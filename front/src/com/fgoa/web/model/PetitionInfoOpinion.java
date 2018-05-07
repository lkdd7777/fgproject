/*    */ package com.fgoa.web.model;
/*    */ 
/*    */ import java.util.List;
/*    */ 
/*    */ public class PetitionInfoOpinion extends com.jfinal.plugin.activerecord.Model<PetitionInfoOpinion>
/*    */ {
/*  7 */   public static final PetitionInfoOpinion dao = new PetitionInfoOpinion();
/*    */   
/*    */   public PetitionInfoOpinion findSingleOpinionById(String petitionInfoId, String userId)
/*    */   {
/* 11 */     String sql = "select * from t_oa_petition_opinion where petitionId =? and userId=?";
/* 12 */     return (PetitionInfoOpinion)dao.findFirst(sql, new Object[] {
/* 13 */       petitionInfoId, userId });
/*    */   }
/*    */   
/*    */   public List<PetitionInfoOpinion> findOpinionsById(String petitionInfoId) {
/* 17 */     String sql = "select * from t_oa_petition_opinion where petitionId =?";
/* 18 */     return dao.find(sql, new Object[] { petitionInfoId });
/*    */   }
/*    */   
/*    */   public List<PetitionInfoOpinion> findOthersOpinionsById(String petitionInfoId, String userId)
/*    */   {
/* 23 */     String sql = "select * from t_oa_petition_opinion where petitionId =? and userId<>?";
/* 24 */     return dao.find(sql, new Object[] { petitionInfoId, userId });
/*    */   }
/*    */ }


/* Location:              E:\aaa\front\WEB-INF\classes\!\com\fgoa\web\model\PetitionInfoOpinion.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */