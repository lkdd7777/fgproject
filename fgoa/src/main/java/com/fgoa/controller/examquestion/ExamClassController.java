package com.fgoa.controller.examquestion;
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

import com.fgoa.entity.examquestion.ExamClassEntity;
import com.fgoa.service.examquestion.ExamClassServiceI;

/**   
 * @Title: Controller
 * @Description: 考试科目
 * @author onlineGenerator
 * @date 2014-10-16 16:59:48
 * @version V1.0   
 *
 */
@Controller
@RequestMapping("/examClassController")
public class ExamClassController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(ExamClassController.class);

	@Autowired
	private ExamClassServiceI examClassService;
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
	 * 考试科目列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "examClass")
	public ModelAndView examClass(HttpServletRequest request) {
		return new ModelAndView("com/fgoa/examquestion/examClassList");
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
	public void datagrid(ExamClassEntity examClass,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(ExamClassEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, examClass, request.getParameterMap());
		try{
		//自定义追加查询条件
		}catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
		cq.add();
		this.examClassService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}

	/**
	 * 删除考试科目
	 * 
	 * @return
	 */
	@RequestMapping(params = "doDel")
	@ResponseBody
	public AjaxJson doDel(ExamClassEntity examClass, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		examClass = systemService.getEntity(ExamClassEntity.class, examClass.getId());
		message = "考试科目删除成功";
		try{
			examClassService.delete(examClass);
			systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "考试科目删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 批量删除考试科目
	 * 
	 * @return
	 */
	 @RequestMapping(params = "doBatchDel")
	@ResponseBody
	public AjaxJson doBatchDel(String ids,HttpServletRequest request){
		AjaxJson j = new AjaxJson();
		message = "考试科目删除成功";
		try{
			for(String id:ids.split(",")){
				ExamClassEntity examClass = systemService.getEntity(ExamClassEntity.class, 
				Integer.parseInt(id)
				);
				examClassService.delete(examClass);
				systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
			}
		}catch(Exception e){
			e.printStackTrace();
			message = "考试科目删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加考试科目
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doAdd")
	@ResponseBody
	public AjaxJson doAdd(ExamClassEntity examClass, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		message = "考试科目添加成功";
		try{
			examClassService.save(examClass);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "考试科目添加失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 更新考试科目
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doUpdate")
	@ResponseBody
	public AjaxJson doUpdate(ExamClassEntity examClass, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		message = "考试科目更新成功";
		ExamClassEntity t = examClassService.get(ExamClassEntity.class, examClass.getId());
		try {
			MyBeanUtils.copyBeanNotNull2Bean(examClass, t);
			examClassService.saveOrUpdate(t);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		} catch (Exception e) {
			e.printStackTrace();
			message = "考试科目更新失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	

	/**
	 * 考试科目新增页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goAdd")
	public ModelAndView goAdd(ExamClassEntity examClass, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(examClass.getId())) {
			examClass = examClassService.getEntity(ExamClassEntity.class, examClass.getId());
			req.setAttribute("examClassPage", examClass);
		}
		return new ModelAndView("com/fgoa/examquestion/examClass-add");
	}
	/**
	 * 考试科目编辑页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goUpdate")
	public ModelAndView goUpdate(ExamClassEntity examClass, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(examClass.getId())) {
			examClass = examClassService.getEntity(ExamClassEntity.class, examClass.getId());
			req.setAttribute("examClassPage", examClass);
		}
		return new ModelAndView("com/fgoa/examquestion/examClass-update");
	}
}
