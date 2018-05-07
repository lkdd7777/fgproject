/*    */ package com.fgoa.service.impl.carfee;
/*    */ 
/*    */ import com.fgoa.entity.carfee.CarFeeEntity;
/*    */ import com.fgoa.service.carfee.CarFeeServiceI;
/*    */ import java.io.Serializable;
/*    */ import java.util.UUID;
/*    */ import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
/*    */ import org.springframework.stereotype.Service;
/*    */ import org.springframework.transaction.annotation.Transactional;
/*    */ 
/*    */ @Service("carFeeService")
/*    */ @Transactional
/*    */ public class CarFeeServiceImpl
/*    */   extends CommonServiceImpl implements CarFeeServiceI
/*    */ {
/*    */   public <T> void delete(T entity)
/*    */   {
/* 18 */     super.delete(entity);
/*    */     
/* 20 */     doDelSql((CarFeeEntity)entity);
/*    */   }
/*    */   
/*    */   public <T> Serializable save(T entity) {
/* 24 */     Serializable t = super.save(entity);
/*    */     
/* 26 */     doAddSql((CarFeeEntity)entity);
/* 27 */     return t;
/*    */   }
/*    */   
/*    */   public <T> void saveOrUpdate(T entity) {
/* 31 */     super.saveOrUpdate(entity);
/*    */     
/* 33 */     doUpdateSql((CarFeeEntity)entity);
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public boolean doAddSql(CarFeeEntity t)
/*    */   {
/* 42 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public boolean doUpdateSql(CarFeeEntity t)
/*    */   {
/* 50 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public boolean doDelSql(CarFeeEntity t)
/*    */   {
/* 58 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public String replaceVal(String sql, CarFeeEntity t)
/*    */   {
/* 67 */     sql = sql.replace("#{id}", String.valueOf(t.getId()));
/* 68 */     sql = sql.replace("#{recorddate}", String.valueOf(t.getRecorddate()));
/* 69 */     sql = sql.replace("#{feetype}", String.valueOf(t.getFeetype()));
/* 70 */     sql = sql.replace("#{amount}", String.valueOf(t.getAmount()));
/* 71 */     sql = sql.replace("#{remark}", String.valueOf(t.getRemark()));
/* 72 */     sql = sql.replace("#{UUID}", UUID.randomUUID().toString());
/* 73 */     return sql;
/*    */   }
/*    */ }


/* Location:              E:\aaa\admin\WEB-INF\classes\!\com\fgoa\service\impl\carfee\CarFeeServiceImpl.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */