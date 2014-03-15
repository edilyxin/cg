 <%@ page language="java" import="java.util.*" isELIgnored="false" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib uri="/WEB-INF/page.tld" prefix="page"%>
<% 
	String path = request.getContextPath();
%>
<jsp:include page="/common/util.jsp"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="<%=path %>/css/skin.css" rel="stylesheet" type="text/css" />
<script type="text/javascript">
function find()
{							
	document.frm.action="<%=path%>/house!find";
	document.frm.submit();
}
function save(type)
{
	if(validator(document.form1)){
		document.getElementById("saveType").value = type;
		var str = "";
		if (type == 1) {
			str = "是否保存?";
		} else if (type == 2) {
			str = "是否保存,到楼盘表页面?";
		}
		if(confirm(str)){
		document.form1.action="<%=path%>/house!addRoom";
		document.form1.submit();
		}
	}
}
	
function secBoard(n)
{
	for(i=0;i<secTable.cells.length;i++)
		secTable.cells[i].className="sec1";
		secTable.cells[n].className="sec2";
	for(i=0;i<mainTable.tBodies.length;i++)
		mainTable.tBodies[i].style.display="none";
		mainTable.tBodies[n].style.display="block";
}
</script>
</head>
<body  >
	<form name="form1" action="<%=path%>/house!find" method="post">
		<div class="bigBox" id="idwidth">
			<h2>
				<span>系统管理 &gt; 楼栋信息管理 &gt; 新增楼栋 &gt; 新增单元 &gt;新增楼层</span>
			</h2>
			<div class="content">
				<table width="100%" border="0" cellpadding="0" cellspacing="0"> 
		<tr>
			<td align="right" nowrap>楼栋编号：</td>
			<td align="left"  nowrap><s:property value="houseForm.hs_sno"/>
			<input type="hidden" name="houseForm.hs_sno"  value="${houseForm.hs_sno}"/></td>
			<td align="right" nowrap>所属校区：</td>
			<td align="left"  nowrap><s:property value="houseForm.sh_sname"/>
			<input type="hidden" name="houseForm.sh_sname"  value="${houseForm.sh_sname}"/></td>
  			<td align="right" nowrap>所属单位：</td>
			<td align="left" nowrap><s:property value="houseForm.comp_sname"/>
				 <input type="hidden" name="houseForm.comp_sname"  value="${houseForm.comp_sname}"/>
			</td>
		</tr>
		<tr>
			<td align="right" nowrap>楼栋名称：</td>
			<td align="left" nowrap><s:property value="houseForm.hs_sname"/>
			<input type="hidden" name="houseForm.hs_sname"  value="${houseForm.hs_sname}"/></td>
      		<td align="right" nowrap>楼栋简称：</td>
		  	<td align="left" nowrap><s:property value="houseForm.hs_ssname"/>
		  	<input type="hidden" name="houseForm.hs_ssname"  value="${houseForm.hs_ssname}"/></td>
		  	<td align="right" nowrap>楼栋单元数：</td>
		  	<td align="left" nowrap><s:property value="houseForm.hs_nunit"/>
		  	<input type="hidden" name="houseForm.hs_nunit"  value="${houseForm.hs_nunit}"/></td>
		</tr>
		<tr>
			<td align="right" nowrap>楼栋总房间数：</td>
			<td align="left" nowrap><s:property value="houseForm.hs_nroomnum"/>
			<input type="hidden" name="houseForm.hs_nroomnum"  value="${houseForm.hs_nroomnum}"/></td>
      		<td align="right" nowrap>楼栋地上层数：</td>
		  	<td align="left" nowrap><s:property value="houseForm.hs_nulayer"/>
		  	<input type="hidden" name="houseForm.hs_nulayer"  value="${houseForm.hs_nulayer}"/></td>
		  	<td align="right" nowrap>楼栋地下层数：</td>
		  	<td align="left" nowrap><s:property value="houseForm.hs_ndlayer"/>
		  	<input type="hidden" name="houseForm.hs_ndlayer"  value="${houseForm.hs_ndlayer}"/></td>
		</tr>
		 
				</table>
				
 
				
				<!--<table width="100%" border="0" cellpadding="0" cellspacing="0" id=secTable> 
						<tr>
							<s:iterator value="#request.huList" var="hu" status="st">
								<td align="center"  class=<s:if test="#st.index==0">sec2</s:if><s:if test="#st.index!=0">sec1</s:if> onclick="secBoard(<s:property value="#st.index"/>)">
								${hu.hu_sname}
								</td>
							</s:iterator>
					</tr>
				</table>
				-->
				<table width="100%" border="0" cellpadding="0" cellspacing="0" id=secTable> 																	
					<s:iterator value="#request.houselayerList" var="hl" status="st">												
							 <s:if test="#st.index % 7 == 0">         
						       	 <tr>          
						     </s:if>      
			                <td align="center" width="10%" class=<s:if test="#st.index==0">sec2</s:if><s:if test="#st.index!=0">sec1</s:if> onclick="secBoard(<s:property value="#st.index"/>)">
								${hl.hl_sdef5}								
								${hl.hl_sname}
							</td>        
	                          <s:if test="#st.index % 7 == 6">   
	                              </tr>        
                              </s:if>
					
							<!--<td align="center" width="10%" class=<s:if test="#st.index==0">sec2</s:if><s:if test="#st.index!=0">sec1</s:if> onclick="secBoard(<s:property value="#st.index"/>)">
								${hl.hl_sdef5}								
								${hl.hl_sname}
							</td>															
							-->	
																	
					</s:iterator>
				   </table>
				
				
				
				
				 <table class=main_tab id="mainTable"  width=100%      bgcolor="#95B0B9" border="0" cellpadding="1" cellspacing="1" >
				<s:iterator value="#request.houselayerList" var="hl" status="st">
				<TBODY style=" display:<s:if test="#st.index==0">block</s:if><s:if test="#st.index!=0">none</s:if>"   >
					<tr bgcolor="#CBE0FF">
						<!--<th  >单元号</th>
						<th  >楼层号</th>
						--><th width="70" align="left" >房间号</th>					
						<th width="90" align="left">房间名称</th>
						<th width="90" align="left" >房间简称</th>
						<th width="80" align="left">房间门数</th>
						<th width="100" align="left">使用面积</th>
						<th width="100" align="left">建筑面积</th>
						<!--<th width="100" >房间类型(教育部)</th>
						<th width="100">房间类型(学校)</th>
						-->
						<th width="95" >房间朝向</th>
						<th width="100" >房间状态</th>	
											
					</tr>
					<s:iterator value="#request.roomList" var="rm" status="st" >
					<s:if test="#rm.hl_scode==#hl.hl_scode and #rm.hu_scode==#hl.hu_scode">
					<tr bgcolor="#FFFFFF" align="center">						
						<td width="70"><input style="width:90%"  type="text" name="houseForm.rm_scode" value="${rm.rm_scode}">
						<input  type="hidden" name="houseForm.rm_sno" value="${rm.rm_sno}">
						<input  type="hidden" name="houseForm.hu_scode" value="${rm.hu_scode}">
						<input type="hidden" name="houseForm.hl_scode" value="${rm.hl_scode}">
						</td>
						<td width="90"><input style="width:90%" type="text" name="houseForm.rm_sname" value="${rm.rm_sname}"></td>
						<td width="90"><input style="width:90%" type="text" name="houseForm.rm_ssname" value="${rm.rm_ssname}"></td>
						<td width="80"><input style="width:90%" type="text" name="houseForm.rm_nmennum" value="${rm.rm_nmennum}"></td>
						<td width="100"><input style="width:95%" type="text" name="houseForm.rm_nsyarea" value="${rm.rm_nsyarea}"></td>
						<td width="100"><input style="width:95%" type="text" name="houseForm.rm_njzarea" value="${rm.rm_njzarea}"></td>		
						
						<!--<td width="100">
						<input style="width:95%" type="text" name="form.rt_sno" value="${rm.rt_sno}">
						
						<input style="width:80%" type="text" id="rt_sname"    value="" readonly="readonly"/>
           			    <input type="button" class="select_button" onclick="roomTypeTree('rt_sno','rt_sname','rt_ssname','0');" />
           				<input type="hidden" id="rt_sno"   name="form.rt_sno"  value=""/>
						</td>
																			
						-->
						<td width="95">
						<!--<input type="text" name="form.rm_scx" value="${rm.rm_scx}">
						--><select name="houseForm.rm_scx">
								<option value="" ></option>
								<option value="东" <s:if test="#rm.rm_scx==\"东\"">selected</s:if>>东</option>
								<option value="东南" <s:if test="#rm.rm_scx==\"东南\"">selected</s:if>>东南</option>
								<option value="南" <s:if test="#rm.rm_scx==\"南\"">selected</s:if>>南</option>
								<option value="西南" <s:if test="#rm.rm_scx==\"西南\"">selected</s:if>>西南</option>
								<option value="西" <s:if test="#rm.rm_scx==\"西\"">selected</s:if>>西</option>
								<option value="西北" <s:if test="#rm.rm_scx==\"西北\"">selected</s:if>>西北</option>
								<option value="北" <s:if test="#rm.rm_scx==\"北\"">selected</s:if>>北</option>
								<option value="东北" <s:if test="#rm.rm_scx==\"东北\"">selected</s:if>>东北</option>
							</select>
						</td>	
						<td width="100">
						<select name="houseForm.rm_sstate">
								<option value="" ></option>
								<option value="0" <s:if test="#rm.rm_sstate==\"0\"">selected</s:if>>未分配</option>
								<option value="1" <s:if test="#rm.rm_sstate==\"1\"">selected</s:if>>在用</option>
								<option value="2" <s:if test="#rm.rm_sstate==\"2\"">selected</s:if>>空房</option>								
							</select>
						</td>	
						
					</tr>
					</s:if>
					</s:iterator>
				</TBODY> 
				</s:iterator>
				</table>
				
		</div>
		<table width="100%" align="center" >
		<tr height="24" valign="middle">
		    <td  colspan="4" align="center" nowrap>
		      <input name="submit22" type="button" class="button_02a" value="保存" onClick="save(1)" />
		      <input name="submit22" type="button" class="button_02a" value="保存->楼盘页面" onClick="save(2)" />
		      <input name="Submit22" type="reset" class="button_02a" value="重置" />
	        	<input name="Submit22" type="button" class="button_02a" value="返回" onClick="javascript:find();"></td>
	    </tr>
	</table>
		</div>
		<input type="hidden" name="saveType" id="saveType" value=""/>
		<input type="hidden" name="houseForm.comp_sno"  value="${houseForm.comp_sno}"/>		
		<input type="hidden" name="houseForm.sh_sno"  value="${houseForm.sh_sno}"/>
		<input type="hidden" name="houseForm.ht_sno"  value="${houseForm.ht_sno}"/>
		<input type="hidden" name="houseForm.hs_sno"  value="${houseForm.hs_sno}"/>
</form>
</body>
</html>