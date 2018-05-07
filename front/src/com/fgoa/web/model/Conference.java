/*    */ package com.fgoa.web.model;
/*    */ 
/*    */ import com.fgoa.web.utils.OaDateUtils;
/*    */ import com.fgoa.web.vo.CommonDate;
/*    */ import com.fgoa.web.vo.ConferenceVo;
/*    */ import com.jfinal.plugin.activerecord.Db;
/*    */ import com.jfinal.plugin.activerecord.Model;
/*    */ import com.jfinal.plugin.activerecord.Record;
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ 
/*    */ public class Conference extends Model<Conference>
/*    */ {
/* 14 */   public static Conference dao = new Conference();
/*    */   
/*    */   public List<ConferenceVo> findConferenceByRoomType(String roomType) {
/* 17 */     if (org.apache.commons.lang.StringUtils.isBlank(roomType)) {
/* 18 */       return null;
/*    */     }
/* 20 */     List<ConferenceVo> returnValue = new ArrayList();
/*    */     
/* 22 */     String sql = "SELECT * FROM `t_oa_conference` as c where c.executetime>now() and c.roomtype=? ORDER BY executetime ASC";
/* 23 */     List<Record> result = Db.find(sql, new Object[] { roomType });
/* 24 */     for (Record c : result) {
/* 25 */       ConferenceVo vo = new ConferenceVo();
/* 26 */       vo.setContent(c.getStr("content"));
/* 27 */       vo.setDepartName(c.getStr("usersName") + "," + 
/* 28 */         c.getStr("departsName"));
/* 29 */       CommonDate cd = OaDateUtils.getCommonDate(c
/* 30 */         .getTimestamp("executetime"));
/*    */       
/* 32 */       vo.setWeek(cd.getWeek());
/* 33 */       vo.setNoon(cd.getNoon());
/* 34 */       vo.setDate(cd.getDate());
/* 35 */       vo.setTime(cd.getTime());
/* 36 */       vo.setMasterDepartName(c.getStr("masterDepartName"));
/*    */       
/* 38 */       returnValue.add(vo);
/*    */     }
/* 40 */     return returnValue;
/*    */   }
/*    */   
/*    */   public long queryConferenceCount(String roomtype) {
/* 44 */     String sql = "SELECT count(*) FROM `t_oa_conference` where executetime>now() and roomtype= ?";
/* 45 */     return Db.queryLong(sql, new Object[] { roomtype }).longValue();
/*    */   }
/*    */   
/*    */   public long queryConferenceCount() {
/* 49 */     String sql = "SELECT count(*) FROM `t_oa_conference` where executetime>now()";
/* 50 */     return Db.queryLong(sql).longValue();
/*    */   }
/*    */ }


/* Location:              E:\aaa\front\WEB-INF\classes\!\com\fgoa\web\model\Conference.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */