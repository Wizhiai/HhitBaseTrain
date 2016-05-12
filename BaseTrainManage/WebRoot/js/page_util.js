/**
 * 表格的id名为showInform
 * 上一页的按钮id为prePage
 * 下一页的按钮id为nextPage
 * 当前页的按钮id为currentPage
 * 总页数的按钮id为totalPage
 */

function clearTableContent(){//清除表格中的数据
	$("#showInform tbody tr").remove();
}
			
function addTableContent(tr){//将数据加入表格中
	$("#showInform tbody").append($(tr));
}

/*function gotoPage(pageSize,pageIndex,data){页数跳转	var tr = "";
	for(var i=(pageIndex-1)*pageSize;i<=parseInt(pageIndex)*parseInt(pageSize)-1&& i<data.length;i++){
		tr += "<tr><td>"+(i+1)+"</td><td>"+data[i].base_name+"</td><td>"+data[i].base_address+"</td><td>"+data[i].establish_time+"</td>";
		tr += "<td><input id='base_no' type='text' hidden><input type='button' value='浏览' onclick=''></td></tr>";
	}
	clearTableContent();
	addTableContent(tr);
}*/

function pageCalculate(data,pageSize){//计算总页数
	var temp = data.length%pageSize;
	if(temp !=0){
		$("#totalPage").text(parseInt(data.length/pageSize+1));
	}else{
		$("#totalPage").text(data.length/pageSize);
	}
}
/*function showtotalRecords(data){
	alert(data.length);
	$("#totalRecords").text(data.length);
}*/
function pageJudge(){//判断上一页下一页是否可用
	var currentPage =$("#currentPage").text();
	var totalPage =$("#totalPage").text();
	
	if(currentPage == totalPage && currentPage ==1){//当前页为尾页且当前页为起始页
		$("#nextPage").attr("disabled",true);
		$("#prePage").attr("disabled",true);
		$("#nextPage").addClass("btn_disabled");
		$("#prePage").addClass("btn_disabled");
	}else if(currentPage ==1){//当前页为起始页
		$("#prePage").attr("disabled",true);
		$("#nextPage").attr("disabled",false);
		$("#prePage").addClass("btn_disabled");
		$("#nextPage").removeClass("btn_disabled");
	}else if(currentPage == totalPage){//当前页为尾页
		$("#prePage").attr("disabled",false);
		$("#nextPage").attr("disabled",true);
		$("#prePage").removeClass("btn_disabled");
		$("#nextPage").addClass("btn_disabled");
	}else{//当前页既不是首页也不是尾页
		$("#nextPage").attr("disabled",false);
		$("#prePage").attr("disabled",false);
		$("#prePage").removeClass("btn_disabled");
		$("#nextPage").removeClass("btn_disabled");
	}
}

function prePage(data,pageSize){//上一页
	
	var pageIndex =$("#currentPage").text();//获取当前页
	gotoPage(pageSize,parseInt(pageIndex)-1,data);//跳转至上一页
	$("#currentPage").text(parseInt(pageIndex)-1);//改变当前页页数
	pageJudge();
}

function nextPage(data,pageSize){//下一页
	var pageIndex =$("#currentPage").text();//获取当前页
	gotoPage(pageSize,parseInt(pageIndex)+1,data);//跳转至下一页
	$("#currentPage").text(parseInt(pageIndex)+1);//改变当前页页数
	pageJudge();
}

function firstPage(data,pageSize){//首页
	$("#totalRecords").text(data.length);
	gotoPage(pageSize,parseInt(1),data);//跳转至首页
	$("#currentPage").text(1);//改变当前页页数
	pageJudge();
}