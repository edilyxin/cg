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
<title>录入中标结果</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script> 
function save(){
	document.form1.action="<%=path%>/bidwin!add?<%=urlparams%>";
		if(validator()){
		if(confirm("是否保存？")){
			document.form1.action="<%=path%>/bidwin!add?<%=urlparams%>";
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
												<td width="70px" heigth="40px">中标单位：
												<input name="form.EBW_NID" value="${vo.EBW_NID}" type=hidden />
												</td>
												<td><input name="form.AG_NID" value="${vo.AG_NID}" type=text width="98%" /></td>
											</tr>
											<tr>
												<td width="70px" heigth="40px">中标时间：</td>
												<td><input name="form.EBW_TTIME" value="${vo.EBW_TTIME}" type=text style="width: 120px" onfocus="WdatePicker({maxDate:'%y-%M-{%d}'})"  class="Wdate" /></td>
											</tr>
											<tr>
												<td width="70px" heigth="40px">中标金额：</td>
												<td><input name="form.EBW_NMONEY" value="${vo.EBW_NMONEY}" type=text style="width: 95%" /></td>
											</tr>
											<tr>
												<td width="70px" heigth="40px">联系人：</td>
												<td><input name="form.EBW_SMAN" value="${vo.EBW_SMAN}" type=text style="width: 95%" /></td>
											</tr>
											<tr>
												<td width="70px" heigth="40px">联系电话：</td>
												<td><input name="form.EBW_STELE" value="${vo.EBW_STELE}" type=text style="width: 95%" /></td>
											</tr>
											<tr>
												<td width="70px" heigth="40px">邮箱：</td>
												<td><input name="form.EBW_SMAIL" value="${vo.EBW_SMAIL}" type=text style="width: 95%" /></td>
											</tr>
											<tr>
												<td width="70px" heigth="40px">公示标题：</td>
												<td><input name="form.EBW_STITLE" value="${vo.EBW_STITLE}" type=text style="width: 95%" /></td>
											</tr>
											<tr>
												<td width="70px" heigth="40px">公示内容：</td>
												<td><textarea value="${vo.EBW_SCONTENT}" type="" style="width: 95%" rows="4" name="form.EBW_SCONTENT"></textarea></td>
											</tr>
											<tr>
												<td width="70px" heigth="40px">公示时间：</td>
												<td><input type=text name="form.EBW_TBEGIN" value="<s:date format="yyyy-MM-dd" name="vo.EBW_TBEGIN"/>" onfocus="WdatePicker({maxDate:'%y-%M-{%d}'})"  class="Wdate" />&nbsp;&nbsp;至&nbsp;&nbsp;<input
													type=text name="form.EBW_TEND" value="<s:date format="yyyy-MM-dd" name="vo.EBW_TEND"/>" onfocus="WdatePicker({maxDate:'%y-%M-{%d}'})"  class="Wdate" /></td>
											</tr>
											<tr>
												<td width="70px" heigth="40px">附件：</td>
												<td><input name="form.EBW_SFILENAME" value="${vo.EBW_SFILENAME}" type=file style="width: 95%" /></td>
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
		<div id="divwidth" style="overflow: auto; overflow-y: hidden;">
								<table width="1500px" id="table1" class="table" border="0"
									cellpadding="0" cellspacing="1" bgcolor="#a8c7ce">
									<tr bgcolor="#CBE0FF">
										<th width="40px" height="24" class="STYLE6"><div
												align="center">
												<span class="STYLE10">序号</span>
											</div></th>
										<th width="80px" height="24" class="STYLE6"><div
												align="center">
												<span class="STYLE10">包名称</span>
											</div></th>
										<th width="80px" height="24" class="STYLE6"><div
												align="center">
												<span class="STYLE10">分包明细</span>
											</div></th>
										<th width="40px" height="24" class="STYLE6"><div
												align="center">
												<span class="STYLE10">单位 </span>
											</div></th>
										<th width="80px" height="24" class="STYLE6"><div
												align="center">
												<span class="STYLE10">审定单价</span>
											</div></th>
										<th width="40px" height="24" class="STYLE6"><div
												align="center">
												<span class="STYLE10">审定数量</span>
											</div></th>
										<th width="80px" height="24" class="STYLE6"><div
												align="center">
												<span class="STYLE10">审定总金额</span>
											</div></th>
										<th width="80px" height="24" class="STYLE6"><div
												align="center">
												<span class="STYLE10">是否进口</span>
											</div></th>
										<th width="80px" height="24" class="STYLE6"><div
												align="center">
												<span class="STYLE10">是否免税</span>
											</div></th>
										<th width="80px" height="24" class="STYLE6"><div
												align="center">
												<span class="STYLE10">技术参数</span>
											</div></th>
										<th width="80px" height="24" class="STYLE6"><div
												align="center">
												<span class="STYLE10">免税申请表</span>
											</div></th>
									</tr>

									<tr>
										<td>1</td>
										<td rowspan="2">是了的空间发了</td>
										<td>阿勒快减肥啦</td>
										<td>个</td>
										<td>10.00</td>
										<td>100</td>
										<td>1000.00</td>
										<td>是</td>
										<td>否</td>
										<td><a href="#" onclick="showParams('1')">查看</a>&nbsp; <a>打印</a><input
											name="hid1" type="hidden" value="1111" /></td>
										<td>查看</td>
									</tr>
									<tr>
										<td>1</td>
										<td>阿勒快减肥啦</td>
										<td>个</td>
										<td>10.00</td>
										<td>100</td>
										<td>1000.00</td>
										<td>是</td>
										<td>否</td>
										<td>查看</td>
										<td>查看</td>
									</tr>
								</table>
							</div>
							</div>
							<div align="center">
								<!-- 分页标签BEGIN -->
								<s:if test="list.size()!=0">
									<page:page uri="/post!find"></page:page>
								</s:if>
								<s:elseif test="list.size()==0">
									<div align="center">
										<span style="color: red; font-size: 14px;"><strong>抱歉，未查询到符合条件的信！</strong></span>
									</div>
								</s:elseif>

								<!-- 分页标签END -->
							</div>
	</form>
</body>
</html>

<a href="<%=path%>/bitwin!publish">录入中标结构（推送至网站）</a>
<br />
