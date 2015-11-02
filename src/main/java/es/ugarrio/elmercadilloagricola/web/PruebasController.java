package es.ugarrio.elmercadilloagricola.web;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import es.ugarrio.elmercadilloagricola.domain.Provincia;
import es.ugarrio.elmercadilloagricola.service.ProvinciaService;

@Controller
@RequestMapping(value="/pruebas")
public class PruebasController {
	
	@Autowired
	private ProvinciaService provinciaService;
	
	/** Logger for this class and subclasses */
    protected final Log logger = LogFactory.getLog(getClass());
    
    @RequestMapping(value="/provincias", method=RequestMethod.GET)
    public String pruebaProvinciasPage( Model model) {
		
    	logger.info("Con model");
    	
    	List<Provincia> listProvincia = provinciaService.findAll();
    	//List<Provincia> listProvincia = provinciaService.findByCodProvincia("45");
    	model.addAttribute("listProvincia", listProvincia);
        model.addAttribute("saludo", "Holaaaaaaaaaaa!!!!");
        return "pruebas/provincias";
    	
        //Variable donde pasamos los datos
    	//Map<String, Object> myModel = new HashMap<String, Object>();
        //myModel.put("saludo", "Holaaaaaa");
    	//ModelAndView mav = new ModelAndView("pruebas/provincias", "model", myModel);
		//Smartphone smartphone = smartphoneService.get(id);
		//mav.addObject("sPhone", smartphone);
		//return mav;
	}

	
}
