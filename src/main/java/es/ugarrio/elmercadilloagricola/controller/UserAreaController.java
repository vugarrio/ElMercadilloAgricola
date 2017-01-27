package es.ugarrio.elmercadilloagricola.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="/userarea")
public class UserAreaController {
	
	/** Logger for this class and subclasses */
    protected final Log logger = LogFactory.getLog(getClass());
    
    
   
    @RequestMapping(value = { "/"}, method = RequestMethod.GET)
	public String index(Model model, Authentication authentication) {
    	
    	UserDetails userDetails = null;
		
		logger.info(" controler ---->  web/userarea/home");
		
		if (authentication.isAuthenticated())  {
			userDetails = (UserDetails) authentication.getPrincipal();
			//logger.info(" authentication ---->  " + authentication.toString());
			logger.info(" authentication ---->  Autorizaciones: " + userDetails.getAuthorities());
			logger.info(" authentication ---->  UserName: " + userDetails.getUsername());
			logger.info(" authentication ---->  HashCode: " + userDetails.hashCode());
			
		} else {
			logger.info(" authentication ---->  No esta identificado");
		}
		
    	
    	 return "redirect:/userarea/anuncios/";
    }
	
	@RequestMapping(value = {"anuncios" }, method = RequestMethod.GET)
	public String getListAnuncios(Model model, Authentication authentication) {
		
		logger.info(" controler ---->  web/userarea/anuncios");
		
		
		return "web/userarea/anuncios";		
	}
	

}
