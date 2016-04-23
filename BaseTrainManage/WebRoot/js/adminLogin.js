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
					$("#msg").html(result.msg);
					addCookie("username",result.data.username,2);
					/*$.session.set("username",result.data.username);*/
					window.location.href="../jsp/adminIndex.jsp";
					
				},
				error:function(){
					alert("程序出错");
				}
			});
		}
  });
});