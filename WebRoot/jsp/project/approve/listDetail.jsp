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
  //查询
  function findInfo(){
	  if(document.form1.idcheckbox==null){
		  return;
	}
	  
	   var len = document.form1.idcheckbox.length;
	   var flag = 0;
	   var knum=0;
	   if(len!=undefined)
	   {
		  for(var i=0;i<len;i++)
		  {
			if(eval(document.form1.idcheckbox[i].checked))
			{
				flag++;
				knum=i;
			}
		 }
	  }else
	  {
		if(document.form1.idcheckbox.checked)
		{
			flag++;
		}
	  }
	 
	 if(flag==0)
	 {
		alert("请选择一条记录！");
		return;
	 }
	 else if(confirm("是否修改？"))
	 {
		 document.form1.action="<%=path%>/approve!save";
		  document.all.form1.submit();
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
                <input type="text" name="searchA" id="searchA" value="${form.searchA}" />
                <input type="hidden" name="form.searchA" id="searchA1" value="${form.searchA}" />
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
                <td   valign="bottom"><span class="STYLE1" style="white-space:nowrap;">项目明细信息列表</span></td>
              </tr>
            </table></td>
            <!-- 根据配置添加功能按钮 -->
					<td align="right" >
					<span class="STYLE1"   style="white-space:nowrap;">
					<a href="javascript:void(0)" onclick="submitPurType1()">暂存采购方式</a>
														<s:if test="#session.operList.get(\"020402\")!=null">
              											<a title="修改" href="javascript:void(0)" onclick="toUpdate()">
 														  <img  src="<%=path%>/<s:property value="#session.operList.get(\"020402\").oper_simg"/>" width="10" height="10" border="0"/> 
														  <span class="STYLE1"><s:property value="#session.operList.get(\"020402\").oper_sname"/>             											
              											 </span></a>&nbsp;
              											</s:if>
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
        
        <th width="120px" height="24" class="STYLE6"><div align="center"><span class="STYLE10">项目代码</span></div></th>
        <th width="160px" height="24" class="STYLE6"><div align="center"><span class="STYLE10">项目名称</span></div></th>
        <th width="160px" height="24" class="STYLE6"><div align="center"><span class="STYLE10">负责人</span></div></th>
        <th width="160px" height="24" class="STYLE6"><div align="center"><span class="STYLE10">明细内容</span></div></th> 
        <th width="160px" height="24" class="STYLE6"><div align="center"><span class="STYLE10">单位</span></div></th>
        <th width="160px" height="24" class="STYLE6"><div align="center"><span class="STYLE10">单价</span></div></th>
        <th width="160px" height="24" class="STYLE6"><div align="center"><span class="STYLE10">数量</span></div></th>
        <th width="160" class="STYLE6"><div align="center"><span class="STYLE10">总金额</span></div></th>
        <th width="80px" height="24" class="STYLE6"><div align="center"><span class="STYLE10">采购方式</span></div></th>
      </tr>
     <s:iterator value="list"  id="li" status="st"> 
     
      <tr bgcolor="#FFFFFF" <s:if test="#li.EPD_SISVALID==\"1\"">style="color:red;"</s:if>>
      	<td height="20" ><div align="center">
          <input type="checkbox" id="idcheckbox" name="idcheckbox" onclick="checkOne();"  value="${li.EPD_NID}" />
          <input type="hidden" id="setSIsValid" name="setSIsValid" value="${li.EPD_SISVALID}"/>
        </div></td>
        <td height="20"   title="${li.EPD_SASKNO}">${li.EPD_SASKNO}</td>
        <td height="20"   title="${li.EP_SNO}">${li.EP_SNO}</td>
        <td height="20"   title="${li.EP_SNO}">${li.EP_SNO}</td>
        <td height="20"   title="${li.EPD_SNAME}">${li.EPD_SNAME}</td>
        <td height="20"  title="${li.EPD_SUNIT}">${li.EPD_SUNIT}</td>
        <td height="20"   title="${li.EPD_NPRICE}">${li.EPD_NPRICE}</td>
        <td height="20"   title="${li.EPD_NNUM}">${li.EPD_NNUM}</td>
        <td height="20"   title="${li.EPD_NTOTAL}">${li.EPD_NTOTAL}</td>
        <td height="20"   title="${li.EPD_NTOTAL}">${li.EPD_SPURTYPE}</td> 
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
   		<div>
   			采购方式：
   			<select name="form.EPD_SPURTYPE" id="EPD_SPURTYPE">
   				<option value=0>招标采购</option>
   				<option value=1>集中采购</option>
   				<option value=2>自行采购</option>
   			</select>
   		</div>
   		<div>
   			<input onclick="findInfo()" type="button" value="暂存采购方式" /><input onclick="findInfo()" type="button" value="提交采购方式" />
   		</div>
		</div>
		
</form>
</body>
</html>
  