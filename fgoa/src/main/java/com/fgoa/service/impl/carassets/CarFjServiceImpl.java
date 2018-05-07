/*    */ package com.fgoa.service.impl.carassets;
/*    */ 
/*    */ import com.fgoa.entity.carassets.CarFjEntity;
/*    */ import com.fgoa.service.carassets.CarFjServiceI;
/*    */ import java.io.Serializable;
/*    */ import java.util.UUID;
/*    */ import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
/*    */ import org.springframework.stereotype.Service;
/*    */ import org.springframework.transaction.annotation.Transactional;
/*    */ 
/*    */ @Service("carFjService")
/*    */ @Transactional
/*    */ public class CarFjServiceImpl
/*    */   extends CommonServiceImpl implements CarFjServiceI
/*    */ {
/*    */   public <T> void delete(T entity)
/*    */   {
/* 18 */     super.delete(entity);
/*    */     
/* 20 */     doDelSql((CarFjEntity)entity);
/*    */   }
/*    */   
/*    */   public <T> Serializable save(T entity) {
/* 24 */     Serializable t = super.save(entity);
/*    */     
/* 26 */     doAddSql((CarFjEntity)entity);
/* 27 */     return t;
/*    */   }
/*    */   
/*    */   public <T> void saveOrUpdate(T entity) {
/* 31 */     super.saveOrUpdate(entity);
/*    */     
/* 33 */     doUpdateSql((CarFjEntity)entity);
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public boolean doAddSql(CarFjEntity t)
/*    */   {
/* 42 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public boolean doUpdateSql(CarFjEntity t)
/*    */   {
/* 50 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public boolean doDelSql(CarFjEntity t)
/*    */   {
/* 58 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public String replaceVal(String sql, CarFjEntity t)
/*    */   {
/* 67 */     sql = sql.replace("#{id}", String.valueOf(t.getId()));
/* 68 */     sql = sql.replace("#{cid}", String.valueOf(t.getCid()));
/* 69 */     sql = sql.replace("#{wjms}", String.valueOf(t.getWjms()));
/* 70 */     sql = sql.replace("#{wjlj}", String.valueOf(t.getWjlj()));
/* 71 */     sql = sql.replace("#{UUID}", UUID.randomUUID().toString());
/* 72 */     return sql;
/*    */   }
/*    */ }


/* Location:              E:\aaa\admin\WEB-INF\classes\!\com\fgoa\service\impl\carassets\CarFjServiceImpl.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */