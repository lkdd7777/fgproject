/*     */ package com.fgoa.web.service;
/*     */ 
/*     */ import com.fgoa.web.model.PetitionInfo;
/*     */ import com.fgoa.web.model.PetitionInfoDoc;
/*     */ import com.fgoa.web.model.PetitionInfoUserRel;
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
/*     */ public class PetitionService
/*     */ {
/*  31 */   public static final PetitionService instance = new PetitionService();
/*     */   
/*     */   public static final String PETITION_FILE_FOLDER = "/userupload/inboxfile/";
/*     */   
/*  35 */   public static final String[] PIC_EXTENSION = { "jpg", "jpeg", 
/*  36 */     "png", "gif" };
/*     */   
/*     */   public String getPetitionUrl()
/*     */   {
/*  40 */     if (Role.dao.isCurrentUserHasRole("inboxmanager"))
/*  41 */       return "/petition/managerPage";
/*  42 */     if ((Role.dao.isCurrentUserHasRole("sectionchife")) || 
/*  43 */       (Role.dao.isCurrentUserHasRole("vicedirector")) || 
/*  44 */       (Role.dao.isCurrentUserHasRole("centerleader")) || 
/*  45 */       (Role.dao.isCurrentUserHasRole("vicesectionchife")) || 
/*  46 */       (Role.dao.isCurrentUserHasRole("normaluser"))) {
/*  47 */       return "/petition/memberPage";
/*     */     }
/*  49 */     return "";
/*     */   }
/*     */   
/*     */ 
/*     */   public long getUserPetitionCount()
/*     */   {
/*  55 */     if (Role.dao.isCurrentUserHasRole("inboxmanager"))
/*  56 */       return 0L;
/*  57 */     if ((Role.dao.isCurrentUserHasRole("sectionchife")) || 
/*  58 */       (Role.dao.isCurrentUserHasRole("vicedirector")) || 
/*  59 */       (Role.dao.isCurrentUserHasRole("centerleader")) || 
/*  60 */       (Role.dao.isCurrentUserHasRole("vicesectionchife")) || 
/*  61 */       (Role.dao.isCurrentUserHasRole("normaluser"))) {
/*  62 */       return PetitionInfo.dao.findMemberReadCount();
/*     */     }
/*  64 */     return 0L;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public String savePetitionFile(UploadFile uploadFile, HttpServletRequest request)
/*     */     throws BizException, IOException
/*     */   {
/*  72 */     String uuid = UUIDUtils.getRandomUUIDString();
/*  73 */     String uploadDirPath = request.getSession().getServletContext()
/*  74 */       .getRealPath("/userupload/inboxfile/" + uuid);
/*  75 */     FileUtils.unZip(uploadFile.getFile(), uploadDirPath);
/*  76 */     if (checkPicFileExist(uploadDirPath)) {
/*  77 */       return uuid;
/*     */     }
/*  79 */     throw new BizException("压缩包中不存在图片文件");
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public String savePetitionDoc(PetitionInfo petitionInfo, String fileFolder, HttpServletRequest request)
/*     */     throws BizException
/*     */   {
/*  88 */     String infoId = petitionInfo.getStr("id");
/*  89 */     List<String> picPathList = findPicPathList(fileFolder, request);
/*  90 */     for (int i = 0; i < picPathList.size(); i++)
/*     */     {
/*     */ 
/*  93 */       ((PetitionInfoDoc)((PetitionInfoDoc)((PetitionInfoDoc)((PetitionInfoDoc)new PetitionInfoDoc().set("path", picPathList.get(i))).set("petitionId", infoId)).set("folder", fileFolder)).set("orderNum", Integer.valueOf(i))).save();
/*     */     }
/*  95 */     petitionInfo.save();
/*  96 */     return infoId;
/*     */   }
/*     */   
/*     */   public boolean isFileExist(String subFolder, HttpServletRequest request) {
/* 100 */     String filePath = request.getSession().getServletContext()
/* 101 */       .getRealPath("/userupload/inboxfile/" + subFolder);
/* 102 */     return checkPicFileExist(filePath);
/*     */   }
/*     */   
/*     */   public List<String> findPicPathList(String folderName, HttpServletRequest request) throws BizException
/*     */   {
/* 107 */     String filePath = request.getSession().getServletContext()
/* 108 */       .getRealPath("/userupload/inboxfile/" + folderName);
/*     */     
/* 110 */     File folder = new File(filePath);
/* 111 */     if (!folder.exists()) {
/* 112 */       throw new BizException("未找到上传的文件");
/*     */     }
/*     */     
/* 115 */     List<String> fileNameList = new ArrayList();
/* 116 */     File[] arrayOfFile; int j = (arrayOfFile = folder.listFiles()).length; for (int i = 0; i < j; i++) { File file = arrayOfFile[i];
/* 117 */       if (!file.isDirectory())
/*     */       {
/*     */ 
/* 120 */         if (checkIsPic(file.getName())) {
/* 121 */           fileNameList.add("/userupload/inboxfile/" + folderName + "/" + 
/* 122 */             file.getName());
/*     */         }
/*     */       }
/*     */     }
/* 126 */     if (fileNameList.size() > 0) {
/* 127 */       String[] nameArr = (String[])fileNameList.toArray(new String[0]);
/* 128 */       Arrays.sort(nameArr);
/* 129 */       return Arrays.asList(nameArr);
/*     */     }
/* 131 */     throw new BizException("上传的文件夹中不包含图片，请重新上传");
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void savePetionRel(String[] orgIds, String[] userIds, PetitionInfo info, String currentUserId)
/*     */   {
/* 139 */     String petitionInfoId = info.getStr("id");
/*     */     
/* 141 */     StringBuffer statusInfo = new StringBuffer();
/*     */     String[] arrayOfString;
/* 143 */     int j; int i; if (ArrayUtils.isNotEmpty(orgIds))
/*     */     {
/*     */ 
/* 146 */       if (ArrayUtils.isNotEmpty(userIds)) {
/* 147 */         j = (arrayOfString = userIds).length; for (i = 0; i < j; i++) { String uId = arrayOfString[i];
/* 148 */           saveRel(petitionInfoId, uId);
/*     */         }
/*     */       }
/*     */       
/* 152 */       j = (arrayOfString = orgIds).length; for (i = 0; i < j; i++) { String oId = arrayOfString[i];
/*     */         
/* 154 */         List<User> directors = User.dao.findSectionLeader(oId);
/* 155 */         for (User u : directors) {
/* 156 */           saveRel(petitionInfoId, u.getStr("ID"));
/*     */         }
/*     */       }
/* 159 */       deActiveRel(petitionInfoId);
/*     */       
/*     */ 
/* 162 */       j = (arrayOfString = orgIds).length; for (i = 0; i < j; i++) { String oId = arrayOfString[i];
/*     */         
/*     */ 
/* 165 */         List<User> users = User.dao.findUserByDepartIdAndRoleCode(
/* 166 */           "sectionchife", oId);
/* 167 */         for (User u : users) {
/* 168 */           saveRel(petitionInfoId, u.getStr("ID"));
/* 169 */           if (statusInfo.length() == 0) {
/* 170 */             statusInfo.append(u.getStr("realname"));
/*     */           } else {
/* 172 */             statusInfo.append(",").append(u.getStr("realname"));
/*     */           }
/*     */           
/*     */         }
/*     */         
/*     */       }
/*     */     }
/* 179 */     else if (ArrayUtils.isNotEmpty(userIds)) {
/* 180 */       deActiveRel(petitionInfoId);
/* 181 */       j = (arrayOfString = userIds).length; for (i = 0; i < j; i++) { String uId = arrayOfString[i];
/* 182 */         saveRel(petitionInfoId, uId);
/* 183 */         if (statusInfo.length() == 0) {
/* 184 */           statusInfo.append(User.dao.findUserNameById(uId));
/*     */         } else {
/* 186 */           statusInfo.append(",").append(
/* 187 */             User.dao.findUserNameById(uId));
/*     */         }
/*     */       }
/*     */     }
/*     */     
/*     */ 
/*     */ 
/* 194 */     if (Role.dao.isUserContainAnyRole(currentUserId, new String[] { "centerleader", "director" })) {
/* 195 */       info.set("distributed", Integer.valueOf(0));
/*     */     }
/*     */     
/*     */ 
/*     */ 
/* 200 */     ((PetitionInfo)info.set("statusInfo", statusInfo.toString())).update();
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
/*     */   public void saveApproval(String replyContent, PetitionInfo info, String currentUserId)
/*     */   {
/* 214 */     ((PetitionInfo)((PetitionInfo)((PetitionInfo)info.set("replyContent", replyContent)).set("replyed", Integer.valueOf(0))).set("rejected", Integer.valueOf(1))).update();
/* 215 */     List<String> userIdList = null;
/*     */     
/* 217 */     if (Role.dao.isCurrentUserHasRole("normaluser")) {
/* 218 */       userIdList = findRelUserIdsByRoleCode(info.getStr("id"), new String[] {
/* 219 */         "sectionchife" });
/* 220 */     } else if (Role.dao.isCurrentUserHasRole("sectionchife")) {
/* 221 */       userIdList = findRelUserIdsByRoleCode(info.getStr("id"), new String[] {
/* 222 */         "vicedirector" });
/*     */       
/* 224 */       if (CollectionUtils.isEmpty(userIdList)) {
/* 225 */         userIdList = findRelUserIdsByRoleCode(info.getStr("id"), new String[] {
/* 226 */           "centerleader" });
/*     */         
/* 228 */         if (CollectionUtils.isEmpty(userIdList)) {
/* 229 */           deActiveRel(info.getStr("id"));
/* 230 */           ((PetitionInfo)((PetitionInfo)info.set("status", Integer.valueOf(1))).set("statusInfo", "已归档")).update();
/*     */         }
/*     */       }
/*     */     }
/* 234 */     else if (Role.dao.isCurrentUserHasRole("vicedirector")) {
/* 235 */       userIdList = findRelUserIdsByRoleCode(info.getStr("id"), new String[] {
/* 236 */         "centerleader" });
/* 237 */     } else if (Role.dao.isCurrentUserHasRole("centerleader")) {
/* 238 */       deActiveRel(info.getStr("id"));
/* 239 */       ((PetitionInfo)((PetitionInfo)info.set("status", Integer.valueOf(1))).set("statusInfo", "已归档")).update();
/*     */     }
/* 241 */     if (CollectionUtils.isNotEmpty(userIdList)) {
/* 242 */       String[] userIds = new String[userIdList.size()];
/* 243 */       userIdList.toArray(userIds);
/* 244 */       savePetionRel(null, userIds, info, currentUserId);
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
/*     */   public void saveReject(String rejectContent, PetitionInfo info, String currentUserId)
/*     */   {
/* 258 */     ((PetitionInfo)((PetitionInfo)((PetitionInfo)info.set("rejectContent", rejectContent)).set("replyed", Integer.valueOf(0))).set("rejected", Integer.valueOf(0))).update();
/*     */     
/* 260 */     List<String> userIdList = null;
/*     */     
/* 262 */     if (Role.dao.isCurrentUserHasRole("sectionchife")) {
/* 263 */       userIdList = findRelUserIdsByRoleCode(info.getStr("id"), new String[] {
/* 264 */         "normaluser" });
/* 265 */     } else if (Role.dao.isCurrentUserHasRole("vicedirector")) {
/* 266 */       userIdList = findRelUserIdsByRoleCode(info.getStr("id"), new String[] {
/* 267 */         "sectionchife" });
/* 268 */     } else if (Role.dao.isCurrentUserHasRole("centerleader")) {
/* 269 */       userIdList = findRelUserIdsByRoleCode(info.getStr("id"), new String[] {
/* 270 */         "vicedirector" });
/*     */       
/* 272 */       if (CollectionUtils.isEmpty(userIdList)) {
/* 273 */         userIdList = findRelUserIdsByRoleCode(info.getStr("id"), new String[] {
/* 274 */           "sectionchife" });
/*     */       }
/*     */     }
/* 277 */     if (CollectionUtils.isNotEmpty(userIdList)) {
/* 278 */       String[] userIds = new String[userIdList.size()];
/* 279 */       userIdList.toArray(userIds);
/* 280 */       savePetionRel(null, userIds, info, currentUserId);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   private List<String> findRelUserIdsByRoleCode(String infoId, String... roleCode)
/*     */   {
/* 287 */     StringBuffer s = new StringBuffer();
/* 288 */     String[] arrayOfString; int j = (arrayOfString = roleCode).length; for (int i = 0; i < j; i++) { String c = arrayOfString[i];
/* 289 */       if (s.length() > 0) {
/* 290 */         s.append(",");
/*     */       }
/* 292 */       s.append("'").append(c).append("'");
/*     */     }
/* 294 */     String sql = "select u.ID from t_s_base_user as u,t_s_role_user as ru,t_s_role as r,t_oa_petition as p,t_oa_petition_user_rel as pu where u.status=1 and u.ID=ru.userid and r.ID=ru.roleid and u.ID=pu.userId and pu.petitionId=p.id and p.id=? and r.rolecode in(" + 
/* 295 */       s + ")";
/* 296 */     Object result = Db.query(sql, new Object[] { infoId });
/* 297 */     return (List<String>)result;
/*     */   }
/*     */   
/*     */   private boolean checkPicFileExist(String filePath) {
/* 301 */     File folder = new File(filePath);
/* 302 */     if (!folder.exists()) {
/* 303 */       return false;
/*     */     }
/*     */     File[] arrayOfFile;
/* 306 */     int j = (arrayOfFile = folder.listFiles()).length; for (int i = 0; i < j; i++) { File file = arrayOfFile[i];
/* 307 */       if (!file.isDirectory())
/*     */       {
/*     */ 
/* 310 */         if (checkIsPic(file.getName())) {
/* 311 */           return true;
/*     */         }
/*     */       }
/*     */     }
/* 315 */     return false;
/*     */   }
/*     */   
/*     */   private void saveRel(String infoId, String userId) {
/* 319 */     PetitionInfoUserRel rel = PetitionInfoUserRel.dao
/* 320 */       .findByUserIdAndInfoId(userId, infoId);
/* 321 */     if (rel == null)
/*     */     {
/*     */ 
/* 324 */       ((PetitionInfoUserRel)((PetitionInfoUserRel)((PetitionInfoUserRel)((PetitionInfoUserRel)new PetitionInfoUserRel().set("userId", userId)).set("petitionId", infoId)).set("active", Integer.valueOf(0))).set("isReaded", Integer.valueOf(0))).save();
/*     */     } else {
/* 326 */       ((PetitionInfoUserRel)((PetitionInfoUserRel)rel.set("active", Integer.valueOf(0))).set("isReaded", Integer.valueOf(0))).update();
/*     */     }
/*     */   }
/*     */   
/*     */   public void updateReadStatus(String infoId, String userId) {
/* 331 */     PetitionInfoUserRel rel = PetitionInfoUserRel.dao
/* 332 */       .findByUserIdAndInfoId(userId, infoId);
/* 333 */     if (rel != null) {
/* 334 */       ((PetitionInfoUserRel)((PetitionInfoUserRel)rel.set("active", Integer.valueOf(0))).set("isReaded", Integer.valueOf(1))).update();
/*     */     }
/*     */   }
/*     */   
/*     */   private boolean checkIsPic(String fileName) {
/* 339 */     return ArrayUtils.contains(PIC_EXTENSION, getFileSuffix(fileName)
/* 340 */       .toLowerCase());
/*     */   }
/*     */   
/*     */   private String getFileSuffix(String fileName) {
/* 344 */     String fileSuffix = StringUtils.substring(fileName, 
/* 345 */       fileName.lastIndexOf(".") + 1);
/* 346 */     return fileSuffix;
/*     */   }
/*     */   
/*     */   private void deActiveRel(String petitionInfoId)
/*     */   {
/* 351 */     Db.update(
/* 352 */       "update t_oa_petition_user_rel set active = ? where petitionid=?", new Object[] {
/* 353 */       Integer.valueOf(1), petitionInfoId });
/*     */   }
/*     */   
/*     */   public void delete(PetitionInfo info, String currentUserId) {
/* 357 */     String userName = User.dao.findUserNameById(currentUserId);
/* 358 */     ((PetitionInfo)((PetitionInfo)info.set("status", Integer.valueOf(1))).set("statusInfo", userName + "删除")).update();
/* 359 */     Db.update(
/* 360 */       "update t_oa_petition_user_rel set active = ? where petitionid=?", new Object[] {
/* 361 */       Integer.valueOf(1), info.get("id") });
/*     */   }
/*     */ }


/* Location:              E:\aaa\front\WEB-INF\classes\!\com\fgoa\web\service\PetitionService.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */