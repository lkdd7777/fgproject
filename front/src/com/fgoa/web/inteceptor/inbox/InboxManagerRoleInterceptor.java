/*    */ package com.fgoa.web.inteceptor.inbox;
/*    */ 
/*    */ import com.fgoa.web.model.Role;
/*    */ import com.jfinal.aop.Interceptor;
/*    */ import com.jfinal.aop.Invocation;
/*    */ import com.jfinal.core.Controller;
/*    */ import org.apache.shiro.SecurityUtils;
/*    */ import org.apache.shiro.subject.Subject;
/*    */ 
/*    */ public class InboxManagerRoleInterceptor implements Interceptor
/*    */ {
/*    */   public void intercept(Invocation ai)
/*    */   {
/* 14 */     if (SecurityUtils.getSubject().getPrincipal() != null) {
/* 15 */       if (!Role.dao.isCurrentUserHasRole("inboxmanager")) {
/* 16 */         ai.getController().renderError(503);
/*    */       } else {
/* 18 */         ai.invoke();
/*    */       }
/*    */     }
/*    */   }
/*    */ }


/* Location:              E:\aaa\front\WEB-INF\classes\!\com\fgoa\web\inteceptor\inbox\InboxManagerRoleInterceptor.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */