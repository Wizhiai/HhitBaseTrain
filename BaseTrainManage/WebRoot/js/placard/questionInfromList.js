var pageSize = 5;
var resultdata = new Object();
$(function(){//页面加载时从数据库中取出有哪些基地可供学生搜索其相关问题，同时从数据库中加载初一些基地常见问题
	showBase();//显示基地名供查询
	showAllQuestion();//显示所有基地常见问题
		$("#search").click(function(){//给按钮查詢绑定事件
			searchBaseQuestion();
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
function showBase(){
	$.ajax({
		url:"http://localhost:8080/BaseTrainManage/base/searchName.do",
			type:"post",
			dataType:"json",
			success:function(result){
				if(result.status == 1){
					addSelectOption(result.data);
				}else{
					alert(result.msg);
				}
			},
			error:function(){
					alert("程序出错");
			}
		});
}

function addSelectOption(data){//添加基地名供学生进行搜索
	var tr = "";
	for(var i=0;i<data.length;i++){
			tr += "<option value='"+data[i].base_no+"'>"+data[i].base_name+"</option>";
		}
		$("#searchType").append($(tr));
}
function showAllQuestion(){
	$.ajax({
		url:"http://localhost:8080/BaseTrainManage/question/searchAll.do",
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
			tr += "<tr><td>"+(i+1)+"</td><td>"+data[i].placard_title+"</td><td>"+data[i].publish_time+"</td><td>"+data[i].base_name+"</td>";
			//tr += "<td><input id='placard_no' type='text' hidden value ="+data[i].placard_no+"><a href='question.jsp' onclick ='gotoQuestion'>浏览</a></td></tr>";
			tr += "<td><input id='placard_no' type='hidden'  value ='"+data[i].placard_no+"'/><input type='button' value='浏览' class='btn' onclick='gotoQuestion(this)'></td></tr>";
		}
		clearTableContent();
		addTableContent(tr);
	}
	function gotoQuestion(obj){
		var placard_no = $(obj).parent().find("#placard_no").val();
		addCookie("placard_no",placard_no,2);
		window.open("question.jsp");
	}
	
function searchBaseQuestion(){//根据学生选中的基地名查找常见问题

	var base_no = $("#searchType option:selected").val();
	var ok = true;
	if(base_no ==""){
			alert("请输入关键字");
			ok = false;
		}
		if(ok){
			$.ajax({
		url:"http://localhost:8080/BaseTrainManage/question/searchByBaseNo.do",
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