// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.depich1987.wsih.domain;

import com.depich1987.wsih.domain.WSDepartment;
import com.depich1987.wsih.domain.WSJob;
import java.util.Set;

privileged aspect WSDepartment_Roo_JavaBean {
    
    public String WSDepartment.getName() {
        return this.name;
    }
    
    public void WSDepartment.setName(String name) {
        this.name = name;
    }
    
    public String WSDepartment.getDescription() {
        return this.description;
    }
    
    public void WSDepartment.setDescription(String description) {
        this.description = description;
    }
    
    public String WSDepartment.getDepartmentType() {
        return this.departmentType;
    }
    
    public void WSDepartment.setDepartmentType(String departmentType) {
        this.departmentType = departmentType;
    }
    
    public Set<WSJob> WSDepartment.getJobs() {
        return this.jobs;
    }
    
    public void WSDepartment.setJobs(Set<WSJob> jobs) {
        this.jobs = jobs;
    }
    
}
