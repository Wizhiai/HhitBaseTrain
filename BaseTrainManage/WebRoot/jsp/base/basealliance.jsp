<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML>
<html>
  <head>
    <title>企业联盟</title>
		<link rel="stylesheet" type="text/css" href="../../css/common.css"/>
    <link rel="stylesheet" type="text/css" href="../../css/base.css"/>
		<script type="text/javascript" src="../../js/jquery.min.js"></script>
		<script type="text/javascript" src="../../js/jquery-1.9.1.js"></script>
    <script type="text/javascript" src="../../js/slide.js"></script>
    <script type="text/javascript" src="../../js/menuchoose.js"></script>
		<script type="text/javascript" src="../../js/cookie_util.js"></script>
		<script type="text/javascript" src="../../js/base/basealliance.js"></script>
 		<script type="text/javascript">
 		
 	</script>
 	
  </head>
  
  <body style="background:#dfe9f7;height:100%;width:100%">
    <section  class="baseCoach">
        <section class="column">
            <div class="term">
                <span class="imgBtn"></span><h1 class="resultTitle">合作企业及其状况</h1>
                <div class="resultInfo">
                    <span>合作开发实训项目的企业数<input type="text" id="cooperation_enterprise_num" class="baseNeedInfo" style="width:160px;"/></span>
                    <span>每年合作开发项目数<input type="text" id="cooperation_project_num" class="baseNeedInfo" style="width:160px;"/></span><br/>
                    <span>加入就业联盟的企业数<input type="text" id="employment_alliance_num" class="baseNeedInfo" style="width:160px;"/></span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    <span>实际从基地招生的企业数<input type="text" id="actual_employment_num" class="baseNeedInfo" style="width:160px;"/></span><br/>
                    <span>就业联盟企业招生数占实训学生总数的比例<input type="text" id="employment_alliance_proportion" class="baseNeedInfo" />%</span><br/>
                    <span>请列出与本基地长期稳定合作的大中型企业名称</span>
                    <textarea class="editContent" id="cooperation_enterprise_name"></textarea>
                </div>
            </div>
        </section>
    </section>
  </body>
</html>
