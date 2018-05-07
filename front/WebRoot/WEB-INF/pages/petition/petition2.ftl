<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<@globe.include title="信访管理"/>
<style type="text/css">
#main{width:1002px;position:relative;}
#main .title{width:1001px;height:58px;overflow:hidden;overflow:hidden;}
#main .title img{display:block;width:1001px;height:58px;}

#main .link{background:url(${base}/res/images/Petition/Inbox2_1.jpg) no-repeat;width:416px;height:63px;overflow:hidden;margin:0 auto; position:relative;}
#main .link .left{display:block;width:256px;overflow:hidden;height:63px; position:absolute;left:0px;top:0px;text-indent:-10000em;}
#main .link .right{display:block;width:160px;overflow:hidden;height:63px; position:absolute;right:0px;top:0px;text-indent:-10000em;}
#main .bg{background:#fff;padding:73px 0 150px 0;}
</style>
</head>
<body>
<div id="wrap">
	<@globe.header/>
	<div id="main">
		<div class="title">
			<img src="${base}/res/images/Petition/title.jpg"/>
		</div>
		<div class="bg">
			<div class="link">
				<a class="left" href="${base}/petition/handleDocPage?subFileFolder=${subFileFolder}">点击处理文件</a>
				<a class="right" href="javascript:void(0)">点击提交</a>
			</div>
		</div>
	</div>
	<@globe.footer backhref="${base}"/>
</div>
</body>
</html>
