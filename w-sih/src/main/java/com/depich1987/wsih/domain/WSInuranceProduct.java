package com.depich1987.wsih.domain;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.tostring.RooToString;
import javax.persistence.ManyToOne;

@RooJavaBean
@RooToString
@RooJpaActiveRecord(table = "WS_INSURANCE_PRODUCT")
public class WSInuranceProduct {

    /**
     */
    private String title;

    /**
     */
    @ManyToOne
    private WSInsuranceCompany insuranceCompany;

    /**
     */
    @ManyToOne
    private WSHealthCare healthCare;
}
