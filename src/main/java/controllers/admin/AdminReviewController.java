package controllers.admin;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import controllers.AbstractController;
import domain.Review;
import services.ReviewService;

@Controller
@RequestMapping("/review/admin")
public class AdminReviewController extends AbstractController {

	// Services ----------------------------------------------------------------
	@Autowired
	private ReviewService reviewService;


	// Constructors -----------------------------------------------------------
	public AdminReviewController() {
		super();
	}

	// Listing-----------------------------------------------------------------
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView list(@RequestParam int purchaserId) {
		ModelAndView result;
		Collection<Review> reviews;

		reviews = reviewService.findReviewsOfPurchaser(purchaserId);

		String uri = "review/admin/list";
		String requestURI = "review/admin/list.do";
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