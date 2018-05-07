/*    */ package com.jfinal.weixin.sdk.msg.in.event;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class InTemplateMsgEvent
/*    */   extends EventInMsg
/*    */ {
/*    */   public static final String EVENT_INTEMPLATEMSG_STATUS_SUCCESS = "success";
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public static final String EVENT_INTEMPLATEMSG_STATUS_BLOCK = "block";
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public static final String EVENT_INTEMPLATEMSG_STATUS_FAILED = "failed: system failed";
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   private String msgId;
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   private String status;
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public InTemplateMsgEvent(String toUserName, String fromUserName, Integer createTime, String msgType, String event)
/*    */   {
/* 41 */     super(toUserName, fromUserName, createTime, msgType, event);
/*    */   }
/*    */   
/*    */   public String getMsgId() {
/* 45 */     return this.msgId;
/*    */   }
/*    */   
/*    */   public void setMsgId(String msgId) {
/* 49 */     this.msgId = msgId;
/*    */   }
/*    */   
/*    */   public String getStatus() {
/* 53 */     return this.status;
/*    */   }
/*    */   
/*    */   public void setStatus(String status) {
/* 57 */     this.status = status;
/*    */   }
/*    */ }


/* Location:              E:\aaa\front\WEB-INF\classes\!\com\jfinal\weixin\sdk\msg\in\event\InTemplateMsgEvent.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */