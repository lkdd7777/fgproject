/*    */ package com.fgoa.web.model;
/*    */ 
/*    */ import com.jfinal.plugin.activerecord.Db;
/*    */ import java.util.List;
/*    */ import org.apache.commons.lang.StringUtils;
/*    */ 
/*    */ public class PetitionInfoDoc extends com.jfinal.plugin.activerecord.Model<PetitionInfoDoc>
/*    */ {
/*  9 */   public static final PetitionInfoDoc dao = new PetitionInfoDoc();
/*    */   
/*    */   public List<PetitionInfoDoc> findByPetitionInfoId(String petitionInfoId) {
/* 12 */     if (StringUtils.isNotBlank(petitionInfoId)) {
/* 13 */       String sql = "select * from t_oa_petition_doc where petitionId =?";
/* 14 */       return dao.find(sql, new Object[] { petitionInfoId });
/*    */     }
/* 16 */     return null;
/*    */   }
/*    */   
/*    */   public PetitionInfoDoc findByPetitionInfoIdAndIndex(String petitionInfoId, int index)
/*    */   {
/* 21 */     if ((StringUtils.isNotBlank(petitionInfoId)) && (index >= 0)) {
/* 22 */       String sql = "select * from t_oa_petition_doc where petitionId =? and orderNum =?";
/* 23 */       return (PetitionInfoDoc)dao.findFirst(sql, new Object[] {
/* 24 */         petitionInfoId, Integer.valueOf(index) });
/*    */     }
/* 26 */     return null;
/*    */   }
/*    */   
/*    */   public long findDocNum(String petitionInfoId) {
/* 30 */     if (StringUtils.isNotBlank(petitionInfoId)) {
/* 31 */       String sql = "select count(*) from t_oa_petition_doc where petitionId =?";
/* 32 */       return Db.queryLong(sql, new Object[] { petitionInfoId })
/* 33 */         .longValue();
/*    */     }
/* 35 */     return 0L;
/*    */   }
/*    */ }


/* Location:              E:\aaa\front\WEB-INF\classes\!\com\fgoa\web\model\PetitionInfoDoc.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */