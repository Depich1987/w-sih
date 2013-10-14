package com.depich1987.wsih.services.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.transaction.annotation.Transactional;

import com.depich1987.wsih.domain.WSDepartment;
import com.depich1987.wsih.domain.WSUser;

public class UserServiceImpl implements UserService{
	
	@PersistenceContext(name = "persistenceUnit")
	private EntityManager entityManager;

	
		@Override
		public long countUsers() {
	        return entityManager.createQuery("SELECT COUNT(o) FROM WSUser o", Long.class).getSingleResult();
	    }
	    
		@Override
	    public List<WSUser> findAllUsers() {
	        return entityManager.createQuery("SELECT o FROM WSUser o", WSUser.class).getResultList();
	    }
		
		@Override
		public List<WSUser> findUsersByDepartment(WSDepartment department) {

			return entityManager.createQuery("SELECT o FROM WSUser o WHERE o.job.department = :department", WSUser.class)
					.setParameter("department", department)
					.getResultList();
		}
		
		@Override
		public List<WSUser> findUsersByUserType(String userType) {

			if (userType == null || userType.length() == 0) throw new IllegalArgumentException("The 'userType' argument is required");
			
			return entityManager.createQuery("SELECT o FROM WSUser o WHERE o.userType = :userType", WSUser.class)
					.setParameter("userType", userType)
					.getResultList();
			
		}
		
		@Override
		public List<WSUser> findUsersByDepartmentAndUserType(WSDepartment department, String userType) {
			
			if (userType == null || userType.length() == 0) throw new IllegalArgumentException("The 'userType' argument is required");
			
			return entityManager.createQuery("SELECT o FROM WSUser o WHERE o.job.department = :department AND o.userType = :userType", WSUser.class)
					.setParameter("department", department)
					.setParameter("userType", userType)
					.getResultList();
		}
	    
		@Override
	    public WSUser findUser(Long id) {
	        if (id == null) return null;
	        return entityManager.find(WSUser.class, id);
	    }
	    
		@Override
	    public List<WSUser> findUserEntries(int firstResult, int maxResults) {
	        return entityManager.createQuery("SELECT o FROM WSUser o", WSUser.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
	    }
	    
	    @Transactional
	    @Override
	    public void persist(WSUser user) {
	        this.entityManager.persist(user);
	    }
	    
	    @Transactional
	    @Override
	    public void remove(Long id) {
            WSUser attached = this.findUser(id);
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
	    public WSUser merge(WSUser user) {
	        WSUser merged = this.entityManager.merge(user);
	        this.entityManager.flush();
	        return merged;
	    }
	    
	    @Override
	    @Transactional
	    public void update(WSUser user) {
	    	this.entityManager.createQuery("UPDATE WSUser SET civility = :civility, firstName = :firstName, lastName = :lastName, userName = :userName, password = :password, userType = :userType, job = :job WHERE id = :id")
	    	.setParameter("id", user.getId())
	    	.setParameter("civility", user.getCivility())
	    	.setParameter("firstName", user.getFirstName())
	    	.setParameter("lastName", user.getLastName())
	    	.setParameter("userName", user.getUserName())
	    	.setParameter("password", user.getPassword())
	    	.setParameter("userType", user.getUserType())
	    	.setParameter("job", user.getJob())
	    	.executeUpdate();
	    }

		public void setEntityManager(EntityManager entityManager) {
			this.entityManager = entityManager;
		}
	    
	    

}
