package es.ugarrio.elmercadilloagricola.web;

import java.util.Iterator;
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
