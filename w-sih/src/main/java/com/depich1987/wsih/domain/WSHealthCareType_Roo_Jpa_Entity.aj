// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.depich1987.wsih.domain;

import com.depich1987.wsih.domain.WSHealthCareType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Version;

privileged aspect WSHealthCareType_Roo_Jpa_Entity {
    
    declare @type: WSHealthCareType: @Entity;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long WSHealthCareType.id;
    
    @Version
    @Column(name = "version")
    private Integer WSHealthCareType.version;
    
    public Long WSHealthCareType.getId() {
        return this.id;
    }
    
    public void WSHealthCareType.setId(Long id) {
        this.id = id;
    }
    
    public Integer WSHealthCareType.getVersion() {
        return this.version;
    }
    
    public void WSHealthCareType.setVersion(Integer version) {
        this.version = version;
    }
    
}
