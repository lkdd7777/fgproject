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
		</header>
		<div class="mui-content">
			<form id="selectForm" action="${base}/weixin/petition/saveSelect">
				<button id="submitSelectBtn" class="mui-btn mui-btn-block mui-btn-primary mui-icon">确定</button>
				<div id='list' class="mui-indexed-list">
					<div class="mui-indexed-list-inner">
						<ul class="mui-table-view">
							<li data-group="部门" class="mui-table-view-divider mui-indexed-list-group">部门</li>
							<#list orgs as item>
								<li data-value="${item.ID}" class="mui-table-view-cell mui-indexed-list-item mui-checkbox mui-left">
									<input type="checkbox" data-tag="org" data-value="${item.ID}"/>${item.departname}
								</li>
							</#list>
						</ul>
					</div>
				</div>
				<input type="hidden" name="infoId" value="${info.id}"/>
			</form>
		</div>
		<script src="${base}/res/js/mui/js/mui.min.js"></script>
		<script src="${base}/res/js/mui/js/mui.indexedlist.js"></script>
		<script src="${base}/res/js/jquery-1.8.2.min.js" type="text/javascript"></script>
		<script type="text/javascript" charset="utf-8">
			mui.init();
			mui.ready(function() {
				var header = document.querySelector('header.mui-bar');
				var list = document.getElementById('list');
				var submitBtn = document.getElementById('submitSelectBtn');
				list.style.height = (document.body.offsetHeight - header.offsetHeight) + 'px';
				//window.indexedList = new mui.IndexedList(list);
				
				submitBtn.addEventListener('tap', function() {
					var checkboxArray = [].slice.call(list.querySelectorAll('input[type="checkbox"]'));
					//var checkboxArray=$(list).children('input[type="checkbox"]');
					var orgValues = [];
					$.each(checkboxArray,function() {
						var _this=$(this);
						if (_this[0].checked) {
							var box = $(this);
							if(_this.attr("data-tag")=="org"){
								orgValues.push(_this.attr("data-value"));
							}
						}
					});
					
					if(orgValues.length==0){
						alert("请选择部门");
						return;
					}else{
						$.each(orgValues,function(){
							$(list).append('<input type="hidden" name="orgId" value="'+this+'">');
						})
					}
					
					$("#selectForm").submit();
					
				}, false);
			});
		</script>
	</body>
</html>