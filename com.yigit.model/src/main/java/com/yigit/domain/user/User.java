package com.yigit.domain.user;

import java.util.Objects;

public class User {

	private Long id;
	private String firstName;
	private String lastName;
	private String username;
	private String email;
	private String password;
	private boolean enabled;
	private boolean accountNonExpired; // user hesabı sonlandırılmışmı
	private boolean credentialNonExpired; // kimlik sonlandırılmışmı
	private boolean accountNonLocked; // hesap kitlenmişmi

	private Role role; // Her user'ın bir tane rolü var o yüzden liste hakinde tutmadık

	public User() {

		// ilk user oluştuğunda enabled akitif olmasın false olsun
		this.enabled = false;

		// İlk user oluştuğunda bu değerler true gelsin
		this.accountNonExpired = true;
		this.credentialNonExpired = true;
		this.accountNonLocked = true;
	}

	public User(String firstName, String lastName, String username, String email, String password, Role role) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.email = email;
		this.password = password;
		this.role = role;

		// ilk user oluştuğunda enabled akitif olmasın false olsun
		this.enabled = false;

		// İlk user oluştuğunda bu değerler true gelsin
		this.accountNonExpired = true;
		this.credentialNonExpired = true;
		this.accountNonLocked = true;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public boolean isAccountNonExpired() {
		return accountNonExpired;
	}

	public void setAccountNonExpired(boolean accountNonExpired) {
		this.accountNonExpired = accountNonExpired;
	}

	public boolean isCredentialNonExpired() {
		return credentialNonExpired;
	}

	public void setCredentialNonExpired(boolean credentialNonExpired) {
		this.credentialNonExpired = credentialNonExpired;
	}

	public boolean isAccountNonLocked() {
		return accountNonLocked;
	}

	public void setAccountNonLocked(boolean accountNonLocked) {
		this.accountNonLocked = accountNonLocked;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, username);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(id, other.id) && Objects.equals(username, other.username);
	}
	
	

}
