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
	$("#trainregist").click(function(){
		isRegist();
	});
	$("#exit").click(function(){
		exitSystem();
	});
});
function isRegist(){
	var stuno = getCookie("username");
	var ok = true;
	if(stuno == "" || stuno == null){
		ok = false;
	}
	if(ok){
		$.ajax({
			url:"http://localhost:8080/BaseTrainManage/student/isregist.do",
			type:"post",
			data:{"stuno":stuno},
			dataType:"json",
			success:function(result){
				if(result.status == 0){//已报名
					alert(result.msg);
					//$("#trainregist").attr("href","#");
				}else{//还未报名
					$("#businessfrm").attr("src","trainregist.jsp");
				}
			},
			error:function(){
					alert("程序出错");
			}
		});
	}
	
}