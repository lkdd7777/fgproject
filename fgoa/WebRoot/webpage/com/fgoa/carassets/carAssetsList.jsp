<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:1px;">
  <t:datagrid name="carAssetsList" checkbox="true" fitColumns="false" title="汽车资产" actionUrl="carAssetsController.do?datagrid" idField="id" fit="true" queryMode="group">
   <t:dgCol title="id"  field="id"  hidden="false"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="排序号"  field="sortNum"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="保险"  field="insurance"  hidden="true" query="true" queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="过桥费"  field="bridgeToll"  hidden="true" query="true" queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="油卡充值"  field="cardRecharge"  hidden="true" query="true" queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="维修"  field="repairs"  hidden="true" query="true" queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="停车费"  field="parkingFee"  hidden="true" query="true" queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="用油量"  field="oilCapacity"  hidden="true" query="true" queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <t:dgDelOpt title="删除" url="carAssetsController.do?doDel&id={id}" />
   <t:dgFunOpt funname="queryFjByCid(id)" title="附件上传"></t:dgFunOpt>
   <t:dgToolBar title="录入" icon="icon-add" url="carAssetsController.do?goAdd" funname="add"></t:dgToolBar>
   <t:dgToolBar title="编辑" icon="icon-edit" url="carAssetsController.do?goUpdate" funname="update"></t:dgToolBar>
   <t:dgToolBar title="批量删除"  icon="icon-remove" url="carAssetsController.do?doBatchDel" funname="deleteALLSelect"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="carAssetsController.do?goUpdate" funname="detail"></t:dgToolBar>
   <t:dgToolBar title="导出Excel" icon="icon-search" onclick="carAssetsListExportXls();"></t:dgToolBar>
  </t:datagrid>
  </div>
 </div>
  <script type="text/javascript" charset="utf-8">
function carAssetsListExportXls() {
		JeecgExcelExport("carAssetsController.do?exportXls","carAssetsList");
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
<div class="easyui-panel" style="padding: 1px;" fit="true" border="false" id="carFjListpanel"></div>
</div>
<script type="text/javascript">

$(function() {
	var li_east = 0;
});

function queryFjByRowData(rowData){
	$('#carFjListpanel').panel("refresh", "carFjController.do?carFj&cid=" + rowData.id);
}

function queryFjByCid(cid){
	$('#carFjListpanel').panel("refresh", "carFjController.do?carFj&cid=" + cid);
}
</script>
 <script src = "webpage/com/fgoa/carassets/carAssetsList.js"></script>		
 <script type="text/javascript">
 $(document).ready(function(){
 		//给时间控件加上样式
 });
 </script>