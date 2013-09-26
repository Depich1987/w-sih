package com.depich1987.wsih.domain;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.tostring.RooToString;

@RooJavaBean
@RooToString
@RooJpaActiveRecord(table = "WS_BUDGET_ACCOUNT", finders = { "findWSBudgetAccountsByAccountNumberEquals", "findWSBudgetAccountsByNature" })
public class WSBudgetAccount {

    /**
     */
    private String name;

    /**
     */
    private String accountNumber;

    /**
     */
    private String nature;

    /**
     */
    private String description;
}
