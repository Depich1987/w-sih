package com.depich1987.wsih.web.admin;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.util.UriUtils;
import org.springframework.web.util.WebUtils;

import com.depich1987.wsih.domain.WSHealthCare;
import com.depich1987.wsih.domain.WSHealthCareType;
import com.depich1987.wsih.services.dao.HealthCareService;
import com.depich1987.wsih.services.dao.HealthCareTypeService;

@Controller
public class AdminHealthCareManagerController {
	
	private static Logger logger = Logger.getLogger(AdminHealthCareManagerController.class);
	
	private static final String PATH = "/admin/healthcaremanagement";
	
	private static final String INDEX_VIEW = "admin/healthcaremanagement/index";
	
	private static final String CREATE_HEALTHCARETYPE_VIEW = "admin/healthcaremanagement/healthcaretypes/create";
	private static final String SHOW_HEALTHCARETYPE_VIEW = "admin/healthcaremanagement/healthcaretypes/show";
	private static final String UPDATE_HEALTHCARETYPE_VIEW = "admin/healthcaremanagement/healthcaretypes/update";
	private static final String LIST_HEALTHCARETYPE_VIEW = "admin/healthcaremanagement/healthcaretypes/list";
	
	private static final String CREATE_HEALTHCARE_VIEW = "admin/healthcaremanagement/healthcares/create";
	private static final String SHOW_HEALTHCARE_VIEW = "admin/healthcaremanagement/healthcares/show";
	private static final String UPDATE_HEALTHCARE_VIEW = "admin/healthcaremanagement/healthcares/update";
	private static final String LIST_HEALTHCARE_VIEW = "admin/healthcaremanagement/healthcares/list";
	
	
	@Autowired
	private HealthCareTypeService healthCareTypeService;
	
	@Autowired
	private HealthCareService healthCareService;
	
	
	public AdminHealthCareManagerController() {
		// TODO Auto-generated constructor stub
	}
	
	@RequestMapping(value = PATH , produces = "text/html")
	public String index(){
		logger.debug("index()- acces to healthcare area.");
		return INDEX_VIEW;
	}
	
	 @RequestMapping(value = PATH + "/healthcaretypes/create", method = RequestMethod.POST, produces = "text/html")
	    public String createHealthCareType(@Valid WSHealthCareType WSHealthCareType_, BindingResult bindingResult, Model uiModel, HttpServletRequest httpServletRequest) {
	        if (bindingResult.hasErrors()) {
	            populateHealthCareTypeEditForm(uiModel, WSHealthCareType_);
	            logger.debug("createHealthCareType()- WSHealthCareType_ is invalid,redirect user to create view");
	            return CREATE_HEALTHCARETYPE_VIEW;
	        }
	        uiModel.asMap().clear();
	        healthCareTypeService.persist(WSHealthCareType_);
	        logger.debug("createHealthCareType()- WSHealthCareType_ has been created siwth success!");
	        return "redirect:"+PATH +"/healthcaretypes/" + encodeUrlPathSegment(WSHealthCareType_.getId().toString(), httpServletRequest);
	    }
	 
	    
	    @RequestMapping(value = PATH + "/healthcaretypes/create",params = "form", produces = "text/html")
	    public String createHealthCareTypeForm(Model uiModel) {
	        populateHealthCareTypeEditForm(uiModel, new WSHealthCareType());
	        return CREATE_HEALTHCARETYPE_VIEW;
	    }
	    
	    
	    @RequestMapping(value = PATH +"/healthcaretypes/{id}", produces = "text/html")
	    public String showHealthCareType(@PathVariable("id") Long id, Model uiModel) {
	        uiModel.addAttribute("wshealthcaretype_", healthCareTypeService.findHealthCareType(id));
	        uiModel.addAttribute("itemId", id);
	        uiModel.addAttribute("currentNav", "healthcare");
	        return SHOW_HEALTHCARETYPE_VIEW;
	    }
	    
	    
	    @RequestMapping(value = PATH + "/healthcaretypes",produces = "text/html")
	    public String listHealthCareType(@RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size, Model uiModel) {
	        if (page != null || size != null) {
	            int sizeNo = size == null ? 10 : size.intValue();
	            final int firstResult = page == null ? 0 : (page.intValue() - 1) * sizeNo;
	            uiModel.addAttribute("wshealthcaretypes", healthCareTypeService.findHealthCareTypeEntries(firstResult, sizeNo));
	            float nrOfPages = (float) healthCareTypeService.countHealthCareTypes() / sizeNo;
	            uiModel.addAttribute("maxPages", (int) ((nrOfPages > (int) nrOfPages || nrOfPages == 0.0) ? nrOfPages + 1 : nrOfPages));
	        } else {
	            uiModel.addAttribute("wshealthcaretypes", healthCareTypeService.findAllHealthCareTypes());
	        }
	        uiModel.addAttribute("currentNav", "healthcare");
	        
	        return LIST_HEALTHCARETYPE_VIEW;
	    }
	    
	    
	    @RequestMapping(value = PATH + "/healthcaretypes/update", method = RequestMethod.POST, produces = "text/html")
	    public String updateHealthCareType(@Valid WSHealthCareType WSHealthCareType_, BindingResult bindingResult, Model uiModel, HttpServletRequest httpServletRequest) {
	        if (bindingResult.hasErrors()) {
	            populateHealthCareTypeEditForm(uiModel, WSHealthCareType_);
	            logger.debug("updateHealthCareType()- WSHealthCareType_ is invalid,redirect user to update view");
	            return UPDATE_HEALTHCARETYPE_VIEW;
	        }
	        uiModel.asMap().clear();
	        healthCareTypeService.update(WSHealthCareType_);
	        logger.debug("createHealthCareType()- WSHealthCareType_ has been updated");
	        
	        return "redirect:"+ PATH +"/healthcaretypes/" + encodeUrlPathSegment(WSHealthCareType_.getId().toString(), httpServletRequest);
	    }
	    
	    
	    @RequestMapping(value = PATH +"/healthcaretypes/{id}", params = "form", produces = "text/html")
	    public String updateHealthCareTypeForm(@PathVariable("id") Long id, Model uiModel) {
	        populateHealthCareTypeEditForm(uiModel, healthCareTypeService.findHealthCareType(id));
	        return UPDATE_HEALTHCARETYPE_VIEW;
	    }
	    
	    
	    @RequestMapping(value = PATH +"/healthcaretypes/delete/{id}", method = RequestMethod.DELETE, produces = "text/html")
	    public String deleteHealthCareType(@PathVariable("id") Long id, @RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size, Model uiModel) {
	        WSHealthCareType WSHealthCareType_ = WSHealthCareType.findWSHealthCareType(id);
	        WSHealthCareType_.remove();
	        uiModel.asMap().clear();
	        uiModel.addAttribute("page", (page == null) ? "1" : page.toString());
	        uiModel.addAttribute("size", (size == null) ? "10" : size.toString());
	        return "redirect:" + PATH +"/healthcaretypes?size=10";
	    }
	    
	    @RequestMapping(value = PATH +"/healthcares/create", method = RequestMethod.POST, produces = "text/html")
	    public String createHealthCare(@Valid WSHealthCare WSHealthCare_, BindingResult bindingResult, Model uiModel, HttpServletRequest httpServletRequest) {
	        if (bindingResult.hasErrors()) {
	            populateHealthCareEditForm(uiModel, WSHealthCare_);
	            logger.debug("createHealthCareType()- WSHealthCare_ creation failed.redirect to create view");
		        
	            return CREATE_HEALTHCARE_VIEW;
	        }
	        uiModel.asMap().clear();
	        
	        healthCareService.persist(WSHealthCare_);
	        logger.debug("createHealthCareType()- WSHealthCare_ has been created with success!");
	        return "redirect:"+PATH +"/healthcares/" + encodeUrlPathSegment(WSHealthCare_.getId().toString(), httpServletRequest);
	    }
	    
	    @RequestMapping(value = PATH +"/healthcares/create", params = "form", produces = "text/html")
	    public String createHealthCareForm(Model uiModel) {
	        populateHealthCareEditForm(uiModel, new WSHealthCare());
	        return CREATE_HEALTHCARE_VIEW;
	    }
	    
	    @RequestMapping(value = PATH +"/healthcares/{id}", produces = "text/html")
	    public String showHealthCare(@PathVariable("id") Long id, Model uiModel) {
	        uiModel.addAttribute("wshealthcare_", healthCareService.findHealthCare(id));
	        uiModel.addAttribute("itemId", id);
	        uiModel.addAttribute("currentNav", "healthcare");
	        return SHOW_HEALTHCARE_VIEW;
	    }
	    
	    @RequestMapping(value = PATH +"/healthcares", produces = "text/html")
	    public String listHealthCare(@RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size, Model uiModel) {
	        if (page != null || size != null) {
	            int sizeNo = size == null ? 10 : size.intValue();
	            final int firstResult = page == null ? 0 : (page.intValue() - 1) * sizeNo;
	            uiModel.addAttribute("wshealthcares", healthCareService.findHealthCareEntries(firstResult, sizeNo));
	            float nrOfPages = (float) healthCareService.countHealthCares() / sizeNo;
	            uiModel.addAttribute("maxPages", (int) ((nrOfPages > (int) nrOfPages || nrOfPages == 0.0) ? nrOfPages + 1 : nrOfPages));
	        } else {
	            uiModel.addAttribute("wshealthcares", healthCareService.findAllHealthCares());
	        }
	        
	        uiModel.addAttribute("currentNav", "healthcare");
	        
	        return LIST_HEALTHCARE_VIEW;
	    }
	    
	    @RequestMapping(value = PATH +"/healthcares/update", method = RequestMethod.POST, produces = "text/html")
	    public String updateHealthCare(@Valid WSHealthCare WSHealthCare_, BindingResult bindingResult, Model uiModel, HttpServletRequest httpServletRequest) {
	        if (bindingResult.hasErrors()) {
	            populateHealthCareEditForm(uiModel, WSHealthCare_);
	            return UPDATE_HEALTHCARE_VIEW;
	        }
	        uiModel.asMap().clear();
	        healthCareService.update(WSHealthCare_);
	        return "redirect:"+PATH+"/healthcares/" + encodeUrlPathSegment(WSHealthCare_.getId().toString(), httpServletRequest);
	    }
	    
	    @RequestMapping(value = PATH + "/healthcares/{id}", params = "form", produces = "text/html")
	    public String updateHealthCareForm(@PathVariable("id") Long id, Model uiModel) {
	        populateHealthCareEditForm(uiModel, healthCareService.findHealthCare(id));
	        return UPDATE_HEALTHCARE_VIEW;
	    }
	    
	    @RequestMapping(value = PATH +"/healthcares/delete/{id}", method = RequestMethod.DELETE, produces = "text/html")
	    public String deleteHealthCare(@PathVariable("id") Long id, @RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size, Model uiModel) {
	        WSHealthCare WSHealthCare_ = healthCareService.findHealthCare(id);
	        WSHealthCare_.remove();
	        uiModel.asMap().clear();
	        uiModel.addAttribute("page", (page == null) ? "1" : page.toString());
	        uiModel.addAttribute("size", (size == null) ? "10" : size.toString());
	        return "redirect:" + PATH + "/healthcares";
	    }
	    
	    void populateHealthCareEditForm(Model uiModel, WSHealthCare WSHealthCare_) {
	        uiModel.addAttribute("WSHealthCare_", WSHealthCare_);
	        uiModel.addAttribute("wshealthcaretypes", healthCareTypeService.findAllHealthCareTypes());
	        uiModel.addAttribute("currentNav", "healthcare");
	    }
	    
	    
	    void populateHealthCareTypeEditForm(Model uiModel, WSHealthCareType WSHealthCareType_) {
	        uiModel.addAttribute("WSHealthCareType_", WSHealthCareType_);
	        uiModel.addAttribute("wshealthcares", WSHealthCareType_.getHealthCares());
	        uiModel.addAttribute("currentNav", "healthcare");
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
