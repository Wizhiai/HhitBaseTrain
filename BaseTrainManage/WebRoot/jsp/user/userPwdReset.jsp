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
			$(function(){
				$("#showInform").hide();
				$("#search").click(function(){
					searchPwdResetUser();
				});
			});
			function searchPwdResetUser(){
				var username = $("#username").val();
				var userType = $("#userType").val();
				if(username ==　""){
					alert("请输入用户账号！");
				}else if(userType == 0){
					alert("请选择用户身份！");
				}else if(username !=　"" & userType != 0){//账号不为空且用户身份类别不为空
					if(userType ==1){//学生
						var tr = "<tr><th>姓名</th><th>性别</th><th>班级</th><th>专业</th><th>操作</th></tr>";
						$("#showInform thead tr").remove();
						$("#showInform thead").append($(tr));
						$.ajax({
							url:"http://localhost:8080/BaseTrainManage/user/searchStudentUserInfo.do",
								type:"post",
								data:{"username":username},
								dataType:"json",
								success:function(result){
									if(result.status == 1){
										var data = result.data;
										var td = "<tr><td>"+data.stu_name+"</td><td>"+data.stu_sex+"</td>";
										td += "<td>"+data.stu_class+"</td><td>"+data.major+"</td>";
										td += "<td><input type='hidden' id='username' value ="+data.stuno+"/>";
										td += "<input type='button' onclick='pwdReset()' value='密码重置' class='btn'/></td></tr>";
										$("#showInform tbody tr").remove();
										$("#showInform tbody").append($(td));
										$("#showInform").show();
									}else{
										$("#showInform").hide();
										alert(result.msg);
									}
								},
								error:function(){
										alert("程序出错");
								}
						});
					}else if(userType ==2){
						var tr = "<tr><th>姓名</th><th>性别</th><th>职称</th><th>联系方式</th><th>操作</th></tr>";
						$("#showInform thead tr").remove();
						$("#showInform thead ").append($(tr));
						$.ajax({
							url:"http://localhost:8080/BaseTrainManage/user/searchCollegeTeacherUserInfo.do",
								type:"post",
								data:{"username":username},
								dataType:"json",
								success:function(result){
									if(result.status == 1){
										var data = result.data;
										var td = "<tr><td>"+data.ct_name+"</td><td>"+data.ct_sex+"</td>";
										td += "<td>"+data.ct_profession+"</td><td>"+data.ct_phone+"</td>";
										td += "<td><input type='hidden' id='username' value ="+data.ct_no+"/>";
										td += "<input type='button' onclick='pwdReset()' value='密码重置' class='btn'/></td></tr>";
										$("#showInform tbody tr").remove();
										$("#showInform tbody").append($(td));
										$("#showInform").show();
									}else{
										alert(result.msg);
									}
								},
								error:function(){
										alert("程序出错");
								}
						});
					}
				}
			}
			
			function pwdReset(){//密码重置
				var username = $("#username").val();
				$.ajax({
			  	url:"http://localhost:8080/BaseTrainManage/user/resetPwd.do",
			  	data:{"username":username},
					type:"post",
					dataType:"json",
					async:false,
					success:function(result){
						if(result.status != 0){//密码重置成功
							alert(result.msg);
						}else{
							alert(result.msg);
						}
					},
					error:function(){
							alert("程序出错");
					}
				});
			}
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
