	
	
	<div class="main" role="main">
    	<div id="content" class="content full">
        	<div class="container">
            	<div class="row">
                    
                       
                    
                	<div class="col-md-8">
                        <h2>REGÍSTRATE GRATIS</h2>
                        <p>Crea una cuenta en El Mercadillo Verde y tendrás numerosas ventajas, gestión de anuncios, contactos con otros usuarios, guardar tus búsquedas favoritas, envíos de boletines informativos y muchas más ventajas.</p>
                        <div class="spacer-20"></div>
                        <div class="icon-box ibox-rounded ibox-light ibox-effect">
                            <div class="ibox-icon">
                                <i class="fa fa-list-alt"></i>
                            </div>
                            <h3>Gestiona tus anuncios</h3>
                            <p>Modifica, borra o renueva tus anuncios cuando quieras.</p>
                        </div>
                        <div class="spacer-20"></div>
                        <div class="icon-box ibox-rounded ibox-light ibox-effect">
                            <div class="ibox-icon">
                                <i class="fa fa fa-star"></i>
                            </div>
                            <h3>Sigue tus favoritos</h3>
                            <p>Guarda anuncios y consúltalos desde tu ordenador o tu móvil.</p>
                        </div>
                        <div class="spacer-20"></div>
                        <div class="icon-box ibox-rounded ibox-light ibox-effect">
                            <div class="ibox-icon">
                                <i class="fa fa-cogs"></i>
                            </div>
                            <h3>Configura tu cuenta</h3>
                            <p>Gesión de boletines y datos personales</p>
                        </div>
                        <div class="spacer-20"></div>
                        
                        <hr class="fw">
                        
                        <header>
                        	<h3>Testimonios de usuarios</h3>
                        </header>
                        <div class="spacer-40"></div>
                        <!-- Testimonials -->
                      	<div class="carousel-wrapper">
                            <div class="row">
                                <ul class="owl-carousel carousel-fw" id="testimonials-slider" data-columns="2" data-pagination="yes" data-arrows="no" data-single-item="no" data-items-desktop="2" data-items-desktop-small="2" data-items-tablet="2" data-items-mobile="1">
                                    <li class="item">
                                        <div class="testimonial-block">
                                            <blockquote>
                                                <p>Tiene un buscador rápido y ágil donde encortar lo que buscas. Encontré una pieza que hacia tiempo que estaba buscando.</p>
                                            </blockquote>
                                            <div class="testimonial-avatar"><img src="${pageContext.servletContext.contextPath}/resources/web/images/usuarios/tente_100.jpg" alt="" width="60" height="60"></div>
                                            <div class="testimonial-info">
                                                <div class="testimonial-info-in">
                                                    <strong>Vicente Ugarrio</strong>
                                                </div>
                                            </div>
                                        </div>
                                    </li>
                                    <li class="item">
                                        <div class="testimonial-block">
                                            <blockquote>
                                                <p>Agradezco a la persona que me recomendó este buscador; conseguí comprar el tractor que un cliente estaba buscando.</p>
                                            </blockquote>
                                            <div class="testimonial-avatar"><img src="${pageContext.servletContext.contextPath}/resources/web/images/usuarios/user1.jpg" alt="" width="60" height="60"></div>
                                            <div class="testimonial-info">
                                                <div class="testimonial-info-in">
                                                    <strong>José Roberto</strong><span>Repuestos Manrtín</span>
                                                </div>
                                            </div>
                                        </div>
                                    </li>
                                    <li class="item">
                                        <div class="testimonial-block">
                                            <blockquote>
                                                <p>Tienes un teléfono al que llamar, en el que rápidamente te contestan y te solucionan. El trámite es muy rápido .</p>                                                
                                            </blockquote>
                                            <div class="testimonial-avatar"><img src="${pageContext.servletContext.contextPath}/resources/web/images/usuarios/user3.jpg" alt="" width="60" height="60"></div>
                                            <div class="testimonial-info">
                                                <div class="testimonial-info-in">
                                                    <strong>Susana Fenrnadez</strong>
                                                </div>
                                            </div>
                                        </div>
                                    </li>
                                </ul>
                            </div>
                    	</div>
                    </div>
                    <div class="col-md-4">
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
                                        <%-- TODO: Pendiente validar si ya existe el email --%>
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
   	</div>