<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>

<div class="modal fade" id="loginModal" tabindex="-1" role="dialog"  aria-hidden="true">
    <div class="modal-dialog modal-sm">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4>INICIAR SESIÓN</h4>
            </div>
            <div class="modal-body form-validate-vu">
                <form name="formLogin" id="formLogin" action="<spring:url value="/j_spring_security_check"/>"  data-origen="${param.origen}" method="post">
                    <input type="hidden" name="accion" value="login"/>
                    <div class="input-group">
                        <span class="input-group-addon"><i class="fa fa-user"></i></span>
                        <input type="text" id="j_email" name="email" class="form-control validate[required]" placeholder="<spring:message code="page.login.email"/>">
                    </div>
                    <div class="input-group">
                        <span class="input-group-addon"><i class="fa fa-key"></i></span>
                        <input type="password" id="j_password" name="j_password" class="form-control validate[required]" placeholder="<spring:message code="page.login.password"/>">
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
