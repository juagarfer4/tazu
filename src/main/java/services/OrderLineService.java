package services;

import java.util.ArrayList;
import java.util.Collection;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import domain.Artwork;
import domain.Order;
import domain.OrderLine;
import repositories.OrderLineRepository;
import security.Authority;
import security.LoginService;

@Service
@Transactional
public class OrderLineService {

	// Managed repository
	@Autowired
	private OrderLineRepository orderLineRepository;

	// Supporting services
	
	@Autowired
	private ArtworkService artworkService;
	@Autowired
	private OrderService orderService;

	// Constructors
	public OrderLineService() {
		super();
	}

	// Simple CRUD methods
	public OrderLine create() {
		OrderLine res = new OrderLine();
		return res;
	}

	public OrderLine findOne(int orderLineId) {
		return orderLineRepository.findOne(orderLineId);
	}

	public Collection<OrderLine> findAll() {
		return orderLineRepository.findAll();
	}

	public void save(OrderLine orderLine) {
		orderLineRepository.save(orderLine);
	}

	public void delete(OrderLine orderLine) {
		orderLineRepository.delete(orderLine);
	}
	
	public Collection<OrderLine> findByArtist() {
		ArrayList<OrderLine> result;
		Collection<Artwork> artworks;
		OrderLine orderLine;
		String ticker;
	
		artworks = artworkService.findArtworksByPrincipal();
		
		result= new ArrayList<OrderLine>();
		
		for(Artwork a: artworks){
			ticker= a.getTicker();
			orderLine = this.findByTicker(ticker);
			
			if(orderLine != null){
				result.add(orderLine);
			}
		}
		
		return result;
	}

	public OrderLine findByTicker(String ticker) {
		
		return orderLineRepository.findByTicker(ticker);
	}

	// Other business methods
	public Collection<OrderLine> findOrderLinesOfOrder(int orderId) {
		checkPurchaserRole();
		Order order;
		
		order = orderService.findOne(orderId);
		Assert.isTrue(order.getPurchaser().getUserAccount().getId()==LoginService.getPrincipal().getId(), "order.no.yours");
		
		Collection<OrderLine> res = new ArrayList<OrderLine>();
		res = orderLineRepository.findOrderLinesOfOrder(orderId);
		
		return res;
	}
	
	public Collection<OrderLine> findMyOrderLines(){
		checkPurchaserRole();
		Collection<OrderLine> res = new ArrayList<OrderLine>();
		res = orderLineRepository.findMyOrderLines(LoginService.getPrincipal().getId());
		return res;
	}
	
	public Collection<String> findMyArtworksPaid(String ticker){
		checkArtistRole();
		Collection<String> res= new ArrayList<String>();
		res=orderLineRepository.findMyArtworksPaid(ticker);
		return res;
	}


	// All checks
	
	public void checkPurchaserRole() {

		Authority Purchaser = new Authority();
		Purchaser.setAuthority(Authority.PURCHASER);

		Assert.isTrue(LoginService.getPrincipal().getAuthorities().contains(Purchaser), "You're not an Purchaser user");
	}
	
	public void checkArtistRole() {

		Authority artist = new Authority();
		artist.setAuthority(Authority.ARTIST);

		Assert.isTrue(LoginService.getPrincipal().getAuthorities().contains(artist), "You're not an ARTIST user");
	}

	
}
