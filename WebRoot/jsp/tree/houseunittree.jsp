<%@ page language="java" import="java.util.*,com.rc.sys.vo.*" isELIgnored="false" pageEncoding="UTF-8"%>
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
		document.form1.action="<%=path%>/school!tree";
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
</script>
</head>
  <body>
  <form name="form1" method="post">
<div class="bigBox">
 	<h2>
			<span><a href="javascript:void(0)">楼栋管理</a> &gt; 楼栋单元</span>
		</h2> 
			<div class="right1">
<table width="100%">
  		<tr>
  			<td height="20" width="50"><a  style="color: #000000;" onclick="clickUser();" style="cursor:hand"><img src="<%=path %>/image/add.png" border="0"/>添加</a></td>
  			<td height="20"><a  style="color: #000000;" onclick="window.close();" style="cursor:hand"><img src="<%=path %>/image/delete.png" border="0"/>关闭</a></td>
  		</tr>
  	</table>
        </div>				
        </div>
          <div class="content">
  	 <table width="100%" border="0" cellpadding="0" cellspacing="0">
           <tr bgcolor="#D5EAFB">
                <td height="30" >
                <span style="white-space:nowrap;">&nbsp;&nbsp;&nbsp;单元名称:</span>
                	<span style="white-space:nowrap;"><input type="text" name="form.hs_sname" value="${form.hs_sname}" onClick="tree('form.hs_sno','form.hs_sname','<%=path %>/house!tree');"><img src="<%=path%>/images/09.gif" onClick="tree('form.hs_sno','form.hs_sname','<%=path %>/house!tree');"	
				              width="16" height="20" border="0" align="absmiddle" onMouseOver="this.style.cursor='hand'">
				            <input type="hidden" name="form.hs_sno" id="hs_sno" value="${form.hs_sno}" size="15"/>
				         
				            <input type="hidden" name="form.searchB" id="searchB" value="${form.searchB}" size="15"/>
				        </span>&nbsp;&nbsp;&nbsp;
                	
					
                
                <span style="white-space:nowrap;">&nbsp;&nbsp;&nbsp;单元名称:<input type="text" name="form.searchA" value="${form.searchA}" size="12"/></span>
                	<span style="white-space:nowrap;"></span>&nbsp;&nbsp;&nbsp;
                	<span style="white-space:nowrap;"> <a  href="#" onclick="find();" style="cursor:hand"><img src="<%=path %>/image/zoom.png" /> 查询</a></span>
					
					</td></tr>
     </table>
  	</div>
  	<div class="right2_x" >
  	<div style="width:100%;padding:0 0;overflow:auto;overflow-y:hidden;">
  	<table width="1620" border="0" align="center" cellpadding="2" cellspacing="1" bgcolor="#93B3CA" class="tabletext">
	 <tr>
	       		<th width="1%" height="24" align="center" bgcolor="#CBE0FF" ><input type="checkbox" /></th>
	       		<th width="3%" align="center" bgcolor="#CBE0FF" scope="col">序号</th>
	       		<th width="7%" align="center" bgcolor="#CBE0FF" scope="col">校区名</th>    		
	       		 <th width="5%" align="center" bgcolor="#CBE0FF" scope="col">楼栋编号</th>
	       		 <th width="5%" align="center" bgcolor="#CBE0FF" scope="col">楼栋名称</th>	
	       		 <th width="5%" align="center" bgcolor="#CBE0FF" scope="col">单元名称</th>
	       		  <th width="5%" align="center" bgcolor="#CBE0FF" scope="col">单元简称</th>
	       		   
	       		   <th width="5%" align="center" bgcolor="#CBE0FF" scope="col">单位编码</th>
	       		 <th width="5%" align="center" bgcolor="#CBE0FF" scope="col">楼层数</th>
	       		 <th width="5%" align="center" bgcolor="#CBE0FF" scope="col">地下层数</th> 
	       		 <th width="5%" align="center" bgcolor="#CBE0FF" scope="col">总房间数</th>
	       		 <th width="5%" align="center" bgcolor="#CBE0FF" scope="col">单元类型</th>
	       		 <th width="5%" align="center" bgcolor="#CBE0FF" scope="col">房间类型结构</th>
	       		 <th width="5%" align="center" bgcolor="#CBE0FF" scope="col">朝向</th>
	       		 <th width="5%" align="center" bgcolor="#CBE0FF" scope="col">总使用面积</th>
	       		 <th width="5%" align="center" bgcolor="#CBE0FF" scope="col">占地面积</th>
	       		 <th width="5%" align="center" bgcolor="#CBE0FF" scope="col">状态</th>
	       		 <th width="15%" align="center" bgcolor="#CBE0FF" scope="col">备注</th>
	       </tr>
	       <s:iterator value="list"  status="i" var="li">
	     	<tr bgcolor="#FFFFFF" onmouseover="this.style.backgroundColor='#E3EFFF'"onmouseout="this.style.backgroundColor='#FFFFFF'">
	     	     <td height="20" align="center" ><input name="idcheckbox"  type="checkbox" id="btnChk"    value="${li.hu_sno}|${li.hu_scode}"> </td>
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
	       <table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
   
                       <s:if test="%{list.size()!=0}">
    			
    			<page:page uri="/houseunit!find"></page:page>
   				</s:if>
   				<s:else><br>
    				<span  style="color:red;font-size:14px;"><strong>抱歉，未查询到符合条件的信息！</strong> </span>
   				</s:else>
           </table>
	       </div>
 <input type="hidden" name="form.hu_sno" value="${form.hu_sno}" size="11"/>
  </form>
  </body>
</html>