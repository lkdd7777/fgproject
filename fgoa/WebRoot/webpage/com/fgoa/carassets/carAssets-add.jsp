<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>tbl_car_assets</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
  <script type="text/javascript" src="plug-in/ckeditor_new/ckeditor.js"></script>
  <script type="text/javascript" src="plug-in/ckfinder/ckfinder.js"></script>
  <script type="text/javascript">
  //编写自定义JS代码
  </script>
 </head>
 <body>
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="carAssetsController.do?doAdd" tiptype="1">
					<input id="id" name="id" type="hidden" value="${carAssetsPage.id }">
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
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							保险:
						</label>
					</td>
					<td class="value">
					     	 <input id="insurance" name="insurance" type="text" style="width: 150px" class="inputxt"  
								               
								               >
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">保险</label>
						</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							过桥费:
						</label>
					</td>
					<td class="value">
					     	 <input id="bridgeToll" name="bridgeToll" type="text" style="width: 150px" class="inputxt"  
								               
								               >
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">过桥费</label>
						</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							油卡充值:
						</label>
					</td>
					<td class="value">
					     	 <input id="cardRecharge" name="cardRecharge" type="text" style="width: 150px" class="inputxt"  
								               
								               >
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">油卡充值</label>
						</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							维修:
						</label>
					</td>
					<td class="value">
					     	 <input id="repairs" name="repairs" type="text" style="width: 150px" class="inputxt"  
								               
								               >
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">维修</label>
						</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							停车费:
						</label>
					</td>
					<td class="value">
					     	 <input id="parkingFee" name="parkingFee" type="text" style="width: 150px" class="inputxt"  
								               
								               >
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">停车费</label>
						</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							用油量:
						</label>
					</td>
					<td class="value">
					     	 <input id="oilCapacity" name="oilCapacity" type="text" style="width: 150px" class="inputxt"  
								               
								               >
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">用油量</label>
						</td>
				</tr>
			</table>
		</t:formvalid>
 </body>
  <script src = "webpage/com/fgoa/carassets/carAssets.js"></script>		