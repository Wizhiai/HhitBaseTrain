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
		<script type="text/javascript">
			$(function(){
				selectHide();
				$("#userType").change(function(){
					var userType = $("#userType").val();
					alert(userType);
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
						$("#academy_no").show();
					}
				});
				$("#stu_major").change(function(){
					addStudentClass();//添加班级
				});
			});
			function selectHide(){/*隐藏用户类型后的选择条件*/
				$("#stu_enter_year").hide();
				$("#stu_major").hide();
				$("#stu_class").hide();
				$("#academy_no").hide();
			}
			function addStudentEnterYear(){//添加入学年份
				$.ajax({
		  			url:"http://localhost:8080/BaseTrainManage/student/searchEnteryear.do",
						type:"post",
						dataType:"json",
						success:function(result){
							if(result.status == 1){
								var data = result.data;
								for(var i=0;i<data.length;i++){
									var tr ="<option value="+data[i]+">"+data[i]+"</option>"
									$("#stu_enter_year").append($(tr));
								}
							}else{
								alert(result.msg);
							}
						},
						error:function(){
								alert("程序出错");
						}
				});
			}
			function addStudentMajor(){//添加专业
				$.ajax({
		  			url:"http://localhost:8080/BaseTrainManage/student/searchMajor.do",
						type:"post",
						dataType:"json",
						success:function(result){
							if(result.status == 1){
								var data = result.data;
								var tr ="<option selected>请选择专业</option>";
								for(var i=0;i<data.length;i++){
									tr +="<option value="+data[i]+">"+data[i]+"</option>"
									$("#stu_major").append($(tr));
								}
							}else{
								alert(result.msg);
							}
						},
						error:function(){
								alert("程序出错");
						}
				});
			}
			function addStudentClass(){//添加班级
				var major = $("#stu_major option:selected").val();
				$.ajax({
		  			url:"http://localhost:8080/BaseTrainManage/student/searchClass.do",
						type:"post",
						data:{"major":major},
						dataType:"json",
						success:function(result){
							if(result.status == 1){
								var data = result.data;
								var tr ="<option selected>请选择班级</option>";
								for(var i=0;i<data.length;i++){
								
									tr +="<option value="+data[i]+">"+data[i]+"</option>"
									$("#stu_class").append($(tr));
								}
							}else{
								alert(result.msg);
							}
						},
						error:function(){
								alert("程序出错");
						}
				});
			}
			
			function searchUser(){
				var userType = $("#userType").val();
				if(userType == 0){
					alert("请选择用户类型");
				}else if(userType == 1){//学生
					$("#stu_enter_year").show();
					$("#stu_major").show();
					$("#stu_class").show();
				}else if(userType == 2){//教师
					$("#academy_no").show();
				}
			}
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
	  		<select id="stu_major"></select>
	  		<select id="stu_class"></select>
	  		<select id="academy_no"><option>12</option></select>
	  		<input type="button" id="search" value="查询"/>
  		</div>
		</div>
  </body>
</html>
