/*    */ package com.fgoa.web.security;
/*    */ 
/*    */ import org.apache.shiro.subject.Subject;
/*    */ 
/*    */ public class ShiroUtils
/*    */ {
/*    */   public static ShiroRealmUser getCurrentUser()
/*    */   {
/*  9 */     Subject subject = org.apache.shiro.SecurityUtils.getSubject();
/* 10 */     ShiroRealmUser realmUser = (ShiroRealmUser)subject.getPrincipal();
/* 11 */     return realmUser;
/*    */   }
/*    */   
/*    */   public static String getCurrentUserId() {
/* 15 */     return getCurrentUser().getId();
/*    */   }
/*    */   
/*    */   public static java.util.List<String> getCurrentUserRoles() {
/* 19 */     return getCurrentUser().getUserRoles();
/*    */   }
/*    */   
/*    */   public static String getCurrentUserName() {
/* 23 */     return getCurrentUser().getRealName();
/*    */   }
/*    */   
/*    */   public static String getCurrentUserOrgName() {
/* 27 */     return getCurrentUser().getOrgName();
/*    */   }
/*    */   
/*    */   public static String getCurrentUserOrgId() {
/* 31 */     return getCurrentUser().getOrgId();
/*    */   }
/*    */ }


/* Location:              E:\aaa\front\WEB-INF\classes\!\com\fgoa\web\security\ShiroUtils.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */