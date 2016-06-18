var addResult = parseInt(0);
$(function(){
	selectHide();
	$(".searchResultInfo").hide();
	$("#userSearchInform").hide();
	$("#searchType").change(function(){
		$("#userType option:first").attr("selected","true");
		$("#stu_major option:first").attr("selected","true");
		$("#stu_class option:first").attr("selected","true");
		$("#academy option:first").attr("selected","true");
		$("#username").val("");
		var searchType = $("#searchType").val();
		if(searchType == 0){
			selectHide();
			alert("请选择查询类型！");
		}else if(searchType == 1){
			selectHide();
			$("#username").show();
			$("#noType").show();
		}else if(searchType == 2){
			selectHide();
			$("#userType").show();
		}
	});
	$("#userType").change(function(){
		var userType = $("#userType").val();
		if(userType == 0){
			alert("请选择用户类型");
		}else if(userType == 1){//学生
			selectHide();
			$("#userType").show();
			addStudentEnterYear();//添加入学年份
			addStudentMajor();//添加专业
			$("#stu_enter_year").show();
			$("#stu_major").show();
			$("#stu_class").show();
		}else if(userType == 2){//教师
			selectHide();
			$("#userType").show();
			addAcademy();//添加学院
			$("#academy").show();
		}
	});
	$("#stu_major").change(function(){//专业改变触发班级改变事件
		$("#stu_class option:first").next().remove();
		addStudentClass();//添加班级
	});
	
	$("#search").click(function(){//查找用户
		//if($("#searchType").val() == 2){
			$("#userSearchInform").hide();
			$(".searchResultInfo").hide();
		//}else if($("#searchType").val() == 1){
			$(".searchResultInfo").hide();
			$("#userSearchInform").hide();
		//}
		searchUserforAdd();
		
	});
	$("#rightMove").click(function(){
		resultRightMove();
	});
	$("#rightAllMove").click(function(){//全部右移
		resultAllRightMove();
	});
	$("#leftMove").click(function(){//左移
		insertLeftMove();
	});
	$("#leftAllMove").click(function(){//全部左移
		resultAllLeftMove();
	});
	$("#addUser").click(function(){
		addUser();
	});
});