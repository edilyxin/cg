<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>打印测试</title>
</head>
<body>
<!-- javascritp 打印准备 -->
<div id="printdiv">

<table width="1200px" id="table1" class="table" border="0"
					cellpadding="0" cellspacing="1" bgcolor="#a8c7ce">
					<tr bgcolor="#CBE0FF" class="STYLE10">
						<th width="40px" height="20"><input type="checkbox"
							name="checkbox" id="checkbox" onclick="checkAll(this);" /></th>
						<th width="40px">序号</th>
						<th width="100px">院系</th>
						<th width="120px">附件</th>
						<th">项目名称</th>
						<th width="100px">项目负责人</th>
						<th width="80px">申报金额（万元）</th>
						<th width="120px">建议金额（万元）</th>
						<th width="120px">项目重要性</th>
						<th width="120px">专家意见</th>
						<th width="120px">导入时间</th>
					</tr>

					<tr bgcolor="#ffffff" class="STYLE19">
						<td width="40px" height="20"><input type="checkbox"
							name="checkbox" id="ibox" onclick="checkOne(this);" />
						</th>
						<th width="40px">1</th>
						<th width="100px">院系</th>
						<th width="120px">附件</th>
						<th">项目名称</th>
						<th width="100px">项目负责人</th>
						<th width="80px">申报金额（万元）</th>
						<th width="120px">建议金额（万元）</th>
						<th width="120px">项目重要性</th>
						<th width="120px">专家意见</th>
						<th width="120px">导入时间</th>
					</tr>
				</table>
</div>
</body>
</html>