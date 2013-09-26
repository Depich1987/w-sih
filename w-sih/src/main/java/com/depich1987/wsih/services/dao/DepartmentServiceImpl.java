package com.depich1987.wsih.services.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.transaction.annotation.Transactional;

import com.depich1987.wsih.domain.WSDepartment;

public class DepartmentServiceImpl implements DepartmentService {
	
    @PersistenceContext(name = "persistenceUnit")
    private EntityManager entityManager;
    
    public DepartmentServiceImpl() {
		// TODO Auto-generated constructor stub
	}
    
    @Override
    public long countDepartments() {
        return entityManager.createQuery("SELECT COUNT(o) FROM WSDepartment o", Long.class).getSingleResult();
    }
    
    @Override
    public List<WSDepartment> findAllDepartments() {
        return entityManager.createQuery("SELECT o FROM WSDepartment o", WSDepartment.class).getResultList();
    }
    
    @Override
    public WSDepartment findDepartment(Long id) {
        if (id == null) return null;
        return entityManager.find(WSDepartment.class, id);
    }
    
    @Override
    public List<WSDepartment> findDepartmentEntries(int firstResult, int maxResults) {
        return entityManager.createQuery("SELECT o FROM WSDepartment o", WSDepartment.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
    }
    
    @Transactional
    @Override
    public void persist(WSDepartment department) {
        this.entityManager.persist(department);
    }
    
    @Transactional
    @Override
    public void remove(Long id) {

	    WSDepartment attached = this.findDepartment(id);
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
    public WSDepartment merge(WSDepartment department) {
        WSDepartment merged = this.entityManager.merge(department);
        this.entityManager.flush();
        return merged;
    }
    
    public void setEntityManager(EntityManager entityManager){
    	this.entityManager = entityManager;
    }

}
