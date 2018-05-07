<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>考试信息表</title>
  <t:base type="ckfinder,ckeditor,jquery,easyui,tools,DatePicker"></t:base>
  <script type="text/javascript">
  //编写自定义JS代码
  </script>
 </head>
 <body>
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="examInfoController.do?doAdd" tiptype="1">
					<input id="id" name="id" type="hidden" value="${examInfoPage.id }">
		<table style="width: 98%;" cellpadding="0" cellspacing="1" class="formtable">
				<tr>
					<td align="right" style="width:5%">
						<label class="Validform_label">
							类型:
						</label>
					</td>
					<td class="value">
							  <t:dictSelect field="type" type="list"
									typeGroupCode="examinfo" defaultVal="${examInfoPage.type}" hasLabel="false"  title="类型"></t:dictSelect>     
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">类型</label>
						</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							内容:
						</label>
					</td>
					<td class="value"><t:ckeditor name="content" isfinder="true"
						value="" type="width:850,height:300"></t:ckeditor>
					<span class="Validform_checktip"></span> <label
					class="Validform_label" style="display: none;">内容</label></td>
					<%-- 
						<td class="value">
					     	 <input id="content" name="content" type="text" style="width: 150px" class="inputxt"  
								               datatype="*"
								               >
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">内容</label>
						</td>
					--%>
				</tr>
			</table>
		</t:formvalid>
 </body>
  <script src = "webpage/com/fgoa/examinfo/examInfo.js"></script>		