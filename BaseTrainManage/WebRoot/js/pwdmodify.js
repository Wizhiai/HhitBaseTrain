$(function(){
	var username = getCookie("username");
	alert(username);
	$("#modify").click(function(){
		var oldPwd = $("#oldpwd").val();
		var newPwd = $("#newpwd").val();
		alert(oldPwd+newPwd);
		$.ajax({
			url:"http://localhost:8080/BaseTrainManage/mofifyPwd.do",
			type:"post",
			data:{"username":username,"oldPwd":oldPwd,"newPwd":newPwd},
			dataType:"json",
			success:function(result){
				alert(result.status+result.msg);
			},
			error:function(){
				alert("程序出错！");
			}
	});
	});
			
});