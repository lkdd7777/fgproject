<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<@globe.include title="在线考试"/>
<style type="text/css">
#main{width:1002px;position:relative;}
#main .title{width:1001px;height:58px;overflow:hidden;overflow:hidden;}
#main .title img{display:block;width:1001px;height:58px;}

#main .page{background:#fff;width:892px;padding:50px 55px 100px 55px;}
#main .page .bg{width:854px;margin:0 auto;}
#main .page .bg h5{color:#454545;font-family:'微软雅黑','宋体';text-align:center;font-size:22px;font-weight:normal;}
#main .page .bg p{line-height:2em;padding:10px 0;text-indent:2em;color:#454545;}
#main .page .btn{padding-top:30px;text-align:center;}
#main .page .btn a{cursor:pointer;}

</style>
</head>
<body>
<div id="wrap">
	<@globe.header/>
	<div id="main">
		<div class="title">
			<img src="${base}/res/images/Test/title.jpg" alt="在线考试" />
		</div>
		<div class="page">
			<div class="bg">
				<h5>${title}</h5>
				${info.content}
			</div>
			<div class="btn">
				<a href="${base}/${redirecUrl}"><img src="${base}/res/images/Test/Test04.jpg" alt="我已阅读并接受" /></a>
			</div>
		</div>
	</div>
	<@globe.footer backhref="${base}"/>
</div>
</body>
</html>
