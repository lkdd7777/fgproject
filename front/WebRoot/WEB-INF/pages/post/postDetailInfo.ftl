<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<@globe.include title="发文管理"/>
<style type="text/css">
	#main{width:1002px;position:relative;}
	#main .title{width:1001px;height:58px;overflow:hidden;overflow:hidden;}
	#main .title img{display:block;width:1001px;height:58px;}
	
	#main .bg{background:#fff;padding:10px 46px 80px;}
	#main .bg h2{ line-height:70px;height:70px;text-align:center;font-size:16px;color:#55c5d1;}
	#main table{margin:0 auto;border-left:3px solid #d9d9d9;border-top:3px solid #d9d9d9;}
	#main table th,#main table td{margin:0 auto;border-right:3px solid #d9d9d9;border-bottom:3px solid #d9d9d9;background:#f5f5f5;}
	#main table th{text-align:center;padding:9px 4px;font-size:14px;color:#454545;line-height:28px;}
	#main table td{padding:9px 14px;font-size:14px;color:#454545;line-height:28px;}
	#main table td textarea{width:100%;line-height:28px;height:28px;}
	#main table td p.pad{padding:5px 2px;}
	#main table td p.textright{text-align:right;}
	
	#main .btn{padding:33px 0 0 330px;height:38px;overflow:hidden;}
	#main .btn input{display:block;width:130px;height:38px;overflow:hidden;float:left;margin-right:22px;cursor:pointer;padding:0px;border:0px;}
	#main .btn input.reset{background:url(${base}/res/images/Inbox/Inbox3_1.jpg) no-repeat;}
	#main .btn input.submit{background:url(${base}/res/images/Posting/Posting4-02.jpg) no-repeat;}
</style>
</head>
<body>
<div id="wrap">
	<@globe.header/>
	<div id="main">
		<#include "title.ftl"/>
		<div class="bg">
			<h2>武汉市房地产市场管理中心发文管理单</h2>
				<table cellpadding="0" cellspacing="0">
					<tr>
						<th>联合发文单位</th>
						<td colspan="3">
							<textarea>${info.title!}</textarea>
						</td>
					</tr>
					<tr>
						<th style="width:116px;">编号</th>
						<td style="width:316px;">
							<textarea readonly="readonly">${info.sortNum!}</textarea>
						</td>
						<th style="width:116px;">密级</th>
						<td style="width:316px;">
							<textarea readonly="readonly">${info.classfication!}</textarea>
						</td>
					</tr>
					<tr>
						<th>标题</th>
						<td colspan="3">
							<textarea readonly="readonly">${info.title!}</textarea>
						</td>
					</tr>
					<tr>
						<th>主题词</th>
						<td colspan="3">
							<textarea readonly="readonly">${info.keyWords!}</textarea>
						</td>
					</tr>
					<tr>
						<th>发</th>
						<td colspan="3">
							<textarea readonly="readonly">${info.to!}</textarea>
						</td>
					</tr>
					<tr>
						<th>抄送</th>
						<td colspan="3">
							<textarea readonly="readonly">${info.cc!}</textarea>
						</td>
					</tr>
					<tr>
						<td colspan="4">
							<p class="pad">发文者：</p>
							<textarea readonly="readonly">${info.from!}</textarea>
							<p class="pad textright"><#if info.submitTime??>${info.submitTime?string("yyyy年MM月dd日")}</#if></p>
						</td>
					</tr>
					<tr>
						<td colspan="4">
							<p class="pad">科长：</p>
							<textarea readonly="readonly">${info.sectionChief!}</textarea>
							<p class="pad textright"><#if info.sectionChiefTime??>${info.sectionChiefTime?string("yyyy年MM月dd日")}</#if></p>
						</td>
					</tr>
					<tr>
						<td colspan="4">
							<p class="pad">分管领导：</p>
							<textarea readonly="readonly">${info.viceDirector!}</textarea>
							<p class="pad textright"><#if info.viceDirectorTime??>${info.viceDirectorTime?string("yyyy年MM月dd日")}</#if></p>
						</td>
					</tr>
					<tr>
						<td colspan="4">
							<p class="pad">中心负责人：</p>
							<textarea readonly="readonly">${info.centerLeader!}</textarea>
							<p class="pad textright"><#if info.centerLeaderTime??>${info.centerLeaderTime?string("yyyy年MM月dd日")}</#if></p>
						</td>
					</tr>
					<tr>
						<td colspan="4">
							<p class="pad">文字审稿：</p>
							<textarea readonly="readonly">${info.postManager!}</textarea>
							<p class="pad textright"><#if info.postManagerTime??>${info.postManagerTime?string("yyyy年MM月dd日")}</#if></p>
						</td>
					</tr>
				</table>
			</form>
		</div>
	</div>
	<@globe.footer backhref="${base}"/>
</div>
</body>
</html>
