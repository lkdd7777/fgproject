/*    */ package com.fgoa.web.inteceptor;
/*    */ 
/*    */ import com.fgoa.web.security.ShiroRealmUser;
/*    */ import com.jfinal.aop.Interceptor;
/*    */ import com.jfinal.aop.Invocation;
/*    */ import com.jfinal.core.Controller;
/*    */ import java.util.ArrayList;
/*    */ import org.apache.shiro.SecurityUtils;
/*    */ import org.apache.shiro.subject.Subject;
/*    */ 
/*    */ 
/*    */ public class ParamInteterceptor
/*    */   implements Interceptor
/*    */ {
/*    */   public void intercept(Invocation ai)
/*    */   {
/* 17 */     Controller ctrl = ai.getController();
/*    */     
/* 19 */     Subject subject = SecurityUtils.getSubject();
/* 20 */     ShiroRealmUser realmUser = (ShiroRealmUser)subject.getPrincipal();
/* 21 */     if (realmUser != null) {
/* 22 */       ctrl.setAttr("userRoles", realmUser.getUserRoles());
/*    */     } else {
/* 24 */       ctrl.setAttr("userRoles", new ArrayList());
/*    */     }
/*    */     
/* 27 */     ai.invoke();
/*    */   }
/*    */ }


/* Location:              E:\aaa\front\WEB-INF\classes\!\com\fgoa\web\inteceptor\ParamInteterceptor.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */