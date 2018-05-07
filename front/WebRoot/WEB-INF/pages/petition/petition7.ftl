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

#main .bg{padding:39px 0 60px;}
#main .bg table{width:100%;border-bottom:4px solid #d1d1d1;background:#f9f9f9;}
#main .bg table th{background:url(${base}/res/images/Announcement/bg.jpg) left bottom repeat-x;height:48px;padding:0 0 2px 0;color:#b4b4b4;font-size:14px;line-height:48x;font-weight:bold;}
#main .bg table th.th1{padding:0 0 0 49px;width:444px;overflow:hidden;}
#main .bg table th.th3{width:140px;overflow:hidden;}
#main .bg table th.th5{width:140px;overflow:hidden;}
#main .bg table th.th2{width:140px;overflow:hidden;}
#main .bg table th.th4{width:137px;overflow:hidden;}

#main .bg table td{color:#000;font-size:14px;line-height:24x;padding:12px 0;border-bottom:1px solid #dbdbdb;}
#main .bg table td.td1{padding-left:49px;width:664px;overflow:hidden;}
#main .bg table td.td2{width:200px;overflow:hidden;}
#main .bg table td.td4{width:137px;overflow:hidden;}

#main .btn{padding:43px 0 0 342px;height:49px;overflow:hidden;}
#main .btn a{display:block;height:49px;width:151px;overflow:hidden;float:left;margin:0 30px 0 0;}
</style>
</head>
<body>
<div id="wrap">
	<@globe.header/>
	<div id="main">
		<div class="title">
			<img src="${base}/res/images/Petition/title4.jpg" alt="信访管理" />
		</div>
		<div class="bg">
			<table>
				<tr>
					<th class="th1">信访来件标题</th>
					<th class="th3">进度阶段</th>
					<th class="th5">时间</th>
					<th class="th2"></th>
					<th class="th4">　</th>
				</tr>
				<#list petitionInfoList as info>
					<tr>
						<td class="td1">${info.title}<#if info.replyed??><font color="red"> (答复)</font></#if></td>
						<td class="td2">
							<#if info.isReaded??>
								<#if info.isReaded == 0>
									<font color="red">[未读]</font>
								<#else>
									<font color="green">[已读]</font>
								</#if>
							</#if>
							<#if info.statusInfo??>${info.statusInfo}<#else>-</#if>
						</td>
						<td class="td3">${info.submitDate?string("yy年MM月dd日")}</td>
						<td class="td4">
							<#if info.active =0>
								<a href="${base}/petition/infoDetial?petitionInfoId=${info.id}" title="查看">
									<img src="${base}/res/images/Inbox/Inbox8_1.jpg" alt="阅读文件" />
								</a>
							</#if>
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
