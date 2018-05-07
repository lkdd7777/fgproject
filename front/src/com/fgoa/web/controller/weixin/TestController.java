/*    */ package com.fgoa.web.controller.weixin;
/*    */ 
/*    */ import com.fgoa.web.inteceptor.weixin.WeixinInteterceptor;
/*    */ import com.jfinal.aop.Before;
/*    */ 
/*    */ public class TestController extends com.jfinal.core.Controller
/*    */ {
/*    */   @Before({WeixinInteterceptor.class})
/*    */   public void index()
/*    */   {
/* 11 */     keepPara();
/* 12 */     render("test1.ftl");
/*    */   }
/*    */   
/*    */   @Before({WeixinInteterceptor.class})
/*    */   public void test() {
/* 17 */     keepPara();
/* 18 */     render("test2.ftl");
/*    */   }
/*    */ }


/* Location:              E:\aaa\front\WEB-INF\classes\!\com\fgoa\web\controller\weixin\TestController.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */