/*     */ package com.fgoa.web.controller;
/*     */ 
/*     */ import com.alibaba.fastjson.JSONObject;
/*     */ import com.fgoa.web.model.AddonFile;
/*     */ import com.fgoa.web.model.Depart;
/*     */ import com.fgoa.web.model.PostHistory;
/*     */ import com.fgoa.web.model.PostInfo;
/*     */ import com.fgoa.web.model.PostUserRel;
/*     */ import com.fgoa.web.model.Role;
/*     */ import com.fgoa.web.model.SerialNumber;
/*     */ import com.fgoa.web.model.User;
/*     */ import com.fgoa.web.security.ShiroRealmUser;
/*     */ import com.fgoa.web.security.ShiroUtils;
/*     */ import com.fgoa.web.service.PostHistoryService;
/*     */ import com.fgoa.web.service.PostService;
/*     */ import com.fgoa.web.service.ShortMsgService;
/*     */ import com.fgoa.web.validator.PostValidator;
/*     */ import com.jfinal.aop.Before;
/*     */ import com.jfinal.core.Controller;
/*     */ import com.jfinal.ext.interceptor.POST;
/*     */ import com.woo.jfinal.exception.BizException;
/*     */ import com.woo.jfinal.utils.UUIDUtils;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Date;
/*     */ import java.util.List;
/*     */ import org.apache.commons.lang.StringUtils;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class PostController
/*     */   extends Controller
/*     */ {
/*     */   public void postList()
/*     */   {
/*  36 */     setAttr("postList", PostInfo.dao.findUserPost(ShiroUtils.getCurrentUserId()));
/*  37 */     if (ShiroUtils.getCurrentUserRoles().contains("normaluser")) {
/*  38 */       setAttr("postable", Boolean.valueOf(true));
/*     */     } else {
/*  40 */       setAttr("postable", Boolean.valueOf(false));
/*     */     }
/*  42 */     render("posting4.ftl");
/*     */   }
/*     */   
/*     */   public void managerPostList() {
/*  46 */     String queryStr = getPara("queryStr");
/*  47 */     Date startTime = getParaToDate("startTime");
/*  48 */     Date endTime = getParaToDate("endTime");
/*  49 */     String sortNumStr = getPara("sortNum");
/*  50 */     setAttr("postList", 
/*  51 */       PostInfo.dao.findUserPostByStr(startTime, endTime, queryStr, sortNumStr));
/*  52 */     keepPara();
/*  53 */     render("posting6.ftl");
/*     */   }
/*     */   
/*     */   public void managerPostList2() {
/*  57 */     setAttr("postList", 
/*  58 */       PostInfo.dao.findIncompletePost());
/*  59 */     keepPara();
/*  60 */     render("posting6-1.ftl");
/*     */   }
/*     */   
/*     */   public void newPostInfo()
/*     */   {
/*  65 */     setAttr("sortNum", SerialNumber.dao.getPostSerialNum());
/*  66 */     render("posting2.ftl");
/*     */   }
/*     */   
/*     */   public void delete() {
/*  70 */     PostInfo postInfo = getPostInfoInRequest();
/*  71 */     if (postInfo == null) {
/*  72 */       renderError(404);
/*  73 */       return;
/*     */     }
/*  75 */     PostService.instance.delete(postInfo, ShiroUtils.getCurrentUserId());
/*     */     
/*  77 */     redirect("/post/postList");
/*     */   }
/*     */   
/*     */ 
/*     */   @Before({PostValidator.class, POST.class})
/*     */   public void savePostInfo()
/*     */   {
/*  84 */     String departName = getPara("departName");
/*  85 */     String sortNum = getPara("sortNum");
/*  86 */     String classfication = getPara("classfication");
/*  87 */     String title = getPara("title");
/*  88 */     String keyWords = getPara("keyWords");
/*  89 */     String to = getPara("to");
/*  90 */     String cc = getPara("cc");
/*  91 */     String from = getPara("from");
/*  92 */     String id = UUIDUtils.getRandomUUIDString();
/*  93 */     boolean result = 
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 102 */       ((PostInfo)((PostInfo)((PostInfo)((PostInfo)((PostInfo)((PostInfo)((PostInfo)((PostInfo)((PostInfo)((PostInfo)((PostInfo)((PostInfo)((PostInfo)((PostInfo)((PostInfo)((PostInfo)new PostInfo().set("departName", departName)).set("sortNum", sortNum)).set("classfication", classfication)).set("title", title)).set("keyWords", keyWords)).set("to", to)).set("cc", cc)).set("from", from)).set("status", Integer.valueOf(0))).set("statusInfo", "审核中")).set("submitTime", new Date())).set("createUserId", ShiroUtils.getCurrentUserId())).set("from", ShiroUtils.getCurrentUserName())).set("id", id)).set("postManager", ShiroUtils.getCurrentUser().getRealName())).set("postManagerTime", new Date())).save();
/*     */     
/* 104 */     if (result)
/*     */     {
/*     */ 
/* 107 */       ((PostUserRel)((PostUserRel)((PostUserRel)new PostUserRel().set("postid", id)).set("userid", ShiroUtils.getCurrentUserId())).set("active", Integer.valueOf(1))).save();
/* 108 */       setAttr("postInfoId", id);
/* 109 */       List<User> userList = User.dao.findUserListByRole2();
/*     */       
/* 111 */       List<User> list = new ArrayList();
/* 112 */       for (int i = 0; i < 4; i++) {
/* 113 */         list.add(new User());
/*     */       }
/* 115 */       for (int i = 0; i < userList.size(); i++) {
/* 116 */         User user = (User)userList.get(i);
/* 117 */         String realname = user.getStr("realname");
/*     */         
/* 119 */         if (realname.equals("汪静")) {
/* 120 */           list.remove(0);
/* 121 */           list.add(0, user);
/* 122 */         } else if (realname.equals("潘峰")) {
/* 123 */           list.remove(1);
/* 124 */           list.add(1, user);
/* 125 */         } else if (realname.equals("谭国林")) {
/* 126 */           list.remove(2);
/* 127 */           list.add(2, user);
/* 128 */         } else if (realname.equals("林坤")) {
/* 129 */           list.remove(3);
/* 130 */           list.add(3, user);
/*     */         }
/*     */       }
/*     */       
/* 134 */       setAttr("user", list);
/* 135 */       render("posting1.ftl");
/*     */     } else {
/* 137 */       keepPara();
/* 138 */       setAttr("errorMsg", "保存收文信息单出现错误");
/* 139 */       render("posting2.ftl");
/*     */     }
/*     */   }
/*     */   
/*     */   public void viewArchiveDetail() {
/* 144 */     String postInfoId = getPara("postInfoId");
/* 145 */     PostInfo postInfo = getPostInfoInRequest();
/* 146 */     if (postInfo == null) {
/* 147 */       renderError(404);
/* 148 */       return;
/*     */     }
/* 150 */     keepPara();
/* 151 */     boolean isEditable = false;
/* 152 */     boolean isRejectable = false;
/*     */     
/* 154 */     setAttr("isEditable", Boolean.valueOf(isEditable));
/* 155 */     setAttr("isRejectable", Boolean.valueOf(isRejectable));
/* 156 */     setAttr("rejected", Boolean.valueOf(false));
/* 157 */     setAttr("isArchived", Boolean.valueOf(true));
/*     */     
/* 159 */     setAttr("content", postInfo.get("content"));
/* 160 */     setAttr("addonList", AddonFile.dao.findById(postInfoId));
/* 161 */     setAttr("postRecord", PostInfo.dao.findPostRecord(postInfoId));
/* 162 */     render("posting7.ftl");
/*     */   }
/*     */   
/*     */   public void postContentDetail()
/*     */   {
/* 167 */     String postInfoId = getPara("postInfoId");
/* 168 */     PostInfo postInfo = getPostInfoInRequest();
/* 169 */     if (postInfo == null) {
/* 170 */       renderError(404);
/* 171 */       return;
/*     */     }
/* 173 */     keepPara();
/* 174 */     boolean isEditable = false;
/* 175 */     boolean isRejectable = false;
/*     */     
/* 177 */     if (PostService.instance.isRelActived(postInfoId, ShiroUtils.getCurrentUserId())) {
/* 178 */       isEditable = true;
/*     */     }
/* 180 */     List<String> roleCodes = ShiroUtils.getCurrentUserRoles();
/* 181 */     if ((roleCodes.contains("centerleader")) || 
/* 182 */       (roleCodes.contains("director")) || 
/* 183 */       (roleCodes.contains("vicedirector")) || 
/* 184 */       (roleCodes.contains("sectionchife"))) {
/* 185 */       isRejectable = true;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/* 190 */     if (Role.dao.isCurrentUserHasRole("sectionchife")) {
/* 191 */       setAttr("isSelectAble", Boolean.valueOf(true));
/* 192 */       List<User> list = User.dao.findUserListByRole("centerleader");
/*     */       
/* 194 */       String username = ShiroUtils.getCurrentUserName();
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
/* 223 */       setAttr("leaders", list);
/* 224 */     } else if ((Role.dao.isCurrentUserHasRole("centerleader")) && (!Role.dao.isCurrentUserHasRole("chief"))) {
/* 225 */       setAttr("isSelectAble", Boolean.valueOf(true));
/* 226 */       List<User> list = User.dao.findUserListByRole("chief");
/* 227 */       setAttr("leaders", list);
/*     */     }
/*     */     
/* 230 */     setAttr("isEditable", Boolean.valueOf(isEditable));
/* 231 */     setAttr("isRejectable", Boolean.valueOf(isRejectable));
/* 232 */     setAttr("content", postInfo.get("content"));
/* 233 */     setAttr("addonList", AddonFile.dao.findById(postInfoId));
/*     */     try {
/* 235 */       if (postInfo.getInt("status").intValue() == 4) {
/* 236 */         setAttr("rejected", Boolean.valueOf(true));
/* 237 */         setAttr("rejectInfo", postInfo.getStr("rejectInfo"));
/*     */       } else {
/* 239 */         setAttr("rejected", Boolean.valueOf(false));
/*     */       }
/*     */     } catch (Exception e) {
/* 242 */       setAttr("rejected", Boolean.valueOf(false));
/*     */     }
/*     */     
/* 245 */     setAttr("phList", PostHistory.dao.findPostHistory(postInfoId));
/* 246 */     PostService.instance.updateReadStatus(postInfoId, ShiroUtils.getCurrentUserId());
/* 247 */     render("posting7.ftl");
/*     */   }
/*     */   
/*     */   public void previewPostInfoDetail()
/*     */   {
/* 252 */     PostInfo postInfo = getPostInfoInRequest();
/* 253 */     if (postInfo == null) {
/* 254 */       renderError(404);
/* 255 */       return;
/*     */     }
/* 257 */     setAttr("info", postInfo);
/* 258 */     if (StringUtils.isNotBlank(getPara("print"))) {
/* 259 */       render("postinfo_print.ftl");
/*     */     } else {
/* 261 */       render("postDetailInfo.ftl");
/*     */     }
/*     */   }
/*     */   
/*     */   public void approvePost()
/*     */   {
/* 267 */     List<String> roles = ShiroUtils.getCurrentUserRoles();
/* 268 */     PostInfo postInfo = getPostInfoInRequest();
/* 269 */     if (postInfo == null) {
/* 270 */       renderError(404);
/*     */     }
/* 272 */     String postInfoId = getPara("postInfoId");
/*     */     
/* 274 */     String rejectInfo = getPara("rejectInfo");
/* 275 */     String[] users = getParaValues("user");
/*     */     
/* 277 */     if (roles.contains("normaluser")) {
/* 278 */       String content = getPara("content");
/* 279 */       if (StringUtils.isBlank(content)) {
/* 280 */         setAttr("postInfoId", postInfoId);
/* 281 */         setAttr("errorMsg", "发文内容不能为空");
/* 282 */         render("posting1.ftl");
/* 283 */         return;
/*     */       }
/* 285 */       PostInfo newPostInfo = 
/* 286 */         (PostInfo)((PostInfo)((PostInfo)postInfo.set("content", content)).set("status", Integer.valueOf(1))).set("statusInfo", "审批中");
/*     */       
/* 288 */       PostService.instance.savePostRel2(postInfoId, newPostInfo, users);
/* 289 */       PostHistoryService.instance.savePostHistory(ShiroUtils.getCurrentUserName(), postInfoId, "提交发文审核", "审批中");
/* 290 */       sendRemind(postInfoId);
/* 291 */       redirect("/post/postList");
/* 292 */     } else if ((roles.contains("director")) || ((roles.contains("centerleader")) && (!roles.contains("chief")))) {
/* 293 */       ((PostInfo)postInfo.set("viceDirector", ShiroUtils.getCurrentUserName())).set("viceDirectorTime", new Date());
/* 294 */       PostService.instance.savePostRel(users, postInfoId, postInfo, rejectInfo);
/* 295 */       PostHistoryService.instance.savePostHistory(ShiroUtils.getCurrentUserName(), postInfoId, rejectInfo, "审批中");
/* 296 */       redirect("/post/postList");
/* 297 */     } else if (roles.contains("chief")) {
/* 298 */       ((PostInfo)postInfo.set("centerLeader", ShiroUtils.getCurrentUserName())).set(
/* 299 */         "centerLeaderTime", new Date());
/* 300 */       saveApproval("inboxmanager", 
/* 301 */         5, "已发文", postInfo);
/* 302 */       PostHistoryService.instance.savePostHistory(ShiroUtils.getCurrentUserName(), postInfoId, rejectInfo, "已发文");
/*     */     } else {
/* 304 */       ((PostInfo)postInfo.set("sectionChief", ShiroUtils.getCurrentUserName())).set(
/* 305 */         "sectionChiefTime", new Date());
/* 306 */       PostService.instance.savePostRel(users, postInfoId, postInfo, rejectInfo);
/*     */       
/*     */ 
/* 309 */       PostHistoryService.instance.savePostHistory(ShiroUtils.getCurrentUserName(), postInfoId, rejectInfo, "审批通过");
/* 310 */       redirect("/post/postList");
/*     */     }
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
/*     */   private PostInfo getPostInfoInRequest()
/*     */   {
/* 357 */     String postInfoId = getPara("postInfoId");
/* 358 */     if (StringUtils.isBlank(postInfoId)) {
/* 359 */       setAttr("errorMsg", "未找到对应的发文处理单");
/* 360 */       return null;
/*     */     }
/*     */     
/* 363 */     PostInfo postInfo = (PostInfo)PostInfo.dao.findById(postInfoId);
/* 364 */     if (postInfo == null) {
/* 365 */       return null;
/*     */     }
/* 367 */     return postInfo;
/*     */   }
/*     */   
/*     */ 
/*     */   private void saveApproval(String roleCode, int status, String statusInfo, PostInfo postInfo)
/*     */   {
/* 373 */     String postInfoId = getPara("postInfoId");
/* 374 */     if (postInfo == null) {
/* 375 */       renderError(404);
/*     */     }
/*     */     
/* 378 */     String content = getPara("content");
/* 379 */     if (StringUtils.isBlank(content)) {
/* 380 */       setAttr("postInfoId", postInfoId);
/* 381 */       setAttr("errorMsg", "发文内容不能为空");
/* 382 */       render("posting1.ftl");
/* 383 */       return;
/*     */     }
/*     */     
/* 386 */     PostInfo PostInfo = 
/* 387 */       (PostInfo)((PostInfo)((PostInfo)postInfo.set("content", content)).set("status", Integer.valueOf(status))).set("statusInfo", statusInfo);
/*     */     try {
/* 389 */       PostService.instance.savePostRel(postInfoId, roleCode, PostInfo, ShiroUtils.getCurrentUserId());
/*     */       
/* 391 */       sendRemind(postInfoId);
/*     */     } catch (BizException e) {
/* 393 */       keepPara();
/* 394 */       setAttr("errorMsg", e.getMessage());
/* 395 */       if (status <= 1) {
/* 396 */         render("posting1.ftl");
/*     */       } else {
/* 398 */         render("posting7.ftl");
/*     */       }
/* 400 */       return;
/*     */     }
/* 402 */     redirect("/post/postList");
/*     */   }
/*     */   
/*     */   public void saveReject()
/*     */   {
/* 407 */     String postInfoId = getPara("postInfoId");
/* 408 */     PostInfo postInfo = getPostInfoInRequest();
/* 409 */     if (postInfo == null) {
/* 410 */       renderError(404);
/*     */     }
/* 412 */     String rejectInfo = getPara("rejectInfo");
/*     */     try {
/* 414 */       PostService.instance.saveReject(postInfoId, postInfo, ShiroUtils.getCurrentUserId());
/*     */       
/* 416 */       ((PostInfo)((PostInfo)((PostInfo)postInfo.set("status", Integer.valueOf(4))).set("statusInfo", "已驳回")).set("rejectInfo", rejectInfo)).update();
/* 417 */       PostHistoryService.instance.savePostHistory(ShiroUtils.getCurrentUserName(), postInfoId, rejectInfo, "已驳回");
/* 418 */       sendRemind(postInfoId);
/* 419 */       redirect("/post/postList");
/*     */     } catch (BizException e) {
/* 421 */       setAttr("postInfoId", postInfoId);
/* 422 */       setAttr("errorMsg", "保存发文内容时出错");
/* 423 */       render("posting1.ftl");
/*     */     }
/*     */   }
/*     */   
/*     */   public void printDoc() {
/* 428 */     PostInfo postInfo = getPostInfoInRequest();
/* 429 */     if (postInfo == null) {
/* 430 */       renderError(404);
/*     */     }
/*     */     
/* 433 */     PostUserRel rel = PostUserRel.dao.findByUserIdAndInfoId(
/* 434 */       ShiroUtils.getCurrentUserId(), postInfo.getStr("id"));
/*     */     
/* 436 */     if ((rel != null) && (rel.getInt("active").intValue() == 0)) {
/* 437 */       ((PostUserRel)rel.set("active", Integer.valueOf(1))).update();
/*     */     }
/* 439 */     setAttr("content", postInfo.get("content"));
/* 440 */     render("postdoc_print.ftl");
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void chooseMember()
/*     */   {
/* 447 */     String postInfoId = getPara("postInfoId");
/* 448 */     getPostInfoInRequest();
/*     */     
/* 450 */     setAttr("postInfoId", postInfoId);
/*     */     
/* 452 */     setAttr("viceDirector", 
/* 453 */       User.dao.find(
/* 454 */       "select u.* from `t_s_base_user` as u,`t_s_user` as su,`t_s_role` as r,`t_s_role_user` as ru where u.id=su.id and ru.roleid=r.id and u.id=ru.userid and (r.rolecode = ?) order by su.orderNum desc", new Object[] {
/* 455 */       "centerleader" }));
/*     */     
/* 457 */     setAttr("departs", Depart.dao.findAll());
/* 458 */     render("distribute.ftl");
/*     */   }
/*     */   
/*     */   public void saveChooseOrg()
/*     */   {
/* 463 */     PostInfo info = getPostInfoInRequest();
/*     */     
/* 465 */     String[] orgIds = getParaValues("orgId");
/* 466 */     String[] userIds = getParaValues("userId");
/*     */     
/* 468 */     PostService.instance.saveDistribute(orgIds, userIds, info);
/*     */     
/* 470 */     sendRemind(info.getStr("id"));
/* 471 */     redirect("/post/managerPostList");
/*     */   }
/*     */   
/*     */   private JSONObject sendRemind(String infoId)
/*     */   {
/* 476 */     return ShortMsgService.instance.remindUser(Integer.valueOf(2), infoId);
/*     */   }
/*     */ }


/* Location:              E:\aaa\front\WEB-INF\classes\!\com\fgoa\web\controller\PostController.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */