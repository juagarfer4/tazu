package domain;

import java.util.Collection;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Range;
import org.springframework.data.annotation.Transient;

@Entity
@Access(AccessType.PROPERTY)
public class Artist extends Customer{
	
	// Constructors -----------------------------
	
	public Artist(){
		super();
	}
	
	// Attributes --------------------------
	
	private double rating;
	
	@Transient
	@Range(min = 0 , max = 10)
	public double getRating() {
		return rating;
	}
	public void setRating(double rating) {
		this.rating = rating;
	}
	
	// Relationships --------------------------------
	
	private Collection<Artwork> artworks;
	private Collection<Review> reviews;

	@Valid
	@NotNull
	@OneToMany(mappedBy = "artist")
	public Collection<Artwork> getArtworks() {
		return artworks;
	}

	public void setArtworks(Collection<Artwork> artworks) {
		this.artworks = artworks;
	}
	
	@Valid
	@NotNull
	@OneToMany(mappedBy = "artist")
	public Collection<Review> getReviews() {
		return reviews;
	}

	public void setReviews(Collection<Review> reviews) {
		this.reviews = reviews;
	}

}
