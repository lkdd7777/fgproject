/*    */ package com.fgoa.web.validator;
/*    */ 
/*    */ import com.jfinal.core.Controller;
/*    */ import com.jfinal.validate.Validator;
/*    */ import javax.servlet.http.HttpServletRequest;
/*    */ import org.apache.commons.lang.StringUtils;
/*    */ 
/*    */ public class InboxValidator extends Validator
/*    */ {
/*    */   protected void validate(Controller c)
/*    */   {
/* 12 */     if (!StringUtils.equalsIgnoreCase("post", c.getRequest().getMethod())) {
/* 13 */       c.redirect("/inbox/backLogList");
/* 14 */       return;
/*    */     }
/* 16 */     validateRequired("title", "titleMsg", "缺少标题；");
/* 17 */     validateRequired("orgName", "orgNameMsg", "缺少来文单位；");
/* 18 */     validateRequired("submitDate", "submitDateMsg", "缺少来文日期；");
/* 19 */     validateRequired("tag", "tagMsg", "缺少字号；");
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   protected void handleError(Controller c)
/*    */   {
/* 28 */     c.keepPara();
/* 29 */     c.render("inbox3.ftl");
/*    */   }
/*    */ }


/* Location:              E:\aaa\front\WEB-INF\classes\!\com\fgoa\web\validator\InboxValidator.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */