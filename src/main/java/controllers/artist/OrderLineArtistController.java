package controllers.artist;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import controllers.AbstractController;
import domain.OrderLine;
import services.ArtistService;
import services.OrderLineService;
import services.ReviewService;

@Controller
@RequestMapping("/orderLine/artist")
public class OrderLineArtistController extends AbstractController {

	// Services ----------------------------------------------------------------
	@Autowired
	private OrderLineService orderLineService;

	// Constructors -----------------------------------------------------------
	public OrderLineArtistController() {
		super();
	}

	// Listing-----------------------------------------------------------------
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView list() {
		ModelAndView result;
		Collection<OrderLine> orderLines;

		orderLines = orderLineService.findByArtist();

		String requestURI = "orderLine/artist/list.do";
		
		result = new ModelAndView("orderLine/artist/list");
		result.addObject("orderLines", orderLines);
		result.addObject("requestURI", requestURI);

		return result;
	}

	// Creation ---------------------------------------------------------------
	
	
	
	// Edition------------------------------------------------------------------------

		
	// Other bussiness method
	// ---------------------------------------------------------------

	

	

}