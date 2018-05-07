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
		<div id="slider" class="mui-slider" >
			<div class="mui-slider-group mui-slider-loop">
				<!-- 额外增加的一个节点(循环轮播：第一个节点是最后一张轮播) -->
				 <#assign listSize=docList?size/> 
				<#list docList as item>
					<div class="mui-slider-item <#if item_index==0 || item_index==listSize>mui-slider-item-duplicate</#if>">
						<a href="#">
							<img src="${base}/${item.path}">
						</a>
					</div>
				</#list>
			</div>
			<div class="mui-slider-indicator">
				<#list docList as item>
					<#if item_index==0>
						<div class="mui-indicator mui-active"></div>
					<#else>
						<div class="mui-indicator"></div>
					</#if>
				</#list>
			</div>
		</div>
		<div class="mui-content">
			<div class="mui-content-padded">
				<#if editable??><#else>
					<#if isReplay??>
						<a href="${base}/weixin/inbox/replay?infoId=${info.id}">
							<button class="mui-btn mui-btn-block mui-btn-primary mui-icon">编写阅文批示</button>
						</a>
					</#if>
					<#if isRemark??>
						<a href="${base}/weixin/inbox/transfer?infoId=${info.id}">
							<button class="mui-btn mui-btn-block mui-btn-primary mui-icon">收文转签</button>
						</a>
						<a href="${base}/weixin/inbox/archive?infoId=${info.id}">
							<button class="mui-btn mui-btn-block mui-btn-primary mui-icon">已阅归档</button>
						</a>
					</#if>
				</#if>
			</div>
		</div>
		<script src="${base}/res/js/mui/js/mui.min.js"></script>
		<script type="text/javascript" charset="utf-8">
			<#--mui.init({
				swipeBack:true //启用右滑关闭功能
			});-->
			var slider = mui("#slider");
			document.getElementById("switch").addEventListener('toggle', function(e) {
				if (e.detail.isActive) {
					slider.slider({
						interval: 5000
					});
				} else {
					slider.slider({
						interval: 0
					});
				}
			});
		</script>
	</body>
</html>