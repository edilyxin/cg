<%@ page language="java" isELIgnored="false" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib uri="/WEB-INF/page.tld" prefix="page"%>
<% 
	String path = request.getContextPath();
%>
<jsp:include page="/common/util.jsp"/>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript">
function find()
{							
	document.frm.action="<%=path%>/house!find";
	document.frm.submit();
}

function toUpdate()
{
	var check = $(".check:checked");
	if (check.length == 0) {
		alert("请选择记录！");
		return
	} else if (check.length != 1) {
		alert("请选择一条记录，不要多选！");
		return;
	}
	document.frm.action="<%=path%>/house!toUpdate";
	document.frm.submit();
}

function del(){
	var check = $(".check:checked");
	if (check.length == 0) {
		alert("请选择记录！");
		return
	}
	var arrNO = "";
	var ext = ":";
	for (var i = 0; i < check.length; i++) {
		var hs_sno = check[i].value;
		if (i == (check.length - 1)) {
			ext = "";
		}
		arrNO = arrNO + hs_sno + ext;
	}
 	 if (arrNO != "") {
 		if(confirm("是否删除？"))
		 {
	         $.post("<%=path%>/house!del",
	        		 {"arrNO": arrNO},
	        		 function(data){
	        			 if (data != "") {
	        				 alert(data);
	        			 }
	        			 window.location.reload();
	        		 },"json");
	     }
 	 }
}
</script>
</head>
<body>
	<form name="frm" action="<%=path%>/house!find" method="post">
		<div class="bigBox" id="idwidth" >
			<h2>
				<span>系统管理 &gt; 楼栋信息管理</span>
			</h2>
			<div class="content">
				<table width="100%" border="0" cellpadding="0" cellspacing="0">
					<tr>
						<td height="30" align="left"  >
						<span style="white-space:nowrap;">&nbsp;&nbsp;楼栋编号： <input type="text" name="houseForm.searchA" value="${houseForm.searchA}" size="12"/></span>
						<span style="white-space:nowrap;">&nbsp;&nbsp;楼栋名称： <input type="text" name="houseForm.searchB" value="${houseForm.searchB}"  size="12"/></span>
						<span style="white-space:nowrap;">&nbsp;&nbsp;楼栋简称： <input type="text" name="houseForm.searchC" value="${houseForm.searchC}"  size="12"/></span>
						<span style="white-space:nowrap;">&nbsp;&nbsp;<a href="javascript:void(0);" onclick="find();" ><img src="<%=path %>/image/zoom.png" align="middle" border="0" width="15" height="15"/>查询</a></span>
						</td>
					</tr>
					<tr bgcolor="#A5D2FC">
						<td height="30"   align="left"     >
							<span style="white-space:nowrap;vertical-align:middle;">
								<a href="<%=path%>/house!addHouse"   ><img src="<%=path %>/image/add.png"   border="0"  align="middle"/>新增</a>
								<a href="javascript:void(0)" onclick="toUpdate();"><img src="<%=path %>/image/update.png"   border="0" align="middle"/>修改</a>
								<a href="javascript:void(0)" onclick="del();"><img src="<%=path %>/image/delete.png"   border="0" align="middle"/>删除</a></span>
						</td>
					</tr>
				</table>
				<div id="divwidth" style="overflow:auto;overflow-y:hidden;">
				<table width="2100" id="table1"  class="table" bgcolor="#95B0B9" border="0" cellpadding="1" cellspacing="1">
					<tr bgcolor="#CBE0FF">
						<th width="40" height="24"  ><input type="checkbox" id="chkall"   /></th>
						<th width="40">序号</th>
						<th width="100">校区名</th>
						<th width="100">楼栋编号</th>
						<th width="100">楼栋名称</th>
						<th width="100">楼栋简称</th>
						<th width="60">单元数</th>
						<th width="80">地上层数</th>
						<th width="80">地下层数</th>
						<th width="100">建筑面积(㎡)</th>
						<th width="100">占地面积(㎡)</th>
						<th width="100">使用面积(㎡)</th> 
						<th width="100">总造价数（元）</th>
						<th  >用途</th>
						<th width="40">状态</th>
						<th width="80">抗震级别</th>
						<th width="80">人防级别</th>
						<th width="80">竣工日期</th>
						<th width="80">房屋结构</th>
						<th width="80">房间结构</th>
						<th width="80">产权类型</th>
						<th width="80">使用类型</th>
						<th width="80">朝向</th>
						<th width="80">楼栋结构</th>
					</tr>
					<s:iterator value="houseList" var="house" status="st">
					<tr bgcolor="#FFFFFF">
						<td height="24"  >
						<input type="checkbox" name="houseForm.hs_sno" id="btnChk" class="check" value="${house.hs_sno}"  /></td>
						<td><s:property value="(#st.index + 1)" /></td>
						<td title="${house.sh_sname}">${house.sh_sname}</td>
						<td title="${house.hs_sno}">${house.hs_sno}</td>
						<td title="${house.hs_sname}">${house.hs_sname}</td>
						<td title="${house.hs_ssname}">${house.hs_ssname}</td>
						<td title="${house.hs_nunit}">${house.hs_nunit}</td>
						<td title="${house.hs_nulayer}">${house.hs_nulayer}</td>
						<td title="${house.hs_ndlayer}">${house.hs_ndlayer}</td>
						<td title="${house.hs_njzarea}">${house.hs_njzarea}</td>
						<td title="${house.hs_nzdarea}">${house.hs_nzdarea}</td>
						<td title="${house.hs_nsyarea}">${house.hs_nsyarea}</td> 
						<td title="${house.hs_nbuildnum}">${house.hs_nbuildnum}</td>
						<td title="${house.hs_susetype}">${house.hs_susetype}</td>
						<td title="${house.hs_sstat}">${house.hs_sstat}</td>
						<td title="${house.hs_skznum}">${house.hs_skznum}</td>
						<td title="${house.hs_srflevel}">${house.hs_srflevel}</td>
						<td title="<s:date name="#house.hs_dwdate" format="yyyy-MM-dd"/>"><s:date name="#house.hs_dwdate" format="yyyy-MM-dd"/></td>
						<td title="${house.hs_stype}">${house.hs_stype}</td>
						<td title="${house.hs_sroomcr}">${house.hs_sroomcr}</td>
						<td title="${house.hs_sfctype}">${house.hs_sfctype}</td>
						<td title="${house.hs_susetype}">${house.hs_susetype}</td>
						<td title="${house.hs_scx}">${house.hs_scx}</td>
						<td title="${house.hs_scr}">${house.hs_scr}</td>
					</tr>
					</s:iterator>
				</table>
				</div>
		</div>
		<div align="center">
	 					<s:if test="houseList.size()!=0">
							<page:page uri="/house!find"></page:page>
						</s:if>
						<s:elseif test="houseList.size()==0">
							<div align="center"><span style="color: red; font-size: 14px;"><strong>抱歉，未查询到符合条件的信息！</strong></span></div>
						</s:elseif>
   		</div>
		</div>
</form>
</body>
</html>