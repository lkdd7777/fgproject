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
		    <a href="javascript:history.go(-1);" class="mui-action-back mui-icon mui-icon-left-nav mui-pull-left"></a>
		    <h1 class="mui-title">错误信息</h1>
		</header>
		<div class="mui-content">
		    <ul class="mui-table-view mui-table-view-striped mui-table-view-condensed">
				<li class="mui-table-view-cell">
		            <div class="mui-table">
		                <div class="mui-table-cell mui-col-xs-10">
		                	<h4 class="mui-ellipsis">${errorMsg!}</h4>
		                 </div>
		            </div>
		        </li>
		    </ul>
		</div>
	</body>
</html>