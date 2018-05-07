/*    */ package com.fgoa.web.job;
/*    */ 
/*    */ import com.fgoa.web.model.ExamPaper;
/*    */ import java.io.PrintStream;
/*    */ import java.util.Date;
/*    */ import org.quartz.Job;
/*    */ import org.quartz.JobExecutionContext;
/*    */ import org.quartz.JobExecutionException;
/*    */ 
/*    */ public class JobA implements Job
/*    */ {
/* 12 */   static int callTime = 0;
/*    */   
/*    */   public void execute(JobExecutionContext arg0) throws JobExecutionException
/*    */   {
/* 16 */     System.out.println("update" + new Date());
/* 17 */     ExamPaper.dao.updateValidatePaper();
/*    */   }
/*    */ }


/* Location:              E:\aaa\front\WEB-INF\classes\!\com\fgoa\web\job\JobA.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */