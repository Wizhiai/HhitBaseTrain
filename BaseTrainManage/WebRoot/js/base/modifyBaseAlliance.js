$(function(){
	var base_no = getCookie("base_no");
 	if(base_no =="" || base_no ==null){
 		alert("页面已失效，请重新登录！");
 	}else{
 		showBaseAllianceInfo();
		slide();
		$("#update").click(function(){
			updateBaseAlliance();
		});
 	}
});
function showBaseAllianceInfo(){
	var base_no = getCookie("base_no");
	$.ajax({
		url:"http://localhost:8080/BaseTrainManage/base/searchAllianceByBaseNo.do",
		type:"post",
		data:{"base_no":base_no},
		dataType:"json",
		success:function(result){
			if(result.status == 1){//查询成功，显示基地基本信息
				dataManage(result.data)
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
	/* 合作开发实训项目的企业数 */
	if(data.cooperation_enterprise_num != "" && data.cooperation_enterprise_num !=null){
		$("#cooperation_enterprise_num").val(data.cooperation_enterprise_num);
	}else{
		$("#cooperation_enterprise_num").val(0);
	}
	/* 每年合作开发项目数 */
	if(data.cooperation_project_num != "" && data.cooperation_project_num !=null){
		$("#cooperation_project_num").val(data.cooperation_project_num);
	}else{
		$("#cooperation_project_num").val(0);
	}
	/* 加入就业联盟企业数 */
	if(data.employment_alliance_num != "" && data.employment_alliance_num !=null){
		$("#employment_alliance_num").val(data.employment_alliance_num);
	}else{
		$("#employment_alliance_num").val(0);
	}
	/* 实际从基地招生的企业数 */
	if(data.actual_employment_num != "" && data.actual_employment_num !=null){
		$("#actual_employment_num").val(data.actual_employment_num);
	}else{
		$("#actual_employment_num").val(0);
	}
	/* 就业联盟企业招生数占学生总数比例 */
	if(data.employment_alliance_proportion != "" && data.employment_alliance_proportion !=null){
		$("#employment_alliance_proportion").val(data.employment_alliance_proportion);
	}else{
		$("#employment_alliance_proportion").val(0);
	}
	/* 与基地长期稳定合作的大中型企业名称 */
	if(data.cooperation_enterprise_name !="" && data.cooperation_enterprise_name !=null){
		$("#cooperation_enterprise_name").val(data.cooperation_enterprise_name);
	}else{
		$("#cooperation_enterprise_name").val("未填写");
	}
}
function updateBaseAlliance(){
	var ok = true;
	var base_no = getCookie("base_no");
	if(base_no =="" || base_no ==null){
 		alert("页面已失效，请重新登录！");
 		ok = false;
 	}
	var re =new RegExp("(^\\d{0,2}(\\.\\d{0,3})?$)|(^100$)");//5位正浮点数
	var cooperation_enterprise_num = $("#cooperation_enterprise_num").val();//合作开发实训项目的企业数
	var cooperation_project_num = $("#cooperation_project_num").val();//每年合作开发项目数
	var employment_alliance_num = $("#employment_alliance_num").val();//加入就业联盟的企业数
	var actual_employment_num = $("#actual_employment_num").val();//实际从基地招生的企业数
	var employment_alliance_proportion = $("#employment_alliance_proportion").val();//就业联盟企业招生数占实训学生总数的比例
	if(employment_alliance_proportion !=""){//就业联盟企业招生数占实训学生总数的比例不为空
		var result = re.test(employment_alliance_proportion);
		if(!result){//若就业联盟企业招生数占实训学生总数的比例不是0-5位的数字
			alert("就业联盟企业招生数占实训学生总数的比例输入格式错误");
			ok = false;
		}
	}
	var cooperation_enterprise_name = $("#cooperation_enterprise_name").val();//与本基地长期稳定合作的大中型企业名称
	
	if(ok){
		$.ajax({
			url:"http://localhost:8080/BaseTrainManage/base/modifyAllianceByBaseNo.do",
			type:"post",
			data:{"base_no":base_no,"cooperation_enterprise_num":cooperation_enterprise_num,
						"cooperation_project_num":cooperation_project_num,
						"employment_alliance_num":employment_alliance_num,
						"actual_employment_num":actual_employment_num,
						"employment_alliance_proportion":employment_alliance_proportion,
						"cooperation_enterprise_name":cooperation_enterprise_name},
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