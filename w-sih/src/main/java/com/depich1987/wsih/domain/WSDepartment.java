package com.depich1987.wsih.domain;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.tostring.RooToString;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.OneToMany;
import javax.persistence.ManyToOne;

@RooJavaBean
@RooToString
@RooJpaActiveRecord(table = "WS_DEPARTMENT")
public class WSDepartment {

    /**
     */
    private String name;

    /**
     */
    private String description;

    /**
     */
    private String departmentType;

    /**
     */
    @OneToMany(cascade = CascadeType.ALL)
    private Set<WSMeeting> meetings = new HashSet<WSMeeting>();

    /**
     */
    @OneToMany(cascade = CascadeType.ALL)
    private Set<WSJob> jobs = new HashSet<WSJob>();

    /**
     */
    @ManyToOne
    private WSJob job;
}
