/*    */ package com.fgoa.web.model;
/*    */ 
/*    */ import com.fgoa.web.security.ShiroUtils;
/*    */ import com.jfinal.plugin.activerecord.Db;
/*    */ import java.util.List;
/*    */ 
/*    */ public class PetitionInfo extends com.jfinal.plugin.activerecord.Model<PetitionInfo>
/*    */ {
/*  9 */   public static final PetitionInfo dao = new PetitionInfo();
/*    */   
/*    */   public List<PetitionInfo> findListByStatus(int status) {
/* 12 */     String sql = "select * from t_oa_petition where status = ? order by submitDate desc";
/* 13 */     return dao.find(sql, new Object[] { Integer.valueOf(status) });
/*    */   }
/*    */   
/*    */   public List<PetitionInfo> findPetitionListByTitleAndStatus(String title, int status)
/*    */   {
/* 18 */     String sql = "select * from t_oa_petition where status = ? and title like '% " + 
/* 19 */       title + "%' order by submitDate desc";
/*    */     
/* 21 */     return dao.find(sql, new Object[] { Integer.valueOf(status) });
/*    */   }
/*    */   
/*    */   public List<PetitionInfo> findMemberReadList(String userId) {
/* 25 */     String sql = "select p.id as id, p.title as title ,p.statusInfo as statusInfo ,p.submitDate as submitDate,pu.active,pu.isReaded,p.replyed as replyed from t_oa_petition as p ,t_oa_petition_user_rel as pu where p.id=pu.petitionId and  pu.userId=? and p.`status` <> ? order by p.submitDate desc";
/* 26 */     return dao.find(sql, new Object[] { userId, Integer.valueOf(1) });
/*    */   }
/*    */   
/*    */   public long findMemberReadCount() {
/* 30 */     String userId = ShiroUtils.getCurrentUserId();
/*    */     
/* 32 */     String sql = "select COUNT(*) from t_oa_petition as p ,t_oa_petition_user_rel as pu where p.id=pu.petitionId and  pu.userId=? and pu.isReaded=?;";
/* 33 */     return Db.queryLong(sql, new Object[] { userId, Integer.valueOf(0) })
/* 34 */       .longValue();
/*    */   }
/*    */   
/*    */   public boolean isPetitionRel(String petitionId) {
/* 38 */     PetitionInfo p = 
/* 39 */       (PetitionInfo)dao.findFirst(
/* 40 */       "SELECT * from t_oa_petition_user_rel where userId =? and petitionId=?", 
/* 41 */       new Object[] { ShiroUtils.getCurrentUserId(), 
/* 42 */       petitionId });
/* 43 */     if (p != null) {
/* 44 */       return true;
/*    */     }
/* 46 */     return false;
/*    */   }
/*    */ }


/* Location:              E:\aaa\front\WEB-INF\classes\!\com\fgoa\web\model\PetitionInfo.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */