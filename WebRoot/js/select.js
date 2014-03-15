/**
 * 系统下拉框
 * @param no 系统编号 sysint_sno
 * @param tagName 标签ID
 * @param path 工程路径
 */
function getSysSelect(no,tagName,path){
	var flag = false; 
	var dataPath = "form.sysint_sno="+no; 
	$.ajax({
		async:false,//同步
		type:"post",//post方式提交
		url:path+"/tree!selectSys",//提交地址
		data:dataPath,
		dataType:"html",
		success:function(data){
				$('#'+tagName).empty();
				$('#'+tagName).append("<option value=''></option>");
      			$('#'+tagName).append(data);
      			flag = true;
		},
		error:function(){
			$('#'+tagName).empty();
			$('#'+tagName).append("<option value='' style='color:red'>数据错误！</option>") ;
			flag =  false;
		}
	}); 
	return flag;
}
/**
 * 员工下拉框
 * @param no 员工NO emp_sno
 * @param tagName 标签ID
 * @param path 工程路径
 */
function getEmpSelect(no,tagName,path,compno,depno,jobno,classno,teamno){
	var flag = false; 
	var dataPath = "form.emp_sno="+no; 
	if(compno!=undefined&&compno!=null&&compno!=""){
		dataPath+="&form.comp_sno="+compno;
	}
	if(depno!=undefined&&depno!=null&&depno!=""){
		dataPath+="&form.dep_sno="+depno;
	}
	if(jobno!=undefined&&jobno!=null&&jobno!=""){
		dataPath+="&form.job_sno="+jobno;
	}
	if(classno!=undefined&&classno!=null&&classno!=""){
		dataPath+="&form.class_sno="+classno;
	}
	if(teamno!=undefined&&teamno!=null&&teamno!=""){
		dataPath+="&form.team_sno="+teamno;
	} 
	$.ajax({
		async:false,//同步
		type:"post",//post方式提交
		url:path+"/tree!selectEmp",//提交地址
		data:dataPath,
		dataType:"html",
		success:function(data){
				$('#'+tagName).empty();
				$('#'+tagName).append("<option value=''>--请选择--</option>");
      			$('#'+tagName).append(data);
      			flag = true;
		},
		error:function(){
			$('#'+tagName).empty();
			$('#'+tagName).append("<option style='color:red'>数据错误！</option>") ;
			flag =  false;
		}
	}); 
	return flag;
}

/**
 * 单位下拉框
 * @param no 单位NO  
 * @param tagName 标签ID
 * @param path 工程路径
 */
function getCompSelect(no,tagName,path,compno){
	var flag = false; 
	var dataPath = "form.comp_sno="+no;
	if(compno!=undefined&&compno!=null&&compno!=""){
		dataPath+="&form.comp_ssuper="+compno;
	} 
	$.ajax({
		async:false,//同步
		type:"post",//post方式提交
		url:path+"/tree!selectComp",//提交地址
		data:dataPath,
		dataType:"html",
		success:function(data){
			$('#'+tagName).empty();
			$('#'+tagName).append("<option value=''>--请选择--</option>");
      			$('#'+tagName).append(data);
      			flag = true;
		},
		error:function(){
			$('#'+tagName).empty();
			$('#'+tagName).append("<option style='color:red'>数据错误！</option>") ;
			flag =  false;
		}
	}); 
	return flag;
}

/**
 * 部门下拉框
 * @param no 部门NO  
 * @param tagName 标签ID
 * @param path 工程路径
 */
function getDepSelect(no,tagName,path,compno ){
	var flag = false; 
	var dataPath = "form.dep_sno="+no;
	if(compno!=undefined&&compno!=null&&compno!=""){
		dataPath+="&form.comp_sno="+compno;
	}
	 
	$.ajax({
		async:false,//同步
		type:"post",//post方式提交
		url:path+"/tree!selectDep",//提交地址
		data:dataPath,
		dataType:"html",
		success:function(data){
			$('#'+tagName).empty();
			$('#'+tagName).append("<option value=''>--请选择--</option>");
      			$('#'+tagName).append(data);
      			flag = true;
		},
		error:function(){
			$('#'+tagName).empty();
			$('#'+tagName).append("<option style='color:red'>数据错误！</option>") ;
			flag =  false;
		}
	}); 
	return flag;
}

/**
 * 岗位下拉框
 * @param no 岗位NO  
 * @param tagName 标签ID
 * @param path 工程路径
 */
function getJobSelect(no,tagName,path,depno){
	var flag = false; 
	var dataPath = "form.job_sno="+no;
	 
	if(depno!=undefined&&depno!=null&&depno!=""){
		dataPath+="&form.dep_sno="+depno;
	}
	 
	$.ajax({
		async:false,//同步
		type:"post",//post方式提交
		url:path+"/tree!selectJob",//提交地址
		data:dataPath,
		dataType:"html",
		success:function(data){
			$('#'+tagName).empty();
			$('#'+tagName).append("<option value=''>--请选择--</option>");
      			$('#'+tagName).append(data);
      			flag = true;
		},
		error:function(){
			$('#'+tagName).empty();
			$('#'+tagName).append("<option style='color:red'>数据错误！</option>") ;
			flag =  false;
		}
	}); 
	return flag;
}

/**
 * 班组下拉框
 * @param no 班组NO 
 * @param tagName 标签ID
 * @param path 工程路径
 */
function getClassSelect(no,tagName,path,depno){
	var flag = false; 
	var dataPath = "form.class_sno="+no; 
	if(depno!=undefined&&depno!=null&&depno!=""){
		dataPath+="&form.dep_sno="+depno;
	} 
	$.ajax({
		async:false,//同步
		type:"post",//post方式提交
		url:path+"/tree!selectClass",//提交地址
		data:dataPath,
		dataType:"html",
		success:function(data){
			$('#'+tagName).empty();
			$('#'+tagName).append("<option value=''>--请选择--</option>");
      			$('#'+tagName).append(data);
      			flag = true;
		},
		error:function(){
			$('#'+tagName).empty();
			$('#'+tagName).append("<option style='color:red'>数据错误！</option>") ;
			flag =  false;
		}
	}); 
	return flag;
}

/**
 * 团队下拉框
 * @param no 团队NO 
 * @param tagName 标签ID
 * @param path 工程路径
 */
function getTeamSelect(no,tagName,path,classno){
	var flag = false; 
	var dataPath = "form.team_sno="+no; 
	if(classno!=undefined&&classno!=null&&classno!=""){
		dataPath+="&form.class_sno="+classno;
	} 
	$.ajax({
		async:false,//同步
		type:"post",//post方式提交
		url:path+"/tree!selectTeam",//提交地址
		data:dataPath,
		dataType:"html",
		success:function(data){
			$('#'+tagName).empty();
			$('#'+tagName).append("<option value=''>--请选择--</option>");
      			$('#'+tagName).append(data);
      			flag = true;
		},
		error:function(){
			$('#'+tagName).empty();
			$('#'+tagName).append("<option style='color:red'>数据错误！</option>") ;
			flag =  false;
		}
	}); 
	return flag;
}
/**
 * 数据字典下拉框
 * @param value 字典项值
 * @param tagName 标签ID
 * @param name 字典名
 * @param sysint_sno 所属系统	所属系统（公共类为空）
 * @param dictType 字典类型 0.系统字典 1.用户字典
 * @param path 工程路径
 */
function getDictSelect(value,tagName,name,sysint_sno,dictType,path){
	var flag = false; 
	var dataPath = "form.ditem_svalue="+value;
	dataPath+="&form.dict_sname="+name;
	dataPath+="&form.dict_ntype="+dictType;

	if(sysint_sno!=undefined&&sysint_sno!=null&&sysint_sno!=""){
		dataPath+="&form.sysint_sno="+sysint_sno;
	}
	$.ajax({
		async:false,//同步
		type:"post",//post方式提交
		url:path+"/tree!selectDict",//提交地址
		data:dataPath,
		dataType:"html",
		success:function(data){	
			$('#'+tagName).empty();
			$('#'+tagName).append("<option value=''></option>");
      			$('#'+tagName).append(data);
      			flag = true;
		},
		error:function(){
			$('#'+tagName).empty();
			$('#'+tagName).append("<option style='color:red'>数据错误！</option>") ;
			flag =  false;
		}
	}); 
	return flag;
	 
}

/**
 * 客户类别下拉框
 * @param no 客户类别NO 
 * @param tagName 标签ID
 * @param path 工程路径
 */
function getCtypeSelect(no,tagName,path){
	var flag = false; 
	var dataPath = "form.ctype_sno="+no; 
	$.ajax({
		async:false,//同步
		type:"post",//post方式提交
		url:path+"/tree!selectCtype",//提交地址
		data:dataPath,
		dataType:"html",
		success:function(data){
			$('#'+tagName).empty();
			$('#'+tagName).append("<option value=''>--请选择--</option>");
      			$('#'+tagName).append(data);
      			flag = true;
		},
		error:function(){
			$('#'+tagName).empty();
			$('#'+tagName).append("<option style='color:red'>数据错误！</option>") ;
			flag =  false;
		}
	}); 
	return flag;
}
/**
 * 合作企业类别下拉框
 * @param no 合作企业NO 
 * @param tagName 标签ID
 * @param path 工程路径
 */
function getCooptSelect(no,tagName,path ){
	var flag = false; 
	var dataPath = "form.coopt_sno="+no;  
	$.ajax({
		async:false,//同步
		type:"post",//post方式提交
		url:path+"/tree!selectCoopt",//提交地址
		data:dataPath,
		dataType:"html",
		success:function(data){
			$('#'+tagName).empty();
			$('#'+tagName).append("<option value=''>--请选择--</option>");
      			$('#'+tagName).append(data);
      			flag = true;
		},
		error:function(){
			$('#'+tagName).empty();
			$('#'+tagName).append("<option style='color:red'>数据错误！</option>") ;
			flag =  false;
		}
	}); 
	return flag;
}

/**
 * 教研组下拉框
 * @param no 岗位NO  
 * @param tagName 标签ID
 * @param path 工程路径
 */
function getTeachGroupSelect(no,tagName,path,udno){
	var flag = false; 
	var dataPath = "form.tg_sno="+no;
	 
	if(udno!=undefined&&udno!=null&&udno!=""){
		dataPath+="&form.ud_sno="+udno;
	}
	 
	$.ajax({
		async:false,//同步
		type:"post",//post方式提交
		url:path+"/tree!selectTeachGroup",//提交地址
		data:dataPath,
		dataType:"html",
		success:function(data){
			$('#'+tagName).empty();
			$('#'+tagName).append("<option value=''>--请选择--</option>");
      			$('#'+tagName).append(data);
      			flag = true;
		},
		error:function(){
			$('#'+tagName).empty();
			$('#'+tagName).append("<option style='color:red'>数据错误！</option>") ;
			flag =  false;
		}
	}); 
	return flag;
}

/**
 * 放大镜
 * @param text1 第一个返回值
 * @param text2 第二个返回值
 * text1,text2,text3,text4,text5,text6,text7,text8,text9,text10
 * @param path  放大镜地址
 * @param Height 高度
 * @param Width 宽度
 */
function tree1(text1,text2,text3,text4,text5,text6,text7,text8,text9,text10,path,Height,Width)
{
	var obj = [document.getElementById(text1),document.getElementById(text2),document.getElementById(text3),document.getElementById(text4),document.getElementById(text5),document.getElementById(text6),document.getElementById(text7),document.getElementById(text8),document.getElementById(text9),document.getElementById(text10)];
	if(Height==undefined)
	{
		Height = '500px';
	}
	if(Width==undefined)
	{
		Width = '760px';
	}
	if(path==undefined){
		path="";
	} 
	var returnValue = window.showModalDialog(path,'','dialogHeight:'+Height+';dialogWidth:'+Width+';center:yes;help:no;resizable:no;status:no;scroll:no;location:no;');
	if (returnValue == undefined) {
	    returnValue = window.returnValue;
	}
	if(returnValue!="default"&&returnValue!=undefined&&returnValue!=null&&returnValue!="")
	{
		backReturnValue1(returnValue,text1,text2,text3,text4,text5,text6,text7,text8,text9,text10);
	}else
	{
		backReturnValue2(text1,text2,text3,text4,text5,text6,text7,text8,text9,text10);
	}}



/**
 * 放大镜
 * @param text1 第一个返回值
 * @param text2 第二个返回值
 * text1,text2,text3,text4,text5,text6,text7,text8,text9,text10
 * @param path  放大镜地址
 * @param Height 高度
 * @param Width 宽度
 */
function treeagency(text1,text2,text3,text4,text5,text6,text7,text8,text9,path,Height,Width)
{
	var obj = [document.getElementById(text1),document.getElementById(text2),document.getElementById(text3),document.getElementById(text4),document.getElementById(text5),document.getElementById(text6),document.getElementById(text7),document.getElementById(text8),document.getElementById(text9)];
	if(Height==undefined)
	{
		Height = '500px';
	}
	if(Width==undefined)
	{
		Width = '760px';
	}
	if(path==undefined){
		path="";
	} 
	var returnValue = window.showModalDialog(path,'','dialogHeight:'+Height+';dialogWidth:'+Width+';center:yes;help:no;resizable:no;status:no;scroll:no;location:no;');
	if (returnValue == undefined) {
	    returnValue = window.returnValue;
	}
	if(returnValue!="default"&&returnValue!=undefined&&returnValue!=null&&returnValue!="")
	{
		backReturnValue1(returnValue,text1,text2,text3,text4,text5,text6,text7,text8,text9);
	}else
	{
		backReturnValue2(text1,text2,text3,text4,text5,text6,text7,text8,text9);
	}}
/**
 * 放大镜
 * @param text1 第一个返回值
 * @param text2 第二个返回值
 * text1,text2,text3,text4,text5,text6,text7
 * @param path  放大镜地址
 * @param Height 高度
 * @param Width 宽度
 */
function tree4(text1,text2,text3,text4,text5,text6,text7,text8,path,Height,Width)
{
	var obj = [document.getElementById(text1),document.getElementById(text2),document.getElementById(text3),document.getElementById(text4),document.getElementById(text5),document.getElementById(text6),document.getElementById(text7),document.getElementById(text8)];
	if(Height==undefined)
	{
		Height = '500px';
	}
	if(Width==undefined)
	{
		Width = '760px';
	}
	if(path==undefined){
		path="";
	} 
	var returnValue = window.showModalDialog(path,'','dialogHeight:'+Height+';dialogWidth:'+Width+';center:yes;help:no;resizable:no;status:no;scroll:no;location:no;');
	if (returnValue == undefined) {
	    returnValue = window.returnValue;
	}
	if(returnValue!="default"&&returnValue!=undefined&&returnValue!=null&&returnValue!="")
	{
		backReturnValue1(returnValue,text1,text2,text3,text4,text5,text6,text7,text8);
	}else
	{
		backReturnValue2(text1,text2,text3,text4,text5,text6,text7,text8);
	}
}
/**
 * 放大镜
 * @param text1 第一个返回值
 * @param text2 第二个返回值
 * text1,text2,text3,text4,text5,text6,text7，text8,text9,text10,text11,text12,text13,text14
 * @param path  放大镜地址
 * @param Height 高度
 * @param Width 宽度  ,text3,text4,text5,text6,text7,text8,text9,text10,text11,text12,text13,text14
 */
function tree5(text1,text2,text3,text4,text5,text6,text7,text8,text9,text10,text11,text12,text13,text14,text15,text16,path,Height,Width)
{//,document.getElementById(text3),document.getElementById(text4),document.getElementById(text5),document.getElementById(text6),document.getElementById(text7),document.getElementById(text8),document.getElementById(text9),document.getElementById(text10),document.getElementById(text11),document.getElementById(text12),document.getElementById(text13),document.getElementById(text14)
	var obj = [document.getElementById(text1),document.getElementById(text2),document.getElementById(text3),document.getElementById(text4),document.getElementById(text5),document.getElementById(text6),document.getElementById(text7),document.getElementById(text8),document.getElementById(text9),document.getElementById(text10),document.getElementById(text11),document.getElementById(text12),document.getElementById(text13),document.getElementById(text14),document.getElementById(text15),document.getElementById(text16)];
	if(Height==undefined)
	{
		Height = '500px';
	}
	if(Width==undefined)
	{
		Width = '760px';
	}
	if(path==undefined){
		path="";
	} 
	alert(path);
	var returnValue = window.showModalDialog(path,'','dialogHeight:'+Height+';dialogWidth:'+Width+';center:yes;help:no;resizable:no;status:no;scroll:no;location:no;');
	if (returnValue == undefined) {
	    returnValue = window.returnValue;
	}
	if(returnValue!="default"&&returnValue!=undefined&&returnValue!=null&&returnValue!="")
	{
		backReturnValue1(returnValue,text1,text2,text3,text4,text5,text6,text7,text8,text9,text10,text11,text12,text13,text14,text15,text16);
	}else
	{
		backReturnValue2(text1,text2,text3,text4,text5,text6,text7,text8,text9,text10,text11,text12,text13,text14,text15,text16);
	}
}
/**
 * 放大镜
 * @param text1 第一个返回值
 * @param text2 第二个返回值
 * text1,text2,text3,text4,text5,text6,text7，text8,text9,text10,text11,text12,text13,text14
 * @param path  放大镜地址
 * @param Height 高度
 * @param Width 宽度  ,text3,text4,text5,text6,text7,text8,text9,text10,text11,text12,text13,text14
 */
function tree7(text1,text2,text3,text4,text5,text6,text7,text8,text9,text10,text11,text12,text13,path,Height,Width)
{//,document.getElementById(text3),document.getElementById(text4),document.getElementById(text5),document.getElementById(text6),document.getElementById(text7),document.getElementById(text8),document.getElementById(text9),document.getElementById(text10),document.getElementById(text11),document.getElementById(text12),document.getElementById(text13),document.getElementById(text14)
	var obj = [document.getElementById(text1),document.getElementById(text2),document.getElementById(text3),document.getElementById(text4),document.getElementById(text5),document.getElementById(text6),document.getElementById(text7),document.getElementById(text8),document.getElementById(text9),document.getElementById(text10),document.getElementById(text11),document.getElementById(text12),document.getElementById(text13)];
	if(Height==undefined)
	{
		Height = '500px';
	}
	if(Width==undefined)
	{
		Width = '760px';
	}
	if(path==undefined){
		path="";
	} 
	var returnValue = window.showModalDialog(path,'','dialogHeight:'+Height+';dialogWidth:'+Width+';center:yes;help:no;resizable:no;status:no;scroll:no;location:no;');
	if (returnValue == undefined) {
	    returnValue = window.returnValue;
	}
	if(returnValue!="default"&&returnValue!=undefined&&returnValue!=null&&returnValue!="")
	{
		backReturnValue1(returnValue,text1,text2,text3,text4,text5,text6,text7,text8,text9,text10,text11,text12,text13);
	}else
	{
		backReturnValue2(text1,text2,text3,text4,text5,text6,text7,text8,text9,text10,text11,text12,text13);
	}
}
/**
 * 放大镜
 * @param text1 第一个返回值
 * @param text2 第二个返回值
 * text1,text2,text3,text4,text5,text6,text7
 * @param path  放大镜地址
 * @param Height 高度
 * @param Width 宽度
 */
function tree8(text1,text2,text3,text4,text5,text6,text7,text8,text9,text10,text11,text12,text13,text14,text15,text16,text17,text18,text19,text20,text21,text22,text23,text24,text25,text26,text27,text28,path,Height,Width)
{
	var obj = [document.getElementById(text1),document.getElementById(text2),document.getElementById(text3),document.getElementById(text4),document.getElementById(text5),document.getElementById(text6),document.getElementById(text7),document.getElementById(text8),document.getElementById(text9),document.getElementById(text10),document.getElementById(text11),document.getElementById(text12),document.getElementById(text13),document.getElementById(text14),document.getElementById(text15),document.getElementById(text16),document.getElementById(text17),document.getElementById(text18),document.getElementById(text19),document.getElementById(text20),document.getElementById(text21),document.getElementById(text22),document.getElementById(text23),document.getElementById(text24),document.getElementById(text25),document.getElementById(text26),document.getElementById(text27),document.getElementById(text28)];
	if(Height==undefined)
	{
		Height = '500px';
	}
	if(Width==undefined)
	{
		Width = '760px';
	}
	if(path==undefined){
		path="";
	} 
	var returnValue = window.showModalDialog(path,'','dialogHeight:'+Height+';dialogWidth:'+Width+';center:yes;help:no;resizable:no;status:no;scroll:no;location:no;');
	if (returnValue == undefined) {
	    returnValue = window.returnValue;
	}
	if(returnValue!="default"&&returnValue!=undefined&&returnValue!=null&&returnValue!="")
	{
		backReturnValue1(returnValue,text1,text2,text3,text4,text5,text6,text7,text8,text9,text10,text11,text12,text13,text14,text15,text16,text17,text18,text19,text20,text21,text22,text23,text24,text25,text26,text27,text28);
	}else
	{
		backReturnValue2(text1,text2,text3,text4,text5,text6,text7,text8,text9,text10,text11,text12,text13,text14,text15,text16,text17,text18,text19,text20,text21,text22,text23,text24,text25,text26,text27,text28);
	}
}
function tree9(text1,text2,text3,text4,text5,text6,text7,path,Height,Width)
{
	var obj = [document.getElementById(text1),document.getElementById(text2),document.getElementById(text3),document.getElementById(text4),document.getElementById(text5),document.getElementById(text6),document.getElementById(text7)];
	if(Height==undefined)
	{
		Height = '500px';
	}
	if(Width==undefined)
	{
		Width = '760px';
	}
	if(path==undefined){
		path="";
	} 
	var returnValue = window.showModalDialog(path,'','dialogHeight:'+Height+';dialogWidth:'+Width+';center:yes;help:no;resizable:no;status:no;scroll:no;location:no;');
	if (returnValue == undefined) {
	    returnValue = window.returnValue;
	}
	if(returnValue!="default"&&returnValue!=undefined&&returnValue!=null&&returnValue!="")
	{
		backReturnValue1(returnValue,text1,text2,text3,text4,text5,text6,text7);
	}else
	{
		backReturnValue2(text1,text2,text3,text4,text5,text6,text7);
	}
}
function tree10(text1,text2,text3,text4,text5,text6,text7,text8,text9,text10,text11,text12,text13,path,Height,Width)
{
	var obj = [document.getElementById(text1),document.getElementById(text2),document.getElementById(text3),document.getElementById(text4),document.getElementById(text5),document.getElementById(text6),document.getElementById(text7),document.getElementById(text8),document.getElementById(text9),document.getElementById(text10),document.getElementById(text11),document.getElementById(text12),document.getElementById(text13)];
	if(Height==undefined)
	{
		Height = '500px';
	}
	if(Width==undefined)
	{
		Width = '760px';
	}
	if(path==undefined){
		path="";
	} 
	var returnValue = window.showModalDialog(path,'','dialogHeight:'+Height+';dialogWidth:'+Width+';center:yes;help:no;resizable:no;status:no;scroll:no;location:no;');
	//backReturnValue(returnValue,obj1);
	if (returnValue == undefined) {
	    returnValue = window.returnValue;
	}
	if(returnValue!="default"&&returnValue!=undefined&&returnValue!=null&&returnValue!="")
	{
		backReturnValue1(returnValue,text1,text2,text3,text4,text5,text6,text7,text8,text9,text10,text11,text12,text13);
	}else
	{
		backReturnValue2(text1,text2,text3,text4,text5,text6,text7,text8,text9,text10,text11,text12,text13);
	}
}
/**
 * 放大镜
 * @param text1 第一个返回值
 * @param text2 第二个返回值
 * text1,text2,text3,text4,text5,text6,text7
 * @param path  放大镜地址
 * @param Height 高度
 * @param Width 宽度
 */
function tree11(text1,text2,text3,text4,text5,path,Height,Width)
{
	var obj = [document.getElementById(text1),document.getElementById(text2),document.getElementById(text3),document.getElementById(text4),document.getElementById(text5)];
	if(Height==undefined)
	{
		Height = '500px';
	}
	if(Width==undefined)
	{
		Width = '760px';
	}
	if(path==undefined){
		path="";
	} 
	var returnValue = window.showModalDialog(path,'','dialogHeight:'+Height+';dialogWidth:'+Width+';center:yes;help:no;resizable:no;status:no;scroll:no;location:no;');
	var obj1 = text1,text2,text3,text4,text5,text6;
	//backReturnValue(returnValue,obj1);
	if (returnValue == undefined) {
	    returnValue = window.returnValue;
	}
	if(returnValue!="default"&&returnValue!=undefined&&returnValue!=null&&returnValue!="")
	{
		backReturnValue1(returnValue,text1,text2,text3,text4,text5);
	}else
	{
		backReturnValue2(text1,text2,text3,text4,text5);
	}
}
/**
 * 放大镜
 * @param text1 第一个返回值
 * @param text2 第二个返回值
 * text1,text2,text3,text4,text5,text6,text7
 * @param path  放大镜地址
 * @param Height 高度
 * @param Width 宽度
 */
function tree6(text1,text2,text3,text4,text5,text6,path,Height,Width)
{
	var obj = [document.getElementById(text1),document.getElementById(text2),document.getElementById(text3),document.getElementById(text4),document.getElementById(text5),document.getElementById(text6)];
	if(Height==undefined)
	{
		Height = '500px';
	}
	if(Width==undefined)
	{
		Width = '760px';
	}
	if(path==undefined){
		path="";
	} 
	//var returnValue = window.showModalDialog(path,obj,'dialogHeight:'+Height+';dialogWidth:'+Width+';center:yes;help:no;resizable:no;status:no;scroll:no;location:no;');
	var returnValue = window.showModalDialog(path,'','dialogHeight='+Height+';dialogWidth='+Width+';');
	var obj1 = text1,text2,text3,text4,text5,text6;
	//backReturnValue(returnValue,obj1);
	if (returnValue == undefined) {
	    returnValue = window.returnValue;
	}
	if(returnValue!="default"&&returnValue!=undefined&&returnValue!=null&&returnValue!="")
	{
		backReturnValue1(returnValue,text1,text2,text3,text4,text5,text6);
	}else
	{
		backReturnValue2(text1,text2,text3,text4,text5,text6);
	}
}

/**
 * 放大镜
 * @param text1 第一个返回值
 * @param text2 第二个返回值
 * text1,text2,text3
 * @param path  放大镜地址
 * @param Height 高度
 * @param Width 宽度
 */
function tree2(text1,text2,text3,path,Height,Width)
{
	var obj = [document.getElementById(text1),document.getElementById(text2),document.getElementById(text3)];
	if(Height==undefined)
	{
		Height = '500px';
	}
	if(Width==undefined)
	{
		Width = '760px';
	}
	if(path==undefined){
		path="";
	} 
	var returnValue = window.showModalDialog(path,'','dialogHeight:'+Height+';dialogWidth:'+Width+';center:yes;help:no;resizable:no;status:no;scroll:no;location:no;');
	var obj1 = text1,text2,text3,text4,text5,text6;
	//backReturnValue(returnValue,obj1);
	if (returnValue == undefined) {
	    returnValue = window.returnValue;
	}
	if(returnValue!="default"&&returnValue!=undefined&&returnValue!=null&&returnValue!="")
	{
		backReturnValue1(returnValue,text1,text2,text3);
	}else
	{
		backReturnValue2(text1,text2,text3);
	}
}
/**
 * 放大镜
 * @param text1 第一个返回值
 * @param text2 第二个返回值
 * text1,text2,text3,text4,
 * @param path  放大镜地址
 * @param Height 高度
 * @param Width 宽度
 */
function tree3(text1,text2,text3,text4,path,Height,Width)
{
	var obj = [document.getElementById(text1),document.getElementById(text2),document.getElementById(text3),document.getElementById(text4)];
	if(Height==undefined)
	{
		Height = '500px';
	}
	if(Width==undefined)
	{
		Width = '760px';
	}
	if(path==undefined){
		path="";
	} 
	var returnValue = window.showModalDialog(path,'','dialogHeight:'+Height+';dialogWidth:'+Width+';center:yes;help:no;resizable:no;status:no;scroll:no;location:no;');
	var obj1 = text1,text2,text3,text4,text5,text6;
	//backReturnValue(returnValue,obj1);
	if (returnValue == undefined) {
	    returnValue = window.returnValue;
	}
	if(returnValue!="default"&&returnValue!=undefined&&returnValue!=null&&returnValue!="")
	{
		backReturnValue1(returnValue,text1,text2,text3,text4);
	}else
	{
		backReturnValue2(text1,text2,text3,text4);
	}
}

/**
 * 放大镜
 * @param text1 第一个返回值
 * @param text2 第二个返回值
 * @param path  放大镜地址
 * @param Height 高度
 * @param Width 宽度
 */
function tree(text1,text2,path,Height,Width)
{
	var obj = [document.getElementById(text1),document.getElementById(text2)];
	if(Height==undefined)
	{
		Height = '500px';
	}
	if(Width==undefined)
	{
		Width = '780px';
	}
	if(path==undefined){
		path="";
	} 

var returnValue = window.showModalDialog(path,'','dialogHeight:'+Height+';dialogWidth:'+Width+';center:yes;help:no;resizable:no;status:no;scroll:no;location:no;');
//backReturnValue(returnValue,obj1);
if (returnValue == undefined) {
    returnValue = window.returnValue;
}
if(returnValue!="default"&&returnValue!=undefined&&returnValue!=null&&returnValue!="")
{
	backReturnValue1(returnValue,text1,text2);
}else
{
	backReturnValue2(text1,text2);
}	
if(document.getElementById(text1).value!=null&&document.getElementById(text1).value!=""){
		return true;
	}else{
		return false;
	}
}
function backReturnValue1(returnValue,text1,text2,text3,text4,text5,text6,text7,text8,text9,text10,text11,text12,text13,text14,text15,text16,text17,text18,text19,text20,text21,text22,text23,text24,text25,text26,text27,text28){
		if(document.getElementById(text1)!=null&&document.getElementById(text1)!=undefined&&document.getElementById(text1)!=""){
			document.getElementById(text1).value = returnValue.split("|")[0];
		}
		if(document.getElementById(text2)!=null&&document.getElementById(text2)!=undefined&&document.getElementById(text2)!=""){
			document.getElementById(text2).value = returnValue.split("|")[1];
		}
		if(document.getElementById(text3)!=null&&document.getElementById(text3)!=undefined&&document.getElementById(text3)!=""){
			document.getElementById(text3).value = returnValue.split("|")[2];
		}
		if(document.getElementById(text4)!=null&&document.getElementById(text4)!=undefined&&document.getElementById(text4)!=""){
			document.getElementById(text4).value = returnValue.split("|")[3];
		}
		if(document.getElementById(text5)!=null&&document.getElementById(text5)!=undefined&&document.getElementById(text5)!=""){
			document.getElementById(text5).value = returnValue.split("|")[4];
		}
		if(document.getElementById(text6)!=null&&document.getElementById(text6)!=undefined&&document.getElementById(text6)!=""){
			document.getElementById(text6).value = returnValue.split("|")[5];
		}
		if(document.getElementById(text7)!=null&&document.getElementById(text7)!=undefined&&document.getElementById(text7)!=""){
			document.getElementById(text7).value = returnValue.split("|")[6];
		}
		if(document.getElementById(text8)!=null&&document.getElementById(text8)!=undefined&&document.getElementById(text8)!=""){
			document.getElementById(text8).value = returnValue.split("|")[7];
		}
		if(document.getElementById(text9)!=null&&document.getElementById(text9)!=undefined&&document.getElementById(text9)!=""){
			document.getElementById(text9).value = returnValue.split("|")[8];
		}
		if(document.getElementById(text10)!=null&&document.getElementById(text10)!=undefined&&document.getElementById(text10)!=""){
			document.getElementById(text10).value = returnValue.split("|")[9];
		}
		if(document.getElementById(text11)!=null&&document.getElementById(text11)!=undefined&&document.getElementById(text11)!=""){
			document.getElementById(text11).value = returnValue.split("|")[10];
		}
		if(document.getElementById(text12)!=null&&document.getElementById(text12)!=undefined&&document.getElementById(text12)!=""){
			document.getElementById(text12).value = returnValue.split("|")[11];
		}
		if(document.getElementById(text13)!=null&&document.getElementById(text13)!=undefined&&document.getElementById(text13)!=""){
			document.getElementById(text13).value = returnValue.split("|")[12];
		}
		if(document.getElementById(text14)!=null&&document.getElementById(text14)!=undefined&&document.getElementById(text14)!=""){
			document.getElementById(text14).value = returnValue.split("|")[13];
		}
		if(document.getElementById(text15)!=null&&document.getElementById(text15)!=undefined&&document.getElementById(text15)!=""){
			document.getElementById(text15).value = returnValue.split("|")[14];
		}
		if(document.getElementById(text16)!=null&&document.getElementById(text16)!=undefined&&document.getElementById(text16)!=""){
			document.getElementById(text16).value = returnValue.split("|")[15];
		}
		if(document.getElementById(text17)!=null&&document.getElementById(text17)!=undefined&&document.getElementById(text17)!=""){
			document.getElementById(text17).value = returnValue.split("|")[16];
		}
		if(document.getElementById(text18)!=null&&document.getElementById(text18)!=undefined&&document.getElementById(text18)!=""){
			document.getElementById(text18).value = returnValue.split("|")[17];
		}
		if(document.getElementById(text19)!=null&&document.getElementById(text19)!=undefined&&document.getElementById(text19)!=""){
			document.getElementById(text19).value = returnValue.split("|")[18];
		}
		if(document.getElementById(text20)!=null&&document.getElementById(text20)!=undefined&&document.getElementById(text20)!=""){
			document.getElementById(text20).value = returnValue.split("|")[19];
		}
		if(document.getElementById(text21)!=null&&document.getElementById(text21)!=undefined&&document.getElementById(text21)!=""){
			document.getElementById(text21).value = returnValue.split("|")[20];
		}
		if(document.getElementById(text22)!=null&&document.getElementById(text22)!=undefined&&document.getElementById(text22)!=""){
			document.getElementById(text22).value = returnValue.split("|")[21];
		}
		if(document.getElementById(text23)!=null&&document.getElementById(text23)!=undefined&&document.getElementById(text23)!=""){
			document.getElementById(text23).value = returnValue.split("|")[22];
		}
		if(document.getElementById(text24)!=null&&document.getElementById(text24)!=undefined&&document.getElementById(text24)!=""){
			document.getElementById(text24).value = returnValue.split("|")[23];
		}
		if(document.getElementById(text25)!=null&&document.getElementById(text25)!=undefined&&document.getElementById(text25)!=""){
			document.getElementById(text25).value = returnValue.split("|")[24];
		}
		if(document.getElementById(text26)!=null&&document.getElementById(text26)!=undefined&&document.getElementById(text26)!=""){
			document.getElementById(text26).value = returnValue.split("|")[25];
		}
		if(document.getElementById(text27)!=null&&document.getElementById(text27)!=undefined&&document.getElementById(text27)!=""){
			document.getElementById(text27).value = returnValue.split("|")[26];
		}
		if(document.getElementById(text28)!=null&&document.getElementById(text28)!=undefined&&document.getElementById(text28)!=""){
			document.getElementById(text28).value = returnValue.split("|")[27];
		}
		
		/*document.getElementById(text1).value = returnValue.split("|")[0];
		document.getElementById(text2).value = returnValue.split("|")[1];
		document.getElementById(text3).value = returnValue.split("|")[2];
		document.getElementById(text4).value = returnValue.split("|")[3];
		document.getElementById(text5).value = returnValue.split("|")[4];
		document.getElementById(text6).value = returnValue.split("|")[5];*/
		/*document.getElementById(text1).value = "";
		document.getElementById(text2).value = "";
		document.getElementById(text3).value = "";
		document.getElementById(text4).value = "";
		document.getElementById(text5).value = "";
		document.getElementById(text6).value = "";*/
}
function backReturnValue2(text1,text2,text3,text4,text5,text6,text7,text8,text9,text10,text11,text12,text13,text14,text15,text16,text17,text18,text19,text20,text21,text22,text23,text24,text25,text26,text27,text28){
	if(document.getElementById(text1)!=null&&document.getElementById(text1)!=undefined&&document.getElementById(text1)!=""){
		document.getElementById(text1).value = "";
	}
	if(document.getElementById(text2)!=null&&document.getElementById(text2)!=undefined&&document.getElementById(text2)!=""){
		document.getElementById(text2).value = "";
	}
	if(document.getElementById(text3)!=null&&document.getElementById(text3)!=undefined&&document.getElementById(text3)!=""){
		document.getElementById(text3).value = "";
	}
	if(document.getElementById(text4)!=null&&document.getElementById(text4)!=undefined&&document.getElementById(text4)!=""){
		document.getElementById(text4).value = "";
	}
	if(document.getElementById(text5)!=null&&document.getElementById(text5)!=undefined&&document.getElementById(text5)!=""){
		document.getElementById(text5).value = "";
	}
	if(document.getElementById(text6)!=null&&document.getElementById(text6)!=undefined&&document.getElementById(text6)!=""){
		document.getElementById(text6).value = "";
	}
	if(document.getElementById(text7)!=null&&document.getElementById(text7)!=undefined&&document.getElementById(text7)!=""){
		document.getElementById(text7).value = "";
	}
	if(document.getElementById(text8)!=null&&document.getElementById(text8)!=undefined&&document.getElementById(text8)!=""){
		document.getElementById(text8).value = "";
	}
	if(document.getElementById(text9)!=null&&document.getElementById(text9)!=undefined&&document.getElementById(text9)!=""){
		document.getElementById(text9).value = "";
	}
	if(document.getElementById(text10)!=null&&document.getElementById(text10)!=undefined&&document.getElementById(text10)!=""){
		document.getElementById(text10).value = "";
	}
	if(document.getElementById(text11)!=null&&document.getElementById(text11)!=undefined&&document.getElementById(text11)!=""){
		document.getElementById(text11).value = "";
	}
	if(document.getElementById(text12)!=null&&document.getElementById(text12)!=undefined&&document.getElementById(text12)!=""){
		document.getElementById(text12).value = "";
	}
	if(document.getElementById(text13)!=null&&document.getElementById(text13)!=undefined&&document.getElementById(text13)!=""){
		document.getElementById(text13).value = "";
	}
	if(document.getElementById(text14)!=null&&document.getElementById(text14)!=undefined&&document.getElementById(text14)!=""){
		document.getElementById(text14).value = "";
	}
	if(document.getElementById(text15)!=null&&document.getElementById(text15)!=undefined&&document.getElementById(text15)!=""){
		document.getElementById(text15).value = "";
	}
	if(document.getElementById(text16)!=null&&document.getElementById(text16)!=undefined&&document.getElementById(text16)!=""){
		document.getElementById(text16).value = "";
	}
	if(document.getElementById(text17)!=null&&document.getElementById(text17)!=undefined&&document.getElementById(text17)!=""){
		document.getElementById(text17).value = "";
	}
	if(document.getElementById(text18)!=null&&document.getElementById(text18)!=undefined&&document.getElementById(text18)!=""){
		document.getElementById(text18).value = "";
	}
	if(document.getElementById(text19)!=null&&document.getElementById(text19)!=undefined&&document.getElementById(text19)!=""){
		document.getElementById(text19).value = "";
	}
	if(document.getElementById(text20)!=null&&document.getElementById(text20)!=undefined&&document.getElementById(text20)!=""){
		document.getElementById(text20).value = "";
	}
	if(document.getElementById(text21)!=null&&document.getElementById(text21)!=undefined&&document.getElementById(text21)!=""){
		document.getElementById(text21).value = "";
	}
	if(document.getElementById(text22)!=null&&document.getElementById(text22)!=undefined&&document.getElementById(text22)!=""){
		document.getElementById(text22).value = "";
	}
	if(document.getElementById(text23)!=null&&document.getElementById(text23)!=undefined&&document.getElementById(text23)!=""){
		document.getElementById(text23).value = "";
	}
	if(document.getElementById(text24)!=null&&document.getElementById(text24)!=undefined&&document.getElementById(text24)!=""){
		document.getElementById(text24).value = "";
	}
	if(document.getElementById(text25)!=null&&document.getElementById(text25)!=undefined&&document.getElementById(text25)!=""){
		document.getElementById(text25).value = "";
	}
	if(document.getElementById(text26)!=null&&document.getElementById(text26)!=undefined&&document.getElementById(text26)!=""){
		document.getElementById(text26).value = "";
	}
	if(document.getElementById(text27)!=null&&document.getElementById(text27)!=undefined&&document.getElementById(text27)!=""){
		document.getElementById(text27).value = "";
	}
	if(document.getElementById(text28)!=null&&document.getElementById(text28)!=undefined&&document.getElementById(text28)!=""){
		document.getElementById(text28).value = "";
	}
}