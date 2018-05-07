/*     */ package com.jfinal.weixin.sdk.msg.in.event;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class InMassEvent
/*     */   extends EventInMsg
/*     */ {
/*     */   public static final String EVENT_INMASS_STATUS_SENDSUCCESS = "sendsuccess";
/*     */   
/*     */ 
/*     */ 
/*     */   public static final String EVENT_INMASS_STATUS_SENDFAIL = "sendfail";
/*     */   
/*     */ 
/*     */ 
/*     */   private String msgId;
/*     */   
/*     */ 
/*     */ 
/*     */   private String status;
/*     */   
/*     */ 
/*     */ 
/*     */   private String totalCount;
/*     */   
/*     */ 
/*     */ 
/*     */   private String filterCount;
/*     */   
/*     */ 
/*     */ 
/*     */   private String sentCount;
/*     */   
/*     */ 
/*     */ 
/*     */   private String errorCount;
/*     */   
/*     */ 
/*     */ 
/*     */   public InMassEvent(String toUserName, String fromUserName, Integer createTime, String msgType, String event)
/*     */   {
/*  43 */     super(toUserName, fromUserName, createTime, msgType, event);
/*     */   }
/*     */   
/*     */   public String getMsgId()
/*     */   {
/*  48 */     return this.msgId;
/*     */   }
/*     */   
/*     */   public void setMsgId(String msgId)
/*     */   {
/*  53 */     this.msgId = msgId;
/*     */   }
/*     */   
/*     */   public String getStatus()
/*     */   {
/*  58 */     return this.status;
/*     */   }
/*     */   
/*     */   public void setStatus(String status)
/*     */   {
/*  63 */     this.status = status;
/*     */   }
/*     */   
/*     */   public String getTotalCount()
/*     */   {
/*  68 */     return this.totalCount;
/*     */   }
/*     */   
/*     */   public void setTotalCount(String totalCount)
/*     */   {
/*  73 */     this.totalCount = totalCount;
/*     */   }
/*     */   
/*     */   public String getFilterCount()
/*     */   {
/*  78 */     return this.filterCount;
/*     */   }
/*     */   
/*     */   public void setFilterCount(String filterCount)
/*     */   {
/*  83 */     this.filterCount = filterCount;
/*     */   }
/*     */   
/*     */   public String getSentCount()
/*     */   {
/*  88 */     return this.sentCount;
/*     */   }
/*     */   
/*     */   public void setSentCount(String sentCount)
/*     */   {
/*  93 */     this.sentCount = sentCount;
/*     */   }
/*     */   
/*     */   public String getErrorCount()
/*     */   {
/*  98 */     return this.errorCount;
/*     */   }
/*     */   
/*     */   public void setErrorCount(String errorCount)
/*     */   {
/* 103 */     this.errorCount = errorCount;
/*     */   }
/*     */ }


/* Location:              E:\aaa\front\WEB-INF\classes\!\com\jfinal\weixin\sdk\msg\in\event\InMassEvent.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */