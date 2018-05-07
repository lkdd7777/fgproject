/*    */ package com.fgoa.service.impl.officesupply;
/*    */ 
/*    */ import com.fgoa.entity.officesupply.OfficeSupplyEntity;
/*    */ import com.fgoa.service.officesupply.OfficeSupplyServiceI;
/*    */ import java.io.Serializable;
/*    */ import java.util.UUID;
/*    */ import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
/*    */ import org.springframework.stereotype.Service;
/*    */ import org.springframework.transaction.annotation.Transactional;
/*    */ 
/*    */ @Service("officeSupplyService")
/*    */ @Transactional
/*    */ public class OfficeSupplyServiceImpl
/*    */   extends CommonServiceImpl implements OfficeSupplyServiceI
/*    */ {
/*    */   public <T> void delete(T entity)
/*    */   {
/* 18 */     super.delete(entity);
/*    */     
/* 20 */     doDelSql((OfficeSupplyEntity)entity);
/*    */   }
/*    */   
/*    */   public <T> Serializable save(T entity) {
/* 24 */     Serializable t = super.save(entity);
/*    */     
/* 26 */     doAddSql((OfficeSupplyEntity)entity);
/* 27 */     return t;
/*    */   }
/*    */   
/*    */   public <T> void saveOrUpdate(T entity) {
/* 31 */     super.saveOrUpdate(entity);
/*    */     
/* 33 */     doUpdateSql((OfficeSupplyEntity)entity);
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public boolean doAddSql(OfficeSupplyEntity t)
/*    */   {
/* 42 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public boolean doUpdateSql(OfficeSupplyEntity t)
/*    */   {
/* 50 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public boolean doDelSql(OfficeSupplyEntity t)
/*    */   {
/* 58 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public String replaceVal(String sql, OfficeSupplyEntity t)
/*    */   {
/* 67 */     sql = sql.replace("#{id}", String.valueOf(t.getId()));
/* 68 */     sql = sql.replace("#{myorder}", String.valueOf(t.getMyorder()));
/* 69 */     sql = sql.replace("#{guestname}", String.valueOf(t.getGuestname()));
/* 70 */     sql = sql.replace("#{devicetype}", String.valueOf(t.getDevicetype()));
/* 71 */     sql = sql.replace("#{devicename}", String.valueOf(t.getDevicename()));
/* 72 */     sql = sql.replace("#{purchasedate}", String.valueOf(t.getPurchasedate()));
/* 73 */     sql = sql.replace("#{unit}", String.valueOf(t.getUnit()));
/* 74 */     sql = sql.replace("#{number}", String.valueOf(t.getNumber()));
/* 75 */     sql = sql.replace("#{price}", String.valueOf(t.getPrice()));
/* 76 */     sql = sql.replace("#{money}", String.valueOf(t.getMoney()));
/* 77 */     sql = sql.replace("#{depart}", String.valueOf(t.getDepart()));
/* 78 */     sql = sql.replace("#{remark}", String.valueOf(t.getRemark()));
/* 79 */     sql = sql.replace("#{UUID}", UUID.randomUUID().toString());
/* 80 */     return sql;
/*    */   }
/*    */ }


/* Location:              E:\aaa\admin\WEB-INF\classes\!\com\fgoa\service\impl\officesupply\OfficeSupplyServiceImpl.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */