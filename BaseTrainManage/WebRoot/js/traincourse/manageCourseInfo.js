var pageSize = parseInt(5);
var resultdata = new Object();
	$(function(){
		$("#skinInfo").hide();
		$("#modify").attr("disabled","true");
		$("#modify").addClass("btn_disabled");
		
		$("#cname").attr("disabled","true");
		$("#cost").change(function(){
			$("#modify").removeAttr("disabled");
			$("#modify").removeClass("btn_disabled");
		});
		$("#term").change(function(){
			$("#modify").removeAttr("disabled");
			$("#modify").removeClass("btn_disabled");
		});
		$("#modify").click(function(){
			modifyCourseInfo();
		});
		showAllBaseCourse();//显示所有基地课程信息
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
	  	$("#editCourse").show();
	  	showAllBaseCourse();
  });
	});
	function showAllBaseCourse(){
		var manager_no = getCookie("username");
		$.ajax({
  		url:"http://localhost:8080/BaseTrainManage/traincourse/showBaseCourseByManagerNo.do",
  		data:{"manager_no":manager_no},
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
			tr += "<tr><td>"+(i+1)+"</td><td>"+data[i].cname+"</td><td>"+data[i].cost+"</td><td>"+data[i].term+"个月</td>";
			tr += "<td><input id='cno' type='hidden' value ='"+data[i].cno+"'><input type='button' value='浏览  ' class='btn' onclick='showTrainCourse(this);'>";
			tr += "<input type='button' value='修改  ' class='btn' onclick='showTrainCourse(this);;'><input type='button' value='删除' class='btn' onclick='deleteTrainCourse(this);'></td></tr>";
		}
		clearTableContent();
		addTableContent(tr);
	}
	/*浏览按钮，当前页隐藏，浏览页显示*/
	function gotoManageSchoolPlacard(){
	var placard_no = $("#placard_no").val();
		addCookie("placard_no",placard_no,2);
		$("#editCourse").hide();
		$("#skinInfo").show();			
}
function showTrainCourse(obj){
		var cno = $(obj).parent("td").find("#cno").val();
		if(cno == "" || cno == null){
			alert("页面已失效，请重新登录！");
			ok = false;
		}
		addCookie("cno",cno,2);
		$("#editCourse").hide();
		$("#skinInfo").show();	
		$.ajax({
		url:"http://localhost:8080/BaseTrainManage/traincourse/searchCourseByCourseNo.do",
			type:"post",
			data:{"cno":cno},
			dataType:"json",
			success:function(result){
				if(result.status == 1){
					$("#cname").val(result.data.cname);
					$("#cost").val(result.data.cost);
					$("#term").val(result.data.term);
				}else{
					alert(result.msg);
				}
			},
			error:function(){
					alert("程序出错");
			}
		});
	}
function modifyCourseInfo(obj){//修改数据
		var cno = getCookie("cno");
		var cname = $("#cname").val();
		var cost = $("#cost").val();
		var term = $("#term").val();
		var manager_no = getCookie("username");
		var ok = true;
		if(cno == "" || cno == null || manager_no =="" || manager_no ==null){
			alert("页面已失效，请重新登录！");
			ok = false;
		}else if(cno != "" && cno != null && manager_no =="" && manager_no ==null){
		
			if(cname == "" ||cost =="" ||term ==""){
 				alert("课程名不能为空或课程花费或学习时间不能为空!");
 				ok = false;
 			}else if(cname != "" && cost !="" && term !=""){
 				var re = new RegExp("^\\d{0,5}$");//0-5位的数字
	 			var result = re.test(term);
	 			if(!result){//课程时长不满足条件
	 				alert("课程花费输入格式错误！");
	 				ok = false;
	 			}else{
	 				re = new RegExp("^\\d{0,1}(\\.\\d{0,1})?$|\\d{0,1}");//2位正浮点数
	 				result = re.test(cost);
	 				if(!result){
	 					alert("学习时间输入格式错误！");
	 					ok = false;
	 				}
	 			}
 			}
		}
		if(ok){
			$.ajax({
	  		url:"http://localhost:8080/BaseTrainManage/traincourse/modifyCourseInfoByCourseNo.do",
				type:"post",
				data:{"cno":cno,"cname":cname,"cost":cost,"term":term},
				dataType:"json",
				success:function(result){
						alert(result.msg);
				},
				error:function(){
						alert("程序出错");
				}
			});
		}
}
function deleteTrainCourse(obj){//删除数据
	if(confirm("确定删除？")){
			var cno = $(obj).parent("td").find("#cno").val();
			$.ajax({
  			url:"http://localhost:8080/BaseTrainManage/traincourse/deleteCourseInfoByCourseNo.do",
				type:"post",
				data:{"cno":cno},
				dataType:"json",
				success:function(result){
					if(result.status != 0){
						alert(result.msg);
						showAllBaseCourse();
					}
				},
				error:function(){
						alert("程序出错");
				}
			});
		}
}