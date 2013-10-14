package com.depich1987.wsih.web;
import com.depich1987.wsih.domain.WSPatient;
import org.springframework.roo.addon.web.mvc.controller.scaffold.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/wspatients")
@Controller
@RooWebScaffold(path = "wspatients", formBackingObject = WSPatient.class)
public class PatientController {
}
