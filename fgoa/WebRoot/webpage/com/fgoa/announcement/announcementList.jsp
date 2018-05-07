<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:1px;">
  <t:datagrid name="announcementList" checkbox="true" fitColumns="false" title="公告通知" actionUrl="announcementController.do?datagrid" idField="id" fit="true" queryMode="group">
   <t:dgCol title="主键"  field="id"  hidden="false"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="公告类型"  field="type"  hidden="true" dictionary="annotype" queryMode="single"  width="60"></t:dgCol>
   <t:dgCol title="地点"  field="title"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="内容"  field="plainContent"  hidden="true"  queryMode="single"  width="200"></t:dgCol>
   <t:dgCol title="组织部门"  field="masterDepartName"  hidden="true"  queryMode="single"  width="100"></t:dgCol>
   <t:dgCol title="参加部门"  field="departsNameStr"  hidden="true"  queryMode="single"  width="200"></t:dgCol>
   <t:dgCol title="参加用户"  field="usersNameStr"  hidden="true"  queryMode="single"  width="100"></t:dgCol>
   <t:dgCol title="举行时间"  field="validtime" formatter="yyyy-MM-dd hh:mm:ss" hidden="true"  queryMode="single"  width="140"></t:dgCol>
   <t:dgCol title="截止时间"  field="invalidtime" formatter="yyyy-MM-dd hh:mm:ss" hidden="true"  queryMode="single"  width="140"></t:dgCol>
   <t:dgCol title="操作" field="opt" width="50"></t:dgCol>
   <t:dgDelOpt title="删除" url="announcementController.do?doDel&id={id}" />
   <t:dgToolBar title="录入" icon="icon-add" url="announcementController.do?goAdd" funname="add"></t:dgToolBar>
   <%-- <t:dgToolBar title="编辑" icon="icon-edit" url="announcementController.do?goUpdate" funname="update"></t:dgToolBar>--%>
   <t:dgToolBar title="批量删除"  icon="icon-remove" url="announcementController.do?doBatchDel" funname="deleteALLSelect"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="announcementController.do?goUpdate" funname="detail"></t:dgToolBar>
  </t:datagrid>
  </div>
 </div>
 <script src = "webpage/com/fgoa/announcement/announcementList.js"></script>		
 <script type="text/javascript">
 $(document).ready(function(){
 		//给时间控件加上样式
 			$("#announcementListtb").find("input[name='validtime']").attr("class","Wdate").attr("style","height:20px;width:90px;").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#announcementListtb").find("input[name='invalidtime']").attr("class","Wdate").attr("style","height:20px;width:90px;").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 });
 </script>