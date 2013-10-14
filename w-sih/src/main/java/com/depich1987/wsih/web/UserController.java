package com.depich1987.wsih.web;
import com.depich1987.wsih.domain.WSUser;
import org.springframework.roo.addon.web.mvc.controller.scaffold.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/wsusers")
@Controller
@RooWebScaffold(path = "wsusers", formBackingObject = WSUser.class)
public class UserController {
}
