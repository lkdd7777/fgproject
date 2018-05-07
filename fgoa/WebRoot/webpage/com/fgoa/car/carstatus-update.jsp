<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>车审保险</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
 </head>
 <body>
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="carController.do?doUpdateStatus" tiptype="1">
					<input id="id" name="id" type="hidden" value="${carPage.id }">
		<table style="width: 600px;" cellpadding="0" cellspacing="1" class="formtable">
					<tr>
						<td align="right">
							<label class="Validform_label">
								车辆号牌:
							</label>
						</td>
						<td class="value">
						     	 <input id="carnum" name="carnum" type="text" style="width: 150px" class="inputxt"  
									    datatype="*" value='${carPage.carnum}' readonly="readonly">
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">车辆号牌</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								使用状态:
							</label>
						</td>
						<td class="value">
							<input id="status" name="status" type="text" style="width: 150px" class="inputxt"  
									    datatype="*" value='${carPage.status}'>
							<%-- <t:dictSelect field="status" type="list"
										typeGroupCode="carstatus" defaultVal="${carPage.status}" hasLabel="false"  title="车辆状态"></t:dictSelect> --%>    
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">车辆状态</label>
						</td>
					</tr>
			</table>
		</t:formvalid>
 </body>