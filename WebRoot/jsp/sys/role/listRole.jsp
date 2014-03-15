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
    <title>角色管理</title>
	<script>

function toUser(){
		common("<%=path %>/role!getUserByRole");
}



function find(){
input_trim();
	$(".form1").submit();
}
//显示排序后选择框项
	$(function() {
		var searchA = $("#searchAValue").val();
		$("#searchA option").each(function(){
			if ($(this).val() == searchA) {
				$(this).attr("selected", true);
			}
		});	
	});
	//更新
	function toUpdate(){
		common("<%=path%>/role!toUpdate");
	}
	//删除
	function del(){
		var checkedObj = $(".Off:checked");
		var v = checkedObj.length == 1;
		if (!v) {
			alert("您只能选一项进行删除 ");
			return ;//false;
		} else {
			if(confirm("是否确认删除?")==true){
			document.form1.action="<%=path%>/role!toDelete";
			document.form1.submit();
			}
		}
		
	}
	//系统权限分配：只有公共角色才能有此操作
	function toSYSFunction(){
		var checkedObj = $(".Off");
		var sysint_sno = document.getElementsByName("sysint_sno");
		if($(".Off:checked").length!=1){
				alert("您只能选一项进行修改 ");
				return;
		}
		checkedObj.each(function(i){
			if(this.checked){
				if(sysint_sno[i].value==null||sysint_sno[i].value==""){
					var isCheck = $(".Off:checked").val();
					location =  "<%=path %>/role!toFunction?checkedId=" + isCheck;
				}else{
					alert("只有公共角色才能进行此操作");
				}
			}
			
		});
		
	
		
	}
	//角色权限分配：只有系统角色才能有此操作
	function toFunction(){
	var checkedObj = $(".Off");
		var sysint_sno = document.getElementsByName("sysint_sno");
		if($(".Off:checked").length!=1){
				alert("您只能选一项进行修改 ");
				return;
		}
		checkedObj.each(function(i){
			if(this.checked){
				if(sysint_sno[i].value!=null||sysint_sno[i].value!=""){
					var isCheck = $(".Off:checked").val();
					location = "<%=path %>/role!toFunction?checkedId=" + isCheck;
				}else{
					alert("只有系统角色才能进行此操作");
				}
			}
			
		});
	}
	function checkRole(){
		common("<%=path %>/role!tocheckRole");
	}
	//共用方法
	function common(vu) {
		var checkedObj = $(".Off:checked");
		
		var v = checkedObj.length == 1;
		
		if (!v) {
			alert("您只能选一项进行修改 ");
			return ;//false;
		} else {
			var isCheck = checkedObj.val();
			location = vu + "?checkedId=" + isCheck;
		}
	}
	//操作权限
	function toRole(){
	common("<%=path %>/role!toOper");
	}
	//数据权限
	function toDB(){
	common("<%=path %>/role!todbOper");
	}
 
 
</script>
	
  </head>
  
  <body>
<form name="form1" class="form1" method="post" action="<%=path %>/role!find">
<div class="bigBox" id="idwidth">
		<!--外部大DIV，可以调整宽度-->
		<h2>
			<span><s:property value="#session.navbar"/></span>
		</h2>
		<div class="content">
			<table width="100%" border="0" cellpadding="0" cellspacing="0">
				<tr bgcolor="#D5EAFB" >
					<td height="30" align="left" colspan="2">
                	<span  style="white-space:nowrap;">&nbsp;&nbsp;角色类型:
                		
							<select name="form.searchA" id="searchA">
						    	<option value=""></option>
						    	<option value="0">公共角色</option>
						    	<option value="1">系统角色</option>
						    </select></span>
				<span  style="white-space:nowrap;">&nbsp;&nbsp;角色编号:<input type="text" name="form.searchB" value="${form.searchB}" /></span>
				<span  style="white-space:nowrap;">&nbsp;&nbsp;角色名称:<input type="text" name="form.searchC" value="${form.searchC}" />
                </span>
                <span  style="white-space:nowrap;">&nbsp;&nbsp;
                <a href="javascript:void(0);"  onclick="find()"><img src="<%=path%>/images/zoom.png" width="15" height="15" border="0"/> 查询</a></span>
                
			 </td>
				 	
				  </tr>
				<tr bgcolor="#0E6BB1">
				<td height="30" ><table width="100%" border="0" cellspacing="0" cellpadding="0">
              <tr>
                <td width="20" height="19" valign="bottom"><div align="center"><img src="<%=path%>/images/tb.gif" width="14" height="14" /></div></td>
                <td   valign="bottom"><span class="STYLE1" style="white-space:nowrap;">角色信息列表</span></td>
              </tr>
            </table></td>
					<td align="right" >
					<span class="STYLE1" style="white-space:nowrap;">
            <s:if test="#session.operList.get(\"010601\")!=null">
						<a title="新增" href="<%=path %>/role!toAdd" >
							<img src="<%=path%>/<s:property value="#session.operList.get(\"010601\").oper_simg"/>" width="10" height="10" border="0"/> 
							<span class="STYLE1"><s:property value="#session.operList.get(\"010601\").oper_sname"/></span>
						</a> 
			</s:if>
			<s:if test="#session.operList.get(\"010602\")!=null">
				<a title="修改" href="#" onclick="toUpdate();" ><img src="<%=path%>/<s:property value="#session.operList.get(\"010602\").oper_simg"/>" width="10" height="10" border="0"/> 
				<span class="STYLE1"><s:property value="#session.operList.get(\"010602\").oper_sname"/></span></a>
			</s:if>
			<s:if test="#session.operList.get(\"010603\")!=null">	
				<a title="删除" href="#" onclick="del();" ><img src="<%=path%>/<s:property value="#session.operList.get(\"010603\").oper_simg"/>" width="10" height="10" border="0"/>
				 <span class="STYLE1"><s:property value="#session.operList.get(\"010603\").oper_sname"/></span></a>
			</s:if>
			<s:if test="#session.operList.get(\"010604\")!=null">
				<a title="公共权限分配" href="#" onclick="toSYSFunction();" ><img src="<%=path%>/<s:property value="#session.operList.get(\"010604\").oper_simg"/>" width="10" height="10" border="0"/> 
				<span class="STYLE1"><s:property value="#session.operList.get(\"010604\").oper_sname"/></span></a>
			</s:if>	
			<s:if test="#session.operList.get(\"010605\")!=null">
				<a title="系统权限分配" href="#" onclick="toFunction();" ><img src="<%=path%>/<s:property value="#session.operList.get(\"010605\").oper_simg"/>" width="10" height="10" border="0"/> 
				<span class="STYLE1"><s:property value="#session.operList.get(\"010605\").oper_sname"/></span></a>
			</s:if>	
			</span> <span class="STYLE1" style="white-space:nowrap;">
			<s:if test="#session.operList.get(\"010606\")!=null">
				<a title="操作权限分配" href="#" onclick="toRole();" ><img src="<%=path%>/<s:property value="#session.operList.get(\"010606\").oper_simg"/>" width="10" height="10" border="0"/> 
				<span class="STYLE1"><s:property value="#session.operList.get(\"010606\").oper_sname"/></span></a>
			</s:if>	
			<s:if test="#session.operList.get(\"010607\")!=null">
				<a title="数据权限分配" href="#" onclick="toDB();" ><img src="<%=path%>/<s:property value="#session.operList.get(\"010607\").oper_simg"/>" width="10" height="10" border="0"/> 
				<span class="STYLE1"><s:property value="#session.operList.get(\"010607\").oper_sname"/></span></a>
			</s:if>
			<s:if test="#session.operList.get(\"010608\")!=null">
				<a title="权限查看" href="#" onclick="checkRole();" ><img src="<%=path%>/<s:property value="#session.operList.get(\"010608\").oper_simg"/>" width="10" height="10" border="0"/> 
				<span class="STYLE1"><s:property value="#session.operList.get(\"010608\").oper_sname"/></span></a>
			</s:if>
			<s:if test="#session.operList.get(\"010609\")!=null">	
				<a title="角色用户查看" href="#" onclick="toUser();" ><img src="<%=path%>/<s:property value="#session.operList.get(\"010609\").oper_simg"/>" width="10" height="10" border="0"/>
				 <span class="STYLE1"><s:property value="#session.operList.get(\"010609\").oper_sname"/></span></a>
			</s:if>
			<s:if test="#session.operList.get(\"010610\")!=null">	
				<a title="下载模板" href="javascript:void(0);" onclick="downloadTemp('mng_role');" ><img src="<%=path %>/<s:property value="#session.operList.get(\"010610\").oper_simg"/>" width="10" height="10" border="0"/> 
				<span class="STYLE1"><s:property value="#session.operList.get(\"010610\").oper_sname"/></span></a>
			</s:if>
			<s:if test="#session.operList.get(\"010611\")!=null">	
				<a title="角色导入" href="#" onclick="findRight();" ><img src="<%=path%>/<s:property value="#session.operList.get(\"010611\").oper_simg"/>" width="10" height="10" border="0"/>
				 <span class="STYLE1"><s:property value="#session.operList.get(\"010611\").oper_sname"/></span></a>
			</s:if>
			</span>	
			</td>
					</tr>
			</table>
    <div id="divwidth"  style="overflow:auto;overflow-y:hidden;"> 
   	<table width="700"  id="table1"  class="table"   border="0" cellpadding="0" cellspacing="1" bgcolor="#a8c7ce">
     <tr bgcolor="#CBE0FF">
        <th width="40px" height="24"  class="STYLE10">
        <div align="center">
          <input type="checkbox" name="checkbox" id="checkbox" onclick="checkAll(this);"  />
        </div></th>
        <th width="40px" height="20"  class="STYLE6"><div align="center"><span class="STYLE10">序号</span></div></th>
        <th width="100px" height="20"  class="STYLE6"><div align="center"><span class="STYLE10">角色类型</span></div></th>
        <th width="80px" height="20"  class="STYLE6"><div align="center"><span class="STYLE10">角色编号</span></div></th>
        <th width="100px" height="20"  class="STYLE6"><div align="center"><span class="STYLE10">角色名称</span></div></th>
        <th   height="20"  class="STYLE6"><div align="center"><span class="STYLE10">角色描述</span></div></th>
        <th width="100px" height="20"  class="STYLE6"><div align="center"><span class="STYLE10">系统名称</span></div></th>
        <th width="100px" height="20"  class="STYLE6"><div align="center"><span class="STYLE10">是否缺省角色</span></div></th>
      </tr>
      <s:iterator value="list" var="v" status="s"> 
      	<tr bgcolor="FFFFFF"  >
        <td height="20" ><div align="center">
          <input type="checkbox" name="idcheckbox" class="Off" onclick="checkOne();" value="${v.role_sno}"   />
          <input type="hidden" id="sysint_sno" name="sysint_sno" value="${v.sysint_sno}"   />
        </div></td>
        <td  height="20" ><div align="center"><span class="STYLE10">${s.index+1}</span></div></td>
        <td  height="20" title="<s:if test="#v.role_stype==0">公共角色</s:if><s:else>系统角色</s:else>"><div align="center"><span class="STYLE10">
        <s:if test="#v.role_stype==0">公共角色</s:if><s:else>系统角色</s:else></span></div></td>
        <td  height="20" title="${v.role_sno}"><div align="center"><span class="STYLE10">${v.role_sno}</span></div></td>
        <td  height="20" title="${v.role_sname}"><div align="center"><span class="STYLE10">${v.role_sname}</span></div></td>
        <td  height="20" title="${v.role_sdesc}"><div align="center"><span class="STYLE10">${v.role_sdesc}</span></div></td>
        <td height="20" title="<s:if test="#v.sysint_sno==null">公共角色</s:if><s:else>${v.sysint_sname}</s:else>"><div align="center"><span class="STYLE10">
        <s:if test="#v.sysint_sno==null">公共角色</s:if><s:else>${v.sysint_sname}</s:else></span></div></td>
        <td  height="20" title="<s:if test="#v.role_sisdefault==0">是</s:if><s:else>否</s:else>"><div align="center"><span class="STYLE10">
        <s:if test="#v.role_sisdefault==0">是</s:if><s:else>否</s:else></span></div></td>
      </tr>
      </s:iterator>
   </table>
			</div>
  		</div>
		<div align="center">
<!-- 分页标签BEGIN -->
						<s:if test="list.size()!=0">
							<page:page uri="/role!find"></page:page>
						</s:if>
						<s:elseif test="list.size()==0">
							<div align="center"><span style="color: red; font-size: 14px;"><strong>抱歉，未查询到符合条件的信息！</strong></span></div>
						</s:elseif>
		 
<!-- 分页标签END -->
   		</div>
		</div>
		<input type="hidden" id="first" value=""/>
 <input type="hidden" value="${form.searchA}" id="searchAValue"/>
</form>
</body>
</html>
