package com.depich1987.wsih.domain;
import java.util.Date;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.tostring.RooToString;

@RooJavaBean
@RooToString
@RooJpaActiveRecord(table = "WS_HEALTHCARE_IN_MEETING")
public class WSHealthCareInMeeting {

    /**
     */
    private WSUser user;

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
    private WSMeeting meeting;

    /**
     */
    @ManyToOne
    private WSHealthCare healthCare;

    /**
     */
    private String diagnostic;
    
    /**
     */
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(style = "S-")
    private Date meetingDate;

    /**
     */
    @Temporal(TemporalType.TIME)
    @DateTimeFormat(style = "-S")
    private Date startTime;
    
    /**
     */
    @Temporal(TemporalType.TIME)
    @DateTimeFormat(style = "-S")
    private Date endTime;
}
