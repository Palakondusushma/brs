package springboot.busnama.dto;

import java.util.Set;

import springboot.namabus.entities.UserRoles;

public class UserDTO {

	private String username;

	private String password;

	private Set<UserRoles> roles;

	public UserDTO() {

	}

	public UserDTO(String username, String password, Set<UserRoles> roles) {

		this.username = username;

		this.password = password;

		this.roles = roles;

	}

	public String getUsername() {

		return username;

	}

	public void setUsername(String username) {

		this.username = username;

	}

	public String getPassword() {

		return password;

	}

	public void setPassword(String password) {

		this.password = password;

	}

	public Set<UserRoles> getRoles() {

		return roles;

	}

	public void setRoles(Set<UserRoles> roles) {

		this.roles = roles;

	}

}