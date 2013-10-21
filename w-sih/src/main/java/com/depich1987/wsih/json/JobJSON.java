package com.depich1987.wsih.json;

import java.io.Serializable;

public class JobJSON implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2726714095464284061L;
	
	private long id;
	private String name;
	
	public JobJSON() {
		// TODO Auto-generated constructor stub
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	
}
