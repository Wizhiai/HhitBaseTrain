var pageSize = 10;
var resultdata = new Object();
$(function(){
	showCountInfo();
	$("#firstPage").click(function(){//首页
	firstPage(resultdata,pageSize);
	});
	$("#prePage").click(function(){//上一页
		prePage(resultdata,pageSize);
	});
	$("#nextPage").click(function(){//下一页
		nextPage(resultdata,pageSize);
	});
	$("#close").click(function(){
		closeCurrentWindow();
	});
});
function showCountInfo(){
	$.ajax({
  	url:"http://localhost:8080/BaseTrainManage/student/registCountInfo.do",
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
function gotoPage(pageSize,pageIndex,data){
	var tr = "";
	for(var i=(pageIndex-1)*pageSize;i<=parseInt(pageIndex)*parseInt(pageSize)-1&& i<data.length;i++){
	
		tr += "<tr><td>"+(i+1)+"</td><td>"+data[i].stu_name+"</td><td>"+data[i].stu_class+"</td>";
		tr += "<td>"+data[i].major+"</td><td>"+data[i].base_name+"</td><td>"+data[i].cname+"</td></tr>";
	}
	clearTableContent();
	addTableContent(tr);
}