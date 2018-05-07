<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>tbl_house_assets</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
  <script type="text/javascript" src="plug-in/ckeditor_new/ckeditor.js"></script>
  <script type="text/javascript" src="plug-in/ckfinder/ckfinder.js"></script>
  <script type="text/javascript">
  //编写自定义JS代码
  </script>
 </head>
 <body>
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="houseAssetsController.do?doAdd" tiptype="1">
					<input id="id" name="id" type="hidden" value="${houseAssetsPage.id }">
		<table style="width: 600px;" cellpadding="0" cellspacing="1" class="formtable">
				<tr>
					<td align="right">
						<label class="Validform_label">
							排序号:
						</label>
					</td>
					<td class="value">
					     	 <input id="sortNum" name="sortNum" type="text" style="width: 150px" class="inputxt"  
								               
								               >
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">排序号</label>
						</td>
					<td align="right">
						<label class="Validform_label">
							资产地址:
						</label>
					</td>
					<td class="value">
						  	 <textarea id="address" name="address"></textarea>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">资产地址</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							建筑面积:
						</label>
					</td>
					<td class="value">
					     	 <input id="buildingArea" name="buildingArea" type="text" style="width: 150px" class="inputxt"  
								               
								               >
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">建筑面积</label>
						</td>
					<td align="right">
						<label class="Validform_label">
							土地面积:
						</label>
					</td>
					<td class="value">
					     	 <input id="landArea" name="landArea" type="text" style="width: 150px" class="inputxt"  
								               
								               >
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">土地面积</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							合同价款:
						</label>
					</td>
					<td class="value">
					     	 <input id="contractPrice" name="contractPrice" type="text" style="width: 150px" class="inputxt"  
								               
								               >
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">合同价款</label>
						</td>
					<td align="right">
						<label class="Validform_label">
							取得时间:
						</label>
					</td>
					<td class="value">
							   <input id="achieveTime" name="achieveTime" type="text" style="width: 150px" 
					      						class="Wdate" onClick="WdatePicker()"
								                
								               >    
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">取得时间</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							办证时间:
						</label>
					</td>
					<td class="value">
							   <input id="certificateTime" name="certificateTime" type="text" style="width: 150px" 
					      						class="Wdate" onClick="WdatePicker()"
								                
								               >    
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">办证时间</label>
						</td>
					<td align="right">
						<label class="Validform_label">
							证载用途:
						</label>
					</td>
					<td class="value">
						  	 <textarea id="purpose" name="purpose"></textarea>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">证载用途</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							权属情况:
						</label>
					</td>
					<td class="value">
						  	 <textarea id="ownership" name="ownership"></textarea>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">权属情况</label>
						</td>
					<td align="right">
						<label class="Validform_label">
							房屋现状:
						</label>
					</td>
					<td class="value">
						  	 <textarea id="housingSituation" name="housingSituation"></textarea>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">房屋现状</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							租金方式:
						</label>
					</td>
					<td class="value">
							  <t:dictSelect field="rentalType" type="list"
									typeGroupCode="paytype" defaultVal="${houseAssetsPage.rentalType}" hasLabel="false"  title="租金方式"></t:dictSelect>     
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">租金方式</label>
						</td>
					<td align="right">
						<label class="Validform_label">
							租金:
						</label>
					</td>
					<td class="value">
					     	 <input id="rental" name="rental" type="text" style="width: 150px" class="inputxt"  
								               
								               >
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">租金</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							承租时间:
						</label>
					</td>
					<td class="value">
							   <input id="leaseTime" name="leaseTime" type="text" style="width: 150px" 
					      						class="Wdate" onClick="WdatePicker()"
								                
								               >    
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">承租时间</label>
						</td>
					<td align="right">
						<label class="Validform_label">
							租期:
						</label>
					</td>
					<td class="value">
					     	 <input id="lease" name="lease" type="text" style="width: 150px" class="inputxt"  
								               
								               >
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">租期</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							承租人:
						</label>
					</td>
					<td class="value">
					     	 <input id="user" name="user" type="text" style="width: 150px" class="inputxt"  
								               
								               >
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">承租人</label>
						</td>
					<td align="right">
						<label class="Validform_label">
							承租人电话:
						</label>
					</td>
					<td class="value">
					     	 <input id="userPhone" name="userPhone" type="text" style="width: 150px" class="inputxt"  
								               
								               >
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">承租人电话</label>
						</td>
					</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							水电煤等缴费方式:
						</label>
					</td>
					<td class="value">
						  	 <textarea id="other" name="other"></textarea>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">水电煤等缴费方式</label>
						</td>
					<td align="right">
						<label class="Validform_label">
							备注:
						</label>
					</td>
					<td class="value">
						  	 <textarea id="remark" name="remark"></textarea>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">备注</label>
						</td>
					</tr>
			</table>
		</t:formvalid>
 </body>
  <script src = "webpage/com/fgoa/houseassets/houseAssets.js"></script>		