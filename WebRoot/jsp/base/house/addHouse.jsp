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
		var flag = true;
						
		$(function(){
				$("#hs_nroomnum").blur(function(){
					var nroom=$("#hs_nroomnum").val();
					var nunit= $("#hs_nunit").val();
					var nu= $("#hs_nulayer").val();
					var nd= $("#hs_ndlayer").val();

					if(parseInt(nroom) >= parseInt(nunit)*(parseInt(nu)+parseInt(nd))){
					$("#hs_nroomnum\\.info").html("");
					
					flag = true;
					}else{
					$("#hs_nroomnum\\.info").html("请填写合理的楼栋总房间数！");
					flag = false;
					}
										
				});
			});



function save(type)
{
	if (!flag) {
		$("#hs_nroomnum").focus();
		$("#hs_nroomnum\\.info").html("请填写合理的楼栋总房间数！");
		return;
		} 

	if(validator(document.form1)){
		document.getElementById("saveType").value = type;
		document.getElementById("sh_sno").value = document.getElementById("sh_sno1").value.split("|")[0];
		document.getElementById("sh_sname").value = document.getElementById("sh_sno1").value.split("|")[1];
		var str = "";
		if (type == 1) {
			str = "是否保存?";
		} else if (type == 2) {
			str = "是否保存，继续添加单元?";
		}
		if(confirm(str)){
		document.form1.action="<%=path%>/house!add";
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




</script>
</head>

<body  style="overflow:hidden;" >
<!--<form name="form1" method="post" enctype="multipart/form-data">-->
<form name="form1" method="post" >
<div class="bigBox" >
<!--外部大DIV，可以调整宽度-->
<h2>
<span>基础管理 &gt; 楼栋信息管理 &gt; 新增</span>
</h2>
<div class="content" id="divheight" style="overflow:auto;">
	<table width="100%"  border="0">
		<tr>
			<td align="right" nowrap>所属校区：</td>
			<td align="left"  nowrap>
			  <select name="sh_sno1" id="sh_sno1" valid="required" errmsg="请选择所属校区!" >
			    <option value=""></option>
			    <s:iterator value="schoolList" var="school">
			      <option value="${school.sh_sno}|${school.sh_sname}">${school.sh_sname}</option>
			      </s:iterator>
			    </select>
			    <span class="msg">*</span>
			</td>
				
  			<td align="right" nowrap>所属单位：</td>
			<td align="left" nowrap>
				<input type="text" name="houseForm.comp_sname"  value="" size="17" valid="required" errmsg="请选择所属单位!" readonly/><img src="<%=path%>/images/09.gif" style="cursor:hand;" onClick="tree('houseForm.comp_sno','houseForm.comp_sname','<%=path %>/comp!tree')"	width="18" height="20" border="0" align="middle" />
            	<input type="hidden" name="houseForm.comp_sno" value=""><span class="msg">*</span>
			</td>
		</tr>
		<tr>
			<td align="right" nowrap>楼栋名称：</td>
			<td align="left" nowrap>
				<input type="text" name="houseForm.hs_sname" id="hs_sname" class="hs"  maxlength="20" valid="required|isSymbols" errmsg="楼栋名称不能为空!|楼栋名称只能以字母、汉字、数字、下划线组成!" />
				<span class="msg">*</span>
			</td>
      		<td align="right" nowrap>楼栋简称：</td>
		  	<td align="left" nowrap>
		  	<input type="text" name="houseForm.hs_ssname" id="hs_ssname"  maxlength="20" valid="required|isSymbols" errmsg="楼栋简称不能为空!|楼栋简称只能以字母、汉字、数字、下划线组成!" />
		  	<span class="msg">*</span></td>
		</tr>
		<tr>
			<td align="right" nowrap>地址：</td>
		  	<td colspan="3"   align="left" nowrap>
		  	<input type="text" name="houseForm.hs_saddr" maxlength="50" style="width:50%; "/></td>
		</tr>
		<tr >
			<td align="right" nowrap>楼栋单元数：</td>
	    	<td align="left" nowrap>
	    		<input type="text" name="houseForm.hs_nunit" id="hs_nunit" maxlength="6" valid="required|isNum" errmsg="楼栋单元数不能为空!|楼栋单元数只能为正整数!" />
	    		<span class="msg">*</span></td>
	    	<td align="right" nowrap>楼栋总房间数：</td>
	    	<td align="left" nowrap>
	    		<input type="text" name="houseForm.hs_nroomnum" id="hs_nroomnum"  maxlength="6" valid="required|isNum" errmsg="楼栋总房间数不能为空!|楼栋总房间数只能为正整数!" />
	    		<span id="hs_nroomnum.info" style="color:red;">*</span></td>
		</tr>
		<tr>
			<td align="right" nowrap>楼栋地上层数：</td>
			<td align="left" nowrap>
				<input type="text" name="houseForm.hs_nulayer" id="hs_nulayer"  maxlength="6" valid="required|isNum" errmsg="楼栋地上层数不能为空!|楼栋地上层数只能为正整数!" />
				<span class="msg">*</span></td>
			<td align="right" nowrap>楼栋地下层数：</td>
			<td align="left" nowrap>
				<input type="text" name="houseForm.hs_ndlayer" id="hs_ndlayer" maxlength="6" valid="required|isNum" errmsg="楼栋地下层数不能为空!|楼栋地下层数只能为正整数!" />
				<span class="msg">*</span></td>
		</tr>
		<tr>
			<td align="right" nowrap>电梯个数：</td>
			<td align="left" nowrap><input type="text" name="houseForm.hs_ndtnum" maxlength="6" valid="isNum" errmsg="电梯个数只能为正整数!" /></td>
			<td align="right" nowrap>楼道个数：</td>
			<td align="left" nowrap><input type="text" name="houseForm.hs_nldnum" maxlength="6" valid="isNum" errmsg="楼道个数只能为正整数!" /></td>
		</tr>
		<tr>
			<td align="right" nowrap>楼栋类型：</td>
		    <td align="left" nowrap>		    
   				<select name="houseForm.ht_sno" >
					<option value="" selected>--请选择--</option>
			        <option value="0" >类型一</option>
			        <option value="1" >类型二</option>
		        </select>
		    </td>
		  	<td align="right" nowrap>楼栋朝向：</td>
			<td align="left" nowrap>
			<select name="houseForm.hs_scx">
				<option value=""></option>
				<option value="东">东</option>
				<option value="东南">东南</option>
				<option value="南">南</option>
				<option value="西南">西南</option>
				<option value="西">西</option>
				<option value="西北">西北</option>
				<option value="北">北</option>
				<option value="东北">东北</option>
			</select>
			</td>
		</tr>
		<tr>
			<td align="right" nowrap>状态：</td>
			<td align="left" nowrap>
			<select name="houseForm.hs_sstat">
			  <option value="" selected>--请选择--</option>
			  <option value="0">在建</option>
			  <option value="1">在用</option>
			  <option value="2">维修</option>
			  <option value="3">拆除</option>
            </select>
		    </td>
			<td align="right" nowrap>总使用面积(㎡)：</td>
	    	<td align="left" nowrap><input type="text" name="houseForm.hs_nsyarea" maxlength="20" valid="isMoney" errmsg="总使用面积只能为正数!" /></td>
		</tr>
		<tr>
			<td align="right" nowrap>总建筑面积(㎡)：</td>
			<td align="left" nowrap><input type="text" name="houseForm.hs_njzarea" maxlength="20" valid="isMoney" errmsg="总建筑面积只能为正数!" /></td>
			<td align="right" nowrap>总占地面积(㎡)：</td>
			<td align="left" nowrap><input type="text" name="houseForm.hs_nzdarea" maxlength="20" valid="isMoney" errmsg="总占地面积只能为正数!" /></td>
		</tr>
		<tr>
			<td align="right" nowrap>房屋造价(元)：</td>
	    	<td align="left" nowrap><input type="text" name="houseForm.hs_nbuildnum" maxlength="20" valid="isMoney" errmsg="房屋造价只能为正数!" />
	    	</td>
		  	<td align="right" nowrap>抗震系数：</td>
			<td align="left" nowrap>
				<select name="houseForm.hs_skznum" style="width:130px;">
					<option value="" ></option>
					<option value="1" >1</option>
					<option value="2" >2</option>
					<option value="3" >3</option>
				</select>
				</td>
			
		</tr>
		<tr>
			<td align="right" nowrap>人防级别：</td>
			<td align="left" nowrap>
				<select name="houseForm.hs_srflevel" style="width:130px;">
					<option value=""></option>
					<option value="1">1</option>
					<option value="2">2</option>
					<option value="3">3</option>
				</select>
				</td>
			<td align="right" nowrap>楼栋结构：</td>
			<td align="left" nowrap>
				<select name="houseForm.hs_scr" style="width:130px;">
			  		<option value=""></option>
			  		<option value="0">一字型</option>
			  		<option value="1">U字型</option>
			  		<option value="2">O字型</option>
		    	</select></td>
		</tr>
		<tr>
			<td align="right" nowrap>类型结构：</td>
			<td align="left" nowrap> 
				<select name="houseForm.hs_stype" style="width:130px;">
					<option value=""></option>
					<option value="0" >单间</option>
					<option value="1" >套间</option>
				</select></td>
			<td align="right" nowrap>房间结构：</td>
			<td align="left" nowrap>
				<select name="houseForm.hs_sroomcr" style="width:130px;">
					<option value="0">几室几厅</option>
				</select></td>
		</tr>
		<tr>
			<td align="right" nowrap>使用类型：</td>
			<td align="left" nowrap>
				<select name="houseForm.hs_susetype" style="width:130px;">
			  		<option value=""></option>
			  		<option value="0" >一般</option>
			  		<option value="1" >专用</option>
			  		<option value="2" >公用</option>
		    	</select></td>
		  	<td align="right" nowrap>使用单位：</td>
			<td align="left" nowrap>
				<input type="text" name="comp_sname1"  value="" size="17"   readonly/><img src="<%=path%>/images/09.gif" style="cursor:hand;" onClick="tree('houseForm.comp_sno1','comp_sname1','<%=path %>/comp!tree')" width="18" height="20" border="0" align="middle"  >
            	<input type="hidden" name="houseForm.comp_sno1" value="">
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
	    	<td align="left" nowrap><input type="text" name="houseForm.hs_scomp" maxlength="20" /></td>
	    	<td align="right" nowrap>承建主负责人：</td>
	    	<td align="left" nowrap><input type="text" name="houseForm.hs_semp" maxlength="20" /></td>
		</tr>
		<tr>
			<td align="right" nowrap>承建开始日期：</td>
			<td align="left" nowrap>
				<input type="text" name="houseForm.hs_dcdate" onfocus="WdatePicker({maxDate:'%y-%M-{%d}'})" class="Wdate" /></td>
			<td align="right" nowrap>承建完工日期：</td>
			<td align="left" nowrap>
				<input type="text" name="houseForm.hs_dwdate" onfocus="WdatePicker({maxDate:'%y-%M-{%d}'})" class="Wdate" /></td>
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
				<input type="text" name="houseForm.hs_sccomp" maxlength="20" /></td>
			<td align="right" nowrap>图纸设计负责人：</td>
			<td align="left" nowrap>
				<input type="text" name="houseForm.hs_scemp" maxlength="20" /></td>
		</tr>
		<tr>
			<td align="right" nowrap>招标文件号：</td>
	    	<td align="left" nowrap>
	    		<input type="text" name="houseForm.hs_sfilesno" maxlength="40" /></td>
		  	<td align="right" nowrap>招标文件名称：</td>
			<td align="left" nowrap>
				<input type="text" name="houseForm.hs_sfilename" maxlength="40" /></td>
		</tr>
		<tr>
			<td align="right" nowrap>产权类型：</td>
			<td align="left" nowrap>
				<select name="houseForm.hs_sfctype" style="width:130px;">
					<option value="" ></option>
			  		<option value="1" >1</option>
			  		<option value="1" >1</option>
			  		<option value="1" >1</option>
		    	</select></td>
		  	<td align="right" nowrap>房产证号：</td>
			<td align="left" nowrap>
				<input type="text" name="houseForm.hs_sfcno" maxlength="40" /></td>
		</tr>
		<tr>
		  	<td align="right" nowrap>原楼栋代码：</td>
			<td align="left" nowrap>
				<input type="text" name="houseForm.hs_soldno" maxlength="40" /></td>
			<td align="right" nowrap>原楼栋名称：</td>
			<td align="left" nowrap>
				<input type="text" name="houseForm.hs_soldname" maxlength="40" /></td>
		</tr>
		<tr>
			<td align="right" nowrap>供暖费用(元/月)：</td>
	    	<td align="left" nowrap>
	    		<input type="text" name="houseForm.hs_nheatnum" maxlength="20" valid="isMoney" errmsg="供暖费用只能为正数!" /></td>
		  	<td align="right" nowrap>物业费用(元/月)：</td>
			<td align="left" nowrap><input type="text" name="houseForm.hs_nproperty" maxlength="20" valid="isMoney" errmsg="供暖费用只能为正数!" /></td>
		</tr>
		<tr>
			<td align="right" nowrap>资金来源：</td>
	    	<td align="left" colspan="3" nowrap>
	    		<input type="text" name="houseForm.hs_smem1" maxlength="40" /></td>
	    </tr>
		<tr>
		  <td align="right" nowrap>备注：</td>
		  <td align="left" colspan="3" nowrap>
		  	<textarea name="houseForm.hs_smem" id="textarea" style="width:50%;" rows="5"></textarea>
	      </td>
	    </tr>
		
	</table>
</div>
	<table width="100%" align="center" >
		<tr height="24" valign="middle">
		    <td   align="center" nowrap>
		      <input name="submit22" type="button" class="button_02a" value="保存" onClick="save(1)" />
		      <input name="submit22" type="button" class="button_02a" value="保存->添加单元" onClick="save(2)" />
		      <input name="Submit22" type="reset" class="button_02a" value="重置" />
	          <input name="Submit22" type="button" class="button_02a" value="返回" onClick="javascript:history.back();"></td>
	    </tr>
	</table>
</div>　
<input type="hidden" name="saveType" id="saveType" value=""/>
<input type="hidden" name="houseForm.sh_sno" id="sh_sno" value=""/>
<input type="hidden" name="houseForm.sh_sname" id="sh_sname" value=""/>


</form>
</body>
</html>