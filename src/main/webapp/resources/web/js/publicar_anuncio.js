$(function() {
    
    $('.fileinput').fileinput();
    
    // Publicar un anuncio
    /*$(".listing-form-steps li").on("click", function(){
            $(this).removeClass("completed");
            $(".listing-form-steps li").removeClass("active");
            $(this).addClass("active");
            $(this).prevAll().addClass("completed");
    });*/
    $(".listing-form-steps li:nth-child(1), .link-publcar-listing-add-form-one").on("click", function(){
            $(".listing-form-progress .progress-bar").attr("data-appear-progress-animation","0%").width("0%");
            acualizarProcesoPublicarAnuncio();
    });
    $(".listing-form-steps li:nth-child(2), .link-publcar-listing-add-form-two").on("click", function(){
            $(".listing-form-progress .progress-bar").attr("data-appear-progress-animation","50%").width("50%");
            acualizarProcesoPublicarAnuncio();
    });
    $(".listing-form-steps li:nth-child(3), .link-publcar-listing-add-form-three").on("click", function(){
            
            $(".listing-form-progress .progress-bar").attr("data-appear-progress-animation","100%").width("100%");
            var esOK = validaFormularioPublicarAnuncio ();
            /*if (validaFormularioPublicarAnuncio ()) {
                $(".listing-form-progress .progress-bar").attr("data-appear-progress-animation","100%").width("100%");
                acualizarProcesoPublicarAnuncio();
            } else {
                return false;   
            }*/        
            
    });
    $('.registration-details').hide();
    $('.listing-add-form .registeredv').on("click", function() {
            $(".registration-details").slideUp();
    });
    $('.listing-add-form .noregisteredv').on("click", function() {
            $(".registration-details").slideDown();
    });
    
    $('#btn_publicar_anuncio').on("click", function(event) {
            event.preventDefault();
            enviarDatosFormInsertarAnuncio();
    });
    
    
});

function acualizarProcesoPublicarAnuncio() {
    var grafica = $(".listing-form-steps li");
    grafica.removeClass("completed");
    $(".listing-form-steps li").removeClass("active");
    grafica.addClass("active");
    grafica.prevAll().addClass("completed");        
    
    //Subo el scroll
    //$('body,html').animate({ scrollTop: "0" }, 750, 'easeOutExpo' );
}

function validaFormularioPublicarAnuncio () {
    var formPA = $("#formPublicarAnuncio");
    var caja = $("#listing-add-form-three .caja-txt-validacion");
    
    if ( formPA.validaFormulariosVU() ) {
        mostrarCajaFormMensajeOK(caja, "Los datos introducidos estan correctos. Para finalizar pulse en el boton PUBLICAR.<br/>¡MUCHA SUERTE!");
        $("#btn_publicar_anuncio").show();
        $("#btn_revisar_anuncio").hide();
        return true;
    } else {
        mostrarCajaFormMensajeError(caja, "<strong>Existen datos incorrectos en el formulario.</strong><br/>Por favor, revisa los campos marcados.");   
        $("#btn_publicar_anuncio").hide();
        $("#btn_revisar_anuncio").show();
        return false; 
    }
}

function enviarDatosFormInsertarAnuncio() {
    var obj = $("#formPublicarAnuncio");
    var caja = $("#listing-add-form-three .caja-txt-validacion");
    
    $('.enviar-formulario-btn', obj).button('loading');
    $('.caja-txt-validacion').html('');
    
    var datos = obj.serialize();  
    
    obj.attr('action', 'publicar_anuncio_controller.jsp');
    obj.submit();

    /* ***$.ajax({
      type: "POST",    
      url: 'publicar_anuncio_controller.jsp',
      data: datos,
      async: false,
      dataType: "xml",
      error:  function(request, settings){
        mostrarCajaFormMensajeError (caja, 'No se han podido enviar los datos.');
        $('.enviar-formulario-btn', obj).button('reset');
      },
      success: function(dataXml) {
         var tag_REALIZADO =  $(dataXml).find('REALIZADO'); 
         var tag_MENSAJE =  $(dataXml).find('MENSAJE');
         if (tag_REALIZADO.text() == '1') {  
                capa_ok = $('.listing-form-content #message');
                capa_ok.hide();
                capa_ok.html(tag_MENSAJE.text());                    
                capa_ok.slideDown('slow');
                $('.enviar-formulario-btn', obj).removeAttr('disabled');
                $('#listing-add-form-three').slideUp('slow');
                
                $('.listing-form-steps li:nth-child(3)').addClass("active");
                $('#listing-add-form-one, #listing-add-form-two').remove();
                $('.listing-form-steps li').off();

         } else {
              mostrarCajaFormMensajeError (caja, tag_MENSAJE.text()); 
         }
         $('.enviar-formulario-btn', obj).button('reset');
      }
   }); **** */


  
}   



