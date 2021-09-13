<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>修改客户信息</title>
</head>
<body>
	<center>
		<s:form action="update" method="post">
			<!--定义表单-->
			<tr>
				<td colspan="2">
					<h1>
						<s:text name="修改客户信息" />
					</h1> <br /> <!--格式化文本数据--> <s:actionerror />
				</td>
			</tr>
			<td>客户ID：<s:property value="#parameters.cid" />
			</td>
			<s:textfield name="custom.cid" key="客户ID" required="true"></s:textfield>
			<s:textfield name="custom.name" key="客户名"></s:textfield>
			<s:password name="custom.password" key="密码"></s:password>
			<s:textfield name="custom.mobile" key="电话"></s:textfield>
			<s:textfield name="custom.email" key="邮箱"></s:textfield>

			<s:submit value="提交" />
			<s:reset value="重置" />
			<s:set />
		</s:form>
	</center>
</body>
</html>