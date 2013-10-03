package com.depich1987.wsih.web;
import com.depich1987.wsih.domain.WSHealthCareType;
import org.springframework.roo.addon.web.mvc.controller.scaffold.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/wshealthcaretypes")
@Controller
@RooWebScaffold(path = "wshealthcaretypes", formBackingObject = WSHealthCareType.class)
public class HealthCareTypeController {
}
