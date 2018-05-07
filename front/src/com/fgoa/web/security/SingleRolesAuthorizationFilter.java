/*    */ package com.fgoa.web.security;
/*    */ 
/*    */ import javax.servlet.ServletRequest;
/*    */ import javax.servlet.ServletResponse;
/*    */ import org.apache.shiro.subject.Subject;
/*    */ import org.apache.shiro.util.CollectionUtils;
/*    */ import org.apache.shiro.web.filter.authz.AuthorizationFilter;
/*    */ 
/*    */ public class SingleRolesAuthorizationFilter extends AuthorizationFilter
/*    */ {
/*    */   protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) throws Exception
/*    */   {
/* 13 */     Subject subject = getSubject(request, response);
/* 14 */     String[] rolesArray = (String[])mappedValue;
/* 15 */     if ((rolesArray == null) || (rolesArray.length == 0)) {
/* 16 */       return true;
/*    */     }
/* 18 */     java.util.Set<String> roles = CollectionUtils.asSet(rolesArray);
/* 19 */     for (String role : roles) {
/* 20 */       if (subject.hasRole(role)) {
/* 21 */         return true;
/*    */       }
/*    */     }
/* 24 */     return false;
/*    */   }
/*    */ }


/* Location:              E:\aaa\front\WEB-INF\classes\!\com\fgoa\web\security\SingleRolesAuthorizationFilter.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */