/*     */ package com.fgoa.controller.houseassets;
/*     */ 
/*     */ import com.fgoa.entity.examconfig.ExamConfigEntity;
import com.fgoa.entity.houseassets.HouseFjEntity;
/*     */ import com.fgoa.service.houseassets.HouseFjServiceI;

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
/*     */ @RequestMapping({"/houseFjController"})
/*     */ public class HouseFjController
/*     */   extends BaseController
/*     */ {
/*  45 */   private static final Logger logger = Logger.getLogger(HouseFjController.class);
/*     */   @Autowired
/*     */   private HouseFjServiceI houseFjService;
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
/*     */   @RequestMapping(params={"houseFj"})
/*     */   public ModelAndView houseFj(HttpServletRequest request, String hid)
/*     */   {
/*  69 */     request.setAttribute("hid", hid);
/*  70 */     return new ModelAndView("com/fgoa/houseassets/houseFjList");
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
/*     */   public void datagrid(HouseFjEntity houseFj, HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid)
/*     */   {
/*  84 */     CriteriaQuery cq = new CriteriaQuery(HouseFjEntity.class, dataGrid);
/*     */     
/*  86 */     HqlGenerateUtil.installHql(cq, houseFj, request.getParameterMap());
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  92 */     cq.add();
/*  93 */     this.houseFjService.getDataGridReturn(cq, true);
/*  94 */     TagUtil.datagrid(response, dataGrid);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   @RequestMapping(params={"doDel"})
/*     */   @ResponseBody
/*     */   public AjaxJson doDel(HouseFjEntity houseFj, HttpServletRequest request)
/*     */   {
/* 105 */     AjaxJson j = new AjaxJson();
/* 106 */     houseFj = (HouseFjEntity)this.systemService.getEntity(HouseFjEntity.class, houseFj.getId());
/* 107 */     this.message = "t_house_fj删除成功";
/*     */     try {
/* 109 */       this.houseFjService.delete(houseFj);
/* 110 */       this.systemService.addLog(this.message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
/*     */     } catch (Exception e) {
/* 112 */       e.printStackTrace();
/* 113 */       this.message = "t_house_fj删除失败";
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
/* 129 */     this.message = "t_house_fj删除成功";
/*     */     try { 
	for(String id:ids.split(",")){
		ExamConfigEntity examConfig = systemService.getEntity(ExamConfigEntity.class, 
		Integer.parseInt(id)
		);
		houseFjService.delete(examConfig);
		systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
	}
/*     */     } catch (Exception e) {
/* 139 */       e.printStackTrace();
/* 140 */       this.message = "t_house_fj删除失败";
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
/*     */   public AjaxJson doAdd(HouseFjEntity houseFj, HttpServletRequest request)
/*     */   {
/* 157 */     AjaxJson j = new AjaxJson();
/* 158 */     this.message = "t_house_fj添加成功";
/*     */     try {
/* 160 */       this.houseFjService.save(houseFj);
/* 161 */       this.systemService.addLog(this.message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
/*     */     } catch (Exception e) {
/* 163 */       e.printStackTrace();
/* 164 */       this.message = "t_house_fj添加失败";
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
/*     */   public AjaxJson doUpdate(HouseFjEntity houseFj, HttpServletRequest request)
/*     */   {
/* 180 */     AjaxJson j = new AjaxJson();
/* 181 */     this.message = "t_house_fj更新成功";
/* 182 */     HouseFjEntity t = (HouseFjEntity)this.houseFjService.get(HouseFjEntity.class, houseFj.getId());
/*     */     try {
/* 184 */       MyBeanUtils.copyBeanNotNull2Bean(houseFj, t);
/* 185 */       this.houseFjService.saveOrUpdate(t);
/* 186 */       this.systemService.addLog(this.message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
/*     */     } catch (Exception e) {
/* 188 */       e.printStackTrace();
/* 189 */       this.message = "t_house_fj更新失败";
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
/*     */   public ModelAndView goAdd(HouseFjEntity houseFj, HttpServletRequest req)
/*     */   {
/* 204 */     String hid = oConvertUtils.getString(req.getParameter("hid"));
/*     */     
/* 206 */     if (StringUtils.isNotBlank(hid)) {
/* 207 */       req.setAttribute("hid", hid);
/*     */     }
/*     */     
/* 210 */     if (StringUtil.isNotEmpty(houseFj.getId())) {
/* 211 */       houseFj = (HouseFjEntity)this.houseFjService.getEntity(HouseFjEntity.class, houseFj.getId());
/* 212 */       req.setAttribute("houseFjPage", houseFj);
/*     */     }
/* 214 */     return new ModelAndView("com/fgoa/houseassets/houseFj-add");
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   @RequestMapping(params={"goUpdate"})
/*     */   public ModelAndView goUpdate(HouseFjEntity houseFj, HttpServletRequest req)
/*     */   {
/* 223 */     if (StringUtil.isNotEmpty(houseFj.getId())) {
/* 224 */       houseFj = (HouseFjEntity)this.houseFjService.getEntity(HouseFjEntity.class, houseFj.getId());
/* 225 */       req.setAttribute("houseFjPage", houseFj);
/*     */     }
/* 227 */     return new ModelAndView("com/fgoa/houseassets/houseFj-update");
/*     */   }
/*     */ }


/* Location:              E:\aaa\admin\WEB-INF\classes\!\com\fgoa\controller\houseassets\HouseFjController.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */