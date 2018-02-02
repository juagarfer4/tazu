package controllers;

import java.util.Collection;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.sql.SQLException;

import services.ArtworkService;
import domain.Artwork;

@Controller
@RequestMapping("/artwork")
public class ArtworkController extends AbstractController {

	// Services --------------------------------------------------------------

	@Autowired
	private ArtworkService artworkService;

	// Listing -----------------------------------------------------------------

	@RequestMapping(value = "/listByArtist", method = RequestMethod.GET)
	public ModelAndView list(@RequestParam int artistId) {
		ModelAndView result;
		String requestURI;
		String cancelURI;
		Collection<Artwork> artworks;

		artworks = artworkService.findByArtist(artistId);

		requestURI = "artwork/listByArtist.do";
		cancelURI = "artist/list.do";

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

		artworks = artworkService.findAllNotDeleted();

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
	
	@RequestMapping(value = "/listOnSale", method = RequestMethod.GET)
	public ModelAndView listOnSale() {
		ModelAndView result;
		Collection<Artwork> artworks;
		String keywordURI;
		String cancelURI;

		artworks = artworkService.findArtworkOnSale();
		keywordURI = "artwork/listByKeyword.do";
		cancelURI = "welcome/index.do";

		String requestURI = "artwork/listOnSale.do";

		result = new ModelAndView("artwork/list");
		result.addObject("artworks", artworks);
		result.addObject("keywordURI", keywordURI);
		result.addObject("requestURI", requestURI);
		result.addObject("cancelURI", cancelURI);

		return result;
	}
	
	
	// Show -----------------------------------------------------------------
	@RequestMapping(value="/show", method=RequestMethod.GET)
	public void show(HttpServletResponse response, @RequestParam int artworkId) throws IOException, SQLException{
		Artwork artwork;
		byte[] picture;
		
		artwork=artworkService.findOne(artworkId);
		picture=artwork.getPicture();
		
		picture = artworkService.watermark(picture);
		
		if(picture != null){
			response.setContentType("image/jpeg");
			response.setContentLength(picture.length);
			response.getOutputStream().write(picture);
			response.getOutputStream().flush();
		}
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
	
	// Ancillary methods -----------------------------------------------------------------
	
	protected ModelAndView createListModelAndView(Collection<Artwork> artworks, String requestURI, String uri) {
		ModelAndView result;

		result = new ModelAndView(uri);
		result.addObject("artworks", artworks);
		result.addObject("requestURI", requestURI);

		return result;
	}

	
}
