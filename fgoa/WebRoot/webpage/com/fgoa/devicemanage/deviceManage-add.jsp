<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>设备管理</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
  <script type="text/javascript" src="plug-in/ckeditor_new/ckeditor.js"></script>
  <script type="text/javascript" src="plug-in/ckfinder/ckfinder.js"></script>
  <script type="text/javascript">
  //编写自定义JS代码
  </script>
 </head>
 <body>
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="deviceManageController.do?doAdd" tiptype="1">
					<input id="id" name="id" type="hidden" value="${deviceManagePage.id }">
		<table style="width: 600px;" cellpadding="0" cellspacing="1" class="formtable">
				<tr>
					<td align="right">
						<label class="Validform_label">
							序号:
						</label>
					</td>
					<td class="value">
					     	 <input id="myorder" name="myorder" type="text" style="width: 200px" class="inputxt"  
								               
								               >
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">序号</label>
						</td>
				<tr>
					<td align="right">
						<label class="Validform_label">
							部门:
						</label>
					</td>
					<td class="value">
					     	 <input id="depart" name="depart" type="text" style="width: 200px" class="inputxt"  
								               
								               >
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">部门</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							型号:
						</label>
					</td>
					<td class="value">
					     	 <input id="model" name="model" type="text" style="width: 200px" class="inputxt"  
								               
								               >
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">型号</label>
						</td>
				<tr>
					<td align="right">
						<label class="Validform_label">
							类型:
						</label>
					</td>
					<td class="value">
							<t:dictSelect field="type" type="list" id="type" 
									typeGroupCode="devicetype" hasLabel="false"  title="设备类型"></t:dictSelect>   	               
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">类型</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							设备类型:
						</label>
					</td>
					<td class="value">
					     	 <input id="devicetype" name="devicetype" type="text" style="width: 200px" class="inputxt"  
								               
								               >
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">设备类型</label>
						</td>
				<tr>
					<td align="right">
						<label class="Validform_label">
							购置时间:
						</label>
					</td>
					<td class="value">
							   <input id="purchasedate" name="purchasedate" type="text" style="width: 200px" 
					      						class="Wdate" onClick="WdatePicker()"
								                
								               >    
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">购置时间</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							基本配置:
						</label>
					</td>
					<td class="value">
					     	 <input id="baseconfig" name="baseconfig" type="text" style="width: 200px" class="inputxt"  
								               
								               >
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">基本配置</label>
						</td>
				<tr>
					<td align="right">
						<label class="Validform_label">
							状况:
						</label>
					</td>
					<td class="value">
							 <t:dictSelect field="status" type="list" id="status" 
									typeGroupCode="devicesta" hasLabel="false"  title="设备状况"></t:dictSelect>  
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">状况</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							使用人:
						</label>
					</td>
					<td class="value">
					     	 <input id="user" name="user" type="text" style="width: 200px" class="inputxt"  
								               
								               >
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">使用人</label>
						</td>
				<tr>
					<td align="right">
						<label class="Validform_label">
							备注:
						</label>
					</td>
					<td class="value">
						  	 <textarea id="remark" style="width: 400px" name="remark"></textarea>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">备注</label>
						</td>
					</tr>
			</table>
		</t:formvalid>
 </body>
  <script src = "webpage/com/fgoa/devicemanage/deviceManage.js"></script>		