package services;

import java.util.ArrayList;
import java.util.Collection;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import repositories.TaxRepository;
import domain.Artwork;
import domain.Tax;

@Service
@Transactional
public class TaxService {

	// Managed repository
	@Autowired
	private TaxRepository taxRepository;

	// Supporting services

	// Constructors
	public TaxService() {
		super();
	}

	// Simple CRUD methods
	public Tax create() {
		Tax result;
		Collection<Artwork> artworks;
		
		artworks = new ArrayList<Artwork>();
		
		result = new Tax();
		
		result.setArtworks(artworks);
		
		return result;
	}

	public Tax findOne(int taxId) {
		return taxRepository.findOne(taxId);
	}

	public Collection<Tax> findAll() {
		return taxRepository.findAll();
	}

	public void save(Tax tax) {
		taxRepository.save(tax);
	}

	public void delete(Tax tax) {
		taxRepository.delete(tax);
	}

	// Other business methods

	// All checks
	

}
