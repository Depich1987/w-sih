package com.depich1987.wsih.services.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.transaction.annotation.Transactional;

import com.depich1987.wsih.domain.WSHealthCareType;

public class HealthCareTypeServiceImpl implements HealthCareTypeService {
	
	@PersistenceContext(name = "persistenceUnit")
    private EntityManager entityManager;
	
	
	public HealthCareTypeServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
    public  long countHealthCareTypes() {
        return entityManager.createQuery("SELECT COUNT(o) FROM WSHealthCareType o", Long.class).getSingleResult();
    }
    
	@Override
    public  List<WSHealthCareType> findAllHealthCareTypes() {
        return entityManager.createQuery("SELECT o FROM WSHealthCareType o", WSHealthCareType.class).getResultList();
    }
    
	@Override
    public  WSHealthCareType findHealthCareType(Long id) {
        if (id == null) return null;
        return entityManager.find(WSHealthCareType.class, id);
    }
    
	@Override
    public  List<WSHealthCareType> findHealthCareTypeEntries(int firstResult, int maxResults) {
        return entityManager.createQuery("SELECT o FROM WSHealthCareType o", WSHealthCareType.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
    }
    
    @Transactional
    @Override
    public void persist(WSHealthCareType healthCareType) {
        this.entityManager.persist(healthCareType);
    }
    
    @Transactional
    @Override
    public void remove(Long id) {
        WSHealthCareType attached = this.findHealthCareType(id);
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
    public WSHealthCareType merge(WSHealthCareType careType) {
        WSHealthCareType merged = this.entityManager.merge(careType);
        this.entityManager.flush();
        return merged;
    }
    
    @Override
    @Transactional
    public void update(WSHealthCareType careType) {
    	
    	this.entityManager.createQuery("UPDATE WSHealthCareType SET  name = :name, description = :description WHERE id = :id")
    	.setParameter("id", careType.getId())
    	.setParameter("name", careType.getName())
    	.setParameter("description", careType.getDescription())
    	.executeUpdate();
    	
    }

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
    
    

}
