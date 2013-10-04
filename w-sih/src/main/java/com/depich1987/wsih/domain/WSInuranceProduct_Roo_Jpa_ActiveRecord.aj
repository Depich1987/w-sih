// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.depich1987.wsih.domain;

import com.depich1987.wsih.domain.WSInuranceProduct;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.transaction.annotation.Transactional;

privileged aspect WSInuranceProduct_Roo_Jpa_ActiveRecord {
    
    @PersistenceContext
    transient EntityManager WSInuranceProduct.entityManager;
    
    public static final EntityManager WSInuranceProduct.entityManager() {
        EntityManager em = new WSInuranceProduct().entityManager;
        if (em == null) throw new IllegalStateException("Entity manager has not been injected (is the Spring Aspects JAR configured as an AJC/AJDT aspects library?)");
        return em;
    }
    
    public static long WSInuranceProduct.countWSInuranceProducts() {
        return entityManager().createQuery("SELECT COUNT(o) FROM WSInuranceProduct o", Long.class).getSingleResult();
    }
    
    public static List<WSInuranceProduct> WSInuranceProduct.findAllWSInuranceProducts() {
        return entityManager().createQuery("SELECT o FROM WSInuranceProduct o", WSInuranceProduct.class).getResultList();
    }
    
    public static WSInuranceProduct WSInuranceProduct.findWSInuranceProduct(Long id) {
        if (id == null) return null;
        return entityManager().find(WSInuranceProduct.class, id);
    }
    
    public static List<WSInuranceProduct> WSInuranceProduct.findWSInuranceProductEntries(int firstResult, int maxResults) {
        return entityManager().createQuery("SELECT o FROM WSInuranceProduct o", WSInuranceProduct.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
    }
    
    @Transactional
    public void WSInuranceProduct.persist() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.persist(this);
    }
    
    @Transactional
    public void WSInuranceProduct.remove() {
        if (this.entityManager == null) this.entityManager = entityManager();
        if (this.entityManager.contains(this)) {
            this.entityManager.remove(this);
        } else {
            WSInuranceProduct attached = WSInuranceProduct.findWSInuranceProduct(this.id);
            this.entityManager.remove(attached);
        }
    }
    
    @Transactional
    public void WSInuranceProduct.flush() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.flush();
    }
    
    @Transactional
    public void WSInuranceProduct.clear() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.clear();
    }
    
    @Transactional
    public WSInuranceProduct WSInuranceProduct.merge() {
        if (this.entityManager == null) this.entityManager = entityManager();
        WSInuranceProduct merged = this.entityManager.merge(this);
        this.entityManager.flush();
        return merged;
    }
    
}