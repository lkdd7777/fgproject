<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<@globe.include title="日程安排"/>
<link href="${base}/res/css/page/schedule.css" rel="stylesheet" type="text/css">
<script type="text/javascript">
	function pre(){
		var month=${cal.month};
		var year=${cal.year};
		if(month>1){
			month--;
		}else if(month==1){
			year--;
			month=12;
		}
		window.location='${base}/schedule?datetime='+year+'-'+month+'-1';
	}
	
	function next(){
		var month=${cal.month};
		var year=${cal.year};
		if(month<12){
			month++;
		}else if(month==12){
			year++;
			month=1;
		}
		window.location='${base}/schedule?datetime='+year+'-'+month+'-1';
	}
</script>
</head>
<body>
<div id="wrap">
	<@globe.header/>
	<div id="main">
		<div class="title">
			<img src="${base}/res/images/Schedule/title.jpg" alt="个人日程" />
		</div>
		<div class="box">
        	<#if goPre??><#if goPre><a class="left_btn" onclick="pre();">left</a></#if></#if>
            <#if goNext??><#if goNext><a class="right_btn" onclick="next();">right</a></#if></#if>
			<h2>${cal.year}年${cal.month}月</h2>
			<table id="Calendar">
				<tr>
					<th class="left">日</th>
					<th>一</th>
					<th>二</th>
					<th>三</th>
					<th>四</th>
					<th>五</th>
					<th class="right">六</th>
				</tr>
				<#assign day=1>
				<#assign startWeek=cal.startWeek>
				<#list 1..cal.weekNum as i>
					<tr>
						<#list 0..6 as j>
							<td class="<#if j=0>left </#if><#if j=6>right </#if><#if events?seq_contains(day)><#if day=1 && startWeek=j+1>events <#elseif day gt 1>events </#if></#if>" 
								onclick="window.location='${base}/schedule?datetime=${cal.year}-<#if cal.month lt 10>0${cal.month}<#else>${cal.month}</#if>-<#if day lt 10>0${day}<#else>${day}</#if>'">
								<span class="<#if j=0>left </#if> <#if j=6>right </#if>
											<#if cal.current=day><#if day=1 && startWeek=j+1>current <#elseif day gt 1>current </#if></#if>
											<#if queryDay??><#if queryDay gt 0 && cal.current!=queryDay><#if queryDay=day><#if day=1 && startWeek=j+1>queryDay <#elseif day gt 1>queryDay </#if></#if></#if></#if>">
									<#if startWeek=j+1 || (day gt 1 && day lte cal.max)>${day}<#assign day=day+1><#assign startWeek=100></#if>
								</span>
							</td>
						</#list>
					</tr>
				</#list>
			</table>
			<ul>
				<#list schedules as schedule>
					<li>
						<div class="in_time">${schedule.noon}　${schedule.time}</div>
						<table class="Schedule">
							<tr>
								<th class="th1">地点</th>
								<th class="th2">内容</th>
								<th class="th3">参加领导及部门</th>
								<th class="th4">组织部门</th>
							</tr>
							<tr>
								<td class="td1">${schedule.address}</td>
								<td class="td2">${schedule.content}</td>
								<td class="td3">${schedule.departName}</td>
								<td class="td4">${schedule.masterDepartName}</td>
							</tr>
						</table>
					</li>
				</#list>
			</ul>
		</div>
	</div>
    <div class="btn">
    	<a title="请(休)假申请" href="${base}/schedule/leavePage" target="_blank"><img src="${base}/res/images/Schedule/btn01.jpg" alt="请(休)假申请" /></a>
    </div>
	<@globe.footer backhref="${base}"/>
</div>
</body>
</html>
