package com.depich1987.wsih.services.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.transaction.annotation.Transactional;

import com.depich1987.wsih.domain.WSMeeting;

public class MeetingServiceImpl  implements MeetingService{
	
	@PersistenceContext(name = "persistenceUnit")
	private EntityManager entityManager;
	
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
