package controllers;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import domain.Review;

import services.ReviewService;

@Controller
@RequestMapping("/review")
public class ReviewController extends AbstractController{
	
	// Services --------------------------------------------------------------
	
	@Autowired
	private ReviewService reviewService;
	
	// Constructors ----------------------------------------------------------

	public ReviewController() {
		super();
	}

	// Listing ---------------------------------------------------------------		

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView list(@RequestParam int artistId) {
		ModelAndView result;
		Collection<Review> reviews;
			
		reviews = reviewService.findAllReviewsByArtist(artistId);

		result = new ModelAndView("review/list");
		result.addObject("reviews", reviews);
		result.addObject("requestURI", "review/list.do");

		return result;
	}
	
	// Creation --------------------------------------------
	
	// Edition -------------------------------------------
			
	// Ancillary methods -----------------------------------

}