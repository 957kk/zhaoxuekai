<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>显示客户信息</title>
</head>
<body>
	<center>
		<!--对包含的内容进行居中处理-->
		<h1>客户信息</h1>
		<table border="1" width="650">
			<!--定义表格-->
			<tr>
				<!--定义表格行-->
				<th>客户ID</th>
				<!--定义表头单元格-->
				<th >客户名</th>
				<th>客户电话</th>
				<th>客户邮箱</th>
				<th>是否删除</th>
				<th>是否修改</th>
			</tr>
			<s:iterator value="#request.customlist" id="st">
				<!--对集合元素迭代-->
				<tr>
					<td align="center"><s:property value="#st.cid" /></td>
					<td align="center"><s:property value="#st.name" /></td>
					<td align="center"><s:property value="#st.mobile" /></td>
					<td align="center"><s:property value="#st.email" /></td>
					<td><a
						href="delete.action?cid=<s:property value='#st.cid'/>">删除</a></td>
					<!--定义超链接-->
					<td><a href="pages/update.jsp?cid=<s:property value='#st.cid'/>">更新</a></td>
				</tr>
			</s:iterator>
		</table>
		<br> <s:a href="pages/add.jsp">添加客户</s:a>
		<!--定义超链接-->
	</center>
</body>
</html>