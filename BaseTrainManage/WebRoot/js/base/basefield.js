$(function(){
	var base_no = getCookie("base_no");
 	if(base_no =="" || base_no ==null){
 		alert("页面已失效，请重新登录！");
 	}else{
 		showBaseBuildInfo();
		slide();
 	}
});
function showBaseBuildInfo(){
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
			$("#machine_situation").text("良好（满足实习教学）");
		}else if(data.handware ==2){
			$("#machine_situation").text("较好（基本满足）");
		}else{
			$("#machine_situation").text("一般（能应付教学）");
		}
	}else{
		$("#machine_situation").text("一般（能应付教学）");
	}
	/* 软件先进度自我评价 */
	if(data.software_selfevaluation != "" && data.software_selfevaluation !=null){
		if(data.software_selfevaluation ==1){
			$("#software_selfevaluation").text("业界主流、先进");
		}else if(data.software_selfevaluation ==2){
			$("#software_selfevaluation").text("较好");
		}else{
			$("#software_selfevaluation").text("一般");
		}
	}else{
		$("#software_selfevaluation").text("一般");
	}
	/* 软件实训需求情况 */
	if(data.software_demand != "" && data.software_demand !=null){
		if(data.software_demand ==1){
			$("#software_demand").text("足以支撑整个项目");
		}else{
			$("#software_demand").text("基本能够支撑整个项目");
		}
	}else{
		$("#software_demand").text("基本能够支撑整个项目");
	}
	/* 食堂归属 */
	if(data.canteen_belong != "" && data.canteen_belong !=null){
		if(data.canteen_belong ==1){
			$("#canteen_belong").text("基地独有食堂");
		}else if(data.handware ==2){
			$("#canteen_belong").text("园区共用食堂");
		}else{
			$("#canteen_belong").text("借用其他单位食堂");
		}
	}else{
		$("#canteen_belong").text("借用其他单位食堂");
	}
	/*  宿舍归属 */
	if(data.dormitory_belong != "" && data.dormitory_belong !=null){
		if(data.dormitory_belong ==1){
			$("#dormitory_belong").text("基地自建宿舍");
		}else if(data.dormitory_belong ==2){
			$("#dormitory_belong").text("园区共用宿舍");
		}else{
			$("#dormitory_belong").text("租用其他单位");
		}
	}else{
		$("#dormitory_belong").text("租用其他单位");
	}
	/* 学生管理现状 */
	if(data.student_manage != "" && data.student_manage !=null){
		if(data.student_manage ==1){
			$("#student_manage").text("有专职人员、作息制度健全，管理严格");
		}else if(data.student_manage ==2){
			$("#student_manage").text("非专职管理人员、有作息制度，但不太严格");
		}else{
			$("#student_manage").text("学生自主（自行）管理");
		}
	}else{
		$("#student_manage").text("学生自主（自行）管理");
	}
	/* 清洁卫生  */
	if(data.clean_manage != "" && data.clean_manage !=null){
		if(data.clean_manage ==1){
			$("#clean_manage").text("有专人打扫");
		}else{
			$("#clean_manage").text("学生自行打扫");
		}
	}else{
		$("#clean_manage").text("学生自行打扫");
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