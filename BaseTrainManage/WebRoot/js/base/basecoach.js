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
		url:"http://localhost:8080/BaseTrainManage/base/searchCoachByBaseNo.do",
		type:"post",
		data:{"base_no":base_no},
		dataType:"json",
		success:function(result){
			if(result.status == 1){//查询成功，显示基地基本信息
				/* 学院指导教师 */
				if(result.data.school_teacher !="" && result.data.school_teacher !=null){
					$("#school_teacher").val(result.data.school_teacher);
				}else{
					$("#school_teacher").val(0);
				}
				/* 企业指导教师 */
				if(result.data.company_teacher !="" && result.data.company_teacher !=null){
					$("#company_teacher").val(result.data.company_teacher);
				}else{
					$("#company_teacher").val(0);
				}
			}else{
				alert(result.msg);
			}
		},
		error:function(){
				alert("程序出错");
		}
	});
}