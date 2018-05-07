/*    */ package com.fgoa.web.model;
/*    */ 
/*    */ import com.jfinal.plugin.activerecord.Model;
/*    */ import java.util.List;
/*    */ import org.apache.commons.lang.StringUtils;
/*    */ 
/*    */ public class InboxInfoUserRel
/*    */   extends Model<InboxInfoUserRel>
/*    */ {
/* 10 */   public static final InboxInfoUserRel dao = new InboxInfoUserRel();
/*    */   
/*    */   public InboxInfoUserRel findByUserIdAndInfoId(String userId, String infoId) {
/* 13 */     String sql = "select * from t_oa_inbox_user_rel where userId = ? and inboxId=?";
/* 14 */     return (InboxInfoUserRel)dao.findFirst(sql, new Object[] { userId, 
/* 15 */       infoId });
/*    */   }
/*    */   
/*    */   public List<InboxInfoUserRel> findByInboxInfoId(String inboxInfoId) {
/* 19 */     if (StringUtils.isNotBlank(inboxInfoId)) {
/* 20 */       String sql = "select a.*,b.realname from t_oa_inbox_user_rel a,t_s_base_user b where a.userId = b.id and inboxid = ?";
/* 21 */       return dao.find(sql, new Object[] { inboxInfoId });
/*    */     }
/* 23 */     return null;
/*    */   }
/*    */ }


/* Location:              E:\aaa\front\WEB-INF\classes\!\com\fgoa\web\model\InboxInfoUserRel.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */