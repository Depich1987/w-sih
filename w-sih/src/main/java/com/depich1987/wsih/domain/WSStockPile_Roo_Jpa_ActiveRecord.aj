// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.depich1987.wsih.domain;

import com.depich1987.wsih.domain.WSStockPile;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.transaction.annotation.Transactional;

privileged aspect WSStockPile_Roo_Jpa_ActiveRecord {
    
    @PersistenceContext
    transient EntityManager WSStockPile.entityManager;
    
    public static final EntityManager WSStockPile.entityManager() {
        EntityManager em = new WSStockPile().entityManager;
        if (em == null) throw new IllegalStateException("Entity manager has not been injected (is the Spring Aspects JAR configured as an AJC/AJDT aspects library?)");
        return em;
    }
    
    public static long WSStockPile.countWSStockPiles() {
        return entityManager().createQuery("SELECT COUNT(o) FROM WSStockPile o", Long.class).getSingleResult();
    }
    
    public static List<WSStockPile> WSStockPile.findAllWSStockPiles() {
        return entityManager().createQuery("SELECT o FROM WSStockPile o", WSStockPile.class).getResultList();
    }
    
    public static WSStockPile WSStockPile.findWSStockPile(Long id) {
        if (id == null) return null;
        return entityManager().find(WSStockPile.class, id);
    }
    
    public static List<WSStockPile> WSStockPile.findWSStockPileEntries(int firstResult, int maxResults) {
        return entityManager().createQuery("SELECT o FROM WSStockPile o", WSStockPile.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
    }
    
    @Transactional
    public void WSStockPile.persist() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.persist(this);
    }
    
    @Transactional
    public void WSStockPile.remove() {
        if (this.entityManager == null) this.entityManager = entityManager();
        if (this.entityManager.contains(this)) {
            this.entityManager.remove(this);
        } else {
            WSStockPile attached = WSStockPile.findWSStockPile(this.id);
            this.entityManager.remove(attached);
        }
    }
    
    @Transactional
    public void WSStockPile.flush() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.flush();
    }
    
    @Transactional
    public void WSStockPile.clear() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.clear();
    }
    
    @Transactional
    public WSStockPile WSStockPile.merge() {
        if (this.entityManager == null) this.entityManager = entityManager();
        WSStockPile merged = this.entityManager.merge(this);
        this.entityManager.flush();
        return merged;
    }
    
}
