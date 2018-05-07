/*    */ package com.fgoa.web.controller.weixin;
/*    */ 
/*    */ import com.fgoa.web.model.User;
/*    */ import com.jfinal.core.Controller;
/*    */ import org.apache.commons.lang.StringUtils;
/*    */ 
/*    */ public class ContactController extends Controller
/*    */ {
/*    */   public void index()
/*    */   {
/* 11 */     render("contact_query.ftl");
/*    */   }
/*    */   
/*    */   public void query()
/*    */   {
/* 16 */     String userName = getPara("userName");
/* 17 */     if (StringUtils.isBlank(userName)) {
/* 18 */       setAttr("users", 
/* 19 */         User.dao.find("select * from t_s_base_user as b,t_s_user as u,t_s_depart as d where b.id=u.id and b.departid=d.id order by u.orderNum desc"));
/*    */     }
/*    */     else {
/* 22 */       setAttr("userName", userName);
/* 23 */       setAttr("users", 
/* 24 */         User.dao.find("select * from t_s_base_user as b,t_s_user as u,t_s_depart as d where b.id=u.id and b.departid=d.id and b.realname like '%" + userName + "%' order by u.orderNum desc"));
/*    */     }
/*    */     
/* 27 */     render("contact_result.ftl");
/*    */   }
/*    */ }


/* Location:              E:\aaa\front\WEB-INF\classes\!\com\fgoa\web\controller\weixin\ContactController.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */