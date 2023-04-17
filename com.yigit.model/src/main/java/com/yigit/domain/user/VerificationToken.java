package com.yigit.domain.user;

import java.util.Calendar;
import java.util.Date;
import java.util.Objects;

public class VerificationToken {

	private final int EXPIRY_DATE = 60*24;  // Her bir token'in süresini tutacak değer - sonlanma süresi 60 dk * 24 saat = 1 gün
	
	private Long id; // Her token veri tabanında saklanırken bir primary ke'i olsun id
	
	private User user; // Her bir token'i user ile bağlamamız lazım bu token saklandığında user'a ait bilgide saklanması lazım
	
	private String token; // Token'i tutacak
	
	private Date expiryDate; // Sonlanma tarihi

	public VerificationToken() {
		this.expiryDate = calculateExpiryDate(EXPIRY_DATE);
	}

	public VerificationToken(User user, String token) {

		this.user = user;
		this.token = token;
		this.expiryDate = calculateExpiryDate(EXPIRY_DATE); // Token oluşturma tarihinin 24 saat sonrasına göre ayarlandı
	}

	private Date calculateExpiryDate(int eXPIRY_DATE2) {
		
		// Kullanıcı hengi tarihte kayıt olduysa bir tane token göndericek o tokeninde süresi buradaki expiryDate süresi kadar yani 24 saat geçerli olucak
		
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(new Date().getTime()); // Şu anki tarihi verdik
		calendar.add(Calendar.MINUTE, eXPIRY_DATE2); // Şu anki tarih üstüne bir tarhi ekliycez
		
		return new Date(calendar.getTime().getTime());
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
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
		VerificationToken other = (VerificationToken) obj;
		return Objects.equals(id, other.id);
	}
	
}
