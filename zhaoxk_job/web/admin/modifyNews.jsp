<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>新闻信息修改</title>
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
	<h1 align="center">新闻信息修改</h1>
	<div align="center" style="color:red;"><s:property value="msg" />
	<table>
   <tr>
   <td>
   <form action="news_delete" method="post">
       <input type="hidden" name="newsID" value="<s:property value="#parameters['newsID']"/>"/>
       <input type="submit" value="删除该新闻"/>
   </form>   
   </tr>
   </table>
   </div>
	<hr width="600">
	
	<div align="center">
	
  <form action="news_updatePerson" method="post">
    	<input type="text" hidden="true"  name="newsID" value="${session.news_info[0]}"/>
<table style="border-collapse:collapse;width:800px;height:300px;border:1px solid blue;">
<tr><td>新闻标题:</td><td><input type="text" name="title" value="${session.news_info[1]}"/></td></tr><tr>
<td>新闻内容:</td><td><textarea class="ckeditor" cols="80" id="editor1" name="content" rows="8" > ${session.news_info[2]}</textarea> </td></tr><tr>
<td>新闻上传时间:</td><td><input type="text" readonly="readonly" name="submitTime" value="${session.news_info[3]}"/></td></tr><tr>
<td align="center"colspan="2"><input type="submit" value="提交"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<input type="reset" value="重置"/></td></tr>

</table>
</form>
	</div>
	<jsp:include page="bottom.jsp"></jsp:include>
</body>
</html>