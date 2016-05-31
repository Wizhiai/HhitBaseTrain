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
		url:"http://localhost:8080/BaseTrainManage/base/searchEffectByBaseNo.do",
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
	/* 实际使用的项目数 */
	if(data.project_inuse !="" && data.project_inuse !=null){
		$("#project_inuse").val(data.project_inuse);
	}else{
		$("#project_inuse").val(0);
	}
	/* 实训效果较好的项目数 */
	if(data.good_project !="" && data.good_project !=null){
		$("#good_project").val(data.good_project);
	}else{
		$("#good_project").val(0);
	}
	/*企业实际产品研发项目数 */
	if(data.company_project !="" && data.company_project !=null){
		$("#company_project").val(data.company_project);
	}else{
		$("#company_project").val(0);
	}
	/* 基地自主研发项目数 */
	if(data.selfdevelop_project !="" && data.selfdevelop_project !=null){
		$("#selfdevelop_project").val(data.selfdevelop_project);
	}else{
		$("#selfdevelop_project").val(0);
	}
	/* 研究生层次 */
	if(data.postgraduate_proportion !="" && data.postgraduate_proportion !=null){
		$("#postgraduate_proportion").val(data.selfdevelop_project);
	}else{
		$("#postgraduate_proportion").val(0);
	}
	/*  本科生层次 */
	if(data.undergraduate_proportion !="" && data.undergraduate_proportion !=null){
		$("#undergraduate_proportion").val(data.undergraduate_proportion);
	}else{
		$("#undergraduate_proportion").val(0);
	}
	/*专科生层次  */
	if(data.specialist_proportion !="" && data.specialist_proportion !=null){
		$("#specialist_proportion").val(data.specialist_proportion);
	}else{
		$("#specialist_proportion").val(0);
	}
	/* 学员来源：学校安排推荐 */
	if(data.school_source !="" && data.school_source !=null){
		$("#school_source").val(data.school_source);
	}else{
		$("#school_source").val(0);
	}
	/* 学员来源：零散报道 */
	if(data.trainee_source !="" && data.trainee_source !=null){
		$("#trainee_source").val(data.trainee_source);
	}else{
		$("#trainee_source").val(0);
	}
	/* 每年完成实训的人数 */
	if(data.train_finish_num !="" && data.train_finish_num !=null){
		$("#train_finish_num").val(data.train_finish_num);
	}else{
		$("#train_finish_num").val("未填写");
	}
	/* 顺利就业的学生人数 */
	if(data.train_employed_num !="" && data.train_employed_num !=null){
		$("#train_employed_num").val(data.train_employed_num);
	}else{
		$("#train_employed_num").val("未填写");
	}
	/* 就业范围：大型企业*/
	if(data.large_enterprise !="" && data.large_enterprise !=null){
		$("#large_enterprise").val(data.large_enterprise);
	}else{
		$("#large_enterprise").val(0);
	}
	/*就业范围：中型企业 */
	if(data.middle_enterprise !="" && data.middle_enterprise !=null){
		$("#middle_enterprise").val(data.middle_enterprise);
	}else{
		$("#middle_enterprise").val(0);
	}
	/* 就业范围：小型企业 */
	if(data.small_enterprise !="" && data.small_enterprise !=null){
		$("#small_enterprise").val(data.small_enterprise);
	}else{
		$("#small_enterprise").val(0);
	}
	/* 学生就业时起薪范围 */
	if(data.salary_range !="" && data.salary_range !=null){
		$("#salary_range").val(data.salary_range);
	}else{
		$("#salary_range").val("未填写");
	}
	/* 基地推荐就业 */
	if(data.base_recommend !="" && data.base_recommend !=null){
		$("#base_recommend").val(data.base_recommend);
	}else{
		$("#base_recommend").val(0);
	}
	/* 学员自找就业 */
	if(data.student_selfask !="" && data.student_selfask !=null){
		$("#student_selfask").val(data.student_selfask);
	}else{
		$("#student_selfask").val(0);
	}
	/* 实训管理与考评规范 */id="evaluation_rule4"
	if(data.evaluation_rule !="" && data.evaluation_rule !=null){
		var evaluation_rules = data.evaluation_rule.split(",");
		var evaluation_rule = "";
		for(var i = 0;i<evaluation_rules.length;i++){
			if(evaluation_rules[i]==1){
				$("#evaluation_rule1").attr("checked","true");
			}else if(evaluation_rules[i]==2){
				$("#evaluation_rule2").attr("checked","true");
			}else if(evaluation_rules[i]==3){
				$("#evaluation_rule3").attr("checked","true");
			}else if(evaluation_rules[i]==4){
				$("#evaluation_rule4").attr("checked","true");
			}else if(evaluation_rules[i]==5){
				$("#evaluation_rule5").attr("checked","true");
			}else if(evaluation_rules[i]==6){
				$("#evaluation_rule6").attr("checked","true");
			}else if(evaluation_rules[i]==7){
				$("#evaluation_rule7").attr("checked","true");
			}else if(evaluation_rules[i]==8){
				$("#evaluation_rule8").attr("checked","true");
			}else if(evaluation_rules[i]==9){
				$("#evaluation_rule9").attr("checked","true");
			}else if(evaluation_rules[i]==10){
				$("#evaluation_rule10").attr("checked","true");
			}else if(evaluation_rules[i]==11){
				$("#evaluation_rule11").attr("checked","true");
			}
		}
	}
	
}