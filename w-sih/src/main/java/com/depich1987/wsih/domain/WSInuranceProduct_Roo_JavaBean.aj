// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.depich1987.wsih.domain;

import com.depich1987.wsih.domain.WSHealthCare;
import com.depich1987.wsih.domain.WSInsuranceCompany;
import com.depich1987.wsih.domain.WSInuranceProduct;

privileged aspect WSInuranceProduct_Roo_JavaBean {
    
    public String WSInuranceProduct.getTitle() {
        return this.title;
    }
    
    public void WSInuranceProduct.setTitle(String title) {
        this.title = title;
    }
    
    public WSInsuranceCompany WSInuranceProduct.getInsuranceCompany() {
        return this.insuranceCompany;
    }
    
    public void WSInuranceProduct.setInsuranceCompany(WSInsuranceCompany insuranceCompany) {
        this.insuranceCompany = insuranceCompany;
    }
    
    public WSHealthCare WSInuranceProduct.getHealthCare() {
        return this.healthCare;
    }
    
    public void WSInuranceProduct.setHealthCare(WSHealthCare healthCare) {
        this.healthCare = healthCare;
    }
    
}