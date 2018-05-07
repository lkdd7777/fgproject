package com.fgoa.web.controller;

import java.io.FileOutputStream;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

import com.fgoa.web.model.ExamAnswer;
import com.fgoa.web.model.ExamClass;
import com.fgoa.web.model.ExamPaper;
import com.fgoa.web.service.ExamService;
import com.jfinal.aop.Before;
import com.jfinal.core.Controller;
import com.jfinal.ext.interceptor.POST;
import com.jfinal.plugin.activerecord.Record;

public class ExamController extends Controller {

	public void index() {
		redirect("/exam/description");
	}

	public void start() {
		setAttr("examClassList",
				ExamClass.dao.find("select * from t_oa_exam_class"));
		render("exam_start.ftl");
	}

	public void description() {
		setAttr("title", "考试简介");
		setAttr("redirecUrl", "exam/rule");
		setAttr("info", ExamService.instance.getConfigInfo("content"));
		render("exam_info.ftl");
	}

	public void rule() {
		setAttr("title", "考试规则");
		setAttr("redirecUrl", "exam/start");
		setAttr("info", ExamService.instance.getConfigInfo("rule"));
		render("exam_info.ftl");
	}

	@Before(POST.class)
	public void generatePaper() {
		Long examClassId = getParaToLong("examClassId");

		ExamPaper existPaper = ExamService.instance
				.getExamPaperByClassId(examClassId);
		if (existPaper != null) {
			if (StringUtils.equalsIgnoreCase("y",
					existPaper.getStr("iscomplete"))) {
				setAttr("message", "您已经参加过该科目的考试，无需重复参加。");
				render("exam_error.ftl");
				return;
			} else {
				setSessionAttr("current_paper_id", existPaper.getLong("id"));
				setSessionAttr("current_question_num",
						existPaper.getInt("pauseNum"));
				redirect("/exam/question");
			}
		} else {
			ExamPaper paper = ExamService.instance.generatePaper(examClassId);
			if (paper != null) {
				setSessionAttr("current_paper_id", paper.getLong("id"));
				setSessionAttr("current_question_num", 1);
				redirect("/exam/question");
			} else {
				renderError(404);
			}
		}
	}

	public void submitAnswer() {
		Long paperId = getSessionAttr("current_paper_id");
		if (paperId == null) {
			renderError(404);
			return;
		} else {
			String[] answerIds = getParaValues("answerIds");
			Long paperQid = getParaToLong("paperQid");
			String questionId = getPara("questionId");
			if (ArrayUtils.isNotEmpty(answerIds)) {
				ExamService.instance.updatePaperQuestion(questionId, paperQid,
						answerIds, paperId);
			}

			Integer currentQuestionNum = getSessionAttr("current_question_num");
			setSessionAttr("current_question_num", currentQuestionNum + 1);
			redirect("/exam/question");
		}
	}

	public void question() {
		Long paperId = getSessionAttr("current_paper_id");
		Integer currentQuestionNum = getSessionAttr("current_question_num");
		if (paperId == null) {
			renderError(404);
			return;
		} else {
			ExamPaper paper = ExamPaper.dao.findById(paperId);
			if (ExamService.instance.isPapeExist(paperId)) {
				if (StringUtils.equalsIgnoreCase("y",
						paper.getStr("iscomplete"))) {
					setAttr("message", "该科目考试已经完成！");
					render("exam_error.ftl");
					return;
				} else {

					Record q = ExamService.instance.getQuetion(paperId,
							currentQuestionNum);
					String answerIsStr = q.getStr("answerIds");
					if (StringUtils.isNotBlank(answerIsStr)) {
						setAttr("answerIds", answerIsStr.split(","));
					} else {
						setAttr("answerIds", new String[] {});
					}
					List<ExamAnswer> answerList = ExamService.instance
							.getAnswerList(q.getStr("id"));
					setAttr("question", q);
					setAttr("answerList", answerList);
					setAttr("num", currentQuestionNum);
					setAttr("character", new String[] { "A", "B", "C", "D",
							"E", "F" });
					setAttr("leftSecond", ExamService.instance.getExamLeftSecond(paper));
					render("exam_question.ftl");
					return;
				}
			} else {
				// 试卷不存在
				renderError(404);
				return;
			}
		}
	}

	public void backToPre() {
		Integer currentQuestionNum = getSessionAttr("current_question_num");
		if (currentQuestionNum > 1) {
			setSessionAttr("current_question_num", currentQuestionNum - 1);
		}

		redirect("/exam/question");
	}

	public void submitPaper() {
		Long paperId = getSessionAttr("current_paper_id");

		ExamPaper.dao.findById(paperId).set("iscomplete", "Y")
				.set("endtime", new Date()).update();

		render("exam_result.ftl");
		return;

	}
	
	public void exportWord() throws Exception{
		
		Long examClassId = getParaToLong("examClassId");
		
		ExamPaper paper = ExamService.instance.generatePaper(examClassId);
		Long paperId = paper.getLong("id");
		
		XWPFDocument doc = new XWPFDocument();
        XWPFParagraph p1 = doc.createParagraph();
        p1.setAlignment(ParagraphAlignment.LEFT);
        XWPFRun r1 = p1.createRun();
        
		for(int i = 1; i < 101; i++){
			Record q = ExamService.instance.getQuetion(paperId,i);
			String answerIsStr = q.getStr("answerIds");
			if (StringUtils.isNotBlank(answerIsStr)) {
				setAttr("answerIds", answerIsStr.split(","));
			} else {
				setAttr("answerIds", new String[] {});
			}
			List<ExamAnswer> answerList = ExamService.instance
					.getAnswerList(q.getStr("id"));
			r1.setFontFamily("黑体");
			r1.setText(i+"、"+q.getStr("title"));
			r1.setFontFamily("宋体");
			r1.addCarriageReturn();
			for(ExamAnswer answer : answerList){
				r1.setText(answer.getStr("content"));
				r1.addCarriageReturn();
			}
			r1.addCarriageReturn();
		}
		FileOutputStream out = new FileOutputStream("G://exam.docx");
        doc.write(out);
        out.close();
		redirect("/exam/description");
	}
}
