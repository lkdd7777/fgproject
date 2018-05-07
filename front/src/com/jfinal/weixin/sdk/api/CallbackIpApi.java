/*    */ package com.jfinal.weixin.sdk.api;
/*    */ 
/*    */ import com.jfinal.kit.HttpKit;
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
/*    */ public class CallbackIpApi
/*    */ {
/* 17 */   private static String apiUrl = "https://api.weixin.qq.com/cgi-bin/getcallbackip?access_token=";
/*    */   
/*    */ 
/*    */ 
/*    */   public static ApiResult getCallbackIp()
/*    */   {
/* 23 */     String jsonResult = HttpKit.get(apiUrl + AccessTokenApi.getAccessToken().getAccessToken());
/* 24 */     return new ApiResult(jsonResult);
/*    */   }
/*    */ }


/* Location:              E:\aaa\front\WEB-INF\classes\!\com\jfinal\weixin\sdk\api\CallbackIpApi.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */