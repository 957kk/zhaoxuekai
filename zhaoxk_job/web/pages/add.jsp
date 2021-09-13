<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>添加客户</title>
<!--定义页面标题-->
</head>
<body>
	<center>
		<s:form action="add" method="post">
			<!--发送给名为add的action-->
			<!--定义表单-->
			<tr>
				<td colspan="2" align="center">
					<h1>
						<s:text name="欢迎注册" />
					</h1> <br /> <s:property value="exception.message" />
				</td>
			</tr>
			<s:textfield name="newcustom.name" label="姓名" required="true"></s:textfield>
			<s:password name="newcustom.password" label="密码" required="true"></s:password>
			<s:textfield name="newcustom.mobile" label="电话" required="true"></s:textfield>
			<s:textfield name="newcustom.email" label="邮箱"></s:textfield>

			<s:submit value="提交">
				<!--提交按钮-->
			</s:submit>
		</s:form>
	</center>
</body>
</html>