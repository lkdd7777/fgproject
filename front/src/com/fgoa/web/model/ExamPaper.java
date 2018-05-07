/*    */ package com.fgoa.web.model;
/*    */ 
/*    */ import java.io.PrintStream;
/*    */ import java.util.Calendar;
/*    */ import java.util.Date;
/*    */ import java.util.List;
/*    */ 
/*    */ public class ExamPaper extends com.jfinal.plugin.activerecord.Model<ExamPaper>
/*    */ {
/* 10 */   public static ExamPaper dao = new ExamPaper();
/*    */   
/*    */   public void updateValidatePaper() {
/* 13 */     List<ExamPaper> list = dao.find(
/* 14 */       "select * from t_oa_exam_paper where iscomplete=?", 
/* 15 */       new Object[] { "N" });
/* 16 */     for (ExamPaper e : list) {
/* 17 */       Date endTime = e.getTimestamp("starttime");
/* 18 */       Calendar c = Calendar.getInstance();
/* 19 */       c.setTime(endTime);
/* 20 */       c.add(12, e.getInt("timeAllow").intValue());
/*    */       
/* 22 */       Date now = new Date();
/* 23 */       if (now.after(c.getTime()))
/*    */       {
/* 25 */         ((ExamPaper)((ExamPaper)e.set("iscomplete", "Y")).set("endtime", now)).update();
/*    */       }
/*    */     }
/*    */   }
/*    */   
/*    */   public static void main(String[] args) {
/* 31 */     Date d = new Date(1414683375000L);
/* 32 */     System.out.println(d);
/* 33 */     Date d1 = new Date(1414638519003L);
/* 34 */     System.out.println(d1);
/*    */   }
/*    */ }


/* Location:              E:\aaa\front\WEB-INF\classes\!\com\fgoa\web\model\ExamPaper.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */