<#assign shiro=JspTaglibs["/WEB-INF/tlds/shiro.tld"] />
﻿<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<@globe.include title="在线考试"/>
<link href="${base}/res/css/page/onlinetest.css" rel="stylesheet" type="text/css">
</head>
<body>
<div id="wrap">
	<@globe.header/>
	<div id="main">
		<div class="title">
			<img src="${base}/res/images/Test/title.jpg" alt="日程安排" />
		</div>
		<div class="page">
			<h2 class="big_title">车辆在交叉路口有优先通行权的，遇有车辆抢行时，应怎样做？</h2>
			<ul>
				<li><span class="selected">A. 抢行通</span></li>
				<li><span>B. 提前加速通过</span></li>
				<li><span>C. 按优先权规定正常行驶不予避让</span></li>
				<li><span>D. 减速避让，必要时停车让行</span></li>
			</ul>
		</div>
		<ul class="step clearfix">
			<li class="selected">上一题</li>
			<li></li>
			<li></li>
			<li></li>
			<li></li>
			<li></li>
			<li>提交答卷</li>
		</ul>
		<div class="time_out">距离考试结束还有：1时05分40秒</div>
	</div>
	<@globe.footer backhref="${base}"/>
</div>
</body>
</html>
