$(function(){
	var stuno = getCookie("username");
	$.ajax({
		url:"http://localhost:8080/BaseTrainManage/student/loadSelfInf.do",
		type:"post",
		data:{"stuno":stuno},
		dataType:"json",
		success:function(result){
			if(result.status==1){
				$("#name").val(result.data.stu_name);
				$("#sex").val(result.data.stu_sex);
				$("#birthday").val(result.data.birthday);
				$("#enter_year").val(result.data.enter_year);
				$("#major").val(result.data.major);
				$("#class").val(result.data.stu_class);
				$("#telephone").val(result.data.phone);
				$("#address").val(result.data.address);
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
		var sex = $("#sex").val();
		var birthday = $("#birthday").val();
		var enter_year = $("#enter_year").val();
		var major = $("#major").val();
		var stu_class = $("#class").val();
		var phone = $("#telephone").val();
		var address = $("#address").val();
		$.ajax({
			url:"http://localhost:8080/BaseTrainManage/student/modifySelfInf.do",
			type:"post",
			data:{"stuno":stuno,"stu_name":name,"stu_sex":sex,"birthday":birthday,"enter_year":enter_year,"major":major,
			"stu_class":stu_class,"phone":phone,"address":address},
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