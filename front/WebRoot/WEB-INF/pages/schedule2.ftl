﻿<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<@globe.include title="日程安排（请休假审批）"/>
<script type="text/javascript">

</script>
<style type="text/css">
#main{width:1002px;position:relative;}
#main .title{width:1001px;height:58px;overflow:hidden;overflow:hidden;}
#main .title img{display:block;width:1001px;height:58px;}

#main .bg{padding:39px 0 0;}
#main .bg table{width:100%;border-bottom:4px solid #d1d1d1;background:#f9f9f9;}
#main .bg table th{background:url(${base}/res/images/Announcement/bg.jpg) left bottom repeat-x;height:48px;padding:0 0 2px 0;color:#b4b4b4;font-size:14px;line-height:48x;font-weight:bold;}
#main .bg table th.th1{padding:0 0 0 49px;width:134px;overflow:hidden;}
#main .bg table th.th2{width:160px;overflow:hidden;text-align:center;}
#main .bg table th.th3{width:310px;overflow:hidden;text-align:center;}
#main .bg table th.th4{width:157px;overflow:hidden;text-align:center;}
#main .bg table th.th5{width:240px;overflow:hidden;text-align:center;}

#main .bg table td{color:#000;font-size:14px;line-height:24x;padding:12px 0;border-bottom:1px solid #dbdbdb;}
#main .bg table td.td1{padding-left:49px;width:134px;overflow:hidden;}
#main .bg table td.td2{width:160px;overflow:hidden;text-align:center;}
#main .bg table td.td3{width:310px;overflow:hidden;text-align:center;}
#main .bg table td.td4{width:157px;overflow:hidden;text-align:center;}
#main .bg table td.td5{width:240px;overflow:hidden;text-align:center;}

#main .btn{padding:43px 0 0 342px;height:49px;overflow:hidden;}
#main .btn a{display:block;height:49px;width:151px;overflow:hidden;float:left;margin:0 30px 0 0;}

#main .th_title{background:url(${base}/res/images/Contacts/th_title.jpg) no-repeat;height:46px;width:1001px;position:relative;}
#main .th_title .text{width:800px;left:100px;top:8px;position:absolute;background:none;border:0px;padding:0px;text-align:center;font-size:16px; line-height:30px;height:30px;color:#ccc;font-family:'微软雅黑','宋体',Arial, Helvetica, sans-serif;letter-spacing:2px;display:block;}
#main .th_title .submit{width:48px;height:25px;overflow:hidden;right:45px;top:11px;display:block;position:absolute;background:none;border:0px;padding:0px;cursor:pointer;}

.pager{text-align:center;padding:20px 10px;}
.pager a{color:#036cb4;background-color:#FFFFFF;text-decoration:none;border:#eee solid 1px;padding:2px 6px;margin-right:5px;}
.pager a:hover{color:#FFFFFF;background-color:#036cb4;border:#036cb4 solid 1px;}
.pager .cpb {color:#FFFFFF;background-color:#036cb4;text-decoration:none;border:#036cb4 solid 1px;padding:2px 6px;margin-right:5px;}
</style>
</head>
<body>
<div id="wrap">
	<@globe.header/>
	<div id="main">
		<div class="title">
			<img src="${base}/res/images/Schedule/title2.jpg" alt="日程安排（请休假审批）" />
		</div>
		<div class="bg">
			<table>
				<tr>
					<th class="th1">申请人</th>
					<th class="th2">申请时间</th>
					<th class="th3">请假起止时间</th>
					<th class="th4">请假事由</th>
                    <th class="th5"></th>
				</tr>
				<tr>
					<td class="td1">张三</td>
					<td class="td2">2014年11月29日</td>
					<td class="td3">2014年12月1日-2014年12月6日</td>
                    <td class="td4">年休假</td>
					<td class="td5">
						<a href="javascript:void(0);" style="margin-right:12px;" title="同意"><img src="images/Schedule/Schedule01.jpg" alt="同意" /></a>
						<a href="javascript:void(0);" style="margin-right:12px;" title="驳回"><img src="images/Schedule/Schedule02.jpg" alt="驳回" /></a>
					</td>
				</tr>
                <tr>
					<td class="td1">张三</td>
					<td class="td2">2014年11月29日</td>
					<td class="td3">2014年12月1日-2014年12月6日</td>
                    <td class="td4">年休假</td>
					<td class="td5">
                    	已驳回
					</td>
				</tr>
			</table>
		</div>
	</div>
	<@globe.footer backhref="${base}"/>
</div>
</body>
</html>
