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
					if(result.status == 1){
						
						if(result.data.identity == "1"){
							$("#msg").html(result.msg);
							addCookie("username",result.data.username,2);
							window.location.href="../jsp/baseadminIndex.jsp";
						}else{
							alert("您没有权限进入系统！");
						}
					}
				},
				error:function(){
					alert("程序出错");
				}
			});
		}
  });
});