package com.depich1987.wsih.domain;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.activerecord.RooJpaActiveRecord;
import org.springframework.roo.addon.tostring.RooToString;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.OneToMany;

@RooJavaBean
@RooToString
@RooJpaActiveRecord(table = "WS_MEDECINE_TYPE")
public class WSMedecineType {

    /**
     */
    private String name;

    /**
     */
    private String description;

    /**
     */
    @OneToMany(cascade = CascadeType.ALL)
    private List<WSMedecine> medecines = new ArrayList<WSMedecine>();
}
