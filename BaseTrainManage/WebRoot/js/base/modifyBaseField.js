$(function(){
	var base_no = getCookie("base_no");
	if(base_no =="" || base_no ==null){
		alert("未获取到基地编号，请重新登录");
	}else{
		showBaseFieldInfo();
		slide();
		$("#update").click(function(){
			updateField();
		});
	}
});
function showBaseFieldInfo(){
	var base_no = getCookie("base_no");
	$.ajax({
		url:"http://localhost:8080/BaseTrainManage/base/searchFieldByBaseNo.do",
		type:"post",
		data:{"base_no":base_no},
		dataType:"json",
		success:function(result){
			if(result.status == 1){//查询成功，显示基地基本信息
				dataManage(result.data);
			}else{
				alert(result.msg);
			}
		},
		error:function(){
				alert("程序出错");
		}
	});
}
function dataManage(data){
	/* 实训场地 */
	if(data.base_area != "" && data.base_area !=null){
		$("#base_area").val(data.base_area);
		
	}else{
		$("#base_area").val("未填写");
	}
	/*  硬件设备*/
	if(data.handware != "" && data.handware !=null){
		$("#handware").val(data.handware);
		
	}else{
		$("#handware").val("未填写");
	}
	/* 设备使用状况 */
	if(data.machine_situation != "" && data.machine_situation !=null){
		if(data.machine_situation ==1){
			$("#machine_situation1").attr("checked","true");
		}else if(data.handware ==2){
			$("#machine_situation2").attr("checked","true");
		}else{
			$("#machine_situation3").attr("checked","true");
		}
	}else{
		$("#machine_situation3").attr("checked","true");
	}
	/* 软件先进度自我评价 */
	if(data.software_selfevaluation != "" && data.software_selfevaluation !=null){
		if(data.software_selfevaluation ==1){
			$("#software_selfevaluation1").attr("checked","true");
		}else if(data.software_selfevaluation ==2){
			$("#software_selfevaluation2").attr("checked","true");
		}else{
			$("#software_selfevaluation3").attr("checked","true");
		}
	}else{
		$("#software_selfevaluation3").attr("checked","true");
	}
	/* 软件实训需求情况 */
	if(data.software_demand != "" && data.software_demand !=null){
		if(data.software_demand ==1){
			$("#software_demand1").attr("checked","true");
		}else{
			$("#software_demand2").attr("checked","true");
		}
	}else{
		$("#software_demand2").attr("checked","true");
	}
	/* 食堂归属 */
	if(data.canteen_belong != "" && data.canteen_belong !=null){
		if(data.canteen_belong ==1){
			$("#canteen_belong1").attr("checked","true");
		}else if(data.handware ==2){
			$("#canteen_belong2").attr("checked","true");
		}else{
			$("#canteen_belong3").attr("checked","true");
		}
	}else{
		$("#canteen_belong3").attr("checked","true");
	}
	/*  宿舍归属 */
	if(data.dormitory_belong != "" && data.dormitory_belong !=null){
		if(data.dormitory_belong ==1){
			$("#dormitory_belong1").attr("checked","true");
		}else if(data.dormitory_belong ==2){
			$("#dormitory_belong2").attr("checked","true");
		}else{
			$("#dormitory_belong3").attr("checked","true");
		}
	}else{
		$("#dormitory_belong3").attr("checked","true");
	}
	/* 学生管理现状 */
	if(data.student_manage != "" && data.student_manage !=null){
		if(data.student_manage ==1){
			$("#student_manage1").attr("checked","true");
		}else if(data.student_manage ==2){
			$("#student_manage2").attr("checked","true");
		}else{
			$("#student_manage3").attr("checked","true");
		}
	}else{
		$("#student_manage3").attr("checked","true");
	}
	/* 清洁卫生  */
	if(data.clean_manage != "" && data.clean_manage !=null){
		if(data.clean_manage ==1){
			$("#clean_manage1").attr("checked","true");
		}else{
			$("#clean_manage2").attr("checked","true");
		}
	}else{
		$("#clean_manage2").attr("checked","true");
	}
	/* 环境状况 */
	if(data.environment != "" && data.environment !=null){
		$("#environment").val(data.environment);
	}else{
		$("#environment").val("未填写");
	}
	/* 安全状况  */
	if(data.safety != "" && data.safety !=null){
		$("#safety").val(data.safety);
	}else{
		$("#safety").val("未填写");
	}
}
function updateField(){
	var base_area = $("#base_area").val();//实训场地
	var handware = $("#handware").val();//硬件设备
	var machine_situation = $("input:radio[name='machine_situation']:checked").val();//设备使用状况
	var software_selfevaluation = $("input:radio[name='software_selfevaluation']:checked").val();//软件先进度自我评价
	var software_demand = $("input:radio[name='software_demand']:checked").val();//软件实训需求情况
	var canteen_belong = $("input:radio[name='canteen_belong']:checked").val();//食堂归属
	var dormitory_belong = $("input:radio[name='dormitory_belong']:checked").val();//宿舍归属
	var student_manage = $("input:radio[name='student_manage']:checked").val();//学生管理现状
	var clean_manage = $("input:radio[name='clean_manage']:checked").val();//清洁卫生
	var environment = $("#environment").val();//环境状况
	var safety = $("#safety").val();//安全状况
	var base_no = getCookie("base_no");
	var ok = true;
	
	if(base_no =="" || base_no ==null){
		alert("页面已失效，请重新登录");
		ok = false;
	}
	if(ok){
		$.ajax({
			url:"http://localhost:8080/BaseTrainManage/base/modifyFiledByBaseNo.do",
			type:"post",
			data:{"base_no":base_no,"base_area":base_area,"handware":handware,"machine_situation":machine_situation,
						"software_selfevaluation":software_selfevaluation,"software_demand":software_demand,
						"canteen_belong":canteen_belong,"dormitory_belong":dormitory_belong,
						"student_manage":student_manage,"clean_manage":clean_manage,"environment":environment,"safety":safety},
			dataType:"json",
			success:function(result){
				if(result.status == 1){//修改成功
					alert(result.msg);
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