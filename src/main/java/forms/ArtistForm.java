package forms;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

import domain.Artist;

public class ArtistForm {

	private Artist artist;
	private boolean conditions;
	private String checkPassword;

	@Valid
	public Artist getArtist() {
		return artist;
	}

	public void setArtist(Artist artist) {
		this.artist = artist;
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
