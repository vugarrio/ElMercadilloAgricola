
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
                
                <c:if test="${not empty anuncio}">   
                   <util:breadcrumb id="miga" active="${anuncio.getTitulo()}">
                   		<util:breaditem url="/" label="Home" />
                   		<util:breaditem url="/anuncios/" label="Venden" />
                   </util:breadcrumb>
                </c:if>
                   
           	</div>
               <div class="col-md-4 col-sm-6 col-xs-4">                	
                   <util:iconosRedesSociales />
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
                            		
                            		<%--Bloque estadisticas --%>
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
		                        </div><%-- <div class="col-md-4"> --%>
		                        
		                   	</div> <%-- class="row" --%>
		                   	
		                   	<div class="spacer-50"></div>
		                   	
		                   	
		                   	<div class="row">
		                    	<div class="col-md-8">
		                            <div class="tabs vehicle-details-tabs">
		                                <ul class="nav nav-tabs">
		                                    <li class="active"> <a data-toggle="tab" href="#vehicle-overview">Descripción</a></li>
		                                    
		                                </ul>
		                                <div class="tab-content">
		                                    <div id="vehicle-overview" class="tab-pane fade in active">
		                                        <p>${ anuncio.getDescripcion().replaceAll("\\n", "<br/>")  }</p>
		                                    </div>
		                                
		                                  
		                                </div>
		                    		</div>
		                    		
		                    		<div class="spacer-50"></div>
		                    		
		                    		<!-- Listado de otros productos de este usuario -->
		                            <%--<section class="listing-block recent-vehicles">
		                                <div class="listing-header">
		                                    <h3>Otros productos de <%= anuncio.getUsuarios().getNombre() %></h3>
		                                </div>
		                                <div class="listing-container">
		                                    <div class="carousel-wrapper">
		                                        <div class="row">
		                                            <ul class="owl-carousel carousel-fw" id="vehicle-slider" data-columns="3" data-autoplay="" data-pagination="yes" data-arrows="no" data-single-item="no" data-items-desktop="3" data-items-desktop-small="3" data-items-tablet="2" data-items-mobile="1">
		                                                <li class="item">
		                                                    <div class="vehicle-block format-standard">
		                                                        <a href="#" class="media-box"><img src="http://placehold.it/600x400&amp;text=IMAGE+PLACEHOLDER" alt=""></a>
		                                                        <span class="label label-default vehicle-age">2014</span>
		                                                        <span class="label label-success premium-listing">Premium Listing</span>
		                                                        <h5 class="vehicle-title"><a href="#">Mercedes-benz SL 300</a></h5>
		                                                        <span class="vehicle-meta">Mercedes, Grey color, by <abbr class="user-type" title="Listed by an individual user">Individual</abbr></span>
		                                                        <a href="#" title="View all Sedans" class="vehicle-body-type"><img src="images/body-types/sedan.png" width="30" alt=""></a>
		                                                        <span class="vehicle-cost">$48500</span>
		                                                    </div>
		                                                </li>
		                                                <li class="item">
		                                                    <div class="vehicle-block format-standard">
		                                                        <a href="#" class="media-box"><img src="http://placehold.it/600x400&amp;text=IMAGE+PLACEHOLDER" alt=""></a>
		                                                        <span class="label label-primary vehicle-age">Brand New</span>
		                                                        <h5 class="vehicle-title"><a href="#">Nissan Terrano first hand</a></h5>
		                                                        <span class="vehicle-meta">Nissan, Brown beige, by <abbr class="user-type" title="Listed by an dealer">Dealer</abbr></span>
		                                                        <a href="#" title="View all SUVs" class="vehicle-body-type"><img src="images/body-types/suv.png" width="30" alt=""></a>
		                                                        <span class="vehicle-cost">$28000</span>
		                                                    </div>
		                                                </li>
		                                                <li class="item">
		                                                    <div class="vehicle-block format-standard">
		                                                        <a href="#" class="media-box"><img src="http://placehold.it/600x400&amp;text=IMAGE+PLACEHOLDER" alt=""></a>
		                                                        <span class="label label-default vehicle-age">2013</span>
		                                                        <h5 class="vehicle-title"><a href="#">Mercedes Benz E Class</a></h5>
		                                                        <span class="vehicle-meta">Mercedes, Silver Blue, by <abbr class="user-type" title="Listed by an individual">Individual</abbr></span>
		                                                        <a href="#" title="View all convertibles" class="vehicle-body-type"><img src="images/body-types/convertible.png" width="30" alt=""></a>
		                                                        <span class="vehicle-cost">$76000</span>
		                                                    </div>
		                                                </li>
		                                                <li class="item">
		                                                    <div class="vehicle-block format-standard">
		                                                        <a href="#" class="media-box"><img src="http://placehold.it/600x400&amp;text=IMAGE+PLACEHOLDER" alt=""></a>
		                                                        <span class="label label-default vehicle-age">2014</span>
		                                                        <h5 class="vehicle-title"><a href="#">Newly launched Nissan Sunny</a></h5>
		                                                        <span class="vehicle-meta">Nissan, Brown beige, by <abbr class="user-type" title="Listed by Autostars">Autostars</abbr></span>
		                                                        <a href="#" title="View all coupes" class="vehicle-body-type"><img src="images/body-types/coupe.png" width="30" alt=""></a>
		                                                        <span class="vehicle-cost">$31999</span>
		                                                    </div>
		                                                </li>
		                                                <li class="item">
		                                                    <div class="vehicle-block format-standard">
		                                                        <a href="#" class="media-box"><img src="http://placehold.it/600x400&amp;text=IMAGE+PLACEHOLDER" alt=""></a>
		                                                        <span class="label label-default vehicle-age">2014</span>
		                                                        <span class="label label-success premium-listing">Premium Listing</span>
		                                                        <h5 class="vehicle-title"><a href="#">Mercedes-benz SL 300</a></h5>
		                                                        <span class="vehicle-meta">Mercedes, Grey color, by <abbr class="user-type" title="Listed by an individual user">Individual</abbr></span>
		                                                        <a href="#" title="View all Sedans" class="vehicle-body-type"><img src="images/body-types/sedan.png" width="30" alt=""></a>
		                                                        <span class="vehicle-cost">$48500</span>
		                                                    </div>
		                                                </li>
		                                                <li class="item">
		                                                    <div class="vehicle-block format-standard">
		                                                        <a href="#" class="media-box"><img src="http://placehold.it/600x400&amp;text=IMAGE+PLACEHOLDER" alt=""></a>
		                                                        <span class="label label-primary vehicle-age">Brand New</span>
		                                                        <h5 class="vehicle-title"><a href="#">Nissan Terrano first hand</a></h5>
		                                                        <span class="vehicle-meta">Nissan, Brown beige, by <abbr class="user-type" title="Listed by an dealer">Dealer</abbr></span>
		                                                        <a href="#" title="View all SUVs" class="vehicle-body-type"><img src="images/body-types/suv.png" width="30" alt=""></a>
		                                                        <span class="vehicle-cost">$28000</span>
		                                                    </div>
		                                                </li>
		                                                <li class="item">
		                                                    <div class="vehicle-block format-standard">
		                                                        <a href="#" class="media-box"><img src="http://placehold.it/600x400&amp;text=IMAGE+PLACEHOLDER" alt=""></a>
		                                                        <span class="label label-default vehicle-age">2013</span>
		                                                        <h5 class="vehicle-title"><a href="#">Mercedes Benz E Class</a></h5>
		                                                        <span class="vehicle-meta">Mercedes, Silver Blue, by <abbr class="user-type" title="Listed by an individual">Individual</abbr></span>
		                                                        <a href="#" title="View all convertibles" class="vehicle-body-type"><img src="images/body-types/convertible.png" width="30" alt=""></a>
		                                                        <span class="vehicle-cost">$76000</span>
		                                                    </div>
		                                                </li>
		                                                <li class="item">
		                                                    <div class="vehicle-block format-standard">
		                                                        <a href="#" class="media-box"><img src="http://placehold.it/600x400&amp;text=IMAGE+PLACEHOLDER" alt=""></a>
		                                                        <span class="label label-default vehicle-age">2014</span>
		                                                        <h5 class="vehicle-title"><a href="#">Newly launched Nissan Sunny</a></h5>
		                                                        <span class="vehicle-meta">Nissan, Brown beige, by <abbr class="user-type" title="Listed by Autostars">Autostars</abbr></span>
		                                                        <a href="#" title="View all coupes" class="vehicle-body-type"><img src="images/body-types/coupe.png" width="30" alt=""></a>
		                                                        <span class="vehicle-cost">$31999</span>
		                                                    </div>
		                                                </li>
		                                            </ul>
		                                        </div>
		                                    </div>
		                                </div>
		                            </section>--%>
		                    	</div><%-- <div class="col-md-8"> --%>
		                    	
		                    	
		                    	 <!-- Anuncio Details Sidebar -->
                        		<div class="col-md-4 vehicle-details-sidebar sidebar">
		                    		<!-- Anuncio Enquiry -->
		                            <div class="sidebar-widget widget contactar-widget">
		                              	<h4 class="widgettitle">Contacta ahora</h4>
		                                <div class="loan-contactar form-validate-vu">
		                                    <form name="formContactar" id="formContactar" action="anuncio_controller.jsp">
		                                        <input type="hidden" name="id_anuncio" value="${ anuncio.getIdAnuncio() }" />
		                                        <input type="hidden" name="accion"value="nuevo_anuncio" />
		                                        <div class="form-group">
		                                            <input type="text" name="nombre" placeholder="Tu nombre *" class="form-control  validate[required]" data-etiqueta="Tu nombre" />                                              
		                                        </div>    
		                                        <div class="form-group">
		                                            <input type="text" name="email" placeholder="Tu e-mail *" class="form-control validate[funcCall[checkEmailValido]]" data-etiqueta="Tu e-mail" />
		                                        </div>    
		                                        <div class="form-group">    
		                                            <div class="row">
		                                                <div class="col-md-7"><input type="text" name="telefono" placeholder="Tu teléfono" class="form-control" ></div>
		                                                <div class="col-md-5"><input type="text" name="cp" placeholder="C.P." class="form-control" ></div>
		                                            </div>
		                                        </div>    
		                                        <div class="form-group">    
		                                            <textarea name="mensaje" class="form-control  validate[required]" placeholder="Estoy interesado en este anuncio..." data-etiqueta="Mensaje"></textarea>
		                                        </div>    
		                                        
		                                        <label class="checkbox-inline">
		                                            <input type="checkbox" id="inlineCheckbox1" name="acepto_politica" value="1" class="validate[funcCall[checkAceptaPoliticaProteccion]]" required /> Acepto <a href="#" >la política de privacidad</a> y <a href="#">condiciones de uso</a>.
		                                        </label>
		                                       
		                                        <input type="submit" data-loading-text="Enviando..." class="btn btn-primary enviar-formulario-btn" value="Contactar">
		                                        
		                                        
		                                    </form>
		                                        
		                                    <div class="clearfix"></div>
		                                    <div id="message"></div>    
		                                </div>
		                                
		                                <c:if test="${not empty anuncio.getTelefono()}">
		                                	<div class="vehicle-enquiry-foot">                                    
			                                    <span class="vehicle-enquiry-foot-ico"><i class="fa fa-phone"></i></span>
			                                    <strong>${ anuncio.getTelefono() }</strong>${ anuncio.getUsuarios().getNombre() }
			                                </div>
		                                </c:if>
		                                
		                            </div>
		                    	</div><%-- <div class="col-md-4 vehicle-details-sidebar sidebar"> --%>		                    	
		                    	
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
    
    
    
    
    
    <!-- BOOK TEST DRIVE POPUP -->
	<div class="modal fade" id="testdriveModal" tabindex="-1" role="dialog" aria-hidden="true">
	    <div class="modal-dialog">
	        <div class="modal-content">
	            <div class="modal-header">
	                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
	                <h4>Book a test drive</h4>
	            </div>
	            <div class="modal-body">
	            	<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nulla convallis egestas rhoncus. Donec facilisis fermentum sem, ac viverra ante luctus vel. Donec vel mauris quam.</p>
	                <form>
	                    <div class="input-group">
	                        <span class="input-group-addon"><i class="fa fa-user"></i></span>
	                        <input type="text" class="form-control" placeholder="Full Name">
	                    </div>
	                    <div class="row">
	                    	<div class="col-md-6">
	                            <div class="input-group">
	                                <span class="input-group-addon"><i class="fa fa-envelope"></i></span>
	                                <input type="email" class="form-control" placeholder="Email">
	                            </div>
	                      	</div>
	                    	<div class="col-md-6">
	                            <div class="input-group">
	                                <span class="input-group-addon"><i class="fa fa-phone"></i></span>
	                                <input type="text" class="form-control" placeholder="Phone">
	                            </div>
	                      	</div>
	                   	</div>
	                    <div class="row">
	                    	<div class="col-md-6">
	                            <div class="input-group">
	                                <span class="input-group-addon"><i class="fa fa-calendar"></i></span>
	                                <input type="text" id="datepicker" class="form-control" placeholder="Preferred Date">
	                            </div>
	                      	</div>
	                    	<div class="col-md-6">
	                            <div class="input-group input-append bootstrap-timepicker">
	                                <span class="input-group-addon add-on"><i class="fa fa-clock-o"></i></span>
	                                <input type="text" id="timepicker" class="form-control" placeholder="Preferred time">
	                            </div>
	                      	</div>
	                   	</div>
	             		<input type="submit" class="btn btn-primary pull-right" value="Schedule Now">
	                    <label class="btn-block">Preferred Contact</label>
	                    <label class="checkbox-inline"><input type="checkbox"> Email</label>
	                    <label class="checkbox-inline"><input type="checkbox"> Phone</label>
	                </form>
	           	</div>
	        </div>
	    </div>
	</div>
	<!-- MAKE AN OFFER POPUP -->
	<div class="modal fade" id="offerModal" tabindex="-1" role="dialog" aria-hidden="true">
	    <div class="modal-dialog">
	        <div class="modal-content">
	            <div class="modal-header">
	                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
	                <h4>Make an offer</h4>
	            </div>
	            <div class="modal-body">
	            	<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nulla convallis egestas rhoncus. Donec facilisis fermentum sem, ac viverra ante luctus vel. Donec vel mauris quam.</p>
	                <form>
	                    <div class="input-group">
	                        <span class="input-group-addon"><i class="fa fa-user"></i></span>
	                        <input type="text" class="form-control" placeholder="Full Name">
	                    </div>
	                    <div class="row">
	                    	<div class="col-md-6">
	                            <div class="input-group">
	                                <span class="input-group-addon"><i class="fa fa-envelope"></i></span>
	                                <input type="email" class="form-control" placeholder="Email">
	                            </div>
	                      	</div>
	                    	<div class="col-md-6">
	                            <div class="input-group">
	                                <span class="input-group-addon"><i class="fa fa-phone"></i></span>
	                                <input type="text" class="form-control" placeholder="Phone">
	                            </div>
	                      	</div>
	                   	</div>
	                    <div class="row">
	                    	<div class="col-md-6">
	                            <div class="input-group">
	                                <span class="input-group-addon"><i class="fa fa-dollar"></i></span>
	                                <input type="text" class="form-control" placeholder="Offered Price">
	                            </div>
	                      	</div>
	                    	<div class="col-md-6">
	                            <div class="input-group">
	                                <span class="input-group-addon"><i class="fa fa-credit-card"></i></span>
	                                <select type="text" class="form-control selectpicker">
	                                	<option selected>Financing required?</option>
	                                	<option>Yes</option>
	                                	<option>No</option>
	                                </select>
	                            </div>
	                      	</div>
	                   	</div>
	                    <textarea class="form-control" placeholder="Additional comments"></textarea>
	             		<input type="submit" class="btn btn-primary pull-right" value="Submit">
	                    <div class="clearfix"></div>
	                </form>
	           	</div>
	        </div>
	    </div>
	</div>
	<!-- SEND TO A FRIEND POPUP -->
	<div class="modal fade" id="sendModal" tabindex="-1" role="dialog" aria-hidden="true">
	    <div class="modal-dialog">
	        <div class="modal-content">
	            <div class="modal-header">
	                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
	                <h4>Enviar a un amigo</h4>
	            </div>
	            <div class="modal-body">
	                <form>
	                    <div class="input-group">
	                        <span class="input-group-addon"><i class="fa fa-user"></i></span>
	                        <input type="text" class="form-control" placeholder="Tu nombre">
	                    </div>
	                    <div class="row">
	                    	<div class="col-md-6">
	                            <div class="input-group">
	                                <span class="input-group-addon"><i class="fa fa-envelope"></i></span>
	                                <input type="email" class="form-control" placeholder="Tu E-mail">
	                            </div>
	                      	</div>
	                    	<div class="col-md-6">
	                            <div class="input-group">
	                                <span class="input-group-addon"><i class="fa fa-envelope"></i></span>
	                                <input type="email" class="form-control" placeholder="El E-mail del amigo">
	                            </div>
	                      	</div>
	                   	</div>
	                    <textarea class="form-control" placeholder="Mensaje"></textarea>
	             		<input type="submit" class="btn btn-primary pull-right" value="Enviar">
	                    <div class="clearfix"></div>
	                </form>
	           	</div>
	        </div>
	    </div>
	</div>
	    
	    
	
