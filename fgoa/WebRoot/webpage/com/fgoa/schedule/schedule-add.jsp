<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>日程安排</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
  <script type="text/javascript" src="plug-in/ckeditor_new/ckeditor.js"></script>
  <script type="text/javascript" src="plug-in/ckfinder/ckfinder.js"></script>
	<script type="text/javascript">
		$(function() {
			$('#masterDepId').combotree({
				url : 'departController.do?setPFunction&selfId=${depart.id}',
			});
		});
	</script>
 </head>
 <body>
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="scheduleController.do?doAdd" tiptype="1">
					<input id="id" name="id" type="hidden" value="${schedulePage.id }">
		<table style="width: 600px;" cellpadding="0" cellspacing="1" class="formtable">
				<tr>
					<td align="right">
						<label class="Validform_label">
							活动地点:
						</label>
					</td>
					<td class="value">
					     	 <input id="address" name="address" type="text" style="width: 150px" class="inputxt"  
								               datatype="*"
								               >
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">活动地点</label>
						</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							 活动时间:
						</label>
					</td>
					<td class="value">
							<input id="executetime" name="executetime" type="text" style="width: 150px" 
					      						 class="Wdate" onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})"
								               datatype="*" 
								               >
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;"> 活动时间</label>
						</td>
				</tr>
				
				<tr>
					<td align="right"><label class="Validform_label"> 参加部门: </label></td>
					<td class="value" nowrap>
						<input name="departIds" type="hidden" id="departid">
						<input name="text" class="inputxt" readonly="readonly" datatype="*" />
						<t:choose hiddenName="departid" textname="text" hiddenid="id" url="scheduleController.do?selectDepart" name="departList" icon="icon-search" title="部门列表" isclear="true"></t:choose>
					<span class="Validform_checktip">部门可多选</span></td>
				</tr>
				<tr>
					<td align="right"><label class="Validform_label"> 参加用户: </label></td>
					<td class="value" nowrap>
						<input name="userIds" type="hidden" id="userid">
						<input name=realName class="inputxt" readonly="readonly" datatype="*" />
						<t:choose hiddenName="userid" textname="realName" hiddenid="id" url="announcementController.do?selectUser" name="userList" icon="icon-search" title="用户列表" isclear="true"></t:choose>
					<span class="Validform_checktip">用户可多选</span></td>
				</tr>
				<tr>
					<td align="right"><label class="Validform_label"> 组织部门: </label></td>
					<td class="value" nowrap>
						<input id="masterDepId" name="masterDepId" style="width: 150px">
						<span class="Validform_checktip"></span>
						<label class="Validform_label" style="display: none;">组织部门</label>
					</td>
				</tr>
				
				<tr>
					<td align="right">
						<label class="Validform_label">
							活动内容:
						</label>
					</td>
					<td class="value">
					  	<textarea id="content" name="content" cols="60" rows="8"></textarea>
						<span class="Validform_checktip"></span>
						<label class="Validform_label" style="display: none;">活动内容</label>
					</td>
				</tr>
			</table>
		</t:formvalid>
 </body>
  <script src = "webpage/com/fgoa/schedule/schedule.js"></script>		