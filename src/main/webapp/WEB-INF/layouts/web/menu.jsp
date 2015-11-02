<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"  %>

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
                       <li><a href="index.jsp">Home</a></li>
                       <li class="megamenu"><a href="anuncios.jsp">Anuncios</a>
                            <ul class="dropdown">
                                <li>
                                    <div class="megamenu-container container">
                                        <div class="row">
                                            <div class="mm-col col-md-2">
                                                <ul class="sub-menu">
                                                    <li><a href="anuncios.jsp">Todo los anuncios</a></li> 
                                                    <li><a href="anuncios.jsp?f_idprovincia=45">Toledo</a></li>
                                                    <li><a href="anuncios.jsp?f_idprovincia=28">Madrid</a></li>
                                                    <li><a href="anuncios.jsp?f_idprovincia=50">Zaragoza</a></li>
                                                    <li><a href="anuncios.jsp?f_idprovincia=2">Albacete</a></li>
                                                </ul>
                                            </div>
                                            <div class="mm-col col-md-5">
                                                <span class="megamenu-sub-title">Por una categoría</span>
                                                <ul class="body-type-widget">
                                                    <%-- [***] ${beanCategorias.getHTMLListLICategoriasN1("")}  --%>                                                   
                                                </ul>
                                                    <%--<a href="results-list.html" class="basic-link">view all</a>--%>
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
                        
                    </ul>
                </nav> 
               
            </div>
        </div>
