package com.depich1987.wsih.services.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.transaction.annotation.Transactional;

import com.depich1987.wsih.domain.WSDepartment;
import com.depich1987.wsih.domain.WSJob;

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
    public List<WSDepartment> findDepartmentsByDepartmentType(String departmentType) {
    	
    	 if (departmentType == null || departmentType.length() == 0) throw new IllegalArgumentException("The 'departmentType' argument is required");
    	
    	return entityManager.createQuery("SELECT o FROM WSDepartment o WHERE o.departmentType = :departmentType", WSDepartment.class)
    			.setParameter("departmentType", departmentType)
    			.getResultList();
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
    
    @Override
    public List<WSJob> findAllJobs() {
        return entityManager.createQuery("SELECT o FROM WSJob o", WSJob.class).getResultList();
    }
    
    @Override
    public List<WSJob> findJobsInDepartment(WSDepartment department) {
    	return entityManager.createQuery("SELECT o FROM WSJob o WHERE o.department = :department", WSJob.class)
    			.setParameter("department", department)
    			.getResultList();
    }
    
    @Override
    public WSJob findJob(Long id) {
        if (id == null) return null;
        return entityManager.find(WSJob.class, id);
    }
    
    @Override
    public List<WSJob> findJobEntries(int firstResult, int maxResults) {
        return entityManager.createQuery("SELECT o FROM WSJob o", WSJob.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
    }
    
    @Transactional
    @Override
    public void persist(WSDepartment department) {
        this.entityManager.persist(department);
    }
    
    @Transactional
    @Override
    public void persist(WSJob job) {
    	this.entityManager.persist(job);    	
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
    
    @Transactional
    @Override
    public WSJob merge(WSJob job) {
    	WSJob merged = this.entityManager.merge(job);
        this.entityManager.flush();
        return merged;
    }
    
    @Transactional
    @Override
    public void update(WSJob job){
    	this.entityManager.createQuery("UPDATE WSJob SET name = :name, description= :description, department = :department WHERE id= :id")
    	.setParameter("name", job.getName())
    	.setParameter("description", job.getDescription())
    	.setParameter("department", job.getDepartment())
    	.setParameter("id", job.getId())
    	.executeUpdate();
    }
    
    public void setEntityManager(EntityManager entityManager){
    	this.entityManager = entityManager;
    }

}
