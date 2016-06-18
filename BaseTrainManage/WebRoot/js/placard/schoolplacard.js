$(function(){
	var placard_no = getCookie("placard_no");
	$.ajax({
	url:"http://localhost:8080/BaseTrainManage/schoolPlacard/searchByPlacardNo.do",
		type:"post",
		data:{"placard_no":placard_no},
		dataType:"json",
		success:function(result){
			if(result.status == 1){
				$("#title").val(result.data.placard_title);
				$("#publish_time").val(result.data.publish_time);
				$("#content").val(result.data.placard_content);
			}else{
				alert(result.msg);
			}
		},
		error:function(){
				alert("程序出错");
		}
	});
	$("#close").click(function(){
		closeCurrentWindow();
	});
});