/*    */ package com.fgoa.web.service;
/*    */ 
/*    */ import com.fgoa.web.model.PostHistory;
/*    */ import java.util.Date;
/*    */ import org.slf4j.Logger;
/*    */ import org.slf4j.LoggerFactory;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PostHistoryService
/*    */ {
/* 12 */   private Logger log = LoggerFactory.getLogger(PostHistoryService.class);
/*    */   
/* 14 */   public static final PostHistoryService instance = new PostHistoryService();
/*    */   
/*    */ 
/*    */   public void savePostHistory(String userName, String postId, String content, String status)
/*    */   {
/* 19 */     ((PostHistory)((PostHistory)((PostHistory)((PostHistory)((PostHistory)new PostHistory().set("post_id", postId)).set("user_name", userName)).set("content", content)).set("status", status)).set("create_time", new Date())).save();
/*    */   }
/*    */ }


/* Location:              E:\aaa\front\WEB-INF\classes\!\com\fgoa\web\service\PostHistoryService.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */