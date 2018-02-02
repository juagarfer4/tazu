package services;

import java.util.ArrayList;
import java.util.Collection;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import domain.Artwork;
import domain.Order;
import domain.Purchaser;
import domain.Review;
import forms.PurchaserForm;
import repositories.PurchaserRepository;
import security.Authority;
import security.LoginService;
import security.UserAccount;

@Service
@Transactional
public class PurchaserService {

	// Managed repository
	@Autowired
	private PurchaserRepository purchaserRepository;

	// Supporting services

	// Constructors
	public PurchaserService() {
		super();
	}

	// Simple CRUD methods
	public Purchaser create() {
		Purchaser res;
		UserAccount userAccount;
		Authority authority;
		Collection<Review> reviews;
		Collection<Order> orders;

		res = new Purchaser();
		userAccount = new UserAccount();
		authority = new Authority();
		reviews = new ArrayList<Review>();
		orders = new ArrayList<Order>();

		authority.setAuthority("PURCHASER");
		userAccount.getAuthorities().add(authority);
		res.setUserAccount(userAccount);
		res.setReviews(reviews);
		res.setOrders(orders);

		return res;
	}

	public void save(Purchaser purchaser) {

		Md5PasswordEncoder encoder;
		String unencryptedPassword;
		String encryptedPassword;

		encoder = new Md5PasswordEncoder();
		unencryptedPassword = purchaser.getUserAccount().getPassword();
		encryptedPassword = encoder.encodePassword(unencryptedPassword, null);

		purchaser.getUserAccount().setPassword(encryptedPassword);
		purchaserRepository.save(purchaser);
	}
	
	public void saveSimple(Purchaser purchaser) {
		purchaserRepository.save(purchaser);
	}
	public void delete(Purchaser purchaser) {
		purchaserRepository.delete(purchaser);
	}

	public Purchaser findOne(int purchaserId) {
		return purchaserRepository.findOne(purchaserId);
	}

	public Collection<Purchaser> findAll() {
		checkAdminRole();
		return purchaserRepository.findAll();
	}

	// Other methods

	public PurchaserForm construct() {
		PurchaserForm res;
		Purchaser purchaser;

		res = new PurchaserForm();
		purchaser = create();

		res.setPurchaser(purchaser);

		return res;
	}

	public void deconstruct(PurchaserForm purchaserForm) {
		Purchaser purchaser;

		purchaser = purchaserForm.getPurchaser();

		// Comprueba que las contraseñas coinciden
		String password;
		String checkPassword;

		password = purchaserForm.getPurchaser().getUserAccount().getPassword();
		checkPassword = purchaserForm.getCheckPassword();

		Assert.isTrue(password.equals(checkPassword), "customer.error.checkPassword");

		// Check accepted terms
		Assert.isTrue(purchaserForm.getConditions(), "customer.error.terms");

		save(purchaser);

	}
	// Find purchaser by his userAccount
	public Purchaser findOneByUserId(int purchaserId) {
		return purchaserRepository.findOneByUserId(purchaserId);
	}
	// The purchaser who has spent more money
	public Collection<Object> findPurchaserSpendMoreMoney(){
		checkAdminRole();
		Collection<Object> res=new ArrayList<Object>();
		res=purchaserRepository.findPurchaserSpendMoreMoney();
		return res;
	}
	// The purchaser who has purchased more artworks. 
	public 	Collection<Purchaser> findPurchaserMoreArtworkBought(){
		checkAdminRole();
		Collection<Purchaser> res=new ArrayList<Purchaser>();
		res=purchaserRepository.findPurchaserMoreArtworkBought();
		return res;
	}
	

	// All checks

	public void checkAdminRole() {
		Authority admin = new Authority();
		admin.setAuthority(Authority.ADMINISTRATOR);

		Assert.isTrue(LoginService.getPrincipal().getAuthorities().contains(admin), "You're not an ADMIN user");
	}

}
