<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<script type="text/javascript">
	$('#addTUserJcjlBtn').linkbutton({   
	    iconCls: 'icon-add'  
	});  
	$('#delTUserJcjlBtn').linkbutton({   
	    iconCls: 'icon-remove'  
	}); 
	$('#addTUserJcjlBtn').bind('click', function(){   
 		 var tr =  $("#add_tUserJcjl_table_template tr").clone();
	 	 $("#add_tUserJcjl_table").append(tr);
	 	 resetTrNum('add_tUserJcjl_table');
    });  
	$('#delTUserJcjlBtn').bind('click', function(){   
      	$("#add_tUserJcjl_table").find("input:checked").parent().parent().remove();   
        resetTrNum('add_tUserJcjl_table'); 
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
	<a id="addTUserJcjlBtn" href="#">添加</a> <a id="delTUserJcjlBtn" href="#">删除</a> 
</div>
<div style="width: auto;height: 300px;overflow-y:auto;overflow-x:scroll;">
<table border="0" cellpadding="2" cellspacing="0" id="tUserJcjl_table">
	<tr bgcolor="#E6E6E6">
		<td align="center" bgcolor="#EEEEEE"><label class="Validform_label">序号</label></td>
		<td align="center" bgcolor="#EEEEEE"><label class="Validform_label">操作</label></td>
				  <td align="left" bgcolor="#EEEEEE">
				  <label class="Validform_label">
								奖惩类别
							</label></td>
				  <td align="left" bgcolor="#EEEEEE">
				  <label class="Validform_label">
								奖惩级别
							</label></td>
				  <td align="left" bgcolor="#EEEEEE">
				  <label class="Validform_label">
								奖惩时间
							</label></td>
				  <td align="left" bgcolor="#EEEEEE">
				  <label class="Validform_label">
								原因
							</label></td>
				  <td align="left" bgcolor="#EEEEEE">
				  <label class="Validform_label">
								结果
							</label></td>
				  <td align="left" bgcolor="#EEEEEE">
				  <label class="Validform_label">
								奖惩记录备注
							</label></td>
	</tr>
	<tbody id="add_tUserJcjl_table">	
	<c:if test="${fn:length(tUserJcjlList)  <= 0 }">
			<tr>
				<td align="center"><div style="width: 25px;" name="xh">1</div></td>
				<td align="center"><input style="width:20px;"  type="checkbox" name="ck"/></td>
					<input name="tUserJcjlList[0].id" type="hidden"/>
					<input name="tUserJcjlList[0].uid" type="hidden"/>
				  <td align="left">
					  	<input name="tUserJcjlList[0].jclb" maxlength="100" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					               >
					  <label class="Validform_label" style="display: none;">奖惩类别</label>
					</td>
				  <td align="left">
					  	<input name="tUserJcjlList[0].jcjb" maxlength="100" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					               >
					  <label class="Validform_label" style="display: none;">奖惩级别</label>
					</td>
				  <td align="left">
					  	<input name="tUserJcjlList[0].jcsj" maxlength="100" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					               >
					  <label class="Validform_label" style="display: none;">奖惩时间</label>
					</td>
				  <td align="left">
					  	<input name="tUserJcjlList[0].yy" maxlength="100" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					               >
					  <label class="Validform_label" style="display: none;">原因</label>
					</td>
				  <td align="left">
					  	<input name="tUserJcjlList[0].jg" maxlength="100" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					               >
					  <label class="Validform_label" style="display: none;">结果</label>
					</td>
				  <td align="left">
					  	<input name="tUserJcjlList[0].jcjlbz" maxlength="100" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					               >
					  <label class="Validform_label" style="display: none;">奖惩记录备注</label>
					</td>
   			</tr>
	</c:if>
	<c:if test="${fn:length(tUserJcjlList)  > 0 }">
		<c:forEach items="${tUserJcjlList}" var="poVal" varStatus="stuts">
			<tr>
				<td align="center"><div style="width: 25px;" name="xh">${stuts.index+1 }</div></td>
				<td align="center"><input style="width:20px;"  type="checkbox" name="ck" /></td>
					<input name="tUserJcjlList[${stuts.index }].id" type="hidden" value="${poVal.id }"/>
					<input name="tUserJcjlList[${stuts.index }].uid" type="hidden" value="${poVal.uid }"/>
				   <td align="left">
					  	<input name="tUserJcjlList[${stuts.index }].jclb" maxlength="100" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					                value="${poVal.jclb }">
					  <label class="Validform_label" style="display: none;">奖惩类别</label>
				   </td>
				   <td align="left">
					  	<input name="tUserJcjlList[${stuts.index }].jcjb" maxlength="100" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					                value="${poVal.jcjb }">
					  <label class="Validform_label" style="display: none;">奖惩级别</label>
				   </td>
				   <td align="left">
					  	<input name="tUserJcjlList[${stuts.index }].jcsj" maxlength="100" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					                value="${poVal.jcsj }">
					  <label class="Validform_label" style="display: none;">奖惩时间</label>
				   </td>
				   <td align="left">
					  	<input name="tUserJcjlList[${stuts.index }].yy" maxlength="100" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					                value="${poVal.yy }">
					  <label class="Validform_label" style="display: none;">原因</label>
				   </td>
				   <td align="left">
					  	<input name="tUserJcjlList[${stuts.index }].jg" maxlength="100" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					                value="${poVal.jg }">
					  <label class="Validform_label" style="display: none;">结果</label>
				   </td>
				   <td align="left">
					  	<input name="tUserJcjlList[${stuts.index }].jcjlbz" maxlength="100" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					                value="${poVal.jcjlbz }">
					  <label class="Validform_label" style="display: none;">奖惩记录备注</label>
				   </td>
   			</tr>
		</c:forEach>
	</c:if>	
	</tbody>
</table>
</div>