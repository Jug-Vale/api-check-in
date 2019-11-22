package com.jugvale.api.checkin.application.request;

import java.io.Serializable;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.jugvale.api.checkin.domain.Credential;

public final class CheckinRequest implements Serializable {

	private static final long serialVersionUID = 1L;

	@NotNull
	@NotBlank
	private String name;
	@NotNull
	@NotBlank
	@Email
	private String email;
	
	public CheckinRequest() {}
	
	public Credential toCredential() {
		return Credential.of(this.name.toUpperCase(), this.email);
	}
	
	public void setName(final String name) {
		this.name = name;
	}
	
	public void setEmail(final String email) {
		this.email = email;
	}
	
	public String getEmail() {
		return email;
	}
	
	public String getName() {
		return name;
	}
}
