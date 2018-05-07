/*    */ package com.jfinal.weixin.sdk.msg.in;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class InImageMsg
/*    */   extends InMsg
/*    */ {
/*    */   private String picUrl;
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   private String mediaId;
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
/*    */   public InImageMsg(String toUserName, String fromUserName, Integer createTime, String msgType)
/*    */   {
/* 28 */     super(toUserName, fromUserName, createTime, msgType);
/*    */   }
/*    */   
/*    */   public String getPicUrl() {
/* 32 */     return this.picUrl;
/*    */   }
/*    */   
/*    */   public void setPicUrl(String picUrl) {
/* 36 */     this.picUrl = picUrl;
/*    */   }
/*    */   
/*    */   public String getMediaId() {
/* 40 */     return this.mediaId;
/*    */   }
/*    */   
/*    */   public void setMediaId(String mediaId) {
/* 44 */     this.mediaId = mediaId;
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


/* Location:              E:\aaa\front\WEB-INF\classes\!\com\jfinal\weixin\sdk\msg\in\InImageMsg.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */