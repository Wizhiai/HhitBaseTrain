<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML >
<html  >
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
				url:"http://localhost:8080/BaseTrainManage/base/searchBuildByBaseNo.do",
				type:"post",
				data:{"base_no":base_no},
				dataType:"json",
				success:function(result){
					if(result.status == 1){//查询成功，显示基地基本信息
						manageData(result.data)
					}else{
						alert(result.msg);
					}
				},
				error:function(){
						alert("程序出错");
				}
			});
 		}
 		function manageData(data){
 			/*基地性质*/
 			if(data.base_property != "" && data.base_property != null){
 				var propertys = data.base_property.split(",");
	 			var property = "";
	 			for(var i = 0;i<propertys.length;i++){
	 				if(propertys[i]==1){
	 					$("#base_property1").attr("checked","true");
	 				}else{
	 					$("#base_property2").attr("checked","true");
	 				}
	 			}
 			}
 			
 			/*基地资格*/
 			if(data.base_qualification == 1){
 				$("#base_qualification").text("生产、营业执照和资质批文齐全");
 			}else{
 				$("#base_qualification").text("上述手续正在办理中");
 			}
 			/* 主要规章制度 */
 			if(data.main_rule !="" && data.main_rule!=null){
 				$("#main_rule").val(data.main_rule);
 			}else{
 				$("#main_rule").val("无主要规章制度");
 			}
 			/* 基地管理机构情况 */
 			if(data.manage_institution == 1){
 				$("#manage_institution").text("管理机构完善");
 			}else if(data.manage_institution == 2){
 				$("#manage_institution").text("有管理机构");
 			}else{
 				$("#manage_institution").text("无管理机构");
 			}
 			/* 建设发展计划 */
 			if(data.development_plan == 1){
 				$("#development_plan").text("建设发展计划完善 ");
 			}else if(data.development_plan == 2){
 				$("#development_plan").text("有建设发展计划 ");
 			}else{
 				$("#development_plan").text("无建设发展计划 ");
 			}
 			/* 建设经费总额 */
 			if(data.construction_funds != "" && data.construction_funds !=null){
 				$("#construction_funds").val(data.construction_funds);
 			}else{
 				$("#construction_funds").val(0);
 			}
 			
 			/* 经费状况 */
 			if(data.financial_situation == 1){
 				$("#financial_situation").text("经费全部到位");
 			}else if(data.financial_situation == 2){
 				$("#financial_situation").text("经费大部分到位");
 			}else{
 				$("#financial_situation").text("经费大部分未到位");
 			}
 			/* 教师人数 */
 			if(data.teacher_num != "" && data.teacher_num !=null){
 				$("#teacher_num").val(data.teacher_num);
 			}else{
 				$("#teacher_num").val(0);
 			}
 			/* 高级职称 */
 			if(data.senior_num != "" && data.senior_num !=null){
 				$("#senior_num").val(data.senior_num);
 			}else{
 				$("#senior_num").val(0);
 			}
 			/* 中级职称 */
 			if(data.intermediate_num != "" && data.intermediate_num !=null){
 				$("#intermediate_num").val(data.intermediate_num);
 			}else{
 				$("#intermediate_num").val(0);
 			}
 			/* 企业、项目经验丰富的指导教师人数 */
 			if(data.experienced_teacher != "" && data.experienced_teacher !=null){
 				$("#experienced_teacher").val(data.experienced_teacher);
 			}else{
 				$("#experienced_teacher").val(0);
 			}
 			/* 管理人员数 */
 			if(data.manager_num != "" && data.manager_num !=null){
 				$("#manager_num").val(data.manager_num);
 			}else{
 				$("#manager_num").val(0);
 			}
 			/* 基辅助人员数 */
 			if(data.aid_num != "" && data.aid_num !=null){
 				$("#aid_num").val(data.aid_num);
 			}else{
 				$("#aid_num").val(0);
 			}
 			/* 实训项目开发人员数 */
 			if(data.developer_num != "" && data.developer_num !=null){
 				$("#developer_num").val(data.developer_num);
 			}else{
 				$("#developer_num").val(0);
 			}
 		}
 	</script>
 	
  </head>
  <body>
     <div class="baseBuild" >
        <section class="baseCharacter column">
            <div class="term">
                <span class="imgBtn"></span><h1 class="resultTitle">基地性质</h1>
                <div class="resultInfo">
                     <input type="checkbox" id="base_property1"/><span>培训单位/学校</span>
                     <input type="checkbox" id="base_property2"/><span>研发生产企业</span>
                </div>
            </div>
            <div class="term">
                <span class="imgBtn"></span><h1  class="resultTitle">基地资格</h1>
                <div class="resultInfo">
                    <p id="base_qualification"></p>
                </div>
            </div>
            <div class="term">
                <span class="imgBtn"></span><h1  class="resultTitle">规章制度</h1>
                <div class="resultInfo">
                    <textarea class="editContent" id="main_rule"></textarea>
                </div>
            </div>
        </section>
        <section class="baseManage column">
            <div class="term">
                <span class="imgBtn"></span><h1 class="resultTitle">管理机构</h1>
                <div class="resultInfo">
                    <p id="manage_institution">管理机构完善</p>
                </div>
            </div>
            <div class="term">
                <span class="imgBtn"></span><h1  class="resultTitle">发展计划</h1>
                <div class="resultInfo">
                    <p id="development_plan"></p>
                </div>
            </div>
            <div class="term">
                <span class="imgBtn"></span><h1  class="resultTitle">建设经费</h1>
                <div class="resultInfo">
                    <span>总额</span>
                    <input type="text" id="construction_funds"/><span>千万</span><br/><br/>
                    <span>经费状况：<span id="financial_situation"></span></span>
                </div>
            </div>
        </section>
        <section class="column unitPersonnel">
            <div class="term">
                <span class="imgBtn"></span><h1  class="resultTitle">单位人员</h1>
                <div class="resultInfo personnel">
                    <span>教师人数:</span><input class="numBtn" type="number" id="teacher_num"/><br/>
                    <span>高级职称:</span><input class="numBtn"type="number" id="senior_num"/><br/>
                    <span>中级职称:</span><input class="numBtn"type="number" id="intermediate_num"/><br/>
                    <span>指导教师:</span><input class="numBtn"type="number" id="experienced_teacher"/><br/>
                    <span>管理人员数:</span><input class="numBtn lastNextNum" id="manager_num"/><br/>
                    <span>辅导人员数:</span><input class="numBtn lastNextNum" id="aid_num"/><br/>
                    <span>实训开发人员数:</span><input class="numBtn lastNum"type="number" id="developer_num"/><br/>
                </div>
            </div>
        </section>
    </div>
  </body>
</html>
