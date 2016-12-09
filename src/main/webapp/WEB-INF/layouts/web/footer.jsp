<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="string" uri="http://www.springframework.org/tags" %>

	<footer class="site-footer">
       	<div class="site-footer-top">
       		<div class="container">
                <div class="row">
                	<div class="col-md-3 col-sm-6 footer_widget widget widget_newsletter">
                    	<h4 class="widgettitle">Suscripción a newsletter</h4>
                        <form>
                        	<input type="text" class="form-control" placeholder="Nombre">
                        	<input type="email" class="form-control" placeholder="E-mail">
                        	<input type="submit" class="btn btn-primary btn-lg" value="Enviar">
                        </form>
                    </div>
                	<div class="col-md-2 col-sm-6 footer_widget widget widget_custom_menu widget_links">
                    	<h4 class="widgettitle">Categorias</h4>
                        <ul>
                        	<li><a href="${pageContext.servletContext.contextPath}/anuncios?filtroIdCategoria=1">Tractores</a></li>
                        	<li><a href="${pageContext.servletContext.contextPath}/anuncios?filtroIdCategoria=2">Cosechadoras</a></li>
                        	<li><a href="${pageContext.servletContext.contextPath}/anuncios?filtroIdCategoria=3">Sembradoras</a></li>
                        	<li><a href="${pageContext.servletContext.contextPath}/anuncios?filtroIdCategoria=5">Aperos</a></li>
                        </ul>
                    </div>
                	<div class="col-md-2 col-sm-6 footer_widget widget widget_custom_menu widget_links">
                    	<h4 class="widgettitle">Provincias</h4>
                        <ul>
                        	<li><a href="${pageContext.servletContext.contextPath}/anuncios?filtroIdProvincia=45">Toledo</a></li>
                        	<li><a href="${pageContext.servletContext.contextPath}/anuncios?filtroIdProvincia=28">Madrid</a></li>
                        	<li><a href="${pageContext.servletContext.contextPath}/anuncios?filtroIdProvincia=50">Zaragoza</a></li>
                        	<li><a href="${pageContext.servletContext.contextPath}/anuncios?filtroIdProvincia=2">Albacete</a></li>
                        </ul>
                    </div>
                	<div class="col-md-5 col-sm-6 footer_widget widget text_widget">
                    	<h4 class="widgettitle">Sobre nosotros</h4>
                        <p>En Mercadillo Verde podrás buscar y publicar anuncios clasificados gratis de maquinarias y respuestos agricolas en toda España.

Encontrarás anuncios de tractores, cosechadoras, sembradoras, remolques, aperosy todo tipo de herramientas y respuestos.</p>
                    </div>
                </div>
            </div>
     	</div>
        <div class="site-footer-bottom">
        	<div class="container">
                <div class="row">
                	<div class="col-md-6 col-sm-6 copyrights-left">
                    	<p>&copy; 2015 Vicente Ugarrio. Copyright © Todos los Derechos Reservados</p>
                    </div>
                    <div class="col-md-6 col-sm-6 copyrights-right">
                        <ul class="social-icons social-icons-colored pull-right">
                            <li class="facebook"><a href="#"><i class="fa fa-facebook"></i></a></li>
                            <li class="twitter"><a href="#"><i class="fa fa-twitter"></i></a></li>
                            <li class="linkedin"><a href="#"><i class="fa fa-linkedin"></i></a></li>
                            <li class="youtube"><a href="#"><i class="fa fa-youtube"></i></a></li>
                            <li class="flickr"><a href="#"><i class="fa fa-flickr"></i></a></li>
                            <li class="vimeo"><a href="#"><i class="fa fa-vimeo-square"></i></a></li>
                            <li class="digg"><a href="#"><i class="fa fa-digg"></i></a></li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
    </footer>