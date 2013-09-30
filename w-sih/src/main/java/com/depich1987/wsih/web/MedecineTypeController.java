package com.depich1987.wsih.web;
import com.depich1987.wsih.domain.WSMedecineType;
import org.springframework.roo.addon.web.mvc.controller.scaffold.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/wsmedecinetypes")
@Controller
@RooWebScaffold(path = "wsmedecinetypes", formBackingObject = WSMedecineType.class)
public class MedecineTypeController {
}
