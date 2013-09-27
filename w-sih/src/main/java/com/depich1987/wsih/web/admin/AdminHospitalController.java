package com.depich1987.wsih.web.admin;

import java.io.UnsupportedEncodingException;
import java.util.List;

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

import com.depich1987.wsih.domain.WSBudgetAccount;
import com.depich1987.wsih.domain.WSCashAccount;
import com.depich1987.wsih.domain.WSHospital;
import com.depich1987.wsih.services.dao.BudgetAccountService;
import com.depich1987.wsih.services.dao.CashAccountService;
import com.depich1987.wsih.services.dao.HospitalService;

@Controller
public class AdminHospitalController{
	
	private static Logger logger = Logger.getLogger(AdminHospitalController.class);
	
	private static final  String PATH = "/admin/hospital";
	private static final String CREATE_VIEW = "admin/hospital/create";
	private static final String SHOW_VIEW = "admin/hospital/show";
	private static final String UPDATE_VIEW = "admin/hospital/update";
	
	public AdminHospitalController() {
		// TODO Auto-generated constructor stub
	}
	
	@Autowired
	private HospitalService hospitalService;
	
	@Autowired
	private BudgetAccountService budgetAccountService;
	
	@Autowired
	private CashAccountService cashAccountService;
	
	@RequestMapping(value = PATH , produces = "text/html")
	public String index(HttpServletRequest httpServletRequest){
		List<WSHospital> hospitals = hospitalService.findAllHospitals();
		
		if(!hospitals.isEmpty()){
			return "redirect:" +PATH + "/"+ encodeUrlPathSegment(hospitals.get(0).getId().toString(), httpServletRequest); 
		}
		
		return "redirect:" +PATH + "/create?form";
	}
	
	@RequestMapping( value = PATH + "/create", method = RequestMethod.POST, produces = "text/html")
    public String create(@Valid WSHospital hospital, BindingResult bindingResult, Model uiModel, HttpServletRequest httpServletRequest) {
        if (bindingResult.hasErrors()) {
            populateEditForm(uiModel, hospital);
            return CREATE_VIEW;
        }
        uiModel.asMap().clear();
        hospitalService.persist(hospital);
        logger.debug("create() - A new Hospital has been created on the dataBase!");
        return "redirect:" + PATH + "/" +encodeUrlPathSegment(hospital.getId().toString(), httpServletRequest);
    }
    
    @RequestMapping(value = PATH + "/create", params = "form", produces = "text/html")
    public String createForm(Model uiModel) {
        populateEditForm(uiModel, new WSHospital());
        
        List<WSBudgetAccount> budgetAccounts = budgetAccountService.findAllBudgetAccounts();
        List<WSCashAccount> cashAccounts = cashAccountService.findAllCashAccounts();
        
        uiModel.addAttribute("budgetAccounts", budgetAccounts);
        uiModel.addAttribute("cashAccounts", cashAccounts);
        return CREATE_VIEW;
    }
    
    @RequestMapping(value = PATH + "/{id}", produces = "text/html")
    public String show(@PathVariable("id") Long id, Model uiModel) {
        uiModel.addAttribute("wshospital_", hospitalService.findHospital(id));
        uiModel.addAttribute("itemId", id);
        return SHOW_VIEW;
    }

    
    @RequestMapping(value = PATH +"/update", method = RequestMethod.POST, produces = "text/html")
    public String update(@Valid WSHospital WSHospital_, BindingResult bindingResult, Model uiModel, HttpServletRequest httpServletRequest) {
        
    	if (bindingResult.hasErrors()) {
            populateEditForm(uiModel, WSHospital_);
            return UPDATE_VIEW;
        }
    	
        uiModel.asMap().clear();
        WSHospital hospitalOld = hospitalService.findHospital(WSHospital_.getId());
        
        hospitalOld.setName(WSHospital_.getName());
        hospitalOld.setCity(WSHospital_.getCity());
        hospitalOld.setAddress(WSHospital_.getAddress());
        hospitalOld.setEmail(WSHospital_.getEmail());
        hospitalOld.setPhoneNumber(WSHospital_.getPhoneNumber());
        
        hospitalService.merge(hospitalOld);
        logger.debug("update() - Hospital details has been updated with success!");
        
        return "redirect:"+ PATH +"/" + encodeUrlPathSegment(hospitalOld.getId().toString(), httpServletRequest);
    }
    
    @RequestMapping(value = PATH +"/{id}", params = "form", produces = "text/html")
    public String updateForm(@PathVariable("id") Long id, Model uiModel) {
        populateEditForm(uiModel, hospitalService.findHospital(id));
        
        List<WSBudgetAccount> budgetAccounts = budgetAccountService.findAllBudgetAccounts();
        List<WSCashAccount> cashAccounts = cashAccountService.findAllCashAccounts();
        
        uiModel.addAttribute("budgetAccounts", budgetAccounts);
        uiModel.addAttribute("cashAccounts", cashAccounts);
        
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