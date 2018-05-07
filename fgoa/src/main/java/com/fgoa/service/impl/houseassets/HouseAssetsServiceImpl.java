/*    */ package com.fgoa.service.impl.houseassets;
/*    */ 
/*    */ import com.fgoa.entity.houseassets.HouseAssetsEntity;
/*    */ import com.fgoa.service.houseassets.HouseAssetsServiceI;
/*    */ import java.io.Serializable;
/*    */ import java.util.UUID;
/*    */ import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
/*    */ import org.springframework.stereotype.Service;
/*    */ import org.springframework.transaction.annotation.Transactional;
/*    */ 
/*    */ @Service("houseAssetsService")
/*    */ @Transactional
/*    */ public class HouseAssetsServiceImpl
/*    */   extends CommonServiceImpl implements HouseAssetsServiceI
/*    */ {
/*    */   public <T> void delete(T entity)
/*    */   {
/* 18 */     super.delete(entity);
/*    */     
/* 20 */     doDelSql((HouseAssetsEntity)entity);
/*    */   }
/*    */   
/*    */   public <T> Serializable save(T entity) {
/* 24 */     Serializable t = super.save(entity);
/*    */     
/* 26 */     doAddSql((HouseAssetsEntity)entity);
/* 27 */     return t;
/*    */   }
/*    */   
/*    */   public <T> void saveOrUpdate(T entity) {
/* 31 */     super.saveOrUpdate(entity);
/*    */     
/* 33 */     doUpdateSql((HouseAssetsEntity)entity);
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public boolean doAddSql(HouseAssetsEntity t)
/*    */   {
/* 42 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public boolean doUpdateSql(HouseAssetsEntity t)
/*    */   {
/* 50 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public boolean doDelSql(HouseAssetsEntity t)
/*    */   {
/* 58 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public String replaceVal(String sql, HouseAssetsEntity t)
/*    */   {
/* 67 */     sql = sql.replace("#{id}", String.valueOf(t.getId()));
/* 68 */     sql = sql.replace("#{sort_num}", String.valueOf(t.getSortNum()));
/* 69 */     sql = sql.replace("#{address}", String.valueOf(t.getAddress()));
/* 70 */     sql = sql.replace("#{building_area}", String.valueOf(t.getBuildingArea()));
/* 71 */     sql = sql.replace("#{land_area}", String.valueOf(t.getLandArea()));
/* 72 */     sql = sql.replace("#{contract_price}", String.valueOf(t.getContractPrice()));
/* 73 */     sql = sql.replace("#{achieve_time}", String.valueOf(t.getAchieveTime()));
/* 74 */     sql = sql.replace("#{certificate_time}", String.valueOf(t.getCertificateTime()));
/* 75 */     sql = sql.replace("#{purpose}", String.valueOf(t.getPurpose()));
/* 76 */     sql = sql.replace("#{ownership}", String.valueOf(t.getOwnership()));
/* 77 */     sql = sql.replace("#{housing_situation}", String.valueOf(t.getHousingSituation()));
/* 78 */     sql = sql.replace("#{rental_type}", String.valueOf(t.getRentalType()));
/* 79 */     sql = sql.replace("#{rental}", String.valueOf(t.getRental()));
/* 80 */     sql = sql.replace("#{lease_time}", String.valueOf(t.getLeaseTime()));
/* 81 */     sql = sql.replace("#{lease}", String.valueOf(t.getLease()));
/* 82 */     sql = sql.replace("#{user}", String.valueOf(t.getUser()));
/* 83 */     sql = sql.replace("#{user_phone}", String.valueOf(t.getUserPhone()));
/* 84 */     sql = sql.replace("#{other}", String.valueOf(t.getOther()));
/* 85 */     sql = sql.replace("#{remark}", String.valueOf(t.getRemark()));
/* 86 */     sql = sql.replace("#{UUID}", UUID.randomUUID().toString());
/* 87 */     return sql;
/*    */   }
/*    */ }


/* Location:              E:\aaa\admin\WEB-INF\classes\!\com\fgoa\service\impl\houseassets\HouseAssetsServiceImpl.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */