<#assign shiro=JspTaglibs["/WEB-INF/tlds/shiro.tld"]/>
﻿<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<@globe.include title="发文管理"/>
<link href="${base}/res/css/page/post.css" rel="stylesheet" type="text/css" />
<link href="${base}/res/js/uploadify/uploadify.css" rel="stylesheet" type="text/css">
<script type="text/javascript" charset="utf-8" src="${base}/res/js/ueditor/ueditor.config.js"></script>
<script type="text/javascript" charset="utf-8" src="${base}/res/js/ueditor/ueditor.all.min.js"></script>
<script type="text/javascript" charset="utf-8" src="${base}/res/js/ueditor/lang/zh-cn/zh-cn.js"></script>
<link href="${base}/res/js/fancy/jquery.fancybox.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="${base}/res/js/fancy/jquery.fancybox.pack.js"></script>
<script type="text/javascript" src="${base}/res/js/uploadify/jquery.uploadify.min.js"></script>
<script type="text/javascript">
	$(function(){
		UEDITOR_CONFIG.UEDITOR_HOME_URL="${base}/res/js/ueditor/";
		UEDITOR_CONFIG.initialStyle="body{font-size:12px;}"
		
		if($("#richtxt-case").size()>0){
			var editor=UE.getEditor('richtxt-case',{
			});
			editor.ready(function(){
				$(".edui-editor").css("width","auto");
			})
			editor.addListener('contentChange',function(ed){
				$("#richtxt").val(editor.getContent());
			});
		}else{
			$("#richtxt").show();
		}
		
		 $("#uploadify").uploadify({
            //指定swf文件
            'swf': '${base}/res/js/uploadify/uploadify.swf',
            //后台处理的页面
            'uploader': '${base}/file/uploadFile?id=${postInfoId}&type=1',
            //按钮显示的文字
            'buttonText': '上传附件',
            //显示的高度和宽度，默认 height 30；width 120
            //'height': 15,
            //'width': 80,
            //上传文件的类型  默认为所有文件    'All Files'  ;  '*.*'
            //在浏览窗口底部的文件类型下拉菜单中显示的文本
            //'fileTypeDesc': 'Image Files',
            //允许上传的文件后缀
            'fileTypeExts': '*.gif; *.jpg; *.png;*.doc;*.docx;*.xls;*.xlsx;*.zip;*.rar',
            //发送给后台的其他参数通过formData指定
            'formData': { 'id': '${postInfoId}', 'type': 1 },
            //上传文件页面中，你想要用来作为文件队列的元素的id, 默认为false  自动生成,  不带#
            //'queueID': 'fileQueue',
            //选择文件后自动上传
            'auto': true,
            //设置为true将允许多文件上传
            'multi': true,
            'onAllComplete'  :function(event,data)  {
            	alert("附件上传成功！");
            }
        });
        
        $("a#selector").fancybox();
        $('.list_box ul li').click(function(){
			$(this).toggleClass('selected');
			$("#param").empty();
			
			$('.list_box .selected').each(function(){
				$("#param").append('<input type="hidden" name="user" value="'+$(this).attr("data-rel")+'" >');
			});
		});
	})
	
	function submitApproval(){
		$('form').attr('action','${base}/post/approvePost').submit();
	}
</script>
<style type="text/css">
.list_box{border:2px solid #bbb5b5;width:327px;}
.list_box .top_btn{height:56px;background:url(${base}/res/images/Inbox/Inbox5_1.jpg) top center no-repeat #f5f5f5;cursor:pointer;border-bottom:1px solid #dfdfdf;}
.list_box ul{background:#f5f5f5;}
.list_box ul li{height:46px;overflow:hidden;line-height:46px;font-size:16px;border-bottom:1px solid #dfdfdf;cursor:pointer;background:url(${base}/res/images/Inbox/Inbox10_2.png) 110px -3px no-repeat;text-align:center;}
.list_box ul li.selected{background:url(${base}/res/images/Inbox/Inbox10_2.png) 110px -57px no-repeat #f5f5f5;}
.list_box .bottom_btn{margin-left:15%;margin-top:10px;height:56px;background:url(${base}/res/images/Inbox/Inbox5_3.jpg) top center no-repeat #f5f5f5;cursor:pointer;}
</style>
</head>
<body>
<div id="wrap">
	<@globe.header/>
	<div id="main">
		<#include "title.ftl">
		<div class="bg">
			<font color="red">${errorMsg!}</font>
			<input type="file" name="uploadify" id="uploadify" />
			<form action="${base}/post/approvePost" method="post">
				<div class="content">
					<div id="richtxt-case" style="height:400px;"></div>
					<textarea style="display:none;" id="richtxt"  name="content"></textarea>
				</div>
				<div class="btn">
					<input type="hidden" value="${postInfoId}" name="postInfoId"/>
					<!--
					<a href="javascript:void(0)" onclick="$('form').submit();">
						<img src="${base}/res/images/Posting/Posting1-01.jpg" alt="" />
					</a>
					-->
					<a id="selector" href="#selectDirectorDiv">
						<img src="${base}/res/images/Posting/Posting1-01.jpg" alt="" />
					</a>
				</div>
				
				<div id="selectDirectorDiv" class="list_box" style="display:none;">
					<div class="top_btn"></div>
					<ul>
						<#list user as item>
							<#if item.realname == '党支部1'>
							<#elseif  item.realname == '党支部2'>
							<#elseif  item.realname == '团支部'>
							<#elseif  item.realname == '工会主席'>
							<#else>
								<li data-rel="${item.ID}">${item.realname}</li>
							</#if>
							
						</#list>
					</ul>
					<div class="bottom_btn">
						<a href="#" onclick="submitApproval()">
							<img src="${base}/res/images/Petition/Inbox12_2.jpg" alt="" />
						</a>
					</div>
				</div>
				<div id="param" style="display:none;"></div>
			</form>
		</div>
	</div>
	<@globe.footer backhref="${base}"/>
</div>
</body>
</html>
