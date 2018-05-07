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
			.mui-input-group label {
				width: 22%;
			}
		</style>

	</head>

	<body>
		<header class="mui-bar mui-bar-nav">
			<h1 class="mui-title">通讯录</h1>
		</header>
		<div class="mui-content">
			<form id='query-form' class="mui-input-group" action="${base}/weixin/contact/query">
				<div class="mui-input-row">
					<label>姓名</label>
					<input type="text" name="userName" class="mui-input-clear mui-input" placeholder="请输入您要查询的同事姓名">
				</div>
			</form>
			<div class="mui-content-padded">
				<button onclick="$('#query-form').submit();" class="mui-btn mui-btn-block mui-btn-primary mui-icon mui-icon-search">查询</button>
				</div>
			</div>
		</div>
		<script src="${base}/res/js/jquery-1.8.2.min.js" type="text/javascript"></script>
		<script type="text/javascript">
			$(function(){
				$('#query-form').on('submit',function(){
					debugger;
				})
			});
		</script>
	</body>
</html>