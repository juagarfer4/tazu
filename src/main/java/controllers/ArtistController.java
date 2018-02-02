package controllers;

import java.util.Collection;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import domain.Artist;
import forms.ArtistForm;
import services.ArtistService;

@Controller
@RequestMapping("/artist")
public class ArtistController extends AbstractController {

	// Services ----------------------------------------------------------------
	@Autowired
	private ArtistService artistService;

	// Constructors -----------------------------------------------------------
	public ArtistController() {
		super();
	}

	// Listing-------------------------------------------------------------------

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView list() {
		ModelAndView result;
		String requestURI;
		String cancelURI;
		String keywordURI;
		Collection<Artist> artists;

		artists = artistService.findAll();

		requestURI = "artist/list.do";
		cancelURI = "welcome/index.do";
		keywordURI = "artist/listByKeyword.do";

		result = new ModelAndView("artist/list");
		result.addObject("artists", artists);
		result.addObject("requestURI", requestURI);
		result.addObject("cancelURI", cancelURI);
		result.addObject("keywordURI", keywordURI);

		return result;

	}

	@RequestMapping(value = "/listByKeyword", method = RequestMethod.GET)
	public ModelAndView listByKeywordService(@RequestParam String keyword) {
		ModelAndView result;
		String requestURI;
		String keywordURI;
		Collection<Artist> artists;

		artists = artistService.findArtistByKeywork(keyword);

		requestURI = "artist/list.do";
		keywordURI = "artist/listByKeyword.do";

		result = new ModelAndView("artist/list");
		result.addObject("artists", artists);
		result.addObject("requestURI", requestURI);
		result.addObject("keywordURI", keywordURI);

		return result;
	}

	// Creation ---------------------------------------------------------------
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public ModelAndView create() {
		ModelAndView result;
		ArtistForm artistForm;

		artistForm = artistService.construct();

		result = new ModelAndView("artist/register");
		result.addObject("artistForm", artistForm);

		return result;
	}

	// Edition------------------------------------------------------------------------
	@RequestMapping(value = "/edit", method = RequestMethod.POST, params = "save")
	public ModelAndView save(@Valid ArtistForm artistForm, BindingResult binding) {
		ModelAndView result;
		if (binding.hasErrors()) {
			System.out.println(binding.getAllErrors().get(0));
			if(artistForm.getCheckPassword().isEmpty()|| artistForm.getCheckPassword().length()<5 || artistForm.getCheckPassword().length()>32  
					|| artistForm.getArtist().getUserAccount().getPassword().isEmpty() || artistForm.getArtist().getUserAccount().getPassword().length()<5 
					|| artistForm.getArtist().getUserAccount().getPassword().length()>32){
				result = createEditModelAndView(artistForm,"passwords.notempty");
			}else{
				result = createEditModelAndView(artistForm,null);
			}
				
		} else {
			try {
				artistService.deconstruct(artistForm);
				result = new ModelAndView("redirect:/welcome/login.do");
			} catch (org.springframework.dao.DataIntegrityViolationException oops) {
				result = createEditModelAndView(artistForm, "customer.error.duplicate");
			} catch (Throwable oops) {
				result = createEditModelAndView(artistForm, oops.getMessage());

			}
		}

		return result;
	}

	// Other bussiness method
	// ------------------------ ---------------------------------------
	protected ModelAndView createEditModelAndView(ArtistForm artistForm, String message) {

		ModelAndView result;

		result = new ModelAndView("artist/register");
		result.addObject("message", message);

		return result;
	}

}