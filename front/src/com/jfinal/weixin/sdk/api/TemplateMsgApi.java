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
/*    */ public class TemplateMsgApi
/*    */ {
/* 16 */   private static String sendApiUrl = "https://api.weixin.qq.com/cgi-bin/message/template/send?access_token=";
/*    */   
/*    */ 
/*    */ 
/*    */   public static ApiResult send(String jsonStr)
/*    */   {
/* 22 */     String jsonResult = HttpKit.post(sendApiUrl + AccessTokenApi.getAccessToken().getAccessToken(), jsonStr);
/* 23 */     return new ApiResult(jsonResult);
/*    */   }
/*    */ }


/* Location:              E:\aaa\front\WEB-INF\classes\!\com\jfinal\weixin\sdk\api\TemplateMsgApi.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */