package com.yigit.domain.user;

import java.util.List;
import java.util.Objects;

public class Role {

	private Long id;
	private String name;
	private List<Privilege> privileges;
	private List<User> users; // Bir role sahip birden fazla user olabilir

	public Role() {

	}

	public Role(Long id, String name, List<Privilege> privileges, List<User> users) {

		this.id = id;
		this.name = name;
		this.privileges = privileges;
		this.users = users;
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

	public List<Privilege> getPrivileges() {
		return privileges;
	}

	public void setPrivileges(List<Privilege> privileges) {
		this.privileges = privileges;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
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
		Role other = (Role) obj;
		return Objects.equals(id, other.id);
	}

}
