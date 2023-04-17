package com.yigit.domain.employee;

import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long employeeId;
	
	@Column
	private String firstName;
	
	@Column
	private String lastName;
	
	@Column
	private String email;
	
	@Column
	private String phoneNumber;
	
	@Temporal(TemporalType.DATE) // sadece tarih  - temporal db'de hangi formatta tutulacağını belirtik - sadece tarih - saat - dk gibi
	private Date hireDate; // İşe başlama tarihi
	
	@ManyToOne(fetch = FetchType.LAZY, targetEntity = Job.class)
	@JoinColumn(name = "job_id", foreignKey = @ForeignKey(foreignKeyDefinition = "job_fk"))
	private Job job; // Her employee bir işte çalışabildiği için liste içinde tutmuyoruz.
	
	@ManyToOne(fetch = FetchType.LAZY, targetEntity = Department.class)
	@JoinColumn(name = "department_id", foreignKey = @ForeignKey(foreignKeyDefinition = "department_fk"))
	private Department department; // Birden fazla employee aynı departmanda çalışbilir bu yüzden liste halinde değilde tutmuyoruz.

	public Employee() {

	}

	public Employee(String firstName, String lastName, String email, String phoneNumber, Date hireDate, Job job, Department department) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.hireDate = hireDate;
		this.job = job;
		this.department = department;
	}

	public Long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Date getHireDate() {
		return hireDate;
	}

	public void setHireDate(Date hireDate) {
		this.hireDate = hireDate;
	}

	public Job getJob() {
		return job;
	}

	public void setJob(Job job) {
		this.job = job;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	@Override
	public int hashCode() {
		return Objects.hash(employeeId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		return Objects.equals(employeeId, other.employeeId);
	}
	
	

}
