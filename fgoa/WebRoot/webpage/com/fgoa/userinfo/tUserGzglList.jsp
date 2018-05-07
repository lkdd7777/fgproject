<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<script type="text/javascript">
	$('#addTUserGzglBtn').linkbutton({   
	    iconCls: 'icon-add'  
	});  
	$('#delTUserGzglBtn').linkbutton({   
	    iconCls: 'icon-remove'  
	}); 
	$('#addTUserGzglBtn').bind('click', function(){   
 		 var tr =  $("#add_tUserGzgl_table_template tr").clone();
	 	 $("#add_tUserGzgl_table").append(tr);
	 	 resetTrNum('add_tUserGzgl_table');
    });  
	$('#delTUserGzglBtn').bind('click', function(){   
      	$("#add_tUserGzgl_table").find("input:checked").parent().parent().remove();   
        resetTrNum('add_tUserGzgl_table'); 
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
	<a id="addTUserGzglBtn" href="#">添加</a> <a id="delTUserGzglBtn" href="#">删除</a> 
</div>
<div style="width: auto;height: 300px;overflow-y:auto;overflow-x:scroll;">
<table border="0" cellpadding="2" cellspacing="0" id="tUserGzgl_table">
	<tr bgcolor="#E6E6E6">
		<td align="center" bgcolor="#EEEEEE"><label class="Validform_label">序号</label></td>
		<td align="center" bgcolor="#EEEEEE"><label class="Validform_label">操作</label></td>
				  <td align="left" bgcolor="#EEEEEE">
				  <label class="Validform_label">
								岗位工资
							</label></td>
				  <td align="left" bgcolor="#EEEEEE">
				  <label class="Validform_label">
								本年度社保基数
							</label></td>
				  <td align="left" bgcolor="#EEEEEE">
				  <label class="Validform_label">
								本年度其他基数
							</label></td>
				  <td align="left" bgcolor="#EEEEEE">
				  <label class="Validform_label">
								正式职工薪酬备注
							</label></td>
				  <td align="left" bgcolor="#EEEEEE">
				  <label class="Validform_label">
								薪级月增资额
							</label></td>
				  <td align="left" bgcolor="#EEEEEE">
				  <label class="Validform_label">
								上年度社保基数
							</label></td>
				  <td align="left" bgcolor="#EEEEEE">
				  <label class="Validform_label">
								薪级金额
							</label></td>
				  <td align="left" bgcolor="#EEEEEE">
				  <label class="Validform_label">
								上年度其他基数
							</label></td>
	</tr>
	<tbody id="add_tUserGzgl_table">	
	<c:if test="${fn:length(tUserGzglList)  <= 0 }">
			<tr>
				<td align="center"><div style="width: 25px;" name="xh">1</div></td>
				<td align="center"><input style="width:20px;"  type="checkbox" name="ck"/></td>
					<input name="tUserGzglList[0].id" type="hidden"/>
					<input name="tUserGzglList[0].uid" type="hidden"/>
				  <td align="left">
					  	<input name="tUserGzglList[0].bndsbjs" maxlength="100" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					               >
					  <label class="Validform_label" style="display: none;">岗位工资</label>
					</td>
				  <td align="left">
					  	<input name="tUserGzglList[0].gzkzh" maxlength="100" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					               >
					  <label class="Validform_label" style="display: none;">本年度社保基数</label>
					</td>
				  <td align="left">
					  	<input name="tUserGzglList[0].bndqtjs" maxlength="100" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					               >
					  <label class="Validform_label" style="display: none;">本年度其他基数</label>
					</td>
				  <td align="left">
					  	<input name="tUserGzglList[0].zszgxcbz" maxlength="100" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					               >
					  <label class="Validform_label" style="display: none;">正式职工薪酬备注</label>
					</td>
				  <td align="left">
					  	<input name="tUserGzglList[0].xjyzze" maxlength="100" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					               >
					  <label class="Validform_label" style="display: none;">薪级月增资额</label>
					</td>
				  <td align="left">
					  	<input name="tUserGzglList[0].sndsbjs" maxlength="100" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					               >
					  <label class="Validform_label" style="display: none;">上年度社保基数</label>
					</td>
				  <td align="left">
					  	<input name="tUserGzglList[0].xjje" maxlength="100" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					               >
					  <label class="Validform_label" style="display: none;">薪级金额</label>
					</td>
				  <td align="left">
					  	<input name="tUserGzglList[0].sndqtjs" maxlength="100" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					               >
					  <label class="Validform_label" style="display: none;">上年度其他基数</label>
					</td>
   			</tr>
	</c:if>
	<c:if test="${fn:length(tUserGzglList)  > 0 }">
		<c:forEach items="${tUserGzglList}" var="poVal" varStatus="stuts">
			<tr>
				<td align="center"><div style="width: 25px;" name="xh">${stuts.index+1 }</div></td>
				<td align="center"><input style="width:20px;"  type="checkbox" name="ck" /></td>
					<input name="tUserGzglList[${stuts.index }].id" type="hidden" value="${poVal.id }"/>
					<input name="tUserGzglList[${stuts.index }].uid" type="hidden" value="${poVal.uid }"/>
				   <td align="left">
					  	<input name="tUserGzglList[${stuts.index }].bndsbjs" maxlength="100" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					                value="${poVal.bndsbjs }">
					  <label class="Validform_label" style="display: none;">岗位工资</label>
				   </td>
				   <td align="left">
					  	<input name="tUserGzglList[${stuts.index }].gzkzh" maxlength="100" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					                value="${poVal.gzkzh }">
					  <label class="Validform_label" style="display: none;">本年度社保基数</label>
				   </td>
				   <td align="left">
					  	<input name="tUserGzglList[${stuts.index }].bndqtjs" maxlength="100" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					                value="${poVal.bndqtjs }">
					  <label class="Validform_label" style="display: none;">本年度其他基数</label>
				   </td>
				   <td align="left">
					  	<input name="tUserGzglList[${stuts.index }].zszgxcbz" maxlength="100" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					                value="${poVal.zszgxcbz }">
					  <label class="Validform_label" style="display: none;">正式职工薪酬备注</label>
				   </td>
				   <td align="left">
					  	<input name="tUserGzglList[${stuts.index }].xjyzze" maxlength="100" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					                value="${poVal.xjyzze }">
					  <label class="Validform_label" style="display: none;">薪级月增资额</label>
				   </td>
				   <td align="left">
					  	<input name="tUserGzglList[${stuts.index }].sndsbjs" maxlength="100" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					                value="${poVal.sndsbjs }">
					  <label class="Validform_label" style="display: none;">上年度社保基数</label>
				   </td>
				   <td align="left">
					  	<input name="tUserGzglList[${stuts.index }].xjje" maxlength="100" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					                value="${poVal.xjje }">
					  <label class="Validform_label" style="display: none;">薪级金额</label>
				   </td>
				   <td align="left">
					  	<input name="tUserGzglList[${stuts.index }].sndqtjs" maxlength="100" 
					  		type="text" class="inputxt"  style="width:120px;"
					               
					                value="${poVal.sndqtjs }">
					  <label class="Validform_label" style="display: none;">上年度其他基数</label>
				   </td>
   			</tr>
		</c:forEach>
	</c:if>	
	</tbody>
</table>
</div>