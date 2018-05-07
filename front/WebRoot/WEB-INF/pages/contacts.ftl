<#assign shiro=JspTaglibs["/WEB-INF/tlds/shiro.tld"] />
﻿<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<@globe.include title="通讯录"/>
<link href="${base}/res/css/page/contacts.css" rel="stylesheet" type="text/css">
<script type="text/javascript">
$(function() {
	$("#nameQueryInput").focusin(function(){
		var Text = $(this);
		if(Text.val() == "请输入姓名"){
			Text.css({"font-weight":"bold","color":"#666"});
			Text.val("");
		}
	});
});
</script>
</head>
<body>
	<div id="wrap">
		<@globe.header/>
		<div id="main">
			<div class="title">
				<img src="${base}/res/images/Contacts/Title.jpg" alt="通讯录" />
			</div>
			<div class="th_title">
				<form action="${base}/contacts" method="post">
					<input id="nameQueryInput" name="userName" type="text" class="text" value="<#if userName??>${userName}<#else>请输入姓名</#if>" />
					<input type="submit" class="submit" value="" />
				</form>
			</div>
			<div class="th">
				<table>
					<#list users as item>
						<tr>
							<td class="d1">${item.realname}</td>
							<td class="d2">${item.departname}</td>
							<td class="d3">${item.officno!}</td>
							<td class="d4">
								<#if item.officePhone??>
									<#if item.officePhone="">
										——————
									<#else>
										${item.officePhone!}
									</#if>
								<#else>
									——————
								</#if>
							</td>
							<td class="d5">
								<#if item.showMobile??>
									<#if item.showMobile=1>
										<#if item.mobilePhone??>
											<#if item.mobilePhone="">
												——————
											<#else>
												${item.mobilePhone!}
											</#if>
										<#else>
											——————
										</#if>
									<#else>
										——————
									</#if>
								<#else>
									——————
								</#if>
							</td>
						</tr>
					</#list>
				</table>
			</div>
			<div class="print">
				<a href="${base}/contacts?print=true" title="打印通讯录" target="_blank">
					<img src="${base}/res/images/Contacts/print.jpg" alt="打印通讯录" />
				</a>
			</div>
		</div>
		<@globe.footer backhref="${base}"/>
	</div>
</body>
</html>
