package com.depich1987.wsih.web;
import com.depich1987.wsih.domain.WSInsuranceProduct;
import org.springframework.roo.addon.web.mvc.controller.scaffold.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/wsinuranceproducts")
@Controller
@RooWebScaffold(path = "wsinuranceproducts", formBackingObject = WSInsuranceProduct.class)
public class InsuranceProductController {
}
