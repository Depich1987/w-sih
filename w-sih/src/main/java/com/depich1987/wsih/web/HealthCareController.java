package com.depich1987.wsih.web;
import com.depich1987.wsih.domain.WSHealthCare;
import org.springframework.roo.addon.web.mvc.controller.scaffold.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/wshealthcares")
@Controller
@RooWebScaffold(path = "wshealthcares", formBackingObject = WSHealthCare.class)
public class HealthCareController {
}
