// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.depich1987.wsih.domain;

import com.depich1987.wsih.domain.WSHealthCareInMeeting;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;

privileged aspect WSHealthCareInMeeting_Roo_Jpa_Entity {
    
    declare @type: WSHealthCareInMeeting: @Entity;
    
    declare @type: WSHealthCareInMeeting: @Table(name = "WS_HEALTHCARE_IN_MEETING");
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long WSHealthCareInMeeting.id;
    
    @Version
    @Column(name = "version")
    private Integer WSHealthCareInMeeting.version;
    
    public Long WSHealthCareInMeeting.getId() {
        return this.id;
    }
    
    public void WSHealthCareInMeeting.setId(Long id) {
        this.id = id;
    }
    
    public Integer WSHealthCareInMeeting.getVersion() {
        return this.version;
    }
    
    public void WSHealthCareInMeeting.setVersion(Integer version) {
        this.version = version;
    }
    
}
