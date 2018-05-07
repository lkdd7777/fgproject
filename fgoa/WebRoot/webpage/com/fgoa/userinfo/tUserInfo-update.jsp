<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>用户信息</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
  <script type="text/javascript" src="plug-in/ckeditor_new/ckeditor.js"></script>
  <script type="text/javascript" src="plug-in/ckfinder/ckfinder.js"></script>
  <script type="text/javascript">
  $(document).ready(function(){
	$('#tt').tabs({
	   onSelect:function(title){
	       $('#tt .panel-body').css('width','auto');
		}
	});
	$(".tabs-wrap").css('width','100%');
  });
 </script>
 </head>
 <body style="overflow-x: hidden;">
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" tiptype="1" action="tUserInfoController.do?doUpdate">
					<input id="id" name="id" type="hidden" value="${tUserInfoPage.id }">
	<h1>个人信息</h1>
	<table cellpadding="0" cellspacing="1" class="formtable">
		<tr>
			<td align="right">
				<label class="Validform_label">编号:</label>
			</td>
			<td class="value">
		     	 <input id="bh" name="bh" type="text" style="width: 150px" class="inputxt"  
					               datatype="*"
					                value='${tUserInfoPage.bh}'>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">编号</label>
			</td>
			<td align="right">
				<label class="Validform_label">姓名:</label>
			</td>
			<td class="value">
		     	 <input id="xm" name="xm" type="text" style="width: 150px" class="inputxt"  
					               datatype="*"
					                value='${tUserInfoPage.xm}'>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">姓名</label>
			</td>
		</tr>
		<tr>
			<td align="right">
				<label class="Validform_label">性别:</label>
			</td>
			<td class="value">
					<t:dictSelect field="xb" type="list"
						typeGroupCode="sex" defaultVal="${tUserInfoPage.xb}" hasLabel="false"  title="性别"></t:dictSelect>     
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">性别</label>
			</td>
			<td align="right">
				<label class="Validform_label">民族:</label>
			</td>
			<td class="value">
		     	 <input id="mz" name="mz" type="text" style="width: 150px" class="inputxt"  
					               
					                value='${tUserInfoPage.mz}'>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">民族</label>
			</td>
		</tr>
		<tr>
			<td align="right">
				<label class="Validform_label">身份证:</label>
			</td>
			<td class="value">
		     	 <input id="sfz" name="sfz" type="text" style="width: 150px" class="inputxt"  
					               
					                value='${tUserInfoPage.sfz}'>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">身份证</label>
			</td>
			<td align="right">
				<label class="Validform_label">婚姻状态:</label>
			</td>
			<td class="value">
					<t:dictSelect field="hyzt" type="list"
						typeGroupCode="hyzt" defaultVal="${tUserInfoPage.hyzt}" hasLabel="false"  title="婚姻状态"></t:dictSelect>     
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">婚姻状态</label>
			</td>
		</tr>
		<tr>
			<td align="right">
				<label class="Validform_label">出生日期:</label>
			</td>
			<td class="value">
		     	 <input id="csrq" name="csrq" type="text" style="width: 150px" class="inputxt"  
					               
					                value='${tUserInfoPage.csrq}'>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">出生日期</label>
			</td>
			<td align="right">
				<label class="Validform_label">办公电话:</label>
			</td>
			<td class="value">
		     	 <input id="bgdh" name="bgdh" type="text" style="width: 150px" class="inputxt"  
					               
					                value='${tUserInfoPage.bgdh}'>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">办公电话</label>
			</td>
		</tr>
		<tr>
			<td align="right">
				<label class="Validform_label">学历:</label>
			</td>
			<td class="value">
					<t:dictSelect field="xl" type="list"
						typeGroupCode="xl" defaultVal="${tUserInfoPage.xl}" hasLabel="false"  title="学历"></t:dictSelect>     
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">学历</label>
			</td>
			<td align="right">
				<label class="Validform_label">紧急联系电话:</label>
			</td>
			<td class="value">
		     	 <input id="jjlxdh" name="jjlxdh" type="text" style="width: 150px" class="inputxt"  
					               
					                value='${tUserInfoPage.jjlxdh}'>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">紧急联系电话</label>
			</td>
		</tr>
		<tr>
			<td align="right">
				<label class="Validform_label">qq号码:</label>
			</td>
			<td class="value">
		     	 <input id="qq" name="qq" type="text" style="width: 150px" class="inputxt"  
					               
					                value='${tUserInfoPage.qq}'>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">qq号码</label>
			</td>
			<td align="right">
				<label class="Validform_label">籍贯:</label>
			</td>
			<td class="value">
		     	 <input id="jg" name="jg" type="text" style="width: 150px" class="inputxt"  
					               
					                value='${tUserInfoPage.jg}'>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">籍贯</label>
			</td>
		</tr>
		<tr>
			<td align="right">
				<label class="Validform_label">家庭住址:</label>
			</td>
			<td class="value">
		     	 <input id="jtzz" name="jtzz" type="text" style="width: 150px" class="inputxt"  
					               
					                value='${tUserInfoPage.jtzz}'>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">家庭住址</label>
			</td>
			<td align="right">
				<label class="Validform_label">户口所在地:</label>
			</td>
			<td class="value">
		     	 <input id="hkszd" name="hkszd" type="text" style="width: 150px" class="inputxt"  
					               
					                value='${tUserInfoPage.hkszd}'>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">户口所在地</label>
			</td>
		</tr>
		<tr>
			<td align="right">
				<label class="Validform_label">政治面貌:</label>
			</td>
			<td class="value">
					<t:dictSelect field="zzmm" type="list"
						typeGroupCode="zzmm" defaultVal="${tUserInfoPage.zzmm}" hasLabel="false"  title="政治面貌"></t:dictSelect>     
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">政治面貌</label>
			</td>
			<td align="right">
				<label class="Validform_label">入党团时间:</label>
			</td>
			<td class="value">
		     	 <input id="rdtsj" name="rdtsj" type="text" style="width: 150px" class="inputxt"  
					               
					                value='${tUserInfoPage.rdtsj}'>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">入党团时间</label>
			</td>
		</tr>
		<tr>
			<td align="right">
				<label class="Validform_label">党内职务:</label>
			</td>
			<td class="value">
		     	 <input id="dnzw" name="dnzw" type="text" style="width: 150px" class="inputxt"  
					               
					                value='${tUserInfoPage.dnzw}'>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">党内职务</label>
			</td>
			<td align="right">
				<label class="Validform_label">团内职务:</label>
			</td>
			<td class="value">
		     	 <input id="tnzw" name="tnzw" type="text" style="width: 150px" class="inputxt"  
					               
					                value='${tUserInfoPage.tnzw}'>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">团内职务</label>
			</td>
		</tr>
		<tr>
			<td align="right">
				<label class="Validform_label">党支部:</label>
			</td>
			<td class="value">
		     	 <input id="dzb" name="dzb" type="text" style="width: 150px" class="inputxt"  
					               
					                value='${tUserInfoPage.dzb}'>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">党支部</label>
			</td>
			<td align="right">
				<label class="Validform_label">入党阶段:</label>
			</td>
			<td class="value">
		     	 <input id="rdjd" name="rdjd" type="text" style="width: 150px" class="inputxt"  
					               
					                value='${tUserInfoPage.rdjd}'>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">入党阶段</label>
			</td>
		</tr>
		<tr>
			<td align="right">
				<label class="Validform_label">党费基数:</label>
			</td>
			<td class="value">
		     	 <input id="dfjs" name="dfjs" type="text" style="width: 150px" class="inputxt"  
					               
					                value='${tUserInfoPage.dfjs}'>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">党费基数</label>
			</td>
			<td align="right">
				<label class="Validform_label">团外职务:</label>
			</td>
			<td class="value">
		     	 <input id="twzw" name="twzw" type="text" style="width: 150px" class="inputxt"  
					               
					                value='${tUserInfoPage.twzw}'>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">团外职务</label>
			</td>
		</tr>
		<tr>
			<td align="right">
				<label class="Validform_label">个人信息备注:</label>
			</td>
			<td class="value" colspan="3">
		     	<%--  <input id="grxxbz" name="grxxbz" type="text" style="width: 150px" class="inputxt"  
					               
					                value='${tUserInfoPage.grxxbz}'> --%>
                <textarea rows="5" name="grxxbz" style="width: 500px;">${tUserInfoPage.grxxbz}</textarea>	          
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">个人信息备注</label>
			</td>
		</tr>
	</table>
	<h1>单位信息</h1>
	<table cellpadding="0" cellspacing="1" class="formtable">
		<tr>
			<td align="right">
				<label class="Validform_label">用工形式:</label>
			</td>
			<td class="value">
					<t:dictSelect field="ygxs" type="list"
						typeGroupCode="ygxs" defaultVal="${tUserInfoPage.ygxs}" hasLabel="false"  title="用工形式"></t:dictSelect>     
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">用工形式</label>
			</td>
			<td align="right">
				<label class="Validform_label">在职状态:</label>
			</td>
			<td class="value">
					<t:dictSelect field="zzzt" type="list"
						typeGroupCode="zzzt" defaultVal="${tUserInfoPage.zzzt}" hasLabel="false"  title="在职状态"></t:dictSelect>     
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">在职状态</label>
			</td>
		</tr>
		<tr>
			<td align="right">
				<label class="Validform_label">岗位:</label>
			</td>
			<td class="value">
					<t:dictSelect field="gw" type="list"
						typeGroupCode="gw" defaultVal="${tUserInfoPage.gw}" hasLabel="false"  title="岗位"></t:dictSelect>     
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">岗位</label>
			</td>
			<td align="right">
				<label class="Validform_label">部门:</label>
			</td>
			<td class="value">
					<t:dictSelect field="bm" type="list"
						typeGroupCode="bm" defaultVal="${tUserInfoPage.bm}" hasLabel="false"  title="部门"></t:dictSelect>     
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">部门</label>
			</td>
		</tr>
		<tr>
			<td align="right">
				<label class="Validform_label">专业技术职称:</label>
			</td>
			<td class="value">
		     	 <input id="zzjszc" name="zzjszc" type="text" style="width: 150px" class="inputxt"  
					               
					                value='${tUserInfoPage.zzjszc}'>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">专业技术职称</label>
			</td>
			<td align="right">
				<label class="Validform_label">岗位等级:</label>
			</td>
			<td class="value">
					<t:dictSelect field="gwdj" type="list"
						typeGroupCode="gwdj" defaultVal="${tUserInfoPage.gwdj}" hasLabel="false"  title="岗位等级"></t:dictSelect>     
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">岗位等级</label>
			</td>
		</tr>
		<tr>
			<td align="right">
				<label class="Validform_label">职务:</label>
			</td>
			<td class="value">
		     	 <input id="zw" name="zw" type="text" style="width: 150px" class="inputxt"  
					               
					                value='${tUserInfoPage.zw}'>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">职务</label>
			</td>
			<td align="right">
				<label class="Validform_label">参加工作时间:</label>
			</td>
			<td class="value">
		     	 <input id="cjgzsj" name="cjgzsj" type="text" style="width: 150px" class="inputxt"  
					               
					                value='${tUserInfoPage.cjgzsj}'>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">参加工作时间</label>
			</td>
		</tr>
		<tr>
			<td align="right">
				<label class="Validform_label">社保账号:</label>
			</td>
			<td class="value">
		     	 <input id="sbzh" name="sbzh" type="text" style="width: 150px" class="inputxt"  
					               
					                value='${tUserInfoPage.sbzh}'>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">社保账号</label>
			</td>
			<td align="right">
				<label class="Validform_label">职务级别:</label>
			</td>
			<td class="value">
					<t:dictSelect field="zwjb" type="list"
						typeGroupCode="zwjb" defaultVal="${tUserInfoPage.zwjb}" hasLabel="false"  title="职务级别"></t:dictSelect>     
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">职务级别</label>
			</td>
		</tr>
		<tr>
			<td align="right">
				<label class="Validform_label">现职务工作年限:</label>
			</td>
			<td class="value">
		     	 <input id="xzwgznx" name="xzwgznx" type="text" style="width: 150px" class="inputxt"  
					               
					                value='${tUserInfoPage.xzwgznx}'>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">现职务工作年限</label>
			</td>
			<td align="right">
				<label class="Validform_label">职称:</label>
			</td>
			<td class="value">
					<t:dictSelect field="zc" type="list"
						typeGroupCode="zc" defaultVal="${tUserInfoPage.zc}" hasLabel="false"  title="职称"></t:dictSelect>     
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">职称</label>
			</td>
		</tr>
		<tr>
			<td align="right">
				<label class="Validform_label">现职务工作时间:</label>
			</td>
			<td class="value">
		     	 <input id="xzwgzsj" name="xzwgzsj" type="text" style="width: 150px" class="inputxt"  
					               
					                value='${tUserInfoPage.xzwgzsj}'>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">现职务工作时间</label>
			</td>
			<td align="right">
				<label class="Validform_label">本级别工作年限:</label>
			</td>
			<td class="value">
		     	 <input id="bjbgznx" name="bjbgznx" type="text" style="width: 150px" class="inputxt"  
					               
					                value='${tUserInfoPage.bjbgznx}'>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">本级别工作年限</label>
			</td>
		</tr>
		<tr>
			<td align="right">
				<label class="Validform_label">就餐卡号:</label>
			</td>
			<td class="value">
		     	 <input id="jckh" name="jckh" type="text" style="width: 150px" class="inputxt"  
					               
					                value='${tUserInfoPage.jckh}'>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">就餐卡号</label>
			</td>
			<td align="right">
				<label class="Validform_label">部门调整记录:</label>
			</td>
			<td class="value">
		     	 <input id="bmtzjl" name="bmtzjl" type="text" style="width: 150px" class="inputxt"  
					               
					                value='${tUserInfoPage.bmtzjl}'>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">部门调整记录</label>
			</td>
		</tr>
		<tr>
			<td align="right">
				<label class="Validform_label">公积金账号:</label>
			</td>
			<td class="value">
		     	 <input id="gjjzh" name="gjjzh" type="text" style="width: 150px" class="inputxt"  
					               
					                value='${tUserInfoPage.gjjzh}'>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">公积金账号</label>
			</td>
			<td align="right">
				<label class="Validform_label">单位信息备注:</label>
			</td>
			<td class="value">
		     	 <input id="dwxxbz" name="dwxxbz" type="text" style="width: 150px" class="inputxt"  
					               
					                value='${tUserInfoPage.dwxxbz}'>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">单位信息备注</label>
			</td>
		</tr>
		<tr>
			<td align="right">
				<label class="Validform_label">入本单位时间:</label>
			</td>
			<td class="value">
		     	 <input id="rbdwsj" name="rbdwsj" type="text" style="width: 150px" class="inputxt"  
					               
					                value='${tUserInfoPage.rbdwsj}'>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">入本单位时间</label>
			</td>
			<td align="right">
				<label class="Validform_label">工龄:</label>
			</td>
			<td class="value">
		     	 <input id="gl" name="gl" type="text" style="width: 150px" class="inputxt"  
					               
					                value='${tUserInfoPage.gl}'>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">工龄</label>
			</td>
		</tr>
		<tr>
			<td align="right">
				<label class="Validform_label">任本级别时间:</label>
			</td>
			<td class="value">
		     	 <input id="rbjbsj" name="rbjbsj" type="text" style="width: 150px" class="inputxt"  
					               
					                value='${tUserInfoPage.rbjbsj}'>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">任本级别时间</label>
			</td>
			<td align="right">
				<label class="Validform_label">入单位渠道:</label>
			</td>
			<td class="value">
		     	 <input id="rdwqd" name="rdwqd" type="text" style="width: 150px" class="inputxt"  
					               
					                value='${tUserInfoPage.rdwqd}'>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">入单位渠道</label>
			</td>
		</tr>
			</table>
			<div style="width: auto;height: 200px;">
				<%-- 增加一个div，用于调节页面大小，否则默认太小 --%>
				<div style="width:800px;height:1px;"></div>
				<t:tabs id="tt" iframe="false" tabPosition="top" fit="false">
				 <t:tab href="tUserInfoController.do?tUserJtcyList&id=${tUserInfoPage.id}" icon="icon-search" title="家庭成员" id="tUserJtcy"></t:tab>
				 <t:tab href="tUserInfoController.do?tUserJyjlList&id=${tUserInfoPage.id}" icon="icon-search" title="教育经历" id="tUserJyjl"></t:tab>
				 <t:tab href="tUserInfoController.do?tUserGzjlList&id=${tUserInfoPage.id}" icon="icon-search" title="工作经历" id="tUserGzjl"></t:tab>
				 <t:tab href="tUserInfoController.do?tUserHtglList&id=${tUserInfoPage.id}" icon="icon-search" title="合同管理" id="tUserHtgl"></t:tab>
				 <t:tab href="tUserInfoController.do?tUserJcjlList&id=${tUserInfoPage.id}" icon="icon-search" title="奖惩记录" id="tUserJcjl"></t:tab>
				 <t:tab href="tUserInfoController.do?tUserPxjlList&id=${tUserInfoPage.id}" icon="icon-search" title="培训记录" id="tUserPxjl"></t:tab>
				 <t:tab href="tUserInfoController.do?tUserGzglList&id=${tUserInfoPage.id}" icon="icon-search" title="工资管理" id="tUserGzgl"></t:tab>
				 <t:tab href="tUserInfoController.do?tUserTxjsList&id=${tUserInfoPage.id}" icon="icon-search" title="调薪记录" id="tUserTxjs"></t:tab>
				</t:tabs>
			</div>
			</t:formvalid>
			<!-- 添加 附表明细 模版 -->
		<table style="display:none">
		<tbody id="add_tUserJtcy_table_template">
			<tr>
			 <td align="center"><div style="width: 25px;" name="xh"></div></td>
			 <td align="center"><input style="width:20px;" type="checkbox" name="ck"/></td>
				  <td align="left">
					  	<input name="tUserJtcyList[#index#].xm" maxlength="50" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					               >
					  <label class="Validform_label" style="display: none;">姓名</label>
				  </td>
				  <td align="left">
					  	<input name="tUserJtcyList[#index#].gx" maxlength="50" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					               >
					  <label class="Validform_label" style="display: none;">关系</label>
				  </td>
				  <td align="left">
					  	<input name="tUserJtcyList[#index#].gzdw" maxlength="100" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					               >
					  <label class="Validform_label" style="display: none;">工作单位</label>
				  </td>
				  <td align="left">
					  	<input name="tUserJtcyList[#index#].zw" maxlength="50" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					               >
					  <label class="Validform_label" style="display: none;">职务</label>
				  </td>
				  <td align="left">
					  	<input name="tUserJtcyList[#index#].dh" maxlength="50" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					               >
					  <label class="Validform_label" style="display: none;">电话</label>
				  </td>
				  <td align="left">
					  	<input name="tUserJtcyList[#index#].jtcybz" maxlength="100" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					               >
					  <label class="Validform_label" style="display: none;">家庭成员备注</label>
				  </td>
			</tr>
		 </tbody>
		<tbody id="add_tUserJyjl_table_template">
			<tr>
			 <td align="center"><div style="width: 25px;" name="xh"></div></td>
			 <td align="center"><input style="width:20px;" type="checkbox" name="ck"/></td>
				  <td align="left">
					  	<input name="tUserJyjlList[#index#].xxmc" maxlength="100" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					               >
					  <label class="Validform_label" style="display: none;">学校名称</label>
				  </td>
				  <td align="left">
					  	<input name="tUserJyjlList[#index#].rxsj" maxlength="100" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					               >
					  <label class="Validform_label" style="display: none;">入学时间</label>
				  </td>
				  <td align="left">
					  	<input name="tUserJyjlList[#index#].bysj" maxlength="100" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					               >
					  <label class="Validform_label" style="display: none;">毕业时间</label>
				  </td>
				  <td align="left">
					  	<input name="tUserJyjlList[#index#].sxzy" maxlength="100" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					               >
					  <label class="Validform_label" style="display: none;">所学专业</label>
				  </td>
				  <td align="left">
					  	<input name="tUserJyjlList[#index#].whcd" maxlength="100" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					               >
					  <label class="Validform_label" style="display: none;">文化程度</label>
				  </td>
				  <td align="left">
					  	<input name="tUserJyjlList[#index#].xw" maxlength="100" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					               >
					  <label class="Validform_label" style="display: none;">学位</label>
				  </td>
				  <td align="left">
					  	<input name="tUserJyjlList[#index#].jyjlbz" maxlength="100" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					               >
					  <label class="Validform_label" style="display: none;">教育经历备注</label>
				  </td>
			</tr>
		 </tbody>
		<tbody id="add_tUserGzjl_table_template">
			<tr>
			 <td align="center"><div style="width: 25px;" name="xh"></div></td>
			 <td align="center"><input style="width:20px;" type="checkbox" name="ck"/></td>
				  <td align="left">
					  	<input name="tUserGzjlList[#index#].rzsj" maxlength="100" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					               >
					  <label class="Validform_label" style="display: none;">入职时间</label>
				  </td>
				  <td align="left">
					  	<input name="tUserGzjlList[#index#].lzsj" maxlength="100" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					               >
					  <label class="Validform_label" style="display: none;">离职时间</label>
				  </td>
				  <td align="left">
					  	<input name="tUserGzjlList[#index#].gzdw" maxlength="100" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					               >
					  <label class="Validform_label" style="display: none;">工作单位</label>
				  </td>
				  <td align="left">
					  	<input name="tUserGzjlList[#index#].zw" maxlength="100" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					               >
					  <label class="Validform_label" style="display: none;">职务</label>
				  </td>
				  <td align="left">
					  	<input name="tUserGzjlList[#index#].lzyy" maxlength="100" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					               >
					  <label class="Validform_label" style="display: none;">离职原因</label>
				  </td>
				  <td align="left">
					  	<input name="tUserGzjlList[#index#].gzjlbz" maxlength="100" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					               >
					  <label class="Validform_label" style="display: none;">工作经历备注</label>
				  </td>
			</tr>
		 </tbody>
		<tbody id="add_tUserHtgl_table_template">
			<tr>
			 <td align="center"><div style="width: 25px;" name="xh"></div></td>
			 <td align="center"><input style="width:20px;" type="checkbox" name="ck"/></td>
				  <td align="left">
					  	<input name="tUserHtglList[#index#].htbh" maxlength="100" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					               >
					  <label class="Validform_label" style="display: none;">合同编号</label>
				  </td>
				  <td align="left">
					  	<input name="tUserHtglList[#index#].sybzht" maxlength="100" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					               >
					  <label class="Validform_label" style="display: none;">事业编制合同</label>
				  </td>
				  <td align="left">
					  	<input name="tUserHtglList[#index#].qyhtsj" maxlength="100" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					               >
					  <label class="Validform_label" style="display: none;">签约合同时间</label>
				  </td>
				  <td align="left">
					  	<input name="tUserHtglList[#index#].htdqsj" maxlength="100" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					               >
					  <label class="Validform_label" style="display: none;">合同到期时间</label>
				  </td>
				  <td align="left">
					  	<input name="tUserHtglList[#index#].xqsj" maxlength="100" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					               >
					  <label class="Validform_label" style="display: none;">续签时间</label>
				  </td>
				  <td align="left">
					  	<input name="tUserHtglList[#index#].htglbz" maxlength="100" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					               >
					  <label class="Validform_label" style="display: none;">合同管理备注</label>
				  </td>
			</tr>
		 </tbody>
		<tbody id="add_tUserJcjl_table_template">
			<tr>
			 <td align="center"><div style="width: 25px;" name="xh"></div></td>
			 <td align="center"><input style="width:20px;" type="checkbox" name="ck"/></td>
				  <td align="left">
					  	<input name="tUserJcjlList[#index#].jclb" maxlength="100" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					               >
					  <label class="Validform_label" style="display: none;">奖惩类别</label>
				  </td>
				  <td align="left">
					  	<input name="tUserJcjlList[#index#].jcjb" maxlength="100" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					               >
					  <label class="Validform_label" style="display: none;">奖惩级别</label>
				  </td>
				  <td align="left">
					  	<input name="tUserJcjlList[#index#].jcsj" maxlength="100" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					               >
					  <label class="Validform_label" style="display: none;">奖惩时间</label>
				  </td>
				  <td align="left">
					  	<input name="tUserJcjlList[#index#].yy" maxlength="100" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					               >
					  <label class="Validform_label" style="display: none;">原因</label>
				  </td>
				  <td align="left">
					  	<input name="tUserJcjlList[#index#].jg" maxlength="100" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					               >
					  <label class="Validform_label" style="display: none;">结果</label>
				  </td>
				  <td align="left">
					  	<input name="tUserJcjlList[#index#].jcjlbz" maxlength="100" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					               >
					  <label class="Validform_label" style="display: none;">奖惩记录备注</label>
				  </td>
			</tr>
		 </tbody>
		<tbody id="add_tUserPxjl_table_template">
			<tr>
			 <td align="center"><div style="width: 25px;" name="xh"></div></td>
			 <td align="center"><input style="width:20px;" type="checkbox" name="ck"/></td>
				  <td align="left">
					  	<input name="tUserPxjlList[#index#].pxzzbm" maxlength="100" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					               >
					  <label class="Validform_label" style="display: none;">培训组织部门</label>
				  </td>
				  <td align="left">
					  	<input name="tUserPxjlList[#index#].pxdd" maxlength="100" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					               >
					  <label class="Validform_label" style="display: none;">培训地点</label>
				  </td>
				  <td align="left">
					  	<input name="tUserPxjlList[#index#].pxsj" maxlength="100" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					               >
					  <label class="Validform_label" style="display: none;">培训时间</label>
				  </td>
				  <td align="left">
					  	<input name="tUserPxjlList[#index#].pxjf" maxlength="100" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					               >
					  <label class="Validform_label" style="display: none;">培训经费</label>
				  </td>
				  <td align="left">
					  	<input name="tUserPxjlList[#index#].pxjg" maxlength="100" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					               >
					  <label class="Validform_label" style="display: none;">培训结果</label>
				  </td>
				  <td align="left">
					  	<input name="tUserPxjlList[#index#].dwpxbz" maxlength="100" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					               >
					  <label class="Validform_label" style="display: none;">单位培训备注</label>
				  </td>
			</tr>
		 </tbody>
		<tbody id="add_tUserGzgl_table_template">
			<tr>
			 <td align="center"><div style="width: 25px;" name="xh"></div></td>
			 <td align="center"><input style="width:20px;" type="checkbox" name="ck"/></td>
				  <td align="left">
					  	<input name="tUserGzglList[#index#].bndsbjs" maxlength="100" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					               >
					  <label class="Validform_label" style="display: none;">岗位工资</label>
				  </td>
				  <td align="left">
					  	<input name="tUserGzglList[#index#].gzkzh" maxlength="100" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					               >
					  <label class="Validform_label" style="display: none;">本年度社保基数</label>
				  </td>
				  <td align="left">
					  	<input name="tUserGzglList[#index#].bndqtjs" maxlength="100" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					               >
					  <label class="Validform_label" style="display: none;">本年度其他基数</label>
				  </td>
				  <td align="left">
					  	<input name="tUserGzglList[#index#].zszgxcbz" maxlength="100" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					               >
					  <label class="Validform_label" style="display: none;">正式职工薪酬备注</label>
				  </td>
				  <td align="left">
					  	<input name="tUserGzglList[#index#].xjyzze" maxlength="100" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					               >
					  <label class="Validform_label" style="display: none;">薪级月增资额</label>
				  </td>
				  <td align="left">
					  	<input name="tUserGzglList[#index#].sndsbjs" maxlength="100" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					               >
					  <label class="Validform_label" style="display: none;">上年度社保基数</label>
				  </td>
				  <td align="left">
					  	<input name="tUserGzglList[#index#].xjje" maxlength="100" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					               >
					  <label class="Validform_label" style="display: none;">薪级金额</label>
				  </td>
				  <td align="left">
					  	<input name="tUserGzglList[#index#].sndqtjs" maxlength="100" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					               >
					  <label class="Validform_label" style="display: none;">上年度其他基数</label>
				  </td>
			</tr>
		 </tbody>
		<tbody id="add_tUserTxjs_table_template">
			<tr>
			 <td align="center"><div style="width: 25px;" name="xh"></div></td>
			 <td align="center"><input style="width:20px;" type="checkbox" name="ck"/></td>
				  <td align="left">
					  	<input name="tUserTxjsList[#index#].tzsj" maxlength="100" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					               >
					  <label class="Validform_label" style="display: none;">调整时间</label>
				  </td>
				  <td align="left">
					  	<input name="tUserTxjsList[#index#].txqje" maxlength="100" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					               >
					  <label class="Validform_label" style="display: none;">调薪前金额</label>
				  </td>
				  <td align="left">
					  	<input name="tUserTxjsList[#index#].txhje" maxlength="100" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					               >
					  <label class="Validform_label" style="display: none;">调薪后金额</label>
				  </td>
				  <td align="left">
					  	<input name="tUserTxjsList[#index#].txwh" maxlength="100" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					               >
					  <label class="Validform_label" style="display: none;">调薪文号</label>
				  </td>
				  <td align="left">
					  	<input name="tUserTxjsList[#index#].txbz" maxlength="100" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					               >
					  <label class="Validform_label" style="display: none;">调薪备注</label>
				  </td>
				  <td align="left">
					  	<input name="tUserTxjsList[#index#].txyy" maxlength="100" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					               >
					  <label class="Validform_label" style="display: none;">调薪原因</label>
				  </td>
			</tr>
		 </tbody>
		</table>
 </body>
 <script src = "webpage/com/fgoa/userinfo/tUserInfo.js"></script>	