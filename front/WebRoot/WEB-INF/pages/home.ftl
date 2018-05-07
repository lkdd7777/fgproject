<#assign shiro=JspTaglibs["/WEB-INF/tlds/shiro.tld"] />
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<@globe.include title="控制面板"/>
	<link href="${base}/res/css/page/home.css" rel="stylesheet" type="text/css">
	<script type="text/javascript">
		$(function(){
			$.get("${base}/index/getWeatherInfo",function(data){
				if(data.success){
					$("#dateDiv").html(data.date);
					$("#weatherIcon").attr("src","${base}/res/images/weather/"+data.pictureUrl);
					$("#weatherDiv").html(data.weather+"<br>"+data.wind);
					$("#pm25Div").html(data.pm25);
					$("#tempDiv").html(data.temperature);
				}else{
					$(".section01").html("<font color='white'>抱歉，获取天气数据失败，请检查网络...</font>");
				}
			})
			
			function getUserOaInfo(){
				$.get("${base}/index/getUserOaData",function(data){
					if(data){
						if(data.announceNum && data.announceNum>0){
							if($("#announceSpan").length < 1){
								$(".section02").append('<span id="announceSpan">'+data.announceNum+'</span>');
							}else{
								$("#announceSpan").html(data.announceNum);
							}
						}
						if(data.petitionNum && data.petitionNum>0){
							if($("#petitionSpan").length < 1){
								$(".section03").append('<span id="petitionSpan">'+data.petitionNum+'</span>');
							}else{
								$("#petitionSpan").html(data.petitionNum);
							}
						}
						if(data.inboxNum && data.inboxNum>0){
							if($("#inboxSpan").length < 1){
								$(".section04").append('<span id="inboxSpan">'+data.inboxNum+'</span>');
							}else{
								$("#inboxSpan").html(data.inboxNum);
							}
						}
						if(data.postNum && data.postNum>0){
							if($("#postSpan").length < 1){
								$(".section05").append('<span id="postSpan">'+data.postNum+'</span>');
							}else{
								$("#postSpan").html(data.postNum);
							}
						}
						if(data.scheduleNum && data.scheduleNum>0){
							if($("#scheduleSpan").length < 1){
								$(".section07").append('<span id="scheduleSpan">'+data.scheduleNum+'</span>');
							}else{
								$("#scheduleSpan").html(data.scheduleNum);
							}
						}
						if(data.conferenceNum && data.conferenceNum>0){
							if($("#conferenceSpan").length < 1){
								$(".section05").append('<span id="conferenceSpan">'+data.conferenceNum+'</span>');
							}else{
								$("#conferenceSpan").html(data.conferenceNum);
							}
						}
					}
				});
			}
			
			setInterval(getUserOaInfo, 1000); 
		})
	</script>
</head>
<body>
	<div id="wrap">
		<@globe.header/>
		<div id="main">
			<div class="section01">
				<div id="dateDiv" class="date">
				</div>
				<div class="ico">
					<img id="weatherIcon" style="width:80%;" src="" />
				</div>
				<div id="tempDiv" class="temperature">
					28～23℃
				</div>
				<div class="weather" id="weatherDiv">
				</div>
				<div class="airQuality">
					pm2.5：
					<div id="pm25Div" class="num_bg"></div>
				</div>
			</div>
			<div class="section02">
				<a href="${base}/announcement" title="工作安排">工作安排</a>
				<#if announceNum gt 0><span id="announceSpan">${announceNum}</span></#if>
			</div>
	        <div class="section02_sub">
	        	<a href="${base}/schedule" title="个人日程">个人日程</a>
				<#if scheduleNum gt 0><span id="scheduleSpan">${scheduleNum}</span></#if>
			</div>
			<div class="section03">
				<a href="${base}${inboxUrl}" title="收文管理">收文管理</a>
				<#if inboxNum gt 0><span id="inboxSpan">${inboxNum}</span></#if>
			</div>
			<div class="section04">
				<a href="${base}${postUrl}" title="发文管理">发文管理</a>
				<#if postNum gt 0><span id="postSpan">${postNum}</span></#if>
			</div>
			<div class="section05">
				<a href="${base}${petitionUrl}" title="信访管理">信访管理</a>
				<#if petitionNum gt 0><span id="petitionSpan">${petitionNum}</span></#if>
			</div>
			<div class="section06">
				<a href="${base}/conference" title="会议室管理">会议室管理</a>
				<#if conferenceNum gt 0><span id="conferenceSpan">${conferenceNum}</span></#if>
			</div>
			<div class="section07">
				<a href="${base}/contacts" title="通讯录">通讯录</a>
			</div>
			<div class="section08">
				<a href="${base}/car" title="车辆管理">车辆管理</a>
			</div>
			<div class="section09">
				<a href="${base}/business" title="业务系统">业务系统</a>
			</div>
			<div class="section10">
				<a href="${base}/exam/index" title="在线考试">在线考试</a>
			</div>
			<#--<div class="section11">
				<a href="${base}/logout" title="退出登录">退出登录</a>
			</div>
			<ul class="section12">
				<li class="li1">
					<a href="#" title="发文台账">发文台账</a>
				</li>
				<li class="li2">
					<a href="#" title="收文台账">收文台账</a>
				</li>
				<li class="li3">
					<a href="#" title="人事管理">人事管理</a>
				</li>
				<li class="li4">
					<a href="#" title="设备管理">设备管理</a>
				</li>
				<li class="li5">
					<a href="#" title="办公用品管理">办公用品管理</a>
				</li>
			</ul>-->
		</div>
		<@globe.footer/>
	</div>
</body>
</html>
