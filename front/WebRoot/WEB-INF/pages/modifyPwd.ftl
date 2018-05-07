<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<@globe.include title="修改密码"/>
<link href="${base}/res/js/alert/sweetalert.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="${base}/res/js/alert/sweetalert.min.js"></script>
<script type="text/javascript">
	$(function(){
		$("form").submit(function(){
			var _orginalPwd=$("input[name='orginalPwd']").val();
			var _newPwd=$("input[name='newPwd']").val();
			var _newPwdRp=$("input[name='newPwdRp']").val();
			
			if($.trim(_orginalPwd) == ""){
				swal("原始密码不能为空");
				return false;
			}
			
			if($.trim(_newPwd) == ""){
				swal("设置的密码不能为空");
				return false;
			}
			
			if($.trim(_newPwd).length < 6){
				swal("密码长度最少为六位数字或字母组成");
				return false;
			}
			
			if($.trim(_newPwdRp) == "" || (_newPwdRp != _newPwd)){
				swal("两次输入的密码不一致")
				return false;
			}
			
			$.ajax({
				url:"${base}/modifyPwd",
				type:"POST",
				data:{"orginalPwd":_orginalPwd,"newPwd":_newPwd},
				success:function(data){
					if(data.errorMsg){
						swal(data.errorMsg, "", "error");
					}else{
						swal({
							title: "密码修改成功！",
							text: "请重新登录",
							type: "success",
							showCancelButton: false,
							confirmButtonText: "OK", 
							closeOnConfirm: false 
						}, function(){
							window.location="${base}/logout";
						});
					}
				}
			});
			
			return false;
			
		});
    });
</script>
<style type="text/css">
#main{width:1002px;position:relative;}
#main .title{width:1001px;height:58px;overflow:hidden;overflow:hidden;}
#main .title img{display:block;width:1001px;height:58px;}

#main .bg{padding:39px 50px 30px;background:#fff;font-family:'微软雅黑','宋体',Arial, Helvetica, sans-serif;}
#main .bg h5{font-family:'微软雅黑','宋体',Arial, Helvetica, sans-serif;color:#454545;padding:0 0 20px;font-size:24px;overflow:hidden;font-weight:normal;}
#main .bg .box1{padding:10px 10px 30px;}
#main .bg .box1 {margin-right:10px; line-height:40px;color:#454545;font-size:18px;}
#main .bg .box1 input.textfield{padding:0 10px;margin:10px 0;width:400px;font-size:20px;color:#454545;height:40px;line-height:40px;border:1px solid #f4edd1;text-align:center;font-family:'微软雅黑','宋体',Arial, Helvetica, sans-serif;background:#f4edd1;}
#main .bg .clear{clear:both;}

#main .bg .submit{display:block;margin:0 auto;width:251px;height:64px;overflow:hidden;background:url(${base}/res/images/Home/btn02.jpg) no-repeat;border:0px;padding:0px;cursor:pointer;}
</style>
</head>
<body>
<div id="wrap">
	<@globe.header/>
	<div id="main">
		<div class="title">
			<img src="${base}/res/images/Home/modifypwd.jpg" alt="日程安排（请休假）" />
		</div>
		<div class="bg">
			<form action="" method="post">
            	<div class="box1 clearfix">
                	<span>原始密码：</span><input type="password" name="orginalPwd" class="textfield" value="" />
                	
                	<div class="clear"></div>
                	<span>设置密码：</span><input type="password" name="newPwd" class="textfield" value="" />
					<div class="clear"></div>
                	<span>重复确认：</span><input type="password" name="newPwdRp" class="textfield" value="" />
                </div>
                <input type="submit" value=" " class="submit" />
            </form>
		</div>        
	</div>
	<@globe.footer backhref="${base}"/>
</div>
</body>
</html>
