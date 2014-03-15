<%@ page language="java" import="com.rc.sys.vo.*" isELIgnored="false" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib  uri="/struts-tags" prefix="s"%>
<%@ taglib uri="/WEB-INF/page.tld" prefix="page" %>

<%
String path = request.getContextPath();
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
  <jsp:include page="/common/util.jsp"/>
<link rel="stylesheet" type="text/css" href="<%=path%>/css/stylecss.css">
<script type="text/javascript" src="<%=path %>/js/jquery-1.4.2.min.js"></script>
<script type="text/javascript" src="<%=path %>/js/valid.js"></script>
<script type="text/javascript">


$(function() {
	
	$("#save").click(function() {
  			if(confirm("是否保存?")){
				document.form1.action="<%=path %>/houseUnit!update";
				document.form1.submit();
  			}	
	});
	
});

 
/*}*/
</script>
  </head>
  
  <body>
 <form name="form1" method="post">
  <div class="bigBox"><!--外部大DIV，可以调整宽度-->
  <h2><span><a href="javascript:void(0)">楼栋管理</a> &gt; <a href="javascript:void(0)">楼栋单位管理</a> &gt; 修改</span></h2>
   <div class="content"> 
<table width="100%" >

   
   <tr>
    <td height="24" align="right" width="20%" nowrap="nowrap">所属楼栋：</td>
    <td  align="left" nowrap="nowrap" width="20%">
    	<input type="text" name="form.hs_sname" value="${vo.hs_sname}"  > 
	  <input type="hidden" name="form.hs_sno" id="hs_sno" value="${vo.hs_sno}" size="15"/><span style="color:red;" id="us_sloginname.info">*</span>
		<span style="color:red;"  id="errMsg_us_sno"></span>
   		<input type="hidden" name="form.hu_sno" value="${vo.hu_sno}"/>
   		<input type="hidden" name="form.comp_sno" value="${vo.comp_sno}"/>
   		<input type="hidden" name="form.sh_sno" value="${vo.sh_sno}"/>
     </td>
  
    <td height="24" align="right" width="20%" nowrap="nowrap">单元名称：</td>
    <td  align="left" nowrap="nowrap">
   <input type="text" name="form.hu_sname" value="${vo.hu_sname}" onkeyup="javascript:document.all.hu_ssname.value=this.value;" maxlength="20" valid="required|isSymbols" errmsg="楼栋类型名称不能为空!|楼栋类型名称只能以字母、汉字、数字、下划线组成!"/>
    <span style="color:red;" id="us_sloginpwd.info">*</span>
    </td>
    </tr>
     <tr>
    <td height="24" align="right" nowrap="nowrap">单元简称：</td>
    <td  align="left" nowrap="nowrap">
    <input type="text" name="form.hu_ssname" value="${vo.hu_ssname}" id="hu_ssname" maxlength="20" valid="required|isSymbols" errmsg="楼栋类型简称不能为空!|楼栋类型简称只能以字母、汉字、数字、下划线组成!"/>
    <span style="color:red;" id="us_sloginpwd1.info">*</span>
    </td>    
   	<td height="24" align="right" nowrap="nowrap">
					单元层数：
				</td>
				<td  align="left">
					<input type="text" name="form.hu_nulayer" value="${vo.hu_nulayer}"
						maxlength="20" valid="required|isSymbols"
						errmsg="楼栋类型简称不能为空!|楼栋类型简称只能以字母、汉字、数字、下划线组成!" />
					<span style="color: red;" id="us_sloginpwd1.info">*</span>
				</td>
			</tr>
			<tr>
				<td height="24" align="right" nowrap="nowrap">
					单元朝向：
				</td>
				<td  align="left" nowrap="nowrap">
				 
						<select name="form.hu_scx" valid="required" errmsg="楼栋类型简称不能为空!">
							<option value="" ></option>
							<option value="东" <s:if test="list.hu_scx==\"东\"">selected</s:if>>东</option>
							<option value="东南" <s:if test="list.hu_scx==\"东南\"">selected</s:if>>东南</option>
							<option value="南" <s:if test="list.hu_scx==\"南\"">selected</s:if>>南</option>
							<option value="西南" <s:if test="list.hu_scx==\"西南\"">selected</s:if>>西南</option>
							<option value="西" <s:if test="list.hu_scx==\"西\"">selected</s:if>>西</option>
							<option value="西北" <s:if test="list.hu_scx==\"西北\"">selected</s:if>>西北</option>
							<option value="北" <s:if test="list.hu_scx==\"北\"">selected</s:if>>北</option>
							<option value="东北" <s:if test="list.hu_scx==\"东北\"">selected</s:if>>东北</option>
						</select>
					<span style="color: red;" id="us_sloginpwd1.info">*</span>
				</td>
			 
				<td height="24" align="right" nowrap="nowrap">
					每层房间数：
				</td>
				<td  align="left" nowrap="nowrap">
					<input type="text" name="form.hu_nlrnum" value="${vo.hu_nlrnum}" maxlength="20"
						valid="required|isSymbols"
						errmsg="楼栋类型简称不能为空!|楼栋类型简称只能以字母、汉字、数字、下划线组成!" />
					<span style="color: red;" id="us_sloginpwd1.info">*</span>
				</td>
			</tr>
			<tr>
				<td height="24" align="right" nowrap="nowrap">
					房间使用面积：
				</td>
				<td  align="left" nowrap="nowrap">
					<input type="text" name="form.hu_nroomarea" value="${vo.hu_nroomarea}"
						maxlength="20" valid="required|isSymbols"
						errmsg="楼栋类型简称不能为空!|楼栋类型简称只能以字母、汉字、数字、下划线组成!" />
					<span style="color: red;" id="us_sloginpwd1.info">*</span>
				</td>
			 
				<td height="24" align="right" nowrap="nowrap">
					房间建筑面积：
				</td>
				<td  align="left" nowrap="nowrap">
					<input type="text" name="form.hu_njzarea" value="${vo.hu_njzarea}"
						maxlength="20" valid="required|isSymbols"
						errmsg="楼栋类型简称不能为空!|楼栋类型简称只能以字母、汉字、数字、下划线组成!" />
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
				    <option value="单间"<s:if test="list.hu_stype == \"单间\"">selected</s:if>>单间</option>
				    <option value="套间"<s:if test="list.hu_stype == \"套间\"">selected</s:if>>套间</option>
				</select>
				</td>
			 
				<td height="24" align="right" nowrap="nowrap">
					类型结构：
				</td>
				<td  align="left">
					<input type="text" name="form.hu_sroomcr" value="${vo.hu_sroomcr}"
						maxlength="20" valid="required|isSymbols"
						errmsg="楼栋类型简称不能为空!|楼栋类型简称只能以字母、汉字、数字、下划线组成!" />
					<span style="background:#FFFFFF;color:red;">几室几厅</span>
				</td>
			</tr>
			
			  <tr>
				<td height="24" align="right" nowrap="nowrap">
					电梯个数：
				</td>
				<td  align="left" nowrap="nowrap">
					<input type="text" name="form.hu_ndtnum" value="${vo.hu_ndtnum}"
						maxlength="20" valid="required|isSymbols"
						errmsg="楼栋类型简称不能为空!|楼栋类型简称只能以字母、汉字、数字、下划线组成!" />
				</td>
			 
				<td height="24" align="right" nowrap="nowrap">
					楼道个数：
				</td>
				<td  align="left" nowrap="nowrap">
					<input type="text" name="form.hu_nldnum" value="${vo.hu_nldnum}"
						maxlength="20" valid="required|isSymbols"
						errmsg="楼栋类型简称不能为空!|楼栋类型简称只能以字母、汉字、数字、下划线组成!" />
				</td>
			</tr>
     <tr>
	
</table>
<table width="90%">
	 <tr>   
	     
		<td   align="center">
	      <input name="submit22" type="button" class="button_02a" id="save" value="保存" /> &nbsp;&nbsp;&nbsp;
	      <input name="Submit22" type="reset" class="button_02a" id="reset" value="重置"/>&nbsp;&nbsp;&nbsp;
	      <input name="Submit22" type="button" class="button_02a" id="back" value="返回" onClick="javascript:history.back();"/>
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
	       <s:iterator value="listsno"  status="i" var="li">
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
  </form>
  </body>
</html>
