<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<@globe.include title="信访管理"/>
<script type="text/javascript" charset="utf-8" src="${base}/res/js/ueditor/ueditor.config.js"></script>
<script type="text/javascript" charset="utf-8" src="${base}/res/js/ueditor/ueditor.all.min.js"></script>
<script type="text/javascript" charset="utf-8" src="${base}/res/js/ueditor/lang/zh-cn/zh-cn.js"></script>
<link rel="stylesheet" type="text/css" href="${base}/res/js/fancybox/jquery.thumbox.1.2.css" />
<script type="text/javascript" src="${base}/res/js/fancybox/jquery.easing.1.3.js"></script>
<script type="text/javascript" src="${base}/res/js/fancybox/jquery.thumbox.1.2.js"></script>
<link href="${base}/res/js/fancy/jquery.fancybox.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="${base}/res/js/fancy/jquery.fancybox.pack.js"></script>
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
		
		$('form').attr('action','${base}/inbox/saveReplay').submit();
	}
	
	function submitReject(){
		var rejectContent=$("#rejectInput").val();
		if(rejectContent=="" || rejectContent=="请在此输入驳回信息"){
			return false;
		}else{
			$('form').attr('action','${base}/inbox/saveReject').submit();
		}
	}
</script>

<script type="text/javascript">
	$(document).ready(function(e) {
		$('#read_box').click(function(){
			$('#img_box a:first').trigger("click");
			return false;
		});
		$('#img_box').thumbox({maxThumbHeight:100});
	});
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

#main{width:1002px;position:relative;}
#main .title{width:1001px;height:58px;overflow:hidden;overflow:hidden;}
#main .title img{display:block;width:1001px;height:58px;}

#main .bg{background:#fff;padding:10px 46px 80px;}
#main .bg h2{ line-height:70px;height:70px;text-align:center;font-size:16px;color:#d44499;}
#main table{margin:0 auto;border-left:3px solid #d9d9d9;border-top:3px solid #d9d9d9;}
#main table th,#main table td{margin:0 auto;border-right:3px solid #d9d9d9;border-bottom:3px solid #d9d9d9;background:#f5f5f5;}
#main table th{text-align:center;padding:9px 4px;font-size:14px;color:#454545;line-height:28px;}
#main table td{padding:9px 14px;font-size:14px;color:#454545;line-height:28px;}
#main table td textarea{width:100%;line-height:28px;height:28px;}

#main .btn{padding:33px 0 0 330px;height:38px;overflow:hidden;}
#main .btn input{display:block;width:130px;height:38px;overflow:hidden;float:left;margin-right:22px;cursor:pointer;padding:0px;border:0px;}
#main .btn input.reset{background:url(${base}/res/images/Inbox/Inbox3_1.jpg) no-repeat;}
#main .btn input.submit{background:url(${base}/res/images/Inbox/Inbox3_2.jpg) no-repeat;}

#main .strong{font-weight:bold;}
#main textarea.leader{min-height:200px;}

#img_box{position:absolute;top:-1000000px;;left:-1000000px;}
</style>
</head>
<body>
<div id="wrap">
	<@globe.header/>
	<div id="main">
		<div class="title">
			<img src="${base}/res/images/Inbox/title.jpg" alt="收文管理" />
		</div>
		<div class="bg">
			<h2>武汉市房地产市场管理中心收文处理单</h2>
			<table cellpadding="0" cellspacing="0">
				<tr>
					<th>来文标题</th>
					<td class="strong" colspan="3">${info.title}</td>
				</tr>
				<tr>
					<th style="width:116px;">来文单位</th>
					<td style="width:316px;">${info.orgName}</td>
					<th style="width:116px;">来文日期</th>
					<td style="width:316px;">${info.submitDate?string("yyyy年MM月dd日")}</td>
				</tr>
				<tr>
					<th>来文字号</th>
					<td>${info.tag!}</td>
					<th>收文编号</th>
					<td>${info.sortNum!}</td>
				</tr>
				<tr>
					<th>正文</th>
					<td>
						<a id="read_box" href="#" title="查看正文">查看正文</a>
						<ul id="img_box">
							<#list contentList as item>
								<li>
									<a href="${base}/${item.path}" title="${info.title}">
										<img src="${base}/${item.path}" alt="${info.title}" />
									</a>
								</li>
							</#list>
						</ul>
					</td>
					<th>份数</th>
					<td>${info.amount}</td>
				</tr>
				<tr>
					<th>附件</th>
					<td>${info.addon!}</td>
					<th>密级</th>
					<td>${info.classification!}</td>
				</tr>
				<tr>
					<th class="strong">阅文批示</th>
					<td colspan="3">
						<#list opinions as item>
							<div class="msg">
								<p>${item.content}</p>
								<p style="text-align:right">${item.userName} ${item.submitDate?string("yyyy年MM月dd日")}</p>
							</div>
						</#list>
						<textarea class="leader" name="opinionContent"><#if opinion??>${opinion.content}</#if></textarea>
					</td>
				</tr>
			</table>
			<form method="post">
				<font color="red">${errorMsg!}</font>
				
				<#if rejected??><#if rejected ==true><font color="red">驳回意见：【${info.rejectContent!}】</font><br></#if></#if>
				<#if isEditable??><#if isEditable !=true><font color="red">当前答复收文已经提交审批，无法进行修改</font><br></#if></#if>
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
				<#if (ihList?size > 0)>
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
							
							<#list ihList as item>
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
				<div class="btn">
					<input type="hidden" value="${info.id}" name="inboxInfoId"/>
					<#if isRejectAble??>
						<a href="#" onclick="submitReject()">
							<img src="${base}/res/images/Petition/Inbox12_1.jpg" alt="" />
						</a>
					</#if>
					<#if isSelectAble??>
						<a id="selector" href="#selectDirectorDiv"><img src="${base}/res/images/Petition/Inbox12_2.jpg" alt="" /></a>
					<#else>
						<a href="#" onclick="submitApproval()"><img src="${base}/res/images/Petition/Inbox12_2.jpg" alt="" /></a>
					</#if>
				</div>
				<div id="param" style="display:none;"></div>
			</form>
			
			<div id="selectDirectorDiv" class="list_box" style="display:none;">
				<div class="top_btn"></div>
				<ul>
					<#list leaders as item>
						<li <#if item_index = 0>class="selected"</#if> data-rel="${item.ID}">${item.realname}</li>
					</#list>
				</ul>
				<div class="bottom_btn">
					<a href="#" onclick="submitApproval()">
						<img src="${base}/res/images/Petition/Inbox12_2.jpg" alt="" />
					</a>
				</div>
			</div>
		</div>
	</div>
	<@globe.footer backhref="${base}"/>
</div>
</body>
</html>
