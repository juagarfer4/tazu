package forms;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

import domain.Purchaser;

public class PurchaserForm {

	private Purchaser purchaser;
	private boolean conditions;
	private String checkPassword;

	@Valid
	public Purchaser getPurchaser() {
		return purchaser;
	}

	public void setPurchaser(Purchaser purchaser) {
		this.purchaser = purchaser;
	}

	@NotNull
	public boolean getConditions() {
		return conditions;
	}

	public void setConditions(boolean conditions) {
		this.conditions = conditions;
	}

	@NotBlank
	public String getCheckPassword() {
		return checkPassword;
	}

	public void setCheckPassword(String checkPassword) {
		this.checkPassword = checkPassword;
	}

}
