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