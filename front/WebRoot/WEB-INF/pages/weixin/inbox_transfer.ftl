<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title></title>
		<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no" />
		<title></title>
		<link href="${base}/res/js/mui/css/mui.min.css" rel="stylesheet" />
		<style>
			.mui-table h4,.mui-table h5,.mui-table .mui-h5,.mui-table .mui-h6,.mui-table p{
		        margin-top: 0;
		    }
		    .mui-table h4{
		        line-height: 21px;
		        font-weight: 500;
		    }
		</style>
	</head>
	<body>
		<header class="mui-bar mui-bar-nav">
			<a class="mui-action-back mui-icon mui-icon-left-nav mui-pull-left"></a>
			<h1 class="mui-title">收文管理</h1>
		</header>
		<div class="mui-content">
			<div class="mui-content-padded" style="margin: 5px;">
				<form id="tansferForm" action="${base}/weixin/inbox/saveOpition">
					<div class="mui-input-row" style="margin: 10px 5px;">
						<textarea id="textarea" name="opinionContent" rows="5" placeholder="转签意见"></textarea>
						<input type="hidden" name="infoId" value="${info.id}"/>
					</div>
				</form>
				<button onclick="$('#tansferForm').submit();" class="mui-btn mui-btn-block mui-btn-primary mui-icon">确定</button>
				<a href="${base}/weixin/inbox">
					<button class="mui-btn mui-btn-block mui-btn-primary mui-icon">取消</button>
				</a>
			</div>
		</div>
		<script src="${base}/res/js/jquery-1.8.2.min.js" type="text/javascript"></script>
	</body>
</html>