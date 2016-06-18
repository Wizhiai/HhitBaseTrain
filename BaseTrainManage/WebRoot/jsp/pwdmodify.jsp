<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>修改密码</title>
    <link rel="stylesheet" href="../css/common.css"/>
    <link rel="stylesheet" href="../css/index.css"/>
    <script type="text/javascript" src="../js/jquery.min.js"></script>
    <script type="text/javascript" src="../js/cookie_util.js"></script>
    <script type="text/javascript" src="../js/pwdmodify.js"></script>
  </head>
  
  <body>
  <div class="list">
 	 <div  class="modifyInfo" >
    	<span>原&nbsp;密&nbsp;码&nbsp;：<input type="password" id="oldpwd"/></span><br/>
    	<span>新&nbsp;密&nbsp;码&nbsp;：<input type="password" id="newpwd"/></span><br/>
    	<span>确认密码：<input type="password" id="newpwd2"/></span><br/>
    	<input type="button" class="editBtn" value="修改" id="modify">
    	<input type="button" class="editBtn" value="保存" id="update">
   </div>
  </div>
  </body>
</html>
