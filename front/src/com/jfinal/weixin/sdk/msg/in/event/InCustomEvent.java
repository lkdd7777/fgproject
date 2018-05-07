/*    */ package com.jfinal.weixin.sdk.msg.in.event;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class InCustomEvent
/*    */   extends EventInMsg
/*    */ {
/*    */   public static final String EVENT_INCUSTOM_KF_CREATE_SESSION = "kf_create_session";
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public static final String EVENT_INCUSTOM_KF_CLOSE_SESSION = "kf_close_session";
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public static final String EVENT_INCUSTOM_KF_SWITCH_SESSION = "kf_switch_session";
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   private String kfAccount;
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   private String toKfAccount;
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public InCustomEvent(String toUserName, String fromUserName, Integer createTime, String msgType, String event)
/*    */   {
/* 55 */     super(toUserName, fromUserName, createTime, msgType, event);
/*    */   }
/*    */   
/*    */   public String getKfAccount()
/*    */   {
/* 60 */     return this.kfAccount;
/*    */   }
/*    */   
/*    */   public void setKfAccount(String kfAccount)
/*    */   {
/* 65 */     this.kfAccount = kfAccount;
/*    */   }
/*    */   
/*    */   public String getToKfAccount()
/*    */   {
/* 70 */     return this.toKfAccount;
/*    */   }
/*    */   
/*    */   public void setToKfAccount(String toKfAccount)
/*    */   {
/* 75 */     this.toKfAccount = toKfAccount;
/*    */   }
/*    */ }


/* Location:              E:\aaa\front\WEB-INF\classes\!\com\jfinal\weixin\sdk\msg\in\event\InCustomEvent.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */