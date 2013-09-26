package com.depich1987.wsih.services.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.transaction.annotation.Transactional;

import com.depich1987.wsih.domain.WSInsuranceCompany;

public class InsuranceCompanyServiceImpl implements InsuranceCompanyService{
	
	@PersistenceContext(name = "persistenceUnit")
    private EntityManager entityManager;
	
	public InsuranceCompanyServiceImpl() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public long countInsuanceCompanys() {
        return entityManager.createQuery("SELECT COUNT(o) FROM WSInsuanceCompany o", Long.class).getSingleResult();
    }
    
	@Override
    public List<WSInsuranceCompany> findAllInsuanceCompanys() {
        return entityManager.createQuery("SELECT o FROM WSInsuanceCompany o", WSInsuranceCompany.class).getResultList();
    }
    
    @Override
    public WSInsuranceCompany findInsuranceCompany(Long id) {
        if (id == null) return null;
        return entityManager.find(WSInsuranceCompany.class, id);
    }
    
    @Override
    public List<WSInsuranceCompany> findInsuanceCompanyEntries(int firstResult, int maxResults) {
        return entityManager.createQuery("SELECT o FROM WSInsuanceCompany o", WSInsuranceCompany.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
    }
    
    @Transactional
    @Override
    public void persist(WSInsuranceCompany insuanceCompany) {
        this.entityManager.persist(insuanceCompany);
    }
    
    @Transactional
    @Override
    public void remove(Long id) {

        WSInsuranceCompany attached = findInsuranceCompany(id);
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
    public WSInsuranceCompany merge(WSInsuranceCompany insuanceCompany) {

        WSInsuranceCompany merged = this.entityManager.merge(insuanceCompany);
        this.entityManager.flush();
        return merged;
    }
	
    public void setEntityManager(EntityManager entityManager){
    	this.entityManager = entityManager;
    }

}
