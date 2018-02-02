package services;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import domain.Artist;
import domain.Purchaser;
import domain.Review;
import repositories.ReviewRepository;
import security.Authority;
import security.LoginService;

@Service
@Transactional
public class ReviewService {

	// Managed repository

	@Autowired
	private ReviewRepository reviewRepository;

	// Supporting services
	@Autowired
	private PurchaserService purchaserService;
	
	@Autowired
	private ArtistService artistService;

	// Constructors

	public ReviewService() {
		super();
	}

	// Simple CRUD methods

	public Review create(Integer artistId) {
		checkPurchaserRole();
		Review res = new Review();
		int purchaserId = LoginService.getPrincipal().getId();
		Purchaser purchaser = purchaserService.findOneByUserId(purchaserId);
		res.setPurchaser(purchaser);
		
		Artist artist;
		
		artist = artistService.findOne(artistId);
		
		Assert.notNull(artist);
		
		res.setArtist(artist);
		
		return res;
	}

	public Review findOne(int reviewId) {

		return reviewRepository.findOne(reviewId);
	}

	public Collection<Review> findAll() {

		return reviewRepository.findAll();
	}

	public void save(Review review) {
		checkPurchaserRole();
		reviewRepository.save(review);
	}

	public void delete(Review review) {
		reviewRepository.delete(review);
	}

	// Other business methods

	public Collection<Review> findReviewsOfPurchaser(int purchaserId) {
		checkAdminRole();
		Collection<Review> res = new ArrayList<Review>();
		res = reviewRepository.findReviewsOfPurchaser(purchaserId);
		return res;
	}

	public Collection<Review> findMyReviews() {
		checkPurchaserRole();
		Collection<Review> res = new ArrayList<Review>();
		res = reviewRepository.findMyReviews(LoginService.getPrincipal().getId());
		return res;
	}
	
	public Collection<Review> findReviewsOfArtist() {
		checkArtistRole();
		Collection<Review> res = new ArrayList<Review>();
		res = reviewRepository.findReviewsOfArtist(LoginService.getPrincipal().getId());
		return res;
	}

	public List<Integer> getRatingNumbers() {
		List<Integer> res = new ArrayList<Integer>();

		for (int i = 0; i <= 10; i++)
			res.add(i);

		return res;
	}
	
	public Collection<Review> findAllReviewsByArtist(Integer artistId){
		Collection<Review> result;
		
		result = reviewRepository.findAllReviewsByArtist(artistId);
		
		return result;
	}

	// All checks----------------------------------------------------------

	public void checkAdminRole() {

		Authority admin = new Authority();
		admin.setAuthority(Authority.ADMINISTRATOR);

		Assert.isTrue(LoginService.getPrincipal().getAuthorities().contains(admin), "You're not an ADMIN user");
	}

	public void checkPurchaserRole() {

		Authority Purchaser = new Authority();
		Purchaser.setAuthority(Authority.PURCHASER);

		Assert.isTrue(LoginService.getPrincipal().getAuthorities().contains(Purchaser), "You're not an PURCHASER user");
	}
	
	public void checkArtistRole() {

		Authority artist = new Authority();
		artist.setAuthority(Authority.ARTIST);

		Assert.isTrue(LoginService.getPrincipal().getAuthorities().contains(artist), "You're not an ARTIST user");
	}
}