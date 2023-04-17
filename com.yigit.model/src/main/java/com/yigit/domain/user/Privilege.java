package com.yigit.domain.user;

import java.util.List;
import java.util.Objects;

public class Privilege {

	private Long id;
	private String name;
	private List<Role> roles;

	public Privilege() {
		
	}

	public Privilege(String name, List<Role> roles) {
		this.name = name;
		this.roles = roles;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Privilege other = (Privilege) obj;
		return Objects.equals(id, other.id);
	}
	
	

}
