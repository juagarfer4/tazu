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

import controllers.AbstractController;
import domain.Artist;
import domain.Artwork;
import domain.Order;
import domain.Profit;
import domain.Purchaser;
import domain.Tax;
import services.ArtistService;
import services.ArtworkService;
import services.OrderService;
import services.ProfitService;
import services.PurchaserService;
import services.TaxService;

@Controller
@RequestMapping("/dashboard/admin")
public class DashboardAdminController extends AbstractController {

	// Services ----------------------------------------------------------------
	@Autowired
	private ArtistService artistService;

	@Autowired
	private PurchaserService purchaserService;

	@Autowired
	private ArtworkService artworkService;

	@Autowired
	private OrderService orderService;
	
	@Autowired
	private ProfitService profitService;
	
	@Autowired
	private TaxService taxService;

	// Constructors -----------------------------------------------------------
	public DashboardAdminController() {
		super();
	}

	// Purchaser menu -----------------------------------------------
	@RequestMapping(value = "/purchasers", method = RequestMethod.GET)
	public ModelAndView purchasers() {
		ModelAndView result;
		
		Collection<Artist> highestRateArtists;
		Double numberHighestRateArtists;
		Collection<Artist> moreArtworksSoldArtists;
		Integer numberMoreArtworksSoldArtists;
		Collection<Artist> artistsEarnedMoreMoney;
		Double quantityArtistEarnedMoreMoney;
		Collection<Object> purchaserSpendMoreMoney;
		Collection<Purchaser> moreArtworksBought;
		Collection<Artwork> mostExpensiveOnSale;
		Integer totalPurchasers;
		Integer totalArtists;
		Integer totalOnSaleArtworks;
		Collection<Artwork> onSaleArtworks;
		Collection<Artwork> soldArtworks;
		Integer totalsoldArtworks;
		Integer totalOrders;

		highestRateArtists = artistService.findHighestRateArtists();
		numberHighestRateArtists = artistService.findNumberHighestRateArtists();
		moreArtworksSoldArtists = artistService.findMoreArtworksSoldArtists();
		artistsEarnedMoreMoney = artistService.findArtistEarnedMoreMoney();
		quantityArtistEarnedMoreMoney = artistService.findQuantityArtistEarnedMoreMoney();
		purchaserSpendMoreMoney = purchaserService.findPurchaserSpendMoreMoney();
		moreArtworksBought = purchaserService.findPurchaserMoreArtworkBought();
		mostExpensiveOnSale = artworkService.findMostExpensiveOnSale();
		totalPurchasers = purchaserService.findAll().size();
		totalArtists = artistService.findAll().size();
		totalOnSaleArtworks = artworkService.findArtworkOnSale().size();
		soldArtworks = artworkService.findAll();
		onSaleArtworks = artworkService.findArtworkOnSale();
		soldArtworks.removeAll(onSaleArtworks);
		totalsoldArtworks = soldArtworks.size();
		totalOrders = orderService.findAll().size();

		String out1 = "";
		for (Object a : purchaserSpendMoreMoney) {
			Object[] arr = (Object[]) a;
			if (arr[0] == null) {
				out1 = "[]";
			} else {
				out1 += "Purchaser: " + arr[0].toString() + ", total cost: " + arr[1].toString() + "\n";

			}
		}

		result = new ModelAndView("administrator/purchasers");

		result.addObject("highestRateArtists", highestRateArtists);
		result.addObject("numberHighestRateArtists", numberHighestRateArtists);
		result.addObject("moreArtworksSoldArtists", moreArtworksSoldArtists);
		result.addObject("artistsEarnedMoreMoney", artistsEarnedMoreMoney);
		result.addObject("quantityArtistEarnedMoreMoney", quantityArtistEarnedMoreMoney);
		result.addObject("purchaserSpendMoreMoney", out1);
		result.addObject("moreArtworksBought", moreArtworksBought);
		result.addObject("mostExpensiveOnSale", mostExpensiveOnSale);
		result.addObject("totalPurchasers", totalPurchasers);
		result.addObject("totalArtists", totalArtists);
		result.addObject("totalOnSaleArtworks", totalOnSaleArtworks);
		result.addObject("totalsoldArtworks", totalsoldArtworks);
		result.addObject("totalOrders", totalOrders);

		return result;

	}

	// Artist menu -----------------------------------------------
	@RequestMapping(value = "/artists", method = RequestMethod.GET)
	public ModelAndView artists() {
		ModelAndView result;
		
		Collection<Artist> highestRateArtists;
		Double numberHighestRateArtists;
		Collection<Artist> moreArtworksSoldArtists;
		Integer numberMoreArtworksSoldArtists;
		Collection<Artist> artistsEarnedMoreMoney;
		Double quantityArtistEarnedMoreMoney;
		Collection<Object> purchaserSpendMoreMoney;
		Collection<Purchaser> moreArtworksBought;
		Collection<Artwork> mostExpensiveOnSale;
		Integer totalPurchasers;
		Integer totalArtists;
		Integer totalOnSaleArtworks;
		Collection<Artwork> onSaleArtworks;
		Collection<Artwork> soldArtworks;
		Integer totalsoldArtworks;
		Integer totalOrders;

		highestRateArtists = artistService.findHighestRateArtists();
		numberHighestRateArtists = artistService.findNumberHighestRateArtists();
		moreArtworksSoldArtists = artistService.findMoreArtworksSoldArtists();
		artistsEarnedMoreMoney = artistService.findArtistEarnedMoreMoney();
		quantityArtistEarnedMoreMoney = artistService.findQuantityArtistEarnedMoreMoney();
		purchaserSpendMoreMoney = purchaserService.findPurchaserSpendMoreMoney();
		moreArtworksBought = purchaserService.findPurchaserMoreArtworkBought();
		mostExpensiveOnSale = artworkService.findMostExpensiveOnSale();
		totalPurchasers = purchaserService.findAll().size();
		totalArtists = artistService.findAll().size();
		totalOnSaleArtworks = artworkService.findArtworkOnSale().size();
		soldArtworks = artworkService.findAll();
		onSaleArtworks = artworkService.findArtworkOnSale();
		soldArtworks.removeAll(onSaleArtworks);
		totalsoldArtworks = soldArtworks.size();
		totalOrders = orderService.findAll().size();

		String out1 = "";
		for (Object a : purchaserSpendMoreMoney) {
			Object[] arr = (Object[]) a;
			if (arr[0] == null) {
				out1 = "[]";
			} else {
				out1 += "Purchaser: " + arr[0].toString() + ", total cost: " + arr[1].toString() + "\n";

			}
		}

		result = new ModelAndView("administrator/artists");

		result.addObject("highestRateArtists", highestRateArtists);
		result.addObject("numberHighestRateArtists", numberHighestRateArtists);
		result.addObject("moreArtworksSoldArtists", moreArtworksSoldArtists);
		result.addObject("artistsEarnedMoreMoney", artistsEarnedMoreMoney);
		result.addObject("quantityArtistEarnedMoreMoney", quantityArtistEarnedMoreMoney);
		result.addObject("purchaserSpendMoreMoney", out1);
		result.addObject("moreArtworksBought", moreArtworksBought);
		result.addObject("mostExpensiveOnSale", mostExpensiveOnSale);
		result.addObject("totalPurchasers", totalPurchasers);
		result.addObject("totalArtists", totalArtists);
		result.addObject("totalOnSaleArtworks", totalOnSaleArtworks);
		result.addObject("totalsoldArtworks", totalsoldArtworks);
		result.addObject("totalOrders", totalOrders);

		return result;

	}

	// On sale artworks menu -----------------------------------------------
	@RequestMapping(value = "/onSaleArtworks", method = RequestMethod.GET)
	public ModelAndView onSaleArtworks() {
		ModelAndView result;
		Collection<Artwork> onSaleArtworks;

		onSaleArtworks = artworkService.findArtworkOnSale();

		result = new ModelAndView("administrator/onSaleArtworks");

		result.addObject("onSaleArtworks", onSaleArtworks);

		return result;

	}

	// sold artworks menu -----------------------------------------------
	@RequestMapping(value = "/soldArtworks", method = RequestMethod.GET)
	public ModelAndView soldArtworks() {
		ModelAndView result;
		Collection<Artwork> onSaleArtworks;
		Collection<Artwork> soldArtworks;

		soldArtworks = artworkService.findAll();
		onSaleArtworks = artworkService.findArtworkOnSale();
		soldArtworks.removeAll(onSaleArtworks);

		result = new ModelAndView("administrator/soldArtworks");

		result.addObject("soldArtworks", soldArtworks);

		return result;

	}

	// Order menu -----------------------------------------------
	@RequestMapping(value = "/orders", method = RequestMethod.GET)
	public ModelAndView orders() {
		ModelAndView result;
		Double costYear;
		Double costMonth;
		Double profitYear;
		Double profitMonth;
		Integer totalOrders;
		Collection<Order> orders;
		Double totalCost;
		Double profit;

		costYear = Math.round(orderService.findTotalCostByYear()*100)/100.0;
		costMonth = Math.round(orderService.findTotalCostByMonth()*100)/100.0;
		profitYear = Math.round(orderService.findProfitByYear()*100)/100.0;
		profitMonth = Math.round(orderService.findProfitByMonth()*100)/100.0;
		totalOrders = orderService.findAll().size();
		orders = orderService.findAll();
		totalCost = orderService.findTotalCost();
		profit = orderService.findProfit();
		
		result = new ModelAndView("administrator/orders");

		result.addObject("costYear", costYear);
		result.addObject("costMonth", costMonth);
		result.addObject("profitYear", profitYear);
		result.addObject("profitMonth", profitMonth);
		result.addObject("totalOrders", totalOrders);
		result.addObject("orders", orders);
		result.addObject("totalBilling", totalCost);
		result.addObject("totalProfit", profit);

		return result;

	}
	
	// Listing --------------------------------------
	
	@RequestMapping(value="/listprofit",method = RequestMethod.GET)
	public ModelAndView listprpfit(){
		ModelAndView result;
			
		Collection<Profit> profits = profitService.findAll();
					
		result = new ModelAndView("administrator/listprofit");
		result.addObject("profits", profits);
		result.addObject("requestUri","dashboard/admin/listprofit.do");
					
		return result;
	}
	
	@RequestMapping(value="/listtax",method = RequestMethod.GET)
	public ModelAndView listtax(){
		ModelAndView result;
			
		Collection<Tax> taxes = taxService.findAll();
					
		result = new ModelAndView("administrator/listtax");
		result.addObject("taxes", taxes);
		result.addObject("requestUri","dashboard/admin/listtax.do");
					
		return result;
	}
	
	// Creation --------------------------------------
	
	@RequestMapping(value="/createtax", method=RequestMethod.GET)
	public ModelAndView createtax(){
		ModelAndView result;
		Tax tax;
		
		tax = taxService.create();
		result = new ModelAndView("administrator/createtax");
		result.addObject("tax", tax);
		
		return result;
	}
	
	// Edition -----------------------------------------
	
	@RequestMapping(value="/editprofit",method = RequestMethod.GET)
	public ModelAndView editprofit(@RequestParam int profitId){
		ModelAndView result;
		Profit profit;
		profit = profitService.findOne(profitId);
		
		result = new ModelAndView("administrator/editprofit");
		result.addObject("profit", profit);
		return result;
	}
	
	@RequestMapping(value="/editprofit",method = RequestMethod.POST, params="save")
	public ModelAndView editprofit(@Valid Profit profit, BindingResult binding){
		ModelAndView result;
		
		if(binding.hasErrors()){
			result = new ModelAndView("administrator/editprofit");
			result.addObject("profit", profit);
		}else{
			try{
				profitService.save(profit);
				result = new ModelAndView("redirect:listprofit.do");
			}catch(Throwable oops){
				result = new ModelAndView("administrator/editprofit");
				result.addObject("profit", profit);
				result.addObject("message2","profit.commit.error");
			}
		}
		return result;
	}
	
	@RequestMapping(value="/edittax",method = RequestMethod.GET)
	public ModelAndView edittax(@RequestParam int taxId){
		ModelAndView result;
		Tax tax;
		tax = taxService.findOne(taxId);
		
		result = new ModelAndView("administrator/edittax");
		result.addObject("tax", tax);
		return result;
	}
	
	@RequestMapping(value="/edittax",method = RequestMethod.POST, params="save")
	public ModelAndView edittax(@Valid Tax tax, BindingResult binding){
		ModelAndView result;
		
		if(binding.hasErrors()){
			result = new ModelAndView("administrator/edittax");
			result.addObject("tax", tax);
		}else{
			try{
				taxService.save(tax);
				result = new ModelAndView("redirect:listtax.do");
			}catch(Throwable oops){
				result = new ModelAndView("administrator/edittax");
				result.addObject("tax", tax);
				result.addObject("message2","tax.commit.error");
			}
		}
		return result;
	}

}