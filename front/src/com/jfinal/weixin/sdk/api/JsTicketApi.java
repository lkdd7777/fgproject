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
/*    */ public class JsTicketApi
/*    */ {
/* 18 */   private static String apiUrl = "https://api.weixin.qq.com/cgi-bin/ticket/getticket?access_token=";
/*    */   
/*    */   public static ApiResult getTicket() {
/* 21 */     ParaMap pm = ParaMap.create("access_token", AccessTokenApi.getAccessToken().getAccessToken()).put("type", "wx_card");
/* 22 */     return new ApiResult(HttpKit.get(apiUrl, pm.getData()));
/*    */   }
/*    */ }


/* Location:              E:\aaa\front\WEB-INF\classes\!\com\jfinal\weixin\sdk\api\JsTicketApi.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */