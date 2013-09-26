package com.depich1987.wsih.web;
import com.depich1987.wsih.domain.WSBudgetAccount;
import org.springframework.roo.addon.web.mvc.controller.scaffold.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/wsbudgetaccounts")
@Controller
@RooWebScaffold(path = "wsbudgetaccounts", formBackingObject = WSBudgetAccount.class)
public class BudgetAccountController {
}
