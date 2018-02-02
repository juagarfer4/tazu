package controllers.artist;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import controllers.AbstractController;
import domain.Review;
import services.ArtistService;
import services.ReviewService;

@Controller
@RequestMapping("/review/artist")
public class ArtistReviewController extends AbstractController {

	// Services ----------------------------------------------------------------
	@Autowired
	private ReviewService reviewService;
	@Autowired
	private ArtistService artistService;

	// Constructors -----------------------------------------------------------
	public ArtistReviewController() {
		super();
	}

	// Listing-----------------------------------------------------------------
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView list() {
		ModelAndView result;
		Collection<Review> reviews;

		reviews = reviewService.findReviewsOfArtist();

		String uri = "review/artist/list";
		String requestURI = "review/artist/list.do";
		result = createListModelAndView(reviews, requestURI, uri);

		return result;
	}

	// Creation ---------------------------------------------------------------
	
	
	
	// Edition------------------------------------------------------------------------

		
	// Other bussiness method
	// ---------------------------------------------------------------
	protected ModelAndView createListModelAndView(Collection<Review> reviews, String requestURI, String uri) {
		ModelAndView result;

		
		result = new ModelAndView(uri);
		result.addObject("reviews", reviews);
		result.addObject("requestURI", requestURI);

		return result;
	}
	
	

	

}