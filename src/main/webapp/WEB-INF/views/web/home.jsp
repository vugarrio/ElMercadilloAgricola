<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>




<div class="hero-area">
        <!-- Search Form -->
        <div class="floated">
            <div class="search-form">
          	<h2>¿Buscas maquinaria agrícola?</h2>
                <p>En nuestro portal podrás encontrar todo tipo de maquinaria agrícola.</p>
                <div class="search-form-inner">
                    <form action="anuncios.jsp" method="get">
                    	<div class="input-group input-group-lg">
      				<input type="text" class="form-control" name="f_txt" id="f_txt" placeholder="Título, Marca, Modelo...">
                        	<span class="input-group-btn">
        			<button class="btn btn-primary" type="submit">Buscar</button>
      				</span>
                        </div>
                        <span class="label label-warning pull-right"><%-- 	TODO PENDIENTE DE HACER beanBuscadorAnuncios.getNumAnucnios() --%>${countAnunciosActivos} Anuncios publicados</span>
                        <%--<span class="label label-success pull-right">10 Anuncios de venta</span>--%>
                        <a href="#" class="search-advanced-trigger">Búsqueda avanzada <i class="fa fa-arrow-down"></i></a>
                        <div class="row advanced-search-row">
                            
                                                        
                            <c:set var="anArray" value='<%=new String[] {"100", "500", "1.000", "5.000", "10.000", "20.000", "30.000", "40.000", "50.000", "60.000", "10.000", "20.000", "90.000", "100.000"} %>'/>
                            
                            <div class="col-md-3">
                                <label>Provincias</label>
                                <%-- beanBuscadorAnuncios.pintaComboBuscadorProvincias("f_idprovincia", "", "", "", filtros) --%>
                                <select name="${provincia.getNombreProvincia()} }" class="form-control selectpicker ">
                                	 <option value=""></option>
                                	 <c:forEach var="rowProv" items="${listProvincias}">                                	 	                              	 	
	                                	<option value="${rowProv.getIdProvincia()}"> ${rowProv.getNombreProvincia()}</option>
	                                	<%--  ${rowProv.getIdProvincia() eq value_selected ? 'selected': ''} --%>
                                	</c:forEach>
                                </select>
                               
                                
                            </div>
                            
                           
                            
                            <div class="col-md-3">
                                <label>Precio Mínimo</label>
                                <select name="f_precio_desde" id="f_precio_desde" class="form-control selectpicker">
                                    <option value=""></option>
                                    <c:forEach var="num" items="${anArray}">
                                    	<option value="${num.replace(".", "")}">${num}</option>
                                    </c:forEach>                                                                                                                                                
                                </select>
                            </div>  
                                
                            <div class="col-md-3">
                                <label>Precio Máximo</label>
                                <select name="f_precio_hasta" id="f_precio_hasta" class="form-control selectpicker">
                                    <option value=""></option>
                                    <c:forEach var="num" items="${anArray}">
                                    	<option value="${num.replace(".", "")}">${num}</option>
                                    </c:forEach>                                                                                                         
                                </select>
                            </div>      
                                
                            <div class="col-md-3">
                                <label>C. P. </label>
                                <input type="text" name="f_cp" id="f_cp" class="form-control  input-120" value="" />      
                            </div>    
                           
                        </div>
                    </form>
                </div>
            </div>
       	</div>
        <!-- Start Hero Slider -->
        <div class="hero-slider heroflex flexslider clearfix" data-autoplay="yes" data-pagination="no" data-arrows="yes" data-style="fade" data-speed="7000" data-pause="yes">
            <ul class="slides">
                <li class="parallax" style="background-image:url(${pageContext.servletContext.contextPath}/resources/web/images/slides/slide1.jpg);"></li>
                <li class="parallax" style="background-image:url(${pageContext.servletContext.contextPath}/resources/web/images/slides/slide2.jpg);"></li>
                <li class="parallax" style="background-image:url(${pageContext.servletContext.contextPath}/resources/web/images/slides/slide3.jpg);"></li>
                <li class="parallax" style="background-image:url(${pageContext.servletContext.contextPath}/resources/web/images/slides/slide20.jpg);"></li>
            </ul>
        </div>
        <!-- End Hero Slider -->
    </div>
        
    <!-- Start Utilities Bar -->
    <div class="utility-bar">
    	<div class="container">
        	<div class="row">
            	<div class="col-md-4 col-sm-6 col-xs-8">
                	<div class="toggle-make">
                		<a href="#"><i class="fa fa-navicon"></i></a>
                    	<span>Búsqueda por categorías</span>
                    </div>
                </div>
            	<div class="col-md-8 col-sm-6 col-xs-4">
            		
            		<!-- Start Iconos redes sociales -->
                    <ul class="utility-icons social-icons social-icons-colored">
					  	<li class="facebook"><a href="#"><i class="fa fa-facebook"></i></a></li>
					  	<li class="twitter"><a href="#"><i class="fa fa-twitter"></i></a></li>
					  	<li class="googleplus"><a href="#"><i class="fa fa-google-plus"></i></a></li>
					  	<li class="linkedin"><a href="#"><i class="fa fa-linkedin"></i></a></li>
					  	<li class="pinterest"><a href="#"><i class="fa fa-pinterest"></i></a></li>
					  	<li class="delicious"><a href="#"><i class="fa fa-delicious"></i></a></li>
					  </ul>
                    <!-- End Iconos redes sociales -->
                    
                </div>
          	</div>
      	</div>                
    	<div class="by-type-options">
    		<div class="container">
               	<div class="row">
                  	<ul class="owl-carousel carousel-alt" data-columns="6" data-autoplay="" data-pagination="no" data-arrows="yes" data-single-item="no" data-items-desktop="6" data-items-desktop-small="4" data-items-mobile="3" data-items-tablet="4">
                            <%-- TODO PENDIENTE ${beanCategorias.getHTMLListLICategoriasN1("item")} --%> PENDIENTE
                    </ul>
               	</div>
            </div>
        </div>
    </div>
   <!-- End Utilities Bar -->
   
    <!-- Start Body Content -->
  	<div class="main" role="main">
    	<div id="content" class="content full padding-b0">
            <div class="container">
            	<!-- Welcome Content and Services overview -->
            	<div class="row">
                	<div class="col-md-6">
                    	<h1 class="uppercase strong">Bienvenido al <br/>Mercadillo Verde</h1>
                        <p class="lead">
                            <span class="accent-color">Mercadillo Verde</span> es el portal líder en el mundo para <span class="accent-color">comprar y vender</span> maquinaria agrícola.
                        </p>
                    </div>
                    <div class="col-md-6">
                    	<p>
                            En Mercadillo Verde podrás buscar y publicar anuncios clasificados gratis de maquinarias y respuestos agricolas en toda España.
                        <p>Encontrarás anuncios de tractores, cosechadoras, sembradoras, remolques, aperosy todo tipo de herramientas y respuestos.</p>
                    </div>
                </div>
                <div class="spacer-75"></div>
                
                <c:if test="${not empty listLastAnuncios}">
	                <!-- Recently Listed Vehicles -->
	                <section class="listing-block recent-vehicles">
	                	<div class="listing-header">
	                    	<h3>Últimos anuncios publicados</h3>
	                    </div>
	                    <div class="listing-container">
	                        <div class="carousel-wrapper">
	                            <div class="row">
	                                <ul class="owl-carousel carousel-fw" id="vehicle-slider" data-columns="4" data-autoplay="" data-pagination="yes" data-arrows="no" data-single-item="no" data-items-desktop="4" data-items-desktop-small="3" data-items-tablet="2" data-items-mobile="1">
	                                    
	                                    <%--TODO: PENDIENTE PONER BIEN --%>
	                                    <fmt:setLocale value="es_ES"/>
										<c:forEach var="anuncioLast" items="${listLastAnuncios}">
										
											<li class="item">
		                                        <div class="vehicle-block format-standard">
		                                        	<c:if test="${not empty anuncioLast.getUrlImagen()}">
		                                            	<a href="anuncio.jsp?idanuncio=${anuncioLast.getIdAnuncio()}" class="media-box"><img src="${pageContext.servletContext.contextPath}/resources/web/${anuncioLast.getUrlImagen()}" alt=""></a>
		                                             </c:if>
		                                            <div class="vehicle-block-content">
		                                                <span class="label label-default vehicle-age">${anuncioLast.getTxtFechaPublicado()}</span>
		                                                <span class="label label-success premium-listing">${anuncioLast.getCategoria().getNombreCategoria()}</span>
		                                                <h5 class="vehicle-title"><a href="anuncio.jsp?idanuncio=${anuncioLast.getIdAnuncio()}">${anuncioLast.getTitulo()}</a></h5>
		                                                
		                                                <c:if test="${not empty anuncioLast.getTxtDescripcionDestacado()}">
		                                               	 	<span class="vehicle-meta">${anuncioLast.getTxtDescripcionDestacado()}</span>
		                                                </c:if>	
		                                                <%--<a href="results-list.html" title="View all Sedans" class="vehicle-body-type"><img src="${pageContext.servletContext.contextPath}/resources/web/images/body-types/sedan.png" width="30" alt=""></a> --%>
		                                                
		                                                <fmt:formatNumber value="${anuncioLast.getPrecio()}" type="number" var="precio" /> 
		                                                <span class="vehicle-cost">${precio} €</span>
		                                            </div>
		                                        </div>
		                                    </li>
											
											<%-- <p><fmt:formatDate pattern="dd/MM/yyyy H:m" value="${anuncioLast.getFechaPublicacion()}" /> - idAnuncio = ${anuncioLast.getIdAnuncio()} }</p> --%>
										</c:forEach>
										
	                                    
	                                   
	                                </ul>
	                            </div>
	                        </div>
	                    </div>
	                </section>
                </c:if>	
             	
           </div>
            <div class="spacer-50"></div>
            <div class="lgray-bg make-slider patrocinadores-slider">
            	<div class="container">
                    <!-- Search by make -->
                    <div class="row">
                        <div class="col-md-3 col-sm-4">
                            <h3>Patrocinadores</h3>
                            
                        </div>
                        <div class="col-md-9 col-sm-8">
                            <div class="row">
                                <ul class="owl-carousel" id="make-carousel" data-columns="5" data-autoplay="6000" data-pagination="no" data-arrows="no" data-single-item="no" data-items-desktop="5" data-items-desktop-small="4" data-items-tablet="3" data-items-mobile="3">
                                    <li class="item"> <a href="#"><img src="${pageContext.servletContext.contextPath}/resources/web/images/patrocinadores/patro_1.png" alt=""></a></li>
                                    <li class="item"> <a href="#"><img src="${pageContext.servletContext.contextPath}/resources/web/images/patrocinadores/patro_2.png" alt=""></a></li>
                                    <li class="item"> <a href="#"><img src="${pageContext.servletContext.contextPath}/resources/web/images/patrocinadores/patro_3.png" alt=""></a></li>
                                    <li class="item"> <a href="#"><img src="${pageContext.servletContext.contextPath}/resources/web/images/patrocinadores/patro_4.png" alt=""></a></li>
                                    <li class="item"> <a href="#"><img src="${pageContext.servletContext.contextPath}/resources/web/images/patrocinadores/patro_5.png" alt=""></a></li>
                                    <li class="item"> <a href="#"><img src="${pageContext.servletContext.contextPath}/resources/web/images/patrocinadores/patro_6.png" alt=""></a></li>
                                    <li class="item"> <a href="#"><img src="${pageContext.servletContext.contextPath}/resources/web/images/patrocinadores/patro_7.png" alt=""></a></li>
                                    <li class="item"> <a href="#"><img src="${pageContext.servletContext.contextPath}/resources/web/images/patrocinadores/patro_8.png" alt=""></a></li>
                                </ul>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>


