/*    */ package com.fgoa.service.impl.car;
/*    */ 
/*    */ import com.fgoa.entity.car.CarEntity;
/*    */ import com.fgoa.service.car.CarServiceI;
/*    */ import java.io.Serializable;
/*    */ import java.util.UUID;
/*    */ import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
/*    */ import org.springframework.stereotype.Service;
/*    */ import org.springframework.transaction.annotation.Transactional;
/*    */ 
/*    */ @Service("carService")
/*    */ @Transactional
/*    */ public class CarServiceImpl
/*    */   extends CommonServiceImpl implements CarServiceI
/*    */ {
/*    */   public <T> void delete(T entity)
/*    */   {
/* 18 */     super.delete(entity);
/*    */     
/* 20 */     doDelSql((CarEntity)entity);
/*    */   }
/*    */   
/*    */   public <T> Serializable save(T entity) {
/* 24 */     Serializable t = super.save(entity);
/*    */     
/* 26 */     doAddSql((CarEntity)entity);
/* 27 */     return t;
/*    */   }
/*    */   
/*    */   public <T> void saveOrUpdate(T entity) {
/* 31 */     super.saveOrUpdate(entity);
/*    */     
/* 33 */     doUpdateSql((CarEntity)entity);
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public boolean doAddSql(CarEntity t)
/*    */   {
/* 42 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public boolean doUpdateSql(CarEntity t)
/*    */   {
/* 50 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public boolean doDelSql(CarEntity t)
/*    */   {
/* 58 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public String replaceVal(String sql, CarEntity t)
/*    */   {
/* 67 */     sql = sql.replace("#{id}", String.valueOf(t.getId()));
/* 68 */     sql = sql.replace("#{carnum}", String.valueOf(t.getCarnum()));
/* 69 */     sql = sql.replace("#{regdate}", String.valueOf(t.getRegdate()));
/* 70 */     sql = sql.replace("#{presurveydate}", String.valueOf(t.getPresurveydate()));
/* 71 */     sql = sql.replace("#{surveydate}", String.valueOf(t.getSurveydate()));
/* 72 */     sql = sql.replace("#{etcdate}", String.valueOf(t.getEtcdate()));
/* 73 */     sql = sql.replace("#{etclimitdate}", String.valueOf(t.getEtclimitdate()));
/* 74 */     sql = sql.replace("#{telnum}", String.valueOf(t.getTelnum()));
/* 75 */     sql = sql.replace("#{status}", String.valueOf(t.getStatus()));
/* 76 */     sql = sql.replace("#{UUID}", UUID.randomUUID().toString());
/* 77 */     return sql;
/*    */   }
/*    */ }


/* Location:              E:\aaa\admin\WEB-INF\classes\!\com\fgoa\service\impl\car\CarServiceImpl.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */