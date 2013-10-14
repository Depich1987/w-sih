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

import com.depich1987.wsih.domain.WSInsuranceCompany;
import com.depich1987.wsih.services.dao.InsuranceCompanyService;

@Controller
public class AdminInsuranceCompanyController {
	
	private static Logger logger = Logger.getLogger(AdminInsuranceCompanyController.class);
	
	private static final  String PATH = "/admin/insurancecompanies";
	private static final String CREATE_VIEW = "admin/insurancecompanies/create";
	private static final String SHOW_VIEW = "admin/insurancecompanies/show";
	private static final String LIST_VIEW = "admin/insurancecompanies/list";
	private static final String UPDATE_VIEW = "admin/insurancecompanies/update";

	
	
	@Autowired
	private InsuranceCompanyService insuranceCompanyService;
	
	public AdminInsuranceCompanyController() {
		// TODO Auto-generated constructor stub
	}
	
	@RequestMapping(value = PATH , produces = "text/html")
	public String index(){
		logger.debug("index() - Insurance Company controller index !");
		return "redirect:" + PATH +"/list?size=10";
	}
	
	@RequestMapping(value = PATH +"/create", method = RequestMethod.POST, produces = "text/html")
    public String create(@Valid WSInsuranceCompany WSInsuranceCompany_, BindingResult bindingResult, Model uiModel, HttpServletRequest httpServletRequest) {
        if (bindingResult.hasErrors()) {
            populateEditForm(uiModel, WSInsuranceCompany_);
            return CREATE_VIEW;
        }
        uiModel.asMap().clear();
        insuranceCompanyService.persist(WSInsuranceCompany_);
        logger.debug("create() - A Cash Account has been created!");
        return "redirect:"+ PATH +"/" + encodeUrlPathSegment(WSInsuranceCompany_.getId().toString(), httpServletRequest);
    }
    
    @RequestMapping(value = PATH +"/create", params = "form", produces = "text/html")
    public String createForm(Model uiModel) {
        populateEditForm(uiModel, new WSInsuranceCompany());
        return CREATE_VIEW;
    }
    
    @RequestMapping(value = PATH +"/{id}", produces = "text/html")
    public String show(@PathVariable("id") Long id, Model uiModel) {
        uiModel.addAttribute("wsinsurancecompany_", insuranceCompanyService.findInsuranceCompany(id));
        uiModel.addAttribute("itemId", id);
        uiModel.addAttribute("currentNav", "insurances");
        return SHOW_VIEW;
    }
    
    @RequestMapping(value = PATH +"/list", produces = "text/html")
    public String list(@RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size, Model uiModel) {
        if (page != null || size != null) {
            int sizeNo = size == null ? 10 : size.intValue();
            final int firstResult = page == null ? 0 : (page.intValue() - 1) * sizeNo;
            uiModel.addAttribute("wsinsurancecompanys", insuranceCompanyService.findInsuranceCompanyEntries(firstResult, sizeNo));
            float nrOfPages = (float) insuranceCompanyService.countInsuranceCompanies() / sizeNo;
            uiModel.addAttribute("maxPages", (int) ((nrOfPages > (int) nrOfPages || nrOfPages == 0.0) ? nrOfPages + 1 : nrOfPages));
        } else {
            uiModel.addAttribute("wsinsurancecompanys", insuranceCompanyService.findAllInsuranceCompanies());
        }
        
        uiModel.addAttribute("currentNav", "insurances");
        
        return LIST_VIEW;
    }
    
    @RequestMapping(value = PATH +"/update", method = RequestMethod.POST, produces = "text/html")
    public String update(@Valid WSInsuranceCompany WSInsuranceCompany_, BindingResult bindingResult, Model uiModel, HttpServletRequest httpServletRequest) {
        if (bindingResult.hasErrors()) {
            populateEditForm(uiModel, WSInsuranceCompany_);
            return UPDATE_VIEW;
        }
        uiModel.asMap().clear();
        WSInsuranceCompany insuranceCompany = insuranceCompanyService.findInsuranceCompany(WSInsuranceCompany_.getId());
        
        insuranceCompany.setCompanyName(WSInsuranceCompany_.getCompanyName());
        insuranceCompany.setContact(WSInsuranceCompany_.getContact());
        insuranceCompany.setEmail(WSInsuranceCompany_.getEmail());

        insuranceCompanyService.merge(insuranceCompany);
        logger.debug("update() - A Cash Account has been updated!");
        return "redirect:"+ PATH +"/" + encodeUrlPathSegment(WSInsuranceCompany_.getId().toString(), httpServletRequest);
    }
    
    @RequestMapping(value = PATH +"/{id}", params = "form", produces = "text/html")
    public String updateForm(@PathVariable("id") Long id, Model uiModel) {
        populateEditForm(uiModel, insuranceCompanyService.findInsuranceCompany(id));
        return UPDATE_VIEW;
    }
    
    @RequestMapping(value = PATH +"/delete/{id}", method = RequestMethod.GET, produces = "text/html")
    public String delete(@PathVariable("id") Long id, @RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size, Model uiModel) {
        WSInsuranceCompany WSInsuranceCompany_ = insuranceCompanyService.findInsuranceCompany(id);
        WSInsuranceCompany_.remove();
        uiModel.asMap().clear();
        uiModel.addAttribute("page", (page == null) ? "1" : page.toString());
        uiModel.addAttribute("size", (size == null) ? "10" : size.toString());
        return "redirect:" + PATH ;
    }
    
    void populateEditForm(Model uiModel, WSInsuranceCompany WSInsuranceCompany_) {
        uiModel.addAttribute("WSInsuranceCompany_", WSInsuranceCompany_);
        uiModel.addAttribute("currentNav", "insurances");
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
