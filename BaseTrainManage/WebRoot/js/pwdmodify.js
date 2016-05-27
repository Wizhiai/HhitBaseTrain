$(function(){
	var username = getCookie("username");
	$("#oldpwd").attr("disabled","true");
	$("#newpwd").attr("disabled","true");
	$("#newpwd2").attr("disabled","true");
	$("#update").attr("disabled","true");
	$("#update").addClass("btn_disabled");
	
	$("#modify").click(function(){
		$("#oldpwd").removeAttr("disabled");
		$("#newpwd").removeAttr("disabled");
		$("#newpwd2").removeAttr("disabled");
		$("#update").removeAttr("disabled");
		$("#update").removeClass("btn_disabled");
	});
	
	$("#update").click(function(){
		var oldPwd = $("#oldpwd").val();
		var newPwd = $("#newpwd").val();
		var newPwd2 = $("#newpwd2").val();
		var username = getCookie("username");
		if(username == "" || username ==null){
			alert("页面失效，请重新登录！");
			return;
		}
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