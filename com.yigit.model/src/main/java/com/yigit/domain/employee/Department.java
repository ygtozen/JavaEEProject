package com.yigit.domain.employee;

import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Department {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "department_id")
	private Long departmentId;
	
	@Column
	private String departmentName;
	
	@ManyToOne(targetEntity = Location.class, fetch = FetchType.LAZY) // Birden fazka departman bir locationda olabilir - Location.class -> Location class'ından geliyor, fetch ->
	@JoinColumn(name = "location_id", foreignKey = @ForeignKey(foreignKeyDefinition = "location_id")) // Bu location'un departman tablosuna ekleneceği adı veriyorum
	private Location location; // Bir departman(software departman) sadece bir location'da olabilir o yüzde liste halinde tutmuyoruz
	
	// fetch = FetchType.LAZY --> Veritabanımıza hibernate kullanarak departman tablosuna select attığımızda o tabloya bağlı tablolarada gelip gelmeyeceğini 
	// FetchType kullanarak belirtiyoruz.
	// Benm depertman tablosuna select attığım zaman location'ında gelip gelmeyeceğini belirliyorum
	//  Bir departmanda birden fazla işçi çalışabilir, o yüzden liste halinde tutyoruz
	// LAZY -> Veritabanında departman nesnesini çağrıdım zaman location gelmeyecek
	// EAGER -> Biz departmen'i çağırdığımızda ona bağlı location nesnesi hibernate bizim için arka tarafta sorgu atıp o locationu bulup department listesine yüklü bir şekilde getiriyor.
	
	// Department departmen = sorgu 
	// departman.getLocation() Lazy olduğunda location'nu alamayız
	// eager olduğunda location'nu alabiliriz. Location location = departmen.getLocation();
	// location'da getCity gibi şeyleri alabiliriz
	// Eğer FetchType kullanmazsak hibernate sorgu sırasında bir session açıyor 
	// entityManager.getTransaction.begin() dediğimiz zaman session açılıyor
	
	// Department department = sorgu;
	// departmant.getLocation() dediğimizde çekeriz
	
	// entityManager.close() dediğimizde session kapanıyor
	// Ama session kapandığında gelemez (Detached Error alırız)
	
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "department")
	private List<Employee> employees; // Bir departman'da bir den fazla çalışan olabilir

	public Department() {
	}

	public Department(String departmentName, Location location, List<Employee> employees) {
		this.departmentName = departmentName;
		this.location = location;
		this.employees = employees;
	}

	public Long getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(Long departmentId) {
		this.departmentId = departmentId;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

	@Override
	public int hashCode() {
		return Objects.hash(departmentId);
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
		Department other = (Department) obj;
		return Objects.equals(departmentId, other.departmentId);
	}

}
