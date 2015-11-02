package es.ugarrio.elmercadilloagricola.web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class NavigationController {

	@RequestMapping(value = { "/", "index" }, method = RequestMethod.GET)
	public ModelAndView index() {
		return new ModelAndView("web/home");
	}

	/*@RequestMapping(value = "/{pageName}", method = RequestMethod.GET)
	@ResponseBody
	public ModelAndView showPage(final HttpServletRequest request, @PathVariable final String pageName) {
		return new ModelAndView(pageName);
	}*/

}
