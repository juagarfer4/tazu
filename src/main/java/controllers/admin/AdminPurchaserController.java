package controllers.admin;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import controllers.AbstractController;
import domain.Purchaser;
import services.PurchaserService;

@Controller
@RequestMapping("/purchaser/admin")
public class AdminPurchaserController extends AbstractController {

	// Services ----------------------------------------------------------------
	@Autowired
	private PurchaserService purchaserService;


	// Constructors -----------------------------------------------------------
	public AdminPurchaserController() {
		super();
	}

	// Listing-----------------------------------------------------------------
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView list() {
		ModelAndView result;
		Collection<Purchaser> purchasers;

		purchasers = purchaserService.findAll();

		String uri = "purchaser/admin/list";
		String requestURI = "purchaser/admin/list.do";
		result = createListModelAndView(purchasers, requestURI, uri);

		return result;
	}

	// Creation ---------------------------------------------------------------

	// Edition------------------------------------------------------------------------

	// Other bussiness method
	// ---------------------------------------------------------------
	protected ModelAndView createListModelAndView(Collection<Purchaser> purchasers, String requestURI, String uri) {
		ModelAndView result;

		result = new ModelAndView(uri);
		result.addObject("purchasers", purchasers);
		result.addObject("requestURI", requestURI);

		return result;
	}

	

}