<#assign shiro=JspTaglibs["/WEB-INF/tlds/shiro.tld"] />
﻿<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<@globe.include title="发文管理"/>
<style type="text/css">
#main{width:1002px;position:relative;}
#main .title{width:1001px;height:58px;overflow:hidden;overflow:hidden;}
#main .title img{display:block;width:1001px;height:58px;}

#main .bg{padding:39px 0 0;}
#main .bg table{width:100%;border-bottom:4px solid #d1d1d1;background:#f9f9f9;}
#main .bg table th{background:url(${base}/res/images/Announcement/bg.jpg) left bottom repeat-x;height:48px;padding:0 0 2px 0;color:#b4b4b4;font-size:14px;line-height:48x;font-weight:bold;}
#main .bg table th.th1{padding:0 0 0 49px;width:400px;overflow:hidden;}
#main .bg table th.th2{width:210px;overflow:hidden;}
#main .bg table th.th3{width:170px;overflow:hidden;}
#main .bg table th.th4{width:187px;overflow:hidden;}

#main .bg table td{color:#000;font-size:14px;line-height:24x;padding:12px 0;border-bottom:1px solid #dbdbdb;}
#main .bg table td.td1{padding-left:49px;width:450px;overflow:hidden;}
#main .bg table td.td2{padding-right:100px;width:94px;overflow:hidden;}
#main .bg table td.td3{padding-right:76px;width:100px;overflow:hidden;}
#main .bg table td.td4{padding-right:60px;width:121px;overflow:hidden;}

#main .btn{padding:43px 0 0 342px;height:49px;overflow:hidden;}
#main .btn a{display:block;height:49px;width:151px;overflow:hidden;float:left;margin:0 30px 0 0;}

#main .th_title{background:url(${base}/res/images/Contacts/th_title.jpg) no-repeat;height:46px;width:1001px;position:relative;}
#main .th_title div.text{width:800px;left:100px;top:8px;position:absolute;background:none;border:0px;padding:0px;text-align:center;font-size:16px; line-height:30px;height:30px;color:#ccc;font-family:'微软雅黑','宋体',Arial, Helvetica, sans-serif;letter-spacing:2px;display:block;}
#main .th_title div.text *{display:block;float:left;}
#main .th_title div.text input{background:none;border:0px;padding:0px;text-align:center;font-size:16px; line-height:30px;height:30px;color:#ccc;font-family:'微软雅黑','宋体',Arial, Helvetica, sans-serif;letter-spacing:2px;width:112px;}
#main .th_title .submit{width:48px;height:25px;overflow:hidden;right:45px;top:11px;display:block;position:absolute;background:none;border:0px;padding:0px;cursor:pointer;}

.pager{text-align:center;padding:20px 10px;}
.pager a{color:#036cb4;background-color:#FFFFFF;text-decoration:none;border:#eee solid 1px;padding:2px 6px;margin-right:5px;}
.pager a:hover{color:#FFFFFF;background-color:#036cb4;border:#036cb4 solid 1px;}
.pager .cpb {color:#FFFFFF;background-color:#036cb4;text-decoration:none;border:#036cb4 solid 1px;padding:2px 6px;margin-right:5px;}
.btn2{
	    width: 150px;
    height: 45px;
    color: #fff;
    background-color: ##BBB5B5;
    border-color: #BBB5B5;
    border: 1px solid transparent;
    cursor: pointer;
    font-weight: 700;
    background-color: #55c5d0;
    font-size: 18;
}
</style>
<script type="text/javascript">
$(function() {
	
	$("#queryForm").submit(function(){
		var startTimeStr=$.trim($("#startTimeStr").val());
		var endTimeStr=$.trim($("#endTimeStr").val());
		if(startTimeStr!=""){
			if(!($.checkDate(startTimeStr))){
				return false;
			}
		}
		if(endTimeStr!=""){
			if(!($.checkDate(endTimeStr))){
				return false;
			}
		}
	});
	
	$(".btn2").bind("click",function(){
		window.location.href = "";
	})
});
</script>
</head>
<body>
<div id="wrap">
	<@globe.header/>
	<div id="main">
		<div class="title">
			<img src="${base}/res/images/Posting/title3.jpg" alt="发文管理" />
		</div>
		<div class="bg">
			<table>
				<tr>
					<th class="th1">文件名</th>
					<th class="th2">时间</th>
					<th class="th3">进度阶段</th>
					<th class="th4">　</th>
				</tr>
				<#list postList as item>
					<tr>
						<td class="td1">${item.title}</td>
						<td class="td2"><#if item.postManagerTime??>${item.postManagerTime?string("yy年MM月dd日")}</#if></td>
						<td class="td3">${item.statusInfo}</td>
						<td class="td4">
							<a href="${base}/post/viewArchiveDetail?postInfoId=${item.id}" target="_blank" title="查看">
								<img src="${base}/res/images/Posting/Posting5-00.jpg" alt="查看" />
							</a>
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
