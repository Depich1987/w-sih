package com.depich1987.wsih.services.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.transaction.annotation.Transactional;

import com.depich1987.wsih.domain.WSHospital;

public class HospitalServiceImpl implements HospitalService {

    @PersistenceContext(name = "persistenceUnit")
    private EntityManager entityManager;
    
	public HospitalServiceImpl() {
		// TODO Auto-generated constructor stub
	}
    
    
    @Override
    public long countHospitals() {
        return entityManager.createQuery("SELECT COUNT(o) FROM WSHospital o", Long.class).getSingleResult();
    }
    
    @Override
    public List<WSHospital> findAllHospitals() {
        return entityManager.createQuery("SELECT o FROM WSHospital o", WSHospital.class).getResultList();
    }
    
    @Override
    public WSHospital findHospital(Long id) {
        if (id == null) return null;
        return entityManager.find(WSHospital.class, id);
    }
    
    @Override
    public List<WSHospital> findHospitalEntries(int firstResult, int maxResults) {
        return entityManager.createQuery("SELECT o FROM WSHospital o", WSHospital.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
    }
    
    @Transactional
    @Override
    public void persist(WSHospital hospital) {
        this.entityManager.persist(hospital);
    }
    
    @Transactional
    @Override
    public void remove(Long id) {

        WSHospital attached = findHospital(id);
        this.entityManager.remove(attached);
    }
    
    @Transactional
    @Override
    public void flush() {
        this.entityManager.flush();
    }
    
    @Transactional
    @Override
    public void clear() {

        this.entityManager.clear();
    }
    
    @Transactional
    @Override
    public WSHospital merge(WSHospital hospital) {

        WSHospital merged = this.entityManager.merge(hospital);
        this.entityManager.flush();
        return merged;
    }
    
    public void setEntityManager(EntityManager entityManager){
    	this.entityManager = entityManager;
    }
  
}
