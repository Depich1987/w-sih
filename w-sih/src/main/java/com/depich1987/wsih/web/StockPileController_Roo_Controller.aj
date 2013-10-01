// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.depich1987.wsih.web;

import com.depich1987.wsih.domain.WSMedecine;
import com.depich1987.wsih.domain.WSStockPile;
import com.depich1987.wsih.web.StockPileController;
import java.io.UnsupportedEncodingException;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.joda.time.format.DateTimeFormat;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.util.UriUtils;
import org.springframework.web.util.WebUtils;

privileged aspect StockPileController_Roo_Controller {
    
    @RequestMapping(method = RequestMethod.POST, produces = "text/html")
    public String StockPileController.create(@Valid WSStockPile WSStockPile_, BindingResult bindingResult, Model uiModel, HttpServletRequest httpServletRequest) {
        if (bindingResult.hasErrors()) {
            populateEditForm(uiModel, WSStockPile_);
            return "wsstockpiles/create";
        }
        uiModel.asMap().clear();
        WSStockPile_.persist();
        return "redirect:/wsstockpiles/" + encodeUrlPathSegment(WSStockPile_.getId().toString(), httpServletRequest);
    }
    
    @RequestMapping(params = "form", produces = "text/html")
    public String StockPileController.createForm(Model uiModel) {
        populateEditForm(uiModel, new WSStockPile());
        return "wsstockpiles/create";
    }
    
    @RequestMapping(value = "/{id}", produces = "text/html")
    public String StockPileController.show(@PathVariable("id") Long id, Model uiModel) {
        addDateTimeFormatPatterns(uiModel);
        uiModel.addAttribute("wsstockpile_", WSStockPile.findWSStockPile(id));
        uiModel.addAttribute("itemId", id);
        return "wsstockpiles/show";
    }
    
    @RequestMapping(produces = "text/html")
    public String StockPileController.list(@RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size, Model uiModel) {
        if (page != null || size != null) {
            int sizeNo = size == null ? 10 : size.intValue();
            final int firstResult = page == null ? 0 : (page.intValue() - 1) * sizeNo;
            uiModel.addAttribute("wsstockpiles", WSStockPile.findWSStockPileEntries(firstResult, sizeNo));
            float nrOfPages = (float) WSStockPile.countWSStockPiles() / sizeNo;
            uiModel.addAttribute("maxPages", (int) ((nrOfPages > (int) nrOfPages || nrOfPages == 0.0) ? nrOfPages + 1 : nrOfPages));
        } else {
            uiModel.addAttribute("wsstockpiles", WSStockPile.findAllWSStockPiles());
        }
        addDateTimeFormatPatterns(uiModel);
        return "wsstockpiles/list";
    }
    
    @RequestMapping(method = RequestMethod.PUT, produces = "text/html")
    public String StockPileController.update(@Valid WSStockPile WSStockPile_, BindingResult bindingResult, Model uiModel, HttpServletRequest httpServletRequest) {
        if (bindingResult.hasErrors()) {
            populateEditForm(uiModel, WSStockPile_);
            return "wsstockpiles/update";
        }
        uiModel.asMap().clear();
        WSStockPile_.merge();
        return "redirect:/wsstockpiles/" + encodeUrlPathSegment(WSStockPile_.getId().toString(), httpServletRequest);
    }
    
    @RequestMapping(value = "/{id}", params = "form", produces = "text/html")
    public String StockPileController.updateForm(@PathVariable("id") Long id, Model uiModel) {
        populateEditForm(uiModel, WSStockPile.findWSStockPile(id));
        return "wsstockpiles/update";
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = "text/html")
    public String StockPileController.delete(@PathVariable("id") Long id, @RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size, Model uiModel) {
        WSStockPile WSStockPile_ = WSStockPile.findWSStockPile(id);
        WSStockPile_.remove();
        uiModel.asMap().clear();
        uiModel.addAttribute("page", (page == null) ? "1" : page.toString());
        uiModel.addAttribute("size", (size == null) ? "10" : size.toString());
        return "redirect:/wsstockpiles";
    }
    
    void StockPileController.addDateTimeFormatPatterns(Model uiModel) {
        uiModel.addAttribute("WSStockPile__creationdate_date_format", DateTimeFormat.patternForStyle("M-", LocaleContextHolder.getLocale()));
    }
    
    void StockPileController.populateEditForm(Model uiModel, WSStockPile WSStockPile_) {
        uiModel.addAttribute("WSStockPile_", WSStockPile_);
        addDateTimeFormatPatterns(uiModel);
        uiModel.addAttribute("wsmedecines", WSMedecine.findAllWSMedecines());
    }
    
    String StockPileController.encodeUrlPathSegment(String pathSegment, HttpServletRequest httpServletRequest) {
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
