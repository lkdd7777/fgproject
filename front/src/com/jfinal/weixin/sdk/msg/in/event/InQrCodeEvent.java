/*    */ package com.jfinal.weixin.sdk.msg.in.event;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class InQrCodeEvent
/*    */   extends EventInMsg
/*    */ {
/*    */   public static final String EVENT_INQRCODE_SUBSCRIBE = "subscribe";
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public static final String EVENT_INQRCODE_SCAN = "SCAN";
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   private String eventKey;
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   private String ticket;
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public InQrCodeEvent(String toUserName, String fromUserName, Integer createTime, String msgType, String event)
/*    */   {
/* 46 */     super(toUserName, fromUserName, createTime, msgType, event);
/*    */   }
/*    */   
/*    */   public String getEventKey() {
/* 50 */     return this.eventKey;
/*    */   }
/*    */   
/*    */   public void setEventKey(String eventKey) {
/* 54 */     this.eventKey = eventKey;
/*    */   }
/*    */   
/*    */   public String getTicket() {
/* 58 */     return this.ticket;
/*    */   }
/*    */   
/*    */   public void setTicket(String ticket) {
/* 62 */     this.ticket = ticket;
/*    */   }
/*    */ }


/* Location:              E:\aaa\front\WEB-INF\classes\!\com\jfinal\weixin\sdk\msg\in\event\InQrCodeEvent.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */