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
/*    */ 
/*    */ public class UserApi
/*    */ {
/* 18 */   private static String getUserInfo = "https://api.weixin.qq.com/cgi-bin/user/info";
/* 19 */   private static String getFollowers = "https://api.weixin.qq.com/cgi-bin/user/get";
/* 20 */   private static String batchGetUserInfo = "https://api.weixin.qq.com/cgi-bin/user/info/batchget?access_token=";
/*    */   
/*    */   public static ApiResult getUserInfo(String openId) {
/* 23 */     ParaMap pm = ParaMap.create("access_token", AccessTokenApi.getAccessToken().getAccessToken()).put("openid", openId).put("lang", "zh_CN");
/* 24 */     return new ApiResult(HttpKit.get(getUserInfo, pm.getData()));
/*    */   }
/*    */   
/*    */   public static ApiResult getFollowers(String nextOpenid) {
/* 28 */     ParaMap pm = ParaMap.create("access_token", AccessTokenApi.getAccessToken().getAccessToken());
/* 29 */     if (nextOpenid != null)
/* 30 */       pm.put("next_openid", nextOpenid);
/* 31 */     return new ApiResult(HttpKit.get(getFollowers, pm.getData()));
/*    */   }
/*    */   
/*    */   public static ApiResult getFollows() {
/* 35 */     return getFollowers(null);
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public static ApiResult batchGetUserInfo(String jsonStr)
/*    */   {
/* 42 */     String jsonResult = HttpKit.post(batchGetUserInfo + AccessTokenApi.getAccessToken().getAccessToken(), jsonStr);
/* 43 */     return new ApiResult(jsonResult);
/*    */   }
/*    */ }


/* Location:              E:\aaa\front\WEB-INF\classes\!\com\jfinal\weixin\sdk\api\UserApi.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */