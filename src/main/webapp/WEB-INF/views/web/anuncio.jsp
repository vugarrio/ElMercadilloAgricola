<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<div class="page-header parallax" style="background-image:url(${pageContext.servletContext.contextPath}/resources/web/images/slides/hay-bales_1200_300.png);">
   	<div class="container">
       	<h1 class="page-title">Detalle del Anuncio</h1>
      	</div>
   </div>
   
   <!-- Utiity Bar -->
   <div class="utility-bar">
   	<div class="container"> 
       	<div class="row">	
           	<div class="col-md-8 col-sm-6 col-xs-8">
                   <%-- if (anuncio != null) { 
                   <%= beanAnuncios.getHTMLMigaPan(anuncio.getIdAnuncio()) %>
                   <% } --%>
           	</div>
               <div class="col-md-4 col-sm-6 col-xs-4">                	
                   <%--  <%@ include file="includes/iconos_redes_sociales.jsp" %> --%>
               </div>
           </div>
     	</div>
   </div>
   
    <c:if test="${ (not empty anuncio)	}">
    	<p>${anuncio.getTitulo()}</p>    
    </c:if>