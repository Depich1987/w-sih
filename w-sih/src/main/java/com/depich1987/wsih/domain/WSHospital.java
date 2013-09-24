package com.depich1987.wsih.domain;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.tostring.RooToString;

@RooJavaBean
@RooToString
@RooJpaActiveRecord(table = "WS_HOSPITAL")
public class WSHospital {

    /**
     */
    private String name;

    /**
     */
    private String email;

    /**
     */
    private String phoneNumber;

    /**
     */
    private String city;

    /**
     */
    private String header;

    /**
     */
    private String footer;

    /**
     */
    private String address;
}
