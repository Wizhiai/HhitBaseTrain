<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'admin_modifyInf.jsp' starting page</title>
		<link rel="stylesheet" type="text/css" href="styles.css">

  </head>
  <body>
    	姓名：<input type="text" id="name"/>
    	联系方式：<input type="text" id="telephone"/>
    	<input class="modify" type="button" value="修改">
    	<input class="back" type="button" value="返回">
  </body>
</html>
