/*    */ package com.fgoa.web.model;
/*    */ 
/*    */ import com.jfinal.plugin.activerecord.Model;
/*    */ 
/*    */ public class PetitionInfoUserRel extends Model<PetitionInfoUserRel> {
/*  6 */   public static final PetitionInfoUserRel dao = new PetitionInfoUserRel();
/*    */   
/*    */   public PetitionInfoUserRel findByUserIdAndInfoId(String userId, String infoId)
/*    */   {
/* 10 */     String sql = "select * from t_oa_petition_user_rel where userId = ? and petitionId=?";
/* 11 */     return (PetitionInfoUserRel)dao.findFirst(sql, new Object[] { userId, 
/* 12 */       infoId });
/*    */   }
/*    */ }


/* Location:              E:\aaa\front\WEB-INF\classes\!\com\fgoa\web\model\PetitionInfoUserRel.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */