package com.depich1987.wsih.domain;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.tostring.RooToString;

@RooJavaBean
@RooToString
@RooJpaActiveRecord(table = "WS_USER")
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
    private String password;

    /**
     */
    private String confirmPassword;

    /**
     */
    private String userType;

}
