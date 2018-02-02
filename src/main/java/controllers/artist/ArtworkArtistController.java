package controllers.artist;

import java.util.ArrayList;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.support.ByteArrayMultipartFileEditor;
import org.springframework.web.servlet.ModelAndView;

import controllers.AbstractController;
import domain.Artwork;
import domain.Profit;
import services.ArtworkService;
import services.ProfitService;

@Controller
@RequestMapping("/artwork/artist")
public class ArtworkArtistController extends AbstractController {

	// Services --------------------------------------------------------------

	@Autowired
	private ArtworkService artworkService;
	
	@Autowired
	private ProfitService profitService;
	
	
	@InitBinder
	protected void initBinder(HttpServletRequest request, ServletRequestDataBinder binder) throws ServletException {
		binder.registerCustomEditor(byte[].class, new ByteArrayMultipartFileEditor());
	}


	// Listing -----------------------------------------------------------------

	@RequestMapping(value = "/myList", method = RequestMethod.GET)
	public ModelAndView list() {
		ModelAndView result;
		String requestURI;
		String cancelURI;
		Collection<Artwork> artworks;

		artworks = artworkService.findArtworksByPrincipal();

		requestURI = "artwork/artist/myList.do";
		cancelURI = "welcome/index.do";

		result = new ModelAndView("artwork/list");
		result.addObject("artworks", artworks);
		result.addObject("requestURI", requestURI);
		result.addObject("cancelURI", cancelURI);
		

		return result;
	}
	
	@RequestMapping(value = "/listSold", method = RequestMethod.GET)
	public ModelAndView listSoldAndPaid() {
		ModelAndView result;
		String requestURI;
		String cancelURI;
		Collection<Artwork> artworks;

		artworks = artworkService.findArtworkSoldPaidOfArtist();

		requestURI = "artwork/artist/listSold.do";
		cancelURI = "welcome/index.do";

		result = new ModelAndView("artwork/list");
		result.addObject("artworks", artworks);
		result.addObject("requestURI", requestURI);
		result.addObject("cancelURI", cancelURI);

		return result;
	}
	
	@RequestMapping(value = "/listAll", method = RequestMethod.GET)
	public ModelAndView listAll() {
		ModelAndView result;
		String requestURI;
		String cancelURI;
		Collection<Artwork> artworks;
		String keywordURI;

		artworks = artworkService.findAll();

		requestURI = "artwork/listAll.do";
		cancelURI = "welcome/index.do";
		keywordURI = "artwork/listByKeyword.do";

		result = new ModelAndView("artwork/list");
		result.addObject("artworks", artworks);
		result.addObject("requestURI", requestURI);
		result.addObject("keywordURI", keywordURI);
		result.addObject("cancelURI", cancelURI);

		return result;
	}
	
	@RequestMapping(value = "/listByKeyword", method = RequestMethod.GET)
	public ModelAndView listByKeywordService(@RequestParam String keyword) {
		ModelAndView result;
		String requestURI;
		String keywordURI;
		Collection<Artwork> artworks;

		artworks = artworkService.findByKeywordService(keyword);

		requestURI = "artwork/list.do";
		keywordURI = "artwork/listByKeyword.do";

		result = new ModelAndView("artwork/list");
		result.addObject("artworks", artworks);
		result.addObject("requestURI", requestURI);
		result.addObject("keywordURI", keywordURI);
		

		return result;
	}

	
	
	// Delete -----------------------------------------------------------------
	
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public ModelAndView delete(@RequestParam int artworkId) {
		ModelAndView result;
		String requestURI;
		String uri;
		
		requestURI = "artwork/artist/myList.do";
		uri = "artwork/list";
		
		try {
			
			artworkService.delete(artworkId);
			result = new ModelAndView("redirect:/artwork/artist/myList.do");
		}catch (Throwable oops) {
			result = createListModelAndView(requestURI, uri,oops.getMessage());
		}
			

	
		return result;
	}
	
	// Display -----------------------------------------------------------------

	@RequestMapping(value = "/display", method = RequestMethod.GET)
	public ModelAndView display(@RequestParam int artworkId) {
		ModelAndView result;
		Artwork artwork;
		String requestURI, cancelURI;
		Collection<String> tags;

		artwork = artworkService.findOne(artworkId);
		tags = artworkService.formatTags(artwork);

		cancelURI = "artwork/listByArtist.do?artistId="+artwork.getArtist().getId();
		requestURI = "artwork/display.do";

		result = new ModelAndView("artwork/display");
		result.addObject("artwork", artwork);
		result.addObject("tags", tags);
		result.addObject("requestURI", requestURI);
		result.addObject("cancelURI", cancelURI);

		return result;

	}
	
	// Creation ----------------------------------------------------------------
	
	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public ModelAndView create(){
		ModelAndView result;
		Artwork artwork;
		
		artwork = artworkService.create();
		result = createEditModelAndView(artwork);
		
		return result;
	}
		//Editing-------------------------------------------------

	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public ModelAndView edit(@RequestParam int artworkId){
		ModelAndView result;
		Artwork artwork;
		artwork = artworkService.findOne(artworkId);

		result = createEditModelAndView(artwork);
		return result;

	}
	// Edition -----------------------------------------------------------------
	
	@RequestMapping(value = "/edit", method = RequestMethod.POST, params = "save")
	public ModelAndView save(@Valid Artwork artwork, BindingResult binding) {
		ModelAndView result;

		if (binding.hasErrors()) {
			result = createEditModelAndView(artwork);
		} else {
			try {
				
				
				artworkService.save(artwork);
				
				result = new ModelAndView("redirect:../../artwork/artist/myList.do");
			} catch (Throwable oops) {
				
				if (oops.getMessage().startsWith("artwork")) {
                	result = createEditModelAndView(artwork, oops.getMessage());
                }
                else {
                	result = createEditModelAndView(artwork, "artwork.commit.error");
                }
				
				
			}
		}
		return result;
	}
	
	// Ancillary methods ----------------------------------------------

		protected ModelAndView createEditModelAndView(Artwork artwork) {
			ModelAndView result;

			result = createEditModelAndView(artwork, null);

			return result;
		}

		protected ModelAndView createEditModelAndView(Artwork artwork, String string) {
			ModelAndView result;
			Integer numberOfSales;
			Double taxNumber,profitNumber;
			Profit profit;
			
			numberOfSales = artworkService.findNumberOfSalesByArtist();
			profit = profitService.findProfitByNumberSalesByArtist(numberOfSales);
			
			taxNumber= artwork.getTax().getValue()/100;
			profitNumber= profit.getValue()/100;

			result = new ModelAndView("artwork/edit");
			result.addObject("artwork", artwork);
			result.addObject("profitNumber", profitNumber);
			result.addObject("taxNumber", taxNumber);
			result.addObject("message", string);

			return result;
		}


		protected ModelAndView createListModelAndView(String requestURI, String uri, String message) {
			ModelAndView result;
			
			Collection<Artwork> artworks = new ArrayList<Artwork>();
			
			artworks = artworkService.findArtworksByPrincipal();

			result = new ModelAndView(uri);
			result.addObject("artworks", artworks);
			result.addObject("requestURI", requestURI);
			result.addObject("message", message);

			return result;
		}
		
	
}
