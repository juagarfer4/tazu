/* CustomerController.java
 *
 * Copyright (C) 2013 Universidad de Sevilla
 * 
 * The use of this project is hereby constrained to the conditions of the 
 * TDG Licence, a copy of which you may download from 
 * http://www.tdg-seville.info/License.html
 * 
 */

package controllers.purchaser;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import controllers.AbstractController;
import domain.OrderLine;
import services.OrderLineService;
import services.TaxService;

@Controller
@RequestMapping("/orderLine/purchaser")
public class PurchaserOrderLineController extends AbstractController {

	// Services ----------------------------------------------------------------

	@Autowired
	private OrderLineService orderLineService;
	


	// Constructors -----------------------------------------------------------

	public PurchaserOrderLineController() {
		super();
	}

	// Listing ---------------------------------------------------------------

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView list(@RequestParam int orderId) {
		ModelAndView result;
		String uri = "orderLine/purchaser/list";
		String requestURI = "orderLine/purchaser/list.do";
		
		try {
			Collection<OrderLine> orderLines = orderLineService
					.findOrderLinesOfOrder(orderId);
			result = createListModelAndView(orderLines, requestURI, uri);
		} catch (Throwable oops) {
			result = new ModelAndView(
					"redirect:/order/purchaser/list.do?message=order.no.yours");
			result.addObject("message", oops.getMessage());
		}

		return result;
			

		
	}

	// Other bussiness method
	// ---------------------------------------------------------------

	protected ModelAndView createListModelAndView(
			Collection<OrderLine> orderLines, String requestURI, String uri) {
		ModelAndView result;

		result = new ModelAndView(uri);
		
		result.addObject("orderLines", orderLines);
		result.addObject("requestURI", requestURI);

		return result;
	}

}