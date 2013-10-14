// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.depich1987.wsih.domain;

import com.depich1987.wsih.domain.WSHealthCareInMeeting;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.transaction.annotation.Transactional;

privileged aspect WSHealthCareInMeeting_Roo_Jpa_ActiveRecord {
    
    @PersistenceContext
    transient EntityManager WSHealthCareInMeeting.entityManager;
    
    public static final EntityManager WSHealthCareInMeeting.entityManager() {
        EntityManager em = new WSHealthCareInMeeting().entityManager;
        if (em == null) throw new IllegalStateException("Entity manager has not been injected (is the Spring Aspects JAR configured as an AJC/AJDT aspects library?)");
        return em;
    }
    
    public static long WSHealthCareInMeeting.countWSHealthCareInMeetings() {
        return entityManager().createQuery("SELECT COUNT(o) FROM WSHealthCareInMeeting o", Long.class).getSingleResult();
    }
    
    public static List<WSHealthCareInMeeting> WSHealthCareInMeeting.findAllWSHealthCareInMeetings() {
        return entityManager().createQuery("SELECT o FROM WSHealthCareInMeeting o", WSHealthCareInMeeting.class).getResultList();
    }
    
    public static WSHealthCareInMeeting WSHealthCareInMeeting.findWSHealthCareInMeeting(Long id) {
        if (id == null) return null;
        return entityManager().find(WSHealthCareInMeeting.class, id);
    }
    
    public static List<WSHealthCareInMeeting> WSHealthCareInMeeting.findWSHealthCareInMeetingEntries(int firstResult, int maxResults) {
        return entityManager().createQuery("SELECT o FROM WSHealthCareInMeeting o", WSHealthCareInMeeting.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
    }
    
    @Transactional
    public void WSHealthCareInMeeting.persist() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.persist(this);
    }
    
    @Transactional
    public void WSHealthCareInMeeting.remove() {
        if (this.entityManager == null) this.entityManager = entityManager();
        if (this.entityManager.contains(this)) {
            this.entityManager.remove(this);
        } else {
            WSHealthCareInMeeting attached = WSHealthCareInMeeting.findWSHealthCareInMeeting(this.id);
            this.entityManager.remove(attached);
        }
    }
    
    @Transactional
    public void WSHealthCareInMeeting.flush() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.flush();
    }
    
    @Transactional
    public void WSHealthCareInMeeting.clear() {
        if (this.entityManager == null) this.entityManager = entityManager();
        this.entityManager.clear();
    }
    
    @Transactional
    public WSHealthCareInMeeting WSHealthCareInMeeting.merge() {
        if (this.entityManager == null) this.entityManager = entityManager();
        WSHealthCareInMeeting merged = this.entityManager.merge(this);
        this.entityManager.flush();
        return merged;
    }
    
}