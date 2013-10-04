package com.depich1987.wsih.domain;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.tostring.RooToString;

import javax.validation.constraints.NotNull;

import java.util.Date;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.springframework.format.annotation.DateTimeFormat;

@RooJavaBean
@RooToString
@RooJpaActiveRecord(table = "WS_PATIENT")
public class WSPatient {

    /**
     */
    @NotNull
    private String folderRegistrationId;

    /**
     */
    private String civility;

    /**
     */
    private String firstName;

    /**
     */
    private String lastName;

    /**
     */
    private String gender;

    /**
     */
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(style = "M-")
    private Date birthDate;

    /**
     */
    private String bithPlace;

    /**
     */
    private String country;

    /**
     */
    private String job;

    /**
     */
    private String address;

    /**
     */
    private String city;
    
    /**
     */
    private float longitude;
    
    /** 
     */
    private float latitude;

    /**
     */
    private String phoneHome;

    /**
     */
    private String mobilePhone;

    /**
     */
    private String email;

    /**
     */
    private Boolean insured;

    /**
     */
    private String insuredRegistrationId;

    /**
     */
    private String insuredCardId;

    /**
     */
    private String principalInsuredRegistrationId;

    /**
     */
    private String insuredFullName;

    /**
     */
    private String pitcureName;

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
    private long assignedDoctor;

    /**
     */
    private Boolean securedFolder;

    /**
     */
    private String password;

    /**
     */
    @Transient
    private String confirmPassword;
}
