$(function(){
	$("#login").click(function(){
		var username = $("#username").val();
		var password = $("#password").val();
		alert(username+","+ password);
		if(username == "" || password == ""){
			alert("用户名或密码不能为空");
		}else{
			$.ajax({
				url:"http://localhost:8080/BaseTrainManage/login.do",
				type:"post",
				data:{"username":username,"password":password},
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