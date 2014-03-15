<%@ page language="java" import="java.util.*" isELIgnored="false" pageEncoding="UTF-8"%>
<%@ taglib  uri="/struts-tags" prefix="s"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
 
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>功能排序</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<script type="text/javascript" src="<%=path%>/js/jquery-1.4.2.js"></script>
<script type="text/javascript" src="<%=path%>/js/jquery-1.4.2.min.js"></script>
<script type="text/javascript" src="<%=path%>/js/jquery-ui-1.8.16.custom.min.js"></script>
<script type="text/javascript" src="<%=path%>/js/select.js"></script>
<script type="text/javascript" src="<%=path%>/js/util.js"></script>
<script type="text/javascript" src="<%=path%>/js/tree/selectjs.js"></script>
<script type="text/javascript" src="<%=path%>/js/tree/treejs.js"></script>
<link rel="stylesheet" type="text/css" href="<%=path%>/css/text.css">
<link rel="stylesheet" type="text/css" href="<%=path%>/css/validate.css"  />
<script type="text/javascript" src="<%=path%>/js/DatePicker/WdatePicker.js"></script>
<link rel="stylesheet" type="text/css" href="<%=path%>/css/stylecss.css">
<link rel="stylesheet" href="<%=path%>/common/css/itemScreen1.css"  type="text/css"/>
<link rel="stylesheet" href="<%=path%>/common/css/alter.css"  type="text/css"/> 
<script type="text/javascript" src="<%=path%>/js/jquery.bgiframe.min.js"></script>
<link rel="stylesheet" type="text/css" media="screen" href="<%=path %>/js/tree/ztree/css/zTreeStyle/zTreeStyle.css">
<link rel="stylesheet" href="<%=path %>/css/skin.css" type="text/css" />
<script type="text/javascript" src="<%=path %>/js/tree/ztree/js/jquery-1.4.4.min.js"></script>
<script type="text/javascript" src="<%=path %>/js/tree/ztree/js/jquery.ztree.core-3.4.js"></script>
<script type="text/javascript" src="<%=path %>/js/tree/ztree/js/jquery.ztree.excheck-3.4.js"></script>
<script type="text/javascript" src="<%=path %>/js/tree/ztree/js/jquery.ztree.exedit-3.4.js"></script>
<style type="text/css">
.bigBox ul li{ float:none;}
</style>
<script type="text/javascript">
	var setting = {
		edit: {
			drag: {
				autoExpandTrigger: true,
				prev: dropPrev,
				inner: dropInner,
				next: dropNext
			},
			enable: true,
			showRemoveBtn: false,
			showRenameBtn: false
		},
		data: {
			simpleData: {
				enable: true
			}
		},
		callback: {
			beforeDrag: beforeDrag,
			beforeDrop: beforeDrop,
			beforeDragOpen: beforeDragOpen,
			onDrag: onDrag,
			onDrop: onDrop,
			onExpand: onExpand,
			onClick: function(event, treeId, treeNode) {
				$.post("<%=path%>/right!findSub",
						{"form.right_sno": treeNode.id, "form.sysint_sno": $("#sysint_sno option:selected").val()},
						function(data) {
							zNodes1 = [];
							for (var i = 0; i < data.length; i++) {
								var right = data[i];
								var parentId = (right.right_sparentno == null) ? 0 : right.right_sparentno;
								var node = {
									id: right.right_sno,
									pId: parentId,
									name: right.right_sname
								};
								if (right.right_nmorb == "0") {
									node.childOuter=false;
								}
								zNodes1.push(node);
							}
							$.fn.zTree.init($("#tree2"), setting1, zNodes1);
							$("#tree2").slideDown("fast");
						},"json");
			}
		}
	};
	
	var setting1 = {
			edit: {
				drag: {
					autoExpandTrigger: true,
					prev: dropPrev,
					inner: dropInner,
					next: dropNext
				},
				enable: true,
				showRemoveBtn: false,
				showRenameBtn: false
			},
			data: {
				simpleData: {
					enable: true
				}
			},
			callback: {
				beforeDrag: beforeDrag,
				beforeDrop: beforeDrop,
				beforeDragOpen: beforeDragOpen,
				onDrag: onDrag,
				onDrop: onDrop,
				onExpand: onExpand,
				onClick: function(event, treeId, treeNode) {
					return false;
				}
			}
	};

	var zNodes =[
	    //不能拖拽成根节点(dropRoot:false)，不能拖拽成父节点(dropInner:false)，
	    //禁止子节点排序(childOrder:false)，禁止拖拽(drag:false)，
	    //禁止子节点移走(childOuter:false)
		{ id:01, pId:0, name:"系统管理", open:true, childOuter:false, drag:false},
		{ id:0101, pId:01, name:"系统集成管理"},
		{ id:0102, pId:01, name:"功能信息管理"},
		{ id:0103, pId:01, name:"操作信息管理"},
		{ id:0104, pId:01, name:"数据权限管理"},
		{ id:02, pId:0, name:"基础管理", open:true, childOuter:false, drag:false},
		{ id:0201, pId:02, name:"校区信息管理"},
		{ id:0202, pId:02, name:"单位部门管理"},
		{ id:0203, pId:02, name:"岗位信息管理"},
		{ id:0204, pId:02, name:"职称信息管理"},
		{ id:0205, pId:02, name:"职工信息管理", open:true, childOuter:false},
		{ id:020501, pId:0205, name:"职工兼职情况"},
		{ id:0206, pId:02, name:"公司信息管理", open:true, childOuter:false},
		{ id:020601, pId:0206, name:"公司情况", dropInner:false},  
		{ id:020602, pId:0206, name:"公司发展历史", dropInner:false}
	];

	function dropPrev(treeId, nodes, targetNode) {
		var pNode = targetNode.getParentNode();
		if (pNode && pNode.dropInner === false) {
			return false;
		} else {
			for (var i=0,l=curDragNodes.length; i<l; i++) {
				var curPNode = curDragNodes[i].getParentNode();
				if (curPNode && curPNode !== targetNode.getParentNode() && curPNode.childOuter === false) {
					return false;
				}
			}
		}
		return true;
	}
	function dropInner(treeId, nodes, targetNode) {
		if (targetNode && targetNode.dropInner === false) {
			return false;
		} else {
			for (var i=0,l=curDragNodes.length; i<l; i++) {
				if (!targetNode && curDragNodes[i].dropRoot === false) {
					return false;
				} else if (curDragNodes[i].parentTId && curDragNodes[i].getParentNode() !== targetNode && curDragNodes[i].getParentNode().childOuter === false) {
					return false;
				}
			}
		}
		return true;
	}
	function dropNext(treeId, nodes, targetNode) {
		var pNode = targetNode.getParentNode();
		if (pNode && pNode.dropInner === false) {
			return false;
		} else {
			for (var i=0,l=curDragNodes.length; i<l; i++) {
				var curPNode = curDragNodes[i].getParentNode();
				if (curPNode && curPNode !== targetNode.getParentNode() && curPNode.childOuter === false) {
					return false;
				}
			}
		}
		return true;
	}

	var log, className = "dark", curDragNodes, autoExpandNode;
	function beforeDrag(treeId, treeNodes) {
		className = (className === "dark" ? "":"dark");
		showLog("[ "+getTime()+" beforeDrag ]&nbsp;&nbsp;&nbsp;&nbsp; drag: " + treeNodes.length + " nodes." );
		for (var i=0,l=treeNodes.length; i<l; i++) {
			if (treeNodes[i].drag === false) {
				curDragNodes = null;
				return false;
			} else if (treeNodes[i].parentTId && treeNodes[i].getParentNode().childDrag === false) {
				curDragNodes = null;
				return false;
			}
		}
		curDragNodes = treeNodes;
		return true;
	}
	function beforeDragOpen(treeId, treeNode) {
		autoExpandNode = treeNode;
		return true;
	}
	function beforeDrop(treeId, treeNodes, targetNode, moveType, isCopy) {
		className = (className === "dark" ? "":"dark");
		showLog("[ "+getTime()+" beforeDrop ]&nbsp;&nbsp;&nbsp;&nbsp; moveType:" + moveType);
		showLog("target: " + (targetNode ? targetNode.name : "root") + "  -- is "+ (isCopy==null? "cancel" : isCopy ? "copy" : "move"));
		return true; 
	}
	
	function onDrag(event, treeId, treeNodes) {
		className = (className === "dark" ? "":"dark");
		showLog("[ "+getTime()+" onDrag ]&nbsp;&nbsp;&nbsp;&nbsp; drag: " + treeNodes.length + " nodes." );
	}
	function onDrop(event, treeId, treeNodes, targetNode, moveType, isCopy) {
		className = (className === "dark" ? "":"dark");
		showLog("[ "+getTime()+" onDrop ]&nbsp;&nbsp;&nbsp;&nbsp; moveType:" + moveType);
		showLog("target: " + (targetNode ? targetNode.name : "root") + "  -- is "+ (isCopy==null? "cancel" : isCopy ? "copy" : "move"));
	}
	function onExpand(event, treeId, treeNode) {
		if (treeNode === autoExpandNode) {
			className = (className === "dark" ? "":"dark");
			showLog("[ "+getTime()+" onExpand ]&nbsp;&nbsp;&nbsp;&nbsp;" + treeNode.name);
		}
	}

	function showLog(str) {
		if (!log) log = $("#log");
		log.append("<li class='"+className+"'>"+str+"</li>");
		if(log.children("li").length > 8) {
			log.get(0).removeChild(log.children("li")[0]);
		}
	}
	function getTime() {
		var now= new Date(),
		h=now.getHours(),
		m=now.getMinutes(),
		s=now.getSeconds(),
		ms=now.getMilliseconds();
		return (h+":"+m+":"+s+ " " +ms);
	}

	function setTrigger() {
		var zTree = $.fn.zTree.getZTreeObj("treeDemo");
		zTree.setting.edit.drag.autoExpandTrigger = $("#callbackTrigger").attr("checked");
	}
	
	//过滤函数
	function filter(treeId, parentNode, childNodes) {
		if (!childNodes) {
			return null;
		}
		for (var i = 0, l = childNodes.length; i < l; i++) {
			childNodes[i].name = childNodes[i].name.replace(/\.n/g, '.');
		}
		return childNodes;
	}
	
	$(document).ready(function(){
		$("#sysint_sno").change(function() {
			if ($("#sysint_sno option:selected").val() == "") {
				$("#msg").html("tips：请选择系统！");
				$("#tree1").attr("style", "display:none");
				$("#tree2").attr("style", "display:none");
			} else {
				$.post("<%=path%>/right!findMenu",
						{"form.sysint_sno":$(this).val()},
						function(data) {
							zNodes = [];
							for (var i = 0; i < data.length; i++) {
								var right = data[i];
								var node = {
									id: right.right_sno,
									pId: 0,
									name: right.right_sname,
									dropInner: false
								};
								zNodes.push(node);
							}
							$("#tree2").attr("style", "display:none");
							$.fn.zTree.init($("#tree1"), setting, zNodes);
							$("#tree1").slideDown("fast", function(){
								if (zNodes.length == 0) {
									$("#msg").html("抱歉，未查询到数据！");
								} else {
									$("#msg").html("拖拽节点以排序，点击菜单可查看功能排序列表！");
								}
							});
						}, "json");
			}
		});
	});
	
	function toSave() {
		if ($("#sysint_sno").val() == "") {
			alert("请选择系统");
			return;
		}
		var treeObj1 = $.fn.zTree.getZTreeObj("tree1");
		var treeObj2 = $.fn.zTree.getZTreeObj("tree2");
		var orderValue = "";
		if (treeObj1 != null) {
			var nodes1 = treeObj1.getNodes();
			if (nodes1.length != 0) {
				orderValue = getOrderStr(treeObj1, nodes1);
			}
		}
		if (treeObj2 != null) {
			var nodes2 = treeObj2.getNodes();
			if (nodes2.length != 0) {
				orderValue = getOrderStr(treeObj2, nodes2) + orderValue;
			}
		}
		if (confirm("是否保存排序值？")) {
			$.post("<%=path %>/right!order",
					{"orderValue":orderValue},
					function(data) {
						if (data) {
							$("#msg").html("保存排序值成功！");
							if (confirm("是否返回查询页面？")) {
								window.location.href="<%=path %>/right!find";
							}
						} else {
							$("#msg").html("保存排序值失败，请稍后重试！");
						}
					},"json");
		}
	}
	
	function getOrderStr(treeObj, nodes) {
		var nodeArray = treeObj.transformToArray(nodes);
		var str = "";
		var len = nodeArray.length - 1;
		for (var i = len; i >= 0; i--) {
			var node = nodeArray[i];
			str = node.id + ":" + (i + 1) + "," + str;
		}
		return str;
	}
	
	function toBack() {
		document.forms[0].action="<%=path %>/right!find";
		document.forms[0].submit();
	}
</script>
</head>
  
<body>
<form name="form1" method="post">
<div class="bigBox"  >
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
                									<td width="94%" valign="bottom"><span class="STYLE1">功能排序</span></td>
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
					 				<tr height="5%" >
 
                <td colspan="2" align="right" nowrap><div align="left">系统名称：
                  <select name="form.sysint_sno" id="sysint_sno" valid="required" errmsg="请选择系统名称！">
                    <option value="">--请选择--</option>
                    <s:iterator value="sysIntList" var="sysInt">
                      <option value="${sysInt.sysint_sno}">${sysInt.sysint_sname}</option>
                    </s:iterator>
                  </select>
                  <span style="color:red;">*</span>&nbsp;<span style="color:red;" id="msg">请选择系统！</span></div></td>
                </tr>
              <tr height="10%">
                <td align="right" nowrap style="color:red"><div align="left" >菜单排序</div></td>
                <td align="right" nowrap style="color:green"><div align="left">功能排序</div></td>
              </tr>
              <tr height="85%" >
                <td width="50%" align="right" valign="top" nowrap>
                	<div align="left">
                	<!-- 这里的ul的class名字一定要是ztree，不能更改 -->
	                		<ul id="tree1" class="ztree" style="display:none;">
	                		</ul></div></td>
                <td width="50%" align="right" valign="top" nowrap>
                	<div align="left">
                	<!-- 这里的ul的class名字一定要是ztree，不能更改 -->
	                		<ul id="tree2" class="ztree" style="display:none;">
	                		</ul></div></td>
              </tr>
 
             </table>
							</td>
      					</tr>
    				</table>
    				<table width="100%" border="0" cellspacing="0" cellpadding="0">
      				<tr>
        				<td  colspan="5" nowrap>
        					<div align="center">
        					  <input type="button" name="Submit" value="保存" class="button" onclick="toSave();"/>&nbsp;
							<input type="reset" name="Submit3" value="重置" class="button" />&nbsp;
							<input type="button" name="Submit2" value="返回" class="button" onclick="toBack();" id="back"/>
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

 