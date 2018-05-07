<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:1px;">
  <t:datagrid name="examInfoList" checkbox="true" fitColumns="false" title="考试信息表" actionUrl="examInfoController.do?datagrid" idField="id" fit="true" queryMode="group">
   <t:dgCol title="主键"  field="id"  hidden="false"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="类型"  field="type"  hidden="true"  queryMode="single" dictionary="examinfo" width="120"></t:dgCol>
   <t:dgCol title="内容"  field="content"  hidden="true"  queryMode="single"  width="800"></t:dgCol>
   <%-- <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <t:dgDelOpt title="删除" url="examInfoController.do?doDel&id={id}" />
   <t:dgToolBar title="录入" icon="icon-add" url="examInfoController.do?goAdd" funname="add" width="1000" height="500"></t:dgToolBar>--%>
   <t:dgToolBar title="编辑" icon="icon-edit" url="examInfoController.do?goUpdate" funname="update" width="1000" height="500"></t:dgToolBar>
   <%-- <t:dgToolBar title="批量删除"  icon="icon-remove" url="examInfoController.do?doBatchDel" funname="deleteALLSelect"></t:dgToolBar>--%>
   <t:dgToolBar title="查看" icon="icon-search" url="examInfoController.do?goUpdate" funname="detail" width="1000" height="500"></t:dgToolBar>
  </t:datagrid>
  </div>
 </div>
 <script src = "webpage/com/fgoa/examinfo/examInfoList.js"></script>		
 <script type="text/javascript">
 $(document).ready(function(){
 		//给时间控件加上样式
 });
 </script>