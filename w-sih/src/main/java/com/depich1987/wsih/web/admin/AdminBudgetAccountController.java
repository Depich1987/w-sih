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
import org.springframework.web.servlet.support.RequestContext;
import org.springframework.web.util.UriUtils;
import org.springframework.web.util.WebUtils;

import com.depich1987.wsih.domain.AccountType;
import com.depich1987.wsih.domain.WSBudgetAccount;
import com.depich1987.wsih.fwk.WSUtils;
import com.depich1987.wsih.services.dao.BudgetAccountService;

@Controller
public class AdminBudgetAccountController {
	
	private static Logger logger = Logger.getLogger(AdminBudgetAccountController.class);
	
	private static final  String PATH = "/admin/budgetaccounts";
	private static final String CREATE_VIEW = "admin/budgetaccounts/create";
	private static final String SHOW_VIEW = "admin/budgetaccounts/show";
	private static final String LIST_VIEW = "admin/budgetaccounts/list";
	private static final String UPDATE_VIEW = "admin/budgetaccounts/update";
	
	@Autowired
	private BudgetAccountService budgetAccountService;
	
	public AdminBudgetAccountController() {
		// TODO Auto-generated constructor stub
	}
	
	@RequestMapping(value = PATH , produces = "text/html")
	public String index(){
		logger.debug("index() - budget account controller index !");
		return "redirect:" + PATH +"/list?size=10";
	}
	
	@RequestMapping(value = PATH + "/create", method = RequestMethod.POST, produces = "text/html")
    public String create(@Valid WSBudgetAccount WSBudgetAccount_, BindingResult bindingResult, Model uiModel, HttpServletRequest httpServletRequest) {
        if (bindingResult.hasErrors()) {
            populateEditForm(uiModel, WSBudgetAccount_);
            return CREATE_VIEW;
        }
        uiModel.asMap().clear();
        budgetAccountService.persist(WSBudgetAccount_);
        logger.debug("create() - a new Budget Account has been created in the database!");
        return "redirect:/"+ PATH +"/" + encodeUrlPathSegment(WSBudgetAccount_.getId().toString(), httpServletRequest);
    }
    
    @RequestMapping(value = PATH + "/create", params = "form", produces = "text/html")
    public String createForm(Model uiModel, HttpServletRequest httpServletRequest) {
        populateEditForm(uiModel, new WSBudgetAccount());

        RequestContext context = new RequestContext(httpServletRequest);
        AccountType accountType = WSUtils.getAccounType(httpServletRequest, context);
        uiModel.addAttribute("accountTypes", accountType);
        
        return CREATE_VIEW;
    }
    
    @RequestMapping(value = PATH +"/{id}", produces = "text/html")
    public String show(@PathVariable("id") Long id, Model uiModel, HttpServletRequest httpServletRequest) {
        uiModel.addAttribute("wsbudgetaccount_", budgetAccountService.findBudgetAccount(id));
        uiModel.addAttribute("itemId", id);
        
        RequestContext context = new RequestContext(httpServletRequest);
        uiModel.addAttribute("accountTypes", WSUtils.getAccounType(httpServletRequest, context));
        
        uiModel.addAttribute("currentNav", "budgetaccounts");
        
        return SHOW_VIEW;
    }
    
    @RequestMapping(value = PATH +"/list", produces = "text/html")
    public String list(@RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size, Model uiModel) {
        if (page != null || size != null) {
        	
            int sizeNo = size == null ? 10 : size.intValue();
            final int firstResult = page == null ? 0 : (page.intValue() - 1) * sizeNo;
            
            uiModel.addAttribute("wsbudgetaccounts", budgetAccountService.findBudgetAccountEntries(firstResult, sizeNo));
            float nrOfPages = (float) budgetAccountService.countBudgetAccounts() / sizeNo;
            uiModel.addAttribute("maxPages", (int) ((nrOfPages > (int) nrOfPages || nrOfPages == 0.0) ? nrOfPages + 1 : nrOfPages));
            
        } else {
            uiModel.addAttribute("wsbudgetaccounts", budgetAccountService.findAllBudgetAccounts());
        }
        
        uiModel.addAttribute("currentNav", "budgetaccounts");
        
        return LIST_VIEW;
    }
    
    @RequestMapping(value = PATH +"/update",method = RequestMethod.POST, produces = "text/html")
    public String update(@Valid WSBudgetAccount WSBudgetAccount_, BindingResult bindingResult, Model uiModel, HttpServletRequest httpServletRequest) {
        if (bindingResult.hasErrors()) {
            populateEditForm(uiModel, WSBudgetAccount_);
            return UPDATE_VIEW;
        }
        uiModel.asMap().clear();
        
        WSBudgetAccount budgetAccount = budgetAccountService.findBudgetAccount(WSBudgetAccount_.getId());
        budgetAccount.setAccountNumber(WSBudgetAccount_.getAccountNumber());
        budgetAccount.setName(WSBudgetAccount_.getName());
        budgetAccount.setNature(WSBudgetAccount_.getNature());
        budgetAccount.setDescription(WSBudgetAccount_.getDescription());
        
        budgetAccountService.merge(budgetAccount);
        logger.debug("update() -A Budget Account has been updated!");
        return "redirect:"+PATH +"/" + encodeUrlPathSegment(WSBudgetAccount_.getId().toString(), httpServletRequest);
    }
    
    @RequestMapping(value = PATH + "/{id}", params = "form", produces = "text/html")
    public String updateForm(@PathVariable("id") Long id, Model uiModel, HttpServletRequest httpServletRequest) {
        populateEditForm(uiModel, budgetAccountService.findBudgetAccount(id));
        
        RequestContext context = new RequestContext(httpServletRequest);
        uiModel.addAttribute("accountTypes", WSUtils.getAccounType(httpServletRequest, context));
        
        return UPDATE_VIEW;
    }
    
    @RequestMapping(value = PATH +"/delete/{id}", method = RequestMethod.GET, produces = "text/html")
    public String delete(@PathVariable("id") Long id, @RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size, Model uiModel) {
       
    	WSBudgetAccount WSBudgetAccount_ = budgetAccountService.findBudgetAccount(id);
        budgetAccountService.remove(WSBudgetAccount_.getId());
        
        uiModel.asMap().clear();
        uiModel.addAttribute("page", (page == null) ? "1" : page.toString());
        uiModel.addAttribute("size", (size == null) ? "10" : size.toString());
        
        return "redirect:"+PATH + "/list?size=10";
    }
    
    void populateEditForm(Model uiModel, WSBudgetAccount WSBudgetAccount_) {
        uiModel.addAttribute("WSBudgetAccount_", WSBudgetAccount_);
        uiModel.addAttribute("currentNav", "budgetaccounts");
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
