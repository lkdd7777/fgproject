/*     */ package com.fgoa.web.service;
/*     */ 
/*     */ import com.fgoa.web.model.InboxInfo;
/*     */ import com.fgoa.web.model.InboxInfoDoc;
/*     */ import com.fgoa.web.model.InboxInfoUserRel;
/*     */ import com.fgoa.web.model.Role;
/*     */ import com.fgoa.web.model.User;
/*     */ import com.fgoa.web.utils.FileUtils;
/*     */ import com.jfinal.aop.Before;
/*     */ import com.jfinal.plugin.activerecord.Db;
/*     */ import com.jfinal.plugin.activerecord.tx.Tx;
/*     */ import com.jfinal.upload.UploadFile;
/*     */ import com.woo.jfinal.exception.BizException;
/*     */ import com.woo.jfinal.utils.UUIDUtils;
/*     */ import java.io.File;
/*     */ import java.io.IOException;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.List;
/*     */ import javax.servlet.ServletContext;
/*     */ import javax.servlet.http.HttpServletRequest;
/*     */ import javax.servlet.http.HttpSession;
/*     */ import org.apache.commons.collections.CollectionUtils;
/*     */ import org.apache.commons.lang.ArrayUtils;
/*     */ import org.apache.commons.lang.StringUtils;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class InboxService
/*     */ {
/*  32 */   public static final InboxService instance = new InboxService();
/*     */   
/*     */   public static final String INBOX_FILE_FOLDER = "/userupload/inboxfile/";
/*     */   
/*  36 */   public static final String[] PIC_EXTENSION = { "jpg", "jpeg", 
/*  37 */     "png", "gif" };
/*     */   
/*     */   public String getInboxUrl()
/*     */   {
/*  41 */     if (Role.dao.isCurrentUserHasRole("inboxmanager"))
/*  42 */       return "/inbox/backLogList";
/*  43 */     if ((Role.dao.isCurrentUserHasRole("centerleader")) || 
/*  44 */       (Role.dao.isCurrentUserHasRole("sectionchife")) || 
/*  45 */       (Role.dao.isCurrentUserHasRole("vicedirector")) || 
/*  46 */       (Role.dao.isCurrentUserHasRole("normaluser")) || 
/*  47 */       (Role.dao.isCurrentUserHasRole("vicesectionchife"))) {
/*  48 */       return "/inbox/memeberReadList";
/*     */     }
/*  50 */     return "";
/*     */   }
/*     */   
/*     */ 
/*     */   public long getUserInboxCount()
/*     */   {
/*  56 */     if ((Role.dao.isCurrentUserHasRole("sectionchife")) || 
/*  57 */       (Role.dao.isCurrentUserHasRole("vicedirector")) || 
/*  58 */       (Role.dao.isCurrentUserHasRole("centerleader")) || 
/*  59 */       (Role.dao.isCurrentUserHasRole("vicesectionchife")) || 
/*  60 */       (Role.dao.isCurrentUserHasRole("normaluser"))) {
/*  61 */       return InboxInfo.dao.findMemberInboxCount();
/*     */     }
/*  63 */     return 0L;
/*     */   }
/*     */   
/*     */   public String saveInboxFile(UploadFile uploadFile, HttpServletRequest request)
/*     */     throws BizException, IOException
/*     */   {
/*  69 */     String uuid = UUIDUtils.getRandomUUIDString();
/*  70 */     String uploadDirPath = request.getSession().getServletContext()
/*  71 */       .getRealPath("/userupload/inboxfile/" + uuid);
/*  72 */     FileUtils.unZip(uploadFile.getFile(), uploadDirPath);
/*  73 */     if (checkPicFileExist(uploadDirPath)) {
/*  74 */       return uuid;
/*     */     }
/*  76 */     throw new BizException("压缩包中不存在图片文件");
/*     */   }
/*     */   
/*     */ 
/*     */   public boolean isFileExist(String subFolder, HttpServletRequest request)
/*     */   {
/*  82 */     String filePath = request.getSession().getServletContext()
/*  83 */       .getRealPath("/userupload/inboxfile/" + subFolder);
/*  84 */     return checkPicFileExist(filePath);
/*     */   }
/*     */   
/*     */   private boolean checkPicFileExist(String filePath) {
/*  88 */     File folder = new File(filePath);
/*  89 */     if (!folder.exists()) {
/*  90 */       return false;
/*     */     }
/*     */     File[] arrayOfFile;
/*  93 */     int j = (arrayOfFile = folder.listFiles()).length; for (int i = 0; i < j; i++) { File file = arrayOfFile[i];
/*  94 */       if (!file.isDirectory())
/*     */       {
/*     */ 
/*  97 */         if (checkIsPic(file.getName())) {
/*  98 */           return true;
/*     */         }
/*     */       }
/*     */     }
/* 102 */     return false;
/*     */   }
/*     */   
/*     */   public String saveInboxDoc(InboxInfo inboxInfo, String fileFolder, HttpServletRequest request)
/*     */     throws BizException
/*     */   {
/* 108 */     String infoId = inboxInfo.getStr("id");
/* 109 */     List<String> picPathList = findPicPathList(fileFolder, request);
/* 110 */     for (int i = 0; i < picPathList.size(); i++)
/*     */     {
/*     */ 
/* 113 */       ((InboxInfoDoc)((InboxInfoDoc)((InboxInfoDoc)((InboxInfoDoc)new InboxInfoDoc().set("path", picPathList.get(i))).set("inboxId", infoId)).set("folder", fileFolder)).set("orderNum", Integer.valueOf(i))).save();
/*     */     }
/* 115 */     inboxInfo.save();
/* 116 */     return infoId;
/*     */   }
/*     */   
/*     */   private String getFileSuffix(String fileName) {
/* 120 */     String fileSuffix = StringUtils.substring(fileName, 
/* 121 */       fileName.lastIndexOf(".") + 1);
/* 122 */     return fileSuffix;
/*     */   }
/*     */   
/*     */   private boolean checkIsPic(String fileName) {
/* 126 */     return ArrayUtils.contains(PIC_EXTENSION, getFileSuffix(fileName)
/* 127 */       .toLowerCase());
/*     */   }
/*     */   
/*     */   public List<String> findPicPathList(String folderName, HttpServletRequest request) throws BizException
/*     */   {
/* 132 */     String filePath = request.getSession().getServletContext()
/* 133 */       .getRealPath("/userupload/inboxfile/" + folderName);
/*     */     
/* 135 */     File folder = new File(filePath);
/* 136 */     if (!folder.exists()) {
/* 137 */       throw new BizException("未找到上传的文件");
/*     */     }
/*     */     
/* 140 */     List<String> fileNameList = new ArrayList();
/* 141 */     File[] arrayOfFile; int j = (arrayOfFile = folder.listFiles()).length; for (int i = 0; i < j; i++) { File file = arrayOfFile[i];
/* 142 */       if (!file.isDirectory())
/*     */       {
/*     */ 
/* 145 */         if (checkIsPic(file.getName())) {
/* 146 */           fileNameList.add("/userupload/inboxfile/" + folderName + "/" + 
/* 147 */             file.getName());
/*     */         }
/*     */       }
/*     */     }
/* 151 */     if (fileNameList.size() > 0) {
/* 152 */       String[] nameArr = (String[])fileNameList.toArray(new String[0]);
/* 153 */       Arrays.sort(nameArr);
/* 154 */       return Arrays.asList(nameArr);
/*     */     }
/* 156 */     throw new BizException("上传的文件夹中不包含图片，请重新上传");
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void saveInboxRel(String[] orgIds, String[] userIds, InboxInfo info, String currentUserId)
/*     */   {
/* 164 */     String infoId = info.getStr("id");
/*     */     
/* 166 */     StringBuffer statusInfo = new StringBuffer();
/*     */     String[] arrayOfString;
/* 168 */     int j; int i; if (ArrayUtils.isNotEmpty(orgIds))
/*     */     {
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
/* 189 */       j = (arrayOfString = orgIds).length; for (i = 0; i < j; i++) { String oId = arrayOfString[i];
/*     */         
/*     */ 
/* 192 */         List<User> users = User.dao.findUserByDepartIdAndRoleCode(
/* 193 */           "sectionchife", oId);
/* 194 */         for (User u : users) {
/* 195 */           saveRel(infoId, u.getStr("ID"), currentUserId);
/* 196 */           if (statusInfo.length() == 0) {
/* 197 */             statusInfo.append(u.getStr("realname"));
/*     */           } else {
/* 199 */             statusInfo.append(",").append(u.getStr("realname"));
/*     */           }
/*     */         }
/*     */       }
/*     */     }
/*     */     
/*     */ 
/*     */ 
/* 207 */     if (ArrayUtils.isNotEmpty(userIds))
/*     */     {
/* 209 */       j = (arrayOfString = userIds).length; for (i = 0; i < j; i++) { String uId = arrayOfString[i];
/* 210 */         saveRel(infoId, uId, currentUserId);
/* 211 */         if (statusInfo.length() == 0) {
/* 212 */           statusInfo.append(User.dao.findUserNameById(uId));
/*     */         } else {
/* 214 */           statusInfo.append(",").append(
/* 215 */             User.dao.findUserNameById(uId));
/*     */         }
/*     */       }
/*     */     }
/*     */     
/* 220 */     updateActiveRelByUser(infoId, currentUserId);
/* 221 */     if (Role.dao.isUserContainAnyRole(currentUserId, new String[] { "centerleader", "director" })) {
/* 222 */       info.set("distributed", Integer.valueOf(0));
/*     */     }
/*     */     
/* 225 */     ((InboxInfo)info.set("statusInfo", statusInfo.toString())).update();
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
/*     */   @Before({Tx.class})
/*     */   public void saveApproval(String replyContent, InboxInfo info, String[] userIdArray)
/*     */   {
/* 239 */     ((InboxInfo)((InboxInfo)((InboxInfo)info.set("replyContent", replyContent)).set("replyed", Integer.valueOf(0))).set("rejected", Integer.valueOf(1))).update();
/* 240 */     List<String> userIdList = null;
/* 241 */     if (ArrayUtils.isNotEmpty(userIdArray)) {
/* 242 */       userIdList = new ArrayList();
/* 243 */       CollectionUtils.addAll(userIdList, userIdArray);
/*     */ 
/*     */     }
/* 246 */     else if (Role.dao.isCurrentUserHasRole("normaluser")) {
/* 247 */       userIdList = findRelUserIdsByRoleCode(info.getStr("id"), new String[] {
/* 248 */         "sectionchife" });
/* 249 */     } else if (Role.dao.isCurrentUserHasRole("sectionchife")) {
/* 250 */       userIdList = findRelUserIdsByRoleCode(info.getStr("id"), new String[] {
/* 251 */         "vicedirector" });
/*     */       
/* 253 */       if (CollectionUtils.isEmpty(userIdList)) {
/* 254 */         userIdList = findRelUserIdsByRoleCode(info.getStr("id"), new String[] {
/* 255 */           "centerleader" });
/*     */       }
/*     */     }
/* 258 */     else if (Role.dao.isCurrentUserHasRole("vicedirector")) {
/* 259 */       userIdList = findRelUserIdsByRoleCode(info.getStr("id"), new String[] {
/* 260 */         "centerleader" });
/* 261 */     } else if (Role.dao.isCurrentUserHasRole("centerleader")) {
/* 262 */       deActiveRel(info.getStr("id"));
/* 263 */       ((InboxInfo)info.set("status", Integer.valueOf(1))).update();
/*     */     }
/*     */     
/* 266 */     if (CollectionUtils.isNotEmpty(userIdList)) {
/* 267 */       String[] userIds = new String[userIdList.size()];
/* 268 */       userIdList.toArray(userIds);
/* 269 */       saveInboxRel(null, userIds, info, null);
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
/*     */   @Before({Tx.class})
/*     */   public void saveReject(String rejectContent, InboxInfo info)
/*     */   {
/* 283 */     ((InboxInfo)((InboxInfo)((InboxInfo)info.set("rejectContent", rejectContent)).set("replyed", Integer.valueOf(0))).set("rejected", Integer.valueOf(0))).update();
/*     */     
/* 285 */     List<String> userIdList = null;
/*     */     
/* 287 */     if (Role.dao.isCurrentUserHasRole("sectionchife")) {
/* 288 */       userIdList = findRelUserIdsByRoleCode(info.getStr("id"), new String[] {
/* 289 */         "normaluser" });
/* 290 */     } else if (Role.dao.isCurrentUserHasRole("vicedirector")) {
/* 291 */       userIdList = findRelUserIdsByRoleCode(info.getStr("id"), new String[] {
/* 292 */         "sectionchife" });
/* 293 */     } else if (Role.dao.isCurrentUserHasRole("centerleader")) {
/* 294 */       userIdList = findRelUserIdsByRoleCode(info.getStr("id"), new String[] {
/* 295 */         "vicedirector" });
/*     */       
/* 297 */       if (CollectionUtils.isEmpty(userIdList)) {
/* 298 */         userIdList = findRelUserIdsByRoleCode(info.getStr("id"), new String[] {
/* 299 */           "sectionchife" });
/*     */       }
/*     */     }
/* 302 */     if (CollectionUtils.isNotEmpty(userIdList)) {
/* 303 */       String[] userIds = new String[userIdList.size()];
/* 304 */       userIdList.toArray(userIds);
/* 305 */       saveInboxRel(null, userIds, info, null);
/*     */     }
/*     */   }
/*     */   
/*     */   private void saveRel(String infoId, String userId, String forUserId) {
/* 310 */     InboxInfoUserRel rel = InboxInfoUserRel.dao
/* 311 */       .findByUserIdAndInfoId(userId, infoId);
/* 312 */     if (rel == null)
/*     */     {
/*     */ 
/* 315 */       ((InboxInfoUserRel)((InboxInfoUserRel)((InboxInfoUserRel)((InboxInfoUserRel)((InboxInfoUserRel)new InboxInfoUserRel().set("userId", userId)).set("inboxId", infoId)).set("active", Integer.valueOf(0))).set("isReaded", Integer.valueOf(0))).set("forUserId", forUserId)).save();
/*     */     }
/*     */     else {
/* 318 */       ((InboxInfoUserRel)((InboxInfoUserRel)((InboxInfoUserRel)((InboxInfoUserRel)rel.set("userId", userId)).set("inboxId", infoId)).set("active", Integer.valueOf(0))).set("isReaded", Integer.valueOf(0))).update();
/*     */     }
/*     */   }
/*     */   
/*     */   public void updateReadStatus(String infoId, String userId) {
/* 323 */     InboxInfoUserRel rel = InboxInfoUserRel.dao
/* 324 */       .findByUserIdAndInfoId(userId, infoId);
/* 325 */     if (rel != null) {
/* 326 */       ((InboxInfoUserRel)rel.set("isReaded", Integer.valueOf(1))).update();
/*     */     }
/*     */   }
/*     */   
/*     */   public void deActiveRel(String inboxInfoId)
/*     */   {
/* 332 */     Db.update(
/* 333 */       "update t_oa_inbox_user_rel set active = ? where inboxId=?", new Object[] {
/* 334 */       Integer.valueOf(1), inboxInfoId });
/*     */   }
/*     */   
/*     */   public void updateActiveRelByUser(String inboxInfoId, String userId) {
/* 338 */     Db.update(
/* 339 */       "update t_oa_inbox_user_rel set active = ? where inboxId=? and userId=?", new Object[] {
/* 340 */       Integer.valueOf(1), inboxInfoId, userId });
/*     */   }
/*     */   
/*     */ 
/*     */   private List<String> findRelUserIdsByRoleCode(String infoId, String... roleCode)
/*     */   {
/* 346 */     StringBuffer s = new StringBuffer();
/* 347 */     String[] arrayOfString; int j = (arrayOfString = roleCode).length; for (int i = 0; i < j; i++) { String c = arrayOfString[i];
/* 348 */       if (s.length() > 0) {
/* 349 */         s.append(",");
/*     */       }
/* 351 */       s.append("'").append(c).append("'");
/*     */     }
/* 353 */     String sql = "select u.ID from t_s_base_user as u,t_s_role_user as ru,t_s_role as r,t_oa_inbox as p,t_oa_inbox_user_rel as pu where u.status=1 and u.ID=ru.userid and r.ID=ru.roleid and u.ID=pu.userId and pu.inboxId=p.id and p.id=? and r.rolecode in(" + 
/* 354 */       s + ")";
/* 355 */     Object result = Db.query(sql, new Object[] { infoId });
/* 356 */     return (List<String>)result;
/*     */   }
/*     */ }


/* Location:              E:\aaa\front\WEB-INF\classes\!\com\fgoa\web\service\InboxService.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */