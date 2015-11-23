package es.ugarrio.elmercadilloagricola.web;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import es.ugarrio.elmercadilloagricola.domain.Anuncio;
import es.ugarrio.elmercadilloagricola.domain.Categoria;
import es.ugarrio.elmercadilloagricola.domain.Provincia;
import es.ugarrio.elmercadilloagricola.exception.EMCAException;
import es.ugarrio.elmercadilloagricola.service.AnuncioService;
import es.ugarrio.elmercadilloagricola.service.CategoriaService;
import es.ugarrio.elmercadilloagricola.service.ProvinciaService;
import es.ugarrio.elmercadilloagricola.web.dto.AnuncioDTO;

@Controller
public class NavigationController {
	
	@Autowired
	private AnuncioService anuncioService;
	
	@Autowired
	private ProvinciaService provinciaService;
	
	@Autowired
	private CategoriaService categoriaService;
	
	/** Logger for this class and subclasses */
    protected final Log logger = LogFactory.getLog(getClass());
    
    
	@RequestMapping(value = { "/", "home", "index" }, method = RequestMethod.GET)
	public String index(Model model) {
		
		logger.info("Controller --> home");
		
		//Obtenemos y añadimos el listado de provincias.
		List<Provincia> listProvincias = provinciaService.findAll();		
		model.addAttribute("listProvincias", listProvincias);
		
		
		//Obtenemos y añadimos a la vista los ultimos anuncios publicados.
		List<AnuncioDTO> listLastAnuncios = anuncioService.findLast(8);		
		model.addAttribute("listLastAnuncios", listLastAnuncios);
		
		//Obtenemosy añadimos el num de anuncios activos
		int countAnunciosActivos = anuncioService.countActivos();
		model.addAttribute("countAnunciosActivos", countAnunciosActivos);
		
		
		
		/* *********  INICIO COMUN PARA TODAS LAS PLANTILLAS ****************** */
		
		//Obtenemos y añadimos las categorias del primer nivel (Menu --> Anuncios)
		List<Categoria> listCategoriasN1 = new ArrayList<>();
		try {
			listCategoriasN1 = categoriaService.findByNivel(1);
		} catch (EMCAException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		model.addAttribute("listCategoriasN1", listCategoriasN1);
		
		/* *********  FIN COMUN PARA TODAS LAS PLANTILLAS ****************** */
		
		return "web/home";
		
		
	}

	/*@RequestMapping(value = "/{pageName}", method = RequestMethod.GET)
	@ResponseBody
	public ModelAndView showPage(final HttpServletRequest request, @PathVariable final String pageName) {
		return new ModelAndView(pageName);
	}*/

}
