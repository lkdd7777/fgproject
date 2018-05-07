<#assign shiro=JspTaglibs["/WEB-INF/tlds/shiro.tld"] />
﻿<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<@globe.include title="通知公告"/>
<link href="${base}/res/css/page/announcement.css" rel="stylesheet" type="text/css">
<link href="${base}/res/js/fancy/jquery.fancybox.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="${base}/res/js/fancy/jquery.fancybox.pack.js"></script>
<script type="text/javascript">
	$(function(){
		$('.fancybox').fancybox({
			'autoDimensions':true,
			'width':1000
		});
		
		$('contentAnchor').click(function(){
			alert();
		});
	});
</script>
</head>
<body>
<div id="wrap">
	<@globe.header/>
	<div id="main">
		<div class="title">
			<img src="${base}/res/images/Announcement/title.jpg" alt="工作安排" />
		</div>
		<ul>
			<#list announceList as item>
				<#if item.type =='0'>
					<li class="notice">
						<div class="in_time">
							<span class="date">${item.date}</span>${item.week}
							<span class="divide">至</span>
							<span class="date">${item.endTime.date}</span>${item.endTime.week}
						</div>
						<table>
							<tr>
								<th class="th1">标题</th>
								<td class="td1">${item.title}</td>
							</tr>
							<tr>
								<th class="th2">内容</th>
								<td class="td2">
									<a class="fancybox fancybox.iframe" href="${base}/announcement/detail?id=${item.id}">
										<#if item.simpleContent?length lt 50>${item.simpleContent}<#else>${item.simpleContent[0..50]}...</#if>
									</a>
								</td>
							</tr>
						</table>
					</li>
				<#else>
					<li class="meeting">
						<div class="in_time">
							<#if item.showEndTime>
								<span class="date">${item.date}</span>${item.week}
								<span class="divide">至</span>
								<span class="date">${item.endTime.date}</span>${item.endTime.week}
							<#else>
								<span class="date">${item.date}</span>${item.week}&nbsp;&nbsp;${item.noon}&nbsp;&nbsp;${item.time}
							</#if>
						</div>
						<table>
							<tr>
								<th class="th1">地点</th>
								<th class="th2">内容</th>
								<th class="th3">参加领导及部门</th>
								<th class="th4">组织部门</th>
							</tr>
							<tr>
								<td class="td1">${item.title}</td>
								<td class="td2">
									<a class="fancybox fancybox.iframe" href="${base}/announcement/detail?id=${item.id}">
										<#if item.simpleContent?length lt 50>${item.simpleContent}<#else>${item.simpleContent[0..50]}...</#if>
									</a>
								</td>
								<td class="td3">${item.departName}</td>
								<td class="td4">${item.masterDepartName}</td>
							</tr>
						</table>
					</li>
				</#if>
				<div id="${item.id}" style="width:640px;display:none;">${item.content}</div>
			</#list>
		</ul>
	</div>
	<@globe.footer backhref="${base}"/>
</div>
</body>
</html>
