package com.depich1987.wsih.web.workbench;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.joda.time.format.DateTimeFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.support.RequestContext;
import org.springframework.web.util.UriUtils;
import org.springframework.web.util.WebUtils;

import com.depich1987.wsih.domain.DepartmentType;
import com.depich1987.wsih.domain.HealthCare;
import com.depich1987.wsih.domain.Meeting;
import com.depich1987.wsih.domain.UserType;
import com.depich1987.wsih.domain.WSDepartment;
import com.depich1987.wsih.domain.WSHealthCare;
import com.depich1987.wsih.domain.WSHealthCareInMeeting;
import com.depich1987.wsih.domain.WSMeeting;
import com.depich1987.wsih.domain.WSPatient;
import com.depich1987.wsih.domain.WSUser;
import com.depich1987.wsih.form.MeetingForm;
import com.depich1987.wsih.fwk.MeetingException;
import com.depich1987.wsih.fwk.WSUtils;
import com.depich1987.wsih.services.dao.DepartmentService;
import com.depich1987.wsih.services.dao.HealthCareService;
import com.depich1987.wsih.services.dao.MeetingService;
import com.depich1987.wsih.services.dao.PatientService;
import com.depich1987.wsih.services.dao.UserService;

@Controller
public class WorkbenchMeetingController {
	
	private static final  String PATH = "/workbench/meetings";
	
	private static final String CREATE_VIEW = "workbench/meetings/create";
	private static final String SHOW_VIEW = "workbench/meetings/show";
	private static final String LIST_VIEW = "workbench/meetings/list";
//	private static final String AGENDA_VIEW = "workbench/meetings/agenda";
	private static final String UPDATE_VIEW = "workbench/meetings/update";
	
	private static Logger logger = Logger.getLogger(WorkbenchMeetingController.class);
	
	@Autowired
	private PatientService patientService;
	
	@Autowired
	private HealthCareService healthCareService;
	
	@Autowired
	private MeetingService meetingService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private DepartmentService departmentService;
	
	
	public WorkbenchMeetingController() {
		// TODO Auto-generated constructor stub
	}
	
	@RequestMapping(value = PATH + "/create", method = RequestMethod.POST, produces = "text/html")
    public String create(@Valid MeetingForm meetingForm, BindingResult bindingResult, Model uiModel, HttpServletRequest httpServletRequest) {
        
		if (bindingResult.hasErrors()) {
            populateMeetingEditForm(uiModel, meetingForm, httpServletRequest);
            return CREATE_VIEW;
        }
		uiModel.asMap().clear();
		
		WSPatient patient = null;
        if(meetingForm.isNewPatient()){
        	patient = new WSPatient();
        	patient.setFirstName(meetingForm.getFirstName());
        	patient.setLastName(meetingForm.getLastName());
        	//patient.setFolderRegistrationId(folderRegistrationId);
        	
        	patientService.persist(patient);
        	logger.debug("create() - A new Patient has been created");
        }else{
        	patient = patientService.findPatient(meetingForm.getPatientId());
        }
        
        WSMeeting meeting = new WSMeeting();
        meeting.setPatient(patient);
        meeting.setCreationDate(new Date());
        meeting.setMeetingDate(meetingForm.getMeetingDate());
        meeting.setStatus(false);
        meeting.setDescription(meetingForm.getDescription());
        patient.getMeetings().add(meeting);
        WSHealthCareInMeeting healthCareInMeeting = new WSHealthCareInMeeting();
        
        healthCareInMeeting.setCreationDate(new Date());
        healthCareInMeeting.setMeeting(meeting);
        
        WSHealthCare healthCare = healthCareService.findHealthCare(meetingForm.getHealthCare()); 
        healthCareInMeeting.setHealthCare(healthCare);
        
        WSUser user = userService.findUser(meetingForm.getDoctorId());
        healthCareInMeeting.setUser(user);
        healthCareInMeeting.setStartTime(meetingForm.getStartTime());
        healthCareInMeeting.setEndTime(meetingForm.getEndTime());
        healthCareInMeeting.setStatus(false);
        healthCareInMeeting.setMeetingDate(meetingForm.getMeetingDate());
        meeting.getHealthCareInMeeting().add(healthCareInMeeting);
        meetingService.merge(meeting);
        
        logger.debug("create() - A new Meeting has been created");
        
        return "redirect:/workbench/agenda/global";
		
    }
	
//	@RequestMapping(value = PATH + "/addHealthCare/{meetingId}", method = RequestMethod.POST,  produces = "text/html")
//    public String addHealthCares(@PathVariable("meetingId")Long meetingId,@Valid Meeting meetingForm) throws MeetingException{
//		
//		WSMeeting meeting = meetingService.findMeeting(meetingId);
//		
//		if(meeting == null ){
//			String message =">>>>>  addHealthCares() - Given Meeting Id does not exist in the database. Reindexing the search engine might help.\n";;
//			logger.debug("addHealthCares() -unknown meeting with id ["+meetingId+"]");
//			throw new MeetingException(message);
//		}
//		
//		for (HealthCare healthCare : meetingForm.getCares()) {
//			
//			WSHealthCare care = healthCareService.findHealthCare(healthCare.getId());
//			
//			WSHealthCareInMeeting healthCareInMeeting = new WSHealthCareInMeeting();
//			healthCareInMeeting.setMeeting(meeting);
//			healthCareInMeeting.setCreationDate(new Date());
//			healthCareInMeeting.setHealthCare(care);
//			
//			meeting.getHealthCareInMeeting().add(healthCareInMeeting);
//		}
//		
//		meetingService.merge(meeting);
//		logger.debug("addHealthCares() - all healthCareInMeeting have been added to meeting ["+meeting+"]");
//		
//		return "redirect:workbench/agenda/global";
//	}
	
	@RequestMapping(value = PATH +"/events.json", method = RequestMethod.POST, produces = "application/json")
	public @ResponseBody String getEventsJSONByDepartments(@RequestParam("departmentId")Long departmentId,@RequestParam("startDate")Long startDate,@RequestParam("endDate")Long endDate){
		
		List<WSHealthCareInMeeting> healthCareInMeetings =  null;
		Date dateStart =  new Date(startDate);
		Date dateEnd =  new Date(endDate);
		if(departmentId == 0){
			
			healthCareInMeetings = meetingService.findHealthCareInMeetingsBetweenDates(dateStart, dateEnd);
		}else{
			healthCareInMeetings = meetingService.findHealthCareInMeetingsByDepartmentBetweenDates(departmentId, dateStart, dateEnd);
		}
		
		return WSUtils.createEventJSONAsString(healthCareInMeetings);
	
	}
	
    @RequestMapping(value = PATH + "/create", params = "form", produces = "text/html")
    public String createForm( HttpServletRequest httpServletRequest, Model uiModel) {
    	populateMeetingEditForm(uiModel, new MeetingForm(), httpServletRequest);
        return CREATE_VIEW;
    }
    
    @RequestMapping(value = PATH + "/{id}", produces = "text/html")
    public String show(@PathVariable("id") Long id, Model uiModel) {
        addDateTimeFormatPatterns(uiModel);
        uiModel.addAttribute("wsmeeting_", meetingService.findMeeting(id));
        uiModel.addAttribute("itemId", id);
        
        uiModel.addAttribute("currentNav", "meetingmanagement");
        
        return SHOW_VIEW;
    }
    
    @RequestMapping(value = PATH , produces = "text/html")
    public String list(@RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size, Model uiModel) {
        if (page != null || size != null) {
            int sizeNo = size == null ? 10 : size.intValue();
            final int firstResult = page == null ? 0 : (page.intValue() - 1) * sizeNo;
            uiModel.addAttribute("wsmeetings", meetingService.findMeetingEntries(firstResult, sizeNo));
            float nrOfPages = (float) meetingService.countMeetings() / sizeNo;
            uiModel.addAttribute("maxPages", (int) ((nrOfPages > (int) nrOfPages || nrOfPages == 0.0) ? nrOfPages + 1 : nrOfPages));
        } else {
            uiModel.addAttribute("wsmeetings", meetingService.findAllMeetings());
        }
        addDateTimeFormatPatterns(uiModel);
        
        uiModel.addAttribute("currentNav", "meetingmanagement");
        
        return LIST_VIEW;
    }
    
    @RequestMapping(value = PATH + "/update", method = RequestMethod.POST, produces = "text/html")
    public String update(@Valid WSMeeting WSMeeting_, BindingResult bindingResult, Model uiModel, HttpServletRequest httpServletRequest) {
        if (bindingResult.hasErrors()) {
            populateEditForm(uiModel, WSMeeting_);
            return UPDATE_VIEW;
        }
        uiModel.asMap().clear();
        meetingService.merge(WSMeeting_);
        return "redirect:" + PATH +"/" + encodeUrlPathSegment(WSMeeting_.getId().toString(), httpServletRequest);
    }
    
    @RequestMapping(value = PATH + "/{id}", params = "form", produces = "text/html")
    public String updateForm(@PathVariable("id") Long id, Model uiModel) {
        populateEditForm(uiModel, WSMeeting.findWSMeeting(id));
        return UPDATE_VIEW;
    }
    
    @RequestMapping(value = PATH + "/delete/{id}", method = RequestMethod.DELETE, produces = "text/html")
    public String delete(@PathVariable("id") Long id, @RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size, Model uiModel) {
        WSMeeting WSMeeting_ = WSMeeting.findWSMeeting(id);
        WSMeeting_.remove();
        uiModel.asMap().clear();
        uiModel.addAttribute("page", (page == null) ? "1" : page.toString());
        uiModel.addAttribute("size", (size == null) ? "10" : size.toString());
        return "redirect:"+ PATH + "?size=10";
    }
    
    @RequestMapping(value = PATH + "/candidates", method = RequestMethod.POST,produces ="application/json")
    public @ResponseBody String getCandidatesJson(@RequestParam("departmentId")Long departmentId,HttpServletRequest httpServletRequest){
    	
    	RequestContext context = new RequestContext(httpServletRequest);;
		UserType userType = WSUtils.getUserType(httpServletRequest, context );
    	WSDepartment department = departmentService.findDepartment(departmentId);
		List<WSUser> users = userService.findUsersByDepartmentAndUserType(department , userType.getDoctor());
		return WSUtils.createUserJSONAsString(users );
		
    }
    
    void addDateTimeFormatPatterns(Model uiModel) {
        uiModel.addAttribute("WSMeeting__meetingdate_date_format", DateTimeFormat.patternForStyle("M-", LocaleContextHolder.getLocale()));
        uiModel.addAttribute("WSMeeting__creationdate_date_format", DateTimeFormat.patternForStyle("M-", LocaleContextHolder.getLocale()));
    }
    
    void populateEditForm(Model uiModel, WSMeeting WSMeeting_) {
        uiModel.addAttribute("WSMeeting_", WSMeeting_);
        addDateTimeFormatPatterns(uiModel);
        uiModel.addAttribute("wspatients", patientService.findAllPatients());
        uiModel.addAttribute("currentNav", "meetingmanagement");
    }
    
    void populateMeetingEditForm(Model uiModel, MeetingForm WSMeeting_, HttpServletRequest httpServletRequest) {
        uiModel.addAttribute("WSMeeting_", WSMeeting_);
        addDateTimeFormatPatterns(uiModel);
        uiModel.addAttribute("wspatients", patientService.findAllPatients());
        
        RequestContext context =  new RequestContext(httpServletRequest);
		DepartmentType departmentType =  WSUtils.getDepartmentType(httpServletRequest, context);
		
        uiModel.addAttribute("wsdepartments", departmentService.findDepartmentsByDepartmentType(departmentType.getMedical()));
        uiModel.addAttribute("currentNav", "meetingmanagement");
        uiModel.addAttribute("cares", healthCareService.findAllHealthCares());
    }
    
    String encodeUrlPathSegment(String pathSegment, HttpServletRequest httpServletRequest) {
        String enc = httpServletRequest.getCharacterEncoding();
        if (enc == null) {
            enc = WebUtils.DEFAULT_CHARACTER_ENCODING;
        }
        try {
            pathSegment = UriUtils.encodePathSegment(pathSegment, enc);
        } catch (UnsupportedEncodingException uee) {}
        return pathSegment;
    }
}