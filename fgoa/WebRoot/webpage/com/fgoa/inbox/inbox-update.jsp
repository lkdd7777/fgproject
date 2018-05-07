<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>收文信息表</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
  <script type="text/javascript" src="plug-in/ckeditor_new/ckeditor.js"></script>
  <script type="text/javascript" src="plug-in/ckfinder/ckfinder.js"></script>
  <script type="text/javascript">
  //编写自定义JS代码
  </script>
 </head>
 <body>
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="inboxController.do?doUpdate" tiptype="1">
					<input id="id" name="id" type="hidden" value="${inboxPage.id }">
		<table style="width: 600px;" cellpadding="0" cellspacing="1" class="formtable">
					<tr>
						<td align="right">
							<label class="Validform_label">
								日期:
							</label>
						</td>
						<td class="value">
									  <input id="submitdate" name="submitdate" type="text" style="width: 150px" 
						      						class="Wdate" onClick="WdatePicker()"
									                
						      						 value='<fmt:formatDate value='${inboxPage.submitdate}' type="date" pattern="yyyy-MM-dd"/>'>    
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">日期</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								文号:
							</label>
						</td>
						<td class="value">
						     	 <input id="sortnum" name="sortnum" type="text" style="width: 150px" class="inputxt"  
									               
									                 value='${inboxPage.sortnum}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">文号</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								标题:
							</label>
						</td>
						<td class="value">
						     	 <input id="title" name="title" type="text" style="width: 150px" class="inputxt"  
									               
									                 value='${inboxPage.title}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">标题</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								收文单位:
							</label>
						</td>
						<td class="value">
						     	 <input id="orgname" name="orgname" type="text" style="width: 150px" class="inputxt"  
									               
									                 value='${inboxPage.orgname}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">收文单位</label>
						</td>
					</tr>
			</table>
		</t:formvalid>
 </body>
  <script src = "webpage/com/fgoa/inbox/inbox.js"></script>		