package domain;

import java.util.Collection;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Transient;

@Entity
@Access(AccessType.PROPERTY)
public class Cart extends DomainEntity {

	// Constructors ------------------

	public Cart() {
		super();
	}

	// Attributes ----------------------
	
	private double totalCost;
	
	@Transient
	@Min(0)
	public double getTotalCost() {
		return totalCost;
	}
	public void setTotalCost(double totalCost) {
		this.totalCost = totalCost;
	}
	
	// Relationships -----------------------------
	
	private Purchaser purchaser;
	private Collection<Artwork> artworks;
	
	@Valid
	@NotNull
	@OneToOne(optional=false)
	public Purchaser getPurchaser() {
		return purchaser;
	}
	public void setPurchaser(Purchaser purchaser) {
		this.purchaser = purchaser;
	}
	
	@Valid
	@NotNull
	@ManyToMany(cascade = { CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH,
			CascadeType.PERSIST })
	public Collection<Artwork> getArtworks() {
		return artworks;
	}

	public void setArtworks(Collection<Artwork> artworks) {
		this.artworks = artworks;
	}

}
