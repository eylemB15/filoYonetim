package com.springFilo.springFiloYonetim.models;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper=false)
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Employee extends Person {
	
	private Integer employeetypeid;
	private String photo;
	private String username;
	private Integer jobtitleid;
	
	@ManyToOne
	@JoinColumn(name="employeetypeid", insertable=false, updatable=false)
	private EmployeeType employeeType;
	
	
	@ManyToOne
	@JoinColumn(name="jobtitleid", insertable=false, updatable=false)
	private JobTitle jobTitle;
	
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")	
	private Date hireDate;


	public Integer getEmployeetypeid() {
		return employeetypeid;
	}


	public void setEmployeetypeid(Integer employeetypeid) {
		this.employeetypeid = employeetypeid;
	}


	public String getPhoto() {
		return photo;
	}


	public void setPhoto(String photo) {
		this.photo = photo;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public Integer getJobtitleid() {
		return jobtitleid;
	}


	public void setJobtitleid(Integer jobtitleid) {
		this.jobtitleid = jobtitleid;
	}


	public EmployeeType getEmployeeType() {
		return employeeType;
	}


	public void setEmployeeType(EmployeeType employeeType) {
		this.employeeType = employeeType;
	}


	public JobTitle getJobTitle() {
		return jobTitle;
	}


	public void setJobTitle(JobTitle jobTitle) {
		this.jobTitle = jobTitle;
	}


	public Date getHireDate() {
		return hireDate;
	}


	public void setHireDate(Date hireDate) {
		this.hireDate = hireDate;
	}
	
	
}
