<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<script type="text/javascript" charset="utf-8">
function officeListExportXls() {
		JeecgExcelExport("inboxController.do?exportXls","inboxList");
	}
</script>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:1px;">
  <t:datagrid name="inboxList" checkbox="true" fitColumns="false" title="收文信息表" actionUrl="inboxController.do?datagrid" idField="id" fit="true" queryMode="group">
   <t:dgCol title="主键"  field="id"  hidden="false"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="日期"  field="submitdate" formatter="yyyy-MM-dd" hidden="true" query="true" queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="文号"  field="sortnum"  hidden="true" query="true" queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="标题"  field="title"  hidden="true" query="true" queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="收文单位"  field="orgname"  hidden="true" query="true" queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <t:dgDelOpt title="删除" url="inboxController.do?doDel&id={id}" />
   <t:dgToolBar title="录入" icon="icon-add" url="inboxController.do?goAdd" funname="add"></t:dgToolBar>
   <t:dgToolBar title="编辑" icon="icon-edit" url="inboxController.do?goUpdate" funname="update"></t:dgToolBar>
   <t:dgToolBar title="批量删除"  icon="icon-remove" url="inboxController.do?doBatchDel" funname="deleteALLSelect"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="inboxController.do?goUpdate" funname="detail"></t:dgToolBar>
  <t:dgToolBar title="导出Excel" icon="icon-search" onclick="officeListExportXls();"></t:dgToolBar>
  </t:datagrid>
  </div>
 </div>
 <script src = "webpage/com/fgoa/inbox/inboxList.js"></script>		
 <script type="text/javascript">
 $(document).ready(function(){
 		//给时间控件加上样式
 			$("#inboxListtb").find("input[name='submitdate_begin']").attr("class","Wdate").attr("style","height:20px;width:90px;").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#inboxListtb").find("input[name='submitdate_end']").attr("class","Wdate").attr("style","height:20px;width:90px;").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 });
 </script>