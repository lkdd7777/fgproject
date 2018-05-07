﻿<#assign shiro=JspTaglibs["/WEB-INF/tlds/shiro.tld"] />
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<@globe.include title="发文管理"/>
<link href="${base}/res/css/page/post.css" rel="stylesheet" type="text/css" />
</head>
<body>
<div id="wrap">
	<@globe.header/>
	<div id="main">
		<div class="title">
			<img src="${base}/res/images/Posting/Title2.jpg" alt="发文管理" />
		</div>
		<div class="bg4">
			<table>
				<tr>
					<th class="th1">文件名</th>
					<th class="th3">状态</th>
					<th class="th4">　</th>
				</tr>
				<#list postList as item>
					<tr>
						<td class="td1"><#if item.status==5>【已归档】</#if>${item.title}</td>
						<td class="td3">
							<#if item.isReaded??>
								<#if item.isReaded == 0>
									<font color="red">[未读]</font>
								<#else>
									<font color="green">[已读]</font>
								</#if>
							</#if>
							${item.statusInfo}
						</td>
						<td class="td4">
							<a href="${base}/post/postContentDetail?postInfoId=${item.id}" title="查看">
								<img src="${base}/res/images/Posting/Posting3-01.jpg" alt="查看" />
							</a>
							<#if item.active??><#if item.active =0>
								<a href="${base}/post/delete?postInfoId=${item.id}" title="删除">
									<img src="${base}/res/images/Posting/Posting3-03.jpg" alt="删除" />
								</a>
							</#if></#if>
						</td>
					</tr>
				</#list>
			</table>
			<#if postable>
				<div class="btn4">
					<a href="${base}/post/newPostInfo" title="我要发文"><img src="${base}/res/images/Posting/Posting3-02.jpg" alt="我要发文" /></a>
				</div>
			</#if>
		</div>
	</div>
	<@globe.footer backhref="${base}"/>
</div>
</body>
</html>
