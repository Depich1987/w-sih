package com.depich1987.wsih.services.dao;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

//import org.apache.log4j.Logger;
import org.springframework.transaction.annotation.Transactional;

import com.depich1987.wsih.domain.WSHealthCareInMeeting;
import com.depich1987.wsih.domain.WSMeeting;


public class MeetingServiceImpl  implements MeetingService{
	
	@PersistenceContext(name = "persistenceUnit")
	private EntityManager entityManager;
	
//	private static Logger logger = Logger.getLogger(MeetingServiceImpl.class);
	
	public MeetingServiceImpl() {
		// TODO Auto-generated constructor stub
	}

		@Override
	 	public long countMeetings() {
	        return entityManager.createQuery("SELECT COUNT(o) FROM WSMeeting o", Long.class).getSingleResult();
	    }
	    
	 	@Override
	    public List<WSMeeting> findAllMeetings() {
	        return entityManager.createQuery("SELECT o FROM WSMeeting o ORDER BY o.meetingDate DESC", WSMeeting.class).getResultList();
	    }
	    
	    @Override
	    public WSMeeting findMeeting(Long id) {
	        if (id == null) return null;
	        return entityManager.find(WSMeeting.class, id);
	    }
	    
	    @Override
	    public List<WSMeeting> findMeetingEntries(int firstResult, int maxResults) {
	        return entityManager.createQuery("SELECT o FROM WSMeeting o ORDER BY o.meetingDate DESC", WSMeeting.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
	    }
	    
	    @Override
	    public List<WSHealthCareInMeeting> findHealthCareInMeetingsByDepartmentBetweenDates(Long departmentId, Date startDate, Date endDate) {
	    	// TODO Auto-generated method stub
	    	return entityManager.createQuery("SELECT o FROM WSHealthCareInMeeting WHERE o.user.job.department.id = :departmentId AND o.meetingDate BETWEEN :startDate AND :endDate", WSHealthCareInMeeting.class)
	    			.setParameter("departmentId", departmentId)
	    			.setParameter("startDate", startDate)
	    			.setParameter("endDate", endDate)
	    			.getResultList();
	    }
	    
	    @Override
	    public List<WSHealthCareInMeeting> findHealthCareInMeetingsByUserBetweenDates(Long userId, Date startDate, Date endDate) {
	    	// TODO Auto-generated method stub
	    	return entityManager.createQuery("SELECT o FROM WSHealthCareInMeeting WHERE o.user.id = :userId AND o.meetingDate BETWEEN :startDate AND :endDate", WSHealthCareInMeeting.class)
	    			.setParameter("userId", userId)
	    			.setParameter("startDate", startDate)
	    			.setParameter("endDate", endDate)
	    			.getResultList();
	    }
	    
	    @Override
	    public List<WSHealthCareInMeeting> findHealthCareInMeetingsBetweenDates(Date startDate, Date endDate) {
	    	
	    	CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
			CriteriaQuery<WSHealthCareInMeeting> criteriaQuery = criteriaBuilder.createQuery(WSHealthCareInMeeting.class);
			Root<WSHealthCareInMeeting> healthCareInMeetingRoot = criteriaQuery.from(WSHealthCareInMeeting.class);
			criteriaQuery.select(healthCareInMeetingRoot);
			
			Predicate predicate = criteriaBuilder.conjunction();
			
			predicate = criteriaBuilder.and(predicate,criteriaBuilder.greaterThanOrEqualTo(healthCareInMeetingRoot.<Date>get("meetingDate"),startDate));
			predicate = criteriaBuilder.and(predicate,criteriaBuilder.lessThanOrEqualTo(healthCareInMeetingRoot.<Date>get("meetingDate"),endDate));
	    	
			criteriaQuery.where(predicate);
			
			return entityManager.createQuery(criteriaQuery).getResultList();
			
//			logger.debug(">>>>>>>>>>>>>>> "+ startDate + " , " + endDate);
//	    	// TODO Auto-generated method stub
//	    	return entityManager.createQuery("SELECT o FROM WSHealthCareInMeeting WHERE o.meetingDate >= :startDate <= :endDate", WSHealthCareInMeeting.class)
//	    			.setParameter("startDate", startDate,TemporalType.TIMESTAMP)
//	    			.setParameter("endDate", endDate,TemporalType.TIMESTAMP)
//	    			.getResultList();
	    }
	    
	    @Transactional
	    @Override
	    public void persist(WSMeeting meeting) {
	        this.entityManager.persist(meeting);
	    }
	    
	    @Transactional
	    @Override
	    public void remove(long id) {
            WSMeeting attached = this.findMeeting(id);
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
	    public WSMeeting merge(WSMeeting meeting) {
	        WSMeeting merged = this.entityManager.merge(meeting);
	        this.entityManager.flush();
	        return merged;
	    }

	    
	    public void setEntityManager(EntityManager entityManager){
	    	this.entityManager = entityManager;
	    }
}
