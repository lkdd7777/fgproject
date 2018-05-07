/*    */ package com.jfinal.weixin.sdk.kit;
/*    */ 
/*    */ import javax.servlet.http.HttpServletRequest;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class IpKit
/*    */ {
/*    */   public static String getRealIp(HttpServletRequest request)
/*    */   {
/* 14 */     String ip = request.getHeader("x-forwarded-for");
/* 15 */     if ((ip == null) || (ip.length() == 0) || ("unknown".equalsIgnoreCase(ip))) {
/* 16 */       ip = request.getHeader("Proxy-Client-IP");
/*    */     }
/* 18 */     if ((ip == null) || (ip.length() == 0) || ("unknown".equalsIgnoreCase(ip))) {
/* 19 */       ip = request.getHeader("WL-Proxy-Client-IP");
/*    */     }
/* 21 */     if ((ip == null) || (ip.length() == 0) || ("unknown".equalsIgnoreCase(ip))) {
/* 22 */       ip = request.getRemoteAddr();
/*    */     }
/* 24 */     return ip;
/*    */   }
/*    */   
/*    */   public static String getRealIpV2(HttpServletRequest request) {
/* 28 */     String accessIP = request.getHeader("x-forwarded-for");
/* 29 */     if (accessIP == null)
/* 30 */       return request.getRemoteAddr();
/* 31 */     return accessIP;
/*    */   }
/*    */ }


/* Location:              E:\aaa\front\WEB-INF\classes\!\com\jfinal\weixin\sdk\kit\IpKit.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */