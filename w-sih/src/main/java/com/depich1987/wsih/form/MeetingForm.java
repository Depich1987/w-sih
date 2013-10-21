package com.depich1987.wsih.form;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

public class MeetingForm implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -909544698754740787L;

	private Long id;
    
    private String description;
    
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(style = "S-")
    private Date meetingDate;
	
    /**
     */
    @Temporal(TemporalType.TIME)
    @DateTimeFormat(style = "-S")
    private Date startTime;

    /**
     */
    @Temporal(TemporalType.TIME)
    @DateTimeFormat(style = "-S")
    private Date endTime;
	
	
	//Patient Informations
	private boolean newPatient;
	private String firstName;
	private String lastName;
	private String registrationFolderId;
	private Long patientId;
	
	//Clinical Informations
    private String doctorFullName;
    private Long doctorId;
    private Long department;
    private Long healthCare;
    
    public MeetingForm() {
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getMeetingDate() {
		return meetingDate;
	}

	public void setMeetingDate(Date meetingDate) {
		this.meetingDate = meetingDate;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public boolean isNewPatient() {
		return newPatient;
	}

	public void setNewPatient(boolean newPatient) {
		this.newPatient = newPatient;
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

	public Long getPatientId() {
		return patientId;
	}

	public void setPatientId(Long patientId) {
		this.patientId = patientId;
	}

	public String getDoctorFullName() {
		return doctorFullName;
	}

	public void setDoctorFullName(String doctorFullName) {
		this.doctorFullName = doctorFullName;
	}

	public Long getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(Long doctorId) {
		this.doctorId = doctorId;
	}

	public Long getDepartment() {
		return department;
	}

	public void setDepartment(Long department) {
		this.department = department;
	}

	public Long getHealthCare() {
		return healthCare;
	}

	public void setHealthCare(Long healthCare) {
		this.healthCare = healthCare;
	}
    
    

}
