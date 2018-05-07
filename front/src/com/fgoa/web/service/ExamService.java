/*     */ package com.fgoa.web.service;
/*     */ 
/*     */ import com.fgoa.web.model.ExamAnswer;
/*     */ import com.fgoa.web.model.ExamPaper;
/*     */ import com.fgoa.web.model.ExamPaperQuestion;
/*     */ import com.fgoa.web.model.ExamQuestion;
/*     */ import com.fgoa.web.security.ShiroUtils;
/*     */ import com.jfinal.aop.Before;
/*     */ import com.jfinal.plugin.activerecord.Db;
/*     */ import com.jfinal.plugin.activerecord.Record;
/*     */ import com.jfinal.plugin.activerecord.tx.Tx;
/*     */ import com.woo.jfinal.utils.UUIDUtils;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.Date;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import org.apache.commons.collections.CollectionUtils;
/*     */ import org.apache.commons.lang.ArrayUtils;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ExamService
/*     */ {
/*  25 */   public static final ExamService instance = new ExamService();
/*     */   
/*     */   public Record getConfigInfo(String type) {
/*  28 */     return Db.findFirst("select * from t_oa_exam_info where type=?", new Object[] { type });
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   @Before({Tx.class})
/*     */   public ExamPaper generatePaper(Long examClassId)
/*     */   {
/*  40 */     ExamPaper paper = 
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*  45 */       (ExamPaper)((ExamPaper)((ExamPaper)((ExamPaper)((ExamPaper)((ExamPaper)((ExamPaper)((ExamPaper)new ExamPaper().set("starttime", new Date())).set("score", Integer.valueOf(0))).set("pausetime", new Date())).set("iscomplete", "N")).set("user_id", ShiroUtils.getCurrentUserId())).set("examClass_id", examClassId)).set("pauseNum", Integer.valueOf(1))).set("timeAllow", Integer.valueOf(getUserExamTimeAllow()));
/*  46 */     paper.save();
/*  47 */     Long paperId = paper.getLong("id");
/*     */     
/*  49 */     List<ExamQuestion> questionList = ExamQuestion.dao
/*  50 */       .find("select * from t_oa_exam_question order by rand() limit 100");
/*  51 */     int i = 1;
/*  52 */     for (ExamQuestion q : questionList)
/*     */     {
/*     */ 
/*  55 */       ((ExamPaperQuestion)((ExamPaperQuestion)((ExamPaperQuestion)((ExamPaperQuestion)new ExamPaperQuestion().set("paper_id", paperId)).set("question_id", q.getStr("id"))).set("orderNum", Integer.valueOf(i++))).set("isCompleted", Integer.valueOf(1))).save();
/*     */     }
/*     */     
/*  58 */     return paper;
/*     */   }
/*     */   
/*     */   public boolean isCurrentExamClassExist(Long examClassId)
/*     */   {
/*  63 */     String sql = "select * from t_oa_exam_paper where user_id=? and examClass_id=? and iscomplete=?";
/*     */     
/*  65 */     if (CollectionUtils.isNotEmpty(ExamPaper.dao.find(sql, new Object[] {ShiroUtils.getCurrentUserId(), examClassId, "Y" }))) {
/*  66 */       return true;
/*     */     }
/*  68 */     return false;
/*     */   }
/*     */   
/*     */   public ExamPaper getExamPaperByClassId(Long examClassId)
/*     */   {
/*  73 */     String sql = "select * from t_oa_exam_paper where user_id=? and examClass_id=?";
/*     */     
/*  75 */     return (ExamPaper)ExamPaper.dao.findFirst(sql, new Object[] { ShiroUtils.getCurrentUserId(), 
/*  76 */       examClassId });
/*     */   }
/*     */   
/*     */   public boolean isPapeExist(Long paperId) {
/*  80 */     if (ExamPaper.dao.findById(paperId) != null) {
/*  81 */       return true;
/*     */     }
/*  83 */     return false;
/*     */   }
/*     */   
/*     */ 
/*     */   public boolean isComplete(Long paperId)
/*     */   {
/*  89 */     String sql = "select * from t_oa_exam_paper_question t where t.paper_id=? and t.isCompleted=?";
/*     */     
/*  91 */     if (CollectionUtils.isEmpty(ExamPaperQuestion.dao.find(sql, new Object[] { paperId, Integer.valueOf(1) }))) {
/*  92 */       return true;
/*     */     }
/*  94 */     return false;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Record getQuetion(Long paperId, Integer currentQuestionNum)
/*     */   {
/* 101 */     Db.update("update t_oa_exam_paper set pauseNum=? where id= ?", new Object[] {
/* 102 */       currentQuestionNum, paperId });
/* 103 */     String sql = "select t.*,q.id as paperQid,q.answer_id as answerIds from t_oa_exam_question t, t_oa_exam_paper_question q where t.id=q.question_id and q.paper_id=? and q.orderNum=?";
/* 104 */     return Db.findFirst(sql, new Object[] { paperId, currentQuestionNum });
/*     */   }
/*     */   
/*     */   public List<ExamAnswer> getAnswerList(String quesionId)
/*     */   {
/* 109 */     String sql = "select * from t_oa_exam_question_answer where question_id=?";
/* 110 */     return ExamAnswer.dao.find(sql, new Object[] { quesionId });
/*     */   }
/*     */   
/*     */   public void updatePaperQuestion(String questionId, Long paperQid, String[] answerIds, Long paperId)
/*     */   {
/* 115 */     List<ExamAnswer> answerList = ExamAnswer.dao.find(
/* 116 */       "select * from t_oa_exam_question_answer where question_id =?", new Object[] {
/* 117 */       questionId });
/* 118 */     boolean isCorrect = false;
/* 119 */     List<String> correctAnswerIds = new ArrayList();
/* 120 */     for (ExamAnswer answer : answerList) {
/* 121 */       if (answer.getInt("isCorrect").intValue() == 0) {
/* 122 */         correctAnswerIds.add(answer.get("id").toString());
/*     */       }
/*     */     }
/* 125 */     if (correctAnswerIds.size() > 0) {
/* 126 */       List<String> answerIdList = Arrays.asList(answerIds);
/* 127 */       if (correctAnswerIds.containsAll(answerIdList)) {
/* 128 */         correctAnswerIds.removeAll(answerIdList);
/* 129 */         if (correctAnswerIds.size() == 0) {
/* 130 */           isCorrect = true;
/*     */         }
/*     */       }
/*     */     }
/*     */     
/* 135 */     int correctTag = 1;
/* 136 */     if (isCorrect) {
/* 137 */       correctTag = 0;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/* 142 */     ((ExamPaperQuestion)((ExamPaperQuestion)((ExamPaperQuestion)((ExamPaperQuestion)ExamPaperQuestion.dao.findById(paperQid)).set("answer_id", getStrFromArr(answerIds))).set("isCompleted", Integer.valueOf(0))).set("isCorrected", Integer.valueOf(correctTag))).update();
/*     */     
/* 144 */     ExamPaper paper = (ExamPaper)ExamPaper.dao.findById(paperId);
/* 145 */     Integer score = (Integer)paper.get("score");
/* 146 */     if (score == null) {
/* 147 */       score = Integer.valueOf(0);
/*     */     }
/* 149 */     if (isCorrect) {
/* 150 */       score = Integer.valueOf(score.intValue() + 1); Integer 
/* 151 */         tmp270_268 = score;score = Integer.valueOf(tmp270_268.intValue() + 1);((ExamPaper)((ExamPaper)paper.set("score", tmp270_268)).set("pausetime", new Date())).update();
/*     */     }
/*     */   }
/*     */   
/*     */   public int getUserExamTimeAllow()
/*     */   {
/* 157 */     List<Record> list = Db.find("select * from t_oa_exam_config");
/* 158 */     Record localRecord; for (Iterator localIterator = list.iterator(); localIterator.hasNext(); localRecord = (Record)localIterator.next()) {}
/*     */     
/*     */ 
/*     */ 
/* 162 */     return 90;
/*     */   }
/*     */   
/*     */   public void generateQ()
/*     */   {
/* 167 */     for (int i = 0; i < 100; i++) {
/* 168 */       ExamQuestion e = 
/*     */       
/*     */ 
/* 171 */         (ExamQuestion)((ExamQuestion)((ExamQuestion)((ExamQuestion)new ExamQuestion().set("id", UUIDUtils.getRandomUUID())).set("title", "这是单选题" + i)).set("type", "single")).set("examClass_id", Integer.valueOf(4));
/* 172 */       e.save();
/* 173 */       String qid = (String)e.get("id");
/* 174 */       for (int j = 0; j < 4; j++) {
/* 175 */         ExamAnswer a = (ExamAnswer)((ExamAnswer)new ExamAnswer().set("content", "单选答案" + j)).set(
/* 176 */           "question_id", qid);
/* 177 */         if (j == 0) {
/* 178 */           ((ExamAnswer)a.set("isCorrect", Integer.valueOf(1))).save();
/*     */         } else {
/* 180 */           ((ExamAnswer)a.set("isCorrect", Integer.valueOf(0))).save();
/*     */         }
/*     */       }
/*     */     }
/*     */     
/* 185 */     for (int i = 0; i < 100; i++) {
/* 186 */       ExamQuestion e = 
/*     */       
/*     */ 
/* 189 */         (ExamQuestion)((ExamQuestion)((ExamQuestion)((ExamQuestion)new ExamQuestion().set("id", UUIDUtils.getRandomUUID())).set("title", "这是多选题" + i)).set("type", "mutiple")).set("examClass_id", Integer.valueOf(4));
/* 190 */       e.save();
/* 191 */       String qid = (String)e.get("id");
/* 192 */       for (int j = 0; j < 4; j++) {
/* 193 */         int rd = Math.random() > 0.5D ? 1 : 0;
/* 194 */         if (j == 0) {
/* 195 */           rd = 1;
/*     */         }
/*     */         
/* 198 */         ((ExamAnswer)((ExamAnswer)((ExamAnswer)new ExamAnswer().set("content", "多选题答案" + j)).set("question_id", qid)).set("isCorrect", Integer.valueOf(rd))).save();
/*     */       }
/*     */     }
/* 201 */     for (int i = 0; i < 100; i++) {
/* 202 */       ExamQuestion e = 
/*     */       
/*     */ 
/* 205 */         (ExamQuestion)((ExamQuestion)((ExamQuestion)((ExamQuestion)new ExamQuestion().set("id", UUIDUtils.getRandomUUID())).set("title", "这是判断题" + i)).set("type", "judge")).set("examClass_id", Integer.valueOf(4));
/* 206 */       e.save();
/* 207 */       String qid = (String)e.get("id");
/*     */       
/* 209 */       ExamAnswer a = (ExamAnswer)((ExamAnswer)new ExamAnswer().set("content", "正确")).set(
/* 210 */         "question_id", qid);
/* 211 */       ExamAnswer b = (ExamAnswer)((ExamAnswer)new ExamAnswer().set("content", "错误")).set(
/* 212 */         "question_id", qid);
/*     */       
/* 214 */       if (i % 2 == 0) {
/* 215 */         ((ExamAnswer)a.set("isCorrect", Integer.valueOf(1))).save();
/* 216 */         ((ExamAnswer)b.set("isCorrect", Integer.valueOf(0))).save();
/*     */       } else {
/* 218 */         ((ExamAnswer)a.set("isCorrect", Integer.valueOf(0))).save();
/* 219 */         ((ExamAnswer)b.set("isCorrect", Integer.valueOf(1))).save();
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public long getExamLeftSecond(ExamPaper paper)
/*     */   {
/* 226 */     int timeAllow = paper.getInt("timeAllow").intValue();
/* 227 */     Date StartTime = (Date)paper.get("starttime");
/* 228 */     Date now = new Date();
/* 229 */     return (StartTime.getTime() + timeAllow * 60 * 1000 - now.getTime()) / 1000L;
/*     */   }
/*     */   
/*     */   public String getStrFromArr(String[] arr)
/*     */   {
/* 234 */     return ArrayUtils.toString(arr).replace("{", "").replace("}", "");
/*     */   }
/*     */ }


/* Location:              E:\aaa\front\WEB-INF\classes\!\com\fgoa\web\service\ExamService.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */