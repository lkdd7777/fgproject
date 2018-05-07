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
		    <h1 class="mui-title">本周安排</h1>
		</header>
		<div class="mui-content">
		    <ul class="mui-table-view mui-table-view-striped mui-table-view-condensed">
		    	<#if announceList??>
			    	<#if (announceList?size>0)>
    					<#list announceList as item>
							<#if item.type =='0'>
				    			<li class="mui-table-view-cell">
						            <div class="mui-table">
						                <div class="mui-table-cell mui-col-xs-10" onclick="aaa('${item.id}');">
						                    <h4 class="mui-ellipsis">标题：${item.title}</h4>
						                    <h5>时间：${item.date} ${item.week} 至  ${item.endTime.date} ${item.endTime.week}</h5>
						                    <h5>内容：<#if item.simpleContent?length lt 50>${item.simpleContent}<#else>${item.simpleContent[0..50]}...</#if></h5>
						                </div>
						            </div>
						        </li>
						     <#else>
						     	<li class="mui-table-view-cell">
						            <div class="mui-table">
						                <div class="mui-table-cell mui-col-xs-10">
						                    <h4 class="mui-ellipsis">
						                    	<#if item.showEndTime>
													${item.date} ${item.week} 至 ${item.endTime.date} ${item.endTime.week}
												<#else>
													${item.date} ${item.week}&nbsp;&nbsp;${item.noon}&nbsp;&nbsp;${item.time}
												</#if>
						                    </h4>
						                    <h5>地点：${item.title}</h5>
						                    <h5>内容：<#if item.simpleContent?length lt 50>${item.simpleContent}<#else>${item.simpleContent[0..50]}...</#if></h5>
						                    <h5>参加领导及部门：${item.departName}</h5>				
						                </div>
						            </div>
						        </li>
						     </#if>
			    		</#list>
			    	<#else>
			    		<li class="mui-table-view-cell">
				            <div class="mui-table">
				                <div class="mui-table-cell mui-col-xs-10">
				                	<h4 class="mui-ellipsis">本周工作安排还未发布，请耐心等候。</h4>
				                 </div>
				            </div>
				        </li>
			    	</#if>
		    	</#if>
		    </ul>
		</div>
	</body>
	
	<script>
		function aaa(id){
			window.location.href='${base}/weixin/anno/detail?id='+id;
		}
	</script>
</html>