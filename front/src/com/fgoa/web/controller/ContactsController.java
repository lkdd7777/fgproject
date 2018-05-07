/*    */ package com.fgoa.web.controller;
/*    */ 
/*    */ import com.fgoa.web.model.User;
/*    */ import org.apache.commons.lang.StringUtils;
/*    */ 
/*    */ public class ContactsController extends com.jfinal.core.Controller
/*    */ {
/*    */   public void index()
/*    */   {
/* 10 */     String userName = getPara("userName");
/* 11 */     String print = getPara("print");
/* 12 */     if (StringUtils.isBlank(userName)) {
/* 13 */       setAttr("users", 
/* 14 */         User.dao.find("select * from t_s_base_user as b,t_s_user as u,t_s_depart as d where b.id=u.id and b.departid=d.id order by u.orderNum desc"));
/*    */     }
/*    */     else {
/* 17 */       setAttr("userName", userName);
/* 18 */       setAttr("users", 
/* 19 */         User.dao.find("select * from t_s_base_user as b,t_s_user as u,t_s_depart as d where b.id=u.id and b.departid=d.id and b.realname like '%" + userName + "%' order by u.orderNum desc"));
/*    */     }
/* 21 */     if (StringUtils.isNotBlank(print)) {
/* 22 */       render("contacts_print.ftl");
/*    */     }
/*    */     else {
/* 25 */       render("contacts.ftl");
/*    */     }
/*    */   }
/*    */ }


/* Location:              E:\aaa\front\WEB-INF\classes\!\com\fgoa\web\controller\ContactsController.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */