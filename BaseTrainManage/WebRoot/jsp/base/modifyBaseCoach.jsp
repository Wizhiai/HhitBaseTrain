<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML>
<html>
  <head>
    <title>编辑基地教师与辅导队伍信息</title>
		<link rel="stylesheet" type="text/css" href="../../css/common.css"/>
    <link rel="stylesheet" type="text/css" href="../../css/index.css"/>
		<script type="text/javascript" src="../../js/jquery.min.js"></script>
		<script type="text/javascript" src="../../js/jquery-1.9.1.js"></script>
    <script type="text/javascript" src="../../js/slide.js"></script>
    <script type="text/javascript" src="../../js/menuchoose.js"></script>
		<script type="text/javascript" src="../../js/cookie_util.js"></script>
 	<script type="text/javascript">
 		$(function(){
 			var base_no = getCookie("base_no");
		 	if(base_no =="" || base_no ==null){
		 		alert("页面已失效，请重新打开页面！");
		 	}else{
		 		showBaseCoachInfo();
 				slide();
 				$("#update").click(function(){
	 				updateBaseCoach();
	 			});
		 	}
 			
 		});
 		function showBaseCoachInfo(){
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
 		function updateBaseCoach(){
 			var school_teacher = $("#school_teacher").val();//高校(聘请或合作)的指导教师和教辅人员总数
 			var company_teacher = $("#company_teacher").val();//实践教学经验的指导教师和教辅人员总数
 			var base_no = getCookie("base_no");
 			var ok = true;
 			var re =new RegExp("^\\d{0,5}$");//0-5位的数字
 			
 			if(school_teacher !=""){//若高校(聘请或合作)的指导教师和教辅人员总数不为空，判断格式
				var result = re.test(school_teacher);
	 			if(!result){//若高校(聘请或合作)的指导教师和教辅人员总数格式错误
	 				alert("高校(聘请或合作)的指导教师和教辅人员总数格式错误");
	 				ok = false;
	 			}
 			}
 			if(company_teacher !=""){//若实践教学经验的指导教师和教辅人员总数不为空，判断格式
				var result = re.test(company_teacher);
	 			if(!result){//若实践教学经验的指导教师和教辅人员总数格式错误
	 				alert("实践教学经验的指导教师和教辅人员总数格式错误");
	 				ok = false;
	 			}
 			}
 			if(ok){
 				$.ajax({
					url:"http://localhost:8080/BaseTrainManage/base/modifyCocahByBaseNo.do",
					type:"post",
					data:{"base_no":base_no,"school_teacher":school_teacher,"company_teacher":company_teacher},
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
 	</script>
 	
  </head>
  
  <body style="background:#dfe9f7;height:100%;width:100%">
	<div class="baseCoach">
	    <section class="column">
	        <div class="term">
	            <span class="imgBtn"></span><h1 class="resultTitle">学院队伍基地队伍</h1>
	            <div class="resultInfo">
	                <span>来自高校(聘请或合作)的指导教师和教辅人员总数<input type="text" value="" class="baseNeedInfo" id="school_teacher"/>人</span><br/>
	                <span>来自企业，且富有实践教学经验的指导教师和教辅人员总数<input type="text" value="" class="baseNeedInfo" id="company_teacher"/>人</span>
	            </div>
	            <input type="button" class="editBtn" id="update" value="修改">
	        </div>
	    </section>
	</div>
	</body>
</html>
