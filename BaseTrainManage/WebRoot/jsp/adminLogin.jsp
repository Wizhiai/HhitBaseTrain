<%@ page contentType="text/html; charset=utf-8"%>
<html>
  <head>
  	<title>淮海工学院计算机工程学院实训教务在线</title>
  	<link rel="stylesheet" href="css/index.css"/>
  	<script type="text/javascript" src="../js/jquery.min.js"></script>
  	<script type="text/javascript" src="../js/adminLogin.js"></script>
  </head>
  <center>
  <body>
  	This is AdminLogin
  	<form>
  		用户名：<input type="text" id="username"/>
  		密码:<input type="password" id="password"/>
  		<input type="radio" id="identity_admin" name="user" value="1">1
			<input type="radio" name="user" value="2">2
			<input type="radio" name="user" value="3">3
  		
  	</form>
  	<input type="button" id="login" value="登录"/>
  	<span id="msg"></span>
  </body>
  </center>
</html>
