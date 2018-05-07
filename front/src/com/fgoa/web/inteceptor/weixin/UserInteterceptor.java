/*    */ package com.fgoa.web.inteceptor.weixin;
/*    */ 
/*    */ import com.jfinal.aop.Invocation;
/*    */ import com.jfinal.core.Controller;
/*    */ import javax.servlet.http.HttpServletRequest;
/*    */ import org.apache.commons.lang.StringUtils;
/*    */ 
/*    */ public class UserInteterceptor implements com.jfinal.aop.Interceptor
/*    */ {
/*    */   public void intercept(Invocation ai)
/*    */   {
/* 12 */     Controller ctrl = ai.getController();
/*    */     
/* 14 */     String userId = (String)ctrl.getSessionAttr("userId");
/* 15 */     if (StringUtils.isBlank(userId)) {
/* 16 */       userId = ctrl.getPara("userId");
/* 17 */       if (StringUtils.isBlank(userId)) {
/* 18 */         userId = (String)ctrl.getRequest().getAttribute("userId");
/* 19 */         if (StringUtils.isBlank(userId)) {
/* 20 */           ctrl.getRequest().setAttribute("errorMsg", "未正确读取到用户信息");
/* 21 */           ctrl.render("errorInfo.ftl");
/* 22 */           return;
/*    */         }
/*    */       }
/*    */     }
/* 26 */     ctrl.setSessionAttr("userId", userId);
/* 27 */     ai.invoke();
/*    */   }
/*    */ }


/* Location:              E:\aaa\front\WEB-INF\classes\!\com\fgoa\web\inteceptor\weixin\UserInteterceptor.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */