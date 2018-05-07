/*     */ package com.fgoa.web.service;
/*     */ 
/*     */ import com.alibaba.fastjson.JSONObject;
/*     */ import com.jfinal.plugin.activerecord.Db;
/*     */ import com.jfinal.plugin.activerecord.Record;
/*     */ import com.woo.jfinal.utils.HttpExecutor;
/*     */ import java.io.PrintStream;
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import org.apache.commons.collections.CollectionUtils;
/*     */ import org.apache.commons.lang.StringUtils;
/*     */ import org.apache.http.impl.client.DefaultHttpClient;
/*     */ import org.apache.log4j.Logger;
/*     */ import org.jsoup.Jsoup;
/*     */ import org.jsoup.nodes.Document;
/*     */ import org.jsoup.nodes.Element;
/*     */ import org.jsoup.select.Elements;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ShortMsgService
/*     */ {
/*     */   private static final String SMS_SERVER_URL = "http://sdk4.entinfo.cn:8060/webservice.asmx/SendSMS";
/*     */   public static final int INBOX_TYPE = 0;
/*     */   public static final int PETITION_TYPE = 1;
/*     */   public static final int POST_TYPE = 2;
/*     */   private static final String content = "您好，您有一条待办%s需要您及时处理[市场管理中心]";
/*  32 */   public static final ShortMsgService instance = new ShortMsgService();
/*     */   
/*  34 */   private static final Logger LOGGER = Logger.getLogger(ShortMsgService.class);
/*     */   
/*     */   public boolean sendSms(String[] mobile, String content) {
/*  37 */     HttpExecutor executor = new HttpExecutor(new DefaultHttpClient(), "application/x-www-form-urlencoded", "GBK");
/*     */     
/*  39 */     Map<String, String> param = new HashMap();
/*  40 */     param.put("sn", "DXX-WSZ-010-00285");
/*  41 */     param.put("pwd", "789512");
/*  42 */     param.put("mobile", StringUtils.join(mobile, ","));
/*  43 */     param.put("content", content);
/*     */     
/*  45 */     String result = executor.post("http://sdk4.entinfo.cn:8060/webservice.asmx/SendSMS", param);
/*  46 */     return parseResult(result);
/*     */   }
/*     */   
/*     */   public boolean sendSms(String mobile, String content) {
/*  50 */     return sendSms(new String[] { mobile }, content);
/*     */   }
/*     */   
/*     */   private boolean parseResult(String result) {
/*     */     try {
/*  55 */       System.out.println(result);
/*  56 */       Document doc = Jsoup.parse(result);
/*  57 */       String[] resultArr = doc.getAllElements().first().text().split(" ");
/*     */       
/*  59 */       String status = resultArr[0];
/*  60 */       String msg = resultArr[1];
/*  61 */       if (StringUtils.equals(status, "0")) {
/*  62 */         return true;
/*     */       }
/*  64 */       LOGGER.error("短信发送失败，原因【：" + msg + "】");
/*  65 */       return false;
/*     */     }
/*     */     catch (Exception e) {
/*  68 */       LOGGER.error("短信发送失败，返回的内容为：\n" + result); }
/*  69 */     return false;
/*     */   }
/*     */   
/*     */   public JSONObject remindUser(Integer type, String id)
/*     */   {
/*  74 */     JSONObject returnValue = new JSONObject();
/*  75 */     boolean success = false;
/*  76 */     String sql = "";
/*     */     
/*  78 */     String typeStr = "";
/*  79 */     switch (type.intValue()) {
/*     */     case 0: 
/*  81 */       sql = "select tu.id,tu.mobilePhone,u.realname from t_oa_inbox_user_rel as ur, t_s_base_user as u,t_oa_inbox as i , t_s_user as tu where tu.id=u.ID and i.id=ur.inboxId and u.ID=ur.userId and i.id=? and ur.active=?";
/*  82 */       typeStr = "收文";
/*  83 */       break;
/*     */     case 1: 
/*  85 */       sql = "select tu.id,tu.mobilePhone,u.realname from t_oa_petition_user_rel as ur, t_s_base_user as u,t_oa_petition as p,t_s_user as tu  where tu.id=u.ID and p.id=ur.petitionId and u.ID=ur.userId and p.id=? and ur.active=?";
/*  86 */       typeStr = "信访";
/*  87 */       break;
/*     */     case 2: 
/*  89 */       sql = "select tu.id,tu.mobilePhone,u.realname from t_oa_post_user_rel as ur, t_s_base_user as u,t_oa_post as p,t_s_user as tu  where tu.id=u.ID and p.id=ur.postId and u.ID=ur.userId and p.id=? and ur.active=?";
/*  90 */       typeStr = "发文";
/*  91 */       break;
/*     */     }
/*     */     
/*     */     
/*  95 */     if ((StringUtils.isNotBlank(sql)) && (StringUtils.isNotBlank(id))) {
/*  96 */       List<Record> result = Db.find(sql, new Object[] { id, Integer.valueOf(0) });
/*  97 */       List<String> mobileNums = new ArrayList();
/*  98 */       if (CollectionUtils.isNotEmpty(result)) {
/*  99 */         StringBuilder sb = new StringBuilder();
/* 100 */         LOGGER.info("向下列人员发送短信提醒：");
/* 101 */         for (Record r : result) {
/* 102 */           LOGGER.info(String.format("姓名:%s\t电话:%s", new Object[] { r.getStr("realname"), r.getStr("mobilePhone") }));
/* 103 */           String mobileNum = r.getStr("mobilePhone");
/* 104 */           if (StringUtils.isNotBlank(mobileNum)) {
/* 105 */             mobileNums.add(mobileNum);
/*     */           } else {
/* 107 */             sb.append(r.getStr("realname")).append(",");
/*     */           }
/*     */         }
/*     */         
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 117 */         if (sb.length() > 0) {
/* 118 */           sb.deleteCharAt(sb.length() - 1);
/* 119 */           returnValue.put("errorMsg", "以下用户未配置手机号:[" + sb.toString() + "],请与管理员联系完成配置");
/*     */         }
/* 121 */         LOGGER.info("短信内容为：" + String.format("您好，您有一条待办%s需要您及时处理[市场管理中心]", new Object[] { typeStr }) + "。短信发送完毕");
/*     */       } else {
/* 123 */         returnValue.put("errorMsg", "当前记录未找到待提醒的用户");
/*     */       }
/*     */     } else {
/* 126 */       returnValue.put("errorMsg", "请求参数错误");
/*     */     }
/* 128 */     returnValue.put("success", Boolean.valueOf(success));
/* 129 */     return returnValue;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public static void main(String[] args)
/*     */   {
/* 136 */     instance.sendSms(new String[] { "15926313556" }, "");
/*     */   }
/*     */ }


/* Location:              E:\aaa\front\WEB-INF\classes\!\com\fgoa\web\service\ShortMsgService.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */