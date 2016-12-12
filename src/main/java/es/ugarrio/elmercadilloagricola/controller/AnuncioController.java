package es.ugarrio.elmercadilloagricola.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
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
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.HandlerMapping;

import es.ugarrio.elmercadilloagricola.domain.Anuncio;
import es.ugarrio.elmercadilloagricola.domain.AnuncioImagen;
import es.ugarrio.elmercadilloagricola.domain.Categoria;
import es.ugarrio.elmercadilloagricola.dto.AnuncioDTO;
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
       
        //String name = form.getName();
        //String query = (StringUtils.hasText(name) ? name : "") + "%";
        //Page<User> page = userService.findByNameLike(query, pageable);
        //model.addAttribute("page", page);
    	
    	
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
    	
    	if (result.hasErrors()) {
    		logger.info(" --> Estoy en search: errrrorrrr --> " + result.toString());
            return "web/anuncios";
        }

        String f_idCategoria = form.getFiltroIdCategoria();    	
    	
    	
    	//Page<User> page = userService.findByNameLike(query, pageable);
    	
    	
    	Map<String,String> filtros = new HashMap<String,String>();
    	 
    	int pagina = pageable.getPageNumber() + 1;
    	int listadoNumRegistrosPorPagina = pageable.getPageSize();
    	int offset = pageable.getOffset();
    	int listadoTotalRegistros = 0;
    	
    	//String listadoOrdenarPor =  pageable.getSort().toString();
    	
		
    	
    	List<AnuncioDTO> listAnunciosFitradoPaginado = anuncioService.findAnunciosPaginados(form, pagina, listadoNumRegistrosPorPagina, form.getListadoOrdenarPor());
    	listadoTotalRegistros = anuncioService.countAnunciosPaginados(form);
    	
    	logger.info(" --> Estoy en search: " + f_idCategoria);
    	
    	logger.info(" --> AnuncioSearchForm: " + form.toString());
    	
    	logger.info(" ---------------- paginacion -- pageable.getPageNumber() = " + pageable.getPageNumber());
    	logger.info(" ---------------- paginacion -- offset = " + pageable.getOffset());
    	logger.info(" ---------------- paginacion -- pageable.getPageSize() = " + pageable.getPageSize());
		
    	
    	logger.info(" ---------------- listAnunciosFitradoPaginado.size() = " + listAnunciosFitradoPaginado.size());
    	logger.info(" ---------------- listadoTotalRegistros = " + listadoTotalRegistros);
    	
    			
		Page<AnuncioDTO> page = new PageImpl<AnuncioDTO>(listAnunciosFitradoPaginado, pageable, listadoTotalRegistros);
    	
    	
    	model.addAttribute("page", page);
    	model.addAttribute("anuncioSearchForm", form);
    	
    	
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
