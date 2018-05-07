/*    */ package com.fgoa.web.controller;
/*    */ 
/*    */ import com.fgoa.web.model.Announcement;
/*    */ import com.fgoa.web.security.ShiroUtils;
/*    */ import com.jfinal.core.Controller;
/*    */ import com.jfinal.plugin.activerecord.Db;
/*    */ 
/*    */ public class AnnouncementController extends Controller
/*    */ {
/*    */   public void index()
/*    */   {
/* 12 */     setAttr("announceList", Announcement.dao.findAnnouncement());
/* 13 */     render("announcement.ftl");
/*    */   }
/*    */   
/*    */   public void detail() {
/* 17 */     String id = getPara("id");
/* 18 */     if (org.apache.commons.lang.StringUtils.isBlank(id)) {
/* 19 */       renderError(404);
/* 20 */       return;
/*    */     }
/*    */     
/* 23 */     Announcement result = (Announcement)Announcement.dao.findById(id);
/* 24 */     Db.update("update t_oa_announce_user as t set t.isReaded= ?  where user_id=? and announce_id =?", new Object[] { Boolean.valueOf(true), ShiroUtils.getCurrentUserId(), id });
/* 25 */     setAttr("announcement", result);
/* 26 */     render("anno_content.ftl");
/*    */   }
/*    */ }


/* Location:              E:\aaa\front\WEB-INF\classes\!\com\fgoa\web\controller\AnnouncementController.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */