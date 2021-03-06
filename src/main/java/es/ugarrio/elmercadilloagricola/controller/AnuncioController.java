package es.ugarrio.elmercadilloagricola.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefaults;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.util.NumberUtils;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.HandlerMapping;

import es.ugarrio.elmercadilloagricola.domain.Categoria;
import es.ugarrio.elmercadilloagricola.domain.Provincia;
import es.ugarrio.elmercadilloagricola.dto.AnuncioDTO;
import es.ugarrio.elmercadilloagricola.dto.CategoriaAnunciosDTO;
import es.ugarrio.elmercadilloagricola.dto.ProvinciaAnunciosDTO;
import es.ugarrio.elmercadilloagricola.exception.EMCAException;
import es.ugarrio.elmercadilloagricola.form.AnuncioSearchForm;
import es.ugarrio.elmercadilloagricola.service.AnuncioService;
import es.ugarrio.elmercadilloagricola.service.CategoriaService;
import es.ugarrio.elmercadilloagricola.service.ProvinciaService;


@Controller
public class AnuncioController {
	
	@Autowired
	private AnuncioService anuncioService;
	
	@Autowired
	private ProvinciaService provinciaService;
	
	@Autowired
	private CategoriaService categoriaService;
	
	/** Logger for this class and subclasses */
    protected final Log logger = LogFactory.getLog(getClass());
    
    
    protected static final int DEFAULT_PAGE_NUM = 0;
    protected static final int DEFAULT_PAGE_SIZE = 5;
    protected static final String DEFAULT_RESULTS_LIST_VIEW = "results-list-view";
    protected static final String DEFAULT_RESULTS_ORDER= "a.fechaPublicacion desc";
    
        
    
    @RequestMapping(value = { "/anuncios/", "/anuncios" })
    public String search(@Valid @ModelAttribute("anuncioSearchForm")AnuncioSearchForm form,  BindingResult result, @PageableDefaults(value = DEFAULT_PAGE_SIZE) Pageable pageable, ModelMap model) {
       
    	List<AnuncioDTO> listAnunciosFitradoPaginado = new ArrayList<AnuncioDTO>();
    	List<CategoriaAnunciosDTO> listCategoriaAnuncios = new ArrayList<CategoriaAnunciosDTO>();
    	List<ProvinciaAnunciosDTO> listProvinciaAnuncios = new ArrayList<ProvinciaAnunciosDTO>();
    	
    	int pagina = pageable.getPageNumber() + 1;
    	int listadoNumRegistrosPorPagina = pageable.getPageSize();
    	int listadoTotalRegistros = 0;
    	
    	//Detalles de filtros
    	Categoria filtroCategoria = null;
    	Provincia filtroProvincia = null;
    	
    	
    	//Inicializamos datos de la paginación si estan en blanco.
    	if (form.getListadoVista() == null) {
    		form.setListadoVista(DEFAULT_RESULTS_LIST_VIEW);
    	}
    	
    	if (form.getListadoOrdenarPor() == null) {
    		form.setListadoOrdenarPor(DEFAULT_RESULTS_ORDER);
    	}
    	
    	if (form.getListadoSize() == null) {
    		form.setListadoSize(String.valueOf(DEFAULT_PAGE_SIZE));
    	}    	
    	
    	//Solo anuncios con estado a 1:Activo
    	form.setFiltroIdAnuncioEstado("1");
    	
    	
    	//Validamos el formulario de filtros y si existe error.
    	if (result.hasErrors()) {
    		logger.info(" --> Estoy en search: error en la validación:  " + result.toString());
            return "web/anuncios";
        }
    	
    	
    	//Si se ha filtrado por filtroIdCategoria obtenemos el objeto del dato y se lo pasamos a la view.
		if (!StringUtils.isEmpty(form.getFiltroIdCategoria())) {
			filtroCategoria = categoriaService.findById(Integer.parseInt(form.getFiltroIdCategoria()));
		}
		//Si se ha filtrado por filtroIdProvincia obtenemos el objeto del dato y se lo pasamos a la view.
		if (!StringUtils.isEmpty(form.getFiltroIdProvincia())) {
			filtroProvincia = provinciaService.findById(Integer.parseInt(form.getFiltroIdProvincia()));
		}

           	
    	//Obtenemos el listado de categorias que existen según el filtro
		try {
			listCategoriaAnuncios = categoriaService.findCategoriasAnuncios(form);			
		} catch (EMCAException e) {
			logger.error("No se han podido obtener las categorias con el fitlo: " + e.getMessage());
		}
		
		//Obtenemos el listado de provincias que existen según el filtro
		try {
			listProvinciaAnuncios = provinciaService.findProvinciasAnuncios(form);			
		} catch (EMCAException e) {
			logger.error("No se han podido obtener las provincias con el fitlo: " + e.getMessage());
		}
    	
    	
		//Trazas para ver registros de paginacion
		logger.info(" --> AnuncioSearchForm: " + form.toString());
		
		
    	//Obtenemos el listado de anuncios filtrado y paginado.
    	listAnunciosFitradoPaginado = anuncioService.findAnunciosPaginados(form, pagina, listadoNumRegistrosPorPagina, form.getListadoOrdenarPor());
    	listadoTotalRegistros = anuncioService.countAnunciosPaginados(form);
    	
    	
    	//Trazas para ver registros de paginacion
    	logger.info(" --> AnuncioSearchForm: " + form.toString());    	
    	logger.info(" ---------------- paginacion -- pageable.getPageNumber() = " + pageable.getPageNumber());
    	logger.info(" ---------------- paginacion -- offset = " + pageable.getOffset());
    	logger.info(" ---------------- paginacion -- pageable.getPageSize() = " + pageable.getPageSize());		
    	
    	logger.info(" ---------------- listAnunciosFitradoPaginado.size() = " + listAnunciosFitradoPaginado.size());
    	logger.info(" ---------------- listadoTotalRegistros = " + listadoTotalRegistros);
    	
    	//Creamos el objeto de paginación		
		Page<AnuncioDTO> page = new PageImpl<AnuncioDTO>(listAnunciosFitradoPaginado, pageable, listadoTotalRegistros);
		
		
		//Enviamos datos a la view
    	model.addAttribute("page", page);
    	model.addAttribute("anuncioSearchForm", form);
    	model.addAttribute("filtrosListCategoriaAnuncios", listCategoriaAnuncios);
    	model.addAttribute("filtrosListProvinciaAnuncios", listProvinciaAnuncios);
    	
    	if (categoriaService != null) {
			model.addAttribute("filtroCategoria", filtroCategoria);
		}
    	if (provinciaService != null) {
			model.addAttribute("filtroProvincia", filtroProvincia);
		}
    	
    	model.addAttribute("menuDinamico", "Opción xxxxx");    	
    	
        return "web/anuncios"; 
    }
    
    
    /*@RequestMapping(value = { "/anuncios____", "/anuncios_____/" }, method = RequestMethod.GET)
	public String getAnuncios(@RequestParam Map<String,String> allRequestParams, ModelMap model) {
		
		logger.info("AnuncioController --> anuncios (con parametros dinamicos)");
		
		if (allRequestParams == null) {
			logger.info("Var null");
		} else if (allRequestParams.size()==0) {
			logger.info("Var == 0");
		}
		// Imprimimos el Map con un Iterador
		Iterator it = allRequestParams.keySet().iterator();
		while(it.hasNext()){
		  String key = (String) it.next();
		  logger.info("Clave: " + key + " -> Valor: " + allRequestParams.get(key));
		}
		
		
		//CREAMOS Y RECUPERAMOS VARIABLES DE PAGINACION Y ORDENACION Y FILTROS DE BUSQUEDA 
		String filtroIdAnuncio = ""; 
	    String filtroIdUsuario = "";                    
	    String filtroIdCategoria = "";
	    String filtroIdProvincia = "";
	    String filtroCP = "";
	    String filtroTxt = "";
	    String filtroPrecioDesde = "";
	    String filtroPrecioHasta = "";
	    	    
	    String listadoVista = "results-list-view";
	    String listadoOrdenarPor = "a.fechaPublicacion desc";
	    int pagina = 1;
	    int listadoNumRegistrosPorPagina = 5;  
	    int listadoTotalPaginas = 0;  
	    int listadoTotalRegistros = 0;
	    
	    Map<String,String> filtros = new HashMap<>();
	    
	    //Seleccionamos los anuncios con estado a activos
	    filtros.put("filtro_id_anuncio_estado", "1"); //Activo
	    
	    if (allRequestParams.get("f_idanuncio") != null && !allRequestParams.get("f_idanuncio").trim().equals("")) {
	        filtroIdAnuncio = allRequestParams.get("f_idanuncio");
	        filtros.put("filtroIdAnuncio", filtroIdAnuncio);
	    }
	    if (allRequestParams.get("f_idusuario") != null && !allRequestParams.get("f_idusuario").trim().equals("")) {
	        filtroIdUsuario = allRequestParams.get("f_idusuario"); 
	        filtros.put("filtroIdUsuario", filtroIdUsuario);
	    }
	    if (allRequestParams.get("f_idcategoria") != null && !allRequestParams.get("f_idcategoria").trim().equals("")) {
	        filtroIdCategoria = allRequestParams.get("f_idcategoria");
	        filtros.put("filtroIdCategoria", filtroIdCategoria);
	    }
	    if (allRequestParams.get("f_idprovincia") != null && !allRequestParams.get("f_idprovincia").trim().equals("")) {
	        filtroIdProvincia = allRequestParams.get("f_idprovincia");
	        filtros.put("filtroIdProvincia", filtroIdProvincia);
	    }
	    if (allRequestParams.get("f_cp") != null && !allRequestParams.get("f_cp").trim().equals("")) {
	        filtroCP = allRequestParams.get("f_cp");
	        filtros.put("filtroCP", filtroCP);
	    }
	    if (allRequestParams.get("f_txt") != null && !allRequestParams.get("f_txt").trim().equals("")) {
	        filtroTxt = allRequestParams.get("f_txt");
	        filtros.put("filtroTxt", filtroTxt);
	    }
	    if (allRequestParams.get("f_precio_desde") != null && !allRequestParams.get("f_precio_desde").trim().equals("")) {
	        filtroPrecioDesde = allRequestParams.get("f_precio_desde");
	        filtros.put("filtroPrecioDesde", filtroPrecioDesde);
	    }
	    if (allRequestParams.get("f_precio_hasta") != null && !allRequestParams.get("f_precio_hasta").trim().equals("")) {
	        filtroPrecioHasta = allRequestParams.get("f_precio_hasta");
	        filtros.put("filtroPrecioHasta", filtroPrecioHasta);
	    }
	    
	    
	    if (allRequestParams.get("listado_vista") != null && !allRequestParams.get("listado_vista").trim().equals("")) {
	        listadoVista = allRequestParams.get("listado_vista");
	        filtros.put("listadoVista", listadoVista);
	    }
	    	    
	    
	    if (allRequestParams.get("page") != null && !allRequestParams.get("page").trim().equals("")) {
	        pagina = Integer.parseInt(allRequestParams.get("page"));        
	    }
	    if (allRequestParams.get("listado_num_registros_por_pagina") != null && !allRequestParams.get("listado_num_registros_por_pagina").trim().equals("")) {
	    	listadoNumRegistrosPorPagina = Integer.parseInt(allRequestParams.get("listado_num_registros_por_pagina"));        
	    }
	    if (allRequestParams.get("listado_ordenar_por") != null && !allRequestParams.get("listado_ordenar_por").trim().equals("")) {
	        listadoOrdenarPor = allRequestParams.get("listado_ordenar_por");       
	    }
		    
	    
		
		//Obtenemos y añadimos las categorias del primer nivel (Menu --> Anuncios)
		List<AnuncioDTO> listAnunciosFitradoPaginado = anuncioService.findAnunciosPaginados(filtros, pagina, listadoNumRegistrosPorPagina, listadoOrdenarPor);
		listadoTotalRegistros = anuncioService.countAnunciosPaginados(filtros);
		if (listadoTotalRegistros > 0) {
			listadoTotalPaginas = (int) Math.ceil((double)listadoTotalRegistros / (double)listadoNumRegistrosPorPagina);
		} 
		
		//LOGS PAGINACIÓN
		for (AnuncioDTO anuncioDTO : listAnunciosFitradoPaginado) {
			logger.info(" ---------------- >  " + anuncioDTO.toString());
		}
		logger.info(" ---------------- paginacion -- pagina = " + pagina);
		logger.info(" ---------------- paginacion -- listadoNumRegistrosPorPagina = " + listadoNumRegistrosPorPagina);
		logger.info(" ---------------- paginacion -- listadoTotalRegistros = " + listadoTotalRegistros);
		logger.info(" ---------------- paginacion -- listadoTotalPaginas = " + listadoTotalPaginas);
		logger.info(" ---------------- paginacion -- listadoOrdenarPor = " + listadoOrdenarPor);
		logger.info(" ---------------- paginacion -- listadoVista = " + listadoVista);
		logger.info(" ---------------- paginacion -- filtros = " + filtros.toString());
		
			
		
		//Insertamos en la vista el resultado de los Anuncios
		model.addAttribute("listAnunciosFitradoPaginado", listAnunciosFitradoPaginado);
		
		//Insertamos las variables de paginación
		model.addAttribute("listadoVista", listadoVista);
		model.addAttribute("pagina", pagina);
		model.addAttribute("listadoNumRegistrosPorPagina", listadoNumRegistrosPorPagina);
		model.addAttribute("listadoOrdenarPor", listadoOrdenarPor);
		model.addAttribute("listadoTotalPaginas", listadoTotalPaginas);
		
		//Insertamos las variables de filtros
		model.addAttribute("f_idanuncio", filtroIdAnuncio);
		//TODO: falnta insertar el resto de variables
		
		model.addAttribute("menuDinamico", "Opción dinamica test");
		
		
		return "web/anuncios";		
    }
    
    
    */
    
    
    
    
     
    @RequestMapping(value = { "/anuncio",
    		                  "/anuncio/{id:[\\d]+}",
    		                  "/anuncio/{id:[\\d]+}/{name}",
    		                  "/anuncio/{name}"    		
    }, method = RequestMethod.GET)
	public String getAnuncio(Model model, HttpServletRequest request) {
		 
    	 logger.info("AnuncioController --> anuncio"); 
    	
    	 Map pathVariables = (Map) request.getAttribute(HandlerMapping.URI_TEMPLATE_VARIABLES_ATTRIBUTE);
    	 
    	 AnuncioDTO anuncio = null;
    	 
    	 if (pathVariables != null) {
    		 if (pathVariables.containsKey("idanuncio")) {
    			 logger.info("idanuncio = " +  pathVariables.get("idanuncio"));
    			 anuncio = anuncioService.findOne(NumberUtils.parseNumber((String)pathVariables.get("idanuncio"), Integer.class));
		      }
    		 if (pathVariables.containsKey("id")) {
    			 logger.info("id = " +  pathVariables.get("id"));
    			 anuncio = anuncioService.findOne(NumberUtils.parseNumber((String)pathVariables.get("id"), Integer.class));
    			 
		      }
    		 if (pathVariables.containsKey("name")) {
    			 logger.info("name = " +  pathVariables.get("name"));
		      } 
    	 } else {
    		 logger.info("Sin variables");
    	 }
    	 
    	 if ( anuncio != null) {
    		 model.addAttribute("anuncio", anuncio);
    		 
    		 logger.info(anuncio.toString());
    		 
    		//Mensajes
			/*if (anuncio.getAnunciosMensajes() != null ) { 
				for (AnuncioMensaje anuncioMensaje : anuncio.getAnunciosMensajes()) {					 
					 logger.info(" --> Mensaje: " + anuncioMensaje.getMensaje() );
				}
				logger.info(" --> Size: " + anuncio.getAnunciosMensajes().size() );  
			}*/
    		 
    	 }
    			
		return "web/anuncio";
		
    }
      
    
    
    
    /**********
     * 
     * @RequestMapping(value = { "/trip/", // /trip/
		        "/trip/{tab:doa|poa}/",// /trip/doa/,/trip/poa/
		        "/trip/page{page:\\d+}/",// /trip/page1/
		        "/trip/{tab:doa|poa}/page{page:\\d+}/",// /trip/doa/page1/,/trip/poa/page1/
		        "/trip/{tab:trip|doa|poa}-place-{location}/",// /trip/trip-place-beijing/,/trip/doa-place-shanghai/,/trip/poa-place-newyork/,
		        "/trip/{tab:trip|doa|poa}-place-{location}/page{page:\\d+}/"// /trip/trip-place-beijing/page1/
		}, method = RequestMethod.GET)
		public String tripPark(Model model, HttpServletRequest request) throws Exception {
		    int page = 1;
		    String location = "";
		    String tab = "trip";
		    //
		    Map pathVariables = (Map) request.getAttribute(HandlerMapping.URI_TEMPLATE_VARIABLES_ATTRIBUTE);
		    if (pathVariables != null) {
		        if (pathVariables.containsKey("page")) {
		            page = NumberUtils.toInt("" + pathVariables.get("page"), page);
		        }
		        if (pathVariables.containsKey("tab")) {
		            tab = "" + pathVariables.get("tab");
		        }
		        if (pathVariables.containsKey("location")) {
		            location = "" + pathVariables.get("location");
		        }
		    }
		    page = Math.max(1, Math.min(50, page));
		    final int pagesize = "poa".equals(tab) ? 40 : 30;
		    return _processTripPark(location, tab, pagesize, page, model, request);
		}
     * 
     */
     

}
