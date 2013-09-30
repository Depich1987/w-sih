package com.depich1987.wsih.domain;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.tostring.RooToString;
import java.util.Date;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.springframework.format.annotation.DateTimeFormat;
import javax.persistence.ManyToOne;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.ManyToMany;

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
    private long currentStock;

    /**
     */
    @ManyToMany(cascade = CascadeType.ALL)
    private List<WSStockPile> stockPiles = new ArrayList<WSStockPile>();
}
