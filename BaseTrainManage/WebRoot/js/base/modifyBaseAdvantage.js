$(function(){
	var base_no = getCookie("base_no");
 	if(base_no =="" || base_no ==null){
 		alert("页面已失效，请重新登录！");
 	}else{
 		showBaseAdvantageInfo();
		slide();
		$("#update").click(function(){
			updateBaseAdvantage();
		});
 	}
});
function showBaseAdvantageInfo(){
	var base_no = getCookie("base_no");
	$.ajax({
		url:"http://localhost:8080/BaseTrainManage/base/searchAdvantageByBaseNo.do",
		type:"post",
		data:{"base_no":base_no},
		dataType:"json",
		success:function(result){
			if(result.status == 1){//查询成功，显示基地基本信息
				if(result.data.base_advantage =="" || result.data.base_advantage ==null){
					$("#base_advantage").val("未填写");
				}else{
					$("#base_advantage").val(result.data.base_advantage);
				}
				
			}else{
				alert(result.msg);
			}
		},
		error:function(){
				alert("程序出错");
		}
	});
}
function updateBaseAdvantage(){
	var ok = true;
	var base_no = getCookie("base_no");
	if(base_no =="" || base_no ==null){
 		alert("页面已失效，请重新登录！");
 		ok = false;
 	}
	var base_advantage = $("#base_advantage").val();
	
	if(ok){
		$.ajax({
			url:"http://localhost:8080/BaseTrainManage/base/modifyAdvantageByBaseNo.do",
			type:"post",
			data:{"base_no":base_no,"base_advantage":base_advantage},
			dataType:"json",
			success:function(result){
				if(result.status == 1){//修改成功
					alert(result.msg);
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