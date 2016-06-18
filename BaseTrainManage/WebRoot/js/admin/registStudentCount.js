var pageSize = 5;
var resultdata = new Object();
$(function(){
	$("#studnetRegistCountInform").hide();
	$("#search").click(function(){
		Count();
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
function Count(){
	var countType = $("#countType option:selected").val();
	if(countType == 1){
		var tr = "<tr><th>序号</th><th>专业</th><th>报名人数</th><th>操作</th></tr>";
		$("#showInform thead tr").remove();
		$("#showInform thead").append($(tr));
		$.ajax({
		url:"http://localhost:8080/BaseTrainManage/student/registCountByMajor.do",
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
	}else if(countType == 2){
		var tr = "<tr><th>序号</th><th>实训单位</th><th>报名人数</th><th>操作</th></tr>";
		$("#showInform thead tr").remove();
		$("#showInform thead").append($(tr));
		$.ajax({
		url:"http://localhost:8080/BaseTrainManage/student/registCountByBase.do",
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
	}else if(countType == 3){
		var tr = "<tr><th>序号</th><th>专业</th><th>实训单位</th><th>报名人数</th><th>操作</th></tr>";
		$("#showInform thead tr").remove();
		$("#showInform thead").append($(tr));
		$.ajax({
		url:"http://localhost:8080/BaseTrainManage/student/registCountByMajorAndBase.do",
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
	$("#studnetRegistCountInform").show();
}
function gotoPage(pageSize,pageIndex,data){

	var countType = $("#countType option:selected").val();
	var tr = "";
	if(countType ==1){//按专业划分页数跳转
		for(var i=(pageIndex-1)*pageSize;i<=parseInt(pageIndex)*parseInt(pageSize)-1&& i<data.length;i++){
			tr += "<tr><td>"+(i+1)+"</td><td>"+data[i].major+"</td><td>"+data[i].num+"</td>";
			tr += "<td><input type='button' value='详细信息' class='btn' onclick ='clearCountInfo();'/></td></tr>";
		}
	}else if(countType ==2){//按实训单位划分页数跳转
		for(var i=(pageIndex-1)*pageSize;i<=parseInt(pageIndex)*parseInt(pageSize)-1&& i<data.length;i++){
			tr += "<tr><td>"+(i+1)+"</td><td>"+data[i].base_name+"</td><td>"+data[i].num+"</td>";
			tr += "<td><input type='button' value='详细信息' class='btn' onclick ='clearCountInfo();'/></td></tr>";
		}
	}else if(countType ==3){//按专业和实训单位划分页数跳转
		for(var i=(pageIndex-1)*pageSize;i<=parseInt(pageIndex)*parseInt(pageSize)-1&& i<data.length;i++){
			tr += "<tr><td>"+(i+1)+"</td><td>"+data[i].major+"</td><td>"+data[i].base_name+"</td><td>"+data[i].num+"</td>";
			tr += "<td><input type='button' value='详细信息' class='btn' onclick ='clearCountInfo();'/></td></tr>";
		}
	}
	
	clearTableContent();
	addTableContent(tr);
}
function clearCountInfo(){
	window.open("clearRegistStudentCountInfo.jsp");
}