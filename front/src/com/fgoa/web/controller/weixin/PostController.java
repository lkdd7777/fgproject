/*     */ package com.fgoa.web.controller.weixin;
/*     */ 
/*     */ import com.alibaba.fastjson.JSONObject;
/*     */ import com.fgoa.web.inteceptor.weixin.UserInteterceptor;
/*     */ import com.fgoa.web.inteceptor.weixin.WeixinInteterceptor;
/*     */ import com.fgoa.web.model.AddonFile;
/*     */ import com.fgoa.web.model.Depart;
/*     */ import com.fgoa.web.model.PostInfo;
/*     */ import com.fgoa.web.model.Role;
/*     */ import com.fgoa.web.model.User;
/*     */ import com.fgoa.web.service.PostService;
/*     */ import com.fgoa.web.service.ShortMsgService;
/*     */ import com.jfinal.aop.Before;
/*     */ import com.jfinal.core.Controller;
/*     */ import com.woo.jfinal.exception.BizException;
/*     */ import java.util.Date;
/*     */ import java.util.List;
/*     */ import javax.servlet.http.HttpServletRequest;
/*     */ import org.apache.commons.lang.StringUtils;
/*     */ import org.slf4j.Logger;
/*     */ import org.slf4j.LoggerFactory;
/*     */ 
/*     */ 
/*     */ public class PostController
/*     */   extends Controller
/*     */ {
/*  27 */   private Logger log = LoggerFactory.getLogger(PostController.class);
/*     */   
/*     */   @Before({WeixinInteterceptor.class})
/*     */   public void index() {
/*  31 */     String userId = getUserId();
/*  32 */     if (StringUtils.isNotBlank(userId)) {
/*  33 */       setAttr("postList", PostInfo.dao.findUserPost(userId));
/*  34 */       render("post_result.ftl");
/*     */     } else {
/*  36 */       setAttr("errorMsg", "获取微信账号信息出现错误");
/*  37 */       render("errorInfo.ftl");
/*     */     }
/*     */   }
/*     */   
/*     */   @Before({UserInteterceptor.class})
/*     */   public void detail() {
/*  43 */     PostInfo postInfo = getInfo();
/*  44 */     String infoId = postInfo.getStr("id");
/*  45 */     keepPara();
/*  46 */     boolean isEditable = false;
/*  47 */     boolean isRejectable = false;
/*     */     
/*  49 */     if (PostService.instance.isRelActived(infoId, getUserId())) {
/*  50 */       isEditable = true;
/*     */     }
/*     */     
/*  53 */     List<String> roleCodes = Role.dao.getUserRoles(getUserId());
/*     */     
/*  55 */     if ((roleCodes.contains("centerleader")) || 
/*  56 */       (roleCodes.contains("director")) || 
/*  57 */       (roleCodes.contains("vicedirector")) || 
/*  58 */       (roleCodes.contains("sectionchife"))) {
/*  59 */       isRejectable = true;
/*     */     }
/*  61 */     setAttr("info", postInfo);
/*  62 */     setAttr("isEditable", Boolean.valueOf(isEditable));
/*  63 */     setAttr("isRejectable", Boolean.valueOf(isRejectable));
/*  64 */     setAttr("content", postInfo.get("content"));
/*  65 */     setAttr("addonList", AddonFile.dao.findById(infoId));
/*     */     try {
/*  67 */       if (postInfo.getInt("status").intValue() == 4) {
/*  68 */         setAttr("rejected", Boolean.valueOf(true));
/*  69 */         setAttr("rejectInfo", postInfo.getStr("rejectInfo"));
/*     */       } else {
/*  71 */         setAttr("rejected", Boolean.valueOf(false));
/*     */       }
/*     */     } catch (Exception e) {
/*  74 */       setAttr("rejected", Boolean.valueOf(false));
/*     */     }
/*     */     
/*  77 */     render("post_detail.ftl");
/*     */   }
/*     */   
/*     */   @Before({UserInteterceptor.class})
/*     */   public void approval()
/*     */   {
/*  83 */     this.log.info("开始保存数据...");
/*  84 */     String userId = getUserId();
/*  85 */     List<String> roles = Role.dao.getUserRoles(userId);
/*  86 */     String userName = User.dao.findUserNameById(userId);
/*     */     
/*  88 */     PostInfo postInfo = getInfo();
/*  89 */     if (postInfo == null) {
/*  90 */       renderError(404);
/*     */     }
/*  92 */     if (roles.contains("normaluser")) {
/*  93 */       this.log.info("当前用户为普通用户");
/*  94 */       saveApproval("sectionchife", 
/*  95 */         1, "审批中", postInfo);
/*  96 */     } else if (roles.contains("sectionchife")) {
/*  97 */       this.log.info("当前用户为科长");
/*  98 */       ((PostInfo)postInfo.set("sectionChief", userName)).set(
/*  99 */         "sectionChiefTime", new Date());
/*     */       
/* 101 */       saveApproval("vicedirector", 
/* 102 */         2, "审批中", 
/* 103 */         postInfo);
/* 104 */     } else if (roles.contains("vicedirector")) {
/* 105 */       this.log.info("当前用户为分管领导");
/* 106 */       ((PostInfo)postInfo.set("viceDirector", userName)).set(
/* 107 */         "viceDirectorTime", new Date());
/*     */       
/* 109 */       saveApproval("director", 
/* 110 */         3, "审批中", 
/* 111 */         postInfo);
/* 112 */     } else if (roles.contains("director")) {
/* 113 */       this.log.info("当前用户为中心领导");
/* 114 */       ((PostInfo)postInfo.set("centerLeader", userName)).set(
/* 115 */         "centerLeaderTime", new Date());
/*     */       
/* 117 */       saveApproval("inboxmanager", 
/* 118 */         5, "已发文", postInfo);
/*     */     }
/* 120 */     this.log.info("保存数据结束...");
/* 121 */     redirect("/weixin/post");
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   private void saveApproval(String roleCode, int status, String statusInfo, PostInfo postInfo)
/*     */   {
/* 128 */     String infoId = getPara("infoId");
/* 129 */     if (postInfo == null) {
/* 130 */       renderError(404);
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
/*     */ 
/* 144 */     PostInfo PostInfo = (PostInfo)((PostInfo)postInfo.set("status", Integer.valueOf(status))).set("statusInfo", statusInfo);
/*     */     try {
/* 146 */       this.log.info("开始更新发文数据...");
/* 147 */       PostService.instance.savePostRel(infoId, roleCode, PostInfo, getUserId());
/* 148 */       sendRemind(infoId);
/* 149 */       this.log.info("更新发文数据完成...");
/* 150 */       redirect("/weixin/post");
/*     */     } catch (BizException e) {
/* 152 */       keepPara();
/* 153 */       setAttr("errorMsg", "驳回收文信息失败");
/* 154 */       render("errorInfo.ftl");
/*     */     }
/*     */   }
/*     */   
/*     */   @Before({UserInteterceptor.class})
/*     */   public void saveReject()
/*     */   {
/* 161 */     String infoId = getPara("infoId");
/* 162 */     PostInfo postInfo = getInfo();
/* 163 */     if (postInfo == null) {
/* 164 */       renderError(404);
/*     */     }
/* 166 */     String rejectInfo = getPara("rejectContent");
/*     */     try {
/* 168 */       PostService.instance.saveReject(infoId, postInfo, getUserId());
/*     */       
/* 170 */       ((PostInfo)((PostInfo)((PostInfo)postInfo.set("status", Integer.valueOf(4))).set("statusInfo", "已驳回")).set("rejectInfo", rejectInfo)).update();
/* 171 */       sendRemind(infoId);
/*     */     } catch (BizException e) {
/* 173 */       setAttr("infoId", infoId);
/* 174 */       setAttr("errorMsg", "驳回收文信息失败");
/* 175 */       render("errorInfo.ftl");
/* 176 */       return;
/*     */     }
/* 178 */     redirect("/weixin/post");
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   @Before({UserInteterceptor.class})
/*     */   public void chooseMember()
/*     */   {
/* 186 */     PostInfo info = getInfo();
/* 187 */     if (info == null) {
/* 188 */       renderError(404);
/*     */     }
/* 190 */     setAttr("infoId", info.get("id"));
/*     */     
/* 192 */     setAttr("viceDirector", 
/* 193 */       User.dao.find(
/* 194 */       "select u.* from `t_s_base_user` as u,`t_s_user` as su,`t_s_role` as r,`t_s_role_user` as ru where u.id=su.id and ru.roleid=r.id and u.id=ru.userid and (r.rolecode = ? or r.rolecode=?) order by su.orderNum desc", new Object[] {
/* 195 */       "director", "vicedirector" }));
/*     */     
/* 197 */     setAttr("departs", Depart.dao.findAll());
/* 198 */     render("distribute.ftl");
/*     */   }
/*     */   
/*     */   @Before({UserInteterceptor.class})
/*     */   public void saveChooseOrg()
/*     */   {
/* 204 */     PostInfo info = getInfo();
/*     */     
/* 206 */     String[] orgIds = getParaValues("orgId");
/* 207 */     String[] userIds = getParaValues("userId");
/*     */     
/* 209 */     PostService.instance.saveDistribute(orgIds, userIds, info);
/*     */     
/* 211 */     sendRemind(info.getStr("id"));
/* 212 */     redirect("/weixin/post");
/*     */   }
/*     */   
/*     */   private JSONObject sendRemind(String infoId)
/*     */   {
/* 217 */     return ShortMsgService.instance.remindUser(Integer.valueOf(2), 
/* 218 */       infoId);
/*     */   }
/*     */   
/*     */   private PostInfo getInfo() {
/* 222 */     String infoId = getPara("infoId");
/* 223 */     if (StringUtils.isBlank(infoId)) {
/* 224 */       return null;
/*     */     }
/* 226 */     PostInfo info = (PostInfo)PostInfo.dao.findById(infoId);
/* 227 */     if (info == null) {
/* 228 */       return null;
/*     */     }
/* 230 */     return info;
/*     */   }
/*     */   
/*     */   private String getUserId() {
/* 234 */     String userId = (String)getSessionAttr("userId");
/* 235 */     if (StringUtils.isBlank(userId)) {
/* 236 */       userId = getPara("userId");
/* 237 */       if (StringUtils.isBlank(userId)) {
/* 238 */         userId = (String)getRequest().getAttribute("userId");
/*     */       }
/*     */     }
/*     */     
/* 242 */     return userId;
/*     */   }
/*     */ }


/* Location:              E:\aaa\front\WEB-INF\classes\!\com\fgoa\web\controller\weixin\PostController.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */