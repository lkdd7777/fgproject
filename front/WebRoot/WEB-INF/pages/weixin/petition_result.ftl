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
		    <h1 class="mui-title">信访管理</h1>
		</header>
		<div class="mui-content">
		    <ul class="mui-table-view mui-table-view-striped mui-table-view-condensed">
		    	<#if petitionInfoList??>
			    	<#if (petitionInfoList?size>0)>
			    		<#list petitionInfoList as info>
			    			<li class="mui-table-view-cell">
			    				<a href="${base}/weixin/petition/detail?infoId=${info.id}">
						            <div class="mui-table">
						                <div class="mui-table-cell mui-col-xs-10">
						                    <h4 class="mui-ellipsis">${info.title}<#if info.replyed??><font color="red"> (答复)</font></#if></h4>
						                    <h5>时间：${info.submitDate?string("yy年MM月dd日")}</h5>
						                </div>
						                <div class="mui-table-cell mui-col-xs-5 mui-text-right">
						                    <span class="mui-h5"><#if info.statusInfo??>${info.statusInfo}<#else>-</#if></span>
						                </div>
						            </div>
						        </a>
					        </li>
			    		</#list>
			    	<#else>
			    		<li class="mui-table-view-cell">
				            <div class="mui-table">
				                <div class="mui-table-cell mui-col-xs-10">
				                	<h4 class="mui-ellipsis">您当前无信访件需要办理。</h4>
				                 </div>
				            </div>
				        </li>
			    	</#if>
		    	</#if>
		    </ul>
		</div>
	</body>
</html>