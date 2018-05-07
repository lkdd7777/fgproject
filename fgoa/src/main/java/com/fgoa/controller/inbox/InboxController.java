package com.fgoa.controller.inbox;
import java.util.List;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
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
import org.jeecgframework.core.util.BrowserUtils;
import org.jeecgframework.core.util.StringUtil;
import org.jeecgframework.poi.excel.ExcelExportUtil;
import org.jeecgframework.poi.excel.entity.ExcelTitle;
import org.jeecgframework.tag.core.easyui.TagUtil;
import org.jeecgframework.web.system.pojo.base.TSDepart;
import org.jeecgframework.web.system.service.SystemService;
import org.jeecgframework.core.util.MyBeanUtils;

import com.fgoa.entity.inbox.InboxEntity;
import com.fgoa.service.inbox.InboxServiceI;

/**   
 * @Title: Controller
 * @Description: 收文信息表
 * @author onlineGenerator
 * @date 2014-09-14 20:41:35
 * @version V1.0   
 *
 */
@Controller
@RequestMapping("/inboxController")
public class InboxController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(InboxController.class);

	@Autowired
	private InboxServiceI inboxService;
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
	 * 收文信息表列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "inbox")
	public ModelAndView inbox(HttpServletRequest request) {
		return new ModelAndView("com/fgoa/inbox/inboxList");
	}

	/**
	 * 导出excel
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXls")
	public void exportXls(InboxEntity course,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid) {
		response.setContentType("application/vnd.ms-excel");
		String codedFileName = null;
		OutputStream fOut = null;
		try {
			codedFileName = "收文台帐";
			// 根据浏览器进行转码，使其支持中文文件名
			if (BrowserUtils.isIE(request)) {
				response.setHeader(
						"content-disposition",
						"attachment;filename="
								+ java.net.URLEncoder.encode(codedFileName,
										"UTF-8") + ".xls");
			} else {
				String newtitle = new String(codedFileName.getBytes("UTF-8"),
						"ISO8859-1");
				response.setHeader("content-disposition",
						"attachment;filename=" + newtitle + ".xls");
			}
			// 产生工作簿对象
			HSSFWorkbook workbook = null;
			CriteriaQuery cq = new CriteriaQuery(InboxEntity.class, dataGrid);
			org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, course, request.getParameterMap());
			
			List<InboxEntity> courses = this.inboxService.getListByCriteriaQuery(cq,false);
			workbook = ExcelExportUtil.exportExcel(new ExcelTitle("收文台帐", "",
					"收文台帐"), InboxEntity.class, courses);
			fOut = response.getOutputStream();
			workbook.write(fOut);
		} catch (Exception e) {
		} finally {
			try {
				fOut.flush();
				fOut.close();
			} catch (IOException e) {

			}
		}
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
	public void datagrid(InboxEntity inbox,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(InboxEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, inbox, request.getParameterMap());
		try{
		//自定义追加查询条件
		String query_submitdate_begin = request.getParameter("submitdate_begin");
		String query_submitdate_end = request.getParameter("submitdate_end");
		if(StringUtil.isNotEmpty(query_submitdate_begin)){
			cq.ge("submitdate", new SimpleDateFormat("yyyy-MM-dd").parse(query_submitdate_begin));
		}
		if(StringUtil.isNotEmpty(query_submitdate_end)){
			cq.le("submitdate", new SimpleDateFormat("yyyy-MM-dd").parse(query_submitdate_end));
		}
		}catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
		cq.add();
		this.inboxService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}

	/**
	 * 删除收文信息表
	 * 
	 * @return
	 */
	@RequestMapping(params = "doDel")
	@ResponseBody
	public AjaxJson doDel(InboxEntity inbox, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		inbox = systemService.getEntity(InboxEntity.class, inbox.getId());
		message = "收文信息表删除成功";
		try{
			inboxService.delete(inbox);
			systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "收文信息表删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 批量删除收文信息表
	 * 
	 * @return
	 */
	 @RequestMapping(params = "doBatchDel")
	@ResponseBody
	public AjaxJson doBatchDel(String ids,HttpServletRequest request){
		AjaxJson j = new AjaxJson();
		message = "收文信息表删除成功";
		try{
			for(String id:ids.split(",")){
				InboxEntity inbox = systemService.getEntity(InboxEntity.class, 
				id
				);
				inboxService.delete(inbox);
				systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
			}
		}catch(Exception e){
			e.printStackTrace();
			message = "收文信息表删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加收文信息表
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doAdd")
	@ResponseBody
	public AjaxJson doAdd(InboxEntity inbox, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		message = "收文信息表添加成功";
		try{
			inboxService.save(inbox);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "收文信息表添加失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 更新收文信息表
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doUpdate")
	@ResponseBody
	public AjaxJson doUpdate(InboxEntity inbox, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		message = "收文信息表更新成功";
		InboxEntity t = inboxService.get(InboxEntity.class, inbox.getId());
		try {
			MyBeanUtils.copyBeanNotNull2Bean(inbox, t);
			inboxService.saveOrUpdate(t);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		} catch (Exception e) {
			e.printStackTrace();
			message = "收文信息表更新失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	

	/**
	 * 收文信息表新增页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goAdd")
	public ModelAndView goAdd(InboxEntity inbox, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(inbox.getId())) {
			inbox = inboxService.getEntity(InboxEntity.class, inbox.getId());
			req.setAttribute("inboxPage", inbox);
		}
		return new ModelAndView("com/fgoa/inbox/inbox-add");
	}
	/**
	 * 收文信息表编辑页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goUpdate")
	public ModelAndView goUpdate(InboxEntity inbox, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(inbox.getId())) {
			inbox = inboxService.getEntity(InboxEntity.class, inbox.getId());
			req.setAttribute("inboxPage", inbox);
		}
		return new ModelAndView("com/fgoa/inbox/inbox-update");
	}
}
