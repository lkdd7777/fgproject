﻿﻿﻿<#assign shiro=JspTaglibs["/WEB-INF/tlds/shiro.tld"] />
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<@globe.include title="收文管理"/>
<script type="text/javascript">

</script>
<style type="text/css">
#main{width:1002px;position:relative;}
#main .title{width:1001px;height:58px;overflow:hidden;overflow:hidden;}
#main .title img{display:block;width:1001px;height:58px;}

#main .bg{padding:39px 0 100px;}
#main .bg table{width:100%;border-bottom:4px solid #d1d1d1;background:#f9f9f9;}
#main .bg table th{background:url(${base}/res/images/Announcement/bg.jpg) left bottom repeat-x;height:48px;padding:0 0 2px 0;color:#b4b4b4;font-size:14px;line-height:48x;font-weight:bold;}
#main .bg table th.th1{padding:0 0 0 49px;width:400px;overflow:hidden;}
#main .bg table th.th2{width:200px;overflow:hidden;}
#main .bg table th.th3{width:170px;overflow:hidden;}
#main .bg table th.th4{width:187px;overflow:hidden;}

#main .bg table td{color:#000;font-size:14px;line-height:24x;padding:12px 0;border-bottom:1px solid #dbdbdb;}
#main .bg table td.td1{padding-left:49px;width:450px;overflow:hidden;}
#main .bg table td.td2{padding-right:100px;width:94px;overflow:hidden;}
#main .bg table td.td3{padding-right:76px;width:100px;overflow:hidden;}
#main .bg table td.td4{padding-right:60px;width:121px;overflow:hidden;}

/*#main .btn{padding:43px 0 0 342px;height:49px;overflow:hidden;}*/
#main .btn{padding:0 0 20px 342px;height:49px;overflow:hidden;}
#main .btn a{display:block;height:49px;width:151px;overflow:hidden;float:left;margin:0 30px 0 0;}
.btn2{
	    width: 59px;
    height: 27px;
    color: #fff;
    background-color: ##BBB5B5;
    border-color: #BBB5B5;
    border: 1px solid transparent;
    cursor: pointer;
    font-weight: 700;
}
</style>
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
		
		$(".btn2").bind("click",function(){
			var _inboxId=$(this).attr("data-ref");
			var url = "${base}/inbox/read?inboxInfoId="+_inboxId+"&type=admin";
			
			window.location.href=url;
		});
	});
</script>
</head>
<body>
<div id="wrap">
	<@globe.header/>
	<div id="main">
		<div class="title">
			<img src="${base}/res/images/Inbox/title2.jpg" alt="日程安排" />
		</div>
		<div class="bg">
			<div class="btn">
				<a class="left" href="${base}/inbox/uploadPage" title="文件录入"><img src="${base}/res/images/Inbox/Inbox6_2.jpg" alt="文件录入" /></a>
				<a class="right" href="${base}/inbox/archiveList" title="查看归档文件"><img src="${base}/res/images/Inbox/Inbox6_3.jpg" alt="查看归档文件" /></a>
			</div>
			<table>
				<tr>
					<th class="th1">文件名</th>
					<th class="th2">时间</th>
					<th class="th3">进度阶段</th>
					<th class="th4">　</th>
				</tr>
				<#list inboxInfoList as info>
						<tr>
							<td class="td1">${info.title}</td>
							<td class="td2">${info.submitDate?string("yy年MM月dd日")}</td>
							<td class="td3"><#if info.statusInfo??>${info.statusInfo}<#else>-</#if></td>
							<td class="td4">
								<#--
								<#if info.readedCount &gt; 0 >
									<a href="javascript:void(0);" class="remindAnchor" title="催办" data-ref="${info.id}"><img src="${base}/res/images/Inbox/Inbox6_1.jpg" alt="催办" /></a>
								<#else>
									<button class="btn2">归档</button>
								</#if>-->
								<button class="btn2" data-ref="${info.id}">查看</button>
							</td>
						</tr>
				</#list>
			</table>
		</div>
	</div>
	<@globe.footer backhref="${base}"/>
</div>
</body>
</html>
