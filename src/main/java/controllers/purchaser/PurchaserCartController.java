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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import controllers.AbstractController;
import domain.Cart;
import services.CartService;

@Controller
@RequestMapping("/cart/purchaser")
public class PurchaserCartController extends AbstractController {

	// Services ----------------------------------------------------------------
	@Autowired
	private CartService cartService;

	
	// Constructors -----------------------------------------------------------

	public PurchaserCartController() {
		super();
	}
		
	// Edition -----------------------------------------------------------------
	
	@RequestMapping(value = "/addToCart", method = RequestMethod.GET)
	public ModelAndView addToCart(@RequestParam int artworkId) {
		ModelAndView result;

		cartService.addArtworkToCart(artworkId);

		result = new ModelAndView("redirect:/artwork/purchaser/listInCart.do");

		return result;
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public ModelAndView deleteOne(@RequestParam int artworkId) {
		ModelAndView result;

		cartService.deleteArtWorkOfCart(artworkId);

		result = new ModelAndView("redirect:/artwork/purchaser/listInCart.do");

		return result;
	}
	
	// Listing ---------------------------------------------------------------

		@RequestMapping(value = "/list", method = RequestMethod.GET)
		public ModelAndView list() {
			ModelAndView result;


			Cart cart = cartService.findMyCart();

			String uri = "cart/purchaser/list";
			String requestURI = "cart/purchaser/list.do";

			result = createListModelAndView(cart, requestURI, uri);

			return result;
		}

		


		// Other bussiness method ---------------------------------------------------------------

		protected ModelAndView createListModelAndView(Cart cart,
				String requestURI, String uri) {
			ModelAndView result;

			result = new ModelAndView(uri);
			result.addObject("cart", cart);
			result.addObject("requestURI", requestURI);

			return result;
		}
		
	
}