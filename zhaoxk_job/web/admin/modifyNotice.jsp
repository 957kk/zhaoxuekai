<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>通知信息修改</title>
<script type="text/javascript" src="../ckeditor/ckeditor.js"></script>
<script src="../ckeditor/sample.js" type="text/javascript"></script>
<script type="text/javascript">
var editor = CKEDITOR.replace('editor1', { 
	filebrowserImageUploadUrl :"picture/editor/upload",
	removePlugins:'elementspath,resize',
	codeSnippet_theme: 'zenburn',
	height:'600'
});
</script>
<link rel="stylesheet" type="text/css" href="css/reception.css" />
</head>
<body>
<jsp:include page="top.jsp"></jsp:include>
	<h1 align="center">通知信息修改</h1>
	<div align="center" style="color:red;"><s:property value="msg" />
	<table>
   <tr>
   <td>
   <form action="notice_delete" method="post">
       <input type="hidden" name="noticeID" value="<s:property value="#parameters['noticeID']"/>"/>
       <input type="submit" value="删除该通知"/>
   </form>   
   </tr>
   </table>
   </div>
	<hr width="600">
	
	<div align="center">
	
  <form action="notice_updatePerson" method="post">
    	<input type="text" hidden="true"  name="noticeID" value="${session.notice_info[0]}"/>
<table style="border-collapse:collapse;width:800px;height:300px;border:1px solid blue;">
<tr><td>发布号</td><td><input type="text" name="number" value="${session.notice_info[1]}"/></td></tr><tr>

<tr><td>发布人</td><td><input type="text" name="username" value="${session.notice_info[2]}"/></td></tr><tr>
<tr><td>通知标题</td><td><input type="text" name="title" value="${session.notice_info[3]}"/></td></tr><tr>

<td>通知内容:</td><td><textarea class="ckeditor" cols="80" id="editor1" name="noticeContent" rows="8" > ${session.notice_info[4]}</textarea> </td></tr><tr>
<td>通知上传时间:</td><td><input type="text" readonly="readonly" name="submitTime" value="${session.notice_info[5]}"/></td></tr>
<tr>
<td align="center"colspan="2"><input type="submit" value="提交"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<input type="reset" value="重置"/></td>
</tr>

</table>
</form>
	</div>
	<jsp:include page="bottom.jsp"></jsp:include>
</body>
</html>