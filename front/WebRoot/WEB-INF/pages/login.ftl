<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml"><head>
<title>登陆</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="robots" content="all" />
<link href="${base}/res/css/default.css" rel="stylesheet" type="text/css" />
<link href="${base}/res/css/page/login.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="${base}/res/js/jquery-1.8.2.min.js"></script>
<script type="text/javascript">
$(function(e) {
	$("#IsRemember").click(function(){
		var IsRemember = $(this)
		if(IsRemember.hasClass('checked'))
		{
			IsRemember.removeClass("checked");
			$("#LoginPage input.remember").val("false");
		}
		else
		{
			IsRemember.addClass("checked");
			$("#LoginPage input.remember").val("true");	
		}
	});
	$("#LoginPage .button").hover(
		function(){
			$(this).addClass("hover");
		},
		function(){
			$(this).removeClass("hover");
		}
	);
	
	$("#username").on("blur",function(){
		var userName=$("#username").val();
		if(userName=="libo" || userName=="zengzheng" || userName=="chenhao" || userName=="chenlong" || userName=="chenyan" || userName=="chenchi"){
			$("#photo").attr("src","${base}/userupload/usericon/"+userName+".jpg");
		}
	})
});
</script>
</head>
<body>
<div id="wrap">
	<div id="header">
		<img src="${base}/res/images/login/01.jpg" alt="武汉市房地产市场管理中心/武汉市住房专项维修资金管理中心 协同办公自动化系统" />
	</div>
	<div id="Login">
		<div id="imgspan">
			<img id="photo" src="${base}/userupload/usericon/default.jpg"/>
		</div>
		<form id="LoginPage" action="${base}/login/check" method="post">
			<input type="text" class="username" id="username" name="username" value="${username!}" />
			<input type="password" class="password" name="password" value="${password!}" />
			<input type="hidden" class="remember" name="rememberMe" />
			<input type="submit" class="login button" value=""/>
			<input type="reset" class="reset button" value=""/>
		</form>
		<div id="IsRemember">记住密码</div>
		<font color="red">${error!}</font>
	</div>
	<@globe.footer/>
</div>
</body>
</html>