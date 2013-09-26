package com.depich1987.wsih.web;
import com.depich1987.wsih.domain.WSInsuranceCompany;
import org.springframework.roo.addon.web.mvc.controller.scaffold.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/wsinsurancecompanys")
@Controller
@RooWebScaffold(path = "wsinsurancecompanys", formBackingObject = WSInsuranceCompany.class)
public class InsuranceCompanyController {
}
