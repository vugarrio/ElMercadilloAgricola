package es.ugarrio.elmercadilloagricola.web;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
    
    @RequestMapping(value = { "/anuncios" }, method = RequestMethod.GET)
	public String anuncios(Model model) {
		
		logger.info("AnuncioController --> anuncios");
		
		return "web/anuncios.jsp";
		
    }
    
    
    
    @RequestMapping(value = { "/anuncio" }, method = RequestMethod.GET)
	public String anuncio(Model model) {
		
		logger.info("AnuncioController --> anuncio");
		
		return "web/anuncio";
		
    }

}
