function upDownMenu(obj){  
	$(obj).parent().find("ul li").css("background","url(../images/dict.png) no-repeat 0px 50%");//a连接的底色问题
	$(obj).parent().find("ul li a").css("padding-left","20px");
	if(!$(obj).parent().find("ul")){
		return false;
	}
	if($(obj).parent().find("ul").css("display")=='block'){
		$(obj).parent().find("ul").hide();
		$(obj).parent().removeClass().addClass("up");
	}else{
		$(obj).parent().find("ul").show();
		$(obj).parent().removeClass().addClass("down");//点击处添加css样式
		$(obj).parent().prevAll().find("ul").hide();
		$(obj).parent().prevAll().removeClass().addClass("up");//其他兄弟节点改变样式
		$(obj).parent().nextAll().find("ul").hide();
		$(obj).parent().nextAll().removeClass().addClass("up");
	}
}
function promptName(){
	var no = getCookie("username");
	var identity = getCookie("identity");
	if(identity == 0){//管理员
		$.ajax({
			url:"http://localhost:8080/BaseTrainManage/admin/findName.do",
			type:"post",
			data:{"no":no},
			dataType:"json",
			success:function(result){
				if(result.status==1){
					$("#name_show").html("欢迎你"+result.data);
				}else{
					alert(result.msg);
				}
			},
			error:function(){
				alert("程序出错");
			}
		});
	}else if(identity == 1){//基地管理员
		$.ajax({
			url:"http://localhost:8080/BaseTrainManage/baseadmin/findName.do",
			type:"post",
			data:{"manager_no":no},
			dataType:"json",
			success:function(result){
				if(result.status==1){
					$("#name_show").html("欢迎你"+result.data);
				}else{
					alert(result.msg);
				}
			},
			error:function(){
				alert("程序出错");
			}
		});
	}else if(identity == 2){//学校教师
		$.ajax({
			url:"http://localhost:8080/BaseTrainManage/collegeteacher/findName.do",
			type:"post",
			data:{"ct_no":no},
			dataType:"json",
			success:function(result){
				if(result.status==1){
					$("#name_show").html("欢迎你"+result.data);
				}else{
					alert(result.msg);
				}
			},
			error:function(){
				alert("程序出错");
			}
		});
	}else if(identity == 4){//学生
		$.ajax({
			url:"http://localhost:8080/BaseTrainManage/student/findName.do",
			type:"post",
			data:{"stuno":no},
			dataType:"json",
			success:function(result){
				if(result.status==1){
					$("#name_show").html("欢迎你"+result.data);
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