/*     */ package com.fgoa.controller.userinfo;
/*     */ 
/*     */ import com.fgoa.entity.examconfig.ExamConfigEntity;
import com.fgoa.entity.userinfo.UserFjEntity;
/*     */ import com.fgoa.service.userinfo.UserFjServiceI;

/*     */ import javax.servlet.http.HttpServletRequest;
/*     */ import javax.servlet.http.HttpServletResponse;

/*     */ import org.apache.commons.lang.StringUtils;
/*     */ import org.apache.log4j.Logger;
/*     */ import org.jeecgframework.core.common.controller.BaseController;
/*     */ import org.jeecgframework.core.common.exception.BusinessException;
/*     */ import org.jeecgframework.core.common.hibernate.qbc.CriteriaQuery;
/*     */ import org.jeecgframework.core.common.model.json.AjaxJson;
/*     */ import org.jeecgframework.core.common.model.json.DataGrid;
/*     */ import org.jeecgframework.core.constant.Globals;
/*     */ import org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil;
/*     */ import org.jeecgframework.core.util.MyBeanUtils;
/*     */ import org.jeecgframework.core.util.StringUtil;
/*     */ import org.jeecgframework.core.util.oConvertUtils;
/*     */ import org.jeecgframework.tag.core.easyui.TagUtil;
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
/*     */ 
/*     */ @Controller
/*     */ @RequestMapping({"/userFjController"})
/*     */ public class UserFjController
/*     */   extends BaseController
/*     */ {
/*  45 */   private static final Logger logger = Logger.getLogger(UserFjController.class);
/*     */   @Autowired
/*     */   private UserFjServiceI userFjService;
/*     */   @Autowired
/*     */   private SystemService systemService;
/*     */   private String message;
/*     */   
/*     */   public String getMessage()
/*     */   {
/*  54 */     return this.message;
/*     */   }
/*     */   
/*     */   public void setMessage(String message) {
/*  58 */     this.message = message;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   @RequestMapping(params={"userFj"})
/*     */   public ModelAndView userFj(HttpServletRequest request, String uid)
/*     */   {
/*  69 */     request.setAttribute("uid", uid);
/*  70 */     return new ModelAndView("com/fgoa/userinfo/userFjList");
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
/*     */   @RequestMapping(params={"datagrid"})
/*     */   public void datagrid(UserFjEntity userFj, HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid)
/*     */   {
/*  84 */     CriteriaQuery cq = new CriteriaQuery(UserFjEntity.class, dataGrid);
/*     */     
/*  86 */     HqlGenerateUtil.installHql(cq, userFj, request.getParameterMap());
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  92 */     cq.add();
/*  93 */     this.userFjService.getDataGridReturn(cq, true);
/*  94 */     TagUtil.datagrid(response, dataGrid);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   @RequestMapping(params={"doDel"})
/*     */   @ResponseBody
/*     */   public AjaxJson doDel(UserFjEntity userFj, HttpServletRequest request)
/*     */   {
/* 105 */     AjaxJson j = new AjaxJson();
/* 106 */     userFj = (UserFjEntity)this.systemService.getEntity(UserFjEntity.class, userFj.getId());
/* 107 */     this.message = "上传附件删除成功";
/*     */     try {
/* 109 */       this.userFjService.delete(userFj);
/* 110 */       this.systemService.addLog(this.message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
/*     */     } catch (Exception e) {
/* 112 */       e.printStackTrace();
/* 113 */       this.message = "上传附件删除失败";
/* 114 */       throw new BusinessException(e.getMessage());
/*     */     }
/* 116 */     j.setMsg(this.message);
/* 117 */     return j;
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
/* 128 */     AjaxJson j = new AjaxJson();
/* 129 */     this.message = "上传附件删除成功";
/*     */     try {
	for(String id:ids.split(",")){
		ExamConfigEntity examConfig = systemService.getEntity(ExamConfigEntity.class, 
		Integer.parseInt(id)
		);
		userFjService.delete(examConfig);
		systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
	}
/*     */     } catch (Exception e) {
/* 139 */       e.printStackTrace();
/* 140 */       this.message = "上传附件删除失败";
/* 141 */       throw new BusinessException(e.getMessage());
/*     */     }
/* 143 */     j.setMsg(this.message);
/* 144 */     return j;
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
/*     */   public AjaxJson doAdd(UserFjEntity userFj, HttpServletRequest request)
/*     */   {
/* 157 */     AjaxJson j = new AjaxJson();
/* 158 */     this.message = "上传附件添加成功";
/*     */     try {
/* 160 */       this.userFjService.save(userFj);
/* 161 */       this.systemService.addLog(this.message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
/*     */     } catch (Exception e) {
/* 163 */       e.printStackTrace();
/* 164 */       this.message = "上传附件添加失败";
/* 165 */       throw new BusinessException(e.getMessage());
/*     */     }
/* 167 */     j.setMsg(this.message);
/* 168 */     return j;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   @RequestMapping(params={"doUpdate"})
/*     */   @ResponseBody
/*     */   public AjaxJson doUpdate(UserFjEntity userFj, HttpServletRequest request)
/*     */   {
/* 180 */     AjaxJson j = new AjaxJson();
/* 181 */     this.message = "上传附件更新成功";
/* 182 */     UserFjEntity t = (UserFjEntity)this.userFjService.get(UserFjEntity.class, userFj.getId());
/*     */     try {
/* 184 */       MyBeanUtils.copyBeanNotNull2Bean(userFj, t);
/* 185 */       this.userFjService.saveOrUpdate(t);
/* 186 */       this.systemService.addLog(this.message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
/*     */     } catch (Exception e) {
/* 188 */       e.printStackTrace();
/* 189 */       this.message = "上传附件更新失败";
/* 190 */       throw new BusinessException(e.getMessage());
/*     */     }
/* 192 */     j.setMsg(this.message);
/* 193 */     return j;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   @RequestMapping(params={"goAdd"})
/*     */   public ModelAndView goAdd(UserFjEntity userFj, HttpServletRequest req)
/*     */   {
/* 204 */     String uid = oConvertUtils.getString(req.getParameter("uid"));
/* 205 */     if (StringUtils.isNotBlank(uid)) {
/* 206 */       req.setAttribute("uid", uid);
/*     */     }
/* 208 */     if (StringUtil.isNotEmpty(userFj.getId())) {
/* 209 */       userFj = (UserFjEntity)this.userFjService.getEntity(UserFjEntity.class, userFj.getId());
/* 210 */       req.setAttribute("userFjPage", userFj);
/*     */     }
/* 212 */     return new ModelAndView("com/fgoa/userinfo/userFj-add");
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   @RequestMapping(params={"goUpdate"})
/*     */   public ModelAndView goUpdate(UserFjEntity userFj, HttpServletRequest req)
/*     */   {
/* 221 */     if (StringUtil.isNotEmpty(userFj.getId())) {
/* 222 */       userFj = (UserFjEntity)this.userFjService.getEntity(UserFjEntity.class, userFj.getId());
/* 223 */       req.setAttribute("userFjPage", userFj);
/*     */     }
/* 225 */     return new ModelAndView("com/fgoa/userinfo/userFj-update");
/*     */   }
/*     */ }


