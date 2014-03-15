<%@ page language="java" isELIgnored="false" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib uri="/WEB-INF/page.tld" prefix="page"%>
<%
	String path = request.getContextPath();
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head  >
<base target="_self"/>
<jsp:include page="/common/util.jsp"/>
<link rel="stylesheet" type="text/css" href="<%=path%>/css/stylecss.css">
<script type="text/javascript" src="<%=path %>/js/jquery-1.4.2.min.js"></script>
<script type="text/javascript">
var  highlightcolor='#d5f4fe';
var  clickcolor='#51b2f6';
function  changeto(){
source=event.srcElement;
if  (source.tagName=="TR"||source.tagName=="TABLE")
return;
while(source.tagName!="TD")
source=source.parentElement;
source=source.parentElement;
cs  =  source.children;
//alert(cs.length);
if  (cs[1].style.backgroundColor!=highlightcolor&&source.id!="nc"&&cs[1].style.backgroundColor!=clickcolor)
for(i=0;i<cs.length;i++){
	cs[i].style.backgroundColor=highlightcolor;
}
}

function  changeback(){
if  (event.fromElement.contains(event.toElement)||source.contains(event.toElement)||source.id=="nc")
return
if  (event.toElement!=source&&cs[1].style.backgroundColor!=clickcolor)
//source.style.backgroundColor=originalcolor
for(i=0;i<cs.length;i++){
	cs[i].style.backgroundColor="";
}
}
	function find()
	{							
		document.form1.action="<%=path%>/house!tree";
		document.form1.submit();
	}

function clickUser()
{
 if(document.form1.idcheckbox==null)
	    {
		  return;
	    }
	   var len = document.form1.idcheckbox.length;
	   var flag = 0;
	   var val;
	   if(len!=undefined)
	   {
		  for(var i=0;i<len;i++)
		  {
			if(eval(document.form1.idcheckbox[i].checked))
			{
				flag++;
				val = document.form1.idcheckbox[i].value;
			}
		 }
	  }else
	  {
		if(document.form1.idcheckbox.checked)
		{
			flag++;
			val = document.form1.idcheckbox.value;
		}
	  }
	
	 if(flag==0)
	 {
		alert("请选择一条记录！");
		return;
	 }else if(flag!=1)
	 {
		alert("请只选择一条记录，不要多选！");
		return;
	 }
	 
		window.returnValue = val;
		window.close();	
	  
	
}

<%--		function clickUser(tex1,tex2){--%>
<%-- 	 	window.returnValue = tex1+"|"+tex2;--%>
<%--		window.close();	--%>
<%--	 }--%>
	 

</script>

</head>
<body>
	<form name="form1"  method="post">
		<div class="bigBox">
			<h2>
				<span><a href="javascript:void(0)">系统管理</a> &gt; 楼栋信息管理</span>
			</h2>
			<div class="right1">
<table width="100%">
  		<tr>
  			<td height="20" width="50"><a  style="color: #000000;" onclick="clickUser();" style="cursor:hand"><img src="<%=path %>/image/add.png" border="0"/>添加</a></td>
  			<td height="20"><a  style="color: #000000;" onclick="window.close();" style="cursor:hand"><img src="<%=path %>/image/delete.png" border="0"/>关闭</a></td>
  		</tr>
  	</table>
        </div>
			<div class="content">
				<table width="100%" border="0" cellpadding="0" cellspacing="0">
					<tr>
						<td width="8%" align="right" scope="col">楼栋编号：</td>
						<td width="10%" scope="col"><input type="text" name="houseForm.searchA" value="${houseForm.searchA}" size="11"/></td>
						<td width="8%" align="right" scope="col">楼栋名称：</td>
						<td width="10%" scope="col"><input type="text" name="houseForm.searchB" value="${houseForm.searchB}"  size="11"/></td>
						<td width="8%" align="right" scope="col">楼栋简称：</td>
						<td width="10%" scope="col"><input type="text" name="houseForm.searchC" value="${houseForm.searchC}"  size="11"/></td><!--
						<td scope="col" onclick="find();"><img src="<%=path %>/image/zoom.png" />查询</td>
					-->
					<td width="20%" onclick="find();" style="cursor:hand"><img src="<%=path %>/image/zoom.png" /> 查询</td></tr>
					
				</table>
				<div style="width:100%;padding:0 0 17px;overflow:auto;overflow-y:hidden;">
				<table width="1620" bgcolor="#95B0B9" border="0" cellpadding="1"
					cellspacing="1">
					<tr>
						<th width="1%" height="24" align="center" bgcolor="#CBE0FF"><input
							type="checkbox" id="chkall" onclick="chkSelect()"/></th>
						<th width="3%" align="center" bgcolor="#CBE0FF" scope="col" nowrap>序号</th>
						<th width="10%" align="center" bgcolor="#CBE0FF" scope="col" nowrap>校区名</th>
						<th width="10%" align="center" bgcolor="#CBE0FF" scope="col" nowrap>楼栋编号</th>
						<th width="10%" align="center" bgcolor="#CBE0FF" scope="col" nowrap>楼栋名称</th>
						<th width="10%" align="center" bgcolor="#CBE0FF" scope="col" nowrap>楼栋简称</th>
						<th width="10%" align="center" bgcolor="#CBE0FF" scope="col" nowrap>单元数</th>
						<th width="10%" align="center" bgcolor="#CBE0FF" scope="col" nowrap>地上层数</th>
						<th width="10%" align="center" bgcolor="#CBE0FF" scope="col" nowrap>地下层数</th>
						<th width="10%" align="center" bgcolor="#CBE0FF" scope="col" nowrap>建筑面积(㎡)</th>
						<th width="10%" align="center" bgcolor="#CBE0FF" scope="col" nowrap>占地面积(㎡)</th>
						<th width="10%" align="center" bgcolor="#CBE0FF" scope="col" nowrap>使用面积(㎡)</th> 
						<th width="10%" align="center" bgcolor="#CBE0FF" scope="col" nowrap>总造价数（元）</th>
						<th width="10%" align="center" bgcolor="#CBE0FF" scope="col" nowrap>用途</th>
						<th width="10%" align="center" bgcolor="#CBE0FF" scope="col" nowrap>状态</th>
						<th width="10%" align="center" bgcolor="#CBE0FF" scope="col" nowrap>抗震级别</th>
						<th width="10%" align="center" bgcolor="#CBE0FF" scope="col" nowrap>人防级别</th>
						<th width="10%" align="center" bgcolor="#CBE0FF" scope="col" nowrap>竣工日期</th>
						<th width="10%" align="center" bgcolor="#CBE0FF" scope="col" nowrap>房屋结构</th>
						<th width="10%" align="center" bgcolor="#CBE0FF" scope="col" nowrap>房间结构</th>
						<th width="10%" align="center" bgcolor="#CBE0FF" scope="col" nowrap>产权类型</th>
						<th width="10%" align="center" bgcolor="#CBE0FF" scope="col" nowrap>使用类型</th>
						<th width="10%" align="center" bgcolor="#CBE0FF" scope="col" nowrap>朝向</th>
						<th width="10%" align="center" bgcolor="#CBE0FF" scope="col" nowrap>楼栋结构</th>
					</tr>
					<s:iterator value="houseList" var="house" status="st">
					<tr>
						<td height="24" align="center" bgcolor="#E3EFFF" nowrap>
						<input name="idcheckbox"  type="checkbox" value="${house.hs_sno}|${house.hs_sname}"/></td>
						<td align="center" bgcolor="#E3EFFF" nowrap>
						<s:property value="(#st.index + 1)" /></td>
						<td align="center" bgcolor="#E3EFFF" nowrap>${house.sh_sname}</td>
						<td align="center" bgcolor="#E3EFFF" nowrap>${house.hs_sno}</td>
						<td align="center" bgcolor="#E3EFFF" nowrap>${house.hs_sname}</td>
						<td align="center" bgcolor="#E3EFFF" nowrap>${house.hs_ssname}</td>
						<td align="center" bgcolor="#E3EFFF" nowrap>${house.hs_nunit}</td>
						<td align="center" bgcolor="#E3EFFF" nowrap>${house.hs_nulayer}</td>
						<td align="center" bgcolor="#E3EFFF" nowrap>${house.hs_ndlayer}</td>
						<td align="center" bgcolor="#E3EFFF" nowrap>${house.hs_njzarea}</td>
						<td align="center" bgcolor="#E3EFFF" nowrap>${house.hs_nzdarea}</td>
						<td align="center" bgcolor="#E3EFFF" nowrap>${house.hs_nsyarea}</td> 
						<td align="center" bgcolor="#E3EFFF" nowrap>${house.hs_nbuildnum}</td>
						<td align="center" bgcolor="#E3EFFF" nowrap>${house.hs_susetype}</td>
						<td align="center" bgcolor="#E3EFFF" nowrap>${house.hs_sstat}</td>
						<td align="center" bgcolor="#E3EFFF" nowrap>${house.hs_skznum}</td>
						<td align="center" bgcolor="#E3EFFF" nowrap>${house.hs_srflevel}</td>
						<td align="center" bgcolor="#E3EFFF" nowrap><s:date name="#house.hs_dwdate" format="yyyy-MM-dd"/></td>
						<td align="center" bgcolor="#E3EFFF" nowrap>${house.hs_stype}</td>
						<td align="center" bgcolor="#E3EFFF" nowrap>${house.hs_sroomcr}</td>
						<td align="center" bgcolor="#E3EFFF" nowrap>${house.hs_sfctype}</td>
						<td align="center" bgcolor="#E3EFFF" nowrap>${house.hs_susetype}</td>
						<td align="center" bgcolor="#E3EFFF" nowrap>${house.hs_scx}</td>
						<td align="center" bgcolor="#E3EFFF" nowrap>${house.hs_scr}</td>
					</tr>
					</s:iterator>
				</table>
				</div>
				<div align="center"  >
	 				<s:if test="%{houseList.size()!=0}">
	 					<page:page uri="/house!tree"></page:page>
	 				</s:if>
	 				<s:else><br>
	 				<span  style="color:red;font-size:14px;"><strong>抱歉，未查询到符合条件的信息！</strong> </span>
	 				</s:else>
   				</div>
		</div>
		</div>
		<input type="hidden" name="houseForm.sh_sno" value="${houseForm.sh_sno}" size="11"/>
	</form>
</body>
</html>