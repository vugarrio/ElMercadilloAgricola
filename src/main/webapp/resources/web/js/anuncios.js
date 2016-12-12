$(function() {
    
    $(".filtro_buscador_link").on("click",  function(e) {
        e.preventDefault();  
        var filtro_nombre = $(this).attr('filtro_nombre');
        var filtro_valor = $(this).attr('filtro_valor');    
        $("#formBuscarAnuncios input[name='" + filtro_nombre + "']").val(filtro_valor);
        lanzarBusquedaFiltrada();
     });
     
     
     $(".filtro_buscador_link").on("click",  function(e) {
        e.preventDefault();  
        var filtro_nombre = $(this).attr('filtro_nombre');
        var filtro_valor = $(this).attr('filtro_valor');    
        $("#formBuscarAnuncios input[name='" + filtro_nombre + "']").val(filtro_valor);
        lanzarBusquedaFiltrada();
     });
     
     $(".result-list-num-registros").on("click",  function(e) {
        e.preventDefault();  
        //alert('ok');
        var num_registros = $(this).html();
        $("#formBuscarAnuncios input[name='listadoSize']").val(num_registros);
        $("#formBuscarAnuncios input[name='page.size']").val(num_registros);        
        lanzarBusquedaFiltrada();
     });
     
     $(".result-list-opcion-ordenacion").on("click",  function(e) {
        e.preventDefault();  
        var campo = $(this).attr('campo');
        var texto = $(this).html();
        $("#formBuscarAnuncios input[name='listadoOrdenarPor']").val(campo);
        $("#  ").html(texto);
        lanzarBusquedaFiltrada();
     });
     
     $("#btn-filters-reset").on("click",  function(e) {
        e.preventDefault();  
        resetBusquedaFiltrada();
        lanzarBusquedaFiltrada();
     });
     
     
     //La paginacion se hace a traves del formulario
     $(".pagination a").on("click",  function(e) {
         e.preventDefault();  
         //alert($(this).attr('href'));
         if ($.urlParam($(this).attr('href'), 'page.page') != null) {
        	 $("#formBuscarAnuncios input[name='page.page']").val($.urlParam($(this).attr('href'), 'page.page'));
         }
         $("#formBuscarAnuncios").submit();
      });
     
     
     
});


function filtro_buscador(txt_var) {
    if (txt_var == "filtroPrecio") {
        
        var filtro_valor_desde = $('#filtroPrecioDesde').val();
        var filtro_valor_hasta = $('#filtroPrecioHasta').val();
        $("#formBuscarAnuncios input[name='filtroPrecioDesde']").val(filtro_valor_desde);
        $("#formBuscarAnuncios input[name='filtroPrecioHasta']").val(filtro_valor_hasta);
        
    } else {
        var filtro_valor = $('#'+txt_var).val();  
        $("#formBuscarAnuncios input[name='" + txt_var + "']").val(filtro_valor);
    }
    lanzarBusquedaFiltrada();
};

function lanzarBusquedaFiltrada () {
    $("#formBuscarAnuncios input[name='page.page']").val('1');
    $("#formBuscarAnuncios").submit();
}

function resetBusquedaFiltrada () {
    $("#formBuscarAnuncios input[name='filtroIdCategoria']").val('');
    $("#formBuscarAnuncios input[name='filtroIdProvincia']").val('');
    $("#formBuscarAnuncios input[name='filtroTxt']").val('');
    $("#formBuscarAnuncios input[name='filtroCP']").val('');
    $("#formBuscarAnuncios input[name='filtroPrecioDesde']").val('');
    $("#formBuscarAnuncios input[name='filtroPrecioHasta']").val('');
    lanzarBusquedaFiltrada();
}

function irAPaginaBusquedaFiltrada (pagina) {
    $("#formBuscarAnuncios input[name='page.page']").val(pagina);
    $("#formBuscarAnuncios").submit();
}
