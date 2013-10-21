package com.depich1987.wsih.services.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.transaction.annotation.Transactional;

import com.depich1987.wsih.domain.WSInsuranceProduct;

public class InsuranceProductServiceImpl  implements InsuranceProductService{
	
	@PersistenceContext(name = "persistenceUnit")
	private EntityManager entityManager;
	
	public InsuranceProductServiceImpl() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
    public long countInsuranceProducts() {
        return entityManager.createQuery("SELECT COUNT(o) FROM WSInsuranceProduct o", Long.class).getSingleResult();
    }
    
	@Override
    public List<WSInsuranceProduct> findAllInsuranceProducts() {
        return entityManager.createQuery("SELECT o FROM WSInsuranceProduct o", WSInsuranceProduct.class).getResultList();
    }
    
	@Override
    public WSInsuranceProduct findInsuranceProduct(Long id) {
        if (id == null) return null;
        return entityManager.find(WSInsuranceProduct.class, id);
    }
    
	@Override
    public List<WSInsuranceProduct> findInsuranceProductEntries(int firstResult, int maxResults) {
        return entityManager.createQuery("SELECT o FROM WSInsuranceProduct o", WSInsuranceProduct.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
    }
    
    @Transactional
    @Override
    public void persist(WSInsuranceProduct insuranceProduct ) {
        this.entityManager.persist(insuranceProduct);
    }
    
    @Transactional
    @Override
    public void remove(Long id) {
            WSInsuranceProduct attached = findInsuranceProduct(id);
            this.entityManager.remove(attached);
    }
    
    @Transactional
    @Override
    public void update(WSInsuranceProduct insuranceProduct){
    	this.entityManager.createQuery("UPDATE WSInsuranceProduct o SET o.name = :name, o.contact = :contact, o.insuranceCompany = :insuranceCompany  WHERE o.id = :id")
    	.setParameter("id", insuranceProduct.getId())
    	.setParameter("name", insuranceProduct.getName())
    	.setParameter("contact", insuranceProduct.getContact())
    	.setParameter("insuranceCompany", insuranceProduct.getInsuranceCompany())
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
    public WSInsuranceProduct merge(WSInsuranceProduct insuranceProduct) {
        WSInsuranceProduct merged = this.entityManager.merge(insuranceProduct);
        this.entityManager.flush();
        return merged;
    }
    

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
}
