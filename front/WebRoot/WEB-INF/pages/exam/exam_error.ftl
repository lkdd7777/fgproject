<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<@globe.include title="在线考试"/>
<style type="text/css">
	#main{width:1002px;position:relative;}
	#main .title{width:1001px;height:58px;overflow:hidden;overflow:hidden;}
	#main .title img{display:block;width:1001px;height:58px;}
	
	#main .page{background:#fff;width:892px;padding:50px 55px 100px 55px;}
	#main .page .bg{width:854px;height:270px;margin:0 auto;position:relative;}
	#main .page .bg h5{ position:absolute;color:#4c4c4c;top:89px;left:335px;}
	
	#main .btn input{display:block;width:200px;height:60px;overflow:hidden;margin-right:22px;cursor:pointer;padding:0px;border:0px;}
	#main .btn input.submit{background:url(${base}/res/images/Test/start.jpg) no-repeat;}
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
				<h5>
					${message!}
				</h5>
			</div>
		</div>
	</div>
	<@globe.footer backhref="${base}"/>
</div>
</body>
</html>
