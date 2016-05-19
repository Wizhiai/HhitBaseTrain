<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML >
<html  >
  <head>
    <title>编辑基地建设与管理状况信息</title>
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
		 		showBaseBuildInfo();
	 			slide();
	 			$("#update").click(function(){
	 				updateBaseBuild();
	 			});
		 	}
 			
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
 				$("#base_qualification1").attr("checked","true");
 			}else{
 				$("#base_qualification").attr("checked","true");
 			}
 			/* 主要规章制度 */
 			if(data.main_rule !="" && data.main_rule!=null){
 				$("#main_rule").val(data.main_rule);
 			}else{
 				$("#main_rule").val("无主要规章制度");
 			}
 			/* 基地管理机构情况 */
 			if(data.manage_institution == 1){
 				$("#manage_institution1").attr("checked","true");
 			}else if(data.manage_institution == 2){
 				$("#manage_institution2").attr("checked","true");
 			}else{
 				$("#manage_institution3").attr("checked","true");
 			}
 			/* 建设发展计划 */
 			if(data.development_plan == 1){
 				$("#development_plan1").attr("checked","true");
 			}else if(data.development_plan == 2){
 				$("#development_plan2").attr("checked","true");
 			}else{
 				$("#development_plan3").attr("checked","true");
 			}
 			/* 建设经费总额 */
 			if(data.construction_funds != "" && data.construction_funds !=null){
 				$("#construction_funds").val(data.construction_funds);
 			}else{
 				$("#construction_funds").val(0);
 			}
 			
 			/* 经费状况 */
 			if(data.financial_situation == 1){
 				$("#financial_situation1").attr("checked","true");
 			}else if(data.financial_situation == 2){
 				$("#financial_situation2").attr("checked","true");
 			}else{
 				$("#financial_situation3").attr("checked","true");
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
 		function updateBaseBuild(){
 			var ok = true;
 			var base_property = $("input:checkbox[name='base_property']:checked").map(function(){
 			return $(this).val();
 			}).get().join(",");//基地性质
 			var base_qualification = $("input:radio[name='base_qualification']:checked").val();//基地资格
 			var main_rule = $("#main_rule").val();//规章制度
 			var manage_institution = $("input:radio[name='manage_institution']:checked").val();//管理机构
 			var development_plan = $("input:radio[name='development_plan']:checked").val();//发展计划
 			var construction_funds = $("#construction_funds").val();//建设经费
 			var financial_situation = $("input:radio[name='financial_situation']:checked").val();//经费状况
 			var teacher_num = $("#teacher_num").val();//教师人数
 			var intermediate_num = $("#intermediate_num").val();//中级职称
 			var senior_num = $("#senior_num").val();//高级职称
 			var experienced_teacher = $("#experienced_teacher").val();//指导教师
 			var manager_num = $("#manager_num").val();//管理人员数
 			var aid_num = $("#aid_num").val();//辅导人员数
 			var developer_num = $("#developer_num").val();//实训开发人员数
 			var base_no = getCookie("base_no");
 			if(construction_funds !=""){//若建设经费不为空，判断格式
 				var re =new RegExp("^\\d{0,8}(\\.\\d{0,2})?$");
				var result = re.test(construction_funds);
	 			if(!result){//若建设经费不是非负浮点数
	 				alert("建设经费输入格式错误");
	 				ok = false;
	 			}
 			}
 			
 			if(ok){
 				$.ajax({
					url:"http://localhost:8080/BaseTrainManage/base/modifyBuildByBaseNo.do",
					type:"post",
					data:{"base_no":base_no,"base_property":base_property,"base_qualification":base_qualification,
								"main_rule":main_rule,"manage_institution":manage_institution,"development_plan":development_plan,
								"construction_funds":construction_funds,"financial_situation":financial_situation,"teacher_num":teacher_num,
								"intermediate_num":intermediate_num,"senior_num":senior_num,"experienced_teacher":experienced_teacher,
								"manager_num":manager_num,"aid_num":aid_num,"developer_num":developer_num},
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
  <body>
     <div class="baseBuild" >
        <section class="baseCharacter column">
            <div class="term">
                <span class="imgBtn"></span><h1 class="resultTitle">基地性质</h1>
                <div class="resultInfo">
                    <input type="checkbox" id="base_property1" value="1" name="base_property"/><span>培训单位/学校</span>
                    <input type="checkbox" id="base_property2" value="2" name="base_property"/><span>研发生产企业</span>
                </div>
            </div>
            <div class="term">
                <span class="imgBtn"></span><h1  class="resultTitle">基地资格</h1>
                <div class="resultInfo">
                    <input type="radio" id="base_qualification1" value="1" name="base_qualification"/><span>生产、营业执照和资质批文齐全</span><br/>
                    <input type="radio" id="base_qualification2" value="2" name="base_qualification"/><span>上述手续正在办理中</span>
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
                		<input type="radio" value="1" id="manage_institution1" name="manage_institution"/><span>管理机构完善</span>
                		<input type="radio" value="2" id="manage_institution2" name="manage_institution"/><span>有管理机构</span><br/>
                    <input type="radio" value="3" id="manage_institution3" name="manage_institution"/><span>无管理机构</span><br/>
                </div>
            </div>
            <div class="term">
                <span class="imgBtn"></span><h1  class="resultTitle">发展计划</h1>
                <div class="resultInfo">
                		<input type="radio" value="1" id="development_plan1" name="development_plan"/><span>建设发展计划完善</span>
                    <input type="radio" value="2" id="development_plan2" name="development_plan"/><span>有建设发展计划</span><br/>
                    <input type="radio" value="2" id="development_plan3" name="development_plan"/><span>无建设发展计划</span>
                </div>
            </div>
            <div class="term">
                <span class="imgBtn"></span><h1  class="resultTitle">建设经费</h1>
                <div class="resultInfo">
                    <span>总额</span>
                    <input type="text" id="construction_funds"/><span>千万</span><br/>
                    <span>经费状况</span><br/>
                    <input type="radio" value="1" id="financial_situation1" name="financial_situation"/><span>经费全部到位</span><br/>
                    <input type="radio" value="2" id="financial_situation2" name="financial_situation"/><span>经费大部分到位</span><br/>
                    <input type="radio" value="3" id="financial_situation3" name="financial_situation"/><span>经费大部分未到位</span>
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
            <input type="button" class="editBtn" id="update" value="修改">
        </section>
    </div>
  </body>
</html>
