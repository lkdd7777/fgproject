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
/*    */ public class CustomServiceApi
/*    */ {
/* 17 */   private static String getRecordUrl = "https://api.weixin.qq.com/customservice/msgrecord/getrecord?access_token=";
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public static ApiResult getRecord(String jsonStr)
/*    */   {
/* 24 */     String jsonResult = HttpKit.post(getRecordUrl + AccessTokenApi.getAccessToken().getAccessToken(), jsonStr);
/* 25 */     return new ApiResult(jsonResult);
/*    */   }
/*    */ }


/* Location:              E:\aaa\front\WEB-INF\classes\!\com\jfinal\weixin\sdk\api\CustomServiceApi.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */