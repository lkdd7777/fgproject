package com.fgoa.controller.conference;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
import org.jeecgframework.core.common.model.json.TreeGrid;
import org.jeecgframework.core.constant.Globals;
import org.jeecgframework.core.util.StringUtil;
import org.jeecgframework.tag.core.easyui.TagUtil;
import org.jeecgframework.tag.vo.datatable.SortDirection;
import org.jeecgframework.tag.vo.easyui.TreeGridModel;
import org.jeecgframework.web.system.pojo.base.TSDepart;
import org.jeecgframework.web.system.pojo.base.TSUser;
import org.jeecgframework.web.system.service.SystemService;
import org.jeecgframework.core.util.MyBeanUtils;

import com.fgoa.entity.announcement.AnnouncementEntity;
import com.fgoa.entity.conference.ConferenceEntity;
import com.fgoa.entity.schedule.ScheduleEntity;
import com.fgoa.service.conference.ConferenceServiceI;

/**
 * @Title: Controller
 * @Description: 会议管理
 * @author onlineGenerator
 * @date 2014-07-28 14:02:32
 * @version V1.0
 * 
 */
@Controller
@RequestMapping("/conferenceController")
public class ConferenceController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger
			.getLogger(ConferenceController.class);

	@Autowired
	private ConferenceServiceI conferenceService;
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
	 * 会议管理列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "conference")
	public ModelAndView conference(HttpServletRequest request) {
		return new ModelAndView("com/fgoa/conference/conferenceList");
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
	public void datagrid(ConferenceEntity conference,
			HttpServletRequest request, HttpServletResponse response,
			DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(ConferenceEntity.class, dataGrid);
		Map<String,Object> orderMap=new HashMap<String,Object>();
		orderMap.put("executetime", SortDirection.desc);
		cq.setOrder(orderMap);
		// 查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq,
				conference, request.getParameterMap());
		try {
			// 自定义追加查询条件
		} catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
		cq.add();
		this.conferenceService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}

	/**
	 * 删除会议管理
	 * 
	 * @return
	 */
	@RequestMapping(params = "doDel")
	@ResponseBody
	public AjaxJson doDel(ConferenceEntity conference,
			HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		conference = systemService.getEntity(ConferenceEntity.class,
				conference.getId());
		message = "会议管理删除成功";
		try {
			conference.setDeparts(null);
			conference.setUsers(null);
			conferenceService.save(conference);
			conferenceService.delete(conference);
			systemService.addLog(message, Globals.Log_Type_DEL,
					Globals.Log_Leavel_INFO);
		} catch (Exception e) {
			e.printStackTrace();
			message = "会议管理删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 批量删除会议管理
	 * 
	 * @return
	 */
	@RequestMapping(params = "doBatchDel")
	@ResponseBody
	public AjaxJson doBatchDel(String ids, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		message = "会议管理删除成功";
		try {
			for (String id : ids.split(",")) {
				ConferenceEntity conference = systemService.getEntity(
						ConferenceEntity.class, id);
				conference.setDeparts(null);
				conference.setUsers(null);
				conferenceService.save(conference);
				conferenceService.delete(conference);
				systemService.addLog(message, Globals.Log_Type_DEL,
						Globals.Log_Leavel_INFO);
			}
		} catch (Exception e) {
			e.printStackTrace();
			message = "会议管理删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 添加会议管理
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doAdd")
	@ResponseBody
	public AjaxJson doAdd(ConferenceEntity conference,
			HttpServletRequest request,String departIds,String masterDepId,String userIds) {
		AjaxJson j = new AjaxJson();
		message = "会议管理添加成功";
		try {
			TSDepart depart=systemService.getEntity(TSDepart.class, masterDepId);
			if(depart==null){
				throw new BusinessException("未找到对应的组织单位");
			}
			//conference.setMasterDepart(depart);
			conferenceService.save(conference);
			saveConferenceDeparts(conference,departIds);
			saveConferenceUser(conference, userIds);
			systemService.addLog(message, Globals.Log_Type_INSERT,
					Globals.Log_Leavel_INFO);
		} catch (Exception e) {
			e.printStackTrace();
			message = "会议管理添加失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 更新会议管理
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doUpdate")
	@ResponseBody
	public AjaxJson doUpdate(ConferenceEntity conference,
			HttpServletRequest request,String departIds,String masterDepId,String userIds) {
		AjaxJson j = new AjaxJson();
		message = "会议管理更新成功";
		ConferenceEntity t = conferenceService.get(ConferenceEntity.class,
				conference.getId());
		try {
			MyBeanUtils.copyBeanNotNull2Bean(conference, t);
			TSDepart depart=systemService.getEntity(TSDepart.class, masterDepId);
			if(depart!=null){
				//t.setMasterDepart(depart);
			}
			conferenceService.saveOrUpdate(t);
			saveConferenceDeparts(t,departIds);
			saveConferenceUser(t,userIds);
			systemService.addLog(message, Globals.Log_Type_UPDATE,
					Globals.Log_Leavel_INFO);
		} catch (Exception e) {
			e.printStackTrace();
			message = "会议管理更新失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	private void saveConferenceDeparts(ConferenceEntity conference, String departIds) {
		String[] departArr = departIds.split(",");
		List<TSDepart> departs = new ArrayList<TSDepart>();
		for (int i = 0; i < departArr.length; i++) {
			TSDepart depart = systemService.getEntity(TSDepart.class,
					departArr[i]);
			departs.add(depart);
		}
		conference.setDeparts(departs);
		conferenceService.saveOrUpdate(conference);
	}
	
	private void saveConferenceUser(ConferenceEntity conference,
			String userIds) {
		String[] userArr=userIds.split(",");
		List<TSUser> users=new ArrayList<TSUser>();
		for(int i=0;i<userArr.length;i++){
			TSUser user = systemService.getEntity(TSUser.class, userArr[i]);
			users.add(user);
		}
		conference.setUsers(users);
		conferenceService.saveOrUpdate(conference);
	} 

	/**
	 * 会议管理新增页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goAdd")
	public ModelAndView goAdd(ConferenceEntity conference,
			HttpServletRequest req) {
		if (StringUtil.isNotEmpty(conference.getId())) {
			conference = conferenceService.getEntity(ConferenceEntity.class,
					conference.getId());
			req.setAttribute("conferencePage", conference);
		}
		return new ModelAndView("com/fgoa/conference/conference-add");
	}

	/**
	 * 会议管理编辑页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goUpdate")
	public ModelAndView goUpdate(ConferenceEntity conference,
			HttpServletRequest req) {
		if (StringUtil.isNotEmpty(conference.getId())) {
			conference = conferenceService.getEntity(ConferenceEntity.class,
					conference.getId());
			req.setAttribute("conferencePage", conference);
		}
		return new ModelAndView("com/fgoa/conference/conference-update");
	}

	/**
	 * 选择参与部门
	 * 
	 * @return
	 */
	@RequestMapping(params = "selectDepart")
	public String showDeparts() {
		return "com/fgoa/conference/selectDepart";
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
