<%@ page language="java" isELIgnored="false" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib uri="/WEB-INF/page.tld" prefix="page"%>
<% 
	String path = request.getContextPath();
%>
<jsp:include page="/common/util.jsp"/>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript">
function find()
{							
	document.frm.action="<%=path%>/house!find";
	document.frm.submit();
}
function save(type)
{
	if(validator(document.form1)){
		document.getElementById("saveType").value = type;
		var str = "";
		if (type == 1) {
			str = "是否保存?";
		} else if (type == 2) {
			str = "是否保存，继续添加楼层?";
		}
		if(confirm(str)){
		document.form1.action="<%=path%>/house!addUnit";
		document.form1.submit();
		}
	}
}
 
	
</script>
</head>
<body  >
	<form name="form1" action="<%=path%>/house!find" method="post">
		<div class="bigBox" id="idwidth">
			<h2>
				<span>系统管理 &gt; 楼栋信息管理 &gt; 新增楼栋 &gt; 新增单元</span>
			</h2>
			<div class="content">
				<table width="100%" border="0" cellpadding="0" cellspacing="0"> 
		<tr>
			<td align="right" nowrap>楼栋编号：</td>
			<td align="left"  nowrap><s:property value="houseForm.hs_sno"/></td>
			<td align="right" nowrap>所属校区：</td>
			<td align="left"  nowrap><s:property value="houseForm.sh_sname"/>
			<input type="hidden" name="houseForm.sh_sname"  value="${houseForm.sh_sname}"/></td>
  			<td align="right" nowrap>所属单位：</td>
			<td align="left" nowrap><s:property value="houseForm.comp_sname"/>
				  <input type="hidden" name="houseForm.comp_sname"  value="${houseForm.comp_sname}"/>
			</td>
		</tr>
		<tr>
			<td align="right" nowrap>楼栋名称：</td>
			<td align="left" nowrap><s:property value="houseForm.hs_sname"/>
			<input type="hidden" name="houseForm.hs_sname"  value="${houseForm.hs_sname}"/></td>
      		<td align="right" nowrap>楼栋简称：</td>
		  	<td align="left" nowrap><s:property value="houseForm.hs_ssname"/>
		  	<input type="hidden" name="houseForm.hs_ssname"  value="${houseForm.hs_ssname}"/></td>
		  	<td align="right" nowrap>楼栋单元数：</td>
		  	<td align="left" nowrap><s:property value="houseForm.hs_nunit"/>
		  	<input type="hidden" name="houseForm.hs_nunit" value="${houseForm.hs_nunit}">
		  	</td>
		</tr>
		<tr>
			<td align="right" nowrap>楼栋总房间数：</td>
			<td align="left" nowrap><s:property value="houseForm.hs_nroomnum"/>
			<input type="hidden" name="houseForm.hs_nroomnum"  value="${houseForm.hs_nroomnum}"/></td>
      		<td align="right" nowrap>楼栋地上层数：</td>
		  	<td align="left" nowrap><s:property value="houseForm.hs_nulayer"/>
		  	<input type="hidden" name="houseForm.hs_nulayer"  value="${houseForm.hs_nulayer}"/></td>
		  	<td align="right" nowrap>楼栋地下层数：</td>
		  	<td align="left" nowrap><s:property value="houseForm.hs_ndlayer"/>
		  	<input type="hidden" name="houseForm.hs_ndlayer"  value="${houseForm.hs_ndlayer}"/></td>
		</tr>
		 
				</table>
				<table width="100%" id="table1"  class="table" bgcolor="#95B0B9" border="0" cellpadding="1" cellspacing="1">
					<tr bgcolor="#CBE0FF"> 
						<th width="40">序号</th>
						<th width="100">单元代码</th>
						<th width="100">单元名称</th>
						<th width="100">单元简称</th>
						<th width="100">单元层数</th>
						<th width="60">地下层数</th>
						<th width="80">总房间数</th>
						<th width="80">单元朝向</th>
						<th width="100">电梯个数</th>
						<th width="100">楼道个数</th>
					</tr>
					<s:iterator value="#request.huList" var="hu" status="st">
					<tr bgcolor="#FFFFFF"> 
						<td>${st.index+1} </td>
						<td><input type="text" name="houseForm.hu_scode" value="${hu.hu_scode}"></td>
						<td><input type="text" name="houseForm.hu_sname" value="${hu.hu_sname}"></td>
						<td><input type="text" name="houseForm.hu_ssname" value="${hu.hu_ssname}"></td>
						<td><input type="text" name="houseForm.hu_nulayer" value="${hu.hu_nulayer}"></td>
						<td><input type="text" name="houseForm.hu_ndlayer" value="${hu.hu_ndlayer}"></td>
						<td><input type="text" name="houseForm.hu_nroomnum" value="${hu.hu_nroomnum}"></td>
						<td>
							<select name="houseForm.hu_scx">
							<option value="" ></option>
							<option value="东" <s:if test="#hu.hu_scx==\"东\"">selected</s:if>>东</option>
							<option value="东南" <s:if test="#hu.hu_scx==\"东南\"">selected</s:if>>东南</option>
							<option value="南" <s:if test="#hu.hu_scx==\"南\"">selected</s:if>>南</option>
							<option value="西南" <s:if test="#hu.hu_scx==\"西南\"">selected</s:if>>西南</option>
							<option value="西" <s:if test="#hu.hu_scx==\"西\"">selected</s:if>>西</option>
							<option value="西北" <s:if test="#hu.hu_scx==\"西北\"">selected</s:if>>西北</option>
							<option value="北" <s:if test="#hu.hu_scx==\"北\"">selected</s:if>>北</option>
							<option value="东北" <s:if test="#hu.hu_scx==\"东北\"">selected</s:if>>东北</option>
						</select>
						</td>
						<td><input type="text" name="houseForm.hu_ndtnum" value="${hu.hu_ndtnum}"></td>
						<td><input type="text" name="houseForm.hu_nldnum" value="${hu.hu_nldnum}">
						<input type="hidden" name="houseForm.hu_nlrnum" value="${hu.hu_nlrnum}">
						<input type="hidden" name="houseForm.hu_nroomarea" value="${hu.hu_nroomarea}">
						<input type="hidden" name="houseForm.hu_njzarea" value="${hu.hu_njzarea}">
						<input type="hidden" name="houseForm.hu_stype" value="${hu.hu_stype}">
						<input type="hidden" name="houseForm.hu_sroomcr" value="${hu.hu_sroomcr}">
						<input type="hidden" name="houseForm.hu_ndarea" value="${hu.hu_ndarea}">
						<input type="hidden" name="houseForm.hu_soldno" value="${hu.hu_soldno}">
						<input type="hidden" name="houseForm.hu_soldname" value="${hu.hu_soldname}">
						</td>
					</tr>
					</s:iterator>
				</table> 
				
		</div>
		<table width="100%" align="center" >
		<tr height="24" valign="middle">
		    <td  colspan="4" align="center" nowrap>
		      <input name="submit22" type="button" class="button_02a" value="保存" onClick="save(1)" />
		      <input name="submit22" type="button" class="button_02a" value="保存->添加楼层" onClick="save(2)" />
		      <input name="Submit22" type="reset" class="button_02a" value="重置" />
	        	<input name="Submit22" type="button" class="button_02a" value="返回" onClick="javascript:find();"></td>
	    </tr>
	</table>
		</div>
		<input type="hidden" name="saveType" id="saveType" value=""/>
		<input type="hidden" name="houseForm.hs_sno"  value="${houseForm.hs_sno}"/>
		<input type="hidden" name="houseForm.comp_sno"  value="${houseForm.comp_sno}"/>
		<input type="hidden" name="houseForm.sh_sno"  value="${houseForm.sh_sno}"/>
		<input type="hidden" name="houseForm.ht_sno"  value="${houseForm.ht_sno}"/>
</form>
</body>
</html>