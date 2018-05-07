<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
<head>
<title>公告通知</title>
<t:base type="ckfinder,ckeditor,jquery,easyui,tools,DatePicker"></t:base>
	<script type="text/javascript">
	
		function announcementBeforeSubmit(){
			
			if($("#userid").val()=="" && $("#departid").val()==""){
				$.messager.alert("缺少必填项","请选择参与部门或者参与人员","error");
			}
			
			if($("input[name='masterDepId']").val()==""){
				$.messager.alert("缺少必填项","请选择组织部门","error");
			}
		}
  </script>
</head>
<body>
	<t:formvalid formid="formobj" dialog="true" usePlugin="password"
		layout="table" action="announcementController.do?doUpdate" beforeSubmit="announcementBeforeSubmit" tiptype="1">
		<input id="id" name="id" type="hidden" value="${announcementPage.id }">
		<table style="width: 100%;" cellpadding="0" cellspacing="1"
			class="formtable">
			<tr>
				<td align="right"><label class="Validform_label"> 公告类型:
				</label></td>
				<td class="value">
					<t:dictSelect field="type" type="list"
							typeGroupCode="annotype" defaultVal="${announcementPage.type}" hasLabel="false"  title="会议地点"></t:dictSelect>
					<span class="Validform_checktip"></span><label class="Validform_label"
					style="display: none;">公告类型</label></td>
			</tr>
			<tr>
				<td align="right"><label class="Validform_label"> 地点: </label>
				</td>
				<td class="value"><input id="title" name="title" type="text"
					style="width: 150px" class="inputxt" datatype="*"
					value='${announcementPage.title}'> <span
					class="Validform_checktip"></span> <label class="Validform_label"
					style="display: none;">地点</label></td>
			</tr>
			<tr>
				<td align="right"><label class="Validform_label"> 参加部门: </label></td>
				<td class="value" nowrap>
					<input name="departIds" type="hidden" value="<c:forEach items='${announcementPage.departs}' var='depart'>${depart.id},</c:forEach>" id="departid">
					<input name="text" class="inputxt" value="${announcementPage.departsNameStr}" readonly="readonly"/>
					<t:choose hiddenName="departid" textname="text" hiddenid="id" url="announcementController.do?selectDepart" name="departList" icon="icon-search" title="部门列表" isclear="true"></t:choose>
				<span class="Validform_checktip">部门可多选</span></td>
			</tr>
			<tr>
				<td align="right"><label class="Validform_label"> 参加人员: </label></td>
				<td class="value" nowrap>
					<input name="userIds" type="hidden" value="<c:forEach items='${announcementPage.users}' var='user'>${user.id},</c:forEach>" id="userid">
					<input name=realName class="inputxt" value="${announcementPage.usersNameStr}" readonly="readonly"/>
					<t:choose hiddenName="userid" textname="realName" hiddenid="id" url="announcementController.do?selectUser" name="userList" icon="icon-search" title="用户列表" isclear="true"></t:choose>
				<span class="Validform_checktip">部门可多选</span></td>
			</tr>
			<tr>
				<td align="right"><label class="Validform_label"> 组织部门: </label></td>
				<td class="value" nowrap>
					<input id="amasterDepId" name="masterDepId" style="width: 150px" value="${announcementPage.masterDepartName}">
					<span class="Validform_checktip"></span>
					<label class="Validform_label" style="display: none;">组织部门</label>
				</td>
			</tr>
			<tr>
				<td align="right"><label class="Validform_label"> 举行时间:
				</label></td>
				<td class="value"><input id="validtime" name="validtime"
					type="text" style="width: 150px" class="Wdate"
					onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" datatype="*"
					value='<fmt:formatDate value='${announcementPage.validtime}' type="date" pattern="yyyy-MM-dd hh:mm:ss"/>'>
					<span class="Validform_checktip"></span> <label
					class="Validform_label" style="display: none;">举行时间</label></td>
			</tr>
			<tr>
				<td align="right"><label class="Validform_label"> 截止时间:
				</label></td>
				<td class="value"><input id="invalidtime" name="invalidtime"
					type="text" style="width: 150px" class="Wdate"
					onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" datatype="*"
					value='<fmt:formatDate value='${announcementPage.invalidtime}' type="date" pattern="yyyy-MM-dd hh:mm:ss"/>'>
					<span class="Validform_checktip"></span> <label
					class="Validform_label" style="display: none;">截止时间</label></td>
			</tr> 
			<tr>
				<td align="right"><label class="Validform_label"> 内容: </label>
				</td>
				<%--<td class="value"><textarea id="content" name="content" rows="10" cols="40">${announcementPage.content}</textarea>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">内容</label>
				</td>--%>
				
					<td class="value"><t:ckeditor name="content" isfinder="true"
						value="${announcementPage.content}" type="width:580"></t:ckeditor>
					<span class="Validform_checktip"></span> <label
					class="Validform_label" style="display: none;">内容</label></td>
				 
			</tr>
		</table>
	</t:formvalid>
</body>
<script src="webpage/com/fgoa/announcement/announcement.js"></script>