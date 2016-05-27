var pageSize = 5;
var resultdata = new Object();
$(function(){
	showBase();//显示基地名
	showAllCourse();//页面加载时显示所有基地开课信息
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
			tr += "<tr><td>"+(i+1)+"</td><td>"+data[i].cname+"</td><td>"+data[i].cost+"</td><td>"+data[i].term+"个月</td><td>"+data[i].base_name+"</td></tr>";
			//tr += "<td><input id='cno' type='text' hidden value ="+data[i].cno+"/><input id='base_no' type='text' hidden value ="+data[i].base_no+"/></td>";
		}
		clearTableContent();
		addTableContent(tr);
	}
function searchCourseByBaseNo(){
	var base_no = $("#baseName").val();
	alert(base_no);
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