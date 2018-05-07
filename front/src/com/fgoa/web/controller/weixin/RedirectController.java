/*    */ package com.fgoa.web.controller.weixin;
/*    */ 
/*    */ import com.jfinal.core.Controller;
/*    */ import org.apache.commons.lang.StringUtils;
/*    */ 
/*    */ 
/*    */ public class RedirectController
/*    */   extends Controller
/*    */ {
/*    */   public void index()
/*    */   {
/* 12 */     String targetUrl = getPara("targetUrl");
/* 13 */     if (StringUtils.isBlank(targetUrl)) {
/* 14 */       renderError(404);
/* 15 */       return;
/*    */     }
/* 17 */     redirect(String.format("https://open.weixin.qq.com/connect/oauth2/authorize?appid=wx1a801083c534d772&redirect_uri=%s&response_type=code&scope=snsapi_userinfo&state=STATE#wechat_redirect", new Object[] { targetUrl }));
/*    */   }
/*    */ }


/* Location:              E:\aaa\front\WEB-INF\classes\!\com\fgoa\web\controller\weixin\RedirectController.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */