//表单验证
/*
	Copyright (C) 2009 - 2012
	WebSite:	Http://wangking717.javaeye.com/
	Author:		wangking
*/
function getRootPath(){    //获取当前网址，如： http://localhost:8083/uimcardprj/share/meun.jsp    
	var curWwwPath=window.document.location.href;    
	//获取主机地址之后的目录，如： uimcardprj/share/meun.jsp    
	var pathName=window.document.location.pathname; 
	var pos=curWwwPath.indexOf(pathName);  
	//获取主机地址，如： http://localhost:8083    
	var localhostPaht=curWwwPath.substring(0,pos);   
	//获取带"/"的项目名，如：/uimcardprj   
	var projectName=pathName.substring(0,pathName.substr(1).indexOf('/')+1);  
	return(localhostPaht+projectName);
}
$(function(){
	var xOffset = -20; // x distance from mouse
    var yOffset = 20; // y distance from mouse  
    if(nowpath==undefined){
    	var nowpath =getRootPath();
    }
	//input action
	$("[valid],[url]:([urlmsg]),[errmsg]").hover(
		function(e) {
			if($(this).attr('errmsg') != undefined){
				var top = (e.pageY + yOffset);
				var left = (e.pageX + xOffset); 
				if($(this).attr('show')==undefined){
					$(this).attr('show',$(this).attr('tip'));
				}  
				if($(this).attr('show')==null||$(this).attr('show')=="null"){
					$(this).removeAttr('show');
				}
				if(document.getElementById("vtip")==null&&$(this).attr('show')!=undefined){
					$('body').append( '<p id="vtip"><img id="vtipArrow" src="'+nowpath+'/images/vtip_arrow.png"/>' + $(this).attr('show') + '</p>' );
				}
				$('p#vtip').css("top", top+"px").css("left", left+"px");
				$('p#vtip').bgiframe();
			}
		},
		function() { 
			if($(this).attr('errmsg') != undefined){
				$("p#vtip").remove();
			}
		}
	).mousemove(
		function(e) { 
			if($(this).attr('errmsg') != undefined){
				var top = (e.pageY + yOffset);
				var left = (e.pageX + xOffset);
				$("p#vtip").css("top", top+"px").css("left", left+"px");
			}
		},
		function() {
			if($(this).attr('errmsg') != undefined){
				$("p#vtip").remove();
			}
		}
	).blur(function(){
		if($(this).attr("url") != undefined){
			if(!ajax_validate($(this)))return false;
		}
		if($(this).attr("valid") != undefined){
			if(!validate($(this)))return false;
		}
	});
	
	
});

function validator() {
	var isSubmit = true;
	var fv = new FormValid($("[valid],[url]:([urlmsg])"));
	$("[valid],[url]:([urlmsg])").each(function(){
		if($(this).attr("url") != undefined){
			if(!ajax_validate($(this))){
				isSubmit = false;
				return isSubmit;
			}
		}
		if($(this).attr("valid") != undefined){
			if(!validate($(this))){
				isSubmit = false;
				if($(this).attr("type")=="checkbox"||$(this).attr("type")=="radio"){ 
					var fvname = true;
					for (key in fv.errName) {
						if(fv.errName[key]==$(this).attr("name")){
							fvname = false;
						}
					}
					if(fvname){
						fv.errName.push($(this).attr("name")); 
						fv.errMsg.push($(this).attr("errmsg"));
					}
				}
				
			}
		} 
	});
	if(fv.errName.length > 0){
		FormValid.showError(fv.errMsg);
		document.getElementsByName(fv.errName[0])[0].focus(); 
	}
	return isSubmit;
}

function resetDiv(){
			document.forms[0].reset();
			$("[valid],[url]:([urlmsg]),[errmsg]").each(function(){
				$("p#vtip").remove();
				$(this).removeAttr("show");
				change_error_style($(this),"remove");
				change_tip($(this),null,"remove");
			});
}


function validate(obj){
	var flag = true;
	var frm = $("[valid],[url]:not([valid])");
	var formElements = frm;
	var fv = new FormValid(frm);
	if(obj.attr("type")=="text"&&obj.attr("value")!=undefined){
		obj.attr("value", obj.attr("value").trim());
	}else if(obj.attr("type")=="checkbox"||obj.attr("type")=="radio"){ 
		if(obj.attr("valid")=="required"){
			var len = document.getElementsByName(obj.attr("name")).length;
			var flag = 0;
			if(len!=undefined){
				for(var i=0;i<len;i++){
					if(eval(document.getElementsByName(obj.attr("name"))[i].checked)){
						flag++;
					}
				}
			}else{
				if(document.getElementsByName(obj.attr("name")).checked){
					flag++;
				}
			}
			if(flag==0){
				$("[valid]").each(function(){
					if($(this).attr("name")==obj.attr("name")){
						change_error_style($(this),"add");
						$(this).attr("show",$(this).attr("errmsg"));
		        		change_tip($(this),null,"remove");
					}
					 
				});
				 
				return false;
			}else{
				$("[valid]").each(function(){
					if($(this).attr("name")==obj.attr("name")){
						change_error_style($(this),"remove");
						$(this).removeAttr("show");
		        		change_tip($(this),null,"remove");
					}
					 
				});
				return true;
			}
		}
		return true;
	}
	var validType = obj.attr("valid");
	var errorMsg = obj.attr("errmsg");
	if (validType==null||validType=="") return true; 
	var vts = validType.split('|');
	var ems = errorMsg.split('|');
	for (var j=0; j<vts.length; j++) {
		var curValidType = vts[j];
		var curErrorMsg = ems[j];
		switch (curValidType) {
			case 'isNum':
			case 'isSymbols':
		    case 'isTableName':
			case 'isNumber':
			case 'isAccount':
			case 'isPassword':
			case 'isEnglishChinese':
			case 'isEmail':
			case 'isPhone':
			case 'isMobile':
			case 'isIdCard':
			case 'isMoney':
			case 'isZip':
			case 'isQQ':
			case 'isInt':
			case 'isEnglish':
			case 'isChinese':
			case 'isUrl':
			case 'isDate':
			case 'isXs':
			case 'isTime':  
			case 'isScore':
			case 'isScore1':
			case 'isZInt':
			        if (obj.attr("value") == "") {
//			            return true;
			        } else {
			            if (!RegExps[curValidType].test(obj.attr("value"))) {
			            	change_error_style(obj,"add");
			            	obj.attr("show",curErrorMsg);
			        		change_tip(obj,null,"remove");
			        		return false;
						}else{
							if(obj.attr("url") == undefined){
								change_error_style(obj,"remove");
								obj.removeAttr("show");
								change_tip(obj,null,"remove");
//								return true;
							}else{
								flag =  ajax_validate(obj);
							}
						}
			        } 
				break;
			case 'regexp': 
				if (obj.attr("value") == "") {
//		            return true;
		        } else {
		            if (!new RegExp(obj.attr("regexp"),"g").test(obj.value)) {
		            	change_error_style(obj,"add");
		            	obj.attr("show",curErrorMsg);
		        		change_tip(obj,null,"remove");
		        		return false;
					}else{
						if(obj.attr("url") == undefined){
							change_error_style(obj,"remove");
							obj.removeAttr("show");
							change_tip(obj,null,"remove");
//							return true;
						}else{
							flag =  ajax_validate(obj);
						}
					}
		        } 
				break;
			case 'custom':
				if (!eval(obj.attr('custom')+'(obj,formElements)')) {
					change_error_style(obj,"add");
	        		change_tip(obj,null,"remove");
	        		return false;
				}else{
					if(obj.attr("url") == undefined){
						change_error_style(obj,"remove");
						change_tip(obj,null,"remove");
//						return true;
					}else{
						flag =  ajax_validate(obj);
					}
				}
				break;
			default :
				if (!eval('fv.'+curValidType+'(obj)')) {
					change_error_style(obj,"add");
					obj.attr("show",curErrorMsg);
	        		change_tip(obj,null,"remove");
	        		return false;
				}else{
					if(obj.attr("url") == undefined){
						change_error_style(obj,"remove");
						obj.removeAttr("show");
						change_tip(obj,null,"remove");
//						return true;
					}else{
						flag = ajax_validate(obj);
					}
				}
				break;
		}
		if(!flag){
			return flag;
		}
	}
	 return true;
}

function ajax_validate(obj){
	if(obj.attr("value")==undefined||obj.attr("value").trim()==""){
		change_error_style(obj,"remove");
		obj.attr("show",null);
		change_tip(obj,null,"remove");
		return true;
	}
	var url_str = obj.attr("url");
	if(url_str.indexOf("?") != -1){
		url_str = url_str+"&"+obj.attr("name")+"="+obj.attr("value");
		
	}else{
		url_str = url_str+"?"+obj.attr("name")+"="+obj.attr("value");
		
	}
	if(obj.attr("urlname")!=undefined){
		var urlname = obj.attr("urlname").split('|');
		for (var j=0; j<urlname.length; j++) {
			var uname=$("*").filter(function(){
			    return $(this).attr("name")==urlname[j];
			  });
			if(uname.val()!=undefined){
				url_str = url_str+"&"+urlname[j]+"="+uname.val().trim();
			}
		}
	}
	
	var feed_back = $.ajax({url: encodeURI(url_str),cache: false,async: false}).responseText;
	feed_back = feed_back.replace(/(^\s*)|(\s*$)/g, "");
	if(feed_back == 'true'){
		change_error_style(obj,"remove");
		obj.attr("show",null);
		change_tip(obj,null,"remove");
		return true;
	}else{
		change_error_style(obj,"add");
		obj.attr("show",obj.attr("urlmsg"));
		change_tip(obj,feed_back,"add");
		return false;
	}
}

function change_tip(obj,msg,action_type){
	
	if(obj.attr("errmsg") == undefined){//初始化判断TIP是否为空
		obj.attr("is_tip_null","yes");
	}
	if(action_type == "add"){
		if(obj.attr("is_tip_null") == "yes"){
			obj.attr("errmsg",msg);
		}else{
			if(msg != null){
				if(obj.attr("tip_bak") == undefined){
					obj.attr("tip_bak",obj.attr("errmsg"));
				}
				obj.attr("errmsg",msg);
			}
		}
	}else{
		if(obj.attr("is_tip_null") == "yes"){
			obj.removeAttr("errmsg");
			obj.removeAttr("tip_bak");
		}else{
			obj.attr("errmsg",obj.attr("tip_bak"));
			obj.removeAttr("tip_bak");
		}
	}
}

function change_error_style(obj,action_type){
	if(obj.attr("select")!=undefined){
		if(action_type == "add"){
			obj.addClass("input_validation-failed");
		}else{
			obj.removeClass("input_validation-failed");
		}
	}else{
		if(action_type == "add"){
			obj.addClass("select_validation-failed");
		}else{
			obj.removeClass("select_validation-failed");
		}
	}
}

$.fn.validate_callback = function(msg,action_type,options){
	this.each(function(){
		if(action_type == "failed"){
			change_error_style($(this),"add");
			change_tip($(this),msg,"add");
		}else{
			change_error_style($(this),"remove");
			change_tip($(this),null,"remove");
		}
	});
};

var FormValid = function(frm) {
    this.frm = frm;
    this.errMsg = new Array();
	this.errName = new Array();
    this.required = function(inputObj) {
        if (typeof(inputObj) == "undefined" || inputObj.attr("value").trim() == "") { 
        	//alert(inputObj.name);
            return false;
        }
		return true;
    };
    this.equal = function(inputObj) {
     var fstObj = inputObj;
	 var sndObj = document.getElementById(inputObj.attr('equalName'));
	
        if (fstObj != null && sndObj != null) {
        	alert(fstObj.attr("value"));
        	alert(sndObj.value.trim());
            if (fstObj.attr("value") != sndObj.value.trim()) {
               return false;
            }
        }
		return true;
    };

    this.gt = function(inputObj) {
		var fstObj = inputObj;
		var sndObj = document.getElementById(inputObj.attr('equalName'));
        if (fstObj != null && sndObj != null && fstObj.attr("value").trim()!='' && sndObj.value.trim()!='') {
            if (fstObj.attr("value") <= sndObj.value) {
                 return false;
            }
        }
		return true;
    };

	this.compare = function(inputObj) {
		var fstObj = inputObj;
		var sndObj = document.getElementById(inputObj.attr('equalName'));
        if (fstObj != null && sndObj != null && fstObj.attr("value").trim()!='' && sndObj.value.trim()!='') {
            if (!eval('fstObj.attr("value")' + inputObj.attr("operate") + 'sndObj.value')) {
                 return false;
            }
        }
		return true;
	};

	this.limit = function (inputObj) {
		var len = inputObj.attr("value").length;
		if (len) {
			var minv = inputObj.attr("min");
			var maxv = inputObj.attr("max");
			minv = minv || 0;
			maxv = maxv || Number.MAX_VALUE;
			return minv <= len && len <= maxv;
		}
		return true;
	};

	this.range = function (inputObj) {
		var val = parseInt(inputObj.attr("value"));
		if (inputObj.value) {
			var minv = inputObj.attr("min");
			var maxv = inputObj.attr("max");
			minv = minv || 0;
			maxv = maxv || Number.MAX_VALUE;
			return minv <= val && val <= maxv;
		}
		return true;
	};

	this.requireChecked = function (inputObj) {
		var minv = inputObj.attr("min");
		var maxv = inputObj.attr("max");
		minv = minv || 1;
		maxv = maxv || Number.MAX_VALUE;
		var checked = 0;
		var groups = document.getElementsByName(inputObj.attr("name"));

		for(var i=0;i<groups.length;i++) {
		if(groups[i].checked) checked++;

		}
		return minv <= checked && checked <= maxv;
	};

	this.filter = function (inputObj) {
		var value = inputObj.attr("value");
		var allow = inputObj.attr("allow");
		if (value.trim()) {
			return new RegExp("^.+\.(?=EXT)(EXT)$".replace(/EXT/g, allow.split(/\s*,\s*/).join("|")), "gi").test(value);
		}
		return true;
	};

	this.isNo = function (inputObj) {
		var value = inputObj.attr("value");
		var noValue = inputObj.attr("noValue");
		return value!=noValue;
	};
    this.checkReg = function(inputObj, reg, msg) {
        inputObj.value = inputObj.attr("value").trim();

        if (inputObj.attr("value") == '') {
            return;
        } else {
            if (!reg.test(inputObj.attr("value"))) {
				this.addErrorMsg(inputObj.attr("name"),msg);
			}
        }
    };


    this.passed = function() {
        if (this.errMsg.length > 0) {
            FormValid.showError(this.errMsg,this.errName);
            frt = document.getElementsByName(this.errName[0])[0];

			if (frt.type!='radio' && frt.type!='checkbox') {
				frt.focus();
			}
            return false;
        } else {
          return true;
        }
    };


    this.addErrorMsg = function(name,str) {
        this.errMsg.push(str);
		this.errName.push(name);
    };

    this.addAllName = function(name) {
		FormValid.allName.push(name);
    };

};
FormValid.allName = new Array();
FormValid.showError = function(errMsg) {
	var msg = "";
	for (i = 0; i < errMsg.length; i++) {
		msg += "- " + errMsg[i] + "\n";
	}
	alert(msg);
};
//function validator(frm) {
//	var formElements = frm.elements;
//	var fv = new FormValid(frm);
//	for (var i=0;i<formElements.length;i++) {
//		//去除text中前后空格
//		if(formElements[i].type=="text"&&formElements[i].value!=undefined){
//			formElements[i].value = formElements[i].value.trim();
//		}
//		var validType = formElements[i].getAttribute('valid');
//		var errorMsg = formElements[i].getAttribute('errmsg');
//		if (validType==null||validType=="") continue;
//		fv.addAllName(formElements[i].name);
//
//		var vts = validType.split('|');
//		var ems = errorMsg.split('|');
//		for (var j=0; j<vts.length; j++) {
//			var curValidType = vts[j];
//			var curErrorMsg = ems[j];
//			switch (curValidType) {
//				case 'isNum':
//				case 'isSymbols':
//			    case 'isTableName':
//				case 'isNumber':
//				case 'isAccount':
//				case 'isPassword':
//				case 'isEnglishChinese':
//				case 'isEmail':
//				case 'isPhone':
//				case 'isMobile':
//				case 'isIdCard':
//				case 'isMoney':
//				case 'isZip':
//				case 'isQQ':
//				case 'isInt':
//				case 'isEnglish':
//				case 'isChinese':
//				case 'isUrl':
//				case 'isDate':
//				case 'isXs':
//				case 'isTime':
//					fv.checkReg(formElements[i],RegExps[curValidType],curErrorMsg);
//					break;
//				case 'regexp':
//					fv.checkReg(formElements[i],new RegExp(formElements[i].getAttribute('regexp'),"g"),curErrorMsg);
//					break;
//				case 'custom':
//					if (!eval(formElements[i].getAttribute('custom')+'(formElements[i],formElements)')) {
//						fv.addErrorMsg(formElements[i].name,curErrorMsg);
//					}
//					break;
//				default :
//					if (!eval('fv.'+curValidType+'(formElements[i],formElements)')) {
//						fv.addErrorMsg(formElements[i].name,curErrorMsg);
//					}
//					break;
//			}
//		}
//	}
//	return fv.passed();
//}

//FormValid.showError = function(errMsg,errName) {
//	for (key in FormValid.allName) {
//		document.getElementById('errMsg_'+FormValid.allName[key]).innerHTML = '';
//	}
//	for (key in errMsg) {
//		document.getElementById('errMsg_'+errName[key]).innerHTML = errMsg[key];
//	}
//}

String.prototype.trim = function() {
	return this.replace(/^\s*|\s*$/g, "");
};
var RegExps = function(){};
RegExps.isNumber = /^[-\+]?\d+(\.\d+)?$/;
RegExps.isEmail = /^((([a-z]|\d|[!#\$%&'\*\+\-\/=\?\^_`{\|}~]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])+(\.([a-z]|\d|[!#\$%&'\*\+\-\/=\?\^_`{\|}~]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])+)*)|((\x22)((((\x20|\x09)*(\x0d\x0a))?(\x20|\x09)+)?(([\x01-\x08\x0b\x0c\x0e-\x1f\x7f]|\x21|[\x23-\x5b]|[\x5d-\x7e]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(\\([\x01-\x09\x0b\x0c\x0d-\x7f]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF]))))*(((\x20|\x09)*(\x0d\x0a))?(\x20|\x09)+)?(\x22)))@((([a-z]|\d|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(([a-z]|\d|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])*([a-z]|\d|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])))\.)+(([a-z]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(([a-z]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])([a-z]|\d|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])*([a-z]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])))\.?$/;
//RegExps.isEmail = /([\w-\.]+)@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.)|(([\w-]+\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\]?)/;
RegExps.isPhone = /^((\(\d{2,3}\))|(\d{3}\-))?(\(0\d{2,3}\)|0\d{2,3}-)?[1-9]\d{6,7}(\-\d{1,4})?$/;
//RegExps.isMobile = /^((\(\d{2,3}\))|(\d{3}\-))?13\d{9}$/;
RegExps.isMobile =/(\d{11})|^((\d{7,8})|(\d{4}|\d{3})-(\d{7,8})|(\d{4}|\d{3})-(\d{7,8})-(\d{4}|\d{3}|\d{2}|\d{1})|(\d{7,8})-(\d{4}|\d{3}|\d{2}|\d{1}))$/;  
RegExps.isIdCard = /(^\d{15}$)|(^\d{17}[0-9Xx]$)/;
RegExps.isMoney = /^\d+(\.\d+)?$/;
RegExps.isZip = /^[1-9]\d{5}$/;
RegExps.isQQ = /^[1-9]\d{4,10}$/;
RegExps.isInt = /^[-\+]?\d+$/;
RegExps.isEnglish = /^[A-Za-z]+$/;
RegExps.isChinese =  /^[\u0391-\uFFE5]+$/;
RegExps.isUrl = /^http:\/\/[A-Za-z0-9]+\.[A-Za-z0-9]+[\/=\?%\-&_~`@[\]\':+!]*([^<>\"\"])*$/;
RegExps.isDate = /^\d{4}-\d{1,2}-\d{1,2}$/;
RegExps.isTime = /^\d{4}-\d{1,2}-\d{1,2}\s\d{1,2}:\d{1,2}:\d{1,2}$/;
RegExps.isAccount = /^[a-z]\w{3,}$/i;
RegExps.isPassword = /^\w{6,16}$/i;
RegExps.isEnglishChinese = /^[A-Za-z\u0391-\uFFE5]+$/i;
RegExps.isTableName = /^[a-z]\w*$/i;
RegExps.isSymbols = /^[\w\u0391-\uFFE5]+$/i;
RegExps.isNum = /^\d+$/i;
RegExps.isXs= /^[0-9]+(\.[0-9]{0,2})?$/;
RegExps.isScore= /^[-\+]?\d+(\.\d{0,1})?$/;
RegExps.isScore1= /^[+]?\d+(\.\d{0,1})?$/;
RegExps.isZInt = /^[+]?\d+$/;