$(function() {
    
    $('[data-toggle="tooltip"]').tooltip()
    
    $("#formContactar").on("submit", function(event) {                   	
            event.preventDefault();
            enviarDatosFormContactar($(this));                                
     }); 
    
});

function enviarDatosFormContactar(obj) {
    if ( obj.validaFormulariosVU() ) {

        $('.enviar-formulario-btn', obj).button('loading');

        var datos = obj.serialize();    
        
        $.ajax({
          type: "POST",    
          url: 'anuncio_controller.jsp',
          data: datos,
          async: false,
          dataType: "xml",
          error:  function(request, settings){
            mostrarCajaFormMensajeError (obj, 'No se han podido enviar los datos.');
            $('.enviar-formulario-btn', obj).button('reset');
          },
          success: function(dataXml) {
             var tag_REALIZADO =  $(dataXml).find('REALIZADO'); 
             var tag_MENSAJE =  $(dataXml).find('MENSAJE');
             if (tag_REALIZADO.text() == '1') {  
                    capa_ok = $('.loan-contactar #message');
                    capa_ok.hide();
                    capa_ok.html(tag_MENSAJE.text());                    
                    capa_ok.slideDown('slow');
                    $('.enviar-formulario-btn', obj).removeAttr('disabled');
                    $('#formContactar').slideUp('slow');
                    
             } else {
                  mostrarCajaFormMensajeError (obj, tag_MENSAJE.text()); 
             }
             $('.enviar-formulario-btn', obj).button('reset');
          }
       });


    }   else {
            mostrarCajaFormMensajeError (obj, "Por favor, revisa los campos marcados."); 
    }
  
}   



