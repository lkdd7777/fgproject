package com.fgoa.controller.examconfig;
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

import com.fgoa.entity.examconfig.ExamConfigEntity;
import com.fgoa.service.examconfig.ExamConfigServiceI;

/**   
 * @Title: Controller
 * @Description: 考试配置
 * @author onlineGenerator
 * @date 2014-10-12 13:52:03
 * @version V1.0   
 *
 */
@Controller
@RequestMapping("/examConfigController")
public class ExamConfigController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(ExamConfigController.class);

	@Autowired
	private ExamConfigServiceI examConfigService;
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
	 * 考试配置列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "examConfig")
	public ModelAndView examConfig(HttpServletRequest request) {
		return new ModelAndView("com/fgoa/examconfig/examConfigList");
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
	public void datagrid(ExamConfigEntity examConfig,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(ExamConfigEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, examConfig, request.getParameterMap());
		try{
		//自定义追加查询条件
		}catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
		cq.add();
		this.examConfigService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}

	/**
	 * 删除考试配置
	 * 
	 * @return
	 */
	@RequestMapping(params = "doDel")
	@ResponseBody
	public AjaxJson doDel(ExamConfigEntity examConfig, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		examConfig = systemService.getEntity(ExamConfigEntity.class, examConfig.getId());
		message = "考试配置删除成功";
		try{
			examConfigService.delete(examConfig);
			systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "考试配置删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 批量删除考试配置
	 * 
	 * @return
	 */
	 @RequestMapping(params = "doBatchDel")
	@ResponseBody
	public AjaxJson doBatchDel(String ids,HttpServletRequest request){
		AjaxJson j = new AjaxJson();
		message = "考试配置删除成功";
		try{
			for(String id:ids.split(",")){
				ExamConfigEntity examConfig = systemService.getEntity(ExamConfigEntity.class, 
				Integer.parseInt(id)
				);
				examConfigService.delete(examConfig);
				systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
			}
		}catch(Exception e){
			e.printStackTrace();
			message = "考试配置删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加考试配置
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doAdd")
	@ResponseBody
	public AjaxJson doAdd(ExamConfigEntity examConfig, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		message = "考试配置添加成功";
		try{
			examConfigService.save(examConfig);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "考试配置添加失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 更新考试配置
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doUpdate")
	@ResponseBody
	public AjaxJson doUpdate(ExamConfigEntity examConfig, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		message = "考试配置更新成功";
		ExamConfigEntity t = examConfigService.get(ExamConfigEntity.class, examConfig.getId());
		try {
			MyBeanUtils.copyBeanNotNull2Bean(examConfig, t);
			examConfigService.saveOrUpdate(t);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		} catch (Exception e) {
			e.printStackTrace();
			message = "考试配置更新失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	

	/**
	 * 考试配置新增页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goAdd")
	public ModelAndView goAdd(ExamConfigEntity examConfig, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(examConfig.getId())) {
			examConfig = examConfigService.getEntity(ExamConfigEntity.class, examConfig.getId());
			req.setAttribute("examConfigPage", examConfig);
		}
		return new ModelAndView("com/fgoa/examconfig/examConfig-add");
	}
	/**
	 * 考试配置编辑页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goUpdate")
	public ModelAndView goUpdate(ExamConfigEntity examConfig, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(examConfig.getId())) {
			examConfig = examConfigService.getEntity(ExamConfigEntity.class, examConfig.getId());
			req.setAttribute("examConfigPage", examConfig);
		}
		return new ModelAndView("com/fgoa/examconfig/examConfig-update");
	}
}
