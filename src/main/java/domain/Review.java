package domain;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Range;
import org.hibernate.validator.constraints.SafeHtml;
import org.hibernate.validator.constraints.SafeHtml.WhiteListType;

@Entity
@Access(AccessType.PROPERTY)
public class Review extends DomainEntity{
	
	// Constructors ---------------------
	
	public Review(){
		super();
	}
	
	// Attributes ------------------------
	
	private int Rating;
	private String description;
	@NotNull
	@Range(min = 0 , max = 10)
	public int getRating() {
		return Rating;
	}
	public void setRating(int rating) {
		Rating = rating;
	}
	@SafeHtml(whitelistType=WhiteListType.NONE)
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	// Relationships -----------------------------
	
	private Purchaser purchaser;
	private Artist artist;
	
	@Valid
	@NotNull
	@ManyToOne(optional=false)
	public Artist getArtist() {
		return artist;
	}
	public void setArtist(Artist artist) {
		this.artist = artist;
	}
	
	@Valid
	@NotNull
	@ManyToOne(optional=false)
	public Purchaser getPurchaser() {
		return purchaser;
	}
	public void setPurchaser(Purchaser purchaser) {
		this.purchaser = purchaser;
	}

}
