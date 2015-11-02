$(function() {
    
    $('[data-toggle="tooltip"]').tooltip()
    
    $("#formLogin").on("submit", function(event) {                   	
            event.preventDefault();
            enviarDatosLogin($(this));                                
     }); 
});

function enviarDatosLogin(obj) {
    if ( obj.validaFormulariosVU() ) {

        $('.enviar-formulario-btn', obj).button('loading');
        

        var datos = obj.serialize();  
        var origen = obj.attr('data-origen');
        
        $.ajax({
          type: "POST",    
          url: 'login_controller.jsp',
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
                    mostrarCajaFormMensajeOK (obj, tag_MENSAJE.text()); 
                    if (origen == 'publicar_anuncio') {
                        self.location = 'publicar_anuncio.jsp';     
                    } else if (origen == 'area_usuario') {
                        self.location = 'area_usuario_anuncios.jsp';     
                    } else {
                        //location.reload();         
                        self.location = 'area_usuario_anuncios.jsp'; 
                    }
                               
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
    


