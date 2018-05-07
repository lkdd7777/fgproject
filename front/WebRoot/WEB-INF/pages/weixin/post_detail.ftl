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
			<h1 class="mui-title">发文管理</h1>
		</header>
		<div class="mui-content">
			<div class="mui-content-padded" style="margin: 5px;">
				<form method="post">
					${info.content}
					<input type="hidden" name="infoId" value="${info.id}"/>
					<#if isEditable??>
					<#if isEditable>
						<#if isRejectable??><#if isRejectable>
							<div class="mui-input-row" style="margin: 10px 5px;">
								<textarea id="textarea" name="rejectContent" rows="8" placeholder="驳回意见"></textarea>
							</div>
						</#if></#if>
						<button onclick="submitApproval()" class="mui-btn mui-btn-block mui-btn-primary mui-icon">确认提交</button>
						<#if isRejectable??><#if isRejectable>
							<button onclick="submitReject()" class="mui-btn mui-btn-block mui-btn-primary mui-icon">确认驳回</button>
						</#if></#if>
					</#if>
					</#if>
				</form>
			</div>
		</div>
		<script src="${base}/res/js/jquery-1.8.2.min.js" type="text/javascript"></script>
		<script type="text/javascript">
			function submitApproval(){
				$('form').attr('action','${base}/weixin/post/appoval').submit();
			}
			
			function submitReject(){
				var rejectContent=$("#rejectInput").val();
				if(rejectContent=="" || rejectContent=="请在此输入驳回信息"){
					return false;
				}else{
					$('form').attr('action','${base}/weixin/petition/saveReject').submit();
				}
			}
		</script>
	</body>
</html>