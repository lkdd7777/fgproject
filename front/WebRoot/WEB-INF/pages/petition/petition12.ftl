<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<@globe.include title="信访管理"/>
<script type="text/javascript" charset="utf-8" src="${base}/res/js/ueditor/ueditor.config.js"></script>
<script type="text/javascript" charset="utf-8" src="${base}/res/js/ueditor/ueditor.all.min.js"></script>
<script type="text/javascript" charset="utf-8" src="${base}/res/js/ueditor/lang/zh-cn/zh-cn.js"></script>
<script type="text/javascript">
	$(document).ready(function(e) {
		UEDITOR_CONFIG.UEDITOR_HOME_URL="${base}/res/js/ueditor/";
		UEDITOR_CONFIG.initialStyle="body{font-size:12px;}"
		
		if($("#richtxt-case").size()>0){
			var editor=UE.getEditor('richtxt-case',{
				initialContent:'${info.replyContent!}'
			});
			editor.ready(function(){
				$(".edui-editor").css("width","auto");
			})
			editor.addListener('contentChange',function(ed){
				$("#richtxt").val(editor.getContent());
			});
		}else{
			$("#richtxt").show();
		}
		
		$("#rejectInput").focusin(function(){
			var Text = $(this);
			if(Text.val() == "请在此输入驳回信息"){
				Text.val("");
		}
	});
	});
	
	function submitApproval(){
		$('form').attr('action','${base}/petition/saveReplay').submit();
	}
	
	function submitReject(){
		var rejectContent=$("#rejectInput").val();
		if(rejectContent=="" || rejectContent=="请在此输入驳回信息"){
			return false;
		}else{
			$('form').attr('action','${base}/petition/saveReject').submit();
		}
	}
</script>
<style type="text/css">
#main{width:1002px;position:relative;}
#main .title{width:1001px;height:58px;overflow:hidden;overflow:hidden;}
#main .title img{display:block;width:1001px;height:58px;}

#main .bg{background:#fff;padding:10px 46px 80px;}
#main .bg h2{ line-height:70px;height:70px;text-align:center;font-size:16px;color:#010101;}
#main .bg .content{width:864px;overflow:hidden;margin:0 auto;}
#main .bg .content p{ line-height:2em;font-size:14px;color:#454545;padding:12px 3px;}
#main .textarea{padding:15px 0 10px;}
#main .textarea textarea{background:#f3f3f3;border:1px solid #bbb5b5;padding:10px;height:240px;width:880px;margin:0 auto;font-size:14px;color:#909090;}
#main .bg .btn{text-align:center;padding:20px 0 0;}
</style>
</head>
<body>
<div id="wrap">
	<@globe.header/>
	<div id="main">
		<div class="title">
			<img src="${base}/res/images/Petition/title.jpg" alt="信访管理" />
		</div>
		<div class="bg">
			<form method="post">
				<font color="red">${errorMsg!}</font>
				<#if rejected??><#if rejected ==true><font color="red">驳回意见：【${info.rejectContent!}】</font><br></#if></#if>
				<#if isEditable??><#if isEditable !=true><font color="red">当前答复信息已经提交审批，无法进行修改</font><br></#if></#if>
				<#if addonList??>
					&nbsp;&nbsp;&nbsp;&nbsp;附件：
					<#list addonList as item>
						<a href="${base}/${item.path}" target="_blank">${item.name}</a>&nbsp;&nbsp;
					</#list>
				</#if>
				<div class="content">
					<div id="richtxt-case" style="height:400px;"></div>
					<textarea style="display:none;" id="richtxt"  name="replyContent"></textarea>
				</div>
				<#if isRejectAble??>
					<div class="textarea">
						<textarea id="rejectInput" name="rejectContent"></textarea>
					</div>
				</#if>
				<div class="btn">
					<input type="hidden" value="${info.id}" name="petitionInfoId"/>
					<#if isRejectAble??>
						<a href="#" onclick="submitReject()">
							<img src="${base}/res/images/Petition/Inbox12_1.jpg" alt="" />
						</a>
					</#if>
					<a href="#" onclick="submitApproval()"><img src="${base}/res/images/Petition/Inbox12_2.jpg" alt="" /></a>
				</div>
			</form>
		</div>
	</div>
	<@globe.footer backhref="${base}"/>
</div>
</body>
</html>
