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
   

  
    <!-- Start Body Content -->
  	<div class="main" role="main">
    	<div id="content" class="content full">
    		
    		<c:choose>
            	<c:when test="${not empty anuncio}">
            		
            		<div class="container">
		            	<!-- Anuncio Details -->
		                <article class="single-vehicle-details">
		                    <div class="single-vehicle-title">
		                        <span class="badge-premium-listing"><a href="javascript:window.history.back();">Volver</a></span>
		                        <h2 class="post-title">${anuncio.getTitulo()}</h2>
		                    </div>
            			    <div class="single-listing-actions">
		                        <div class="btn-group pull-right" role="group">
		                            <a href="#" class="btn btn-default" title="Guardar en favoritos"><i class="fa fa-star-o"></i> <span>Guardar en favoritos</span></a>
		                            <a href="#" data-toggle="modal" data-target="#sendModal" class="btn btn-default" title="Enviar a un amigo"><i class="fa fa-send"></i> <span>Enviar a un amigo</span></a>
		                            <a href="javascript:void(0)" onclick="window.print();" class="btn btn-default" title="Imprimir"><i class="fa fa-print"></i> <span>Imprimir</span></a>
		                        </div>
		                        <fmt:formatNumber value="${anuncio.getPrecio()}" type="number" var="precio" /> 
		                        <div class="btn btn-info price">${precio} €</div>
		                    </div>
            				
            				<div class="row">
		                        <div class="col-md-8">
		                            <div class="single-listing-images">
		                            
		                            	<c:choose>
			                            	<c:when test="${not empty anuncio.getAnunciosImagenes() && anuncio.getAnunciosImagenes().size() > 0}">
			                            		
			                            		<div class="featured-image format-image">
		                                            <a href="${pageContext.servletContext.contextPath}/resources/web/${anuncio.getUrlImagen()}" data-rel="prettyPhoto[gallery]" class="media-box"><img src="${pageContext.servletContext.contextPath}/resources/web/${anuncio.getUrlImagen()}" alt=""></a>
		                                        </div>
			                            		
			                            		
			                            		 <c:if test="${anuncio.getAnunciosImagenes().size() > 1}">
			                            		 	 
			                            		 	 <div class="additional-images">
		                                                <ul class="owl-carousel" data-columns="4" data-pagination="no" data-arrows="yes" data-single-item="no" data-items-desktop="4" data-items-desktop-small="4" data-items-tablet="3" data-items-mobile="3">
		                                                  	
		                                                  	 <c:set var="anunciosImagenes" value="${anuncio.getAnunciosImagenes()}" scope="page"/>
		                                                  	 <c:forEach begin="1" items="${anunciosImagenes}" var="anuncioImagen">
					                            		 		<li class="item format-image"> <a href="${pageContext.servletContext.contextPath}/resources/web/${anuncioImagen.getUrlFichero()}" data-rel="prettyPhoto[gallery]" class="media-box"><img src="${pageContext.servletContext.contextPath}/resources/web/${anuncioImagen.getUrlFichero()}" alt=""></a></li>  
					                            		 	 </c:forEach> 
					                            		 	
					                            		 </ul>
                                       				 </div>
                                       				 
			                            		 </c:if>
			                            		
			                            		
			                            	</c:when><%-- ${not empty anuncio.getAnunciosImagenes() and anuncio.getAnunciosImagenes().size() > 0} --%>	
							            	<c:otherwise>
							            		<div class="featured-image format-image">
		                                            <a href=""><img src="${pageContext.servletContext.contextPath}/resources/web/images/listado_sin_imagen_700x400.png" alt=""></a>
		                                        </div>
							            	</c:otherwise>		                            
            							</c:choose>
            							
            						</div>
                      			</div>
            					
            					<div class="col-md-4">
            					
		                            <div class="sidebar-widget widget">
		                                <ul class="list-group">
		                                	<c:if test="${not empty anuncio.getMarca()}">
		                                		<li class="list-group-item"> <span class="badge">Marca</span> ${anuncio.getMarca()}</li>
		                                	</c:if>	
		                                	<c:if test="${not empty anuncio.getModelo()}">
		                                		<li class="list-group-item"> <span class="badge">Modelo</span> ${anuncio.getModelo()}</li>
		                                	</c:if>	
		                                	
		                                	<c:if test="${not empty anuncio.getCategoria()}">
		                                		<c:choose>
			                            			<c:when test="${not empty anuncio.getCategoria().getCategoria()}">
			                            				<li class="list-group-item"> <span class="badge">Categoria</span> ${ anuncio.getCategoria().getCategoria().getNombreCategoria() }</li>
			                            			</c:when><%-- ${not empty anuncio.getCategoria().getCategoria()} --%>	
			                            			<c:otherwise>
									            		<li class="list-group-item"> <span class="badge">Categoria</span> ${ anuncio.getCategoria().getNombreCategoria() }</li>	
									            	</c:otherwise>	
		                                		</c:choose>
		                                	
		                                		<li class="list-group-item"> <span class="badge">Modelo</span> ${anuncio.getModelo()}</li>
		                                	</c:if>	
		                                	
		                                	<c:if test="${not empty anuncio.getProvincia()}">
		                                		<li class="list-group-item"> <span class="badge">Marca</span> ${anuncio.getProvincia().getNombreProvincia()}</li>
		                                	</c:if>	
		                                	<c:if test="${not empty anuncio.getCp()}">
		                                		<li class="list-group-item"> <span class="badge">C.P.</span> ${anuncio.getCp()}</li>
		                                	</c:if>	
		                                	<c:if test="${not empty anuncio.getLocalidad()}">
		                                		<li class="list-group-item"> <span class="badge">Localidad</span> ${anuncio.getLocalidad()}</li>
		                                	</c:if>	
		                                	<c:if test="${not empty anuncio.getHorariosLlamada()}">
		                                		<li class="list-group-item"> <span class="badge">Horario de llamada</span> ${anuncio.getHorariosLlamada().getDescripcion()}</li>
		                                	</c:if>	
		                                </ul>
                            		</div> 
                            		
                            		<div class="accordion" id="toggleArea">
		                                <div class="accordion-group panel">
		                                      <div class="accordion-heading togglize"> <a class="accordion-toggle" data-toggle="collapse" data-parent="#" href="#collapseOne"> Estadísticas <i class="fa fa-plus-circle"></i> <i class="fa fa-minus-circle"></i> </a> </div>
		                                            	<div id="collapseOne" class="accordion-body collapse">
		                                              		<div class="accordion-inner">
		                                                    	<table class="table-specifications table table-striped table-hover">
		                                                            <tbody>
		                                                            	<tr>
		                                                            		<td>Se ha visto</td>
		                                                            		<fmt:formatNumber value="${anuncio.getNumVistos()}" type="number" var="numVistos" /> 
		                                                            		<td>${numVistos}</td>
		                                                            	</tr>
		                                                            	<tr>
		                                                            		<td>Se ha enviado</td>
		                                                            		<fmt:formatNumber value="${anuncio.getNumEnviosEmail()}" type="number" var="numEnviosEmail" /> 
		                                                            		<td>${numEnviosEmail}</td>
		                                                            	</tr>
		                                                            	<tr>
		                                                            		<td>Contactos</td>
		                                                            		<fmt:formatNumber value="${anuncio.getNumAnunciosMensajes()}" type="number" var="numContactos" /> 
		                                                            		<td>${numContactos}</td>  
		                                                            	</tr>
		                                                            	
		                                                            </tbody>
		                                                  		</table>
		                                                    </div>
		                                            	</div>
		                                          	</div>
		                            </div>
                                
                                   
		                                
		                        </div>
		                   	</div> <%-- class="row" --%>
            					
            			
            			
            			</article>
		                <div class="clearfix"></div>
		            </div>
		            
            	</c:when><%-- when test="${not empty anuncio} --%>	
            	<c:otherwise>
            		 <p>Sin anuncio</p>
            	</c:otherwise>
            </c:choose>
    		
    		
    	</div><!-- div id="content" class="content full" -->	
    </div> 
    <!-- End Body Content -->	

