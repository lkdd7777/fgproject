/*     */ package com.fgoa.controller.announcement;
/*     */ 
/*     */ import com.fgoa.entity.announcement.AnnouncementEntity;
/*     */ import com.fgoa.entity.conference.ConferenceEntity;
/*     */ import com.fgoa.entity.schedule.ScheduleEntity;
/*     */ import com.fgoa.service.announcement.AnnouncementServiceI;
/*     */ import com.fgoa.service.conference.ConferenceServiceI;
/*     */ import com.fgoa.service.schedule.ScheduleServiceI;
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.HashSet;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import javax.servlet.http.HttpServletRequest;
/*     */ import javax.servlet.http.HttpServletResponse;
/*     */ import org.apache.commons.collections.CollectionUtils;
/*     */ import org.apache.commons.lang.StringUtils;
/*     */ import org.apache.log4j.Logger;
/*     */ import org.jeecgframework.core.common.controller.BaseController;
/*     */ import org.jeecgframework.core.common.exception.BusinessException;
/*     */ import org.jeecgframework.core.common.hibernate.qbc.CriteriaQuery;
/*     */ import org.jeecgframework.core.common.model.json.AjaxJson;
/*     */ import org.jeecgframework.core.common.model.json.DataGrid;
/*     */ import org.jeecgframework.core.common.model.json.TreeGrid;
/*     */ import org.jeecgframework.core.constant.Globals;
/*     */ import org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil;
/*     */ import org.jeecgframework.core.util.MyBeanUtils;
/*     */ import org.jeecgframework.core.util.StringUtil;
/*     */ import org.jeecgframework.tag.core.easyui.TagUtil;
/*     */ import org.jeecgframework.tag.vo.datatable.SortDirection;
/*     */ import org.jeecgframework.tag.vo.easyui.TreeGridModel;
/*     */ import org.jeecgframework.web.system.pojo.base.TSDepart;
/*     */ import org.jeecgframework.web.system.pojo.base.TSUser;
/*     */ import org.jeecgframework.web.system.service.SystemService;
/*     */ import org.springframework.beans.factory.annotation.Autowired;
/*     */ import org.springframework.stereotype.Controller;
/*     */ import org.springframework.web.bind.annotation.RequestMapping;
/*     */ import org.springframework.web.bind.annotation.ResponseBody;
/*     */ import org.springframework.web.servlet.ModelAndView;
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
/*     */ @Controller
/*     */ @RequestMapping({"/announcementController"})
/*     */ public class AnnouncementController
/*     */   extends BaseController
/*     */ {
/*  59 */   private static final Logger logger = Logger.getLogger(AnnouncementController.class);
/*     */   
/*     */   @Autowired
/*     */   private AnnouncementServiceI announcementService;
/*     */   
/*     */   @Autowired
/*     */   private ConferenceServiceI conferenceService;
/*     */   
/*     */   @Autowired
/*     */   private ScheduleServiceI scheduleService;
/*     */   
/*     */   @Autowired
/*     */   private SystemService systemService;
/*     */   private String message;
/*     */   
/*     */   public String getMessage()
/*     */   {
/*  76 */     return this.message;
/*     */   }
/*     */   
/*     */   public void setMessage(String message) {
/*  80 */     this.message = message;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   @RequestMapping(params={"announcement"})
/*     */   public ModelAndView announcement(HttpServletRequest request)
/*     */   {
/*  91 */     return new ModelAndView("com/fgoa/announcement/announcementList");
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
/*     */   @RequestMapping(params={"datagrid"})
/*     */   public void datagrid(AnnouncementEntity announcement, HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid)
/*     */   {
/* 107 */     CriteriaQuery cq = new CriteriaQuery(AnnouncementEntity.class, dataGrid);
/* 108 */     if (StringUtils.isBlank(dataGrid.getSort())) {
/* 109 */       Map<String, Object> orderMap = new HashMap();
/* 110 */       orderMap.put("validtime", SortDirection.desc);
/* 111 */       cq.setOrder(orderMap);
/*     */     }
/*     */     
/* 114 */     HqlGenerateUtil.installHql(cq, 
/* 115 */       announcement, request.getParameterMap());
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 121 */     cq.add();
/* 122 */     this.announcementService.getDataGridReturn(cq, true);
/* 123 */     TagUtil.datagrid(response, dataGrid);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   @RequestMapping(params={"doDel"})
/*     */   @ResponseBody
/*     */   public AjaxJson doDel(AnnouncementEntity announcement, HttpServletRequest request)
/*     */   {
/* 135 */     AjaxJson j = new AjaxJson();
/* 136 */     announcement = (AnnouncementEntity)this.systemService.getEntity(AnnouncementEntity.class, 
/* 137 */       announcement.getId());
/* 138 */     this.message = "公告通知删除成功";
/*     */     try {
/* 140 */       deleteConferenceByAnno(announcement);
/* 141 */       deleteScheduleByAnno(announcement);
/* 142 */       announcement.setDeparts(null);
/* 143 */       announcement.setUsers(null);
/* 144 */       this.announcementService.save(announcement);
/* 145 */       this.announcementService.delete(announcement);
/* 146 */       this.systemService.addLog(this.message, Globals.Log_Type_DEL, 
/* 147 */         Globals.Log_Leavel_INFO);
/*     */     } catch (Exception e) {
/* 149 */       e.printStackTrace();
/* 150 */       this.message = "公告通知删除失败";
/* 151 */       throw new BusinessException(e.getMessage());
/*     */     }
/* 153 */     j.setMsg(this.message);
/* 154 */     return j;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   @RequestMapping(params={"doBatchDel"})
/*     */   @ResponseBody
/*     */   public AjaxJson doBatchDel(String ids, HttpServletRequest request)
/*     */   {
/* 165 */     AjaxJson j = new AjaxJson();
/* 166 */     this.message = "公告通知删除成功";
/*     */     try {
	for (String id : ids.split(",")) {
		AnnouncementEntity announcement = systemService.getEntity(
				AnnouncementEntity.class, id);
		deleteConferenceByAnno(announcement);
		deleteScheduleByAnno(announcement);
		announcement.setDeparts(null);
		announcement.setUsers(null);
		announcementService.save(announcement);
		announcementService.delete(announcement);
		systemService.addLog(message, Globals.Log_Type_DEL,
				Globals.Log_Leavel_INFO);
	}
/*     */     } catch (Exception e) {
/* 181 */       e.printStackTrace();
/* 182 */       this.message = "公告通知删除失败";
/* 183 */       throw new BusinessException(e.getMessage());
/*     */     }
/* 185 */     j.setMsg(this.message);
/* 186 */     return j;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   @RequestMapping(params={"doAdd"})
/*     */   @ResponseBody
/*     */   public AjaxJson doAdd(AnnouncementEntity announcement, HttpServletRequest request, String departIds, String userIds, String announcementTile)
/*     */   {
/* 199 */     AjaxJson j = new AjaxJson();
/* 200 */     this.message = "公告通知添加成功";
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     try
/*     */     {
/* 209 */       if (StringUtils.equals(announcement.getType(), "0")) {
/* 210 */         announcement.setTitle(announcementTile);
/*     */       }
/*     */       
/* 213 */       this.announcementService.save(announcement);
/*     */       
/* 215 */       if (StringUtils.equals(announcement.getType(), "1")) {
/* 216 */         saveAnnouncementDepart(announcement, departIds);
/* 217 */         saveAnnouncementUser(announcement, userIds, departIds);
/* 218 */         saveConference(announcement, departIds, userIds);
/* 219 */         saveSchedule(announcement, departIds, userIds);
/*     */       } else {
/* 221 */         announcement.setDeparts(this.systemService.loadAll(TSDepart.class));
/* 222 */         announcement.setDepartsNameStr(getDepartsNameStr(this.systemService.loadAll(TSDepart.class)));
/*     */         
/* 224 */         StringBuffer sb = new StringBuffer();
/* 225 */         List<TSDepart> departs = this.systemService.loadAll(TSDepart.class);
/* 226 */         for (TSDepart t : departs) {
/* 227 */           sb.append(t.getId()).append(",");
/*     */         }
/* 229 */         if (sb.length() > 0) {
/* 230 */           sb.deleteCharAt(sb.length() - 1);
/*     */         }
/* 232 */         saveAnnouncementUser(announcement, "", sb.toString());
/* 233 */         this.announcementService.saveOrUpdate(announcement);
/*     */       }
/*     */       
/* 236 */       this.systemService.addLog(this.message, Globals.Log_Type_INSERT, 
/* 237 */         Globals.Log_Leavel_INFO);
/*     */     }
/*     */     catch (Exception e) {
/* 240 */       e.printStackTrace();
/* 241 */       this.message = "公告通知添加失败";
/* 242 */       throw new BusinessException(this.message);
/*     */     }
/* 244 */     j.setMsg(this.message);
/* 245 */     return j;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   @RequestMapping(params={"doUpdate"})
/*     */   @ResponseBody
/*     */   public AjaxJson doUpdate(AnnouncementEntity announcement, HttpServletRequest request, String departIds, String userIds)
/*     */   {
/* 258 */     AjaxJson j = new AjaxJson();
/* 259 */     this.message = "公告通知更新成功";
/*     */     
/* 261 */     AnnouncementEntity t = (AnnouncementEntity)this.announcementService.get(
/* 262 */       AnnouncementEntity.class, announcement.getId());
/*     */     try {
/* 264 */       MyBeanUtils.copyBeanNotNull2Bean(announcement, t);
/*     */       
/* 266 */       t.setDeparts(null);
/* 267 */       this.announcementService.saveOrUpdate(t);
/* 268 */       saveAnnouncementDepart(t, departIds);
/* 269 */       saveAnnouncementUser(t, userIds, departIds);
/*     */       
/* 271 */       saveConference(t, departIds, userIds);
/* 272 */       saveSchedule(t, departIds, userIds);
/*     */       
/* 274 */       this.systemService.addLog(this.message, Globals.Log_Type_UPDATE, 
/* 275 */         Globals.Log_Leavel_INFO);
/*     */     } catch (Exception e) {
/* 277 */       e.printStackTrace();
/* 278 */       this.message = "公告通知更新失败";
/* 279 */       throw new BusinessException(e.getMessage());
/*     */     }
/* 281 */     j.setMsg(this.message);
/* 282 */     return j;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   @RequestMapping(params={"goAdd"})
/*     */   public ModelAndView goAdd(AnnouncementEntity announcement, HttpServletRequest req)
/*     */   {
/* 293 */     if (StringUtil.isNotEmpty(announcement.getId())) {
/* 294 */       announcement = (AnnouncementEntity)this.announcementService.getEntity(
/* 295 */         AnnouncementEntity.class, announcement.getId());
/* 296 */       req.setAttribute("announcementPage", announcement);
/*     */     }
/*     */     
/* 299 */     req.setAttribute("departList", this.systemService.getList(TSDepart.class));
/* 300 */     return new ModelAndView("com/fgoa/announcement/announcement-add");
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   @RequestMapping(params={"goUpdate"})
/*     */   public ModelAndView goUpdate(AnnouncementEntity announcement, HttpServletRequest req)
/*     */   {
/* 311 */     if (StringUtil.isNotEmpty(announcement.getId())) {
/* 312 */       announcement = (AnnouncementEntity)this.announcementService.getEntity(
/* 313 */         AnnouncementEntity.class, announcement.getId());
/* 314 */       req.setAttribute("announcementPage", announcement);
/*     */     }
/* 316 */     return new ModelAndView("com/fgoa/announcement/announcement-update");
/*     */   }
/*     */   
/*     */   @RequestMapping(params={"selectDepart"})
/*     */   public String showDeparts() {
/* 321 */     return "com/fgoa/announcement/selectDepart";
/*     */   }
/*     */   
/*     */   @RequestMapping(params={"selectUser"})
/*     */   public String showUsers() {
/* 326 */     return "com/fgoa/announcement/selectUser";
/*     */   }
/*     */   
/*     */   @RequestMapping(params={"departGrid"})
/*     */   public void departGrid(HttpServletResponse response, DataGrid dataGrid) {
/* 331 */     CriteriaQuery cq = new CriteriaQuery(TSDepart.class, dataGrid);
/* 332 */     this.systemService.getDataGridReturn(cq, true);
/* 333 */     TagUtil.datagrid(response, dataGrid);
/*     */   }
/*     */   
/*     */   @RequestMapping(params={"userGrid"})
/*     */   public void userGrid(HttpServletResponse response, DataGrid dataGrid) {
/* 338 */     CriteriaQuery cq = new CriteriaQuery(TSUser.class, dataGrid);
/* 339 */     this.systemService.getDataGridReturn(cq, true);
/* 340 */     TagUtil.datagrid(response, dataGrid);
/*     */   }
/*     */   
/*     */   @RequestMapping(params={"departTreeGrid"})
/*     */   @ResponseBody
/*     */   public List<TreeGrid> departTree(TSDepart tSDepart, TreeGrid treegrid) {
/* 346 */     CriteriaQuery cq = new CriteriaQuery(TSDepart.class);
/*     */     
/* 348 */     if (tSDepart.getDepartname() != null)
/*     */     {
/* 350 */       HqlGenerateUtil.installHql(cq, tSDepart);
/*     */     }
/* 352 */     if (treegrid.getId() != null) {
/* 353 */       cq.eq("TSPDepart.id", treegrid.getId());
/*     */     }
/* 355 */     if (treegrid.getId() == null) {
/* 356 */       cq.isNull("TSPDepart");
/*     */     }
/* 358 */     cq.add();
/* 359 */     List<TreeGrid> departList = null;
/* 360 */     cq.addOrder("orderNum", SortDirection.desc);
/* 361 */     departList = this.systemService.getListByCriteriaQuery(cq, Boolean.valueOf(false));
/*     */     
/* 363 */     List<TreeGrid> treeGrids = new ArrayList();
/* 364 */     TreeGridModel treeGridModel = new TreeGridModel();
/* 365 */     treeGridModel.setTextField("departname");
/* 366 */     treeGridModel.setParentText("TSPDepart_departname");
/* 367 */     treeGridModel.setParentId("TSPDepart_id");
/* 368 */     treeGridModel.setSrc("description");
/* 369 */     treeGridModel.setIdField("id");
/* 370 */     treeGridModel.setChildList("TSDeparts");
/* 371 */     treeGrids = this.systemService.treegrid(departList, treeGridModel);
/*     */     
/* 373 */     return treeGrids;
/*     */   }
/*     */   
/*     */   private void saveConference(AnnouncementEntity announcement, String departIds, String userIds)
/*     */   {
/* 378 */     deleteConferenceByAnno(announcement);
/* 379 */     if (StringUtils.equals("1", announcement.getType())) {
/* 380 */       ConferenceEntity conference = new ConferenceEntity();
/* 381 */       conference.setContent(announcement.getContent());
/* 382 */       if (StringUtils.equals("大会议室", announcement.getTitle())) {
/* 383 */         conference.setRoomtype("1");
/* 384 */       } else if (StringUtils.equals("小会议室", announcement.getTitle())) {
/* 385 */         conference.setRoomtype("2");
/* 386 */       } else if (StringUtils.equals("阅览室", announcement.getTitle())) {
/* 387 */         conference.setRoomtype("3");
/*     */       } else {
/* 389 */         conference.setRoomtype("4");
/*     */       }
/*     */       
/* 392 */       conference.setExecutetime(announcement.getInvalidtime());
/* 393 */       conference.setMasterDepartName(announcement.getMasterDepartName());
/* 394 */       conference.setAnno(announcement);
/* 395 */       this.conferenceService.save(conference);
/* 396 */       saveConferenceDepart(conference, departIds);
/* 397 */       saveConferenceUser(conference, userIds);
/*     */     }
/*     */   }
/*     */   
/*     */   private void saveSchedule(AnnouncementEntity announcement, String departIds, String userIds)
/*     */   {
/* 403 */     deleteScheduleByAnno(announcement);
/* 404 */     if (StringUtils.equals("1", announcement.getType())) {
/* 405 */       ScheduleEntity schedule = new ScheduleEntity();
/* 406 */       schedule.setContent(announcement.getContent());
/* 407 */       schedule.setAddress(announcement.getTitle());
/* 408 */       schedule.setExecutetime(announcement.getValidtime());
/* 409 */       schedule.setMasterDepartName(announcement.getMasterDepartName());
/* 410 */       schedule.setAnno(announcement);
/* 411 */       this.scheduleService.save(schedule);
/* 412 */       saveScheduleDepart(schedule, departIds);
/* 413 */       saveScheduleUser(schedule, userIds);
/*     */     }
/*     */   }
/*     */   
/*     */   public void deleteConferenceByAnno(AnnouncementEntity announcement) {
/* 418 */     ConferenceEntity conference = null;
/* 419 */     if ((announcement != null) && 
/* 420 */       (StringUtils.isNotBlank(announcement.getId()))) {
/* 421 */       conference = (ConferenceEntity)this.conferenceService.findUniqueByProperty(
/* 422 */         ConferenceEntity.class, "anno.id", announcement.getId());
/*     */     }
/* 424 */     if (conference != null) {
/* 425 */       conference.setDeparts(null);
/* 426 */       conference.setUsers(null);
/* 427 */       this.conferenceService.save(conference);
/* 428 */       this.conferenceService.delete(conference);
/*     */     }
/*     */   }
/*     */   
/*     */   public void deleteScheduleByAnno(AnnouncementEntity announcement) {
/* 433 */     ScheduleEntity schedule = null;
/* 434 */     if ((announcement != null) && 
/* 435 */       (StringUtils.isNotBlank(announcement.getId()))) {
/* 436 */       schedule = (ScheduleEntity)this.scheduleService.findUniqueByProperty(
/* 437 */         ScheduleEntity.class, "anno", announcement);
/*     */     }
/* 439 */     if (schedule != null) {
/* 440 */       schedule.setDeparts(null);
/* 441 */       schedule.setUsers(null);
/* 442 */       this.scheduleService.save(schedule);
/* 443 */       this.scheduleService.delete(schedule);
/*     */     }
/*     */   }
/*     */   
/*     */   private void saveAnnouncementDepart(AnnouncementEntity announcement, String departIds)
/*     */   {
/* 449 */     String[] departArr = departIds.split(",");
/* 450 */     List<TSDepart> departs = new ArrayList();
/*     */     
/* 452 */     for (int i = 0; i < departArr.length; i++) {
/* 453 */       TSDepart depart = (TSDepart)this.systemService.getEntity(TSDepart.class, 
/* 454 */         departArr[i]);
/* 455 */       if (depart != null) {
/* 456 */         departs.add(depart);
/*     */       }
/*     */     }
/* 459 */     announcement.setDeparts(departs);
/* 460 */     announcement.setDepartsNameStr(getDepartsNameStr(departs));
/* 461 */     this.announcementService.saveOrUpdate(announcement);
/*     */   }
/*     */   
/*     */   private void saveAnnouncementUser(AnnouncementEntity announcement, String userIds, String departIds)
/*     */   {
/* 466 */     String[] userArr = userIds.split(",");
/* 467 */     String[] departArr = departIds.split(",");
/* 468 */     Set<TSUser> users = new HashSet();
/* 469 */     List<TSUser> userNameList = new ArrayList();
/*     */     
/* 471 */     for (int i = 0; i < departArr.length; i++) {
/* 472 */       TSDepart depart = (TSDepart)this.systemService.getEntity(TSDepart.class, 
/* 473 */         departArr[i]);
/* 474 */       if (depart != null) {
/* 475 */         users.addAll(this.systemService.findByProperty(TSUser.class, "TSDepart", depart));
/*     */       }
/*     */     }
/*     */     
/* 479 */     for (int i = 0; i < userArr.length; i++) {
/* 480 */       TSUser user = (TSUser)this.systemService.getEntity(TSUser.class, userArr[i]);
/* 481 */       if (user != null) {
/* 482 */         users.add(user);
/* 483 */         userNameList.add(user);
/*     */       }
/*     */     }
/*     */     
/* 487 */     List<TSUser> userList = new ArrayList();
/* 488 */     userList.addAll(users);
/* 489 */     announcement.setUsers(userList);
/* 490 */     announcement.setUsersNameStr(getUsersNameStr(userNameList));
/* 491 */     this.announcementService.saveOrUpdate(announcement);
/*     */   }
/*     */   
/*     */   private void saveConferenceDepart(ConferenceEntity c, String departIds) {
/* 495 */     String[] departArr = departIds.split(",");
/* 496 */     List<TSDepart> departs = new ArrayList();
/* 497 */     for (int i = 0; i < departArr.length; i++) {
/* 498 */       TSDepart depart = (TSDepart)this.systemService.getEntity(TSDepart.class, 
/* 499 */         departArr[i]);
/* 500 */       if (depart != null) {
/* 501 */         departs.add(depart);
/*     */       }
/*     */     }
/* 504 */     c.setDeparts(departs);
/* 505 */     this.conferenceService.saveOrUpdate(c);
/*     */   }
/*     */   
/*     */   private void saveConferenceUser(ConferenceEntity c, String userIds) {
/* 509 */     String[] userArr = userIds.split(",");
/* 510 */     List<TSUser> users = new ArrayList();
/* 511 */     for (int i = 0; i < userArr.length; i++) {
/* 512 */       TSUser user = (TSUser)this.systemService.getEntity(TSUser.class, userArr[i]);
/* 513 */       if (user != null) {
/* 514 */         users.add(user);
/*     */       }
/*     */     }
/* 517 */     c.setUsers(users);
/* 518 */     this.conferenceService.saveOrUpdate(c);
/*     */   }
/*     */   
/*     */   private void saveScheduleDepart(ScheduleEntity s, String departIds) {
/* 522 */     String[] departArr = departIds.split(",");
/* 523 */     List<TSDepart> departs = new ArrayList();
/* 524 */     for (int i = 0; i < departArr.length; i++) {
/* 525 */       TSDepart depart = (TSDepart)this.systemService.getEntity(TSDepart.class, 
/* 526 */         departArr[i]);
/*     */       
/* 528 */       if (depart != null) {
/* 529 */         departs.add(depart);
/*     */       }
/*     */     }
/* 532 */     s.setDeparts(departs);
/* 533 */     this.scheduleService.saveOrUpdate(s);
/*     */   }
/*     */   
/*     */   private void saveScheduleUser(ScheduleEntity s, String userIds) {
/* 537 */     String[] userArr = userIds.split(",");
/* 538 */     List<TSUser> users = new ArrayList();
/* 539 */     for (int i = 0; i < userArr.length; i++) {
/* 540 */       TSUser user = (TSUser)this.systemService.getEntity(TSUser.class, userArr[i]);
/* 541 */       if (user != null) {
/* 542 */         users.add(user);
/*     */       }
/*     */     }
/* 545 */     s.setUsers(users);
/* 546 */     this.scheduleService.saveOrUpdate(s);
/*     */   }
/*     */   
/*     */   private String getDepartsNameStr(List<TSDepart> dlist) {
/* 550 */     StringBuilder sb = new StringBuilder();
/* 551 */     if (CollectionUtils.isNotEmpty(dlist)) {
/* 552 */       for (TSDepart d : dlist) {
/* 553 */         sb.append(d.getDepartname() + ",");
/*     */       }
/*     */       
/* 556 */       sb.deleteCharAt(sb.length() - 1);
/*     */     }
/* 558 */     return sb.toString();
/*     */   }
/*     */   
/*     */   private String getUsersNameStr(List<TSUser> ulist) {
/* 562 */     StringBuilder sb = new StringBuilder();
/* 563 */     if (CollectionUtils.isNotEmpty(ulist)) {
/* 564 */       for (TSUser d : ulist) {
/* 565 */         sb.append(d.getRealName() + ",");
/*     */       }
/*     */       
/* 568 */       sb.deleteCharAt(sb.length() - 1);
/*     */     }
/* 570 */     return sb.toString();
/*     */   }
/*     */ }


/* Location:              E:\aaa\admin\WEB-INF\classes\!\com\fgoa\controller\announcement\AnnouncementController.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */