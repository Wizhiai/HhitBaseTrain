var pageSize = 5;
var resultdata = new Object();
$(function(){
	$("#baseInform").hide();
	$("#search").click(function(){
		searchBase();
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
})
function searchBase(){
	var baseName = $("#base_name").val();
	if(baseName == ""){
		alert("请输入基地名！");
	}else{
		$.ajax({
				url:"http://localhost:8080/BaseTrainManage/base/searchByName.do",
				type:"post",
				data:{"base_name":baseName},
				dataType:"json",
				success:function(result){
					if(result.status == 1){
						resultdata = result.data;
						pageCalculate(resultdata,pageSize);
						firstPage(resultdata,pageSize);//显示首页
						$("#baseInform").show();
					}else{
						alert(result.msg);
						$("#baseInform").hide();
					}
				},
				error:function(){
						alert("程序出错");
				}
		});
	}
}
function gotoPage(pageSize,pageIndex,data){//页数跳转
		var tr = "";
		for(var i=(pageIndex-1)*pageSize;i<=parseInt(pageIndex)*parseInt(pageSize)-1&& i<data.length;i++){
			tr += "<tr><td>"+(i+1)+"</td><td>"+data[i].base_name+"</td><td>"+data[i].base_address+"</td><td>"+data[i].establish_time+"</td>";
			tr += "<td><input id='base_no' type='hidden'value='"+data[i].base_no+"'><input type='button' value='删除' class='btn' onclick='deleteBase(this);'></td></tr>";
		}
		clearTableContent();
		addTableContent(tr);
}
function deleteBase(obj){
	if(confirm("确定删除该基地？")){
		var base_no = $(obj).parent("td").find("#base_no").val();
		$.ajax({
			url:"http://localhost:8080/BaseTrainManage/base/deleteBase.do",
			type:"post",
			data:{"base_no":base_no},
			dataType:"json",
			success:function(result){
				if(result.status == 1){
					alert("基地删除成功！");
					$("#baseInform").hide();
					//searchBase();
				}else{
					alert("基地删除失败！");
				}
			},
			error:function(){
					alert("程序出错");
			}
		});
	}
}