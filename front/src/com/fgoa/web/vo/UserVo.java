/*    */ package com.fgoa.web.vo;
/*    */ 
/*    */ import java.util.List;
/*    */ 
/*    */ public class UserVo {
/*    */   private String userId;
/*    */   private String userName;
/*    */   private List<OrgVo> orgs;
/*    */   
/*    */   public String getUserId() {
/* 11 */     return this.userId;
/*    */   }
/*    */   
/*    */   public void setUserId(String userId) {
/* 15 */     this.userId = userId;
/*    */   }
/*    */   
/*    */   public String getUserName() {
/* 19 */     return this.userName;
/*    */   }
/*    */   
/*    */   public void setUserName(String userName) {
/* 23 */     this.userName = userName;
/*    */   }
/*    */   
/*    */   public List<OrgVo> getOrgs() {
/* 27 */     return this.orgs;
/*    */   }
/*    */   
/*    */   public void setOrgs(List<OrgVo> orgs) {
/* 31 */     this.orgs = orgs;
/*    */   }
/*    */ }


/* Location:              E:\aaa\front\WEB-INF\classes\!\com\fgoa\web\vo\UserVo.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */