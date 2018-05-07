<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<script type="text/javascript">
	$('#addTUserPxjlBtn').linkbutton({   
	    iconCls: 'icon-add'  
	});  
	$('#delTUserPxjlBtn').linkbutton({   
	    iconCls: 'icon-remove'  
	}); 
	$('#addTUserPxjlBtn').bind('click', function(){   
 		 var tr =  $("#add_tUserPxjl_table_template tr").clone();
	 	 $("#add_tUserPxjl_table").append(tr);
	 	 resetTrNum('add_tUserPxjl_table');
    });  
	$('#delTUserPxjlBtn').bind('click', function(){   
      	$("#add_tUserPxjl_table").find("input:checked").parent().parent().remove();   
        resetTrNum('add_tUserPxjl_table'); 
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
	<a id="addTUserPxjlBtn" href="#">添加</a> <a id="delTUserPxjlBtn" href="#">删除</a> 
</div>
<div style="width: auto;height: 300px;overflow-y:auto;overflow-x:scroll;">
<table border="0" cellpadding="2" cellspacing="0" id="tUserPxjl_table">
	<tr bgcolor="#E6E6E6">
		<td align="center" bgcolor="#EEEEEE"><label class="Validform_label">序号</label></td>
		<td align="center" bgcolor="#EEEEEE"><label class="Validform_label">操作</label></td>
				  <td align="left" bgcolor="#EEEEEE">
				  <label class="Validform_label">
								培训组织部门
							</label></td>
				  <td align="left" bgcolor="#EEEEEE">
				  <label class="Validform_label">
								培训地点
							</label></td>
				  <td align="left" bgcolor="#EEEEEE">
				  <label class="Validform_label">
								培训时间
							</label></td>
				  <td align="left" bgcolor="#EEEEEE">
				  <label class="Validform_label">
								培训经费
							</label></td>
				  <td align="left" bgcolor="#EEEEEE">
				  <label class="Validform_label">
								培训结果
							</label></td>
				  <td align="left" bgcolor="#EEEEEE">
				  <label class="Validform_label">
								单位培训备注
							</label></td>
	</tr>
	<tbody id="add_tUserPxjl_table">	
	<c:if test="${fn:length(tUserPxjlList)  <= 0 }">
			<tr>
				<td align="center"><div style="width: 25px;" name="xh">1</div></td>
				<td align="center"><input style="width:20px;"  type="checkbox" name="ck"/></td>
					<input name="tUserPxjlList[0].id" type="hidden"/>
					<input name="tUserPxjlList[0].uid" type="hidden"/>
				  <td align="left">
					  	<input name="tUserPxjlList[0].pxzzbm" maxlength="100" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					               >
					  <label class="Validform_label" style="display: none;">培训组织部门</label>
					</td>
				  <td align="left">
					  	<input name="tUserPxjlList[0].pxdd" maxlength="100" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					               >
					  <label class="Validform_label" style="display: none;">培训地点</label>
					</td>
				  <td align="left">
					  	<input name="tUserPxjlList[0].pxsj" maxlength="100" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					               >
					  <label class="Validform_label" style="display: none;">培训时间</label>
					</td>
				  <td align="left">
					  	<input name="tUserPxjlList[0].pxjf" maxlength="100" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					               >
					  <label class="Validform_label" style="display: none;">培训经费</label>
					</td>
				  <td align="left">
					  	<input name="tUserPxjlList[0].pxjg" maxlength="100" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					               >
					  <label class="Validform_label" style="display: none;">培训结果</label>
					</td>
				  <td align="left">
					  	<input name="tUserPxjlList[0].dwpxbz" maxlength="100" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					               >
					  <label class="Validform_label" style="display: none;">单位培训备注</label>
					</td>
   			</tr>
	</c:if>
	<c:if test="${fn:length(tUserPxjlList)  > 0 }">
		<c:forEach items="${tUserPxjlList}" var="poVal" varStatus="stuts">
			<tr>
				<td align="center"><div style="width: 25px;" name="xh">${stuts.index+1 }</div></td>
				<td align="center"><input style="width:20px;"  type="checkbox" name="ck" /></td>
					<input name="tUserPxjlList[${stuts.index }].id" type="hidden" value="${poVal.id }"/>
					<input name="tUserPxjlList[${stuts.index }].uid" type="hidden" value="${poVal.uid }"/>
				   <td align="left">
					  	<input name="tUserPxjlList[${stuts.index }].pxzzbm" maxlength="100" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					                value="${poVal.pxzzbm }">
					  <label class="Validform_label" style="display: none;">培训组织部门</label>
				   </td>
				   <td align="left">
					  	<input name="tUserPxjlList[${stuts.index }].pxdd" maxlength="100" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					                value="${poVal.pxdd }">
					  <label class="Validform_label" style="display: none;">培训地点</label>
				   </td>
				   <td align="left">
					  	<input name="tUserPxjlList[${stuts.index }].pxsj" maxlength="100" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					                value="${poVal.pxsj }">
					  <label class="Validform_label" style="display: none;">培训时间</label>
				   </td>
				   <td align="left">
					  	<input name="tUserPxjlList[${stuts.index }].pxjf" maxlength="100" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					                value="${poVal.pxjf }">
					  <label class="Validform_label" style="display: none;">培训经费</label>
				   </td>
				   <td align="left">
					  	<input name="tUserPxjlList[${stuts.index }].pxjg" maxlength="100" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					                value="${poVal.pxjg }">
					  <label class="Validform_label" style="display: none;">培训结果</label>
				   </td>
				   <td align="left">
					  	<input name="tUserPxjlList[${stuts.index }].dwpxbz" maxlength="100" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					                value="${poVal.dwpxbz }">
					  <label class="Validform_label" style="display: none;">单位培训备注</label>
				   </td>
   			</tr>
		</c:forEach>
	</c:if>	
	</tbody>
</table>
</div>