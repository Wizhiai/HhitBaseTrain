$(function(){
	$("#cname").change(function(){
		isCourseNameExit();
	});
	$("#add").click(function(){
		addCourse();
	});
})
function addCourse(){
	var cname = $("#cname").val();
	var manager_no = getCookie("username");
	var cost = $("#cost").val();
	var term = $("#term").val();
	var ok = true;
	
	if(cname == "" ||cost =="" ||term ==""){
		alert("课程名或课程花费或学习时间不能为空!");
		ok = false;
	}
	if(cname != "" && cost !="" && term !=""){
		var re =new RegExp("^\\d{0,1}(\\.\\d{0,1})?$");//2位正浮点数
		var result = re.test(term);
		if(!result){//课程时长不满足条件
			alert("学习时间输入格式错误！");
			ok = false;
		}else{
			re =new RegExp("^\\d{0,5}$");//0-5位的数字
			result = re.test(cost);
			if(!result){
				alert("课程花费输入格式错误！");
				ok = false;
			}
		}
	}
	
	if(ok){
		$.ajax({
			url:"http://localhost:8080/BaseTrainManage/traincourse/addCourse.do",
			type:"post",
			data:{"cname":cname,"manager_no":manager_no,"cost":cost,"term":term},
			dataType:"json",
			success:function(result){
				if(result.status == 1){
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
function isCourseNameExit(){//判断课程名是否存在
	var cname = $("#cname").val();
	var manager_no = getCookie("username");
	if(cname == ""){
		alert("请输入课程名！");
	}else{
		$.ajax({
			url:"http://localhost:8080/BaseTrainManage/traincourse/isCourseNameExit.do",
			type:"post",
			data:{"cname":cname,"manager_no":manager_no},
			dataType:"json",
			success:function(result){
				if(result.status == 0){
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