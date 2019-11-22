package com.jugvale.api.checkin.domain;

import java.io.Serializable;
import java.util.Objects;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import io.azam.ulidj.ULID;

@Document(collection = "credentials")
public final class Credential implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	private String id = ULID.random();
	private String name;
	@Indexed(unique = true)
	private String email;
	
	private Credential(final String name, final String email) {
		super();
		this.name = name;
		this.email = email;
	}
	
	public static Credential of(final String name, final String email) {
		return new Credential(name, email);
	}
	
	public String getId() {
		return id;
	}
	
	public String getEmail() {
		return email;
	}
	
	public String getName() {
		return name;
	}

	@Override
	public int hashCode() {
		return Objects.hash(email, id, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Credential other = (Credential) obj;
		return Objects.equals(email, other.email) && Objects.equals(id, other.id) && Objects.equals(name, other.name);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Credential [id=").append(id).append(", name=").append(name).append(", email=").append(email)
				.append("]");
		return builder.toString();
	}
}
