/*    */ package com.fgoa.web.model;
/*    */ 
/*    */ import java.util.List;
/*    */ 
/*    */ public class Depart extends com.jfinal.plugin.activerecord.Model<Depart>
/*    */ {
/*  7 */   public static Depart dao = new Depart();
/*    */   
/*    */   public List<Depart> findChargeDeparts(String userId) {
/* 10 */     String sql = "select d.* from t_s_depart as d,t_oa_inbox_user_org as uo where d.isValid=1 and uo.orgId=d.ID and uo.userId=?";
/* 11 */     return dao.find(sql, new Object[] { userId });
/*    */   }
/*    */   
/*    */   public List<Depart> findAll() {
/* 15 */     return dao.find("select * from t_s_depart where isValid=1");
/*    */   }
/*    */   
/*    */   public List<Depart> findAllAndUser() {
/* 19 */     return dao.find("select d.*,u.realname from t_s_depart as d,t_oa_inbox_user_org as uo , t_s_base_user  as u where d.isValid=1 and uo.orgId=d.ID and u.id = uo.userId");
/*    */   }
/*    */ }


/* Location:              E:\aaa\front\WEB-INF\classes\!\com\fgoa\web\model\Depart.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */