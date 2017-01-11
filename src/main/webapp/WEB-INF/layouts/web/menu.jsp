<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>


   <div class="navbar">
            <div class="container sp-cont">
                <div class="search-function">
                    <%-- Buscador<a href="#" class="search-trigger"><i class="fa fa-search"></i></a>--%>
                    <span><i class="fa fa-phone"></i> Llama al teléfono <strong>902 369 369</strong> <%-- Buscador  <em>ó</em> busca --%></span>
                </div>
                
                 
                <a href="#" class="visible-sm visible-xs" id="menu-toggle"><i class="fa fa-bars"></i></a>
                
                
                <!-- Main Navigation -->
                <nav class="main-navigation dd-menu toggle-menu" role="navigation">
                    <ul class="sf-menu">
                       <li><a href="${pageContext.servletContext.contextPath}/">Home</a></li>
                       <li class="megamenu"><a href="${pageContext.servletContext.contextPath}/anuncios">Anuncios</a>
                            <ul class="dropdown">
                                <li>
                                    <div class="megamenu-container container">
                                        <div class="row">
                                            <div class="mm-col col-md-2">
                                                <ul class="sub-menu">
                                                    <li><a href="${pageContext.servletContext.contextPath}/anuncios">Todo los anuncios</a></li> 
                                                    <li><a href="${pageContext.servletContext.contextPath}/anuncios?filtroIdProvincia=45">Toledo</a></li>
                                                    <li><a href="${pageContext.servletContext.contextPath}/anuncios?filtroIdProvincia=28">Madrid</a></li>
                                                    <li><a href="${pageContext.servletContext.contextPath}/anuncios?filtroIdProvincia=50">Zaragoza</a></li>
                                                    <li><a href="${pageContext.servletContext.contextPath}/anuncios?filtroIdProvincia=2">Albacete</a></li>
                                                </ul>
                                            </div>
                                            <div class="mm-col col-md-5">
                                            	<c:if test="${not empty listCategoriasN1}">
	                                                <span class="megamenu-sub-title">Por una categoría</span>
	                                                <ul class="body-type-widget">
	                                                    <c:forEach var="rowCatMenu" items="${listCategoriasN1}">   
							                            	<li class="">
							                            		<a href="${pageContext.servletContext.contextPath}/anuncios?filtroIdCategoria=${rowCatMenu.getIdCategoria()}">
							                            			<c:if test="${not empty rowCatMenu.getUrlImagen()}">
							                            				<img src="${pageContext.servletContext.contextPath}/resources/web/${rowCatMenu.getUrlImagen()}" alt="${rowCatMenu.getNombreCategoria()}"/>
							                            			</c:if>
							                            		<span>${rowCatMenu.getNombreCategoria()}</span></a>
							                            	</li>
							                            </c:forEach>                                               
	                                                </ul>
	                                                <%--<a href="results-list.html" class="basic-link">view all</a>--%>
	                                            </c:if>
                                            </div>
                                            <div class="mm-col col-md-5">
                                                <span class="megamenu-sub-title">Patrocinadores</span>
                                                <ul class="make-widget">
                                                    <li class="item"> <a href="#"><img src="${pageContext.servletContext.contextPath}/resources/web/images/patrocinadores/patro_1.png" alt=""></a></li>
                                                    <li class="item"> <a href="#"><img src="${pageContext.servletContext.contextPath}/resources/web/images/patrocinadores/patro_2.png" alt=""></a></li>
                                                    <li class="item"> <a href="#"><img src="${pageContext.servletContext.contextPath}/resources/web/images/patrocinadores/patro_3.png" alt=""></a></li>
                                                    <li class="item"> <a href="#"><img src="${pageContext.servletContext.contextPath}/resources/web/images/patrocinadores/patro_4.png" alt=""></a></li>
                                                    <li class="item"> <a href="#"><img src="${pageContext.servletContext.contextPath}/resources/web/images/patrocinadores/patro_5.png" alt=""></a></li>
                                                    <li class="item"> <a href="#"><img src="${pageContext.servletContext.contextPath}/resources/web/images/patrocinadores/patro_6.png" alt=""></a></li>
                                                    <li class="item"> <a href="#"><img src="${pageContext.servletContext.contextPath}/resources/web/images/patrocinadores/patro_7.png" alt=""></a></li>
                                                    <li class="item"> <a href="#"><img src="${pageContext.servletContext.contextPath}/resources/web/images/patrocinadores/patro_8.png" alt=""></a></li>
                                                </ul>
                                                <%--<a href="results-list.html" class="basic-link">view all</a>--%>
                                            </div>
                                        </div>
                                    </div>
                                </li>
                            </ul>
                        </li>
                        
                        
                         
                        
                        <li><a href="publicar_anuncio.jsp">Publicar un anuncio</a>
                        
                        <c:if test="${ (not empty menuDinamico)	}">
					    	<li><a href="/">${menuDinamico}</a>
					    </c:if>
                       
                        
                    </ul>
                </nav> 
               
            </div>
        </div>
