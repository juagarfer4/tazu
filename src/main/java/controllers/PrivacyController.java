package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/privacy")
public class PrivacyController extends AbstractController{
	
	// Services ---------------------------------------------------------------
	
	// Constructors -----------------------------------------------------------
	
	public PrivacyController(){
		super();
	}
	
	// Listing -----------------------------------------------------------------
	
	@RequestMapping(value = "/lopd-lssi", method = RequestMethod.GET)
	public ModelAndView lopdlssi() {
		ModelAndView result;
				
		result = new ModelAndView("privacy/lopd-lssi");
		
		return result;
	}
	
	@RequestMapping(value = "/cookies", method = RequestMethod.GET)
	public ModelAndView cookies() {
		ModelAndView result;
				
		result = new ModelAndView("privacy/cookies");
		
		return result;
	}
	
	@RequestMapping(value = "/unsubscribe", method = RequestMethod.GET)
	public ModelAndView unsubscribe() {
		ModelAndView result;
				
		result = new ModelAndView("privacy/unsubscribe");
		
		return result;
	}
	
	@RequestMapping(value = "/policy", method = RequestMethod.GET)
	public ModelAndView policy() {
		ModelAndView result;
				
		result = new ModelAndView("privacy/policy");
		
		return result;
	}
	
	// Creation ----------------------------------------------------------------
	
	// Edition -----------------------------------------------------------------
	
	// Ancillary methods -------------------------------------------------------

}
