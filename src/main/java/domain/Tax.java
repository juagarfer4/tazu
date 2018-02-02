package domain;

import java.util.Collection;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.Range;
import org.hibernate.validator.constraints.SafeHtml;
import org.hibernate.validator.constraints.SafeHtml.WhiteListType;

@Entity
@Access(AccessType.PROPERTY)
public class Tax extends DomainEntity{
	
	// Constructors ------------------

	public Tax() {
			super();
	}
	
	// Attributes ----------------------
	
	private String name;
	private double value;
	
	@NotBlank
	@SafeHtml(whitelistType=WhiteListType.NONE)
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@NotNull
	@Range(min = 1 , max = 100)
	public double getValue() {
		return value;
	}
	public void setValue(double value) {
		this.value = value;
	}
	
	// Relationships ----------------------
	
	private Collection<Artwork> artworks;

	@Valid
	@NotNull
	@OneToMany(mappedBy = "tax")
	public Collection<Artwork> getArtworks() {
		return artworks;
	}
	public void setArtworks(Collection<Artwork> artworks){
		this.artworks = artworks;
	}

}
