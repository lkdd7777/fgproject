<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:1px;">
  <t:datagrid name="houseList" checkbox="true" fitColumns="false" title="房屋资产" actionUrl="houseController.do?datagrid" idField="id" fit="true" queryMode="group">
   <t:dgCol title="主键"  field="id"  hidden="false"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="房屋简称"  field="housename"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="坐落"  field="location"  hidden="false"  queryMode="single"  width="200"></t:dgCol>
   <t:dgCol title="合同备案日期"  field="contactdate" formatter="yyyy-MM-dd" hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="登记办证日期"  field="regdate" formatter="yyyy-MM-dd" hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="使用现状"  field="status"  hidden="true"  queryMode="single" dictionary="housetype" width="120"></t:dgCol>
   <t:dgCol title="上次出租日期"  field="prerentdate" formatter="yyyy-MM-dd" hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="租期"  field="rentlength"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="出租到期日期"  field="rentlimitdate" formatter="yyyy-MM-dd" hidden="false"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="租金"  field="price"  hidden="false"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="租金支付方式"  field="paytype"  hidden="false"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="管理手机号"  field="telnum"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="建筑面积"  field="jzarea"  hidden="false"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="土地面积"  field="tdarea"  hidden="false"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="合同价格"  field="htprice"  hidden="false"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="取得时间"  field="gaindate" formatter="yyyy-MM-dd" hidden="false"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="办证时间"  field="permitdate" formatter="yyyy-MM-dd" hidden="false"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="证载用途"  field="purpose"  hidden="false"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="权属情况"  field="ownsip"  hidden="false"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="房屋现状"  field="useage"  hidden="false"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <t:dgDelOpt title="删除" url="houseController.do?doDel&id={id}" />
   <t:dgToolBar title="录入" icon="icon-add" url="houseController.do?goAdd" funname="add"></t:dgToolBar>
   <t:dgToolBar title="编辑" icon="icon-edit" url="houseController.do?goUpdate" funname="update"></t:dgToolBar>
   <t:dgToolBar title="批量删除"  icon="icon-remove" url="houseController.do?doBatchDel" funname="deleteALLSelect"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="houseController.do?goUpdate" funname="detail"></t:dgToolBar>
  </t:datagrid>
  </div>
 </div>
 <script src = "webpage/com/fgoa/house/houseList.js"></script>		
 <script type="text/javascript">
 $(document).ready(function(){
 		//给时间控件加上样式
 			$("#houseListtb").find("input[name='contactdate']").attr("class","Wdate").attr("style","height:20px;width:90px;").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#houseListtb").find("input[name='regdate']").attr("class","Wdate").attr("style","height:20px;width:90px;").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#houseListtb").find("input[name='prerentdate']").attr("class","Wdate").attr("style","height:20px;width:90px;").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#houseListtb").find("input[name='rentlimitdate']").attr("class","Wdate").attr("style","height:20px;width:90px;").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#houseListtb").find("input[name='gaindate']").attr("class","Wdate").attr("style","height:20px;width:90px;").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#houseListtb").find("input[name='permitdate']").attr("class","Wdate").attr("style","height:20px;width:90px;").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 });
 </script>