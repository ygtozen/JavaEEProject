package com.yigit.domain.employee;

import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Location {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "location_id", nullable = false, unique = true)
	private Long locationId;
	
	@Column(length = 25) // 25 karakter
	private String streetAddress; // Açık Adres
	
	@Column(name = "postal_code")
	private int postaCode;
	
	// Eğer hiçbir şey girmez isek hibernate default değerleri ile kolonu oluşturur
	private String city;
	
	// OneToMany - 1'e Çok
	// 1 tane location'a birden fazla departman gelebilir
	// Bu çok departman'ı bir colleciton yapısına atayacağız
	// Örneğin city'si balıkesir olan bir location'da 5 tane departman olsun bu departmanları list hakinde tutcağız.
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "location") // OneToMany-Bir locationda birden fazla departman olabilir
	private List<Department> departments; // Departmen'leri liste halinde tutmasını istedik - Bir location'da birden fazla departman olabilir bu yüzden liste halinde tutuyoruz
	
	// Cascade --> Bu location'da bir değişiklik yaptığımızda oana bağlı birimlerin yani buradaki örnekte departman'larda nasıl değişiklikler olacağını belirtiyoruz
	// Örneğin location'ımızın şehri balıkesir olsun departman'larımızda bu locationda bulununa software, tester,  network olsun.
	// Bu locaiton'u değişiklik yaptığımızda buradan departman'ların ne kadar etkileneceğini belirtiyoruz.
	// CascadeType.ALL
	// CascadeType.MERGE -> Bu locationda'daki bir güncellemede departman'lar etkilensin 
	// Burada locaitonda güncelleme işlemleri için o locationdaki bulunan departman'larda güncellemesine Cascade.ALL kullanarak izin verdik.
	// Eğer bu location'nu silersek bu locationa bağlı tüm departman'larda silme izni verdik. Eğer silme izni vermezsek ve bu locationu silersek veritabanından hata alırız.
	
	// mappedBy -> 
	// mappedBy kullanarak hangi class'ın diğeri üstünde olduğunu birinci sınıf class olduğunu belirtiyotuz.
	// mappedBy = "location" --> Departman class'ındaki location değişkenidir ismi aynı olmak zorundadır
	// Nedeni: birinci sınıf class bizim için departman olsun istedim ve departman tablosunda locatin foreing keyini eklemesini söyledik.
	
	// Location table
	// location_id - 	city - 		streetAddress
	// 1				Balıkesir 	
	// 2				Ankara
	
	// Departman table
	// departmenId 	- 	departmanName - 	locaitonId
	// 100				software			1(balıkesir)
	// 101				tester				2(ankara)
	// 102				network				2(ankara)

	
	
	public Location() {

	}

	// locationId'yi biz vermeyeceğiz, departmens listesi ise setmetoduyla vereceğiz
	public Location(String streetAddress, int postaCode, String city) {
		this.streetAddress = streetAddress;
		this.postaCode = postaCode;
		this.city = city;
	}

	// Getter and Setter
	public Long getLocationId() {
		return locationId;
	}

	public void setLocationId(Long locationId) {
		this.locationId = locationId;
	}

	public String getStreetAddress() {
		return streetAddress;
	}

	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}

	public int getPostaCode() {
		return postaCode;
	}

	public void setPostaCode(int postaCode) {
		this.postaCode = postaCode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public List<Department> getDepartments() {
		return departments;
	}

	public void setDepartments(List<Department> departments) {
		this.departments = departments;
	}

	@Override
	public int hashCode() {
		return Objects.hash(locationId);
	}

	// Hascode
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Location other = (Location) obj;
		return Objects.equals(locationId, other.locationId);
	}

}
