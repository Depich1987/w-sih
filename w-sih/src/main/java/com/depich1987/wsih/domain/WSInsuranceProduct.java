package com.depich1987.wsih.domain;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.tostring.RooToString;
import javax.persistence.ManyToOne;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.OneToMany;

@RooJavaBean
@RooToString
@RooJpaActiveRecord(table = "WS_INSURANCE_PRODUCT")
public class WSInsuranceProduct {

    /**
     */
    private String name;

    /**
     */
    private String contact;

    /**
     */
    @ManyToOne
    private WSInsuranceCompany insuranceCompany;

    /**
     */
    @OneToMany(cascade = CascadeType.ALL)
    private Set<WSPricing> prices = new HashSet<WSPricing>();
}
