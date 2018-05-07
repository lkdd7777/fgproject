<#assign shiro=JspTaglibs["/WEB-INF/tlds/shiro.tld"] />
﻿<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<@globe.include title="发文管理"/>
<link href="${base}/res/css/page/post.css" rel="stylesheet" type="text/css"/>
<script type="text/javascript" charset="utf-8" src="${base}/res/js/ueditor/ueditor.config.js"></script>
<script type="text/javascript" charset="utf-8" src="${base}/res/js/ueditor/ueditor.all.min.js"></script>
<script type="text/javascript" charset="utf-8" src="${base}/res/js/ueditor/lang/zh-cn/zh-cn.js"></script>
<link href="${base}/res/js/fancy/jquery.fancybox.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="${base}/res/js/fancy/jquery.fancybox.pack.js"></script>
<script type="text/javascript">
	$(document).ready(function(e) {
		UEDITOR_CONFIG.UEDITOR_HOME_URL="${base}/res/js/ueditor/";
		UEDITOR_CONFIG.initialStyle="body{font-size:12px;}"
		
		if($("#richtxt-case").size()>0){
			var editor=UE.getEditor('richtxt-case',{
				initialContent:'${content!}'
			});
			
			editor.ready(function(){
				$(".edui-editor").css("width","auto");

				editor.execCommand('forecolor','#F00');
				
			})
			editor.addListener('contentChange',function(ed){
				$("#richtxt").val(editor.getContent());
			});
		}else{
			$("#richtxt").show();
		}
		
		$("a#selector").fancybox();
		$('.list_box ul li').click(function(){
			$(this).toggleClass('selected');
			$("#param").empty();
			
			$('.list_box .selected').each(function(){
				$("#param").append('<input type="hidden" name="user" value="'+$(this).attr("data-rel")+'" >');
			});
		});
	});
	
	function submitApproval(){
		$('form').attr('action','${base}/post/approvePost').submit();
	}
	
	function submitReject(){
		var rejectInfo=$.trim($("textarea[name='rejectInfo']").val());
		if(rejectInfo || rejectInfo==""){
			alert("请输入驳回意见！");
		}
		$('form').attr('action','${base}/post/saveReject').submit();
	}
</script>
<style type="text/css">
.list_box{border:2px solid #bbb5b5;width:327px;}
.list_box .top_btn{height:56px;background:url(${base}/res/images/Inbox/Inbox5_1.jpg) top center no-repeat #f5f5f5;cursor:pointer;border-bottom:1px solid #dfdfdf;}
.list_box ul{background:#f5f5f5;}
.list_box ul li{height:46px;overflow:hidden;line-height:46px;font-size:16px;border-bottom:1px solid #dfdfdf;cursor:pointer;background:url(${base}/res/images/Inbox/Inbox10_2.png) 120px -3px no-repeat;text-align:center;}
.list_box ul li.selected{background:url(${base}/res/images/Inbox/Inbox10_2.png) 120px -57px no-repeat #f5f5f5;}
.list_box .bottom_btn{margin-left:15%;margin-top:10px;height:56px;background:url(${base}/res/images/Inbox/Inbox5_3.jpg) top center no-repeat #f5f5f5;cursor:pointer;}
.post-history{margin-top:10px;border-top:2px solid #55C5D0;}
.post-history p{margin-top:10px;}
table.gridtable {
	font-family: verdana,arial,sans-serif;
	font-size:11px;
	color:#333333;
	border-width: 1px;
	border-color: #666666;
	border-collapse: collapse;
	width:100%
}
table.gridtable th {
	border-width: 1px;
	padding: 8px;
	border-style: solid;
	border-color: #666666;
	background-color: #dedede;
}
table.gridtable td {
	border-width: 1px;
	padding: 8px;
	border-style: solid;
	border-color: #666666;
	background-color: #ffffff;
}
</style>
</head>
<body>
<div id="wrap">
	<@globe.header/>
	<div id="main">
		<#include "title.ftl"/>
		<div class="bg">
			<font color="red">${errorMsg!}</font>
			<#if rejected??><#if rejected ==true><font color="red">驳回意见：【${rejectInfo!}】</font></#if></#if>
			<#if isEditable??><#if isEditable !=true><font color="red">当前发文已经<#if isArchived??>归档<#else>提交审批</#if>，无法进行修改</font></#if></#if>
			<#if addonList??>
				</br>&nbsp;&nbsp;&nbsp;&nbsp;附件：
				<#list addonList as item>
					<a href="${base}/${item.path}" target="_blank">${item.name}</a>&nbsp;&nbsp;
				</#list>
			</#if>
			<form method="post">
				<div class="content">
					<div id="richtxt-case" style="height:400px;"></div>
					<textarea style="display:none;" id="richtxt"  name="content"></textarea>
				</div>
				<#if isEditable??>
					<#if isEditable>
						<#if isRejectable??><#if isRejectable>
							<div class="textarea">
								<textarea name="rejectInfo"></textarea>
							</div>
						</#if></#if>
						<div class="btn">
							<input type="hidden" value="${postInfoId}" name="postInfoId"/>
							
							<#if isSelectAble??>
								<a id="selector" href="#selectDirectorDiv">
									<img src="${base}/res/images/Posting/Posting7-02.jpg" alt=""/>
								</a>
							<#else>
								<a href="#" onclick="submitApproval();">
									<img src="${base}/res/images/Posting/Posting7-02.jpg" alt=""/>
								</a>
							</#if>
							
							<#if isRejectable??><#if isRejectable>
								<a href="#" onclick="$('form').attr('action','${base}/post/saveReject').submit()">
									<img src="${base}/res/images/Posting/Posting7-01.jpg" alt=""/>
								</a>
							</#if></#if>
						</div>
					</#if>
				</#if>
				<div id="param" style="display:none;"></div>
			</form>
			<#if postRecord??>
				<div class="post-history">
					<h3>历史记录</h3>
					<table class="gridtable">
						<tr>
							<th></th>
							<th>姓名</th>
							<th>是否查看</th>
							<th>是否审批</th>
						</tr>
						
						<#list postRecord as item>
							<tr>
								<td>${item_index + 1}</td>
								<td>${item.realname}</td>
								<td><#if item.isReaded == 0>否<#else>是</#if></td>
								<td><#if item.active == 0>否<#else>是</#if></td>
							</tr>
						</#list>
					</table>
				</div>
			</#if>
			<#if phList??>
				<div class="post-history">
					<h3>历史记录</h3>
						<table class="gridtable">
							<tr>
								<th></th>
								<th>姓名</th>
								<th>状态</th>
								<th>时间</th>
								<th>内容</th>
							</tr>
							
							<#list phList as item>
								<tr>
									<td>${item_index + 1}</td>
									<td>${item.user_name}</td>
									<td>${item.status}</td>
									<td>${item.create_time}</td>
									<td>${item.content}</td>
								</tr>
							</#list>
						</table>
				</div>
			</#if>
			
			<#if leaders??>
				<div id="selectDirectorDiv" class="list_box" style="display:none;">
					<div class="top_btn"></div>
					<ul>
						<#list leaders as item>
							<li data-rel="${item.ID}">${item.realname}</li>
						</#list>
					</ul>
					<div class="bottom_btn">
						<a href="#" onclick="submitApproval()">
							<img src="${base}/res/images/Petition/Inbox12_2.jpg" alt="" />
						</a>
					</div>
				</div>
			
			</#if>
			
		</div>
	</div>
	<@globe.footer backhref="${base}"/>
</div>
</body>
</html>
