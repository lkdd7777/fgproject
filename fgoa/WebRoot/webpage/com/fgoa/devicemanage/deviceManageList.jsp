<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<script type="text/javascript" charset="utf-8">
function officeListExportXls() {
		JeecgExcelExport("deviceManageController.do?exportXls","deviceManageList");
	}
</script>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:1px;">
  <t:datagrid name="deviceManageList" checkbox="true" fitColumns="false" title="设备管理" actionUrl="deviceManageController.do?datagrid" idField="id" fit="true" queryMode="group">
   <t:dgCol title="主键"  field="id"  hidden="false"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="序号"  field="myorder"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="部门"  field="depart"  hidden="true" query="true" queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="型号"  field="model"  hidden="true" query="true" queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="类型"  field="type"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="设备类型"  field="devicetype"  hidden="true" query="true" queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="购置时间"  field="purchasedate" formatter="yyyy-MM-dd" hidden="true" query="true" queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="基本配置"  field="baseconfig"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="状况"  field="status"  hidden="true" query="true" queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="使用人"  field="user"  hidden="true" query="true" queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="备注"  field="remark"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <t:dgDelOpt title="删除" url="deviceManageController.do?doDel&id={id}" />
   <t:dgToolBar title="录入" icon="icon-add" url="deviceManageController.do?goAdd" funname="add"></t:dgToolBar>
   <t:dgToolBar title="编辑" icon="icon-edit" url="deviceManageController.do?goUpdate" funname="update"></t:dgToolBar>
   <t:dgToolBar title="批量删除"  icon="icon-remove" url="deviceManageController.do?doBatchDel" funname="deleteALLSelect"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="deviceManageController.do?goUpdate" funname="detail"></t:dgToolBar>
   <t:dgToolBar title="导出Excel" icon="icon-search" onclick="officeListExportXls();"></t:dgToolBar>
  </t:datagrid>
  </div>
 </div>
 <script src = "webpage/com/fgoa/devicemanage/deviceManageList.js"></script>		
 <script type="text/javascript">
 $(document).ready(function(){
 		//给时间控件加上样式
 			$("#deviceManageListtb").find("input[name='purchasedate_begin']").attr("class","Wdate").attr("style","height:20px;width:90px;").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#deviceManageListtb").find("input[name='purchasedate_end']").attr("class","Wdate").attr("style","height:20px;width:90px;").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 });
 </script>