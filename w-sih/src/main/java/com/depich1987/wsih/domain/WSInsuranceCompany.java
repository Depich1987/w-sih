package com.depich1987.wsih.domain;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.tostring.RooToString;

@RooJavaBean
@RooToString
@RooJpaActiveRecord(table = "WS_INSURANCE_COMPANY")
public class WSInsuranceCompany {

    /**
     */
    private String companyName;

    /**
     */
    private String contact;

    /**
     */
    private String email;
}
