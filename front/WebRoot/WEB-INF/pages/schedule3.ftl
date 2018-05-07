<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<@globe.include title="日程安排（请休假）"/>
<script type="text/javascript" src="${base}/res/js/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript">
	$(document).ready(function(e) {
        $('#main .bg .box2 ul li').click(function(){
			$(this).addClass('on');
			$(this).siblings('li').removeClass('on');
			$('input.typeDesc').val($(this).text());
			$('input.type').val($(this).attr('data-rel'));
			if($(this).text() == '其他'){
				$('input.typeDesc').val("");
				$('input.other_text').attr('readonly',false);
				$('input.other_text').change(function(){
					$('input.typeDesc').val($(this).val());
				})
			}else
			{
				$('input.other_text').val('').attr('readonly',true);
			}
		});
		
		$("form").submit(function(){
			if($.trim($('#datatime1').val())=="" || $.trim($('#datatime2').val())==""){
				alert("请正确填写请假时间");
				return false;
			}
			
			if($.trim($('input.typeDesc').val())==""){
				alert("请选择或填写请假事由");
				return false;
			}
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
#main .bg .box1 *{float:left;margin-right:10px; line-height:40px;color:#454545;font-size:18px;}
#main .bg .box1 input.time1{padding:0 10px;width:220px;font-size:20px;color:#454545;height:40px;line-height:40px;border:1px solid #f4edd1;text-align:center;font-family:'微软雅黑','宋体',Arial, Helvetica, sans-serif;background:#f4edd1;}
#main .bg .box1 input.time2{padding:0 10px;width:220px;font-size:20px;color:#454545;height:40px;line-height:40px;border:1px solid #f4edd1;text-align:center;font-family:'微软雅黑','宋体',Arial, Helvetica, sans-serif;background:#f4edd1;}
#main .bg .box1 input.checkbox{margin:0px;margin:14px 5px 0 20px;padding:0px;width:15px;height:15px;border:1px solid #454545;background:eee;display:block;font-family:'微软雅黑','宋体',Arial, Helvetica, sans-serif;cursor:pointer;}

#main .bg .box2{padding:10px 0 30px 10px;position:relative;}
#main .bg .box2 ul li{float:left;width:179px;height:71px;line-height:72px;overflow:hidden;font-family:'微软雅黑','宋体',Arial, Helvetica, sans-serif;background:url(${base}/res/images/Schedule/bg1.jpg) no-repeat;text-align:center;font-size:20px;margin-right:45px;margin-bottom:40px;cursor:pointer;overflow:hidden;color:#fff;}
#main .bg .box2 ul li.on{background:url(${base}/res/images/Schedule/bg2.jpg) no-repeat;}

#main .bg .box2 input.other_text{width:615px;border:0px;border-bottom:1px solid #454545;padding:0px;font-size:20px;font-family:'微软雅黑','宋体',Arial, Helvetica, sans-serif;margin:0px;position:absolute;top:277px;right:45px;cursor:pointer;}

#main .bg .submit{display:block;margin:0 auto;width:251px;height:64px;overflow:hidden;background:url(${base}/res/images/Schedule/btn02.jpg) no-repeat;border:0px;padding:0px;cursor:pointer;}
</style>
</head>
<body>
<div id="wrap">
	<@globe.header/>
	<div id="main">
		<div class="title">
			<img src="${base}/res/images/Schedule/title3.jpg" alt="日程安排（请休假）" />
		</div>
		<div class="bg">
			<form action="${base}/schedule/submitLeaveInfo" method="post">
				<div class="box1 clearfix"><#if errorMsg??>${errorMsg}</#if></div>
            	<h5>请假起止时间：</h5>
            	<div class="box1 clearfix">
                	<input type="text" name="startDate" id="datatime1" class="time1" onfocus="var datatime2=$dp.$('datatime2');WdatePicker({onpicked:function(){datatime2.focus();},dateFmt:'yyyy-MM-dd',minDate:'%y-%M-%d',maxDate:'#F{$dp.$D(\'datatime2\')}'})" value="" />
                    <span>---</span>
                    <input type="text" name="endDate" id="datatime2" class="time2" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd',minDate:'#F{$dp.$D(\'datatime1\')}'})" value="" />
                    <input type="checkbox" class="checkbox" name="isHalfDay" value="true" />
                    <span>半天</span>
                </div>
                <h5>请假事由：</h5>
                <div class="box2">
                	<ul class="clearfix">
                    	<li data-rel="1">年休假</li>
                        <li data-rel="2">病假</li>
                        <li data-rel="3">事假</li>
                        <li style="margin-right:0px;" data-rel="4">婚假</li>
                        <li data-rel="5">产假</li>
                        <li data-rel="6">哺乳假</li>
                        <li data-rel="7">丧假</li>
                        <li style="margin-right:0px;" data-rel="8">探亲假</li>
                        <li data-rel="9">其他</li>
                    </ul>
                    <input type="hidden" class="typeDesc" value="" name="typeDesc"/>
                    <input type="hidden" class="type" value="" name="type"/>
                    <input type="text" class="other_text" name="otherDesc" readonly="readonly" value="" />
                </div>
                <input type="submit" value=" " class="submit" />
            </form>
		</div>        
	</div>
	<@globe.footer backhref="${base}"/>
</div>
</body>
</html>
