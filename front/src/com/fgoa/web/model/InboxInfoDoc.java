/*    */ package com.fgoa.web.model;
/*    */ 
/*    */ import com.jfinal.plugin.activerecord.Db;
/*    */ import java.util.List;
/*    */ import org.apache.commons.lang.StringUtils;
/*    */ 
/*    */ public class InboxInfoDoc extends com.jfinal.plugin.activerecord.Model<InboxInfoDoc>
/*    */ {
/*  9 */   public static final InboxInfoDoc dao = new InboxInfoDoc();
/*    */   
/*    */   public List<InboxInfoDoc> findByInboxInfoId(String inboxInfoId) {
/* 12 */     if (StringUtils.isNotBlank(inboxInfoId)) {
/* 13 */       String sql = "select * from t_oa_inbox_doc where inboxId =?";
/* 14 */       return dao.find(sql, new Object[] { inboxInfoId });
/*    */     }
/* 16 */     return null;
/*    */   }
/*    */   
/*    */   public InboxInfoDoc findByInboxInfoIdAndIndex(String inboxInfoId, int index) {
/* 20 */     if ((StringUtils.isNotBlank(inboxInfoId)) && (index >= 0)) {
/* 21 */       String sql = "select * from t_oa_inbox_doc where inboxId =? and orderNum =?";
/* 22 */       return (InboxInfoDoc)dao.findFirst(sql, new Object[] {
/* 23 */         inboxInfoId, Integer.valueOf(index) });
/*    */     }
/* 25 */     return null;
/*    */   }
/*    */   
/*    */   public long findDocNum(String inboxInfoId) {
/* 29 */     if (StringUtils.isNotBlank(inboxInfoId)) {
/* 30 */       String sql = "select count(*) from t_oa_inbox_doc where inboxId =?";
/* 31 */       return Db.queryLong(sql, new Object[] { inboxInfoId }).longValue();
/*    */     }
/* 33 */     return 0L;
/*    */   }
/*    */ }


/* Location:              E:\aaa\front\WEB-INF\classes\!\com\fgoa\web\model\InboxInfoDoc.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */