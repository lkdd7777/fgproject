/*    */ package com.fgoa.web.controller;
/*    */ 
/*    */ import com.fgoa.web.model.Conference;
/*    */ import org.apache.commons.lang.StringUtils;
/*    */ 
/*    */ public class ConferenceController extends com.jfinal.core.Controller
/*    */ {
/*    */   public void index()
/*    */   {
/* 10 */     setAttr("num1", Long.valueOf(Conference.dao.queryConferenceCount("1")));
/* 11 */     setAttr("num2", Long.valueOf(Conference.dao.queryConferenceCount("2")));
/* 12 */     setAttr("num3", Long.valueOf(Conference.dao.queryConferenceCount("3")));
/* 13 */     setAttr("num4", Long.valueOf(Conference.dao.queryConferenceCount("4")));
/* 14 */     render("conference.ftl");
/*    */   }
/*    */   
/*    */   public void list() {
/* 18 */     String roomType = getPara("roomType");
/* 19 */     if ((StringUtils.isBlank(roomType)) || (!StringUtils.equals("1", roomType)) || 
/* 20 */       (!StringUtils.equals("2", roomType)) || 
/* 21 */       (!StringUtils.equals("3", roomType)) || 
/* 22 */       (!StringUtils.equals("4", roomType))) {
/* 23 */       redirect("/conference");
/*    */     }
/* 25 */     setAttr("conferences", 
/* 26 */       Conference.dao.findConferenceByRoomType(roomType));
/* 27 */     setAttr("roomType", roomType);
/* 28 */     render("conference_list.ftl");
/*    */   }
/*    */ }


/* Location:              E:\aaa\front\WEB-INF\classes\!\com\fgoa\web\controller\ConferenceController.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */