<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>武汉市房地产市场管理中心发文处理单</title>
<style type="text/css">
	body {font-size:14px;}
	table {width:800px;}
	
	#main table{margin:0 auto;border-left:1px solid #000;border-top:1px solid #000;}
	#main table th,#main table td{margin:0 auto;border-right:1px solid #000;border-bottom:1px solid #000;background:#f5f5f5;}
	#main table th{text-align:center;padding:9px 4px;font-size:14px;color:#454545;line-height:28px;}
	#main table td{padding:9px 14px;font-size:14px;color:#454545;line-height:28px;}
	#main table td textarea{width:100%;line-height:28px;height:28px;}
	#main table td p.pad{padding:5px 2px;}
	#main table td p.textright{text-align:right;}
</style>
</head>
<body onload="window.print();">
	<div id="main">
		<table>
			<tr>
				<th>联合发文单位</th>
				<td colspan="3">
					${info.title}
				</td>
			</tr>
			<tr>
				<th style="width:116px;">编号</th>
				<td style="width:316px;">
					${info.sortNum}
				</td>
				<th style="width:116px;">密级</th>
				<td style="width:316px;">
					${info.classfication}
				</td>
			</tr>
			<tr>
				<th>标题</th>
				<td colspan="3">
					${info.title}
				</td>
			</tr>
			<tr>
				<th>主题词</th>
				<td colspan="3">
					${info.keyWords}
				</td>
			</tr>
			<tr>
				<th>发</th>
				<td colspan="3">
					${info.to}
				</td>
			</tr>
			<tr>
				<th>抄送</th>
				<td colspan="3">
					${info.cc}
				</td>
			</tr>
			<tr>
				<th>发文者：</th>
				<td colspan="3">
					${info.from}
					<p style="text-align:right"><#if info.submitTime??>${info.submitTime?string("yyyy年MM月dd日")}</#if></p>
				</td>
			</tr>
			<tr>
				<th>科长：</th>
				<td colspan="3">
					${info.sectionChief!}
					<p style="text-align:right"><#if info.sectionChiefTime??>${info.sectionChiefTime?string("yyyy年MM月dd日")}</#if></p>
				</td>
			</tr>
			<tr>
				<th>分管领导：</th>
				<td colspan="3">
					${info.viceDirector!}
					<p style="text-align:right"><#if info.viceDirectorTime??>${info.viceDirectorTime?string("yyyy年MM月dd日")}</#if></p>
				</td>
			</tr>
			<tr>
				<th>中心负责人：</th>
				<td colspan="3">
					${info.centerLeader!}
					<p style="text-align:right"><#if info.centerLeaderTime??>${info.centerLeaderTime?string("yyyy年MM月dd日")}</#if></p>
				</td>
			</tr>
			<tr>
				<th>文字审稿：</th>
				<td colspan="3" >
					${info.postManager!}
					<p style="text-align:right"><#if info.postManagerTime??>${info.postManagerTime?string("yyyy年MM月dd日")}</#if></p>
				</td>
			</tr>
		</table>
	</div>
</body>
</html>
