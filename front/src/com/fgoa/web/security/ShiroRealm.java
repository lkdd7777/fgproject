/*    */ package com.fgoa.web.security;
/*    */ 
/*    */ import com.fgoa.web.model.Role;
/*    */ import com.fgoa.web.model.User;
/*    */ import com.woo.jfinal.utils.PasswordUtil;
/*    */ import java.util.ArrayList;
/*    */ import java.util.Collection;
/*    */ import java.util.Iterator;
/*    */ import java.util.List;
/*    */ import org.apache.commons.lang.StringUtils;
/*    */ import org.apache.shiro.authc.AuthenticationException;
/*    */ import org.apache.shiro.authc.AuthenticationInfo;
/*    */ import org.apache.shiro.authc.AuthenticationToken;
/*    */ import org.apache.shiro.authc.IncorrectCredentialsException;
/*    */ import org.apache.shiro.authc.UnknownAccountException;
/*    */ import org.apache.shiro.authc.UsernamePasswordToken;
/*    */ import org.apache.shiro.authz.AuthorizationInfo;
/*    */ import org.apache.shiro.authz.SimpleAuthorizationInfo;
/*    */ import org.apache.shiro.realm.AuthorizingRealm;
/*    */ import org.apache.shiro.subject.PrincipalCollection;
/*    */ 
/*    */ public class ShiroRealm extends AuthorizingRealm
/*    */ {
/*    */   protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authcToken) throws AuthenticationException
/*    */   {
/* 26 */     UsernamePasswordToken token = (UsernamePasswordToken)authcToken;
/*    */     
/* 28 */     String password = String.valueOf(token.getPassword());
/*    */     
/* 30 */     User user = User.dao.findUserByName(token.getUsername());
/* 31 */     if (user == null) {
/* 32 */       throw new UnknownAccountException();
/*    */     }
/* 34 */     String encryptPwd = PasswordUtil.encrypt(token.getUsername(), password, 
/* 35 */       PasswordUtil.getStaticSalt());
/* 36 */     if (encryptPwd.equals(user.getStr("password"))) {
/* 37 */       ShiroRealmUser realmUser = new ShiroRealmUser(user.getStr("ID"), 
/* 38 */         user.getStr("username"), user.getStr("realname"), 
/* 39 */         user.getStr("departid"), getRoles(user.getStr("ID")));
/*    */       
/* 41 */       token.setPassword(encryptPwd.toCharArray());
/* 42 */       return new org.apache.shiro.authc.SimpleAuthenticationInfo(realmUser, encryptPwd, 
/* 43 */         getName());
/*    */     }
/* 45 */     throw new IncorrectCredentialsException();
/*    */   }
/*    */   
/*    */   protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals)
/*    */   {
/* 50 */     Iterator<?> principalsItr = principals.fromRealm(getName()).iterator();
/* 51 */     if (principalsItr == null) {
/* 52 */       return null;
/*    */     }
/* 54 */     ShiroRealmUser realmUser = (ShiroRealmUser)principalsItr.next();
/*    */     
/* 56 */     List<Role> roles = Role.dao.findUserRolesById(realmUser.getId());
/* 57 */     SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
/* 58 */     if (!roles.isEmpty()) {
/* 59 */       for (Role r : roles) {
/* 60 */         info.addStringPermission(r.getStr("rolecode"));
/*    */       }
/* 62 */       return info;
/*    */     }
/* 64 */     return null;
/*    */   }
/*    */   
/*    */   private List<String> getRoles(String userId) {
/* 68 */     List<String> returnValue = new ArrayList();
/* 69 */     if (StringUtils.isNotBlank(userId)) {
/* 70 */       List<Role> roles = Role.dao.findUserRolesById(userId);
/* 71 */       if (!roles.isEmpty()) {
/* 72 */         for (Role r : roles) {
/* 73 */           returnValue.add(r.getStr("rolecode"));
/*    */         }
/*    */       }
/*    */     }
/* 77 */     return returnValue;
/*    */   }
/*    */ }


/* Location:              E:\aaa\front\WEB-INF\classes\!\com\fgoa\web\security\ShiroRealm.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */