package com.depich1987.wsih.web;
import com.depich1987.wsih.domain.WSJob;
import org.springframework.roo.addon.web.mvc.controller.scaffold.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/wsjobs")
@Controller
@RooWebScaffold(path = "wsjobs", formBackingObject = WSJob.class)
public class JobController {
}
