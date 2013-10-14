package com.depich1987.wsih.domain;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

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
@RooJpaActiveRecord(table = "WS_MEETING")
public class WSMeeting {

    /**
     */
    private String description;
    
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(style = "M-")
    private Date meetingDate;

    /**
     */
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(style = "M-")
    private Date creationDate;

    /**
     */
    private String createdBy;
    
    /**
     */
    private Boolean status;

    /**
     */
    @ManyToOne
    private WSPatient patient;
    

    /**
     */
    @OneToMany(cascade = CascadeType.ALL)
    private Set<WSHealthCareInMeeting> healthCareInMeeting = new HashSet<WSHealthCareInMeeting>();
    
    
}
