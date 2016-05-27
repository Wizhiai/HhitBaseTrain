var deleteResult =-1;
var insertResult = -1;
function selectHide(){/*隐藏用户类型后的选择条件*/
	$("#username").hide();
	$("#noType").hide();
	$("#userType").hide();
	$("#stu_enter_year").hide();
	$("#stu_major").hide();
	$("#stu_class").hide();
	$("#academy").hide();
}
function addStudentEnterYear(){//添加入学年份
	$.ajax({
		url:"http://localhost:8080/BaseTrainManage/student/searchEnteryear.do",
			type:"post",
			dataType:"json",
			success:function(result){
				if(result.status == 1){
					var data = result.data;
					for(var i=0;i<data.length;i++){
						var tr ="<option value="+data[i]+">"+data[i]+"</option>"
						$("#stu_enter_year").append($(tr));
					}
				}else{
					alert(result.msg);
				}
			},
			error:function(){
					alert("程序出错");
			}
	});
}
function addStudentMajor(){//添加专业
	$.ajax({
		url:"http://localhost:8080/BaseTrainManage/student/searchMajor.do",
			type:"post",
			dataType:"json",
			success:function(result){
				if(result.status == 1){
					var data = result.data;
					var tr ="";
					for(var i=0;i<data.length;i++){
						tr +="<option value="+data[i]+">"+data[i]+"</option>"
					}
					$("#stu_major").append($(tr));
				}else{
					alert(result.msg);
				}
			},
			error:function(){
					alert("程序出错");
			}
	});
}
function addStudentClass(){//添加班级
	var major = $("#stu_major option:selected").val();
	if(major != ""){
		$.ajax({
		url:"http://localhost:8080/BaseTrainManage/student/searchClass.do",
			type:"post",
			data:{"major":major},
			dataType:"json",
			success:function(result){
				if(result.status == 1){
					var data = result.data;
					var tr ="";
					for(var i=0;i<data.length;i++){
						tr +="<option value="+data[i]+">"+data[i]+"</option>"
					}
					$("#stu_class").append($(tr));
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
function addAcademy(){//添加学院
	$.ajax({
	url:"http://localhost:8080/BaseTrainManage/collegeteacher/searchAcademy.do",
		type:"post",
		dataType:"json",
		success:function(result){
			if(result.status == 1){
				var data = result.data;
				var tr ="";
				for(var i=0;i<data.length;i++){
					tr +="<option value="+data[i].academy_no+">"+data[i].academy_name+"</option>"
				}
				$("#academy").append($(tr));
			}else{
				alert(result.msg);
			}
		},
		error:function(){
				alert("程序出错");
		}
	});
}
function searchUserforAdd(){//查询要添加用户
	var searchType = $("#searchType").val();
	if(searchType == 0){
		selectHide();
		alert("请选择用户类型");
	}else if(searchType == 1){//账号添加
		var username = $("#username").val();
		if(username == ""){
			alert("请输入用户账号！");
		}else{
			var noType = $("#noType").val();
			if(noType ==1){//学生
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
							td += "<td><input type='hidden' id='userno' value ='"+data.stuno+"'/>";
							td += "<input type='button' onclick='addUserByNo()' value='添加用户' class='btn'/></td></tr>";
							$("#showInform tbody tr").remove();
							$("#showInform tbody").append($(td));
							$("#userSearchInform").show();
						}else{
							$("#userSearchInform").hide();
							alert(result.msg);
						}
					},
					error:function(){
							alert("程序出错");
					}
				});
			}else if(noType ==2){
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
							td += "<td><input type='hidden' id='userno' value ='"+data.ct_no+"'/>";
							td += "<input type='button' onclick='addUserByNo()' value='添加用户' class='btn'/></td></tr>";
							$("#showInform tbody tr").remove();
							$("#showInform tbody").append($(td));
							$("#userSearchInform").show();
						}else{
							$("#userSearchInform").hide();
							alert(result.msg);
						}
					},
					error:function(){
							alert("程序出错");
					}
				});
			}
		}
	}else if(searchType == 2){
		var userType = $("#userType").val();
		if(userType == 0){
			alert("请选择用户类型");
		}else if(userType == 1){//学生
			$("#insertResult tr").remove();
			var enter_year = $("#stu_enter_year option:selected").val();
			var major = $("#stu_major option:selected").val();
			var stu_class = $("#stu_class option:selected").val();
			$.ajax({
	  			url:"http://localhost:8080/BaseTrainManage/student/searchStudentUser.do",
				type:"post",
				data:{"enter_year":enter_year,"major":major,"stu_class":stu_class},
				dataType:"json",
				success:function(result){
					if(result.status == 1){
						var data = result.data;
						var tr ="";
						for(var i=0;i<data.length;i++){
							tr += "<tr><td onclick ='chooseSearchResult(this)'><input type='hidden' value='"+data[i].stuno+"'/>"+data[i].stu_name+"</td></tr>";
						}
						$("#searchResult tr").remove();
						$("#searchResult").append($(tr));
						$(".searchResultInfo").show();
					}else{
						$(".searchResultInfo").hide();
						alert(result.msg);
					}
				},
				error:function(){
						alert("程序出错");
				}
			});
		}else if(userType == 2){//教师
			var academy_no = $("#academy option:selected").val();
			$("#insertResult tr").remove();
			$.ajax({
	  			url:"http://localhost:8080/BaseTrainManage/teacher/searchTeacherUser.do",
	  			data:{"academy_no":academy_no},
				type:"post",
				dataType:"json",
				success:function(result){
					if(result.status == 1){
						var data = result.data;
						var tr ="";
						for(var i=0;i<data.length;i++){
							tr += "<tr><td onclick ='chooseSearchResult(this)'><input type='hidden' value='"+data[i].ct_no+"'/>"+data[i].ct_name+"</td></tr>";
							//tr +="<option value="+data[i].ct_no+">"+data[i].ct_name+"</option>";
						}
						$("#searchResult tr").remove();
						$("#searchResult").append($(tr));
						$(".searchResultInfo").show();
					}else{
						$(".searchResultInfo").hide();
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
function searchUserforDelete(){//查询要删除的用户
	var searchType = $("#searchType").val();
	if(searchType == 0){
		selectHide();
		alert("请选择用户类型");
	}else if(searchType == 1){//账号添加
		var username = $("#username").val();
		if(username == ""){
			alert("请输入用户账号！");
		}else{
			var noType = $("#noType").val();
			if(noType ==1){//学生
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
							td += "<td><input type='hidden' id='userno' value ='"+data.stuno+"'/>";
							td += "<input type='button' onclick='deleteUserByNo(this)' value='删除用户' class='btn'/></td></tr>";
							$("#showInform tbody tr").remove();
							$("#showInform tbody").append($(td));
							$("#userSearchInform").show();
						}else{
							$("#userSearchInform").hide();
							alert(result.msg);
						}
					},
					error:function(){
							alert("程序出错");
					}
				});
			}else if(noType ==2){
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
							td += "<td><input type='hidden' id='userno' value ='"+data.ct_no+"'/>";
							td += "<input type='button' onclick='deleteUserByNo(this)' value='删除用户' class='btn'/></td></tr>";
							$("#showInform tbody tr").remove();
							$("#showInform tbody").append($(td));
							$("#userSearchInform").show();
						}else{
							$("#userSearchInform").hide();
							alert(result.msg);
						}
					},
					error:function(){
							alert("程序出错");
					}
				});
			}
		}
	}else if(searchType == 2){
		var userType = $("#userType").val();
		if(userType == 0){
			alert("请选择用户类型");
		}else if(userType == 1){//学生
			$("#insertResult tr").remove();
			var enter_year = $("#stu_enter_year option:selected").val();
			var major = $("#stu_major option:selected").val();
			var stu_class = $("#stu_class option:selected").val();
			$.ajax({
	  			url:"http://localhost:8080/BaseTrainManage/student/searchStudentUser.do",
				type:"post",
				data:{"enter_year":enter_year,"major":major,"stu_class":stu_class},
				dataType:"json",
				success:function(result){
					if(result.status == 1){
						var data = result.data;
						var tr ="";
						for(var i=0;i<data.length;i++){
							tr += "<tr><td onclick ='chooseSearchResult(this)'><input type='hidden' value='"+data[i].stuno+"'/>"+data[i].stu_name+"</td></tr>";
						}
						$("#searchResult tr").remove();
						$("#searchResult").append($(tr));
						$(".searchResultInfo").show();
					}else{
						$(".searchResultInfo").hide();
						alert(result.msg);
					}
				},
				error:function(){
						alert("程序出错");
				}
			});
		}else if(userType == 2){//教师
			var academy_no = $("#academy option:selected").val();
			$("#insertResult tr").remove();
			$.ajax({
	  			url:"http://localhost:8080/BaseTrainManage/teacher/searchTeacherUser.do",
	  			data:{"academy_no":academy_no},
				type:"post",
				dataType:"json",
				success:function(result){
					if(result.status == 1){
						var data = result.data;
						var tr ="";
						for(var i=0;i<data.length;i++){
							tr += "<tr><td onclick ='chooseSearchResult(this)'><input type='hidden' value='"+data[i].ct_no+"'/>"+data[i].ct_name+"</td></tr>";
							//tr +="<option value="+data[i].ct_no+">"+data[i].ct_name+"</option>";
						}
						$("#searchResult tr").remove();
						$("#searchResult").append($(tr));
						$(".searchResultInfo").show();
					}else{
						$(".searchResultInfo").hide();
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
function chooseSearchResult(obj){
	$(obj).toggleClass("changeColor");
}
function resultRightMove(){//右移

	$("#searchResult td").each(function(){
		if($(this).hasClass("changeColor")){
			$(this).removeClass("changeColor").parent().clone().appendTo("#insertResult");
			$(this).remove();
		}
	});
}
function insertLeftMove(){//左移
	$("#insertResult td").each(function(){
		if($(this).hasClass("changeColor")){
			$(this).removeClass("changeColor").parent().clone().appendTo("#searchResult");
			$(this).remove();
		}
	});
}
function resultAllRightMove(){//全部右移
	
	$("#searchResult td").each(function(){
		
		$(this).removeClass("changeColor").parent().clone().appendTo("#insertResult");
		$(this).remove();
	});
}
function resultAllLeftMove(){//全部左移
	$("#insertResult td").each(function(){
		$(this).removeClass("changeColor").parent().clone().appendTo("#searchResult");
		$(this).remove();
	});
}
function addUser(){//添加用户函数
	
	var tds = $("#insertResult td");
	var length = tds.length;
	if(length == 0){
		alert("请选择要添加的用户！");
	}else{
		$("#insertResult td").each(function(){
			var username = $(this).find("input").val();
			var name = $(this).text();
			//alert(username+","+name);
			insertResult = -1;
			insertUser(username,name);
			if(insertResult == 1){
				$(this).parent("tr").remove();
			}			
		});
		alert("需要添加的总用户记录条数为："+length+",添加成功的记录条数为："+addResult);
	}
	
}

function insertUser(username,name){//向数据库中添加用户
	var userType = $("#userType").val();
	var identity = -1;
	if(userType == 1){
		identity = 4;//学生
	}else if(userType == 2){
		identity = 3;//教师
	}
	$.ajax({
  		url:"http://localhost:8080/BaseTrainManage/user/addUser.do",
  		data:{"username":username,"identity":identity},
		type:"post",
		dataType:"json",
		async:false,
		success:function(result){
			if(result.status == 0){//插入失败
				insertResult = 0;
				alert(result.msg+"姓名为:"+name+"的记录已经存在，记录插入失败！");
			}else{
				insertResult = 1;
				addResult = addResult+parseInt(1);
			}
		},
		error:function(){
				alert("程序出错");
		}
	});
}
function removeUser(){//删除用户函数
	if(confirm("确定退出删除？")){
		var tds = $("#insertResult td");
		var length = tds.length;
		if(length == 0){
			alert("请选择要删除的用户！");
		}else{
			$("#insertResult td").each(function(){
				var username = $(this).find("input").val();
				var name = $(this).text();
				deleteResult = -1;
				deleteUser(username,name);
				if(deleteResult == 1){
					$(this).parent("tr").remove();
				}
			});
			alert("需要删除的总用户记录条数为："+length+",删除成功的记录条数为："+addResult);
		}
	}
	
}
function deleteUser(username,name){//从数据库删除用户
	$.ajax({
  		url:"http://localhost:8080/BaseTrainManage/user/deleteUser.do",
  		data:{"username":username},
		type:"post",
		dataType:"json",
		async:false,
		success:function(result){
			if(result.status != 0){//删除成功
				deleteResult = 1;
				addResult = addResult+parseInt(1);
			}else{
				deleteResult = 0;
				alert("姓名为:"+name+"的"+result.msg+"删除失败！");
			}
		},
		error:function(){
				alert("程序出错");
		}
	});
}
function addUserByNo(){//通过账号添加用户
	var userno = $("#userno").val();
	var noType = $("#noType").val();
	var identity = -1;
	if(noType == 1){
		identity = 4;//学生
	}else if(noType == 2){
		identity = 3;//教师
	}
	$.ajax({
  		url:"http://localhost:8080/BaseTrainManage/user/addUser.do",
  		data:{"username":userno,"identity":identity},
		type:"post",
		dataType:"json",
		success:function(result){
			if(result.status == 0){//插入失败
				alert("记录已经存在，插入失败！");
			}else{
				alert(result.msg);
			}
		},
		error:function(){
				alert("程序出错");
		}
	});
}
function deleteUserByNo(obj){//通过账号删除用户
	if(confirm("确定退出删除？")){
		var userno = $("#userno").val();
		var noType = $("#noType").val();
		var identity = -1;
		if(noType == 1){
			identity = 4;//学生
		}else if(noType == 2){
			identity = 3;//教师
		}
		$.ajax({
	  		url:"http://localhost:8080/BaseTrainManage/user/deleteUser.do",
	  		data:{"username":userno},
			type:"post",
			dataType:"json",
			success:function(result){
				if(result.status != 0){//删除成功
					alert(result.msg);
					$(obj).parent("tr").remove();
				}else{
					alert(result.msg+"删除失败！");
				}
			},
			error:function(){
					alert("程序出错");
			}
		});
	}
	
}