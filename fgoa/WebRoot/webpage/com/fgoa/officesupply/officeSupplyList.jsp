<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<script type="text/javascript" charset="utf-8">
function officeListExportXls() {
		JeecgExcelExport("officeSupplyController.do?exportXls","officeSupplyList");
	}
</script>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:1px;">
  <t:datagrid name="officeSupplyList" checkbox="true" fitColumns="false" title="办公用品管理" actionUrl="officeSupplyController.do?datagrid" idField="id" fit="true" queryMode="group">
   <t:dgCol title="主键"  field="id"  hidden="false"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="序号"  field="myorder"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="中心名称"  field="guestname"  hidden="true" query="true" queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="分类"  field="devicetype"  hidden="true" query="true" queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="产品名称"  field="devicename"  hidden="true" query="true" queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="采购时间"  field="purchasedate" formatter="yyyy-MM-dd" hidden="true" query="true" queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="单位"  field="unit"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="数量"  field="number"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="单价"  field="price"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="金额"  field="money"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="申请科室"  field="depart"  hidden="true" query="true" queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="签收备注"  field="remark"  hidden="true" query="true" queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <t:dgDelOpt title="删除" url="officeSupplyController.do?doDel&id={id}" />
   <t:dgToolBar title="录入" icon="icon-add" url="officeSupplyController.do?goAdd" funname="add"></t:dgToolBar>
   <t:dgToolBar title="编辑" icon="icon-edit" url="officeSupplyController.do?goUpdate" funname="update"></t:dgToolBar>
   <t:dgToolBar title="批量删除"  icon="icon-remove" url="officeSupplyController.do?doBatchDel" funname="deleteALLSelect"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="officeSupplyController.do?goUpdate" funname="detail"></t:dgToolBar>
   <t:dgToolBar title="导出Excel" icon="icon-search" onclick="officeListExportXls();"></t:dgToolBar>
    </t:datagrid>
  </div>
 </div>
 <script src = "webpage/com/fgoa/officesupply/officeSupplyList.js"></script>		
 <script type="text/javascript">
 $(document).ready(function(){
 		//给时间控件加上样式
 		$("#officeSupplyListtb").find("input[name='purchasedate']").attr("class","Wdate").attr("style","height:20px;width:90px;").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#officeSupplyListtb").find("input[name='purchasedate_begin']").attr("class","Wdate").attr("style","height:20px;width:90px;").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#officeSupplyListtb").find("input[name='purchasedate_end']").attr("class","Wdate").attr("style","height:20px;width:90px;").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 });
 </script>