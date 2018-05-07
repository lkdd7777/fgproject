<#assign shiro=JspTaglibs["/WEB-INF/tlds/shiro.tld"] />
﻿<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<@globe.include title="发文管理"/>
<link href="${base}/res/css/page/post.css" rel="stylesheet" type="text/css" />
<script type="text/javascript">
	$(document).ready(function(e) {
		$('#main .list_box ul li').click(function(){
			var This = $(this)
			if(This.hasClass('selected'))
			{
				This.removeClass('selected');	
			}
			else
			{
				This.addClass('selected');	
			}
		});
	});
</script>
</head>
<body>
<div id="wrap">
	<@globe.header/>
	<div id="main">
		<#include "title.ftl"/>
		<div class="bg5">
			<div class="list_box">
				<div class="top_btn"></div>
				<ul>
					<li class="selected">谢平</li>
					<li>陈浩</li>
				</ul>
				<div class="bottom_btn"></div>
			</div>
			<div class="btn5">
				<form>
					<a class="cancel" href="#" title="取消"><img src="${base}/res/images/Inbox/Inbox5_4.jpg" /></a>
					<input type="submit" class="submit" value=" " />
				</form>
			</div>
		</div>
	</div>
	<@globe.footer backhref="${base}"/>
</div>
</body>
</html>
