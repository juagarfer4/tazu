package services;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import domain.Artist;
import domain.Artwork;
import domain.Cart;
import domain.MailMail;
import domain.Order;
import domain.OrderLine;
import domain.Profit;
import domain.Status;
import domain.Tax;
import junit.framework.Assert;
import repositories.OrderLineRepository;
import repositories.OrderRepository;
import security.Authority;
import security.LoginService;

@Service
@Transactional
public class OrderService {

	// Managed repository
	@Autowired
	private OrderRepository orderRepository;

	// Supporting services
	@Autowired
	private CartService cartService;
	@Autowired
	private ArtistService artistService;
	@Autowired
	private ProfitService profitService;
	@Autowired
	private TaxService taxService;
	@Autowired
	private ArtworkService artworkService;

	// Constructors
	public OrderService() {
		super();
	}

	// Simple CRUD methods
	public Order create() {
		Order res;
		res = new Order();
		return res;
	}

	public Order findOne(int orderId) {
		return orderRepository.findOne(orderId);
	}

	public Collection<Order> findAll() {
		return orderRepository.findAll();
	}

	public void save(Order order) {
		orderRepository.save(order);
	}

	public void delete(Order order) {
		orderRepository.delete(order);
	}

	// Other business methods
	public void createAndSave() {

		Cart cart;
		Double totalCost;
		Boolean paid;
		List<OrderLine> orderLines;
		Order order = create();
		cart = cartService.findMyCart();
		Collection<Artwork> artworks;
		Profit profit;
		Collection<Tax> taxs;
		Tax tax;
		int numberSales;
		Collection<Cart> carts;

		// Cart no puede estar vacia
		org.springframework.util.Assert.isTrue(cart.getArtworks().size() != 0, "cart.has.no.artwork");
		// No puede generar otro order habiendo ya pagado uno
		org.springframework.util.Assert.isTrue(findLastCreatedByPurchaser() == null, "must.pay.the.previous.order");
		// Encontramos las obras
		artworks = artworkService.findArtWorkInCartAlthoughArtworkIsSold();
		// Creamos un nuevo pedido
		orderLines = new ArrayList<OrderLine>();
		totalCost = 0.0;
		paid = false;
		order.setPaid(paid);
		order.setTotalCost(totalCost);

		for (Artwork a : artworks) {
			OrderLine orderLine;
			// Compruebo que el artwork del carrito no ya sido vendido
			// org.springframework.util.Assert.isTrue(a.getStatus().compareTo(Status.SALE)
			// == 0, "artwork.is.sold");
			org.springframework.util.Assert.isTrue(a.getStatus().equals(Status.SALE), "artwork.is.sold");
			// Por cada línea de carro creamos una línea de pedido
			orderLine = new OrderLine();
			Double orderLineValue = 0.0;
			Double profitValue = 0.0;
			Double taxValue = 0.0;

			// Asociamos atributos
			orderLine.setTicker(a.getTicker());
			orderLine.setTitle(a.getTitle());
			numberSales = artistService.findNumberArtworkSoldByArtist(a.getArtist().getUserAccount().getId());
			profit = profitService.findProfitByNumberSales(numberSales);

			orderLine.setProfit(profit.getValue());
			a.setStatus(Status.SOLD);
			carts = a.getCarts();
			// for (Cart c : carts) {
			// c.getArtworks().remove(a);
			// cartService.save(cart);
			// }
			taxValue = a.getPrice() * ((1 + (a.getTax().getValue()) / 100));
			profitValue = (a.getPrice() * (profit.getValue()) / 100);
			orderLineValue = taxValue + profitValue;
			totalCost = totalCost + orderLineValue;

			order.setTotalCost(totalCost);

			// Asociamos las líneas al pedido
			orderLine.setOrder(order);
			orderLines.add(orderLine);
			orderLineValue = redondear(orderLineValue);
			orderLine.setTotalCost(orderLineValue);

		}
		// Encontrar la tasa áctiva
		taxs = taxService.findAll();
		tax = ((List<Tax>) taxs).get(0);
		order.setTaxName(tax.getName());
		order.setTaxValue(tax.getValue());
		// Asigno comprador al pedido
		order.setPurchaser(cart.getPurchaser());
		// Guardo el momento de la compra
		Date moment = new Date(System.currentTimeMillis() - 1000);
		order.setMoment(moment);
		order.setMomentPaid(moment);
		// Redondeo el precio
		totalCost = redondear(order.getTotalCost());
		order.setTotalCost(totalCost);

		// Libera la asociación entre carro y cliente
		order.getPurchaser().setCart(null);

		// Al eliminar carrito también elimina sus líneas
		cartService.delete(cart);

		// Asociamos al pedido sus líneas
		order.setOrderLines(orderLines);
		orderRepository.save(order);

	}

	public Collection<Order> findMyOrders() {
		checkPurchaserRole();
		Collection<Order> res = new ArrayList<Order>();
		res = orderRepository.findMyOrders(LoginService.getPrincipal().getId());
		return res;
	}

	public double redondear(double value) {
		return Math.rint(value * 100) / 100;
	}

	public Order findLastCreatedByPurchaser() {
		checkPurchaserRole();
		Order res = orderRepository.findLastCreatedByPurchaser(LoginService.getPrincipal().getId());
		return res;
	}

	public Collection<Order> findMomentPaidIsNotNull() {
		Collection<Order> res = new ArrayList<Order>();
		res = orderRepository.findMomentPaidIsNotNull();
		return res;
	}

	public Double findTotalCostByYear() {
		ArrayList<Object> list;
		Double result;
		Date start;

		start = new Date(System.currentTimeMillis() - 1000000);
		start.setMonth(0);
		start.setDate(1);

		list = orderRepository.findTotalCostByStartDate(start);

		result = (Double) list.get(0);
		if (result == null) {
			result = 0.0;
		}

		return result;
	}

	public Double findTotalCostByMonth() {
		ArrayList<Object> list;
		Double result;
		Date start;

		start = new Date(System.currentTimeMillis() - 1000000);
		start.setDate(1);

		list = orderRepository.findTotalCostByStartDate(start);

		result = (Double) list.get(0);
		if (result == null) {
			result = 0.0;
		}

		return result;
	}

	public Double findTotalCost() {
		ArrayList<Object> list;
		Double result;

		list = orderRepository.findTotalCost();

		result = (Double) list.get(0);
		if (result == null) {
			result = 0.0;
		}

		return result;
	}

	public Double findProfitByYear() {
		ArrayList<Object> list;
		Double result;
		Date start;

		start = new Date(System.currentTimeMillis() - 1000000);
		start.setMonth(0);
		start.setDate(1);

		list = orderRepository.findProfitByStartDate(start);

		result = (Double) list.get(0);
		if (result == null) {
			result = 0.0;
		}

		return result;
	}

	public Double findProfitByMonth() {
		ArrayList<Object> list;
		Double result;
		Date start;

		start = new Date(System.currentTimeMillis() - 1000000);
		start.setDate(1);

		list = orderRepository.findProfitByStartDate(start);

		result = (Double) list.get(0);
		if (result == null) {
			result = 0.0;
		}

		return result;
	}

	public Double findProfit() {
		ArrayList<Object> list;
		Double result;

		list = orderRepository.findProfit();

		result = (Double) list.get(0);
		if (result == null) {
			result = 0.0;
		}

		return result;
	}

	public void sendEmail(Collection<OrderLine> orderLines) {
		Set<Artist> artists = new HashSet<Artist>();
		for (OrderLine o : orderLines) {
			Artwork a = artworkService.findArtworkByTicker(o.getTicker());
			Artist art = a.getArtist();
			artists.add(art);

			ApplicationContext context = new ClassPathXmlApplicationContext("PopulateDatabase.xml");

			MailMail mm = (MailMail) context.getBean("mailMail");
			if (LocaleContextHolder.getLocale().getDisplayLanguage().equals("Spanish")
					|| LocaleContextHolder.getLocale().getDisplayLanguage().equals("español")) {

				mm.sendMail("tazuispp@outlook.com", art.getEmail(),
						"¡Su obra " + a.getTitle() + " ha sido vendida!",
						"Estimado/a " + art.getName() + ",\n" + "" + "Estamos encantados de informarle que su obra "
								+ a.getTitle()
								+ " ha sido vendida. Si tiene alguna duda o sugerencia, no dude en contactar con nosotros ispptazu@gmail.com. \n"
								+ "" + "Pase un buen día. \n" + "Tazu Inc. \n \n"
								+ "Para más información visite nuestra página web");

			} else {
				mm.sendMail("tazuispp@outlook.com", art.getEmail(),
						"Your artwork " + a.getTitle() + " has been sold!",
						"Dear " + art.getName() + ",\n\n" + "" + "We are glad to inform you that your artwork "
								+ a.getTitle()
								+ " has been sold. If you have any doubts or suggestions, please contact us ispptazu@gmail.com. \n"
								+ "" + "Have a nice day. \n" + "Tazu Inc. \n \n"
								+ "Visit our page www.tazu.com for more information");

			}
		}

	}

	// All checks
	public void checkPurchaserRole() {

		Authority purchaser = new Authority();
		purchaser.setAuthority(Authority.PURCHASER);

		Assert.assertTrue("You're not an PURCHASER user",
				LoginService.getPrincipal().getAuthorities().contains(purchaser));
	}

	public void checkAdminRole() {

		Authority admin = new Authority();
		admin.setAuthority(Authority.ADMINISTRATOR);

		Assert.assertTrue("You're not an ADMIN user", LoginService.getPrincipal().getAuthorities().contains(admin));
	}

}
