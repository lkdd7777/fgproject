<#--全局资源引用-->
<#macro include title>
	<title>${title!}</title>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta name="robots" content="all" />
	<link href="${base}/res/css/default.css" rel="stylesheet" type="text/css" />
	<link href="${base}/res/css/css.css" rel="stylesheet" type="text/css">
	<script src="${base}/res/js/jquery-1.8.2.min.js" type="text/javascript"></script>
	<script src="${base}/res/js/main.js" type="text/javascript"></script>
</#macro>

<#--页头-->
<#macro header>
	<div id="header">
		<a href="${base}">
			<img id="Logo" src="${base}/res/images/header/header01.jpg" alt="武汉市房地产市场管理中心/武汉市住房专项维修资金管理中心 协同办公自动化系统" />
		</a>
		<a href="${base}">
			<img id="code" src="${base}/res/images/header/code.jpg" alt="武汉市房地产市场管理中心/武汉市住房专项维修资金管理中心 协同办公自动化系统" />
		</a>
		<div class="username">
			<div class="photo">
				<img src="${base}/userupload/usericon/<@shiro.principal property="loginName"/>.jpg"/>
			</div>
			<p>
				<span><@shiro.principal property="realName"/></span>，您好！<br />
				<a href="${base}/logout"><span>退出系统</span></a>
				<a href="${base}/toModifyPwd"><span>修改密码</span></a>
			</p>
		</div>
	</div>
</#macro>

<#--页脚-->
<#macro footer backhref="">
	<div id="footer">
		<#if backhref?length gt 0>
			<a href="${backhref}" class="back">
				<img src="${base}/res/images/back.jpg" width="72" height="72" />
			</a>
		</#if>
		copyright 2006-2013 © 版权所有　武汉市房地产市场管理中心　鄂ICP备07002437号
	</div>
</#macro>

<#macro announcementHead>
	<tr>
		<th class="th1">地点</th>
		<th class="th2">内容</th>
		<th class="th3">参加领导及部门</th>
		<th class="th4">组织部门</th>
	</tr>
</#macro>