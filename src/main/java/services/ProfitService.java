package services;

import java.util.Collection;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import domain.Profit;
import repositories.ProfitRepository;
import security.Authority;
import security.LoginService;

@Service
@Transactional
public class ProfitService {

	// Managed repository

	@Autowired
	private ProfitRepository profitRepository;

	// Supporting services
	
	
	// Constructors

	public ProfitService() {
		super();
	}

	// Simple CRUD methods

	public Profit create() {
		checkAdminRole();
		Profit res = new Profit();
		
		return res;
	}

	public Profit findOne(int profitId) {

		return profitRepository.findOne(profitId);
	}

	public Collection<Profit> findAll() {

		return profitRepository.findAll();
	}

	public void save(Profit profit) {
		checkAdminRole(); 	
		profitRepository.save(profit);
	}

	public void delete(Profit profit) {
		profitRepository.delete(profit);
		}

	

	
	public Profit findProfitByNumberSales(int numberSales) {
		checkPurchaserRole();
		Profit res;
		
		res=profitRepository.findProfitByNumberSales(numberSales);
		return res;
	}
	
	public Profit findProfitByNumberSalesByArtist(int numberSales) {
		Profit result;
		
		result = profitRepository.findProfitByNumberSales(numberSales);
		
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

		Assert.isTrue(LoginService.getPrincipal().getAuthorities().contains(Purchaser), "You're not an Purchaser user");
	}

	
}