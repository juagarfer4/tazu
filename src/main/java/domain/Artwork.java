package domain;

import java.util.Collection;
import java.util.Date;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.Valid;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.SafeHtml;
import org.hibernate.validator.constraints.SafeHtml.WhiteListType;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Access(AccessType.PROPERTY)
public class Artwork extends DomainEntity{
	
	// Constructors -----------------
	
	public Artwork(){
		super();
	}
	
	// Attributes ---------------------
	
	private String ticker;
	private String title;
	private String discipline;
	private String description;
	private double height;
	private double width;
	private Date moment;
	private Status status;
	private double price;
	private double totalCost;
	private String tags;
	private Boolean deleted;
	private byte[] picture;
	
	@Column(unique = true)
	@NotBlank
	@SafeHtml(whitelistType=WhiteListType.NONE)
	public String getTicker() {
		return ticker;
	}
	public void setTicker(String ticker) {
		this.ticker = ticker;
	}
	@NotBlank
	@SafeHtml(whitelistType=WhiteListType.NONE)
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	@NotBlank
	@SafeHtml(whitelistType=WhiteListType.NONE)
	public String getDiscipline() {
		return discipline;
	}
	public void setDiscipline(String discipline) {
		this.discipline = discipline;
	}
	@SafeHtml(whitelistType=WhiteListType.NONE)
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@NotNull
	@Min(0)
	public double getHeight() {
		return height;
	}
	public void setHeight(double height) {
		this.height = height;
	}
	@NotNull
	@Min(0)
	public double getWidth() {
		return width;
	}
	public void setWidth(double width) {
		this.width = width;
	}
	@NotNull
	@Past
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	public Date getMoment() {
		return moment;
	}
	public void setMoment(Date moment) {
		this.moment = moment;
	}
	@Valid
	@NotNull
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	@Min(0)
	@Digits(integer = 9, fraction = 2)
	@NotNull
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	@NotNull
	public double getTotalCost() {
		return totalCost;
	}
	public void setTotalCost(double totalCost) {
		this.totalCost = totalCost;
	}
	@SafeHtml(whitelistType=WhiteListType.NONE)
	public String getTags() {
		return tags;
	}
	public void setTags(String tags) {
		this.tags = tags;
	}
	@NotNull
	public Boolean getDeleted() {
		return deleted;
	}
	public void setDeleted(Boolean deleted) {
		this.deleted = deleted;
	}
	@Lob
	public byte[] getPicture() {
		return picture;
	}
	public void setPicture(byte[] picture) {
		this.picture = picture;
	}
	
	@Transient
	public boolean getNotNullPicture(){
		boolean result;
		result =true;
		if (this.getPicture().length == 0){
			result =false;
		}
		else if (this.getPicture() == null ){
			result =false;
		}else{
			result =true;
		}
		return result;
	}
	
	// Relationships ----------------------------
	
	private Artist artist;
	private Collection<Cart> carts;
	private Tax tax;
	
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
	public Tax getTax() {
		return tax;
	}
	public void setTax(Tax tax) {
		this.tax = tax;
	}
	
	@Valid
	@ManyToMany(mappedBy="artworks")
	public Collection<Cart> getCarts() {
		return carts;
	}
	public void setCarts(Collection<Cart> carts) {
		this.carts = carts;
	}
	
	
	
}
