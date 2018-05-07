<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<@globe.include title="信访管理"/>
<script type="text/javascript">
	$(function(e) {
		$('#main .list_box ul li').click(function(){
			$(this).addClass('selected');
			$(this).siblings('li').removeClass('selected');
			$("input.msg").val($(this).attr("data-rel"));
		});
		$("input.msg").val($('.selected').attr("data-rel"));
	});
</script>
<style type="text/css">
#main{width:1002px;position:relative;}
#main .title{width:1001px;height:58px;overflow:hidden;overflow:hidden;}
#main .title img{display:block;width:1001px;height:58px;}

#main .bg{background:url(${base}/res/images/Petition/Inbox4_1.jpg) 156px 65px no-repeat #fff;padding:65px 0 120px 428px;}
#main .list_box{border:2px solid #bbb5b5;width:327px;}
#main .list_box .top_btn{height:56px;background:url(${base}/res/images/Inbox/Inbox5_1.jpg) top center no-repeat #f5f5f5;cursor:pointer;border-bottom:1px solid #dfdfdf;}
#main .list_box ul{background:#f5f5f5;}
#main .list_box ul li{height:46px;overflow:hidden;line-height:46px;font-size:16px;text-align:center;border-bottom:1px solid #dfdfdf;cursor:pointer;}
#main .list_box ul li.selected{background:url(${base}/res/images/Inbox/Inbox5_2.jpg) 240px 11px no-repeat;}

#main .list_box .bottom_btn{height:56px;background:url(${base}/res/images/Inbox/Inbox5_3.jpg) top center no-repeat #f5f5f5;cursor:pointer;}
#main .btn{padding:33px 0 0;height:38px;overflow:hidden;}
#main .btn a.cancel{display:block;float:left;width:130px;height:38px;overflow:hidden;margin-right:22px;}
#main .btn input.submit{display:block;float:left;width:130px;height:38px;overflow:hidden;padding:0px;border:0px;background:url(${base}/res/images/Petition/Inbox5_5.jpg) no-repeat;cursor:pointer;}
</style>
</head>
<body>
<div id="wrap">
	<@globe.header/>
	<div id="main">
		<div class="title">
			<img src="${base}/res/images/Petition/title.jpg" alt="日程安排" />
		</div>
		<div class="bg">
			<div class="list_box">
				<div class="top_btn"></div>
				<ul>
					<#list leaders as item>
						<li <#if item_index = 0>class="selected"</#if> data-rel="${item.ID}">${item.realname}</li>
					</#list>
				</ul>
				<div class="bottom_btn"></div>
			</div>
			<div class="btn">
				<form action="${base}/petition/saveLeaderInfo" method="post">
					<input class="msg" name="leaderId" type="hidden" value="" />
					<input name="petitionInfoId" type="hidden" value="${petitionInfoId}" />
					<a class="cancel" href="#" title="取消"><img src="${base}/res/images/Inbox/Inbox5_4.jpg" /></a>
					<input type="submit" class="submit" value=" " />
				</form>
			</div>
		</div>
	</div>
	<@globe.footer backhref="${base}"/>
</div>
</body>
</html>
