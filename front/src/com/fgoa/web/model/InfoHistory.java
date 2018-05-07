/*    */ package com.fgoa.web.model;
/*    */ 
/*    */ import com.jfinal.plugin.activerecord.Db;
/*    */ import com.jfinal.plugin.activerecord.Model;
/*    */ import com.jfinal.plugin.activerecord.Record;
/*    */ import java.util.List;
/*    */ import org.apache.commons.lang.StringUtils;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class InfoHistory
/*    */   extends Model<InfoHistory>
/*    */ {
/*    */   private static final long serialVersionUID = 4521243874573220216L;
/* 18 */   public static final InfoHistory dao = new InfoHistory();
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public List<Record> findInfoHistory(String postId)
/*    */   {
/* 26 */     if (StringUtils.isNotBlank(postId)) {
/* 27 */       String sql = "select a.* from  tbl_info_history a where a.info_id = ? order by create_time desc";
/*    */       
/* 29 */       return Db.find(sql, new Object[] { postId });
/*    */     }
/* 31 */     return null;
/*    */   }
/*    */ }


/* Location:              E:\aaa\front\WEB-INF\classes\!\com\fgoa\web\model\InfoHistory.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */