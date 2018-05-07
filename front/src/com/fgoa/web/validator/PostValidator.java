/*    */ package com.fgoa.web.validator;
/*    */ 
/*    */ import com.jfinal.core.Controller;
/*    */ import com.jfinal.validate.Validator;
/*    */ import javax.servlet.http.HttpServletRequest;
/*    */ import org.apache.commons.lang.StringUtils;
/*    */ 
/*    */ public class PostValidator extends Validator
/*    */ {
/*    */   protected void validate(Controller c)
/*    */   {
/* 12 */     if (!StringUtils.equalsIgnoreCase("post", c.getRequest().getMethod())) {
/* 13 */       c.redirect("/post/postList");
/* 14 */       return;
/*    */     }
/*    */     
/* 17 */     validateRequired("sortNum", "sortNumMsg", "请输入发文编号");
/*    */     
/* 19 */     validateRequired("title", "titleMsg", "请输入标题");
/* 20 */     validateRequired("keyWords", "keyWordsMsg", "请输入主题词");
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   protected void handleError(Controller c)
/*    */   {
/* 28 */     c.keepPara();
/* 29 */     c.render("posting2.ftl");
/*    */   }
/*    */ }


/* Location:              E:\aaa\front\WEB-INF\classes\!\com\fgoa\web\validator\PostValidator.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */