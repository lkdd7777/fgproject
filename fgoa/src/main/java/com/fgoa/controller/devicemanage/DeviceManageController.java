package com.fgoa.controller.devicemanage;
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

import com.fgoa.entity.devicemanage.DeviceManageEntity;
import com.fgoa.service.devicemanage.DeviceManageServiceI;

/**   
 * @Title: Controller
 * @Description: 设备管理
 * @author onlineGenerator
 * @date 2014-09-14 18:05:03
 * @version V1.0   
 *
 */
@Controller
@RequestMapping("/deviceManageController")
public class DeviceManageController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(DeviceManageController.class);

	@Autowired
	private DeviceManageServiceI deviceManageService;
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
	 * 设备管理列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "deviceManage")
	public ModelAndView deviceManage(HttpServletRequest request) {
		return new ModelAndView("com/fgoa/devicemanage/deviceManageList");
	}

	/**
	 * 导出excel
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXls")
	public void exportXls(DeviceManageEntity course,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid) {
		response.setContentType("application/vnd.ms-excel");
		String codedFileName = null;
		OutputStream fOut = null;
		try {
			codedFileName = "计算机及外围设备盘整清册";
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
			CriteriaQuery cq = new CriteriaQuery(DeviceManageEntity.class, dataGrid);
			org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, course, request.getParameterMap());
			
			List<DeviceManageEntity> courses = this.deviceManageService.getListByCriteriaQuery(cq,false);
			workbook = ExcelExportUtil.exportExcel(new ExcelTitle("计算机及外围设备盘整清册", "",
					"计算机及外围设备盘整清册"), DeviceManageEntity.class, courses);
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
	public void datagrid(DeviceManageEntity deviceManage,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(DeviceManageEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, deviceManage, request.getParameterMap());
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
		this.deviceManageService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}

	/**
	 * 删除设备管理
	 * 
	 * @return
	 */
	@RequestMapping(params = "doDel")
	@ResponseBody
	public AjaxJson doDel(DeviceManageEntity deviceManage, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		deviceManage = systemService.getEntity(DeviceManageEntity.class, deviceManage.getId());
		message = "设备管理删除成功";
		try{
			deviceManageService.delete(deviceManage);
			systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "设备管理删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 批量删除设备管理
	 * 
	 * @return
	 */
	 @RequestMapping(params = "doBatchDel")
	@ResponseBody
	public AjaxJson doBatchDel(String ids,HttpServletRequest request){
		AjaxJson j = new AjaxJson();
		message = "设备管理删除成功";
		try{
			for(String id:ids.split(",")){
				DeviceManageEntity deviceManage = systemService.getEntity(DeviceManageEntity.class, 
				id
				);
				deviceManageService.delete(deviceManage);
				systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
			}
		}catch(Exception e){
			e.printStackTrace();
			message = "设备管理删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加设备管理
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doAdd")
	@ResponseBody
	public AjaxJson doAdd(DeviceManageEntity deviceManage, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		message = "设备管理添加成功";
		try{
			deviceManageService.save(deviceManage);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "设备管理添加失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 更新设备管理
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doUpdate")
	@ResponseBody
	public AjaxJson doUpdate(DeviceManageEntity deviceManage, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		message = "设备管理更新成功";
		DeviceManageEntity t = deviceManageService.get(DeviceManageEntity.class, deviceManage.getId());
		try {
			MyBeanUtils.copyBeanNotNull2Bean(deviceManage, t);
			deviceManageService.saveOrUpdate(t);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		} catch (Exception e) {
			e.printStackTrace();
			message = "设备管理更新失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	

	/**
	 * 设备管理新增页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goAdd")
	public ModelAndView goAdd(DeviceManageEntity deviceManage, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(deviceManage.getId())) {
			deviceManage = deviceManageService.getEntity(DeviceManageEntity.class, deviceManage.getId());
			req.setAttribute("deviceManagePage", deviceManage);
		}
		return new ModelAndView("com/fgoa/devicemanage/deviceManage-add");
	}
	/**
	 * 设备管理编辑页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goUpdate")
	public ModelAndView goUpdate(DeviceManageEntity deviceManage, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(deviceManage.getId())) {
			deviceManage = deviceManageService.getEntity(DeviceManageEntity.class, deviceManage.getId());
			req.setAttribute("deviceManagePage", deviceManage);
		}
		return new ModelAndView("com/fgoa/devicemanage/deviceManage-update");
	}
}
