<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>My JSP 'question.jsp' starting page</title>
    <link rel="stylesheet" href="../../css/common.css"/>
    <link rel="stylesheet" href="../../css/index.css"/>
    <script type="text/javascript" src="../../js/jquery.min.js"></script>
    <script type="text/javascript" src="../../js/menuchoose.js"></script>
		<script type="text/javascript" src="../../js/cookie_util.js"></script>
		<script type="text/javascript" src="../../js/userManage.js"></script>
		<script type="text/javascript">
			var addResult = parseInt(0);
			$(function(){
				selectHide();
				$(".searchResultInfo").hide();
				$("#userType").change(function(){
					var userType = $("#userType").val();
					if(userType == 0){
						alert("请选择用户类型");
					}else if(userType == 1){//学生
						selectHide();
						addStudentEnterYear();//添加入学年份
						addStudentMajor();//添加专业
						$("#stu_enter_year").show();
						$("#stu_major").show();
						$("#stu_class").show();
					}else if(userType == 2){//教师
						selectHide();
						addAcademy();//添加学院
						$("#academy").show();
					}
				});
				$("#stu_major").change(function(){//专业改变触发班级改变事件
					$("#stu_class option:first").next().remove();
					addStudentClass();//添加班级
				});
				$("#search").click(function(){//查找用户
					searchUser();
					if($("#userType").val() != 0){
						$(".searchResultInfo").show();
					}
				});
				$("#rightMove").click(function(){//右移
					resultRightMove();
				});
				$("#rightAllMove").click(function(){//全部右移
					resultAllRightMove();
				});
				$("#leftMove").click(function(){//左移
					insertLeftMove();
				});
				$("#leftAllMove").click(function(){//全部左移
					resultAllLeftMove();
				});
				$("#deleteUser").click(function(){//删除用户
					removeUser();
				});
			});
			
		</script>
  </head>
  
  <body>
  	<div class="list">
   		<div class="topContent">
	  		<h1>条件查询</h1>
	  		<select id="userType">
	  			<option value="0" selected>请选择用户类型</option>
	  			<option value="1">学生</option>
	  			<option value="2">学校教师</option>
	  		</select>
	  		<select id="stu_enter_year"></select>
	  		<select id="stu_major"><option value="" selected>请选择专业</option></select>
	  		<select id="stu_class"><option value="" selected>请选择班级</option></select>
	  		<select id="academy"><option value="" selected>请选择学院</option></select>
	  		<input type="button" id="search" class="editBtn" value="查询"/>
  		</div>
  		<div class="searchResultInfo">
  			<section class="tableShow">
	  			<table id="searchResult" class="appendStu">
	  			</table>
	  		</section>
  			<section class="btnLists">
	  			<input type="button" id="rightMove" value=">"/><br/>
	  			<input type="button" id="rightAllMove" value=">>"/><br/>
	  			<input type="button" id="leftMove" value="<"/><br/>
	  			<input type="button" id="leftAllMove" value="<<"/><br/>
	  			<input type="button" value="删除" id="deleteUser"/>
	  		</section>
	  		<section class="tableShow">
  				<table id="insertResult" class="appendStu"></table>
  			</section>
  		</div>
		</div>
  </body>
</html>
