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

import com.depich1987.wsih.domain.WSPricing;
import com.depich1987.wsih.services.dao.HealthCareService;
import com.depich1987.wsih.services.dao.InsuranceProductService;
import com.depich1987.wsih.services.dao.PricingService;

@Controller
public class AdminPricingController {
	
	private static Logger logger = Logger.getLogger(AdminPricingController.class);
	
	private static final  String PATH = "/admin/prices";
	
	private static final String CREATE_VIEW = "admin/prices/create";
	private static final String UPDATE_VIEW = "admin/prices/update";
	private static final String SHOW_VIEW = "admin/prices/show";
	private static final String LIST_VIEW = "admin/prices/list";
	
	@Autowired
	private PricingService pricingService;
	
	@Autowired
	private HealthCareService healthCareService;
	
	@Autowired
	private InsuranceProductService insuranceProductService;
	
	public AdminPricingController() {
		// TODO Auto-generated constructor stub
	}
	
	 @RequestMapping(value = PATH +"/create", method = RequestMethod.POST, produces = "text/html")
	    public String create(@Valid WSPricing WSPricing_, BindingResult bindingResult, Model uiModel, HttpServletRequest httpServletRequest) {
	        if (bindingResult.hasErrors()) {
	            populateEditForm(uiModel, WSPricing_);
	            logger.debug("create() - Pricing creation  failed!redirect to create view.");
	            return CREATE_VIEW;
	        }
	        uiModel.asMap().clear();
	        pricingService.persist(WSPricing_);
	        logger.debug("create() - Pricing has been created !redirect to show view.");
	        return "redirect:"+PATH +"/" + encodeUrlPathSegment(WSPricing_.getId().toString(), httpServletRequest);
	    }
	    
	    @RequestMapping(value = PATH +"/create", params = "form", produces = "text/html")
	    public String createForm(Model uiModel) {
	        populateEditForm(uiModel, new WSPricing());
	        return CREATE_VIEW;
	    }
	    
	    @RequestMapping(value = PATH +"/{id}", produces = "text/html")
	    public String show(@PathVariable("id") Long id, Model uiModel) {
	        uiModel.addAttribute("wspricing_", pricingService.findPricing(id));
	        uiModel.addAttribute("itemId", id);
	        uiModel.addAttribute("currentNav", "insurances");
	        return SHOW_VIEW;
	    }
	    
	    @RequestMapping(value = PATH , produces = "text/html")
	    public String list(@RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size, Model uiModel) {
	       
	    	if (page != null || size != null) {
	            int sizeNo = size == null ? 10 : size.intValue();
	            final int firstResult = page == null ? 0 : (page.intValue() - 1) * sizeNo;
	            uiModel.addAttribute("wspricings", pricingService.findPricingEntries(firstResult, sizeNo));
	            float nrOfPages = (float) pricingService.countPricings() / sizeNo;
	            uiModel.addAttribute("maxPages", (int) ((nrOfPages > (int) nrOfPages || nrOfPages == 0.0) ? nrOfPages + 1 : nrOfPages));
	        
	    	} else {
	            
	    		uiModel.addAttribute("wspricings", pricingService.findAllPricings());
	    		
	        }
	    	uiModel.addAttribute("currentNav", "insurances");
	        return LIST_VIEW;
	    }
	    
	    @RequestMapping(value = PATH +"/update", method = RequestMethod.POST, produces = "text/html")
	    public String update(@Valid WSPricing WSPricing_, BindingResult bindingResult, Model uiModel, HttpServletRequest httpServletRequest) {
	        if (bindingResult.hasErrors()) {
	            populateEditForm(uiModel, WSPricing_);
	            logger.debug("update() - Pricing update  failed!redirect to update view.");
	            return UPDATE_VIEW;
	        }
	        uiModel.asMap().clear();
	        pricingService.update(WSPricing_);
	        logger.debug("update() - Pricing update  has been updated!redirect to show view.");
	        return "redirect:"+PATH +"/" + encodeUrlPathSegment(WSPricing_.getId().toString(), httpServletRequest);
	    }
	    
	    @RequestMapping(value = PATH +"/{id}", params = "form", produces = "text/html")
	    public String updateForm(@PathVariable("id") Long id, Model uiModel) {
	        populateEditForm(uiModel, WSPricing.findWSPricing(id));
	        return UPDATE_VIEW;
	    }
	    
	    @RequestMapping(value = PATH +"/delete/{id}", method = RequestMethod.DELETE, produces = "text/html")
	    public String delete(@PathVariable("id") Long id, @RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size, Model uiModel) {
	        WSPricing WSPricing_ = WSPricing.findWSPricing(id);
	        WSPricing_.remove();
//	        uiModel.asMap().clear();
//	        uiModel.addAttribute("page", (page == null) ? "1" : page.toString());
//	        uiModel.addAttribute("size", (size == null) ? "10" : size.toString());
	        return "redirect:" + PATH +"?size=10";
	    }
	    
	    void populateEditForm(Model uiModel, WSPricing WSPricing_) {
	        uiModel.addAttribute("WSPricing_", WSPricing_);
	        uiModel.addAttribute("wshealthcares", healthCareService.findAllHealthCares());
	        uiModel.addAttribute("wsinsuranceproducts", insuranceProductService.findAllInsuranceProducts());
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
