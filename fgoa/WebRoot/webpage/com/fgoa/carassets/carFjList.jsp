<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:1px;">
  <t:datagrid name="carFjList" checkbox="true" fitColumns="false" title="附件上传" actionUrl="carFjController.do?datagrid&cid=${cid }" idField="id" fit="true" queryMode="group">
   <t:dgCol title="id"  field="id"  hidden="false"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="carid"  field="cid"  hidden="false"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="文件描述"  field="wjms"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="文件路径"  field="wjlj"  hidden="true"  queryMode="group"  width="120" downloadName="附件下载"></t:dgCol>
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <t:dgDelOpt title="删除" url="carFjController.do?doDel&id={id}" />
   <t:dgToolBar title="录入" icon="icon-add" url="carFjController.do?goAdd&cid=${cid }" funname="add"></t:dgToolBar>
  </t:datagrid>
  </div>
 </div>
 <script src = "webpage/com/fgoa/carassets/carFjList.js"></script>		
 <script type="text/javascript">
 $(document).ready(function(){
 		//给时间控件加上样式
 });
 </script>