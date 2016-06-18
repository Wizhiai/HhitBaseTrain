$(function(){
	$("#add").click(function(){
		var placard_title = $("#title").val();
		var placard_content = $("#content").val();
		if(placard_title =="" || placard_content == ""){
			alert("公告标题或公告内容不能为空！");
		}else if(placard_title !="" && placard_content != ""){
				addSchoolPlacard();
		}
	});
	$("#title").change(function(){
		isSchoolTitleExit();
	});
});
function isSchoolTitleExit(){
	var placard_title = $("#title").val();
	$.ajax({
		url:"http://localhost:8080/BaseTrainManage/schoolPlacard/findSchoolPlacardByTitle.do",
			type:"post",
			data:{"placard_title":placard_title},
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
function addSchoolPlacard(){
	var placard_title = $("#title").val();
	var placard_content = $("#content").val();
	var publish_author = getCookie("username");
	var ok = true;
	if(publish_author == "" ||publish_author == null){
		alert("页面已失效，请重新登录！");
		ok = false;
	}
	if(ok){
		$.ajax({
		url:"http://localhost:8080/BaseTrainManage/schoolPlacard/addPlacard.do",
			type:"post",
			data:{"placard_title":placard_title,"placard_content":placard_content,"publish_author":publish_author},
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