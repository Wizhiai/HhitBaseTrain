<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML>
<html>
  <head>
  	<meta content="">
    <title>超级管理员个人信息</title>
    <link rel="stylesheet" href="../../css/common.css"/>
    <link rel="stylesheet" href="../../css/index.css"/>
    <script type="text/javascript" src="../../js/jquery.min.js"></script>
    <script type="text/javascript" src="../../js/cookie_util.js"></script>
		<script type="text/javascript" src="../../js/admin/admin_modifyInf.js"></script>
  </head>
  <body>
  <div class="list">
 	 <div  class="modifyInfo" >
    	<span>姓&nbsp;&nbsp;&nbsp;名：&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" id="name"/></span><br/>
    	<span>联系方式：<input type="tel" id="telephone"/></span><br/>
    	<input type="button" value="修改" id="modify" class="editBtn">
    	<input type="button" value="保存" id="update" class="editBtn"/>
   </div>
  </div>
  </body>
</html>
