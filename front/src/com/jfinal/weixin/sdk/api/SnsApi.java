/*    */ package com.jfinal.weixin.sdk.api;
/*    */ 
/*    */ import com.jfinal.kit.HttpKit;
/*    */ import com.jfinal.weixin.sdk.kit.ParaMap;
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
/*    */ public class SnsApi
/*    */ {
/* 17 */   private static String getUserInfo = "https://api.weixin.qq.com/sns/userinfo";
/*    */   
/*    */   public static ApiResult getUserInfo(String code, String openId)
/*    */   {
/* 21 */     ParaMap pm = ParaMap.create("access_token", SnsAccessTokenApi.getAccessToken(code).getAccessToken()).put("openid", openId).put("lang", "zh_CN");
/* 22 */     return new ApiResult(HttpKit.get(getUserInfo, pm.getData()));
/*    */   }
/*    */ }


/* Location:              E:\aaa\front\WEB-INF\classes\!\com\jfinal\weixin\sdk\api\SnsApi.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */