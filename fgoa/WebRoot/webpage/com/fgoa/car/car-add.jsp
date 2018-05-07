<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>车审保险</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
  <script type="text/javascript">
  //编写自定义JS代码
  </script>
 </head>
 <body>
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="carController.do?doAdd" tiptype="1">
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
								               datatype="*"
								               >
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">车辆号牌</label>
						</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							注册日期:
						</label>
					</td>
					<td class="value">
							   <input id="regdate" name="regdate" type="text" style="width: 150px" 
					      						class="Wdate" onClick="WdatePicker()"
								               datatype="*"  readonly="readonly"
								               >    
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">注册日期</label>
						</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							上次年审时间:
						</label>
					</td>
					<td class="value">
							   <input id="presurveydate" name="presurveydate" type="text" style="width: 150px" 
					      						class="Wdate" onClick="WdatePicker()<%--WdatePicker({onpicked:function(dp){plusTwoYear(dp,'#surveydate');}})--%>"
								               datatype="*"  readonly="readonly" 
								               >    
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">上次年审时间</label>
						</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							即将年审时间:
						</label>
					</td>
					<td class="value">
							   <input id="surveydate" name="surveydate" type="text" style="width: 150px" 
					      						class="Wdate" datatype="*" onClick="WdatePicker()" readonly="readonly" >    
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">即将年审时间</label>
						</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							上次购险日期:
						</label>
					</td>
					<td class="value">
							   <input id="insurencedate" name="insurencedate" type="text" style="width: 150px" 
					      						class="Wdate" onClick="WdatePicker()<%--WdatePicker({onpicked:function(dp){plusYear(dp,'#insurenceLimitdate');}})--%>"
								               datatype="*"  readonly="readonly" 
								               >    
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">上次购险日期</label>
						</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							保险到期日期:
						</label>
					</td>
					<td class="value">
							   <input id="insurenceLimitdate" name="insurenceLimitdate" type="text" style="width: 150px" 
					      						class="Wdate"  datatype="*" onClick="WdatePicker()" readonly="readonly" >    
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">保险到期日期:</label>
						</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							ETC上次缴费日期:
						</label>
					</td>
					<td class="value">
							   <input id="etcdate" name="etcdate" type="text" style="width: 150px" 
					      						class="Wdate" onClick="WdatePicker()<%--WdatePicker({onpicked:function(dp){plusYear(dp,'#etclimitdate');}})--%>"
								               datatype="*"  readonly="readonly" >    
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">ETC上次缴费日期</label>
						</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							ETC到期日期:
						</label>
					</td>
					<td class="value">
							   <input id="etclimitdate" name="etclimitdate" type="text" style="width: 150px" 
					      						class="Wdate" onClick="WdatePicker()"
								               datatype="*"  readonly="readonly">    
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">ETC到期日期</label>
						</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							提醒手机号:
						</label>
					</td>
					<td class="value">
					     	 <input id="telnum" name="telnum" type="text" style="width: 150px" class="inputxt"  
								               datatype="*"
								               >
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">提醒手机号</label>
						</td>
				</tr>
			</table>
		</t:formvalid>
 </body>
  <script src = "webpage/com/fgoa/car/car.js"></script>		