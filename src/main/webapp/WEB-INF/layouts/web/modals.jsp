<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
W<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<div class="modal fade" id="loginModal" tabindex="-1" role="dialog"  aria-hidden="true">
    <div class="modal-dialog modal-sm">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4>INICIA SESSIÓN</h4>
            </div>
            <div class="modal-body form-validate-vu">
                <form name="formLogin" id="formLogin" action="login_controller.jsp"  data-origen="${param.origen}" method="post">
                    <input type="hidden" name="accion" value="login"/>
                    <div class="input-group">
                        <span class="input-group-addon"><i class="fa fa-user"></i></span>
                        <input type="text" name="email" class="form-control validate[required]" placeholder="E-mail">
                    </div>
                    <div class="input-group">
                        <span class="input-group-addon"><i class="fa fa-key"></i></span>
                        <input type="password" name="password" class="form-control validate[required]" placeholder="Password">
                    </div>
                    <input type="submit" data-loading-text="Verificando..." class="btn btn-primary enviar-formulario-btn" value="Iniciar sesión">
                </form>
           	</div>
            <div class="modal-footer">
                <button type="button" class="btn btn-block btn-facebook btn-social"><i class="fa fa-facebook"></i> Iniciar con Facebook</button>
                <button type="button" class="btn btn-block btn-twitter btn-social"><i class="fa fa-twitter"></i> Iniciar con Twitter</button>
            </div>
        </div>
    </div>
</div>
