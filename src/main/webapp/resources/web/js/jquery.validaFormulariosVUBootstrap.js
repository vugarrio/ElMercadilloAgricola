/**
 * @author Vicente Ugarrio  18/07/2012
 * 
 * 
 * requiere otras libreraias js:  bootstrap.js, validaciones.js

 * 
 */

// definición de la función  
$.fn.validaFormulariosVU = function(options){  
   // puede recibir un array de parámetros nombrados  
   // invocamos a una función genérica que hace el merge   
   // entre los recibidos y los de por defecto   
   var opts = $.extend({}, $.fn.validaFormulariosVU.defaults, options);  
   var form = $(this);
   
   var error = 0;
   var mensaje = opts.textoIntro;
   
   $(".form-control-feedback", form).remove();
   $(".alert", form).remove();
   $('.form-group, .input-group', form).each(function (index) {
    	$(this).removeClass( "has-error has-feedback" );
   }); 	

	form.find("input[class*=validate], select[class*=validate], textarea[class*=validate]").each( 
		function(){ 			
			var rulesParsing = $(this).attr('class');
			var getRules = /\[(.*)\]/.exec(rulesParsing);
			var str = getRules[1];
			var rules = str.split(/\[|,|\]/);
			
			var label_etiqueta = "";
			if ($(this).is("[data-etiqueta]")) {
			    label_etiqueta = $(this).attr('data-etiqueta');
			} else if ($(this).is("[placeholder]")) {
			    label_etiqueta = $(this).attr('placeholder');
			}
						 
			//alert($(this).attr("class") + " -- " + str  + " -- " + rules[0] + " --- data-etiqueta: " + label_etiqueta  ); 
			
			$(this).removeClass('errorMarcoCampo');			
		 
			if (rules[0] == 'required') {
				if ( esVacio($(this).val()) ) {
					error = 1;	
					mensaje =  label_etiqueta.toUpperCase() + ' es requerido';				
					showErrorBootstrap($(this),mensaje);
					
					
				}
			} else  if (rules[0] == 'funcCall') {
				var functionName = rules[1];
				var fn = window[functionName];
				var errorMsg;
				if (typeof(fn) === 'function') {
					errorMsg = fn($(this));
					if (errorMsg !== undefined) {
						error = 1;
						showErrorBootstrap($(this),errorMsg);	
					}	
				}	 
			}	
		}); //function(){ 

	
	
	if (error == 1)	{
		//vex.dialog.alert("Por favor, revise los campos marcados.");
				 
		$('.form-control-feedback').tooltip({'placement':'left'});

		 
		return false;
	}  else {
		//document.formDatosPromocion.action = "promocion_formulario_action.php";	
		//enviarFormularioConsultaDatos();
		//pinta(form, 'ok');
		return true;
	} 


   // para cada componente que puede contener el objeto jQuery que invoca a esta función  
   this.each(function(){
       /*
       // asignamos a la asignación del foco la invocación a una función  
       $(this).focus(function(){  
           // asignamos funcionalidad
           alert($(this).attr('id'));   
       });  
       // asignamos a la perdida del foco la invocación a una función  
       $(this).blur(function(){  
           // asignamos funcionalidad
           alert($(this).attr('id')); 
       });  */
   });  //form.find("[class*=validate]").each()
   
   
   
   function showErrorBootstrap(elem,txt)
	{
		
		//alert($(elem).attr('id'));
		var contenedor = $(elem).parents('.form-group, .input-group').first();
                $(contenedor).addClass('has-error');
		$(contenedor).addClass('has-feedback');
		
                var errorIconFa = $('<i>',{'class':'fa fa-exclamation-circle'});
		var errorIcon = $('<span>',{'class':'glyphicon form-control-feedback', 'data-toggle':'tooltip ', 'title':txt.toUpperCase()}).append(errorIconFa);
               
		
		//$(elem).parent().after(errorIcon);
		primer_hijo = $(':first-child', contenedor);
		
		//alert(primer_hijo.hasClass('checkbox'));
		if ( primer_hijo.hasClass('checkbox')) {
			$(primer_hijo).append(errorIcon);
		} else {
			//$('.input-group:first', contenedor).append(errorIcon);
			$(contenedor).append(errorIcon);
		}
		
		
	}
   
   
	
 
};  
 
// definimos los parámetros junto con los valores por defecto de la función  
$.fn.validaFormulariosVU.defaults = {  
   // para el texto de introducción
   textoIntro: 'Debes rellenar correctamente los siguentes datos:'  
}; 




/* funciones que se llaman para hacer validciones concretas
 * 
 * 
 */


function checkAceptaCondiciones(field){
	var acepta = $("input[name='acepto_aviso_legal']:checked").val();
	if ( acepta === undefined) {
		return "Lea y acepta los términos y condiciones de uso.";
	}			
}

function checkAceptaPoliticaProteccion(field){
	var acepta = $("input[name='acepto_politica']:checked").val();
	if ( acepta === undefined) {
		return "Lea y acepta la Política de privacidad.";
	}			
}


function checkAceptaPoliticaCookies(field){
	var acepta = $("input[name='acepto_cookies']:checked").val();
	if ( acepta === undefined) {
		return "Lea y acepta la Política de cookies.";
	}			
}


function checkEmailValido(field){  
  var mensaje = "";
  var error = 0;
  var dato = field.val();
   var etiqueta = "";
  if (field.is("[data-etiqueta]")) {
	    etiqueta = field.attr('data-etiqueta');
  } else if (field.is("[placeholder]")) {
	    etiqueta = field.attr('placeholder');
  }
  
  
  if (esVacio(dato) ) {
	  	error = 1;
		mensaje = mensaje + etiqueta + " es requerido";
  } else if (!validaEmail(dato)) {
		error = 1;
		mensaje = mensaje + etiqueta + " no válido"
		
	}  	
  
  if (error == 1) {
	  return mensaje;
  }  
}



function checkEmailExiste(field){  
  var mensaje = "";
  var error = 0;
  var dato = field.val();
  var etiqueta = "";
  if (field.is("[data-etiqueta]")) {
	    etiqueta = field.attr('data-etiqueta');
  } else if (field.is("[placeholder]")) {
	    etiqueta = field.attr('placeholder');
  }
  
  if (esVacio(dato) ) {
	  	error = 1;
		mensaje = mensaje + etiqueta + " es requerido";
  } else if (!validaEmail(dato)) {
		error = 1;
		mensaje = mensaje + etiqueta + " no válido"
		
	}  else {
	  
		  /*  ****** TODO: PENDIENTE DE COMPROBAR SI EXISTE EMAIL ****
                  var datos = 'accion=existeEmail&email=' + dato;
		  if ($('#f_id_usuario').length) {
		  	datos = datos + '&id_usuario=' + $('#f_id_usuario').val();
		  }
		  
		  $.ajax({
		  type: "GET",	   
		  url: '/registro_controller.php',
		  data: datos,
		  async: false,
		  dataType: "xml",
		  error:  function(request, settings){
			alert("Error de conexión (error en el servidor): " + request);
		  },
		  success: function(dataXml) {
		  	 var tag_ESVALIDO =  $(dataXml).find('ESVALIDO');	
			 var tag_TEXTO_CONFIRMACION =  $(dataXml).find('MENSAJE');
			 if (tag_ESVALIDO.text() == '0') {
			 	error = 1;
				mensaje =  mensaje + etiqueta + ': ' + tag_TEXTO_CONFIRMACION.text();	
			 }
		  }
		}); */
	}
	
  
  if (error == 1) {
	  return mensaje;
  }  
}


function checkEmailConfirma(field){  
  var mensaje = "";
  var error = 0;
  var dato = field.val();
  var dato_email = $('#f_email').val();
  var etiqueta = "";
  if (field.is("[data-etiqueta]")) {
	    etiqueta = field.attr('data-etiqueta');
  } else if (field.is("[placeholder]")) {
	    etiqueta = field.attr('placeholder');
  }
		  
  if (esVacio(dato) ) {	  
		error = 1;
		mensaje = mensaje +  etiqueta.toUpperCase() + " es requerido"   
		
  } else if (!esVacio(dato_email) && dato_email != dato ) { 
  		error = 1;
		mensaje = mensaje + "Los emails no coinciden"
  }
	
  
  if (error == 1) {
	  return mensaje;
  }  
}


function checkPasswordConfirma(field){  
  var mensaje = "";
  var error = 0;
  var dato = field.val();
  var dato_pass = $('#f_pass').val();
  var etiqueta = "";
  if (field.is("[data-etiqueta]")) {
	    etiqueta = field.attr('data-etiqueta');
  } else if (field.is("[placeholder]")) {
	    etiqueta = field.attr('placeholder');
  }
		  
  if (esVacio(dato) ) {	  
		error = 1;
		mensaje = mensaje +  etiqueta.toUpperCase() + " es requerido"   
		
  } else if (!esVacio(dato_pass) && dato_pass != dato ) { 
  		error = 1;
		mensaje = mensaje + "Las contraseñas no coinciden"
  }
	
  
  if (error == 1) {
	  return mensaje;
  }  
}


function checkCPSpain(field){  
  var mensaje = "";
  var error = 0;
  var dato = field.val();
  var etiqueta = "";
  if (field.is("[data-etiqueta]")) {
	    etiqueta = field.attr('data-etiqueta');
  } else if (field.is("[placeholder]")) {
	    etiqueta = field.attr('placeholder');
  }
  var es_requerido = 1;
  
  if (field.attr('data-es-requerido')) {
  	es_requerido = field.attr('data-es-requerido');
  }
  
  
  if (es_requerido == 1 ) {	  
	 if ( esVacio(dato) ) {	  
			error = 1;
			mensaje = mensaje +  etiqueta.toUpperCase() + " es requerido"; 
			
	  } else if (dato.length !=5 && !$.isNumeric(dato) ) { 
			  		error = 1;
					mensaje = etiqueta.toUpperCase() + " no es válido";   
			  }	
  } else  { 
  		if (!esVacio(dato))  {
  			if (dato.length !=5 && !$.isNumeric(dato) ) { 
			  		error = 1;
					mensaje = etiqueta.toUpperCase() + " no es válido";   
			  }			
  		}   
  } 
  		  
    
  if (error == 1) {
	  return mensaje;
  }  
}


function checkTelefonoSpain(field){  
  var mensaje = "";
  var error = 0;
  var dato = field.val();
  var etiqueta = "";
  if (field.is("[data-etiqueta]")) {
	    etiqueta = field.attr('data-etiqueta');
  } else if (field.is("[placeholder]")) {
	    etiqueta = field.attr('placeholder');
  }
  var es_requerido = 1;
  
  if (field.attr('data-es-requerido')) {
  	es_requerido = field.attr('data-es-requerido');
  }
  
  if (es_requerido == 1 ) {	  
	 if ( esVacio(dato) ) {	  
			error = 1;
			mensaje = mensaje +  etiqueta.toUpperCase() + " es requerido"; 
			
	  } else if (!validaTelefono(dato)) { 
			  		error = 1;
					mensaje = etiqueta.toUpperCase() + " no es válido";   
			  }		
  } else  { 
  		if (!esVacio(dato))  {
  			if (!validaTelefono(dato)) { 
			  		error = 1;
					mensaje = etiqueta.toUpperCase() + " no es válido";   
			  }		
  		}   
  } 
  
  if (error == 1) {
	  return mensaje;
  }  
}


function checkTelefonoGeneral(field){  
  var mensaje = "";
  var error = 0;
  var dato = field.val();
  var etiqueta = "";
  if (field.is("[data-etiqueta]")) {
	    etiqueta = field.attr('data-etiqueta');
  } else if (field.is("[placeholder]")) {
	    etiqueta = field.attr('placeholder');
  }
  var es_requerido = 1;
  
  if (field.attr('data-es-requerido')) {
  	es_requerido = field.attr('data-es-requerido');
  }
  
  if (es_requerido == 1 ) {	  
	 if ( esVacio(dato) ) {	  
			error = 1;
			mensaje = mensaje +  "El teléfono es requerido"; 
			
	  } else if (!validaTelefonoGeneral(dato)) { 
			  		error = 1;
					mensaje = "El formato introducido del teléfono no es válido";   
			  }		
  } else  { 
  		if (!esVacio(dato))  {
  			if (!validaTelefonoGeneral(dato)) { 
			  		error = 1;
					mensaje = "El formato introducido del teléfono no es válido";  
			  }		
  		}   
  } 
  
  if (error == 1) {
	  return mensaje;
  }  
}


function checkPassword(field){  
  var mensaje = "";
  var error = 0;
  var dato = field.val();
  var etiqueta = "";
  if (field.is("[data-etiqueta]")) {
	    etiqueta = field.attr('data-etiqueta');
  } else if (field.is("[placeholder]")) {
	    etiqueta = field.attr('placeholder');
  }
		  
  if (esVacio(dato) ) {	  
		error = 1;
		mensaje = mensaje +  etiqueta.toUpperCase() + " es requerido"; 
		
  } else if (!validarPassword(dato)) { 
  		error = 1;
		mensaje = etiqueta.toUpperCase() + " no es válida, entre 4 y 16 carácteres alfanuméricos";   
  }
	
  
  if (error == 1) {
	  return mensaje;
  }  
}

function checkFecha(field){  
  var mensaje = "";
  var error = 0;
  var dato = field.val();
  var etiqueta = "";
  if (field.is("[data-etiqueta]")) {
	    etiqueta = field.attr('data-etiqueta');
  } else if (field.is("[placeholder]")) {
	    etiqueta = field.attr('placeholder');
  }
  var es_requerido = 1;
  
  if (field.attr('data-es-requerido')) {
  	es_requerido = field.attr('data-es-requerido');
  }
  
  //alert(es_requerido);
  
  if (es_requerido == 1 ) {	  
	 if ( esVacio(dato) ) {	  
			error = 1;
			mensaje = mensaje +  etiqueta.toUpperCase() + " es requerido"; 
			
	  } else if (!fechaCorrecta(dato)) { 
	  		error = 1;
			mensaje = etiqueta.toUpperCase() + " no es válida";   
	  }		
  } else  { 
  		if (!esVacio(dato))  {
  			if (!fechaCorrecta(dato)) { 
		  		error = 1;
				mensaje = etiqueta.toUpperCase() + " no es válida";   
		  }		
  		}   
  }
  
		  
  
	
  
  if (error == 1) {
	  return mensaje;
  }  
}


function checkTexto(field){  
  var mensaje = "";
  var error = 0;
  var dato = field.val();
  var etiqueta = "";
  if (field.is("[data-etiqueta]")) {
	    etiqueta = field.attr('data-etiqueta');
  } else if (field.is("[placeholder]")) {
	    etiqueta = field.attr('placeholder');
  }
		  
  if (esVacio(dato) ) {	  
		error = 1;
		mensaje = mensaje +  etiqueta.toUpperCase() + " es requerido"; 
		
  } else if (dato.length > 1000) { 
  		error = 1;
		mensaje = etiqueta.toUpperCase() + " máximo 1000 caracteres";   
  }
	
  
  if (error == 1) {
	  return mensaje;
  }  
}


function checkTexto2000(field){  
  var mensaje = "";
  var error = 0;
  var dato = field.val();
  var etiqueta = "";
  if (field.is("[data-etiqueta]")) {
	    etiqueta = field.attr('data-etiqueta');
  } else if (field.is("[placeholder]")) {
	    etiqueta = field.attr('placeholder');
  }
		  
  if (esVacio(dato) ) {	  
		error = 1;
		mensaje = mensaje +  etiqueta.toUpperCase() + " es requerido"; 
		
  } else if (dato.length > 2000) { 
  		error = 1;
		mensaje = etiqueta.toUpperCase() + " máximo 2000 caracteres";   
  }
	
  
  if (error == 1) {
	  return mensaje;
  }  
}



/*function resetFormulario(id_txt_form) {    
  $("#"+id_txt_form).reset();
  
  $("#"+id_txt_form + " .campo_txt_in").each(function(index) {
       if (esVacio($(this).val())) {
           if ($(this).attr('type') == 'password') {
              $(this).addClass('campo_password');
           } else {
               $(this).val($(this).attr('data-etiqueta'));
           }
       }
  });  
}*/
