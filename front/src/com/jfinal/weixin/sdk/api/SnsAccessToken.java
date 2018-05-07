/*     */ package com.jfinal.weixin.sdk.api;
/*     */ 
/*     */ import com.fasterxml.jackson.databind.ObjectMapper;
/*     */ import java.util.Map;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SnsAccessToken
/*     */ {
/*     */   private String access_token;
/*     */   private Integer expires_in;
/*     */   private String refresh_token;
/*     */   private String openid;
/*     */   private String scope;
/*     */   private Integer errcode;
/*     */   private String errmsg;
/*     */   private Long expiredTime;
/*     */   private String json;
/*     */   
/*     */   public SnsAccessToken(String jsonStr)
/*     */   {
/*  33 */     this.json = jsonStr;
/*     */     
/*     */ 
/*     */     try
/*     */     {
/*  38 */       Map map = (Map)new ObjectMapper().readValue(jsonStr, Map.class);
/*  39 */       this.access_token = ((String)map.get("access_token"));
/*  40 */       this.expires_in = ((Integer)map.get("expires_in"));
/*  41 */       this.refresh_token = ((String)map.get("refresh_token"));
/*  42 */       this.openid = ((String)map.get("openid"));
/*  43 */       this.scope = ((String)map.get("scope"));
/*  44 */       this.errcode = ((Integer)map.get("errcode"));
/*  45 */       this.errmsg = ((String)map.get("errmsg"));
/*     */       
/*  47 */       if (this.expires_in != null) {
/*  48 */         this.expiredTime = Long.valueOf(System.currentTimeMillis() + (this.expires_in.intValue() - 5) * 1000);
/*     */       }
/*     */     }
/*     */     catch (Exception e) {
/*  52 */       throw new RuntimeException(e);
/*     */     }
/*     */   }
/*     */   
/*     */   public String getJson()
/*     */   {
/*  58 */     return this.json;
/*     */   }
/*     */   
/*     */   public boolean isAvailable()
/*     */   {
/*  63 */     if (this.expiredTime == null)
/*  64 */       return false;
/*  65 */     if (this.errcode != null)
/*  66 */       return false;
/*  67 */     if (this.expiredTime.longValue() < System.currentTimeMillis())
/*  68 */       return false;
/*  69 */     return this.access_token != null;
/*     */   }
/*     */   
/*     */   public String getAccessToken()
/*     */   {
/*  74 */     return this.access_token;
/*     */   }
/*     */   
/*     */   public Integer getExpiresIn()
/*     */   {
/*  79 */     return this.expires_in;
/*     */   }
/*     */   
/*     */   public String getRefresh_token()
/*     */   {
/*  84 */     return this.refresh_token;
/*     */   }
/*     */   
/*     */   public void setRefresh_token(String refresh_token)
/*     */   {
/*  89 */     this.refresh_token = refresh_token;
/*     */   }
/*     */   
/*     */   public String getOpenid()
/*     */   {
/*  94 */     return this.openid;
/*     */   }
/*     */   
/*     */   public void setOpenid(String openid)
/*     */   {
/*  99 */     this.openid = openid;
/*     */   }
/*     */   
/*     */   public String getScope()
/*     */   {
/* 104 */     return this.scope;
/*     */   }
/*     */   
/*     */   public void setScope(String scope)
/*     */   {
/* 109 */     this.scope = scope;
/*     */   }
/*     */   
/*     */   public Integer getErrorCode()
/*     */   {
/* 114 */     return this.errcode;
/*     */   }
/*     */   
/*     */   public String getErrorMsg()
/*     */   {
/* 119 */     if (this.errcode != null)
/*     */     {
/* 121 */       String result = ReturnCode.get(this.errcode.intValue());
/* 122 */       if (result != null)
/* 123 */         return result;
/*     */     }
/* 125 */     return this.errmsg;
/*     */   }
/*     */ }


/* Location:              E:\aaa\front\WEB-INF\classes\!\com\jfinal\weixin\sdk\api\SnsAccessToken.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */