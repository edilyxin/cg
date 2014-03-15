<%@ page language="java" isELIgnored="false" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
String path = request.getContextPath();
%>

<jsp:include page="/common/util.jsp"/>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"  "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script language="javascript">
function save()
{
	if(validator(document.form1)){
		if(confirm("是否保存?")){
			document.form1.action="<%=path %>/house!update";
			document.form1.submit();
		}	
	}
}

	$(function(){
		$(".hs").change(function(){
			var sname=$("#hs_sname").val();
			$("#hs_ssname").val(sname);
		});
	});



//获得divheight的高度
	function getheight(){ 
			document.getElementById("divheight").style.height= document.body.offsetHeight-83;
			document.getElementById("divheight").style.width= document.body.offsetWidth;

	}
</script>
</head>

<body onload="getheight();" onresize="getheight();" style="overflow:hidden;" >
<!--<form name="form1" method="post" enctype="multipart/form-data">-->
<form name="form1" method="post" >
<div class="bigBox" >
<!--外部大DIV，可以调整宽度-->
<h2>
<span>基础管理 &gt; 楼栋信息管理 &gt; 修改</span>
</h2>
<div class="content" id="divheight" style="overflow:auto;">
	<table width="100%"  border="0">
		<tr>
			<td align="right" nowrap>所属校区：</td>
			<td align="left"  nowrap>
			  <select name="houseForm.sh_sno" id="sh_sno1" valid="required" errmsg="请选择所属校区!" >
			    <option value=""></option>
			    <s:iterator value="schoolList" var="school">
			      <option value="${school.sh_sno}" <s:if test="#school.sh_sno == house.sh_sno">selected</s:if>>${school.sh_sname}</option>
			      </s:iterator>
			    </select>
			    <span class="msg">*</span>
			</td>
				
  			<td align="right" nowrap>所属单位：</td>
			<td align="left" nowrap>
				<input type="text" name="houseForm.comp_sname"  value="${comp.comp_sname}" size="17" valid="required" errmsg="请选择所属单位!" readonly/><img src="<%=path%>/images/09.gif" style="cursor:hand;" onClick="tree('houseForm.comp_sno','houseForm.comp_sname','<%=path %>/comp!tree')"	width="18" height="20" border="0" align="middle" />
            	<input type="hidden" name="houseForm.comp_sno" value="${comp.comp_sno}"><span class="msg">*</span>
			</td>
		</tr>
		<tr>
			<td align="right" nowrap>楼栋名称：</td>
			<td align="left" nowrap>
				<input type="text" name="houseForm.hs_sname" id="hs_sname" value="${house.hs_sname}" class="hs"  maxlength="20" valid="required|isSymbols" errmsg="楼栋名称不能为空!|楼栋名称只能以字母、汉字、数字、下划线组成!" />
				<span class="msg">*</span>
			</td>
      		<td align="right" nowrap>楼栋简称：</td>
		  	<td align="left" nowrap>
		  	<input type="text" name="houseForm.hs_ssname" id="hs_ssname" value="${house.hs_ssname}"  maxlength="20" valid="required|isSymbols" errmsg="楼栋简称不能为空!|楼栋简称只能以字母、汉字、数字、下划线组成!" />
		  	<span class="msg">*</span></td>
		</tr>
		<tr>
			<td align="right" nowrap>地址：</td>
		  	<td colspan="3"   align="left" nowrap>
		  	<input type="text" name="houseForm.hs_saddr" value="${house.hs_saddr}" maxlength="50" style="width:50%; "/></td>
		</tr>
		<tr >
			<td align="right" nowrap>楼栋单元数：</td>
	    	<td align="left" nowrap>
	    		<input type="text" name="houseForm.hs_nunit" value="${house.hs_nunit}" maxlength="6" valid="required|isNum" errmsg="楼栋单元数不能为空!|楼栋单元数只能为正整数!" />
	    		<span class="msg">*</span></td>
	    	<td align="right" nowrap>楼栋总房间数：</td>
	    	<td align="left" nowrap>
	    		<input type="text" name="houseForm.hs_nroomnum" value="${house.hs_nroomnum}" maxlength="6" valid="required|isNum" errmsg="楼栋总房间数不能为空!|楼栋总房间数只能为正整数!" />
	    		<span class="msg">*</span></td>
		</tr>
		<tr>
			<td align="right" nowrap>楼栋地上层数：</td>
			<td align="left" nowrap>
				<input type="text" name="houseForm.hs_nulayer" value="${house.hs_nulayer}" maxlength="6" valid="required|isNum" errmsg="楼栋地上层数不能为空!|楼栋地上层数只能为正整数!" />
				<span class="msg">*</span></td>
			<td align="right" nowrap>楼栋地下层数：</td>
			<td align="left" nowrap>
				<input type="text" name="houseForm.hs_ndlayer" value="${house.hs_ndlayer}" maxlength="6" valid="required|isNum" errmsg="楼栋地下层数不能为空!|楼栋地下层数只能为正整数!" />
				<span class="msg">*</span></td>
		</tr>
		<tr>
			<td align="right" nowrap>电梯个数：</td>
			<td align="left" nowrap><input type="text" name="houseForm.hs_ndtnum" value="${house.hs_ndtnum}" maxlength="6" valid="isNum" errmsg="电梯个数只能为正整数!" /></td>
			<td align="right" nowrap>楼道个数：</td>
			<td align="left" nowrap><input type="text" name="houseForm.hs_nldnum" value="${house.hs_nldnum}" maxlength="6" valid="isNum" errmsg="楼道个数只能为正整数!" /></td>
		</tr>
		<tr>
			<td align="right" nowrap>楼栋类型：</td>
		    <td align="left" nowrap>		    
   				<select name="houseForm.ht_sno" >
					<option value="">--请选择--</option>
			        <option value="0" <s:if test="house.ht_sno == \"0\"">selected</s:if>>类型一</option>
			        <option value="1" <s:if test="house.ht_sno == \"1\"">selected</s:if>>类型二</option>
			       
		        </select>
		    </td>
		  	<td align="right" nowrap>楼栋朝向：</td>
			<td align="left" nowrap>
			<select name="houseForm.hs_scx">
				<option value=""></option>
				<option value="东" <s:if test="house.hs_scx == \"东\"">selected</s:if>>东</option>
				<option value="东南" <s:if test="house.hs_scx == \"东南\"">selected</s:if>>东南</option>
				<option value="南" <s:if test="house.hs_scx == \"南\"">selected</s:if>>南</option>
				<option value="西南" <s:if test="house.hs_scx == \"西南\"">selected</s:if>>西南</option>
				<option value="西" <s:if test="house.hs_scx == \"西\"">selected</s:if>>西</option>
				<option value="西北" <s:if test="house.hs_scx == \"西北\"">selected</s:if>>西北</option>
				<option value="北" <s:if test="house.hs_scx == \"北\"">selected</s:if>>北</option>
				<option value="东北" <s:if test="house.hs_scx == \"东北\"">selected</s:if>>东北</option>
			</select>
			</td>
		</tr>
		<tr>
			<td align="right" nowrap>状态：</td>
			<td align="left" nowrap>
			<select name="houseForm.hs_sstat">
			  <option value="" selected>--请选择--</option>
			  <option value="0" <s:if test="house.hs_sstat == \"0\"">selected</s:if>>在建</option>
			  <option value="1" <s:if test="house.hs_sstat == \"1\"">selected</s:if>>在用</option>
			  <option value="2" <s:if test="house.hs_sstat == \"2\"">selected</s:if>>维修</option>
			  <option value="3" <s:if test="house.hs_sstat == \"3\"">selected</s:if>>拆除</option>
            </select>
		    </td>
			<td align="right" nowrap>总使用面积(㎡)：</td>
	    	<td align="left" nowrap><input type="text" name="houseForm.hs_nsyarea" value="${house.hs_nsyarea}" maxlength="20" valid="isMoney" errmsg="总使用面积只能为正数!" /></td>
		</tr>
		<tr>
			<td align="right" nowrap>总建筑面积(㎡)：</td>
			<td align="left" nowrap><input type="text" name="houseForm.hs_njzarea" value="${house.hs_njzarea}" maxlength="20" valid="isMoney" errmsg="总建筑面积只能为正数!" /></td>
			<td align="right" nowrap>总占地面积(㎡)：</td>
			<td align="left" nowrap><input type="text" name="houseForm.hs_nzdarea" value="${house.hs_nzdarea}" maxlength="20" valid="isMoney" errmsg="总占地面积只能为正数!" /></td>
		</tr>
		<tr>
			<td align="right" nowrap>房屋造价(元)：</td>
	    	<td align="left" nowrap><input type="text" name="houseForm.hs_nbuildnum" value="${house.hs_nbuildnum}" maxlength="20" valid="isMoney" errmsg="房屋造价只能为正数!" />
	    	</td>
		  	<td align="right" nowrap>抗震系数：</td>
			<td align="left" nowrap>
				<select name="houseForm.hs_skznum" style="width:130px;">
					<option value="" <s:if test="house.hs_skznum == \"\"">selected</s:if>></option>
					<option value="1" <s:if test="house.hs_skznum == \"1\"">selected</s:if>>1</option>
					<option value="2" <s:if test="house.hs_skznum == \"2\"">selected</s:if>>2</option>
					<option value="3" <s:if test="house.hs_skznum == \"3\"">selected</s:if>>3</option>
				</select>
				</td>
			
		</tr>
		<tr>
			<td align="right" nowrap>人防级别：</td>
			<td align="left" nowrap>
				<select name="houseForm.hs_srflevel" style="width:130px;">
					<option value=""></option>
					<option value="1" <s:if test="house.hs_srflevel == \"1\"">selected</s:if>>1</option>
					<option value="2" <s:if test="house.hs_srflevel == \"2\"">selected</s:if>>2</option>
					<option value="3" <s:if test="house.hs_srflevel == \"3\"">selected</s:if>>3</option>
				</select>
				</td>
			<td align="right" nowrap>楼栋结构：</td>
			<td align="left" nowrap>
				<select name="houseForm.hs_scr" style="width:130px;">
			  		<option value=""></option>
			  		<option value="0" <s:if test="house.hs_scr == \"0\"">selected</s:if>>一字型</option>
			  		<option value="1" <s:if test="house.hs_scr == \"1\"">selected</s:if>>U字型</option>
			  		<option value="2" <s:if test="house.hs_scr == \"2\"">selected</s:if>>O字型</option>
		    	</select>
		    </td>
		</tr>
		<tr>
			<td align="right" nowrap>类型结构：</td>
			<td align="left" nowrap> 
				<select name="houseForm.hs_stype" style="width:130px;">
					<option value=""></option>
					<option value="0" <s:if test="house.hs_stype == \"0\"">selected</s:if>>单间</option>
					<option value="1" <s:if test="house.hs_stype == \"1\"">selected</s:if>>套间</option>
				</select></td>
			<td align="right" nowrap>房间结构：</td>
			<td align="left" nowrap>
				<select name="houseForm.hs_sroomcr" style="width:130px;">
					<option value="0" <s:if test="house.hs_sroomcr == \"0\"">selected</s:if>>几室几厅</option>
				</select></td>
		</tr>
		<tr>
			<td align="right" nowrap>使用类型：</td>
			<td align="left" nowrap>
				<select name="houseForm.hs_susetype" style="width:130px;">
			  		<option value=""></option>
			  		<option value="0" <s:if test="house.hs_susetype == \"0\"">selected</s:if>>一般</option>
			  		<option value="1" <s:if test="house.hs_susetype == \"1\"">selected</s:if>>专用</option>
			  		<option value="2" <s:if test="house.hs_susetype == \"2\"">selected</s:if>>公用</option>
		    	</select></td>
		  	<td align="right" nowrap>使用单位：</td>
			<td align="left" nowrap>
				<input type="text" name="comp_sname1"  value="" size="17"   readonly/><img src="<%=path%>/images/09.gif" style="cursor:hand;" onClick="tree('houseForm.comp_sno1','comp_sname1','<%=path %>/comp!tree')" width="18" height="20" border="0" align="middle"  >
            	<input type="hidden" name="houseForm.comp_sno1" value="${house.comp_sno1}">
			</td>
		</tr>
		<tr>
			<td align="right" nowrap>楼栋效果图：</td>
		  	<td align="left" colspan="3" nowrap>
		  		<input type="file" name="houseForm.hs_sfile" style="width:50%;height:20px;"    />
		  		<input type="button" value="上传" style="height:20px;"/>
		  	</td>
		</tr>
		<tr>
			<td align="right" nowrap>承建单位：</td>
	    	<td align="left" nowrap><input type="text" name="houseForm.hs_scomp" value="${house.hs_scomp}" maxlength="20" /></td>
	    	<td align="right" nowrap>承建主负责人：</td>
	    	<td align="left" nowrap><input type="text" name="houseForm.hs_semp" value="${house.hs_semp}" maxlength="20" /></td>
		</tr>
		<tr>
			<td align="right" nowrap>承建开始日期：</td>
			<td align="left" nowrap>
				<input type="text" name="houseForm.hs_dcdate" value="<s:date name="house.hs_dcdate" format="yyyy-MM-dd"/>" onfocus="WdatePicker({maxDate:'%y-%M-{%d}'})" class="Wdate" /></td>
			<td align="right" nowrap>承建完工日期：</td>
			<td align="left" nowrap>
				<input type="text" name="houseForm.hs_dwdate" value="<s:date name="house.hs_dwdate" format="yyyy-MM-dd"/>" onfocus="WdatePicker({maxDate:'%y-%M-{%d}'})" class="Wdate" /></td>
		</tr>
		<tr>
			<td align="right" nowrap>承建图纸：</td>
		  	<td align="left" colspan="3" nowrap>
		  		<input type="file" name="houseForm.hs_sdrawfile" style="width:50%;height:20px;" />
		  		<input type="button" value="上传" style="height:20px;"/></td>
		</tr>
		<tr>
			<td align="right" nowrap>图纸设计单位：</td>
			<td align="left" nowrap>
				<input type="text" name="houseForm.hs_sccomp" value="${house.hs_sccomp}" maxlength="20" /></td>
			<td align="right" nowrap>图纸设计负责人：</td>
			<td align="left" nowrap>
				<input type="text" name="houseForm.hs_scemp" value="${house.hs_scemp}" maxlength="20" /></td>
		</tr>
		<tr>
			<td align="right" nowrap>招标文件号：</td>
	    	<td align="left" nowrap>
	    		<input type="text" name="houseForm.hs_sfilesno" value="${house.hs_sfilesno}" maxlength="40" /></td>
		  	<td align="right" nowrap>招标文件名称：</td>
			<td align="left" nowrap>
				<input type="text" name="houseForm.hs_sfilename" value="${house.hs_sfilename}" maxlength="40" /></td>
		</tr>
		<tr>
			<td align="right" nowrap>产权类型：</td>
			<td align="left" nowrap>
				<select name="houseForm.hs_sfctype" style="width:130px;">
					<option value="" ></option>
			  		<option value="1" <s:if test="house.hs_sfctype == \"1\"">selected</s:if>>1</option>
			  		<option value="1" <s:if test="house.hs_sfctype == \"1\"">selected</s:if>>1</option>
			  		<option value="1" <s:if test="house.hs_sfctype == \"1\"">selected</s:if>>1</option>
		    	</select></td>
		  	<td align="right" nowrap>房产证号：</td>
			<td align="left" nowrap>
				<input type="text" name="houseForm.hs_sfcno" value="${house.hs_sfcno}" maxlength="40" /></td>
		</tr>
		<tr>
		  	<td align="right" nowrap>原楼栋代码：</td>
			<td align="left" nowrap>
				<input type="text" name="houseForm.hs_soldno" value="${house.hs_soldno}" maxlength="40" /></td>
			<td align="right" nowrap>原楼栋名称：</td>
			<td align="left" nowrap>
				<input type="text" name="houseForm.hs_soldname" value="${house.hs_soldname}" maxlength="40" /></td>
		</tr>
		<tr>
			<td align="right" nowrap>供暖费用(元/月)：</td>
	    	<td align="left" nowrap>
	    		<input type="text" name="houseForm.hs_nheatnum" value="${house.hs_nheatnum}" maxlength="20" valid="isMoney" errmsg="供暖费用只能为正数!" /></td>
		  	<td align="right" nowrap>物业费用(元/月)：</td>
			<td align="left" nowrap><input type="text" name="houseForm.hs_nproperty" value="${house.hs_nproperty}" maxlength="20" valid="isMoney" errmsg="供暖费用只能为正数!" /></td>
		</tr>
		<tr>
			<td align="right" nowrap>资金来源：</td>
	    	<td align="left" colspan="3" nowrap>
	    		<input type="text" name="houseForm.hs_smem1" value="${house.hs_smem1}" maxlength="40" /></td>
	    </tr>
		<tr>
		  <td align="right" nowrap>备注：</td>
		  <td align="left" colspan="3" nowrap>
		  	<textarea name="houseForm.hs_smem" id="textarea" style="width:50%;" rows="5">${house.hs_smem}</textarea>
	      </td>
	    </tr>
		
	</table>
</div>
	<table width="100%" align="center" >
		<tr height="24" valign="middle">
		    <td  colspan="4" align="center" nowrap>
		      <input name="submit22" type="button" class="button_02a" value="保存" onClick="save()" />
		      <input name="Submit22" type="reset" class="button_02a" value="重置" />
	          <input name="Submit22" type="button" class="button_02a" value="返回" onClick="javascript:history.back();"></td>
	    </tr>
	</table>
</div>　
<input type="hidden" name="houseForm.hs_sno" value="${house.hs_sno}"/>
</form>
</body>
</html>