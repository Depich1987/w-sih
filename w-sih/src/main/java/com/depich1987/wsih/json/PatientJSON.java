package com.depich1987.wsih.json;

import java.io.Serializable;

public class PatientJSON implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3932538210016026839L;
	
	private Long id;
	

	private String folderRegistrationId;

    /**
     */
    private String civility;

    /**
     */
    private String firstName;

    /**
     */
    private String lastName;

    /**
     */
    private String gender;
    
    public PatientJSON() {
		// TODO Auto-generated constructor stub
	}
    

	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public String getFolderRegistrationId() {
		return folderRegistrationId;
	}

	public void setFolderRegistrationId(String folderRegistrationId) {
		this.folderRegistrationId = folderRegistrationId;
	}

	public String getCivility() {
		return civility;
	}

	public void setCivility(String civility) {
		this.civility = civility;
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

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}
    
    

}
