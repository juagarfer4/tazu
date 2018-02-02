package domain;


import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Range;

@Entity
@Access(AccessType.PROPERTY)
public class Profit extends DomainEntity{
	
	// Constructors ----------------------
	
	public Profit(){
		super();
	}
	
	// Attributes -----------------------
	
	private double value;
	private int lowerLimit;
	private int upperLimit;

	@NotNull
	@Range(min = 1 , max = 100)
	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}

	@NotNull
	@Min(0)
	public int getLowerLimit() {
		return lowerLimit;
	}

	public void setLowerLimit(int lowerLimit) {
		this.lowerLimit = lowerLimit;
	}

	@NotNull
	@Min(0)
	public int getUpperLimit() {
		return upperLimit;
	}

	public void setUpperLimit(int upperLimit) {
		this.upperLimit = upperLimit;
	}
	
	// Relationships -----------------------

}
