$(function(){
	$("#showInform").hide();
	$("#search").click(function(){
		searchPwdResetUser();
	});
});
function searchPwdResetUser(){
	var username = $("#username").val();
	var userType = $("#userType").val();
	if(username ==　""){
		alert("请输入用户账号！");
	}else if(userType == 0){
		alert("请选择用户身份！");
	}else if(username !=　"" & userType != 0){//账号不为空且用户身份类别不为空
		if(userType ==1){//学生
			var tr = "<tr><th>姓名</th><th>性别</th><th>班级</th><th>专业</th><th>操作</th></tr>";
			$("#showInform thead tr").remove();
			$("#showInform thead").append($(tr));
			$.ajax({
				url:"http://localhost:8080/BaseTrainManage/user/searchStudentUserInfo.do",
					type:"post",
					data:{"username":username},
					dataType:"json",
					success:function(result){
						if(result.status == 1){
							var data = result.data;
							var td = "<tr><td>"+data.stu_name+"</td><td>"+data.stu_sex+"</td>";
							td += "<td>"+data.stu_class+"</td><td>"+data.major+"</td>";
							td += "<td><input type='hidden' id='username' value ="+data.stuno+"/>";
							td += "<input type='button' onclick='pwdReset()' value='密码重置' class='btn'/></td></tr>";
							$("#showInform tbody tr").remove();
							$("#showInform tbody").append($(td));
							$("#showInform").show();
						}else{
							$("#showInform").hide();
							alert(result.msg);
						}
					},
					error:function(){
							alert("程序出错");
					}
			});
		}else if(userType ==2){
			var tr = "<tr><th>姓名</th><th>性别</th><th>职称</th><th>联系方式</th><th>操作</th></tr>";
			$("#showInform thead tr").remove();
			$("#showInform thead ").append($(tr));
			$.ajax({
				url:"http://localhost:8080/BaseTrainManage/user/searchCollegeTeacherUserInfo.do",
					type:"post",
					data:{"username":username},
					dataType:"json",
					success:function(result){
						if(result.status == 1){
							var data = result.data;
							var td = "<tr><td>"+data.ct_name+"</td><td>"+data.ct_sex+"</td>";
							td += "<td>"+data.ct_profession+"</td><td>"+data.ct_phone+"</td>";
							td += "<td><input type='hidden' id='username' value ="+data.ct_no+"/>";
							td += "<input type='button' onclick='pwdReset()' value='密码重置' class='btn'/></td></tr>";
							$("#showInform tbody tr").remove();
							$("#showInform tbody").append($(td));
							$("#showInform").show();
						}else{
							alert(result.msg);
						}
					},
					error:function(){
							alert("程序出错");
					}
			});
		}
	}
}

function pwdReset(){//密码重置
	var username = $("#username").val();
	$.ajax({
  	url:"http://localhost:8080/BaseTrainManage/user/resetPwd.do",
  	data:{"username":username},
		type:"post",
		dataType:"json",
		async:false,
		success:function(result){
			if(result.status != 0){//密码重置成功
				alert(result.msg);
			}else{
				alert(result.msg);
			}
		},
		error:function(){
				alert("程序出错");
		}
	});
}