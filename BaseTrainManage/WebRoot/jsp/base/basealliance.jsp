<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML>
<html>
  <head>
    <title>My JSP 'base.jsp' starting page</title>
		<link rel="stylesheet" type="text/css" href="../../css/common.css"/>
    <link rel="stylesheet" type="text/css" href="../../css/index.css"/>
		<script type="text/javascript" src="../../js/jquery.min.js"></script>
		<script type="text/javascript" src="../../js/jquery-1.9.1.js"></script>
    <script type="text/javascript" src="../../js/slide.js"></script>
    <script type="text/javascript" src="../../js/menuchoose.js"></script>
		<script type="text/javascript" src="../../js/cookie_util.js"></script>
 		<script type="text/javascript">
 		$(function(){
 			showBaseBuildInfo();
 			slide();
 		});
 		function showBaseBuildInfo(){
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
 	</script>
 	
  </head>
  
  <body style="background:#dfe9f7;height:100%;width:100%">
    <section  class="baseCoach">
        <section class="column">
            <div class="term">
                <span class="imgBtn"></span><h1 class="resultTitle">合作企业及其状况</h1>
                <div class="resultInfo">
                    <span>合作开发实训项目的企业数<input type="text" id="cooperation_enterprise_num" class="baseNeedInfo"/></span>
                    <span>每年合作开发项目数<input type="text" id="cooperation_project_num" class="baseNeedInfo"/></span><br/>
                    <span>加入就业联盟的企业数<input type="text" id="employment_alliance_num" class="baseNeedInfo"/></span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    <span>实际从基地招生的企业数<input type="text" id="actual_employment_num" class="baseNeedInfo"/></span><br/>
                    <span>就业联盟企业招生数占实训学生总数的比例<input type="text" id="employment_alliance_proportion" class="baseNeedInfo"/>%</span><br/>
                    <span>请列出与本基地长期稳定合作的大中型企业名称</span>
                    <textarea class="editContent" id="cooperation_enterprise_name"></textarea>
                </div>
            </div>
        </section>
    </section>
  </body>
</html>
