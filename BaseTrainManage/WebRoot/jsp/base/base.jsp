<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML >
<html style="overflow: scroll;">
  <head>
    <title>基地信息</title>
    <link rel="stylesheet" type="text/css" href="../../css/common.css"/>
    <link rel="stylesheet" type="text/css" href="../../css/base.css"/>
		<script type="text/javascript" src="../../js/jquery.min.js"></script>
		<script type="text/javascript" src="../../js/cookie_util.js"></script>
		<script type="text/javascript" src="../../js/base/base.js"></script>
    <script type="text/javascript">
        
    </script>
  </head>
  
  <body>
  	<section class="mainBody">
        <section class="showInfo">
            <span>基地名称:</span>
            <input type="text" id="base_name" class="baseInfo" style="width:300px;" disabled="disabled"/>
            <span>成立时间:</span>
            <input type="text"  id="establish_time"  class="baseInfo" disabled="disabled">
            <span class="baseAddr" style="margin-top:0px;">基地地址:</span>
            <input type="text"  id="base_address"  class="baseInfo" disabled="disabled"><br/>
            <span class="baseAddr">基地负责人:</span>
            <input type="text"  id="manager_name"  class="baseInfo" style="margin-top:20px;" disabled="disabled">
            <span class="baseAddr" style="margin-left:130px;">联系电话:</span>
            <input type="text"  id="telephone"  class="baseInfo" style="margin-top:30px;" disabled="disabled">
        </section>
        <section class="researchInfo">
            <ul>
                <li><a id="base_build_manage" class="selected">基地建设与管理状况</a></li>
                <li><a id="site_facility_condition">场地与设施条件</a></li>
                <li><a id="train_goal_content">实训项目目标及内容</a></li>
                <li><a id="teacher_coach_staff">教师与辅导队伍</a></li>
                <li><a id="research_technical_activity">科研与技术活动</a></li>
                <li><a id="practice_effect_develop">实践效果与能力开发</a></li>
                <li><a id="enterprise_alliance">企业联盟</a></li>
                <li><a id="base_character">基地特色</a></li>
            </ul>
            <div class="researchResult">
                <iframe id="baseManage" src=""
                        frameborder="0" width="100%" height="100%" name="baseManage"  height="100%" border="1px solid #ccc" ></iframe>
            </div>
        </section>
    </section>
  </body>
</html>
