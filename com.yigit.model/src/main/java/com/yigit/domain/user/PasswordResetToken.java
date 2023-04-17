package com.yigit.domain.user;

import java.util.Calendar;
import java.util.Date;
import java.util.Objects;

public class PasswordResetToken {

	private final int EXPIRY_DATE = 60 * 24;
	private Long id;
	private String token;
	private User user;
	private Date expiryDate;

	public PasswordResetToken() {
		this.expiryDate = calculateExpiryDate(EXPIRY_DATE);
	}

	public PasswordResetToken(String token, User user) {
		this.user = user;
		this.token = token;
		this.expiryDate = calculateExpiryDate(EXPIRY_DATE);
	}

	private Date calculateExpiryDate(int eXPIRY_DATE2) {

		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(new Date().getTime());
		calendar.add(Calendar.MINUTE, eXPIRY_DATE2);

		return new Date(calendar.getTime().getTime());
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Date getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}

	public int getEXPIRY_DATE() {
		return EXPIRY_DATE;
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
		PasswordResetToken other = (PasswordResetToken) obj;
		return Objects.equals(id, other.id);
	}

}
