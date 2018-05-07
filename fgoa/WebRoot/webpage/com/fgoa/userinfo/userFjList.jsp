<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:1px;">
  <t:datagrid name="userFjList" checkbox="true" fitColumns="false" title="上传附件" actionUrl="userFjController.do?datagrid&uid=${uid }" idField="id" fit="true" queryMode="group">
   <t:dgCol title="id"  field="id"  hidden="false"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="用户id"  field="uid"  hidden="false"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="文件描述"  field="wjms"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="文件路径"  field="wjlj"  hidden="true"  queryMode="group"  width="120" downloadName="附件下载" ></t:dgCol>
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <t:dgDelOpt title="删除" url="userFjController.do?doDel&id={id}" />
   <t:dgToolBar title="录入" icon="icon-add" url="userFjController.do?goAdd&uid=${uid }" funname="add"></t:dgToolBar>
   <%-- <t:dgToolBar title="编辑" icon="icon-edit" url="userFjController.do?goUpdate&uid=${uid }" funname="update"></t:dgToolBar>
   <t:dgToolBar title="批量删除"  icon="icon-remove" url="userFjController.do?doBatchDel" funname="deleteALLSelect"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="userFjController.do?goUpdate" funname="detail"></t:dgToolBar> --%>
  </t:datagrid>
  </div>
 </div>
 <script src = "webpage/com/fgoa/userinfo/userFjList.js"></script>		
 <script type="text/javascript">
 $(document).ready(function(){
 		//给时间控件加上样式
 });
 </script>