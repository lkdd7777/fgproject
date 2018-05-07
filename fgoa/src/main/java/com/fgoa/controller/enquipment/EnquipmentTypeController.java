package com.fgoa.controller.enquipment;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.jeecgframework.core.common.controller.BaseController;
import org.jeecgframework.core.common.exception.BusinessException;
import org.jeecgframework.core.common.hibernate.qbc.CriteriaQuery;
import org.jeecgframework.core.common.model.json.AjaxJson;
import org.jeecgframework.core.common.model.json.DataGrid;
import org.jeecgframework.core.constant.Globals;
import org.jeecgframework.core.util.MyBeanUtils;
import org.jeecgframework.core.util.StringUtil;
import org.jeecgframework.tag.core.easyui.TagUtil;
import org.jeecgframework.web.system.service.SystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.fgoa.entity.enquipment.EnquipmentTypeEntity;
import com.fgoa.service.enquipment.EnquipmentTypeServiceI;

/**   
 * @Title: Controller
 * @Description: 设备类型
 * @author onlineGenerator
 * @date 2014-07-02 14:06:40
 * @version V1.0   
 *
 */
@Controller
@RequestMapping("/enquipmentTypeController")
public class EnquipmentTypeController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(EnquipmentTypeController.class);

	@Autowired
	private EnquipmentTypeServiceI enquipmentTypeService;
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
	 * 设备类型列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "enquipmentType")
	public ModelAndView enquipmentType(HttpServletRequest request) {
		return new ModelAndView("com/fgoa/enquipment/enquipmentTypeList");
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
	public void datagrid(EnquipmentTypeEntity enquipmentType,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(EnquipmentTypeEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, enquipmentType, request.getParameterMap());
		try{
		//自定义追加查询条件
		}catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
		cq.add();
		this.enquipmentTypeService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}

	/**
	 * 删除设备类型
	 * 
	 * @return
	 */
	@RequestMapping(params = "doDel")
	@ResponseBody
	public AjaxJson doDel(EnquipmentTypeEntity enquipmentType, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		enquipmentType = systemService.getEntity(EnquipmentTypeEntity.class, enquipmentType.getId());
		message = "设备类型删除成功";
		try{
			enquipmentTypeService.delete(enquipmentType);
			systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "设备类型删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 批量删除设备类型
	 * 
	 * @return
	 */
	 @RequestMapping(params = "doBatchDel")
	@ResponseBody
	public AjaxJson doBatchDel(String ids,HttpServletRequest request){
		AjaxJson j = new AjaxJson();
		message = "设备类型删除成功";
		try{
			for(String id:ids.split(",")){
				EnquipmentTypeEntity enquipmentType = systemService.getEntity(EnquipmentTypeEntity.class, 
				id
				);
				enquipmentTypeService.delete(enquipmentType);
				systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
			}
		}catch(Exception e){
			e.printStackTrace();
			message = "设备类型删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加设备类型
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doAdd")
	@ResponseBody
	public AjaxJson doAdd(EnquipmentTypeEntity enquipmentType, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		message = "设备类型添加成功";
		try{
			enquipmentTypeService.save(enquipmentType);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "设备类型添加失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 更新设备类型
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doUpdate")
	@ResponseBody
	public AjaxJson doUpdate(EnquipmentTypeEntity enquipmentType, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		message = "设备类型更新成功";
		EnquipmentTypeEntity t = enquipmentTypeService.get(EnquipmentTypeEntity.class, enquipmentType.getId());
		try {
			MyBeanUtils.copyBeanNotNull2Bean(enquipmentType, t);
			enquipmentTypeService.saveOrUpdate(t);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		} catch (Exception e) {
			e.printStackTrace();
			message = "设备类型更新失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	

	/**
	 * 设备类型新增页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goAdd")
	public ModelAndView goAdd(EnquipmentTypeEntity enquipmentType, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(enquipmentType.getId())) {
			enquipmentType = enquipmentTypeService.getEntity(EnquipmentTypeEntity.class, enquipmentType.getId());
			req.setAttribute("enquipmentTypePage", enquipmentType);
		}
		return new ModelAndView("com/fgoa/enquipment/enquipmentType-add");
	}
	/**
	 * 设备类型编辑页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goUpdate")
	public ModelAndView goUpdate(EnquipmentTypeEntity enquipmentType, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(enquipmentType.getId())) {
			enquipmentType = enquipmentTypeService.getEntity(EnquipmentTypeEntity.class, enquipmentType.getId());
			req.setAttribute("enquipmentTypePage", enquipmentType);
		}
		return new ModelAndView("com/fgoa/enquipment/enquipmentType-update");
	}
}
