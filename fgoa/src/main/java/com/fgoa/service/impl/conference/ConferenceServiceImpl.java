/*    */ package com.fgoa.service.impl.conference;
/*    */ 
/*    */ import com.fgoa.entity.conference.ConferenceEntity;
/*    */ import com.fgoa.service.conference.ConferenceServiceI;
/*    */ import java.io.Serializable;
/*    */ import java.util.UUID;
/*    */ import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
/*    */ import org.springframework.stereotype.Service;
/*    */ import org.springframework.transaction.annotation.Transactional;
/*    */ 
/*    */ @Service("conferenceService")
/*    */ @Transactional
/*    */ public class ConferenceServiceImpl
/*    */   extends CommonServiceImpl implements ConferenceServiceI
/*    */ {
/*    */   public <T> void delete(T entity)
/*    */   {
/* 18 */     super.delete(entity);
/*    */     
/* 20 */     doDelSql((ConferenceEntity)entity);
/*    */   }
/*    */   
/*    */   public <T> Serializable save(T entity) {
/* 24 */     Serializable t = super.save(entity);
/*    */     
/* 26 */     doAddSql((ConferenceEntity)entity);
/* 27 */     return t;
/*    */   }
/*    */   
/*    */   public <T> void saveOrUpdate(T entity) {
/* 31 */     super.saveOrUpdate(entity);
/*    */     
/* 33 */     doUpdateSql((ConferenceEntity)entity);
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public boolean doAddSql(ConferenceEntity t)
/*    */   {
/* 42 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public boolean doUpdateSql(ConferenceEntity t)
/*    */   {
/* 50 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public boolean doDelSql(ConferenceEntity t)
/*    */   {
/* 58 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public String replaceVal(String sql, ConferenceEntity t)
/*    */   {
/* 67 */     sql = sql.replace("#{id}", String.valueOf(t.getId()));
/* 68 */     sql = sql.replace("#{executetime}", String.valueOf(t.getExecutetime()));
/* 69 */     sql = sql.replace("#{content}", String.valueOf(t.getContent()));
/* 70 */     sql = sql.replace("#{roomtype}", String.valueOf(t.getRoomtype()));
/* 71 */     sql = sql.replace("#{UUID}", UUID.randomUUID().toString());
/* 72 */     return sql;
/*    */   }
/*    */ }


/* Location:              E:\aaa\admin\WEB-INF\classes\!\com\fgoa\service\impl\conference\ConferenceServiceImpl.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */