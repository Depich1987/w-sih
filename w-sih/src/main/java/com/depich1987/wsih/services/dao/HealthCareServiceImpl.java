package com.depich1987.wsih.services.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.transaction.annotation.Transactional;

import com.depich1987.wsih.domain.WSHealthCare;

public class HealthCareServiceImpl implements HealthCareService{
	
	@PersistenceContext(name = "persistenceUnit")
    private EntityManager entityManager;
    
	public HealthCareServiceImpl() {
		// TODO Auto-generated constructor stub
	}
    
	@Override
    public long countHealthCares() {
        return entityManager.createQuery("SELECT COUNT(o) FROM WSHealthCare o", Long.class).getSingleResult();
    }
    
	@Override
    public List<WSHealthCare> findAllHealthCares() {
        return entityManager.createQuery("SELECT o FROM WSHealthCare o", WSHealthCare.class).getResultList();
    }
    
	@Override
    public WSHealthCare findHealthCare(Long id) {
        if (id == null) return null;
        return entityManager.find(WSHealthCare.class, id);
    }
    
	@Override
    public List<WSHealthCare> findHealthCareEntries(int firstResult, int maxResults) {
        return entityManager.createQuery("SELECT o FROM WSHealthCare o", WSHealthCare.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
    }
    
    @Transactional
    @Override
    public void persist(WSHealthCare healthCare) {
        this.entityManager.persist(healthCare);
    }
    
    
    @Transactional
    @Override
    public void remove(Long id) {
        WSHealthCare attached = findHealthCare(id);
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
    public WSHealthCare merge(WSHealthCare healthCare) {
        WSHealthCare merged = this.entityManager.merge(healthCare);
        this.entityManager.flush();
        return merged;
    }
    
    @Override
    @Transactional
    public void update(WSHealthCare healthCare) {
    	
    	entityManager.createQuery("UPDATE WSHealthCare SET  name = :name, healthCareType = :healthCareType WHERE id = :id")
    	.setParameter("id", healthCare.getId())
    	.setParameter("name", healthCare.getName())
    	.setParameter("healthCareType", healthCare.getHealthCareType())
    	.executeUpdate();
    	
    }

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
    
   

}
