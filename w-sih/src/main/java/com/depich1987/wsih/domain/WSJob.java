package com.depich1987.wsih.domain;
import javax.persistence.ManyToOne;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.tostring.RooToString;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.OneToMany;

@RooJavaBean
@RooToString
@RooJpaActiveRecord(table = "WS_JOB")
public class WSJob {

    /**
     */
    private String name;

    @ManyToOne
    private WSDepartment department;

    /**
     */
    private String description;

    /**
     */
    @OneToMany(cascade = CascadeType.ALL)
    private Set<WSUser> users = new HashSet<WSUser>();
}
