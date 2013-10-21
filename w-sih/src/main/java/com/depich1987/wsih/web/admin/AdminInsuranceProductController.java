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

import com.depich1987.wsih.domain.WSInsuranceProduct;
import com.depich1987.wsih.services.dao.InsuranceProductService;

@Controller
public class AdminInsuranceProductController {

	private static Logger logger = Logger.getLogger(AdminInsuranceProductController.class);
	
	private static final  String PATH = "/admin/insuranceproducts";
	
	private static final String CREATE_VIEW = "admin/insuranceproducts/create";
	private static final String UPDATE_VIEW = "admin/insuranceproducts/update";
	private static final String SHOW_VIEW = "admin/insuranceproducts/show";
	private static final String LIST_VIEW = "admin/insuranceproducts/list";
	
	@Autowired
	private InsuranceProductService insuranceProductService;
	
	
	public AdminInsuranceProductController() {
		// TODO Auto-generated constructor stub
	}
	
    @RequestMapping(value = PATH +"/create", method = RequestMethod.POST, produces = "text/html")
    public String create(@Valid WSInsuranceProduct WSInsuranceProduct_, BindingResult bindingResult, Model uiModel, HttpServletRequest httpServletRequest) {
        if (bindingResult.hasErrors()) {
            populateEditForm(uiModel, WSInsuranceProduct_);
            logger.debug("create() - Insurance Product creation failed!redirect to creation view.");
            return CREATE_VIEW;
        }
        uiModel.asMap().clear();
        insuranceProductService.persist(WSInsuranceProduct_);
        logger.debug("create() - A new Insurance Product has been created!redirect to show view.");
        return "redirect:" + PATH + "/" + encodeUrlPathSegment(WSInsuranceProduct_.getId().toString(), httpServletRequest);
    }
    
    @RequestMapping(value = PATH +"/create", params = "form", produces = "text/html")
    public String createForm(Model uiModel) {
        populateEditForm(uiModel, new WSInsuranceProduct());
        return CREATE_VIEW;
    }
    
    @RequestMapping(value = PATH +"/{id}", produces = "text/html")
    public String show(@PathVariable("id") Long id, Model uiModel) {
    	WSInsuranceProduct insuranceProduct = insuranceProductService.findInsuranceProduct(id);
        uiModel.addAttribute("wsInsuranceProduct_", insuranceProduct);
        uiModel.addAttribute("prices", insuranceProduct.getPrices());
        uiModel.addAttribute("itemId", id);
        uiModel.addAttribute("currentNav", "insurances");
        return SHOW_VIEW;
    }
    
    @RequestMapping(value = PATH, produces = "text/html")
    public String list(@RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size, Model uiModel) {
        
    	if (page != null || size != null) {
            int sizeNo = size == null ? 10 : size.intValue();
            final int firstResult = page == null ? 0 : (page.intValue() - 1) * sizeNo;
            uiModel.addAttribute("wsinsuranceproducts", insuranceProductService.findInsuranceProductEntries(firstResult, sizeNo));
            float nrOfPages = (float) insuranceProductService.countInsuranceProducts() / sizeNo;
            uiModel.addAttribute("maxPages", (int) ((nrOfPages > (int) nrOfPages || nrOfPages == 0.0) ? nrOfPages + 1 : nrOfPages));
        
    	} else {
    		
            uiModel.addAttribute("wsinsuranceproducts", insuranceProductService.findAllInsuranceProducts());
        }
    	
    	uiModel.addAttribute("currentNav", "insurances");
    	
        return LIST_VIEW;
    }
    
    @RequestMapping(value = PATH +"/update",method = RequestMethod.POST, produces = "text/html")
    public String update(@Valid WSInsuranceProduct WSInsuranceProduct_, BindingResult bindingResult, Model uiModel, HttpServletRequest httpServletRequest) {
        if (bindingResult.hasErrors()) {
            populateEditForm(uiModel, WSInsuranceProduct_);
            logger.debug("update() - Insurance Product update  failed!redirect to update view.");
            return UPDATE_VIEW;
        }
        uiModel.asMap().clear();
        insuranceProductService.update(WSInsuranceProduct_);
        logger.debug("update() - Insurance Product update  has been updated!redirect to show view.");
        return "redirect:"+PATH +"/" + encodeUrlPathSegment(WSInsuranceProduct_.getId().toString(), httpServletRequest);
    }
    
    @RequestMapping(value = PATH + "/{id}", params = "form", produces = "text/html")
    public String updateForm(@PathVariable("id") Long id, Model uiModel) {
        populateEditForm(uiModel, insuranceProductService.findInsuranceProduct(id));
        return UPDATE_VIEW;
    }
    
    @RequestMapping(value = PATH +"/delete/{id}", method = RequestMethod.DELETE, produces = "text/html")
    public String delete(@PathVariable("id") Long id, @RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size, Model uiModel) {
        WSInsuranceProduct WSInsuranceProduct_ = WSInsuranceProduct.findWSInsuranceProduct(id);
        WSInsuranceProduct_.remove();
//        uiModel.asMap().clear();
//        uiModel.addAttribute("page", (page == null) ? "1" : page.toString());
//        uiModel.addAttribute("size", (size == null) ? "10" : size.toString());
        return "redirect:"+ PATH +"?size=10";
    }
    
    void populateEditForm(Model uiModel, WSInsuranceProduct WSInsuranceProduct_) {
        uiModel.addAttribute("WSInsuranceProduct_", WSInsuranceProduct_);
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
