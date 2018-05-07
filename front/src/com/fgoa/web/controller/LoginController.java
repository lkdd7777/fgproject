/*    */ package com.fgoa.web.controller;
/*    */ 
/*    */ import com.jfinal.aop.Before;
/*    */ import com.jfinal.core.ActionKey;
/*    */ import com.jfinal.core.Controller;
/*    */ import com.jfinal.ext.interceptor.GET;
/*    */ import com.jfinal.ext.interceptor.POST;
/*    */ import org.apache.commons.lang.StringUtils;
/*    */ import org.apache.shiro.SecurityUtils;
/*    */ import org.apache.shiro.authc.AuthenticationException;
/*    */ import org.apache.shiro.authc.IncorrectCredentialsException;
/*    */ import org.apache.shiro.authc.UnknownAccountException;
/*    */ import org.apache.shiro.authc.UsernamePasswordToken;
/*    */ import org.apache.shiro.subject.Subject;
/*    */ 
/*    */ public class LoginController extends Controller
/*    */ {
/*    */   @Before({GET.class})
/*    */   public void index()
/*    */   {
/* 21 */     Subject currentUser = SecurityUtils.getSubject();
/* 22 */     if (currentUser.isAuthenticated()) {
/* 23 */       redirect("/index");
/* 24 */       return;
/*    */     }
/* 26 */     render("login.ftl");
/*    */   }
/*    */   
/*    */   @Before({POST.class})
/*    */   public void check() {
/* 31 */     Subject currentUser = SecurityUtils.getSubject();
/* 32 */     String errorMsg = null;
/*    */     
/* 34 */     String username = getPara("username");
/* 35 */     String password = getPara("password");
/*    */     try
/*    */     {
/* 38 */       UsernamePasswordToken token = new UsernamePasswordToken(username, 
/* 39 */         password, false);
/* 40 */       currentUser.login(token);
/*    */     } catch (UnknownAccountException e) {
/* 42 */       errorMsg = "账号不存在";
/*    */     } catch (IncorrectCredentialsException e) {
/* 44 */       errorMsg = "密码错误";
/*    */     } catch (AuthenticationException e) {
/* 46 */       errorMsg = "登录失败";
/*    */     }
/* 48 */     if (StringUtils.isNotBlank(errorMsg)) {
/* 49 */       setAttr("error", errorMsg);
/* 50 */       setAttr("username", username);
/* 51 */       setAttr("password", password);
/* 52 */       render("login.ftl");
/*    */     } else {
/* 54 */       redirect("/index");
/*    */     }
/*    */   }
/*    */   
/*    */   @ActionKey("/logout")
/*    */   @Before({GET.class})
/*    */   public void logout() {
/* 61 */     Subject currentUser = SecurityUtils.getSubject();
/* 62 */     currentUser.logout();
/* 63 */     redirect("/index");
/*    */   }
/*    */ }


/* Location:              E:\aaa\front\WEB-INF\classes\!\com\fgoa\web\controller\LoginController.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */