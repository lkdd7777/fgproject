<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<@globe.include title="信访管理"/>
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
</style>
</head>
<body>
<div id="wrap">
	<@globe.header/>
	<div id="main">
		<div class="title">
			<img src="${base}/res/images/Petition/title.jpg" alt="信访管理" />
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
				<a class="FirstPage" href="<#if index gt 0>${base}/petition/infoDetial?petitionInfoId=${petitionInfoId}<#else>javascript:void(0)</#if>">首页</a>
				<a class="PrevPage" href="<#if index gt 0>${base}/petition/infoDetial?petitionInfoId=${petitionInfoId}&index=${index-1}<#else>javascript:void(0)</#if>">上页</a>
				<#list 1..pageCount as i>
					<a class="NumericPage <#if index+1 = i>cpb</#if>" href="${base}/petition/infoDetial?petitionInfoId=${petitionInfoId}&index=${i-1}">${i}</a>
				</#list>
				<a class="NextPage" href="<#if index lt pageCount-1>${base}/petition/infoDetial?petitionInfoId=${petitionInfoId}&index=${index+1}<#else>javascript:void(0)</#if>">下页</a>
				<a class="LastPage" href="<#if index lt pageCount-1>${base}/petition/infoDetial?petitionInfoId=${petitionInfoId}&index=${pageCount-1}<#else>javascript:void(0)</#if>">尾页</a>
			</div>
			<div class="btn">
				<#if editable??><#else>
					<#if isReplay??>
						<a href="${base}/petition/replay?petitionInfoId=${petitionInfoId}" style="margin-right:74px;" title="编写阅文批示">
							<img src="${base}/res/images/Petition/Inbox9_1.jpg" alt="编写阅文批示" />
						</a>
					</#if>
					<#if isRemark??>
						<a href="${base}/petition/remark?petitionInfoId=${petitionInfoId}" title="编写阅文批示">
							<img src="${base}/res/images/Petition/Inbox9_2.jpg" alt="编写阅文批示" />
						</a>
					</#if>
				</#if>
			</div>
		</div>
	</div>
	<@globe.footer backhref="${base}"/>
</div>
</body>
</html>
