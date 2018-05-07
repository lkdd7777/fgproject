/*    */ package com.fgoa.service.impl.house;
/*    */ 
/*    */ import com.fgoa.entity.house.HouseEntity;
/*    */ import com.fgoa.service.house.HouseServiceI;
/*    */ import java.io.Serializable;
/*    */ import java.util.UUID;
/*    */ import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
/*    */ import org.springframework.stereotype.Service;
/*    */ import org.springframework.transaction.annotation.Transactional;
/*    */ 
/*    */ @Service("houseService")
/*    */ @Transactional
/*    */ public class HouseServiceImpl
/*    */   extends CommonServiceImpl implements HouseServiceI
/*    */ {
/*    */   public <T> void delete(T entity)
/*    */   {
/* 18 */     super.delete(entity);
/*    */     
/* 20 */     doDelSql((HouseEntity)entity);
/*    */   }
/*    */   
/*    */   public <T> Serializable save(T entity) {
/* 24 */     Serializable t = super.save(entity);
/*    */     
/* 26 */     doAddSql((HouseEntity)entity);
/* 27 */     return t;
/*    */   }
/*    */   
/*    */   public <T> void saveOrUpdate(T entity) {
/* 31 */     super.saveOrUpdate(entity);
/*    */     
/* 33 */     doUpdateSql((HouseEntity)entity);
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public boolean doAddSql(HouseEntity t)
/*    */   {
/* 42 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public boolean doUpdateSql(HouseEntity t)
/*    */   {
/* 50 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public boolean doDelSql(HouseEntity t)
/*    */   {
/* 58 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public String replaceVal(String sql, HouseEntity t)
/*    */   {
/* 67 */     sql = sql.replace("#{id}", String.valueOf(t.getId()));
/* 68 */     sql = sql.replace("#{housename}", String.valueOf(t.getHousename()));
/* 69 */     sql = sql.replace("#{location}", String.valueOf(t.getLocation()));
/* 70 */     sql = sql.replace("#{contactdate}", String.valueOf(t.getContactdate()));
/* 71 */     sql = sql.replace("#{regdate}", String.valueOf(t.getRegdate()));
/* 72 */     sql = sql.replace("#{status}", String.valueOf(t.getStatus()));
/* 73 */     sql = sql.replace("#{prerentdate}", String.valueOf(t.getPrerentdate()));
/* 74 */     sql = sql.replace("#{rentlength}", String.valueOf(t.getRentlength()));
/* 75 */     sql = sql.replace("#{rentlimitdate}", String.valueOf(t.getRentlimitdate()));
/* 76 */     sql = sql.replace("#{price}", String.valueOf(t.getPrice()));
/* 77 */     sql = sql.replace("#{paytype}", String.valueOf(t.getPaytype()));
/* 78 */     sql = sql.replace("#{telnum}", String.valueOf(t.getTelnum()));
/* 79 */     sql = sql.replace("#{UUID}", UUID.randomUUID().toString());
/* 80 */     return sql;
/*    */   }
/*    */ }


/* Location:              E:\aaa\admin\WEB-INF\classes\!\com\fgoa\service\impl\house\HouseServiceImpl.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */