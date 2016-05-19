<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
  <head>
  	<meta content="">
    <title>My JSP 'admin_modifyInf.jsp' starting page</title>
     <link rel="stylesheet" href="../../css/common.css"/>
    <link rel="stylesheet" href="../../css/index.css"/>
    <script type="text/javascript" src="../../js/jquery.min.js"></script>
    <script type="text/javascript" src="../../js/cookie_util.js"></script>
		<script type="text/javascript" src="../../js/baseadmin/baseadmin_modifyInf.js"></script>
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
