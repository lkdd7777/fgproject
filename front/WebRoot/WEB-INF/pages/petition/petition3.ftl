<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<@globe.include title="信访管理"/>
<link href="${base}/res/js/uploadify/uploadify.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" type="text/css" href="${base}/res/js/fancybox/jquery.thumbox.1.2.css" />
<script type="text/javascript" src="${base}/res/js/fancybox/jquery.easing.1.3.js"></script>
<script type="text/javascript" src="${base}/res/js/fancybox/jquery.thumbox.1.2.js"></script>
<script type="text/javascript" src="${base}/res/js/uploadify/jquery.uploadify.min.js"></script>
<script type="text/javascript">
	$(document).ready(function(e) {
		$('#read_box').click(function(){
			$('#img_box a:first').trigger("click");
			return false;
		});
		$('#img_box').thumbox({maxThumbHeight:100});
		
		$("#submitForm").submit(function(){
			/*var tag=true;
			$(".require").each(function(){
				if($.trim($(this).val())==""){
					tag=false;
					$(this).focus();
					return false;
				}
			});
			if(!tag){
				alert("请填写表单中的所有字段");
				return false;
			}
			
			*/
		
			var submitTimeStr=$("textarea[name='submitDate']").val();
			if($.trim(submitTimeStr)){
				if(!($.checkDate(submitTimeStr))){
					$("textarea[name='submitDate']").focus();
					return false;
				}
			}
			
			var amountStr=$("textarea[name='amount']").val();
			if($.trim(amountStr)){
				if(!($.checkNum(amountStr))){
					$("textarea[name='amount']").focus();
					return false;
				}
			}
		});
		
		 $("#uploadify").uploadify({
            //指定swf文件
            'swf': '${base}/res/js/uploadify/uploadify.swf',
            //后台处理的页面
            'uploader': '${base}/file/uploadFile?id=${subFileFolder}&type=3',
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
            //'formData': { 'id': '', 'type': 1 },
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
	});
</script>
<style type="text/css">
#main{width:1002px;position:relative;}
#main .title{width:1001px;height:58px;overflow:hidden;overflow:hidden;}
#main .title img{display:block;width:1001px;height:58px;}

#main .bg{background:#fff;padding:10px 46px 80px;}
#main .bg h2{ line-height:70px;height:70px;text-align:center;font-size:16px;color:#482f8d;}
#main table{margin:0 auto;border-left:3px solid #d9d9d9;border-top:3px solid #d9d9d9;}
#main table th,#main table td{margin:0 auto;border-right:3px solid #d9d9d9;border-bottom:3px solid #d9d9d9;background:#f5f5f5;}
#main table th{text-align:center;padding:9px 4px;font-size:14px;color:#454545;line-height:28px;}
#main table td{padding:9px 14px;font-size:14px;color:#454545;line-height:28px;}
#main table td textarea{width:100%;line-height:28px;height:28px;}

#main .btn{padding:33px 0 0 330px;height:38px;overflow:hidden;}
#main .btn input{display:block;width:130px;height:38px;overflow:hidden;float:left;margin-right:22px;cursor:pointer;padding:0px;border:0px;}
#main .btn input.reset{background:url(${base}/res/images/Inbox/Inbox3_1.jpg) no-repeat;}
#main .btn input.submit{background:url(${base}/res/images/Petition/Inbox3_2.jpg) no-repeat;}
#img_box{position:absolute;top:-1000000px;;left:-1000000px;}
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
			<h2>武汉市房地产市场管理中心信访处理单</h2>
			<font color="red">${errorMsg!} ${titleMsg!} ${orgNameMsg!} ${submitDateMsg!} ${tagMsg!} ${sortNumMsg!} ${amountMsg!} ${classificationMsg!}</font>
			<form id="submitForm" action="${base}/petition/saveProcessInfo" method="post">
				<table cellpadding="0" cellspacing="0">
					<tr>
						<th style="width:116px;">来件标题</th>
						<td style="width:316px;">
							<textarea class="require" name="title">${title!}</textarea>
						</td>
						<th style="width:116px;">来件渠道</th>
						<td style="width:316px;">
							<textarea class="require" name="source">${source!}</textarea>
						</td>
					</tr>
					<tr>
						<th>来件单位</th>
						<td>
							<textarea class="require" name="orgName">${orgName!}</textarea>
						</td>
						<th>来件日期<br>(格式:2014-08-05)</th>
						<td>
							<textarea class="require" name="submitDate">${submitDate!}</textarea>
						</td>
					</tr>
					<tr>
						<th>来件字号</th>
						<td>
							<textarea class="require" name="tag">${tag!}</textarea>
						</td>
						<th>收件编号</th>
						<td>
							<textarea class="require" name="sortNum" readonly="readonly">${sortNum!}</textarea>
						</td>
					</tr>
					<tr>
						<th>正文</th>
						<td>
							<a id="read_box" href="#" title="查看正文">查看正文</a>
							<ul id="img_box">
								<#if filePathList??>
									<#list filePathList as item>
										<li>
											<a href="${base}/${item}">
												<img src="${base}/${item}"/>
											</a>
										</li>
									</#list>
								</#if>
							</ul>
						</td>
						<th>份数</th>
						<td>
							<textarea class="require" name="amount">${amount!}</textarea>
						</td>
					</tr>
					<tr>
						<th>附件</th>
						<td>
							<input type="file" name="uploadify" id="uploadify" />
						</td>
						<th>密级</th>
						<td>
							<textarea class="require" name="classification">${classification!}</textarea>
						</td>
					</tr>
				</table>
				<input type="checkbox" name="sendToSectionMember"/>发送给信访专员<br>
				<div class="btn">
					<input type="hidden" name="subFileFolder" value="${subFileFolder}"/>
					<input type="reset" class="reset" value=" " />
					<input type="submit" class="submit" onclick="" value=" " />
				</div>
			</form>
		</div>
	</div>
	<@globe.footer backhref="${base}"/>
</div>
</body>
</html>
