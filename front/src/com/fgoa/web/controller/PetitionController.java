/*     */ package com.fgoa.web.controller;
/*     */ 
/*     */ import com.alibaba.fastjson.JSONObject;
/*     */ import com.fgoa.web.inteceptor.inbox.CenterLeaderRoleInterceptor;
/*     */ import com.fgoa.web.model.AddonFile;
/*     */ import com.fgoa.web.model.Depart;
/*     */ import com.fgoa.web.model.PetitionInfo;
/*     */ import com.fgoa.web.model.PetitionInfoDoc;
/*     */ import com.fgoa.web.model.PetitionInfoOpinion;
/*     */ import com.fgoa.web.model.PetitionInfoUserRel;
/*     */ import com.fgoa.web.model.Role;
/*     */ import com.fgoa.web.model.SerialNumber;
/*     */ import com.fgoa.web.model.User;
/*     */ import com.fgoa.web.security.ShiroRealmUser;
/*     */ import com.fgoa.web.security.ShiroUtils;
/*     */ import com.fgoa.web.service.PetitionService;
/*     */ import com.fgoa.web.service.ShortMsgService;
/*     */ import com.fgoa.web.validator.PetitionValidator;
/*     */ import com.jfinal.aop.Before;
/*     */ import com.jfinal.core.Controller;
/*     */ import com.jfinal.ext.interceptor.POST;
/*     */ import com.jfinal.upload.UploadFile;
/*     */ import com.woo.jfinal.exception.BizException;
/*     */ import com.woo.jfinal.utils.UUIDUtils;
/*     */ import java.io.IOException;
/*     */ import java.util.Date;
/*     */ import javax.servlet.http.HttpServletRequest;
/*     */ import org.apache.commons.lang.StringUtils;
/*     */ 
/*     */ public class PetitionController
/*     */   extends Controller
/*     */ {
/*     */   public void managerPage()
/*     */   {
/*  35 */     setAttr("list", 
/*  36 */       PetitionInfo.dao
/*  37 */       .findListByStatus(0));
/*  38 */     render("petition5.ftl");
/*     */   }
/*     */   
/*     */   public void uploadPage()
/*     */   {
/*  43 */     render("petition1.ftl");
/*     */   }
/*     */   
/*     */   public void uploadFiles()
/*     */   {
/*  48 */     if (!isPostMethod()) {
/*  49 */       redirect("/petition/managerPage");
/*  50 */       return;
/*     */     }
/*     */     
/*  53 */     UploadFile file = getFile("file", "/temp/petitionfile", 
/*  54 */       Integer.valueOf(52428800), "utf-8");
/*     */     try {
/*  56 */       String subFileFolder = PetitionService.instance.savePetitionFile(
/*  57 */         file, getRequest());
/*     */       
/*  59 */       setAttr("subFileFolder", subFileFolder);
/*  60 */       render("petition2.ftl");
/*  61 */       return;
/*     */     } catch (BizException e) {
/*  63 */       setAttr("errorMsg", e.getMessage());
/*     */     } catch (IOException e) {
/*  65 */       e.printStackTrace();
/*  66 */       setAttr("errorMsg", "上传文件时出现异常");
/*     */     }
/*  68 */     render("petition1.ftl");
/*     */   }
/*     */   
/*     */   public void handleDocPage()
/*     */   {
/*  73 */     String subFileFolder = getPara("subFileFolder");
/*  74 */     if ((StringUtils.isBlank(subFileFolder)) || 
/*     */     
/*  76 */       (!PetitionService.instance.isFileExist(subFileFolder, getRequest()))) {
/*  77 */       redirect("/petition/managerPage");
/*  78 */       return;
/*     */     }
/*  80 */     setAttr("sortNum", SerialNumber.dao.getPetitionSerialNum());
/*  81 */     setAttr("filePathList", PetitionService.instance.findPicPathList(
/*  82 */       subFileFolder, getRequest()));
/*  83 */     setAttr("subFileFolder", subFileFolder);
/*  84 */     render("petition3.ftl");
/*     */   }
/*     */   
/*     */   @Before({PetitionValidator.class, POST.class})
/*     */   public void saveProcessInfo()
/*     */   {
/*  90 */     boolean sendToSectionMember = false;
/*     */     
/*  92 */     String sendToSectionMemberParam = getPara("sendToSectionMember");
/*  93 */     if (StringUtils.isNotBlank(sendToSectionMemberParam)) {
/*  94 */       sendToSectionMember = true;
/*     */     }
/*  96 */     String subFileFolder = getPara("subFileFolder");
/*  97 */     String petitionInfoId = UUIDUtils.getRandomUUID();
/*     */     try {
/*  99 */       String title = getPara("title");
/* 100 */       String source = getPara("source");
/* 101 */       String orgName = getPara("orgName");
/* 102 */       Date submitDate = getParaToDate("submitDate");
/* 103 */       String tag = getPara("tag");
/* 104 */       String sortNum = getPara("sortNum");
/* 105 */       Integer amountNum = getParaToInt("amount");
/* 106 */       int amount = amountNum == null ? 0 : amountNum.intValue();
/* 107 */       String addon = getPara("addon");
/* 108 */       String classification = getPara("classification");
/* 109 */       PetitionInfo petitionInfo = 
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 115 */         (PetitionInfo)((PetitionInfo)((PetitionInfo)((PetitionInfo)((PetitionInfo)((PetitionInfo)((PetitionInfo)((PetitionInfo)((PetitionInfo)((PetitionInfo)((PetitionInfo)((PetitionInfo)((PetitionInfo)new PetitionInfo().set("title", title)).set("orgName", orgName)).set("submitDate", submitDate)).set("tag", tag)).set("sortNum", sortNum)).set("source", source)).set("amount", Integer.valueOf(amount))).set("addon", addon)).set("classification", classification)).set("folder", subFileFolder)).set("id", petitionInfoId)).set("distributed", Integer.valueOf(1))).set("rejected", Integer.valueOf(1));
/*     */       
/* 117 */       PetitionService.instance.savePetitionDoc(petitionInfo, 
/* 118 */         subFileFolder, getRequest());
/*     */     } catch (Exception e) {
/* 120 */       setAttr("errorMsg", e.getLocalizedMessage());
/* 121 */       setAttr("subFileFolder", subFileFolder);
/* 122 */       setAttr("filePathList", PetitionService.instance.findPicPathList(
/* 123 */         subFileFolder, getRequest()));
/* 124 */       render("petition3.ftl");
/* 125 */       return;
/*     */     }
/*     */     
/* 128 */     setAttr("petitionInfoId", petitionInfoId);
/*     */     
/* 130 */     if (sendToSectionMember) {
/* 131 */       setAttr("petitionManagers", User.dao.findUserListByRole("petitionmanager"));
/* 132 */       render("petitionManagerSel.ftl");
/*     */     } else {
/* 134 */       setAttr("leaders", User.dao.findUserListByRole("chief"));
/*     */       
/* 136 */       render("petition4.ftl");
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public void saveLeaderInfo()
/*     */   {
/* 143 */     String petitionInfoId = getPara("petitionInfoId");
/*     */     
/* 145 */     if (StringUtils.isBlank(petitionInfoId)) {
/* 146 */       renderError(404);
/* 147 */       return;
/*     */     }
/* 149 */     PetitionInfo info = (PetitionInfo)PetitionInfo.dao.findById(petitionInfoId);
/* 150 */     if (info == null) {
/* 151 */       renderError(404);
/* 152 */       return;
/*     */     }
/*     */     
/* 155 */     if (isPostMethod()) {
/* 156 */       String leaderId = getPara("leaderId");
/* 157 */       User leader = (User)User.dao.findById(leaderId);
/* 158 */       if (leader != null)
/*     */       {
/*     */ 
/*     */ 
/* 162 */         ((PetitionInfoUserRel)((PetitionInfoUserRel)((PetitionInfoUserRel)((PetitionInfoUserRel)new PetitionInfoUserRel().set("userId", leaderId)).set("petitionId", getPara("petitionInfoId"))).set("active", Integer.valueOf(0))).set("isReaded", Integer.valueOf(0))).save();
/*     */         
/*     */ 
/* 165 */         ((PetitionInfo)((PetitionInfo)info.set("statusInfo", leader.get("realname"))).set("status", Integer.valueOf(0)))
/* 166 */           .update();
/* 167 */         sendRemind(info.getStr("id"));
/*     */       }
/*     */     }
/* 170 */     redirect("/petition/managerPage");
/*     */   }
/*     */   
/*     */   public void savePetitionManager() {
/* 174 */     String petitionInfoId = getPara("petitionInfoId");
/*     */     
/* 176 */     if (StringUtils.isBlank(petitionInfoId)) {
/* 177 */       renderError(404);
/* 178 */       return;
/*     */     }
/* 180 */     PetitionInfo info = (PetitionInfo)PetitionInfo.dao.findById(petitionInfoId);
/* 181 */     if (info == null) {
/* 182 */       renderError(404);
/* 183 */       return;
/*     */     }
/*     */     
/* 186 */     if (isPostMethod()) {
/* 187 */       String userId = getPara("userId");
/* 188 */       User user = (User)User.dao.findById(userId);
/* 189 */       if (user != null)
/*     */       {
/*     */ 
/*     */ 
/* 193 */         ((PetitionInfoUserRel)((PetitionInfoUserRel)((PetitionInfoUserRel)((PetitionInfoUserRel)new PetitionInfoUserRel().set("userId", userId)).set("petitionId", petitionInfoId)).set("active", Integer.valueOf(0))).set("isReaded", Integer.valueOf(0))).save();
/*     */         
/* 195 */         User sectionLeader = User.dao.findSectionChife(user.getStr("departid"));
/* 196 */         if (sectionLeader != null)
/*     */         {
/*     */ 
/* 199 */           ((PetitionInfoUserRel)((PetitionInfoUserRel)((PetitionInfoUserRel)((PetitionInfoUserRel)new PetitionInfoUserRel().set("userId", sectionLeader.get("ID"))).set("petitionId", petitionInfoId)).set("active", Integer.valueOf(1))).set("isReaded", Integer.valueOf(0))).save();
/*     */         }
/* 201 */         sendRemind(info.getStr("id"));
/*     */         
/*     */ 
/* 204 */         ((PetitionInfo)((PetitionInfo)info.set("statusInfo", user.get("realname"))).set("status", Integer.valueOf(0)))
/* 205 */           .update();
/*     */       }
/*     */     }
/* 208 */     redirect("/petition/managerPage");
/*     */   }
/*     */   
/*     */ 
/*     */   public void archivePage()
/*     */   {
/* 214 */     String queryStr = getPara("queryStr");
/* 215 */     if (StringUtils.isBlank(queryStr)) {
/* 216 */       setAttr("petitionInfoList", 
/* 217 */         PetitionInfo.dao
/* 218 */         .findListByStatus(1));
/*     */     } else {
/* 220 */       setAttr("queryStr", queryStr);
/* 221 */       setAttr("petitionInfoList", 
/* 222 */         PetitionInfo.dao.findPetitionListByTitleAndStatus(queryStr, 
/* 223 */         1));
/*     */     }
/* 225 */     render("petition6.ftl");
/*     */   }
/*     */   
/*     */   public void memberPage()
/*     */   {
/* 230 */     setAttr("petitionInfoList", PetitionInfo.dao.findMemberReadList(ShiroUtils.getCurrentUserId()));
/* 231 */     render("petition7.ftl");
/*     */   }
/*     */   
/*     */   public void delete() {
/* 235 */     String petitionInfoId = getPara("petitionInfoId");
/*     */     
/* 237 */     if (StringUtils.isBlank(petitionInfoId)) {
/* 238 */       renderError(404);
/* 239 */       return;
/*     */     }
/* 241 */     PetitionInfo info = (PetitionInfo)PetitionInfo.dao.findById(petitionInfoId);
/* 242 */     if (info == null) {
/* 243 */       renderError(404);
/* 244 */       return;
/*     */     }
/*     */     
/* 247 */     PetitionService.instance.delete(info, ShiroUtils.getCurrentUserId());
/*     */     
/* 249 */     redirect("/petition/memberPage");
/*     */   }
/*     */   
/*     */   public void infoDetial()
/*     */   {
/* 254 */     String petitionInfoId = getPara("petitionInfoId");
/*     */     
/* 256 */     PetitionInfo petitionInfo = (PetitionInfo)PetitionInfo.dao.findById(petitionInfoId);
/*     */     
/* 258 */     if ((StringUtils.isBlank(petitionInfoId)) || (petitionInfo == null)) {
/* 259 */       renderError(404);
/* 260 */       return;
/*     */     }
/*     */     
/* 263 */     int index = 0;
/*     */     try {
/* 265 */       String indexStr = getPara("index");
/* 266 */       if (StringUtils.isNotBlank(indexStr)) {
/* 267 */         index = Integer.valueOf(indexStr).intValue();
/*     */       }
/* 269 */       if (index < 0) {
/* 270 */         index = 0;
/*     */       }
/*     */     } catch (Exception e) {
/* 273 */       e.printStackTrace();
/*     */     }
/* 275 */     setAttr("doc", PetitionInfoDoc.dao.findByPetitionInfoIdAndIndex(
/* 276 */       petitionInfoId, index));
/* 277 */     setAttr("pageCount", Long.valueOf(PetitionInfoDoc.dao.findDocNum(petitionInfoId)));
/* 278 */     setAttr("index", Integer.valueOf(index));
/* 279 */     setAttr("petitionInfoId", petitionInfoId);
/* 280 */     setAttr("addonList", AddonFile.dao.findById(petitionInfo.getStr("folder")));
/* 281 */     if (petitionInfo.getInt("status").intValue() == 1) {
/* 282 */       setAttr("editable", Boolean.valueOf(false));
/*     */     }
/* 284 */     if (petitionInfo.getInt("rejected").intValue() == 0) {
/* 285 */       setAttr("rejected", Boolean.valueOf(true));
/*     */     }
/*     */     
/*     */ 
/* 289 */     if ((Role.dao.isCurrentUserHasRole("centerleader")) || 
/* 290 */       (Role.dao.isCurrentUserHasRole("sectionchife")) || 
/* 291 */       (Role.dao.isCurrentUserHasRole("vicedirector")) || 
/* 292 */       (Role.dao.isCurrentUserHasRole("vicesectionchife"))) {
/* 293 */       if (petitionInfo.get("replyed") != null) {
/* 294 */         setAttr("isReplay", Boolean.valueOf(true));
/*     */       } else {
/* 296 */         setAttr("isRemark", Boolean.valueOf(true));
/*     */       }
/* 298 */     } else if (Role.dao.isCurrentUserHasRole("normaluser")) {
/* 299 */       setAttr("isReplay", Boolean.valueOf(true));
/*     */     }
/* 301 */     PetitionService.instance.updateReadStatus(petitionInfoId, ShiroUtils.getCurrentUserId());
/* 302 */     render("petition8.ftl");
/*     */   }
/*     */   
/*     */   public void remark() {
/* 306 */     String petitionInfoId = getPara("petitionInfoId");
/*     */     
/* 308 */     if (StringUtils.isBlank(petitionInfoId)) {
/* 309 */       renderError(404);
/* 310 */       return;
/*     */     }
/* 312 */     PetitionInfo info = (PetitionInfo)PetitionInfo.dao.findById(petitionInfoId);
/* 313 */     if (info == null) {
/* 314 */       renderError(404);
/* 315 */       return;
/*     */     }
/* 317 */     setAttr("info", info);
/* 318 */     setAttr("contentList", 
/* 319 */       PetitionInfoDoc.dao.findByPetitionInfoId(petitionInfoId));
/* 320 */     setAttr("petitionInfoId", petitionInfoId);
/* 321 */     setAttr("opinions", PetitionInfoOpinion.dao.findOthersOpinionsById(
/* 322 */       petitionInfoId, ShiroUtils.getCurrentUserId()));
/* 323 */     setAttr("opinion", PetitionInfoOpinion.dao.findSingleOpinionById(
/* 324 */       petitionInfoId, ShiroUtils.getCurrentUserId()));
/* 325 */     render("petition9.ftl");
/*     */   }
/*     */   
/*     */   public void saveRemark() {
/* 329 */     String petitionInfoId = getPara("petitionInfoId");
/*     */     
/* 331 */     if (StringUtils.isBlank(petitionInfoId)) {
/* 332 */       renderError(404);
/* 333 */       return;
/*     */     }
/* 335 */     PetitionInfo info = (PetitionInfo)PetitionInfo.dao.findById(petitionInfoId);
/* 336 */     if (info == null) {
/* 337 */       renderError(404);
/* 338 */       return;
/*     */     }
/*     */     
/* 341 */     String opinionContent = getPara("opinionContent");
/* 342 */     String opinionId = getPara("opinionId");
/* 343 */     PetitionInfoOpinion opinion = null;
/* 344 */     if (StringUtils.isNotBlank(opinionId)) {
/* 345 */       opinion = PetitionInfoOpinion.dao.findSingleOpinionById(
/* 346 */         petitionInfoId, ShiroUtils.getCurrentUserId());
/*     */     }
/*     */     
/* 349 */     if (opinion != null) {
/* 350 */       ((PetitionInfoOpinion)opinion.set("content", opinionContent)).update();
/*     */ 
/*     */ 
/*     */     }
/*     */     else
/*     */     {
/*     */ 
/* 357 */       ((PetitionInfoOpinion)((PetitionInfoOpinion)((PetitionInfoOpinion)((PetitionInfoOpinion)((PetitionInfoOpinion)((PetitionInfoOpinion)((PetitionInfoOpinion)new PetitionInfoOpinion().set("id", UUIDUtils.getRandomUUID())).set("petitionId", petitionInfoId)).set("content", opinionContent)).set("userName", ShiroUtils.getCurrentUser().getRealName())).set("userId", ShiroUtils.getCurrentUserId())).set("submitDate", new Date())).set("priority", Integer.valueOf(0))).save();
/*     */     }
/*     */     
/* 360 */     if (Role.dao.isCurrentUserHasRole("centerleader")) {
/* 361 */       info.set("status", Integer.valueOf(2));
/* 362 */       redirect("/petition/chooseMember?petitionInfoId=" + petitionInfoId);
/* 363 */     } else if (Role.dao.isCurrentUserHasRole("vicedirector")) {
/* 364 */       redirect("/petition/vdDistributePage?petitionInfoId=" + 
/* 365 */         petitionInfoId);
/* 366 */     } else if ((Role.dao.isCurrentUserHasRole("sectionchife")) || 
/* 367 */       (Role.dao.isCurrentUserHasRole("vicesectionchife"))) {
/* 368 */       redirect("/petition/scDistributePage?petitionInfoId=" + 
/* 369 */         petitionInfoId);
/*     */     }
/*     */   }
/*     */   
/*     */   @Before({CenterLeaderRoleInterceptor.class})
/*     */   public void chooseMember()
/*     */   {
/* 376 */     String petitionInfoId = getPara("petitionInfoId");
/*     */     
/* 378 */     if (StringUtils.isBlank(petitionInfoId)) {
/* 379 */       renderError(404);
/* 380 */       return;
/*     */     }
/* 382 */     PetitionInfo info = (PetitionInfo)PetitionInfo.dao.findById(petitionInfoId);
/* 383 */     if (info == null) {
/* 384 */       renderError(404);
/* 385 */       return;
/*     */     }
/* 387 */     setAttr("petitionInfoId", petitionInfoId);
/* 388 */     if (Role.dao.isCurrentUserHasRole("chief")) {
/* 389 */       setAttr("viceDirector", User.dao.findUserByRoleExceptId("centerleader", ShiroUtils.getCurrentUserId()));
/* 390 */     } else if ((Role.dao.isCurrentUserHasRole("centerleader")) && (!Role.dao.isCurrentUserHasRole("chief")))
/*     */     {
/* 392 */       setAttr("user", User.dao.findUserListByRole2());
/*     */     }
/*     */     
/*     */ 
/*     */ 
/* 397 */     render("petition10.ftl");
/*     */   }
/*     */   
/*     */   @Before({CenterLeaderRoleInterceptor.class})
/*     */   public void chooseMember2() {
/* 402 */     String petitionInfoId = getPara("petitionInfoId");
/*     */     
/* 404 */     if (StringUtils.isBlank(petitionInfoId)) {
/* 405 */       renderError(404);
/* 406 */       return;
/*     */     }
/* 408 */     PetitionInfo info = (PetitionInfo)PetitionInfo.dao.findById(petitionInfoId);
/* 409 */     if (info == null) {
/* 410 */       renderError(404);
/* 411 */       return;
/*     */     }
/* 413 */     setAttr("petitionInfoId", petitionInfoId);
/* 414 */     setAttr("departs", User.dao.findUserListByRole("sectionchife"));
/* 415 */     render("petition10.ftl");
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   @Before({CenterLeaderRoleInterceptor.class})
/*     */   public void viceDirectors()
/*     */   {
/* 423 */     renderJson(User.dao.findViceDirectors());
/*     */   }
/*     */   
/*     */   public void saveChooseUsers()
/*     */   {
/* 428 */     String petitionInfoId = getPara("petitionInfoId");
/* 429 */     if (StringUtils.isBlank(petitionInfoId)) {
/* 430 */       renderError(404);
/* 431 */       return;
/*     */     }
/* 433 */     PetitionInfo info = (PetitionInfo)PetitionInfo.dao.findById(petitionInfoId);
/* 434 */     if (info == null) {
/* 435 */       renderError(404);
/* 436 */       return;
/*     */     }
/*     */     
/* 439 */     String[] orgIds = getParaValues("orgId");
/* 440 */     String[] userIds = getParaValues("userId");
/*     */     
/* 442 */     PetitionService.instance.savePetionRel(orgIds, userIds, info, ShiroUtils.getCurrentUserId());
/* 443 */     sendRemind(info.getStr("id"));
/* 444 */     ((PetitionInfo)info.set("status", Integer.valueOf(3)))
/* 445 */       .update();
/* 446 */     redirect("/petition/memberPage");
/*     */   }
/*     */   
/*     */   public void vdDistributePage()
/*     */   {
/* 451 */     String petitionInfoId = getPara("petitionInfoId");
/* 452 */     PetitionInfo info = getPetitionInfo();
/* 453 */     if (info == null) {
/* 454 */       renderError(404);
/* 455 */       return;
/*     */     }
/*     */     
/* 458 */     setAttr("petitionInfoId", petitionInfoId);
/*     */     
/* 460 */     setAttr("orgs", 
/* 461 */       Depart.dao.findChargeDeparts(ShiroUtils.getCurrentUserId()));
/* 462 */     render("distribute.ftl");
/*     */   }
/*     */   
/*     */   public void scDistributePage()
/*     */   {
/* 467 */     String petitionInfoId = getPara("petitionInfoId");
/* 468 */     PetitionInfo info = getPetitionInfo();
/* 469 */     if (info == null) {
/* 470 */       renderError(404);
/* 471 */       return;
/*     */     }
/*     */     
/* 474 */     setAttr("petitionInfoId", petitionInfoId);
/*     */     
/* 476 */     setAttr("members", User.dao.findUserByDepartIdAndRoleCode(
/* 477 */       "normaluser", ShiroUtils.getCurrentUserOrgId()));
/* 478 */     render("distribute.ftl");
/*     */   }
/*     */   
/*     */   public void replay()
/*     */   {
/* 483 */     PetitionInfo info = getPetitionInfo();
/* 484 */     if (info == null) {
/* 485 */       renderError(404);
/* 486 */       return;
/*     */     }
/*     */     
/*     */ 
/* 490 */     if (!Role.dao.isCurrentUserHasRole("normaluser")) {
/* 491 */       setAttr("isRejectAble", Boolean.valueOf(true));
/*     */     }
/* 493 */     if (info.getInt("status").intValue() == 1) {
/* 494 */       setAttr("editable", Boolean.valueOf(false));
/*     */     }
/* 496 */     if (info.getInt("rejected").intValue() == 0) {
/* 497 */       setAttr("rejected", Boolean.valueOf(true));
/*     */     }
/* 499 */     setAttr("addonList", AddonFile.dao.findById(info.getStr("folder")));
/* 500 */     setAttr("info", info);
/* 501 */     render("petition12.ftl");
/*     */   }
/*     */   
/*     */   public void saveReplay()
/*     */   {
/* 506 */     PetitionInfo info = getPetitionInfo();
/* 507 */     if (info == null) {
/* 508 */       renderError(404);
/*     */     }
/* 510 */     String content = getPara("replyContent");
/* 511 */     if (StringUtils.isBlank(content)) {
/* 512 */       setAttr("errorMsg", "答复内容不能为空");
/* 513 */       setAttr("info", info);
/* 514 */       render("petition12.ftl");
/* 515 */       return;
/*     */     }
/* 517 */     PetitionService.instance.saveApproval(content, info, ShiroUtils.getCurrentUserId());
/* 518 */     sendRemind(info.getStr("id"));
/* 519 */     redirect("/petition/memberPage");
/*     */   }
/*     */   
/*     */ 
/*     */   public void saveReject()
/*     */   {
/* 525 */     PetitionInfo info = getPetitionInfo();
/* 526 */     if (info == null) {
/* 527 */       renderError(404);
/*     */     }
/* 529 */     String content = getPara("rejectContent");
/* 530 */     if (StringUtils.isBlank(content)) {
/* 531 */       setAttr("errorMsg", "答复内容不能为空");
/* 532 */       setAttr("info", info);
/* 533 */       render("petition12.ftl");
/* 534 */       return;
/*     */     }
/* 536 */     PetitionService.instance.saveReject(content, info, ShiroUtils.getCurrentUserId());
/* 537 */     sendRemind(info.getStr("id"));
/* 538 */     redirect("/petition/memberPage");
/*     */   }
/*     */   
/*     */   public void printInfo()
/*     */   {
/* 543 */     String petitionInfoId = getPara("petitionInfoId");
/*     */     
/* 545 */     PetitionInfo petitionInfo = (PetitionInfo)PetitionInfo.dao.findById(petitionInfoId);
/*     */     
/* 547 */     if ((StringUtils.isBlank(petitionInfoId)) || (petitionInfo == null)) {
/* 548 */       renderError(404);
/* 549 */       return;
/*     */     }
/* 551 */     setAttr("info", petitionInfo);
/* 552 */     setAttr("opinions", 
/* 553 */       PetitionInfoOpinion.dao.findOpinionsById(petitionInfoId));
/* 554 */     render("infoprint.ftl");
/*     */   }
/*     */   
/*     */   private boolean isPostMethod() {
/* 558 */     if (!StringUtils.equalsIgnoreCase("post", getRequest().getMethod())) {
/* 559 */       return false;
/*     */     }
/* 561 */     return true;
/*     */   }
/*     */   
/*     */   private PetitionInfo getPetitionInfo()
/*     */   {
/* 566 */     String petitionInfoId = getPara("petitionInfoId");
/* 567 */     if (!PetitionInfo.dao.isPetitionRel(petitionInfoId)) {
/* 568 */       return null;
/*     */     }
/* 570 */     if (StringUtils.isBlank(petitionInfoId)) {
/* 571 */       return null;
/*     */     }
/* 573 */     PetitionInfo info = (PetitionInfo)PetitionInfo.dao.findById(petitionInfoId);
/* 574 */     if (info == null) {
/* 575 */       return null;
/*     */     }
/* 577 */     return info;
/*     */   }
/*     */   
/*     */   public void viewReplay() {
/* 581 */     String petitionInfoId = getPara("petitionInfoId");
/*     */     
/* 583 */     if (StringUtils.isBlank(petitionInfoId)) {
/* 584 */       renderError(404);
/* 585 */       return;
/*     */     }
/* 587 */     PetitionInfo info = (PetitionInfo)PetitionInfo.dao.findById(petitionInfoId);
/* 588 */     if (info == null) {
/* 589 */       renderError(404);
/* 590 */       return;
/*     */     }
/*     */     
/* 593 */     setAttr("addonList", AddonFile.dao.findById(info.getStr("folder")));
/* 594 */     setAttr("info", info);
/* 595 */     render("viewReplay.ftl");
/*     */   }
/*     */   
/*     */ 
/*     */   public void remind()
/*     */   {
/* 601 */     String infoId = getPara("petitionInfoId");
/* 602 */     if (StringUtils.isBlank(infoId)) {
/* 603 */       return;
/*     */     }
/*     */     
/* 606 */     renderJson(sendRemind(infoId));
/*     */   }
/*     */   
/*     */   private JSONObject sendRemind(String infoId)
/*     */   {
/* 611 */     return ShortMsgService.instance.remindUser(Integer.valueOf(1), infoId);
/*     */   }
/*     */ }


/* Location:              E:\aaa\front\WEB-INF\classes\!\com\fgoa\web\controller\PetitionController.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */