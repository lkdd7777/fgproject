/*     */ package com.fgoa.web.controller.weixin;
/*     */ 
/*     */ import com.alibaba.fastjson.JSONObject;
/*     */ import com.fgoa.web.inteceptor.weixin.UserInteterceptor;
/*     */ import com.fgoa.web.inteceptor.weixin.WeixinInteterceptor;
/*     */ import com.fgoa.web.model.AddonFile;
/*     */ import com.fgoa.web.model.Depart;
/*     */ import com.fgoa.web.model.InboxInfo;
/*     */ import com.fgoa.web.model.InboxInfoDoc;
/*     */ import com.fgoa.web.model.InboxInfoOpinion;
/*     */ import com.fgoa.web.model.Role;
/*     */ import com.fgoa.web.model.User;
/*     */ import com.fgoa.web.service.InboxService;
/*     */ import com.fgoa.web.service.ShortMsgService;
/*     */ import com.jfinal.aop.Before;
/*     */ import com.jfinal.core.Controller;
/*     */ import com.woo.jfinal.utils.UUIDUtils;
/*     */ import java.io.PrintStream;
/*     */ import java.util.Date;
/*     */ import javax.servlet.http.HttpServletRequest;
/*     */ import javax.servlet.http.HttpSession;
/*     */ import org.apache.commons.lang.StringUtils;
/*     */ 
/*     */ public class InboxController extends Controller
/*     */ {
/*     */   @Before({WeixinInteterceptor.class})
/*     */   public void index()
/*     */   {
/*  29 */     String userId = getUserId();
/*     */     
/*  31 */     if (StringUtils.isNotBlank(userId)) {
/*  32 */       getSession().setAttribute("userId", userId);
/*  33 */       User user = (User)User.dao.findById(userId);
/*  34 */       setAttr("inboxInfoList", InboxInfo.dao.findMemberReadList(userId));
/*  35 */       setAttr("user", user);
/*  36 */       render("inbox_result.ftl");
/*     */     } else {
/*  38 */       setAttr("errorMsg", "获取微信账号信息出现错误");
/*  39 */       render("errorInfo.ftl");
/*     */     }
/*     */   }
/*     */   
/*     */   @Before({UserInteterceptor.class})
/*     */   public void detail() {
/*  45 */     InboxInfo info = getInfo();
/*  46 */     if (info == null) {
/*  47 */       renderError(404);
/*  48 */       return;
/*     */     }
/*  50 */     setAttr("info", info);
/*  51 */     setAttr("docList", 
/*  52 */       InboxInfoDoc.dao.findByInboxInfoId(info.getStr("id")));
/*     */     
/*  54 */     int rejected = 1;
/*     */     try {
/*  56 */       rejected = info.getInt("rejected").intValue();
/*     */     }
/*     */     catch (Exception localException) {}
/*     */     
/*  60 */     if (rejected == 0) {
/*  61 */       setAttr("rejected", Boolean.valueOf(true));
/*     */     }
/*  63 */     String userId = (String)getSessionAttr("userId");
/*     */     
/*     */ 
/*  66 */     if (Role.dao.isUserContainAnyRole(userId, new String[] {"centerleader", "sectionchife", "vicedirector", "vicesectionchife" })) {
/*  67 */       if (info.get("replyed") != null) {
/*  68 */         setAttr("isReplay", Boolean.valueOf(true));
/*     */       } else {
/*  70 */         setAttr("isRemark", Boolean.valueOf(true));
/*     */       }
/*     */       
/*     */     }
/*     */     else {
/*  75 */       setAttr("isReplay", Boolean.valueOf(true));
/*     */     }
/*  77 */     render("inbox_detail.ftl");
/*     */   }
/*     */   
/*     */   @Before({UserInteterceptor.class})
/*     */   public void transfer() {
/*  82 */     InboxInfo info = getInfo();
/*  83 */     if (info == null) {
/*  84 */       renderError(404);
/*  85 */       return;
/*     */     }
/*  87 */     setAttr("info", info);
/*  88 */     render("inbox_transfer.ftl");
/*     */   }
/*     */   
/*     */   @Before({UserInteterceptor.class})
/*     */   public void saveOpition() {
/*  93 */     InboxInfo info = getInfo();
/*  94 */     if (info == null) {
/*  95 */       renderError(404);
/*  96 */       return;
/*     */     }
/*  98 */     String infoId = (String)info.get("id");
/*     */     
/* 100 */     String userName = User.dao.findUserNameById(getUserId());
/*     */     
/* 102 */     String opinionContent = getPara("opinionContent");
/*     */     
/*     */ 
/*     */ 
/* 106 */     ((InboxInfoOpinion)((InboxInfoOpinion)((InboxInfoOpinion)((InboxInfoOpinion)((InboxInfoOpinion)((InboxInfoOpinion)new InboxInfoOpinion().set("id", UUIDUtils.getRandomUUID())).set("inboxId", infoId)).set("content", opinionContent)).set("userName", userName)).set("submitDate", new Date())).set("priority", Integer.valueOf(0))).save();
/*     */     
/* 108 */     String userId = (String)getSessionAttr("userId");
/*     */     
/* 110 */     if (Role.dao.isUserContainRole(userId, "centerleader")) {
/* 111 */       info.set("status", Integer.valueOf(2));
/* 112 */       redirect("/weixin/inbox/selectDepartAndPerson?infoId=" + infoId);
/* 113 */     } else if (Role.dao.isUserContainRole(userId, "vicedirector")) {
/* 114 */       redirect("/weixin/inbox/selectDepart?infoId=" + infoId);
/* 115 */     } else if (Role.dao.isUserContainAnyRole(userId, new String[] { "sectionchife", "vicesectionchife" })) {
/* 116 */       redirect("/weixin/inbox/selectPerson?infoId=" + infoId);
/*     */     }
/*     */   }
/*     */   
/*     */   @Before({UserInteterceptor.class})
/*     */   public void selectDepartAndPerson() {
/* 122 */     InboxInfo info = getInfo();
/* 123 */     if (info == null) {
/* 124 */       renderError(404);
/* 125 */       return;
/*     */     }
/* 127 */     setAttr("info", info);
/* 128 */     setAttr("viceDirector", User.dao.findUserListByRole("vicedirector"));
/*     */     
/* 130 */     setAttr("departs", Depart.dao.findAll());
/* 131 */     render("inbox_select_depart_d.ftl");
/*     */   }
/*     */   
/*     */   @Before({UserInteterceptor.class})
/*     */   public void selectDepart() {
/* 136 */     InboxInfo info = getInfo();
/* 137 */     if (info == null) {
/* 138 */       renderError(404);
/* 139 */       return;
/*     */     }
/* 141 */     setAttr("info", info);
/*     */     
/* 143 */     setAttr("orgs", Depart.dao.findChargeDeparts(getUserId()));
/* 144 */     render("inbox_select_depart_vd.ftl");
/*     */   }
/*     */   
/*     */   @Before({UserInteterceptor.class})
/*     */   public void selectPerson() {
/* 149 */     InboxInfo info = getInfo();
/* 150 */     if (info == null) {
/* 151 */       renderError(404);
/* 152 */       return;
/*     */     }
/* 154 */     setAttr("info", info);
/*     */     
/* 156 */     setAttr("members", User.dao.findUserByDepartIdAndRoleCode(
/* 157 */       "normaluser", getUserId()));
/* 158 */     render("inbox_select_person.ftl");
/*     */   }
/*     */   
/*     */   @Before({UserInteterceptor.class})
/*     */   public void saveSelect() {
/* 163 */     InboxInfo info = getInfo();
/* 164 */     if (info == null) {
/* 165 */       renderError(404);
/* 166 */       return;
/*     */     }
/* 168 */     String[] orgIds = getParaValues("orgId");
/* 169 */     String[] userIds = getParaValues("userId");
/* 170 */     System.out.println("orgId:" + orgIds);
/* 171 */     System.out.println("userIds:" + userIds);
/* 172 */     InboxService.instance.saveInboxRel(orgIds, userIds, info, getUserId());
/* 173 */     ((InboxInfo)info.set("status", Integer.valueOf(3))).update();
/* 174 */     sendRemind(info.getStr("id"));
/* 175 */     redirect("/weixin/inbox");
/*     */   }
/*     */   
/*     */   @Before({UserInteterceptor.class})
/*     */   public void archive() {
/* 180 */     InboxInfo info = getInfo();
/* 181 */     if (info == null) {
/* 182 */       renderError(404);
/* 183 */       return;
/*     */     }
/* 185 */     InboxService.instance.deActiveRel(info.getStr("id"));
/* 186 */     ((InboxInfo)info.set("status", Integer.valueOf(1))).update();
/* 187 */     redirect("/weixin/inbox");
/*     */   }
/*     */   
/*     */   @Before({UserInteterceptor.class})
/*     */   public void replay() {
/* 192 */     InboxInfo info = getInfo();
/* 193 */     if (info == null) {
/* 194 */       renderError(404);
/* 195 */       return;
/*     */     }
/* 197 */     String userId = (String)getSessionAttr("userId");
/*     */     
/* 199 */     if (!Role.dao.isUserContainRole(userId, "normaluser")) {
/* 200 */       setAttr("isRejectAble", Boolean.valueOf(true));
/*     */     }
/* 202 */     if (info.getInt("status").intValue() == 1) {
/* 203 */       setAttr("editable", Boolean.valueOf(false));
/*     */     }
/* 205 */     int rejected = 1;
/*     */     try {
/* 207 */       rejected = info.getInt("rejected").intValue();
/*     */     }
/*     */     catch (Exception localException) {}
/*     */     
/* 211 */     if (rejected == 0) {
/* 212 */       setAttr("rejected", Boolean.valueOf(true));
/*     */     }
/* 214 */     setAttr("addonList", AddonFile.dao.findById(info.getStr("folder")));
/* 215 */     setAttr("info", info);
/* 216 */     render("inbox_replay.ftl");
/*     */   }
/*     */   
/*     */   @Before({UserInteterceptor.class})
/*     */   public void saveReplay() {
/* 221 */     InboxInfo info = getInfo();
/* 222 */     if (info == null) {
/* 223 */       renderError(404);
/* 224 */       return;
/*     */     }
/*     */     
/* 227 */     String content = getPara("replyContent");
/* 228 */     if (StringUtils.isBlank(content)) {
/* 229 */       setAttr("errorMsg", "答复内容不能为空");
/* 230 */       setAttr("info", info);
/* 231 */       render("inbox_replay.ftl");
/* 232 */       return;
/*     */     }
/* 234 */     InboxService.instance.saveApproval(content, info, null);
/* 235 */     sendRemind(info.getStr("id"));
/* 236 */     redirect("/weixin/inbox");
/*     */   }
/*     */   
/*     */   @Before({UserInteterceptor.class})
/*     */   public void saveReject()
/*     */   {
/* 242 */     InboxInfo info = getInfo();
/* 243 */     if (info == null) {
/* 244 */       renderError(404);
/* 245 */       return;
/*     */     }
/*     */     
/* 248 */     String content = getPara("rejectContent");
/* 249 */     if (StringUtils.isBlank(content)) {
/* 250 */       setAttr("errorMsg", "答复内容不能为空");
/* 251 */       setAttr("info", info);
/* 252 */       render("inbox_replay.ftl");
/* 253 */       return;
/*     */     }
/* 255 */     InboxService.instance.saveReject(content, info);
/* 256 */     sendRemind(info.getStr("id"));
/* 257 */     redirect("/weixin/inbox");
/*     */   }
/*     */   
/*     */ 
/*     */   private JSONObject sendRemind(String infoId)
/*     */   {
/* 263 */     return ShortMsgService.instance.remindUser(Integer.valueOf(0), infoId);
/*     */   }
/*     */   
/*     */   private InboxInfo getInfo() {
/* 267 */     String infoId = getPara("infoId");
/* 268 */     if (StringUtils.isBlank(infoId)) {
/* 269 */       return null;
/*     */     }
/* 271 */     InboxInfo info = (InboxInfo)InboxInfo.dao.findById(infoId);
/* 272 */     if (info == null) {
/* 273 */       return null;
/*     */     }
/* 275 */     return info;
/*     */   }
/*     */   
/*     */   private String getUserId() {
/* 279 */     String userId = (String)getSessionAttr("userId");
/* 280 */     if (StringUtils.isBlank(userId)) {
/* 281 */       userId = getPara("userId");
/* 282 */       if (StringUtils.isBlank(userId)) {
/* 283 */         userId = (String)getRequest().getAttribute("userId");
/*     */       }
/*     */     }
/*     */     
/* 287 */     return userId;
/*     */   }
/*     */ }


/* Location:              E:\aaa\front\WEB-INF\classes\!\com\fgoa\web\controller\weixin\InboxController.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */