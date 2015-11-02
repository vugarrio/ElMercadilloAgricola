<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="tilesx" uri="http://tiles.apache.org/tags-tiles-extras" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>


<html>
<head>
	<c:set var="titleKey">
        <tiles:insertAttribute name="title" ignore="true" />
    </c:set>
    <title><spring:message code="${titleKey}"/> -- TEMPLATE PRUEBA --</title>
    
	<meta charset="utf-8">
	<style type="text/css">
		body {
			font-family: Arial, Verdana, sans-serif;
		}
		.header,.footer,.leftPane,.rightPane {
			border: 1px solid gray;
		}
		.header,.main,.footer {
			width: 960px;
			color: #665544;
			margin: 0px auto;
			clear: both;
		}
		.leftPane,.rightPane {
			float: left;
			margin: 10px;
			height: 400px;
		}
		.leftPane {
			width: 100px;
		}
		.rightPane {
			width: 815px;
		}
		.leftMenu {
			list-style: none;
			padding: 0;
			margin: 10px;
		}
	</style>
	
	<script type="text/javascript" src="${pageContext.servletContext.contextPath}/resources/js/jquery/js/jquery-2.1.4.min.js"></script>
	
</head>
<body>
	

	<tiles:insertAttribute name="header"/>
		<div class="main">
			<tiles:insertAttribute name="menu"/>
			<div class="rightPane">
				<tiles:insertAttribute name="body"/>
			</div>
		</div>
	<tiles:insertAttribute name="footer" />
	
	<tilesx:useAttribute name="current"/>
    <tiles:insertAttribute name="modals"/>
	
	
</body>
</html>
