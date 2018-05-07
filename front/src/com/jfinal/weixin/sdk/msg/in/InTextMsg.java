/*    */ package com.jfinal.weixin.sdk.msg.in;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class InTextMsg
/*    */   extends InMsg
/*    */ {
/*    */   private String content;
/*    */   
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
/*    */ 
/*    */   public InTextMsg(String toUserName, String fromUserName, Integer createTime, String msgType)
/*    */   {
/* 26 */     super(toUserName, fromUserName, createTime, msgType);
/*    */   }
/*    */   
/*    */   public String getContent() {
/* 30 */     return this.content;
/*    */   }
/*    */   
/*    */   public void setContent(String content) {
/* 34 */     this.content = content;
/*    */   }
/*    */   
/*    */   public String getMsgId() {
/* 38 */     return this.msgId;
/*    */   }
/*    */   
/*    */   public void setMsgId(String msgId) {
/* 42 */     this.msgId = msgId;
/*    */   }
/*    */ }


/* Location:              E:\aaa\front\WEB-INF\classes\!\com\jfinal\weixin\sdk\msg\in\InTextMsg.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */