<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>办公用品管理</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
  <script type="text/javascript" src="plug-in/ckeditor_new/ckeditor.js"></script>
  <script type="text/javascript" src="plug-in/ckfinder/ckfinder.js"></script>
  <script type="text/javascript">
  //编写自定义JS代码
  </script>
 </head>
 <body>
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="officeSupplyController.do?doUpdate" tiptype="1">
					<input id="id" name="id" type="hidden" value="${officeSupplyPage.id }">
		<table style="width: 600px;" cellpadding="0" cellspacing="1" class="formtable">					
					<tr>
						<td align="right">
							<label class="Validform_label">
								中心名称:
							</label>
						</td>
						<td class="value">						     	
								<t:dictSelect field="centername" type="list" id="guestname"  defaultVal ='${officeSupplyPage.guestname}'
									typeGroupCode="centername" hasLabel="false"  title="中心名称"></t:dictSelect> 
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">中心名称</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								分类:
							</label>
						</td>
						<td class="value">
								 <t:dictSelect field="devicetype" type="list" id="devicetype"  defaultVal='${officeSupplyPage.devicetype}'
									typeGroupCode="officetp" hasLabel="false"  title="分类"></t:dictSelect>  
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">分类</label>
						</td></tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								产品名称:
							</label>
						</td>
						<td class="value">
						     	 <input id="devicename" name="devicename" type="text" style="width: 200px" class="inputxt"  
									               
									                 value='${officeSupplyPage.devicename}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">产品名称</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								采购时间:
							</label>
						</td>
						<td class="value">
									  <input id="purchasedate" name="purchasedate" type="text" style="width: 200px" 
						      						class="Wdate" onClick="WdatePicker()"
									                
						      						 value='<fmt:formatDate value='${officeSupplyPage.purchasedate}' type="date" pattern="yyyy-MM-dd"/>'>    
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">采购时间</label>
						</td></tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								单位:
							</label>
						</td>
						<td class="value">
								 <t:dictSelect field="unit" type="list" id="unit" defaultVal='${officeSupplyPage.unit}'
									typeGroupCode="officesp" hasLabel="false"  title="单位"></t:dictSelect> 
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">单位</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								数量:
							</label>
						</td>
						<td class="value">
						     	 <input id="number" name="number" type="text" style="width: 200px" class="inputxt"  
									               
									                 value='${officeSupplyPage.number}'>
								  
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">数量</label>
						</td></tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								单价:
							</label>
						</td>
						<td class="value">
						     	 <input id="price" name="price" type="text" style="width: 200px" class="inputxt"  
									               
									                 value='${officeSupplyPage.price}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">单价</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								金额:
							</label>
						</td>
						<td class="value">
						     	 <input id="money" name="money" type="text" style="width: 200px" class="inputxt"  
									               
									                 value='${officeSupplyPage.money}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">金额</label>
						</td></tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								申请科室:
							</label>
						</td>
						<td class="value">
						     	 <input id="depart" name="depart" type="text" style="width: 200px" class="inputxt"  
									               
									                 value='${officeSupplyPage.depart}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">申请科室</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								签收备注:
							</label>
						</td>
						<td class="value">
						  	 	<textarea id="remark"  style="width: 400px" name="remark">${officeSupplyPage.remark}</textarea>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">签收备注</label>
						</td>
				<td align="right">
					<label class="Validform_label">
					</label>
				</td>
				<td class="value">
				</td>
					</tr>
			</table>
		</t:formvalid>
 </body>
  <script src = "webpage/com/fgoa/officesupply/officeSupply.js"></script>		