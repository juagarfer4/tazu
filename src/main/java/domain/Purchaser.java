package domain;

import java.util.Collection;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.SafeHtml;
import org.hibernate.validator.constraints.SafeHtml.WhiteListType;

@Entity
@Access(AccessType.PROPERTY)
public class Purchaser extends Customer{
	
	// Constructors ------------------
	
	public Purchaser(){
		super();
	}
	
	// Attributes -----------------
	
	private String companyName;

	@SafeHtml(whitelistType=WhiteListType.NONE)
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	
	// Relationships -------------------------
	
	private Collection<Review> reviews;
	private Collection<Order> orders;
	private Cart cart;
	
	@Valid
	@NotNull
	@OneToMany(mappedBy = "purchaser")
	public Collection<Review> getReviews() {
		return reviews;
	}
	public void setReviews(Collection<Review> reviews){
		this.reviews = reviews;
	}
	
	@Valid
	@NotNull
	@OneToMany(mappedBy = "purchaser")
	public Collection<Order> getOrders() {
		return orders;
	}
	public void setOrders(Collection<Order> orders){
		this.orders = orders;
	}
	
	@OneToOne(cascade = CascadeType.ALL)
	@Valid
	public Cart getCart(){
		return cart;
	}
	public void setCart(Cart cart){
		this.cart = cart;
	}

}
