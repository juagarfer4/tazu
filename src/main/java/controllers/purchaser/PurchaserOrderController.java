package controllers.purchaser;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import services.ArtistService;
import services.ArtworkService;
import services.OrderService;
import controllers.AbstractController;
import domain.Artist;
import domain.Order;

@Controller
@RequestMapping("/order/purchaser")
public class PurchaserOrderController extends AbstractController {

	// Services ---------------------------------------------------------------
	@Autowired
	private OrderService orderService;
	@Autowired
	private ArtworkService artworkService;

	@Autowired
	private ArtistService artistService;

	// Constructors -----------------------------------------------------------

	public PurchaserOrderController() {
		super();
	}

	// Listing-------------------------------------------------------------------

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView list() {
		ModelAndView result;
		Collection<Order> orders;

		orders = orderService.findMyOrders();

		String uri = "order/purchaser/list";
		String requestURI = "order/purchaser/list.do";
		result = createListModelAndView(orders, requestURI, uri);

		return result;
	}

	// Edition
	// ------------------------------------------------------------------------------

	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public ModelAndView create() {
		ModelAndView result;
		try {
			orderService.createAndSave();
			result = new ModelAndView("redirect:/order/purchaser/list.do");
		} catch (Throwable oops) {
			result = new ModelAndView(
					"redirect:/artwork/purchaser/listInCart.do");
			result.addObject("message", oops.getMessage());
		}

		return result;
	}

	@RequestMapping(value = "/success", method = RequestMethod.GET)
	public ModelAndView success() {
		ModelAndView result;
		Order order;
		Collection<Artist> artists;

		result = new ModelAndView("order/purchaser/success");
		
		order = orderService.findLastCreatedByPurchaser();

		order.setPaid(true);
		order.setMomentPaid(null);

		orderService.save(order);
		artists = artistService.findArtistsByOrder(order);
		artworkService.updateArtworkTotalCost(artists);
		
//		try {
//			order = orderService.findLastCreatedByPurchaser();
//
//			order.setPaid(true);
//			order.setMomentPaid(null);
//
//			orderService.save(order);
//			Integer orderId;
//			orderId = order.getId();
//			artists = artistService.findArtistsByOrder(order);
//			artworkService.updateArtworkTotalCost(artists);
//			order = orderService.findLastCreatedByPurchaser();
//
//			order.setPaid(true);
//			order.setMomentPaid(null);
//
//			orderService.save(order);
//			orderId = order.getId();
//			artists = artistService.findArtistsByOrder(order);
//			artworkService.updateArtworkTotalCost(artists);
//
//			orderService.sendEmail(orderLineService
//					.findOrderLinesOfOrder(orderId));
//		} catch (Throwable oops) {
//			System.out.println(oops.getMessage());
//		}

		return result;
	}

	@RequestMapping(value = "/success", method = RequestMethod.POST)
	public ModelAndView success2() {
		ModelAndView result;
		Order order;
		Collection<Artist> artists;

		result = new ModelAndView("order/purchaser/success");
		
		order = orderService.findLastCreatedByPurchaser();

		order.setPaid(true);
		order.setMomentPaid(null);

		orderService.save(order);
		artists = artistService.findArtistsByOrder(order);
		artworkService.updateArtworkTotalCost(artists);
		
//		try {
//			order = orderService.findLastCreatedByPurchaser();
//
//			order.setPaid(true);
//			order.setMomentPaid(null);
//
//			orderService.save(order);
//			Integer orderId;
//			orderId = order.getId();
//			artists = artistService.findArtistsByOrder(order);
//			artworkService.updateArtworkTotalCost(artists);
//			order = orderService.findLastCreatedByPurchaser();
//
//			order.setPaid(true);
//			order.setMomentPaid(null);
//
//			orderService.save(order);
//			orderId = order.getId();
//			artists = artistService.findArtistsByOrder(order);
//			artworkService.updateArtworkTotalCost(artists);
//
//			orderService.sendEmail(orderLineService
//					.findOrderLinesOfOrder(orderId));
//		} catch (Throwable oops) {
//			System.out.println(oops.getMessage());
//		}

		return result;
	}

	@RequestMapping(value = "/fail", method = RequestMethod.GET)
	public ModelAndView fail() {
		ModelAndView result;

		result = new ModelAndView("order/purchaser/fail");

		return result;
	}

	// Other bussiness method
	// ---------------------------------------------------------------

	protected ModelAndView createListModelAndView(Collection<Order> orders,
			String requestURI, String uri) {
		ModelAndView result;

		result = new ModelAndView(uri);
		result.addObject("orders", orders);
		result.addObject("requestURI", requestURI);

		return result;
	}

}
