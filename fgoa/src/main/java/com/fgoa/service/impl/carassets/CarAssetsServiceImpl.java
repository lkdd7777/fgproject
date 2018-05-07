/*    */ package com.fgoa.service.impl.carassets;
/*    */ 
/*    */ import com.fgoa.entity.carassets.CarAssetsEntity;
/*    */ import com.fgoa.service.carassets.CarAssetsServiceI;
/*    */ import java.io.Serializable;
/*    */ import java.util.UUID;
/*    */ import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
/*    */ import org.springframework.stereotype.Service;
/*    */ import org.springframework.transaction.annotation.Transactional;
/*    */ 
/*    */ @Service("carAssetsService")
/*    */ @Transactional
/*    */ public class CarAssetsServiceImpl
/*    */   extends CommonServiceImpl implements CarAssetsServiceI
/*    */ {
/*    */   public <T> void delete(T entity)
/*    */   {
/* 18 */     super.delete(entity);
/*    */     
/* 20 */     doDelSql((CarAssetsEntity)entity);
/*    */   }
/*    */   
/*    */   public <T> Serializable save(T entity) {
/* 24 */     Serializable t = super.save(entity);
/*    */     
/* 26 */     doAddSql((CarAssetsEntity)entity);
/* 27 */     return t;
/*    */   }
/*    */   
/*    */   public <T> void saveOrUpdate(T entity) {
/* 31 */     super.saveOrUpdate(entity);
/*    */     
/* 33 */     doUpdateSql((CarAssetsEntity)entity);
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public boolean doAddSql(CarAssetsEntity t)
/*    */   {
/* 42 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public boolean doUpdateSql(CarAssetsEntity t)
/*    */   {
/* 50 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public boolean doDelSql(CarAssetsEntity t)
/*    */   {
/* 58 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public String replaceVal(String sql, CarAssetsEntity t)
/*    */   {
/* 67 */     sql = sql.replace("#{id}", String.valueOf(t.getId()));
/* 68 */     sql = sql.replace("#{sort_num}", String.valueOf(t.getSortNum()));
/* 69 */     sql = sql.replace("#{insurance}", String.valueOf(t.getInsurance()));
/* 70 */     sql = sql.replace("#{bridge_toll}", String.valueOf(t.getBridgeToll()));
/* 71 */     sql = sql.replace("#{card_recharge}", String.valueOf(t.getCardRecharge()));
/* 72 */     sql = sql.replace("#{repairs}", String.valueOf(t.getRepairs()));
/* 73 */     sql = sql.replace("#{parking_fee}", String.valueOf(t.getParkingFee()));
/* 74 */     sql = sql.replace("#{oil_capacity}", String.valueOf(t.getOilCapacity()));
/* 75 */     sql = sql.replace("#{UUID}", UUID.randomUUID().toString());
/* 76 */     return sql;
/*    */   }
/*    */ }


/* Location:              E:\aaa\admin\WEB-INF\classes\!\com\fgoa\service\impl\carassets\CarAssetsServiceImpl.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */