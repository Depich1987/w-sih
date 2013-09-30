package com.depich1987.wsih.web.admin;

import java.io.UnsupportedEncodingException;
import java.util.Date;

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

import com.depich1987.wsih.domain.WSMedecine;
import com.depich1987.wsih.domain.WSMedecineType;
import com.depich1987.wsih.domain.WSStockPile;
import com.depich1987.wsih.services.dao.MedecineService;
import com.depich1987.wsih.services.dao.MedecineTypeService;

@Controller
public class AdminMedecineManagerController {
	
	private static Logger logger = Logger.getLogger(AdminMedecineManagerController.class);
	
	private static final  String PATH = "/admin/stockmanager";
	
	private static final String INDEX_VIEW = "admin/stockmanager/stockindex";
	private static final String CREATE_MEDECINETYPE_VIEW = "admin/stockmanager/medecinetypes/create";
	private static final String SHOW_MEDECINETYPE_VIEW = "admin/stockmanager/medecinetypes/show";
	private static final String LIST_MEDECINETYPE_VIEW = "admin/stockmanager/medecinetypes/list";
	private static final String UPDATE_MEDECINETYPE_VIEW = "admin/stockmanager/medecinetypes/update";
	
	private static final String CREATE_MEDECINE_VIEW = "admin/stockmanager/medecines/create";
	private static final String SHOW_MEDECINE_VIEW = "admin/stockmanager/medecines/show";
	private static final String LIST_MEDECINE_VIEW = "admin/stockmanager/medecines/list";
	private static final String UPDATE_MEDECINE_VIEW = "admin/stockmanager/medecines/update";
	
	private static final String CREATE_STOCK_VIEW = "admin/stockmanager/stockpile/create";
	private static final String CREATE_STOCK_MEDECINE_VIEW = "admin/stockmanager/medecine/createstockpile";
	
	@Autowired
	private MedecineTypeService medecineTypeService;
	
	@Autowired
	private MedecineService medecineService;
	
	public AdminMedecineManagerController() {
		// TODO Auto-generated constructor stub
	}
	
	@RequestMapping(value = PATH , produces = "text/html")
	public String index(){
		logger.debug("index() - Access to medecine manager index.");
		return INDEX_VIEW;
		
	}
	
	
	 @RequestMapping(value = PATH +"/medecinetypes/create",method = RequestMethod.POST, produces = "text/html")
	    public String createMedecineType(@Valid WSMedecineType WSMedecineType_, BindingResult bindingResult, Model uiModel, HttpServletRequest httpServletRequest) {
	        if (bindingResult.hasErrors()) {
	        	populateMedecineTypeEditForm(uiModel, WSMedecineType_);
	            return CREATE_MEDECINETYPE_VIEW;
	        }
	        uiModel.asMap().clear();
	        medecineTypeService.persist(WSMedecineType_);
	        return "redirect:"+PATH +"/medecinetypes/" + encodeUrlPathSegment(WSMedecineType_.getId().toString(), httpServletRequest);
	    }
	    
	 
	 
	    @RequestMapping(value = PATH +"/medecinetypes/create", params = "form", produces = "text/html")
	    public String createMedecineTypeForm(Model uiModel) {
	    	populateMedecineTypeEditForm(uiModel, new WSMedecineType());
	        return CREATE_MEDECINETYPE_VIEW;
	    }
	    
	    
	    
	    @RequestMapping(value = PATH + "/medecinetypes/{id}", produces = "text/html")
	    public String showMedecineType(@PathVariable("id") Long id, Model uiModel) {
	        uiModel.addAttribute("wsmedecinetype_", WSMedecineType.findWSMedecineType(id));
	        uiModel.addAttribute("itemId", id);
	        return SHOW_MEDECINETYPE_VIEW;
	    }
	    
	    
	    
	    @RequestMapping(value = PATH +"/medecinetypes", produces = "text/html")
	    public String listMedecineType(@RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size, Model uiModel) {
	        if (page != null || size != null) {
	            int sizeNo = size == null ? 10 : size.intValue();
	            final int firstResult = page == null ? 0 : (page.intValue() - 1) * sizeNo;
	            uiModel.addAttribute("wsmedecinetypes", medecineTypeService.findMedecineTypeEntries(firstResult, sizeNo));
	            float nrOfPages = (float) medecineTypeService.countMedecineTypes() / sizeNo;
	            uiModel.addAttribute("maxPages", (int) ((nrOfPages > (int) nrOfPages || nrOfPages == 0.0) ? nrOfPages + 1 : nrOfPages));
	        } else {
	            uiModel.addAttribute("wsmedecinetypes", medecineTypeService.findAllMedecineTypes());
	        }
	        return LIST_MEDECINETYPE_VIEW;
	    }
	    
	    
	    
	    @RequestMapping(value = PATH +"/medecinetypes/update", method = RequestMethod.POST, produces = "text/html")
	    public String updateMedecineType(@Valid WSMedecineType WSMedecineType_, BindingResult bindingResult, Model uiModel, HttpServletRequest httpServletRequest) {
	        if (bindingResult.hasErrors()) {
	        	populateMedecineTypeEditForm(uiModel, WSMedecineType_);
	            return UPDATE_MEDECINETYPE_VIEW;
	        }
	        uiModel.asMap().clear();
	        
	        WSMedecineType medecineType = medecineTypeService.findMedecineType(WSMedecineType_.getId());
	        medecineType.setName(WSMedecineType_.getName());
	        medecineType.setDescription(WSMedecineType_.getDescription());
	        medecineTypeService.merge(medecineType);
	        
	        return "redirect:"+ PATH +"/medecinetypes/" + encodeUrlPathSegment(WSMedecineType_.getId().toString(), httpServletRequest);
	    }
	    
	    
	    
	    @RequestMapping(value = PATH +"/medecinetypes/{id}", params = "form", produces = "text/html")
	    public String updateMedecineTypeForm(@PathVariable("id") Long id, Model uiModel) {
	    	populateMedecineTypeEditForm(uiModel, medecineTypeService.findMedecineType(id));
	        return UPDATE_MEDECINETYPE_VIEW;
	    }
	    
	    
	    
	    @RequestMapping(value = PATH + "/medecinetypes/delete/{id}", method = RequestMethod.DELETE, produces = "text/html")
	    public String deleteMedecineType(@PathVariable("id") Long id, @RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size, Model uiModel) {

	        medecineTypeService.remove(id);
	        uiModel.asMap().clear();
	        uiModel.addAttribute("page", (page == null) ? "1" : page.toString());
	        uiModel.addAttribute("size", (size == null) ? "10" : size.toString());
	        return LIST_MEDECINETYPE_VIEW;
	    }
	    
	    
	    
	    void populateMedecineTypeEditForm(Model uiModel, WSMedecineType WSMedecineType_) {
	        uiModel.addAttribute("WSMedecineType_", WSMedecineType_);
//	        uiModel.addAttribute("wsmedecines", medecineService.findAllMedecines());
	    }
	
	
    @RequestMapping(value = PATH +"/medecines/create", method = RequestMethod.POST, produces = "text/html")
    public String createMedecine(@Valid WSMedecine WSMedecine_, BindingResult bindingResult, Model uiModel, HttpServletRequest httpServletRequest) {
        if (bindingResult.hasErrors()) {
        	populateMedecineEditForm(uiModel, WSMedecine_);
            return CREATE_MEDECINE_VIEW;
        }
        uiModel.asMap().clear();
        
        WSMedecine_.setCreationDate(new Date());
        if(WSMedecine_.getCurrentStock() > 0){
        	
        	medecineService.persist(WSMedecine_);
        	WSStockPile stockPile =  new WSStockPile();
        	
        	stockPile.setCreationDate(new Date());
        	stockPile.setQuantity(WSMedecine_.getCurrentStock());
        	stockPile.setMedecine(WSMedecine_);
        	medecineService.persist(stockPile);
        }else{
        	medecineService.persist(WSMedecine_);
        }
        return "redirect:"+ PATH +"/medecines/" + encodeUrlPathSegment(WSMedecine_.getId().toString(), httpServletRequest);
    }
    
    
    
    @RequestMapping(value = PATH +"/medecines/create", params = "form", produces = "text/html")
    public String createMedecineForm(Model uiModel) {
        populateMedecineEditForm(uiModel, new WSMedecine());
        return CREATE_MEDECINE_VIEW;
    }
    
    
    
    @RequestMapping(value = PATH + "/medecines/{id}", produces = "text/html")
    public String showMedecine(@PathVariable("id") Long id, Model uiModel) {
        uiModel.addAttribute("wsmedecine_", medecineService.findMedecine(id));
        uiModel.addAttribute("itemId", id);
        return SHOW_MEDECINE_VIEW;
    }
	
    
    
    @RequestMapping(value = PATH +"/medecines", produces = "text/html")
    public String listMedecines(@RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size, Model uiModel) {
        
    	if (page != null || size != null) {
        	
            int sizeNo = size == null ? 10 : size.intValue();
            final int firstResult = page == null ? 0 : (page.intValue() - 1) * sizeNo;
            uiModel.addAttribute("wsmedecines", medecineService.findMedecineEntries(firstResult, sizeNo));
            float nrOfPages = (float) medecineService.countMedecines() / sizeNo;
            uiModel.addAttribute("maxPages", (int) ((nrOfPages > (int) nrOfPages || nrOfPages == 0.0) ? nrOfPages + 1 : nrOfPages));
       
        } else {
            uiModel.addAttribute("wsmedecines", medecineService.findAllMedecines());
        }
       
        return LIST_MEDECINE_VIEW;
    }
    
    @RequestMapping(value = PATH +"/medecines/update", method = RequestMethod.POST, produces = "text/html")
    public String updateMedecine(@Valid WSMedecine WSMedecine_, BindingResult bindingResult, Model uiModel, HttpServletRequest httpServletRequest) {
        if (bindingResult.hasErrors()) {
            populateMedecineEditForm(uiModel, WSMedecine_);
            return UPDATE_MEDECINE_VIEW;
        }
        uiModel.asMap().clear();
        
       
        return "redirect:"+ PATH +"/medecines/" + encodeUrlPathSegment(WSMedecine_.getId().toString(), httpServletRequest);
    }
    
    @RequestMapping(value = PATH +"/medecines/{id}", params = "form", produces = "text/html")
    public String updateMedecineForm(@PathVariable("id") Long id, Model uiModel) {
        populateMedecineEditForm(uiModel, medecineService.findMedecine(id));
        return UPDATE_MEDECINE_VIEW;
    }
    
    void populateMedecineEditForm(Model uiModel, WSMedecine WSMedecine_) {
        uiModel.addAttribute("WSMedecine_", WSMedecine_);
        uiModel.addAttribute("wsmedecinetypes", medecineTypeService.findAllMedecineTypes());
        uiModel.addAttribute("wsstockpiles", WSStockPile.findAllWSStockPiles());
    }
    
    
    
    String encodeUrlPathSegment(String pathSegment, HttpServletRequest httpServletRequest) {
        String enc = httpServletRequest.getCharacterEncoding();
        if (enc == null) {
            enc = WebUtils.DEFAULT_CHARACTER_ENCODING;
        }
        try {
            pathSegment = UriUtils.encodePathSegment(pathSegment, enc);
        } catch (UnsupportedEncodingException uee) {
        	
        }
        return pathSegment;
    }

}
