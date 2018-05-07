/*    */ package com.jfinal.weixin.sdk.msg.in.event;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class InLocationEvent
/*    */   extends EventInMsg
/*    */ {
/*    */   private String latitude;
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   private String longitude;
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   private String precision;
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public InLocationEvent(String toUserName, String fromUserName, Integer createTime, String msgType, String event)
/*    */   {
/* 29 */     super(toUserName, fromUserName, createTime, msgType, event);
/*    */   }
/*    */   
/*    */   public String getLatitude() {
/* 33 */     return this.latitude;
/*    */   }
/*    */   
/*    */   public void setLatitude(String latitude) {
/* 37 */     this.latitude = latitude;
/*    */   }
/*    */   
/*    */   public String getLongitude() {
/* 41 */     return this.longitude;
/*    */   }
/*    */   
/*    */   public void setLongitude(String longitude) {
/* 45 */     this.longitude = longitude;
/*    */   }
/*    */   
/*    */   public String getPrecision() {
/* 49 */     return this.precision;
/*    */   }
/*    */   
/*    */   public void setPrecision(String precision) {
/* 53 */     this.precision = precision;
/*    */   }
/*    */ }


/* Location:              E:\aaa\front\WEB-INF\classes\!\com\jfinal\weixin\sdk\msg\in\event\InLocationEvent.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */