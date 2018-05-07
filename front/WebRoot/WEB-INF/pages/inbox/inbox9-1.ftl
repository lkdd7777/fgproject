<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<@globe.include title="收文管理"/>
<link rel="stylesheet" type="text/css" href="${base}/res/js/fancybox/jquery.thumbox.1.2.css" />
<script type="text/javascript" src="${base}/res/js/fancybox/jquery.easing.1.3.js"></script>
<script type="text/javascript" src="${base}/res/js/fancybox/jquery.thumbox.1.2.js"></script>
<script type="text/javascript">
	$(document).ready(function(e) {
		$('#read_box').click(function(){
			$('#img_box a:first').trigger("click");
			return false;
		});
		$('#img_box').thumbox({maxThumbHeight:100});
	});
</script>
<link href="${base}/res/js/alert/sweetalert.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="${base}/res/js/alert/sweetalert.min.js"></script>
<script type="text/javascript">
	$(function(){
		$(".remindAnchor").click(function(){
			var _inboxId=$(this).attr("data-ref");
			$.ajax({
				url:"${base}/inbox/remind",
				type:"POST",
				data:{"inboxInfoId":_inboxId},
				success:function(data){
					var _type="success";
					var _msg="已向相关用户发送了短信提醒。"
					if(data.errorMsg){
						_type="warning";
						_msg=_msg+"但是出现了警告，"+data.errorMsg;
					}
					if(!data.success){
						_type="error";
					}
					swal({
						title: "催办完成!",
						text: _msg,
						type: _type,
						confirmButtonText: "确定"
					});
				}
			})
		});
		
		$(".filed").bind("click",function(){
			var _inboxId=$(this).attr("data-ref");
			var url = "${base}/inbox/remarkReaded?inboxInfoId=${inboxInfoId}";
			window.location.href=url;
		})
	});
</script>
<style type="text/css">
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

.post-history{margin-top:10px;border-top:2px solid #55C5D0;}
.post-history td{text-align: center;}
.btn2{
	    width: 125px;
    height: 38px;
    color: #fff;
    background-color: #D64499;
    border-color: #D64499;
    border: 1px solid transparent;
    cursor: pointer;
    font-weight: 700;
        font-size: 18px;
}
</style>
</head>
<body>
<div id="wrap">
	<@globe.header/>
	<div id="main">
		<div class="title">
			<img src="${base}/res/images/Inbox/title.jpg" alt="日程安排" />
		</div>
		<div class="bg">
			<h2>武汉市房地产市场管理中心收文处理单</h2>
			<form action="${base}/inbox/saveOpinion" method="post">
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
											<img src="${base}/${item.path}" alt="${info.title}" widht="309" height="437"/>
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
						</td>
					</tr>
					<#if (ihList?size > 0)>
						<tr>
							<th class="strong">回告内容</th>
							<td colspan="3">
								<#list ihList as item>
									<div class="msg">
										<p>${item.content}</p>
										<p style="text-align:right">${item.user_name}（${item.status}）${item.create_time?string("yyyy年MM月dd日")}</p>
									</div>
								</#list>
							</td>
						</tr>
					</#if>
				</table>
			</form>
			<#if (infoUserRel ??) && (infoUserRel?size>0) > 
				<div class="post-history">
					<table style="margin-top: 10px;width:100%">
						<tr>
							<th class="th2">姓名</th>
							<th class="th2">是否阅读</th>
						</tr>
						<#assign isReaded = 0>
						<#list infoUserRel as item>
							<tr>
								<td class="td2">${item.realname}</th>
									
									<#if item.isReaded = 0>
										<#assign isReaded = isReaded + 1>
										<td class="td2">未读</td>
									<#else>
										<td class="td2">已读</td>
									</#if>
								</td>
								
							</tr>
						</#list>
					</table>
				</div>
				<div style="text-align: center;margin-top:10px">
					<#if (isReaded > 0)>
						<button class="btn2 remindAnchor" data-ref="${info.id}">催办</button>
					<#else>
						<button class="btn2 filed" data-ref="${info.id}">归档</button>
					</#if>
				</div>
			</#if>
			
		</div>
		
	</div>
	<@globe.footer backhref="${base}"/>
</div>
</body>
</html>
