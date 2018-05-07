/*    */ package com.fgoa.web.model;
/*    */ 
/*    */ import java.util.List;
/*    */ 
/*    */ public class AddonFile extends com.jfinal.plugin.activerecord.Model<AddonFile>
/*    */ {
/*  7 */   public static AddonFile dao = new AddonFile();
/*    */   
/*    */   public List<AddonFile> findById(String id) {
/* 10 */     return dao.find("select * from t_oa_file where refid= ?", 
/* 11 */       new Object[] { id });
/*    */   }
/*    */ }


/* Location:              E:\aaa\front\WEB-INF\classes\!\com\fgoa\web\model\AddonFile.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */