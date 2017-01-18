<%--

	<div class="main" role="main">
    	<div id="content" class="content full">
        	<div class="container">
            	<div class="row ">
                    
                       
                    
                	<div class="col-md-4 ">
                        <h2>REGÍSTRATE GRATIS</h2>
                        
                        
	                        <section class="signup-form sm-margint">                           
	                            <!-- Regular Signup -->
	                            <div class="regular-signup form-validate-vu">
	                                <form name="formRegistroCorto" id="formRegistroCorto" action="registro_controller.jsp">
	                                    <input type="hidden" name="accion"value="registro_corto" />
	                                    
	                        	    <h3>Crea una cuenta</h3>
	                                    <div class="form-group">
	                                        <input type="text" name="nombre" id="f_nombre" class="form-control validate[required]" maxlength="100" placeholder="Introduce tu nombre">
	                                    </div>
	                                    <div class="form-group">
	                                        <input type="text" name="email" id="f_email" maxlength="100" class="form-control validate[funcCall[checkEmailExiste]]" placeholder="Introduce tu e-mail">
	                                        
	                                    </div>
	                                    <div class="form-group">
	                                        <input type="text" name="email2" id="f_email2" maxlength="100" class="form-control validate[funcCall[checkEmailConfirma]]" placeholder="Repite tu e-mail">
	                                    </div>
	                                    <div class="form-group group-password">
	                                        <input type="password" name="pass" id="f_pass" maxlength="20" class="form-control password-input margin-5 validate[funcCall[checkPassword]]" placeholder="Introduce tu password"/>                                        
	                                    </div>    
	                                    <div class="form-group-progress">
	                                        <a href="javascript:void(0);" class="password-generate pass-actions "><i class="fa fa-refresh"></i></a>
	                                        <div class="progress"><div class="progress-bar password-output" style="width: 0%"></div></div>   
	                                    </div>    
	                                    <div class="clearfix spacer-10"></div>
	                                    <div class="form-group">
	                                        <input type="password" name="pass2" id="f_pass2" maxlength="16" class="form-control validate[funcCall[checkPasswordConfirma]]" placeholder="Repite tu password"/>
	                                    </div>
	                                    <div class="form-group">
	                                        <label class="checkbox-inline"><input name="acepto_politica" value="1" class="validate[funcCall[checkAceptaPoliticaProteccion]]" required type="checkbox"> Acepto <a href="#" >la política de privacidad</a> y <a href="#">condiciones de uso</a>.</label>
	                                    </div>    
	                                    <div class="spacer-20"></div>
	                                   
	                                    <input type="submit" data-loading-text="Enviando..." class="btn btn-primary btn-lg btn-block enviar-formulario-btn" value="Crear cuenta">
	                                    
	                                </form>    
	                                 <div id="message"></div>     
	                            </div>
	                            <!-- Social Signup -->
	                            <div class="social-signup">
	                                <span class="or-break">o</span>
	                                <button type="button" class="btn btn-block btn-facebook btn-social"><i class="fa fa-facebook"></i> Crear con Facebook</button>
	                                <button type="button" class="btn btn-block btn-twitter btn-social"><i class="fa fa-twitter"></i> Crear con Twitter</button>
	                            </div>
	                            
	                        </section>
                       
                      	
                </div>
            </div>
        </div>
   	</div>

 --%>

<div class="container" style="margin-top: 30px;">
	<div id="start" class="form-login">
	
	    <div class="panel panel-success">
	        
	        <div class="panel-heading"><spring:message code="page.login.header.title"/></div>
	        
	        
	        
	        <div class="panel-body">
	        
	            
	            <form class="form-signin" role="form" action="<spring:url value="/j_spring_security_check"/>" method="POST">
	                <%--<label for="j_username"><spring:message code="page.login.login"/></label>
	                <input type="text" id="j_username" name="j_username" class="form-control"
	                       placeholder="<spring:message code="page.login.login"/>" required autofocus> --%>
	                       
	                <label for="j_email"><spring:message code="page.login.email"/></label>
	                <input type="text" id="j_email" name="email" class="form-control" value=""
	                       placeholder="<spring:message code="page.login.email"/>" required autofocus>
	                       
	                <label for="j_password"><spring:message code="page.login.password"/></label>
	                <input type="password" id="j_password" name="j_password" class="form-control"
	                       placeholder="<spring:message code="page.login.password"/>" required>
	                       
	                <button class="btn btn-lg btn-primary btn-block" type="submit">
	                    <spring:message code="page.login.buttonSubmit"/>
	                </button>	                
	            </form>
	            
	            
	            <c:if test="${param.error == 'true'}">
				    <div style="color:red; margin: 20px;">
				    	<spring:message code="page.login.error" /> (${SPRING_SECURITY_LAST_EXCEPTION.message})
				    </div>
				</c:if>
	            
	            
	             <%--
	            <c:if test="${not empty SPRING_SECURITY_LAST_EXCEPTION}">
				      <font color="red">
				        Your login attempt was not successful due to <br/><br/>
				        <c:out value="${SPRING_SECURITY_LAST_EXCEPTION.message}"/>.
				      </font>
				</c:if> --%>
	            
	        </div>
	        
	    </div>
	</div>
</div>	