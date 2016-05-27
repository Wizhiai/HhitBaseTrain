$(function(){
	var base_no = getCookie("base_no");
 	if(base_no =="" || base_no ==null){
 		alert("页面已失效，请重新登录！");
 	}else{
 		showBaseResearchInfo();
		slide();
		$("#update").click(function(){
			updateBaseResearch();
		});
 	}
});
function showBaseResearchInfo(){
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
			$("#scientific_research1").attr("checked","true");
		}else if(data.scientific_research == 2){
			$("#scientific_research2").attr("checked","true");
		}else{
			$("#scientific_research3").attr("checked","true");
		}
	}else{
		$("#scientific_research3").attr("checked","true");
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
function updateBaseResearch(){
	var re =new RegExp("^\\d{0,5}$");//0-5位的数字
	var re1 =new RegExp("^\\d{0,18}(\\.\\d{0,2})?$");//20位正浮点数
	var ok = true;
	
	var research_num = $("#research_num").val();//科研项目总数
	if(research_num !=""){//若科研项目总数不为空，判断格式
		var result = re.test(research_num);
		if(!result){//若建设经费不是0-5位的数字
			alert("科研项目总数输入格式错误");
			ok = false;
		}
	}
	var education_num = $("#education_num").val();//教育教改研究项目总数
	if(education_num !=""){//若教育教改研究项目总数不为空，判断格式
		var result = re.test(education_num);
		if(!result){//若教育教改研究项目总数不是0-5位的数字
			alert("教育教改研究项目总数输入格式错误");
			ok = false;
		}
	}
	var research_funding = $("#research_funding").val();//科教研经费总额
	if(research_funding !=""){//若科教研经费总额不为空，判断格式
		var result = re1.test(research_funding);
		if(!result){//若科教研经费总额不是0-20位的数字
			alert("科教研经费总额输入格式错误");
			ok = false;
		}
	}
	var scientific_research = $("input:radio[name='scientific_research']:checked").val();//科教研成果
	var typical_research = $("#typical_research").val();//典型科教研成功
	
	var develop_project_num = $("#develop_project_num").val();//开发项目总数
	if(develop_project_num !=""){//若开发项目总数不为空，判断格式
		var result = re.test(develop_project_num);
		if(!result){//若开发项目总数不是0-5位的数字
			alert("开发项目总数输入格式错误");
			ok = false;
		}
	}
	var develop_project_student = $("#develop_project_student").val();//参与开发的学生总数
	var develop_project_funding = $("#develop_project_funding").val();//开发项目总额
	if(develop_project_funding !=""){//若开发项目总额不为空，判断格式
		var result = re1.test(develop_project_funding);
		if(!result){//若开发项目总额不是0-20位的数字
			alert("科教研经费总额输入格式错误");
			ok = false;
		}
	}
	var develop_project_staff = $("#develop_project_staff").val();//开发职员数
	var typical_project = $("#typical_project").val();//典型开发成果及效益
	var base_no = getCookie("base_no");
	if(base_no =="" || base_no ==null){
		alert("页面已失效，请重新登录");
		ok = false;
	}
	if(ok){
		$.ajax({
			url:"http://localhost:8080/BaseTrainManage/base/modifyResearchByBaseNo.do",
			type:"post",
			data:{"base_no":base_no,"research_num":research_num,"education_num":education_num,
						"research_funding":research_funding,"scientific_research":scientific_research,
						"typical_research":typical_research,"develop_project_num":develop_project_num,
						"develop_project_student":develop_project_student,"develop_project_funding":develop_project_funding,
						"develop_project_staff":develop_project_staff,"typical_project":typical_project},
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