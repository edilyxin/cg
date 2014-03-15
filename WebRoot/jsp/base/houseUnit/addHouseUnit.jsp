 <%@ page language="java" isELIgnored="false" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib uri="/WEB-INF/page.tld" prefix="page"%>

<%
	String path = request.getContextPath();
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
	<jsp:include page="/common/util.jsp"/>
<link rel="stylesheet" type="text/css" href="<%=path%>/css/stylecss.css">
<script type="text/javascript">
     
$(function(){
		$("#sh_sno").change(function(){
		var hs=$("#sh_sno").val();
		alert(hs);
		if(1>=$(this).val()){
		
		$("#hs_sno").empty();
		$("#hs_sno").append("<option value=''>---请选择---</option>");
		
		return;	}
		else{
			$.post(
				"<%=path%>/houseunit!find1",
				{"houseForm.sh_sno":$(this).val()},
				function(childList) {
					$("#hs_sno").empty();
					$("#hs_sno").append("<option value=''>---请选择---</option>");
					for (var i=0; i < childList.length; i++) {
					
						var child = childList[i];
						$("#hs_sno").append("<option value='" + child.hs_sno + "'>" + child.hs_sno+":"+child.hs_sname +"</option>");
					}
				}, "json"
			);
			}
		});
	});

function save(type)
{
//  $(.form.hs_sno).val();
// alert(  $("input[name='form.hs_sno']").val()  );
  
	if(validator(document.form1)){
		document.getElementById("saveType").value = type;
		var str = "";
		if (type == 1) {
			str = "是否保存?";
		} else if (type == 2) {
			str = "是否保存，去新增楼层?";
		}
		if(confirm(str)){
		document.form1.action="<%=path%>/houseUnit!add";
		document.form1.submit();
		}
	}
}
function toback(){
	document.form1.action="<%=path%>/houseUnit!find";
	document.form1.submit();
}
function find(){
	tree("form.hs_sno","form.hs_sname","<%=path %>/house!tree");
	var sno=$("#hs_sno").val();
	if(sno!=""||sno!=""){
	document.form1.action="<%=path%>/houseUnit!findHsSno?sno="+sno;
	document.form1.submit();
	}
}
</script>
	</head>

	<body>
		<form name="form1" method="post">
			<div class="bigBox">
				<!--外部大DIV，可以调整宽度-->
				<h2>
					<span><a href="javascript:void(0)">基础管理</a> &gt; <a
						href="javascript:void(0)">楼栋单元管理</a> &gt; 新增</span>
				</h2>
				<div class="content">
					<table width="100%">
						<tr>
							<td height="24" width="25%" align="right"  nowrap="nowrap">
								楼栋名称：
							</td>
							<td  align="left"   nowrap="nowrap">
							<s:if test="saveType == \"2\"">
								<input type="text" name="form.hs_sname" value="${houseForm.hs_sname}" readonly/>
								<input type="text" name="form.hs_sno" value="<s:property value="houseForm.hs_sno"/>"/>
							</s:if>
							<s:else>
							<input type="text" name="form.hs_sname" value="${form.hs_sname}" onClick="find();"><img src="<%=path%>/images/09.gif" onClick="find()"	
				              width="16" height="20" border="0" align="absmiddle" onMouseOver="this.style.cursor='hand'">
				            <input type="hidden" name="form.hs_sno" id="hs_sno" value="${form.hs_sno}" size="15"/>
				            </s:else>
				    	<span style="color:red;" id="us_sloginname.info">*</span>
						</td>
					 
							<td height="24" align="right" nowrap="nowrap">
								单元名称：
							</td>
							<td  align="left" nowrap="nowrap">
								<input type="text" name="form.hu_sname" maxlength="20" onkeyup="javascript:document.all.hu_ssname.value=this.value;" valid="required|isSymbols" errmsg="单元名称不能为空！|单元名称只能以字母、汉字、数字、下划线组成！" />
								<span style="color: red;" id="us_sloginpwd.info">*</span>
							</td>
						</tr>
						<tr>
							<td height="24" align="right"  nowrap="nowrap">
								单元简称：
							</td>
							<td  align="left"    nowrap="nowrap">
								<input type="text" name="form.hu_ssname" maxlength="20" id="hu_ssname"valid="required|isSymbols" errmsg="单元简称不能为空！|单元简称只能以字母、汉字、数字、下划线组成！" />
								<span style="color: red;" id="us_sloginpwd1.info">*</span>
							</td>
						 
							<td height="24" align="right" nowrap="nowrap">
								单元层数：
							</td>
							<td  align="left"   nowrap="nowrap">
								<input type="text" name="form.hu_nulayer" maxlength="20" valid="required|isNum" errmsg="单元层数不能为空！|单元层数只能为正整数！" />
								<span style="color: red;" id="us_sloginpwd1.info">*</span>
							</td>
						</tr>
						<tr>
							<td height="24" align="right" nowrap="nowrap">
								单元朝向：
							</td>
							<td  align="left" nowrap="nowrap"  valid="required" errmsg="单元朝向不能为空！">
							<select name="form.hu_scx">
							<option value="" ></option>
							<option value="东" >东</option>
							<option value="东南">东南</option>
							<option value="南" >南</option>
							<option value="西南" >西南</option>
							<option value="西">西</option>
							<option value="西北" >西北</option>
							<option value="北" >北</option>
							<option value="东北" >东北</option>
						</select>
								 
								<span style="color: red;" id="us_sloginpwd1.info">*</span>
							</td>
						 
							<td height="24" align="right" nowrap="nowrap">
								每层房间数：
							</td>
							<td  align="left" nowrap="nowrap">
								<input type="text" name="form.hu_nlrnum" maxlength="20" valid="required|isNum" errmsg="每层房间数不能为空！|每层房间数只能为正整数！" />
								<span style="color: red;" id="us_sloginpwd1.info">*</span>
							</td>
						</tr>
						<tr>
							<td height="24" align="right" nowrap="nowrap">
								房间使用面积：
							</td>
							<td  align="left" nowrap="nowrap">
								<input type="text" name="form.hu_nroomarea" maxlength="20" valid="required|isMoney" errmsg="房间使用面积不能为空！|房间使用面积只能为正数！" />
								<span style="color: red;" id="us_sloginpwd1.info">*</span>
							</td>
						 
							<td height="24" align="right" nowrap="nowrap">
								房间建筑面积：
							</td>
							<td  align="left" nowrap="nowrap">
								<input type="text" name="form.hu_njzarea" maxlength="20" valid="required|isMoney" errmsg="房间建筑面积不能为空！|房间建筑面积只能为正数！" />
								<span style="color: red;" id="us_sloginpwd1.info">*</span>
							</td>
						</tr>
						
						<tr>
							<td height="24" align="right" nowrap="nowrap">
								房间类型：
							</td>
							<td  align="left" nowrap="nowrap">
							<select id="hu_stype" name="form.hu_stype"> 
							<option value="">--请选择--</option>
							<option value="单间">单间</option>
							<option value="套件">套间</option>
							</select>
							</td>
						 
							<td height="24" align="right" nowrap="nowrap">
								房间类型结构：
							</td>
							<td  align="left" nowrap="nowrap">
								<input type="text" name="form.hu_sroomcr" maxlength="20" valid="isSymbols" errmsg="房间类型结构只能以字母、汉字、数字、下划线组成！" />
								<span style="background:#FFFFFF;color:red;">几室几厅</span>
							</td>
							
						
						</tr>
						
						  <tr>
							<td height="24" align="right" nowrap="nowrap">
								电梯个数：
							</td>
							<td  align="left" nowrap="nowrap">
								<input type="text" name="form.hu_ndtnum" maxlength="20" valid="isNum" errmsg="电梯个数只能为正整数！" />
							</td>
					 
							<td height="24" align="right" nowrap="nowrap">
								楼道个数：
							</td>
							<td  align="left" nowrap="nowrap">
								<input type="text" name="form.hu_nldnum" maxlength="20" valid="isNum" errmsg="电梯个数只能为正整数！" />
							</td>
						</tr>
						

						
					</table>
					<table width="100%">
						<tr>
 						<td  align="center" >
								<input name="submit22" type="button" class="button_02a" value="保存" onClick="save(1)"/>&nbsp; &nbsp; &nbsp;   
								<s:if test="saveType == \"2\"">
									<input name="submit22" type="button" class="button_02a" value="保存->新增楼层" onClick="save(2)" />&nbsp; &nbsp; &nbsp; 
								</s:if>
								<input name="Submit22" type="reset" class="button_02a" id="reset" value="重置" />&nbsp; &nbsp; &nbsp; 
								<input name="Submit22" type="button" class="button_02a" id="back" value="返回" onClick="toback();" />
							</td>
							 
						</tr>
					 </table>
				</div>
			 <div class="right2_x" >
          <div style="width:100%;padding:0 0;overflow:auto;overflow-y:hidden;">
  			<table width="1620" border="0" align="center" cellpadding="2" cellspacing="1" bgcolor="#93B3CA" class="tabletext">
			 <tr>
	       		
	       		<th width="3%" align="center" bgcolor="#CBE0FF" scope="col" nowrap>序号</th>
	       		<th width="7%" align="center" bgcolor="#CBE0FF" scope="col" nowrap>校区名</th>    		
	       		 <th width="5%" align="center" bgcolor="#CBE0FF" scope="col" nowrap>楼栋编号</th>
	       		 <th width="5%" align="center" bgcolor="#CBE0FF" scope="col" nowrap>楼栋名称</th>	
	       		 <th width="5%" align="center" bgcolor="#CBE0FF" scope="col" nowrap>单元名称</th>
	       		  <th width="5%" align="center" bgcolor="#CBE0FF" scope="col" nowrap>单元简称</th>
	       		   
	       		   <th width="5%" align="center" bgcolor="#CBE0FF" scope="col">单位编码</th>
	       		 <th width="5%" align="center" bgcolor="#CBE0FF" scope="col" nowrap>楼层数</th>
	       		 <th width="5%" align="center" bgcolor="#CBE0FF" scope="col"nowrap>地下层数</th> 
	       		 <th width="5%" align="center" bgcolor="#CBE0FF" scope="col" nowrap>总房间数</th>
	       		 <th width="5%" align="center" bgcolor="#CBE0FF" scope="col" nowrap>单元类型</th>
	       		 <th width="5%" align="center" bgcolor="#CBE0FF" scope="col"  nowrap>房间类型结构</th>
	       		 <th width="5%" align="center" bgcolor="#CBE0FF" scope="col" nowrap>朝向</th>
	       		 <th width="5%" align="center" bgcolor="#CBE0FF" scope="col" nowrap>总使用面积</th>
	       		 <th width="5%" align="center" bgcolor="#CBE0FF" scope="col" nowrap>占地面积</th>
	       		 <th width="5%" align="center" bgcolor="#CBE0FF" scope="col" nowrap>状态</th>
	       		 <th width="15%" align="center" bgcolor="#CBE0FF" scope="col" nowrap>备注</th>
	       </tr>
	       <s:iterator value="list"  status="i" var="li">
	     	<tr bgcolor="#FFFFFF" onmouseover="this.style.backgroundColor='#E3EFFF'"onmouseout="this.style.backgroundColor='#FFFFFF'">
	     	 
	     	     <td align="center" >${i.index+1}</td>
	     		 <td align="center" title="${li.sh_sno}">${li.sh_sno}</td>
	     	     <td align="center" title="${li.hs_sno}">${li.hs_sno}</td>
	     	     <td align="center" title="${li.hs_sname}">${li.hs_sname}</td>
	     		
	     	     <td align="center" title="${li.hu_sname}">${li.hu_sname}</td>
	     	      <td align="center" title="${li.hu_ssname}">${li.hu_ssname}</td>
	     	      
	     		<td align="center" title="${li.comp_sno}">${li.comp_sno}</td>
	     	     <td align="center" title="${li.hu_nulayer}">${li.hu_nulayer}</td>
	     		 <td align="center" title="${li.hu_ndlayer}">${li.hu_ndlayer}</td>
	     		 <td align="center" title="${li.hu_nroomnum}">${li.hu_nroomnum}</td>
	     		 <td align="center" title="${li.hu_stype}">${li.hu_stype}</td>
	     		 <td align="center" title="${li.hu_sroomcr}">${li.hu_sroomcr}</td>
	     		 <td align="center" title="${li.hu_scx}">${li.hu_scx}</td>
	     		 <td align="center" title="${li.hu_njzarea}">${li.hu_njzarea}</td>
	     		 <td align="center" title="${li.hu_ndarea}">${li.hu_ndarea}</td>
	     		 <td align="center" title=""><s:if test='%{#li.hu_sisvalid=="0"}'>无效</s:if>
				 	 <s:if test='%{#li.hu_sisvalid=="1"}'>有效</s:if>
	     		</td>
	     		<td align="center"title="${li.hu_smem}" >${li.hu_smem}</td>	
	     	</tr>
	       </s:iterator>
	       </table>
	         </div>
	         
	       </div>
			</div>
			
		 <s:if test="saveType == \"2\"">
			<input type="hidden" name="form.comp_sno" value="${houseForm.comp_sno}"/>
			<input type="hidden" name="form.sh_sno" value="${houseForm.sh_sno}"/>
		</s:if>
		<input type="hidden" name="saveType" id="saveType" value="${saveType}"/>
		</form>
	</body>
</html>
