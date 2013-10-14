package com.depich1987.wsih.domain;

import java.util.Date;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

public class MeetingJSON {

	private Long meetingId;
	
	private String patientFullName;
	
	private String doctorFullName;
	
	private String patientFolderRegistrationId;
	
	@Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(style = "M-")
    private Date meetingDate;
	
    /**
     */
    private Boolean status;
    
    /**
     */
    private String description;
    
    public MeetingJSON() {
		// TODO Auto-generated constructor stub
	}

	public Long getMeetingId() {
		return meetingId;
	}

	public void setMeetingId(Long meetingId) {
		this.meetingId = meetingId;
	}

	public String getPatientFullName() {
		return patientFullName;
	}

	public void setPatientFullName(String patientFullName) {
		this.patientFullName = patientFullName;
	}

	public String getDoctorFullName() {
		return doctorFullName;
	}

	public void setDoctorFullName(String doctorFullName) {
		this.doctorFullName = doctorFullName;
	}

	public String getPatientFolderRegistrationId() {
		return patientFolderRegistrationId;
	}

	public void setPatientFolderRegistrationId(String patientFolderRegistrationId) {
		this.patientFolderRegistrationId = patientFolderRegistrationId;
	}

	public Date getMeetingDate() {
		return meetingDate;
	}

	public void setMeetingDate(Date meetingDate) {
		this.meetingDate = meetingDate;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
    
    
}
