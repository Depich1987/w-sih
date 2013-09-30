package com.depich1987.wsih.services.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.transaction.annotation.Transactional;

import com.depich1987.wsih.domain.WSMedecineType;

public class MedecineTypeServiceImpl implements MedecineTypeService{
	
		@PersistenceContext(name = "persistenceUnit")
    	private EntityManager entityManager;
		
		public MedecineTypeServiceImpl() {
			// TODO Auto-generated constructor stub
		}
	
		@Override
	 	public long countMedecineTypes() {
	        return entityManager.createQuery("SELECT COUNT(o) FROM WSMedecineType o", Long.class).getSingleResult();
	    }
	    
	 	@Override
	    public List<WSMedecineType> findAllMedecineTypes() {
	        return entityManager.createQuery("SELECT o FROM WSMedecineType o", WSMedecineType.class).getResultList();
	    }
	    
	    @Override
	    public WSMedecineType findMedecineType(Long id) {
	        if (id == null) return null;
	        return entityManager.find(WSMedecineType.class, id);
	    }
	    
	    @Override
	    public List<WSMedecineType> findMedecineTypeEntries(int firstResult, int maxResults) {
	        return entityManager.createQuery("SELECT o FROM WSMedecineType o", WSMedecineType.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
	    }
	    
	    @Transactional
	    @Override
	    public void persist(WSMedecineType medecineType) {
	        this.entityManager.persist(medecineType);
	    }
	    
	    @Transactional
	    @Override
	    public void remove(Long id) {

	            WSMedecineType attached = findMedecineType(id);
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
	    public WSMedecineType merge(WSMedecineType medecineType) {
	        WSMedecineType merged = this.entityManager.merge(medecineType);
	        this.entityManager.flush();
	        return merged;
	    }
	    
	    public void setEntityManager(EntityManager entityManager){
	    	this.entityManager = entityManager;
	    }

}
