package com.depich1987.wsih.domain;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.tostring.RooToString;

import javax.persistence.ManyToOne;
import javax.persistence.Transient;

@RooJavaBean
@RooToString
@RooJpaActiveRecord(table = "WS_USER", finders = { "findWSUsersByJob", "findWSUsersByUserNameEquals" })
public class WSUser {

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
    private String userName;
    
    /** 
     */
    private String pictureName;

    /**
     */
    private String password;

    /**
     */
    @Transient
    private String confirmPassword;

    /**
     */
    private String userType;

    /**
     */
    @ManyToOne
    private WSJob job;
}
