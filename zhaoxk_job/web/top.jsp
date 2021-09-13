<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>赵雪凯的网站</title>
<link rel="stylesheet" type="text/css" href="css/reception.css" />
</head>
<body>

<table width="1000" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td colspan="2" align="center"><img src="images/zxk.jpg" width="192" height="131" alt="赵雪凯" /></td>
    <td colspan="2" align="center" class="biaoti">赵雪凯的网站</td>
    <td colspan="2" align="center" class="biaoti"><p class="签名">山高人为峰</p>
    </td>
  </tr>
  <tr>
    <td colspan="6">&nbsp;</td>
  </tr>
  <tr>
    <td width="100" class="导航"><a href="index.jsp">首页</a></td>
    
               <s:if test="#session.userName!=''&&#session.userName!=null">	
               <td width="300" class="导航">	
		        <s:property value="#session.userName" />，欢迎你！ <a href="person.jsp">设置</a>
		        <a href="exit.jsp">退出</a>
		       </s:if>
		       <s:else>
		       <td width="150" class="导航">
		             <a href="login.jsp">登录</a></td>
		       <td width="150" class="导航"><a href="register.jsp">注册</a>  </td>        
		       </s:else>
    
    <td width="226" class="导航"><a href="newsMore.action">更多新闻</a></td>
    <td width="169" class="导航"><a href="noticeMore.jsp">更多通知</a></td>
    <!-- <td width="169" class="导航"><a onclick="SetHome(window.location)" href="javascript:void(0)">设为首页</a></td> -->
    <td width="168" class="导航"><a href="admin/login.jsp">后台管理</a></td>
  </tr>
  </table>
 <hr width="1024" />
</body>
</html>