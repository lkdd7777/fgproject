/*    */ package com.fgoa.web.vo;
/*    */ 
/*    */ import java.util.Calendar;
/*    */ import java.util.Date;
/*    */ 
/*    */ public class CalendarVo
/*    */ {
/*    */   private int max;
/*    */   private int startWeek;
/*    */   private int current;
/*    */   private int year;
/*    */   private int month;
/*    */   private int weekNum;
/*    */   
/*    */   public CalendarVo()
/*    */   {
/* 17 */     Date current = new Date();
/* 18 */     Calendar c = Calendar.getInstance(java.util.Locale.CHINA);
/* 19 */     c.setTime(current);
/* 20 */     setCurrent(c.get(5));
/* 21 */     c.set(5, 1);
/* 22 */     setStartWeek(c.get(7));
/* 23 */     setMax(c.getActualMaximum(5));
/* 24 */     setYear(c.get(1));
/* 25 */     setMonth(c.get(2) + 1);
/* 26 */     setWeekNum(c.getActualMaximum(4));
/*    */   }
/*    */   
/*    */   public CalendarVo(Date date) {
/* 30 */     Calendar c = Calendar.getInstance(java.util.Locale.CHINA);
/* 31 */     c.setTime(date);
/* 32 */     setCurrent(c.get(5));
/* 33 */     c.set(5, 1);
/* 34 */     setStartWeek(c.get(7));
/* 35 */     setMax(c.getActualMaximum(5));
/* 36 */     setYear(c.get(1));
/* 37 */     setMonth(c.get(2) + 1);
/* 38 */     setWeekNum(c.getActualMaximum(4));
/*    */   }
/*    */   
/*    */   public int getMax() {
/* 42 */     return this.max;
/*    */   }
/*    */   
/*    */   public void setMax(int max) {
/* 46 */     this.max = max;
/*    */   }
/*    */   
/*    */   public int getStartWeek() {
/* 50 */     return this.startWeek;
/*    */   }
/*    */   
/*    */   public void setStartWeek(int startWeek) {
/* 54 */     this.startWeek = startWeek;
/*    */   }
/*    */   
/*    */   public int getCurrent() {
/* 58 */     return this.current;
/*    */   }
/*    */   
/*    */   public void setCurrent(int current) {
/* 62 */     this.current = current;
/*    */   }
/*    */   
/*    */   public int getYear() {
/* 66 */     return this.year;
/*    */   }
/*    */   
/*    */   public void setYear(int year) {
/* 70 */     this.year = year;
/*    */   }
/*    */   
/*    */   public int getMonth() {
/* 74 */     return this.month;
/*    */   }
/*    */   
/*    */   public void setMonth(int month) {
/* 78 */     this.month = month;
/*    */   }
/*    */   
/*    */   public static void main(String[] args) {
/* 82 */     CalendarVo c = new CalendarVo();
/* 83 */     System.out.println(c);
/*    */   }
/*    */   
/*    */   public int getWeekNum() {
/* 87 */     return this.weekNum;
/*    */   }
/*    */   
/*    */   public void setWeekNum(int weekNum) {
/* 91 */     this.weekNum = weekNum;
/*    */   }
/*    */ }


/* Location:              E:\aaa\front\WEB-INF\classes\!\com\fgoa\web\vo\CalendarVo.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */