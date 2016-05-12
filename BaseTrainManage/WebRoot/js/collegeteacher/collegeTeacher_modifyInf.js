$(function(){
	var ct_no = getCookie("username");
	alert(ct_no);
	$.ajax({
		url:"http://localhost:8080/BaseTrainManage/collegeteacher/loadSelfInf.do",
		type:"post",
		data:{"ct_no":ct_no},
		dataType:"json",
		success:function(result){
			if(result.status==1){
				$("#name").val(result.data.ct_name);
				$("#sex").val(result.data.ct_sex);
				$("#birthday").val(result.data.ct_birthday);
				$("#academy").val(result.data.academy_no);
				$("#profession").val(result.data.ct_profession);
				$("#telephone").val(result.data.ct_phone);
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
		var sex = $("#sex").val();
		var birthday = $("#birthday").val();
		var academy = $("#academy").val();
		var profession = $("#profession").val();
		var phone = $("#telephone").val();
		
		$.ajax({
			url:"http://localhost:8080/BaseTrainManage/collegeteacher/modifySelfInf.do",
			type:"post",
			data:{"ct_no":ct_no,"ct_name":name,"ct_sex":sex,"academy_no":academy,
			"ct_profession":profession,"ct_birthday":birthday,"ct_phone":phone},
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