package com.fgoa.controller.officesupply;
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
import org.jeecgframework.web.demo.entity.test.CourseEntity;
import org.jeecgframework.web.system.pojo.base.TSDepart;
import org.jeecgframework.web.system.service.SystemService;
import org.jeecgframework.core.util.MyBeanUtils;

import com.fgoa.entity.officesupply.OfficeSupplyEntity;
import com.fgoa.service.officesupply.OfficeSupplyServiceI;

/**   
 * @Title: Controller
 * @Description: 办公用品管理
 * @author onlineGenerator
 * @date 2014-09-14 12:42:49
 * @version V1.0   
 *officeSupplyController
 */
@Controller
@RequestMapping("/officeSupplyController")
public class OfficeSupplyController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(OfficeSupplyController.class);

	@Autowired
	private OfficeSupplyServiceI officeSupplyService;
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
	 * 办公用品管理列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "officeSupply")
	public ModelAndView officeSupply(HttpServletRequest request) {
		return new ModelAndView("com/fgoa/officesupply/officeSupplyList");
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
	public void datagrid(OfficeSupplyEntity officeSupply,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(OfficeSupplyEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, officeSupply, request.getParameterMap());
		try{
		//自定义追加查询条件
		String query_purchasedate_begin = request.getParameter("purchasedate_begin");
		String query_purchasedate_end = request.getParameter("purchasedate_end");
		if(StringUtil.isNotEmpty(query_purchasedate_begin)){
			cq.ge("purchasedate", new SimpleDateFormat("yyyy-MM-dd").parse(query_purchasedate_begin));
		}
		if(StringUtil.isNotEmpty(query_purchasedate_end)){
			cq.le("purchasedate", new SimpleDateFormat("yyyy-MM-dd").parse(query_purchasedate_end));
		}
		}catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
		cq.add();
		this.officeSupplyService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}
	
	/**
	 * 导出excel
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXls")
	public void exportXls(OfficeSupplyEntity course,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid) {
		response.setContentType("application/vnd.ms-excel");
		String codedFileName = null;
		OutputStream fOut = null;
		try {
			codedFileName = "办公用品清单";
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
			CriteriaQuery cq = new CriteriaQuery(OfficeSupplyEntity.class, dataGrid);
			org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, course, request.getParameterMap());
			
			List<OfficeSupplyEntity> courses = this.officeSupplyService.getListByCriteriaQuery(cq,false);
			workbook = ExcelExportUtil.exportExcel(new ExcelTitle("设备采购清单", "",
					"设备采购单"), OfficeSupplyEntity.class, courses);
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
	 * 删除办公用品管理
	 * 
	 * @return
	 */
	@RequestMapping(params = "doDel")
	@ResponseBody
	public AjaxJson doDel(OfficeSupplyEntity officeSupply, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		officeSupply = systemService.getEntity(OfficeSupplyEntity.class, officeSupply.getId());
		message = "办公用品管理删除成功";
		try{
			officeSupplyService.delete(officeSupply);
			systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "办公用品管理删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 批量删除办公用品管理
	 * 
	 * @return
	 */
	 @RequestMapping(params = "doBatchDel")
	@ResponseBody
	public AjaxJson doBatchDel(String ids,HttpServletRequest request){
		AjaxJson j = new AjaxJson();
		message = "办公用品管理删除成功";
		try{
			for(String id:ids.split(",")){
				OfficeSupplyEntity officeSupply = systemService.getEntity(OfficeSupplyEntity.class, 
				id
				);
				officeSupplyService.delete(officeSupply);
				systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
			}
		}catch(Exception e){
			e.printStackTrace();
			message = "办公用品管理删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加办公用品管理
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doAdd")
	@ResponseBody
	public AjaxJson doAdd(OfficeSupplyEntity officeSupply, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		message = "办公用品管理添加成功";
		try{
			officeSupplyService.save(officeSupply);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "办公用品管理添加失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 更新办公用品管理
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doUpdate")
	@ResponseBody
	public AjaxJson doUpdate(OfficeSupplyEntity officeSupply, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		message = "办公用品管理更新成功";
		OfficeSupplyEntity t = officeSupplyService.get(OfficeSupplyEntity.class, officeSupply.getId());
		try {
			MyBeanUtils.copyBeanNotNull2Bean(officeSupply, t);
			officeSupplyService.saveOrUpdate(t);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		} catch (Exception e) {
			e.printStackTrace();
			message = "办公用品管理更新失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	

	/**
	 * 办公用品管理新增页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goAdd")
	public ModelAndView goAdd(OfficeSupplyEntity officeSupply, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(officeSupply.getId())) {
			officeSupply = officeSupplyService.getEntity(OfficeSupplyEntity.class, officeSupply.getId());
			req.setAttribute("officeSupplyPage", officeSupply);
		}
		return new ModelAndView("com/fgoa/officesupply/officeSupply-add");
	}
	/**
	 * 办公用品管理编辑页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goUpdate")
	public ModelAndView goUpdate(OfficeSupplyEntity officeSupply, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(officeSupply.getId())) {
			officeSupply = officeSupplyService.getEntity(OfficeSupplyEntity.class, officeSupply.getId());
			req.setAttribute("officeSupplyPage", officeSupply);
		}
		return new ModelAndView("com/fgoa/officesupply/officeSupply-update");
	}
}
