/*    */ package com.fgoa.web.controller.weixin;
/*    */ 
/*    */ import com.fgoa.web.model.User;
/*    */ import com.jfinal.core.Controller;
/*    */ import com.jfinal.plugin.activerecord.Db;
/*    */ import com.woo.jfinal.utils.PasswordUtil;
/*    */ import org.apache.commons.lang.StringUtils;
/*    */ 
/*    */ public class BindUserController
/*    */   extends Controller
/*    */ {
/*    */   public void index()
/*    */   {
/* 14 */     keepPara();
/* 15 */     String userName = getPara("userName");
/* 16 */     String password = getPara("password");
/* 17 */     String openId = getPara("openId");
/* 18 */     String targetUrl = getPara("targetUrl");
/* 19 */     if ((StringUtils.isBlank(userName)) || (StringUtils.isBlank(password)) || 
/* 20 */       (StringUtils.isBlank(openId)) || 
/* 21 */       (StringUtils.isBlank(targetUrl))) {
/* 22 */       setAttr("errorMsg", "用户名或密码不能为空");
/* 23 */       render("errorInfo.ftl");
/* 24 */       return;
/*    */     }
/*    */     
/* 27 */     User user = User.dao.findUserByName(userName);
/* 28 */     if (user == null) {
/* 29 */       setAttr("errorMsg", String.format("未找到用户名为%s的用户", new Object[] { userName }));
/* 30 */       render("errorInfo.ftl");
/* 31 */       return;
/*    */     }
/*    */     
/* 34 */     String encryptPwd = PasswordUtil.encrypt(userName, password, 
/* 35 */       PasswordUtil.getStaticSalt());
/* 36 */     if (!StringUtils.equals(encryptPwd, user.getStr("password"))) {
/* 37 */       setAttr("errorMsg", "用户名或密码错误，请重新绑定");
/* 38 */       render("errorInfo.ftl");
/* 39 */       return;
/*    */     }
/*    */     
/* 42 */     String updateSql = "update t_s_base_user t set t.openId= ? where t.ID= ?";
/* 43 */     Db.update(updateSql, new Object[] { openId, user.getStr("ID") });
/* 44 */     setSessionAttr("userId", user.getStr("ID"));
/* 45 */     redirect(targetUrl + "?userId=" + user.getStr("ID"));
/*    */   }
/*    */ }


/* Location:              E:\aaa\front\WEB-INF\classes\!\com\fgoa\web\controller\weixin\BindUserController.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */