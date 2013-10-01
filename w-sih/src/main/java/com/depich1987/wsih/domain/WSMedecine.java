package com.depich1987.wsih.domain;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.tostring.RooToString;

@RooJavaBean
@RooToString
@RooJpaActiveRecord(table = "WS_MEDECINE")
public class WSMedecine {

    /**
     */
    private String name;

    /**
     */
    private long lowerQuantity;

    /**
     */
    private long currentStock;
    
    
    /**
     */
    private String createdBy;

    /**
     */
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(style = "M-")
    private Date creationDate;

    /**
     */
    @ManyToOne
    private WSMedecineType medecineType;


    /**
     */
    @OneToMany(cascade = CascadeType.ALL)
    private List<WSStockPile> stockPiles = new ArrayList<WSStockPile>();
}
