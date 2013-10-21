package com.depich1987.wsih.domain;
import javax.persistence.ManyToOne;

import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.tostring.RooToString;

@RooJavaBean
@RooToString
@RooJpaActiveRecord(table = "WS_PRICING")
public class WSPricing {

    /**
     */
    private int price;

    /**
     */
    private double insuranceRate;

    /**
     */
    private double rateBNC;

    /**
     */
    private double vatRate;

    /**
     */
    @ManyToOne
    private WSInsuranceProduct insuranceProduct;

    /**
     */
    @ManyToOne
    private WSHealthCare healthCare;
    
    
}
