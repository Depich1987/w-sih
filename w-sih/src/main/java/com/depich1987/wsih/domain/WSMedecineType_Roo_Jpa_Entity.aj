// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.depich1987.wsih.domain;

import com.depich1987.wsih.domain.WSMedecineType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;

privileged aspect WSMedecineType_Roo_Jpa_Entity {
    
    declare @type: WSMedecineType: @Entity;
    
    declare @type: WSMedecineType: @Table(name = "WS_MEDECINE_TYPE");
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long WSMedecineType.id;
    
    @Version
    @Column(name = "version")
    private Integer WSMedecineType.version;
    
    public Long WSMedecineType.getId() {
        return this.id;
    }
    
    public void WSMedecineType.setId(Long id) {
        this.id = id;
    }
    
    public Integer WSMedecineType.getVersion() {
        return this.version;
    }
    
    public void WSMedecineType.setVersion(Integer version) {
        this.version = version;
    }
    
}
