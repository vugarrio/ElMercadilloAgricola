

	<div class="main" role="login">
    	
    	<div class="hero-area parallax">
    	
            	<div class="row login-principal" >
                    
                	<div class="col-md-4 ">                        
	                        <section class=" signup-form sm-margint ">                           
	                            <!-- Regular Signup -->
	                            <div class="regular-signup form-validate-vu text-align-center">
	                                <form name="formLogin" id="formLogin" action="<spring:url value="/j_spring_security_check"/>"  method="post">
	                                    <input type="hidden" name="accion" value="login"/>
	                                    
	                        	    	<h3>INICIAR SESIÓN</h3>
	                                    
	                                    <div class="input-group">
					                        <span class="input-group-addon"><i class="fa fa-user"></i></span>
					                        <input type="text" id="j_email" name="email" class="form-control validate[required]" placeholder="<spring:message code="page.login.email"/>">
					                    </div>
					                    <div class="input-group">
					                        <span class="input-group-addon"><i class="fa fa-key"></i></span>
					                        <input type="password" id="j_password" name="j_password" class="form-control validate[required]" placeholder="<spring:message code="page.login.password"/>">
					                    </div>
					                    
					                    
					                    <input type="submit" data-loading-text="Verificando..." class="btn btn-primary enviar-formulario-btn" value="<spring:message code="page.login.buttonSubmit"/>">
	                                    
	                                </form>    
	                                
	                                <c:if test="${param.error == 'true'}">
		                                <div id="message">
		                                	<div class="alert alert-danger alert-dismissible" role="alert"><spring:message code="page.login.error" /><%-- (${SPRING_SECURITY_LAST_EXCEPTION.message}) --%></div>
		                                </div>  
	                                </c:if>  
	                                
	                                 
	                            </div>
	                            <!-- Social Signup -->
	                            <div class="social-signup">
	                                <span class="or-break">o</span>
	                                <button type="button" class="btn btn-block btn-facebook btn-social"><i class="fa fa-facebook"></i> Iniciar con Facebook</button>
	                                <button type="button" class="btn btn-block btn-twitter btn-social"><i class="fa fa-twitter"></i> Iniciar con Twitter</button>
	                            </div>
	                            
	                            <div class="registro-signup">
	                            	<span class="or-break">¿Eres un nuevo usuario?</span>
	                                <a href="${pageContext.servletContext.contextPath}/registro/" class="btn btn-default btn-rounded">Registrate</a>
	                                
	                            
	                            </div>
	                            
	                        </section>
                       
                    </div>
               
            </div>
      
   	</div>
