// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.depich1987.wsih.domain;

import com.depich1987.wsih.domain.WSDepartment;
import com.depich1987.wsih.domain.WSMeeting;
import java.util.Date;

privileged aspect WSMeeting_Roo_JavaBean {
    
    public Date WSMeeting.getMeetingDate() {
        return this.meetingDate;
    }
    
    public void WSMeeting.setMeetingDate(Date meetingDate) {
        this.meetingDate = meetingDate;
    }
    
    public String WSMeeting.getDescription() {
        return this.description;
    }
    
    public void WSMeeting.setDescription(String description) {
        this.description = description;
    }
    
    public WSDepartment WSMeeting.getDepartment() {
        return this.department;
    }
    
    public void WSMeeting.setDepartment(WSDepartment department) {
        this.department = department;
    }
    
    public Date WSMeeting.getStartTime() {
        return this.startTime;
    }
    
    public void WSMeeting.setStartTime(Date startTime) {
        this.startTime = startTime;
    }
    
    public Date WSMeeting.getEndTime() {
        return this.endTime;
    }
    
    public void WSMeeting.setEndTime(Date endTime) {
        this.endTime = endTime;
    }
    
    public Boolean WSMeeting.getStatus() {
        return this.status;
    }
    
    public void WSMeeting.setStatus(Boolean status) {
        this.status = status;
    }
    
}
