$(function(){
	var tr ="<option value='0'>请选择公告类型</option><option value='1'>基地公告</option><option value='3'>常见问题</option>";
	$("#placard_type").append($(tr));
	$("#add").click(function(){
		var placard_title = $("#title").val();
		var placard_content = $("#content").val();
		var placard_type = $("#placard_type option:selected").val();
		if(placard_type == 0){
			alert("请选择公告类型");
		}else{
			if(placard_title =="" || placard_content == ""){
				alert("公告标题或公告内容不能为空！");
			}else if(placard_title !="" && placard_content != ""){
					addBasePlacard();
			}
		}
		
	});
	$("#title").change(function(){
		isBaseTitleExit();
	});
});
function isBaseTitleExit(){
	var placard_title = $("#title").val();
	alert(placard_title);
	var publish_author = getCookie("username");
	var ok = true;
	if(publish_author == "" ||publish_author == null){
		alert("页面已失效，请重新登录！");
		ok = false;
	}
	if(ok){
		$.ajax({
		url:"http://localhost:8080/BaseTrainManage/basePlacard/findBasePlacardByTitle.do",
			type:"post",
			data:{"placard_title":placard_title,"publish_author":publish_author},
			dataType:"json",
			success:function(result){
				if(result.status == 0){//有相同标题的学校公告
					$("#msg").text(result.msg).css("color","red");
					$("#add").attr("disabled","true");
					$("#add").addClass("btn_disabled");
				}else{
					$("#msg").text("");
					$("#add").removeAttr("disabled");
					$("#add").removeClass("btn_disabled");
				}
			},
			error:function(){
					alert("程序出错");
			}
		});
	}
	
}
function addBasePlacard(){
	var placard_title = $("#title").val();
	var placard_content = $("#content").val();
	var placard_type = $("#placard_type option:selected").val();
	var publish_author = getCookie("username");
	var ok = true;
	if(publish_author == "" ||publish_author == null){
		alert("页面已失效，请重新登录！");
		ok = false;
	}
	if(ok){
		$.ajax({
		url:"http://localhost:8080/BaseTrainManage/basePlacard/addBasePlacard.do",
			type:"post",
			data:{"placard_title":placard_title,"placard_content":placard_content,"publish_author":publish_author,"placard_type":placard_type},
			dataType:"json",
			success:function(result){
				alert(result.msg);
			},
			error:function(){
					alert("程序出错");
			}
		});
	}
}