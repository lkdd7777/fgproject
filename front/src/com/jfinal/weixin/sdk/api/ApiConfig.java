/*     */ package com.jfinal.weixin.sdk.api;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ApiConfig
/*     */ {
/*  14 */   private String token = null;
/*  15 */   private String appId = null;
/*  16 */   private String appSecret = null;
/*  17 */   private String encodingAesKey = null;
/*  18 */   private boolean messageEncrypt = false;
/*     */   
/*     */ 
/*     */   public ApiConfig() {}
/*     */   
/*     */   public ApiConfig(String token)
/*     */   {
/*  25 */     setToken(token);
/*     */   }
/*     */   
/*     */   public ApiConfig(String token, String appId, String appSecret) {
/*  29 */     setToken(token);
/*  30 */     setAppId(appId);
/*  31 */     setAppSecret(appSecret);
/*     */   }
/*     */   
/*     */   public ApiConfig(String token, String appId, String appSecret, boolean messageEncrypt, String encodingAesKey) {
/*  35 */     setToken(token);
/*  36 */     setAppId(appId);
/*  37 */     setAppSecret(appSecret);
/*  38 */     setEncryptMessage(messageEncrypt);
/*  39 */     setEncodingAesKey(encodingAesKey);
/*     */   }
/*     */   
/*     */   public String getToken() {
/*  43 */     if (this.token == null)
/*  44 */       throw new IllegalStateException("token 未被赋值");
/*  45 */     return this.token;
/*     */   }
/*     */   
/*     */   public void setToken(String token) {
/*  49 */     if (token == null)
/*  50 */       throw new IllegalArgumentException("token 值不能为 null");
/*  51 */     this.token = token;
/*     */   }
/*     */   
/*     */   public String getAppId() {
/*  55 */     if (this.appId == null)
/*  56 */       throw new IllegalStateException("appId 未被赋值");
/*  57 */     return this.appId;
/*     */   }
/*     */   
/*     */   public void setAppId(String appId) {
/*  61 */     if (appId == null)
/*  62 */       throw new IllegalArgumentException("appId 值不能为 null");
/*  63 */     this.appId = appId;
/*     */   }
/*     */   
/*     */   public String getAppSecret() {
/*  67 */     if (this.appSecret == null)
/*  68 */       throw new IllegalStateException("appSecret 未被赋值");
/*  69 */     return this.appSecret;
/*     */   }
/*     */   
/*     */   public void setAppSecret(String appSecret) {
/*  73 */     if (appSecret == null)
/*  74 */       throw new IllegalArgumentException("appSecret 值不能为 null");
/*  75 */     this.appSecret = appSecret;
/*     */   }
/*     */   
/*     */   public String getEncodingAesKey() {
/*  79 */     if (this.encodingAesKey == null)
/*  80 */       throw new IllegalStateException("encodingAesKey 未被赋值");
/*  81 */     return this.encodingAesKey;
/*     */   }
/*     */   
/*     */   public void setEncodingAesKey(String encodingAesKey) {
/*  85 */     if (encodingAesKey == null)
/*  86 */       throw new IllegalArgumentException("encodingAesKey 值不能为 null");
/*  87 */     this.encodingAesKey = encodingAesKey;
/*     */   }
/*     */   
/*     */   public boolean isEncryptMessage() {
/*  91 */     return this.messageEncrypt;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setEncryptMessage(boolean messageEncrypt)
/*     */   {
/* 100 */     this.messageEncrypt = messageEncrypt;
/*     */   }
/*     */ }


/* Location:              E:\aaa\front\WEB-INF\classes\!\com\jfinal\weixin\sdk\api\ApiConfig.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */