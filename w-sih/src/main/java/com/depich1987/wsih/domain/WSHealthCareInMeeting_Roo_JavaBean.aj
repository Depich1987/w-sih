// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.depich1987.wsih.domain;

import com.depich1987.wsih.domain.WSHealthCare;
import com.depich1987.wsih.domain.WSHealthCareInMeeting;
import com.depich1987.wsih.domain.WSMeeting;
import com.depich1987.wsih.domain.WSUser;
import java.util.Date;

privileged aspect WSHealthCareInMeeting_Roo_JavaBean {
    
    public WSUser WSHealthCareInMeeting.getUser() {
        return this.user;
    }
    
    public void WSHealthCareInMeeting.setUser(WSUser user) {
        this.user = user;
    }
    
    public Date WSHealthCareInMeeting.getCreationDate() {
        return this.creationDate;
    }
    
    public void WSHealthCareInMeeting.setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }
    
    public String WSHealthCareInMeeting.getCreatedBy() {
        return this.createdBy;
    }
    
    public void WSHealthCareInMeeting.setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }
    
    public Boolean WSHealthCareInMeeting.getStatus() {
        return this.status;
    }
    
    public void WSHealthCareInMeeting.setStatus(Boolean status) {
        this.status = status;
    }
    
    public WSMeeting WSHealthCareInMeeting.getMeeting() {
        return this.meeting;
    }
    
    public void WSHealthCareInMeeting.setMeeting(WSMeeting meeting) {
        this.meeting = meeting;
    }
    
    public WSHealthCare WSHealthCareInMeeting.getHealthCare() {
        return this.healthCare;
    }
    
    public void WSHealthCareInMeeting.setHealthCare(WSHealthCare healthCare) {
        this.healthCare = healthCare;
    }
    
    public String WSHealthCareInMeeting.getDiagnostic() {
        return this.diagnostic;
    }
    
    public void WSHealthCareInMeeting.setDiagnostic(String diagnostic) {
        this.diagnostic = diagnostic;
    }
    
    public Date WSHealthCareInMeeting.getMeetingDate() {
        return this.meetingDate;
    }
    
    public void WSHealthCareInMeeting.setMeetingDate(Date meetingDate) {
        this.meetingDate = meetingDate;
    }
    
    public Date WSHealthCareInMeeting.getStartTime() {
        return this.startTime;
    }
    
    public void WSHealthCareInMeeting.setStartTime(Date startTime) {
        this.startTime = startTime;
    }
    
    public Date WSHealthCareInMeeting.getEndTime() {
        return this.endTime;
    }
    
    public void WSHealthCareInMeeting.setEndTime(Date endTime) {
        this.endTime = endTime;
    }
    
}
