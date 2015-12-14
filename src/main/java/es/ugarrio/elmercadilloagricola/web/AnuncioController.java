package es.ugarrio.elmercadilloagricola.web;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.HandlerMapping;

import es.ugarrio.elmercadilloagricola.domain.Anuncio;
import es.ugarrio.elmercadilloagricola.domain.Categoria;
import es.ugarrio.elmercadilloagricola.service.AnuncioService;
import es.ugarrio.elmercadilloagricola.service.CategoriaService;
import es.ugarrio.elmercadilloagricola.service.ProvinciaService;
import es.ugarrio.elmercadilloagricola.web.dto.AnuncioDTO;


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
    
    
    @RequestMapping(value = { "/anuncios", "/anuncios/" }, method = RequestMethod.GET)
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
		
		
		//Procesamos los parametros de entrada. 
		String filtro_id_anuncio = ""; 
	    String filtro_id_usuario = "";                    
	    String filtro_id_categoria = "";
	    String filtro_id_provincia = "";
	    String filtro_cp = "";
	    String filtro_txt = "";
	    String filtro_precio_desde = "";
	    String filtro_precio_hasta = "";
	    
	    String listado_vista = "results-list-view";
	    String listado_ordenar_por = "a.fechaPublicacion desc";
	    int pagina = 1;
	    int listado_num_registros_por_pagina = 5;    
	    
	    Map<String,String> filtros = new HashMap<>();
	    
	    //Seleccionamos los anuncios con estado a activos
	    filtros.put("filtro_id_anuncio_estado", "1"); //Activo
	    
	    if (allRequestParams.get("f_idanuncio") != null && !allRequestParams.get("f_idanuncio").trim().equals("")) {
	        filtro_id_anuncio = allRequestParams.get("f_idanuncio");
	        filtros.put("filtro_id_anuncio", filtro_id_anuncio);
	    }
	    if (allRequestParams.get("f_idusuario") != null && !allRequestParams.get("f_idusuario").trim().equals("")) {
	        filtro_id_usuario = allRequestParams.get("f_idusuario"); 
	        filtros.put("filtro_id_usuario", filtro_id_usuario);
	    }
	    if (allRequestParams.get("f_idcategoria") != null && !allRequestParams.get("f_idcategoria").trim().equals("")) {
	        filtro_id_categoria = allRequestParams.get("f_idcategoria");
	        filtros.put("filtro_id_categoria", filtro_id_categoria);
	    }
	    if (allRequestParams.get("f_idprovincia") != null && !allRequestParams.get("f_idprovincia").trim().equals("")) {
	        filtro_id_provincia = allRequestParams.get("f_idprovincia");
	        filtros.put("filtro_id_provincia", filtro_id_provincia);
	    }
	    if (allRequestParams.get("f_cp") != null && !allRequestParams.get("f_cp").trim().equals("")) {
	        filtro_cp = allRequestParams.get("f_cp");
	        filtros.put("filtro_cp", filtro_cp);
	    }
	    if (allRequestParams.get("f_txt") != null && !allRequestParams.get("f_txt").trim().equals("")) {
	        filtro_txt = allRequestParams.get("f_txt");
	        filtros.put("filtro_txt", filtro_txt);
	    }
	    if (allRequestParams.get("f_precio_desde") != null && !allRequestParams.get("f_precio_desde").trim().equals("")) {
	        filtro_precio_desde = allRequestParams.get("f_precio_desde");
	        filtros.put("filtro_precio_desde", filtro_precio_desde);
	    }
	    if (allRequestParams.get("f_precio_hasta") != null && !allRequestParams.get("f_precio_hasta").trim().equals("")) {
	        filtro_precio_hasta = allRequestParams.get("f_precio_hasta");
	        filtros.put("filtro_precio_hasta", filtro_precio_hasta);
	    }
	    
	    
	    if (allRequestParams.get("listado_vista") != null && !allRequestParams.get("listado_vista").trim().equals("")) {
	        listado_vista = allRequestParams.get("listado_vista");
	        filtros.put("listado_vista", listado_vista);
	    }
	    	    
	    
	    if (allRequestParams.get("pagina") != null && !allRequestParams.get("pagina").trim().equals("")) {
	        pagina = Integer.parseInt(allRequestParams.get("pagina"));        
	    }
	    if (allRequestParams.get("listado_num_registros_por_pagina") != null && !allRequestParams.get("listado_num_registros_por_pagina").trim().equals("")) {
	        listado_num_registros_por_pagina = Integer.parseInt(allRequestParams.get("listado_num_registros_por_pagina"));        
	    }
	    if (allRequestParams.get("listado_ordenar_por") != null && !allRequestParams.get("listado_ordenar_por").trim().equals("")) {
	        listado_ordenar_por = allRequestParams.get("listado_ordenar_por");       
	    }
		    
	    
		
		//Obtenemos y añadimos las categorias del primer nivel (Menu --> Anuncios)
		List<AnuncioDTO> listAnunciosFitradoPaginado = anuncioService.findAnunciosPaginados(filtros, pagina, listado_num_registros_por_pagina, listado_ordenar_por);
		for (AnuncioDTO anuncioDTO : listAnunciosFitradoPaginado) {
			logger.info(" ---------------- >  " + anuncioDTO.toString());
		}
		
		//Insertamos en la vista el resultado de los Anuncios
		model.addAttribute("listAnunciosFitradoPaginado", listAnunciosFitradoPaginado);
		
		//Insertamos las variables de paginación
		model.addAttribute("listado_vista", listado_vista);
		model.addAttribute("pagina", pagina);
		model.addAttribute("listado_num_registros_por_pagina", listado_num_registros_por_pagina);
		model.addAttribute("listado_ordenar_por", listado_ordenar_por);
		
		//Insertamos las variables de filtros
		model.addAttribute("f_idanuncio", filtro_id_anuncio);
		//TODO: falnta insertar el resto de variables
		
		return "web/anuncios";
		
    }
    
    
   
    
    
    @RequestMapping(value = { "/anuncio",
    		                  "/anuncio/{id:[\\d]+}",
    		                  "/anuncio/{id:[\\d]+}/{name}",
    		                  "/anuncio/{name}"    		
    }, method = RequestMethod.GET)
	public String getAnuncio(Model model, HttpServletRequest request) {
		
    	 logger.info("AnuncioController --> anuncio");
    	
    	 Map pathVariables = (Map) request.getAttribute(HandlerMapping.URI_TEMPLATE_VARIABLES_ATTRIBUTE);
    	 
    	 if (pathVariables != null) {
    		 if (pathVariables.containsKey("id")) {
    			 logger.info("id = " +  pathVariables.get("id"));
		      } 
    		 if (pathVariables.containsKey("name")) {
    			 logger.info("name = " +  pathVariables.get("name"));
		      } 
    	 } else {
    		 logger.info("Sin variables");
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
