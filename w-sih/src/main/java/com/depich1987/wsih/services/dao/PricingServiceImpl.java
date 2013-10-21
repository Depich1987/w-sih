package com.depich1987.wsih.services.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.transaction.annotation.Transactional;

import com.depich1987.wsih.domain.WSPricing;

public class PricingServiceImpl implements PricingService{
	
	@PersistenceContext(name = "persistenceUnit")
	private EntityManager entityManager;
	
	public PricingServiceImpl() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
    public long countPricings() {
        return entityManager.createQuery("SELECT COUNT(o) FROM WSPricing o", Long.class).getSingleResult();
    }
    
    @Override
    public List<WSPricing> findAllPricings() {
        return entityManager.createQuery("SELECT o FROM WSPricing o", WSPricing.class).getResultList();
    }
    
    @Override
    public WSPricing findPricing(Long id) {
        if (id == null) return null;
        return entityManager.find(WSPricing.class, id);
    }
    
    @Override
    public List<WSPricing> findPricingEntries(int firstResult, int maxResults) {
        return entityManager.createQuery("SELECT o FROM WSPricing o", WSPricing.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
    }
    
    @Transactional
    @Override
    public void persist(WSPricing pricing) {
        this.entityManager.persist(pricing);
    }
    
    @Transactional
    @Override
    public void remove(Long id) {
            WSPricing attached = findPricing(id);
            this.entityManager.remove(attached);
    }
    
    @Transactional
    @Override
    public void update(WSPricing pricing){
    	this.entityManager.createQuery("UPDATE WSPricing o SET o.price = :price, o.insuranceRate = :insuranceRate, o.rateBNC = :rateBNC, o.vatRate = :vatRate, o.insuranceProduct = :insuranceProduct  WHERE o.id = :id")
    	.setParameter("id", pricing.getId())
    	.setParameter("insuranceRate",pricing.getInsuranceRate())
    	.setParameter("rateBNC", pricing.getRateBNC())
    	.setParameter("vatRate", pricing.getVatRate())
    	.setParameter("insuranceProduct", pricing.getInsuranceProduct())
    	.executeUpdate();
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
    public WSPricing merge(WSPricing pricing) {
        WSPricing merged = this.entityManager.merge(pricing);
        this.entityManager.flush();
        return merged;
    }

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

}
