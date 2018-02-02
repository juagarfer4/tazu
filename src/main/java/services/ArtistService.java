package services;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import domain.Artist;
import domain.Artwork;
import domain.Order;
import domain.OrderLine;
import domain.Review;
import forms.ArtistForm;
import repositories.ArtistRepository;
import security.Authority;
import security.LoginService;
import security.UserAccount;

@Service
@Transactional
public class ArtistService {

	// Managed repository
	@Autowired
	private ArtistRepository artistRepository;

	// Supporting services
	@Autowired
	private ArtworkService artworkService;
	@Autowired
	private ReviewService reviewService;

	// Constructors
	public ArtistService() {
		super();
	}

	// Simple CRUD methods
	public Artist create() {
		Artist res;
		UserAccount userAccount;
		Authority authority;
		Collection<Review> reviews;
		Collection<Artwork> artworks;

		res = new Artist();
		userAccount = new UserAccount();
		authority = new Authority();
		reviews = new ArrayList<Review>();
		artworks = new ArrayList<Artwork>();

		authority.setAuthority("ARTIST");
		userAccount.getAuthorities().add(authority);
		res.setUserAccount(userAccount);
		res.setReviews(reviews);
		res.setArtworks(artworks);

		return res;
	}

	public void save(Artist artist) {

		Md5PasswordEncoder encoder;
		String unencryptedPassword;
		String encryptedPassword;

		encoder = new Md5PasswordEncoder();
		unencryptedPassword = artist.getUserAccount().getPassword();
		encryptedPassword = encoder.encodePassword(unencryptedPassword, null);

		artist.getUserAccount().setPassword(encryptedPassword);

		artistRepository.save(artist);

	}

	public void delete(Artist artist) {
		artistRepository.delete(artist);
	}

	public Artist findOne(int artistId) {
		return artistRepository.findOne(artistId);
	}

	public Collection<Artist> findAll() {
		return artistRepository.findAll();
	}

	// Other methods

	public ArtistForm construct() {
		ArtistForm res;
		Artist artist;

		res = new ArtistForm();
		artist = create();

		res.setArtist(artist);

		return res;
	}

	public void deconstruct(ArtistForm artistForm) {
		Artist artist;

		artist = artistForm.getArtist();

		// Comprueba que las contraseñas coinciden
		String password;
		String checkPassword;

		password = artistForm.getArtist().getUserAccount().getPassword();
		checkPassword = artistForm.getCheckPassword();

		Assert.isTrue(password.equals(checkPassword),
				"customer.error.checkPassword");

		// Check accepted terms
		Assert.isTrue(artistForm.getConditions(), "customer.error.terms");

		save(artist);

	}

	// Método para permitir comentar solo a artistas que hayamos comprado y no
	// hayamos
	// comentado anteriormente
	public Collection<Artist> findArtistCouldBeCommentedByPurchaser() {

		checkPurchaserRole();
		Set<Artist> res = new HashSet<Artist>();
		Set<Artist> aux = new HashSet<Artist>();
		Collection<Artwork> artworks = artworkService
				.findArtWorkPurchasedByMe();
		Collection<Review> myReviews = reviewService.findMyReviews();
		for (Artwork a : artworks) {
			res.add(a.getArtist());
		}
		for (Review r : myReviews) {
			aux.add(r.getArtist());
		}
		res.removeAll(aux);
		return res;
	}

	// The artist with the highest rate
	public Collection<Artist> findHighestRateArtists() {
		Collection<Artist> result;

		result = artistRepository.findHighestRateArtists();

		return result;
	}

	// The rating of the artist with the highest rate
	public Double findNumberHighestRateArtists() {
		Double result;

		result = artistRepository.findNumberHighestRateArtists();

		return result;
	}

	// The artist who has sold more artworks
	public Collection<Artist> findMoreArtworksSoldArtists() {
		Collection<Artist> result;

		result = artistRepository.findMoreArtworksSoldArtists();

		return result;
	}

	// The artist who has earned more money
	public Collection<Artist> findArtistEarnedMoreMoney() {
		Collection<Artist> result;

		result = artistRepository.findArtistEarnedMoreMoney();

		return result;
	}

	// The quantity of money who has earned the artist who has earned more money
	public Double findQuantityArtistEarnedMoreMoney() {
		Double result;
		ArrayList<Object> list;

		result = 0.0;
		list = artistRepository.findQuantityArtistEarnedMoreMoney();

		for (int i = 0; i < list.size(); i++) {
			if ((Double) list.get(i) > result) {
				result = (Double) list.get(i);
			}
		}

		return result;
	}

	// Update and save the average of rating of the artist
	public void saveAverage(Artist artist) {
		checkPurchaserRole();
		Double rating;
		rating = artistRepository.updateAverage(artist.getId());
		rating = rating / 100;
		artist.setRating(rating);
		artistRepository.save(artist);
	}

	// The quantity of artwork that an artist has sold
	public Integer findNumberArtworkSoldByArtist(int userAccountId) {
		checkPurchaserRole();
		Integer res = 0;
		res = artistRepository.findNumberArtworkSoldByArtist(userAccountId);
		return res;
	}

	public Collection<Artist> findArtistByKeywork(String keyword) {
		Collection<Artist> res;
		res = artistRepository.findArtistByKeywork(keyword);
		return res;
	}

	public Collection<Artist> findArtistsByOrder(Order order) {
		Collection<Artwork> artworks;
		Artwork artwork;
		Collection<Artist>artists;
		
		artworks= new ArrayList<Artwork>();
		artists= new ArrayList<Artist>();
		// Debemos de actualizar todos los precios de las obras de los artistas
		for (OrderLine ol : order.getOrderLines()) {
			artwork = artworkService.findByTicker(ol.getTicker());
			artworks.add(artwork);
		}

		for (Artwork a : artworks) {
			if (!artists.contains(a.getArtist())) {
				artists.add(a.getArtist());
			}
		}
		return artists;
	}
	
	

	// All checks

	public void checkAdminRole() {
		Authority admin = new Authority();
		admin.setAuthority(Authority.ADMINISTRATOR);

		Assert.isTrue(
				LoginService.getPrincipal().getAuthorities().contains(admin),
				"You're not an ADMIN user");
	}

	public void checkPurchaserRole() {

		Authority Purchaser = new Authority();
		Purchaser.setAuthority(Authority.PURCHASER);

		Assert.isTrue(
				LoginService.getPrincipal().getAuthorities()
						.contains(Purchaser), "You're not an Purchaser user");
	}

	public Artist checkPrincipal() {
		UserAccount principalUserAccount;
		Artist customer;

		principalUserAccount = LoginService.getPrincipal();
		customer = artistRepository.findByUserAccount(principalUserAccount);

		Assert.notNull(customer);

		return customer;
	}

}
