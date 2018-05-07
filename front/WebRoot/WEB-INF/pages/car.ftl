<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<@globe.include title="车辆管理"/>
</head>
<style type="text/css">
#main{width:1002px;position:relative;}
#main .title{width:1001px;height:58px;overflow:hidden;overflow:hidden;padding:0 0 13px;}
#main .title img{display:block;width:1001px;height:58px;}

#main ul{padding:15px 0 0;}
#main ul li{float:left;width:312px;height:163px;margin-right:31px;overflow:hidden;margin-bottom:28px;padding:50px 0 0;}

#main ul li.li1{background:#55c5d0;}
#main ul li.li2{background:#4a2f8c;}
#main ul li.li3{margin-right:0px;background:#d64499;}
#main ul li.li4{background:#1eb0a3;}
#main ul li.li5{background:#268eed;}
#main ul li.li6{margin-right:0px;background:#e92d00;}
#main ul li.li7{background:#55c5d0;}

#main ul li h6{line-height:1.8em;font-size:34px;color:#fff;text-align:center;font-family:'微软雅黑','宋体',Arial, Helvetica, sans-serif;font-weight:normal;}
#main ul li p{line-height:1.8em;font-size:30px;color:#fff;text-align:center;font-family:'微软雅黑','宋体',Arial, Helvetica, sans-serif;}

</style>
</head>
<body>
<div id="wrap">
	<@globe.header/>
	<div id="main">
		<div class="title">
			<img src="${base}/res/images/car/title.jpg" alt="车辆管理" />
		</div>
        <ul class="clearfix">
        	<#list list as item>
        		<#if item_index lt 8>
		            <li class="li${item_index+1}">
		            	<h6>${item.carnum}</h6>
		                <p>${item.status}</p>
		            </li>
	            </#if>
        	</#list>
        </ul>
	</div>
	<@globe.footer backhref="${base}"/>
</div>
</body>
</html>
