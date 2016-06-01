<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>添加用户</title>
    <link rel="stylesheet" href="../../css/common.css"/>
    <link rel="stylesheet" href="../../css/index.css"/>
    <script type="text/javascript" src="../../js/jquery.min.js"></script>
    <script type="text/javascript" src="../../js/menuchoose.js"></script>
		<script type="text/javascript" src="../../js/cookie_util.js"></script>
		<script type="text/javascript" src="../../js/userManage.js"></script>
		<script type="text/javascript" src="../../js/user/addUser.js"></script>
		<script type="text/javascript">
		</script>
  </head>
  <body>
  	<div class="list">
   		<div class="topContent">
	  		<h1>条件查询</h1>
	  		<select id="searchType">
	  			<option value="0" selected>请选择查询类型</option>
	  			<option value="1">通过账号添加用户</option>
	  			<option value="2">通过搜索添加用户</option>
	  		</select>
	  		<input type="text" id="username" placeholder="请输入账号"/>
	  		<select id="noType">
	  			<option value="1">学生</option>
	  			<option value="2">学校教师</option>
	  		</select>
	  		<select id="userType">
	  			<option value="0" selected>请选择用户类型</option>
	  			<option value="1">学生</option>
	  			<option value="2">学校教师</option>
	  		</select>
	  		<select id="stu_enter_year"></select>
	  		<select id="stu_major"><option value="" selected>请选择专业</option></select>
	  		<select id="stu_class"><option value="" selected>请选择班级</option></select>
	  		<select id="academy"><option value="" selected>请选择学院</option></select><br/><br/>
	  		<input type="button" id="search"  class="editBtn" value="查询"/>
  		</div>
  		<div class="searchResultInfo">
	  		<section class="tableShow">
	  			<table id="searchResult" class="appendStu">
	  			</table>
	  		</section>
  			<section class="btnLists">
	  			<input type="button" id="rightMove" value="&gt;"/><br/>
	  			<input type="button" id="rightAllMove" value="&gt;&gt;"/><br/>
	  			<input type="button" id="leftMove" value="&lt;"/><br/>
	  			<input type="button" id="leftAllMove" value="&lt;&lt;"/><br/>
	  			<input type="button" value="添加" id="addUser"/>
	  		</section>
	  		<section class="tableShow">
  				<table id="insertResult" class="appendStu"></table>
  			</section>
  		</div>
  		<div id="userSearchInform">
  			<table id="showInform">
	    	<thead>
	    	</thead>
	    	<tbody></tbody>
	    </table>
  		</div>
		</div>
  </body>
</html>
