/*    */ package com.fgoa.web.service;
/*    */ 
/*    */ import com.fgoa.web.model.Schedule;
/*    */ import com.fgoa.web.model.User;
/*    */ import com.fgoa.web.model.UserLeave;
/*    */ import com.fgoa.web.model.UserLeaveApproval;
/*    */ import com.fgoa.web.security.ShiroUtils;
/*    */ import com.fgoa.web.utils.OaDateUtils;
/*    */ import com.fgoa.web.vo.ScheduleVo;
/*    */ import com.woo.jfinal.exception.BizException;
/*    */ import java.util.ArrayList;
/*    */ import java.util.Date;
/*    */ import java.util.List;
/*    */ import org.apache.commons.collections.CollectionUtils;
/*    */ import org.apache.commons.lang.StringUtils;
/*    */ 
/*    */ 
/*    */ public class ScheduleService
/*    */ {
/* 20 */   public static final ScheduleService instance = new ScheduleService();
/*    */   
/*    */   public void submitLeavelApply(Integer type, String typeDesc, Date startDate, Date endDate, boolean isHalfDay)
/*    */   {
/* 24 */     List<String> userRoles = ShiroUtils.getCurrentUserRoles();
/* 25 */     String userDepId = ShiroUtils.getCurrentUserOrgId();
/*    */     
/* 27 */     UserLeave leaveInfo = 
/*    */     
/*    */ 
/* 30 */       (UserLeave)((UserLeave)((UserLeave)((UserLeave)((UserLeave)((UserLeave)new UserLeave().set("type", type)).set("descrtion", typeDesc)).set("startDate", startDate)).set("endDate", endDate)).set("isHalfDay", Boolean.valueOf(isHalfDay))).set("userId", ShiroUtils.getCurrentUserId());
/*    */     
/* 32 */     String userId = null;
/*    */     
/* 34 */     if ((userRoles.contains("normaluser")) || 
/* 35 */       (userRoles.contains("vicesectionchife"))) {
/* 36 */       userId = User.dao.findSectionChife(userDepId).getStr("ID");
/* 37 */     } else if (userRoles.contains("sectionchife")) {
/* 38 */       userId = User.dao.findFirstSectionLeader(userDepId).getStr("ID");
/* 39 */     } else if (userRoles.contains("vicedirector")) {
/* 40 */       List<User> users = User.dao.findUserListByRole("director");
/* 41 */       if (CollectionUtils.isNotEmpty(users)) {
/* 42 */         userId = ((User)users.get(0)).getStr("ID");
/*    */       }
/*    */     }
/*    */     
/* 46 */     if (StringUtils.isNotBlank(userId)) {
/* 47 */       leaveInfo.save();
/* 48 */       UserLeaveApproval approvalInfo = 
/*    */       
/* 50 */         (UserLeaveApproval)((UserLeaveApproval)((UserLeaveApproval)((UserLeaveApproval)new UserLeaveApproval().set("leaveId", leaveInfo.get("id"))).set("active", Boolean.valueOf(true))).set("active", Boolean.valueOf(true))).set("approverId", userId);
/* 51 */       approvalInfo.save();
/*    */     } else {
/* 53 */       throw new BizException("未找到上级审批用户，请与管理员联系");
/*    */     }
/*    */   }
/*    */   
/*    */ 
/*    */   public List<ScheduleVo> queryScheduleInWeek(String userId)
/*    */   {
/* 60 */     List<ScheduleVo> returnValue = new ArrayList();
/* 61 */     User user = (User)User.dao.findById(userId);
/* 62 */     if (user == null) {
/* 63 */       return returnValue;
/*    */     }
/*    */     
/* 66 */     String orgId = user.getStr("departId");
/* 67 */     if (StringUtils.isBlank(orgId)) {
/* 68 */       return returnValue;
/*    */     }
/* 70 */     Date now = new Date();
/* 71 */     Date beginDate = OaDateUtils.getMinTimeInDay(OaDateUtils.getLastMonday(now));
/* 72 */     Date endDate = OaDateUtils.getMinTimeInDay(OaDateUtils.getNextSunday(now));
/* 73 */     return Schedule.dao.queryScheduleList(beginDate, endDate, userId, orgId);
/*    */   }
/*    */ }


/* Location:              E:\aaa\front\WEB-INF\classes\!\com\fgoa\web\service\ScheduleService.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */