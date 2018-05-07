/*    */ package com.jfinal.weixin.sdk.api;
/*    */ 
/*    */ import com.fasterxml.jackson.databind.ObjectMapper;
/*    */ import java.util.Map;
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
/*    */ public class AccessToken
/*    */ {
/*    */   private String access_token;
/*    */   private Integer expires_in;
/*    */   private Integer errcode;
/*    */   private String errmsg;
/*    */   private Long expiredTime;
/*    */   private String json;
/*    */   
/*    */   public AccessToken(String jsonStr)
/*    */   {
/* 27 */     this.json = jsonStr;
/*    */     
/*    */     try
/*    */     {
/* 31 */       Map map = (Map)new ObjectMapper().readValue(jsonStr, Map.class);
/* 32 */       this.access_token = ((String)map.get("access_token"));
/* 33 */       this.expires_in = ((Integer)map.get("expires_in"));
/* 34 */       this.errcode = ((Integer)map.get("errcode"));
/* 35 */       this.errmsg = ((String)map.get("errmsg"));
/*    */       
/* 37 */       if (this.expires_in != null) {
/* 38 */         this.expiredTime = Long.valueOf(System.currentTimeMillis() + (this.expires_in.intValue() - 5) * 1000);
/*    */       }
/*    */     } catch (Exception e) {
/* 41 */       throw new RuntimeException(e);
/*    */     }
/*    */   }
/*    */   
/*    */   public String getJson() {
/* 46 */     return this.json;
/*    */   }
/*    */   
/*    */   public boolean isAvailable() {
/* 50 */     if (this.expiredTime == null)
/* 51 */       return false;
/* 52 */     if (this.errcode != null)
/* 53 */       return false;
/* 54 */     if (this.expiredTime.longValue() < System.currentTimeMillis())
/* 55 */       return false;
/* 56 */     return this.access_token != null;
/*    */   }
/*    */   
/*    */   public String getAccessToken() {
/* 60 */     return this.access_token;
/*    */   }
/*    */   
/*    */   public Integer getExpiresIn() {
/* 64 */     return this.expires_in;
/*    */   }
/*    */   
/*    */   public Integer getErrorCode() {
/* 68 */     return this.errcode;
/*    */   }
/*    */   
/*    */   public String getErrorMsg() {
/* 72 */     if (this.errcode != null) {
/* 73 */       String result = ReturnCode.get(this.errcode.intValue());
/* 74 */       if (result != null)
/* 75 */         return result;
/*    */     }
/* 77 */     return this.errmsg;
/*    */   }
/*    */ }


/* Location:              E:\aaa\front\WEB-INF\classes\!\com\jfinal\weixin\sdk\api\AccessToken.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */