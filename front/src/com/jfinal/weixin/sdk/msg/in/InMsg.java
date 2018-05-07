/*    */ package com.jfinal.weixin.sdk.msg.in;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public abstract class InMsg
/*    */ {
/*    */   protected String toUserName;
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   protected String fromUserName;
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   protected Integer createTime;
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   protected String msgType;
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public InMsg(String toUserName, String fromUserName, Integer createTime, String msgType)
/*    */   {
/* 45 */     this.toUserName = toUserName;
/* 46 */     this.fromUserName = fromUserName;
/* 47 */     this.createTime = createTime;
/* 48 */     this.msgType = msgType;
/*    */   }
/*    */   
/*    */   public String getToUserName() {
/* 52 */     return this.toUserName;
/*    */   }
/*    */   
/*    */   public void setToUserName(String toUserName) {
/* 56 */     this.toUserName = toUserName;
/*    */   }
/*    */   
/*    */   public String getFromUserName() {
/* 60 */     return this.fromUserName;
/*    */   }
/*    */   
/*    */   public void setFromUserName(String fromUserName) {
/* 64 */     this.fromUserName = fromUserName;
/*    */   }
/*    */   
/*    */   public Integer getCreateTime() {
/* 68 */     return this.createTime;
/*    */   }
/*    */   
/*    */   public void setCreateTime(Integer createTime) {
/* 72 */     this.createTime = createTime;
/*    */   }
/*    */   
/*    */   public String getMsgType() {
/* 76 */     return this.msgType;
/*    */   }
/*    */   
/*    */   public void setMsgType(String msgType) {
/* 80 */     this.msgType = msgType;
/*    */   }
/*    */ }


/* Location:              E:\aaa\front\WEB-INF\classes\!\com\jfinal\weixin\sdk\msg\in\InMsg.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */