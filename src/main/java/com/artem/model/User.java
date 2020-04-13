package com.artem.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "user")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(length = 30)
	private String name;
	@Column(length = 60)
	private String lastName;
	private Integer gender;
	@Column(length = 100, unique = true)
	private String email;
	private Date dateOfBirth;
	private String password;
	@Column(length = 20)
	private String cellPhoneNumber;
	@Column(length = 255)
	private String profilePicture;
	private Integer userType;
	@Temporal(TemporalType.TIMESTAMP)
	private Date creationDate;
	
	@OneToOne (targetEntity = Patient.class, cascade = CascadeType.ALL, 
			fetch = FetchType.LAZY, orphanRemoval = true)
	@JoinColumn(name = "idUser", referencedColumnName = "id")
	private List <Patient> Patient;
	
	@OneToOne (targetEntity = Doctor.class, cascade = CascadeType.ALL, 
			fetch = FetchType.LAZY, orphanRemoval = true)
	@JoinColumn(name = "idUser", referencedColumnName = "id")
	private List <Doctor> Doctor;
	
	public User() {}
	
	
	public List<Doctor> getDoctor() {
		return Doctor;
	}

	public void setDoctor(List<Doctor> doctor) {
		Doctor = doctor;
	}

	
	
	public List<Patient> getPatient() {
		return Patient;
	}

	public void setPatient(List<Patient> patient) {
		Patient = patient;
	}


	public Integer getGender() {
		return gender;
	}

	public void setGender(Integer gender) {
		this.gender = gender;
	}

	public Integer getUserType() {
		return userType;
	}

	public void setUserType(Integer userType) {
		this.userType = userType;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCellPhoneNumber() {
		return cellPhoneNumber;
	}

	public void setCellPhoneNumber(String cellPhoneNumber) {
		this.cellPhoneNumber = cellPhoneNumber;
	}

	public String getProfilePicture() {
		return profilePicture;
	}

	public void setProfilePicture(String profilePicture) {
		this.profilePicture = profilePicture;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

}
