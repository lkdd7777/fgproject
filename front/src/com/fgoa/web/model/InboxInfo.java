/*    */ package com.fgoa.web.model;
/*    */ 
/*    */ import com.fgoa.web.security.ShiroUtils;
/*    */ import com.jfinal.plugin.activerecord.Db;
/*    */ import com.jfinal.plugin.activerecord.Record;
/*    */ import java.io.PrintStream;
/*    */ import java.util.ArrayList;
/*    */ import java.util.Date;
/*    */ import java.util.List;
/*    */ import org.apache.commons.lang.StringUtils;
/*    */ 
/*    */ public class InboxInfo extends com.jfinal.plugin.activerecord.Model<InboxInfo>
/*    */ {
/* 14 */   public static final InboxInfo dao = new InboxInfo();
/*    */   
/*    */   public List<InboxInfo> findInboxListByStatus(int inboxInfoStatus) {
/* 17 */     String sql = "select * from t_oa_inbox where status = ? order by submitDate desc";
/* 18 */     return dao.find(sql, new Object[] { Integer.valueOf(inboxInfoStatus) });
/*    */   }
/*    */   
/*    */   public List<InboxInfo> findInboxListNotByStatus(int inboxInfoStatus)
/*    */   {
/* 23 */     String sql = "select t.*,(select COUNT(1) from t_oa_inbox_user_rel t2 where t2.inboxid = t.id and t2.isreaded = 0 ) as readedCount from t_oa_inbox t where status <> ? order by submitDate desc";
/* 24 */     return dao.find(sql, new Object[] { Integer.valueOf(inboxInfoStatus) });
/*    */   }
/*    */   
/*    */   public List<InboxInfo> findInboxListByTitleAndStatus(String title, Date startTime, Date endTime, int inboxInfoStatus)
/*    */   {
/* 29 */     List<Object> params = new ArrayList();
/* 30 */     params.add(Integer.valueOf(inboxInfoStatus));
/* 31 */     StringBuilder sql = new StringBuilder(
/* 32 */       "select * from t_oa_inbox where status = ?");
/* 33 */     if (StringUtils.isNotBlank(title)) {
/* 34 */       sql.append(" and title like '%" + title + "%'");
/*    */     }
/* 36 */     if (startTime != null) {
/* 37 */       sql.append(" and submitDate >=?");
/* 38 */       params.add(startTime);
/*    */     }
/* 40 */     if (endTime != null) {
/* 41 */       sql.append(" and submitDate <= ?");
/* 42 */       params.add(endTime);
/*    */     }
/* 44 */     sql.append(" order by submitDate desc");
/* 45 */     return dao.find(sql.toString(), params.toArray());
/*    */   }
/*    */   
/*    */   public List<Record> findLeaderReadList(String userId) {
/* 49 */     String sql = "select * from t_oa_inbox t,t_oa_inbox_user_rel r where t.id = r.inboxId and r.userId = ? and leaderId=? order by submitDate desc";
/* 50 */     return Db.find(sql, new Object[] { userId, userId });
/*    */   }
/*    */   
/*    */   public long findLeaderInboxCount() {
/* 54 */     String userId = ShiroUtils.getCurrentUserId();
/*    */     
/* 56 */     String sql = "select count(*) from t_oa_inbox where (status=? or status=?) and leaderId=?";
/* 57 */     return 
/* 58 */       Db.queryLong(
/* 59 */       sql, 
/* 60 */       new Object[] { Integer.valueOf(0), Integer.valueOf(2), 
/* 61 */       userId }).longValue();
/*    */   }
/*    */   
/*    */   public List<InboxInfo> findMemberReadList(String userId) {
/* 65 */     if (StringUtils.isBlank(userId)) {
/* 66 */       return null;
/*    */     }
/*    */     
/* 69 */     String sql = "select p.id as id, p.title as title ,p.statusInfo as statusInfo ,p.submitDate as submitDate,pu.active,pu.isReaded,p.replyed as replyed from t_oa_inbox as p ,t_oa_inbox_user_rel as pu where p.id=pu.inboxId and  pu.userId=? order by p.submitDate desc";
/*    */     
/* 71 */     return dao.find(sql, new Object[] { userId });
/*    */   }
/*    */   
/*    */   public long findMemberInboxCount() {
/* 75 */     String userId = ShiroUtils.getCurrentUserId();
/*    */     
/* 77 */     String sql = "select COUNT(*) from t_oa_inbox as p ,t_oa_inbox_user_rel as pu where p.id=pu.inboxId and  pu.userId=? and pu.isReaded=?;";
/* 78 */     return Db.queryLong(sql, new Object[] { userId, Integer.valueOf(0) })
/* 79 */       .longValue();
/*    */   }
/*    */   
/*    */   public static void main(String[] args) {
/* 83 */     System.out.println(new Date().toString());
/*    */   }
/*    */ }


/* Location:              E:\aaa\front\WEB-INF\classes\!\com\fgoa\web\model\InboxInfo.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */