$(function(){
	var placard_no = getCookie("placard_no");
	var ok = true;
	if(placard_no == "" ||placard_no == null){
		alert("页面已失效，请重新登录！");
		ok = false;
	}
	if(ok){
		$.ajax({
		url:"http://localhost:8080/BaseTrainManage/question/searchByPlacardNo.do",
			type:"post",
			data:{"placard_no":placard_no},
			dataType:"json",
			success:function(result){
				if(result.status == 1){
					$("#title").val(result.data.placard_title);
					$("#publish_time").val(result.data.publish_time);
					$("#base_name").val(result.data.base_name);
					$("#content").val(result.data.placard_content);
				}else{
					alert(result.msg);
				}
			},
			error:function(){
					alert("程序出错");
			}
		});
	}
	$("#close").click(function(){
		closeCurrentWindow();
	});
});