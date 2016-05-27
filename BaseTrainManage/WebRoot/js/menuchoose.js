function indexMenuManage(){  
	/*$("body").css("background","#dbecfb");
	$("body").css("height","100%");
	$("body").css("overflow","hidden");*/
	$(".secondMenu").css("display","none");
	/* 二级菜单的显示与隐藏  */
	$(".personInfo").click(function(){
		$(this).next(".secondMenu").slideToggle(1);
		$(this).siblings().next(".secondMenu").css("display","none");
	});
	$(".secondMenu li a").click(function(){
		$(this).addClass("changeColor").parent().siblings().children("a").removeClass("changeColor");
		$(this).parent().parent().siblings("ul").find("a").removeClass("changeColor");
	});
	$(".personInfo li a").click(function(){
		$(this).addClass("changeColor");
		$(this).parent().parent().siblings("ul").find("a").removeClass("changeColor");
	
	});
}
function isPageValid(obj){
	var username = getCookie("username");
	if(username == "" || username == null){
		alert("页面已失效，请从新登陆！");
		$(obj).removeAttr("href");
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
function exitSystem(){
	if(confirm("确定退出系统？")){
		window.location.href="../../index.jsp";
	}
}
function closeCurrentWindow(){
	window.close();
}