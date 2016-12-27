<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page pageEncoding="UTF-8"%>

<tiles:importAttribute name="jsList"/>

<!DOCTYPE HTML>
<html class="no-js">
<head>

	<!-- Basic Page Needs  ================================================== -->
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>ADMIN</title>
	<meta name="description" content="">
	<meta name="keywords" content="">
	<meta name="author" content="">
	
	<tiles:insertAttribute name="head_css_js_metas_comunes"/>
	
</head>
<body>
	<!--[if lt IE 7]>
		<p class="chromeframe">You are using an outdated browser. <a href="http://browsehappy.com/">Upgrade your browser today</a> or <a href="http://www.google.com/chromeframe/?redirect=true">install Google Chrome Frame</a> to better experience this site.</p>
	<![endif]-->
	<div class="body home floated-search">
	    <div class="site-header-wrapper">
			<!-- Start Site Header -->
			<tiles:insertAttribute name="header"/>
		    <!-- End Site Header -->
		        
		    <!-- Start navbar -->
			<tiles:insertAttribute name="menu"/>
		    <!-- End navbar -->  
	    </div>    
	    
	    <!-- Start Body Content -->
	    <tiles:insertAttribute name="body"/>
	    <!-- End Body Content -->
	    
	    <!-- Start site footer -->
	    <tiles:insertAttribute name="footer"/> 
	    <!-- End site footer -->
	    
	    <a id="back-to-top"><i class="fa fa-angle-double-up"></i></a>  
	</div>
	
		
	<tiles:insertAttribute name="footer_js_comunes"/> 
	
	<c:forEach var="jsValue" items="${jsList}">
	    <script src="<c:url value="${jsValue}"/>"></script>
	</c:forEach>

</body>
</html>