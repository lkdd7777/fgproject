/*     */ package com.fgoa.web.controller.weixin;
/*     */ 
/*     */ import com.alibaba.fastjson.JSONObject;
/*     */ import com.fgoa.web.inteceptor.weixin.UserInteterceptor;
/*     */ import com.fgoa.web.inteceptor.weixin.WeixinInteterceptor;
/*     */ import com.fgoa.web.model.AddonFile;
/*     */ import com.fgoa.web.model.Depart;
/*     */ import com.fgoa.web.model.PetitionInfo;
/*     */ import com.fgoa.web.model.PetitionInfoDoc;
/*     */ import com.fgoa.web.model.PetitionInfoOpinion;
/*     */ import com.fgoa.web.model.Role;
/*     */ import com.fgoa.web.model.User;
/*     */ import com.fgoa.web.service.InboxService;
/*     */ import com.fgoa.web.service.PetitionService;
/*     */ import com.fgoa.web.service.ShortMsgService;
/*     */ import com.jfinal.aop.Before;
/*     */ import com.jfinal.core.Controller;
/*     */ import com.woo.jfinal.utils.UUIDUtils;
/*     */ import java.io.PrintStream;
/*     */ import java.util.Date;
/*     */ import javax.servlet.http.HttpServletRequest;
/*     */ import org.apache.commons.lang.StringUtils;
/*     */ 
/*     */ public class PetitionController extends Controller
/*     */ {
/*     */   @Before({WeixinInteterceptor.class})
/*     */   public void index()
/*     */   {
/*  29 */     String userId = getUserId();
/*  30 */     if (StringUtils.isNotBlank(userId)) {
/*  31 */       setAttr("petitionInfoList", PetitionInfo.dao.findMemberReadList(userId));
/*  32 */       render("petition_result.ftl");
/*     */     } else {
/*  34 */       setAttr("errorMsg", "获取微信账号信息出现错误");
/*  35 */       render("errorInfo.ftl");
/*     */     }
/*     */   }
/*     */   
/*     */   @Before({UserInteterceptor.class})
/*     */   public void detail() {
/*  41 */     PetitionInfo info = getInfo();
/*  42 */     if (info == null) {
/*  43 */       renderError(404);
/*  44 */       return;
/*     */     }
/*  46 */     setAttr("info", info);
/*  47 */     setAttr("docList", 
/*  48 */       PetitionInfoDoc.dao.findByPetitionInfoId(info.getStr("id")));
/*     */     
/*  50 */     int rejected = 1;
/*     */     try {
/*  52 */       rejected = info.getInt("rejected").intValue();
/*     */     }
/*     */     catch (Exception localException) {}
/*     */     
/*  56 */     if (rejected == 0) {
/*  57 */       setAttr("rejected", Boolean.valueOf(true));
/*     */     }
/*  59 */     String userId = (String)getSessionAttr("userId");
/*     */     
/*     */ 
/*  62 */     if (Role.dao.isUserContainAnyRole(userId, new String[] {"centerleader", "sectionchife", "vicedirector", "vicesectionchife" })) {
/*  63 */       if (info.get("replyed") != null) {
/*  64 */         setAttr("isReplay", Boolean.valueOf(true));
/*     */       } else {
/*  66 */         setAttr("isRemark", Boolean.valueOf(true));
/*     */       }
/*  68 */     } else if (Role.dao.isCurrentUserHasRole("normaluser")) {
/*  69 */       setAttr("isReplay", Boolean.valueOf(true));
/*     */     }
/*  71 */     render("petition_detail.ftl");
/*     */   }
/*     */   
/*     */   @Before({UserInteterceptor.class})
/*     */   public void transfer() {
/*  76 */     PetitionInfo info = getInfo();
/*  77 */     if (info == null) {
/*  78 */       renderError(404);
/*  79 */       return;
/*     */     }
/*  81 */     setAttr("info", info);
/*  82 */     render("petition_transfer.ftl");
/*     */   }
/*     */   
/*     */   @Before({UserInteterceptor.class})
/*     */   public void saveOpition() {
/*  87 */     PetitionInfo info = getInfo();
/*  88 */     if (info == null) {
/*  89 */       renderError(404);
/*  90 */       return;
/*     */     }
/*  92 */     String infoId = (String)info.get("id");
/*     */     
/*  94 */     String userName = User.dao.findUserNameById(getUserId());
/*     */     
/*  96 */     String opinionContent = getPara("opinionContent");
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 102 */     ((PetitionInfoOpinion)((PetitionInfoOpinion)((PetitionInfoOpinion)((PetitionInfoOpinion)((PetitionInfoOpinion)((PetitionInfoOpinion)((PetitionInfoOpinion)new PetitionInfoOpinion().set("id", UUIDUtils.getRandomUUID())).set("petitionId", infoId)).set("content", opinionContent)).set("userName", userName)).set("userId", getUserId())).set("submitDate", new Date())).set("priority", Integer.valueOf(0))).save();
/*     */     
/* 104 */     String userId = (String)getSessionAttr("userId");
/*     */     
/* 106 */     if (Role.dao.isUserContainRole(userId, "centerleader")) {
/* 107 */       info.set("status", Integer.valueOf(2));
/* 108 */       redirect("/weixin/petition/selectDepartAndPerson?infoId=" + infoId);
/* 109 */     } else if (Role.dao.isUserContainRole(userId, "vicedirector")) {
/* 110 */       redirect("/weixin/petition/selectDepart?infoId=" + infoId);
/* 111 */     } else if (Role.dao.isUserContainAnyRole(userId, new String[] { "sectionchife", "vicesectionchife" })) {
/* 112 */       redirect("/weixin/petition/selectPerson?infoId=" + infoId);
/*     */     }
/*     */   }
/*     */   
/*     */   @Before({UserInteterceptor.class})
/*     */   public void selectDepartAndPerson() {
/* 118 */     PetitionInfo info = getInfo();
/* 119 */     if (info == null) {
/* 120 */       renderError(404);
/* 121 */       return;
/*     */     }
/* 123 */     setAttr("info", info);
/* 124 */     setAttr("viceDirector", User.dao.findUserListByRole("vicedirector"));
/*     */     
/* 126 */     setAttr("departs", Depart.dao.findAll());
/* 127 */     render("petition_select_depart_d.ftl");
/*     */   }
/*     */   
/*     */   @Before({UserInteterceptor.class})
/*     */   public void selectDepart() {
/* 132 */     PetitionInfo info = getInfo();
/* 133 */     if (info == null) {
/* 134 */       renderError(404);
/* 135 */       return;
/*     */     }
/* 137 */     setAttr("info", info);
/*     */     
/* 139 */     setAttr("orgs", Depart.dao.findChargeDeparts(getUserId()));
/* 140 */     render("petition_select_depart_vd.ftl");
/*     */   }
/*     */   
/*     */   @Before({UserInteterceptor.class})
/*     */   public void selectPerson() {
/* 145 */     PetitionInfo info = getInfo();
/* 146 */     if (info == null) {
/* 147 */       renderError(404);
/* 148 */       return;
/*     */     }
/* 150 */     setAttr("info", info);
/*     */     
/* 152 */     setAttr("members", User.dao.findUserByDepartIdAndRoleCode(
/* 153 */       "normaluser", getUserId()));
/* 154 */     render("petition_select_person.ftl");
/*     */   }
/*     */   
/*     */   @Before({UserInteterceptor.class})
/*     */   public void saveSelect() {
/* 159 */     PetitionInfo info = getInfo();
/* 160 */     if (info == null) {
/* 161 */       renderError(404);
/* 162 */       return;
/*     */     }
/* 164 */     String[] orgIds = getParaValues("orgId");
/* 165 */     String[] userIds = getParaValues("userId");
/* 166 */     System.out.println("orgId:" + orgIds);
/* 167 */     System.out.println("userIds:" + userIds);
/* 168 */     PetitionService.instance.savePetionRel(orgIds, userIds, info, getUserId());
/* 169 */     ((PetitionInfo)info.set("status", Integer.valueOf(3))).update();
/* 170 */     sendRemind(info.getStr("id"));
/* 171 */     redirect("/weixin/petition");
/*     */   }
/*     */   
/*     */   @Before({UserInteterceptor.class})
/*     */   public void archive() {
/* 176 */     PetitionInfo info = getInfo();
/* 177 */     if (info == null) {
/* 178 */       renderError(404);
/* 179 */       return;
/*     */     }
/* 181 */     InboxService.instance.deActiveRel(info.getStr("id"));
/* 182 */     ((PetitionInfo)info.set("status", Integer.valueOf(1))).update();
/* 183 */     redirect("/weixin/petition");
/*     */   }
/*     */   
/*     */   @Before({UserInteterceptor.class})
/*     */   public void replay() {
/* 188 */     PetitionInfo info = getInfo();
/* 189 */     if (info == null) {
/* 190 */       renderError(404);
/* 191 */       return;
/*     */     }
/* 193 */     String userId = (String)getSessionAttr("userId");
/*     */     
/* 195 */     if (!Role.dao.isUserContainRole(userId, "normaluser")) {
/* 196 */       setAttr("isRejectAble", Boolean.valueOf(true));
/*     */     }
/* 198 */     if (info.getInt("status").intValue() == 1) {
/* 199 */       setAttr("editable", Boolean.valueOf(false));
/*     */     }
/* 201 */     int rejected = 1;
/*     */     try {
/* 203 */       rejected = info.getInt("rejected").intValue();
/*     */     }
/*     */     catch (Exception localException) {}
/*     */     
/* 207 */     if (rejected == 0) {
/* 208 */       setAttr("rejected", Boolean.valueOf(true));
/*     */     }
/* 210 */     setAttr("addonList", AddonFile.dao.findById(info.getStr("folder")));
/* 211 */     setAttr("info", info);
/* 212 */     render("petition_replay.ftl");
/*     */   }
/*     */   
/*     */   @Before({UserInteterceptor.class})
/*     */   public void saveReplay() {
/* 217 */     PetitionInfo info = getInfo();
/* 218 */     if (info == null) {
/* 219 */       renderError(404);
/* 220 */       return;
/*     */     }
/*     */     
/* 223 */     String content = getPara("replyContent");
/* 224 */     if (StringUtils.isBlank(content)) {
/* 225 */       setAttr("errorMsg", "答复内容不能为空");
/* 226 */       setAttr("info", info);
/* 227 */       render("petition_replay.ftl");
/* 228 */       return;
/*     */     }
/* 230 */     PetitionService.instance.saveApproval(content, info, getUserId());
/* 231 */     sendRemind(info.getStr("id"));
/* 232 */     redirect("/weixin/petition");
/*     */   }
/*     */   
/*     */   @Before({UserInteterceptor.class})
/*     */   public void saveReject()
/*     */   {
/* 238 */     PetitionInfo info = getInfo();
/* 239 */     if (info == null) {
/* 240 */       renderError(404);
/* 241 */       return;
/*     */     }
/*     */     
/* 244 */     String content = getPara("rejectContent");
/* 245 */     if (StringUtils.isBlank(content)) {
/* 246 */       setAttr("errorMsg", "答复内容不能为空");
/* 247 */       setAttr("info", info);
/* 248 */       render("petition_replay.ftl");
/* 249 */       return;
/*     */     }
/* 251 */     PetitionService.instance.saveReject(content, info, getUserId());
/* 252 */     sendRemind(info.getStr("id"));
/* 253 */     redirect("/weixin/petition");
/*     */   }
/*     */   
/*     */ 
/*     */   private JSONObject sendRemind(String infoId)
/*     */   {
/* 259 */     return ShortMsgService.instance.remindUser(Integer.valueOf(1), infoId);
/*     */   }
/*     */   
/*     */   private PetitionInfo getInfo() {
/* 263 */     String infoId = getPara("infoId");
/* 264 */     if (StringUtils.isBlank(infoId)) {
/* 265 */       return null;
/*     */     }
/* 267 */     PetitionInfo info = (PetitionInfo)PetitionInfo.dao.findById(infoId);
/* 268 */     if (info == null) {
/* 269 */       return null;
/*     */     }
/* 271 */     return info;
/*     */   }
/*     */   
/*     */   private String getUserId() {
/* 275 */     String userId = (String)getSessionAttr("userId");
/* 276 */     if (StringUtils.isBlank(userId)) {
/* 277 */       userId = getPara("userId");
/* 278 */       if (StringUtils.isBlank(userId)) {
/* 279 */         userId = (String)getRequest().getAttribute("userId");
/*     */       }
/*     */     }
/*     */     
/* 283 */     return userId;
/*     */   }
/*     */ }


/* Location:              E:\aaa\front\WEB-INF\classes\!\com\fgoa\web\controller\weixin\PetitionController.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */