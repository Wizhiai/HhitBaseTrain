$(function(){
/*	$("body").css("background","#dbecfb");
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
	$("#exit").click(function(){
		exitSystem();
	});
})