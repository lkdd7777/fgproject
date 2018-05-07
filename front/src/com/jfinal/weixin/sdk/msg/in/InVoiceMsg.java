/*    */ package com.jfinal.weixin.sdk.msg.in;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class InVoiceMsg
/*    */   extends InMsg
/*    */ {
/*    */   private String mediaId;
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   private String format;
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
/*    */   public InVoiceMsg(String toUserName, String fromUserName, Integer createTime, String msgType)
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
/*    */   public String getFormat() {
/* 40 */     return this.format;
/*    */   }
/*    */   
/*    */   public void setFormat(String format) {
/* 44 */     this.format = format;
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


/* Location:              E:\aaa\front\WEB-INF\classes\!\com\jfinal\weixin\sdk\msg\in\InVoiceMsg.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */