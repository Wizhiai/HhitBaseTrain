<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@page import="com.sun.net.httpserver.HttpContext"%>
<html>

<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>管理系统</title>
<link type="text/css" rel="stylesheet" href="../css/asSystemstyle.css" />

<!--[if lt IE 9]> <script src="http://css3-mediaqueries-js.googlecode.com/svn/trunk/css3-mediaqueries.js"></script> <![endif]-->

<script type="text/javascript" src="../js/jquery-1.8.3.min.js"></script>
<script type="text/javascript" src="../js/asSystemmenu.js"></script>
<script type="text/javascript" src="../js/js.js"></script>




</head>

<body>


<div id="header">
	<div class="logo">实训质量评估系统</div>
	<div class="navigation">
		<ul>
		 	<li>欢迎您！</li>
			<li><a href="" id = "userId"><%=request.getParameter("id") %></a></li>
			<li><a href="../jsp/baseValueLogin.jsp">退出</a></li>
		</ul>
	</div>
</div>
<div id="content">
	<div class="left_menu">
				<ul id="nav_dot">
     
        <li>  
        
       
    <div class="B" >
       <ul >
        <li id='li1' class="select">   <h4 class="M1" style="color:#ffffff"><span></span><a >专家库管理</a></h4>     
            <div id="C" class="D">
          <h4 class="M1"  style="color:#ccff00"><span></span><a onclick="changeSrcaExpertManage()" id = "changeSrcaExpertManage">添加专家</a></h4>
             <h4 class="M1"  style="color:#ccff00"><span></span><a onclick="changeSrcaEvaluationResultManagement()" id = "changeSrcaEvaluationResultManagement">专家库管理</a></h4>
        
            </div>
        </li>
      
        </ul>
 
</div>
        
        
        
        
      
         
    
       <ul >
          
   <h4 class="M1"  ><span></span><a onclick="changeSrcaExpertCommitteeManagement()" id = "changeSrcaExpertCommitteeManagement">专家委员会管理</a></h4>
       
           
        
           
       
      
        </ul>
 

            
				<li>
       <h4 class="M1" ><span></span><a onclick="announcementManage()" id = "announcementManage">评估信息管理</a></h4>
        </li>
			
  </ul>
		</div>
		<div class="m-right">
			<div class="right-nav">
					<ul>
							<li><img src="../images/home.png"></li>
								<li style="margin-left:25px;">您当前的位置：</li>
								
								<li><a  href="#" id="p">最新公告</a></li>
						</ul>
			</div>
			
			<div class="main">
<iframe id="frameBord" name="frameBord" frameborder="0" width="100%" height="100%" marginwidth="10px" marginheight="10px" src="http://www.hhit.edu.cn/" />
			
			</div>
		</div>
</div>
<div class="bottom"></div>
<div id="footer"><p>Copyright©  2016 版权所有 淮海工学院  来源:<a href="http://www.hhit.edu.cn/" target="_blank">YouZhi</a></p></div>
<script>navList(12);</script>
</body>
</html>
