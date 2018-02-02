package controllers.purchaser;

import java.util.Collection;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import controllers.AbstractController;
import domain.Artist;
import domain.Review;
import services.ArtistService;
import services.ReviewService;

@Controller
@RequestMapping("/review/purchaser")
public class PurchaserReviewController extends AbstractController {

	// Services ----------------------------------------------------------------
	@Autowired
	private ReviewService reviewService;
	@Autowired
	private ArtistService artistService;

	// Constructors -----------------------------------------------------------
	public PurchaserReviewController() {
		super();
	}

	// Listing-----------------------------------------------------------------
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView list() {
		ModelAndView result;
		Collection<Review> reviews;

		reviews = reviewService.findMyReviews();

		String uri = "review/purchaser/list";
		String requestURI = "review/purchaser/list.do";
		result = createListModelAndView(reviews, requestURI, uri);

		return result;
	}

	// Creation ---------------------------------------------------------------
	
	// Creation ---------------------------------------------------------------
		@RequestMapping(value = "/create")
		public ModelAndView create(@RequestParam int artistId) {
			ModelAndView result;
			Review review;

			review = reviewService.create(artistId);

			result = createModelAndView(review, null);

			return result;
		}

	
	// Edition------------------------------------------------------------------------
	/*	
		@RequestMapping(value = "/edit", method = RequestMethod.GET)
		public ModelAndView edit(@RequestParam int reviewId) {
			ModelAndView result;
			Review review;

			review = reviewService.findOne(reviewId);

			result = createEditModelAndView(review, null);

			return result;
		}*/

		@RequestMapping(value = "/edit", method = RequestMethod.POST, params = "save")
		public ModelAndView save(@Valid Review review, BindingResult binding) {
			ModelAndView result;
			if (binding.hasErrors()) {
				System.out.println(binding.getAllErrors().get(0));
				result = createEditModelAndView(review, null);
			} else {
				try {
					reviewService.save(review);
					artistService.saveAverage(review.getArtist());
					result = new ModelAndView("redirect:/review/list.do?artistId="+review.getArtist().getId());
				} catch (Throwable oops) {
					result = createEditModelAndView(review, oops.getMessage());

				}
			}

			return result;
		}


		@RequestMapping(value = "/create", method = RequestMethod.POST, params = "save")
		public ModelAndView save2(@Valid Review review, BindingResult binding) {
			ModelAndView result;
			if (binding.hasErrors()) {
				System.out.println(binding.getAllErrors().get(0));
				result = createModelAndView(review, null);
			} else {
				try {
					reviewService.save(review);
					artistService.saveAverage(review.getArtist());
					result = new ModelAndView("redirect:/review/list.do?artistId="+review.getArtist().getId());
				} catch (Throwable oops) {
					result = createModelAndView(review, oops.getMessage());

				}
			}

			return result;
		}

		
	// Other bussiness method
	// ---------------------------------------------------------------
	protected ModelAndView createListModelAndView(Collection<Review> reviews, String requestURI, String uri) {
		ModelAndView result;

		
		result = new ModelAndView(uri);
		result.addObject("reviews", reviews);
		result.addObject("requestURI", requestURI);

		return result;
	}
	
	protected ModelAndView createEditModelAndView(Review review, String message) {
		ModelAndView result;

		
		result = new ModelAndView("review/purchaser/edit");
		result.addObject("review", review);
		result.addObject("message", message);
		return result;
	}
	
	protected ModelAndView createModelAndView(Review review, String message) {
		ModelAndView result;

		Collection<Artist> artists=artistService.findAll();
		Collection<Integer> ratings = reviewService.getRatingNumbers();
		
		result = new ModelAndView("review/purchaser/create");
		result.addObject("review", review);
		result.addObject("message", message);
		result.addObject("artists", artists);
		result.addObject("ratings", ratings);
		return result;
	}

	

}