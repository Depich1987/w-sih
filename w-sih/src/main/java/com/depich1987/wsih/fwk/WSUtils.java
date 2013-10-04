package com.depich1987.wsih.fwk;

import javax.servlet.http.HttpServletRequest;


//import org.apache.log4j.Logger;
import org.springframework.web.servlet.support.RequestContext;

import com.depich1987.wsih.domain.AccountType;
import com.depich1987.wsih.domain.DepartmentType;

public class WSUtils {
	
//	private static Logger logger = Logger.getLogger(WSUtils.class);
	
	public static final String BUDGET_ACCOUNT_INCOME_MSG = "wsih_income";
	public static final String BUDGET_ACCOUNT_SPENT_MSG = "wsih_spent";
	
	public static final String DEPARTMENT_TYPE_MEDICAL = "wsih_departmentmedical";
	public static final String DEPARTMENT_TYPE_MANAGEMENT = "wsih_departmentmanagement";
	
	public static AccountType getAccounType(HttpServletRequest httpServletRequest, RequestContext context){

		String incomeMessage = context.getMessage(BUDGET_ACCOUNT_INCOME_MSG);
        String spentMessage = context.getMessage(BUDGET_ACCOUNT_SPENT_MSG);
        AccountType accountType = new AccountType();
        accountType.setIncome(incomeMessage);
        accountType.setSpent(spentMessage);
        
        return accountType;
        
	}
	
	public static DepartmentType getDepartmentType(HttpServletRequest httpServletRequest, RequestContext context){
		String medicalDepartmentMessage = context.getMessage(DEPARTMENT_TYPE_MEDICAL);
        String managementDepartmentMessage = context.getMessage(DEPARTMENT_TYPE_MANAGEMENT);
        
        DepartmentType departmentType = new DepartmentType();
        departmentType.setMedical(medicalDepartmentMessage);
        departmentType.setManagement(managementDepartmentMessage);
        
        return departmentType;
	}

}
