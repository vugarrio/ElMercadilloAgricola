package es.ugarrio.elmercadilloagricola.web;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping(value="/anuncios")
public class AnuncioController {
	
	//@Autowired
	//private AnuncioService AnuncioService;
	
	/** Logger for this class and subclasses */
    protected final Log logger = LogFactory.getLog(getClass());

}
