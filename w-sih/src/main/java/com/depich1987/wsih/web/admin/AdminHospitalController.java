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
import org.springframework.web.util.UriUtils;
import org.springframework.web.util.WebUtils;

import com.depich1987.wsih.domain.WSHospital;
import com.depich1987.wsih.services.dao.HospitalService;

@Controller
public class AdminHospitalController{
	
	private static Logger logger = Logger.getLogger(AdminHospitalController.class);
	
	private static final  String PATH = "/admin/hospital";
	private static final String CREATE_VIEW = "admin/hospital/create";
	private static final String SHOW_VIEW = "admin/hospital/show";
	private static final String UPDATE_VIEW = "admin/hospital/update";
	
	@Autowired
	private HospitalService hospitalService;
	
	@RequestMapping(value = PATH , produces = "text/html")
	public String index(){
		long nbr = hospitalService.countHospitals();
		
		if(nbr > 0) {
			return "redirect:" +PATH + "/show"; 
			}	else{ 
				return "redirect:" +PATH + "/create?form";
				}
	}
	
	@RequestMapping( value = PATH + "/create", method = RequestMethod.POST, produces = "text/html")
    public String create(@Valid WSHospital hospital, BindingResult bindingResult, Model uiModel, HttpServletRequest httpServletRequest) {
        if (bindingResult.hasErrors()) {
            populateEditForm(uiModel, hospital);
            return CREATE_VIEW;
        }
        uiModel.asMap().clear();
        hospitalService.persist(hospital);
        logger.debug("A new Hospital has been created on the dataBase!");
        return "redirect:" + PATH + "/" +encodeUrlPathSegment(hospital.getId().toString(), httpServletRequest);
    }
    
    @RequestMapping(value = PATH + "/create", params = "form", produces = "text/html")
    public String createForm(Model uiModel) {
        populateEditForm(uiModel, new WSHospital());
        return CREATE_VIEW;
    }
    
    @RequestMapping(value = PATH + "/{id}", produces = "text/html")
    public String show(@PathVariable("id") Long id, Model uiModel) {
        uiModel.addAttribute("wshospital_", hospitalService.findHospital(id));
        uiModel.addAttribute("itemId", id);
        return SHOW_VIEW;
    }

    
    @RequestMapping(value =PATH +"/update", method = RequestMethod.PUT, produces = "text/html")
    public String update(@Valid WSHospital WSHospital_, BindingResult bindingResult, Model uiModel, HttpServletRequest httpServletRequest) {
        if (bindingResult.hasErrors()) {
            populateEditForm(uiModel, WSHospital_);
            return UPDATE_VIEW;
        }
        uiModel.asMap().clear();
        WSHospital_.merge();
        return "redirect:"+PATH +"/" + encodeUrlPathSegment(WSHospital_.getId().toString(), httpServletRequest);
    }
    
    @RequestMapping(value = PATH +"/{id}", params = "form", produces = "text/html")
    public String updateForm(@PathVariable("id") Long id, Model uiModel) {
        populateEditForm(uiModel, hospitalService.findHospital(id));
        return UPDATE_VIEW;
    }

    
    void populateEditForm(Model uiModel, WSHospital WSHospital_) {
        uiModel.addAttribute("WSHospital_", WSHospital_);
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