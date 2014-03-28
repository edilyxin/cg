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

//分包
function splitPackage(){ 
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
	 if(confirm("是否提交？"))
	 {			
		document.form1.action="<%=path%>/splite!splitPackage?EP_SNO=<%=request.getParameter("EP_SNO")%>";
		document.form1.submit();
	 }	
 }


//提交
function toSubmit(){ 
	 if(confirm("是否提交？"))
	 {		
		document.form2.action="<%=path%>/splite!submitCollect?EP_SNO=<%=request.getParameter("EP_SNO")%>";
		document.form2.submit();
	 }	
 }

  //查询
  function findInfo(){
  input_trim();
  document.getElementById("searchA1").value=document.getElementById("searchA").value;
  document.getElementById("searchB1").value=document.getElementById("searchB").value;
  document.getElementById("searchC1").value=document.getElementById("searchC").value;
  document.form1.action="<%=path%>/demo!find";
  document.all.form1.submit();
}
  //新增
  function toAdd(){
	document.form1.action="<%=path%>/demo!toAdd";
	document.form1.submit();

}
 //修改
 function toUpdate(){
  var obj1=document.getElementsByName("post_sisvalid");
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
				if(obj1[knum].value==1)
			  	 {			  
			  	 }
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
	 }else if(flag!=1)
	 {
		alert("请只选择一条记录，不要多选！");
		return;
	 }
	 if(confirm("是否修改？"))
	 {
		document.form1.action="<%=path%>/demo!toUpdate";
		document.form1.submit();
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
			<b>招标采购</b>
		</h2>
		<div class="content">
			<table width="100%" border="0" cellpadding="0" cellspacing="0">

				<tr bgcolor="#0E6BB1">
				<td height="30" ><table width="100%" border="0" cellspacing="0" cellpadding="0">
              <tr>
                <td width="20" height="19" valign="bottom"><div align="center"><img src="<%=path%>/images/tb.gif" width="14" height="14" /></div></td>
                <td   valign="bottom"><span class="STYLE1" style="white-space:nowrap;">明细预算表</span></td>
              </tr>
            </table></td>
            <!-- 根据配置添加功能按钮 -->
					<td align="right" >
									
					<span class="STYLE1"   style="white-space:nowrap;">
								<s:if test="#session.operList.get(\"020401\")!=null">
								<a  href="javascript:void(0);" onclick="splitPackage()" >
								  <img src="<%=path%>/<s:property value="#session.operList.get(\"020401\").oper_simg"/>" width="10" height="10" border="0"/> 
								  将所选包分成一份</a>
								 </s:if>
                                 
                                 <s:if test="#session.operList.get(\"020401\")!=null">
								<a  href="<%=path%>/declarep!toAdd?EP_SNO=<%=request.getParameter("EP_SNO")%>" >
								  <img src="<%=path%>/<s:property value="#session.operList.get(\"020401\").oper_simg"/>" width="10" height="10" border="0"/> 
								  批量导出技术参数</a>
								 </s:if>  
								 
								   <s:if test="#session.operList.get(\"020401\")!=null">
								<a  href="<%=path%>/declarep!toAdd?EP_SNO=<%=request.getParameter("EP_SNO")%>" >
								  <img src="<%=path%>/<s:property value="#session.operList.get(\"020401\").oper_simg"/>" width="10" height="10" border="0"/> 
								 填写/查看进口申报</a>
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
        <th width="120px" height="24" class="STYLE6"><div align="center"><span class="STYLE10">明细预算内容<br/>（产品品目）</span></div></th>
        <th width="60px" height="24" class="STYLE6"><div align="center"><span class="STYLE10">单位</span></div></th>
        <th width="60px" height="24" class="STYLE6"><div align="center"><span class="STYLE10">审定单价</span></div></th> 
        <th width="60px" height="24" class="STYLE6"><div align="center"><span class="STYLE10">审定数量</span></div></th>
        <th width="60px" height="24" class="STYLE6"><div align="center"><span class="STYLE10">审定总金额</span></div></th>
        <th width="60x" height="24" class="STYLE6"><div align="center"><span class="STYLE10">是否进口</span></div></th>
        <th width="60x" height="24" class="STYLE6"><div align="center"><span class="STYLE10">是否免税</span></div></th>
        <th width="160px" height="24" class="STYLE6"><div align="center"><span class="STYLE10">技术参数</span></div></th>
      </tr>
     <s:iterator value="bitList"  id="li" status="st"> 
      <tr bgcolor="#FFFFFF" >
        <td height="20" ><div align="center">
          <input type="checkbox" name="idcheckbox" onclick="checkOne();"  value="${li.EPD_NID}" />        
        </div></td>
        <td height="20"  >${li.EPD_SNAME}</td>
        <td height="20"  >${li.EPD_SUNIT}</td>
        <td height="20"  >${li.EPD_NPRICE}</td>
        <td height="20"  >${li.EPD_NNUM}</td>
        <td height="20"  >${li.EPD_NTOTAL}</td>
        <td height="20"  >${li.EPD_SISIMPORT }</td>         
        <td height="20"  >${li.EPD_SISFREETAX }</td>        
        <td height="20"><a href="<%=path%>/splite!toUpdateparameter?EP_SNO=<%=request.getParameter("EP_SNO")%>&EPD_NID=${li.EPD_NID}">填写/查看</a></td>
      </tr>
      </s:iterator>
   </table>
			</div>
  		</div>
	


<div class="content">
			<table width="100%" border="0" cellpadding="0" cellspacing="0">
				<tr bgcolor="#0E6BB1">
				<td height="30" ><table width="100%" border="0" cellspacing="0" cellpadding="0">
              <tr>
                <td width="20" height="19" valign="bottom"><div align="center"><img src="<%=path%>/images/tb.gif" width="14" height="14" /></div></td>
                <td   valign="bottom"><span class="STYLE1" style="white-space:nowrap;">已分包列表</span></td>
              </tr>
            </table></td>
            <!-- 根据配置添加功能按钮 -->
					<td align="right" >
									
					</td>
					</tr>
			</table>
    <div id="divwidth"  style="overflow:auto;overflow-y:hidden;">
   	<table width="1500px"  id="table1"  class="table"   border="0" cellpadding="0" cellspacing="1" bgcolor="#a8c7ce">
		<tr bgcolor="#CBE0FF">
	  	<th width="40px" height="25" class="STYLE10">
	  	<div align="center">
			
	  	</div>
        </th>
        <th width="120px" height="24" class="STYLE6"><div align="center"><span class="STYLE10">分包内容</span></div></th>
        <th width="60px" height="24" class="STYLE6"><div align="center"><span class="STYLE10">包操作</span></div></th>
        <th width="60px" height="24" class="STYLE6"><div align="center"><span class="STYLE10">分包明细</span></div></th> 
        <th width="60px" height="24" class="STYLE6"><div align="center"><span class="STYLE10">数量</span></div></th>
        <th width="60px" height="24" class="STYLE6"><div align="center"><span class="STYLE10">操作</span></div></th>      
      </tr>
     <s:iterator value="allPackage"  id="item" status="st"> 
       
        <s:iterator value="#item.packageList" status="st2">
         <tr bgcolor="#FFFFFF">      	
        	<s:if test="#st2.First">
        	 	<td height="20" rowspan="${item.packageList.size() }"><div align="center">
        		<s:property value="BG_SNO" />
        		</div></td> 
        	 </s:if>
           <td height="20"  ><s:property value="PL_SNAME" /></td>
	        <s:if test="#st2.First">
        	 	 <td height="20" rowspan="${item.packageList.size() }">
        	 	 	<s:if test="BG_SSTATUS==0">
        	 	 	<a href="<%=path%>/splite!submitPackage?BG_SNO=<s:property value="BG_SNO" />&EP_SNO=<%=request.getParameter("EP_SNO")%>">提交</a>
        	 	 	</s:if><s:else>        	 	 		
        	 	 		已提交
        	 	 	</s:else>
        	 	 </td>
           </s:if>
	       
	       <td height="20"   ><s:property value="PL_SNAME" /></td>
	       <td height="20"  ><s:property value="PL_NNUM" /></td>         
	       <s:if test="#st2.First">
        	 	 <td height="20" rowspan="${item.packageList.size() }">
        	 	 	<s:if test="BG_SSTATUS==0">
        	 	 	<a href="<%=path%>/splite!deletePackage?BG_SNO=<s:property value="BG_SNO" />&EP_SNO=<%=request.getParameter("EP_SNO")%>">删除</a>
        	 	 	</s:if><s:else>
        	 	 		
        	 	 	</s:else>
        	 	 </td>
           </s:if>
	      
      	</tr>
        </s:iterator>       
     
      </s:iterator>
   </table>
			</div>
  		</div>



		</div>
	
</form>

<form name="form2" method="post" action="<%=path %>/demo!find">
<div class="bigBox" id="idwidth">
		<!--外部大DIV，可以调整宽度-->
		<h2>
			<b>集中采购</b>
		</h2>
		<div class="content">
			<table width="100%" border="0" cellpadding="0" cellspacing="0">
				
				<tr bgcolor="#0E6BB1">
				<td height="30" ><table width="100%" border="0" cellspacing="0" cellpadding="0">
              <tr>
                <td width="20" height="19" valign="bottom"><div align="center"><img src="<%=path%>/images/tb.gif" width="14" height="14" /></div></td>
                <td   valign="bottom"><span class="STYLE1" style="white-space:nowrap;">政府采购查询系统(<a target="_blank" href="http://www.bgpc.gov.cn/">http://www.bgpc.gov.cn/</a>)</span></td>
              </tr>
            </table></td>
            <!-- 根据配置添加功能按钮 -->
					<td align="right" >
					<span class="STYLE1"   style="white-space:nowrap;">
					
														<s:if test="#session.operList.get(\"020401\")!=null">
														<a title="点击提交（提交下面所有技术参数）" href="javascript:void(0);" onclick="toSubmit()" >
														  <img src="<%=path%>/<s:property value="#session.operList.get(\"020401\").oper_simg"/>" width="10" height="10" border="0"/> 
														  点击提交（提交下面所有技术参数）														
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
			
	  	</div>
        </th>
        <th width="120px" height="24" class="STYLE6"><div align="center"><span class="STYLE10">明细预算内容<br/>（产品品目）</span></div></th>
        <th width="120px" height="24" class="STYLE6"><div align="center"><span class="STYLE10">其他操作</span></div></th>
        <th width="160px" height="24" class="STYLE6"><div align="center"><span class="STYLE10">技术参数</span></div></th>
        <th width="60px" height="24" class="STYLE6"><div align="center"><span class="STYLE10">单位</span></div></th>
        <th width="60px" height="24" class="STYLE6"><div align="center"><span class="STYLE10">审定单价</span></div></th> 
        <th width="60px" height="24" class="STYLE6"><div align="center"><span class="STYLE10">审定数量</span></div></th>
        <th width="60px" height="24" class="STYLE6"><div align="center"><span class="STYLE10">审定总金额</span></div></th>
        <th width="60px" height="24" class="STYLE6"><div align="center"><span class="STYLE10">品牌</span></div></th>
        <th width="60x" height="24" class="STYLE6"><div align="center"><span class="STYLE10">型号</span></div></th>
        <th width="60x" height="24" class="STYLE6"><div align="center"><span class="STYLE10">报价（单价）</span></div></th>
        <th width="60x" height="24" class="STYLE6"><div align="center"><span class="STYLE10">报价（总额）</span></div></th>
        <th width="60x" height="24" class="STYLE6"><div align="center"><span class="STYLE10">是否进口</span></div></th>
        <th width="60x" height="24" class="STYLE6"><div align="center"><span class="STYLE10">是否免税</span></div></th>
      
      </tr>
     <s:iterator value="collectList"  id="li" status="st"> 
      <tr bgcolor="#FFFFFF">
        <td height="20" ><div align="center">
         ${st.index+1}
          <input type="hidden" name="idcheckbox" onclick="checkOne();"  value="${li.EPD_NID}" />        
        </div></td>
        <td height="20">${li.EPD_SNAME}</td>
        <td height="20"><a href="<%=path%>/splite!toCollectdetail?EPD_NID=${li.EPD_NID}&EP_SNO=<%=request.getParameter("EP_SNO")%>">拆分报价</a></td>
        <td height="20"><a href="<%=path%>/splite!toCollectupdate?EPD_NID=${li.EPD_NID}&EP_SNO=<%=request.getParameter("EP_SNO")%>">填写/查看</a></td>
        <td height="20">${li.EPD_SUNIT}</td>
        <td height="20">${li.EPD_NPRICE}</td>
        <td height="20">${li.EPD_NNUM}</td>
        <td height="20">${li.EPD_NTOTAL}</td>
        <td height="20">${li.EPD_SBRAND}</td>
        <td height="20">${li.EPD_SMODEL}</td>         
        <td height="20">${li.EPD_NPRICESONG}</td>         
         <td height="20">${li.EPD_NTOTALSONG}</td>         
         <td height="20">${li.EPD_SISIMPORT}</td>         
        <td height="20">${li.EPD_SISFREETAX}</td>         
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
		
		
		
</form>


</body>
</html>
  