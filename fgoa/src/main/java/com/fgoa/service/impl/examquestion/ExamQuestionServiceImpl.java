/*    */ package com.fgoa.service.impl.examquestion;
/*    */ 
/*    */ import com.fgoa.entity.examquestion.ExamQuestionEntity;
/*    */ import com.fgoa.service.examquestion.ExamQuestionServiceI;
/*    */ import java.io.Serializable;
/*    */ import java.util.UUID;
/*    */ import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
/*    */ import org.springframework.stereotype.Service;
/*    */ import org.springframework.transaction.annotation.Transactional;
/*    */ 
/*    */ 
/*    */ 
/*    */ @Service("examQuestionService")
/*    */ @Transactional
/*    */ public class ExamQuestionServiceImpl
/*    */   extends CommonServiceImpl
/*    */   implements ExamQuestionServiceI
/*    */ {
/*    */   public <T> void delete(T entity)
/*    */   {
/* 21 */     super.delete(entity);
/*    */     
/* 23 */     doDelSql((ExamQuestionEntity)entity);
/*    */   }
/*    */   
/*    */   public <T> Serializable save(T entity) {
/* 27 */     Serializable t = super.save(entity);
/*    */     
/* 29 */     doAddSql((ExamQuestionEntity)entity);
/* 30 */     return t;
/*    */   }
/*    */   
/*    */   public <T> void saveOrUpdate(T entity) {
/* 34 */     super.saveOrUpdate(entity);
/*    */     
/* 36 */     doUpdateSql((ExamQuestionEntity)entity);
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public boolean doAddSql(ExamQuestionEntity t)
/*    */   {
/* 45 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public boolean doUpdateSql(ExamQuestionEntity t)
/*    */   {
/* 53 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public boolean doDelSql(ExamQuestionEntity t)
/*    */   {
/* 61 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public String replaceVal(String sql, ExamQuestionEntity t)
/*    */   {
/* 70 */     sql = sql.replace("#{id}", String.valueOf(t.getId()));
/* 71 */     sql = sql.replace("#{type}", String.valueOf(t.getType()));
/* 72 */     sql = sql.replace("#{title}", String.valueOf(t.getTitle()));
/* 73 */     sql = sql.replace("#{UUID}", UUID.randomUUID().toString());
/* 74 */     return sql;
/*    */   }
/*    */   
/*    */   public void clearAnswer(String qId)
/*    */   {
/* 79 */     String sql = "delete from t_oa_exam_question_answer where question_id=?";
/* 80 */     executeSql(sql, new Object[] { qId });
/*    */   }
/*    */ }


/* Location:              E:\aaa\admin\WEB-INF\classes\!\com\fgoa\service\impl\examquestion\ExamQuestionServiceImpl.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */