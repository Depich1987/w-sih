package com.depich1987.wsih.web;
import com.depich1987.wsih.domain.WSMedecine;
import org.springframework.roo.addon.web.mvc.controller.scaffold.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/wsmedecines")
@Controller
@RooWebScaffold(path = "wsmedecines", formBackingObject = WSMedecine.class)
public class MedecineController {
}
