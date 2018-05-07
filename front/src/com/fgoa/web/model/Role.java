/*    */ package com.fgoa.web.model;
/*    */ 
/*    */ import com.jfinal.plugin.activerecord.Model;
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import org.apache.commons.collections.CollectionUtils;
/*    */ 
/*    */ public class Role extends Model<Role>
/*    */ {
/* 10 */   public static Role dao = new Role();
/*    */   
/*    */   public List<Role> findUserRolesById(String userId) {
/* 13 */     String sql = "SELECT r.* FROM `t_s_role` r,`t_s_user` u,`t_s_role_user` ru WHERE r.ID=ru.roleid and u.id=ru.userid and u.id=?";
/* 14 */     return dao.find(sql, new Object[] { userId });
/*    */   }
/*    */   
/*    */   public boolean isCurrentUserHasRole(String roleCode) {
/* 18 */     List<String> currentUserRoles = com.fgoa.web.security.ShiroUtils.getCurrentUserRoles();
/* 19 */     if ((CollectionUtils.isNotEmpty(currentUserRoles)) && 
/* 20 */       (currentUserRoles.contains(roleCode))) {
/* 21 */       return true;
/*    */     }
/* 23 */     return false;
/*    */   }
/*    */   
/*    */   public boolean isUserContainAnyRole(String userId, String[] targetRoles) {
/* 27 */     List<Role> roles = findUserRolesById(userId);
/* 28 */     List<String> roleCodes = new ArrayList();
/* 29 */     CollectionUtils.addAll(roleCodes, targetRoles);
/* 30 */     for (Role role : roles) {
/* 31 */       if (roleCodes.contains(role.getStr("rolecode"))) {
/* 32 */         return true;
/*    */       }
/*    */     }
/* 35 */     return false;
/*    */   }
/*    */   
/*    */   public boolean isUserContainRole(String userId, String targetRole) {
/* 39 */     return isUserContainAnyRole(userId, new String[] { targetRole });
/*    */   }
/*    */   
/*    */   public List<String> getUserRoles(String userId) {
/* 43 */     List<Role> roles = dao.findUserRolesById(userId);
/* 44 */     List<String> roleCodes = new ArrayList();
/* 45 */     for (Role r : roles) {
/* 46 */       roleCodes.add(r.getStr("rolecode"));
/*    */     }
/* 48 */     return roleCodes;
/*    */   }
/*    */ }


/* Location:              E:\aaa\front\WEB-INF\classes\!\com\fgoa\web\model\Role.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */