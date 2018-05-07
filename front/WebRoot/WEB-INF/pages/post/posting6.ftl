<#assign shiro=JspTaglibs["/WEB-INF/tlds/shiro.tld"] />
﻿<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<@globe.include title="发文管理"/>
<style type="text/css">
#main{width:1002px;position:relative;}
#main .title{width:1001px;height:58px;overflow:hidden;overflow:hidden;}
#main .title img{display:block;width:1001px;height:58px;}

/**#main .bg{padding:39px 0 0;}*/
#main .bg table{width:100%;border-bottom:4px solid #d1d1d1;background:#f9f9f9;}
#main .bg table th{background:url(${base}/res/images/Announcement/bg.jpg) left bottom repeat-x;height:48px;padding:0 0 2px 0;color:#b4b4b4;font-size:14px;line-height:48x;font-weight:bold;}
#main .bg table th.th1{padding:0 0 0 49px;width:200px;overflow:hidden;}
#main .bg table th.th2{width:160px;overflow:hidden;}
#main .bg table th.th3{width:100px;overflow:hidden;}
#main .bg table th.th4{width:387px;overflow:hidden;}

#main .bg table td{color:#000;font-size:14px;line-height:24x;padding:12px 0;border-bottom:1px solid #dbdbdb;}
#main .bg table td.td1{padding-left:49px;width:200px;overflow:hidden;}
#main .bg table td.td2{width:120px;overflow:hidden;}
#main .bg table td.td3{width:80px;overflow:hidden;}
#main .bg table td.td4{width:447px;overflow:hidden;}

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
		window.location.href = "managerPostList2";
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
		<div style="text-align:center;margin: 10 0 10 0;">
				<button class="btn2" >未完成文档</button>
			</div>
		<div class="bg">
			
			<div class="th_title">
				<form id="queryForm" action="${base}/post/managerPostList" method="post">
					<div class="text">
						<span>开始日期：</span>
						<input name="startTime" type="text" class="text" value="<#if startTime??>${startTime}</#if>" />
						<span>结束日期：</span>
						<input name="endTime" type="text" class="text" value="<#if endTime??>${endTime}</#if>" />
						<span>文件名：</span>
						<input type="text" class="text" id="queryStr" name="queryStr" value="<#if queryStr??>${queryStr}</#if>" />
						<span>发文编号：</span>
						<input type="text" class="text" id="sortNum" name="sortNum" value="<#if sortNum??>${sortNum}</#if>" />
					</div>
					<input type="submit" class="submit" value="" />
				</form>
			</div>
			<table>
				<tr>
					<th class="th1">文件名</th>
					<th class="th2">批准时间</th>
					<th class="th3">状态</th>
					<th class="th4">　</th>
				</tr>
				<#list postList as item>
					<tr>
						<td class="td1">${item.title}</td>
						<td class="td2"><#if item.centerLeaderTime??>${item.centerLeaderTime?string("yy年MM月dd日")}</#if></td>
						<td class="td3">批准</td>
						<td class="td4">
							<a href="${base}/post/viewArchiveDetail?postInfoId=${item.id}" target="_blank" title="查看">
								<img src="${base}/res/images/Posting/Posting5-00.jpg" alt="查看" />
							</a>
							<a href="${base}/post/printDoc?postInfoId=${item.id}" target="_blank" title="下载印文">
								<img src="${base}/res/images/Posting/Posting5-01.jpg" alt="下载印文" />
							</a>
							<a href="${base}/post/previewPostInfoDetail?postInfoId=${item.id}" title="查看发文管理单">
								<img src="${base}/res/images/Posting/Posting5-02.jpg" alt="查看发文管理单" />
							</a>
							<a href="${base}/post/previewPostInfoDetail?postInfoId=${item.id}&print=true" target="_blank" title="打印发文管理单">
								<img src="${base}/res/images/Posting/Posting5-03.jpg" alt="打印发文管理单" />
							</a>
							<a href="${base}/post/chooseMember?postInfoId=${item.id}" title="分发收文">
								<img src="${base}/res/images/Posting/Posting5-04.jpg" alt="分发" />
							</a>
						</td>
					</tr>
				</#list>
			</table>
			<#--
				<div class="pager">
					<a class="FirstPage" disabled="disabled">首页</a>
					<a class="PrevPage" disabled="disabled">上页</a>
					<span class="cpb NumericPage">1</span>
					<a class="NumericPage" href="#">2</a>
					<a class="NumericPage" href="#">3</a>
					<a class="NextPage" href="#">下页</a>
					<a class="LastPage" href="#">尾页</a>
				</div>
			-->
		</div>
	</div>
	<@globe.footer backhref="${base}"/>
</div>
</body>
</html>
