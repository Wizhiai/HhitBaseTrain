<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML>
<html>
  <head>
    <title>编辑科研与技术活动信息</title>
		<link rel="stylesheet" type="text/css" href="../../css/common.css"/>
    <link rel="stylesheet" type="text/css" href="../../css/base.css"/>	
		<script type="text/javascript" src="../../js/jquery.min.js"></script>
		<script type="text/javascript" src="../../js/jquery-1.9.1.js"></script>
		<script type="text/javascript" src="../../js/slide.js"></script>
    <script type="text/javascript" src="../../js/menuchoose.js"></script>
		<script type="text/javascript" src="../../js/cookie_util.js"></script>
		<script type="text/javascript" src="../../js/base/modifyBaseResearch.js"></script>
 	<script type="text/javascript">
 		
 	</script>
 	
  </head>
  
  <body style="background:#dfe9f7;height:100%;width:100%">
		<div class="baseCoach" >
		    <section class="column">
		        <div class="term">
		            <span class="imgBtn"></span><h1 class="resultTitle">科教研能力</h1>
		            <div class="resultInfo">
		                <span>近三年地区级以上，科研项目总数<input type="text"class="baseNeedInfo" id="research_num"/>项</span>
		                <span class="blank"></span>
		                <span>教育教改研究项目总数<input type="text"class="baseNeedInfo" id="education_num"/>项</span><br/>
		                <span>科教研经费总额<input type="text" class="baseNeedInfo" id="research_funding"/>万元</span><br/>
		                <span>科教研成果</span><br/>
		                <input type="radio" value="1" id="scientific_research1" name="scientific_research"/><span>较为丰硕</span>
                		<input type="radio" value="2" id="scientific_research2" name="scientific_research"/><span>一般</span>
                		<input type="radio" value="3" id="scientific_research3" name="scientific_research"/><span>较少或没有</span>
		                <span>典型科教研成果</span><br/>
		                <textarea class="editContent" id="typical_research"></textarea>
		            </div>
		        </div>
		    </section>
		    <section class="column">
		        <div class="term">
		            <span class="imgBtn"></span><h1 class="resultTitle">实训项目开发能力</h1>
		            <div class="resultInfo">
		                <span>近三年开发项目总数<input type="text"class="baseNeedInfo" id="develop_project_num"/>项</span>
		                <span class="blank" style="width:180px"></span>
		                <span>参与开发的实训学生人数<input type="text"class="baseNeedInfo" id="develop_project_student"/></span><br/>
		                <span>开发项目总额<input type="text"class="baseNeedInfo" id="develop_project_funding"/>万元</span>
		                <span class="blank" style="width:220px"></span>
		                <span>开发职员人数<input type="text"class="baseNeedInfo" id="develop_project_staff"/></span><br/>
		                <span>典型开发成果及效益</span><br/>
		                <textarea class="editContent" id="typical_project"></textarea>
		            </div>
		          
		        </div>
		    </section>
		         <input type="button" class="editBtn" id="update" value="保存"  style='margin-top:20px; margin-left:987px;'>
		</div>
	</body>
</html>
