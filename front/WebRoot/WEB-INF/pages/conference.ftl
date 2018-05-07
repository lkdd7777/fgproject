<#assign shiro=JspTaglibs["/WEB-INF/tlds/shiro.tld"] />
﻿<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<@globe.include title="会议管理"/>
<link href="${base}/res/css/page/conference.css" rel="stylesheet" type="text/css">
</head>
<body>
<div id="wrap">
	<@globe.header/>
	<div id="main">
		<div class="title">
			<img src="${base}/res/images/Conference/title.jpg" alt="会议室管理" />
		</div>
		<div class="button">
			<a href="${base}/conference/list?roomType=2" title="小会议室" class="b01">
				<img src="${base}/res/images/Conference/button01.jpg" alt="小会议室" />
				<#if num2 gt 0><span>${num2}</span></#if>
			</a>
			<a href="${base}/conference/list?roomType=1" title="大会议室" class="b02">
				<img src="${base}/res/images/Conference/button02.jpg" alt="大会议室" />
				<#if num1 gt 0><span>${num1}</span></#if>
			</a>
			<a href="${base}/conference/list?roomType=3" title="阅览室" class="b03">
				<img src="${base}/res/images/Conference/button03.jpg" alt="阅览室" />
				<#if num3 gt 0><span>${num3}</span></#if>
			</a>
		</div>
	</div>
	<@globe.footer backhref="${base}"/>
</div>
</body>
</html>
