// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.depich1987.wsih.domain;

import com.depich1987.wsih.domain.WSBudgetAccount;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.transaction.annotation.Transactional;

privileged aspect WSBudgetAccount_Roo_Jpa_ActiveRecord {
    
    @PersistenceContext
    transient EntityManager WSBudgetAccount.entityManager;
    
    public static final EntityManager WSBudgetAccount.entityManager() {
        EntityManager em = new WSBudgetAccount().entityManager;
        if (em == null) throw new IllegalStateException("Entity manager has not been injected (is the Spring Aspects JAR configured as an AJC/AJDT aspects library?)");
        return em;
    }
    
    public static long WSBudgetAccount.countWSBudgetAccounts() {
        return entityManager().createQuery("SELECT COUNT(o) FROM WSBudgetAccount o", Long.class).getSingleResult();
    }
    
    public static List<WSBudgetAccount> WSBudgetAccount.findAllWSBudgetAccounts() {
        return entityManager().createQuery("SELECT o FROM WSBudgetAccount o", WSBudgetAccount.class).getResultList();
    }
    
    public static WSBudgetAccount WSBudgetAccount.findWSBudgetAccount(Long id) {
        if (id == null) return null;
        return entityManager().find(WSBudgetAccount.class, id);
    }
    
    public static List<WSBudgetAccount> WSBudgetAccount.findWSBudgetAccountEntries(int firstResult, int maxResults) {
        return entityManager().createQuery("SELECT o FROM WSBudgetAccount o", WSBudgetAccount.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
    }
    
    @Transactional
    public void WSBudgetAccount.persist() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.persist(this);
    }
    
    @Transactional
    public void WSBudgetAccount.remove() {
        if (this.entityManager == null) this.entityManager = entityManager();
        if (this.entityManager.contains(this)) {
            this.entityManager.remove(this);
        } else {
            WSBudgetAccount attached = WSBudgetAccount.findWSBudgetAccount(this.id);
            this.entityManager.remove(attached);
        }
    }
    
    @Transactional
    public void WSBudgetAccount.flush() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.flush();
    }
    
    @Transactional
    public void WSBudgetAccount.clear() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.clear();
    }
    
    @Transactional
    public WSBudgetAccount WSBudgetAccount.merge() {
        if (this.entityManager == null) this.entityManager = entityManager();
        WSBudgetAccount merged = this.entityManager.merge(this);
        this.entityManager.flush();
        return merged;
    }
    
}
