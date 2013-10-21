package com.depich1987.wsih.domain;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.tostring.RooToString;
import javax.persistence.ManyToOne;

@RooJavaBean
@RooToString
@RooJpaActiveRecord(table = "WS_PATIENT", finders = { "findWSPatientsByPrincipalInsuredRegistrationIdLike" })
public class WSPatient {

    /**
     */
    //    @NotNull
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
    private String birthPlace;

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

    /**
     */
    @OneToMany(cascade = CascadeType.ALL)
    private Set<WSMeeting> meetings = new HashSet<WSMeeting>();

    /**
     */
    private String registrationCNI;

    /**
     */
    @ManyToOne(optional = true)
    private WSInsuranceProduct insuranceProduct;
}
