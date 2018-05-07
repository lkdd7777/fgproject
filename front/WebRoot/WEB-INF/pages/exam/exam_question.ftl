<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<@globe.include title="在线考试"/>
<style type="text/css">
	#main{width:1002px;position:relative;}
	#main .title{width:1001px;height:58px;overflow:hidden;overflow:hidden;}
	#main .title img{display:block;width:1001px;height:58px;}
	
	#main .page{background:#fff;width:892px;padding:50px 55px 30px 55px;}
	#main .page h2.big_title{display:block;padding-left:39px;font-size:16px;font-family:Microsoft Yahei,'宋体';font-weight:normal;background:url(images/test/Consult01.jpg) no-repeat;height:73px;color:#4c4c4c;margin-bottom:20px;overflow:hidden;}
	
	#main .page ul{padding-left:21px;}
	#main .page ul li{height:40px;line-height:40px;overflow:hidden;font-size:14px;padding:8px 0px;}
	#main .page ul li span{line-height:40px;padding-left:31px;background-image:url(${base}/res/images/Test/check.png);cursor:pointer;display:inline-block;height:40px;background-repeat:no-repeat;background-position:left top;}
	
	#main .page ul li .input_box{width:154px;height:30px;padding:0px;border:1px solid #ccc;line-height:30px;float:left;color:#666;margin-right:40px;}
	#main .page ul li input#input_area{width:130px;height:28px;padding:0px 1px;line-height:30px;display:block;float:left;font-size:26px;color:#666;cursor:text;border:0px;text-align:right;}
	#main .page ul li div.area_div{float:left;height:30px;font-size:18px;width:20px;color:#666;overflow:hidden; line-height:38px;}
	#main .page ul li span.submit{background:url(${base}/res/images/btn/submit.jpg);height:32px;line-height:22px;padding:0px;width:99px;display:block;float:left;text-indent:-10000em;}
	#main .page ul li span.selected{background-position:left bottom;}
	#main .page .result{padding:11px 10px 11px 40px;}
	#main .page .result p{line-height:28px;font-size:16px;letter-spacing:1px;}
	#main .page .result p span{padding:0px 2px;color:#f1681a;font-size:24px;font-family:serif;font-weight:bold;}
	
	#main ul.step{width:892px;height:38px;overflow:hidden;background:#fff;padding:0px 55px 30px 55px;}
	#main ul.step li{width:14.2%;overflow:hidden;float:left;height:34px;border-bottom:4px solid #e3e3e6;color:#4c4c4c;text-align:center;font-size:14px;font-family:Microsoft Yahei,'宋体';line-height:34px;}
	#main ul.step li.selected{border-bottom:4px solid #1db0a3;}
	#main ul.step li span{float:right;}
	#main ul.step li a{color:#4c4c4c;cursor:pointer;}
	#main ul.step li a:hover{text-decoration:none;}
	#main .time_out{position:absolute;bottom:40px;left:390px;color:#1db0a3;font-size:14px;}
</style>
<script type="text/javascript">
	$(function(){
		/*$(".answer").click(function(){
			if($(this).hasClass("selected")){
				$(this).removeClass("selected");
			}else{
				$(this).addClass("selected");
			}
		});*/
		
		if('${question.type}'=='single' | '${question.type}'=='judge'){
			$(".answer").click(function(){
				if($(this).hasClass("selected")){
					$(this).removeClass("selected");
				}else{
					$(".answer").removeClass("selected");
					$(this).addClass("selected");
				}
				$("#hiddenValues").empty();
				addValues($(this).attr("data-rel"));
			});
		}else if('${question.type}'=='mutiple'){
			$(".answer").click(function(){
				if($(this).hasClass("selected")){
					$(this).removeClass("selected");
				}else{
					$(this).addClass("selected");
				}
				
				$("#hiddenValues").empty();
				$(".answer.selected").each(function(){
					addValues($(this).attr("data-rel"));
				})
			});
		}
		
		function addValues(value){
			$("#hiddenValues").append("<input type='hidden' name='answerIds' value='"+value+"'>");
		}
		
		var leftsecond = ${leftSecond};
		showCountDown();
		var countInterval=window.setInterval(function(){showCountDown();}, 1000);
		
		function showCountDown(){
			var day=Math.floor(leftsecond/(60*60*24));
			var hour=Math.floor((leftsecond-day*24*60*60)/3600); 
			var minute=Math.floor((leftsecond-day*24*60*60-hour*3600)/60); 
			var second=Math.floor(leftsecond-day*24*60*60-hour*3600-minute*60); 
			var dayStr="";
			if(day>0){
				dayStr=day+"天";
			}
			
			$("#timeLeftSpan").html(dayStr+hour+"小时"+minute+"分"+second+"秒");
			leftsecond--;
			
			if(leftsecond<0){
				window.clearInterval(countInterval); 
			}
		};
		 
		
	})
	
	function submitForm(){
		if($(".answer.selected").length>0){
			$('form').submit();
		}else{
			alert("请选择答案");
		}
	}
	
	
</script>
</head>
<body>
<div id="wrap">
	<@globe.header/>
	<div id="main">
		<div class="title">
			<img src="${base}/res/images/Test/title.jpg" alt="日程安排" />
		</div>
		<div class="page">
			<h2 class="big_title">${num}、${question.title}</h2>
			<ul>
				<#list answerList as item>
					<li><span class="answer<#if answerIds?seq_contains("${item.id}")> selected</#if>" data-rel="${item.id}">${character[item_index]}. ${item.content}</span></li>
				</#list>
			</ul>
		</div>
		<ul class="step clearfix">
			<li class="selected"><#if num gt 1><a href="${base}/exam/backToPre">上一题</a></#if></li>
			<li class="selected"></li>
			<li class="selected"></li>
			<li class="selected"></li>
			<li class="selected"></li>
			<li class="selected"></li>
			<li class="selected"><#if num lt 100><a href="javascript:submitForm();">下一题</a><#else><a href="${base}/exam/submitPaper">提交答卷</a></#if></li>
		</ul>
		<div class="time_out">距离考试结束还有：<span id="timeLeftSpan"></span></div>
		<form action="${base}/exam/submitAnswer" method="post">
			<input type="hidden" value="${question.paperQid}" name="paperQid">
			<input type="hidden" value="${question.id}" name="questionId">
			<input type="hidden" id="isSubmitHiddenVlaue" value="false" name="isSubmit">
			<div id="hiddenValues">
			</div>
		</form>
	</div>
	<@globe.footer backhref="${base}"/>
</div>
</body>
</html>
