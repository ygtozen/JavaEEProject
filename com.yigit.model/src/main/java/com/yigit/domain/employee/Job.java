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
public class Job {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "job_id")
	private Long jobId;
	
	@Column
	private String jobTitle;
	
	@Column
	private double minSalary;
	
	@Column
	private double maxSalary;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "job")
	private List<Employee> employees; // TODO: Burda da employee ile bir bağ kurman gerekiyor, burada çalışan işçiler, bir job'da birden fazla işçi çalışabilir bu yüzden liste halinde tuttuk

	public Job() {

	}

	public Job(String jobTitle, double minSalary, double maxSalary, List<Employee> employees) {
		this.jobTitle = jobTitle;
		this.minSalary = minSalary;
		this.maxSalary = maxSalary;
		this.employees = employees;
	}

	public Long getJobId() {
		return jobId;
	}

	public void setJobId(Long jobId) {
		this.jobId = jobId;
	}

	public String getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	public double getMinSalary() {
		return minSalary;
	}

	public void setMinSalary(double minSalary) {
		this.minSalary = minSalary;
	}

	public double getMaxSalary() {
		return maxSalary;
	}

	public void setMaxSalary(double maxSalary) {
		this.maxSalary = maxSalary;
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

	@Override
	public int hashCode() {
		return Objects.hash(jobId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Job other = (Job) obj;
		return Objects.equals(jobId, other.jobId);
	}

}
