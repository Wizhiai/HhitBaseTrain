<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>用户密码重置</title>
    <link rel="stylesheet" href="../../css/common.css"/>
    <link rel="stylesheet" href="../../css/index.css"/>
    <script type="text/javascript" src="../../js/jquery.min.js"></script>
    <script type="text/javascript" src="../../js/menuchoose.js"></script>
		<script type="text/javascript" src="../../js/cookie_util.js"></script>
		<script type="text/javascript" src="../../js/user/userPwdReset.js"></script>
		<script type="text/javascript">
			
		</script>
  </head>
  
  <body>
  	<div class="list">
   		<div class="topContent">
	  		<h1>请输入用户账号</h1>
	  		<input type="text" id="username" />
	  		<select id="userType">
	  			<option value="0" selected>请选择用户类型</option>
	  			<option value="1">学生</option>
	  			<option value="2">学校教师</option>
	  		</select>
	  		<input type="button" id="search" class="editBtn" value="查询"/>
  		</div>
  		<div id="placardInform">
  			<table id="showInform">
	    	<thead>
	    		<tr>
	    			<th>序号</th>
	    			<th>公告标题</th>
	    			<th>发布时间</th>
	    			<th>操作</th>
	    		</tr>
	    	</thead>
	    	<tbody></tbody>
	    </table>
  		</div>
		</div>
  </body>
</html>
