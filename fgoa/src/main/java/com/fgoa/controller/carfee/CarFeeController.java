/*     */ package com.fgoa.controller.carfee;
/*     */ 
/*     */ import com.fgoa.entity.car.CarEntity;
import com.fgoa.entity.carfee.CarFeeEntity;
/*     */ import com.fgoa.service.carfee.CarFeeServiceI;

/*     */ import java.util.ArrayList;
/*     */ import java.util.Date;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;

/*     */ import javax.servlet.http.HttpServletRequest;
/*     */ import javax.servlet.http.HttpServletResponse;

/*     */ import org.apache.commons.lang.StringUtils;
/*     */ import org.apache.log4j.Logger;
/*     */ import org.jeecgframework.core.common.controller.BaseController;
/*     */ import org.jeecgframework.core.common.exception.BusinessException;
/*     */ import org.jeecgframework.core.common.hibernate.qbc.CriteriaQuery;
/*     */ import org.jeecgframework.core.common.model.json.AjaxJson;
/*     */ import org.jeecgframework.core.common.model.json.DataGrid;
/*     */ import org.jeecgframework.core.common.model.json.Highchart;
/*     */ import org.jeecgframework.core.constant.Globals;
/*     */ import org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil;
/*     */ import org.jeecgframework.core.util.MyBeanUtils;
/*     */ import org.jeecgframework.core.util.StringUtil;
/*     */ import org.jeecgframework.core.util.oConvertUtils;
/*     */ import org.jeecgframework.tag.core.easyui.TagUtil;
/*     */ import org.jeecgframework.tag.vo.datatable.SortDirection;
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
/*     */ 
/*     */ @Controller
/*     */ @RequestMapping({"/carFeeController"})
/*     */ public class CarFeeController
/*     */   extends BaseController
/*     */ {
/*  53 */   private static final Logger logger = Logger.getLogger(CarFeeController.class);
/*     */   @Autowired
/*     */   private CarFeeServiceI carFeeService;
/*     */   @Autowired
/*     */   private SystemService systemService;
/*     */   private String message;
/*     */   
/*     */   public String getMessage()
/*     */   {
/*  62 */     return this.message;
/*     */   }
/*     */   
/*     */   public void setMessage(String message) {
/*  66 */     this.message = message;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   @RequestMapping(params={"carFee"})
/*     */   public ModelAndView carFee(HttpServletRequest request, String carid)
/*     */   {
/*  76 */     request.setAttribute("carid", carid);
/*  77 */     return new ModelAndView("com/fgoa/carfee/carFeeList");
/*     */   }
/*     */   
/*     */   @RequestMapping(params={"list"})
/*     */   public ModelAndView list(HttpServletRequest request) {
/*  82 */     return new ModelAndView("com/fgoa/carfee/list");
/*     */   }
/*     */   
/*     */   @RequestMapping(params={"feelist"})
/*     */   public ModelAndView feeList(HttpServletRequest request, String carid) {
/*  87 */     if (StringUtils.isNotBlank(carid)) {
/*  88 */       request.setAttribute("carid", carid);
/*     */     }
/*  90 */     return new ModelAndView("com/fgoa/carfee/carFeeList");
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
/*     */   @RequestMapping(params={"datagrid"})
/*     */   public void datagrid(CarFeeEntity carFee, HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid)
/*     */   {
/* 105 */     CriteriaQuery cq = new CriteriaQuery(CarFeeEntity.class, dataGrid);
/* 106 */     cq.addOrder("recorddate", SortDirection.desc);
/*     */     
/* 108 */     HqlGenerateUtil.installHql(cq, 
/* 109 */       carFee, request.getParameterMap());
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 115 */     cq.add();
/* 116 */     this.carFeeService.getDataGridReturn(cq, true);
/* 117 */     TagUtil.datagrid(response, dataGrid);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   @RequestMapping(params={"doDel"})
/*     */   @ResponseBody
/*     */   public AjaxJson doDel(CarFeeEntity carFee, HttpServletRequest request)
/*     */   {
/* 128 */     AjaxJson j = new AjaxJson();
/* 129 */     carFee = (CarFeeEntity)this.systemService.getEntity(CarFeeEntity.class, carFee.getId());
/* 130 */     this.message = "车辆费用删除成功";
/*     */     try {
/* 132 */       this.carFeeService.delete(carFee);
/* 133 */       this.systemService.addLog(this.message, Globals.Log_Type_DEL, 
/* 134 */         Globals.Log_Leavel_INFO);
/*     */     } catch (Exception e) {
/* 136 */       e.printStackTrace();
/* 137 */       this.message = "车辆费用删除失败";
/* 138 */       throw new BusinessException(e.getMessage());
/*     */     }
/* 140 */     j.setMsg(this.message);
/* 141 */     return j;
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
/* 152 */     AjaxJson j = new AjaxJson();
/* 153 */     this.message = "车辆费用删除成功";
/*     */     try { 
	for(String id:ids.split(",")){
		CarEntity car = systemService.getEntity(CarEntity.class, 
		id
		);
		carFeeService.delete(car);
		systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
	}
/*     */     } catch (Exception e) {
/* 163 */       e.printStackTrace();
/* 164 */       this.message = "车辆费用删除失败";
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
/*     */   @RequestMapping(params={"doAdd"})
/*     */   @ResponseBody
/*     */   public AjaxJson doAdd(CarFeeEntity carFee, HttpServletRequest request)
/*     */   {
/* 180 */     AjaxJson j = new AjaxJson();
/* 181 */     this.message = "车辆费用添加成功";
/*     */     try {
/* 183 */       carFee.setRecorddate(new Date());
/* 184 */       this.carFeeService.save(carFee);
/* 185 */       this.systemService.addLog(this.message, Globals.Log_Type_INSERT, 
/* 186 */         Globals.Log_Leavel_INFO);
/*     */     } catch (Exception e) {
/* 188 */       e.printStackTrace();
/* 189 */       this.message = "车辆费用添加失败";
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
/*     */   @RequestMapping(params={"doUpdate"})
/*     */   @ResponseBody
/*     */   public AjaxJson doUpdate(CarFeeEntity carFee, HttpServletRequest request)
/*     */   {
/* 205 */     AjaxJson j = new AjaxJson();
/* 206 */     this.message = "车辆费用更新成功";
/* 207 */     CarFeeEntity t = (CarFeeEntity)this.carFeeService.get(CarFeeEntity.class, carFee.getId());
/*     */     try {
/* 209 */       MyBeanUtils.copyBeanNotNull2Bean(carFee, t);
/* 210 */       this.carFeeService.saveOrUpdate(t);
/* 211 */       this.systemService.addLog(this.message, Globals.Log_Type_UPDATE, 
/* 212 */         Globals.Log_Leavel_INFO);
/*     */     } catch (Exception e) {
/* 214 */       e.printStackTrace();
/* 215 */       this.message = "车辆费用更新失败";
/* 216 */       throw new BusinessException(e.getMessage());
/*     */     }
/* 218 */     j.setMsg(this.message);
/* 219 */     return j;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   @RequestMapping(params={"goAdd"})
/*     */   public ModelAndView goAdd(CarFeeEntity carFee, HttpServletRequest req)
/*     */   {
/* 229 */     String carid = oConvertUtils.getString(req.getParameter("carid"));
/* 230 */     if (StringUtils.isNotBlank(carid)) {
/* 231 */       req.setAttribute("carid", carid);
/*     */     }
/* 233 */     if (StringUtil.isNotEmpty(carFee.getId())) {
/* 234 */       carFee = 
/* 235 */         (CarFeeEntity)this.carFeeService.getEntity(CarFeeEntity.class, carFee.getId());
/* 236 */       req.setAttribute("carFeePage", carFee);
/*     */     }
/* 238 */     return new ModelAndView("com/fgoa/carfee/carFee-add");
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   @RequestMapping(params={"goUpdate"})
/*     */   public ModelAndView goUpdate(CarFeeEntity carFee, HttpServletRequest req)
/*     */   {
/* 248 */     String carid = oConvertUtils.getString(req.getParameter("carid"));
/* 249 */     if (StringUtils.isNotBlank(carid)) {
/* 250 */       req.setAttribute("carid", carid);
/*     */     }
/* 252 */     if (StringUtil.isNotEmpty(carFee.getId())) {
/* 253 */       carFee = 
/* 254 */         (CarFeeEntity)this.carFeeService.getEntity(CarFeeEntity.class, carFee.getId());
/* 255 */       req.setAttribute("carFeePage", carFee);
/*     */     }
/* 257 */     return new ModelAndView("com/fgoa/carfee/carFee-update");
/*     */   }
/*     */   
/*     */   @RequestMapping(params={"stat"})
/*     */   public ModelAndView stat(HttpServletRequest request) {
/* 262 */     String carid = oConvertUtils.getString(request.getParameter("carid"));
/* 263 */     if (StringUtils.isNotBlank(carid)) {
/* 264 */       request.setAttribute("carid", carid);
/*     */     }
/* 266 */     return new ModelAndView("com/fgoa/carfee/carfee-stat");
/*     */   }
/*     */   
/*     */   @RequestMapping(params={"getstat"})
/*     */   @ResponseBody
/*     */   public List<Highchart> getBroswerBar(HttpServletRequest request, String reportType, HttpServletResponse response)
/*     */   {
/* 273 */     List<Highchart> list = new ArrayList();
/* 274 */     Highchart hc = new Highchart();
/* 275 */     hc = new Highchart();
/* 276 */     hc.setName("车辆费用");
/* 277 */     String carid = oConvertUtils.getString(request.getParameter("carid"));
/* 278 */     if (StringUtils.isNotBlank(carid)) {
/* 279 */       StringBuffer sb = new StringBuffer();
/* 280 */       sb.append(
/* 281 */         "select substring(recorddate,1,7),sum(amount) from CarFeeEntity where carid='")
/* 282 */         .append(carid).append("' group by substring(recorddate,1,7)");
/*     */       
/* 284 */       List<Object> statList = this.systemService.findByQueryString(sb.toString());
/*     */       
/* 286 */       hc.setType("折线图");
/*     */       
/* 288 */       List<Map<String, Object>> lt = new ArrayList();
/* 289 */       if (statList.size() > 0) {
/* 290 */         for (Object object : statList) {
/* 291 */           Map<String, Object> map = new HashMap();
/* 292 */           Object[] obj = (Object[])object;
/* 293 */           map.put("month", obj[0]);
/* 294 */           map.put("fee", obj[1]);
/* 295 */           lt.add(map);
/*     */         }
/*     */       }
/*     */     }
/*     */     
/*     */ 
/* 301 */     list.add(hc);
/* 302 */     return list;
/*     */   }
/*     */ }


/* Location:              E:\aaa\admin\WEB-INF\classes\!\com\fgoa\controller\carfee\CarFeeController.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */