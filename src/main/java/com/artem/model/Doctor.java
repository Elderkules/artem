package com.artem.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name = "doctor")
public class Doctor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer Id;
	private Integer idUser;
	@Column(length = 30)
	private String Specialty;
	@Column(length = 20)
	private String professionalLicense;
	@Column(length = 100)
	private String location;
	@Column(length = 500)
	private String experience;
	@Column(length = 100)
	private String lenguages;
	private int price;
	@Temporal(TemporalType.TIMESTAMP)
	private Date creationDate;
	
	@OneToMany (targetEntity = Schedule.class, cascade = CascadeType.ALL, 
			fetch = FetchType.LAZY, orphanRemoval = true)
	@JoinColumn(name = "idDoctor", referencedColumnName = "id")
	private List <Schedule> Schedule;

	@OneToMany (targetEntity = Appointment.class, cascade = CascadeType.ALL, 
			fetch = FetchType.LAZY, orphanRemoval = true)
	@JoinColumn(name = "idDoctor", referencedColumnName = "id")
	private List <Appointment> Appointment;
	
	public Doctor() {}
	
	public List<Appointment> getAppointment() {
		return Appointment;
	}

	public void setAppointment(List<Appointment> appointment) {
		Appointment = appointment;
	}
	
	public List<Schedule> getSchedule() {
		return Schedule;
	}

	public void setSchedule(List<Schedule> schedule) {
		Schedule = schedule;
	}

	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}

	public Integer getIdUser() {
		return idUser;
	}

	public void setIdUser(Integer idUser) {
		this.idUser = idUser;
	}

	public String getSpecialty() {
		return Specialty;
	}

	public void setSpecialty(String specialty) {
		Specialty = specialty;
	}

	public String getProfessionalLicense() {
		return professionalLicense;
	}

	public void setProfessionalLicense(String professionalLicense) {
		this.professionalLicense = professionalLicense;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getExperience() {
		return experience;
	}

	public void setExperience(String experience) {
		this.experience = experience;
	}

	public String getLenguages() {
		return lenguages;
	}

	public void setLenguages(String lenguages) {
		this.lenguages = lenguages;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
	
}
