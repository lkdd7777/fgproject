/*    */ package com.fgoa.web.validator;
/*    */ 
/*    */ import com.jfinal.core.Controller;
/*    */ import com.jfinal.validate.Validator;
/*    */ import javax.servlet.http.HttpServletRequest;
/*    */ import org.apache.commons.lang.StringUtils;
/*    */ 
/*    */ public class PetitionValidator extends Validator
/*    */ {
/*    */   protected void validate(Controller c)
/*    */   {
/* 12 */     if (!StringUtils.equalsIgnoreCase("post", c.getRequest().getMethod())) {
/* 13 */       c.redirect("/petition/memberPage");
/* 14 */       return;
/*    */     }
/*    */     
/*    */ 
/* 18 */     validateRequired("submitDate", "submitDateMsg", "请输入来件日期；");
/* 19 */     validateRequired("title", "titleMsg", "请输入标题；");
/*    */   }
/*    */   
/*    */ 
/*    */   protected void handleError(Controller c)
/*    */   {
/* 25 */     c.keepPara();
/* 26 */     c.render("petition3.ftl");
/*    */   }
/*    */ }


/* Location:              E:\aaa\front\WEB-INF\classes\!\com\fgoa\web\validator\PetitionValidator.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */