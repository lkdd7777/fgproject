package com.fgoa.controller.schedule;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.jeecgframework.core.common.controller.BaseController;
import org.jeecgframework.core.common.exception.BusinessException;
import org.jeecgframework.core.common.hibernate.qbc.CriteriaQuery;
import org.jeecgframework.core.common.model.json.AjaxJson;
import org.jeecgframework.core.common.model.json.DataGrid;
import org.jeecgframework.core.common.model.json.TreeGrid;
import org.jeecgframework.core.constant.Globals;
import org.jeecgframework.core.util.MyBeanUtils;
import org.jeecgframework.core.util.StringUtil;
import org.jeecgframework.tag.core.easyui.TagUtil;
import org.jeecgframework.tag.vo.datatable.SortDirection;
import org.jeecgframework.tag.vo.easyui.TreeGridModel;
import org.jeecgframework.web.system.pojo.base.TSDepart;
import org.jeecgframework.web.system.pojo.base.TSUser;
import org.jeecgframework.web.system.service.SystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.fgoa.entity.conference.ConferenceEntity;
import com.fgoa.entity.schedule.ScheduleEntity;
import com.fgoa.service.schedule.ScheduleServiceI;

/**
 * @Title: Controller
 * @Description: 日程安排
 * @author onlineGenerator
 * @date 2014-07-27 23:52:28
 * @version V1.0
 * 
 */
@Controller
@RequestMapping("/scheduleController")
public class ScheduleController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger
			.getLogger(ScheduleController.class);

	@Autowired
	private ScheduleServiceI scheduleService;
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
	 * 日程安排列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "schedule")
	public ModelAndView schedule(HttpServletRequest request) {
		return new ModelAndView("com/fgoa/schedule/scheduleList");
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
	public void datagrid(ScheduleEntity schedule, HttpServletRequest request,
			HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(ScheduleEntity.class, dataGrid);
		Map<String,Object> orderMap=new HashMap<String,Object>();
		orderMap.put("executetime", SortDirection.desc);
		cq.setOrder(orderMap);
		// 查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq,
				schedule, request.getParameterMap());
		try {
			// 自定义追加查询条件
		} catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
		cq.add();
		this.scheduleService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}

	/**
	 * 删除日程安排
	 * 
	 * @return
	 */
	@RequestMapping(params = "doDel")
	@ResponseBody
	public AjaxJson doDel(ScheduleEntity schedule, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		schedule = systemService.getEntity(ScheduleEntity.class,
				schedule.getId());
		message = "日程安排删除成功";
		try {
			schedule.setDeparts(null);
			schedule.setUsers(null);
			scheduleService.save(schedule);
			scheduleService.delete(schedule);
			systemService.addLog(message, Globals.Log_Type_DEL,
					Globals.Log_Leavel_INFO);
		} catch (Exception e) {
			e.printStackTrace();
			message = "日程安排删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 批量删除日程安排
	 * 
	 * @return
	 */
	@RequestMapping(params = "doBatchDel")
	@ResponseBody
	public AjaxJson doBatchDel(String ids, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		message = "日程安排删除成功";
		try {
			for (String id : ids.split(",")) {
				ScheduleEntity schedule = systemService.getEntity(
						ScheduleEntity.class, id);
				schedule.setDeparts(null);
				schedule.setUsers(null);
				scheduleService.save(schedule);
				scheduleService.delete(schedule);
				systemService.addLog(message, Globals.Log_Type_DEL,
						Globals.Log_Leavel_INFO);
			}
		} catch (Exception e) {
			e.printStackTrace();
			message = "日程安排删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 添加日程安排
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doAdd")
	@ResponseBody
	public AjaxJson doAdd(ScheduleEntity schedule, HttpServletRequest request,
			String departIds,String masterDepId,String userIds) {
		AjaxJson j = new AjaxJson();
		message = "日程安排添加成功";
		try {
			TSDepart depart=systemService.getEntity(TSDepart.class, masterDepId);
			if(depart==null){
				throw new BusinessException("未找到对应的组织单位");
			}
			//schedule.setMasterDepart(depart);
			scheduleService.save(schedule);
			saveScheduleDeparts(schedule, departIds);
			saveScheduleUser(schedule, userIds);
			systemService.addLog(message, Globals.Log_Type_INSERT,
					Globals.Log_Leavel_INFO);
		} catch (Exception e) {
			e.printStackTrace();
			message = "日程安排添加失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 更新日程安排
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doUpdate")
	@ResponseBody
	public AjaxJson doUpdate(ScheduleEntity schedule,
			HttpServletRequest request, String departIds,String masterDepId,String userIds) {
		AjaxJson j = new AjaxJson();
		message = "日程安排更新成功";
		ScheduleEntity t = scheduleService.get(ScheduleEntity.class,
				schedule.getId());
		try {
			MyBeanUtils.copyBeanNotNull2Bean(schedule, t);
			TSDepart depart=systemService.getEntity(TSDepart.class, masterDepId);
			if(depart!=null){
				//t.setMasterDepart(depart);
			}
			scheduleService.saveOrUpdate(t);
			saveScheduleDeparts(t, departIds);
			saveScheduleUser(t, userIds);
			systemService.addLog(message, Globals.Log_Type_UPDATE,
					Globals.Log_Leavel_INFO);
		} catch (Exception e) {
			e.printStackTrace();
			message = "日程安排更新失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}

	private void saveScheduleDeparts(ScheduleEntity schedule, String departIds) {
		String[] departArr = departIds.split(",");
		List<TSDepart> departs = new ArrayList<TSDepart>();
		for (int i = 0; i < departArr.length; i++) {
			TSDepart depart = systemService.getEntity(TSDepart.class,
					departArr[i]);
			departs.add(depart);
		}
		schedule.setDeparts(departs);
		scheduleService.saveOrUpdate(schedule);
	}
	
	private void saveScheduleUser(ScheduleEntity schedule,
			String userIds) {
		String[] userArr=userIds.split(",");
		List<TSUser> users=new ArrayList<TSUser>();
		for(int i=0;i<userArr.length;i++){
			TSUser user = systemService.getEntity(TSUser.class, userArr[i]);
			users.add(user);
		}
		schedule.setUsers(users);
		scheduleService.saveOrUpdate(schedule);
	} 

	/**
	 * 日程安排新增页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goAdd")
	public ModelAndView goAdd(ScheduleEntity schedule, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(schedule.getId())) {
			schedule = scheduleService.getEntity(ScheduleEntity.class,
					schedule.getId());
			req.setAttribute("schedulePage", schedule);
		}
		return new ModelAndView("com/fgoa/schedule/schedule-add");
	}

	/**
	 * 日程安排编辑页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goUpdate")
	public ModelAndView goUpdate(ScheduleEntity schedule, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(schedule.getId())) {
			schedule = scheduleService.getEntity(ScheduleEntity.class,
					schedule.getId());
			req.setAttribute("schedulePage", schedule);
		}
		return new ModelAndView("com/fgoa/schedule/schedule-update");
	}

	/**
	 * 选择参与部门
	 * 
	 * @return
	 */
	@RequestMapping(params = "selectDepart")
	public ModelAndView showDeparts(ModelAndView model) {
		model.addObject("multiSelect", "true");
		model.setViewName("com/fgoa/schedule/selectDepart");
		return model;
	}

	/**
	 * 部门数据
	 * 
	 * @param tSDepart
	 * @param treegrid
	 * @return
	 */
	@RequestMapping(params = "departTreeGrid")
	@ResponseBody
	public List<TreeGrid> departTree(TSDepart tSDepart, TreeGrid treegrid) {
		CriteriaQuery cq = new CriteriaQuery(TSDepart.class);

		if (null != tSDepart.getDepartname()) {
			org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil
					.installHql(cq, tSDepart);
		}
		if (treegrid.getId() != null) {
			cq.eq("TSPDepart.id", treegrid.getId());
		}
		if (treegrid.getId() == null) {
			cq.isNull("TSPDepart");
		}
		cq.add();
		List<TreeGrid> departList = null;
		departList = systemService.getListByCriteriaQuery(cq, false);

		List<TreeGrid> treeGrids = new ArrayList<TreeGrid>();
		TreeGridModel treeGridModel = new TreeGridModel();
		treeGridModel.setTextField("departname");
		treeGridModel.setParentText("TSPDepart_departname");
		treeGridModel.setParentId("TSPDepart_id");
		treeGridModel.setSrc("description");
		treeGridModel.setIdField("id");
		treeGridModel.setChildList("TSDeparts");
		treeGrids = systemService.treegrid(departList, treeGridModel);

		return treeGrids;
	}
}
