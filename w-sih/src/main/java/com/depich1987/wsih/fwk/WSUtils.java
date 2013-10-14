package com.depich1987.wsih.fwk;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializationConfig;
import org.springframework.web.servlet.support.RequestContext;

import com.depich1987.wsih.domain.AccountType;
import com.depich1987.wsih.domain.DepartmentType;
import com.depich1987.wsih.domain.JobJSON;
import com.depich1987.wsih.domain.PatientJSON;
import com.depich1987.wsih.domain.UserJSON;
import com.depich1987.wsih.domain.UserType;
import com.depich1987.wsih.domain.WSJob;
import com.depich1987.wsih.domain.WSPatient;
import com.depich1987.wsih.domain.WSUser;


public class WSUtils {
	
	private static Logger logger = Logger.getLogger(WSUtils.class);
	
	public static final String BUDGET_ACCOUNT_INCOME_MSG = "wsih_income";
	public static final String BUDGET_ACCOUNT_SPENT_MSG = "wsih_spent";
	
	public static final String DEPARTMENT_TYPE_MEDICAL = "wsih_departmentmedical";
	public static final String DEPARTMENT_TYPE_MANAGEMENT = "wsih_departmentmanagement";
	
	public static final String USERTYPE_DOCTOR = "wsih_userdoctor";
	public static final String USERTYPE_SIMPLE = "wsih_usersimple";
	
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
	
	public static UserType getUserType(HttpServletRequest httpServletRequest, RequestContext context){
		
		String doctorMessage = context.getMessage(USERTYPE_DOCTOR);
        String simpleMessage = context.getMessage(USERTYPE_SIMPLE);
        
        UserType userType = new UserType();
        userType.setDoctor(doctorMessage);
        userType.setSimple(simpleMessage);
        
        return userType;
	}
	
	/**
	 * Retrieves a {@link JobJSON} object for a given {@link WSJob}
	 * */
	public static String createJobJSONAsString(List<WSJob> jobs) {
		// configure to avoid timestamp representation
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(SerializationConfig.Feature.WRITE_DATES_AS_TIMESTAMPS, false);
		String json = null;
		try {
			json = mapper.writeValueAsString( createJobJsonList(jobs));
			logger.debug("createJobJSONAsString() - Got Json for Jobs : " + json);
		} catch (IOException e) {
			logger.error("createJobJSONAsString() - Failed mapping Job into JSON. Cause: \n", e);
		}
		
    	return json;
	}
	
	public static String createListString(List<WSPatient> patients) {
		// configure to avoid timestamp representation
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(SerializationConfig.Feature.WRITE_DATES_AS_TIMESTAMPS, false);
		String json = null;
		try {
			json = mapper.writeValueAsString(patients);
			logger.debug("createListString() - Got Json for patients : " + json);
		} catch (IOException e) {
			logger.error("createListString() - Failed mapping patient into JSON. Cause: \n", e);
		}
		
    	return json;
	}
	
	public static String createSimplePatientJSONAsString(WSPatient patient){
		// configure to avoid timestamp representation
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(SerializationConfig.Feature.WRITE_DATES_AS_TIMESTAMPS, false);
		String json = null;
		try {
			json = mapper.writeValueAsString( createSimplePatientJson(patient));
			logger.debug("createSimplePatientJSONAsString() - Got json for patient : " + json);
		} catch (IOException e) {
			logger.error("createSimplePatientJSONAsString() - Failed mapping patient into JSON. Cause: \n", e);
		}
		return json;
	}
	
	public static String createPatientJSONAsString(List<WSPatient> patients){
		// configure to avoid timestamp representation
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(SerializationConfig.Feature.WRITE_DATES_AS_TIMESTAMPS, false);
		String json = null;
		try {
			json = mapper.writeValueAsString( createPatientJsonsList(patients));
			logger.debug("createSimplePatientJSONAsString() - Got json for patient : " + json);
		} catch (IOException e) {
			logger.error("createSimplePatientJSONAsString() - Failed mapping patient into JSON. Cause: \n", e);
		}
		return json;
	}
	
	private static PatientJSON createSimplePatientJson(WSPatient WSPatient_){
		
        PatientJSON patientJSON = new PatientJSON();
        
        patientJSON.setId(WSPatient_.getId());
        patientJSON.setFirstName(WSPatient_.getFirstName());
        patientJSON.setLastName(WSPatient_.getLastName());
        
        return patientJSON;
	}
	
	private static List<PatientJSON> createPatientJsonsList(List<WSPatient> patients){
		
		List<PatientJSON> patientJSONs = new ArrayList<PatientJSON>();
		for (WSPatient wsPatient : patients) {
			PatientJSON patientJSON = new PatientJSON();
	        
	        patientJSON.setId(wsPatient.getId());
	        patientJSON.setFirstName(wsPatient.getFirstName());
	        patientJSON.setLastName(wsPatient.getLastName());
	        
	        patientJSONs.add(patientJSON);
		}
        
        
        return patientJSONs;
	}

	/**
	 * Retrieves a {@link UserJSON} object for a given {@link WSUser}
	 * */
	public static String createUserJSONAsString(List<WSUser> users) {
		
		// configure to avoid timestamp representation
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(SerializationConfig.Feature.WRITE_DATES_AS_TIMESTAMPS, false);
		String json = null;
		
		try {
			json = mapper.writeValueAsString( createUserJsonList(users));
			logger.debug("createUserJSONAsString() - Got Json for users : " + json);
		} catch (IOException e) {
			logger.error("createUserJSONAsString() - Failed mapping user into JSON. Cause: \n", e);
		}
		
    	return json;
	}
	
	
	public static List<JobJSON> createJobJsonList (List<WSJob> jobs){
		List<JobJSON> jobJSONsList = new ArrayList<JobJSON>();
		
		for (WSJob job : jobs) {
			JobJSON jobJSON =  new JobJSON();
			jobJSON.setId(job.getId());
			jobJSON.setName(job.getName());
			
			jobJSONsList.add(jobJSON);
		}
		return jobJSONsList;
		
	}
	
	private static List<UserJSON> createUserJsonList(List<WSUser> users){
		List<UserJSON> userJSONsList = new ArrayList<UserJSON>();
		
		for (WSUser user : users) {
			UserJSON userJSON = new UserJSON();
			
			userJSON.setId(user.getId());
			userJSON.setCivility(user.getCivility());
			userJSON.setFirstName(user.getFirstName());
			userJSON.setLastName(user.getLastName());
			userJSON.setJob(user.getJob().getName());
			
			userJSONsList.add(userJSON);
		}
		return userJSONsList;
	}
}
