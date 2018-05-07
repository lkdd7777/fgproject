/*    */ package com.fgoa.service.impl.schedule;
/*    */ 
/*    */ import com.fgoa.entity.schedule.ScheduleEntity;
/*    */ import com.fgoa.service.schedule.ScheduleServiceI;
/*    */ import java.io.Serializable;
/*    */ import java.util.UUID;
/*    */ import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
/*    */ import org.springframework.stereotype.Service;
/*    */ import org.springframework.transaction.annotation.Transactional;
/*    */ 
/*    */ @Service("scheduleService")
/*    */ @Transactional
/*    */ public class ScheduleServiceImpl
/*    */   extends CommonServiceImpl implements ScheduleServiceI
/*    */ {
/*    */   public <T> void delete(T entity)
/*    */   {
/* 18 */     super.delete(entity);
/*    */     
/* 20 */     doDelSql((ScheduleEntity)entity);
/*    */   }
/*    */   
/*    */   public <T> Serializable save(T entity) {
/* 24 */     Serializable t = super.save(entity);
/*    */     
/* 26 */     doAddSql((ScheduleEntity)entity);
/* 27 */     return t;
/*    */   }
/*    */   
/*    */   public <T> void saveOrUpdate(T entity) {
/* 31 */     super.saveOrUpdate(entity);
/*    */     
/* 33 */     doUpdateSql((ScheduleEntity)entity);
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public boolean doAddSql(ScheduleEntity t)
/*    */   {
/* 42 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public boolean doUpdateSql(ScheduleEntity t)
/*    */   {
/* 50 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public boolean doDelSql(ScheduleEntity t)
/*    */   {
/* 58 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public String replaceVal(String sql, ScheduleEntity t)
/*    */   {
/* 67 */     sql = sql.replace("#{id}", String.valueOf(t.getId()));
/* 68 */     sql = sql.replace("#{address}", String.valueOf(t.getAddress()));
/* 69 */     sql = sql.replace("#{content}", String.valueOf(t.getContent()));
/* 70 */     sql = sql.replace("#{executetime}", String.valueOf(t.getExecutetime()));
/* 71 */     sql = sql.replace("#{UUID}", UUID.randomUUID().toString());
/* 72 */     return sql;
/*    */   }
/*    */ }


/* Location:              E:\aaa\admin\WEB-INF\classes\!\com\fgoa\service\impl\schedule\ScheduleServiceImpl.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */