package com.depich1987.wsih.web;
import com.depich1987.wsih.domain.WSCashAccount;
import org.springframework.roo.addon.web.mvc.controller.scaffold.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/wscashaccounts")
@Controller
@RooWebScaffold(path = "wscashaccounts", formBackingObject = WSCashAccount.class)
public class CashAccountController {
}
