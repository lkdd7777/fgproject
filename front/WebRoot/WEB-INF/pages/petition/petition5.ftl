<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<@globe.include title="信访管理"/>
<script type="text/javascript">

</script>
<style type="text/css">
#main{width:1002px;position:relative;}
#main .title{width:1001px;height:58px;overflow:hidden;overflow:hidden;}
#main .title img{display:block;width:1001px;height:58px;}

#main .bg{padding:39px 0 100px;}
#main .bg table{width:100%;border-bottom:4px solid #d1d1d1;background:#f9f9f9;}
#main .bg table th{background:url(${base}/res/images/Announcement/bg.jpg) left bottom repeat-x;height:48px;padding:0 0 2px 0;color:#b4b4b4;font-size:14px;line-height:48x;font-weight:bold;}
#main .bg table th.th1{padding:0 0 0 49px;width:450px;overflow:hidden;}
#main .bg table th.th2{width:194px;overflow:hidden;}
#main .bg table th.th3{width:170px;overflow:hidden;}
#main .bg table th.th4{width:187px;overflow:hidden;}

#main .bg table td{color:#000;font-size:14px;line-height:24x;padding:12px 0;border-bottom:1px solid #dbdbdb;}
#main .bg table td.td1{padding-left:49px;width:450px;overflow:hidden;}
#main .bg table td.td2{padding-right:100px;width:94px;overflow:hidden;}
#main .bg table td.td3{padding-right:76px;width:94px;overflow:hidden;}
#main .bg table td.td4{padding-right:60px;width:127px;overflow:hidden;}

#main .btn{padding:43px 0 0 342px;height:49px;overflow:hidden;}
#main .btn a{display:block;height:49px;width:151px;overflow:hidden;float:left;margin:0 30px 0 0;}
</style>
<link href="${base}/res/js/alert/sweetalert.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="${base}/res/js/alert/sweetalert.min.js"></script>
<script type="text/javascript">
	$(function(){
		$(".remindAnchor").click(function(){
			var _petitonId=$(this).attr("data-ref");
			$.ajax({
				url:"${base}/petition/remind",
				type:"POST",
				data:{"petitionInfoId":_petitonId},
				success:function(data){
					debugger;
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
	});
</script>
</head>
<body>
<div id="wrap">
	<@globe.header/>
	<div id="main">
		<div class="title">
			<img src="${base}/res/images/Petition/title2.jpg" alt="日程安排" />
		</div>
		<div class="bg">
			<table>
				<tr>
					<th class="th1">信访件标题</th>
					<th class="th2">进度阶段</th>
					<th class="th3">时间</th>
					<th class="th4">　</th>
				</tr>
				<#list list as item>
					<tr>
						<td class="td1">${item.title}</td>
						<td class="td2">${item.statusInfo}</td>
						<td class="td3">${item.submitDate?string("yyyy-MM-dd")}</td>
						<td class="td4">
							<a href="javascript:void(0);" class="remindAnchor" title="催办" data-ref="${item.id}">
								<img src="${base}/res/images/Inbox/Inbox6_1.jpg" alt="催办" />
							</a>
						</td>
					</tr>
				</#list>
			</table>
			<div class="btn">
				<a class="left" href="${base}/petition/uploadPage" title="文件录入">
					<img src="${base}/res/images/Petition/Inbox6_2.jpg" alt="文件录入" />
				</a>
				<a class="right" href="${base}/petition/archivePage" title="查看归档文件">
					<img src="${base}/res/images/Petition/Inbox6_3.jpg" alt="查看归档文件" />
				</a>
			</div>
		</div>
	</div>
	<@globe.footer backhref="${base}"/>
</div>
</body>
</html>
