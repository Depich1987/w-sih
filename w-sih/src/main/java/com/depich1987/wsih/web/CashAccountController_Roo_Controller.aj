// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.depich1987.wsih.web;

import com.depich1987.wsih.domain.WSCashAccount;
import com.depich1987.wsih.web.CashAccountController;
import java.io.UnsupportedEncodingException;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.util.UriUtils;
import org.springframework.web.util.WebUtils;

privileged aspect CashAccountController_Roo_Controller {
    
    @RequestMapping(method = RequestMethod.POST, produces = "text/html")
    public String CashAccountController.create(@Valid WSCashAccount WSCashAccount_, BindingResult bindingResult, Model uiModel, HttpServletRequest httpServletRequest) {
        if (bindingResult.hasErrors()) {
            populateEditForm(uiModel, WSCashAccount_);
            return "wscashaccounts/create";
        }
        uiModel.asMap().clear();
        WSCashAccount_.persist();
        return "redirect:/wscashaccounts/" + encodeUrlPathSegment(WSCashAccount_.getId().toString(), httpServletRequest);
    }
    
    @RequestMapping(params = "form", produces = "text/html")
    public String CashAccountController.createForm(Model uiModel) {
        populateEditForm(uiModel, new WSCashAccount());
        return "wscashaccounts/create";
    }
    
    @RequestMapping(value = "/{id}", produces = "text/html")
    public String CashAccountController.show(@PathVariable("id") Long id, Model uiModel) {
        uiModel.addAttribute("wscashaccount_", WSCashAccount.findWSCashAccount(id));
        uiModel.addAttribute("itemId", id);
        return "wscashaccounts/show";
    }
    
    @RequestMapping(produces = "text/html")
    public String CashAccountController.list(@RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size, Model uiModel) {
        if (page != null || size != null) {
            int sizeNo = size == null ? 10 : size.intValue();
            final int firstResult = page == null ? 0 : (page.intValue() - 1) * sizeNo;
            uiModel.addAttribute("wscashaccounts", WSCashAccount.findWSCashAccountEntries(firstResult, sizeNo));
            float nrOfPages = (float) WSCashAccount.countWSCashAccounts() / sizeNo;
            uiModel.addAttribute("maxPages", (int) ((nrOfPages > (int) nrOfPages || nrOfPages == 0.0) ? nrOfPages + 1 : nrOfPages));
        } else {
            uiModel.addAttribute("wscashaccounts", WSCashAccount.findAllWSCashAccounts());
        }
        return "wscashaccounts/list";
    }
    
    @RequestMapping(method = RequestMethod.PUT, produces = "text/html")
    public String CashAccountController.update(@Valid WSCashAccount WSCashAccount_, BindingResult bindingResult, Model uiModel, HttpServletRequest httpServletRequest) {
        if (bindingResult.hasErrors()) {
            populateEditForm(uiModel, WSCashAccount_);
            return "wscashaccounts/update";
        }
        uiModel.asMap().clear();
        WSCashAccount_.merge();
        return "redirect:/wscashaccounts/" + encodeUrlPathSegment(WSCashAccount_.getId().toString(), httpServletRequest);
    }
    
    @RequestMapping(value = "/{id}", params = "form", produces = "text/html")
    public String CashAccountController.updateForm(@PathVariable("id") Long id, Model uiModel) {
        populateEditForm(uiModel, WSCashAccount.findWSCashAccount(id));
        return "wscashaccounts/update";
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = "text/html")
    public String CashAccountController.delete(@PathVariable("id") Long id, @RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size, Model uiModel) {
        WSCashAccount WSCashAccount_ = WSCashAccount.findWSCashAccount(id);
        WSCashAccount_.remove();
        uiModel.asMap().clear();
        uiModel.addAttribute("page", (page == null) ? "1" : page.toString());
        uiModel.addAttribute("size", (size == null) ? "10" : size.toString());
        return "redirect:/wscashaccounts";
    }
    
    void CashAccountController.populateEditForm(Model uiModel, WSCashAccount WSCashAccount_) {
        uiModel.addAttribute("WSCashAccount_", WSCashAccount_);
    }
    
    String CashAccountController.encodeUrlPathSegment(String pathSegment, HttpServletRequest httpServletRequest) {
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
