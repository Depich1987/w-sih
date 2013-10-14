package com.depich1987.wsih.form;

import java.io.Serializable;

import javax.persistence.Transient;

public class UserForm implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2791299748731976399L;
	
	private long id;

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
    private String userName;
    
    /** 
     */
    private String pictureName;

    /**
     */
    private String password;

    /**
     */
    @Transient
    private String confirmPassword;

    /**
     */
    private String userType;
    
    /** 
     */
    private long department; 

    /**
     */
    private long job;
    
    public UserForm() {
		// TODO Auto-generated constructor stub
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

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPictureName() {
		return pictureName;
	}

	public void setPictureName(String pictureName) {
		this.pictureName = pictureName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public long getDepartment() {
		return department;
	}

	public void setDepartment(long department) {
		this.department = department;
	}

	public long getJob() {
		return job;
	}

	public void setJob(long job) {
		this.job = job;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
    
    

}
