// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.depich1987.wsih.domain;

import com.depich1987.wsih.domain.WSHealthCare;
import com.depich1987.wsih.domain.WSInsuranceProduct;
import com.depich1987.wsih.domain.WSPricing;

privileged aspect WSPricing_Roo_JavaBean {
    
    public int WSPricing.getPrice() {
        return this.price;
    }
    
    public void WSPricing.setPrice(int price) {
        this.price = price;
    }
    
    public double WSPricing.getInsuranceRate() {
        return this.insuranceRate;
    }
    
    public void WSPricing.setInsuranceRate(double insuranceRate) {
        this.insuranceRate = insuranceRate;
    }
    
    public double WSPricing.getRateBNC() {
        return this.rateBNC;
    }
    
    public void WSPricing.setRateBNC(double rateBNC) {
        this.rateBNC = rateBNC;
    }
    
    public double WSPricing.getVatRate() {
        return this.vatRate;
    }
    
    public void WSPricing.setVatRate(double vatRate) {
        this.vatRate = vatRate;
    }
    
    public WSInsuranceProduct WSPricing.getInsuranceProduct() {
        return this.insuranceProduct;
    }
    
    public void WSPricing.setInsuranceProduct(WSInsuranceProduct insuranceProduct) {
        this.insuranceProduct = insuranceProduct;
    }
    
    public WSHealthCare WSPricing.getHealthCare() {
        return this.healthCare;
    }
    
    public void WSPricing.setHealthCare(WSHealthCare healthCare) {
        this.healthCare = healthCare;
    }
    
}