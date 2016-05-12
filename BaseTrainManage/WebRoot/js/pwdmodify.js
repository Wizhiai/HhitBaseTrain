$(function(){
	var username = getCookie("username");
	$("#modify").click(function(){
		var oldPwd = $("#oldpwd").val();
		var newPwd = $("#newpwd").val();
		var newPwd2 = $("#newpwd2").val();
		if(oldPwd ==""){
			alert("请输入原密码!");
			return;
			
		}
		if(newPwd ==""){
			alert("请输入新密码!");
			return;
			
		}
		if(newPwd2 ==""){
			alert("请输入确认密码!");
			return;
			
		}
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
					alert(result.msg);
				},
				error:function(){
					alert("程序出错！!");
				}
			});
		}
		
	});
			
});