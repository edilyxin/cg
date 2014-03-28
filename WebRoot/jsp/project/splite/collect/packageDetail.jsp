<%@ page language="java" import="java.util.*" isELIgnored="false" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib  uri="/struts-tags" prefix="s"%>
<%@ taglib uri="/WEB-INF/page.tld" prefix="page" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<jsp:include page="/common/util.jsp" />
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>项目立项</title> 
<script>
  
 function toMain(){
	 window.location.href="<%=path%>/splite!find?EP_SNO=<%=request.getParameter("EP_SNO")%>";
 }

</script>

</head>

<body>

<form name="form1" method="post" action="<%=path %>/demo!find">
<div class="bigBox" id="idwidth">
		<!--外部大DIV，可以调整宽度-->
		<h2>
			<span>拆分报价</span>
		</h2>
		<div class="content">
			<table width="100%" border="0" cellpadding="0" cellspacing="0">
				<tr bgcolor="#D5EAFB" >
					<td height="30" align="left" colspan="2">
					预算明细内容（产品品目）：<s:property value="projectDetail.EPD_SNAME" />
					<br/>
					单位：<s:property value="projectDetail.EPD_SUNIT" /><br/>
					审定单价：<s:property value="projectDetail.EPD_NPRICE" /><br/>
					审定数量：<s:property value="projectDetail.EPD_NNUM" /><br/>
					审定总金额：<s:property value="projectDetail.EPD_NTOTAL" /><br/>
                	</td>
				 	
				  </tr>
				  
				<tr bgcolor="#0E6BB1">
				<td height="30" ><table width="100%" border="0" cellspacing="0" cellpadding="0">
              <tr>
                <td width="20" height="19" valign="bottom"><div align="center"><img src="<%=path%>/images/tb.gif" width="14" height="14" /></div></td>
                <td   valign="bottom"><span class="STYLE1" style="white-space:nowrap;">拆分报价</span></td>
              </tr>
            </table></td>
            <!-- 根据配置添加功能按钮 -->
					<td align="right" >
					<span class="STYLE1"   style="white-space:nowrap;">
					<a title="新增其他" href="<%=path%>/splite!toAddPackageDetail?EPD_NID=<s:property value="projectDetail.EPD_NID" />&EP_SNO=<s:property value="projectDetail.EP_SNO" />">
					  <img src="<%=path%>/<s:property value="#session.operList.get(\"020401\").oper_simg"/>" width="10" height="10" border="0"/> 
					  <span class="STYLE1"><s:property value="#session.operList.get(\"020401\").oper_sname"/>
					</span></a>&nbsp;                   
            		</span></td>
					</tr>
			</table>
    <div id="divwidth"  style="overflow:auto;overflow-y:hidden;">
   	<table width="1500px"  id="table1"  class="table"   border="0" cellpadding="0" cellspacing="1" bgcolor="#a8c7ce">
		<tr bgcolor="#CBE0FF">
	  	<th width="40px" height="25" class="STYLE10">
	  	<div align="center">
			序号
	  	</div>
        </th>
        <th width="40px" height="24" class="STYLE6"><div align="center"><span class="STYLE10">产品品目</span></div></th>
        <th width="120px" height="24" class="STYLE6"><div align="center"><span class="STYLE10">品牌</span></div></th>
        <th width="160px" height="24" class="STYLE6"><div align="center"><span class="STYLE10">型号</span></div></th>
        <th width="160px" height="24" class="STYLE6"><div align="center"><span class="STYLE10">单位</span></div></th>
        <th width="160px" height="24" class="STYLE6"><div align="center"><span class="STYLE10">报价（单价）</span></div></th> 
        <th width="160px" height="24" class="STYLE6"><div align="center"><span class="STYLE10">数量</span></div></th>
        <th width="160px" height="24" class="STYLE6"><div align="center"><span class="STYLE10">报价（总金额）</span></div></th>
        <th width="160px" height="24" class="STYLE6"><div align="center"><span class="STYLE10">备注</span></div></th>
        <th width="80px" height="24" class="STYLE6"><div align="center"><span class="STYLE10">操作</span></div></th>
      </tr>
     <s:iterator value="packageLists"  id="li" status="st"> 
      <tr bgcolor="#FFFFFF">
        <td height="20" ><div align="center">
          ${st.index+1}
        </div></td>
        <td height="20" >${li.PL_SNAME}</td>
        <td height="20" >${li.PL_SXYBRAND}</td>
        <td height="20" >${li.PL_SXYMODEL}</td>        
        <td height="20" >${li.PL_SUNIT}</td>
        <td height="20" >${li.PL_SXYUNIT}</td>
        <td height="20" >${li.PL_NNUM}</td>
        <td height="20" >${li.PL_SXYTOTAL}</td>
        <td height="20" >${li.PL_SREMARK}</td>
        <td height="20" >
        <a href="<%=path%>/splite!toUpdatePackageDetail?EPD_NID=<s:property value="projectDetail.EPD_NID" />&PL_NNO=${li.PL_NNO}">修改</a>
        &nbsp;&nbsp; 
        <a href="<%=path%>/splite!deletePackageDetail?EPD_NID=<s:property value="projectDetail.EPD_NID" />&PL_NNO=${li.PL_NNO}">删除</a></td>
      
        
      </tr>
      </s:iterator>
     </table>
			</div>
  		</div>
		<div align="center">
<!-- 分页标签BEGIN -->
						<s:if test="list.size()!=0">
							<page:page uri="/post!find"></page:page>
						</s:if>
						<s:elseif test="list.size()==0">
							<div align="center"><span style="color: red; font-size: 14px;"><strong>抱歉，未查询到符合条件的信！</strong></span></div>
						</s:elseif>
		 
<!-- 分页标签END -->
   		</div>
		</div>
<table width="100%" border="0" cellspacing="0" cellpadding="0">
      				<tr>
        				<td align="center">
							<input type="button" name="Submit2" value="返回" class="button" onclick="toMain()"/>
						</td>
      				</tr>
    				</table>
</form>
</body>
</html>
  