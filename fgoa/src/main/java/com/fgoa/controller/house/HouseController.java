package com.fgoa.controller.house;
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

import com.fgoa.entity.house.HouseEntity;
import com.fgoa.service.house.HouseServiceI;

/**   
 * @Title: Controller
 * @Description: 房屋资产
 * @author onlineGenerator
 * @date 2015-05-21 00:35:07
 * @version V1.0   
 *
 */
@Controller
@RequestMapping("/houseController")
public class HouseController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(HouseController.class);

	@Autowired
	private HouseServiceI houseService;
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
	 * 房屋资产列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "house")
	public ModelAndView house(HttpServletRequest request) {
		return new ModelAndView("com/fgoa/house/houseList");
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
	public void datagrid(HouseEntity house,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(HouseEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, house, request.getParameterMap());
		try{
		//自定义追加查询条件
		}catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
		cq.add();
		this.houseService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}

	/**
	 * 删除房屋资产
	 * 
	 * @return
	 */
	@RequestMapping(params = "doDel")
	@ResponseBody
	public AjaxJson doDel(HouseEntity house, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		house = systemService.getEntity(HouseEntity.class, house.getId());
		message = "房屋资产删除成功";
		try{
			houseService.delete(house);
			systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "房屋资产删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 批量删除房屋资产
	 * 
	 * @return
	 */
	 @RequestMapping(params = "doBatchDel")
	@ResponseBody
	public AjaxJson doBatchDel(String ids,HttpServletRequest request){
		AjaxJson j = new AjaxJson();
		message = "房屋资产删除成功";
		try{
			for(String id:ids.split(",")){
				HouseEntity house = systemService.getEntity(HouseEntity.class, 
				Integer.parseInt(id)
				);
				houseService.delete(house);
				systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
			}
		}catch(Exception e){
			e.printStackTrace();
			message = "房屋资产删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加房屋资产
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doAdd")
	@ResponseBody
	public AjaxJson doAdd(HouseEntity house, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		message = "房屋资产添加成功";
		try{
			houseService.save(house);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "房屋资产添加失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 更新房屋资产
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doUpdate")
	@ResponseBody
	public AjaxJson doUpdate(HouseEntity house, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		message = "房屋资产更新成功";
		HouseEntity t = houseService.get(HouseEntity.class, house.getId());
		try {
			MyBeanUtils.copyBeanNotNull2Bean(house, t);
			houseService.saveOrUpdate(t);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		} catch (Exception e) {
			e.printStackTrace();
			message = "房屋资产更新失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	

	/**
	 * 房屋资产新增页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goAdd")
	public ModelAndView goAdd(HouseEntity house, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(house.getId())) {
			house = houseService.getEntity(HouseEntity.class, house.getId());
			req.setAttribute("housePage", house);
		}
		return new ModelAndView("com/fgoa/house/house-add");
	}
	/**
	 * 房屋资产编辑页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goUpdate")
	public ModelAndView goUpdate(HouseEntity house, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(house.getId())) {
			house = houseService.getEntity(HouseEntity.class, house.getId());
			req.setAttribute("housePage", house);
		}
		return new ModelAndView("com/fgoa/house/house-update");
	}
}
