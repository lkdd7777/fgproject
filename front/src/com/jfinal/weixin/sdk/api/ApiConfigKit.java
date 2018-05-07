/*    */ package com.jfinal.weixin.sdk.api;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ApiConfigKit
/*    */ {
/* 12 */   private static final ThreadLocal<ApiConfig> tl = new ThreadLocal();
/*    */   
/*    */ 
/* 15 */   private static boolean devMode = false;
/*    */   
/*    */   public static void setDevMode(boolean devMode) {
/* 18 */     devMode = devMode;
/*    */   }
/*    */   
/*    */   public static boolean isDevMode() {
/* 22 */     return devMode;
/*    */   }
/*    */   
/*    */   public static void setThreadLocalApiConfig(ApiConfig apiConfig) {
/* 26 */     tl.set(apiConfig);
/*    */   }
/*    */   
/*    */   public static void removeThreadLocalApiConfig() {
/* 30 */     tl.remove();
/*    */   }
/*    */   
/*    */   public static ApiConfig getApiConfig() {
/* 34 */     ApiConfig result = (ApiConfig)tl.get();
/* 35 */     if (result == null)
/* 36 */       throw new IllegalStateException("需要事先使用 ApiConfigKit.setThreadLocalApiConfig(apiConfig) 将 ApiConfig对象存入，才可以调用 ApiConfigKit.getApiConfig() 方法");
/* 37 */     return result;
/*    */   }
/*    */ }


/* Location:              E:\aaa\front\WEB-INF\classes\!\com\jfinal\weixin\sdk\api\ApiConfigKit.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */