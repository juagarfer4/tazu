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

import services.ProfitService;
import controllers.AbstractController;
import domain.Profit;

@Controller
@RequestMapping("/profit/administrator")
public class ProfitAdministratorController extends AbstractController {
	
	// Constructor ----------------------------------------------------
	public ProfitAdministratorController() {
		super();
	}
	
	// Services ---------------------------------------------------------
	@Autowired
	private ProfitService profitService;
	
	// List --------------------------------------------------------------
	@RequestMapping(value="/list",method = RequestMethod.GET)
	public ModelAndView list(){
		ModelAndView result;
			
		Collection<Profit> profits = profitService.findAll();
					
		result = new ModelAndView("profit/list");
		result.addObject("profits", profits);
		result.addObject("requestUri","/profit/administrator/list.do");
					
		return result;
	}
	
	// Edit --------------------------------------------------------------
	@RequestMapping(value="/edit",method = RequestMethod.GET)
	public ModelAndView edit(@RequestParam int profitId){
		ModelAndView result;
		Profit profit;
		profit = profitService.findOne(profitId);
		
		result = new ModelAndView("profit/edit");
		result.addObject("profit", profit);
		return result;
	}
	
	// Save --------------------------------------------------------------
	@RequestMapping(value="/edit",method = RequestMethod.POST, params="save")
	public ModelAndView edit(@Valid Profit profit, BindingResult binding){
		ModelAndView result;
		
		if(binding.hasErrors()){
			result = new ModelAndView("profit/edit");
			result.addObject("profit", profit);
		}else{
			try{
				profitService.save(profit);
				result = new ModelAndView("redirect:/profit/administrator/list.do");
			}catch(Throwable oops){
				result = new ModelAndView("profit/edit");
				result.addObject("profit", profit);
				result.addObject("message2","profit.commit.error");
			}
		}
		return result;
	}

}
