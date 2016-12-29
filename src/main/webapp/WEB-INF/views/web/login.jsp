

<div class="container" style="margin-top: 30px;">
	<div id="start" class="form-login">
	
	    <div class="panel panel-success">
	        
	        <div class="panel-heading"><spring:message code="page.login.header.title"/></div>
	        
	        
	        
	        <div class="panel-body">
	        
	            
	            <form class="form-signin" role="form" action="<spring:url value="/j_spring_security_check"/>" method="POST">
	                <label for="j_username"><spring:message code="page.login.login"/></label>
	                <input type="text" id="j_username" name="j_username" class="form-control"
	                       placeholder="<spring:message code="page.login.login"/>" required autofocus>
	                       
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