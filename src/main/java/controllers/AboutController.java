/* WelcomeController.java
 *
 * Copyright (C) 2014 Universidad de Sevilla
 * 
 * The use of this project is hereby constrained to the conditions of the 
 * TDG Licence, a copy of which you may download from 
 * http://www.tdg-seville.info/License.html
 * 
 */

package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class AboutController extends AbstractController {

	// Constructors -----------------------------------------------------------

	public AboutController() {
		super();
	}

	// About ------------------------------------------------------------------

	@RequestMapping(value = "/about")
	public ModelAndView about() {
		ModelAndView result;

		result = new ModelAndView("about");

		return result;
	}

}