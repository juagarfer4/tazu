package services;

import java.util.ArrayList;
import java.util.Collection;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import domain.Artist;
import domain.Artwork;
import domain.Cart;
import domain.Profit;
import domain.Purchaser;
import repositories.CartRepository;
import security.Authority;
import security.LoginService;

@Service
@Transactional
public class CartService {

	// Managed repository
	@Autowired
	private CartRepository cartRepository;

	// Supporting services
	@Autowired
	private ArtworkService artWorkService;
	@Autowired
	private ProfitService profitService;
	@Autowired
	private PurchaserService purchaserService;
	@Autowired
	private ArtistService artistService;
	
	// Constructors
	public CartService() {
		super();
	}

	// Simple CRUD methods
	public Cart create() {
		Cart res = new Cart();
		Collection<Artwork> artworks=new ArrayList<Artwork>();
		Purchaser purchaser=purchaserService.findOneByUserId(LoginService.getPrincipal().getId());
		res.setArtworks(artworks);
		res.setPurchaser(purchaser);
		res.setTotalCost(0);
		return res;
	}

	public Cart findOne(int cartId) {
		return cartRepository.findOne(cartId);
	}

	public Collection<Cart> findAll() {
		return cartRepository.findAll();
	}

	public void save(Cart cart) {
		cartRepository.save(cart);
	}

	public void delete(Cart cart) {
		cartRepository.delete(cart);
	}

	// Other business methods
	public Cart findMyCart() {
		checkPurchaserRole();
		Cart res = new Cart();
		res = cartRepository.findMyCart(LoginService.getPrincipal().getId());
		return res;

	}

	public void addArtworkToCart(int artWorkId) {
		checkPurchaserRole();
		Artwork artWork;
		Cart cart;
		Purchaser purchaser;
		int userAccountId;
		int numberSales;
		Profit profit;
		Double taxValue;
		Double profitValue;
		Double totalCost;
		
		userAccountId=LoginService.getPrincipal().getId();
		artWork = artWorkService.findOne(artWorkId);
		
		// Número de ventas del artista
		numberSales=artistService.findNumberArtworkSoldByArtist(artWork.getArtist().getUserAccount().getId());
		profit=profitService.findProfitByNumberSales(numberSales);
		
		// Encontramos nuestro carrito
		cart = findMyCart();
				
		//Creamos el carrito si es nulo		
		if(cart==null){
			cart=create();
			cart=cartRepository.save(cart);
			purchaser=purchaserService.findOneByUserId(userAccountId);
			purchaser.setCart(cart);
			purchaserService.saveSimple(purchaser);
		}
		if(!cart.getArtworks().contains(artWork)){
			taxValue=artWork.getPrice()*((1 + (artWork.getTax().getValue()) / 100));
			profitValue=artWork.getPrice()*(profit.getValue())/100;
			totalCost=taxValue+profitValue;		
		
		totalCost = redondear(totalCost);
		cart.getArtworks().add(artWork);
		cart.setTotalCost(totalCost);
			
		artWork.getCarts().add(cart);
		artWorkService.saveSimple(artWork);
		}
	}

	public void deleteArtWorkOfCart(int artWorkId) {
		checkPurchaserRole();
		Double price;
		Cart cart;
		Artwork artWork;
		

		artWork = artWorkService.findOne(artWorkId);
		//Buscamos nuestro carrito
		cart = findMyCart();
		calculateTotalCost(cart);	
		
		//Liberamos asociación
		cart.getArtworks().remove(artWork);
		if(cart.getTotalCost()<0){
			cart.setTotalCost(0.0);
		}
		
		cart.setTotalCost(cart.getTotalCost());
		artWork.getCarts().remove(cart);
		artWorkService.saveSimple(artWork);
			
	
	}

	// All checks
	public void checkPurchaserRole() {

		Authority Purchaser = new Authority();
		Purchaser.setAuthority(Authority.PURCHASER);

		Assert.isTrue(LoginService.getPrincipal().getAuthorities().contains(Purchaser), "You're not an Purchaser user");
	}

	// Other methods

	public double redondear(double value) {
		return Math.rint(value * 100) / 100;
	}

	public Double calculateTotalCost(Cart cart) {
		checkPurchaserRole();
		Double profitValue=0.0;
		Double tax=0.0;
		Double res=0.0;
		int numberSales;
		Profit profit;
		Collection<Artwork> artworks=cart.getArtworks();
		for(Artwork a:artworks){
			numberSales=artistService.findNumberArtworkSoldByArtist(a.getArtist().getUserAccount().getId());
			tax=a.getPrice() + ((a.getPrice() * a.getTax().getValue()) / 100);
			profit=profitService.findProfitByNumberSales(numberSales);
			profitValue=(a.getPrice()*profit.getValue())/100;
			res=res+tax+profitValue;
			res=redondear(res);
		}
		return res;
	}

	


}
