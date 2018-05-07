/*    */ package com.fgoa.web.model;
/*    */ 
/*    */ import com.fgoa.web.security.ShiroUtils;
/*    */ import com.jfinal.plugin.activerecord.Db;
/*    */ import com.jfinal.plugin.activerecord.Model;
/*    */ import com.jfinal.plugin.activerecord.Record;
/*    */ import java.util.ArrayList;
/*    */ import java.util.Calendar;
/*    */ import java.util.Date;
/*    */ import java.util.List;
/*    */ import org.apache.commons.lang.StringUtils;
/*    */ 
/*    */ 
/*    */ public class PostInfo
/*    */   extends Model<PostInfo>
/*    */ {
/* 17 */   public static final PostInfo dao = new PostInfo();
/*    */   
/*    */   public List<Record> findUserPost(String userId) {
/* 20 */     if (StringUtils.isNotBlank(userId)) {
/* 21 */       String sql = "select p.status,p.statusInfo,p.id,p.title,pu.active as active,pu.isReaded from t_oa_post as p , t_oa_post_user_rel as pu where p.id=pu.postid and pu.userid=? order by submitTime desc";
/*    */       
/* 23 */       return Db.find(sql, new Object[] { userId });
/*    */     }
/* 25 */     return null;
/*    */   }
/*    */   
/*    */   public List<PostInfo> findUserPostByStr(Date startTime, Date endTime, String queryStr, String sortNumStr)
/*    */   {
/* 30 */     List<Object> params = new ArrayList();
/* 31 */     params.add(ShiroUtils.getCurrentUserId());
/*    */     
/* 33 */     StringBuilder sql = new StringBuilder(
/* 34 */       "select p.* from t_oa_post as p , t_oa_post_user_rel as pu where p.id=pu.postid and pu.userid=?");
/*    */     
/* 36 */     Calendar cal = Calendar.getInstance();
/* 37 */     if (startTime != null) {
/* 38 */       sql.append(" and submitTime >=?");
/* 39 */       params.add(startTime);
/*    */     }
/* 41 */     if (endTime != null) {
/* 42 */       cal.setTime(endTime);
/* 43 */       cal.set(10, 23);
/* 44 */       cal.set(12, 59);
/* 45 */       cal.set(13, 59);
/*    */       
/* 47 */       sql.append(" and submitTime <= ?");
/* 48 */       params.add(cal.getTime());
/*    */     }
/* 50 */     if (StringUtils.isNotBlank(queryStr)) {
/* 51 */       sql.append(" and title like '%" + queryStr + "%'");
/*    */     }
/* 53 */     if (StringUtils.isNotBlank(sortNumStr)) {
/* 54 */       sql.append(" and sortNum like '%" + sortNumStr + "%'");
/*    */     }
/* 56 */     sql.append(" order by submitTime desc");
/*    */     
/* 58 */     return dao.find(sql.toString(), params.toArray());
/*    */   }
/*    */   
/*    */   public long findUserPostCount() {
/* 62 */     String sql = "select COUNT(DISTINCT(p.id)) from `t_oa_post` as p , `t_oa_post_user_rel` as pu where p.id=pu.postid and pu.userid=? and pu.isReaded =?";
/*    */     
/* 64 */     return Db.queryLong(
/* 65 */       sql, 
/* 66 */       new Object[] { ShiroUtils.getCurrentUserId(), 
/* 67 */       Integer.valueOf(0) }).longValue();
/*    */   }
/*    */   
/*    */   public List<PostInfo> findIncompletePost() {
/* 71 */     String sql = "select * from t_oa_post where statusInfo != '收发文管理员' order by submitTime desc";
/* 72 */     return dao.find(sql);
/*    */   }
/*    */   
/*    */   public List<Record> findPostRecord(String postInfoId) {
/* 76 */     String sql = "select t2.realname ,t1.isReaded,t1.active from t_oa_post_user_rel t1,t_s_base_user t2 where t1.userid = t2.ID and t1.postid = ?";
/*    */     
/* 78 */     return Db.find(sql, new Object[] { postInfoId });
/*    */   }
/*    */ }


/* Location:              E:\aaa\front\WEB-INF\classes\!\com\fgoa\web\model\PostInfo.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */