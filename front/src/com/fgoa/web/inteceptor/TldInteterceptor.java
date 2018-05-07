/*    */ package com.fgoa.web.inteceptor;
/*    */ 
/*    */ import com.jfinal.aop.Interceptor;
/*    */ import com.jfinal.aop.Invocation;
/*    */ import com.jfinal.core.Controller;
/*    */ import freemarker.ext.jsp.TaglibFactory;
/*    */ import javax.servlet.http.HttpServletRequest;
/*    */ 
/*    */ public class TldInteterceptor implements Interceptor
/*    */ {
/*    */   public void intercept(Invocation ai)
/*    */   {
/* 13 */     Controller ctrl = ai.getController();
/* 14 */     ctrl.setAttr("JspTaglibs", new TaglibFactory(ctrl.getRequest()
/* 15 */       .getServletContext()));
/* 16 */     ai.invoke();
/*    */   }
/*    */ }


/* Location:              E:\aaa\front\WEB-INF\classes\!\com\fgoa\web\inteceptor\TldInteterceptor.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */