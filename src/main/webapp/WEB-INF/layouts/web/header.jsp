<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="tilesx" uri="http://tiles.apache.org/tags-tiles-extras" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


        <header class="site-header">
            <div class="container sp-cont">
                <div class="site-logo">
                    <h1><a href="index.jsp"><img src="${pageContext.servletContext.contextPath}/resources/web/images/logo.png" alt="Logo"></a></h1>
                    <span class="site-tagline">Comprar y vender,<br>nunca fue tan facil!</span>
                </div>
                <div class="header-right">
                    <%--
                        if (beanSession.isLogin()) {
                    >
                         <div class="user-login-panel logged-in-user">
                             <a title="${beanSession.getNombre()}" href="area_usuario_anuncios.jsp" class="user-login-btn" id="userdropdown" data-toggle="dropdown">
                                <%
                                   String url_foto = "images/avatar/agricultor.png"; 
                                   if (beanSession.getUrlFoto().trim().length() > 0) {
                                       url_foto = beanSession.getUrlFoto();
                                   }
                                %>
                                <img src="<%= url_foto %>" alt="${beanSession.getNombre()}">
                                <span class="user-informa">
                                    <span class="meta-data">Bienvenido</span>
                                    <span class="user-name">${beanSession.getNombre()}</span>
                                </span>
                                <span class="user-dd-dropper"><i class="fa fa-angle-down"></i></span>
                            </a>
                            <ul class="dropdown-menu" role="menu" aria-labelledby="userdropdown">
                                <li><a href="area_usuario_anuncios.jsp">Anuncios</a></li>
                                <li><a href="area_usuario_mensajes.jsp">Mensajes</a></li>
                                <li><a href="javascript:alert('Proximamente');"> Mis datos</a></li>
                                <li><a href="javascript:alert('Proximamente');"> Configuración</a></li>
                                <li><a href="login_controller.jsp?accion=out">Cerrar sesion</a></li>
                            </ul>
                        </div>
                        <div class="topnav dd-menu">
                           
                        </div>
                    
                        } else {
                    --%>
                    
                        <div class="user-login-panel">
                            <a title="Iniciar sesión" href="#" class="user-login-btn" data-toggle="modal" data-target="#loginModal"><i class="icon-profile"></i></a>
                        </div>
                        <div class="topnav dd-menu">
                            <ul class="top-navigation sf-menu">
                                <li><a href="registro.jsp">Registrate</a></li>
                            </ul>
                        </div>
                    
                </div>
            </div>
        </header>
