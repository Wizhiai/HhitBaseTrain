$(function(){
	/*$("body").css("background","#dbecfb");
	$("body").css("height","100%");
	$("body").css("overflow","hidden");
	$(".secondMenu").css("display","none");
	 二级菜单的显示与隐藏  
	$(".personInfo").click(function(){
		$(this).next(".secondMenu").slideToggle(1);
		$(this).siblings().next(".secondMenu").css("display","none");
	});*/
	indexMenuManage();
	promptName();
	$("ul li a").click(function(){
		isPageValid(this);
	});
	$("#searchBaseInfo").click(function(){
		showBaseInfo();
	});
	$("#manageBaseInfo").click(function(){
		manageBaseInfo();
	});
	$("#exit").click(function(){
		exitSystem();
	});
})
function showBaseInfo(){
	var manager_no = getCookie("username");
	var ok = true;
	if(manager_no == "" || manager_no == null){
		ok = false;
	}
	if(ok){
		$.ajax({
  		url:"http://localhost:8080/BaseTrainManage/baseadmin/findBaseNoBymanagerNo.do",
  		data:{"manager_no":manager_no},
			type:"post",
			dataType:"json",
			success:function(result){
				if(result.status == 1){
					var base_no = result.data;
					addCookie("base_no",base_no,2);
					window.open("../base/base.jsp");
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
function manageBaseInfo(){
	var manager_no = getCookie("username");
	var username = getCookie("username");
	var ok = true;
	if(username == "" || username == null){
		ok = false;
	}
	if(ok){
		$.ajax({
  		url:"http://localhost:8080/BaseTrainManage/baseadmin/findBaseNoBymanagerNo.do",
  		data:{"manager_no":manager_no},
			type:"post",
			dataType:"json",
			success:function(result){
				if(result.status == 1){
					var base_no = result.data;
					addCookie("base_no",base_no,2);
					window.open("../base/modifyBase.jsp");
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