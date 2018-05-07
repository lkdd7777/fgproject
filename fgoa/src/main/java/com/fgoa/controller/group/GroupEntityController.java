package com.fgoa.controller.group;
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

import com.fgoa.entity.group.GroupEntityEntity;
import com.fgoa.service.group.GroupEntityServiceI;

/**   
 * @Title: Controller
 * @Description: 团体
 * @author onlineGenerator
 * @date 2015-05-20 23:42:11
 * @version V1.0   
 *
 */
@Controller
@RequestMapping("/groupEntityController")
public class GroupEntityController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(GroupEntityController.class);

	@Autowired
	private GroupEntityServiceI groupEntityService;
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
	 * 团体列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "groupEntity")
	public ModelAndView groupEntity(HttpServletRequest request) {
		return new ModelAndView("com/fgoa/group/groupEntityList");
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
	public void datagrid(GroupEntityEntity groupEntity,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(GroupEntityEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, groupEntity, request.getParameterMap());
		try{
		//自定义追加查询条件
		}catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
		cq.add();
		this.groupEntityService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}

	/**
	 * 删除团体
	 * 
	 * @return
	 */
	@RequestMapping(params = "doDel")
	@ResponseBody
	public AjaxJson doDel(GroupEntityEntity groupEntity, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		groupEntity = systemService.getEntity(GroupEntityEntity.class, groupEntity.getId());
		message = "团体删除成功";
		try{
			groupEntityService.delete(groupEntity);
			systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "团体删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 批量删除团体
	 * 
	 * @return
	 */
	 @RequestMapping(params = "doBatchDel")
	@ResponseBody
	public AjaxJson doBatchDel(String ids,HttpServletRequest request){
		AjaxJson j = new AjaxJson();
		message = "团体删除成功";
		try{
			for(String id:ids.split(",")){
				GroupEntityEntity groupEntity = systemService.getEntity(GroupEntityEntity.class, 
				id
				);
				groupEntityService.delete(groupEntity);
				systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
			}
		}catch(Exception e){
			e.printStackTrace();
			message = "团体删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加团体
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doAdd")
	@ResponseBody
	public AjaxJson doAdd(GroupEntityEntity groupEntity, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		message = "团体添加成功";
		try{
			groupEntityService.save(groupEntity);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "团体添加失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 更新团体
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doUpdate")
	@ResponseBody
	public AjaxJson doUpdate(GroupEntityEntity groupEntity, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		message = "团体更新成功";
		GroupEntityEntity t = groupEntityService.get(GroupEntityEntity.class, groupEntity.getId());
		try {
			MyBeanUtils.copyBeanNotNull2Bean(groupEntity, t);
			groupEntityService.saveOrUpdate(t);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		} catch (Exception e) {
			e.printStackTrace();
			message = "团体更新失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	

	/**
	 * 团体新增页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goAdd")
	public ModelAndView goAdd(GroupEntityEntity groupEntity, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(groupEntity.getId())) {
			groupEntity = groupEntityService.getEntity(GroupEntityEntity.class, groupEntity.getId());
			req.setAttribute("groupEntityPage", groupEntity);
		}
		return new ModelAndView("com/fgoa/group/groupEntity-add");
	}
	/**
	 * 团体编辑页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goUpdate")
	public ModelAndView goUpdate(GroupEntityEntity groupEntity, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(groupEntity.getId())) {
			groupEntity = groupEntityService.getEntity(GroupEntityEntity.class, groupEntity.getId());
			req.setAttribute("groupEntityPage", groupEntity);
		}
		return new ModelAndView("com/fgoa/group/groupEntity-update");
	}
}
