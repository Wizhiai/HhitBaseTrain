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
		url:"http://localhost:8080/BaseTrainManage/base/searchResearchByBaseNo.do",
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
	/* 科研项目总数 */
	if(data.research_num != "" && data.research_num !=null){
		$("#research_num").val(data.research_num);
	}else{
		$("#research_num").val(0);
	}
	/* 教育研究项目总数*/
	if(data.education_num != "" && data.education_num !=null){
		$("#education_num").val(data.education_num);
	}else{
		$("#education_num").val(0);
	}
	/* 科研经费总额 */
	if(data.research_funding != "" && data.research_funding !=null){
		$("#research_funding").val(data.research_funding);
	}else{
		$("#research_funding").val(0);
	}
	/* 科教研成果*/
	if(data.scientific_research != "" && data.scientific_research !=null){
		if(data.scientific_research == 1){
			$("#scientific_research").val("较为丰硕");
		}else if(data.scientific_research == 2){
			$("#scientific_research").val("一般");
		}else{
			$("#scientific_research").val("较少或没有");
		}
	}else{
		$("#scientific_research").val("较少或没有");
	}
	/*典型科教研成果 名称 */
	if(data.typical_research != "" && data.typical_research !=null){
		$("#typical_research").val(data.typical_research);
	}else{
		$("#typical_research").val("未填写");
	}
	/*近三年开发项目总数*/
	if(data.develop_project_num != "" && data.develop_project_num !=null){
		$("#develop_project_num").val(data.develop_project_num);
	}else{
		$("#develop_project_num").val("0");
	}
	/*近三年开发项目总额 */
	if(data.develop_project_funding != "" && data.develop_project_funding !=null){
		$("#develop_project_funding").val(data.develop_project_funding);
	}else{
		$("#develop_project_funding").val("0");
	}
	/*开发职员人数  */
	if(data.develop_project_staff != "" && data.develop_project_staff !=null){
		$("#develop_project_staff").val(data.develop_project_staff);
	}else{
		$("#develop_project_staff").val("未填写");
	}
	/*参与开发的实训学生人数 */
	if(data.develop_project_student != "" && data.develop_project_student !=null){
		$("#develop_project_student").val(data.develop_project_student);
	}else{
		$("#develop_project_student").val("未填写");
	}
	/*典型开发成果及效益 */
	if(data.typical_project != "" && data.typical_project !=null){
		$("#typical_project").val(data.typical_project);
	}else{
		$("#typical_project").val("未填写");
	}
}