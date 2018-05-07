<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:1px;">
  <t:datagrid name="carStatuList" checkbox="true" fitColumns="false" title="车审保险" actionUrl="carController.do?datagrid" idField="id" fit="true" queryMode="group">
   <t:dgCol title="主键"  field="id"  hidden="false"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="车辆号牌"  field="carnum"  hidden="true" query="true" queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="使用状态"  field="status"  hidden="true"  queryMode="single" dictionary="carstatus" width="120"></t:dgCol>
   <t:dgToolBar title="编辑" icon="icon-edit" url="carController.do?goStatusUpdate" funname="update"></t:dgToolBar>
  </t:datagrid>
  </div>
 </div>
 <script type="text/javascript">
 </script>