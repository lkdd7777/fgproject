<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:1px;">
  <t:datagrid fitColumns="false" checkbox="true" name="tUserInfoList" title="用户信息" actionUrl="tUserInfoController.do?datagrid" idField="id" fit="true" queryMode="group">
   <t:dgCol title="id"  field="id"  hidden="false"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="编号"  field="bh"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="姓名"  field="xm"  hidden="true" query="true" queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="性别"  field="xb"  hidden="true"  queryMode="group" dictionary="sex" width="120"></t:dgCol>
   <t:dgCol title="民族"  field="mz"  hidden="false"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="身份证"  field="sfz"  hidden="false"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="婚姻状态"  field="hyzt"  hidden="false"  queryMode="group" dictionary="hyzt" width="120"></t:dgCol>
   <t:dgCol title="出生日期"  field="csrq"  hidden="false"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="办公电话"  field="bgdh"  hidden="false"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="学历"  field="xl"  hidden="true" query="true" queryMode="single" dictionary="xl" width="120"></t:dgCol>
   <t:dgCol title="紧急联系电话"  field="jjlxdh"  hidden="false"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="qq号码"  field="qq"  hidden="false"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="籍贯"  field="jg"  hidden="false"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="家庭住址"  field="jtzz"  hidden="false"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="户口所在地"  field="hkszd"  hidden="false"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="政治面貌"  field="zzmm"  hidden="true" query="true" queryMode="single" dictionary="zzmm" width="120"></t:dgCol>
   <t:dgCol title="入党团时间"  field="rdtsj"  hidden="false"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="党内职务"  field="dnzw"  hidden="false"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="团内职务"  field="tnzw"  hidden="false"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="党支部"  field="dzb"  hidden="false"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="入党阶段"  field="rdjd"  hidden="false"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="党费基数"  field="dfjs"  hidden="false"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="团外职务"  field="twzw"  hidden="false"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="个人信息备注"  field="grxxbz"  hidden="false"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="用工形式"  field="ygxs"  hidden="true" query="true" queryMode="single" dictionary="ygxs" width="120"></t:dgCol>
   <t:dgCol title="在职状态"  field="zzzt"  hidden="true" query="true" queryMode="single" dictionary="zzzt" width="120"></t:dgCol>
   <t:dgCol title="岗位"  field="gw"  hidden="true" query="true" queryMode="single" dictionary="gw" width="120"></t:dgCol>
   <t:dgCol title="部门"  field="bm"  hidden="true" query="true" queryMode="single" dictionary="bm" width="120"></t:dgCol>
   <t:dgCol title="专业技术职称"  field="zzjszc"  hidden="false"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="岗位等级"  field="gwdj"  hidden="false"  queryMode="group" dictionary="gwdj" width="120"></t:dgCol>
   <t:dgCol title="职务"  field="zw"  hidden="false"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="参加工作时间"  field="cjgzsj"  hidden="false"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="社保账号"  field="sbzh"  hidden="false"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="职务级别"  field="zwjb"  hidden="false"  queryMode="group" dictionary="zwjb" width="120"></t:dgCol>
   <t:dgCol title="现职务工作年限"  field="xzwgznx"  hidden="false"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="职称"  field="zc"  hidden="false"  queryMode="group" dictionary="zc" width="120"></t:dgCol>
   <t:dgCol title="现职务工作时间"  field="xzwgzsj"  hidden="false"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="本级别工作年限"  field="bjbgznx"  hidden="false"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="就餐卡号"  field="jckh"  hidden="false"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="部门调整记录"  field="bmtzjl"  hidden="false"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="公积金账号"  field="gjjzh"  hidden="false"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="单位信息备注"  field="dwxxbz"  hidden="false"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="入本单位时间"  field="rbdwsj"  hidden="false"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="工龄"  field="gl"  hidden="false"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="任本级别时间"  field="rbjbsj"  hidden="false"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="入单位渠道"  field="rdwqd"  hidden="false"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <t:dgDelOpt title="删除" url="tUserInfoController.do?doDel&id={id}" />
   <t:dgFunOpt funname="queryFjByUid(id)" title="附件上传"></t:dgFunOpt>
   <t:dgToolBar title="录入" icon="icon-add" url="tUserInfoController.do?goAdd" funname="add" height="450"></t:dgToolBar>
   <t:dgToolBar title="编辑" icon="icon-edit" url="tUserInfoController.do?goUpdate" funname="update" height="450"></t:dgToolBar>
   <t:dgToolBar title="批量删除"  icon="icon-remove" url="tUserInfoController.do?doBatchDel" funname="deleteALLSelect"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="tUserInfoController.do?goUpdate" funname="detail" height="450"></t:dgToolBar>
  </t:datagrid>
  </div>
 </div>
 <div data-options="region:'east',
	title:'附件上传',
	collapsed:false,
	split:true,
	border:false,
	onExpand : function(){
		li_east = 1;
	},
	onCollapse : function() {
	    li_east = 0;
	}"
	style="width: 400px; overflow: hidden;">
<div class="easyui-panel" style="padding: 1px;" fit="true" border="false" id="userFjListpanel"></div>
</div>
<script type="text/javascript">

$(function() {
	var li_east = 0;
});

function queryFjByRowData(rowData){
	$('#userFjListpanel').panel("refresh", "userFjController.do?userFj&uid=" + rowData.id);
}

function queryFjByUid(uid){
	$('#userFjListpanel').panel("refresh", "userFjController.do?userFj&uid=" + uid);
}
</script>
 
 <script src = "webpage/com/fgoa/userinfo/tUserInfoList.js"></script>		
 <script type="text/javascript">
  $(document).ready(function(){
 		//给时间控件加上样式
 });
 </script>