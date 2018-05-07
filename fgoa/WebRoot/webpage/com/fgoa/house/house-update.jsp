<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>房屋资产</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
  <script type="text/javascript">
  //编写自定义JS代码
  </script>
 </head>
 <body>
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="houseController.do?doUpdate" tiptype="1">
					<input id="id" name="id" type="hidden" value="${housePage.id }">
		<table style="width: 600px;" cellpadding="0" cellspacing="1" class="formtable">
					<tr>
						<td align="right">
							<label class="Validform_label">
								房屋简称:
							</label>
						</td>
						<td class="value">
						     	 <input id="housename" name="housename" type="text" style="width: 150px" class="inputxt"  
									               datatype="*"
									                 value='${housePage.housename}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">房屋简称</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								坐落:
							</label>
						</td>
						<td class="value">
						     	 <input id="location" name="location" type="text" style="width: 150px" class="inputxt"  
									               datatype="*"
									                 value='${housePage.location}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">坐落</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								合同备案日期:
							</label>
						</td>
						<td class="value">
									  <input id="contactdate" name="contactdate" type="text" style="width: 150px" 
						      						class="Wdate" onClick="WdatePicker()"
									                
						      						 value='<fmt:formatDate value='${housePage.contactdate}' type="date" pattern="yyyy-MM-dd"/>'>    
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">合同备案日期</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								登记办证日期:
							</label>
						</td>
						<td class="value">
									  <input id="regdate" name="regdate" type="text" style="width: 150px" 
						      						class="Wdate" onClick="WdatePicker()"
									               datatype="*" 
						      						 value='<fmt:formatDate value='${housePage.regdate}' type="date" pattern="yyyy-MM-dd"/>'>    
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">登记办证日期</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								使用现状:
							</label>
						</td>
						<td class="value">
									<t:dictSelect field="status" type="list"
										typeGroupCode="housetype" defaultVal="${housePage.status}" hasLabel="false"  title="使用现状"></t:dictSelect>     
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">使用现状</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								上次出租日期:
							</label>
						</td>
						<td class="value">
									  <input id="prerentdate" name="prerentdate" type="text" style="width: 150px" 
						      						class="Wdate" onClick="WdatePicker()"
									                
						      						 value='<fmt:formatDate value='${housePage.prerentdate}' type="date" pattern="yyyy-MM-dd"/>'>    
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">上次出租日期</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								租期:
							</label>
						</td>
						<td class="value">
						     	 <input id="rentlength" name="rentlength" type="text" style="width: 150px" class="inputxt"  
									    datatype="n1-3" value='${housePage.rentlength}'>年
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">租期</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								出租到期日期:
							</label>
						</td>
						<td class="value">
									  <input id="rentlimitdate" name="rentlimitdate" type="text" style="width: 150px" 
						      						class="Wdate" onClick="WdatePicker()"
									                
						      						 value='<fmt:formatDate value='${housePage.rentlimitdate}' type="date" pattern="yyyy-MM-dd hh:mm:ss"/>'>    
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">出租到期日期</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								租金:
							</label>
						</td>
						<td class="value">
						     	 <input id="price" name="price" type="text" style="width: 150px" class="inputxt"  
									               
									                 value='${housePage.price}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">租金</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								租金支付方式:
							</label>
						</td>
						<td class="value">
						     	 <input id="paytype" name="paytype" type="text" style="width: 150px" class="inputxt"  
									               
									                 value='${housePage.paytype}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">租金支付方式</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								管理手机号:
							</label>
						</td>
						<td class="value">
						     	 <input id="telnum" name="telnum" type="text" style="width: 150px" class="inputxt"  
									               datatype="*"
									                 value='${housePage.telnum}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">管理手机号</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								建筑面积:
							</label>
						</td>
						<td class="value">
						     	 <input id="jzarea" name="jzarea" type="text" style="width: 150px" class="inputxt"  
									               
									                 value='${housePage.jzarea}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">建筑面积</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								土地面积:
							</label>
						</td>
						<td class="value">
						     	 <input id="tdarea" name="tdarea" type="text" style="width: 150px" class="inputxt"  
									               
									                 value='${housePage.tdarea}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">土地面积</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								合同价格:
							</label>
						</td>
						<td class="value">
						     	 <input id="htprice" name="htprice" type="text" style="width: 150px" class="inputxt"  
									               
									                 value='${housePage.htprice}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">合同价格</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								取得时间:
							</label>
						</td>
						<td class="value">
									  <input id="gaindate" name="gaindate" type="text" style="width: 150px" 
						      						class="Wdate" onClick="WdatePicker()"
									                
						      						 value='<fmt:formatDate value='${housePage.gaindate}' type="date" pattern="yyyy-MM-dd"/>'>    
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">取得时间</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								办证时间:
							</label>
						</td>
						<td class="value">
									  <input id="permitdate" name="permitdate" type="text" style="width: 150px" 
						      						class="Wdate" onClick="WdatePicker()"
									                
						      						 value='<fmt:formatDate value='${housePage.permitdate}' type="date" pattern="yyyy-MM-dd"/>'>    
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">办证时间</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								证载用途:
							</label>
						</td>
						<td class="value" colspan="3">
						  	<textarea id="purpose" name="purpose" style="width: 80%" rows="5">${housePage.purpose}</textarea>
							<span class="Validform_checktip"></span>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								权属情况:
							</label>
						</td>
						<td class="value" colspan="3">
						  	 <textarea id="ownsip" name="ownsip" style="width: 80%" rows="5">${housePage.ownsip}</textarea>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">权属情况</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								房屋现状:
							</label>
						</td>
						<td class="value" colspan="3">
						  	<textarea id="useage" name="useage" style="width: 80%" rows="5">${housePage.useage}</textarea>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">房屋现状</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								物业费:
							</label>
						</td>
						<td class="value" colspan="3">
						  	<textarea id="propertyCharge" name="propertyCharge" style="width: 80%" rows="5">${housePage.propertyCharge}</textarea>
							<span class="Validform_checktip"></span>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								水费:
							</label>
						</td>
						<td class="value" colspan="3">
						  	<textarea id="waterCharge" name="waterCharge" style="width: 80%" rows="5">${housePage.waterCharge}</textarea>
							<span class="Validform_checktip"></span>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								电费:
							</label>
						</td>
						<td class="value" colspan="3">
						  	<textarea id="electricityCharge" name="electricityCharge" style="width: 80%" rows="5">${housePage.electricityCharge}</textarea>
							<span class="Validform_checktip"></span>
						</td>
					</tr>
			</table>
		</t:formvalid>
 </body>
  <script src = "webpage/com/fgoa/house/house.js"></script>		