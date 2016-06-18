$(function(){
	var no = getCookie("username");
	$.ajax({
		url:"/BaseTrainManage/admin/loadSelfInf.do",
		type:"post",
		data:{"no":no},
		dataType:"json",
		success:function(result){
			if(result.status==1){
				$("#name").val(result.data.name);
				$("#telephone").val(result.data.phone);
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
			url:"/BaseTrainManage/admin/modifySelfInf.do",
			type:"post",
			data:{"no":no,"name":name,"phone":phone},
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