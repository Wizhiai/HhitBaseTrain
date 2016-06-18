var stuno=null;
$(function(){
	var url=window.location;
	 stuno=getUrlParam(url,"stuno");
	$("#name").attr("disabled","true");
	$("#sex").attr("disabled","true");
	$("#cno").attr("disabled","true");
	$("#train_date").attr("disabled","true");
	$("#class").attr("disabled","true");
	$("#telephone").attr("disabled","true");
	$("#update").attr("disabled","true");
	$("#update").addClass("btn_disabled");
	
	$("#modify").click(function(){
		$("#telephone").removeAttr("disabled");
		$("#train_date").removeAttr("disabled");
		$("#cno").removeAttr("disabled");
		$("#class").removeAttr("disabled");
		$("#update").removeAttr("disabled");
		$("#update").removeClass("btn_disabled");
	});
	
	$.ajax({
		url:"http://localhost:8080/BaseTrainManage/trainstudnet/load.do",
		type:"post",
		data:{"sno":stuno},
		dataType:"json",
		success:function(result){
			if(result.status==1){
				
				$("#name").val(result.data.stu_name);
				$("#cno").val(result.data.cno);
				$("#sex").val(result.data.stu_sex);
				$("#train_date").val(result.data.train_date);
				$("#class").val(result.data.base_class);
				$("#telephone").val(result.data.phone);
				$("#address").val(result.data.address);
			}else{
				alert(result.msg);
			}
		},
		error:function(){
			alert("程序出错");
		}
	});
	
	$("#update").click(function(){
		var train_date = $("#train_date").val();
		var base_class = $("#class").val();
		var phone = $("#telephone").val();
		var cno = $("#cno").val();
		alert(phone);
		
		if(phone ==""||train_date==""){
			alert("联系方式不能为空！");
		}else if(phone !="" && train_date != ""){
			var re =new RegExp("^(13[0-9]|14[5|7]|15[0|1|2|3|5|6|7|8|9]|18[0|1|2|3|5|6|7|8|9])\\d{8}$|\\d{3}-\\d{8}");
			var result = re.test($("#telephone").val());
			if(result){//符合手机号码格式
				re = new RegExp("(([0-9]{3}[1-9]|[0-9]{2}[1-9][0-9]{1}|[0-9]{1}[1-9][0-9]{2}|[1-9][0-9]{3})-(((0[13578]|1[02])-(0[1-9]|[12][0-9]|3[01]))|((0[469]|11)-(0[1-9]|[12][0-9]|30))|(02-(0[1-9]|[1][0-9]|2[0-8]))))|((([0-9]{2})(0[48]|[2468][048]|[13579][26])|((0[48]|[2468][048]|[3579][26])00))-02-29)");
				result = re.test(train_date);
				if(result){//如果日期符合格式
					$.ajax({
						url:"http://localhost:8080/BaseTrainManage/baseadmin/modifytrainstudent.do",
						type:"post",
						data:{"stuno":stuno,"train_date":train_date,
						"base_class":base_class,"phone":phone,"cno":cno},
						dataType:"json",
						success:function(result){
							alert(result.msg);
						},
						error:function(){
							alert("程序出错");
						}
					});
				}else{
					alert("培训格式错误！");
				}
				
			}else{//不符合手机号码格式
				alert("联系方式格式错误！");
			}
		}
	});
});