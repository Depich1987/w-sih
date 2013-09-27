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

import com.depich1987.wsih.domain.WSCashAccount;
import com.depich1987.wsih.services.dao.CashAccountService;

@Controller
public class AdminCashAccountController {
	
	private static Logger logger = Logger.getLogger(AdminCashAccountController.class);
	
	private static final  String PATH = "/admin/cashaccounts";
	private static final String CREATE_VIEW = "admin/cashaccounts/create";
	private static final String SHOW_VIEW = "admin/cashaccounts/show";
	private static final String LIST_VIEW = "admin/cashaccounts/list";
	private static final String UPDATE_VIEW = "admin/cashaccounts/update";
	
	@Autowired
	private CashAccountService cashAccountService;
	
	
	public AdminCashAccountController() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	@RequestMapping(value = PATH , produces = "text/html")
	public String index(){
		logger.debug("index() - cash account controller index !");
		return "redirect:" + PATH +"/list?size=10";
	}
	
	
	
	@RequestMapping(value = PATH +"/create", method = RequestMethod.POST, produces = "text/html")
    public String create(@Valid WSCashAccount WSCashAccount_, BindingResult bindingResult, Model uiModel, HttpServletRequest httpServletRequest) {
        if (bindingResult.hasErrors()) {
            populateEditForm(uiModel, WSCashAccount_);
            return CREATE_VIEW;
        }
        uiModel.asMap().clear();
        cashAccountService.persist(WSCashAccount_);
        logger.debug("create() - a new Cash Account has been created in the database!");
        return "redirect:"+PATH +"/" + encodeUrlPathSegment(WSCashAccount_.getId().toString(), httpServletRequest);
    }
    
	
	
    @RequestMapping(value = PATH + "/create", params = "form", produces = "text/html")
    public String createForm(Model uiModel) {
        populateEditForm(uiModel, new WSCashAccount());
        return CREATE_VIEW;
    }
    
    
    
    @RequestMapping(value = PATH + "/{id}", produces = "text/html")
    public String show(@PathVariable("id") Long id, Model uiModel) {
        uiModel.addAttribute("wscashaccount_", cashAccountService.findCashAccount(id));
        uiModel.addAttribute("itemId", id);
        return SHOW_VIEW;
    }
    
    
    
    @RequestMapping(value = PATH + "/list", produces = "text/html")
    public String list(@RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size, Model uiModel) {
        if (page != null || size != null) {
        	
            int sizeNo = size == null ? 10 : size.intValue();
            final int firstResult = page == null ? 0 : (page.intValue() - 1) * sizeNo;
            
            uiModel.addAttribute("wscashaccounts", cashAccountService.findCashAccountEntries(firstResult, sizeNo));
            float nrOfPages = (float) cashAccountService.countCashAccounts() / sizeNo;
            
            uiModel.addAttribute("maxPages", (int) ((nrOfPages > (int) nrOfPages || nrOfPages == 0.0) ? nrOfPages + 1 : nrOfPages));
       
        } else {
            uiModel.addAttribute("wscashaccounts", cashAccountService.findAllCashAccounts());
        }
        return LIST_VIEW;
    }
    
    @RequestMapping(value = PATH + "/update", method = RequestMethod.POST, produces = "text/html")
    public String update(@Valid WSCashAccount WSCashAccount_, BindingResult bindingResult, Model uiModel, HttpServletRequest httpServletRequest) {
        if (bindingResult.hasErrors()) {
            populateEditForm(uiModel, WSCashAccount_);
            return UPDATE_VIEW;
        }
        uiModel.asMap().clear();
        WSCashAccount cashAccount = cashAccountService.findCashAccount(WSCashAccount_.getId());
        cashAccount.setName(WSCashAccount_.getName());
        cashAccount.setAccountNumber(WSCashAccount_.getAccountNumber());
        
        cashAccountService.merge(cashAccount);
        logger.debug("update() - A Cash Account has been updated!");
        return "redirect:"+ PATH + "/" + encodeUrlPathSegment(WSCashAccount_.getId().toString(), httpServletRequest);
    }
    
    @RequestMapping(value = PATH + "/{id}", params = "form", produces = "text/html")
    public String updateForm(@PathVariable("id") Long id, Model uiModel) {
        populateEditForm(uiModel, cashAccountService.findCashAccount(id));
        return UPDATE_VIEW;
    }
    
    @RequestMapping(value = PATH + "delete/{id}", method = RequestMethod.GET, produces = "text/html")
    public String delete(@PathVariable("id") Long id, @RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size, Model uiModel) {
        WSCashAccount WSCashAccount_ = cashAccountService.findCashAccount(id);
        cashAccountService.remove(WSCashAccount_.getId());
        uiModel.asMap().clear();
        uiModel.addAttribute("page", (page == null) ? "1" : page.toString());
        uiModel.addAttribute("size", (size == null) ? "10" : size.toString());
        
        return "redirect:"+ PATH +"/liste?size=10";
    }
    
    void populateEditForm(Model uiModel, WSCashAccount WSCashAccount_) {
        uiModel.addAttribute("WSCashAccount_", WSCashAccount_);
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
