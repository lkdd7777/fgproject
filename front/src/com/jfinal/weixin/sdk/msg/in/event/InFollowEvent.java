/*    */ package com.jfinal.weixin.sdk.msg.in.event;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class InFollowEvent
/*    */   extends EventInMsg
/*    */ {
/*    */   public static final String EVENT_INFOLLOW_SUBSCRIBE = "subscribe";
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public static final String EVENT_INFOLLOW_UNSUBSCRIBE = "unsubscribe";
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public InFollowEvent(String toUserName, String fromUserName, Integer createTime, String msgType, String event)
/*    */   {
/* 49 */     super(toUserName, fromUserName, createTime, msgType, event);
/*    */   }
/*    */ }


/* Location:              E:\aaa\front\WEB-INF\classes\!\com\jfinal\weixin\sdk\msg\in\event\InFollowEvent.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */