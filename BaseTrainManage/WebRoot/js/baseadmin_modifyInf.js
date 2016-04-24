$(function(){
	var manager_no = getCookie("username");
	alert(manager_no);
	$.ajax({
		url:"http://localhost:8080/BaseTrainManage/baseadmin/loadSelfInf.do",
		type:"post",
		data:{"manager_no":manager_no},
		dataType:"json",
		success:function(result){
			alert(result.status);
			if(result.status==1){
				$("#name").val(result.data.manager_name);
				$("#telephone").val(result.data.manager_phone);
			}else{
				alert(result.msg);
			}
		},
		error:function(){
			alert("程序出错");
		}
	});
	
	$("#modify").click(function(){
		var name = $("#name").val();
		var phone = $("#telephone").val();
		$.ajax({
			url:"http://localhost:8080/BaseTrainManage/baseadmin/modifySelfInf.do",
			type:"post",
			data:{"manager_no":manager_no,"manager_name":name,"manager_phone":phone},
			dataType:"json",
			success:function(result){
				alert(result.status+result.msg);
			},
			error:function(){
				alert("程序出错");
			}
		});
	});
});