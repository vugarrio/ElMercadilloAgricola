package es.ugarrio.elmercadilloagricola.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="/userarea")
public class UserAreaController {
	
	/** Logger for this class and subclasses */
    protected final Log logger = LogFactory.getLog(getClass());
	
	@RequestMapping(value = { "/", "home", "index" }, method = RequestMethod.GET)
	public String index(Model model) {
		
		logger.info(" controler ---->  web/userarea/home");
		
		return "web/userarea/home";		
	}

}
