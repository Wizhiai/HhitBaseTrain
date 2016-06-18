$(function(){
	var ct_no = getCookie("username");
	$("#name").attr("disabled","true");
	$("#sex").attr("disabled","true");
	$("#academy").attr("disabled","true");
	$("#profession").attr("disabled","true");
	$("#telephone").attr("disabled","true");
	$("#birthday").attr("disabled","true");
	$("#update").attr("disabled","true");
	$("#update").addClass("btn_disabled");
	
	$("#modify").click(function(){
		$("#name").removeAttr("disabled");
		$("#telephone").removeAttr("disabled");
		$("#birthday").removeAttr("disabled");
		$("#update").removeAttr("disabled");
		$("#update").removeClass("btn_disabled");
	});
	
	$.ajax({
		url:"http://localhost:8080/BaseTrainManage/collegeteacher/loadSelfInf.do",
		type:"post",
		data:{"ct_no":ct_no},
		dataType:"json",
		success:function(result){
			if(result.status==1){
				$("#name").val(result.data.ct_name);
				$("#sex").val(result.data.ct_sex);
				$("#birthday").val(result.data.ct_birthday);
				$("#academy").val(result.data.academy_no);
				$("#profession").val(result.data.ct_profession);
				$("#telephone").val(result.data.ct_phone);
			}else{
				alert(result.msg);
			}
		},
		error:function(){
			alert("程序出错");
		}
	});
	
	$("#update").click(function(){
		var name = $("#name").val();
		var sex = $("#sex").val();
		var birthday = $("#birthday").val();
		var academy = $("#academy").val();
		var profession = $("#profession").val();
		var phone = $("#telephone").val();
		var ct_no = getCookie("username");
		if(ct_no == "" || ct_no ==null){
			alert("页面已失效，请重新输入!");
			return;
		}
		if(name =="" || phone =="" || birthday ==""){
			alert("姓名或联系方式或出生日期不能为空");
		}else if(name !="" && phone !="" && birthday !=""){
			
			var re =new RegExp("^(13[0-9]|14[5|7]|15[0|1|2|3|5|6|7|8|9]|18[0|1|2|3|5|6|7|8|9])\\d{8}$|\\d{3}-\\d{8}");
			var result = re.test($("#telephone").val());
			if(result){//符合手机号码格式
				
				re = new RegExp("(([0-9]{3}[1-9]|[0-9]{2}[1-9][0-9]{1}|[0-9]{1}[1-9][0-9]{2}|[1-9][0-9]{3})-(((0[13578]|1[02])-(0[1-9]|[12][0-9]|3[01]))|((0[469]|11)-(0[1-9]|[12][0-9]|30))|(02-(0[1-9]|[1][0-9]|2[0-8]))))|((([0-9]{2})(0[48]|[2468][048]|[13579][26])|((0[48]|[2468][048]|[3579][26])00))-02-29)");
				result = re.test(birthday);
				if(result){//如果日期符合格式
					$.ajax({
						url:"http://localhost:8080/BaseTrainManage/collegeteacher/modifySelfInf.do",
						type:"post",
						data:{"ct_no":ct_no,"ct_name":name,"ct_sex":sex,"academy_no":academy,
						"ct_profession":profession,"ct_birthday":birthday,"ct_phone":phone},
						dataType:"json",
						success:function(result){
							alert(result.msg);
						},
						error:function(){
							alert("程序出错");
						}
					});
				}else{
					alert("出生日期格式错误！");
				}
				
			}else{//不符合手机号码格式
				alert("联系方式格式错误！");
			}
		}
	});
});