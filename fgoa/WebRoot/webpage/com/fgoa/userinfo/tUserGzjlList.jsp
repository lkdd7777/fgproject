<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<script type="text/javascript">
	$('#addTUserGzjlBtn').linkbutton({   
	    iconCls: 'icon-add'  
	});  
	$('#delTUserGzjlBtn').linkbutton({   
	    iconCls: 'icon-remove'  
	}); 
	$('#addTUserGzjlBtn').bind('click', function(){   
 		 var tr =  $("#add_tUserGzjl_table_template tr").clone();
	 	 $("#add_tUserGzjl_table").append(tr);
	 	 resetTrNum('add_tUserGzjl_table');
    });  
	$('#delTUserGzjlBtn').bind('click', function(){   
      	$("#add_tUserGzjl_table").find("input:checked").parent().parent().remove();   
        resetTrNum('add_tUserGzjl_table'); 
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
	<a id="addTUserGzjlBtn" href="#">添加</a> <a id="delTUserGzjlBtn" href="#">删除</a> 
</div>
<div style="width: auto;height: 300px;overflow-y:auto;overflow-x:scroll;">
<table border="0" cellpadding="2" cellspacing="0" id="tUserGzjl_table">
	<tr bgcolor="#E6E6E6">
		<td align="center" bgcolor="#EEEEEE"><label class="Validform_label">序号</label></td>
		<td align="center" bgcolor="#EEEEEE"><label class="Validform_label">操作</label></td>
				  <td align="left" bgcolor="#EEEEEE">
				  <label class="Validform_label">
								入职时间
							</label></td>
				  <td align="left" bgcolor="#EEEEEE">
				  <label class="Validform_label">
								离职时间
							</label></td>
				  <td align="left" bgcolor="#EEEEEE">
				  <label class="Validform_label">
								工作单位
							</label></td>
				  <td align="left" bgcolor="#EEEEEE">
				  <label class="Validform_label">
								职务
							</label></td>
				  <td align="left" bgcolor="#EEEEEE">
				  <label class="Validform_label">
								离职原因
							</label></td>
				  <td align="left" bgcolor="#EEEEEE">
				  <label class="Validform_label">
								工作经历备注
							</label></td>
	</tr>
	<tbody id="add_tUserGzjl_table">	
	<c:if test="${fn:length(tUserGzjlList)  <= 0 }">
			<tr>
				<td align="center"><div style="width: 25px;" name="xh">1</div></td>
				<td align="center"><input style="width:20px;"  type="checkbox" name="ck"/></td>
					<input name="tUserGzjlList[0].id" type="hidden"/>
					<input name="tUserGzjlList[0].uid" type="hidden"/>
				  <td align="left">
					  	<input name="tUserGzjlList[0].rzsj" maxlength="100" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					               >
					  <label class="Validform_label" style="display: none;">入职时间</label>
					</td>
				  <td align="left">
					  	<input name="tUserGzjlList[0].lzsj" maxlength="100" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					               >
					  <label class="Validform_label" style="display: none;">离职时间</label>
					</td>
				  <td align="left">
					  	<input name="tUserGzjlList[0].gzdw" maxlength="100" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					               >
					  <label class="Validform_label" style="display: none;">工作单位</label>
					</td>
				  <td align="left">
					  	<input name="tUserGzjlList[0].zw" maxlength="100" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					               >
					  <label class="Validform_label" style="display: none;">职务</label>
					</td>
				  <td align="left">
					  	<input name="tUserGzjlList[0].lzyy" maxlength="100" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					               >
					  <label class="Validform_label" style="display: none;">离职原因</label>
					</td>
				  <td align="left">
					  	<input name="tUserGzjlList[0].gzjlbz" maxlength="100" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					               >
					  <label class="Validform_label" style="display: none;">工作经历备注</label>
					</td>
   			</tr>
	</c:if>
	<c:if test="${fn:length(tUserGzjlList)  > 0 }">
		<c:forEach items="${tUserGzjlList}" var="poVal" varStatus="stuts">
			<tr>
				<td align="center"><div style="width: 25px;" name="xh">${stuts.index+1 }</div></td>
				<td align="center"><input style="width:20px;"  type="checkbox" name="ck" /></td>
					<input name="tUserGzjlList[${stuts.index }].id" type="hidden" value="${poVal.id }"/>
					<input name="tUserGzjlList[${stuts.index }].uid" type="hidden" value="${poVal.uid }"/>
				   <td align="left">
					  	<input name="tUserGzjlList[${stuts.index }].rzsj" maxlength="100" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					                value="${poVal.rzsj }">
					  <label class="Validform_label" style="display: none;">入职时间</label>
				   </td>
				   <td align="left">
					  	<input name="tUserGzjlList[${stuts.index }].lzsj" maxlength="100" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					                value="${poVal.lzsj }">
					  <label class="Validform_label" style="display: none;">离职时间</label>
				   </td>
				   <td align="left">
					  	<input name="tUserGzjlList[${stuts.index }].gzdw" maxlength="100" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					                value="${poVal.gzdw }">
					  <label class="Validform_label" style="display: none;">工作单位</label>
				   </td>
				   <td align="left">
					  	<input name="tUserGzjlList[${stuts.index }].zw" maxlength="100" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					                value="${poVal.zw }">
					  <label class="Validform_label" style="display: none;">职务</label>
				   </td>
				   <td align="left">
					  	<input name="tUserGzjlList[${stuts.index }].lzyy" maxlength="100" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					                value="${poVal.lzyy }">
					  <label class="Validform_label" style="display: none;">离职原因</label>
				   </td>
				   <td align="left">
					  	<input name="tUserGzjlList[${stuts.index }].gzjlbz" maxlength="100" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					                value="${poVal.gzjlbz }">
					  <label class="Validform_label" style="display: none;">工作经历备注</label>
				   </td>
   			</tr>
		</c:forEach>
	</c:if>	
	</tbody>
</table>
</div>