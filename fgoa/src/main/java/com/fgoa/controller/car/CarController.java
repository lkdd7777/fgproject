/*     */ package com.fgoa.controller.car;
/*     */ 
/*     */ import com.fgoa.entity.car.CarEntity;
/*     */ import com.fgoa.service.car.CarServiceI;
/*     */ import javax.servlet.http.HttpServletRequest;
/*     */ import javax.servlet.http.HttpServletResponse;
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
/*     */ @Controller
/*     */ @RequestMapping({"/carController"})
/*     */ public class CarController
/*     */   extends BaseController
/*     */ {
/*  39 */   private static final Logger logger = Logger.getLogger(CarController.class);
/*     */   @Autowired
/*     */   private CarServiceI carService;
/*     */   @Autowired
/*     */   private SystemService systemService;
/*     */   private String message;
/*     */   
/*     */   public String getMessage()
/*     */   {
/*  48 */     return this.message;
/*     */   }
/*     */   
/*     */   public void setMessage(String message) {
/*  52 */     this.message = message;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   @RequestMapping(params={"car"})
/*     */   public ModelAndView car(HttpServletRequest request)
/*     */   {
/*  63 */     return new ModelAndView("com/fgoa/car/carList");
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   @RequestMapping(params={"carStatu"})
/*     */   public ModelAndView carStatus(HttpServletRequest request)
/*     */   {
/*  73 */     return new ModelAndView("com/fgoa/car/carStatusList");
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
/*     */   public void datagrid(CarEntity car, HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid)
/*     */   {
/*  87 */     CriteriaQuery cq = new CriteriaQuery(CarEntity.class, dataGrid);
/*     */     
/*  89 */     HqlGenerateUtil.installHql(cq, car, request.getParameterMap());
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  95 */     cq.add();
/*  96 */     this.carService.getDataGridReturn(cq, true);
/*  97 */     TagUtil.datagrid(response, dataGrid);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   @RequestMapping(params={"doDel"})
/*     */   @ResponseBody
/*     */   public AjaxJson doDel(CarEntity car, HttpServletRequest request)
/*     */   {
/* 108 */     AjaxJson j = new AjaxJson();
/* 109 */     car = (CarEntity)this.systemService.getEntity(CarEntity.class, car.getId());
/* 110 */     this.message = "车审保险删除成功";
/*     */     try {
/* 112 */       this.carService.delete(car);
/* 113 */       this.systemService.addLog(this.message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
/*     */     } catch (Exception e) {
/* 115 */       e.printStackTrace();
/* 116 */       this.message = "车审保险删除失败";
/* 117 */       throw new BusinessException(e.getMessage());
/*     */     }
/* 119 */     j.setMsg(this.message);
/* 120 */     return j;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 

				/**
				 * 批量删除车审保险
				 * 
				 * @return
				 */
				 @RequestMapping(params = "doBatchDel")
				@ResponseBody
				public AjaxJson doBatchDel(String ids,HttpServletRequest request){
					AjaxJson j = new AjaxJson();
					message = "车审保险删除成功";
					try{
						for(String id:ids.split(",")){
							CarEntity car = systemService.getEntity(CarEntity.class, 
							id
							);
							carService.delete(car);
							systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
						}
					}catch(Exception e){
						e.printStackTrace();
						message = "车审保险删除失败";
						throw new BusinessException(e.getMessage());
					}
					j.setMsg(message);
					return j;
				}
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   @RequestMapping(params={"doAdd"})
/*     */   @ResponseBody
/*     */   public AjaxJson doAdd(CarEntity car, HttpServletRequest request)
/*     */   {
/* 160 */     AjaxJson j = new AjaxJson();
/* 161 */     this.message = "车审保险添加成功";
/*     */     try {
/* 163 */       car.setStatus("空闲");
/* 164 */       this.carService.save(car);
/* 165 */       this.systemService.addLog(this.message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
/*     */     } catch (Exception e) {
/* 167 */       e.printStackTrace();
/* 168 */       this.message = "车审保险添加失败";
/* 169 */       throw new BusinessException(e.getMessage());
/*     */     }
/* 171 */     j.setMsg(this.message);
/* 172 */     return j;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   @RequestMapping(params={"doUpdate"})
/*     */   @ResponseBody
/*     */   public AjaxJson doUpdate(CarEntity car, HttpServletRequest request)
/*     */   {
/* 184 */     AjaxJson j = new AjaxJson();
/* 185 */     this.message = "车审保险更新成功";
/* 186 */     CarEntity t = (CarEntity)this.carService.get(CarEntity.class, car.getId());
/*     */     try {
/* 188 */       MyBeanUtils.copyBeanNotNull2Bean(car, t);
/* 189 */       this.carService.saveOrUpdate(t);
/* 190 */       this.systemService.addLog(this.message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
/*     */     } catch (Exception e) {
/* 192 */       e.printStackTrace();
/* 193 */       this.message = "车审保险更新失败";
/* 194 */       throw new BusinessException(e.getMessage());
/*     */     }
/* 196 */     j.setMsg(this.message);
/* 197 */     return j;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   @RequestMapping(params={"doUpdateStatus"})
/*     */   @ResponseBody
/*     */   public AjaxJson doUpdateStatus(CarEntity car, HttpServletRequest request)
/*     */   {
/* 209 */     AjaxJson j = new AjaxJson();
/* 210 */     this.message = "车辆状态更新成功";
/* 211 */     CarEntity t = (CarEntity)this.carService.get(CarEntity.class, car.getId());
/*     */     try {
/* 213 */       MyBeanUtils.copyBeanNotNull2Bean(car, t);
/* 214 */       this.carService.saveOrUpdate(t);
/* 215 */       this.systemService.addLog(this.message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
/*     */     } catch (Exception e) {
/* 217 */       e.printStackTrace();
/* 218 */       this.message = "车辆状态更新成功";
/* 219 */       throw new BusinessException(e.getMessage());
/*     */     }
/* 221 */     j.setMsg(this.message);
/* 222 */     return j;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   @RequestMapping(params={"goAdd"})
/*     */   public ModelAndView goAdd(CarEntity car, HttpServletRequest req)
/*     */   {
/* 233 */     if (StringUtil.isNotEmpty(car.getId())) {
/* 234 */       car = (CarEntity)this.carService.getEntity(CarEntity.class, car.getId());
/* 235 */       req.setAttribute("carPage", car);
/*     */     }
/* 237 */     return new ModelAndView("com/fgoa/car/car-add");
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   @RequestMapping(params={"goUpdate"})
/*     */   public ModelAndView goUpdate(CarEntity car, HttpServletRequest req)
/*     */   {
/* 246 */     if (StringUtil.isNotEmpty(car.getId())) {
/* 247 */       car = (CarEntity)this.carService.getEntity(CarEntity.class, car.getId());
/* 248 */       req.setAttribute("carPage", car);
/*     */     }
/* 250 */     return new ModelAndView("com/fgoa/car/car-update");
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   @RequestMapping(params={"goStatusUpdate"})
/*     */   public ModelAndView goStatusUpdate(CarEntity car, HttpServletRequest req)
/*     */   {
/* 260 */     if (StringUtil.isNotEmpty(car.getId())) {
/* 261 */       car = (CarEntity)this.carService.getEntity(CarEntity.class, car.getId());
/* 262 */       req.setAttribute("carPage", car);
/*     */     }
/* 264 */     return new ModelAndView("com/fgoa/car/carstatus-update");
/*     */   }
/*     */ }


/* Location:              E:\aaa\admin\WEB-INF\classes\!\com\fgoa\controller\car\CarController.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */