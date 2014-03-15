<%@ page language="java" import="java.util.*,java.text.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib  uri="/struts-tags" prefix="s"%>
<%@ taglib uri="/WEB-INF/page.tld" prefix="page" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
Date now =new Date();
    SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
    String dateSign = sdf.format(now.getTime()); //当前日期 
%>
<jsp:include page="/common/util.jsp" />
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<title>日志信息</title>
<script>

function find(){
 	if(!validator(document.form1)){
           return false;
   }
   var beginDate = document.getElementById("beginDate").value;
   var beginTime = document.getElementById("beginTime").value;
   var endDate = document.getElementById("endDate").value;
   var endTime = document.getElementById("endTime").value;
   if(beginDate+" "+beginTime >= endDate+" "+endTime ){
      alert("- 开始时间应小于结束时间!");
        return false;
    }
  	input_trim();      	
   
	var len = document.form1.searchA.length;
	var flag = 0;
	if(len!=undefined){
		for(var i=0;i<len;i++){
			if(eval(document.form1.searchA[i].checked)){
				document.getElementById("searchA1").value=document.form1.searchA[i].value;
			}
		}
	} 
 document.getElementById("searchB1").value=document.getElementById("searchB").value;
 document.getElementById("beginDate1").value=document.getElementById("beginDate").value;
 document.getElementById("beginTime1").value=document.getElementById("beginTime").value;
 document.getElementById("endDate1").value=document.getElementById("endDate").value;
 document.getElementById("endTime1").value=document.getElementById("endTime").value;
 document.all.form1.submit();
}
</script>

</head>

<body> 
<form name="form1" id="form1" method="post"   >
<div class="bigBox" id="idwidth">
		<!--外部大DIV，可以调整宽度-->
		<h2>
			<span><s:property value="#session.navbar"/></span>
		</h2>
		<div class="content">
			<table width="100%" border="0" cellpadding="0" cellspacing="0">
				<tr bgcolor="#D5EAFB" >
					<td height="30" align="left" colspan="2">
               	<span  style="white-space:nowrap;">&nbsp;&nbsp;操作类型:<select id="searchA" name="searchA">
                <option value=""></option>
                        	<option value="0" <s:if test="%{form.searchA==\"0\"}">selected</s:if>>登陆</option>
                            <option value="1" <s:if test="%{form.searchA==\"1\"}">selected</s:if>>登出</option>
                            <option value="2" <s:if test="%{form.searchA==\"2\"}">selected</s:if>>操作</option>
                </select></span>
                <span  style="white-space:nowrap;">&nbsp;&nbsp;用户:<input type="text" id="searchB" name="searchB" value="${form.searchB}"/></span>
                <span  style="white-space:nowrap;">&nbsp;&nbsp;时间：
      <input type="text" name="beginDate" id="beginDate" value="<s:if test="%{form.beginDate!=null}"><s:property value="form.beginDate"/></s:if><s:else><%=dateSign %></s:else>" size="12" onfocus="WdatePicker({maxDate:'%y-%M-{%d}'})"  class="Wdate" valid="required" errmsg="请选择开始日期!"/>
      <input  name="beginTime" id="beginTime" type="text"   value="<s:if test="%{form.beginTime!=null}"><s:property value="form.beginTime"/></s:if><s:else>00:00:00</s:else>" size="8" onfocus="WdatePicker({dateFmt:'HH:mm:ss', startDate:'00:00:00', alwaysUseStartDate:true})" valid="required" errmsg="请选择开始时间!"/>
              至 
      <input type="text" name="endDate" id="endDate" value="<s:if test="%{form.endDate!=null}"><s:property value="form.endDate"/></s:if><s:else><%=dateSign %></s:else>" size="12" onfocus="WdatePicker({maxDate:'%y-%M-{%d}'})"  class="Wdate" size="8" valid="required" errmsg="请选择结束日期!"/>
      <input  name="endTime" id="endTime" type="text" value="<s:if test="%{form.endTime!=null}"><s:property value="form.endTime"/></s:if><s:else>23:59:59</s:else>" size="8" onfocus="WdatePicker({dateFmt:'HH:mm:ss',  alwaysUseStartDate:true})" valid="required" errmsg="请选择结束时间!"/></span>
                
                <span  style="white-space:nowrap;">&nbsp;&nbsp;<a href="javascript:void(0);" onclick="find();" style="cursor:hand"><img src="<%=path %>/images/zoom.png" border="0" width="15" height="15"/> 查询</a></span>
                
			 </td>
				<td></td>	
				  </tr>
				<tr bgcolor="#0E6BB1">
				<td height="30" ><table width="100%" border="0" cellspacing="0" cellpadding="0">
              <tr>
                <td width="20" height="19" valign="bottom"><div align="center"><img src="<%=path%>/images/tb.gif" width="14" height="14" /></div></td>
                <td   valign="bottom"><span class="STYLE1" style="white-space:nowrap;">日志信息列表</span></td>
              </tr>
            </table></td>
					<td align="right" >
	           &nbsp;
           </td>
					</tr>
			</table>
     <div id="divwidth"  style="overflow:auto;overflow-y:hidden;"> 
    <table width="1000px" id="table1" class="table"  border="0" cellpadding="0" cellspacing="1" bgcolor="#a8c7ce">
      <tr bgcolor="#CBE0FF" class="STYLE6" align="center" style="font-size:12px;">
        <th  width="40" height="20"  class="STYLE6">序号</th>
        <th width="80"  class="STYLE6">操作类型</th>
        <th width="100"  class="STYLE6">用户</th>
        <th width="100"  class="STYLE6">IP</th>
        <th width="140"  class="STYLE6">操作时间</th> 
        <th  class="STYLE6">操作内容</th> 
        <th width="100"  class="STYLE6">操作表名</th>
        <th width="100"  class="STYLE6">修改人</th>
        <th width="100"  class="STYLE6">修改时间</th>
      </tr>
       
		 
		
      
      
      <s:iterator value="list" status="s" var="li">
	  <tr bgcolor="#ffffff"   class="STYLE19">
	  <td><s:property value="%{#s.index+1}"/> </td>
	  <td height="20" title="<s:if test="%{#li.log_soptype==\"0\"}">登陆</s:if><s:if test="%{#li.log_soptype==\"1\"}">登出</s:if><s:if test="%{#li.log_soptype==\"2\"}">操作</s:if>">
	  	  <s:if test="%{#li.log_soptype==\"0\"}">
	  			登陆
	  	  </s:if>
	  	  <s:if test="%{#li.log_soptype==\"1\"}">
	  			登出
	  	  </s:if>
	  	  <s:if test="%{#li.log_soptype==\"2\"}">
	  			操作
	  	  </s:if>
	  </td>
	  <td title="<s:property value="#li.log_sreplyby"/>"><s:property value="#li.log_sreplyby"/></td>
      <td title="<s:property value="#li.log_sip"/>"><s:property value="#li.log_sip"/></td>
      <td title="<s:date name="#li.log_ttime" format="yyyy-MM-dd HH:mm:ss"/>"><s:date name="#li.log_ttime" format="yyyy-MM-dd HH:mm:ss"/></td>
      <td title="<s:property value="#li.log_scontent"/>"><s:property value="#li.log_scontent"/></td>
      <td title="<s:property value="#li.log_stable"/>"><s:property value="#li.log_stable"/></td>
      <td title="<s:property value="#li.log_salterby"/>"><s:property value="#li.log_salterby"/></td>
      <td title="<s:date name="#li.log_dalterdate" format="yyyy-MM-dd HH:mm:ss"/>"><s:date name="#li.log_dalterdate" format="yyyy-MM-dd HH:mm:ss"/></td>
	</tr>
	
 </s:iterator>
 </table>
			</div>
  		</div>
		<div align="center">
<!-- 分页标签BEGIN -->
						<s:if test="list.size()!=0">
							<page:page uri="/log!find"></page:page>
						</s:if>
						<s:elseif test="list.size()==0">
							<div align="center"><span style="color: red; font-size: 14px;"><strong>抱歉，未查询到符合条件的信息！</strong></span></div>
						</s:elseif>
		 
<!-- 分页标签END -->
   		</div>
		</div>
		 <input type="hidden" id="searchA1" name="form.searchA" value="${form.searchA}"/>
				<input type="hidden" id="searchB1" name="form.searchB" value="${form.searchB}" />
				<input type="hidden" id="beginDate1" name="form.beginDate" value="${form.beginDate}" />
				<input type="hidden" id="beginTime1" name="form.beginTime" value="${form.beginTime}" />
				<input type="hidden" id="endDate1" name="form.endDate" value="${form.endDate}" />
				<input type="hidden" id="endTime1" name="form.endTime" value="${form.endTime}" />
</form>
</body>
</html>
