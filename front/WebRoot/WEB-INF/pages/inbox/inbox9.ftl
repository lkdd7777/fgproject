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
				<div class="btn">
					<#if opinion??><input type="hidden" value="${opinion.id}" name="opinionId"></#if>
					<input type="hidden" value="${inboxInfoId}" name="inboxInfoId"/>
					<input type="button" class="reset" onclick="$('.leader').val("")" value="" />
					<input type="submit" class="submit" onclick="" value="" />
				</div>
			</form>
		</div>
	</div>
	<@globe.footer backhref="${base}"/>
</div>
</body>
</html>
