package com.depich1987.wsih.domain;

import java.io.Serializable;

public class AccountType implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1708092844938297792L;
	
	private String income;
	private String spent;
	
	public AccountType() {
		// TODO Auto-generated constructor stub
	}

	public String getIncome() {
		return income;
	}

	public void setIncome(String income) {
		this.income = income;
	}

	public String getSpent() {
		return spent;
	}

	public void setSpent(String spent) {
		this.spent = spent;
	}

}
