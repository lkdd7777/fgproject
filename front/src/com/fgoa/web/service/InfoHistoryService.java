/*    */ package com.fgoa.web.service;
/*    */ 
/*    */ import com.fgoa.web.model.InfoHistory;
/*    */ import java.util.Date;
/*    */ import org.slf4j.Logger;
/*    */ import org.slf4j.LoggerFactory;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class InfoHistoryService
/*    */ {
/* 12 */   private Logger log = LoggerFactory.getLogger(InfoHistoryService.class);
/*    */   
/* 14 */   public static final InfoHistoryService instance = new InfoHistoryService();
/*    */   
/*    */ 
/*    */   public void savePostHistory(String userName, String infoId, String content, String status)
/*    */   {
/* 19 */     ((InfoHistory)((InfoHistory)((InfoHistory)((InfoHistory)((InfoHistory)new InfoHistory().set("info_id", infoId)).set("user_name", userName)).set("content", content)).set("status", status)).set("create_time", new Date())).save();
/*    */   }
/*    */ }


/* Location:              E:\aaa\front\WEB-INF\classes\!\com\fgoa\web\service\InfoHistoryService.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */