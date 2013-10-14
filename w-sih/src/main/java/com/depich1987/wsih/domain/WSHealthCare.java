package com.depich1987.wsih.domain;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.tostring.RooToString;

@RooJavaBean
@RooToString
@RooJpaActiveRecord(table = "WS_HEALTHCARE")
public class WSHealthCare {

    /**
     */
    private String name;

    /**
     */
    @ManyToOne
    private WSHealthCareType healthCareType;

    /**
     */
    @OneToMany(cascade = CascadeType.ALL)
    private Set<WSInuranceProduct> insuranceProducts = new HashSet<WSInuranceProduct>();
    

    /**
     */
    @OneToMany(cascade = CascadeType.ALL)
    private Set<WSHealthCareInMeeting> healthCareInMeeting = new HashSet<WSHealthCareInMeeting>();
}
