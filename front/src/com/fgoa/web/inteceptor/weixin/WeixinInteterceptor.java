/*    */ package com.fgoa.web.inteceptor.weixin;
/*    */ 
/*    */ import com.fgoa.web.model.User;
/*    */ import com.jfinal.aop.Invocation;
/*    */ import com.jfinal.core.Controller;
/*    */ import com.jfinal.kit.PropKit;
/*    */ import com.jfinal.weixin.sdk.api.ApiConfig;
/*    */ import com.jfinal.weixin.sdk.api.ApiConfigKit;
/*    */ import com.jfinal.weixin.sdk.api.SnsAccessToken;
/*    */ import com.jfinal.weixin.sdk.api.SnsAccessTokenApi;
/*    */ import javax.servlet.http.HttpServletRequest;
/*    */ import org.apache.commons.lang.StringUtils;
/*    */ import org.apache.log4j.Logger;
/*    */ 
/*    */ public class WeixinInteterceptor implements com.jfinal.aop.Interceptor
/*    */ {
/* 17 */   private static final Logger LOGGER = Logger.getLogger(WeixinInteterceptor.class);
/*    */   
/*    */   public void intercept(Invocation ai)
/*    */   {
/* 21 */     Controller ctrl = ai.getController();
/*    */     
/* 23 */     String userId = (String)ctrl.getSessionAttr("userId");
/* 24 */     if (StringUtils.isBlank(userId)) {
/* 25 */       userId = ctrl.getPara("userId");
/* 26 */       if (StringUtils.isBlank(userId)) {
/* 27 */         userId = (String)ctrl.getRequest().getAttribute("userId");
/*    */       }
/*    */     }
/* 30 */     if (StringUtils.isNotBlank(userId)) {
/* 31 */       ai.invoke();
/* 32 */       return;
/*    */     }
/*    */     
/* 35 */     String code = ctrl.getPara("code");
/* 36 */     if (StringUtils.isBlank(code)) {
/* 37 */       LOGGER.error("获取微信Code值为空");
/* 38 */       ctrl.getRequest().setAttribute("errorMsg", "获取微信账号信息错误，请与管理员联系。<br>具体信息:获取微信Code值为空");
/*    */       
/* 40 */       ctrl.render("errorInfo.ftl");
/* 41 */       return;
/*    */     }
/*    */     
/* 44 */     ApiConfigKit.setThreadLocalApiConfig(getApiConfig());
/* 45 */     SnsAccessToken token = SnsAccessTokenApi.getAccessToken(code);
/*    */     
/* 47 */     if ((token == null) || ((token != null) && (token.getErrorCode() != null)) || (StringUtils.isBlank(token.getOpenid())))
/*    */     {
/* 49 */       LOGGER.error("获取到微信OpenId值为空");
/* 50 */       ctrl.getRequest().setAttribute("errorMsg", "获取微信账号信息错误，请与管理员联系。<br>获取到微信OpenId值为空");
/* 51 */       ctrl.render("errorInfo.ftl");
/* 52 */       return;
/*    */     }
/*    */     
/* 55 */     String openId = token.getOpenid();
/*    */     
/* 57 */     User user = (User)User.dao.findFirst("select * from t_s_base_user where openId = ?", new Object[] { openId });
/* 58 */     if (user == null) {
/* 59 */       LOGGER.info("未找到对应的微信用户，跳转到微信用户绑定页面");
/* 60 */       LOGGER.info(String.format("用户openId为：%s", new Object[] { openId }));
/* 61 */       ctrl.getRequest().setAttribute("openId", openId);
/* 62 */       ctrl.getRequest().setAttribute("targetUrl", ctrl.getRequest().getRequestURL());
/* 63 */       ctrl.render("bind/bind.ftl");
/* 64 */       return;
/*    */     }
/* 66 */     LOGGER.info("找到了对应的微信用户，跳转到目标页面");
/* 67 */     ctrl.getRequest().setAttribute("userId", user.get("ID"));
/* 68 */     ctrl.getRequest().setAttribute("openId", openId);
/* 69 */     ctrl.setSessionAttr("userId", user.get("ID"));
/* 70 */     ai.invoke();
/*    */   }
/*    */   
/*    */   public ApiConfig getApiConfig()
/*    */   {
/* 75 */     ApiConfig ac = new ApiConfig();
/*    */     
/*    */ 
/* 78 */     ac.setToken(PropKit.get("token"));
/* 79 */     ac.setAppId(PropKit.get("appId"));
/* 80 */     ac.setAppSecret(PropKit.get("appSecret"));
/*    */     
/* 82 */     ac.setEncryptMessage(PropKit.getBoolean("encryptMessage", Boolean.valueOf(false)).booleanValue());
/* 83 */     ac.setEncodingAesKey(PropKit.get("encodingAesKey", "setting it in config file"));
/* 84 */     return ac;
/*    */   }
/*    */ }


/* Location:              E:\aaa\front\WEB-INF\classes\!\com\fgoa\web\inteceptor\weixin\WeixinInteterceptor.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */