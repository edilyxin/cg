<%@ page language="java" import="java.util.*" isELIgnored="false" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib  uri="/struts-tags" prefix="s"%>
<%@ taglib uri="/WEB-INF/page.tld" prefix="page" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
String urlparams = "ss_nid="+request.getParameter("ss_nid")+
"&set_nno="+request.getParameter("set_nno")+
"&bg_sno="+request.getParameter("bg_sno")+
"&ep_sno="+request.getParameter("ep_sno")+
"&set_spurtype="+request.getParameter("set_spurtype")+
"&set_nid="+request.getParameter("set_nid");
%>
<jsp:include page="/common/util.jsp" />
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>项目立项</title> 
<script>

function save(){
	document.form1.action="<%=path%>/supplier!save?<%=urlparams%>";
		if(validator()){
		if(confirm("是否保存？")){
			document.form1.action="<%=path%>/supplier!save?<%=urlparams%>";
			document.form1.submit();
			}
		} 
}		
 

  function checkAll(box){  //全选或全不选
	form1.checkbox.checked = box.checked;
  	if(form1.idcheckbox == null)
  		return;
  	var numRow = form1.idcheckbox.length;
  	if(numRow == null) {
  		form1.idcheckbox.checked = box.checked;	
  		return;
  	}
  	if(box.checked) {
		for (var i = 0; i < numRow; i++) {
			form1.idcheckbox[i].checked = true;
		}
	} else {
		for (var i = 0; i < numRow; i++) {
			form1.idcheckbox[i].checked = false;
		}
	}
  }
  
  function checkOne(){  //选一个时全选或全不选
  	
  	if(form1.idcheckbox == null)
  		return;
  	var numRow = form1.idcheckbox.length;
  	if(numRow == null) {
		form1.checkbox.checked = form1.idcheckbox.checked;
		return;
  	}
  	var numBox =0;
	for (var i = 0; i < numRow; i++) {
		if(form1.idcheckbox[i].checked){
			numBox++;
		}
	}
	if(numBox==numRow){
		form1.checkbox.checked = true;
	}else {
		form1.checkbox.checked = false;
	}
  }
 </script>

</head>

<body>

<form name="form1" method="post" action="<%=path %>/demo!find">
<div class="bigBox" id="idwidth">
		<!--外部大DIV，可以调整宽度-->
		<h2>
			<span><%-- <s:property value="#session.navbar"/> --%>项目立项</span>
		</h2>
		<div class="content">
			<table width="100%" border="0" cellpadding="0" cellspacing="0">
				<tr bgcolor="#D5EAFB" >
					<td height="30" align="left" colspan="2">
                <span  style="white-space:nowrap;">&nbsp;&nbsp;职称编号:
                <input type="text" name="searchA" id="searchA" value="${form.searchA}" /></span>
                <span  style="white-space:nowrap;">&nbsp;&nbsp;职称名称:
                <input type="text" name="searchB" id="searchB" value="${form.searchB}" /></span>
                <span  style="white-space:nowrap;">&nbsp;&nbsp;职称等级:
                <select name="searchC" id="searchC" style="width:145;">
    				<option value="" selected></option>
    				<%-- <s:iterator value="list1" var="job" status="s">
    				<option value="${job.post_nlevel}" <s:if test="form.searchC==#job.post_nlevel">selected</s:if>>${job.post_nlevel}级</option>    
    				</s:iterator>    --%> 
    				</select>&nbsp;&nbsp;
                </span>
                <span  style="white-space:nowrap;">&nbsp;&nbsp;
               <a href="javascript:void(0);"  onclick="findInfo()"><img src="<%=path%>/images/zoom.png" width="15" height="15" border="0"/> 查询</a>
               </span>
                </td>
				 	
				  </tr>
				<tr bgcolor="#0E6BB1">
				<td height="30" ><table width="100%" border="0" cellspacing="0" cellpadding="0">
              <tr>
                <td width="20" height="19" valign="bottom"><div align="center"><img src="<%=path%>/images/tb.gif" width="14" height="14" /></div></td>
                <td   valign="bottom"><span class="STYLE1" style="white-space:nowrap;">职称信息列表</span></td>
              </tr>
            </table></td>
            <!-- 根据配置添加功能按钮 -->
					<td align="right" >
					<span class="STYLE1"   style="white-space:nowrap;">
		                                                       
              						</span></td>
					</tr>
			</table>
    <div id="divwidth"  style="overflow:auto;overflow-y:hidden;">
   	<table width="1500px"  id="table1"  class="table"   border="0" cellpadding="0" cellspacing="1" bgcolor="#a8c7ce">
		<tr bgcolor="#CBE0FF">
	  	<th width="40px" height="25" class="STYLE10">
	  	<div align="center">
			<input type="checkbox" name="checkbox" id="checkbox" onclick="checkAll(this);"/>
	  	</div>
        </th>
        <th width="40px" height="24" class="STYLE6"><div align="center"><span class="STYLE10">1</span></div></th>
        <th width="120px" height="24" class="STYLE6"><div align="center"><span class="STYLE10">2</span></div></th>
        <th width="160px" height="24" class="STYLE6"><div align="center"><span class="STYLE10">3</span></div></th>
        <th width="160px" height="24" class="STYLE6"><div align="center"><span class="STYLE10">4</span></div></th>
        <th width="160px" height="24" class="STYLE6"><div align="center"><span class="STYLE10">5</span></div></th> 
        <th width="160px" height="24" class="STYLE6"><div align="center"><span class="STYLE10">6</span></div></th>
        <th width="160px" height="24" class="STYLE6"><div align="center"><span class="STYLE10">7</span></div></th>
        <th width="160px" height="24" class="STYLE6"><div align="center"><span class="STYLE10">8</span></div></th>
        <th  height="20" class="STYLE6"><div align="center"><span class="STYLE10">9</span></div></th>
        <th width="80px" height="24" class="STYLE6"><div align="center"><span class="STYLE10">10</span></div></th>
      </tr>

      <tr bgcolor="#FFFFFF">
        <td height="20" ><div align="center">
          11
        </div></td>
        <td height="20"  >1</td>
        <td height="20"   title=""><a href="javascript:void()" onclick="bidAgencyTree('appname','appid',0)">选择供应商</a>
        <input type="hidden" id="appname"></input>
        <input type="hidden" id="appid"></input>
        
        </td>
        <td height="20"   title="">信息</td>
        <td height="20"   title="">信息</td>
        <td height="20"   title="">信息</td>
        <td height="20"  title="">信息</td>
        <td height="20"   title="">信息</td>
        <td height="20"   title="">信息</td>
        <td height="20"   title="">信息</td>
        <td height="20"  >
           11        
        </td>         
        
      </tr>
   </table>
			</div>
  		</div>
		<div align="center">
		 <input type="button" onclick="save()" value="保存" class="button"></input>&nbsp;&nbsp;<input class="button" type="button" onclick="window.history.go(-1);" value="返回"></input>
<!-- 分页标签END -->
   		</div>
		</div>
		<a href="<%=path%>/process!find">返回</a>
</form>
</body>
</html>
  