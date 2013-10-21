package com.depich1987.wsih.json;

public class UserJSON {
	
	private Long id;
	
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
    private String job;
    
    public UserJSON() {
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

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

    
}
