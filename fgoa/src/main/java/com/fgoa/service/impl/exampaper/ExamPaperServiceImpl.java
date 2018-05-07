/*    */ package com.fgoa.service.impl.exampaper;
/*    */ 
/*    */ import com.fgoa.entity.exampaper.ExamPaperEntity;
/*    */ import com.fgoa.service.exampaper.ExamPaperServiceI;
/*    */ import java.io.Serializable;
/*    */ import java.util.UUID;
/*    */ import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
/*    */ import org.springframework.stereotype.Service;
/*    */ import org.springframework.transaction.annotation.Transactional;
/*    */ 
/*    */ @Service("examPaperService")
/*    */ @Transactional
/*    */ public class ExamPaperServiceImpl
/*    */   extends CommonServiceImpl implements ExamPaperServiceI
/*    */ {
/*    */   public <T> void delete(T entity)
/*    */   {
/* 18 */     super.delete(entity);
/*    */     
/* 20 */     doDelSql((ExamPaperEntity)entity);
/*    */   }
/*    */   
/*    */   public <T> Serializable save(T entity) {
/* 24 */     Serializable t = super.save(entity);
/*    */     
/* 26 */     doAddSql((ExamPaperEntity)entity);
/* 27 */     return t;
/*    */   }
/*    */   
/*    */   public <T> void saveOrUpdate(T entity) {
/* 31 */     super.saveOrUpdate(entity);
/*    */     
/* 33 */     doUpdateSql((ExamPaperEntity)entity);
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public boolean doAddSql(ExamPaperEntity t)
/*    */   {
/* 42 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public boolean doUpdateSql(ExamPaperEntity t)
/*    */   {
/* 50 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public boolean doDelSql(ExamPaperEntity t)
/*    */   {
/* 58 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public String replaceVal(String sql, ExamPaperEntity t)
/*    */   {
/* 67 */     sql = sql.replace("#{id}", String.valueOf(t.getId()));
/* 68 */     sql = sql.replace("#{starttime}", String.valueOf(t.getStarttime()));
/* 69 */     sql = sql.replace("#{endtime}", String.valueOf(t.getEndtime()));
/* 70 */     sql = sql.replace("#{score}", String.valueOf(t.getScore()));
/* 71 */     sql = sql.replace("#{pausetime}", String.valueOf(t.getPausetime()));
/* 72 */     sql = sql.replace("#{iscomplete}", String.valueOf(t.getIscomplete()));
/* 73 */     sql = sql.replace("#{UUID}", UUID.randomUUID().toString());
/* 74 */     return sql;
/*    */   }
/*    */ }


/* Location:              E:\aaa\admin\WEB-INF\classes\!\com\fgoa\service\impl\exampaper\ExamPaperServiceImpl.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */