<%@ page language="java"  isELIgnored="false" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>

<%
String path = request.getContextPath();
%>
<jsp:include page="/jsp/toppage.jsp"/>
<jsp:include page="/jsp/funMenu.jsp"/>
<div class="right1">
        	<ul class="right1_ul1">
            	<li><img src="<%=path %>/image/landian.jpg" /></li>
                <li>模块功能列表</li>
               
            </ul>
            
        </div>
          <div class="right2">
  	<div class="right2_s">
  	</div>
  	<div class="right2_x" >
  	<div style="width:728px;height:490px;overflow:auto;">
  	<table width="100%" border="0" align="center" cellpadding="2" cellspacing="1" bgcolor="#93B3CA" onmouseover="changeto()"  onmouseout="changeback()">
	 <tr align="center" bgcolor="#d3eaef">
	       		<td width="20" height="20" align="center"  style="word-break:break-all" ></td>
	       		<td width="100">功能模块名称</td>
	       		<td  >描述</td>
	       		<td width="100">级别</td>
	       </tr>
	       <logic:notEmpty name="list">
	       <logic:iterate id="li" name="list" scope="request" indexId="i">
	     	<tr bgcolor="#ffffff" align="center">
	     	    <td><%=i+1 %></td>
	     		<td><bean:write name="li" property="rightsName"/></td>
	     		<td><bean:write name="li" property="rightsDesc"/></td>
	     		<td><bean:write name="li" property="rightnNum"/></td>
	     	</tr>
	       </logic:iterate>
	       </logic:notEmpty>
	       </table>
	       </div>
	       
	       
  	
    </div>
  </div>
     

