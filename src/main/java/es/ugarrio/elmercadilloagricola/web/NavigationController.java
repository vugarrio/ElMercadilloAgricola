package es.ugarrio.elmercadilloagricola.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import es.ugarrio.elmercadilloagricola.domain.Anuncio;
import es.ugarrio.elmercadilloagricola.service.AnuncioService;
import es.ugarrio.elmercadilloagricola.service.ProvinciaService;

@Controller
public class NavigationController {
	
	@Autowired
	private AnuncioService anuncioService;
	
	/** Logger for this class and subclasses */
    protected final Log logger = LogFactory.getLog(getClass());
    
    
	@RequestMapping(value = { "/", "home", "index" }, method = RequestMethod.GET)
	public String index(Model model) {
		
		logger.info("Controller --> home");
		
		List<Anuncio> listLastAnuncios = anuncioService.findLast(5);
		model.addAttribute("listLastAnuncios", listLastAnuncios);
		
		//return new ModelAndView("web/home");
		return "web/home";
		
		
	}

	/*@RequestMapping(value = "/{pageName}", method = RequestMethod.GET)
	@ResponseBody
	public ModelAndView showPage(final HttpServletRequest request, @PathVariable final String pageName) {
		return new ModelAndView(pageName);
	}*/

}
