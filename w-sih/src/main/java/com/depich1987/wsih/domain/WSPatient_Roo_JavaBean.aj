// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.depich1987.wsih.domain;

import com.depich1987.wsih.domain.WSInsuranceProduct;
import com.depich1987.wsih.domain.WSMeeting;
import com.depich1987.wsih.domain.WSPatient;
import java.util.Date;
import java.util.Set;

privileged aspect WSPatient_Roo_JavaBean {
    
    public String WSPatient.getFolderRegistrationId() {
        return this.folderRegistrationId;
    }
    
    public void WSPatient.setFolderRegistrationId(String folderRegistrationId) {
        this.folderRegistrationId = folderRegistrationId;
    }
    
    public String WSPatient.getCivility() {
        return this.civility;
    }
    
    public void WSPatient.setCivility(String civility) {
        this.civility = civility;
    }
    
    public String WSPatient.getFirstName() {
        return this.firstName;
    }
    
    public void WSPatient.setFirstName(String firstName) {
        this.firstName = firstName;
    }
    
    public String WSPatient.getLastName() {
        return this.lastName;
    }
    
    public void WSPatient.setLastName(String lastName) {
        this.lastName = lastName;
    }
    
    public String WSPatient.getGender() {
        return this.gender;
    }
    
    public void WSPatient.setGender(String gender) {
        this.gender = gender;
    }
    
    public Date WSPatient.getBirthDate() {
        return this.birthDate;
    }
    
    public void WSPatient.setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }
    
    public String WSPatient.getBirthPlace() {
        return this.birthPlace;
    }
    
    public void WSPatient.setBirthPlace(String birthPlace) {
        this.birthPlace = birthPlace;
    }
    
    public String WSPatient.getCountry() {
        return this.country;
    }
    
    public void WSPatient.setCountry(String country) {
        this.country = country;
    }
    
    public String WSPatient.getJob() {
        return this.job;
    }
    
    public void WSPatient.setJob(String job) {
        this.job = job;
    }
    
    public String WSPatient.getAddress() {
        return this.address;
    }
    
    public void WSPatient.setAddress(String address) {
        this.address = address;
    }
    
    public String WSPatient.getCity() {
        return this.city;
    }
    
    public void WSPatient.setCity(String city) {
        this.city = city;
    }
    
    public float WSPatient.getLongitude() {
        return this.longitude;
    }
    
    public void WSPatient.setLongitude(float longitude) {
        this.longitude = longitude;
    }
    
    public float WSPatient.getLatitude() {
        return this.latitude;
    }
    
    public void WSPatient.setLatitude(float latitude) {
        this.latitude = latitude;
    }
    
    public String WSPatient.getPhoneHome() {
        return this.phoneHome;
    }
    
    public void WSPatient.setPhoneHome(String phoneHome) {
        this.phoneHome = phoneHome;
    }
    
    public String WSPatient.getMobilePhone() {
        return this.mobilePhone;
    }
    
    public void WSPatient.setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }
    
    public String WSPatient.getEmail() {
        return this.email;
    }
    
    public void WSPatient.setEmail(String email) {
        this.email = email;
    }
    
    public String WSPatient.getInsuredRegistrationId() {
        return this.insuredRegistrationId;
    }
    
    public void WSPatient.setInsuredRegistrationId(String insuredRegistrationId) {
        this.insuredRegistrationId = insuredRegistrationId;
    }
    
    public String WSPatient.getInsuredCardId() {
        return this.insuredCardId;
    }
    
    public void WSPatient.setInsuredCardId(String insuredCardId) {
        this.insuredCardId = insuredCardId;
    }
    
    public String WSPatient.getPrincipalInsuredRegistrationId() {
        return this.principalInsuredRegistrationId;
    }
    
    public void WSPatient.setPrincipalInsuredRegistrationId(String principalInsuredRegistrationId) {
        this.principalInsuredRegistrationId = principalInsuredRegistrationId;
    }
    
    public String WSPatient.getInsuredFullName() {
        return this.insuredFullName;
    }
    
    public void WSPatient.setInsuredFullName(String insuredFullName) {
        this.insuredFullName = insuredFullName;
    }
    
    public String WSPatient.getPitcureName() {
        return this.pitcureName;
    }
    
    public void WSPatient.setPitcureName(String pitcureName) {
        this.pitcureName = pitcureName;
    }
    
    public Date WSPatient.getCreationDate() {
        return this.creationDate;
    }
    
    public void WSPatient.setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }
    
    public String WSPatient.getCreatedBy() {
        return this.createdBy;
    }
    
    public void WSPatient.setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }
    
    public long WSPatient.getAssignedDoctor() {
        return this.assignedDoctor;
    }
    
    public void WSPatient.setAssignedDoctor(long assignedDoctor) {
        this.assignedDoctor = assignedDoctor;
    }
    
    public Boolean WSPatient.getSecuredFolder() {
        return this.securedFolder;
    }
    
    public void WSPatient.setSecuredFolder(Boolean securedFolder) {
        this.securedFolder = securedFolder;
    }
    
    public String WSPatient.getPassword() {
        return this.password;
    }
    
    public void WSPatient.setPassword(String password) {
        this.password = password;
    }
    
    public String WSPatient.getConfirmPassword() {
        return this.confirmPassword;
    }
    
    public void WSPatient.setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }
    
    public Set<WSMeeting> WSPatient.getMeetings() {
        return this.meetings;
    }
    
    public void WSPatient.setMeetings(Set<WSMeeting> meetings) {
        this.meetings = meetings;
    }
    
    public String WSPatient.getRegistrationCNI() {
        return this.registrationCNI;
    }
    
    public void WSPatient.setRegistrationCNI(String registrationCNI) {
        this.registrationCNI = registrationCNI;
    }
    
    public WSInsuranceProduct WSPatient.getInsuranceProduct() {
        return this.insuranceProduct;
    }
    
    public void WSPatient.setInsuranceProduct(WSInsuranceProduct insuranceProduct) {
        this.insuranceProduct = insuranceProduct;
    }
    
}
