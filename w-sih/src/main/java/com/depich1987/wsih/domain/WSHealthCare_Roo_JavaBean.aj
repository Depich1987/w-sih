// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.depich1987.wsih.domain;

import com.depich1987.wsih.domain.WSHealthCare;
import com.depich1987.wsih.domain.WSHealthCareType;

privileged aspect WSHealthCare_Roo_JavaBean {
    
    public String WSHealthCare.getName() {
        return this.name;
    }
    
    public void WSHealthCare.setName(String name) {
        this.name = name;
    }
    
    public WSHealthCareType WSHealthCare.getHealthCareType() {
        return this.healthCareType;
    }
    
    public void WSHealthCare.setHealthCareType(WSHealthCareType healthCareType) {
        this.healthCareType = healthCareType;
    }
    
}
