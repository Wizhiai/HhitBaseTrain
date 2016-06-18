$(function(){
	$("#login").click(function(){
		
		var username = $("#username").val();
		var password = $("#password").val();
		
		if(username == "" || password == ""){
			alert("用户名或密码不能为空");
		}else{
			$.ajax({
				url:"/BaseTrainManage/login.do",
				type:"post",
				data:{"username":username,"password":password},
				dataType:"json",
				success:function(result){
					if(result.status == 1){
						
						if(result.data.identity == "1"){
							addCookie("username",result.data.username,2);
							addCookie("identity",result.data.identity,2);
							window.location.href="../../jsp/baseadmin/baseadminIndex.jsp";
						}else{
							alert("您没有权限进入系统！");
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
  });
	$("#back").click(function(){
		window.location.href="../../index.jsp";
	});
});