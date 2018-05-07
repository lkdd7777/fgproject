<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<script type="text/javascript">
	$('#addTUserJtcyBtn').linkbutton({   
	    iconCls: 'icon-add'  
	});  
	$('#delTUserJtcyBtn').linkbutton({   
	    iconCls: 'icon-remove'  
	}); 
	$('#addTUserJtcyBtn').bind('click', function(){   
 		 var tr =  $("#add_tUserJtcy_table_template tr").clone();
	 	 $("#add_tUserJtcy_table").append(tr);
	 	 resetTrNum('add_tUserJtcy_table');
    });  
	$('#delTUserJtcyBtn').bind('click', function(){   
      	$("#add_tUserJtcy_table").find("input:checked").parent().parent().remove();   
        resetTrNum('add_tUserJtcy_table'); 
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
	<a id="addTUserJtcyBtn" href="#">添加</a> <a id="delTUserJtcyBtn" href="#">删除</a> 
</div>
<div style="width: auto;height: 300px;overflow-y:auto;overflow-x:scroll;">
<table border="0" cellpadding="2" cellspacing="0" id="tUserJtcy_table">
	<tr bgcolor="#E6E6E6">
		<td align="center" bgcolor="#EEEEEE"><label class="Validform_label">序号</label></td>
		<td align="center" bgcolor="#EEEEEE"><label class="Validform_label">操作</label></td>
				  <td align="left" bgcolor="#EEEEEE">
				  <label class="Validform_label">
								姓名
							</label></td>
				  <td align="left" bgcolor="#EEEEEE">
				  <label class="Validform_label">
								关系
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
								电话
							</label></td>
				  <td align="left" bgcolor="#EEEEEE">
				  <label class="Validform_label">
								家庭成员备注
							</label></td>
	</tr>
	<tbody id="add_tUserJtcy_table">	
	<c:if test="${fn:length(tUserJtcyList)  <= 0 }">
			<tr>
				<td align="center"><div style="width: 25px;" name="xh">1</div></td>
				<td align="center"><input style="width:20px;"  type="checkbox" name="ck"/></td>
					<input name="tUserJtcyList[0].id" type="hidden"/>
					<input name="tUserJtcyList[0].uid" type="hidden"/>
				  <td align="left">
					  	<input name="tUserJtcyList[0].xm" maxlength="50" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					               >
					  <label class="Validform_label" style="display: none;">姓名</label>
					</td>
				  <td align="left">
					  	<input name="tUserJtcyList[0].gx" maxlength="50" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					               >
					  <label class="Validform_label" style="display: none;">关系</label>
					</td>
				  <td align="left">
					  	<input name="tUserJtcyList[0].gzdw" maxlength="100" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					               >
					  <label class="Validform_label" style="display: none;">工作单位</label>
					</td>
				  <td align="left">
					  	<input name="tUserJtcyList[0].zw" maxlength="50" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					               >
					  <label class="Validform_label" style="display: none;">职务</label>
					</td>
				  <td align="left">
					  	<input name="tUserJtcyList[0].dh" maxlength="50" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					               >
					  <label class="Validform_label" style="display: none;">电话</label>
					</td>
				  <td align="left">
					  	<input name="tUserJtcyList[0].jtcybz" maxlength="100" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					               >
					  <label class="Validform_label" style="display: none;">家庭成员备注</label>
					</td>
   			</tr>
	</c:if>
	<c:if test="${fn:length(tUserJtcyList)  > 0 }">
		<c:forEach items="${tUserJtcyList}" var="poVal" varStatus="stuts">
			<tr>
				<td align="center"><div style="width: 25px;" name="xh">${stuts.index+1 }</div></td>
				<td align="center"><input style="width:20px;"  type="checkbox" name="ck" /></td>
					<input name="tUserJtcyList[${stuts.index }].id" type="hidden" value="${poVal.id }"/>
					<input name="tUserJtcyList[${stuts.index }].uid" type="hidden" value="${poVal.uid }"/>
				   <td align="left">
					  	<input name="tUserJtcyList[${stuts.index }].xm" maxlength="50" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					                value="${poVal.xm }">
					  <label class="Validform_label" style="display: none;">姓名</label>
				   </td>
				   <td align="left">
					  	<input name="tUserJtcyList[${stuts.index }].gx" maxlength="50" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					                value="${poVal.gx }">
					  <label class="Validform_label" style="display: none;">关系</label>
				   </td>
				   <td align="left">
					  	<input name="tUserJtcyList[${stuts.index }].gzdw" maxlength="100" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					                value="${poVal.gzdw }">
					  <label class="Validform_label" style="display: none;">工作单位</label>
				   </td>
				   <td align="left">
					  	<input name="tUserJtcyList[${stuts.index }].zw" maxlength="50" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					                value="${poVal.zw }">
					  <label class="Validform_label" style="display: none;">职务</label>
				   </td>
				   <td align="left">
					  	<input name="tUserJtcyList[${stuts.index }].dh" maxlength="50" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					                value="${poVal.dh }">
					  <label class="Validform_label" style="display: none;">电话</label>
				   </td>
				   <td align="left">
					  	<input name="tUserJtcyList[${stuts.index }].jtcybz" maxlength="100" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					                value="${poVal.jtcybz }">
					  <label class="Validform_label" style="display: none;">家庭成员备注</label>
				   </td>
   			</tr>
		</c:forEach>
	</c:if>	
	</tbody>
</table>
</div>