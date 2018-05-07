/*    */ package com.fgoa.service.impl.examconfig;
/*    */ 
/*    */ import com.fgoa.entity.examconfig.ExamConfigEntity;
/*    */ import com.fgoa.service.examconfig.ExamConfigServiceI;
/*    */ import java.io.Serializable;
/*    */ import java.util.UUID;
/*    */ import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
/*    */ import org.springframework.stereotype.Service;
/*    */ import org.springframework.transaction.annotation.Transactional;
/*    */ 
/*    */ @Service("examConfigService")
/*    */ @Transactional
/*    */ public class ExamConfigServiceImpl
/*    */   extends CommonServiceImpl implements ExamConfigServiceI
/*    */ {
/*    */   public <T> void delete(T entity)
/*    */   {
/* 18 */     super.delete(entity);
/*    */     
/* 20 */     doDelSql((ExamConfigEntity)entity);
/*    */   }
/*    */   
/*    */   public <T> Serializable save(T entity) {
/* 24 */     Serializable t = super.save(entity);
/*    */     
/* 26 */     doAddSql((ExamConfigEntity)entity);
/* 27 */     return t;
/*    */   }
/*    */   
/*    */   public <T> void saveOrUpdate(T entity) {
/* 31 */     super.saveOrUpdate(entity);
/*    */     
/* 33 */     doUpdateSql((ExamConfigEntity)entity);
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public boolean doAddSql(ExamConfigEntity t)
/*    */   {
/* 42 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public boolean doUpdateSql(ExamConfigEntity t)
/*    */   {
/* 50 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public boolean doDelSql(ExamConfigEntity t)
/*    */   {
/* 58 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public String replaceVal(String sql, ExamConfigEntity t)
/*    */   {
/* 67 */     sql = sql.replace("#{id}", String.valueOf(t.getId()));
/* 68 */     sql = sql.replace("#{title}", String.valueOf(t.getTitle()));
/* 69 */     sql = sql.replace("#{maxage}", String.valueOf(t.getMaxage()));
/* 70 */     sql = sql.replace("#{minage}", String.valueOf(t.getMinage()));
/* 71 */     sql = sql.replace("#{allowtime}", String.valueOf(t.getAllowtime()));
/* 72 */     sql = sql.replace("#{UUID}", UUID.randomUUID().toString());
/* 73 */     return sql;
/*    */   }
/*    */ }


/* Location:              E:\aaa\admin\WEB-INF\classes\!\com\fgoa\service\impl\examconfig\ExamConfigServiceImpl.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */