// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.depich1987.wsih.domain;

import com.depich1987.wsih.domain.WSBudgetAccount;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;

privileged aspect WSBudgetAccount_Roo_Jpa_Entity {
    
    declare @type: WSBudgetAccount: @Entity;
    
    declare @type: WSBudgetAccount: @Table(name = "WS_BUDGET_ACCOUNT");
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long WSBudgetAccount.id;
    
    @Version
    @Column(name = "version")
    private Integer WSBudgetAccount.version;
    
    public Long WSBudgetAccount.getId() {
        return this.id;
    }
    
    public void WSBudgetAccount.setId(Long id) {
        this.id = id;
    }
    
    public Integer WSBudgetAccount.getVersion() {
        return this.version;
    }
    
    public void WSBudgetAccount.setVersion(Integer version) {
        this.version = version;
    }
    
}
