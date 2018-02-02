package controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.Assert;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import forms.PurchaserForm;
import services.PurchaserService;

@Controller
@RequestMapping("/purchaser")
public class PurchaserController extends AbstractController {

	// Services ----------------------------------------------------------------
	@Autowired
	private PurchaserService purchaserService;

	// Constructors -----------------------------------------------------------
	public PurchaserController() {
		super();
	}

	// Listing-------------------------------------------------------------------

	// Creation ---------------------------------------------------------------
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public ModelAndView create() {
		ModelAndView result;
		PurchaserForm purchaserForm;

		purchaserForm = purchaserService.construct();

		result = new ModelAndView("purchaser/register");
		result.addObject("purchaserForm", purchaserForm);

		return result;
	}

	// Edition------------------------------------------------------------------------
	@RequestMapping(value = "/edit", method = RequestMethod.POST, params = "save")
	public ModelAndView save(@Valid PurchaserForm purchaserForm, BindingResult binding) {
		ModelAndView result;
		
		if (binding.hasErrors()) {
			System.out.println(binding.getAllErrors().get(0));
				if(purchaserForm.getCheckPassword().isEmpty()|| purchaserForm.getCheckPassword().length()<5 || purchaserForm.getCheckPassword().length()>32  
						|| purchaserForm.getPurchaser().getUserAccount().getPassword().isEmpty() || purchaserForm.getPurchaser().getUserAccount().getPassword().length()<5 
						|| purchaserForm.getPurchaser().getUserAccount().getPassword().length()>32){
					result = createEditModelAndView(purchaserForm,"passwords.notempty");
				}else{
					result = createEditModelAndView(purchaserForm,null);
				}
					
				
		}  else {
			try {
				purchaserService.deconstruct(purchaserForm);
				result = new ModelAndView("redirect:/welcome/login.do");
			} catch (org.springframework.dao.DataIntegrityViolationException oops) {
				result = createEditModelAndView(purchaserForm, "customer.error.duplicate");
			} catch (Throwable oops) {
				result = createEditModelAndView(purchaserForm, oops.getMessage());
			}
		}

		return result;
	}

	// Other bussiness method
	// ------------------------ ---------------------------------------
	protected ModelAndView createEditModelAndView(PurchaserForm purchaserForm, String message) {

		ModelAndView result;

		result = new ModelAndView("purchaser/register");
		result.addObject("message", message);

		return result;
	}

}