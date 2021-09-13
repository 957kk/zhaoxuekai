<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>通知信息</title>

	<link rel="stylesheet" type="text/css" href="css/reception.css" />
</head>
<body>
<jsp:include page="top.jsp"></jsp:include>
<h1 align="center">通知信息</h1>
<hr width="1024">
<div align="center">

	<s:set var="noticeid" ><s:property value="#parameters['notice_id']"/> </s:set>

	<table style="border-collapse:collapse;width:800px;height:300px;border:1px solid blue;">
		<s:iterator value="#session.notice_list" id="st">

			<s:if test="#st.noticeID==#noticeid">
				<tr class="td_list">
					<td>发布号：</td><td align="left" style="width: 650px;">
					<s:property value="#st.number" /></td></tr>
				<tr class="td_list">
					<td>发布人：</td><td align="left" style="width: 650px;">
						${st.username}</td></tr>
				<tr class="td_list">
					<td>通知标题：</td><td align="left" style="width: 650px;">
					<s:property value="#st.title" /></td></tr>
				<tr class="td_list">
					<td>通知内容：</td><td align="left" style="width: 650px;">
						${st.noticeContent}</td></tr>
				<tr class="td_list">
					<td>通知发布时间：</td><td align="left" style="width:650px;">
					<s:property value="#st.submitTime" /></td>

				</tr>
			</s:if>

		</s:iterator>
	</table>

</div>
<jsp:include page="bottom.jsp"></jsp:include>
</body>
</html>