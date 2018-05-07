/*    */ package com.fgoa.web.model;
/*    */ 
/*    */ import com.jfinal.plugin.activerecord.Model;
/*    */ 
/*    */ public class PostUserRel extends Model<PostUserRel> {
/*  6 */   public static final PostUserRel dao = new PostUserRel();
/*    */   
/*    */   public PostUserRel findByUserIdAndInfoId(String userId, String infoId) {
/*  9 */     String sql = "select * from t_oa_post_user_rel where userid = ? and postid=?";
/* 10 */     return 
/* 11 */       (PostUserRel)dao.findFirst(sql, new Object[] { userId, infoId });
/*    */   }
/*    */ }


/* Location:              E:\aaa\front\WEB-INF\classes\!\com\fgoa\web\model\PostUserRel.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */