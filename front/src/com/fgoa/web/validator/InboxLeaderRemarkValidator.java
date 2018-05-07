/*    */ package com.fgoa.web.validator;
/*    */ 
/*    */ import com.jfinal.core.Controller;
/*    */ import com.jfinal.validate.Validator;
/*    */ import javax.servlet.http.HttpServletRequest;
/*    */ import org.apache.commons.lang.StringUtils;
/*    */ 
/*    */ public class InboxLeaderRemarkValidator extends Validator
/*    */ {
/*    */   protected void validate(Controller c)
/*    */   {
/* 12 */     if (!StringUtils.equalsIgnoreCase("post", c.getRequest().getMethod())) {
/* 13 */       c.redirect("/inbox/leaderReadList");
/* 14 */       return;
/*    */     }
/* 16 */     validateRequired("opinionContent", "opinionContent", "请输入批阅意见");
/*    */   }
/*    */   
/*    */   protected void handleError(Controller c)
/*    */   {
/* 21 */     c.keepPara();
/* 22 */     c.render("inbox9.ftl");
/*    */   }
/*    */ }


/* Location:              E:\aaa\front\WEB-INF\classes\!\com\fgoa\web\validator\InboxLeaderRemarkValidator.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */