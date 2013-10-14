package com.depich1987.wsih.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

public class Meeting  implements Serializable {

	private Long id;
	
	private static final long serialVersionUID = 8917896588247591209L;
	
	private boolean newPatient;
	
	private String firstName;
	
	private String lastName;
	
	private String registrationFolderId;
	
	private Long patientId;
	
	private Set<HealthCare> cares;
	

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(style = "M-")
    private Date meetingDate;

    private String description;

	public Meeting() {
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Set<HealthCare> getCares() {
		return cares;
	}

	public void setCares(Set<HealthCare> cares) {
		this.cares = cares;
	}

	public Date getMeetingDate() {
		return meetingDate;
	}

	public void setMeetingDate(Date meetingDate) {
		this.meetingDate = meetingDate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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

	public String getRegistrationFolderId() {
		return registrationFolderId;
	}

	public void setRegistrationFolderId(String registrationFolderId) {
		this.registrationFolderId = registrationFolderId;
	}

	public boolean isNewPatient() {
		return newPatient;
	}

	public void setNewPatient(boolean newPatient) {
		this.newPatient = newPatient;
	}

	public Long getPatientId() {
		return patientId;
	}

	public void setPatientId(Long patientId) {
		this.patientId = patientId;
	}
	
	

}
