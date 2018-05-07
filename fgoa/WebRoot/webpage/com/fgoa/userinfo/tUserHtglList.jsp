<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<script type="text/javascript">
	$('#addTUserHtglBtn').linkbutton({   
	    iconCls: 'icon-add'  
	});  
	$('#delTUserHtglBtn').linkbutton({   
	    iconCls: 'icon-remove'  
	}); 
	$('#addTUserHtglBtn').bind('click', function(){   
 		 var tr =  $("#add_tUserHtgl_table_template tr").clone();
	 	 $("#add_tUserHtgl_table").append(tr);
	 	 resetTrNum('add_tUserHtgl_table');
    });  
	$('#delTUserHtglBtn').bind('click', function(){   
      	$("#add_tUserHtgl_table").find("input:checked").parent().parent().remove();   
        resetTrNum('add_tUserHtgl_table'); 
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
	<a id="addTUserHtglBtn" href="#">添加</a> <a id="delTUserHtglBtn" href="#">删除</a> 
</div>
<div style="width: auto;height: 300px;overflow-y:auto;overflow-x:scroll;">
<table border="0" cellpadding="2" cellspacing="0" id="tUserHtgl_table">
	<tr bgcolor="#E6E6E6">
		<td align="center" bgcolor="#EEEEEE"><label class="Validform_label">序号</label></td>
		<td align="center" bgcolor="#EEEEEE"><label class="Validform_label">操作</label></td>
				  <td align="left" bgcolor="#EEEEEE">
				  <label class="Validform_label">
								合同编号
							</label></td>
				  <td align="left" bgcolor="#EEEEEE">
				  <label class="Validform_label">
								事业编制合同
							</label></td>
				  <td align="left" bgcolor="#EEEEEE">
				  <label class="Validform_label">
								签约合同时间
							</label></td>
				  <td align="left" bgcolor="#EEEEEE">
				  <label class="Validform_label">
								合同到期时间
							</label></td>
				  <td align="left" bgcolor="#EEEEEE">
				  <label class="Validform_label">
								续签时间
							</label></td>
				  <td align="left" bgcolor="#EEEEEE">
				  <label class="Validform_label">
								合同管理备注
							</label></td>
	</tr>
	<tbody id="add_tUserHtgl_table">	
	<c:if test="${fn:length(tUserHtglList)  <= 0 }">
			<tr>
				<td align="center"><div style="width: 25px;" name="xh">1</div></td>
				<td align="center"><input style="width:20px;"  type="checkbox" name="ck"/></td>
					<input name="tUserHtglList[0].id" type="hidden"/>
					<input name="tUserHtglList[0].uid" type="hidden"/>
				  <td align="left">
					  	<input name="tUserHtglList[0].htbh" maxlength="100" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					               >
					  <label class="Validform_label" style="display: none;">合同编号</label>
					</td>
				  <td align="left">
					  	<input name="tUserHtglList[0].sybzht" maxlength="100" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					               >
					  <label class="Validform_label" style="display: none;">事业编制合同</label>
					</td>
				  <td align="left">
					  	<input name="tUserHtglList[0].qyhtsj" maxlength="100" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					               >
					  <label class="Validform_label" style="display: none;">签约合同时间</label>
					</td>
				  <td align="left">
					  	<input name="tUserHtglList[0].htdqsj" maxlength="100" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					               >
					  <label class="Validform_label" style="display: none;">合同到期时间</label>
					</td>
				  <td align="left">
					  	<input name="tUserHtglList[0].xqsj" maxlength="100" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					               >
					  <label class="Validform_label" style="display: none;">续签时间</label>
					</td>
				  <td align="left">
					  	<input name="tUserHtglList[0].htglbz" maxlength="100" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					               >
					  <label class="Validform_label" style="display: none;">合同管理备注</label>
					</td>
   			</tr>
	</c:if>
	<c:if test="${fn:length(tUserHtglList)  > 0 }">
		<c:forEach items="${tUserHtglList}" var="poVal" varStatus="stuts">
			<tr>
				<td align="center"><div style="width: 25px;" name="xh">${stuts.index+1 }</div></td>
				<td align="center"><input style="width:20px;"  type="checkbox" name="ck" /></td>
					<input name="tUserHtglList[${stuts.index }].id" type="hidden" value="${poVal.id }"/>
					<input name="tUserHtglList[${stuts.index }].uid" type="hidden" value="${poVal.uid }"/>
				   <td align="left">
					  	<input name="tUserHtglList[${stuts.index }].htbh" maxlength="100" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					                value="${poVal.htbh }">
					  <label class="Validform_label" style="display: none;">合同编号</label>
				   </td>
				   <td align="left">
					  	<input name="tUserHtglList[${stuts.index }].sybzht" maxlength="100" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					                value="${poVal.sybzht }">
					  <label class="Validform_label" style="display: none;">事业编制合同</label>
				   </td>
				   <td align="left">
					  	<input name="tUserHtglList[${stuts.index }].qyhtsj" maxlength="100" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					                value="${poVal.qyhtsj }">
					  <label class="Validform_label" style="display: none;">签约合同时间</label>
				   </td>
				   <td align="left">
					  	<input name="tUserHtglList[${stuts.index }].htdqsj" maxlength="100" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					                value="${poVal.htdqsj }">
					  <label class="Validform_label" style="display: none;">合同到期时间</label>
				   </td>
				   <td align="left">
					  	<input name="tUserHtglList[${stuts.index }].xqsj" maxlength="100" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					                value="${poVal.xqsj }">
					  <label class="Validform_label" style="display: none;">续签时间</label>
				   </td>
				   <td align="left">
					  	<input name="tUserHtglList[${stuts.index }].htglbz" maxlength="100" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					                value="${poVal.htglbz }">
					  <label class="Validform_label" style="display: none;">合同管理备注</label>
				   </td>
   			</tr>
		</c:forEach>
	</c:if>	
	</tbody>
</table>
</div>