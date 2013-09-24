package com.depich1987.wsih.web;
import com.depich1987.wsih.domain.WSHospital;
import org.springframework.roo.addon.web.mvc.controller.scaffold.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/wshostpitals")
@Controller
@RooWebScaffold(path = "wshostpitals", formBackingObject = WSHospital.class)
public class HostpitalController {
}
