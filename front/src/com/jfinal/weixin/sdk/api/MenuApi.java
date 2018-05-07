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
/*    */ public class MenuApi
/*    */ {
/* 16 */   private static String getMenu = "https://api.weixin.qq.com/cgi-bin/menu/get?access_token=";
/* 17 */   private static String createMenu = "https://api.weixin.qq.com/cgi-bin/menu/create?access_token=";
/*    */   
/*    */ 
/*    */ 
/*    */   public static ApiResult getMenu()
/*    */   {
/* 23 */     String jsonResult = HttpKit.get(getMenu + AccessTokenApi.getAccessToken().getAccessToken());
/* 24 */     return new ApiResult(jsonResult);
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public static ApiResult createMenu(String jsonStr)
/*    */   {
/* 31 */     String jsonResult = HttpKit.post(createMenu + AccessTokenApi.getAccessToken().getAccessToken(), jsonStr);
/* 32 */     return new ApiResult(jsonResult);
/*    */   }
/*    */ }


/* Location:              E:\aaa\front\WEB-INF\classes\!\com\jfinal\weixin\sdk\api\MenuApi.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */