// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.depich1987.wsih.web;

import com.depich1987.wsih.domain.WSMedecine;
import com.depich1987.wsih.domain.WSMedecineType;
import com.depich1987.wsih.web.MedecineTypeController;
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

privileged aspect MedecineTypeController_Roo_Controller {
    
    @RequestMapping(method = RequestMethod.POST, produces = "text/html")
    public String MedecineTypeController.create(@Valid WSMedecineType WSMedecineType_, BindingResult bindingResult, Model uiModel, HttpServletRequest httpServletRequest) {
        if (bindingResult.hasErrors()) {
            populateEditForm(uiModel, WSMedecineType_);
            return "wsmedecinetypes/create";
        }
        uiModel.asMap().clear();
        WSMedecineType_.persist();
        return "redirect:/wsmedecinetypes/" + encodeUrlPathSegment(WSMedecineType_.getId().toString(), httpServletRequest);
    }
    
    @RequestMapping(params = "form", produces = "text/html")
    public String MedecineTypeController.createForm(Model uiModel) {
        populateEditForm(uiModel, new WSMedecineType());
        return "wsmedecinetypes/create";
    }
    
    @RequestMapping(value = "/{id}", produces = "text/html")
    public String MedecineTypeController.show(@PathVariable("id") Long id, Model uiModel) {
        uiModel.addAttribute("wsmedecinetype_", WSMedecineType.findWSMedecineType(id));
        uiModel.addAttribute("itemId", id);
        return "wsmedecinetypes/show";
    }
    
    @RequestMapping(produces = "text/html")
    public String MedecineTypeController.list(@RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size, Model uiModel) {
        if (page != null || size != null) {
            int sizeNo = size == null ? 10 : size.intValue();
            final int firstResult = page == null ? 0 : (page.intValue() - 1) * sizeNo;
            uiModel.addAttribute("wsmedecinetypes", WSMedecineType.findWSMedecineTypeEntries(firstResult, sizeNo));
            float nrOfPages = (float) WSMedecineType.countWSMedecineTypes() / sizeNo;
            uiModel.addAttribute("maxPages", (int) ((nrOfPages > (int) nrOfPages || nrOfPages == 0.0) ? nrOfPages + 1 : nrOfPages));
        } else {
            uiModel.addAttribute("wsmedecinetypes", WSMedecineType.findAllWSMedecineTypes());
        }
        return "wsmedecinetypes/list";
    }
    
    @RequestMapping(method = RequestMethod.PUT, produces = "text/html")
    public String MedecineTypeController.update(@Valid WSMedecineType WSMedecineType_, BindingResult bindingResult, Model uiModel, HttpServletRequest httpServletRequest) {
        if (bindingResult.hasErrors()) {
            populateEditForm(uiModel, WSMedecineType_);
            return "wsmedecinetypes/update";
        }
        uiModel.asMap().clear();
        WSMedecineType_.merge();
        return "redirect:/wsmedecinetypes/" + encodeUrlPathSegment(WSMedecineType_.getId().toString(), httpServletRequest);
    }
    
    @RequestMapping(value = "/{id}", params = "form", produces = "text/html")
    public String MedecineTypeController.updateForm(@PathVariable("id") Long id, Model uiModel) {
        populateEditForm(uiModel, WSMedecineType.findWSMedecineType(id));
        return "wsmedecinetypes/update";
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = "text/html")
    public String MedecineTypeController.delete(@PathVariable("id") Long id, @RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size, Model uiModel) {
        WSMedecineType WSMedecineType_ = WSMedecineType.findWSMedecineType(id);
        WSMedecineType_.remove();
        uiModel.asMap().clear();
        uiModel.addAttribute("page", (page == null) ? "1" : page.toString());
        uiModel.addAttribute("size", (size == null) ? "10" : size.toString());
        return "redirect:/wsmedecinetypes";
    }
    
    void MedecineTypeController.populateEditForm(Model uiModel, WSMedecineType WSMedecineType_) {
        uiModel.addAttribute("WSMedecineType_", WSMedecineType_);
        uiModel.addAttribute("wsmedecines", WSMedecine.findAllWSMedecines());
    }
    
    String MedecineTypeController.encodeUrlPathSegment(String pathSegment, HttpServletRequest httpServletRequest) {
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
