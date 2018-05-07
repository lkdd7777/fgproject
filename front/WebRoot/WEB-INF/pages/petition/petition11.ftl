<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<@globe.include title="信访管理"/>
<style type="text/css">
#main{width:1002px;position:relative;}
#main .title{width:1001px;height:58px;overflow:hidden;overflow:hidden;}
#main .title img{display:block;width:1001px;height:58px;}

#main .submit{padding:73px 0 150px 86px;overflow:hidden;background:#fff;}
#main .input{background:url(${base}/res/images/Inbox/Inbox1_1.jpg) no-repeat;width:755px;height:63px;overflow:hidden; position:relative;}
#main .input a{display:block;width:162px;height:63px;overflow:hidden; position:absolute;right:0px;top:0px;text-indent:-10000em;}
#main .button{padding:62px 161px 0 0;}
#main input.click{display:block;background:url(${base}/res/images/Petition/Inbox11_1.jpg) no-repeat;width:246px;overflow:hidden;height:63px;padding:0px;border:0px;cursor:pointer;float:left;}
#main .next{float:right;}
</style>
</head>
<body>
<div id="wrap">
	<@globe.header/>
	<div id="main">
		<div class="title">
			<img src="${base}/res/images/Petition/title.jpg" alt="信访管理" />
		</div>
		<div class="submit">
			<form>
				<div class="input">
					<a title="选择文件" href="javascript:void(0);">选择文件</a>
				</div>
				<div class="clearfix button">
				<input type="submit" value=" " class="click" />
				<a class="next" href="Petition2.html" title="下一步">
					<img src="${base}/res/images/Petition/Inbox1_3.jpg" alt="下一步" />
				</a>
				</div>
			</form>
		</div>
	</div>
	<@globe.footer backhref="${base}"/>
</div>
</body>
</html>
