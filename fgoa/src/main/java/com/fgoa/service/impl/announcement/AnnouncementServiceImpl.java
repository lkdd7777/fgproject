/*    */ package com.fgoa.service.impl.announcement;
/*    */ 
/*    */ import com.fgoa.entity.announcement.AnnouncementEntity;
/*    */ import com.fgoa.service.announcement.AnnouncementServiceI;
/*    */ import java.io.Serializable;
/*    */ import java.util.UUID;
/*    */ import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
/*    */ import org.springframework.stereotype.Service;
/*    */ import org.springframework.transaction.annotation.Transactional;
/*    */ 
/*    */ 
/*    */ 
/*    */ @Service("announcementService")
/*    */ @Transactional
/*    */ public class AnnouncementServiceImpl
/*    */   extends CommonServiceImpl
/*    */   implements AnnouncementServiceI
/*    */ {
/*    */   public <T> void delete(T entity)
/*    */   {
/* 21 */     super.delete(entity);
/*    */     
/* 23 */     doDelSql((AnnouncementEntity)entity);
/*    */   }
/*    */   
/*    */   public <T> Serializable save(T entity) {
/* 27 */     Serializable t = super.save(entity);
/*    */     
/* 29 */     doAddSql((AnnouncementEntity)entity);
/* 30 */     return t;
/*    */   }
/*    */   
/*    */   public <T> void saveOrUpdate(T entity) {
/* 34 */     super.saveOrUpdate(entity);
/*    */     
/* 36 */     doUpdateSql((AnnouncementEntity)entity);
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public boolean doAddSql(AnnouncementEntity t)
/*    */   {
/* 45 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public boolean doUpdateSql(AnnouncementEntity t)
/*    */   {
/* 53 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public boolean doDelSql(AnnouncementEntity t)
/*    */   {
/* 61 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public String replaceVal(String sql, AnnouncementEntity t)
/*    */   {
/* 70 */     sql = sql.replace("#{id}", String.valueOf(t.getId()));
/* 71 */     sql = sql.replace("#{title}", String.valueOf(t.getTitle()));
/* 72 */     sql = sql.replace("#{validtime}", String.valueOf(t.getValidtime()));
/* 73 */     sql = sql.replace("#{invalidtime}", String.valueOf(t.getInvalidtime()));
/* 74 */     sql = sql.replace("#{content}", String.valueOf(t.getContent()));
/* 75 */     sql = sql.replace("#{UUID}", UUID.randomUUID().toString());
/* 76 */     return sql;
/*    */   }
/*    */ }


/* Location:              E:\aaa\admin\WEB-INF\classes\!\com\fgoa\service\impl\announcement\AnnouncementServiceImpl.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */