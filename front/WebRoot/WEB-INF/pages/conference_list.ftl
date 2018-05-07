<#assign shiro=JspTaglibs["/WEB-INF/tlds/shiro.tld"] />
﻿<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<@globe.include title="会议管理"/>
<link href="${base}/res/css/page/conferencelist.css" rel="stylesheet" type="text/css">
</head>
<body>
<div id="wrap">
	<@globe.header/>
	<div id="main">
		<div class="title">
			<#if roomType == '2'><img src="${base}/res/images/ConferenceList/title1.jpg" alt="会议室管理（小会议室）"/>
			<#elseif roomType == '1'><img src="${base}/res/images/ConferenceList/title2.jpg" alt="会议室管理（大会议室）"/>
			<#else><img src="${base}/res/images/Conference/title.jpg" alt="会议室管理"/></#if>
		</div>
		<ul>
			<#list conferences as item>
				<li>
				<div class="in_time">
					<span class="date">${item.date}</span>
					${item.week}　　　　${item.noon}　${item.time}
				</div>
				<table>
					<tr>
						<th class="th1">内容</th>
						<th class="th2">参加领导及部门</th>
						<th class="th3">组织部门</th>
					</tr>
					<tr>
						<td class="td1">${item.content}</td>
						<td class="td2">${item.departName}</td>
						<td class="td3">${item.masterDepartName}</td>
					</tr>
				</table>
			</li>
			</#list>
		</ul>
	</div>
	<@globe.footer backhref="${base}/conference"/>
</div>
</body>
</html>
