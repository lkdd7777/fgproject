<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>通讯录</title>
<style type="text/css">
	body {font-size:14px;}
	table {width:600px;}
	td {width:20%;}
	.title {font-size:16px;}
</style>
</head>
<body onload="window.print();">
	<table border="1">
		<tr>
			<td class="title">部门</td>
			<td class="title">门号</td>
			<td class="title">姓名</td>
			<td class="title">办公电话</td>
			<td class="title">移动电话</td>
		</tr>
		<#list users as item>
			<tr>
				<td>${item.departname}</td>
				<td>${item.officno!}</td>
				<td>${item.realname}</td>
				<td>${item.officePhone!}</td>
				<td>${item.mobilePhone!}</td>
			</tr>
		</#list>
	</table>
</body>
</html>
