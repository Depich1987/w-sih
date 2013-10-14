package com.depich1987.wsih.web.workbench;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

//import org.apache.log4j.Logger;
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
import org.springframework.web.util.UriUtils;
import org.springframework.web.util.WebUtils;

import com.depich1987.wsih.domain.WSPatient;
import com.depich1987.wsih.fwk.WSUtils;
import com.depich1987.wsih.services.dao.PatientService;

@Controller
public class WorkbenchPatientController {
	
//	private static Logger logger = Logger.getLogger(WorkbenchPatientController.class);
	
	private static final  String PATH = "/workbench/patients";
	
	private static final String CREATE_VIEW = "workbench/patients/create";
	private static final String SHOW_VIEW = "workbench/patients/show";
	private static final String LIST_VIEW = "workbench/patients/list";
	private static final String UPDATE_VIEW = "workbench/patients/update";
	
	@Autowired
	private PatientService patientService;
	
	public WorkbenchPatientController() {
		// TODO Auto-generated constructor stub
	}
	
	 @RequestMapping(value = PATH +"/create", method = RequestMethod.POST, produces = "text/html")
	    public String create(@Valid WSPatient WSPatient_, BindingResult bindingResult, Model uiModel, HttpServletRequest httpServletRequest) {
	        if (bindingResult.hasErrors()) {
	            populateEditForm(uiModel, WSPatient_);
	            return CREATE_VIEW;
	        }
	        uiModel.asMap().clear();
	        WSPatient_.persist();
	        return "redirect:"+ PATH +"/"+ encodeUrlPathSegment(WSPatient_.getId().toString(), httpServletRequest);
	    }
	 
	 @RequestMapping(value = PATH + "/createAjax",method = RequestMethod.POST, produces = "text/html")
	    public @ResponseBody String createByAjax(@Valid WSPatient WSPatient_, BindingResult bindingResult, Model uiModel, HttpServletRequest httpServletRequest) {
//	        if (bindingResult.hasErrors()) {
//	            populateEditForm(uiModel, WSPatient_);
//	            return "wspatients/create";
//	        }
//	        uiModel.asMap().clear();
	        patientService.persist(WSPatient_);
	        
	        return WSUtils.createSimplePatientJSONAsString(WSPatient_);
	    }
	 
	 @RequestMapping(value = PATH + "/autocomplete",method = RequestMethod.POST, produces = "application/json")
	    public @ResponseBody String autocompletePatient(@RequestParam("queryString")String queryString, HttpServletRequest httpServletRequest) {
		 	
		 List<WSPatient> patients =  patientService.findPatientsByFolderRegistrationIdOrFirstNameOrLastNameLike(queryString);
		 return WSUtils.createPatientJSONAsString(patients);
	    }
	    
	    @RequestMapping(value = PATH +"/create",params = "form", produces = "text/html")
	    public String createForm(Model uiModel) {
	        populateEditForm(uiModel, new WSPatient());
	        return CREATE_VIEW;
	    }
	    
	    @RequestMapping(value = PATH +"/{id}", produces = "text/html")
	    public String show(@PathVariable("id") Long id, Model uiModel) {
	        addDateTimeFormatPatterns(uiModel);
	        uiModel.addAttribute("wspatient_", WSPatient.findWSPatient(id));
	        uiModel.addAttribute("itemId", id);
	        uiModel.addAttribute("currentNav", "patientRegistry");
	        return SHOW_VIEW;
	    }
	    
	    @RequestMapping(value = PATH ,produces = "text/html")
	    public String list(@RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size, Model uiModel) {
	        if (page != null || size != null) {
	            int sizeNo = size == null ? 10 : size.intValue();
	            final int firstResult = page == null ? 0 : (page.intValue() - 1) * sizeNo;
	            uiModel.addAttribute("wspatients", WSPatient.findWSPatientEntries(firstResult, sizeNo));
	            float nrOfPages = (float) WSPatient.countWSPatients() / sizeNo;
	            uiModel.addAttribute("maxPages", (int) ((nrOfPages > (int) nrOfPages || nrOfPages == 0.0) ? nrOfPages + 1 : nrOfPages));
	        } else {
	            uiModel.addAttribute("wspatients", WSPatient.findAllWSPatients());
	        }
	        addDateTimeFormatPatterns(uiModel);
	        
	        uiModel.addAttribute("currentNav", "patientRegistry");
	        
	        return LIST_VIEW;
	    }
	    
	    @RequestMapping(value = PATH +"/update",method = RequestMethod.PUT, produces = "text/html")
	    public String update(@Valid WSPatient WSPatient_, BindingResult bindingResult, Model uiModel, HttpServletRequest httpServletRequest) {
	        if (bindingResult.hasErrors()) {
	            populateEditForm(uiModel, WSPatient_);
	            return "wspatients/update";
	        }
	        uiModel.asMap().clear();
	        WSPatient_.merge();
	        return "redirect:"+PATH+"/" + encodeUrlPathSegment(WSPatient_.getId().toString(), httpServletRequest);
	    }
	    
	    @RequestMapping(value = PATH +"/{id}", params = "form", produces = "text/html")
	    public String updateForm(@PathVariable("id") Long id, Model uiModel) {
	        populateEditForm(uiModel, WSPatient.findWSPatient(id));
	        return UPDATE_VIEW;
	    }
	    
	    @RequestMapping(value = PATH +"/delete/{id}", method = RequestMethod.DELETE, produces = "text/html")
	    public String delete(@PathVariable("id") Long id, @RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size, Model uiModel) {
	        WSPatient WSPatient_ = WSPatient.findWSPatient(id);
	        WSPatient_.remove();
	        uiModel.asMap().clear();
	        uiModel.addAttribute("page", (page == null) ? "1" : page.toString());
	        uiModel.addAttribute("size", (size == null) ? "10" : size.toString());
	        return "redirect:/wspatients";
	    }
	    
	    void addDateTimeFormatPatterns(Model uiModel) {
	        uiModel.addAttribute("WSPatient__birthdate_date_format", DateTimeFormat.patternForStyle("M-", LocaleContextHolder.getLocale()));
	        uiModel.addAttribute("WSPatient__creationdate_date_format", DateTimeFormat.patternForStyle("M-", LocaleContextHolder.getLocale()));
	    }
	    
	    void populateEditForm(Model uiModel, WSPatient WSPatient_) {
	        uiModel.addAttribute("WSPatient_", WSPatient_);
	        addDateTimeFormatPatterns(uiModel);
//	        uiModel.addAttribute("wsmeetings", WSMeeting.findAllWSMeetings());
	        uiModel.addAttribute("currentNav", "patientRegistry");
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
