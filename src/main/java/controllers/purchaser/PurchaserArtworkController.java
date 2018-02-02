package controllers.purchaser;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import controllers.AbstractController;
import domain.Artwork;
import domain.Cart;
import domain.Tax;
import services.ArtworkService;
import services.CartService;
import services.TaxService;

@Controller
@RequestMapping("/artwork/purchaser")
public class PurchaserArtworkController extends AbstractController {

	// Services ----------------------------------------------------------------
	@Autowired
	private ArtworkService artworkService;
	
	@Autowired
	private TaxService taxService;
	
	@Autowired
	private CartService cartService;

	// Constructors -----------------------------------------------------------
	public PurchaserArtworkController() {
		super();
	}

	// Listing-----------------------------------------------------------------
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView list() {
		ModelAndView result;
		Collection<Artwork> artworks;
		String cancelURI;

		artworks = artworkService.findArtWorkPurchasedByMe();
		cancelURI = "welcome/index.do";

		String uri = "artwork/purchaser/list";
		String requestURI = "artwork/purchaser/list.do";
		result = createListModelAndView(artworks, requestURI, uri);
		result.addObject("cancelURI", cancelURI);

		return result;
	}

	@RequestMapping(value = "/listInCart", method = RequestMethod.GET)
	public ModelAndView listInCart() {
		ModelAndView result;
		Collection<Artwork> artworks;
		String cancelURI;
		Cart cart;
		Double totalCost = 0.0;
		Tax tax;

		cart = cartService.findMyCart();
		List<Tax> taxes;
		taxes = new ArrayList<Tax>(taxService.findAll());
		tax=taxes.get(0);
		

		artworks = artworkService.findArtWorkInCart();
		cancelURI = "welcome/index.do";

		String uri = "artwork/purchaser/listInCart";
		String requestURI = "artwork/purchaser/listInCart.do";
		result = createListModelAndView(artworks, requestURI, uri);
		result.addObject("tax", tax);
		result.addObject("cancelURI", cancelURI);
		if(artworks.size()>0){
			cart.setArtworks(artworks);
		}
		result.addObject("cart", cart);
		if (cart != null) {
			totalCost = cartService.calculateTotalCost(cart);
			cart.setTotalCost(totalCost);
		}
		if (artworks.size()==0){
			totalCost = 0.0;
		}
		result.addObject("totalCost", totalCost);

		return result;
	}



	// Creation ---------------------------------------------------------------

	// Edition------------------------------------------------------------------------

	// Other bussiness method
	// ---------------------------------------------------------------
	protected ModelAndView createListModelAndView(Collection<Artwork> artworks, String requestURI, String uri) {
		ModelAndView result;

		result = new ModelAndView(uri);
		result.addObject("artworks", artworks);
		result.addObject("requestURI", requestURI);

		return result;
	}

}