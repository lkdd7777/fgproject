/*    */ package com.fgoa.web.controller.weixin;
/*    */ 
/*    */ import com.fgoa.web.model.Announcement;
/*    */ import com.fgoa.web.vo.AnnouncementVo;
/*    */ 
/*    */ public class AnnoController extends com.jfinal.core.Controller
/*    */ {
/*    */   public void index()
/*    */   {
/* 10 */     setAttr("announceList", 
/* 11 */       Announcement.dao.findAnnouncement());
/* 12 */     render("announce_result.ftl");
/*    */   }
/*    */   
/*    */   public void detail() {
/* 16 */     String id = getPara("id");
/* 17 */     Announcement a = (Announcement)Announcement.dao.findById(id);
/*    */     
/* 19 */     AnnouncementVo vo = new AnnouncementVo();
/*    */     
/* 21 */     String conent = a.getStr("content");
/* 22 */     vo.setContent(conent);
/* 23 */     setAttr("announce", a);
/* 24 */     render("announce_detail.ftl");
/*    */   }
/*    */ }


/* Location:              E:\aaa\front\WEB-INF\classes\!\com\fgoa\web\controller\weixin\AnnoController.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */