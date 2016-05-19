$(function(){
	var stuno = getCookie("username");
	$("#name").attr("disabled","true");
	$("#sex").attr("disabled","true");
	$("#major").attr("disabled","true");
	$("#enter_year").attr("disabled","true");
	$("#class").attr("disabled","true");
	$("#telephone").attr("disabled","true");
	$("#address").attr("disabled","true");
	$("#birthday").attr("disabled","true");
	$("#update").attr("disabled","true");
	$("#update").addClass("btn_disabled");
	
	$("#modify").click(function(){
		$("#telephone").removeAttr("disabled");
		$("#address").removeAttr("disabled");
		$("#birthday").removeAttr("disabled");
		$("#update").removeAttr("disabled");
		$("#update").removeClass("btn_disabled");
	});
	
	$.ajax({
		url:"http://localhost:8080/BaseTrainManage/student/loadSelfInf.do",
		type:"post",
		data:{"stuno":stuno},
		dataType:"json",
		success:function(result){
			if(result.status==1){
				$("#name").val(result.data.stu_name);
				$("#sex").val(result.data.stu_sex);
				$("#birthday").val(result.data.birthday);
				$("#enter_year").val(result.data.enter_year);
				$("#major").val(result.data.major);
				$("#class").val(result.data.stu_class);
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
		var name = $("#name").val();
		var sex = $("#sex").val();
		var birthday = $("#birthday").val();
		var enter_year = $("#enter_year").val();
		var major = $("#major").val();
		var stu_class = $("#class").val();
		var phone = $("#telephone").val();
		var address = $("#address").val();
		
		if(phone =="" ||address=="" || birthday==""){
			alert("联系方式或家庭地址或出生日期不能为空！");
		}else if(phone !="" && address != "" && birthday != ""){
			var re =new RegExp("^(13[0-9]|14[5|7]|15[0|1|2|3|5|6|7|8|9]|18[0|1|2|3|5|6|7|8|9])\\d{8}$|\\d{3}-\\d{8}");
			var result = re.test($("#telephone").val());
			if(result){//符合手机号码格式
				re = new RegExp("(([0-9]{3}[1-9]|[0-9]{2}[1-9][0-9]{1}|[0-9]{1}[1-9][0-9]{2}|[1-9][0-9]{3})-(((0[13578]|1[02])-(0[1-9]|[12][0-9]|3[01]))|((0[469]|11)-(0[1-9]|[12][0-9]|30))|(02-(0[1-9]|[1][0-9]|2[0-8]))))|((([0-9]{2})(0[48]|[2468][048]|[13579][26])|((0[48]|[2468][048]|[3579][26])00))-02-29)");
				result = re.test(birthday);
				if(result){//如果日期符合格式
					$.ajax({
						url:"http://localhost:8080/BaseTrainManage/student/modifySelfInf.do",
						type:"post",
						data:{"stuno":stuno,"stu_name":name,"stu_sex":sex,"birthday":birthday,"enter_year":enter_year,"major":major,
						"stu_class":stu_class,"phone":phone,"address":address},
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