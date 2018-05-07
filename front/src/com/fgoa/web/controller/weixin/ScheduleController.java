/*    */ package com.fgoa.web.controller.weixin;
/*    */ 
/*    */ import com.fgoa.web.inteceptor.weixin.WeixinInteterceptor;
/*    */ import com.fgoa.web.service.ScheduleService;
/*    */ import com.jfinal.aop.Before;
/*    */ import javax.servlet.http.HttpServletRequest;
/*    */ import org.apache.commons.lang.StringUtils;
/*    */ 
/*    */ public class ScheduleController extends com.jfinal.core.Controller
/*    */ {
/*    */   @Before({WeixinInteterceptor.class})
/*    */   public void index()
/*    */   {
/* 14 */     String userId = getPara("userId");
/* 15 */     if (StringUtils.isBlank(userId)) {
/* 16 */       userId = (String)getRequest().getAttribute("userId");
/*    */     }
/* 18 */     if (StringUtils.isNotBlank(userId)) {
/* 19 */       setAttr("scheduleList", 
/* 20 */         ScheduleService.instance.queryScheduleInWeek(userId));
/* 21 */       render("schedule_result.ftl");
/*    */     } else {
/* 23 */       setAttr("errorMsg", "获取微信账号信息出现错误");
/* 24 */       render("errorInfo.ftl");
/*    */     }
/*    */   }
/*    */ }


/* Location:              E:\aaa\front\WEB-INF\classes\!\com\fgoa\web\controller\weixin\ScheduleController.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */