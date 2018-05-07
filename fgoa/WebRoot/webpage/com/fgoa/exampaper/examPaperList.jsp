<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<script type="text/javascript" charset="utf-8">
function officeListExportXls() {
	JeecgExcelExport("examPaperController.do?exportXls","examPaperList");
}
</script>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:1px;">
  <t:datagrid name="examPaperList" checkbox="true" fitColumns="false" title="评分管理" actionUrl="examPaperController.do?datagrid" idField="id" fit="true" queryMode="group">
   <t:dgCol title="主键"  field="id"  hidden="false"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="姓名"  field="user.realName" hidden="true"  queryMode="single" query="true"  width="120"></t:dgCol>
   <t:dgCol title="科目"  field="examClass.classname" hidden="true" queryMode="single" query="true"  width="200"></t:dgCol>
   <t:dgCol title="得分"  field="score"  hidden="true"  queryMode="single" width="100"></t:dgCol>
   <t:dgCol title="开始时间"  field="starttime" formatter="yyyy-MM-dd hh:mm:ss" hidden="true"  queryMode="single"  width="200"></t:dgCol>
   <t:dgCol title="结束时间"  field="endtime" formatter="yyyy-MM-dd hh:mm:ss" hidden="true"  queryMode="single"  width="200"></t:dgCol>
   <t:dgCol title="是否完成"  field="iscomplete"  hidden="true"  queryMode="single" dictionary="yesorno" width="120"></t:dgCol>
    <%--<t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <t:dgDelOpt title="删除" url="examPaperController.do?doDel&id={id}" /> --%>
   <t:dgToolBar title="录入" icon="icon-add" url="examPaperController.do?goAdd" funname="add"></t:dgToolBar>
   <t:dgToolBar title="编辑" icon="icon-edit" url="examPaperController.do?goUpdate" funname="update"></t:dgToolBar>
   <t:dgToolBar title="批量删除"  icon="icon-remove" url="examPaperController.do?doBatchDel" funname="deleteALLSelect"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="examPaperController.do?goUpdate" funname="detail"></t:dgToolBar>
   <t:dgToolBar title="导出Excel" icon="icon-search" onclick="officeListExportXls();"></t:dgToolBar>
  </t:datagrid>
  </div>
 </div>
 <script src = "webpage/com/fgoa/exampaper/examPaperList.js"></script>		
 <script type="text/javascript">
 $(document).ready(function(){
 		//给时间控件加上样式
 			$("#examPaperListtb").find("input[name='starttime']").attr("class","Wdate").attr("style","height:20px;width:90px;").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#examPaperListtb").find("input[name='endtime']").attr("class","Wdate").attr("style","height:20px;width:90px;").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#examPaperListtb").find("input[name='pausetime']").attr("class","Wdate").attr("style","height:20px;width:90px;").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 });
 </script>