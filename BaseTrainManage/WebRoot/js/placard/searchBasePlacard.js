var pageSize = parseInt(5);
var resultdata = new Object();
	$(function(){
		$("#skinInfo").hide();
		$("#modify").attr("disabled","true");
		$("#publish_time").attr("disabled","true");
		$("#modify").addClass("btn_disabled");
		
		$("#placard_type").change(function(){
			$("#modify").removeAttr("disabled");
			$("#modify").removeClass("btn_disabled");
		});
		$("#manage_title").change(function(){
			$("#modify").removeAttr("disabled");
			$("#modify").removeClass("btn_disabled");
		});
		$("#content").change(function(){
			$("#modify").removeAttr("disabled");
			$("#modify").removeClass("btn_disabled");
		});
		$("#modify").click(function(){
			modifySchoolPlacard();
		});
		
		showAllBasePlacard();//显示所有基地公告
		$("#search").click(function(){
			var title = $("#title").val();
			if(title == ""){
				alert("标题不能为空！");
			}else{
				searchBasePlacardByTitle();
			}
			$("#title").val("");
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
		
		/*关闭当前页，回到上一页面*/
  $("#close").click(function(){
  	$("#skinInfo").hide();
	  	$("#editPlacard").show();
	  	showAllSchoolPlacard();
  });
	});
	function showAllBasePlacard(){
		var publish_author = getCookie("username"); 
	$.ajax({
		url:"http://localhost:8080/BaseTrainManage//basePlacard/searchAllBasePlacard.do",
			type:"post",
			dataType:"json",
			data:{"publish_author":publish_author},
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
			tr += "<tr><td>"+(i+1)+"</td><td>"+data[i].placard_title+"</td><td>"+data[i].publish_time+"</td>";
			tr += "<td><input id='placard_no' type='hidden' value ="+data[i].placard_no+"><input type='button' value='浏览  ' class='btn' onclick='showBasePlacard(this);'>";
			tr += "<input type='button' value='修改  ' class='btn' onclick='showBasePlacard(this);'><input type='button' value='删除' class='btn' onclick='deleteBasePlacard(this);'></td></tr>";
		}
		clearTableContent();
		addTableContent(tr);
	}
	function searchBasePlacardByTitle(){
		var placard_title = $("#title").val();
		var publish_author = getCookie("username");
		var placard_type = $("#search_placard_type").val();
		var ok = true;
		if(publish_author == "" || publish_author == null){
			alert("页面已失效，请重新登录！");
			ok = false;
		}
		if(ok){
			$.ajax({
  			url:"http://localhost:8080/BaseTrainManage/basePlacard/searchBasePlacardByTitle.do",
				type:"post",
				data:{"placard_title":placard_title,"placard_type":placard_type,
				"publish_author":publish_author},
				dataType:"json",
				success:function(result){
					if(result.status != 0){
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
	
	/*浏览按钮，当前页隐藏，浏览页显示*/
function showBasePlacard(obj){
		var placard_no = $(obj).parent("td").find("input:hidden").val();
		addCookie("placard_no",placard_no,2);
		$("#editPlacard").hide();
		$("#skinInfo").show();	
		$.ajax({
		url:"http://localhost:8080/BaseTrainManage/basePlacard/searchbasePlacardByPlacardNo.do",
			type:"post",
			data:{"placard_no":placard_no},
			dataType:"json",
			success:function(result){
				if(result.status == 1){
					if(result.data.placard_type == 1){
						$("#placard_type1").attr("selected","true");
					}else{
						$("#placard_type2").attr("selected","true");
					}
					$("#manage_title").val(result.data.placard_title);
					$("#publish_time").val(result.data.publish_time);
					$("#content").val(result.data.placard_content);
				}else{
					alert(result.msg);
				}
			},
			error:function(){
					alert("程序出错");
			}
		});
	}
function modifySchoolPlacard(obj){//修改数据
		var placard_no = getCookie("placard_no");
		var publish_author = getCookie("username");
		var placard_title = $("#manage_title").val();
		var placard_content = $("#content").val();
		var placard_type = $("#placard_type option:selected").val();
		var ok = true;
		if(publish_author == "" ||publish_author == null||placard_no == ""||placard_no == null){
			alert("页面已失效，请重新登录！");
			ok = false;
		}else if(publish_author != "" && publish_author != null&& placard_no != ""&& placard_no != null){
			if(placard_title == "" || placard_content == ""){
				alert("公告标题或公告内容不能为空！");
				ok = false;
			}
		}
		if(ok){
			$.ajax({
	  		url:"http://localhost:8080/BaseTrainManage/basePlacard/updateBasePlacardByNo.do",
				type:"post",
				data:{"placard_no":placard_no,"placard_title":placard_title,"placard_content":placard_content,
				"publish_author":publish_author,"placard_type":placard_type},
				dataType:"json",
				success:function(result){
				//	if(result.status != 0){
					alert(result.status);
							alert(result.msg);
					//}
				},
				error:function(){
						alert("程序出错");
				}
			});
		}
		
}
function deleteBasePlacard(obj){//删除数据
	if(confirm("确定删除？")){
			var placard_no = $(obj).parent("td").find("input:hidden").val();
			$.ajax({
  			url:"http://localhost:8080/BaseTrainManage/basePlacard/deleteBasePlacardByNo.do",
				type:"post",
				data:{"placard_no":placard_no},
				dataType:"json",
				success:function(result){
					alert(result.status);
					if(result.status != 0){
						showAllBasePlacard()();
					}
				},
				error:function(){
						alert("程序出错");
				}
			});
		}
}