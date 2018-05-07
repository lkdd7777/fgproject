<#assign shiro=JspTaglibs["/WEB-INF/tlds/shiro.tld"] />
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<@globe.include title="收文管理"/>
<link href="${base}/res/js/uploadify/uploadify.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="${base}/res/js/uploadify/jquery.uploadify.min.js"></script>
<style type="text/css">
#main{width:1002px;position:relative;}
#main .title{width:1001px;height:58px;overflow:hidden;overflow:hidden;}
#main .title img{display:block;width:1001px;height:58px;}

#main .submit{padding:73px 0 150px 86px;overflow:hidden;background:#fff;}
#main .input{background:url(${base}/res/images/Inbox/Inbox1_1.jpg) no-repeat;width:755px;height:63px;overflow:hidden; position:relative;}
#main .input a{display:block;width:162px;height:63px;overflow:hidden; position:absolute;right:0px;top:0px;text-indent:-10000em;}
#main .button{padding:62px 161px 0 0;}
#main input.click{display:block;background:url(${base}/res/images/Inbox/Inbox1_2.jpg) no-repeat;width:246px;overflow:hidden;height:63px;padding:0px;border:0px;cursor:pointer;float:left;}
#main .next{float:right;}
</style>
<script type="text/javascript">
	$(function(){
		$("#submitBtn").on("click",function(){alert("请先选择文件");return false;});
		//$("#nextBtn").attr("disabled","disabled").on("click",function(){alert("请先上传文件");});
		
		$("#fileUpload").on("change",function(){
			var _uploadFileName=$(this).val();
			var _nameArr=_uploadFileName.split(".");
			var _suffix=_nameArr[_nameArr.length-1];
			if(_suffix=="zip"){
				$("#filepath").html(_uploadFileName);
				$("#submitBtn").off().on("click",function(){$("form").submit();})
			}
			else{
				alert("请选择.zip格式的文件");
			}
		});
	})
</script>
</head>
<body>
<div id="wrap">
	<@globe.header/>
	<div id="main">
		<div class="title">
			<img src="${base}/res/images/Inbox/title.jpg" alt="日程安排" />
		</div>
		<div class="submit">
			<form action="${base}/inbox/sendUploadFile" enctype="multipart/form-data" method="post">
				<font color="red">${errorMsg!}</font>
				<div class="input">
					<a title="选择文件" href="javascript:void(0);" onclick="$('#fileUpload').click();">选择文件</a>
					<font id="filepath"></font>
				</div>
				<input type="file" id="fileUpload" name="file" style="display:none;">
				<div class="clearfix button">
					<input id="submitBtn" type="submit" value=" " class="click" />
					<#--<a class="next" id="nextBtn" href="javascript:void(0);" title="下一步">
						<img src="${base}/res/images/Inbox/Inbox1_3.jpg" alt="下一步" />
					</a>-->
				</div>
			</form>
		</div>
	</div>
	<@globe.footer backhref="${base}"/>
</div>
</body>
</html>
