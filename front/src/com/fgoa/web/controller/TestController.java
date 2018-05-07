/*    */ package com.fgoa.web.controller;
/*    */ 
/*    */ import com.jfinal.core.ActionKey;
/*    */ 
/*    */ public class TestController extends com.jfinal.core.Controller
/*    */ {
/*    */   @ActionKey("/hello")
/*    */   public void index() {
/*  9 */     renderText("it works!");
/*    */   }
/*    */   
/*    */   public void json() {
/* 13 */     renderJson(new String[] { "123", "456" });
/*    */   }
/*    */   
/*    */   public void freemarker() {
/* 17 */     render("test.ftl");
/*    */   }
/*    */ }


/* Location:              E:\aaa\front\WEB-INF\classes\!\com\fgoa\web\controller\TestController.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */