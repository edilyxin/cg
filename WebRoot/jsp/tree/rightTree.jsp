<%@ page language="java" isELIgnored="false" pageEncoding="UTF-8"%>
<%@ taglib  uri="/struts-tags" prefix="s"%>
<%@ taglib uri="/WEB-INF/page.tld" prefix="page" %>
<%
String path = request.getContextPath();
//清缓存  
response.setHeader("Pragma", "No-cache");
response.setHeader("Cache-Control", "no-cache");
response.setDateHeader("Expires", 0);
%>
<jsp:include page="/common/util.jsp" />
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
  <base target="_self"/>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>功能信息管理</title>
<script type="text/javascript">
function find(){
 document.frm.action="<%=path%>/tree!findRight";
 document.all.frm.submit();
}
function returnVal(val1,val2){
	if (window.opener != undefined) {
	       //for chrome
	    window.opener.returnValue = val1+"|"+val2;
	}
	else {
	    window.returnValue = val1+"|"+val2;
	}
	window.close();	
}
function clearVal(){
	if (window.opener != undefined) {
       //for chrome
   	 window.opener.returnValue = "";
	}
	else {
    window.returnValue = "";
	}
	window.close();	
}
//获得divwidth的宽度
	function getwidth(){
		document.getElementById("divwidth").style.width= document.body.offsetWidth-50;
			document.getElementById("divwidth").style.width= document.getElementById("idwidth").offsetWidth;
			if(document.getElementById("table1").offsetWidth>document.getElementById("divwidth").offsetWidth){
				document.getElementById("divwidth").style.paddingBottom = "17px";
			}else{
				document.getElementById("divwidth").style.paddingBottom = "0px";
			}
			
	}
	
 $(function(){
 		$("#searchA").val($(".sysName").html());
			if($("#searchA").val()=="null"||$("#searchA").val()==null){
				$("#searchA").val("");
				
			}
 
 });

</script>
</head>

<body onload="getwidth()"  onresize="getwidth()">
<form name="frm" method="post">
<table width="100%" height="95%"  border="0" cellpadding="0" cellspacing="0" >
  <tr>
    <td width="17" valign="top" background="<%=path %>/images/mail_leftbg.gif">
    	<img src="<%=path %>/images/left-top-right.gif" width="17" height="29" />
    </td>
    <td valign="top" background="<%=path %>/images/content-bg.gif">
        <table width="100%" height="31" border="0" cellpadding="0" cellspacing="0" class="left_topbg" id="table2">
        <tr>
            <td height="31"><div class="titlebt">功能信息</div></td>
        </tr>
        </table>
    </td>
    <td width="16" valign="top" background="<%=path %>/images/mail_rightbg.gif">
    	<img src="<%=path %>/images/nav-right-bg.gif" width="16" height="29" />
    </td>
  </tr>
  <tr>
    <td valign="middle" height="100%" background="<%=path %>/images/mail_leftbg.gif">&nbsp;</td>
    <td valign="top" bgcolor="#F7F8F9">
    <table width="100%" border="0" cellpadding="0" cellspacing="1" bgcolor="#F7F8F9" >
      <tr >
        <td   valign="top">
    	<table width="100%" align="center"  border="0" class="STYLE10">
            <tr>
                <td  >
                	<span  style="white-space:nowrap;">&nbsp;&nbsp;系统名称:  	
			<input type="text" size="6" name="form.searchA" value="${form.searchA}" id="searchA" <s:if test="form.sysint_sno!=null">disabled</s:if>/>
                </span><span  style="white-space:nowrap;">&nbsp;&nbsp;功能名称:
                  <input type="text" size="6" name="form.searchB" value="${form.searchB}" />
                </span><span  style="white-space:nowrap;">&nbsp;&nbsp;上级功能名称:
                  <input type="text" size="6" name="form.searchC" value="${form.searchC}" />
                 </span>
                  <span  style="white-space:nowrap;">&nbsp;&nbsp;
                <a href="javaScript:void(0);"  style="cursor:hand" onclick="find();" >  <img src="<%=path%>/images/zoom.png" width="15" height="15" border="0"/> 查询</a>
              	 </span>
              	 <span  style="white-space:nowrap;">&nbsp;&nbsp;
              	 <a href="javaScript:void(0);"  style="cursor:hand" onclick="clearVal();" >  <img src="<%=path%>/images/pic3.jpg" width="15" height="15" border="0"/> 清空</a>
              	 </span>
                 </td>
			</tr>
        </table>
        <table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td height="30"><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td height="24" bgcolor="#353c44"><table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td><table width="100%" border="0" cellspacing="0" cellpadding="0">
              <tr>
                <td width="6%" height="19" valign="bottom"><div align="center"><img src="<%=path %>/images/tb.gif" width="14" height="14" /></div></td>
                <td width="94%" valign="bottom"><span class="STYLE1"> 功能信息列表</span></td>
              </tr>
            </table></td>
            <td><div align="right"><span class="STYLE1">
	                	<input type="hidden" name="form.sysint_sno" value="${form.sysint_sno}"/>
	                </span></div></td>
          </tr>
        </table></td>
      </tr>
    </table>
    			</td>
  			</tr>
  			<tr>
    			<td id="idwidth">
    <div id="divwidth"  style="overflow:auto;overflow-y:hidden;"> 
   	<table width="100%"  id="table1"  class="table"   border="0" cellpadding="0" cellspacing="1" bgcolor="#a8c7ce">
    	
      					<tr>
                            <td width="4%" height="20" bgcolor="d3eaef" class="STYLE6" nowrap><div align="center"><span class="STYLE10">序号</span></div></td>
        					<td width="10%" height="20" bgcolor="d3eaef" class="STYLE6" nowrap><div align="center"><span class="STYLE10">系统名称</span></div></td>
        					<td width="10%" height="20" bgcolor="d3eaef" class="STYLE6" nowrap><div align="center"><span class="STYLE10">功能名称</span></div></td>
        					<td width="10%" height="20" bgcolor="d3eaef" class="STYLE6" nowrap><div align="center"><span class="STYLE10">功能编号</span></div></td>
                            <td width="10%" height="20" bgcolor="d3eaef" class="STYLE6" nowrap><div align="center"><span class="STYLE10">上级功能</span></div></td>
                            <td width="20%" height="20" bgcolor="d3eaef" class="STYLE6" nowrap><div align="center"><span class="STYLE10">功能地址</span></div></td>
        					<td width="20%"height="20" bgcolor="d3eaef" class="STYLE6" nowrap><div align="center"><span class="STYLE10">描述</span></div></td>
      					</tr>
      					
      						<s:iterator value="treeList"  var="v" status="s">
							<tr bgcolor="#ffffff" align="center" class=Off onMouseOut="this.className='Off'" onMouseOver="this.className='Up'"  style="font-size:12px;cursor:hand; " ondblclick="returnVal('<s:property value="#v.right_sno"/>','<s:property value="#v.right_sname"/>')">
                            <td height="24" nowrap><s:property value="#s.index + 1"/></td>
	     					<td nowrap class="sysName">${v.sysint_sname}</td>
	     					<td nowrap>${v.right_sname}</td>
	     					<td nowrap>${v.right_sno}</td>
                            <td nowrap>${v.right_sparentname}</td>
                            <td nowrap>${v.right_smenuurl}</td>
                           <td nowrap title="${v.right_sdesc}">
                            	<s:if test="%{#v.right_sdesc.length() > 15}">
                            		<s:property value="#v.right_sdesc.substring(0, 15) + '...'"/>
                            	</s:if>
                            	<s:else>${v.right_sdesc}</s:else>
                            </td>
                            <!-- <td nowrap>
                            	<s:if test="#v.right_sisvalid == \"0\"">启用</s:if>
                            	<s:if test="#v.right_sisvalid == \"1\"">不启用</s:if>
                            </td>
	     				--></tr>
	       				</s:iterator>
    				</table>
    			</div>
    			</td>
  			</tr>
  			<tr>
    			<td height="30" align="center">
    				<table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="100%" nowrap><div align="center"  >
 				<s:if test="%{treeList.size()!=0}">
 					<page:page uri="/tree!findRight"></page:page>
 				</s:if>
 				<s:elseif test="%{treeList.size()==0}"> <br>
 				<span  style="color:red;font-size:14px;"><strong>抱歉，未查询到符合条件的信息！</strong> </span>
 				</s:elseif>
	   		</div></td>
      </tr>
    </table></td>
  </tr>
</table>
    </td> 
    	</tr>
    </table>
    </td>
    <td background="<%=path %>/images/mail_rightbg.gif">&nbsp;</td>
  </tr>
  <tr>
    <td  valign="bottom" background="<%=path %>/images/mail_leftbg.gif"><img src="<%=path %>/images/buttom_left2.gif" width="17" height="17" /></td>
    <td  valign="bottom" background="<%=path %>/images/buttom_bgs.gif"><img src="<%=path %>/images/buttom_bgs.gif" width="100%" height="17"></td>
    <td  valign="bottom" background="<%=path %>/images/mail_rightbg.gif"><img src="<%=path %>/images/buttom_right2.gif" width="16" height="17" /></td>
  </tr>
</table>
</form>
</body>
</html>
