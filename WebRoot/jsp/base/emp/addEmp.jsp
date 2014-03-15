<%@ page language="java" import="java.util.*,java.text.*" pageEncoding="UTF-8"%>
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
   
    
    <title>职工信息</title>
    
<link href="<%=path %>/css/skin.css" rel="stylesheet" type="text/css" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script type="text/javascript" src="<%=path%>/js/JS_Pinyin.js"></script>
<script src="<%=path %>/js/valid.js" type=text/javascript></script> 
<script> 
function save(){
   $("#show1").show();
    $("#show2").show();
     $("#show3").show();
     $(function(){ 	 
    	 var sno=$("#udsno").val();
    	 var sname=$("#udsname").val();
    	 no= new Array();
    	
    	 no=sno.split("->"); //字符分割    
    	
    	 var udsno= no[0]==undefined?"":no[0];
    	 var udsno1= no[1]==undefined?"":no[1];
    	 var udsno2= no[2]==undefined?"":no[2];
    	
    	 
    	 $("#searchA").val(udsno);	
    	 $("#searchB").val(udsno1);
    	 $("#searchG").val(udsno2);
    	   empname= new Array();
    	   empname=sname.split("->");
    	 var udsname=empname[0]==undefined?"":empname[0];
    	 var udsname1=empname[1]==undefined?"":empname[1];
    	 var udsname2=empname[2]==undefined?"":empname[2];
    	 $("#ud_sname").val(udsname);	
    	 $("#ud_sname1").val(udsname1);
    	 $("#ud_sname2").val(udsname2);
     });
     
 		if(validator()){
					if(confirm("是否保存？")){
 			document.form1.action="<%=path%>/emp!add";
 			document.form1.submit();
 		 
 	}
	}

}
function toResut(){
    document.all.form1.reset();
}
function show1(){
    $("#show1").toggle();
}
function show2(){
    $("#show2").toggle();
}
function show3(){
    $("#show3").toggle();
}

 $(document).ready(function(){
 	getDictSelect("","emp_nlevel","emp_nlevel","","1","<%=path %>");
 	getDictSelect("","emp_sstype","emp_sstype","","1","<%=path %>");
 	});

 $(function(){
		var udsno =$("#searchA").val()+"->" ;
		var udsno1 =$("#searchB").val()+"->";
		var udsno2 =$("#searchE").val();
		var udsname=$("#ud_sname").val()+"->" ;
		var udsname1=$("#ud_sname1").val()+"->";
		var udsname2=$("#ud_sname2").val();
		
		
	});
  
 	function sisfsdw(obj){
 		 if(obj==""){
 			 
 			$("#sfno").css("display","none");
			  $("#emp_sfname").attr("readonly","readonly");
			  $("#emp_sfname").focus(function (){this.blur();});
			 $("#emp_sfname").css("opacity",0.5);
			document.getElementById("emp_sfname").value="";
 		 }else if(obj=="0"){
 			$("#sfno").css("display","none");
 			$("#emp_sfname").css("opacity",1);
 			 $("#emp_sfname").removeAttr("readonly");
 			$("#emp_sfname").unbind(); 
 			document.getElementById("emp_sfname").value="";
 		}else{
 			$("#sfno").css("display","inline");
 			  $("#emp_sfname").attr("readonly","readonly");
 			 $("#emp_sfname").focus(function (){this.blur();});
 			 $("#emp_sfname").css("opacity",0.5);
 			document.getElementById("emp_sfname").value="";
 			
 		}
 	}
 	
	function sisfzrbdw(obj){
		 if(obj==""){
			 $("#szr").css("display","none");
			  $("#emp_szrno").attr("readonly","readonly");
			  $("#emp_szrno").focus(function (){this.blur();});
			 $("#emp_szrno").css("opacity",0.5);
			document.getElementById("emp_szrno").value="";
		 }else 
			 if(obj=="0"||obj=="1"){
				 $("#szr").css("display","none");
			  $("#emp_szrno").attr("readonly","readonly");
			  $("#emp_szrno").unbind();
				 $("#emp_szrno").css("opacity",0.5);
			document.getElementById("emp_szrno").value="";
		}else{
			$("#szr").css("display","inline");
			  $("#emp_szrno").attr("readonly","readonly");
			  $("#emp_szrno").focus(function (){this.blur();});
			 $("#emp_szrno").css("opacity",0.5);
			document.getElementById("emp_szrno").value="";
		}
	}
 	
 	function pinyin() {
 		 var s=$("#emp_sname").val();
 	     var s1=YZCPY1(s);//汉字转拼音
 	     var s2=YZCPY2(s);//汉字转拼音取的 首字母(大写)  
 	     $("#emp_sename").val(s1); 
 	    $("#emp_sdef4").val(s1);
 	      
	}
 	 $(function(){
 	$("#emp_sename").blur(function(){
 		$("#emp_sdef4").val($("#emp_sename").val());
 	});
 	 });
 	
 
</script>
</head>
<body>
<form name="form1" method="post">
<div class="bigBox"  >
		<!--外部大DIV，可以调整宽度-->
		<h2>
			<span><s:property value="#session.navbar"/></span></h2>
   <div class="content" id="divheight" style="overflow:auto;"> 
	 
       	<table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
			<tr>
    			<td height="30">
    				<table width="100%" border="0" cellspacing="0" cellpadding="0">
      					<tr>
        					<td height="24" bgcolor="#0E6BB1">
        						<table width="100%" border="0" cellspacing="0" cellpadding="0">
          							<tr>
            							<td>
            								<table width="100%" border="0" cellspacing="0" cellpadding="0">
              									<tr>
                									<td width="6%" height="19" valign="bottom"><div align="center"><img src="<%=path%>/images/tb.gif" width="14" height="14" /></div></td>
                									<td width="94%" valign="bottom"><span class="STYLE1">添加员工基础信息</span></td>
              									</tr>
            								</table>
            							</td>
            							<td><div align="right"><span class="STYLE1">&nbsp;</span><span class="STYLE1"> &nbsp;</span></div>
              							</td>
          							</tr>
        						</table>
        					</td>
      					</tr>
    				</table>
    			</td>
  			</tr>
 			<tr valign="top">
    			<td>
    				<table width="100%" border="0" cellpadding="0" cellspacing="1" bgcolor="#a8c7ce" >
      					<tr bgcolor="#FFFFFF">
        					<td   bgcolor="#FFFFFF">
					  			<table border="0" cellpadding="2" cellspacing="1" style="width:100%;height:100%;font-size:12px;font-family: Verdana, Arial, Helvetica, sans-serif;"  bgcolor="#E3E9EE">
					 				
					 			  	
					 			  	<tr>
					    				
										   <td nowrap align="right" width="15%"  nowrap>所属单位:</td>
										   <td nowrap width="35%"  >
										   		<input type="hidden"  name="" id="udsno" value="" />
											  <input type="text" style="width:260px" name="" id="udsname" readonly="readonly" value=""onclick="unitDepartTree1('udsno','udsname','111000');"  valid="required" errmsg="单位不能为空!"/>
										       <input type="button" class="select_button" onclick="unitDepartTree1('udsno','udsname','111000');" />
										     <span style="color:red;">*</span>											 
											 <input type="hidden" name="form.ud_sno" id="searchA" value="${form.ud_sno}"/>
											<input type="hidden" name="form.ud_sno1" id="searchB" value="${form.ud_sno1}"/>
											<input type="hidden" name="form.ud_sno2" id="searchG" value="${form.ud_sno2}" />
											  <input type="hidden"  name="form.ud_sname" id="ud_sname" value="${form.ud_sname}"/>
										  <input type="hidden"  name="form.ud_sname1" id="ud_sname1" value="${form.ud_sname1}"/>
										  <input type="hidden"  name="form.ud_sname2" id="ud_sname2" value="${form.ud_sname2}" />
										  </td>
										   
					    				<td nowrap align="right"  width="15%" nowrap>所属校区:</td>
										 <td nowrap>
										 	 
											     <input type="hidden" id="searchc"  name="form.sh_sno" value="${form.sh_sno}" />
											 <input type="text"  name="form.sh_sname" id="sh_sname" value="${form.sh_sname}" readonly onclick="schoolTreecheck('searchc','sh_sname');" />
				 								 <input type="button" class="select_button"onclick="schoolTreecheck('searchc','sh_sname');" />
										 
										 </td>
					    			</tr>
					    			   
					    		     <tr>
					 				       <td nowrap align="right" nowrap>员工姓名:</td>
										    <td nowrap>
										    	<input name="form.emp_sname" id="emp_sname" value="" onkeyup="pinyin()"  class="text" maxlength="25"  style="width:154px" valid="required" errmsg="员工姓名不能为空!"/>
										    <span style="color:red;">*</span>
										    
										   </td><!--
										
										   <td nowrap align="right" nowrap>英文名:</td>
										    <td nowrap>
										       <input name="form.emp_sename" id="emp_sename" value="" maxlength="50"  class="text" style="width:154px" onkeyup="if(this.value.search(/^[A-Za-z]+$/)==-1)this.value=(this.value2)?this.value2:'';else this.value2=null;"/>
										     <input name="form.emp_sdef4" id="emp_sdef4" value=""   type="hidden" style="width:154px"  />
										    <span style="color:red;"  id="errMsg_emp_sename"></span>
										   </td>
										   --><td nowrap align="right" nowrap>英文名:</td>
										    <td nowrap>
										       <input name="form.emp_sename" id="emp_sename" value="" maxlength="50"  class="text" style="width:154px" valid="isEnglish" errmsg="英文名必须为字母!"/>
										      <input name="form.emp_sdef4" id="emp_sdef4" value=""   type="hidden" style="width:154px"  />
										    <span style="color:red;"  id="errMsg_emp_sename"></span>
										   </td> 
										   
								     </tr>
										  
									  <tr>
					 				         <td nowrap align="right" nowrap>性别:</td>
										     <td>
										          <input id="sex1" type="radio" value="1" name="form.emp_sgender" runat="server" valid="required" errmsg="性别不能为空!" checked="checked" />男 &nbsp;
    		   						       		  <input id="sex2" type="radio" value="0" name="form.emp_sgender" runat="server" />女
										    	  
										    	  <span style="color:red;"  id="errMsg_us_sno"></span>
										     </td>
					    				      <td nowrap align="right" nowrap>入职日期:</td>
										      <td nowrap>
										   			 <input name="form.emp_dintime" id="emp_dintime" onfocus="WdatePicker({maxDate:'%y-%M-{%d}'})" value=""   class="text" style="width:154px" />
												     
												    <span style="color:red;"  id="errMsg_emp_dintime"></span>
										   </td>
									 </tr>
										
									 <tr>
										    <td nowrap align="right" nowrap>职工状态:</td>
										    <td nowrap>
										    	 <select name="form.emp_nstate" id="emp_nstate"  style="width:110px" valid="required" errmsg="职工状态不能为空!"> 
										          		 <option value="">--请选择--</option>
										          		 <option value="0">在职</option>
										          		 <option value="1">离职</option>
										          		 <option value="2">停薪留职</option>
										          		 <option value="3">退休</option>
										          		 <option value="4">反聘</option>
										          	     <option value="5">全职外聘</option>
										          		 <option value="6">兼职</option>
										          		  <option value="7">挂职</option>
										          		  <option value="8">客座</option>
										          		  <option value="9">去逝</option>
						          		          </select>
											    <span style="color:red;">*</span>
											    <span style="color:red;"  id="errMsg_emp_nState"></span>
										   </td>
										   
										    <td nowrap align="right" nowrap>职务:</td>
										    <td nowrap> 
										    		 <input type="text"   id="job_sname"    onclick="jobTree('job_sno','job_sname');" readonly/> 
    												 <input type="button" class="select_button"onclick="jobTree('job_sno','job_sname');" />
    												 <input type="hidden" id="job_sno" name="form.job_sno"     /> 
	
													 <span style="color:red;"  id="errMsg_job_sno"></span>
										   </td>							
								    </tr>
					    			
					    			  <tr>   
										   	<td nowrap align="right" nowrap>职称:</td>
										    <td nowrap>
										    	    <input type="text"   id="post_sname"  onclick="postTree('post_sno','post_sname');"   readonly/>
    												  <input type="button" class="select_button"onclick="postTree('post_sno','post_sname');"/>
    												 <input type="hidden" id="post_sno" name="form.post_sno"     /> 
										   
											   </td>
										
										   <td nowrap align="right" nowrap>职级:</td>
										   <td nowrap>
										     	  <select  name="form.emp_nlevel" id="emp_nlevel" valid="required" errmsg="请选择职称!">
													      <option value="">--请选择--</option>
													     </select><span style="color:red;">*</span>
												   
										    </td>  
								    </tr>
					 			   <tr>
					 				      <td nowrap align="right" nowrap>工龄:</td>
										    <td nowrap>
											    <input name="form.emp_nworknum" id="emp_nworknum" value="" maxlength="3"    onkeyup="value=value.replace(/[^\d]/g,'')"  class="text" style="width:105px"  valid="required|isNum" errmsg="工龄不能为空!|工龄只能输入整数!" />
											     <span style="color:red;">*</span>
										    </td>
					 			
					 			    </tr>
					 			   <tr>	   
										   <td nowrap align="right" nowrap>联系电话（内线）:</td>
										    <td nowrap><input name="form.emp_steleinner" id="emp_steleinner"   maxlength="25" onkeyup="value=value.replace(/[^\d]/g,'')" maxlength="50"   class="text" style="width:154px" />
										    
										    <span style="color:red;"  id="errMsg_emp_steleinner"></span>
										   </td>
								     
					    					<td nowrap align="right" nowrap>联系电话（外线）:</td>
										    <td nowrap><input name="form.emp_steleout" id="emp_steleout"    valid="isPhone" errmsg="电话输入格式不正确"  onkeyup="value=value.replace(/[^\-\d]/g,'')"  maxlength="14" class="text" style="width:154px"  />
										  
										    <span style="color:red;"  id="errMsg_emp_steleout"></span>
										   </td>
									</tr>
					    			
					    			<tr>   
										   <td nowrap align="right" nowrap>手机号码:</td>
										    <td nowrap><input name="form.emp_stele" id="emp_stele" value="" maxlength="11"   valid="isMobile" errmsg="手机输入格式不正确" onkeyup="value=value.replace(/[^\d]/g,'')"   class="text" style="width:154px"  />
										   
										    <span style="color:red;"  id="errMsg_emp_stele"></span>
										    </td>
										
										    <td nowrap align="right" nowrap>E-mail:</td>
										    <td nowrap><input name="form.emp_semail" id="emp_semail"    maxlength="50"  valid="isEmail" errmsg="E-mail输入格式不正确"  class="text" style="width:154px"  />
 
										    <span style="color:red;"  id="errMsg_emp_semail"></span>
										   </td>  
								    </tr>
					    				
					    			<tr>
					    				  <td nowrap align="right" nowrap>传真号码:</td>
										    <td nowrap><input name="form.emp_sfax" id="emp_sfax" value="" maxlength="14"  valid="isPhone" errmsg="传真号码格式输入不正确" onkeyup="value=value.replace(/[^\-\d]/g,'')"   class="text" style="width:154px"  />
										   
										    <span style="color:red;"  id="errMsg_emp_sfax"></span>
										   <input type="hidden"  id="emp_sreplyby" name="form.emp_sreplyby" value="${session.userInfo.screenname}"/>
										      	<input type="hidden"  id="emp_sisvalid" name="form.emp_sisvalid" value="0"/>
										      	<input type="hidden"  id="emp_sisdel" name="form.emp_sisdel" value="0"/>
					    			 
										   </td>
								    </tr>
					    			
					    			   
										     
										      	
					    	</table>
							</td>
      			</tr> 
			   	  <tr>
			 	      <td height="30" >
			 				<table width="100%" border="0" cellspacing="0" cellpadding="0" onclick="show1()">
			   					<tr>
			     					<td height="24" bgcolor="#0E6BB1">
			     						<table width="100%" border="0" cellspacing="0" cellpadding="0">
			       							<tr>
			         							<td>
			         								<table width="100%" border="0" cellspacing="0" cellpadding="0">
			           									<tr>
			             									<td width="6%" height="19" valign="bottom"><div align="center"><img src="<%=path %>/images/tb.gif" width="14" height="14" /></div></td>
			             									<td width="94%" valign="bottom"><span class="STYLE1">个人信息</span></td>
			           									</tr>
			         								</table>
			         							</td>
			         							<td><div align="right"><span class="STYLE1">&nbsp;</span><span class="STYLE1"> &nbsp;</span></div>
			           							</td>
			       							</tr>
			     						</table>
			     					</td>
			   					</tr>
			 				</table>
			 			</td>
			 	</tr>
    			
	    		<tr bgcolor="#FFFFFF" id="show1" style="display:none">
	     					<td   bgcolor="#FFFFFF">
	     					    <table border="0" cellpadding="2" cellspacing="1" style="width:100%;height:100%;font-size:12px;font-family: Verdana, Arial, Helvetica, sans-serif;"  bgcolor="#E3E9EE">
			 			               <tr>  
											    <td nowrap align="right" width="15%" nowrap>身高:</td>
											    <td nowrap   width="35%">
											    		<input name="form.emp_nlenght" id="emp_nlenght" onkeyup="value=value.replace(/[^\.\d]/g,'')"  maxlength="4" class="text" style="width:100px" />米
											   
											    	<span style="color:red;"  id="errMsg_emp_nlenght"></span>
											   	</td>
											
											   		<td nowrap align="right"  width="15%" nowrap>籍贯:</td>
											    	<td nowrap>
											    			<input name="form.emp_scity" id="emp_scity"  maxlength="50"   class="text" style="width:154px"   />
					 
											   </td>   
									    </tr>
						    			
						 			    <tr>
										     <td nowrap align="right" nowrap>出生日期:</td>
											  <td nowrap>
											    		<input name="form.emp_dbirthday" id="emp_dbirthday" onfocus="WdatePicker({maxDate:'%y-%M-{%d}'})" value=""   class="text" style="width:154px"  />
													   
													  
											   </td>
											   
											   	<td nowrap align="right" nowrap>出生地址:</td>
											    <td nowrap>
											    		<input name="form.emp_sadder" id="emp_sadder" maxlength="100"  class="text" style="width:154px"  />
													  
											   </td>
									     </tr>
									      <tr>
						    				  <td nowrap align="right" nowrap>婚否:</td>
											  <td nowrap>
											    	 <select name="form.emp_sisyf" id="emp_sisyf"  style="width:110px" > 
			          										<option value="">--请选择--</option>
					                 						 <option value="0">未婚</option>
											          		  <option value="1">已婚</option>
											          		  <option value="2">离婚</option>
			                 						</select>
											    <span style="color:red;"  id="errMsg_emp_sisyf"></span>
											   </td>
										 </tr>
										 <tr>
							    				<td nowrap align="right" nowrap>学历:</td>
												    <td nowrap>
												    <select name="form.emp_sstype" id="emp_sstype"  style="width:110px"> 
		          										<option value="">--请选择--</option>
		          									 
		                 								</select>
												    </td>
												
												   <td nowrap align="right" nowrap>毕业学院:</td>
												    <td nowrap  >
												    	<input name="form.emp_school" id="emp_school"  value="" maxlength="50"  class="text" style="width:154px" />
												    </td>
										     </tr>
										 
						    			     <tr>
								    				 <td nowrap align="right" nowrap>教育经历:</td>
													  <td colspan="4">
													  <textarea  valid="limit" id="smem1"   errmsg="备注最多不能超过250字符！" id="emp_smem1" name="form.emp_smem1" rows="4" cols="80"   ></textarea>
								                      </td>  
									     	</tr>
									     
									      <tr>
						    				  <td nowrap align="right" nowrap>工作经历:</td>
											  <td colspan="4">
											  		<textarea valid="limit" id="smem"  errmsg="备注最多不能超过250字符！"  id="emp_smem" name="form.emp_smem" rows="4" cols="80"   > </textarea>
						                       </td> 
										  </tr>
			 			       </table>
			 		      </td>
				</tr>
				 
				  <tr>
			    	 <td height="30" >
			    				<table width="100%" border="0" cellspacing="0" cellpadding="0" onclick="show2()">
			      					<tr>
			        					<td height="24" bgcolor="#0E6BB1">
			        						<table width="100%" border="0" cellspacing="0" cellpadding="0">
			          							<tr>
			            							<td>
			            								<table width="100%" border="0" cellspacing="0" cellpadding="0" >
			              									<tr>
			                									<td width="6%" height="19" valign="bottom"><div align="center"><img src="<%=path %>/images/tb.gif" width="14" height="14" /></div></td>
			                									<td width="94%" valign="bottom"><span class="STYLE1">家庭信息</span></td>
			              									</tr>
			            								</table>
			            							</td>
			            							<td><div align="right"><span class="STYLE1">&nbsp;</span><span class="STYLE1"> &nbsp;</span></div>
			              							</td>
			          							</tr>
			        						</table>
			        					</td>
			      					</tr>
			    				</table>
			    	</td>
			    </tr>
    	
    			
    			<tr bgcolor="#FFFFFF" id="show2" style="display:none">
     					<td   bgcolor="#FFFFFF">
     					    <table border="0" cellpadding="2" cellspacing="1" style="width:100%;height:100%;font-size:12px;font-family: Verdana, Arial, Helvetica, sans-serif;"  bgcolor="#E3E9EE">
		 			            <tr>   
									 <td nowrap align="right"  width="15%" nowrap>是否户主:</td>
										  <td nowrap  width="35%"> 
												  <select name="form.emp_sishz" id="emp_sishz"  style="width:110px"> 
		          										 <option value="">--请选择--</option>
		                 								  <option value="0">主户主</option>
										          		  <option value="1">副户主</option>
										          		  <option value="2">其他</option>
                 									</select>
										  </td>
								         
								         <td nowrap align="right"  width="15%" nowrap>是否独生子女户:</td>
										    <td nowrap> 
										   		 <input id="emp_sisdsz1" type="radio" value="0" name="form.emp_sisdsz" runat="server"  />是 &nbsp;
    		   						       		 <input id="emp_sisdsz2" type="radio" value="1" name="form.emp_sisdsz" runat="server" />否
										   		 <span style="color:red;"  id="errMsg_us_sno"></span>
										   </td>
					    				  
									 </tr>
					    			
					    			  <tr> 	   
										   <td nowrap align="right" nowrap>配偶是否在附属单位:</td>
										    <td nowrap>
										    <select name="form.emp_sisfsdw" id="emp_sisfsdw"  style="width:110px" onchange="sisfsdw(this.value);"> 
          										<option value="">--请选择--</option>
          										<option value="0">不在本单位</option>
								          		<option value="1">本单位</option>
								          		<option value="2">附属单位</option>
								          	</select>
										    <span style="color:red;"  id="errMsg_emp_sisfsdw"></span>
										   </td>
										
										 <td nowrap align="right" nowrap>配偶姓名:</td>
										    <td nowrap>
										    <input name="form.emp_sfname" id="emp_sfname" value=""   class="text" readonly />
										    <input name="form.emp_sfno" id="emp_sfno"    type="hidden" class="hidden"  />
										    <input  style="display:none;" type="button" class="select_button" id="sfno" onclick="empTree('emp_sfno','emp_sfname');" />
										   </td>
										  
										      
								      </tr>
					    			
					    		 <tr>
					    			 <td nowrap align="right" nowrap>子女是否在本单位:</td>
									 <td nowrap>
										   <select name="form.emp_siszrbdw" id="emp_siszrbdw"  style="width:110px" onchange="sisfzrbdw(this.value);"> 
          										<option value="">--请选择--</option>
          										<option value="0">其它</option>
								          		<option value="1">外单位</option>
								          		<option value="2">本单位</option>
								          		<option value="3">附属单位</option>
                 								</select>
										 </td>
										<td nowrap align="right" nowrap>子女员工编号:</td>
										    <td nowrap>
										    <input name="form.emp_szrno" id="emp_szrno"    class="text" style="width:154px" readonly="readonly" />
										    <input type="hidden"" id="emp_szrnoname"   class="text" style="width:154px" />
										 	 <input style="display:none;" type="button" class="select_button" id="szr" onclick="empTree('emp_szrno','emp_szrnoname');" />
										 </td>
								 </tr>
					    			
					    	  </table>
		 		      </td>
				 </tr>
				 
				 <tr>
				  <td height="30" >
    				<table width="100%" border="0" cellspacing="0" cellpadding="0" onclick="show3()">
      					<tr>
        					<td height="24" bgcolor="#0E6BB1">
        						<table width="100%" border="0" cellspacing="0" cellpadding="0">
          							<tr>
            							<td>
            								<table width="100%" border="0" cellspacing="0" cellpadding="0">
              									<tr>
                									<td width="6%" height="19" valign="bottom"><div align="center"><img src="<%=path %>/images/tb.gif" width="14" height="14" /></div></td>
                									<td width="94%" valign="bottom"><span class="STYLE1">薪资待遇</span></td>
              									</tr>
            								</table>
            							</td>
            							<td><div align="right"><span class="STYLE1">&nbsp;</span><span class="STYLE1"> &nbsp;</span></div>
              							</td>
          							</tr>
        						</table>
        					</td>
      					</tr>
    				</table>
    			</td>
    			</tr>
    			
    			<tr bgcolor="#FFFFFF" id="show3" style="display:none">
     					<td   bgcolor="#FFFFFF">
     					    <table border="0" cellpadding="2" cellspacing="1" style="width:100%;height:100%;font-size:12px;font-family: Verdana, Arial, Helvetica, sans-serif;"  bgcolor="#E3E9EE">
		 			        	   <tr> 		   
										  <td nowrap align="right"  width="15%" nowrap>是否高级人才引进:</td>
										    <td nowrap  width="35%">
											    <input id="emp_sisgjrc1" type="radio" value="0" name="form.emp_sisgjrc" runat="server"  checked="checked" />是 &nbsp;
	    		   						        <input id="emp_sisgjrc2" type="radio" value="1" name="form.emp_sisgjrc" runat="server" />否
										        <span style="color:red;"  id="errMsg_emp_sisgjrc"></span>
										   </td>
								   
										
										    <td nowrap align="right"  width="15%" nowrap>当前工资:</td>
										    <td nowrap>
												    <input name="form.emp_nprice" id="emp_nprice" maxlength="18"  onkeyup="value=value.replace(/[^\.\d]/g,'')" class="text" style="width:154px" />
									        </td>
										   
								       </tr>
					    			
					    			   <tr>
					    				    <td nowrap align="right" nowrap>一次补贴总金额:</td>
										     <td nowrap>
										     <input name="form.emp_nfbsum" id="emp_nfbsum" maxlength="18" onkeyup="value=value.replace(/[^\.\d]/g,'')"   class="text" style="width:154px" />
										    </td>
										
										    <td nowrap align="right" nowrap>一次补贴时间:</td>
										    <td nowrap>
										    <input name="form.emp_dfbdate" id="emp_dfbdate" maxlength="18"  onfocus="WdatePicker({maxDate:'%y-%M-{%d}'})" class="text" style="width:154px" />
										     </td>
										 </tr>
					    			
					    			   <tr>    
										    <td nowrap align="right" nowrap>总补贴金额:</td>
										     <td nowrap>
										        <input name="form.emp_nsum" id="emp_nsum" maxlength="18" onkeyup="value=value.replace(/[^\.\d]/g,'')"  class="text" style="width:154px"  />
								 			  </td>
								    
					    				     <td nowrap align="right" nowrap>房屋补贴是每月工资的:</td>
										     <td nowrap>
										    		<input name="form.emp_nfblevel" id="emp_nfblevel" maxlength="18"onkeyup="value=value.replace(/[^\.\d]/g,'')"  class="text" style="width:154px" />%
							 				   </td>
									  </tr>
					    			
					    			   <tr>    
										    <td nowrap align="right" nowrap>开始补贴日期:</td>
										    <td nowrap>
										       <input name="form.emp_dsbddate" id="emp_dsbddate"     onfocus="WdatePicker({dateFmt:'yyyy-MM-dd'})" class="text" style="width:154px"   />
							 				 </td>
										
										    <td nowrap align="right" nowrap>已补贴金额:</td>
										    <td nowrap>
										       <input name="form.emp_nybsum" id="emp_nybsum"  maxlength="18"  onkeyup="value=value.replace(/[^\.\d]/g,'')" class="text" style="width:154px"  />
											</td> 
								       </tr>
					    				       
					    			    <tr>
										    <td nowrap align="right" nowrap>住房房号号:</td>
										     <td nowrap>
										     		<input name="form.emp_sfjno" id="emp_sfjno"  maxlength="25"   class="text" style="width:154px" />
										     </td> 
								
										   <td nowrap align="right" nowrap>门禁卡号:</td>
										    <td nowrap>
										   			 <input name="form.emp_scardcode" id="emp_scardcode" maxlength="50"   class="text" style="width:154px" />
										     </td> 
										 </tr>
								       
					    			
					    			   <tr>
					    					 <td nowrap align="right" nowrap>住房类型:</td>
										     <td nowrap> 
												    <select name="form.emp_shwtype" id="emp_shwtype"  style="width:110px"> 
			          									<option value="">--请选择--</option>
			          										<option value="0">无房</option>
											          		<option value="1">校集中房</option>
											          		<option value="2">散户</option>
										          	</select> 
										     
										       </td>
										
										
										       <td nowrap align="right" nowrap>房屋补贴类型:</td>
										        <td nowrap>
 												    <select name="form.emp_sfbtype" id="emp_sfbtype"  style="width:110px"> 
		          										<option value="">--请选择--</option>
		          										<option value="0">无补贴</option>
										          		<option value="1">一次性补贴</option>
										          		<option value="2">每月补贴</option>
								          		 </select> 
 											    </td> 
									      </tr>
					    			
					    			
					    			       <tr>   
					    					   <td nowrap align="right" nowrap>供暖核算方法:</td>
										       <td nowrap> 
												    <select name="form.emp_sgltype" id="emp_sgltype"  style="width:110px"> 
		          										<option value="">--请选择--</option>
		          										<option value="0">按建筑面积算</option>
										          		<option value="1">按使用面积算</option>
										          		<option value="2">不支付暖费</option>
		                 								</select>
										      </td>
								    
					    				      <td nowrap align="right" nowrap>供暖单价:</td>
										      <td nowrap>
										     			<input name="form.emp_nglprice" id="emp_nglprice" maxlength="18" onkeyup="value=value.replace(/[^\.\d]/g,'')"  class="text" style="width:154px" />元
										       </td>
										  </tr>
					    			
					    				<tr>   
											   <td nowrap align="right" nowrap>物业费金额:</td>
											    <td nowrap>
											    		<input name="form.emp_nwysum" id="emp_nwysum" maxlength="18"onkeyup="value=value.replace(/[^\.\d]/g,'')"  class="text" style="width:154px"   />元
											   </td>
									   </tr> 
						      </table>
							</td>
      					</tr>
    				</table>
    				<table width="100%" border="0" cellspacing="0" cellpadding="0">
      				<tr>
        				<td  colspan="5" nowrap>
        					<div align="center">
        					  <input type="button" value="保存" class="button" onclick="save();"/>&nbsp;
        					  <input type="button" value="重置" class="button" onclick="resetDiv();"/>&nbsp;
        					  <input type="button" value="返回" class="button" onclick="window.history.go(-1);"  />
        					</div>
						</td>
      				</tr>
    				</table>
    			</td>
  			</tr>
		</table>
    </div>
  

</div>
    <input type="hidden" name="us_sreplyby" value=""/>
<input type="hidden"  name="menu" id="menu" value="<s:property value="menu"/>" />


 
 </form>
 <script type="text/javascript">
	var xksMem = document.getElementById("smem");
	var xksMem1 = document.getElementById("smem1");
	xksMem.onpropertychange = function(){
   	  if(xksMem.value.length > 220){
       	  alert("超出字符串长度限制");
       	  var str = xksMem.value.substring(0, 220);
       	  xksMem.value = str;
         }
         }
	xksMem1.onpropertychange = function(){
	   	  if(xksMem1.value.length > 220){
	       	  alert("超出字符串长度限制");
	       	  var str = xksMem1.value.substring(0, 220);
	       	  xksMem1.value = str;
	         }
	         }
	
	function obj(){
         if(xksMem.value.length > 220){
         var str = xksMem.value.substring(0,220);
         xksMem.value = str;
        }
         if(xksMem1.value.length > 220){
             var str = xksMem1.value.substring(0,220);
             xksMem1.value = str;
            }
	}
	 
</script>
  </body>
</html>

 