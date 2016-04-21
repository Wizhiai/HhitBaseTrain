$(function(){
	$("#login").click(function(){
		
		var username = $("#username").val();
		var password = $("#password").val();
		var identity = -1;
		
		if($("#identity_admin :checked")){//管理员
			identity = 0;
		}else if($("#identity_baseadmin :checked")){//基地管理员
			identity = 1;
		}else if($("#school_teacher :checked")){//学校教师
			identity = 2;
		}else if($("#base_teacher :checked")){//基地教师
			identity = 3;
		}else if($("#studen :checked")){//学生
			identity = 4;
		}else if($("#studen :checked")){//专家
			identity = 7;
		}
		alert("identity"+identity);
		alert(username+","+ password);
		if(username == "" || password == ""){
			alert("用户名或密码不能为空");
		}else{
			$.ajax({
				url:"http://localhost:8080/BaseTrainManage/login.do",
				type:"post",
				data:{"username":username,"password":password,"identity":identity},
				dataType:"json",
				success:function(result){
					alert(result.msg);
					$("#msg").html(result.msg);
				},
				error:function(){
					alert("程序出错");
				}
			});
		}
  });
});