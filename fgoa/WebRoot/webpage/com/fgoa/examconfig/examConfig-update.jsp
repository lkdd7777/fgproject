<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>考试配置</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
  <script type="text/javascript" src="plug-in/ckeditor_new/ckeditor.js"></script>
  <script type="text/javascript" src="plug-in/ckfinder/ckfinder.js"></script>
  <script type="text/javascript">
  //编写自定义JS代码
  </script>
 </head>
 <body>
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="examConfigController.do?doUpdate" tiptype="1">
					<input id="id" name="id" type="hidden" value="${examConfigPage.id }">
		<table style="width: 600px;" cellpadding="0" cellspacing="1" class="formtable">
					<tr>
						<td align="right">
							<label class="Validform_label">
								名称:
							</label>
						</td>
						<td class="value">
						     	 <input id="title" name="title" type="text" style="width: 150px" class="inputxt"  
									               datatype="*"
									                 value='${examConfigPage.title}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">名称</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								最大年纪:
							</label>
						</td>
						<td class="value">
						     	 <input id="maxage" name="maxage" type="text" style="width: 150px" class="inputxt"  
									datatype="n1-2" value='${examConfigPage.maxage}'>
							<span class="Validform_checktip">岁</span>
							<label class="Validform_label" style="display: none;">最大年纪</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								最小年纪:
							</label>
						</td>
						<td class="value">
						     	 <input id="minage" name="minage" type="text" style="width: 150px" class="inputxt"  
									datatype="n1-2" value='${examConfigPage.minage}'>
							<span class="Validform_checktip">岁</span>
							<label class="Validform_label" style="display: none;">最小年纪</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								考试时间:
							</label>
						</td>
						<td class="value">
						     	 <input id="allowtime" name="allowtime" type="text" style="width: 150px" class="inputxt"  
									 datatype="n1-3" value='${examConfigPage.allowtime}'>
							<span class="Validform_checktip">分钟</span>
							<label class="Validform_label" style="display: none;">考试时间</label>
						</td>
					</tr>
			</table>
		</t:formvalid>
 </body>
  <script src = "webpage/com/fgoa/examconfig/examConfig.js"></script>		