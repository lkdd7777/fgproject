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
/*    */ public class ShorturlApi
/*    */ {
/* 17 */   private static String apiUrl = "https://api.weixin.qq.com/cgi-bin/shorturl?access_token=";
/*    */   
/*    */   public static ApiResult getShorturl(String jsonStr) {
/* 20 */     String jsonResult = HttpKit.post(apiUrl + AccessTokenApi.getAccessToken().getAccessToken(), jsonStr);
/* 21 */     return new ApiResult(jsonResult);
/*    */   }
/*    */ }


/* Location:              E:\aaa\front\WEB-INF\classes\!\com\jfinal\weixin\sdk\api\ShorturlApi.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */