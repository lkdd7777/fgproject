<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
<head>
<title>公告通知</title>
<t:base type="ckfinder,ckeditor,jquery,easyui,tools,DatePicker"></t:base>
<script type="text/javascript">
	<%--$(function() {
		$('#masterDepartName').combobox({
			url : 'departController.do?queryDepartList&selfId=${depart.id}',
		});
	});--%>
	
	function setvalue(){
		$.messager.prompt('输入地点','输入会议地点:',function(v){
			if (v){
				$('#title').combobox('setValue',v);
			}
		});
	}
	
	function setMasterDepart(){
		$.messager.prompt('输入地点','输入组织部门:',function(v){
			if (v){
				$('#masterDepartName').combobox('setValue',v);
			}
		});
	}
	
	function announcementBeforeSubmit(){
		if($("#announceTypeSel").val()=="1"){
			
			var userIdValue=$.trim($("#userid").val());
			var departIdValue=$.trim($("#departid").val());
			
			if(userIdValue=="" && departIdValue==""){
				$.messager.alert("缺少必填项","请选择参与部门或者参与人员","error");
				return false;
			}
			
			if($.trim($("input[name='masterDepartName']").val())==""){
				$.messager.alert("缺少必填项","请选择组织部门","error");
				return false;
			}
			
		}
	}
	
	$(function(){
		$("#announceTypeSel").change(function(){
			var _this=$(this);
			
			if(_this.val()=="1"){
				$("#conferenceRoomSelDiv").show();
				$("#announcementTileDiv").hide();
				$("input[name='announcementTile']").removeAttr("datatype");
				$(".announceCls").show();
				
			}else{
				$("#conferenceRoomSelDiv").hide();
				$("#announcementTileDiv").show();
				$(".announceCls").hide();
				$("input[name='announcementTile']").attr("datatype","*");
			}
		});
		
		$("#announceTypeSel").trigger("change");
	})
</script>
</head>
<body>
	<t:formvalid formid="formobj" dialog="true" usePlugin="password"
		layout="table" action="announcementController.do?doAdd" tiptype="1" beforeSubmit="announcementBeforeSubmit">
		<input id="id" name="id" type="hidden" value="${announcementPage.id }">
		<table style="width: 100%;" cellpadding="0" cellspacing="1"
			class="formtable">
			<tr>
				<td align="right"><label class="Validform_label"> 公告类型:
				</label></td>
				<td class="value">
					<t:dictSelect id="announceTypeSel" field="type" type="list"
							typeGroupCode="annotype" defaultVal="" hasLabel="false"  title="会议地点"></t:dictSelect>
					<span class="Validform_checktip"></span><label class="Validform_label"
					style="display: none;">公告类型</label></td>
			</tr>
			<tr id="conferenceRoomSelDiv">
				<td align="right"><label class="Validform_label"> 地点: </label>
				</td>
				<td class="value">
					<select class="easyui-combobox" id="title" name="title" style="width: 150px">
						<option value="大会议室">大会议室</option>
						<option value="小会议室">小会议室</option>
						<option value="阅览室">阅览室</option>
						<option value="其他会议室">其他会议室</option>
					</select>
					<a href="javascript:void(0)" class="easyui-linkbutton" onclick="setvalue()">自定义</a>
					<span class="Validform_checktip"></span> <label class="Validform_label"
					style="display: none;">地点</label>
				</td>
			</tr>
			<tr id="announcementTileDiv">
				<td align="right"><label class="Validform_label"> 标题: </label>
				</td>
				<td class="value">
					<input name="announcementTile" type="text" style="width: 150px" class="inputxt">
					<span class="Validform_checktip"></span> <label class="Validform_label"
					style="display: none;">标题:</label>
				</td>
			</tr>
			<tr class="announceCls">
				<td align="right"><label class="Validform_label"> 参加部门: </label></td>
				<td class="value" nowrap>
					<input name="departIds" type="hidden" id="departid">
					<input name="text" class="inputxt" readonly="readonly"/>
					<t:choose hiddenName="departid" textname="text" hiddenid="id" url="announcementController.do?selectDepart" name="departList" icon="icon-search" title="部门列表" isclear="true"></t:choose>
				<span class="Validform_checktip">部门可多选</span></td>
			</tr>
			<tr class="announceCls">
				<td align="right"><label class="Validform_label"> 参加用户: </label></td>
				<td class="value" nowrap>
					<input name="userIds" type="hidden" id="userid">
					<input name=realName class="inputxt" readonly="readonly"/>
					<t:choose hiddenName="userid" textname="realName" hiddenid="id" url="announcementController.do?selectUser" name="userList" icon="icon-search" title="用户列表" isclear="true"></t:choose>
				<span class="Validform_checktip">用户可多选</span></td>
			</tr>
			<tr class="announceCls">
				<td align="right"><label class="Validform_label"> 组织部门: </label></td>
				<td class="value" nowrap>
					
					<select class="easyui-combobox" id="masterDepartName" name="masterDepartName" style="width: 150px">
						<c:forEach items="${departList}" var="depart">
							<option value="${depart.departname }">${depart.departname }</option>
						</c:forEach>
					</select>
					<span class="Validform_checktip"></span>
					<label class="Validform_label" style="display: none;">组织部门</label>
					<a href="javascript:void(0)" class="easyui-linkbutton" onclick="setMasterDepart()">自定义</a>
				</td>
			</tr>
			<tr>
				<td align="right"><label class="Validform_label"> 举行时间:
				</label></td>
				<td class="value"><input id="validtime" name="validtime"
					type="text" style="width: 150px" class="Wdate"
					onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" datatype="*"> <span
					class="Validform_checktip"></span> <label class="Validform_label"
					style="display: none;">举行时间</label></td>
			</tr>
			<tr>
				<td align="right"><label class="Validform_label"> 截止时间:
				</label></td>
				<td class="value"><input id="invalidtime" name="invalidtime"
					type="text" style="width: 150px" class="Wdate"
					onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})"> <span
					class="Validform_checktip"></span> <label class="Validform_label"
					style="display: none;">截至时间</label></td>
			</tr>
			<tr class="announceCls">
				<td align="right"><label class="Validform_label"> 显示截止时间:
					</label></td>
					<td class="value">
						<input type="checkbox" name="showEndTime">
					<span
						class="Validform_checktip"></span> <label class="Validform_label"
						style="display: none;">显示截止时间</label></td>
			</tr>
			<!-- <tr>
				<td align="right"><label class="Validform_label"> 通知时间:
				</label></td>
				<td class="value"><input id="executeTime" name="executeTime"
					type="text" style="width: 150px" class="Wdate"
					onClick="WdatePicker()" datatype="*"> <span
					class="Validform_checktip"></span> <label class="Validform_label"
					style="display: none;">通知时间</label></td>
			</tr> -->
			<tr>
				<td align="right"><label class="Validform_label"> 内容: </label>
				</td>
				<%--<td class="value"><textarea id="content" name="content" rows="10" cols="40"></textarea>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">内容</label>
				</td> --%>
				<td class="value"><t:ckeditor name="content" isfinder="true"
						value="" type="width:580"></t:ckeditor>
					<span class="Validform_checktip"></span> <label
					class="Validform_label" style="display: none;">内容</label></td>
			</tr>
		</table>
	</t:formvalid>
</body>
<script src="webpage/com/fgoa/announcement/announcement.js"></script>