<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<script type="text/javascript">
	$('#addTUserJyjlBtn').linkbutton({   
	    iconCls: 'icon-add'  
	});  
	$('#delTUserJyjlBtn').linkbutton({   
	    iconCls: 'icon-remove'  
	}); 
	$('#addTUserJyjlBtn').bind('click', function(){   
 		 var tr =  $("#add_tUserJyjl_table_template tr").clone();
	 	 $("#add_tUserJyjl_table").append(tr);
	 	 resetTrNum('add_tUserJyjl_table');
    });  
	$('#delTUserJyjlBtn').bind('click', function(){   
      	$("#add_tUserJyjl_table").find("input:checked").parent().parent().remove();   
        resetTrNum('add_tUserJyjl_table'); 
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
	<a id="addTUserJyjlBtn" href="#">添加</a> <a id="delTUserJyjlBtn" href="#">删除</a> 
</div>
<div style="width: auto;height: 300px;overflow-y:auto;overflow-x:scroll;">
<table border="0" cellpadding="2" cellspacing="0" id="tUserJyjl_table">
	<tr bgcolor="#E6E6E6">
		<td align="center" bgcolor="#EEEEEE"><label class="Validform_label">序号</label></td>
		<td align="center" bgcolor="#EEEEEE"><label class="Validform_label">操作</label></td>
				  <td align="left" bgcolor="#EEEEEE">
				  <label class="Validform_label">
								学校名称
							</label></td>
				  <td align="left" bgcolor="#EEEEEE">
				  <label class="Validform_label">
								入学时间
							</label></td>
				  <td align="left" bgcolor="#EEEEEE">
				  <label class="Validform_label">
								毕业时间
							</label></td>
				  <td align="left" bgcolor="#EEEEEE">
				  <label class="Validform_label">
								所学专业
							</label></td>
				  <td align="left" bgcolor="#EEEEEE">
				  <label class="Validform_label">
								文化程度
							</label></td>
				  <td align="left" bgcolor="#EEEEEE">
				  <label class="Validform_label">
								学位
							</label></td>
				  <td align="left" bgcolor="#EEEEEE">
				  <label class="Validform_label">
								教育经历备注
							</label></td>
	</tr>
	<tbody id="add_tUserJyjl_table">	
	<c:if test="${fn:length(tUserJyjlList)  <= 0 }">
			<tr>
				<td align="center"><div style="width: 25px;" name="xh">1</div></td>
				<td align="center"><input style="width:20px;"  type="checkbox" name="ck"/></td>
					<input name="tUserJyjlList[0].id" type="hidden"/>
					<input name="tUserJyjlList[0].uid" type="hidden"/>
				  <td align="left">
					  	<input name="tUserJyjlList[0].xxmc" maxlength="100" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					               >
					  <label class="Validform_label" style="display: none;">学校名称</label>
					</td>
				  <td align="left">
					  	<input name="tUserJyjlList[0].rxsj" maxlength="100" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					               >
					  <label class="Validform_label" style="display: none;">入学时间</label>
					</td>
				  <td align="left">
					  	<input name="tUserJyjlList[0].bysj" maxlength="100" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					               >
					  <label class="Validform_label" style="display: none;">毕业时间</label>
					</td>
				  <td align="left">
					  	<input name="tUserJyjlList[0].sxzy" maxlength="100" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					               >
					  <label class="Validform_label" style="display: none;">所学专业</label>
					</td>
				  <td align="left">
					  	<input name="tUserJyjlList[0].whcd" maxlength="100" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					               >
					  <label class="Validform_label" style="display: none;">文化程度</label>
					</td>
				  <td align="left">
					  	<input name="tUserJyjlList[0].xw" maxlength="100" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					               >
					  <label class="Validform_label" style="display: none;">学位</label>
					</td>
				  <td align="left">
					  	<input name="tUserJyjlList[0].jyjlbz" maxlength="100" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					               >
					  <label class="Validform_label" style="display: none;">教育经历备注</label>
					</td>
   			</tr>
	</c:if>
	<c:if test="${fn:length(tUserJyjlList)  > 0 }">
		<c:forEach items="${tUserJyjlList}" var="poVal" varStatus="stuts">
			<tr>
				<td align="center"><div style="width: 25px;" name="xh">${stuts.index+1 }</div></td>
				<td align="center"><input style="width:20px;"  type="checkbox" name="ck" /></td>
					<input name="tUserJyjlList[${stuts.index }].id" type="hidden" value="${poVal.id }"/>
					<input name="tUserJyjlList[${stuts.index }].uid" type="hidden" value="${poVal.uid }"/>
				   <td align="left">
					  	<input name="tUserJyjlList[${stuts.index }].xxmc" maxlength="100" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					                value="${poVal.xxmc }">
					  <label class="Validform_label" style="display: none;">学校名称</label>
				   </td>
				   <td align="left">
					  	<input name="tUserJyjlList[${stuts.index }].rxsj" maxlength="100" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					                value="${poVal.rxsj }">
					  <label class="Validform_label" style="display: none;">入学时间</label>
				   </td>
				   <td align="left">
					  	<input name="tUserJyjlList[${stuts.index }].bysj" maxlength="100" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					                value="${poVal.bysj }">
					  <label class="Validform_label" style="display: none;">毕业时间</label>
				   </td>
				   <td align="left">
					  	<input name="tUserJyjlList[${stuts.index }].sxzy" maxlength="100" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					                value="${poVal.sxzy }">
					  <label class="Validform_label" style="display: none;">所学专业</label>
				   </td>
				   <td align="left">
					  	<input name="tUserJyjlList[${stuts.index }].whcd" maxlength="100" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					                value="${poVal.whcd }">
					  <label class="Validform_label" style="display: none;">文化程度</label>
				   </td>
				   <td align="left">
					  	<input name="tUserJyjlList[${stuts.index }].xw" maxlength="100" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					                value="${poVal.xw }">
					  <label class="Validform_label" style="display: none;">学位</label>
				   </td>
				   <td align="left">
					  	<input name="tUserJyjlList[${stuts.index }].jyjlbz" maxlength="100" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					                value="${poVal.jyjlbz }">
					  <label class="Validform_label" style="display: none;">教育经历备注</label>
				   </td>
   			</tr>
		</c:forEach>
	</c:if>	
	</tbody>
</table>
</div>