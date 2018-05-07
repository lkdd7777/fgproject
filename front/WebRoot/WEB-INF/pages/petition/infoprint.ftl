<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>武汉市房地产市场管理中心发信访处理单</title>
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
				<th style="width:116px;">来件标题</th>
				<td style="width:316px;">
					${info.title!}
				</td>
				<th style="width:116px;">来件渠道</th>
				<td style="width:316px;">
					${info.source!}
				</td>
			</tr>
			<tr>
				<th>来件单位</th>
				<td>
					${info.orgName!}
				</td>
				<th>来件日期</th>
				<td>
					${info.submitDate!}
				</td>
			</tr>
			<tr>
				<th>来件字号</th>
				<td>
					${info.tag!}
				</td>
				<th>收件编号</th>
				<td>
					${info.sortNum!}
				</td>
			</tr>
			<tr>
				<th>正文</th>
				<td>
				</td>
				<th>份数</th>
				<td>
					${info.amount!}
				</td>
			</tr>
			<tr>
				<th>附件</th>
				<td>
					${info.addon!}
				</td>
				<th>密级</th>
				<td>
					${info.classification!}
				</td>
			</tr>
			<tr>
				<th class="strong">阅文批示</th>
				<td colspan="3">
					<#list opinions as opinion>
						<div class="msg">
							<p>${opinion.content}</p>
							<p style="text-align:right">${opinion.userName} ${opinion.submitDate?string("yyyy年MM月dd日")}</p>
						</div>
					</#list>
				</td>
			</tr>
		</table>
	</div>
</body>
</html>
