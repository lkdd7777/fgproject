/*     */ package com.fgoa.controller.carassets;
/*     */ 
/*     */ import com.fgoa.entity.car.CarEntity;
import com.fgoa.entity.carassets.CarFjEntity;
/*     */ import com.fgoa.service.carassets.CarFjServiceI;

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
/*     */ @RequestMapping({"/carFjController"})
/*     */ public class CarFjController
/*     */   extends BaseController
/*     */ {
/*  45 */   private static final Logger logger = Logger.getLogger(CarFjController.class);
/*     */   @Autowired
/*     */   private CarFjServiceI carFjService;
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
/*     */   @RequestMapping(params={"carFj"})
/*     */   public ModelAndView carFj(HttpServletRequest request, String cid)
/*     */   {
/*  69 */     request.setAttribute("cid", cid);
/*  70 */     return new ModelAndView("com/fgoa/carassets/carFjList");
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
/*     */   public void datagrid(CarFjEntity carFj, HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid)
/*     */   {
/*  84 */     CriteriaQuery cq = new CriteriaQuery(CarFjEntity.class, dataGrid);
/*     */     
/*  86 */     HqlGenerateUtil.installHql(cq, carFj, request.getParameterMap());
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  92 */     cq.add();
/*  93 */     this.carFjService.getDataGridReturn(cq, true);
/*  94 */     TagUtil.datagrid(response, dataGrid);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   @RequestMapping(params={"doDel"})
/*     */   @ResponseBody
/*     */   public AjaxJson doDel(CarFjEntity carFj, HttpServletRequest request)
/*     */   {
/* 105 */     AjaxJson j = new AjaxJson();
/* 106 */     carFj = (CarFjEntity)this.systemService.getEntity(CarFjEntity.class, carFj.getId());
/* 107 */     this.message = "t_car_fj删除成功";
/*     */     try {
/* 109 */       this.carFjService.delete(carFj);
/* 110 */       this.systemService.addLog(this.message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
/*     */     } catch (Exception e) {
/* 112 */       e.printStackTrace();
/* 113 */       this.message = "t_car_fj删除失败";
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
/* 129 */     this.message = "t_car_fj删除成功";
/*     */     try { 
	for(String id:ids.split(",")){
		CarEntity car = systemService.getEntity(CarEntity.class, 
		id
		);
		carFjService.delete(car);
		systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
	}
				
/*     */     } catch (Exception e) {
/* 139 */       e.printStackTrace();
/* 140 */       this.message = "t_car_fj删除失败";
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
/*     */   public AjaxJson doAdd(CarFjEntity carFj, HttpServletRequest request)
/*     */   {
/* 157 */     AjaxJson j = new AjaxJson();
/* 158 */     this.message = "t_car_fj添加成功";
/*     */     try {
/* 160 */       this.carFjService.save(carFj);
/* 161 */       this.systemService.addLog(this.message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
/*     */     } catch (Exception e) {
/* 163 */       e.printStackTrace();
/* 164 */       this.message = "t_car_fj添加失败";
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
/*     */   public AjaxJson doUpdate(CarFjEntity carFj, HttpServletRequest request)
/*     */   {
/* 180 */     AjaxJson j = new AjaxJson();
/* 181 */     this.message = "t_car_fj更新成功";
/* 182 */     CarFjEntity t = (CarFjEntity)this.carFjService.get(CarFjEntity.class, carFj.getId());
/*     */     try {
/* 184 */       MyBeanUtils.copyBeanNotNull2Bean(carFj, t);
/* 185 */       this.carFjService.saveOrUpdate(t);
/* 186 */       this.systemService.addLog(this.message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
/*     */     } catch (Exception e) {
/* 188 */       e.printStackTrace();
/* 189 */       this.message = "t_car_fj更新失败";
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
/*     */   public ModelAndView goAdd(CarFjEntity carFj, HttpServletRequest req)
/*     */   {
/* 204 */     String cid = oConvertUtils.getString(req.getParameter("cid"));
/*     */     
/* 206 */     if (StringUtils.isNotBlank(cid)) {
/* 207 */       req.setAttribute("cid", cid);
/*     */     }
/*     */     
/* 210 */     if (StringUtil.isNotEmpty(carFj.getId())) {
/* 211 */       carFj = (CarFjEntity)this.carFjService.getEntity(CarFjEntity.class, carFj.getId());
/* 212 */       req.setAttribute("carFjPage", carFj);
/*     */     }
/* 214 */     return new ModelAndView("com/fgoa/carassets/carFj-add");
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   @RequestMapping(params={"goUpdate"})
/*     */   public ModelAndView goUpdate(CarFjEntity carFj, HttpServletRequest req)
/*     */   {
/* 223 */     if (StringUtil.isNotEmpty(carFj.getId())) {
/* 224 */       carFj = (CarFjEntity)this.carFjService.getEntity(CarFjEntity.class, carFj.getId());
/* 225 */       req.setAttribute("carFjPage", carFj);
/*     */     }
/* 227 */     return new ModelAndView("com/fgoa/carassets/carFj-update");
/*     */   }
/*     */ }


/* Location:              E:\aaa\admin\WEB-INF\classes\!\com\fgoa\controller\carassets\CarFjController.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */