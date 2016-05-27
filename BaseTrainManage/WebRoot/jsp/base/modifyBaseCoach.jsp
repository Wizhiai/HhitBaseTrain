<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML>
<html>
  <head>
    <title>编辑基地教师与辅导队伍信息</title>
		<link rel="stylesheet" type="text/css" href="../../css/common.css"/>
    <link rel="stylesheet" type="text/css" href="../../css/base.css"/>
		<script type="text/javascript" src="../../js/jquery.min.js"></script>
		<script type="text/javascript" src="../../js/jquery-1.9.1.js"></script>
    <script type="text/javascript" src="../../js/slide.js"></script>
    <script type="text/javascript" src="../../js/menuchoose.js"></script>
		<script type="text/javascript" src="../../js/cookie_util.js"></script>
		<script type="text/javascript" src="../../js/base/modifyBaseCoach.js"></script>
 	<script type="text/javascript">
 		
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
	        </div>
	    </section>
	            <input type="button" class="editBtn clearfix" id="update" value="保存" style='margin-top:20px; margin-left:987px;'>
	</div>
	</body>
</html>
