<!DOCTYPE html>
<html>

	<head>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no" />
		<title></title>
		<link href="${base}/res/js/mui/css/mui.min.css" rel="stylesheet" />
		<link href="${base}/res/js/mui/css/mui.indexedlist.css" rel="stylesheet" />
		<style>
			html,
			body {
				height: 100%;
				overflow: hidden;
			}
			.mui-bar {
				-webkit-box-shadow: none;
				box-shadow: none;
			}
			#done.mui-disabled{
				color: gray;
			}
		</style>
	</head>

	<body>
		<header class="mui-bar mui-bar-nav">
			<a class="mui-action-back mui-icon mui-icon-left-nav mui-pull-left"></a>
			<h1 class="mui-title">收文管理</h1>
			<a id='done' class="mui-btn mui-btn-link mui-pull-right mui-btn-blue mui-disabled">完成</a>
		</header>
		<div class="mui-content">
			<div id='list' class="mui-indexed-list">
				
				<div class="mui-indexed-list-inner">
					<div class="mui-indexed-list-empty-alert">没有数据</div>
					<ul class="mui-table-view">
						<li data-group="分管领导" class="mui-table-view-divider mui-indexed-list-group">分管领导</li>
						<li data-value="AKU" data-tags="AKeSu" class="mui-table-view-cell mui-indexed-list-item mui-checkbox mui-left">
							<input type="checkbox" />谢平</li>
						<li data-value="BPL" data-tags="ALaShanKou" class="mui-table-view-cell mui-indexed-list-item mui-checkbox mui-left">
							<input type="checkbox" />张世桥</li>
						<li data-value="AAT" data-tags="ALeTai" class="mui-table-view-cell mui-indexed-list-item mui-checkbox mui-left">
							<input type="checkbox" />等等</li>
						<li data-group="部门" class="mui-table-view-divider mui-indexed-list-group">部门</li>
						<li data-value="BSD" data-tags="BaoShan" class="mui-table-view-cell mui-indexed-list-item mui-checkbox mui-left">
							<input type="checkbox" />部门1</li>
						<li data-value="BAV" data-tags="BaoTou" class="mui-table-view-cell mui-indexed-list-item mui-checkbox mui-left">
							<input type="checkbox" />部门2</li>
						<li data-value="BHY" data-tags="BeiHaiFuCheng" class="mui-table-view-cell mui-indexed-list-item mui-checkbox mui-left">
							<input type="checkbox" />部门三</li>
					</ul>
				</div>
			</div>
		</div>
		<script src="${base}/res/js/mui/js/mui.min.js"></script>
		<script src="${base}/res/js/mui/js/mui.indexedlist.js"></script>
		<script type="text/javascript" charset="utf-8">
			mui.init();
			mui.ready(function() {
				var header = document.querySelector('header.mui-bar');
				var list = document.getElementById('list');
				list.style.height = (document.body.offsetHeight - header.offsetHeight) + 'px';
				window.indexedList = new mui.IndexedList(list);
			});
		</script>
	</body>
</html>