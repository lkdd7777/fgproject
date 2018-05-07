<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>上传附件</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
  <script type="text/javascript" src="plug-in/ckeditor_new/ckeditor.js"></script>
  <script type="text/javascript" src="plug-in/ckfinder/ckfinder.js"></script>
  <script type="text/javascript">
  //编写自定义JS代码
  </script>
 </head>
 <body>
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="userFjController.do?doUpdate" tiptype="1">
					<input id="id" name="id" type="hidden" value="${userFjPage.id }">
					<input id="uid" name="uid" type="hidden" value="${userFjPage.uid }">
		<table style="width: 600px;" cellpadding="0" cellspacing="1" class="formtable">
					<tr>
						<td align="right">
							<label class="Validform_label">
								文件描述:
							</label>
						</td>
						<td class="value">
						     	 <input id="wjms" name="wjms" type="text" style="width: 150px" class="inputxt"  
									               
									                 value='${userFjPage.wjms}'>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">文件描述</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								文件路径:
							</label>
						</td>
						<td class="value">
									  <input type="hidden" id="wjlj" name="wjlj" value='${userFjPage.wjlj}'/>
										<c:if test="${userFjPage.wjlj==''}">
											<a   target="_blank" id="wjlj_href">暂时未上传文件</a>
										</c:if>
										<c:if test="${userFjPage.wjlj!=''}">
											<a href="${userFjPage.wjlj}"  target="_blank" id="wjlj_href">下载</a>
										</c:if>
									   <input class="ui-button" type="button" value="上传附件"
													onclick="browseFiles('wjlj','wjlj_href')"/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">文件路径</label>
						</td>
					</tr>
			</table>
		</t:formvalid>
 </body>
  <script src = "webpage/com/fgoa/userinfo/userFj.js"></script>		