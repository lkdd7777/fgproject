<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<script type="text/javascript">
	$('#addTUserTxjsBtn').linkbutton({   
	    iconCls: 'icon-add'  
	});  
	$('#delTUserTxjsBtn').linkbutton({   
	    iconCls: 'icon-remove'  
	}); 
	$('#addTUserTxjsBtn').bind('click', function(){   
 		 var tr =  $("#add_tUserTxjs_table_template tr").clone();
	 	 $("#add_tUserTxjs_table").append(tr);
	 	 resetTrNum('add_tUserTxjs_table');
    });  
	$('#delTUserTxjsBtn').bind('click', function(){   
      	$("#add_tUserTxjs_table").find("input:checked").parent().parent().remove();   
        resetTrNum('add_tUserTxjs_table'); 
    }); 
    $(document).ready(function(){
    	$(".datagrid-toolbar").parent().css("width","auto");
    	if(location.href.indexOf("load=detail")!=-1){
			$(":input").attr("disabled","true");
			$(".datagrid-toolbar").hide();
			$(":input").each(function(){
				var $thisThing = $(this);
				$thisThing.attr("title",$thisThing.val());
			});
		}
    });
</script>
<div style="padding: 3px; height: 25px;width:auto;" class="datagrid-toolbar">
	<a id="addTUserTxjsBtn" href="#">添加</a> <a id="delTUserTxjsBtn" href="#">删除</a> 
</div>
<div style="width: auto;height: 300px;overflow-y:auto;overflow-x:scroll;">
<table border="0" cellpadding="2" cellspacing="0" id="tUserTxjs_table">
	<tr bgcolor="#E6E6E6">
		<td align="center" bgcolor="#EEEEEE"><label class="Validform_label">序号</label></td>
		<td align="center" bgcolor="#EEEEEE"><label class="Validform_label">操作</label></td>
				  <td align="left" bgcolor="#EEEEEE">
				  <label class="Validform_label">
								调整时间
							</label></td>
				  <td align="left" bgcolor="#EEEEEE">
				  <label class="Validform_label">
								调薪前金额
							</label></td>
				  <td align="left" bgcolor="#EEEEEE">
				  <label class="Validform_label">
								调薪后金额
							</label></td>
				  <td align="left" bgcolor="#EEEEEE">
				  <label class="Validform_label">
								调薪文号
							</label></td>
				  <td align="left" bgcolor="#EEEEEE">
				  <label class="Validform_label">
								调薪备注
							</label></td>
				  <td align="left" bgcolor="#EEEEEE">
				  <label class="Validform_label">
								调薪原因
							</label></td>
	</tr>
	<tbody id="add_tUserTxjs_table">	
	<c:if test="${fn:length(tUserTxjsList)  <= 0 }">
			<tr>
				<td align="center"><div style="width: 25px;" name="xh">1</div></td>
				<td align="center"><input style="width:20px;"  type="checkbox" name="ck"/></td>
					<input name="tUserTxjsList[0].id" type="hidden"/>
					<input name="tUserTxjsList[0].uid" type="hidden"/>
				  <td align="left">
					  	<input name="tUserTxjsList[0].tzsj" maxlength="100" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					               >
					  <label class="Validform_label" style="display: none;">调整时间</label>
					</td>
				  <td align="left">
					  	<input name="tUserTxjsList[0].txqje" maxlength="100" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					               >
					  <label class="Validform_label" style="display: none;">调薪前金额</label>
					</td>
				  <td align="left">
					  	<input name="tUserTxjsList[0].txhje" maxlength="100" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					               >
					  <label class="Validform_label" style="display: none;">调薪后金额</label>
					</td>
				  <td align="left">
					  	<input name="tUserTxjsList[0].txwh" maxlength="100" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					               >
					  <label class="Validform_label" style="display: none;">调薪文号</label>
					</td>
				  <td align="left">
					  	<input name="tUserTxjsList[0].txbz" maxlength="100" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					               >
					  <label class="Validform_label" style="display: none;">调薪备注</label>
					</td>
				  <td align="left">
					  	<input name="tUserTxjsList[0].txyy" maxlength="100" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					               >
					  <label class="Validform_label" style="display: none;">调薪原因</label>
					</td>
   			</tr>
	</c:if>
	<c:if test="${fn:length(tUserTxjsList)  > 0 }">
		<c:forEach items="${tUserTxjsList}" var="poVal" varStatus="stuts">
			<tr>
				<td align="center"><div style="width: 25px;" name="xh">${stuts.index+1 }</div></td>
				<td align="center"><input style="width:20px;"  type="checkbox" name="ck" /></td>
					<input name="tUserTxjsList[${stuts.index }].id" type="hidden" value="${poVal.id }"/>
					<input name="tUserTxjsList[${stuts.index }].uid" type="hidden" value="${poVal.uid }"/>
				   <td align="left">
					  	<input name="tUserTxjsList[${stuts.index }].tzsj" maxlength="100" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					                value="${poVal.tzsj }">
					  <label class="Validform_label" style="display: none;">调整时间</label>
				   </td>
				   <td align="left">
					  	<input name="tUserTxjsList[${stuts.index }].txqje" maxlength="100" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					                value="${poVal.txqje }">
					  <label class="Validform_label" style="display: none;">调薪前金额</label>
				   </td>
				   <td align="left">
					  	<input name="tUserTxjsList[${stuts.index }].txhje" maxlength="100" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					                value="${poVal.txhje }">
					  <label class="Validform_label" style="display: none;">调薪后金额</label>
				   </td>
				   <td align="left">
					  	<input name="tUserTxjsList[${stuts.index }].txwh" maxlength="100" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					                value="${poVal.txwh }">
					  <label class="Validform_label" style="display: none;">调薪文号</label>
				   </td>
				   <td align="left">
					  	<input name="tUserTxjsList[${stuts.index }].txbz" maxlength="100" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					                value="${poVal.txbz }">
					  <label class="Validform_label" style="display: none;">调薪备注</label>
				   </td>
				   <td align="left">
					  	<input name="tUserTxjsList[${stuts.index }].txyy" maxlength="100" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					                value="${poVal.txyy }">
					  <label class="Validform_label" style="display: none;">调薪原因</label>
				   </td>
   			</tr>
		</c:forEach>
	</c:if>	
	</tbody>
</table>
</div>