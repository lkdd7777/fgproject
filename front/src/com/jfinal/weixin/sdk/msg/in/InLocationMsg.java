/*    */ package com.jfinal.weixin.sdk.msg.in;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class InLocationMsg
/*    */   extends InMsg
/*    */ {
/*    */   private String location_X;
/*    */   
/*    */ 
/*    */ 
/*    */   private String location_Y;
/*    */   
/*    */ 
/*    */ 
/*    */   private String scale;
/*    */   
/*    */ 
/*    */ 
/*    */   private String label;
/*    */   
/*    */ 
/*    */ 
/*    */   private String msgId;
/*    */   
/*    */ 
/*    */ 
/*    */   public InLocationMsg(String toUserName, String fromUserName, Integer createTime, String msgType)
/*    */   {
/* 31 */     super(toUserName, fromUserName, createTime, msgType);
/*    */   }
/*    */   
/*    */   public String getLocation_X() {
/* 35 */     return this.location_X;
/*    */   }
/*    */   
/*    */   public void setLocation_X(String location_X) {
/* 39 */     this.location_X = location_X;
/*    */   }
/*    */   
/*    */   public String getLocation_Y() {
/* 43 */     return this.location_Y;
/*    */   }
/*    */   
/*    */   public void setLocation_Y(String location_Y) {
/* 47 */     this.location_Y = location_Y;
/*    */   }
/*    */   
/*    */   public String getScale() {
/* 51 */     return this.scale;
/*    */   }
/*    */   
/*    */   public void setScale(String scale) {
/* 55 */     this.scale = scale;
/*    */   }
/*    */   
/*    */   public String getLabel() {
/* 59 */     return this.label;
/*    */   }
/*    */   
/*    */   public void setLabel(String label) {
/* 63 */     this.label = label;
/*    */   }
/*    */   
/*    */   public String getMsgId() {
/* 67 */     return this.msgId;
/*    */   }
/*    */   
/*    */   public void setMsgId(String msgId) {
/* 71 */     this.msgId = msgId;
/*    */   }
/*    */ }


/* Location:              E:\aaa\front\WEB-INF\classes\!\com\jfinal\weixin\sdk\msg\in\InLocationMsg.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */