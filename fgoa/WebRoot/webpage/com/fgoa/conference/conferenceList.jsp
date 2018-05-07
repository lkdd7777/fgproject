<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:1px;">
  <t:datagrid name="conferenceList" checkbox="true" fitColumns="false" title="会议管理" actionUrl="conferenceController.do?datagrid" idField="id" fit="true" queryMode="group">
   <t:dgCol title="主键"  field="id"  hidden="false"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="会议时间"  field="executetime" formatter="yyyy-MM-dd hh:mm:ss" hidden="true"  queryMode="single"  width="200"></t:dgCol>
   <t:dgCol title="会议内容"  field="content"  hidden="true"  queryMode="single"  width="200"></t:dgCol>
   <t:dgCol title="组织部门"  field="masterDepart.departname"  hidden="true"  queryMode="single"  width="200"></t:dgCol>
   <t:dgCol title="参加部门"  field="departsNameStr"  hidden="true"  queryMode="single"  width="200"></t:dgCol>
   <t:dgCol title="参加人员"  field="usersNameStr"  hidden="true"  queryMode="single"  width="200"></t:dgCol>
   <t:dgCol title="会议地点"  field="roomtype"  hidden="true"  queryMode="single" dictionary="roomtype" width="120"></t:dgCol>
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <t:dgDelOpt title="删除" url="conferenceController.do?doDel&id={id}" />
   <t:dgToolBar title="录入" icon="icon-add" url="conferenceController.do?goAdd" funname="add"></t:dgToolBar>
   <t:dgToolBar title="编辑" icon="icon-edit" url="conferenceController.do?goUpdate" funname="update"></t:dgToolBar>
   <t:dgToolBar title="批量删除"  icon="icon-remove" url="conferenceController.do?doBatchDel" funname="deleteALLSelect"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="conferenceController.do?goUpdate" funname="detail"></t:dgToolBar>
  </t:datagrid>
  </div>
 </div>
 <script src = "webpage/com/fgoa/conference/conferenceList.js"></script>		
 <script type="text/javascript">
 $(document).ready(function(){
 		//给时间控件加上样式
 			$("#conferenceListtb").find("input[name='executetime']").attr("class","Wdate").attr("style","height:20px;width:90px;").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 });
 </script>