/*     */ package test;
/*     */ 
/*     */ import java.io.File;
/*     */ import java.io.PrintStream;
/*     */ import java.sql.Connection;
/*     */ import java.sql.DriverManager;
/*     */ import java.sql.PreparedStatement;
/*     */ import java.sql.ResultSet;
/*     */ import java.sql.SQLException;
/*     */ import java.sql.Statement;
/*     */ import java.util.List;
/*     */ import org.apache.commons.io.FileUtils;
/*     */ import org.apache.commons.io.IOUtils;
/*     */ import org.apache.commons.lang.StringUtils;
/*     */ 
/*     */ public class Data
/*     */ {
/*     */   public static void main(String[] args) throws Exception
/*     */   {}
/*     */   
/*     */   public static void insertData() throws Exception
/*     */   {
/*  23 */     List<String> data = IOUtils.readLines(
/*  24 */       FileUtils.openInputStream(new File("E:\\data collection\\12306.txt")), 
/*  25 */       "GBK");
/*  26 */     StringBuffer sql = new StringBuffer("insert into data values");
/*  27 */     for (int i = 0; i < data.size(); i++) {
/*  28 */       String[] arr = ((String)data.get(i)).split("----");
/*  29 */       sql.append("('").append(arr[0]).append("','").append(arr[1])
/*  30 */         .append("','").append(arr[2]).append("','").append(arr[3])
/*  31 */         .append("','").append(arr[4]).append("','").append(arr[5])
/*  32 */         .append("','").append(arr[6]).append("'),");
/*  33 */       if (i % 100 == 0) {
/*  34 */         sql.deleteCharAt(sql.length() - 1);
/*     */         
/*  36 */         execute(";");
/*  37 */         sql = new StringBuffer("insert into data value");
/*  38 */         System.out.println("插入前" + i + "条记录");
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public static void execute(String sql)
/*     */   {
/*  45 */     Connection con = null;
/*     */     try {
/*  47 */       Class.forName("com.mysql.jdbc.Driver");
/*  48 */       con = 
/*  49 */         DriverManager.getConnection("jdbc:mysql://localhost:3306/data?characterEncoding=utf-8&amp;autoReconnect=true&user=root&password=root");
/*     */       
/*  51 */       Statement stat = con.createStatement();
/*  52 */       stat.execute(sql);
/*     */     } catch (Exception e) {
/*  54 */       if (con != null) {
/*     */         try {
/*  56 */           con.close();
/*     */         } catch (SQLException e1) {
/*  58 */           e1.printStackTrace();
/*     */         }
/*     */       }
/*  61 */       e.printStackTrace();
/*     */     }
/*     */   }
/*     */   
/*     */   public static void query(String name)
/*     */   {
/*  67 */     Connection con = null;
/*     */     try {
/*  69 */       Class.forName("com.mysql.jdbc.Driver");
/*  70 */       con = 
/*  71 */         DriverManager.getConnection("jdbc:mysql://localhost:3306/data?characterEncoding=utf-8&amp;autoReconnect=true&user=root&password=root");
/*     */       
/*  73 */       PreparedStatement stat = con.prepareStatement("select * from data where s3=?");
/*  74 */       stat.setString(1, name);
/*  75 */       ResultSet rs = stat.executeQuery();
/*  76 */       while (rs.next()) {
/*  77 */         System.out.println(rs.getString(4));
/*     */       }
/*     */     } catch (Exception e) {
/*  80 */       if (con != null) {
/*     */         try {
/*  82 */           con.close();
/*     */         } catch (SQLException e1) {
/*  84 */           e1.printStackTrace();
/*     */         }
/*     */       }
/*  87 */       e.printStackTrace();
/*     */     }
/*     */   }
/*     */   
/*     */   public static void queryAll() {
/*  92 */     Connection con = null;
/*     */     try {
/*  94 */       Class.forName("com.mysql.jdbc.Driver");
/*  95 */       con = 
/*  96 */         DriverManager.getConnection("jdbc:mysql://localhost:3306/data?characterEncoding=utf-8&amp;autoReconnect=true&user=root&password=root");
/*     */       
/*  98 */       PreparedStatement stat = con.prepareStatement("select * from data");
/*  99 */       ResultSet rs = stat.executeQuery();
/* 100 */       while (rs.next()) {
/* 101 */         String no = rs.getString("身份证");
/*     */         try {
/* 103 */           Integer sex = Integer.valueOf(no.charAt(16));
/*     */           
/* 105 */           Integer year = Integer.valueOf(StringUtils.substring(no, 6, 10));
/* 106 */           if ((sex.intValue() % 2 == 0) && (year.intValue() > 1990)) {
/* 107 */             System.out.println(no);
/* 108 */             System.out.println(year + "\t" + rs.getString("姓名"));
/* 109 */             System.out.println(rs.getString("邮箱") + "\t" + rs.getString("电话"));
/*     */           }
/*     */           
/*     */         }
/*     */         catch (Exception localException1) {}
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 118 */       if (con != null) {
/*     */         try {
/* 120 */           con.close();
/*     */         } catch (SQLException e1) {
/* 122 */           e1.printStackTrace();
/*     */         }
/*     */       }
/* 125 */       e.printStackTrace();
/*     */     }
/*     */   }
/*     */ }


/* Location:              E:\aaa\front\WEB-INF\classes\!\test\Data.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */