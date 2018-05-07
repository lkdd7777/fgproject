/*     */ package com.fgoa.web.controller;
/*     */ 
/*     */ import com.alibaba.fastjson.JSONObject;
/*     */ import com.fgoa.web.inteceptor.inbox.CenterLeaderRoleInterceptor;
/*     */ import com.fgoa.web.inteceptor.inbox.InboxManagerRoleInterceptor;
/*     */ import com.fgoa.web.model.AddonFile;
/*     */ import com.fgoa.web.model.Depart;
/*     */ import com.fgoa.web.model.InboxInfo;
/*     */ import com.fgoa.web.model.InboxInfoDoc;
/*     */ import com.fgoa.web.model.InboxInfoOpinion;
/*     */ import com.fgoa.web.model.InboxInfoUserRel;
/*     */ import com.fgoa.web.model.InfoHistory;
/*     */ import com.fgoa.web.model.Role;
/*     */ import com.fgoa.web.model.SerialNumber;
/*     */ import com.fgoa.web.model.User;
/*     */ import com.fgoa.web.security.ShiroRealmUser;
/*     */ import com.fgoa.web.security.ShiroUtils;
/*     */ import com.fgoa.web.service.InboxService;
/*     */ import com.fgoa.web.service.InfoHistoryService;
/*     */ import com.fgoa.web.service.ShortMsgService;
/*     */ import com.fgoa.web.validator.InboxValidator;
/*     */ import com.jfinal.aop.Before;
/*     */ import com.jfinal.core.Controller;
/*     */ import com.jfinal.ext.interceptor.GET;
/*     */ import com.jfinal.plugin.activerecord.tx.Tx;
/*     */ import com.jfinal.upload.UploadFile;
/*     */ import com.woo.jfinal.exception.BizException;
/*     */ import com.woo.jfinal.utils.UUIDUtils;
/*     */ import java.io.IOException;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collections;
/*     */ import java.util.Date;
/*     */ import java.util.List;
/*     */ import javax.servlet.http.HttpServletRequest;
/*     */ import org.apache.commons.lang.StringUtils;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class InboxController
/*     */   extends Controller
/*     */ {
/*     */   @Before({InboxManagerRoleInterceptor.class})
/*     */   public void backLogList()
/*     */   {
/*  46 */     setAttr("inboxInfoList", 
/*  47 */       InboxInfo.dao
/*     */       
/*  49 */       .findInboxListNotByStatus(1));
/*  50 */     render("inbox5.ftl");
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   @Before({GET.class, InboxManagerRoleInterceptor.class})
/*     */   public void uploadPage()
/*     */   {
/*  58 */     render("inbox1.ftl");
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   @Before({InboxManagerRoleInterceptor.class})
/*     */   public void sendUploadFile()
/*     */   {
/*  66 */     if (!isPostMethod()) {
/*  67 */       redirect("/inbox/backLogList");
/*  68 */       return;
/*     */     }
/*     */     
/*  71 */     UploadFile file = getFile("file", "/temp/inboxfile", Integer.valueOf(52428800), 
/*  72 */       "utf-8");
/*     */     try {
/*  74 */       String subFileFolder = InboxService.instance.saveInboxFile(file, 
/*  75 */         getRequest());
/*  76 */       setAttr("subFileFolder", subFileFolder);
/*  77 */       render("inbox2.ftl");
/*  78 */       return;
/*     */     } catch (BizException e) {
/*  80 */       setAttr("errorMsg", e.getMessage());
/*     */     } catch (IOException e) {
/*  82 */       e.printStackTrace();
/*  83 */       setAttr("errorMsg", "上传文件时出现异常");
/*     */     }
/*  85 */     render("inbox1.ftl");
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   @Before({InboxManagerRoleInterceptor.class})
/*     */   public void handleDoc()
/*     */   {
/*  94 */     String subFileFolder = getPara("subFileFolder");
/*  95 */     if ((StringUtils.isBlank(subFileFolder)) || 
/*     */     
/*  97 */       (!InboxService.instance.isFileExist(subFileFolder, getRequest()))) {
/*  98 */       redirect("/inbox/backLogList");
/*  99 */       return;
/*     */     }
/* 101 */     setAttr("sortNum", SerialNumber.dao.getInboxSeralNum());
/* 102 */     setAttr("filePathList", InboxService.instance.findPicPathList(
/* 103 */       subFileFolder, getRequest()));
/* 104 */     setAttr("subFileFolder", subFileFolder);
/* 105 */     render("inbox3.ftl");
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   @Before({InboxValidator.class, Tx.class, InboxManagerRoleInterceptor.class})
/*     */   public void saveProcessInfo()
/*     */   {
/* 113 */     String subFileFolder = getPara("subFileFolder");
/* 114 */     String inboxInfoId = UUIDUtils.getRandomUUID();
/*     */     try {
/* 116 */       String title = getPara("title");
/* 117 */       String orgName = getPara("orgName");
/* 118 */       Date submitDate = getParaToDate("submitDate");
/* 119 */       String tag = getPara("tag");
/* 120 */       String sortNum = getPara("sortNum");
/* 121 */       Integer amountNum = getParaToInt("amount");
/* 122 */       int amount = amountNum == null ? 0 : amountNum.intValue();
/* 123 */       String addon = getPara("addon");
/* 124 */       String classification = getPara("classification");
/* 125 */       InboxInfo inboxInfo = 
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 131 */         (InboxInfo)((InboxInfo)((InboxInfo)((InboxInfo)((InboxInfo)((InboxInfo)((InboxInfo)((InboxInfo)((InboxInfo)((InboxInfo)((InboxInfo)new InboxInfo().set("title", title)).set("orgName", orgName)).set("submitDate", submitDate)).set("tag", tag)).set("sortNum", sortNum)).set("amount", Integer.valueOf(amount))).set("addon", addon)).set("classification", classification)).set("folder", subFileFolder)).set("id", inboxInfoId)).set("rejected", Integer.valueOf(1));
/* 132 */       InboxService.instance.saveInboxDoc(inboxInfo, subFileFolder, 
/* 133 */         getRequest());
/*     */     } catch (Exception e) {
/* 135 */       setAttr("errorMsg", e.getMessage());
/* 136 */       setAttr("subFileFolder", subFileFolder);
/* 137 */       render("inbox3.ftl");
/* 138 */       return;
/*     */     }
/*     */     
/* 141 */     setAttr("inboxInfoId", inboxInfoId);
/* 142 */     setAttr("leaders", User.dao.findUserListByRole("chief"));
/* 143 */     render("inbox4.ftl");
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   @Before({InboxManagerRoleInterceptor.class})
/*     */   public void saveLeaderInfo()
/*     */   {
/* 152 */     if (isPostMethod()) {
/* 153 */       String leaderId = getPara("leaderId");
/* 154 */       User leader = (User)User.dao.findById(leaderId);
/* 155 */       if (leader != null) {
/* 156 */         InboxInfo inboxInfo = 
/* 157 */           (InboxInfo)InboxInfo.dao.findById(getPara("inboxInfoId"));
/*     */         
/*     */ 
/* 160 */         ((InboxInfo)((InboxInfo)((InboxInfo)inboxInfo.set("leaderId", leaderId)).set("statusInfo", leader.get("realname"))).set("status", Integer.valueOf(0)))
/* 161 */           .update();
/*     */         
/* 163 */         InboxService.instance.saveInboxRel(null, new String[] { leaderId }, inboxInfo, ShiroUtils.getCurrentUserId());
/* 164 */         sendRemind(inboxInfo.getStr("id"));
/*     */       }
/*     */     }
/* 167 */     redirect("/inbox/backLogList");
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void inboxInfoDetail()
/*     */   {
/* 184 */     String inboxInfoId = getPara("inboxInfoId");
/*     */     
/* 186 */     InboxInfo inboxInfo = (InboxInfo)InboxInfo.dao.findById(inboxInfoId);
/*     */     
/* 188 */     if ((StringUtils.isBlank(inboxInfoId)) || (inboxInfo == null)) {
/* 189 */       renderError(404);
/* 190 */       return;
/*     */     }
/*     */     
/* 193 */     int index = 0;
/*     */     try {
/* 195 */       String indexStr = getPara("index");
/* 196 */       if (StringUtils.isNotBlank(indexStr)) {
/* 197 */         index = Integer.valueOf(indexStr).intValue();
/*     */       }
/* 199 */       if (index < 0) {
/* 200 */         index = 0;
/*     */       }
/*     */     } catch (Exception e) {
/* 203 */       e.printStackTrace();
/*     */     }
/* 205 */     setAttr("doc", 
/* 206 */       InboxInfoDoc.dao.findByInboxInfoIdAndIndex(inboxInfoId, index));
/* 207 */     setAttr("pageCount", Long.valueOf(InboxInfoDoc.dao.findDocNum(inboxInfoId)));
/* 208 */     setAttr("index", Integer.valueOf(index));
/* 209 */     setAttr("inboxInfoId", inboxInfoId);
/* 210 */     setAttr("addonList", AddonFile.dao.findById(inboxInfo.getStr("folder")));
/* 211 */     setAttr("status", inboxInfo.get("status"));
/* 212 */     setAttr("iiur", InboxInfoUserRel.dao.findByUserIdAndInfoId(ShiroUtils.getCurrentUserId(), inboxInfoId));
/* 213 */     if (inboxInfo.getInt("status").intValue() == 1) {
/* 214 */       setAttr("editable", Boolean.valueOf(false));
/*     */     } else {
/* 216 */       InboxInfoUserRel userRel = InboxInfoUserRel.dao.findByUserIdAndInfoId(ShiroUtils.getCurrentUserId(), inboxInfoId);
/* 217 */       if (userRel.getInt("active").intValue() == 1) {
/* 218 */         setAttr("editable", Boolean.valueOf(false));
/*     */       } else {
/* 220 */         setAttr("editable", Boolean.valueOf(true));
/*     */       }
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 234 */     int rejected = 1;
/*     */     try {
/* 236 */       rejected = inboxInfo.getInt("rejected").intValue();
/*     */     }
/*     */     catch (Exception localException1) {}
/*     */     
/* 240 */     if (rejected == 0) {
/* 241 */       setAttr("rejected", Boolean.valueOf(true));
/*     */     }
/*     */     
/*     */ 
/* 245 */     if ((Role.dao.isCurrentUserHasRole("centerleader")) || 
/* 246 */       (Role.dao.isCurrentUserHasRole("sectionchife")) || 
/* 247 */       (Role.dao.isCurrentUserHasRole("vicedirector")) || 
/* 248 */       (Role.dao.isCurrentUserHasRole("vicesectionchife"))) {
/* 249 */       if (inboxInfo.get("replyed") != null) {
/* 250 */         setAttr("isReplay", Boolean.valueOf(true));
/*     */       } else {
/* 252 */         setAttr("isRemark", Boolean.valueOf(true));
/*     */       }
/* 254 */     } else if (Role.dao.isCurrentUserHasRole("normaluser")) {
/* 255 */       setAttr("isReplay", Boolean.valueOf(true));
/*     */     }
/* 257 */     InboxService.instance.updateReadStatus(inboxInfoId, ShiroUtils.getCurrentUserId());
/* 258 */     render("inbox8.ftl");
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   @Before({CenterLeaderRoleInterceptor.class})
/*     */   public void leaderRemark()
/*     */   {
/* 266 */     String inboxInfoId = getPara("inboxInfoId");
/*     */     
/* 268 */     if (StringUtils.isBlank(inboxInfoId)) {
/* 269 */       renderError(404);
/* 270 */       return;
/*     */     }
/* 272 */     InboxInfo info = (InboxInfo)InboxInfo.dao.findById(inboxInfoId);
/* 273 */     if (info == null) {
/* 274 */       renderError(404);
/* 275 */       return;
/*     */     }
/* 277 */     setAttr("info", info);
/* 278 */     setAttr("contentList", InboxInfoDoc.dao.findByInboxInfoId(inboxInfoId));
/* 279 */     setAttr("inboxInfoId", inboxInfoId);
/* 280 */     setAttr("opinion", 
/* 281 */       InboxInfoOpinion.dao.findSingleOpinionById(inboxInfoId));
/* 282 */     render("inbox9.ftl");
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   @Before({CenterLeaderRoleInterceptor.class})
/*     */   public void saveLeaderRemark()
/*     */   {
/* 290 */     String inboxInfoId = getPara("inboxInfoId");
/*     */     
/* 292 */     if (StringUtils.isBlank(inboxInfoId)) {
/* 293 */       renderError(404);
/* 294 */       return;
/*     */     }
/* 296 */     InboxInfo info = (InboxInfo)InboxInfo.dao.findById(inboxInfoId);
/* 297 */     if (info == null) {
/* 298 */       renderError(404);
/* 299 */       return;
/*     */     }
/*     */     
/* 302 */     String opinionContent = getPara("opinionContent");
/* 303 */     String opinionId = getPara("opinionId");
/* 304 */     InboxInfoOpinion opinion = null;
/* 305 */     if (StringUtils.isNotBlank(opinionId)) {
/* 306 */       opinion = InboxInfoOpinion.dao.findSingleOpinionById(inboxInfoId);
/*     */     }
/*     */     
/* 309 */     if (opinion != null) {
/* 310 */       ((InboxInfoOpinion)opinion.set("content", opinionContent)).update();
/*     */ 
/*     */     }
/*     */     else
/*     */     {
/* 315 */       ((InboxInfoOpinion)((InboxInfoOpinion)((InboxInfoOpinion)((InboxInfoOpinion)((InboxInfoOpinion)((InboxInfoOpinion)new InboxInfoOpinion().set("id", UUIDUtils.getRandomUUID())).set("inboxId", inboxInfoId)).set("content", opinionContent)).set("userName", ShiroUtils.getCurrentUser().getRealName())).set("submitDate", new Date())).set("priority", Integer.valueOf(0))).save();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 322 */     if (Role.dao.isCurrentUserHasRole("centerleader")) {
/* 323 */       info.set("status", Integer.valueOf(2));
/* 324 */       redirect("/inbox/chooseMember?inboxInfoId=" + inboxInfoId);
/* 325 */     } else if (Role.dao.isCurrentUserHasRole("vicedirector")) {
/* 326 */       redirect("/inbox/vdDistributePage?inboxInfoId=" + 
/* 327 */         inboxInfoId);
/* 328 */     } else if ((Role.dao.isCurrentUserHasRole("sectionchife")) || 
/* 329 */       (Role.dao.isCurrentUserHasRole("vicesectionchife"))) {
/* 330 */       redirect("/inbox/scDistributePage?inboxInfoId=" + 
/* 331 */         inboxInfoId);
/*     */     }
/*     */   }
/*     */   
/*     */   public void remark() {
/* 336 */     String inboxInfoId = getPara("inboxInfoId");
/*     */     
/* 338 */     if (StringUtils.isBlank(inboxInfoId)) {
/* 339 */       renderError(404);
/* 340 */       return;
/*     */     }
/* 342 */     InboxInfo info = (InboxInfo)InboxInfo.dao.findById(inboxInfoId);
/* 343 */     if (info == null) {
/* 344 */       renderError(404);
/* 345 */       return;
/*     */     }
/* 347 */     setAttr("info", info);
/* 348 */     setAttr("contentList", InboxInfoDoc.dao.findByInboxInfoId(inboxInfoId));
/* 349 */     setAttr("inboxInfoId", inboxInfoId);
/* 350 */     setAttr("opinions", InboxInfoOpinion.dao.findOpinionsById(inboxInfoId));
/*     */     
/* 352 */     render("inbox9.ftl");
/*     */   }
/*     */   
/*     */   public void read() {
/* 356 */     String inboxInfoId = getPara("inboxInfoId");
/* 357 */     String type = getPara("type");
/*     */     
/*     */ 
/* 360 */     if (StringUtils.isBlank(inboxInfoId)) {
/* 361 */       renderError(404);
/* 362 */       return;
/*     */     }
/* 364 */     InboxInfo info = (InboxInfo)InboxInfo.dao.findById(inboxInfoId);
/* 365 */     if (info == null) {
/* 366 */       renderError(404);
/* 367 */       return;
/*     */     }
/*     */     
/* 370 */     if (StringUtils.equals(type, "admin")) {
/* 371 */       setAttr("infoUserRel", InboxInfoUserRel.dao.findByInboxInfoId(inboxInfoId));
/*     */     }
/* 373 */     setAttr("info", info);
/* 374 */     setAttr("contentList", InboxInfoDoc.dao.findByInboxInfoId(inboxInfoId));
/* 375 */     setAttr("inboxInfoId", inboxInfoId);
/* 376 */     setAttr("opinions", InboxInfoOpinion.dao.findOpinionsById(inboxInfoId));
/* 377 */     setAttr("ihList", InfoHistory.dao.findInfoHistory(inboxInfoId));
/*     */     
/* 379 */     render("inbox9-1.ftl");
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   @Before({CenterLeaderRoleInterceptor.class})
/*     */   public void chooseMember()
/*     */   {
/* 387 */     String inboxInfoId = getPara("inboxInfoId");
/*     */     
/* 389 */     if (StringUtils.isBlank(inboxInfoId)) {
/* 390 */       renderError(404);
/* 391 */       return;
/*     */     }
/* 393 */     InboxInfo info = (InboxInfo)InboxInfo.dao.findById(inboxInfoId);
/* 394 */     if (info == null) {
/* 395 */       renderError(404);
/* 396 */       return;
/*     */     }
/* 398 */     setAttr("inboxInfoId", inboxInfoId);
/*     */     
/*     */ 
/*     */ 
/* 402 */     List<User> viceDirector = User.dao.findUserByRoleExceptId("centerleader", ShiroUtils.getCurrentUserId());
/* 403 */     int zzlIndex = 0;
/* 404 */     for (int i = 0; i < viceDirector.size(); i++) {
/* 405 */       User user = (User)viceDirector.get(i);
/* 406 */       if ("周志琳".equals(user.get("realname"))) {
/* 407 */         zzlIndex = i;
/*     */       }
/*     */     }
/* 410 */     Collections.swap(viceDirector, 0, zzlIndex);
/* 411 */     setAttr("viceDirector", viceDirector);
/*     */     
/* 413 */     setAttr("departs", Depart.dao.findAll());
/*     */     
/* 415 */     List<User> userList = User.dao.findUserListByRole2();
/* 416 */     boolean flag = false;
/* 417 */     if (userList.size() > 0) {
/* 418 */       User user = (User)userList.get(0);
/* 419 */       String userId = user.getStr("ID");
/* 420 */       List<Role> roleList = Role.dao.find("select a.* from t_s_role a left join t_s_role_user b on a.ID = b.roleid where b.userid = '" + userId + "'");
/*     */       
/* 422 */       if (roleList.size() > 0) {
/* 423 */         Role role = (Role)roleList.get(0);
/* 424 */         String roleCode = role.getStr("rolecode");
/* 425 */         if ((roleCode.equals("sectionchife")) || (roleCode.equals("vicesectionchife"))) {
/* 426 */           flag = true;
/*     */         }
/*     */       }
/*     */     }
/*     */     
/* 431 */     if (flag) {
/* 432 */       List<User> list = new ArrayList();
/* 433 */       for (int i = 0; i < 4; i++) {
/* 434 */         list.add(new User());
/*     */       }
/* 436 */       for (int i = 0; i < userList.size(); i++) {
/* 437 */         User user = (User)userList.get(i);
/* 438 */         String realname = user.getStr("realname");
/*     */         
/* 440 */         if (realname.equals("汪静")) {
/* 441 */           list.remove(0);
/* 442 */           list.add(0, user);
/* 443 */         } else if (realname.equals("潘峰")) {
/* 444 */           list.remove(1);
/* 445 */           list.add(1, user);
/* 446 */         } else if (realname.equals("谭国林")) {
/* 447 */           list.remove(2);
/* 448 */           list.add(2, user);
/* 449 */         } else if (realname.equals("林坤")) {
/* 450 */           list.remove(3);
/* 451 */           list.add(3, user);
/*     */         }
/*     */       }
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 470 */       setAttr("user", list);
/*     */     } else {
/* 472 */       setAttr("user", User.dao.findUserListByRole2());
/*     */     }
/* 474 */     render("inbox10.ftl");
/*     */   }
/*     */   
/*     */   @Before({CenterLeaderRoleInterceptor.class})
/*     */   public void chooseMember2() {
/* 479 */     String inboxInfoId = getPara("inboxInfoId");
/*     */     
/* 481 */     if (StringUtils.isBlank(inboxInfoId)) {
/* 482 */       renderError(404);
/* 483 */       return;
/*     */     }
/* 485 */     InboxInfo info = (InboxInfo)InboxInfo.dao.findById(inboxInfoId);
/* 486 */     if (info == null) {
/* 487 */       renderError(404);
/* 488 */       return;
/*     */     }
/* 490 */     setAttr("inboxInfoId", inboxInfoId);
/*     */     
/*     */ 
/* 493 */     List<User> userList = User.dao.findUserListByRole2();
/* 494 */     boolean flag = false;
/* 495 */     if (userList.size() > 0) {
/* 496 */       User user = (User)userList.get(0);
/* 497 */       String userId = user.getStr("ID");
/* 498 */       List<Role> roleList = Role.dao.find("select a.* from t_s_role a left join t_s_role_user b on a.ID = b.roleid where b.userid = '" + userId + "'");
/*     */       
/* 500 */       if (roleList.size() > 0) {
/* 501 */         Role role = (Role)roleList.get(0);
/* 502 */         String roleCode = role.getStr("rolecode");
/* 503 */         if ((roleCode.equals("sectionchife")) || (roleCode.equals("vicesectionchife"))) {
/* 504 */           flag = true;
/*     */         }
/*     */       }
/*     */     }
/*     */     
/* 509 */     if (flag) {
/* 510 */       List<User> list = new ArrayList();
/* 511 */       for (int i = 0; i < 9; i++) {
/* 512 */         list.add(new User());
/*     */       }
/* 514 */       for (int i = 0; i < userList.size(); i++) {
/* 515 */         User user = (User)userList.get(i);
/* 516 */         String realname = user.getStr("realname");
/*     */         
/* 518 */         if (realname.equals("李晓鸣")) {
/* 519 */           list.remove(0);
/* 520 */           list.add(0, user);
/* 521 */         } else if (realname.equals("潘峰")) {
/* 522 */           list.remove(1);
/* 523 */           list.add(1, user);
/* 524 */         } else if (realname.equals("谭国林")) {
/* 525 */           list.remove(2);
/* 526 */           list.add(2, user);
/* 527 */         } else if (realname.equals("杨军")) {
/* 528 */           list.remove(3);
/* 529 */           list.add(3, user);
/* 530 */         } else if (realname.equals("汪静")) {
/* 531 */           list.remove(4);
/* 532 */           list.add(4, user);
/* 533 */         } else if (realname.equals("张红远")) {
/* 534 */           list.remove(5);
/* 535 */           list.add(5, user);
/* 536 */         } else if (realname.equals("孙红")) {
/* 537 */           list.remove(6);
/* 538 */           list.add(6, user);
/* 539 */         } else if (realname.equals("夏勇波")) {
/* 540 */           list.remove(7);
/* 541 */           list.add(7, user);
/*     */         }
/*     */       }
/* 544 */       setAttr("user", list);
/*     */     } else {
/* 546 */       setAttr("user", User.dao.findUserListByRole2());
/*     */     }
/*     */     
/*     */ 
/* 550 */     render("inbox12.ftl");
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   @Before({CenterLeaderRoleInterceptor.class})
/*     */   public void viceDirectors()
/*     */   {
/* 558 */     renderJson(User.dao.findViceDirectors());
/*     */   }
/*     */   
/*     */   public void saveChooseOrg() {
/* 562 */     String inboxInfoId = getPara("inboxInfoId");
/*     */     
/* 564 */     if (StringUtils.isBlank(inboxInfoId)) {
/* 565 */       renderError(404);
/* 566 */       return;
/*     */     }
/* 568 */     InboxInfo info = (InboxInfo)InboxInfo.dao.findById(inboxInfoId);
/* 569 */     if (info == null) {
/* 570 */       renderError(404);
/* 571 */       return;
/*     */     }
/* 573 */     String[] orgIds = getParaValues("orgId");
/* 574 */     String[] userIds = getParaValues("userId");
/*     */     
/* 576 */     InboxService.instance.saveInboxRel(orgIds, userIds, info, ShiroUtils.getCurrentUserId());
/*     */     
/* 578 */     ((InboxInfo)info.set("status", Integer.valueOf(3))).update();
/* 579 */     sendRemind(info.getStr("id"));
/* 580 */     redirect("/inbox/memeberReadList");
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void archiveList()
/*     */   {
/* 587 */     setAttr("inboxInfoList", 
/* 588 */       InboxInfo.dao
/* 589 */       .findInboxListByStatus(1));
/* 590 */     render("inbox6.ftl");
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void memberRemarkPage()
/*     */   {
/* 597 */     String inboxInfoId = getPara("inboxInfoId");
/*     */     
/* 599 */     if (StringUtils.isBlank(inboxInfoId)) {
/* 600 */       renderError(404);
/* 601 */       return;
/*     */     }
/* 603 */     InboxInfo info = (InboxInfo)InboxInfo.dao.findById(inboxInfoId);
/* 604 */     if (info == null) {
/* 605 */       renderError(404);
/* 606 */       return;
/*     */     }
/* 608 */     setAttr("info", info);
/* 609 */     setAttr("contentList", InboxInfoDoc.dao.findByInboxInfoId(inboxInfoId));
/* 610 */     setAttr("inboxInfoId", inboxInfoId);
/* 611 */     setAttr("opinions", InboxInfoOpinion.dao.findOpinionsById(inboxInfoId));
/*     */     
/* 613 */     if (getPara("print") != null) {
/* 614 */       render("inboxinfo_print.ftl");
/* 615 */       return;
/*     */     }
/* 617 */     render("inbox11.ftl");
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void memeberReadList()
/*     */   {
/* 624 */     setAttr("inboxInfoList", InboxInfo.dao.findMemberReadList(ShiroUtils.getCurrentUserId()));
/* 625 */     render("inbox7.ftl");
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void saveOpinion()
/*     */   {
/* 632 */     String inboxInfoId = getPara("inboxInfoId");
/*     */     
/* 634 */     if (StringUtils.isBlank(inboxInfoId)) {
/* 635 */       renderError(404);
/* 636 */       return;
/*     */     }
/* 638 */     InboxInfo info = (InboxInfo)InboxInfo.dao.findById(inboxInfoId);
/* 639 */     if (info == null) {
/* 640 */       renderError(404);
/* 641 */       return;
/*     */     }
/*     */     
/* 644 */     String opinionContent = getPara("opinionContent");
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 657 */     ((InboxInfoOpinion)((InboxInfoOpinion)((InboxInfoOpinion)((InboxInfoOpinion)((InboxInfoOpinion)((InboxInfoOpinion)new InboxInfoOpinion().set("id", UUIDUtils.getRandomUUID())).set("inboxId", inboxInfoId)).set("content", opinionContent)).set("userName", ShiroUtils.getCurrentUser().getRealName())).set("submitDate", new Date())).set("priority", Integer.valueOf(0))).save();
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 668 */     if (Role.dao.isCurrentUserHasRole("chief")) {
/* 669 */       info.set("status", Integer.valueOf(2));
/* 670 */       redirect("/inbox/chooseMember?inboxInfoId=" + inboxInfoId);
/* 671 */     } else if ((Role.dao.isCurrentUserHasRole("centerleader")) && (!Role.dao.isCurrentUserHasRole("chief"))) {
/* 672 */       redirect("/inbox/chooseMember2?inboxInfoId=" + inboxInfoId);
/* 673 */     } else if (Role.dao.isCurrentUserHasRole("vicedirector")) {
/* 674 */       redirect("/inbox/vdDistributePage?inboxInfoId=" + 
/* 675 */         inboxInfoId);
/* 676 */     } else if ((Role.dao.isCurrentUserHasRole("sectionchife")) || 
/* 677 */       (Role.dao.isCurrentUserHasRole("vicesectionchife"))) {
/* 678 */       redirect("/inbox/scDistributePage?inboxInfoId=" + 
/* 679 */         inboxInfoId);
/*     */     }
/*     */   }
/*     */   
/*     */   public void queryInbox() {
/* 684 */     if (!isPostMethod()) {
/* 685 */       redirect("/inbox/archiveList");
/* 686 */       return;
/*     */     }
/*     */     
/* 689 */     String queryStr = getPara("queryStr");
/*     */     
/* 691 */     Date startTime = getParaToDate("startTimeStr");
/* 692 */     Date endTime = getParaToDate("endTimeStr");
/*     */     
/* 694 */     setAttr("inboxInfoList", InboxInfo.dao.findInboxListByTitleAndStatus(
/* 695 */       queryStr, startTime, endTime, 
/* 696 */       1));
/*     */     
/* 698 */     keepPara();
/* 699 */     render("inbox6.ftl");
/*     */   }
/*     */   
/*     */   private boolean isPostMethod() {
/* 703 */     if (!StringUtils.equalsIgnoreCase("post", getRequest().getMethod())) {
/* 704 */       return false;
/*     */     }
/* 706 */     return true;
/*     */   }
/*     */   
/*     */   public void printContent() {
/* 710 */     String inboxInfoId = getPara("inboxInfoId");
/*     */     
/* 712 */     if (StringUtils.isBlank(inboxInfoId)) {
/* 713 */       renderError(404);
/* 714 */       return;
/*     */     }
/* 716 */     InboxInfo info = (InboxInfo)InboxInfo.dao.findById(inboxInfoId);
/* 717 */     if (info == null) {
/* 718 */       renderError(404);
/* 719 */       return;
/*     */     }
/*     */     
/* 722 */     setAttr("contentList", InboxInfoDoc.dao.findByInboxInfoId(inboxInfoId));
/*     */     
/* 724 */     render("inbox_content_print.ftl");
/*     */   }
/*     */   
/*     */   public void vdDistributePage()
/*     */   {
/* 729 */     String infoId = getPara("inboxInfoId");
/* 730 */     InboxInfo info = getInboxInfo();
/* 731 */     if (info == null) {
/* 732 */       renderError(404);
/* 733 */       return;
/*     */     }
/*     */     
/* 736 */     setAttr("inboxInfoId", infoId);
/*     */     
/* 738 */     setAttr("orgs", 
/* 739 */       Depart.dao.findChargeDeparts(ShiroUtils.getCurrentUserId()));
/* 740 */     render("distribute.ftl");
/*     */   }
/*     */   
/*     */   public void scDistributePage()
/*     */   {
/* 745 */     String infoId = getPara("inboxInfoId");
/* 746 */     InboxInfo info = getInboxInfo();
/* 747 */     if (info == null) {
/* 748 */       renderError(404);
/* 749 */       return;
/*     */     }
/*     */     
/* 752 */     setAttr("inboxInfoId", infoId);
/*     */     
/* 754 */     setAttr("members", User.dao.findUserByDepartIdAndRoleCode(
/* 755 */       "normaluser", ShiroUtils.getCurrentUserOrgId()));
/* 756 */     render("distribute.ftl");
/*     */   }
/*     */   
/*     */   private InboxInfo getInboxInfo()
/*     */   {
/* 761 */     String infoId = getPara("inboxInfoId");
/* 762 */     if (StringUtils.isBlank(infoId)) {
/* 763 */       return null;
/*     */     }
/* 765 */     InboxInfo info = (InboxInfo)InboxInfo.dao.findById(infoId);
/* 766 */     if (info == null) {
/* 767 */       return null;
/*     */     }
/* 769 */     return info;
/*     */   }
/*     */   
/*     */   public void replay()
/*     */   {
/* 774 */     InboxInfo info = getInboxInfo();
/* 775 */     if (info == null) {
/* 776 */       renderError(404);
/* 777 */       return;
/*     */     }
/*     */     
/*     */ 
/* 781 */     if (!Role.dao.isCurrentUserHasRole("normaluser")) {
/* 782 */       setAttr("isRejectAble", Boolean.valueOf(true));
/*     */     }
/*     */     
/*     */ 
/* 786 */     if (Role.dao.isCurrentUserHasRole("sectionchife")) {
/* 787 */       setAttr("isSelectAble", Boolean.valueOf(true));
/*     */     }
/*     */     
/* 790 */     if (Role.dao.isCurrentUserHasRole("centerleader")) {
/* 791 */       setAttr("isSelectAble", Boolean.valueOf(true));
/*     */     }
/*     */     
/* 794 */     if (info.getInt("status").intValue() == 1) {
/* 795 */       setAttr("editable", Boolean.valueOf(false));
/*     */     }
/*     */     
/* 798 */     int rejected = 1;
/*     */     try {
/* 800 */       rejected = info.getInt("rejected").intValue();
/*     */     }
/*     */     catch (Exception localException) {}
/*     */     
/* 804 */     if (rejected == 0) {
/* 805 */       setAttr("rejected", Boolean.valueOf(true));
/*     */     }
/* 807 */     String inboxInfoId = getPara("inboxInfoId");
/* 808 */     setAttr("leaders", User.dao.findUserListByRole("centerleader"));
/* 809 */     setAttr("addonList", AddonFile.dao.findById(info.getStr("folder")));
/* 810 */     setAttr("info", info);
/* 811 */     setAttr("ihList", InfoHistory.dao.findInfoHistory(info.getStr("id")));
/* 812 */     setAttr("contentList", InboxInfoDoc.dao.findByInboxInfoId(inboxInfoId));
/* 813 */     setAttr("inboxInfoId", inboxInfoId);
/* 814 */     setAttr("opinions", InboxInfoOpinion.dao.findOpinionsById(inboxInfoId));
/* 815 */     render("reply.ftl");
/*     */   }
/*     */   
/*     */   public void saveReplay()
/*     */   {
/* 820 */     InboxInfo info = getInboxInfo();
/* 821 */     if (info == null) {
/* 822 */       renderError(404);
/* 823 */       return;
/*     */     }
/*     */     
/* 826 */     String[] users = getParaValues("user");
/*     */     
/* 828 */     String content = getPara("replyContent");
/* 829 */     String rejectContent = getPara("rejectContent");
/* 830 */     if (StringUtils.isBlank(content)) {
/* 831 */       setAttr("errorMsg", "答复内容不能为空");
/* 832 */       setAttr("info", info);
/* 833 */       render("petition12.ftl");
/* 834 */       return;
/*     */     }
/* 836 */     InboxService.instance.saveApproval(content, info, users);
/* 837 */     if (rejectContent == null) {
/* 838 */       InfoHistoryService.instance.savePostHistory(ShiroUtils.getCurrentUserName(), info.getStr("id"), content, "回告");
/*     */     } else {
/* 840 */       InfoHistoryService.instance.savePostHistory(ShiroUtils.getCurrentUserName(), info.getStr("id"), rejectContent, "审批通过");
/*     */     }
/*     */     
/* 843 */     sendRemind(info.getStr("id"));
/* 844 */     redirect("/inbox/memeberReadList");
/*     */   }
/*     */   
/*     */ 
/*     */   public void saveReject()
/*     */   {
/* 850 */     InboxInfo info = getInboxInfo();
/* 851 */     if (info == null) {
/* 852 */       renderError(404);
/* 853 */       return;
/*     */     }
/*     */     
/* 856 */     String content = getPara("rejectContent");
/* 857 */     String replyContent = getPara("replyContent");
/* 858 */     if (StringUtils.isBlank(content)) {
/* 859 */       setAttr("errorMsg", "答复内容不能为空");
/* 860 */       setAttr("info", info);
/* 861 */       render("petition12.ftl");
/* 862 */       return;
/*     */     }
/* 864 */     InboxService.instance.saveReject(content, info);
/* 865 */     InfoHistoryService.instance.savePostHistory(ShiroUtils.getCurrentUserName(), info.getStr("id"), content, "驳回");
/* 866 */     sendRemind(info.getStr("id"));
/* 867 */     redirect("/inbox/memeberReadList");
/*     */   }
/*     */   
/*     */   public void remarkReaded()
/*     */   {
/* 872 */     InboxInfo info = getInboxInfo();
/* 873 */     if (info == null) {
/* 874 */       renderError(404);
/* 875 */       return;
/*     */     }
/* 877 */     InboxService.instance.deActiveRel(info.getStr("id"));
/* 878 */     ((InboxInfo)info.set("status", Integer.valueOf(1))).update();
/* 879 */     redirect("/inbox/memeberReadList");
/*     */   }
/*     */   
/*     */   public void remind()
/*     */   {
/* 884 */     String infoId = getPara("inboxInfoId");
/* 885 */     if (StringUtils.isBlank(infoId)) {
/* 886 */       return;
/*     */     }
/* 888 */     renderJson(sendRemind(infoId));
/*     */   }
/*     */   
/*     */   private JSONObject sendRemind(String infoId)
/*     */   {
/* 893 */     return ShortMsgService.instance.remindUser(Integer.valueOf(0), infoId);
/*     */   }
/*     */ }


/* Location:              E:\aaa\front\WEB-INF\classes\!\com\fgoa\web\controller\InboxController.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */