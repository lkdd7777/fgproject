<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>考试题库</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
  <script type="text/javascript">
	$(function(){
		$(".table-list").parent().parent().css("width", "auto");
		
		$("#question_type_Sel").change(function(){
			var _question_type_val=$(this).val();
			if(_question_type_val=='single'){
				if($(".answerChck:checked").length>1){
					$(".answerChck").removeAttr("checked");
				}
				$(".answerChck").bind("click",singleSelEvtHandler);
			}else{
				$(".answerChck").unbind("click");
			}
			
			if(_question_type_val=='single' || _question_type_val=='mutiple'){
				$("#judgeAnswerDiv").hide();
				$("#selectAnswerDiv").show();
				
				if(_question_type_val=='mutiple'){
					$(".multiTr").show();
				}else{
					$(".multiTr").hide();
				}
				
				$(".answerText").attr("datatype","*").attr("nullmsg","请输入答案内容！");;
			}else{
				$("input[name='answerContent']").removeAttr("datatype").removeAttr("nullmsg");
				$("#selectAnswerDiv").hide();
				$("#judgeAnswerDiv").show();
			}
		});
		$("#question_type_Sel").trigger("change"); 
		
		function singleSelEvtHandler(){
			$(".answerChck").removeAttr("checked");
	        $(this).attr("checked", true);
		}
		
	});
	function beforeAddExam(){
		var _question_type_val=$("#question_type_Sel").val();
		if(_question_type_val=='single' || _question_type_val=='mutiple'){
			if($(".answerChck:checked").length<1){
				$.messager.alert("缺少必填项","请至少选择一个正确答案","error");
				return false;
			}
		}
	}

  </script>
 </head>
 <body>
  <t:formvalid formid="examForm_add" dialog="true" usePlugin="password" layout="table" action="examQuestionController.do?doAdd" beforeSubmit="beforeAddExam" tiptype="1">
					<input id="id" name="id" type="hidden" value="${examQuestionPage.id }">
		<table style="width: 600px;" cellpadding="0" cellspacing="1" class="formtable">
				<tr>
					<td align="right">
						<label class="Validform_label">
							科目:
						</label>
					</td>
					<td class="value">
					  	<select  name="examClass.id" datatype="*">
							<c:forEach items="${examClasses}" var="examClass">
								<option value="${examClass.id }" <c:if test="${examClass.id==examQuestionPage.examClass.id}">selected="selected"</c:if>>${examClass.classname}</option>
							</c:forEach>
						</select>   
						<span class="Validform_checktip"></span>
						<label class="Validform_label" style="display: none;">科目</label>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							类型:
						</label>
					</td>
					<td class="value">
					  	<t:dictSelect id="question_type_Sel" field="type" type="list"
								typeGroupCode="quetype" defaultVal="${examQuestionPage.type}" hasLabel="false"  title="类型"></t:dictSelect>     
						<span class="Validform_checktip"></span>
						<label class="Validform_label" style="display: none;">类型</label>
					</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							题目:
						</label>
					</td>
					<td class="value">
					  	<textarea id="title" name="title" cols="80" rows="7" datatype="*"></textarea>
						<span class="Validform_checktip"></span>
						<label class="Validform_label" style="display: none;">题目</label>
					</td>
				</tr>
			</table>
			<div id="tabs" class="easyui-tabs" tabPosition="top" fit="false" style="margin: 10px 0px; padding: 0px; overflow: hidden; width: auto;">
			    <div title="答案" style="width: 100%; margin: 0px; padding: 0px; overflow: hidden;">
			    <div id="selectAnswerDiv">
			      	<table class="table-list" style=" width:auto;height: 25px;">
			      		<tr bgcolor="#E6E6E6">
							<th align="center" bgcolor="#EEEEEE" width="600">答案内容</th>
							<th align="center" bgcolor="#EEEEEE">正确</th>
						</tr>
							<tr>
								<td align="left">
									1、<input class="answerText" style="width: 90%;" type="text" name="answerContent"/>
								</td>
								<td align="left"><input class="answerChck" type="checkbox" style="width: 50px;"
									name="isCorrect1"></td>
							</tr>
							<tr>
								<td align="left">
									2、<input class="answerText" style="width: 90%;" type="text" name="answerContent"/>
								</td>
								<td align="left"><input class="answerChck" type="checkbox" style="width: 50px;"
									name="isCorrect2"></td>
							</tr>
							<tr>
								<td align="left">
									3、<input class="answerText" style="width: 90%;" type="text" name="answerContent"/>
								</td>
								<td align="left"><input class="answerChck" type="checkbox" style="width: 50px;"
									name="isCorrect3"></td>
							</tr>
							<tr>
								<td align="left">
									4、<input class="answerText" style="width: 90%;" type="text" name="answerContent"/>
								</td>
								<td align="left"><input class="answerChck" type="checkbox" style="width: 50px;"
									name="isCorrect4"></td>
							</tr>
							<tr class="multiTr">
								<td align="left">
									5、<input style="width: 90%;" type="text" name="answerContent"/>
								</td>
								<td align="left"><input class="answerChck" type="checkbox" style="width: 50px;"
									name="isCorrect5"></td>
							</tr>
							<tr class="multiTr">
								<td align="left">
									6、<input style="width: 90%;" type="text" name="answerContent"/>
								</td>
								<td align="left"><input class="answerChck" type="checkbox" style="width: 50px;"
									name="isCorrect6"></td>
							</tr>
				      </table>
			      </div>
			      <div id="judgeAnswerDiv">
						<tr>
							<td align="left">
								<select name="judgeAnswerContent" style="margin: 4px;">
									<option value="true">正确</option>
									<option value="false">错误</option>
								</select>
							</td>
						</tr>
					</div>
			    </div>
			</div>
		</t:formvalid>
 </body>
  <script src = "webpage/com/fgoa/examquestion/examQuestion.js"></script>		