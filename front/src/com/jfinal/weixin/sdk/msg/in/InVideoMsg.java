/*    */ package com.jfinal.weixin.sdk.msg.in;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class InVideoMsg
/*    */   extends InMsg
/*    */ {
/*    */   private String mediaId;
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   private String thumbMediaId;
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   private String msgId;
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public InVideoMsg(String toUserName, String fromUserName, Integer createTime, String msgType)
/*    */   {
/* 28 */     super(toUserName, fromUserName, createTime, msgType);
/*    */   }
/*    */   
/*    */   public String getMediaId() {
/* 32 */     return this.mediaId;
/*    */   }
/*    */   
/*    */   public void setMediaId(String mediaId) {
/* 36 */     this.mediaId = mediaId;
/*    */   }
/*    */   
/*    */   public String getThumbMediaId() {
/* 40 */     return this.thumbMediaId;
/*    */   }
/*    */   
/*    */   public void setThumbMediaId(String thumbMediaId) {
/* 44 */     this.thumbMediaId = thumbMediaId;
/*    */   }
/*    */   
/*    */   public String getMsgId() {
/* 48 */     return this.msgId;
/*    */   }
/*    */   
/*    */   public void setMsgId(String msgId) {
/* 52 */     this.msgId = msgId;
/*    */   }
/*    */ }


/* Location:              E:\aaa\front\WEB-INF\classes\!\com\jfinal\weixin\sdk\msg\in\InVideoMsg.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */