package com.depich1987.wsih.services.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.transaction.annotation.Transactional;

import com.depich1987.wsih.domain.WSMedecine;
import com.depich1987.wsih.domain.WSStockPile;

public class MedecineServiceImpl implements MedecineService {
	
	
	@PersistenceContext(name = "persistenceUnit")
	private EntityManager entityManager;
	
	public MedecineServiceImpl() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public long countMedecines() {
        return entityManager.createQuery("SELECT COUNT(o) FROM WSMedecine o", Long.class).getSingleResult();
    }
    
	@Override
    public List<WSMedecine> findAllMedecines() {
        return entityManager.createQuery("SELECT o FROM WSMedecine o", WSMedecine.class).getResultList();
    }
    
	@Override
    public List<WSStockPile> findAllStockPileByMedecine(WSMedecine medecine) {
        return entityManager.createQuery("SELECT o FROM WSStockPile o WHERE o.medecine = :medecine", WSStockPile.class)
        		.setParameter("medecine", medecine)
        		.getResultList();
    }
	
    @Override
    public WSStockPile findStockPile(Long id) {
        if (id == null) return null;
        return entityManager.find(WSStockPile.class, id);
    }
	
    @Override
    public WSMedecine findMedecine(Long id) {
        if (id == null) return null;
        return entityManager.find(WSMedecine.class, id);
    }
    
    @Override
    public List<WSMedecine> findMedecineEntries(int firstResult, int maxResults) {
        return entityManager.createQuery("SELECT o FROM WSMedecine o", WSMedecine.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
    }
    
    @Transactional
    @Override
    public void persist(WSMedecine medecine) {
        this.entityManager.persist(medecine);
    }
    
    @Transactional
    @Override
    public void persist(WSStockPile stockPile) {
        this.entityManager.persist(stockPile);
    }
    
    @Transactional
    @Override
    public void remove(WSMedecine medecine) {
        WSMedecine attached = findMedecine(medecine.getId());
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
    public WSMedecine merge(WSMedecine medecine) {
        WSMedecine merged = this.entityManager.merge(medecine);
        this.entityManager.flush();
        return merged;
    }
    
    @Transactional
    @Override
    public WSStockPile merge(WSStockPile stockPile) {
    	WSStockPile merged = this.entityManager.merge(stockPile);
        this.entityManager.flush();
        return merged;
    }
    
    @Transactional
    @Override
    public void remove(WSStockPile stockPile) {
    	WSStockPile attached = findStockPile(stockPile.getId());
        this.entityManager.remove(attached);
    }
	
    
    @Override
    public void updateMedecine(WSMedecine medecine) {
    	// TODO Auto-generated method stub
    	this.entityManager.createQuery("UPDATE WSMedecine SET name = :name, medecineType = :medecineType, lowerQuantity=:lowerQuantity WHERE id= :id")
    	.setParameter("id", medecine.getId())
    	.setParameter("name", medecine.getName())
    	.setParameter("medecineType",medecine.getMedecineType())
    	.setParameter("lowerQuantity", medecine.getLowerQuantity())
    	.executeUpdate();
    }
    
    public void setEntityManager(EntityManager entityManager){
    	this.entityManager = entityManager;
    }

}
