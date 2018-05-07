/*    */ package com.fgoa.vo;
/*    */ 
/*    */ import java.util.Date;
/*    */ import org.jeecgframework.poi.excel.annotation.Excel;
/*    */ import org.jeecgframework.poi.excel.annotation.ExcelTarget;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @ExcelTarget(id="ExamPaperExcelEntity")
/*    */ public class ExamPaperVo
/*    */ {
/*    */   @Excel(exportName="用户名", orderNum="1", needMerge=false)
/*    */   private String userName;
/*    */   @Excel(exportName="科目", orderNum="1", needMerge=false)
/*    */   private String classType;
/*    */   @Excel(exportName="得分", orderNum="1", needMerge=false)
/*    */   private int sccore;
/*    */   @Excel(exportName="开始时间", orderNum="1", needMerge=false)
/*    */   private Date startTime;
/*    */   @Excel(exportName="结束时间", orderNum="1", needMerge=false)
/*    */   private Date endTime;
/*    */   
/*    */   public String getUserName()
/*    */   {
/* 27 */     return this.userName;
/*    */   }
/*    */   
/*    */   public void setUserName(String userName) {
/* 31 */     this.userName = userName;
/*    */   }
/*    */   
/*    */   public String getClassType() {
/* 35 */     return this.classType;
/*    */   }
/*    */   
/*    */   public void setClassType(String classType) {
/* 39 */     this.classType = classType;
/*    */   }
/*    */   
/*    */   public int getSccore() {
/* 43 */     return this.sccore;
/*    */   }
/*    */   
/*    */   public void setSccore(int sccore) {
/* 47 */     this.sccore = sccore;
/*    */   }
/*    */   
/*    */   public Date getStartTime() {
/* 51 */     return this.startTime;
/*    */   }
/*    */   
/*    */   public void setStartTime(Date startTime) {
/* 55 */     this.startTime = startTime;
/*    */   }
/*    */   
/*    */   public Date getEndTime() {
/* 59 */     return this.endTime;
/*    */   }
/*    */   
/*    */   public void setEndTime(Date endTime) {
/* 63 */     this.endTime = endTime;
/*    */   }
/*    */ }


/* Location:              E:\aaa\admin\WEB-INF\classes\!\com\fgoa\vo\ExamPaperVo.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */