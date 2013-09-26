package com.depich1987.wsih.services.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.transaction.annotation.Transactional;

import com.depich1987.wsih.domain.WSCashAccount;

public class CashAccountServiceImpl implements CashAccountService{
	
	@PersistenceContext(name = "persistenceUnit")
    private EntityManager entityManager;
    
    
    @Override
    public long countCashAccounts() {
        return entityManager.createQuery("SELECT COUNT(o) FROM WSCashAccount o", Long.class).getSingleResult();
    }
    
    @Override
    public List<WSCashAccount> findAllCashAccounts() {
        return entityManager.createQuery("SELECT o FROM WSCashAccount o", WSCashAccount.class).getResultList();
    }
    
    @Override
    public WSCashAccount findCashAccount(Long id) {
        if (id == null) return null;
        return entityManager.find(WSCashAccount.class, id);
    }
    
    @Override
    public List<WSCashAccount> findCashAccountEntries(int firstResult, int maxResults) {
        return entityManager.createQuery("SELECT o FROM WSCashAccount o", WSCashAccount.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
    }
    
    @Transactional
    @Override
    public void persist(WSCashAccount cashAccount) {
        this.entityManager.persist(cashAccount);
    }
    
    @Transactional
    @Override
    public void remove(Long id) {

        WSCashAccount attached = findCashAccount(id);
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
    public WSCashAccount merge(WSCashAccount cashAccount) {
        WSCashAccount merged = this.entityManager.merge(cashAccount);
        this.entityManager.flush();
        return merged;
    }
    
    public void setEntityManager(EntityManager entityManager){
    	this.entityManager = entityManager;
    }

}
