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
%>
<jsp:include page="/common/util.jsp" />
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<title>招标公式</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script> 
function save(){
	document.form1.action="<%=path%>/mail!sendMail";
		//if(validator()){
	//	if(confirm("是否保存？")){
		//	document.form1.action="<%=path%>/mail!sendMail";
			//document.form1.submit();
			//}
		//}	
		
		 
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
															<td width="94%" valign="bottom"><span class="STYLE1">招标公示</span></td>
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
												<td width="70px" heigth="40px">执行步骤：</td>
												<td><input type=text width="98%" /></td>
											</tr>
											<tr>
												<td width="70px" heigth="40px">发件人：</td>
												<td><input type=text style=width:95% /></td>
											</tr>
											<tr>
												<td width="70px" heigth="40px">发件密码：</td>
												<td><input type=text style=width:95% /></td>
											</tr>
											<tr>
												<td width="70px" heigth="40px">主题：</td>
												<td><input type=text style=width:95% /></td>
											</tr>
											<tr>
												<td width="70px" heigth="40px">内容：</td>
												<td><textarea type="" style=width:95% rows="4"></textarea></td>
											</tr>
											<tr>
												<td width="70px" heigth="40px">附件：</td>
												<td><input type=text style=width:95% /></td>
											</tr>
											<tr>
												<td width="70px" heigth="40px">模板：</td>
												<td><input type=text style=width:95% /></td>
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
<br />