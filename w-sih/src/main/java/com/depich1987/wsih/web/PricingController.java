package com.depich1987.wsih.web;
import com.depich1987.wsih.domain.WSPricing;
import org.springframework.roo.addon.web.mvc.controller.scaffold.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/wspricings")
@Controller
@RooWebScaffold(path = "wspricings", formBackingObject = WSPricing.class)
public class PricingController {
}
