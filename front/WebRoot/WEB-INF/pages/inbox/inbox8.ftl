﻿﻿﻿﻿<#assign shiro=JspTaglibs["/WEB-INF/tlds/shiro.tld"] />
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<@globe.include title="收文管理"/>
<style type="text/css">
#main{width:1002px;position:relative;}
#main .title{width:1001px;height:58px;overflow:hidden;overflow:hidden;}
#main .title img{display:block;width:1001px;height:58px;}

#main .bg{padding:39px 0 60px;background:#fff;}
#main .bg .content{width:980px;margin:0 auto;}
#main .bg .content img{margin:0 auto;display:block;}
#main .btn{text-align:center;padding:30px 0 0;}

.imgContent{max-width:960px;width:expression(document.body.clientWidth > 960? "960px": "auto");}

.pager{text-align:center;padding:20px 10px;}
.pager a{color:#036cb4;background-color:#FFFFFF;text-decoration:none;border:#eee solid 1px;padding:2px 6px;margin-right:5px;}
.pager a:hover{color:#FFFFFF;background-color:#036cb4;border:#036cb4 solid 1px;}
.pager .cpb {color:#FFFFFF;background-color:#036cb4;text-decoration:none;border:#036cb4 solid 1px;padding:2px 6px;margin-right:5px;}
.btn.btn-flat {
    border-radius: 0;
    -webkit-box-shadow: none;
    -moz-box-shadow: none;
    box-shadow: none;
    border-width: 1px;
}
.btn-danger {
    background-color: #D54398;
    border-color: #D54398;
        color: #fff;
}
.btn {
    font-size: 14px;
}
</style>
</head>
<body>
<div id="wrap">
	<@globe.header/>
	<div id="main">
		<div class="title">
			<img src="${base}/res/images/Inbox/title.jpg" alt="收文管理" />
		</div>
		<div class="bg">
			<div class="content">
				<#if addonList??>
					&nbsp;&nbsp;&nbsp;&nbsp;附件：
					<#list addonList as item>
						<a href="${base}/${item.path}" target="_blank">${item.name}</a>&nbsp;&nbsp;
					</#list>
				</#if>
				<a href="${base}/${doc.path}" target="_blank">
					<img class="imgContent" src="${base}/${doc.path}" alt="" />
				</a>
			</div>
			<div class="pager">
				<a class="FirstPage" href="<#if index gt 0>${base}/inbox/inboxInfoDetail?inboxInfoId=${inboxInfoId}<#else>javascript:void(0)</#if>">首页</a>
				<a class="PrevPage" href="<#if index gt 0>${base}/inbox/inboxInfoDetail?inboxInfoId=${inboxInfoId}&index=${index-1}<#else>javascript:void(0)</#if>">上页</a>
				<#list 1..pageCount as i>
					<a class="NumericPage <#if index+1 = i>cpb</#if>" href="${base}/inbox/inboxInfoDetail?inboxInfoId=${inboxInfoId}&index=${i-1}">${i}</a>
				</#list>
				<a class="NextPage" href="<#if index lt pageCount-1>${base}/inbox/inboxInfoDetail?inboxInfoId=${inboxInfoId}&index=${index+1}<#else>javascript:void(0)</#if>">下页</a>
				<a class="LastPage" href="<#if index lt pageCount-1>${base}/inbox/inboxInfoDetail?inboxInfoId=${inboxInfoId}&index=${pageCount-1}<#else>javascript:void(0)</#if>">尾页</a>
			</div>
			<div class="btn">
				<#if editable>
					<#if isReplay??>
						<!--
						<a href="${base}/inbox/replay?inboxInfoId=${inboxInfoId}" style="margin-right:74px;" title="编写阅文批示">
							<img src="${base}/res/images/Inbox/Inbox9_1.jpg" alt="编写阅文批示" />
						</a>-->
						<button class="" onclick="window.location.href='${base}/inbox/replay?inboxInfoId=${inboxInfoId}'" style="width:158px;height:38px;color: #ffffff;background-color: ##BBB5B5;border-color: #d64198;border: 1px solid #d54398;font-weight: 800;font-size: 21;background-color: #d54398;">编写阅文批示</button>
					</#if>
					<#if isRemark??>
						<!--
						<a href="${base}/inbox/remark?inboxInfoId=${inboxInfoId}" title="编写阅文批示">
							<img src="${base}/res/images/Inbox/Inbox9_2.jpg" alt="转签收文" />
						</a>-->
						<button class="" onclick="window.location.href='${base}/inbox/remark?inboxInfoId=${inboxInfoId}'" style="width:158px;height:38px;color: #ffffff;background-color: ##BBB5B5;border-color: #d64198;border: 1px solid #d54398;font-weight: 800;font-size: 21;background-color: #d54398;">转签收文</button>
					</#if>
					<!--归档注释掉，只能由首发管理员归档
					<a href="${base}/inbox/remarkReaded?inboxInfoId=${inboxInfoId}" title="已读并返回">
						<img src="${base}/res/images/Inbox/Inbox9_3.jpg" alt="已读并返回" />
					</a>-->
					<button class="" onclick="window.location.href='memeberReadList'" style="width:158px;height:38px;color: #ffffff;background-color: ##BBB5B5;border-color: #d64198;border: 1px solid #d54398;font-weight: 800;font-size: 21;background-color: #d54398;">已读并返回</button>
				<#else>
						
						<a href="${base}/inbox/read?inboxInfoId=${inboxInfoId}" title="阅读文件">
						<!--<button class="btn btn-danger btn-flat" style="width:158px;height:38px;vertical-align: middle;">阅读</button>-->
						<img src="${base}/res/images/Inbox/Inbox8_1.jpg" alt="阅读文件" />
					</a>
				</#if>
			</div>
		</div>
	</div>
	<@globe.footer backhref="${base}"/>
</div>
</body>
</html>
