/*     */ package com.jfinal.weixin.sdk.api;
/*     */ 
/*     */ import com.fasterxml.jackson.databind.ObjectMapper;
/*     */ import java.math.BigDecimal;
/*     */ import java.math.BigInteger;
/*     */ import java.util.List;
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
/*     */ public class ApiResult
/*     */ {
/*     */   private Map<String, Object> attrs;
/*     */   private String json;
/*     */   
/*     */   public ApiResult(String jsonStr)
/*     */   {
/*  39 */     this.json = jsonStr;
/*     */     try
/*     */     {
/*  42 */       Map<String, Object> temp = (Map)new ObjectMapper().readValue(jsonStr, Map.class);
/*  43 */       this.attrs = temp;
/*     */       
/*  45 */       refreshAccessTokenIfInvalid();
/*     */     } catch (Exception e) {
/*  47 */       throw new RuntimeException(e);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public static ApiResult create(String jsonStr)
/*     */   {
/*  55 */     return new ApiResult(jsonStr);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private void refreshAccessTokenIfInvalid()
/*     */   {
/*  66 */     if (isAccessTokenInvalid())
/*  67 */       AccessTokenApi.refreshAccessToken();
/*     */   }
/*     */   
/*     */   public String getJson() {
/*  71 */     return this.json;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  75 */     return getJson();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public boolean isSucceed()
/*     */   {
/*  82 */     Integer errorCode = getErrorCode();
/*     */     
/*  84 */     return (errorCode == null) || (errorCode.intValue() == 0);
/*     */   }
/*     */   
/*     */   public Integer getErrorCode() {
/*  88 */     return (Integer)this.attrs.get("errcode");
/*     */   }
/*     */   
/*     */   public String getErrorMsg() {
/*  92 */     Integer errorCode = getErrorCode();
/*  93 */     if (errorCode != null) {
/*  94 */       String result = ReturnCode.get(errorCode.intValue());
/*  95 */       if (result != null)
/*  96 */         return result;
/*     */     }
/*  98 */     return (String)this.attrs.get("errmsg");
/*     */   }
/*     */   
/*     */   public <T> T get(String name)
/*     */   {
/* 103 */     return (T)this.attrs.get(name);
/*     */   }
/*     */   
/*     */   public String getStr(String name) {
/* 107 */     return (String)this.attrs.get(name);
/*     */   }
/*     */   
/*     */   public Integer getInt(String name) {
/* 111 */     return (Integer)this.attrs.get(name);
/*     */   }
/*     */   
/*     */   public Long getLong(String name) {
/* 115 */     return (Long)this.attrs.get(name);
/*     */   }
/*     */   
/*     */   public BigInteger getBigInteger(String name) {
/* 119 */     return (BigInteger)this.attrs.get(name);
/*     */   }
/*     */   
/*     */   public Double getDouble(String name) {
/* 123 */     return (Double)this.attrs.get(name);
/*     */   }
/*     */   
/*     */   public BigDecimal getBigDecimal(String name) {
/* 127 */     return (BigDecimal)this.attrs.get(name);
/*     */   }
/*     */   
/*     */   public Boolean getBoolean(String name) {
/* 131 */     return (Boolean)this.attrs.get(name);
/*     */   }
/*     */   
/*     */   public List getList(String name)
/*     */   {
/* 136 */     return (List)this.attrs.get(name);
/*     */   }
/*     */   
/*     */   public Map getMap(String name)
/*     */   {
/* 141 */     return (Map)this.attrs.get(name);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean isAccessTokenInvalid()
/*     */   {
/* 153 */     Integer ec = getErrorCode();
/* 154 */     return (ec != null) && ((ec.intValue() == 40001) || (ec.intValue() == 42001) || (ec.intValue() == 42002) || (ec.intValue() == 40014));
/*     */   }
/*     */ }


/* Location:              E:\aaa\front\WEB-INF\classes\!\com\jfinal\weixin\sdk\api\ApiResult.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */