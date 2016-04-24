$(function(){
	var username = getCookie("username");
	$("#modify").click(function(){
		var oldPwd = $("#oldpwd").val();
		var newPwd = $("#newpwd").val();
		var newPwd2 = $("#newpwd2").val();
		
		if(oldPwd == newPwd){
			alert("新密码与原密码一致！");
		}else if(newPwd != newPwd2){
			alert("两次输入的新密码不一致！！！");
		}else{
			$.ajax({
				url:"http://localhost:8080/BaseTrainManage/mofifyPwd.do",
				type:"post",
				data:{"username":username,"oldPwd":oldPwd,"newPwd":newPwd},
				dataType:"json",
				success:function(result){
					alert(result.status+result.msg);
				},
				error:function(){
					alert("程序出错！!");
				}
			});
		}
		
	});
			
});