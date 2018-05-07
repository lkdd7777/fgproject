/*     */ package com.fgoa.controller.userinfo;
/*     */ 
/*     */ import com.fgoa.entity.examconfig.ExamConfigEntity;
import com.fgoa.entity.userinfo.TUserGzglEntity;
/*     */ import com.fgoa.entity.userinfo.TUserGzjlEntity;
/*     */ import com.fgoa.entity.userinfo.TUserHtglEntity;
/*     */ import com.fgoa.entity.userinfo.TUserInfoEntity;
/*     */ import com.fgoa.entity.userinfo.TUserJcjlEntity;
/*     */ import com.fgoa.entity.userinfo.TUserJtcyEntity;
/*     */ import com.fgoa.entity.userinfo.TUserJyjlEntity;
/*     */ import com.fgoa.entity.userinfo.TUserPxjlEntity;
/*     */ import com.fgoa.entity.userinfo.TUserTxjsEntity;
/*     */ import com.fgoa.page.userinfo.TUserInfoPage;
/*     */ import com.fgoa.service.userinfo.TUserInfoServiceI;

/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;

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
/*     */ import org.jeecgframework.core.util.StringUtil;
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
/*     */ @Controller
/*     */ @RequestMapping({"/tUserInfoController"})
/*     */ public class TUserInfoController
/*     */   extends BaseController
/*     */ {
/*  55 */   private static final Logger logger = Logger.getLogger(TUserInfoController.class);
/*     */   @Autowired
/*     */   private TUserInfoServiceI tUserInfoService;
/*     */   @Autowired
/*     */   private SystemService systemService;
/*     */   private String message;
/*     */   
/*     */   public String getMessage()
/*     */   {
/*  64 */     return this.message;
/*     */   }
/*     */   
/*     */   public void setMessage(String message) {
/*  68 */     this.message = message;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   @RequestMapping(params={"tUserInfo"})
/*     */   public ModelAndView tUserInfo(HttpServletRequest request)
/*     */   {
/*  79 */     return new ModelAndView("com/fgoa/userinfo/tUserInfoList");
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
/*     */   public void datagrid(TUserInfoEntity tUserInfo, HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid)
/*     */   {
/*  93 */     CriteriaQuery cq = new CriteriaQuery(TUserInfoEntity.class, dataGrid);
/*  94 */     Map<String, Object> orderMap = new HashMap();
/*  95 */     orderMap.put("bh", SortDirection.desc);
/*  96 */     cq.setOrder(orderMap);
/*     */     
/*  98 */     HqlGenerateUtil.installHql(cq, tUserInfo);
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 104 */     cq.add();
/* 105 */     this.tUserInfoService.getDataGridReturn(cq, true);
/* 106 */     TagUtil.datagrid(response, dataGrid);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   @RequestMapping(params={"doDel"})
/*     */   @ResponseBody
/*     */   public AjaxJson doDel(TUserInfoEntity tUserInfo, HttpServletRequest request)
/*     */   {
/* 117 */     AjaxJson j = new AjaxJson();
/* 118 */     tUserInfo = (TUserInfoEntity)this.systemService.getEntity(TUserInfoEntity.class, tUserInfo.getId());
/* 119 */     this.message = "用户信息删除成功";
/*     */     try {
/* 121 */       this.tUserInfoService.delMain(tUserInfo);
/* 122 */       this.systemService.addLog(this.message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
/*     */     } catch (Exception e) {
/* 124 */       e.printStackTrace();
/* 125 */       this.message = "用户信息删除失败";
/* 126 */       throw new BusinessException(e.getMessage());
/*     */     }
/* 128 */     j.setMsg(this.message);
/* 129 */     return j;
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
/* 140 */     AjaxJson j = new AjaxJson();
/* 141 */     this.message = "用户信息删除成功";
/*     */     try {
	for(String id:ids.split(",")){
		ExamConfigEntity examConfig = systemService.getEntity(ExamConfigEntity.class, 
		Integer.parseInt(id)
		);
		tUserInfoService.delete(examConfig);
		systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
	}
/*     */     } catch (Exception e) {
/* 151 */       e.printStackTrace();
/* 152 */       this.message = "用户信息删除失败";
/* 153 */       throw new BusinessException(e.getMessage());
/*     */     }
/* 155 */     j.setMsg(this.message);
/* 156 */     return j;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   @RequestMapping(params={"doAdd"})
/*     */   @ResponseBody
/*     */   public AjaxJson doAdd(TUserInfoEntity tUserInfo, TUserInfoPage tUserInfoPage, HttpServletRequest request)
/*     */   {
/* 168 */     List<TUserJtcyEntity> tUserJtcyList = tUserInfoPage.getTUserJtcyList();
/* 169 */     List<TUserJyjlEntity> tUserJyjlList = tUserInfoPage.getTUserJyjlList();
/* 170 */     List<TUserGzjlEntity> tUserGzjlList = tUserInfoPage.getTUserGzjlList();
/* 171 */     List<TUserHtglEntity> tUserHtglList = tUserInfoPage.getTUserHtglList();
/* 172 */     List<TUserJcjlEntity> tUserJcjlList = tUserInfoPage.getTUserJcjlList();
/* 173 */     List<TUserPxjlEntity> tUserPxjlList = tUserInfoPage.getTUserPxjlList();
/* 174 */     List<TUserGzglEntity> tUserGzglList = tUserInfoPage.getTUserGzglList();
/* 175 */     List<TUserTxjsEntity> tUserTxjsList = tUserInfoPage.getTUserTxjsList();
/* 176 */     AjaxJson j = new AjaxJson();
/* 177 */     this.message = "添加成功";
/*     */     try {
/* 179 */       this.tUserInfoService.addMain(tUserInfo, tUserJtcyList, tUserJyjlList, tUserGzjlList, tUserHtglList, tUserJcjlList, tUserPxjlList, tUserGzglList, tUserTxjsList);
/* 180 */       this.systemService.addLog(this.message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
/*     */     } catch (Exception e) {
/* 182 */       e.printStackTrace();
/* 183 */       this.message = "用户信息添加失败";
/* 184 */       throw new BusinessException(e.getMessage());
/*     */     }
/* 186 */     j.setMsg(this.message);
/* 187 */     return j;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   @RequestMapping(params={"doUpdate"})
/*     */   @ResponseBody
/*     */   public AjaxJson doUpdate(TUserInfoEntity tUserInfo, TUserInfoPage tUserInfoPage, HttpServletRequest request)
/*     */   {
/* 198 */     List<TUserJtcyEntity> tUserJtcyList = tUserInfoPage.getTUserJtcyList();
/* 199 */     List<TUserJyjlEntity> tUserJyjlList = tUserInfoPage.getTUserJyjlList();
/* 200 */     List<TUserGzjlEntity> tUserGzjlList = tUserInfoPage.getTUserGzjlList();
/* 201 */     List<TUserHtglEntity> tUserHtglList = tUserInfoPage.getTUserHtglList();
/* 202 */     List<TUserJcjlEntity> tUserJcjlList = tUserInfoPage.getTUserJcjlList();
/* 203 */     List<TUserPxjlEntity> tUserPxjlList = tUserInfoPage.getTUserPxjlList();
/* 204 */     List<TUserGzglEntity> tUserGzglList = tUserInfoPage.getTUserGzglList();
/* 205 */     List<TUserTxjsEntity> tUserTxjsList = tUserInfoPage.getTUserTxjsList();
/* 206 */     AjaxJson j = new AjaxJson();
/* 207 */     this.message = "更新成功";
/*     */     try {
/* 209 */       this.tUserInfoService.updateMain(tUserInfo, tUserJtcyList, tUserJyjlList, tUserGzjlList, tUserHtglList, tUserJcjlList, tUserPxjlList, tUserGzglList, tUserTxjsList);
/* 210 */       this.systemService.addLog(this.message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
/*     */     } catch (Exception e) {
/* 212 */       e.printStackTrace();
/* 213 */       this.message = "更新用户信息失败";
/* 214 */       throw new BusinessException(e.getMessage());
/*     */     }
/* 216 */     j.setMsg(this.message);
/* 217 */     return j;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   @RequestMapping(params={"goAdd"})
/*     */   public ModelAndView goAdd(TUserInfoEntity tUserInfo, HttpServletRequest req)
/*     */   {
/* 227 */     if (StringUtil.isNotEmpty(tUserInfo.getId())) {
/* 228 */       tUserInfo = (TUserInfoEntity)this.tUserInfoService.getEntity(TUserInfoEntity.class, tUserInfo.getId());
/* 229 */       req.setAttribute("tUserInfoPage", tUserInfo);
/*     */     }
/* 231 */     return new ModelAndView("com/fgoa/userinfo/tUserInfo-add");
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   @RequestMapping(params={"goUpdate"})
/*     */   public ModelAndView goUpdate(TUserInfoEntity tUserInfo, HttpServletRequest req)
/*     */   {
/* 241 */     if (StringUtil.isNotEmpty(tUserInfo.getId())) {
/* 242 */       tUserInfo = (TUserInfoEntity)this.tUserInfoService.getEntity(TUserInfoEntity.class, tUserInfo.getId());
/* 243 */       req.setAttribute("tUserInfoPage", tUserInfo);
/*     */     }
/* 245 */     return new ModelAndView("com/fgoa/userinfo/tUserInfo-update");
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
/*     */   @RequestMapping(params={"tUserJtcyList"})
/*     */   public ModelAndView tUserJtcyList(TUserInfoEntity tUserInfo, HttpServletRequest req)
/*     */   {
/* 259 */     Object id0 = tUserInfo.getId();
/*     */     
/*     */ 
/* 262 */     String hql0 = "from TUserJtcyEntity where 1 = 1 AND uID = ? ";
/*     */     try {
/* 264 */       List<TUserJtcyEntity> tUserJtcyEntityList = this.systemService.findHql(hql0, new Object[] { id0 });
/* 265 */       req.setAttribute("tUserJtcyList", tUserJtcyEntityList);
/*     */     } catch (Exception e) {
/* 267 */       logger.info(e.getMessage());
/*     */     }
/* 269 */     return new ModelAndView("com/fgoa/userinfo/tUserJtcyList");
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   @RequestMapping(params={"tUserJyjlList"})
/*     */   public ModelAndView tUserJyjlList(TUserInfoEntity tUserInfo, HttpServletRequest req)
/*     */   {
/* 281 */     Object id1 = tUserInfo.getId();
/*     */     
/*     */ 
/* 284 */     String hql1 = "from TUserJyjlEntity where 1 = 1 AND uID = ? ";
/*     */     try {
/* 286 */       List<TUserJyjlEntity> tUserJyjlEntityList = this.systemService.findHql(hql1, new Object[] { id1 });
/* 287 */       req.setAttribute("tUserJyjlList", tUserJyjlEntityList);
/*     */     } catch (Exception e) {
/* 289 */       logger.info(e.getMessage());
/*     */     }
/* 291 */     return new ModelAndView("com/fgoa/userinfo/tUserJyjlList");
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   @RequestMapping(params={"tUserGzjlList"})
/*     */   public ModelAndView tUserGzjlList(TUserInfoEntity tUserInfo, HttpServletRequest req)
/*     */   {
/* 303 */     Object id2 = tUserInfo.getId();
/*     */     
/*     */ 
/* 306 */     String hql2 = "from TUserGzjlEntity where 1 = 1 AND uID = ? ";
/*     */     try {
/* 308 */       List<TUserGzjlEntity> tUserGzjlEntityList = this.systemService.findHql(hql2, new Object[] { id2 });
/* 309 */       req.setAttribute("tUserGzjlList", tUserGzjlEntityList);
/*     */     } catch (Exception e) {
/* 311 */       logger.info(e.getMessage());
/*     */     }
/* 313 */     return new ModelAndView("com/fgoa/userinfo/tUserGzjlList");
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   @RequestMapping(params={"tUserHtglList"})
/*     */   public ModelAndView tUserHtglList(TUserInfoEntity tUserInfo, HttpServletRequest req)
/*     */   {
/* 325 */     Object id3 = tUserInfo.getId();
/*     */     
/*     */ 
/* 328 */     String hql3 = "from TUserHtglEntity where 1 = 1 AND uID = ? ";
/*     */     try {
/* 330 */       List<TUserHtglEntity> tUserHtglEntityList = this.systemService.findHql(hql3, new Object[] { id3 });
/* 331 */       req.setAttribute("tUserHtglList", tUserHtglEntityList);
/*     */     } catch (Exception e) {
/* 333 */       logger.info(e.getMessage());
/*     */     }
/* 335 */     return new ModelAndView("com/fgoa/userinfo/tUserHtglList");
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   @RequestMapping(params={"tUserJcjlList"})
/*     */   public ModelAndView tUserJcjlList(TUserInfoEntity tUserInfo, HttpServletRequest req)
/*     */   {
/* 347 */     Object id4 = tUserInfo.getId();
/*     */     
/*     */ 
/* 350 */     String hql4 = "from TUserJcjlEntity where 1 = 1 AND uID = ? ";
/*     */     try {
/* 352 */       List<TUserJcjlEntity> tUserJcjlEntityList = this.systemService.findHql(hql4, new Object[] { id4 });
/* 353 */       req.setAttribute("tUserJcjlList", tUserJcjlEntityList);
/*     */     } catch (Exception e) {
/* 355 */       logger.info(e.getMessage());
/*     */     }
/* 357 */     return new ModelAndView("com/fgoa/userinfo/tUserJcjlList");
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   @RequestMapping(params={"tUserPxjlList"})
/*     */   public ModelAndView tUserPxjlList(TUserInfoEntity tUserInfo, HttpServletRequest req)
/*     */   {
/* 369 */     Object id5 = tUserInfo.getId();
/*     */     
/*     */ 
/* 372 */     String hql5 = "from TUserPxjlEntity where 1 = 1 AND uID = ? ";
/*     */     try {
/* 374 */       List<TUserPxjlEntity> tUserPxjlEntityList = this.systemService.findHql(hql5, new Object[] { id5 });
/* 375 */       req.setAttribute("tUserPxjlList", tUserPxjlEntityList);
/*     */     } catch (Exception e) {
/* 377 */       logger.info(e.getMessage());
/*     */     }
/* 379 */     return new ModelAndView("com/fgoa/userinfo/tUserPxjlList");
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   @RequestMapping(params={"tUserGzglList"})
/*     */   public ModelAndView tUserGzglList(TUserInfoEntity tUserInfo, HttpServletRequest req)
/*     */   {
/* 391 */     Object id6 = tUserInfo.getId();
/*     */     
/*     */ 
/* 394 */     String hql6 = "from TUserGzglEntity where 1 = 1 AND uID = ? ";
/*     */     try {
/* 396 */       List<TUserGzglEntity> tUserGzglEntityList = this.systemService.findHql(hql6, new Object[] { id6 });
/* 397 */       req.setAttribute("tUserGzglList", tUserGzglEntityList);
/*     */     } catch (Exception e) {
/* 399 */       logger.info(e.getMessage());
/*     */     }
/* 401 */     return new ModelAndView("com/fgoa/userinfo/tUserGzglList");
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   @RequestMapping(params={"tUserTxjsList"})
/*     */   public ModelAndView tUserTxjsList(TUserInfoEntity tUserInfo, HttpServletRequest req)
/*     */   {
/* 413 */     Object id7 = tUserInfo.getId();
/*     */     
/*     */ 
/* 416 */     String hql7 = "from TUserTxjsEntity where 1 = 1 AND uID = ? ";
/*     */     try {
/* 418 */       List<TUserTxjsEntity> tUserTxjsEntityList = this.systemService.findHql(hql7, new Object[] { id7 });
/* 419 */       req.setAttribute("tUserTxjsList", tUserTxjsEntityList);
/*     */     } catch (Exception e) {
/* 421 */       logger.info(e.getMessage());
/*     */     }
/* 423 */     return new ModelAndView("com/fgoa/userinfo/tUserTxjsList");
/*     */   }
/*     */ }


