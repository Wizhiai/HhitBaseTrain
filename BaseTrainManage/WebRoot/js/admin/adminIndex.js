$(function(){
	indexMenuManage();
	promptName();
	$("ul li a").click(function(){
		isPageValid(this);
	});
	$("#exit").click(function(){
		exitSystem();
	});
})