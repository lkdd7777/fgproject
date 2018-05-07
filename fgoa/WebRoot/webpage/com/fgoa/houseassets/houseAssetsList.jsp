<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:1px;">
  <t:datagrid name="houseAssetsList" checkbox="true" fitColumns="false" title="房屋资产" actionUrl="houseAssetsController.do?datagrid" idField="id" fit="true" queryMode="group">
   <t:dgCol title="id"  field="id"  hidden="false"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="排序号"  field="sortNum"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="资产地址"  field="address"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="建筑面积"  field="buildingArea"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="土地面积"  field="landArea"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="合同价款"  field="contractPrice"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="取得时间"  field="achieveTime" formatter="yyyy-MM-dd" hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="办证时间"  field="certificateTime" formatter="yyyy-MM-dd" hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="证载用途"  field="purpose"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="权属情况"  field="ownership"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="房屋现状"  field="housingSituation"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="租金方式"  field="rentalType"  hidden="true" query="true" queryMode="single" dictionary="paytype" width="120"></t:dgCol>
   <t:dgCol title="租金"  field="rental"  hidden="true" query="true" queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="承租时间"  field="leaseTime" formatter="yyyy-MM-dd" hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="租期"  field="lease"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="承租人"  field="user"  hidden="true" query="true" queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="承租人电话"  field="userPhone"  hidden="true" query="true" queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="水电煤等缴费方式"  field="other"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="备注"  field="remark"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <t:dgDelOpt title="删除" url="houseAssetsController.do?doDel&id={id}" />
   <t:dgFunOpt funname="queryFjByHid(id)" title="附件上传"></t:dgFunOpt>
   <t:dgToolBar title="录入" icon="icon-add" url="houseAssetsController.do?goAdd" funname="add"></t:dgToolBar>
   <t:dgToolBar title="编辑" icon="icon-edit" url="houseAssetsController.do?goUpdate" funname="update"></t:dgToolBar>
   <t:dgToolBar title="批量删除"  icon="icon-remove" url="houseAssetsController.do?doBatchDel" funname="deleteALLSelect"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="houseAssetsController.do?goUpdate" funname="detail"></t:dgToolBar>
   <t:dgToolBar title="导出Excel" icon="icon-search" onclick="houseAssetsListExportXls();"></t:dgToolBar>
  </t:datagrid>
  </div>
 </div>
 <script type="text/javascript" charset="utf-8">
function houseAssetsListExportXls() {
		JeecgExcelExport("houseAssetsController.do?exportXls","houseAssetsList");
	}
</script>
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
<div class="easyui-panel" style="padding: 1px;" fit="true" border="false" id="houseFjListpanel"></div>
</div>
<script type="text/javascript">

$(function() {
	var li_east = 0;
});

function queryFjByRowData(rowData){
	$('#houseFjListpanel').panel("refresh", "houseFjController.do?houseFj&hid=" + rowData.id);
}

function queryFjByHid(hid){
	$('#houseFjListpanel').panel("refresh", "houseFjController.do?houseFj&hid=" + hid);
}
</script>
 <script src = "webpage/com/fgoa/houseassets/houseAssetsList.js"></script>		
 <script type="text/javascript">
 $(document).ready(function(){
 		//给时间控件加上样式
 			$("#houseAssetsListtb").find("input[name='achieveTime_begin']").attr("class","Wdate").attr("style","height:20px;width:90px;").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#houseAssetsListtb").find("input[name='achieveTime_end']").attr("class","Wdate").attr("style","height:20px;width:90px;").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#houseAssetsListtb").find("input[name='certificateTime_begin']").attr("class","Wdate").attr("style","height:20px;width:90px;").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#houseAssetsListtb").find("input[name='certificateTime_end']").attr("class","Wdate").attr("style","height:20px;width:90px;").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#houseAssetsListtb").find("input[name='leaseTime_begin']").attr("class","Wdate").attr("style","height:20px;width:90px;").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#houseAssetsListtb").find("input[name='leaseTime_end']").attr("class","Wdate").attr("style","height:20px;width:90px;").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 });
 </script>