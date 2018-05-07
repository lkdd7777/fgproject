/*    */ package com.fgoa.web.security;
/*    */ 
/*    */ import java.util.List;
/*    */ 
/*    */ public class ShiroRealmUser implements java.io.Serializable
/*    */ {
/*    */   private static final long serialVersionUID = -1748602382963711884L;
/*    */   private String id;
/*    */   private String loginName;
/*    */   private String realName;
/*    */   private String orgId;
/*    */   private String orgName;
/*    */   private List<String> userRoles;
/*    */   
/*    */   public ShiroRealmUser(String id, String loginName, String realName, String departId, List<String> userRoles)
/*    */   {
/* 17 */     this.id = id;
/* 18 */     this.loginName = loginName;
/* 19 */     this.realName = realName;
/* 20 */     this.orgId = departId;
/* 21 */     this.userRoles = userRoles;
/*    */   }
/*    */   
/*    */   public String getId() {
/* 25 */     return this.id;
/*    */   }
/*    */   
/*    */   public void setId(String id) {
/* 29 */     this.id = id;
/*    */   }
/*    */   
/*    */   public String getLoginName() {
/* 33 */     return this.loginName;
/*    */   }
/*    */   
/*    */   public void setLoginName(String loginName) {
/* 37 */     this.loginName = loginName;
/*    */   }
/*    */   
/*    */   public String getRealName() {
/* 41 */     return this.realName;
/*    */   }
/*    */   
/*    */   public void setRealName(String realName) {
/* 45 */     this.realName = realName;
/*    */   }
/*    */   
/*    */   public String getOrgId() {
/* 49 */     return this.orgId;
/*    */   }
/*    */   
/*    */   public void setOrgId(String orgId) {
/* 53 */     this.orgId = orgId;
/*    */   }
/*    */   
/*    */   public String getOrgName() {
/* 57 */     return this.orgName;
/*    */   }
/*    */   
/*    */   public void setOrgName(String orgName) {
/* 61 */     this.orgName = orgName;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 65 */     return this.realName;
/*    */   }
/*    */   
/*    */   public List<String> getUserRoles() {
/* 69 */     return this.userRoles;
/*    */   }
/*    */   
/*    */   public void setUserRoles(List<String> userRoles) {
/* 73 */     this.userRoles = userRoles;
/*    */   }
/*    */ }


/* Location:              E:\aaa\front\WEB-INF\classes\!\com\fgoa\web\security\ShiroRealmUser.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */