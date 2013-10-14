package com.depich1987.wsih.services.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.transaction.annotation.Transactional;

import com.depich1987.wsih.domain.WSPatient;

public class PatientServiceImpl implements PatientService{

	 @PersistenceContext(name = "persistenceUnit")
	 private EntityManager entityManager;

	 public PatientServiceImpl() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
    public long countWSPatients() {
        return entityManager.createQuery("SELECT COUNT(o) FROM WSPatient o", Long.class).getSingleResult();
    }
    
    @Override
    public List<WSPatient> findAllPatients() {
        return entityManager.createQuery("SELECT o FROM WSPatient o", WSPatient.class).getResultList();
    }
    
    @Override
    public List<WSPatient> findPatientsByFolderRegistrationIdOrFirstNameOrLastNameLike(String queryString) {

    	if (queryString == null || queryString.length() == 0) throw new IllegalArgumentException("The principalInsuredRegistrationId argument is required");
    	queryString = queryString.replace('*', '%');
        if (queryString.charAt(0) != '%') {
        	queryString = "%" + queryString;
        }
        if (queryString.charAt(queryString.length() - 1) != '%') {
        	queryString = queryString + "%";
        }

    	return entityManager.createQuery("SELECT o FROM WSPatient AS o WHERE (LOWER(o.folderRegistrationId) LIKE LOWER(:queryString)) OR (LOWER(o.firstName) LIKE LOWER(:queryString)) OR (LOWER(o.lastName) LIKE LOWER(:queryString))", WSPatient.class)
    			.setParameter("queryString", queryString)
    			.getResultList();
    }
    
    @Override
    public WSPatient findPatient(Long id) {
        if (id == null) return null;
        return entityManager.find(WSPatient.class, id);
    }
    
    @Override
    public List<WSPatient> findPatientEntries(int firstResult, int maxResults) {
        return entityManager.createQuery("SELECT o FROM WSPatient o", WSPatient.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
    }
    
    @Transactional
    @Override
    public void persist(WSPatient patient) {
        this.entityManager.persist(patient);
    }
    
    @Transactional
    @Override
    public void remove(Long id) {
        WSPatient attached = this.findPatient(id);
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
    public WSPatient merge(WSPatient patient) {
        WSPatient merged = this.entityManager.merge(patient);
        this.entityManager.flush();
        return merged;
    }

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
    
    
}
