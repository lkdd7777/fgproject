/*     */ package com.jfinal.weixin.sdk.jfinal;
/*     */ 
/*     */ import com.jfinal.aop.Interceptor;
/*     */ import com.jfinal.aop.Invocation;
/*     */ import com.jfinal.core.Controller;
/*     */ import com.jfinal.kit.StrKit;
/*     */ import com.jfinal.log.Logger;
/*     */ import com.jfinal.weixin.sdk.api.ApiConfigKit;
/*     */ import com.jfinal.weixin.sdk.kit.SignatureCheckKit;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class MsgInterceptor
/*     */   implements Interceptor
/*     */ {
/*  27 */   private static final Logger log = Logger.getLogger(MsgInterceptor.class);
/*     */   
/*     */   public void intercept(Invocation inv) {
/*  30 */     Controller controller = inv.getController();
/*  31 */     if (!(controller instanceof MsgController)) {
/*  32 */       throw new RuntimeException("控制器需要继承 MsgController");
/*     */     }
/*     */     try
/*     */     {
/*  36 */       ApiConfigKit.setThreadLocalApiConfig(((MsgController)controller).getApiConfig());
/*     */       
/*     */ 
/*  39 */       if (isConfigServerRequest(controller)) {
/*  40 */         configServer(controller);
/*  41 */         return;
/*     */       }
/*     */       
/*     */ 
/*  45 */       if (checkSignature(controller)) {
/*  46 */         inv.invoke();
/*     */       }
/*     */       else {
/*  49 */         controller.renderText("签名验证失败，请确定是微信服务器在发送消息过来");
/*     */       }
/*     */     }
/*     */     finally {
/*  53 */       ApiConfigKit.removeThreadLocalApiConfig(); } ApiConfigKit.removeThreadLocalApiConfig();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   private boolean checkSignature(Controller controller)
/*     */   {
/*  61 */     String signature = controller.getPara("signature");
/*  62 */     String timestamp = controller.getPara("timestamp");
/*  63 */     String nonce = controller.getPara("nonce");
/*  64 */     if ((StrKit.isBlank(signature)) || (StrKit.isBlank(timestamp)) || (StrKit.isBlank(nonce))) {
/*  65 */       controller.renderText("check signature failure");
/*  66 */       return false;
/*     */     }
/*     */     
/*  69 */     if (SignatureCheckKit.me.checkSignature(signature, timestamp, nonce)) {
/*  70 */       return true;
/*     */     }
/*     */     
/*  73 */     log.error("check signature failure:  signature = " + 
/*  74 */       controller.getPara("signature") + 
/*  75 */       " timestamp = " + controller.getPara("timestamp") + 
/*  76 */       " nonce = " + controller.getPara("nonce"));
/*     */     
/*  78 */     return false;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   private boolean isConfigServerRequest(Controller controller)
/*     */   {
/*  86 */     return StrKit.notBlank(controller.getPara("echostr"));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void configServer(Controller c)
/*     */   {
/*  95 */     String echostr = c.getPara("echostr");
/*  96 */     String signature = c.getPara("signature");
/*  97 */     String timestamp = c.getPara("timestamp");
/*  98 */     String nonce = c.getPara("nonce");
/*  99 */     boolean isOk = SignatureCheckKit.me.checkSignature(signature, timestamp, nonce);
/* 100 */     if (isOk) {
/* 101 */       c.renderText(echostr);
/*     */     } else {
/* 103 */       log.error("验证失败：configServer");
/*     */     }
/*     */   }
/*     */ }


/* Location:              E:\aaa\front\WEB-INF\classes\!\com\jfinal\weixin\sdk\jfinal\MsgInterceptor.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */