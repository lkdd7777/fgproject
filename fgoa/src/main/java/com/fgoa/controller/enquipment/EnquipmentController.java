package com.fgoa.controller.enquipment;
import java.util.List;
import java.text.SimpleDateFormat;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import org.jeecgframework.core.common.controller.BaseController;
import org.jeecgframework.core.common.exception.BusinessException;
import org.jeecgframework.core.common.hibernate.qbc.CriteriaQuery;
import org.jeecgframework.core.common.model.json.AjaxJson;
import org.jeecgframework.core.common.model.json.DataGrid;
import org.jeecgframework.core.constant.Globals;
import org.jeecgframework.core.util.StringUtil;
import org.jeecgframework.tag.core.easyui.TagUtil;
import org.jeecgframework.web.system.pojo.base.TSDepart;
import org.jeecgframework.web.system.service.SystemService;
import org.jeecgframework.core.util.MyBeanUtils;

import com.fgoa.entity.enquipment.EnquipmentEntity;
import com.fgoa.service.enquipment.EnquipmentServiceI;

/**   
 * @Title: Controller
 * @Description: 办公设备
 * @author onlineGenerator
 * @date 2014-07-02 14:07:35
 * @version V1.0   
 *
 */
@Controller
@RequestMapping("/enquipmentController")
public class EnquipmentController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(EnquipmentController.class);

	@Autowired
	private EnquipmentServiceI enquipmentService;
	@Autowired
	private SystemService systemService;
	private String message;
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}


	/**
	 * 办公设备列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "enquipment")
	public ModelAndView enquipment(HttpServletRequest request) {
		return new ModelAndView("com/fgoa/enquipment/enquipmentList");
	}

	/**
	 * easyui AJAX请求数据
	 * 
	 * @param request
	 * @param response
	 * @param dataGrid
	 * @param user
	 */

	@RequestMapping(params = "datagrid")
	public void datagrid(EnquipmentEntity enquipment,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(EnquipmentEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, enquipment, request.getParameterMap());
		try{
		//自定义追加查询条件
		}catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
		cq.add();
		this.enquipmentService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}

	/**
	 * 删除办公设备
	 * 
	 * @return
	 */
	@RequestMapping(params = "doDel")
	@ResponseBody
	public AjaxJson doDel(EnquipmentEntity enquipment, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		enquipment = systemService.getEntity(EnquipmentEntity.class, enquipment.getId());
		message = "办公设备删除成功";
		try{
			enquipmentService.delete(enquipment);
			systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "办公设备删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 批量删除办公设备
	 * 
	 * @return
	 */
	 @RequestMapping(params = "doBatchDel")
	@ResponseBody
	public AjaxJson doBatchDel(String ids,HttpServletRequest request){
		AjaxJson j = new AjaxJson();
		message = "办公设备删除成功";
		try{
			for(String id:ids.split(",")){
				EnquipmentEntity enquipment = systemService.getEntity(EnquipmentEntity.class, 
				id
				);
				enquipmentService.delete(enquipment);
				systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
			}
		}catch(Exception e){
			e.printStackTrace();
			message = "办公设备删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加办公设备
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doAdd")
	@ResponseBody
	public AjaxJson doAdd(EnquipmentEntity enquipment, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		message = "办公设备添加成功";
		try{
			enquipmentService.save(enquipment);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "办公设备添加失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 更新办公设备
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doUpdate")
	@ResponseBody
	public AjaxJson doUpdate(EnquipmentEntity enquipment, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		message = "办公设备更新成功";
		EnquipmentEntity t = enquipmentService.get(EnquipmentEntity.class, enquipment.getId());
		try {
			MyBeanUtils.copyBeanNotNull2Bean(enquipment, t);
			enquipmentService.saveOrUpdate(t);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		} catch (Exception e) {
			e.printStackTrace();
			message = "办公设备更新失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	

	/**
	 * 办公设备新增页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goAdd")
	public ModelAndView goAdd(EnquipmentEntity enquipment, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(enquipment.getId())) {
			enquipment = enquipmentService.getEntity(EnquipmentEntity.class, enquipment.getId());
			req.setAttribute("enquipmentPage", enquipment);
		}
		return new ModelAndView("com/fgoa/enquipment/enquipment-add");
	}
	/**
	 * 办公设备编辑页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goUpdate")
	public ModelAndView goUpdate(EnquipmentEntity enquipment, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(enquipment.getId())) {
			enquipment = enquipmentService.getEntity(EnquipmentEntity.class, enquipment.getId());
			req.setAttribute("enquipmentPage", enquipment);
		}
		return new ModelAndView("com/fgoa/enquipment/enquipment-update");
	}
}
