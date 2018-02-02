package domain;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.Valid;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.Range;
import org.hibernate.validator.constraints.SafeHtml;
import org.hibernate.validator.constraints.SafeHtml.WhiteListType;

@Entity
@Access(AccessType.PROPERTY)
public class OrderLine extends DomainEntity{
	
	// Constructors -------------------------
	
	public OrderLine(){
		super();
	}
	
	// Attributes --------------------------
	
	private String ticker;
	private String title;
	private double totalCost;
	private double profit;
	
	@NotBlank
	@Column(unique = true)
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
	@Min(0)
	@Digits(integer = 9, fraction = 2)
	@NotNull
	public double getTotalCost() {
		return totalCost;
	}
	public void setTotalCost(double totalCost) {
		this.totalCost = totalCost;
	}
	
	@NotNull
	@Range(min = 1 , max = 100)
	public double getProfit() {
		return profit;
	}
	public void setProfit(double profit) {
		this.profit = profit;
	}
	
	// Relationships -----------------------------
	
	private Order order;

	@NotNull
	@Valid
	@ManyToOne(optional=false)
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}

}
