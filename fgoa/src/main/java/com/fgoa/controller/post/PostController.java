package com.fgoa.controller.post;
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

import com.fgoa.entity.post.PostEntity;
import com.fgoa.service.post.PostServiceI;

/**   
 * @Title: Controller
 * @Description: 发文信息表
 * @author onlineGenerator
 * @date 2014-09-14 21:04:34
 * @version V1.0   
 *
 */
@Controller
@RequestMapping("/postController")
public class PostController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(PostController.class);

	@Autowired
	private PostServiceI postService;
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
	 * 发文信息表列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "post")
	public ModelAndView post(HttpServletRequest request) {
		return new ModelAndView("com/fgoa/post/postList");
	}

	/**
	 * 导出excel
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXls")
	public void exportXls(PostEntity course,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid) {
		response.setContentType("application/vnd.ms-excel");
		String codedFileName = null;
		OutputStream fOut = null;
		try {
			codedFileName = "发文台帐";
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
			CriteriaQuery cq = new CriteriaQuery(PostEntity.class, dataGrid);
			org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, course, request.getParameterMap());
			
			List<PostEntity> courses = this.postService.getListByCriteriaQuery(cq,false);
			workbook = ExcelExportUtil.exportExcel(new ExcelTitle("发文台帐", "",
					"发文台帐"), PostEntity.class, courses);
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
	public void datagrid(PostEntity post,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(PostEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, post, request.getParameterMap());
		try{
		//自定义追加查询条件
		String query_submittime_begin = request.getParameter("submittime_begin");
		String query_submittime_end = request.getParameter("submittime_end");
		if(StringUtil.isNotEmpty(query_submittime_begin)){
			cq.ge("submittime", new SimpleDateFormat("yyyy-MM-dd").parse(query_submittime_begin));
		}
		if(StringUtil.isNotEmpty(query_submittime_end)){
			cq.le("submittime", new SimpleDateFormat("yyyy-MM-dd").parse(query_submittime_end));
		}
		}catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
		cq.add();
		this.postService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}

	/**
	 * 删除发文信息表
	 * 
	 * @return
	 */
	@RequestMapping(params = "doDel")
	@ResponseBody
	public AjaxJson doDel(PostEntity post, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		post = systemService.getEntity(PostEntity.class, post.getId());
		message = "发文信息表删除成功";
		try{
			postService.delete(post);
			systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "发文信息表删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 批量删除发文信息表
	 * 
	 * @return
	 */
	 @RequestMapping(params = "doBatchDel")
	@ResponseBody
	public AjaxJson doBatchDel(String ids,HttpServletRequest request){
		AjaxJson j = new AjaxJson();
		message = "发文信息表删除成功";
		try{
			for(String id:ids.split(",")){
				PostEntity post = systemService.getEntity(PostEntity.class, 
				id
				);
				postService.delete(post);
				systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
			}
		}catch(Exception e){
			e.printStackTrace();
			message = "发文信息表删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加发文信息表
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doAdd")
	@ResponseBody
	public AjaxJson doAdd(PostEntity post, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		message = "发文信息表添加成功";
		try{
			postService.save(post);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "发文信息表添加失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 更新发文信息表
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doUpdate")
	@ResponseBody
	public AjaxJson doUpdate(PostEntity post, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		message = "发文信息表更新成功";
		PostEntity t = postService.get(PostEntity.class, post.getId());
		try {
			MyBeanUtils.copyBeanNotNull2Bean(post, t);
			postService.saveOrUpdate(t);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		} catch (Exception e) {
			e.printStackTrace();
			message = "发文信息表更新失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	

	/**
	 * 发文信息表新增页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goAdd")
	public ModelAndView goAdd(PostEntity post, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(post.getId())) {
			post = postService.getEntity(PostEntity.class, post.getId());
			req.setAttribute("postPage", post);
		}
		return new ModelAndView("com/fgoa/post/post-add");
	}
	/**
	 * 发文信息表编辑页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goUpdate")
	public ModelAndView goUpdate(PostEntity post, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(post.getId())) {
			post = postService.getEntity(PostEntity.class, post.getId());
			req.setAttribute("postPage", post);
		}
		return new ModelAndView("com/fgoa/post/post-update");
	}
}
