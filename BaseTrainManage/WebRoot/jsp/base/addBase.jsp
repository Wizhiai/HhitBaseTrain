<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>添加基地</title>
    <link rel="stylesheet" href="../../css/common.css"/>
        <link rel="stylesheet" type="text/css" href="../../css/base.css"/>
		<script type="text/javascript" src="../../js/jquery.min.js"></script>
    <script type="text/javascript" src="../../js/menuchoose.js"></script>
		<script type="text/javascript" src="../../js/cookie_util.js"></script>
		<script type="text/javascript" src="../../js/base/addBase.js"></script>
 	<script type="text/javascript">
 		
 	</script>
 	
  </head>
  
  <body>
    <div class="list">
	  	<div class="topContent">
	  		<h1>请输入基地名</h1>
	  		<input type="text" id="base_name"/><span id="msg"></span>
	  		<h1>请输入基地地址</h1>
	  		<input type="text" id="base_address"/><br/>
	   	 <input type="button" value="添加" id="add" class="editBtn" style="margin-top: 30px;"/>
	   	</div>
    </div>
  </body>
</html>
