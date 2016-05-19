<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
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
				url:"http://localhost:8080/BaseTrainManage/base/searchContentByBaseNo.do",
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
 			/* 制定好的实训大纲 */
 			if(data.internship_outline != "" && data.internship_outline !=null){
 				$("#internship_outline").val(data.internship_outline);
 				
 			}else{
 				$("#internship_outline").val("无已编印制定好的实习大纲");
 			}
 			/*拟指定的实训大纲*/
 			if(data.outline_plan != "" && data.outline_plan !=null){
 				$("#outline_plan").val(data.outline_plan);
 			}else{
 				$("#outline_plan").val("无拟制定和编印的实习大纲");
 			}
 			/* 制定好的计划 */
 			if(data.train_plan != "" && data.train_plan != null){
 				$("#train_plan").val(data.train_plan);
 				
 			}else{
 				$("#train_plan").val("无已制定编印好的实习实训计划");
 			}
 			/*拟制定的计划*/
 			if(data.new_plan != "" && data.new_plan !=null){
 				$("#new_plan").val(data.new_plan);
 			}else{
 				$("#new_plan").val("无拟制定编印的实习实训计划");
 			}
 			/* 制定好的指导书 */
 			if(data.guide_book != "" && data.guide_book != null){
 				$("#guide_book").val(data.guide_book);
 				
 			}else{
 				$("#guide_book").val("无已制定编印好的实训指导书");
 			}
 			/*拟指定的指导书*/
 			if(data.new_guidingbook != "" && data.new_guidingbook !=null){
 				$("#new_guidingbook").val(data.new_guidingbook);
 			}else{
 				$("#new_guidingbook").val("无拟制定编印的实训指导书");
 			}
 			/* 已编订的实训教材 */
 			if(data.teaching_material != "" && data.teaching_material != null){
 				$("#teaching_material").val(data.teaching_material);
 				
 			}else{
 				$("#teaching_material").val("无已编印的实训教材");
 			}
 			/*拟编订的实训教材*/
 			if(data.new_material != "" && data.new_material !=null){
 				$("#new_material").val(data.new_material);
 			}else{
 				$("#new_material").val("无拟编印的实训教材");
 			}
 			/*选用出版图书*/
 			if(data.publish_book != "" && data.publish_book !=null){
 				$("#publish_book").val(data.publish_book);
 			}else{
 				$("#publish_book").val("无选用出版图书");
 			}
 			/*补强实训项目/课程名称 */
 			if(data.train_project != "" && data.train_project !=null){
 				$("#train_project").val(data.train_project);
 			}else{
 				$("#train_project").val("目前无补强实训项目/课程");
 			}
 			/*拟开拓新的实训项目*/
 			if(data.new_project != "" && data.new_project !=null){
 				$("#new_project").val(data.new_project);
 			}else{
 				$("#new_project").val("无拟开拓的新实习项目名称/课程名称");
 			}
 			/* 每个项目/课程安排的学生人数 */ 
 			if(data.student_num != "" && data.student_num !=null){
 				$("#student_num").val(data.student_num);
 			}else{
 				$("#student_num").val("未填写");
 			}
 			/* 实训费用 */ 
 			if(data.train_price != "" && data.train_price !=null){
 				$("#train_price").val(data.train_price);
 			}else{
 				$("#train_price").val("未填写");
 			}
 			/* 开发案例*/ 
 			if(data.develop_case != "" && data.develop_case !=null){
 				$("#develop_case").val(data.develop_case);
 			}else{
 				$("#develop_case").val("无工程项目开发案例及其研发平台");
 			}
 		}
 	</script>
 	
  </head>
  
  <body style="background:#dfe9f7;height:100%;width:100%">
		<div class="baseContent">
		    <section class="column">
		        <div class="term">
		            <span class="imgBtn"></span><h1 class="resultTitle">实训大纲</h1>
		            <div class="resultInfo">
		                <span>现已编印制订好的实训实习大纲有哪些(详细列出名称)</span>
		                <textarea class="editContent" id="internship_outline"></textarea>
		                <span>拟制订和编印的实习实训大纲有哪些（详细列出名称)</span>
		                <textarea class="editContent" id="outline_plan"></textarea>
		                
		            </div>
		        </div>
		        <div class="term">
		            <span class="imgBtn"></span><h1 class="resultTitle">实训计划</h1>
		            <div class="resultInfo">
		                <span>已制订编印好的实习实训计划有哪些(详细列出名称)</span>
		                <textarea class="editContent" id="train_plan"></textarea>
		                <span>拟制订编印的实习实训计划有哪些(详细列出名称)</span>
		                <textarea class="editContent" id="new_plan"></textarea>
		            </div>
		        </div>
		    </section>
		    <section class=" column">
		        <div class="term">
		            <span class="imgBtn"></span><h1 class="resultTitle">实训指导书</h1>
		            <div class="resultInfo">
		                <span>已制定编印好的实训指导书有哪些(详细列出名称)</span>
		                <textarea class="editContent" id="guide_book"></textarea>
		                <span>拟制定编印好的实训指导书有哪些(详细列出名称)</span>
		                <textarea class="editContent" id="new_guidingbook"></textarea>
		            </div>
		        </div>
		        <div class="term">
		            <span class="imgBtn"></span><h1 class="resultTitle">实训教材</h1>
		            <div class="resultInfo">
		                <span>已编印的实训教材有哪些(详细列出名称)</span>
		                <textarea class="editContent" id="teaching_material"></textarea>
		                <span>拟编印的实训教材有哪些(详细列出名称)</span>
		                <textarea class="editContent" id="new_material"></textarea>
		                <span>选用出版图书有哪些(详细列出名称)</span>
		                <textarea class="editContent" id="publish_book"></textarea>
		            </div>
		        </div>
		    </section>
		    <section class=" column">
		        <div class="term">
		            <span class="imgBtn"></span><h1 class="resultTitle">实训项目群(补强课程部分)</h1>
		            <div class="resultInfo">
		                <span>目前现实施的补强实训实习项目/课程名称(详细列出名称)</span>
		                <textarea class="editContent" id="train_project"></textarea>
		                <span>一般每项目/课程同时安排实训学生人数<input type="text" class="baseNeedInfo" id="student_num"style="width:200px;"/></span><br/>
		                <span>每生实训费用</span><input type="text"class="baseNeedInfo" id="train_price" style="width:200px;"/><span></span><br/>
		                <span>近期拟开拓的新实习项目名称/课程名称(详细列出名称)</span>
		                <textarea class="editContent" id="new_project"></textarea>
		            </div>
		        </div>
		        <div class="term">
		            <span class="imgBtn"></span><h1 class="resultTitle">软件工程实训项目群</h1>
		            <div class="resultInfo">
		                <span>工程项目开发案例及其研发平台名称</span>
		                <textarea class="editContent" id="develop_case"></textarea>
		            </div>
		        </div>
		    </section>
		</div>
	</body>
</html>
