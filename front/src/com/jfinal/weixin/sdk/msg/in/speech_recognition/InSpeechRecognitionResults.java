/*    */ package com.jfinal.weixin.sdk.msg.in.speech_recognition;
/*    */ 
/*    */ import com.jfinal.weixin.sdk.msg.in.InMsg;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class InSpeechRecognitionResults
/*    */   extends InMsg
/*    */ {
/*    */   private String mediaId;
/*    */   private String format;
/*    */   private String recognition;
/*    */   private String msgId;
/*    */   
/*    */   public InSpeechRecognitionResults(String toUserName, String fromUserName, Integer createTime, String msgType)
/*    */   {
/* 33 */     super(toUserName, fromUserName, createTime, msgType);
/*    */   }
/*    */   
/*    */   public String getMediaId() {
/* 37 */     return this.mediaId;
/*    */   }
/*    */   
/*    */   public void setMediaId(String mediaId) {
/* 41 */     this.mediaId = mediaId;
/*    */   }
/*    */   
/*    */   public String getFormat() {
/* 45 */     return this.format;
/*    */   }
/*    */   
/*    */   public void setFormat(String format) {
/* 49 */     this.format = format;
/*    */   }
/*    */   
/*    */   public String getRecognition() {
/* 53 */     return this.recognition;
/*    */   }
/*    */   
/*    */   public void setRecognition(String recognition) {
/* 57 */     this.recognition = recognition;
/*    */   }
/*    */   
/*    */   public String getMsgId() {
/* 61 */     return this.msgId;
/*    */   }
/*    */   
/*    */   public void setMsgId(String msgId) {
/* 65 */     this.msgId = msgId;
/*    */   }
/*    */ }


/* Location:              E:\aaa\front\WEB-INF\classes\!\com\jfinal\weixin\sdk\msg\in\speech_recognition\InSpeechRecognitionResults.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */