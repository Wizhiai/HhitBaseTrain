$(function(){
	 $.ajax({
      	url:"http://localhost:8080/BaseTrainManage/baseadmin/loadbaseName.do",
      	type:"post",
      	data:{"manager_no":bno},
      	dataType:"json",
      	success:function(result){
      		if(result.status>0){
      		    var data=result.data;
      		   base_no=data.base_no;
      		   $.ajax({
      			   url:"http://localhost:8080/BaseTrainManage/traincourse/searchCno.do",
      			   type:"post",
      			   data:{"base_no":base_no},
      			   dataType:"json",
      			   success:function(result){
      				   if(result.status!=0){
      					   var data=result.data;
      					   for(var i=0;i<data.length;i++){
      						   var op="<option value="+i+">"+data[i]+"</option>";
      						   var $op=$(op);
      						   $("#courseId").append($op);
      					   }  
      				   }
      			   },
      			   error:function(){
      				   alert("程序出错");
      				   
      			   }
	   });
      		}else{
      			alert(result.msg);
      		}
      	},
      	error:function(){
      		alert("程序错误");
      	}
      
      });
	
	
});
/**
 * 加载课程名
 */
function loadCname(){
	$("#couseName").empty();
	if(cno=='请选择课程号'){
		alert(2);
		var op="<option>无选择</option>";
		var $op=$(op);
		$("#couseName").append($op);
	}else{
		$.ajax({
			url:"http://localhost:8080/BaseTrainManage/traincourse/searchCname.do",
			type:"post",
			data:{"cno":cno},
			dataType:"json",
			success:function(result){
				if(result.status!=0){
					var data=result.data;
					var op="<option>"+data+"</option>";
				    var $op=$(op);
					$("#couseName").append($op);
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
/**
 * 加载基地教师
 */
function loadBaseTeacher(){
	if(cno=='请选择课程号'){
		alert(1);
		$("#baseteacher").empty();
		var op="<option>请选择教师</option>";
		var $op=$(op);
		$("#baseteacher").append($op);
	}else{
		$("#baseteacher").empty();
		var op="<option>请选择教师</option>";
		var $op=$(op);
		$("#courseName").append($op);
		$.ajax({
			url:"http://localhost:8080/BaseTrainManage/baseteacher/showname.do",
			type:"post",
			data:{"base_no":base_no},
			dataType:"json",
			success:function(result){
				if(result.status!=0){
					var data=result.data;
					for(var i=0;i<data.length;i++){
						var op="<option value="+data[i].t_no+">"+data[i].t_name+"</option>";
					    var $op=$(op);
						$("#baseteacher").append($op);
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
}
/**
 * 按课程查询实训报名学习
 */
function searchStudent(){
	alert(cno);
	alert(base_no);
	if(cno==null){
		alert("请输入课程号!");
	}else{
		$.ajax({
			url:"http://localhost:8080/BaseTrainManage/student/loadtrainstudent.do",
			type:"post",
			data:{"base_no":base_no,"cno":cno},
			dataType:"json",
			success:function(result){
				if(result.status!=0){
					var data=result.data;
					var tr="";
					for(var i=0;i<data.length;i++){
						tr += "<tr><td onclick ='chooseSearchResult(this)'><input type='hidden' value='"+data[i].stuno+"'/>"+data[i].stu_name+"</td></tr>";
					}
					$tr=$(tr);
					$("#searchResult").append($tr);
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
/**
 * 教师授课分配
 */
function addTeaching(){
	$.ajax({
		url:"http://localhost:8080/BaseTrainManage/teaching/saveteaching.do",
		type:"post",
		data:{"base_class":base_class,"cno":cno,"t_no":tno},
		dataType:"json",
		success:function(result){
			if(result.status!=0){
				alert("教师分班成功!");
			}else{
				alert(result.msg);
			}
		},
		error:function(){
			alert("程序出错");
		}
});
}
/**
 * 添加实训学生
 */
function addStudent(){
	var tds = $("#insertResult td");
	var length = tds.length;
	if(length == 0){
		alert("请选择要添加的学生！");
	}else{
		$("#insertResult td").each(function(){
			var username = $(this).find("input").val();
			//alert(cno);
			$.ajax({
				url:"http://localhost:8080/BaseTrainManage/student/loadSelfInf.do",
				type:"post",
				data:{"stuno":username},
				dataType:"json",
				success:function(result){
					var data=result.data;
					var stuno=data.stuno;
					var stu_name=data.stu_name;
					var stu_sex=data.stu_sex;
					var stu_class=data.stu_class;
					var major=data.major;
					var phone=data.phone;
					var enter_year=data.enter_year;
					var birthday=data.birthday;
					var address=data.address;
					//inResult =-1;
					addTrainStudent(stuno, stu_name,
					stu_sex,  stu_class, major, phone,
					 enter_year, birthday,  base_no,
					base_class,  cno,  address, train_date);
					//alert(addResult);
					alert(inResult);
					if(inResult==1){
						$(this).parent("tr").remove();
					}		
					
				}
				
			});
			
		});
		//alert("需要添加的总用户记录条数为："+length+",添加成功的记录条数为："+aResult);
	}
	
	
}
/**
 * 将学生插入数据
 */
function addTrainStudent(stuno, stu_name,
		stu_sex,  stu_class, major, phone,
		 enter_year, birthday,  base_no,
	 base_class,  cno,  address, train_date){
	$.ajax({
		url:"http://localhost:8080/BaseTrainManage/trainstudent/inputinfo.do",
		type:"post",
		data:{"stuno":stuno, "stu_name":stu_name,
			"stu_sex":stu_sex, "stu_class":stu_class,"major": major,"phone": phone,
			 "enter_year":enter_year,"birthday": birthday, "base_no":base_no,
		"base_class": base_class,  "cno":cno,  "address":address, "train_date":train_date},
		dataType:"json",
		success:function(result){
			if(result.status==1){
				//alert(2);
				inResult=1;
				aResult=aResult+parseInt(1);
			
			}else{
				inResult=0;
				//	alert(result.msg);
				alert(stu_name+result.msg);
		
				
			}
			
		}
		
	});
}
function hide(){
	 $("#stuno").hide();
	    $("#baseclass").hide();
	    $(".searchResultInfo").hide();
	    $("#studnetRegistCountInform").hide();
}
function addClass(){
	$("#baseclass").show();
	$.ajax({
		url:"http://localhost:8080/BaseTrainManage/baseadmin/loadclass.do",
		type:"post",
		data:{"manager_no":bno},
		dataType:"json",
		success:function(result){
			if(result.status==1){
				var data=result.data;
				var op="";
				for(var i=0;i<data.length;i++){
					op="<option value="+data[i]+">"+data[i]+"</option>";
					var $op=$(op);
					$("#baseclass").append($op);
				}
			}
		},
		error:function(){
			alert("程序出错");
		}
		
	});
	$(".searchResultInfo").show();
}
function searchTrainStudentByNo(){
	$.ajax({
		url:"http://localhost:8080/BaseTrainManage/trainstudentlist/load.do",
		type:"post",
		data:{"sno":stuno},
		dataType:"json",
		success:function(result){
			if(result.status==1){
				$("#studnetRegistCountInform").show();
				var tr = "<tr><th>序号</th><th>学号</th><th>姓名</th><th>性别</th><th>学校班级</th><th>基地班级</th><th>课程号</th><th>培训时间</th><th>操作</th></tr>";
				$("#showInform thead tr").remove();
				$("#showInform thead").append($(tr));
				
						resultdata= result.data;
						pageCalculate(resultdata,pageSize);
						firstPage(resultdata,pageSize);//显示首页
					}else{
						alert(result.msg);
					}
		},
		error:function(){
			alert("程序出错");
		}
		
	});
	
}
function loadStudentByClass(){
	$.ajax({
		url:"http://localhost:8080/BaseTrainManage/trainstudent/searchtrainstudent.do",
		type:"post",
		data:{"manager_no":bno,"base_class":base_class},
		dataType:"json",
		success:function(result){
			if(result.status==1){
				$("#searchResult").empty();
				var data=result.data;
				var tr="";
				for(var i=0;i<data.length;i++){
					tr += "<tr><td onclick ='chooseSearchResult(this)'><input type='hidden' value='"+data[i].stuno+"'/>"+data[i].stu_name+"</td></tr>";
				}
				$tr=$(tr);
				$("#searchResult").append($tr);
		}
		},
		error:function(){
			alert("程序出错");
		}
		
	
});
	$("#searchResult").show();
}
function deleteStudent(stuno){
	$.ajax({
		url:"http://localhost:8080/BaseTrainManage/baseadmin/deletestudent.do",
		type:"post",
		data:{"stuno":stuno},
		dataType:"json",
		success:function(result){
			if(result.status==1){
				delResult=1;
				alert(delResult);
				deleteResult=deleteResult+parseInt(1);
		}else{
			delResult=0;
		}
		},
		error:function(){
			alert("程序出错");
		}
});
	
}


function deleteUser1(){
	var tds = $("#insertResult td");
	var length = tds.length;
	if(length == 0){
		alert("请选择要删除的学生！");
	}else{
		$("#insertResult td").each(function(){
			var username = $(this).find("input").val();
			//delResult=-1;
			deleteStudent(username);
			alert(delResult);
			if(delResult == 1){
				$(this).parent("tr").remove();
			}		
		
		});
		alert("需要删除的总用户记录条数为："+length+",删除成功的记录条数为："+deleteResult);
	}
	
}






