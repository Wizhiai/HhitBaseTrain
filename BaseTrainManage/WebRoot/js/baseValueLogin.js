$(function(){
	$("#login").click(function(){
		
		var username = $("#id").val();
		var password = $("#pwd").val();
		var type = $("#type").val();

//		alert(username+","+ password);
		if(username == "" || password == ""){
			alert("用户名或密码不能为空");
		}else{
			
			$.ajax({
				
				url:"http://localhost:8080/BaseTrainManage/login.do",
				type:"post",
				async:false,
				data:{"username":username,"password":password},
				dataType:"json",
				success:function(result){

				
					alert(result.msg);
					
					
					if(result.status == 1){
						  document.forms[0].method="post";
document.forms[0].action="http://localhost:8080/BaseTrainManage/jsp/asSystem.jsp?id="+username;
document.forms[0].submit();
//								document.forms[0].action ="http://localhost:8080/BaseTrainManage/jsp/asSystem.jsp";
//window.location.href = "http://localhost:8080/BaseTrainManage/jsp/asSystem.jsp?id="+username;
					}
					
				},
				error:function(){
					alert("程序出错");
				}
			});
		}
  });
});