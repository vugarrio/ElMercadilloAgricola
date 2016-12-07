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
        alert('ok');
        var num_registros = $(this).html();
        $("#formBuscarAnuncios input[name='listado_num_registros_mostrar']").val(num_registros);
        lanzarBusquedaFiltrada();
     });
     
     $(".result-list-opcion-ordenacion").on("click",  function(e) {
        e.preventDefault();  
        var campo = $(this).attr('campo');
        var texto = $(this).html();
        $("#formBuscarAnuncios input[name='listado_ordenar_por']").val(campo);
        $("#dLabel987").html(texto);
        lanzarBusquedaFiltrada();
     });
     
     $("#btn-filters-reset").on("click",  function(e) {
        e.preventDefault();  
        resetBusquedaFiltrada();
        lanzarBusquedaFiltrada();
     });
     
});


function filtro_buscador(txt_var) {
    if (txt_var == "f_precio") {
        
        var filtro_valor_desde = $('#f_precio_desde').val();
        var filtro_valor_hasta = $('#f_precio_hasta').val();
        $("#formBuscarAnuncios input[name='f_precio_desde']").val(filtro_valor_desde);
        $("#formBuscarAnuncios input[name='f_precio_hasta']").val(filtro_valor_hasta);
        
    } else {
        var filtro_valor = $('#'+txt_var).val();  
        $("#formBuscarAnuncios input[name='" + txt_var + "']").val(filtro_valor);
    }
    lanzarBusquedaFiltrada();
};

function lanzarBusquedaFiltrada () {
    $("#formBuscarAnuncios input[name='pagina']").val('');
    $("#formBuscarAnuncios").submit();
}

function resetBusquedaFiltrada () {
    $("#formBuscarAnuncios input[name='f_idcategoria']").val('');
    $("#formBuscarAnuncios input[name='f_idprovincia']").val('');
    $("#formBuscarAnuncios input[name='f_txt']").val('');
    $("#formBuscarAnuncios input[name='f_cp']").val('');
    $("#formBuscarAnuncios input[name='f_precio_desde']").val('');
    $("#formBuscarAnuncios input[name='f_precio_hasta']").val('');
    lanzarBusquedaFiltrada();
}

function irAPaginaBusquedaFiltrada (pagina) {
    $("#formBuscarAnuncios input[name='pagina']").val(pagina);
    $("#formBuscarAnuncios").submit();
}
