/*    */ package com.fgoa.web.model;
/*    */ 
/*    */ import com.jfinal.plugin.activerecord.Model;
/*    */ import java.text.DecimalFormat;
/*    */ import java.util.Date;
/*    */ 
/*    */ public class SerialNumber extends Model<SerialNumber>
/*    */ {
/*  9 */   public static SerialNumber dao = new SerialNumber();
/*    */   public static final int INBOX_TYPE = 0;
/*    */   public static final int POST_TYPE = 1;
/*    */   public static final int PETITION_TYPE = 2;
/*    */   
/*    */   public String getInboxSeralNum() {
/* 15 */     return generateDateString(0);
/*    */   }
/*    */   
/*    */   public String getPostSerialNum() {
/* 19 */     return generateDateString(1);
/*    */   }
/*    */   
/*    */   public String getPetitionSerialNum() {
/* 23 */     return generateDateString(2);
/*    */   }
/*    */   
/*    */   private String generateDateString(int type) {
/* 27 */     Date date = new Date();
/* 28 */     String dateStr = org.apache.commons.lang.time.DateFormatUtils.format(date, "yyyyMMdd");
/* 29 */     SerialNumber result = (SerialNumber)dao.findFirst(
/* 30 */       "select * from t_oa_order where dateStr = ? and type= ?", 
/* 31 */       new Object[] { dateStr, Integer.valueOf(type) });
/*    */     
/* 33 */     String tag = "";
/* 34 */     if (type == 0) {
/* 35 */       tag = "s";
/* 36 */     } else if (type == 1) {
/* 37 */       tag = "f";
/* 38 */     } else if (type == 2) {
/* 39 */       tag = "x";
/*    */     }
/* 41 */     if (result == null)
/*    */     {
/*    */ 
/*    */ 
/* 45 */       ((SerialNumber)((SerialNumber)((SerialNumber)new SerialNumber().set("dateStr", dateStr)).set("type", Integer.valueOf(type))).set("order", Integer.valueOf(1))).save();
/*    */       
/* 47 */       return dateStr + tag + "001";
/*    */     }
/* 49 */     return 
/*    */     
/* 51 */       dateStr + tag + new DecimalFormat("000").format(result.getInt("order")
/* 52 */       .intValue() + 1);
/*    */   }
/*    */ }


/* Location:              E:\aaa\front\WEB-INF\classes\!\com\fgoa\web\model\SerialNumber.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */