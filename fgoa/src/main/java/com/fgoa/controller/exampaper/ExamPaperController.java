package com.fgoa.controller.exampaper;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.jeecgframework.core.common.controller.BaseController;
import org.jeecgframework.core.common.exception.BusinessException;
import org.jeecgframework.core.common.hibernate.qbc.CriteriaQuery;
import org.jeecgframework.core.common.model.json.AjaxJson;
import org.jeecgframework.core.common.model.json.DataGrid;
import org.jeecgframework.core.constant.Globals;
import org.jeecgframework.core.util.BrowserUtils;
import org.jeecgframework.core.util.MyBeanUtils;
import org.jeecgframework.core.util.StringUtil;
import org.jeecgframework.poi.excel.ExcelExportUtil;
import org.jeecgframework.poi.excel.entity.ExcelTitle;
import org.jeecgframework.tag.core.easyui.TagUtil;
import org.jeecgframework.web.system.service.SystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.fgoa.entity.exampaper.ExamPaperEntity;
import com.fgoa.service.exampaper.ExamPaperServiceI;
import com.fgoa.vo.ExamPaperVo;

/**
 * @Title: Controller
 * @Description: 考卷
 * @author onlineGenerator
 * @date 2014-10-18 16:05:57
 * @version V1.0
 * 
 */
@Controller
@RequestMapping("/examPaperController")
public class ExamPaperController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger
			.getLogger(ExamPaperController.class);

	@Autowired
	private ExamPaperServiceI examPaperService;
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
	 * 考卷列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "examPaper")
	public ModelAndView examPaper(HttpServletRequest request) {
		return new ModelAndView("com/fgoa/exampaper/examPaperList");
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
	public void datagrid(ExamPaperEntity examPaper, HttpServletRequest request,
			HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(ExamPaperEntity.class, dataGrid);
		// 查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq,
				examPaper, request.getParameterMap());
		try {
			// 自定义追加查询条件
		} catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
		cq.add();
		this.examPaperService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}

	/**
	 * 删除考卷
	 * 
	 * @return
	 */
	@RequestMapping(params = "doDel")
	@ResponseBody
	public AjaxJson doDel(ExamPaperEntity examPaper, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		examPaper = systemService.getEntity(ExamPaperEntity.class,
				examPaper.getId());
		message = "考卷删除成功";
		try {
			examPaperService.delete(examPaper);
			systemService.addLog(message, Globals.Log_Type_DEL,
					Globals.Log_Leavel_INFO);
		} catch (Exception e) {
			e.printStackTrace();
			message = "考卷删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 批量删除考卷
	 * 
	 * @return
	 */
	@RequestMapping(params = "doBatchDel")
	@ResponseBody
	public AjaxJson doBatchDel(String ids, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		message = "考卷删除成功";
		try {
			for (String id : ids.split(",")) {
				ExamPaperEntity examPaper = systemService.getEntity(
						ExamPaperEntity.class, Integer.parseInt(id));
				examPaperService.delete(examPaper);
				systemService.addLog(message, Globals.Log_Type_DEL,
						Globals.Log_Leavel_INFO);
			}
		} catch (Exception e) {
			e.printStackTrace();
			message = "考卷删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 添加考卷
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doAdd")
	@ResponseBody
	public AjaxJson doAdd(ExamPaperEntity examPaper, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		message = "考卷添加成功";
		try {
			examPaperService.save(examPaper);
			systemService.addLog(message, Globals.Log_Type_INSERT,
					Globals.Log_Leavel_INFO);
		} catch (Exception e) {
			e.printStackTrace();
			message = "考卷添加失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 更新考卷
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doUpdate")
	@ResponseBody
	public AjaxJson doUpdate(ExamPaperEntity examPaper,
			HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		message = "考卷更新成功";
		ExamPaperEntity t = examPaperService.get(ExamPaperEntity.class,
				examPaper.getId());
		try {
			MyBeanUtils.copyBeanNotNull2Bean(examPaper, t);
			examPaperService.saveOrUpdate(t);
			systemService.addLog(message, Globals.Log_Type_UPDATE,
					Globals.Log_Leavel_INFO);
		} catch (Exception e) {
			e.printStackTrace();
			message = "考卷更新失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 考卷新增页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goAdd")
	public ModelAndView goAdd(ExamPaperEntity examPaper, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(examPaper.getId())) {
			examPaper = examPaperService.getEntity(ExamPaperEntity.class,
					examPaper.getId());
			req.setAttribute("examPaperPage", examPaper);
		}
		return new ModelAndView("com/fgoa/exampaper/examPaper-add");
	}

	/**
	 * 考卷编辑页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goUpdate")
	public ModelAndView goUpdate(ExamPaperEntity examPaper,
			HttpServletRequest req) {
		if (StringUtil.isNotEmpty(examPaper.getId())) {
			examPaper = examPaperService.getEntity(ExamPaperEntity.class,
					examPaper.getId());
			req.setAttribute("examPaperPage", examPaper);
		}
		return new ModelAndView("com/fgoa/exampaper/examPaper-update");
	}

	/**
	 * 导出excel
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXls")
	public void exportXls(ExamPaperEntity course, HttpServletRequest request,
			HttpServletResponse response, DataGrid dataGrid) {
		response.setContentType("application/vnd.ms-excel");
		String codedFileName = null;
		OutputStream fOut = null;
		try {
			codedFileName = "在线考试评分表";
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
			CriteriaQuery cq = new CriteriaQuery(ExamPaperEntity.class,
					dataGrid);
			org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil
					.installHql(cq, course, request.getParameterMap());

			List<ExamPaperEntity> courses = this.examPaperService
					.getListByCriteriaQuery(cq, false);
			workbook = ExcelExportUtil.exportExcel(new ExcelTitle("在线考试评分表",
					"", "在线考试评分表"), ExamPaperVo.class, convertToVo(courses));
			fOut = response.getOutputStream();
			workbook.write(fOut);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				fOut.flush();
				fOut.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	private List<ExamPaperVo> convertToVo(List<ExamPaperEntity> list) {
		List<ExamPaperVo> returnValue = new ArrayList<ExamPaperVo>();

		for (ExamPaperEntity e : list) {
			ExamPaperVo v = new ExamPaperVo();
			v.setUserName(e.getUser().getRealName());
			v.setClassType(e.getExamClass().getClassname());
			v.setStartTime(e.getStarttime());
			v.setEndTime(e.getEndtime());
			v.setSccore(e.getId());
			returnValue.add(v);
		}

		return returnValue;
	}
}
