<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'pwdmodify.jsp' starting page</title>
    <script type="text/javascript" src="../js/jquery.min.js"></script>
    <script type="text/javascript" src="../js/cookie_util.js"></script>
    <script type="text/javascript" src="../js/pwdmodify.js"></script>
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  
  <body>
    	原密码：<input type="password" id="oldpwd"/><br/>
    	新密码：<input type="password" id="newpwd"/><br/>
    	确认密码：<input type="password" id="newpwd2"/><br/>
    	<input type="button" value="修改" id="modify">
    	<input type="button" value="返回" id="back">
  </body>
</html>
