/*    */ package com.jfinal.weixin.sdk.api;
/*    */ 
/*    */ import com.fasterxml.jackson.core.JsonParseException;
/*    */ import com.fasterxml.jackson.databind.JsonMappingException;
/*    */ import com.jfinal.kit.HttpKit;
/*    */ import com.jfinal.weixin.sdk.kit.ParaMap;
/*    */ import java.io.IOException;
/*    */ import java.io.PrintStream;
/*    */ import java.util.Map;
/*    */ import java.util.concurrent.ConcurrentHashMap;
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
/*    */ public class AccessTokenApi
/*    */ {
/* 24 */   private static String url = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential";
/*    */   
/*    */ 
/* 27 */   private static Map<String, AccessToken> map = new ConcurrentHashMap();
/*    */   
/*    */ 
/*    */ 
/*    */   public static AccessToken getAccessToken()
/*    */   {
/* 33 */     String appId = ApiConfigKit.getApiConfig().getAppId();
/* 34 */     AccessToken result = (AccessToken)map.get(appId);
/* 35 */     if ((result != null) && (result.isAvailable())) {
/* 36 */       return result;
/*    */     }
/* 38 */     refreshAccessToken();
/* 39 */     return (AccessToken)map.get(appId);
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public static synchronized void refreshAccessToken()
/*    */   {
/* 46 */     ApiConfig ac = ApiConfigKit.getApiConfig();
/* 47 */     AccessToken result = null;
/* 48 */     for (int i = 0; i < 3; i++) {
/* 49 */       String appId = ac.getAppId();
/* 50 */       String appSecret = ac.getAppSecret();
/* 51 */       Map<String, String> queryParas = ParaMap.create("appid", appId).put("secret", appSecret).getData();
/* 52 */       String json = HttpKit.get(url, queryParas);
/* 53 */       result = new AccessToken(json);
/*    */       
/* 55 */       if (result.isAvailable()) {
/*    */         break;
/*    */       }
/*    */     }
/*    */     
/* 60 */     map.put(ac.getAppId(), result);
/*    */   }
/*    */   
/*    */   public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException {
/* 64 */     ApiConfig ac = new ApiConfig();
/* 65 */     ac.setAppId("wx9803d1188fa5fbda");
/* 66 */     ac.setAppSecret("db859c968763c582794e7c3d003c3d87");
/* 67 */     ApiConfigKit.setThreadLocalApiConfig(ac);
/*    */     
/* 69 */     AccessToken at = getAccessToken();
/* 70 */     if (at.isAvailable()) {
/* 71 */       System.out.println("access_token : " + at.getAccessToken());
/*    */     } else {
/* 73 */       System.out.println(at.getErrorCode() + " : " + at.getErrorMsg());
/*    */     }
/*    */   }
/*    */ }


/* Location:              E:\aaa\front\WEB-INF\classes\!\com\jfinal\weixin\sdk\api\AccessTokenApi.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */