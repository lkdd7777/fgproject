package com.fgoa.controller.examquestion;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.jeecgframework.core.common.controller.BaseController;
import org.jeecgframework.core.common.exception.BusinessException;
import org.jeecgframework.core.common.hibernate.qbc.CriteriaQuery;
import org.jeecgframework.core.common.model.json.AjaxJson;
import org.jeecgframework.core.common.model.json.DataGrid;
import org.jeecgframework.core.constant.Globals;
import org.jeecgframework.core.util.MyBeanUtils;
import org.jeecgframework.core.util.StringUtil;
import org.jeecgframework.tag.core.easyui.TagUtil;
import org.jeecgframework.web.system.service.SystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.fgoa.entity.examquestion.ExamAnswerEntity;
import com.fgoa.entity.examquestion.ExamClassEntity;
import com.fgoa.entity.examquestion.ExamQuestionEntity;
import com.fgoa.service.examquestion.ExamClassServiceI;
import com.fgoa.service.examquestion.ExamQuestionServiceI;

/**
 * @Title: Controller
 * @Description: 考试题库
 * @author onlineGenerator
 * @date 2014-10-12 14:39:44
 * @version V1.0
 * 
 */
@Controller
@RequestMapping("/examQuestionController")
public class ExamQuestionController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger
			.getLogger(ExamQuestionController.class);

	@Autowired
	private ExamQuestionServiceI examQuestionService;

	@Autowired
	private ExamClassServiceI examClassService;

	@Autowired
	private SystemService systemService;
	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * 考试题库列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "examQuestion")
	public ModelAndView examQuestion(HttpServletRequest request) {
		return new ModelAndView("com/fgoa/examquestion/examQuestionList");
	}

	/**
	 * easyui AJAX请求数据
	 * 
	 * @param request
	 * @param response
	 * @param dataGrid
	 * @param user
	 */

	@RequestMapping(params = "datagrid")
	public void datagrid(ExamQuestionEntity examQuestion,
			HttpServletRequest request, HttpServletResponse response,
			DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(ExamQuestionEntity.class, dataGrid);
		// 查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq,
				examQuestion, request.getParameterMap());
		try {
			// 自定义追加查询条件
		} catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
		cq.add();
		this.examQuestionService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}

	/**
	 * 删除考试题库
	 * 
	 * @return
	 */
	@RequestMapping(params = "doDel")
	@ResponseBody
	public AjaxJson doDel(ExamQuestionEntity examQuestion,
			HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		examQuestion = systemService.getEntity(ExamQuestionEntity.class,
				examQuestion.getId());
		message = "考试题库删除成功";
		try {
			examQuestionService.delete(examQuestion);
			systemService.addLog(message, Globals.Log_Type_DEL,
					Globals.Log_Leavel_INFO);
		} catch (Exception e) {
			e.printStackTrace();
			message = "考试题库删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * d 批量删除考试题库
	 * 
	 * @return
	 */
	@RequestMapping(params = "doBatchDel")
	@ResponseBody
	public AjaxJson doBatchDel(String ids, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		message = "考试题库删除成功";
		try {
			for (String id : ids.split(",")) {
				ExamQuestionEntity examQuestion = systemService.getEntity(
						ExamQuestionEntity.class, id);
				examQuestionService.delete(examQuestion);
				systemService.addLog(message, Globals.Log_Type_DEL,
						Globals.Log_Leavel_INFO);
			}
		} catch (Exception e) {
			e.printStackTrace();
			message = "考试题库删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 添加考试题库
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doAdd")
	@ResponseBody
	public AjaxJson doAdd(ExamQuestionEntity examQuestion,
			HttpServletRequest request, String[] answerContent,
			boolean isCorrect1, boolean isCorrect2, boolean isCorrect3,
			boolean isCorrect4, boolean isCorrect5, boolean isCorrect6,
			boolean judgeAnswerContent) {
		AjaxJson j = new AjaxJson();
		message = "考试题库添加成功";
		try {
			String type = examQuestion.getType();
			List<ExamAnswerEntity> answerList = new ArrayList<ExamAnswerEntity>();
			if (StringUtils.equalsIgnoreCase("judge", type)) {
				// 判断题逻辑

				ExamAnswerEntity answer = new ExamAnswerEntity();
				answer.setContent("正确");
				answer.setQuestion(examQuestion);
				answerList.add(answer);
				if (judgeAnswerContent) {
					answer.setCorrect(true);
				} else {
					answer.setCorrect(false);
				}
				ExamAnswerEntity answer1 = new ExamAnswerEntity();
				answer1.setContent("错误");
				answer1.setQuestion(examQuestion);
				answerList.add(answer1);
				if (judgeAnswerContent) {
					answer1.setCorrect(false);
				} else {
					answer1.setCorrect(true);
				}
			} else if (StringUtils.equalsIgnoreCase("mutiple", type)
					|| StringUtils.equalsIgnoreCase("single", type)) {
				// 选择题逻辑
				if (ArrayUtils.isNotEmpty(answerContent)) {
					for (int i = 0; i < answerContent.length; i++) {
						ExamAnswerEntity answer = new ExamAnswerEntity();
						boolean correct = false;
						if (i == 0 && isCorrect1) {
							correct = true;
						} else if (i == 1 && isCorrect2) {
							correct = true;
						} else if (i == 2 && isCorrect3) {
							correct = true;
						} else if (i == 3 && isCorrect4) {
							correct = true;
						} else if (i == 4 && isCorrect5) {
							correct = true;
						} else if (i == 5 && isCorrect6) {
							correct = true;
						}
						// 不为空则保存
						if (StringUtils.isNotBlank(answerContent[i])) {
							answer.setCorrect(correct);
							answer.setContent(answerContent[i]);
							answer.setQuestion(examQuestion);
							answerList.add(answer);
						}
					}
				}
			} else {
				throw new BusinessException("无法保存类型为：" + type + "的试题");
			}
			examQuestion.setAnswerList(answerList);
			examQuestionService.save(examQuestion);

			systemService.addLog(message, Globals.Log_Type_INSERT,
					Globals.Log_Leavel_INFO);
		} catch (Exception e) {
			e.printStackTrace();
			message = "考试题库添加失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 更新考试题库
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doUpdate")
	@ResponseBody
	public AjaxJson doUpdate(ExamQuestionEntity examQuestion,
			HttpServletRequest request, String[] answerContent,
			boolean isCorrect1, boolean isCorrect2, boolean isCorrect3,
			boolean isCorrect4, boolean isCorrect5, boolean isCorrect6,
			boolean judgeAnswerContent) {
		AjaxJson j = new AjaxJson();
		message = "考试题库更新成功";
		ExamQuestionEntity t = examQuestionService.get(
				ExamQuestionEntity.class, examQuestion.getId());
		try {
			MyBeanUtils.copyBeanNotNull2Bean(examQuestion, t);
			t.setAnswerList(null);
			examQuestionService.clearAnswer(examQuestion.getId());

			String type = t.getType();
			List<ExamAnswerEntity> answerList = new ArrayList<ExamAnswerEntity>();
			if (StringUtils.equalsIgnoreCase("judge", type)) {
				// 判断题逻辑

				ExamAnswerEntity answer = new ExamAnswerEntity();
				answer.setContent("正确");
				answer.setQuestion(t);
				answerList.add(answer);
				if (judgeAnswerContent) {
					answer.setCorrect(true);
				} else {
					answer.setCorrect(false);
				}
				ExamAnswerEntity answer1 = new ExamAnswerEntity();
				answer1.setContent("错误");
				answer1.setQuestion(t);
				answerList.add(answer1);
				if (judgeAnswerContent) {
					answer1.setCorrect(false);
				} else {
					answer1.setCorrect(true);
				}
			} else if (StringUtils.equalsIgnoreCase("mutiple", type)
					|| StringUtils.equalsIgnoreCase("single", type)) {
				// 选择题逻辑
				if (ArrayUtils.isNotEmpty(answerContent)) {
					for (int i = 0; i < answerContent.length; i++) {
						ExamAnswerEntity answer = new ExamAnswerEntity();
						boolean correct = false;
						if (i == 0 && isCorrect1) {
							correct = true;
						} else if (i == 1 && isCorrect2) {
							correct = true;
						} else if (i == 2 && isCorrect3) {
							correct = true;
						} else if (i == 3 && isCorrect4) {
							correct = true;
						} else if (i == 4 && isCorrect5) {
							correct = true;
						} else if (i == 5 && isCorrect6) {
							correct = true;
						}

						if (StringUtils.isNotBlank(answerContent[i])) {
							answer.setCorrect(correct);
							answer.setContent(answerContent[i]);
							answer.setQuestion(examQuestion);
							answerList.add(answer);
						}
					}
				}
			} else {
				throw new BusinessException("无法保存类型为：" + type + "的试题");
			}

			t.setAnswerList(answerList);
			examQuestionService.saveOrUpdate(t);
			systemService.addLog(message, Globals.Log_Type_UPDATE,
					Globals.Log_Leavel_INFO);
		} catch (Exception e) {
			e.printStackTrace();
			message = "考试题库更新失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 考试题库新增页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goAdd")
	public ModelAndView goAdd(ExamQuestionEntity examQuestion,
			HttpServletRequest req) {
		if (StringUtil.isNotEmpty(examQuestion.getId())) {
			examQuestion = examQuestionService.getEntity(
					ExamQuestionEntity.class, examQuestion.getId());
			req.setAttribute("examQuestionPage", examQuestion);
		}
		req.setAttribute("examClasses",
				examClassService.getList(ExamClassEntity.class));
		return new ModelAndView("com/fgoa/examquestion/examQuestion-add");
	}

	/**
	 * 考试题库编辑页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goUpdate")
	public ModelAndView goUpdate(ExamQuestionEntity examQuestion,
			HttpServletRequest req) {
		if (StringUtil.isNotEmpty(examQuestion.getId())) {
			examQuestion = examQuestionService.getEntity(
					ExamQuestionEntity.class, examQuestion.getId());
			req.setAttribute("examQuestionPage", examQuestion);
		}
		req.setAttribute("examClasses",
				examClassService.getList(ExamClassEntity.class));
		return new ModelAndView("com/fgoa/examquestion/examQuestion-update");
	}
}
