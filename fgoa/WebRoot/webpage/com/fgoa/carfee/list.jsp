<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<div id="main_carfee_list"  class="easyui-layout" fit="true">
<div region="center" style="padding: 1px;">
  <t:datagrid name="carList1" checkbox="false" fitColumns="false" title="费用管理" 
  actionUrl="carController.do?datagrid" idField="id" fit="true">
   <t:dgCol title="主键"  field="id"  hidden="false"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="车辆号牌"  field="carnum"  hidden="true" query="false" queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="操作" field="opt" width="150"></t:dgCol>
   <t:dgOpenOpt width="900" height="500" url="carFeeController.do?stat&carid={id}" title="费用统计"></t:dgOpenOpt>
   <t:dgFunOpt funname="queryCarFeeByCar(id)" title="查看费用"></t:dgFunOpt>
  </t:datagrid>
 </div>
</div>
<div data-options="region:'east',
	title:'车辆费用',
	collapsed:false,
	split:true,
	border:false,
	onExpand : function(){
		li_east = 1;
	},
	onCollapse : function() {
	    li_east = 0;
	}"
	style="width: 600px; overflow: hidden;">
<div class="easyui-panel" style="padding: 1px;" fit="true" border="false" id="carfeeListpanel"></div>
</div>
<script type="text/javascript">

$(function() {
	var li_east = 0;
});

function queryCarFeeByRowData(rowData){
	$('#carfeeListpanel').panel("refresh", "carFeeController.do?feelist&carid=" + rowData.id);
}

function queryCarFeeByCar(carid){
	$('#carfeeListpanel').panel("refresh", "carFeeController.do?feelist&carid=" + carid);
}
</script>
