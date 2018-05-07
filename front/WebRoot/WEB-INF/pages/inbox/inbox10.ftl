<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<@globe.include title="收文管理"/>
<script type="text/javascript">

	/*function LiClick(){
		if($("#main .list_box_1 li.selected").length > 0){
			$('#main .list_box_2 ul').html("");
			$("#main .list_box_1 li.selected").each(function(){
				var id = $(this).attr("data-rel");
				$.each(Data,function(index , val){
					if(val.userId == id)
					{
						$.each(val.orgs,function(index,subval){
							$('#main .list_box_2 ul').append("<li class='orglist' data-rel='"+subval.orgId+"'>" + subval.orgName + "</li>");  
						})
					}
				});
			});
			$('#main .list_box_2').show();
		}
		else
		{
			$('#main .list_box_2').hide();
			$('#main .list_box_2 ul').html("");
		}
	}*/
	
	
	$(function(){
		$.getJSON("${base}/inbox/viceDirectors", function(json){Data=json});
		$('#main .list_box li').live('click',function(){
			var This = $(this);
			if(This.hasClass('selected'))
			{
				This.removeClass('selected');
			}
			else
			{
				This.addClass('selected');
			}
			/*if(This.parents('.list_box_1').length > 0)
			{
				LiClick();
			}*/
		});
		
		$('#main .list_box_1 .select_All').live('click',function(){
			var This = $(this);
			if(This.hasClass('selected_All'))
			{
				This.removeClass('selected_All');
				$('#main .list_box_1 li').removeClass('selected');
			}
			else
			{
				This.addClass('selected_All');
				$('#main .list_box_1 li').addClass('selected');
			}
			//LiClick()
		});
		
		$('#main .list_box_2 .select_All').live('click',function(){
			var This = $(this);
			if(This.hasClass('selected_All'))
			{
				This.removeClass('selected_All');
				$('#main .list_box_2 li').removeClass('selected');
			}
			else
			{
				This.addClass('selected_All');
				$('#main .list_box_2 li').addClass('selected');
			}
		});
		
		$("input[type='submit']").on("click",function(){
			$(".orglist.selected").each(function(index,item){
				$("#hiddenValues").append("<input type='hidden' name='userId' value='"+$(item).attr("data-rel")+"'/>");
			});
			$(".userlist.selected").each(function(index,item){
				$("#hiddenValues").append("<input type='hidden' name='userId' value='"+$(item).attr("data-rel")+"'/>");
			});
		});
		
		$('#main .list_box_2').show();
	})

</script>
<style type="text/css">
#main{width:1002px;position:relative;}
#main .title{width:1001px;height:58px;overflow:hidden;overflow:hidden;}
#main .title img{display:block;width:1001px;height:58px;}

#main .bg{background:url(${base}/res/images/Inbox/Inbox10_1.jpg) 68px 65px no-repeat #fff;padding:65px 0 120px 319px;}
#main .list_box_1{border:2px solid #bbb5b5;width:242px;float:left;margin:0 40px 0 0;}
#main .list_box_2{border:2px solid #bbb5b5;width:242px;float:left;display:none;}
#main .list_box{background:#f5f5f5}
#main .list_box .top_btn{height:56px;background:url(${base}/res/images/Inbox/Inbox5_1.jpg) top center no-repeat #f5f5f5;cursor:pointer;border-bottom:1px solid #dfdfdf;}
#main .list_box ul{background:#f5f5f5;}
#main .list_box ul li{height:46px;overflow:hidden;line-height:46px;font-size:16px;border-bottom:1px solid #dfdfdf;cursor:pointer;background:url(${base}/res/images/Inbox/Inbox10_2.png) 40px -3px no-repeat;padding-left:70px;}
#main .list_box ul li.selected{background:url(${base}/res/images/Inbox/Inbox10_2.png) 40px -57px no-repeat #f5f5f5;}
#main .list_box .bottom_btn{height:56px;background:url(images/Inbox/Inbox5_3.jpg) top center no-repeat #f5f5f5;cursor:pointer;border-bottom:1px solid #dfdfdf;}
#main .list_box .select_All{text-align:center;color:#000;background:url(${base}/res/images/Inbox/Inbox10_2.png) 70px top no-repeat #f5f5f5;height:54px; line-height:54px;cursor:pointer;font-size:14px;}
#main .list_box .selected_All{background:url(${base}/res/images/Inbox/Inbox10_2.png) 70px bottom no-repeat #f5f5f5;}
#main .list_box .other{height:48px; line-height:48px;padding:0 0 0 25px;font-size:14px;color:#737373;font-weight:bold;background:#d9d9d9;}
#main .list_box .other input{border:0px;border-bottom:1px solid #878787;height:28px;line-height:24px;width:124px;background:#d9d9d9;padding:0;margin:0 0 0 5px;font-size:14px;color:#737373;text-align:center;font-weight:bold;}
#main .ul_box{position:relative;overflow:hidden;}

#main .list_box_1 ul{width:100%;}


#main .btn{padding:33px 0 0;height:38px;overflow:hidden;}
#main .btn a.cancel{display:block;float:left;width:130px;height:38px;overflow:hidden;margin-right:22px;}
#main .btn input.submit{display:block;float:left;width:130px;height:38px;overflow:hidden;padding:0px;border:0px;background:url(${base}/res/images/Inbox/Inbox5_5.jpg) no-repeat;cursor:pointer;}
</style>
</head>
<body>
<div id="wrap">
	<@globe.header/>
	<div id="main">
		<div class="title">
			<img src="${base}/res/images/Inbox/title.jpg" alt="日程安排" />
		</div>
		<div class="bg clearfix">
			<div class="clearfix">
				<div class="list_box_1 list_box">
					<div class="ul_box">
						<ul>
							<#list viceDirector as item>
								<li class="userlist" data-rel=${item.ID}>${item.realname}</li>
							</#list>
						</ul>
					</div>
					<div class="select_All">全选</div>
				</div>
				
				<div class="list_box_2 list_box">
					<div class="ul_box">
						<ul>
							<#list user as item>
								<li class='orglist' data-rel='${item.ID}'>${item.realname}</li>
							</#list>
						</ul>
					</div>
					<div class="select_All">全选</div>
				</div>
			</div>
			<div class="btn">
				<form action="${base}/inbox/saveChooseOrg" method="post">
					<div id="hiddenValues"></div>
					<input type="hidden" value="${inboxInfoId}" name="inboxInfoId"/>
					<a class="cancel" href="${base}/inbox/leaderReadList" title="取消"><img src="${base}/res/images/Inbox/Inbox5_4.jpg" /></a>
					<input type="submit" class="submit" value=" " />
				</form>
			</div>
		</div>
	</div>
	<@globe.footer backhref="${base}"/>
</div>
</body>
</html>
