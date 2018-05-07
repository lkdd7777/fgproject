/*    */ package com.jfinal.weixin.sdk.msg.in.event;
/*    */ 
/*    */ import com.jfinal.weixin.sdk.msg.in.InMsg;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public abstract class EventInMsg
/*    */   extends InMsg
/*    */ {
/*    */   protected String event;
/*    */   
/*    */   public EventInMsg(String toUserName, String fromUserName, Integer createTime, String msgType, String event)
/*    */   {
/* 17 */     super(toUserName, fromUserName, createTime, msgType);
/* 18 */     this.event = event;
/*    */   }
/*    */   
/*    */   public String getEvent()
/*    */   {
/* 23 */     return this.event;
/*    */   }
/*    */   
/*    */   public void setEvent(String event)
/*    */   {
/* 28 */     this.event = event;
/*    */   }
/*    */ }


/* Location:              E:\aaa\front\WEB-INF\classes\!\com\jfinal\weixin\sdk\msg\in\event\EventInMsg.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */