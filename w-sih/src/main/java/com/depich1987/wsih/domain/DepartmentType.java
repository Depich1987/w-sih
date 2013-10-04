package com.depich1987.wsih.domain;

import java.io.Serializable;

public class DepartmentType implements Serializable {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6979962131039119043L;
	
	private String medical;
	private String management;
	
	public DepartmentType() {
		// TODO Auto-generated constructor stub
	}

	public String getMedical() {
		return medical;
	}

	public void setMedical(String medical) {
		this.medical = medical;
	}

	public String getManagement() {
		return management;
	}

	public void setManagement(String management) {
		this.management = management;
	}
	
	

}
