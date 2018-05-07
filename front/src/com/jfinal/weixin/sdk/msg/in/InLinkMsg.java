/*    */ package com.jfinal.weixin.sdk.msg.in;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class InLinkMsg
/*    */   extends InMsg
/*    */ {
/*    */   private String title;
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   private String description;
/*    */   
/*    */ 
/*    */ 
/*    */   private String url;
/*    */   
/*    */ 
/*    */ 
/*    */   private String msgId;
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public InLinkMsg(String toUserName, String fromUserName, Integer createTime, String msgType)
/*    */   {
/* 30 */     super(toUserName, fromUserName, createTime, msgType);
/*    */   }
/*    */   
/*    */   public String getTitle() {
/* 34 */     return this.title;
/*    */   }
/*    */   
/*    */   public void setTitle(String title) {
/* 38 */     this.title = title;
/*    */   }
/*    */   
/*    */   public String getDescription() {
/* 42 */     return this.description;
/*    */   }
/*    */   
/*    */   public void setDescription(String description) {
/* 46 */     this.description = description;
/*    */   }
/*    */   
/*    */   public String getUrl() {
/* 50 */     return this.url;
/*    */   }
/*    */   
/*    */   public void setUrl(String url) {
/* 54 */     this.url = url;
/*    */   }
/*    */   
/*    */   public String getMsgId() {
/* 58 */     return this.msgId;
/*    */   }
/*    */   
/*    */   public void setMsgId(String msgId) {
/* 62 */     this.msgId = msgId;
/*    */   }
/*    */ }


/* Location:              E:\aaa\front\WEB-INF\classes\!\com\jfinal\weixin\sdk\msg\in\InLinkMsg.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */