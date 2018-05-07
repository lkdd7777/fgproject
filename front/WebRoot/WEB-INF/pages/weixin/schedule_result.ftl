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
		    <h1 class="mui-title">个人日程</h1>
		</header>
		<div class="mui-content">
		    <ul class="mui-table-view mui-table-view-striped mui-table-view-condensed">
		    	<#if scheduleList??>
			    	<#if (scheduleList?size>0)>
			    		<#list scheduleList as item>
			    			<li class="mui-table-view-cell">
					            <div class="mui-table">
					                <div class="mui-table-cell mui-col-xs-10">
					                    <h4 class="mui-ellipsis">${schedule.date} ${schedule.week}</h4>
					                    <h5>地点：${schedule.address}</h5>
					                    <h5>内容：${schedule.content}</h5>
					                    <h5>参加领导及部门：${schedule.departName}</h5>
					                </div>
					                <div class="mui-table-cell mui-col-xs-5 mui-text-right">
					                    <span class="mui-h5">${schedule.noon}　${schedule.time}</span>
					                </div>
					            </div>
					        </li>
			    		</#list>
			    	<#else>
			    		<li class="mui-table-view-cell">
				            <div class="mui-table">
				                <div class="mui-table-cell mui-col-xs-10">
				                	<h4 class="mui-ellipsis">本周工作安排还未发布且您还没有定义自己的日程，请耐心等候。</h4>
				                 </div>
				            </div>
				        </li>
			    	</#if>
		    	</#if>
		    </ul>
		</div>
	</body>
</html>