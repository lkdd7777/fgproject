/*    */ package com.jfinal.weixin.sdk.api;
/*    */ 
/*    */ import com.jfinal.kit.HttpKit;
/*    */ import com.jfinal.weixin.sdk.kit.ParaMap;
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
/*    */ 
/*    */ 
/*    */ public class SnsAccessTokenApi
/*    */ {
/* 22 */   private static String url = "https://api.weixin.qq.com/sns/oauth2/access_token?grant_type=authorization_code";
/*    */   
/*    */ 
/* 25 */   private static Map<String, SnsAccessToken> map = new ConcurrentHashMap();
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public static SnsAccessToken getAccessToken(String code)
/*    */   {
/* 32 */     String appId = ApiConfigKit.getApiConfig().getAppId();
/* 33 */     SnsAccessToken result = (SnsAccessToken)map.get(appId);
/* 34 */     if ((result != null) && (result.isAvailable())) {
/* 35 */       return result;
/*    */     }
/* 37 */     refreshAccessToken(code);
/* 38 */     return (SnsAccessToken)map.get(appId);
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public static synchronized void refreshAccessToken(String code)
/*    */   {
/* 46 */     ApiConfig ac = ApiConfigKit.getApiConfig();
/* 47 */     SnsAccessToken result = null;
/* 48 */     for (int i = 0; i < 3; i++)
/*    */     {
/* 50 */       String appId = ac.getAppId();
/* 51 */       String appSecret = ac.getAppSecret();
/* 52 */       Map<String, String> queryParas = ParaMap.create("appid", appId).put("secret", appSecret).put("code", code).getData();
/* 53 */       String json = HttpKit.get(url, queryParas);
/* 54 */       result = new SnsAccessToken(json);
/*    */       
/* 56 */       if (result.isAvailable()) {
/*    */         break;
/*    */       }
/*    */     }
/*    */     
/* 61 */     map.put(ac.getAppId(), result);
/*    */   }
/*    */ }


/* Location:              E:\aaa\front\WEB-INF\classes\!\com\jfinal\weixin\sdk\api\SnsAccessTokenApi.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */