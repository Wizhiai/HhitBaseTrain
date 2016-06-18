<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>编辑实训目标及内容信息</title>
		<link rel="stylesheet" type="text/css" href="../../css/common.css"/>
    <link rel="stylesheet" type="text/css" href="../../css/base.css"/>
		<script type="text/javascript" src="../../js/jquery.min.js"></script>
		<script type="text/javascript" src="../../js/jquery-1.9.1.js"></script>
    <script type="text/javascript" src="../../js/slide.js"></script>
    <script type="text/javascript" src="../../js/menuchoose.js"></script>
		<script type="text/javascript" src="../../js/cookie_util.js"></script>
		<script type="text/javascript" src="../../js/base/modifyBaseContent.js"></script>
 	<script type="text/javascript">
 		
 	</script>
 	
  </head>
  
  <body style="background:#dfe9f7;height:100%;width:100%">
		<div class="baseContent">
		    <section class="column">
		        <div class="term">
		            <span class="imgBtn"></span><h1 class="resultTitle">实训大纲</h1>
		            <div class="resultInfo">
		                <span>现已编印制订好的实训实习大纲有哪些(详细列出名称)</span>
		                <textarea class="editContent" id="internship_outline"></textarea><br/><br/>
		                <span>拟制订和编印的实习实训大纲有哪些（详细列出名称)</span>
		                <textarea class="editContent" id="outline_plan"></textarea><br/><br/>
		                <input type="checkbox" id="none_outline"/><span>目前尚无实训大纲</span>
		            </div>
		        </div>
		        <div class="term">
		            <span class="imgBtn"></span><h1 class="resultTitle">实训计划</h1>
		            <div class="resultInfo">
		                <span>已制订编印好的实习实训计划有哪些(详细列出名称)</span>
		                <textarea class="editContent" id="train_plan"></textarea><br/><br/>
		                <span>拟制订编印的实习实训计划有哪些(详细列出名称)</span>
		                <textarea class="editContent" id="new_plan"></textarea><br/><br/>
		                <input type="checkbox" id="none_plan"/><span>目前尚无实训计划</span>
		            </div>
		        </div>
		    </section>
		    <section class=" column">
		        <div class="term">
		            <span class="imgBtn"></span><h1 class="resultTitle">实训指导书</h1>
		            <div class="resultInfo">
		                <span>已制定编印好的实训指导书有哪些(详细列出名称)</span>
		                <textarea class="editContent" id="guide_book"></textarea><br/><br/>
		                <span>拟制定编印好的实训指导书有哪些(详细列出名称)</span>
		                <textarea class="editContent" id="new_guidingbook"></textarea><br/><br/>
		                <input type="checkbox" id="none_guidingbook"/><span>目前尚无指导书</span>
		            </div>
		        </div>
		        <div class="term">
		            <span class="imgBtn"></span><h1 class="resultTitle">实训教材</h1>
		            <div class="resultInfo">
		                <span>已编印的实训教材有哪些(详细列出名称)</span>
		                <textarea class="editContent" id="teaching_material"></textarea><br/><br/>
		                <span>拟编印的实训教材有哪些(详细列出名称)</span>
		                <textarea class="editContent" id="new_material"></textarea><br/><br/>
		                <span>选用出版图书有哪些(详细列出名称)</span>
		                <textarea class="editContent" id="publish_book"></textarea>
		                <input type="checkbox" id="none_material"/><span>目前尚无教材</span>
		            </div>
		        </div>
		    </section>
		    <section class=" column">
		        <div class="term">
		            <span class="imgBtn"></span><h1 class="resultTitle">实训项目群(补强课程部分)</h1>
		            <div class="resultInfo">
		                <span>目前现实施的补强实训实习项目/课程名称(详细列出名称)</span>
		                <textarea class="editContent" id="train_project"></textarea><br/><br/>
		                <span>一般每项目/课程同时安排实训学生人数<input type="text" class="baseNeedInfo" id="student_num"/></span><br/>
		                <span>每生实训费用</span><input type="text"class="baseNeedInfo" id="train_price" style="width:160px;"/><span></span><br/>
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
		     <input type="button" class="editBtn clearfix" id="update" value="保存" style='margin-top:-200px; margin-left:1040px;'>
		</div>
	</body>
</html>
