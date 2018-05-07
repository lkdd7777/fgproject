/*    */ package com.fgoa.web.model;
/*    */ 
/*    */ import java.util.List;
/*    */ 
/*    */ public class InboxInfoOpinion extends com.jfinal.plugin.activerecord.Model<InboxInfoOpinion>
/*    */ {
/*  7 */   public static final InboxInfoOpinion dao = new InboxInfoOpinion();
/*    */   
/*    */   public InboxInfoOpinion findSingleOpinionById(String inboxInfoId) {
/* 10 */     String sql = "select * from t_oa_inbox_opinion where inboxId =?";
/* 11 */     return (InboxInfoOpinion)dao.findFirst(sql, 
/* 12 */       new Object[] { inboxInfoId });
/*    */   }
/*    */   
/*    */   public List<InboxInfoOpinion> findOpinionsById(String inboxInfoId) {
/* 16 */     String sql = "select * from t_oa_inbox_opinion where inboxId =?";
/* 17 */     return dao.find(sql, new Object[] { inboxInfoId });
/*    */   }
/*    */ }


/* Location:              E:\aaa\front\WEB-INF\classes\!\com\fgoa\web\model\InboxInfoOpinion.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */