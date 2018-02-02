package controllers.admin;

import java.util.Collection;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import services.TaxService;

import controllers.AbstractController;
import domain.Tax;

@Controller
@RequestMapping("/tax/administrator")
public class TaxAdministratorController extends AbstractController {
	
	// Constructor ----------------------------------------------------
	public TaxAdministratorController() {
		super();
	}
	
	// Services ---------------------------------------------------------
	@Autowired
	private TaxService taxService;
	
	// List --------------------------------------------------------------
	@RequestMapping(value="/list",method = RequestMethod.GET)
	public ModelAndView list(){
		ModelAndView result;
			
		Collection<Tax> taxes = taxService.findAll();
					
		result = new ModelAndView("tax/list");
		result.addObject("taxes", taxes);
		result.addObject("requestUri","/tax/administrator/list.do");
					
		return result;
	}
	
	// Create --------------------------------------------------------------
	@RequestMapping(value="/create", method=RequestMethod.GET)
	public ModelAndView create(){
		ModelAndView result;
		Tax tax;
		
		tax = taxService.create();
		result = new ModelAndView("tax/create");
		result.addObject("tax", tax);
		
		return result;
	}
	
	// Edit --------------------------------------------------------------
	@RequestMapping(value="/edit",method = RequestMethod.GET)
	public ModelAndView edit(@RequestParam int taxId){
		ModelAndView result;
		Tax tax;
		tax = taxService.findOne(taxId);
		
		result = new ModelAndView("tax/edit");
		result.addObject("tax", tax);
		return result;
	}
	
	// Save --------------------------------------------------------------
	@RequestMapping(value="/edit",method = RequestMethod.POST, params="save")
	public ModelAndView edit(@Valid Tax tax, BindingResult binding){
		ModelAndView result;
		
		if(binding.hasErrors()){
			result = new ModelAndView("tax/edit");
			result.addObject("tax", tax);
		}else{
			try{
				taxService.save(tax);
				result = new ModelAndView("redirect:/tax/administrator/list.do");
			}catch(Throwable oops){
				result = new ModelAndView("tax/edit");
				result.addObject("tax", tax);
				result.addObject("message2","tax.commit.error");
			}
		}
		return result;
	}
	
	// Save --------------------------------------------------------------
	@RequestMapping(value="/edit",method = RequestMethod.POST, params="delete")
	public ModelAndView delete(@Valid Tax tax, BindingResult binding){
		ModelAndView result;
		
		if(binding.hasErrors()){
			result = new ModelAndView("tax/edit");
			result.addObject("tax", tax);
		}else{
			try{
				taxService.delete(tax);
				result = new ModelAndView("redirect:/tax/administrator/list.do");
			}catch(Throwable oops){
				result = new ModelAndView("tax/edit");
				result.addObject("tax", tax);
				result.addObject("message2","tax.commit.error");
			}
		}
		return result;
	}

}
