<#assign shiro=JspTaglibs["/WEB-INF/tlds/shiro.tld"] />
﻿<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<@globe.include title="在线考试"/>
<link href="${base}/res/css/page/onlinetest_result.css" rel="stylesheet" type="text/css">
</head>
<body>
<div id="wrap">
	<@globe.header/>
	<div id="main">
		<div class="title">
			<img src="${base}/res/images/Test/title.jpg" alt="日程安排" />
		</div>
		<div class="page">
			<div class="bg">
				<h5>
					您的试卷已经提交系统评分，<br />
					考试分数由执法监督科统一发布。
				</h5>
			</div>
		</div>
	</div>
	<@globe.footer backhref="${base}"/>
</div>
</body>
</html>
