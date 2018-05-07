<!DOCTYPE html>
<html class="ui-page-login">

	<head>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no" />
		<title></title>
		<link href="${base}/res/js/mui/css/mui.min.css" rel="stylesheet" />
		<style>
			.mui-input-group {
				margin-top: 10px;
			}
			.mui-input-group:first-child {
				margin-top: 20px;
			}
			p {
				text-indent: 22px;
				padding: 5px 8px;
			}
		</style>

	</head>

	<body>
		<header class="mui-bar mui-bar-nav">
			<h1 class="mui-title">系统账号绑定</h1>
		</header>
		<div class="mui-content">
			<#if openId??>
				<p>
					您的微信账号还未与OA系统绑定，请输入OA系统登录名密码绑定用户
				</p>
				<form id='login-form' class="mui-input-group" action="${base}/weixin/bindUser" method="post">
					<div class="mui-input-row">
						<label>登录名</label>
						<input type="text" name="userName" class="mui-input-clear mui-input" placeholder="请输入办公系统登录名">
					</div>
					<div class="mui-input-row">
						<label>密码</label>
						<input type="password" name="password" class="mui-input-clear mui-input" placeholder="请输入办公系统登录密码">
					</div>
					<input type="hidden" name="openId" value="${openId!}">
					<input type="hidden" name="targetUrl" value="${targetUrl!}">
				</form>
				<div class="mui-content-padded">
					<button onclick="$('#login-form').submit();" class="mui-btn mui-btn-block mui-btn-primary mui-icon">绑定</button>
					</div>
				</div>
			<#else>
				<p>
					未获得到用户的微信信息,请重试或者与系统管理员联系
				</p>			
			</#if>
		</div>
		<script src="${base}/res/js/jquery-1.8.2.min.js" type="text/javascript"></script>
		<script type="text/javascript">
		</script>
	</body>
</html>