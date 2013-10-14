package com.depich1987.wsih.domain;

import java.io.Serializable;

public class UserType implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2671155093750673639L;
	
	private String doctor;
	private String simple;
	
	public UserType() {
		// TODO Auto-generated constructor stub
	}

	public String getDoctor() {
		return doctor;
	}

	public void setDoctor(String doctor) {
		this.doctor = doctor;
	}

	public String getSimple() {
		return simple;
	}

	public void setSimple(String simple) {
		this.simple = simple;
	}
	
	

}
