/*    */ package com.jfinal.weixin.sdk.msg.in.event;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class InMenuEvent
/*    */   extends EventInMsg
/*    */ {
/*    */   public static final String EVENT_INMENU_CLICK = "CLICK";
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public static final String EVENT_INMENU_VIEW = "VIEW";
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
/*    */ 
/*    */ 
/*    */   public InMenuEvent(String toUserName, String fromUserName, Integer createTime, String msgType, String event)
/*    */   {
/* 40 */     super(toUserName, fromUserName, createTime, msgType, event);
/*    */   }
/*    */   
/*    */   public String getEventKey() {
/* 44 */     return this.eventKey;
/*    */   }
/*    */   
/*    */   public void setEventKey(String eventKey) {
/* 48 */     this.eventKey = eventKey;
/*    */   }
/*    */ }


/* Location:              E:\aaa\front\WEB-INF\classes\!\com\jfinal\weixin\sdk\msg\in\event\InMenuEvent.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */