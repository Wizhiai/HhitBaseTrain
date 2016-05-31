var pageSize = 5;
var resultdata = new Object();
$(function(){
	showBase();
	showAllCourse();
		$("#search").click(function(){//给按钮查詢绑定事件
			searchCourseByBaseNo();
		});
		$("#firstPage").click(function(){//首页
			firstPage(resultdata,pageSize);
		});
		$("#prePage").click(function(){//上一页
			prePage(resultdata,pageSize);
		});
		$("#nextPage").click(function(){//下一页
			nextPage(resultdata,pageSize);
		});
});
function showBase(){//显示基地名供查看选择
	$.ajax({
	url:"http://localhost:8080/BaseTrainManage/base/searchName.do",
		type:"post",
		dataType:"json",
		success:function(result){
			if(result.status == 1){
				addBaseOption(result.data);
				
			}else{
				alert(result.msg);
			}
		},
		error:function(){
				alert("程序出错");
		}
	});
}
function addBaseOption(data){//将基地名添加至选项中
	var tr = "";
for(var i=0;i<data.length;i++){
		tr += "<option value="+data[i].base_no+">"+data[i].base_name+"</option>";
	}
	$("#baseName").append($(tr));
}
function showAllCourse(){
	$.ajax({
	url:"http://localhost:8080/BaseTrainManage/traincourse/searchAllCourse.do",
		type:"post",
		dataType:"json",
		success:function(result){
			if(result.status == 1){
				resultdata = result.data;
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
  	
function gotoPage(pageSize,pageIndex,data){//页数跳转
	var tr = "";
	for(var i=(pageIndex-1)*pageSize;i<=parseInt(pageIndex)*parseInt(pageSize)-1&& i<data.length;i++){
		tr += "<tr><td>"+(i+1)+"</td><td>"+data[i].cname+"</td><td>"+data[i].cost+"</td><td>"+data[i].term+"个月</td><td>"+data[i].base_name+"</td>";
		tr += "<td><input id='cno' type='hidden' value ='"+data[i].cno+"'/><input id='base_no' type='hidden' value ='"+data[i].base_no+"'/><input type='button' value='报名' class='btn' onclick='regist(this);'></td></tr>";
	}
	clearTableContent();
	addTableContent(tr);
}
function regist(obj){
	var cno = $(obj).parent("td").find("#cno").val();
	var base_no = $(obj).parent("td").find("#base_no").val();
	alert(cno+base_no);
	var stuno = getCookie("username");
	$.ajax({
  	url:"http://localhost:8080/BaseTrainManage/student/trainregist.do",
		type:"post",
		data:{"base_no":base_no,"cno":cno,"stuno":stuno},
		dataType:"json",
		success:function(result){
			if(result.status == 0){//报名失败
				alert(result.msg);
			}else{//报名成功
				alert(result.msg);
			}
		},
		error:function(){
				alert("程序出错");
		}
	});
}
function searchCourseByBaseNo(){
	var base_no = $("#baseName").val();
	if(base_no == -1){
		alert("请选择查询的基地");
	}else{
		$.ajax({
			url:"http://localhost:8080/BaseTrainManage/traincourse/searchCourseInfByBaseNo.do",
			type:"post",
			data:{"base_no":base_no},
			dataType:"json",
			success:function(result){
				if(result.status == 1){
					resultdata = result.data;
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
	
}