<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="tilesx" uri="http://tiles.apache.org/tags-tiles-extras" %>
<%@ taglib prefix="util" tagdir="/WEB-INF/tags/util" %>



<!-- Start Page header -->
   <div class="page-header parallax" style="background-image:url(${pageContext.servletContext.contextPath}/resources/web/images/slides/hay-bales_1200_300.png);">
   	<div class="container">
       	<h1 class="page-title">Listado de Anuncios</h1>
      	</div>
   </div>
   
   <!-- Utiity Bar -->
   <div class="utility-bar">
   	<div class="container">
       	<div class="row">
           	<div class="col-md-8 col-sm-6 col-xs-8">
                   <%-- beanBuscadorAnuncios.getHTMLMigaPan(filtros) --%>
                   
                   <util:breadcrumb id="miga" active="Venden">
                   		<util:breaditem url="/" label="Home" />
                   </util:breadcrumb>               
                
           	</div>
               <div class="col-md-4 col-sm-6 col-xs-4">
               		<util:iconosRedesSociales />
               </div>
           </div>
     	</div>
   </div>
   
   
    <!-- Actions bar -->
    <div class="actions-bar tsticky">
     	<div class="container">
        	<div class="row">
            	<div class="col-md-2 col-sm-2 search-actions">
                    <ul class="utility-icons tools-bar">
                        <li><a href="#"><i class="fa fa-star-o"></i></a>
                        	<div class="tool-box">
                            	<div class="tool-box-head">
                            		<%--<a href="user-dashboard-saved-cars.html" class="basic-link pull-right">View all</a>--%>
                            		<h5>Favoritos guardados</h5>
                                </div>
                                <div class="tool-box-in">
                                	<ul class="listing tool-car-listing">
                                    	<li>
                                        	<div class="checkb"><input type="checkbox"></div>
                                            <div class="imageb"><a href="vehicle-details.html"><img src="http://placehold.it/600x400&amp;text=IMAGE+PLACEHOLDER" alt=""></a></div>
                                            <div class="textb">
                                            	<a href="javascript:alert('Pendiente')">6320 DE 110 CV</a>
                                                <span class="price">25.000 €</span>
                                           	</div>
                                            <div class="delete"><a href="javascript:alert('Pendiente')"><i class="icon-delete"></i></a></div>
                                        </li>
                                    	
                                    </ul>
                                </div>
                                <div class="tool-box-foot">
                                	<%--<a href="#" class="btn btn-xs btn-primary pull-right">Join</a>
                                	<a href="#" class="pull-right tool-signin" data-toggle="modal" data-target="#loginModal">Iniciar sesión</a>--%>
                                	<a href="javascript:alert('Pendiente')" class="btn btn-xs btn-info">Ver todos</a>
                                </div>
                            </div>
                        </li>
                    </ul>
                </div>
                <div class="col-md-10 col-sm-10">
                    <div class="btn-group pull-right results-sorter">
                        <button id="dLabel987" type="button" class="btn btn-default listing-sort-btn">
                            
                            <c:set var="txt_ordenacion" value=""/>
                            <c:choose>
                           	   <c:when test="${anuncioSearchForm.getListadoOrdenarPor() == 'a.fechaPublicacion desc'}">
							   		<c:set var="txt_ordenacion">
	                            		<i class="fa fa-long-arrow-down"></i> Fecha
	                            	</c:set>
							   </c:when> 
							   <c:when test="${anuncioSearchForm.getListadoOrdenarPor() == 'a.precio desc'}">
							   		<c:set var="txt_ordenacion" scope="page">
	                            		<i class="fa fa-long-arrow-down"></i> Precio
	                            	</c:set>
							   </c:when> 
							   <c:when test="${anuncioSearchForm.getListadoOrdenarPor() == 'a.precio asc'}">
							   		<c:set var="txt_ordenacion" scope="page">
	                            		<i class="fa fa-long-arrow-up"></i> Precio
	                            	</c:set>
							   </c:when>
							   <c:otherwise>
							   		<c:set var="txt_ordenacion" value="Ordenar"/>
							   </c:otherwise>
							</c:choose>
                            <c:out value="${txt_ordenacion}" escapeXml="false"/>
                            
                            
                        </button>
                        <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown" aria-expanded="false">
                          <span class="caret"></span>
                          <span class="sr-only">Mostrar opciones</span>
                        </button>
                        <ul class="dropdown-menu" role="menu" aria-labelledby="dLabel987">
                            <li><a title="Por Fecha, de mayor a menor" class="result-list-opcion-ordenacion" campo="a.fechaPublicacion desc" href="#"><i class="fa fa-long-arrow-down"></i> Fecha</a></li>
                            <li><a title="Por precio, de mayor a menor" class="result-list-opcion-ordenacion" campo="a.precio desc" href="#" ><i class="fa fa-long-arrow-down"></i> Precio </a></li>
                            <li><a title="Por precio, de menor a mayor" class="result-list-opcion-ordenacion" campo="a.precio asc" href="#"><i class="fa fa-long-arrow-up"></i> Precio </a></li>                          	
                        </ul>
                  	</div>
                    
                    <div class="toggle-view view-count-choice pull-right">
                        <label>Mostrar</label>
                        <div class="btn-group">
                            <a href="#" class="btn btn-default result-list-num-registros ${anuncioSearchForm.getListadoSize() == 1 ? 'active' : ''}">1</a>
                            <a href="#" class="btn btn-default result-list-num-registros ${anuncioSearchForm.getListadoSize() == 2 ? 'active' : ''}">2</a>
                            <a href="#" class="btn btn-default result-list-num-registros ${anuncioSearchForm.getListadoSize() == 5 ? 'active' : ''}">5</a>
                        </div>
                    </div>
                    
                    <div class="toggle-view view-format-choice pull-right">
                        <label>Vista</label>
                        <div class="btn-group">
                        
                        	<c:set var="language" value="${not empty param.language ? param.language : not empty language ? language : pageContext.request.locale}" scope="session" />
                        
                            <a title="Listado" href="#" class="btn btn-default ${anuncioSearchForm.getListadoVista() == 'results-list-view' ? 'active' : ''}" id="results-list-view"><i class="fa fa-th-list"></i></a>
                            <a title="Cajas" href="#" class="btn btn-default ${anuncioSearchForm.getListadoVista() == 'results-grid-view' ? 'active' : ''}" id="results-grid-view"><i class="fa fa-th"></i></a>
                        </div>
                    </div>
                    <!-- Small Screens Filters Toggle Button -->
                    <button class="btn btn-default visible-xs" id="Show-Filters">Mostrar filtros</button> 
                </div>
            </div>
      	</div>
    </div>
    
    
    <!-- Start Content -->
  	<div class="main" role="main">
    	<div id="content" class="content full">
        	<div class="container">
            	<div class="row">
            		
            		<%--TODO: pendiente de validar --%>
            		<c:if test="${not empty errorMessage}">
						<div class="alert alert-error">${errorMessage}</div>
					</c:if>
                    
                    <form:form action="${pageContext.request.contextPath}/anuncios"
							   method="get" modelAttribute="anuncioSearchForm"
							   name="formBuscarAnuncios" id="formBuscarAnuncios" >
						
						<%-- Info para el objeto AnuncioSearchForm --%>
						<input name="filtroIdCategoria" type="text" value="${param.filtroIdCategoria}"/>
                        <input name="filtroIdProvincia" type="text" value="${param.filtroIdProvincia}"/>
                        <input name="filtroTxt" type="text" value="${param.filtroTxt}"/>
                        <input name="filtroCP" type="text" value="${param.filtroCP}"/>
                        <input name="filtroPrecioDesde" type="text" value="${param.filtroPrecioDesde}"/>
                        <input name="filtroPrecioHasta" type="text" value="${param.filtroPrecioHasta}"/>
                        
                        <input name="listadoVista" type="text" value="${anuncioSearchForm.getListadoVista()}"/><%-- results-list-view | results-grid-view --%>
                        <input name="listadoOrdenarPor" type="text" value="${anuncioSearchForm.getListadoOrdenarPor()}"/>
                        <input name="listadoSize" type="text" value="${anuncioSearchForm.getListadoSize()}"/>
                        
                        
                        <%-- Info para el objeto Pageable --%>                                                
                        <input name="page.page" type="text" value="${page.number + 1}"/>
                        <input name="page.size" type="text" value="${anuncioSearchForm.getListadoSize()}"/>
						
					</form:form>
					
                    
                    <!-- Start Search Filters -->
                    <div class="col-md-3 search-filters" id="Search-Filters">
                    	<div class="tbsticky filters-sidebar">
                            <h3>Busqueda avanzada</h3>
                            <div class="accordion" id="toggleArea">
                                
                               
                                
                                <!-- Filter by Texto -->
                                <div class="accordion-group panel">
                                    <div class="accordion-heading togglize active"> <a class="accordion-toggle active" data-toggle="collapse" data-parent="#" href="#collapseTexto">Estoy buscando<i class="fa fa-angle-down"></i> </a> </div>
                                    <div id="collapseTexto" class="accordion-body collapse in" aria-expanded="true">
                                        <div class="accordion-inner">
                                            <div class="form-inline">
  												<div class="form-group form-group-sm">
                                                    <input type="text" name="filtroTxt" id="filtroTxt" class="form-control input-120 " value="${param.filtroTxt}"  placeholder="Título, Marca, Modelo..." />                                                    
                                                </div>      
                                                <button type="button" class="btn btn-default btn-sm pull-right" onclick="filtro_buscador('filtroTxt')">Filtar</button>
                                                    
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                
                                 
                                
                                <!-- Filter by Categoria nivel 2 -->
                                <div class="accordion-group panel">
                                    <div class="accordion-heading togglize active"> <a class="accordion-toggle active" data-toggle="collapse" data-parent="#" href="#collapseCatN1">Categorias<i class="fa fa-angle-down"></i> </a> </div>
                                    <div id="collapseCatN1" class="accordion-body collapse in" aria-expanded="true">
                                        <div class="accordion-inner">
                                        
                                        
                                          <c:if test="${not empty filtroCategoria}">
								                <ol class="breadcrumb menu-group-categoria">
								                
								                <li><a href="${pageContext.servletContext.contextPath}/anuncios" class="filtro_buscador_link" filtro_nombre="filtroIdCategoria" filtro_valor="">Ver todas</a></li>
								                
								                 <c:choose>
								                	<c:when test="${filtroCategoria.getNivel() == 2  }">
								                		<li><a href="${pageContext.servletContext.contextPath}/anuncios?filtroIdCategoria=${filtroCategoria.getCategoria().getIdCategoria()}"  class="filtro_buscador_link" filtro_nombre="filtroIdCategoria" filtro_valor="${filtroCategoria.getCategoria().getIdCategoria()}" >${filtroCategoria.getCategoria().getNombreCategoria()}</a></li>
								                	</c:when>
													<c:otherwise>
													       <li><a href="${pageContext.servletContext.contextPath}/anuncios?filtroIdCategoria=${filtroCategoria.getIdCategoria()}" class="filtro_buscador_link" filtro_nombre="filtroIdCategoria" filtro_valor="${filtroCategoria.getIdCategoria()}">${filtroCategoria.getNombreCategoria()}</a></li>
													</c:otherwise>
												</c:choose>
										  </c:if> 
                                           
                                           <c:choose>
                                           		<c:when test="${not empty filtrosListCategoriaAnuncios }">
											  		 <ul class="filter-options-list list-group">
											  		 	<c:forEach var="row" items="${filtrosListCategoriaAnuncios}">
											  		 		<li class="list-group-item">
											  		 			<span class="badge">${row.getCountAnuncios()}</span>
											  		 			<a href="${pageContext.servletContext.contextPath}/anuncios?filtroIdCategoria=${row.getIdCategoria()}" class="filtro_buscador_link" filtro_nombre="filtroIdCategoria" filtro_valor="${row.getIdCategoria()}">${row.getNombreCategoria()}</a>
											  		 		</li>
											  		 	</c:forEach>
											  		 </ul>
											  	</c:when>
												<c:otherwise>
												       <span  class="filter-options-list-sin-resultado">Sin categorias</span>
												</c:otherwise>
											</c:choose>
                                           
                                        </div>
                                    </div>
                                </div>
                                
                                
                                
                               
                                
                                <!-- Filter by Provincias -->
                                <div class="accordion-group panel">
                                    <div class="accordion-heading togglize active"> <a class="accordion-toggle active" data-toggle="collapse" data-parent="#" href="#collapseProv">Provincias<i class="fa fa-angle-down"></i> </a> </div>
                                    <div id="collapseProv" class="accordion-body collapse in" aria-expanded="true">
                                        <div class="accordion-inner">
                                            
                                            
                                            <c:if test="${not empty filtroProvincia}">
								               	<ol class="breadcrumb menu-group-categoria">									                
								                	<li><a href="${pageContext.servletContext.contextPath}/anuncios" class="filtro_buscador_link" filtro_nombre="filtroIdProvincia" filtro_valor="">Ver todas</a></li>									                
								                </ol>
									        </c:if>  
                                            
                                            <c:choose>
										   		<c:when test="${not empty filtrosListProvinciaAnuncios }">
											  		 <ul class="filter-options-list list-group">
											  		 	<c:forEach var="row" items="${filtrosListProvinciaAnuncios}">
											  		 		<li class="list-group-item">
											  		 			<span class="badge">${row.getCountProvincias()}</span>
											  		 			<a href="${pageContext.servletContext.contextPath}/anuncios?filtroIdProvincia=${row.getIdProvincia()}" class="filtro_buscador_link" filtro_nombre="filtroIdProvincia" filtro_valor="${row.getIdProvincia()}">${row.getNombreProvincia()}</a>
											  		 		</li>
											  		 	</c:forEach>
											  		 </ul>
											  	</c:when>
												<c:otherwise>
												       <span  class="filter-options-list-sin-resultado">Sin provincias</span>
												</c:otherwise>
											</c:choose>
                                            
                                        </div>
                                    </div>
                                </div>
                                
                                
                                
                                
                                <div class="accordion-group panel">
                                    <div class="accordion-heading togglize <c:if test="${not empty param.filtroCP}"> active</c:if>"> <a class="accordion-toggle <c:if test="${not empty param.filtroCP}"> active</c:if>" data-toggle="collapse" data-parent="#" href="#collapseCP">Código Postal<i class="fa fa-angle-down"></i> </a> </div>
                                    <div id="collapseCP" class="accordion-body collapse <c:if test="${not empty param.filtroCP}"> in</c:if>" <c:if test="${not empty param.filtroCP}"> aria-expanded="true"</c:if>>
                                        <div class="accordion-inner">
                                            <div class="form-inline">
  						<div class="form-group form-group-sm">
                                                    <input type="text" name="filtroCP" id="filtroCP" class="form-control  input-120" value="${param.filtroCP}"  placeholder="C.P" />                                                    
                                                </div>
                                                
                                                <button type="button" class="btn btn-default btn-sm pull-right" onclick="filtro_buscador('filtroCP')">Filtar</button>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                
                              
                               
                                   
                              
                               
                                <!-- Filter by Precio -->
                                <div class="accordion-group">
                                    <div class="accordion-heading togglize <c:if test="${not empty param.filtroPrecioDesde or not empty param.filtroPrecioHasta}"> active</c:if>"> <a class="accordion-toggle <c:if test="${not empty param.filtroPrecioDesde or not empty param.filtroPrecioHasta}"> active</c:if>" data-toggle="collapse" data-parent="#" href="#collapseEight">Precio<i class="fa fa-angle-down"></i> </a> </div>
                                    <div id="collapseEight" class="accordion-body collapse <c:if test="${not empty param.filtroPrecioDesde or not empty param.filtroPrecioHasta}"> in</c:if>" <c:if test="${not empty param.filtroPrecioDesde or not empty param.filtroPrecioHasta}"> aria-expanded="true"</c:if>>
                                      <div class="accordion-inner">
                                            <div class="form-inline">
                                                <%-- 
                                                    String[] anArray = {"100", "500", "1.000", "5.000", "10.000", "20.000", "30.000", "40.000", "50.000", "60.000", "10.000", "20.000", "90.000", "100.000"};
                                                --%>
  						<div class="form-group doble">
                                                    <label>Precio Mínimo</label>
                                                    <%--<select name="filtroPrecioDesde" id="filtroPrecioDesde" class="form-control selectpicker">
                                                        <option value="" <%if (filtro_precio_desde.trim().equals("")) { %> selected<% } %>></option>
                                                        
                                                            for (String num: anArray) {
                                                        <option value="<%= num.replace(".", "") %>" <%if (filtro_precio_desde.equals(num.replace(".", ""))) { %> selected<% } %>><%= num %> €</option><%
                                                            }
                                                                                                                                                             
                                                    </select>--%>  
                                                    
                                                    <input type="text" name="filtroPrecioDesde" id="filtroPrecioDesde" class="form-control  input-100" value="${param.filtroPrecioDesde}"  placeholder="" />
                                                    
                                                </div>
                                                <div class="form-group last-child doble">
                                                    <label>Precio Máximo</label>
                                                    <%--<select name="filtroPrecioHasta" id="filtroPrecioHasta" class="form-control selectpicker">
                                                        <option value="" <%if (filtro_precio_hasta.trim().equals("")) { %> selected<% } %>></option>
                                                        <%
                                                            for (String num: anArray) {
                                                        %><option value="<%= num.replace(".", "") %>" <%if (filtro_precio_hasta.equals(num.replace(".", ""))) { %> selected<% } %>><%= num %> €</option><%
                                                            }
                                                        %>                                                    
                                                    </select> --%>  
                                                    
                                                    <input type="text" name="filtroPrecioHasta" id="filtroPrecioHasta" class="form-control  input-100" value="${param.filtroPrecioHasta}"  placeholder="" />
                                                    
                                                </div>
                                                <button type="button" class="btn btn-default btn-sm pull-right" onclick="filtro_buscador('filtroPrecio')">Filtrar</button>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                
                                
                                
                            </div>
                            <!-- End Toggle -->
                            <a href="#" id="btn-filters-reset" class="btn-default btn-sm btn"><i class="fa fa-refresh"></i> Limpiar Búsqueda</a>
                           
                        </div>
                    </div>
					<!-- End Search Filters -->
                    
                    <!-- Listing Results -->
                    <div class="col-md-9 results-container">
                        <div class="results-container-in">
                        	<div class="waiting" style="display:none;">
                            	<div class="spinner">
                                  	<div class="rect1"></div>
                                  	<div class="rect2"></div>
                                  	<div class="rect3"></div>
                                  	<div class="rect4"></div>
                                  	<div class="rect5"></div>
                                </div>
                            </div>
                            
                            <%
                               // String[] resultados = beanBuscadorAnuncios.getHTMLResultadoBuscadorAnuncios(filtros);
                            %>
                            
                            <div id="results-holder" class="${anuncioSearchForm.getListadoVista()}">
                                
                                <%--Buscando con: <%= filtros.toString()  %> <br/><br/>--%>
								
								<c:choose>
									<%-- if --%>
									<c:when test="${not empty page.content && page.content.size() > 0}">
									    
									    <c:forEach var="anuncioDTO" items="${page.content}">
										    
										    <!-- Result Item --> 
						                    <div class="result-item format-standard"> 
						                    	
					                            <div class="result-item-image">
					                            	<c:choose>
						                            	<c:when test="${not empty anuncioDTO.getUrlImagen()}">
						                            		<a href="${pageContext.servletContext.contextPath}/anuncio/${anuncioDTO.getIdAnuncio()}" class="media-box"><img src="${pageContext.servletContext.contextPath}/resources/web/${anuncioDTO.getUrlImagen()}" alt=""></a>
						                            	</c:when>
						                            	<c:otherwise>
						                            		 <a href="${pageContext.servletContext.contextPath}/anuncio/${anuncioDTO.getIdAnuncio()}" class="media-box"><img src="${pageContext.servletContext.contextPath}/resources/web/images/listado_sin_imagen_600x40.png" alt=""></a>
						                            	</c:otherwise>
						                            </c:choose>
						                            
						                            <c:if test="${not empty anuncioDTO.getTxtFechaPublicado()}">
						                            	<span class="label label-default vehicle-age">${anuncioDTO.getTxtFechaPublicado()}</span> 
						                            </c:if>
						                            
													<div class="result-item-view-buttons">
									                	<a href="javascript:alert('pendiente');"><i class="fa fa-star-o"></i> Guardar</a>
									                	<a href="anuncio/${anuncioDTO.getIdAnuncio()}"><i class="fa fa-plus"></i> Ver detalle</a>
									                </div>
					                            </div>
					                            
					                            <div class="result-item-in">
						                           
						                           <h4 class="result-item-title"><a href="${pageContext.servletContext.contextPath}/anuncio/${anuncioDTO.getIdAnuncio()}">${anuncioDTO.getTitulo()}</a></h4>
			                                       
			                                       <div class="result-item-cont">
			                                       	   <div class="result-item-block col1"> 
										               		<p>${anuncioDTO.getDescripcionCorta()}</p>
										               </div>
			                                       	   <div class="result-item-block col2">
			                                       	   		<div class="result-item-categoria">
								 								<span class="label label-primary">${anuncioDTO.getCategoria().getNombreCategoria()}</span>
								 								<!--<span class=\"label label-success \">Tractor agricola</span>--> 
									  						 </div>
								 							 <div class="result-item-pricing">
								 							 	<fmt:formatNumber value="${anuncioDTO.getPrecio()}" type="number" var="precio" /> 
								 								<div class="price">${precio} €</div>
								 							 </div>
								 							 <div class="result-item-action-buttons">
								 								 <a href="javascript:alert('Pendiente')" class="btn btn-default btn-sm" title="Guardar a favoritos"><i class="fa fa-star-o"></i> Guardar</a>
																 <a href="${pageContext.servletContext.contextPath}/anuncio/${anuncioDTO.getIdAnuncio()}" class="btn btn-default btn-sm" title="Pedir más información">+ Info</a><br>
								 							 </div>
								 							 <div class="result-item-provincia">
								 								 <span class="label label-success">${anuncioDTO.getProvincia().getNombreProvincia()}</span>
								 							 </div>   
			                                       	   </div> 
			                                       	   
			                                      </div><%-- <div class="result-item-cont"> --%>   	  			                                       	   
			                                       	   
		                                       	   <c:if test="${ (not empty anuncioDTO.marca)	|| (not empty anuncioDTO.modelo )	}">
		                                       	   				<div class="result-item-features">
		                                       	   					<ul class="inline">
		                                       	   						<c:if test="${not empty anuncioDTO.getMarca() }">
				                                       	   				 	 <li>${anuncioDTO.getMarca()}</li>
				                                       	   				</c:if>
				                                       	   				<c:if test="${not empty anuncioDTO.getModelo() }">
				                                       	   				 	 <li>${anuncioDTO.getModelo()}</li>
				                                       	   				</c:if>
		                                       	   					</ul>
		                                       	   				</div>
		                                       	   
		                                       	   </c:if>			                                       	   	
			                                        
					                            </div><%--  <div class="result-item-in">  --%> 					                            
						                    </div><%-- <div class="result-item format-standard"> --%>
						                    
									    </c:forEach>
									    
									</c:when>
									<%-- else --%>
									<c:otherwise>
									   	<!-- Result Item -->
						                <div class="result-item format-standard">
						                	<div class="sin-resultados"> No se han encotrado anuncios con los filtros seleccionados.</div>
						                </div> 
									</c:otherwise>
								</c:choose>
								
							
                               
                            </div>
                           
						      
                            <util:pagination page="${page}" query="" />
                            
                        </div>
                        
                    </div>
               	</div>
            </div>
        </div>
   	</div>
    <!-- End Content -->
    