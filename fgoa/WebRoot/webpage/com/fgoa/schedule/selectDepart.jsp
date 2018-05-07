<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html >
<html>
<head>
<title>选择部门</title>
<t:base type="jquery,easyui,tools"></t:base>
</head>
<body style="overflow-y: hidden" scroll="no">
<t:datagrid name="departList" title="部门列表" actionUrl="scheduleController.do?departTreeGrid" treegrid="true" idField="id" checkbox="${multiSelect}" showRefresh="false">
	<t:dgCol title="编号" field="id" treefield="id" hidden="false"></t:dgCol>
	<t:dgCol title="部门名称" field="departname" treefield="text" width="50"></t:dgCol>
</t:datagrid>
</body>
</html>
