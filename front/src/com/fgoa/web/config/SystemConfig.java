/*     */ package com.fgoa.web.config;
/*     */ 
/*     */ import com.fgoa.web.controller.AnnouncementController;
/*     */ import com.fgoa.web.controller.BusinessController;
/*     */ import com.fgoa.web.controller.CarController;
/*     */ import com.fgoa.web.controller.ConferenceController;
/*     */ import com.fgoa.web.controller.ContactsController;
/*     */ import com.fgoa.web.controller.ExamController;
/*     */ import com.fgoa.web.controller.FileController;
/*     */ import com.fgoa.web.controller.IndexController;
/*     */ import com.fgoa.web.controller.LoginController;
/*     */ import com.fgoa.web.controller.weixin.AnnoController;
/*     */ import com.fgoa.web.controller.weixin.BindUserController;
/*     */ import com.fgoa.web.controller.weixin.ContactController;
/*     */ import com.fgoa.web.controller.weixin.TestController;
/*     */ import com.fgoa.web.inteceptor.ParamInteterceptor;
/*     */ import com.fgoa.web.inteceptor.TldInteterceptor;
/*     */ import com.fgoa.web.model.AddonFile;
/*     */ import com.fgoa.web.model.Announcement;
/*     */ import com.fgoa.web.model.Car;
/*     */ import com.fgoa.web.model.Conference;
/*     */ import com.fgoa.web.model.Depart;
/*     */ import com.fgoa.web.model.ExamAnswer;
/*     */ import com.fgoa.web.model.ExamClass;
/*     */ import com.fgoa.web.model.ExamPaper;
/*     */ import com.fgoa.web.model.ExamPaperQuestion;
/*     */ import com.fgoa.web.model.ExamQuestion;
/*     */ import com.fgoa.web.model.InboxInfo;
/*     */ import com.fgoa.web.model.InboxInfoDoc;
/*     */ import com.fgoa.web.model.InboxInfoOpinion;
/*     */ import com.fgoa.web.model.InboxInfoOrgRel;
/*     */ import com.fgoa.web.model.InboxInfoUserRel;
/*     */ import com.fgoa.web.model.InfoHistory;
/*     */ import com.fgoa.web.model.PetitionInfo;
/*     */ import com.fgoa.web.model.PetitionInfoDoc;
/*     */ import com.fgoa.web.model.PetitionInfoOpinion;
/*     */ import com.fgoa.web.model.PetitionInfoUserRel;
/*     */ import com.fgoa.web.model.PostHistory;
/*     */ import com.fgoa.web.model.PostInfo;
/*     */ import com.fgoa.web.model.PostUserRel;
/*     */ import com.fgoa.web.model.Role;
/*     */ import com.fgoa.web.model.Schedule;
/*     */ import com.fgoa.web.model.SerialNumber;
/*     */ import com.fgoa.web.model.User;
/*     */ import com.jagregory.shiro.freemarker.ShiroTags;
/*     */ import com.jfinal.config.Constants;
/*     */ import com.jfinal.config.Handlers;
/*     */ import com.jfinal.config.Interceptors;
/*     */ import com.jfinal.config.JFinalConfig;
/*     */ import com.jfinal.config.Plugins;
/*     */ import com.jfinal.config.Routes;
/*     */ import com.jfinal.ext.handler.ContextPathHandler;
/*     */ import com.jfinal.ext.plugin.quartz.QuartzPlugin;
/*     */ import com.jfinal.ext.plugin.shiro.ShiroPlugin;
/*     */ import com.jfinal.kit.PropKit;
/*     */ import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
/*     */ import com.jfinal.plugin.activerecord.CaseInsensitiveContainerFactory;
/*     */ import com.jfinal.plugin.c3p0.C3p0Plugin;
/*     */ import com.jfinal.render.FreeMarkerRender;
/*     */ import com.jfinal.weixin.fgoa.WeixinMsgController;
/*     */ import freemarker.template.Configuration;
/*     */ 
/*     */ public class SystemConfig
/*     */   extends JFinalConfig
/*     */ {
/*     */   private Routes routes;
/*     */   
/*     */   public void loadProp(String pro, String dev)
/*     */   {
/*     */     try
/*     */     {
/*  72 */       PropKit.use(pro);
/*     */     }
/*     */     catch (Exception e) {
/*  75 */       PropKit.use(dev);
/*     */     }
/*     */   }
/*     */   
/*     */   public void configConstant(Constants me) {
/*  80 */     loadProp("config.properties", "config.properties");
/*  81 */     me.setDevMode(true);
/*  82 */     me.setBaseViewPath("/WEB-INF/pages");
/*  83 */     FreeMarkerRender.setProperty("auto_import", 
/*  84 */       "/WEB-INF/pages/_inc/macro/globe_macro.ftl as globe");
/*  85 */     FreeMarkerRender.getConfiguration().setSharedVariable("shiro", 
/*  86 */       new ShiroTags());
/*     */   }
/*     */   
/*     */   public void configRoute(Routes me) {
/*  90 */     this.routes = me;
/*     */     
/*  92 */     me.add("/login", LoginController.class, "/");
/*  93 */     me.add("/index", IndexController.class, "/");
/*  94 */     me.add("/contacts", ContactsController.class, "/");
/*  95 */     me.add("/announcement", AnnouncementController.class, "/");
/*  96 */     me.add("/business", BusinessController.class, "/");
/*  97 */     me.add("/conference", ConferenceController.class, "/");
/*  98 */     me.add("/schedule", com.fgoa.web.controller.ScheduleController.class, "/");
/*  99 */     me.add("/inbox", com.fgoa.web.controller.InboxController.class);
/* 100 */     me.add("/post", com.fgoa.web.controller.PostController.class);
/* 101 */     me.add("/petition", com.fgoa.web.controller.PetitionController.class);
/* 102 */     me.add("/exam", ExamController.class);
/* 103 */     me.add("/car", CarController.class, "/");
/* 104 */     me.add("/file", FileController.class, "/");
/*     */     
/* 106 */     me.add("/msg", WeixinMsgController.class);
/*     */     
/* 108 */     me.add("/weixin/test", TestController.class, "/weixin");
/* 109 */     me.add("/weixin/bindUser", BindUserController.class, "/weixin");
/* 110 */     me.add("/weixin/contact", ContactController.class, "/weixin");
/* 111 */     me.add("/weixin/anno", AnnoController.class, "/weixin");
/* 112 */     me.add("/weixin/schedule", com.fgoa.web.controller.weixin.ScheduleController.class, "/weixin");
/* 113 */     me.add("/weixin/inbox", com.fgoa.web.controller.weixin.InboxController.class, "weixin");
/* 114 */     me.add("/weixin/post", com.fgoa.web.controller.weixin.PostController.class, "/weixin");
/* 115 */     me.add("/weixin/petition", com.fgoa.web.controller.weixin.PetitionController.class, "/weixin");
/*     */   }
/*     */   
/*     */ 
/*     */   public void configPlugin(Plugins me)
/*     */   {
/* 121 */     C3p0Plugin c3p0Plugin = new C3p0Plugin(
/* 122 */       PropKit.get("jdbc.url"), 
/* 123 */       PropKit.get("jdbc.username"), PropKit.get(
/* 124 */       "jdbc.password").trim());
/* 125 */     me.add(c3p0Plugin);
/*     */     
/*     */ 
/* 128 */     ActiveRecordPlugin arp = new ActiveRecordPlugin(c3p0Plugin);
/* 129 */     me.add(arp);
/* 130 */     me.add(new ShiroPlugin(this.routes));
/*     */     
/* 132 */     arp.addMapping("t_oa_announcement", Announcement.class);
/* 133 */     arp.addMapping("t_s_base_user", User.class);
/* 134 */     arp.addMapping("t_s_role", Role.class);
/* 135 */     arp.addMapping("t_s_depart", Depart.class);
/* 136 */     arp.addMapping("t_oa_conference", Conference.class);
/* 137 */     arp.addMapping("t_oa_schedule", Schedule.class);
/* 138 */     arp.addMapping("t_oa_inbox", InboxInfo.class);
/* 139 */     arp.addMapping("t_oa_inbox_doc", InboxInfoDoc.class);
/* 140 */     arp.addMapping("t_oa_inbox_opinion", InboxInfoOpinion.class);
/* 141 */     arp.addMapping("t_oa_inbox_org_rel", InboxInfoOrgRel.class);
/* 142 */     arp.addMapping("t_oa_inbox_user_rel", InboxInfoUserRel.class);
/* 143 */     arp.addMapping("t_oa_post", PostInfo.class);
/* 144 */     arp.addMapping("t_oa_post_user_rel", PostUserRel.class);
/* 145 */     arp.addMapping("t_oa_order", SerialNumber.class);
/* 146 */     arp.addMapping("t_oa_petition", PetitionInfo.class);
/* 147 */     arp.addMapping("t_oa_petition_doc", PetitionInfoDoc.class);
/* 148 */     arp.addMapping("t_oa_petition_opinion", PetitionInfoOpinion.class);
/* 149 */     arp.addMapping("t_oa_petition_user_rel", PetitionInfoUserRel.class);
/* 150 */     arp.addMapping("t_oa_exam_class", ExamClass.class);
/* 151 */     arp.addMapping("t_oa_exam_paper", ExamPaper.class);
/* 152 */     arp.addMapping("t_oa_exam_question", ExamQuestion.class);
/* 153 */     arp.addMapping("t_oa_exam_paper_question", ExamPaperQuestion.class);
/* 154 */     arp.addMapping("t_oa_exam_question_answer", ExamAnswer.class);
/* 155 */     arp.addMapping("t_oa_car", Car.class);
/*     */     
/*     */ 
/* 158 */     arp.addMapping("t_oa_file", AddonFile.class);
/* 159 */     arp.addMapping("tbl_post_history", PostHistory.class);
/* 160 */     arp.addMapping("tbl_info_history", InfoHistory.class);
/* 161 */     arp.setContainerFactory(new CaseInsensitiveContainerFactory(true));
/*     */     
/* 163 */     me.add(new QuartzPlugin("job.properties"));
/*     */   }
/*     */   
/*     */   public void configInterceptor(Interceptors me) {
/* 167 */     me.add(new TldInteterceptor());
/* 168 */     me.add(new ParamInteterceptor());
/*     */   }
/*     */   
/*     */   public void configHandler(Handlers me) {
/* 172 */     me.add(new ContextPathHandler("base"));
/*     */   }
/*     */ }


/* Location:              E:\aaa\front\WEB-INF\classes\!\com\fgoa\web\config\SystemConfig.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */