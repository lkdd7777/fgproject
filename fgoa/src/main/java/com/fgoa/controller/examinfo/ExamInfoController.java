package com.fgoa.controller.examinfo;
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

import com.fgoa.entity.examinfo.ExamInfoEntity;
import com.fgoa.service.examinfo.ExamInfoServiceI;

/**   
 * @Title: Controller
 * @Description: 考试信息表
 * @author onlineGenerator
 * @date 2014-10-11 16:14:38
 * @version V1.0   
 *
 */
@Controller
@RequestMapping("/examInfoController")
public class ExamInfoController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(ExamInfoController.class);

	@Autowired
	private ExamInfoServiceI examInfoService;
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
	 * 考试信息表列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "examInfo")
	public ModelAndView examInfo(HttpServletRequest request) {
		return new ModelAndView("com/fgoa/examinfo/examInfoList");
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
	public void datagrid(ExamInfoEntity examInfo,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(ExamInfoEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, examInfo, request.getParameterMap());
		try{
		//自定义追加查询条件
		}catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
		cq.add();
		this.examInfoService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}

	/**
	 * 删除考试信息表
	 * 
	 * @return
	 */
	@RequestMapping(params = "doDel")
	@ResponseBody
	public AjaxJson doDel(ExamInfoEntity examInfo, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		examInfo = systemService.getEntity(ExamInfoEntity.class, examInfo.getId());
		message = "考试信息表删除成功";
		try{
			examInfoService.delete(examInfo);
			systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "考试信息表删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 批量删除考试信息表
	 * 
	 * @return
	 */
	 @RequestMapping(params = "doBatchDel")
	@ResponseBody
	public AjaxJson doBatchDel(String ids,HttpServletRequest request){
		AjaxJson j = new AjaxJson();
		message = "考试信息表删除成功";
		try{
			for(String id:ids.split(",")){
				ExamInfoEntity examInfo = systemService.getEntity(ExamInfoEntity.class, 
				Integer.parseInt(id)
				);
				examInfoService.delete(examInfo);
				systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
			}
		}catch(Exception e){
			e.printStackTrace();
			message = "考试信息表删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加考试信息表
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doAdd")
	@ResponseBody
	public AjaxJson doAdd(ExamInfoEntity examInfo, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		message = "考试信息表添加成功";
		try{
			examInfoService.save(examInfo);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "考试信息表添加失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 更新考试信息表
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doUpdate")
	@ResponseBody
	public AjaxJson doUpdate(ExamInfoEntity examInfo, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		message = "考试信息表更新成功";
		ExamInfoEntity t = examInfoService.get(ExamInfoEntity.class, examInfo.getId());
		try {
			MyBeanUtils.copyBeanNotNull2Bean(examInfo, t);
			examInfoService.saveOrUpdate(t);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		} catch (Exception e) {
			e.printStackTrace();
			message = "考试信息表更新失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	

	/**
	 * 考试信息表新增页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goAdd")
	public ModelAndView goAdd(ExamInfoEntity examInfo, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(examInfo.getId())) {
			examInfo = examInfoService.getEntity(ExamInfoEntity.class, examInfo.getId());
			req.setAttribute("examInfoPage", examInfo);
		}
		return new ModelAndView("com/fgoa/examinfo/examInfo-add");
	}
	/**
	 * 考试信息表编辑页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goUpdate")
	public ModelAndView goUpdate(ExamInfoEntity examInfo, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(examInfo.getId())) {
			examInfo = examInfoService.getEntity(ExamInfoEntity.class, examInfo.getId());
			req.setAttribute("examInfoPage", examInfo);
		}
		return new ModelAndView("com/fgoa/examinfo/examInfo-update");
	}
}
