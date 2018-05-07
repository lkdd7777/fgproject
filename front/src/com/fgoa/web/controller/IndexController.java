/*     */ package com.fgoa.web.controller;
/*     */ 
/*     */ import com.alibaba.fastjson.JSONObject;
/*     */ import com.fgoa.web.model.Announcement;
/*     */ import com.fgoa.web.model.Conference;
/*     */ import com.fgoa.web.model.PostInfo;
/*     */ import com.fgoa.web.model.User;
/*     */ import com.fgoa.web.security.ShiroUtils;
/*     */ import com.fgoa.web.service.InboxService;
/*     */ import com.fgoa.web.service.PetitionService;
/*     */ import com.fgoa.web.service.PostService;
/*     */ import com.fgoa.web.service.WeatherService;
/*     */ import com.jfinal.aop.Before;
/*     */ import com.jfinal.core.ActionKey;
/*     */ import com.jfinal.core.Controller;
/*     */ import com.jfinal.ext.interceptor.GET;
/*     */ import com.woo.jfinal.utils.PasswordUtil;
/*     */ import org.apache.commons.lang.StringUtils;
/*     */ 
/*     */ public class IndexController extends Controller
/*     */ {
/*     */   public void index()
/*     */   {
/*  24 */     setAttr("announceNum", Long.valueOf(Announcement.dao.queryAnnouncementCount()));
/*     */     
/*  26 */     setAttr("inboxNum", Long.valueOf(InboxService.instance.getUserInboxCount()));
/*     */     
/*  28 */     setAttr("scheduleNum", Integer.valueOf(0));
/*     */     
/*  30 */     setAttr("inboxUrl", InboxService.instance.getInboxUrl());
/*     */     
/*  32 */     setAttr("postUrl", PostService.instance.getPostUrl());
/*     */     
/*  34 */     setAttr("postNum", Long.valueOf(PostInfo.dao.findUserPostCount()));
/*     */     
/*  36 */     setAttr("petitionUrl", PetitionService.instance.getPetitionUrl());
/*     */     
/*  38 */     setAttr("petitionNum", Long.valueOf(PetitionService.instance.getUserPetitionCount()));
/*     */     
/*  40 */     setAttr("conferenceNum", Long.valueOf(Conference.dao.queryConferenceCount()));
/*  41 */     render("home.ftl");
/*     */   }
/*     */   
/*     */   @ActionKey("/")
/*     */   public void main() {
/*  46 */     redirect("/index");
/*     */   }
/*     */   
/*     */   public void test() {
/*  50 */     render("test.ftl");
/*     */   }
/*     */   
/*     */   public void getWeatherInfo() {
/*  54 */     renderJson(WeatherService.instance.getWeatherInfo());
/*     */   }
/*     */   
/*     */   public void getUserOaData() {
/*  58 */     JSONObject returnValue = new JSONObject();
/*     */     
/*  60 */     returnValue.put("announceNum", Long.valueOf(Announcement.dao.queryAnnouncementCount()));
/*  61 */     returnValue.put("inboxNum", Long.valueOf(InboxService.instance.getUserInboxCount()));
/*  62 */     returnValue.put("scheduleNum", Integer.valueOf(0));
/*  63 */     returnValue.put("postNum", Long.valueOf(PostInfo.dao.findUserPostCount()));
/*  64 */     returnValue.put("petitionNum", Long.valueOf(PetitionService.instance.getUserPetitionCount()));
/*  65 */     returnValue.put("conferenceNum", Long.valueOf(Conference.dao.queryConferenceCount()));
/*     */     
/*  67 */     renderJson(returnValue);
/*     */   }
/*     */   
/*     */   @ActionKey("/toModifyPwd")
/*     */   @Before({GET.class})
/*     */   public void toModifyPwd() {
/*  73 */     render("modifyPwd.ftl");
/*     */   }
/*     */   
/*     */   @ActionKey("/modifyPwd")
/*     */   @Before({com.jfinal.ext.interceptor.POST.class})
/*     */   public void modifyPwd() {
/*  79 */     String orginalPwd = getPara("orginalPwd");
/*  80 */     String newPwd = getPara("newPwd");
/*     */     
/*  82 */     if (StringUtils.isBlank(orginalPwd)) {
/*  83 */       renderJson(renderErrorMsg("原始密码不能为空"));
/*  84 */       return;
/*     */     }
/*     */     
/*  87 */     if (StringUtils.isBlank(newPwd)) {
/*  88 */       renderJson(renderErrorMsg("设置密码不能为空"));
/*  89 */       return;
/*     */     }
/*     */     
/*  92 */     User user = (User)User.dao.findById(ShiroUtils.getCurrentUserId());
/*  93 */     if (user == null) {
/*  94 */       renderJson(renderErrorMsg("密码设置错误，未找到当前用户"));
/*  95 */       return;
/*     */     }
/*  97 */     String userName = user.getStr("username");
/*  98 */     String password = user.getStr("password");
/*  99 */     String encryptPwd = PasswordUtil.encrypt(userName, orginalPwd, 
/* 100 */       PasswordUtil.getStaticSalt());
/* 101 */     if (!StringUtils.equals(encryptPwd, password)) {
/* 102 */       renderJson(renderErrorMsg("原始密码不正确，请重新输入"));
/* 103 */       return;
/*     */     }
/* 105 */     String encryptNewPwd = PasswordUtil.encrypt(userName, newPwd, 
/* 106 */       PasswordUtil.getStaticSalt());
/* 107 */     ((User)user.set("password", encryptNewPwd)).update();
/* 108 */     renderJson();
/*     */   }
/*     */   
/*     */ 
/*     */   private String renderErrorMsg(String msg)
/*     */   {
/* 114 */     return String.format("{\"errorMsg\":\"%s\"}", new Object[] { msg });
/*     */   }
/*     */ }


/* Location:              E:\aaa\front\WEB-INF\classes\!\com\fgoa\web\controller\IndexController.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */