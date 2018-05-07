/*    */ package com.fgoa.service.impl.devicemanage;
/*    */ 
/*    */ import com.fgoa.entity.devicemanage.DeviceManageEntity;
/*    */ import com.fgoa.service.devicemanage.DeviceManageServiceI;
/*    */ import java.io.Serializable;
/*    */ import java.util.UUID;
/*    */ import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
/*    */ import org.springframework.stereotype.Service;
/*    */ import org.springframework.transaction.annotation.Transactional;
/*    */ 
/*    */ @Service("deviceManageService")
/*    */ @Transactional
/*    */ public class DeviceManageServiceImpl
/*    */   extends CommonServiceImpl implements DeviceManageServiceI
/*    */ {
/*    */   public <T> void delete(T entity)
/*    */   {
/* 18 */     super.delete(entity);
/*    */     
/* 20 */     doDelSql((DeviceManageEntity)entity);
/*    */   }
/*    */   
/*    */   public <T> Serializable save(T entity) {
/* 24 */     Serializable t = super.save(entity);
/*    */     
/* 26 */     doAddSql((DeviceManageEntity)entity);
/* 27 */     return t;
/*    */   }
/*    */   
/*    */   public <T> void saveOrUpdate(T entity) {
/* 31 */     super.saveOrUpdate(entity);
/*    */     
/* 33 */     doUpdateSql((DeviceManageEntity)entity);
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public boolean doAddSql(DeviceManageEntity t)
/*    */   {
/* 42 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public boolean doUpdateSql(DeviceManageEntity t)
/*    */   {
/* 50 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public boolean doDelSql(DeviceManageEntity t)
/*    */   {
/* 58 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public String replaceVal(String sql, DeviceManageEntity t)
/*    */   {
/* 67 */     sql = sql.replace("#{id}", String.valueOf(t.getId()));
/* 68 */     sql = sql.replace("#{myorder}", String.valueOf(t.getMyorder()));
/* 69 */     sql = sql.replace("#{depart}", String.valueOf(t.getDepart()));
/* 70 */     sql = sql.replace("#{model}", String.valueOf(t.getModel()));
/* 71 */     sql = sql.replace("#{type}", String.valueOf(t.getType()));
/* 72 */     sql = sql.replace("#{devicetype}", String.valueOf(t.getDevicetype()));
/* 73 */     sql = sql.replace("#{purchasedate}", String.valueOf(t.getPurchasedate()));
/* 74 */     sql = sql.replace("#{baseconfig}", String.valueOf(t.getBaseconfig()));
/* 75 */     sql = sql.replace("#{status}", String.valueOf(t.getStatus()));
/* 76 */     sql = sql.replace("#{user}", String.valueOf(t.getUser()));
/* 77 */     sql = sql.replace("#{remark}", String.valueOf(t.getRemark()));
/* 78 */     sql = sql.replace("#{UUID}", UUID.randomUUID().toString());
/* 79 */     return sql;
/*    */   }
/*    */ }


/* Location:              E:\aaa\admin\WEB-INF\classes\!\com\fgoa\service\impl\devicemanage\DeviceManageServiceImpl.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */