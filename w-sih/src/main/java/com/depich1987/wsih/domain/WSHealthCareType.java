package com.depich1987.wsih.domain;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.tostring.RooToString;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.OneToMany;

@RooJavaBean
@RooToString
@RooJpaActiveRecord(table = "WS_HEALTHCARETYPE")
public class WSHealthCareType {

    /**
     */
    private String name;

    /**
     */
    private String description;
    
    
    /**
     */
    private String colorPicker;

    /**
     */
    @OneToMany(cascade = CascadeType.ALL)
    private Set<WSHealthCare> healthCares = new HashSet<WSHealthCare>();
}
