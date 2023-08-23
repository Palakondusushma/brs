package springboot.namabus.entities;

import org.springframework.security.core.authority.SimpleGrantedAuthority;

public enum UserRoles {

	ADMIN, CUSTOMER;

	public String authority() {

		return "ROLE_" + this.name();

	}

	public SimpleGrantedAuthority authorityEnum() {

		return new SimpleGrantedAuthority(this.authority());

	}

}