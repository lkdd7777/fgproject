<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html >
<html>
<head>
<title>选择部门</title>
<t:base type="jquery,easyui,tools"></t:base>
</head>
<body style="overflow-y: hidden" scroll="no">
<t:datagrid name="userList" title="用户列表" actionUrl="announcementController.do?userGrid" idField="id" checkbox="true" showRefresh="false" pagination="false">
	<t:dgCol title="编号" field="id" hidden="false"></t:dgCol>
	<t:dgCol title="登录名" field="userName" width="50"></t:dgCol>
	<t:dgCol title="姓名" field="realName" width="50"></t:dgCol>
</t:datagrid>
</body>
</html>
