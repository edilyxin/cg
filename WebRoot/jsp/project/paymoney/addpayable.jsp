<%@ page language="java" import="java.util.*" isELIgnored="false"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib uri="/WEB-INF/page.tld" prefix="page"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
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
<script>
function hidden(){
	
	if($("#payType").val() =="1"){
		
		$("#PM_NMONEY").val($("#htj").val());
	}
	if($("#payType").val() =="2"){
		$("#PM_SBILL").attr("readonly","readonly");
		$("#PM_NMONEY").val($("#lyj").val());
		$("#PM_SBILL").val("0000000");
	}
	if($("#payType").val() =="3"){
		
		$("#PM_NMONEY").val($("#bzj").val());
	}
	
	
	//$("#row1").hide();
	
}
function save(){
	document.form1.action="<%=path%>/paymoney!pay?<%=urlparams%>";
		if(validator()){
		if(confirm("是否保存？")){
			document.form1.action="<%=path%>/paymoney!pay?<%=urlparams%>";
			document.form1.submit();
			}
		}
		
		 
}		

function toResut(){
    document.all.form1.reset();
}

  //职称等级
<%--   $(document).ready(function(){
 	getDictSelect("","post_nlevel","post_nlevel","","0","<%=path%>
	");
	}); --%>
</script>
</head>
<body>
	<form name="form1" method="post">
		<div class="bigBox">
			<!--外部大DIV，可以调整宽度-->
			<h2>
				<span><s:property value="#session.navbar" /></span>
			</h2>
			<div class="content" id="divheight" style="overflow: auto;">

				<table width="100%" border="0" align="center" cellpadding="0"
					cellspacing="0">
					<tr>
						<td height="30">
							<table width="100%" border="0" cellspacing="0" cellpadding="0">
								<tr>
									<td height="24" bgcolor="#0E6BB1">
										<table width="100%" border="0" cellspacing="0" cellpadding="0">
											<tr>
												<td>
													<table width="100%" border="0" cellspacing="0"
														cellpadding="0">
														<tr>
															<td width="6%" height="19" valign="bottom"><div
																	align="center">
																	<img src="<%=path%>/images/tb.gif" width="14"
																		height="14" />
																</div></td>
															<td width="94%" valign="bottom"><span class="STYLE1">添加过程</span></td>
														</tr>
													</table>
												</td>
												<td><div align="right">
														<span class="STYLE1">&nbsp;</span><span class="STYLE1">
															&nbsp;</span>
													</div></td>
											</tr>
										</table>
									</td>
								</tr>
							</table>
						</td>
					</tr>
					<tr valign="top">
						<td>
							<table width="100%" border="0" cellpadding="0" cellspacing="1"
								bgcolor="#a8c7ce">
								<tr bgcolor="#FFFFFF">
									<td bgcolor="#FFFFFF" align="center">
										<table border="0" cellpadding="2" cellspacing="1"
											style="width: 50%; height: 100%; font-size: 12px; font-family: Verdana, Arial, Helvetica, sans-serif;"
											bgcolor="#E3E9EE">
											<tr>
											<td width="70px" heigth="40px">
												付款类型:
											</td>
											<td colspan="3">
												<select id="payType" onclick="hidden();">													
													<option value="1">合同款</option>
													<option value="2">履约金</option>
													<option value="3">保质金</option>
												</select>
												<input type="hidden" id="htj" value="合同款" />
												<input type="hidden" id="lyj" value="履约金" />
												<input type="hidden" id="bzj" value="保质金" />
											</td>
											</tr>											
											<tr>
												<td width="70px" heigth="40px">执行步骤：</td>
												<td heigth="40px"><span style="width: 70%;"></span></td>
												
												<td width="70px" heigth="40px">付款比例：</td>
												<td heigth="40px"><span style="width: 70%;"></span></td>												
											</tr>
											
											<tr id="row1">
												<td width="70px" heigth="40px">全部金额：</td>
												<td heigth="40px"><span style="width: 70%;"></span></td>
												<td width="70px" heigth="40px">已付金额：</td>
												<td heigth="40px"><span style="width: 70%;"></span></td>
											</tr>
											
											<tr>
												<td width="70px" heigth="40px">支付金额：</td>
												<td heigth="40px" width="200px"><input name="form.PM_NMONEY" id="PM_NMONEY" type="text" style="width: 70%;"/></td>
												<td width="70px" heigth="40px">发票号：</td>
												<td heigth="40px" width="200px">
													<input name="form.PM_SBILL" id="PM_SBILL" type="text" valid="required" errmsg="必填"  />
													<%-- <span style="color:red;">*</span> --%>
												</td>
											</tr>
											<tr>											
												<td width="70px" heigth="40px">付款时间：</td>
												<td heigth="40px"><input name="form.DTIME" type="text" style="width: 70%;"/></td>
												<td width="70px" heigth="40px">经办人：</td>
												<td heigth="40px"><input name="form.PM_SPERSON" type="text" style="width: 70%;" /></td>
											</tr>
											<tr>
												<td width="70px" height="40px">合同编号：</td>
												<td colspan="3"　width="100%"><textarea id="CT_SNO" name="form.CT_SNO" style="width: 100%;height: 80px" rows="4"></textarea>
											</td>																	
											<tr>
												<td width="70px" height="40px">备注：</td>
												<td colspan="3"　width="100%"><textarea name="form.PM_SREMARK" style="width: 100%;height: 80px" rows="4"></textarea>
											</td>
											</tr>
										</table>
								</td>
								</tr>
							</table>
							<table width="100%" border="0" cellspacing="0" cellpadding="0">
								<tr>
									<td colspan="5" nowrap>
										<div align="center">
											<input type="button" value="保存" class="button"
												onclick="save();" />&nbsp; <input type="button" value="重置"
												class="button" onclick="resetDiv();" />&nbsp; <input
												type="button" value="返回" class="button"
												onclick="window.history.go(-1);" />
										</div>
									</td>
								</tr>
							</table>
						</td>
					</tr>
				</table>
			</div>

<div style="color:red">
    <s:fielderror />
</div >
		</div>
		
		
	</form>
</body>
</html>
<br />

	<a href="<%=path%>/paymoney!pay">付款</a><br />
	<a href="<%=path%>/process!find">返回</a><br />