/*     */ package com.fgoa.web.service;
/*     */ 
/*     */ import com.fgoa.web.model.PostInfo;
/*     */ import com.fgoa.web.model.PostUserRel;
/*     */ import com.fgoa.web.model.Role;
/*     */ import com.fgoa.web.model.User;
/*     */ import com.jfinal.plugin.activerecord.Db;
/*     */ import com.woo.jfinal.exception.BizException;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import org.apache.commons.collections.CollectionUtils;
/*     */ import org.apache.commons.lang.ArrayUtils;
/*     */ import org.apache.commons.lang.StringUtils;
/*     */ import org.slf4j.Logger;
/*     */ import org.slf4j.LoggerFactory;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class PostService
/*     */ {
/*  24 */   private Logger log = LoggerFactory.getLogger(PostService.class);
/*     */   
/*  26 */   public static final PostService instance = new PostService();
/*     */   
/*     */   public String getPostUrl()
/*     */   {
/*  30 */     if (Role.dao.isCurrentUserHasRole("inboxmanager")) {
/*  31 */       return "/post/managerPostList";
/*     */     }
/*  33 */     return "/post/postList";
/*     */   }
/*     */   
/*     */   public void savePostRel2(String postId, PostInfo postInfo, String[] userIds)
/*     */   {
/*  38 */     List<User> users = User.dao.findByIds(userIds);
/*  39 */     if (!isUsersExist(users)) {
/*  40 */       this.log.info("科长数据未选择...");
/*  41 */       throw new BizException("请选择科长");
/*     */     }
/*     */     
/*  44 */     Db.update("update t_oa_post_user_rel set active = ? where postid=?", new Object[] {
/*  45 */       Integer.valueOf(1), postId });
/*  46 */     StringBuffer sb = new StringBuffer();
/*  47 */     for (User user : users) {
/*  48 */       saveRel(postId, user.getStr("ID"));
/*  49 */       sb.append(user.getStr("realname")).append(",");
/*     */     }
/*  51 */     sb.deleteCharAt(sb.length() - 1);
/*  52 */     ((PostInfo)postInfo.set("statusInfo", sb.toString())).update();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void savePostRel(String postId, String roleCode, PostInfo postInfo, String currentUserId)
/*     */   {
/*  63 */     List<User> users = new ArrayList();
/*     */     
/*  65 */     User currentUser = (User)User.dao.findById(currentUserId);
/*     */     
/*  67 */     String currentOrgId = currentUser.getStr("departid");
/*  68 */     this.log.info(String.format("获取到当前用户：id--%s ,name--%s，departid--%s", new Object[] { currentUserId, currentUser.get("realname"), currentOrgId }));
/*     */     
/*  70 */     if (StringUtils.equalsIgnoreCase(roleCode, "sectionchife")) {
/*  71 */       this.log.info("查询当前用户的科长...");
/*     */       
/*  73 */       users = User.dao.findSectionChifeByDepartId(currentOrgId);
/*  74 */       if (!isUsersExist(users)) {
/*  75 */         this.log.info("科长数据未找到...");
/*  76 */         throw new BizException("没有找到当前用户科室的科长或者副科长，请与系统管理员联系");
/*     */       }
/*  78 */     } else if (StringUtils.equals(roleCode, "vicedirector")) {
/*  79 */       this.log.info("查询当前用户的分管领导数据...");
/*     */       
/*  81 */       users = User.dao
/*  82 */         .findSectionLeader(currentOrgId);
/*  83 */       if (!isUsersExist(users))
/*     */       {
/*  85 */         this.log.info("分管领导数据未找到，开始查询中心领导数据...");
/*  86 */         users = User.dao.findUserListByRole("director");
/*  87 */         if (!isUsersExist(users)) {
/*  88 */           this.log.info("中心领导数据未找到...");
/*  89 */           throw new BizException("没有找到当前科室的分管副主任或者部门主任，请与系统管理员联系");
/*     */         }
/*     */       }
/*  92 */     } else if (StringUtils.equalsIgnoreCase(roleCode, "director"))
/*     */     {
/*  94 */       this.log.info("查询当前用户的中心领导数据...");
/*  95 */       users = User.dao.findUserListByRole("director");
/*  96 */       if (!isUsersExist(users)) {
/*  97 */         this.log.info("中心领导数据未找到...");
/*  98 */         throw new BizException("没有找到部门主任，请与系统管理员联系");
/*     */       }
/* 100 */     } else if (StringUtils.equalsIgnoreCase(roleCode, "inboxmanager")) {
/* 101 */       this.log.info("当前待接收用户为收发文管理员，查询收发文管理员...");
/* 102 */       users = User.dao.findUserListByRole("inboxmanager");
/* 103 */       if (!isUsersExist(users)) {
/* 104 */         this.log.info("收发文管理员数据未找到...");
/* 105 */         throw new BizException("没有找到发文管理员，请与系统管理员联系");
/*     */       }
/*     */     }
/* 108 */     this.log.info("开始更新发文数据...");
/*     */     
/* 110 */     Db.update("update t_oa_post_user_rel set active = ? where postid=?", new Object[] {
/* 111 */       Integer.valueOf(1), postId });
/* 112 */     StringBuffer sb = new StringBuffer();
/* 113 */     for (User user : users) {
/* 114 */       saveRel(postId, user.getStr("ID"));
/* 115 */       sb.append(user.getStr("realname")).append(",");
/*     */     }
/* 117 */     sb.deleteCharAt(sb.length() - 1);
/* 118 */     ((PostInfo)postInfo.set("statusInfo", sb.toString())).update();
/*     */   }
/*     */   
/*     */ 
/*     */   public void savePostRel(String[] userIds, String postId, PostInfo postInfo, String rejectInfo)
/*     */   {
/* 124 */     Db.update("update t_oa_post_user_rel set active = ? where postid=?", new Object[] {
/* 125 */       Integer.valueOf(1), postId });
/* 126 */     StringBuffer sb = new StringBuffer();
/* 127 */     List<User> users = User.dao.findByIds(userIds);
/* 128 */     for (User user : users) {
/* 129 */       saveRel(postId, user.getStr("ID"));
/* 130 */       sb.append(user.getStr("realname")).append(",");
/*     */     }
/*     */     
/*     */ 
/*     */ 
/* 135 */     sb.deleteCharAt(sb.length() - 1);
/* 136 */     ((PostInfo)((PostInfo)postInfo.set("statusInfo", sb.toString())).set("rejectInfo", rejectInfo)).update();
/*     */   }
/*     */   
/*     */   public void saveReject(String infoId, PostInfo info, String currentUserId) {
/* 140 */     Db.update("update t_oa_post_user_rel set active = ? where postid=?", new Object[] {
/* 141 */       Integer.valueOf(1), infoId });
/* 142 */     List<String> roleCodes = Role.dao.getUserRoles(currentUserId);
/* 143 */     List<String> userIdList = null;
/* 144 */     if (roleCodes.contains("sectionchife"))
/*     */     {
/* 146 */       userIdList = findRelUserIdsByRoleCode(infoId, new String[] { "normaluser" });
/* 147 */     } else if (roleCodes.contains("vicedirector")) {
/* 148 */       userIdList = findRelUserIdsByRoleCode(infoId, new String[] { "sectionchife" });
/* 149 */     } else if ((roleCodes.contains("director")) || 
/* 150 */       (roleCodes.contains("centerleader"))) {
/* 151 */       userIdList = findRelUserIdsByRoleCode(infoId, new String[] { "vicedirector" });
/* 152 */       if (CollectionUtils.isEmpty(userIdList)) {
/* 153 */         userIdList = findRelUserIdsByRoleCode(infoId, new String[] { "sectionchife" });
/*     */       }
/*     */     }
/* 156 */     if (CollectionUtils.isNotEmpty(userIdList)) {
/* 157 */       for (String userId : userIdList) {
/* 158 */         Db.update(
/* 159 */           "update t_oa_post_user_rel set active = ? where postid=? and userid=?", new Object[] {
/* 160 */           Integer.valueOf(0), infoId, userId });
/*     */       }
/*     */     } else {
/* 163 */       throw new BizException("没有找到接收驳回的用户，请联系管理员");
/*     */     }
/*     */   }
/*     */   
/*     */   public boolean isRelActived(String infoId, String currentUserId)
/*     */   {
/* 169 */     PostInfo p = 
/* 170 */       (PostInfo)PostInfo.dao.findFirst(
/* 171 */       "SELECT * from t_oa_post_user_rel where userId =? and postid=? and active=?", new Object[] {
/* 172 */       currentUserId, infoId, Integer.valueOf(0) });
/* 173 */     if (p != null) {
/* 174 */       return true;
/*     */     }
/* 176 */     return false;
/*     */   }
/*     */   
/*     */ 
/*     */   private boolean isUsersExist(List<User> users)
/*     */   {
/* 182 */     if (CollectionUtils.isEmpty(users)) {
/* 183 */       return false;
/*     */     }
/* 185 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   private List<String> findRelUserIdsByRoleCode(String infoId, String... roleCode)
/*     */   {
/* 192 */     StringBuffer s = new StringBuffer();
/* 193 */     String[] arrayOfString; int j = (arrayOfString = roleCode).length; for (int i = 0; i < j; i++) { String c = arrayOfString[i];
/* 194 */       if (s.length() > 0) {
/* 195 */         s.append(",");
/*     */       }
/* 197 */       s.append("'").append(c).append("'");
/*     */     }
/* 199 */     String sql = "select u.ID from t_s_base_user as u,t_s_role_user as ru,t_s_role as r,t_oa_post as p,t_oa_post_user_rel as pu where u.status=1 and u.ID=ru.userid and r.ID=ru.roleid and u.ID=pu.userId and pu.postid=p.id and p.id=? and r.rolecode in(" + 
/* 200 */       s + ")";
/* 201 */     Object result = Db.query(sql, new Object[] { infoId });
/* 202 */     return (List<String>)result;
/*     */   }
/*     */   
/*     */   private void saveRel(String infoId, String userId) {
/* 206 */     PostUserRel rel = PostUserRel.dao.findByUserIdAndInfoId(userId, infoId);
/* 207 */     if (rel == null)
/*     */     {
/* 209 */       ((PostUserRel)((PostUserRel)((PostUserRel)((PostUserRel)new PostUserRel().set("userid", userId)).set("postid", infoId)).set("active", Integer.valueOf(0))).set("isReaded", Integer.valueOf(0))).save();
/*     */     }
/*     */     else {
/* 212 */       ((PostUserRel)((PostUserRel)((PostUserRel)((PostUserRel)rel.set("userid", userId)).set("postid", infoId)).set("active", Integer.valueOf(0))).set("isReaded", Integer.valueOf(0))).update();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   private void savePostHistory(String infoId, String userId, PostInfo postInfo) {}
/*     */   
/*     */ 
/*     */   public void saveDistribute(String[] orgIds, String[] userIds, PostInfo info)
/*     */   {
/* 223 */     String infoId = info.getStr("id");
/*     */     String[] arrayOfString;
/*     */     int j;
/* 226 */     int i; if (ArrayUtils.isNotEmpty(userIds)) {
/* 227 */       j = (arrayOfString = userIds).length; for (i = 0; i < j; i++) { String uId = arrayOfString[i];
/* 228 */         saveDistributeRel(infoId, uId);
/*     */       }
/*     */     }
/*     */     
/*     */ 
/* 233 */     if (ArrayUtils.isNotEmpty(orgIds)) {
/* 234 */       j = (arrayOfString = orgIds).length; for (i = 0; i < j; i++) { String oId = arrayOfString[i];
/*     */         
/* 236 */         List<User> users = User.dao.findUserByDepartIdAndRoleCode(
/* 237 */           "sectionchife", oId);
/* 238 */         for (User u : users) {
/* 239 */           saveDistributeRel(infoId, u.getStr("ID"));
/*     */         }
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   private void saveDistributeRel(String infoId, String userId)
/*     */   {
/* 247 */     PostUserRel rel = PostUserRel.dao.findByUserIdAndInfoId(userId, infoId);
/* 248 */     if (rel == null)
/*     */     {
/*     */ 
/* 251 */       ((PostUserRel)((PostUserRel)((PostUserRel)((PostUserRel)((PostUserRel)new PostUserRel().set("userid", userId)).set("postid", infoId)).set("distributed", Integer.valueOf(0))).set("active", Integer.valueOf(1))).set("isReaded", Integer.valueOf(0))).save();
/*     */     }
/*     */     else {
/* 254 */       ((PostUserRel)((PostUserRel)((PostUserRel)((PostUserRel)rel.set("userid", userId)).set("postid", infoId)).set("distributed", Integer.valueOf(0))).set("isReaded", Integer.valueOf(0))).update();
/*     */     }
/*     */   }
/*     */   
/*     */   public void updateReadStatus(String infoId, String userId) {
/* 259 */     PostUserRel rel = PostUserRel.dao.findByUserIdAndInfoId(userId, infoId);
/* 260 */     if (rel != null) {
/* 261 */       ((PostUserRel)rel.set("isReaded", Integer.valueOf(1))).update();
/*     */     }
/*     */   }
/*     */   
/*     */   public boolean isRelDistributed(String infoId, String currentUserId) {
/* 266 */     PostInfo p = 
/* 267 */       (PostInfo)PostInfo.dao.findFirst(
/* 268 */       "SELECT * from t_oa_post_user_rel where userId =? and postid=? and distributed=?", new Object[] {
/* 269 */       currentUserId, infoId, 
/* 270 */       Integer.valueOf(0) });
/* 271 */     if (p != null) {
/* 272 */       return true;
/*     */     }
/* 274 */     return false;
/*     */   }
/*     */   
/*     */   public void delete(PostInfo info, String currentUserId)
/*     */   {
/* 279 */     String userName = User.dao.findUserNameById(currentUserId);
/* 280 */     ((PostInfo)((PostInfo)info.set("statusInfo", userName + "删除")).set("status", Integer.valueOf(5))).update();
/* 281 */     Db.update("update t_oa_post_user_rel set active = ? where postid=?", new Object[] {
/* 282 */       Integer.valueOf(1), info.get("id") });
/*     */   }
/*     */ }


/* Location:              E:\aaa\front\WEB-INF\classes\!\com\fgoa\web\service\PostService.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */