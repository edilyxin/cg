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
function save(){
	document.form1.action="<%=path%>/contract!add?<%=urlparams%>";
		if(validator()){
		if(confirm("是否保存？")){
			document.form1.action="<%=path%>/contract!add?<%=urlparams%>";
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
												<td width="70px" height="40px">合同编号：</td>
												<td colspan="3"　width="100%"><input type=“text” style="width: 90%" value="${vo.CT_SNO}" /></textarea>
												</td>
											</tr>
											<tr>																							
												<td width="70px" heigth="40px">甲方：</td>
												<td heigth="40px"><input value="${vo.CT_SOWNER}" type="text" style="width: 70%;"/></td>
												<td width="70px" heigth="40px">乙方：</td>
												<td heigth="40px"><input value="${vo.CT_SPARTYB}" type="text" style="width: 70%;"/></td>
											</tr>											
											<tr>
												<td width="70px" heigth="40px">联系人：</td>
												<td heigth="40px"><input value="${vo.CT_SUNITMAN}" type="text" style="width: 70%;"/></td>
												<td width="70px" heigth="40px">联系人：</td>
												<td heigth="40px"><input value="${vo.CT_SUNITMANB}" type="text" style="width: 70%;"/></td>
											</tr>
											<tr>
												<td width="70px" heigth="40px">联系方式：</td>
												<td heigth="40px"><input value="${vo.CT_STELE}" type="text" style="width: 70%;"/></td>
												<td width="70px" heigth="40px">联系方式：</td>
												<td heigth="40px"><input value="${vo.CT_STELEB}" type="text" style="width: 70%;"/></td>
											</tr>
											<tr>											
												<td width="70px" heigth="40px">合同金额：</td>
												<td heigth="40px"><input value="${vo.CT_NMONEY}" type="text" style="width: 70%;"/></td>
												<td width="70px" heigth="40px">到货日期：</td>
												<td heigth="40px"><input  class="Wdate" type="text" style="width: 70%;"/></td>
											</tr>
											<tr>
												<td width="70px" heigth="40px">付款比例：</td>
												<td heigth="40px"><input value="${vo.CT_NPAYRATIO}" type="text" style="width: 70%;"/></td>
												<td width="70px" heigth="40px">收货人：</td>
												<td heigth="40px"><input value="${vo.CT_SGAINMAN}" type="text" style="width: 70%;"/></td>
											</tr>
											<tr>
												<td width="70px" heigth="40px">签订时间：</td>
												<td heigth="40px"><input  class="Wdate" value="<s:date format="yyyy-MM-dd" name="vo.CT_DTIME" />" type="text" style="width: 70%;"/></td>
												<td width="70px" heigth="40px">联系方式：</td>
												<td heigth="40px"><input value="${vo.CT_SGAINTELE}" type="text" style="width: 70%;"/></td>
											</tr>
											<tr>
												<td width="70px" height="40px">收货地址：</td>
												<td colspan="3"　width="100%"><textarea value="${vo.CT_SGAINADDR}" style="width: 100%;height: 80px"></textarea>
												</td>
											</tr>	
											<tr>
												<td width="70px" height="40px">合同內容：</td>
												<td colspan="3"　width="100%"><textarea value="${vo.CT_SCONTENT}" style="width: 100%;height: 80px" rows="4"></textarea>
												</td>
											</tr>																						
											<tr>
												<td width="70px" height="40px">备注：</td>
												<td colspan="3"　width="100%"><textarea value="${vo.CT_NCONTENT}" style="width: 100%;height: 80px" rows="4"></textarea>
												</td>
											</tr>
											<tr>
												<td width="70px" height="40px">test：</td>
												<td colspan="3"　width="100%"><input style="width: 100%;height: 80px" rows="4" />
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


		</div>

	</form>
</body>
</html>

<a href="<%=path%>/contract!add">保存合同信息</a>
<br />