/*    */ package com.fgoa.web.model;
/*    */ 
/*    */ import com.fgoa.web.security.ShiroRealmUser;
/*    */ import com.fgoa.web.security.ShiroUtils;
/*    */ import com.fgoa.web.utils.HtmlUtils;
/*    */ import com.fgoa.web.utils.OaDateUtils;
/*    */ import com.fgoa.web.vo.AnnouncementVo;
/*    */ import com.fgoa.web.vo.CommonDate;
/*    */ import com.jfinal.plugin.activerecord.Db;
/*    */ import com.jfinal.plugin.activerecord.Record;
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import org.apache.commons.lang.StringUtils;
/*    */ 
/*    */ public class Announcement extends com.jfinal.plugin.activerecord.Model<Announcement>
/*    */ {
/* 17 */   public static final Announcement dao = new Announcement();
/*    */   
/*    */   public List<AnnouncementVo> findAnnouncement() {
/* 20 */     List<AnnouncementVo> returnValue = new ArrayList();
/*    */     
/* 22 */     String sql = "SELECT * FROM `t_oa_announcement` as c where c.invalidtime>now() ORDER BY invalidtime asc";
/*    */     
/* 24 */     List<Record> result = Db.find(sql);
/* 25 */     for (Record c : result) {
/* 26 */       AnnouncementVo vo = new AnnouncementVo();
/* 27 */       vo.setId(c.getStr("id"));
/*    */       
/* 29 */       String conent = c.getStr("content");
/* 30 */       vo.setContent(conent);
/* 31 */       vo.setSimpleContent(HtmlUtils.getPureTextFromHtml(conent));
/* 32 */       vo.setTitle(c.getStr("title"));
/* 33 */       vo.setDepartName(c.getStr("usersName") + "," + 
/* 34 */         c.getStr("departsName"));
/* 35 */       CommonDate cd = OaDateUtils.getCommonDate(c
/* 36 */         .getTimestamp("validtime"));
/*    */       
/* 38 */       vo.setWeek(cd.getWeek());
/* 39 */       vo.setNoon(cd.getNoon());
/* 40 */       vo.setDate(cd.getDate());
/* 41 */       vo.setTime(cd.getTime());
/* 42 */       vo.setType(c.getStr("type"));
/* 43 */       vo.setEndTime(OaDateUtils.getCommonDate(c
/* 44 */         .getTimestamp("invalidtime")));
/*    */       
/* 46 */       vo.setMasterDepartName(c.getStr("masterDepartName"));
/*    */       
/* 48 */       vo.setShowEndTime(c.getBoolean("showEndTime"));
/*    */       
/* 50 */       returnValue.add(vo);
/*    */     }
/* 52 */     return returnValue;
/*    */   }
/*    */   
/*    */   public long queryAnnouncementCount() {
/* 56 */     String userId = ShiroUtils.getCurrentUser().getId();
/* 57 */     if (StringUtils.isBlank(userId)) {
/* 58 */       return 0L;
/*    */     }
/* 60 */     String sql = "SELECT count(*) FROM `t_oa_announcement` as c ,`t_oa_announce_user` as r where c.id =r.announce_id and c.invalidtime>now() and r.user_id=? and r.isReaded=0";
/*    */     
/* 62 */     return Db.queryLong(sql, new Object[] { userId }).longValue();
/*    */   }
/*    */ }


/* Location:              E:\aaa\front\WEB-INF\classes\!\com\fgoa\web\model\Announcement.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */