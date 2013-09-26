package com.depich1987.wsih.services.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.transaction.annotation.Transactional;

import com.depich1987.wsih.domain.WSBudgetAccount;

public class BudgetAccountServiceImpl implements BudgetAccountService {
	
	@PersistenceContext(name = "persistenceUnit")
	private EntityManager entityManager;

	@Override
	public long countBudgetAccounts() {
        return entityManager.createQuery("SELECT COUNT(o) FROM WSBudgetAccount o", Long.class).getSingleResult();
    }
    
	@Override
    public List<WSBudgetAccount> findAllBudgetAccounts() {
        return entityManager.createQuery("SELECT o FROM WSBudgetAccount o", WSBudgetAccount.class).getResultList();
    }
    
    @Override
    public WSBudgetAccount findBudgetAccount(Long id) {
        if (id == null) return null;
        return entityManager.find(WSBudgetAccount.class, id);
    }
    
    @Override
    public List<WSBudgetAccount> findBudgetAccountEntries(int firstResult, int maxResults) {
        return entityManager.createQuery("SELECT o FROM WSBudgetAccount o", WSBudgetAccount.class).setFirstResult(firstResult).setMaxResults(maxResults).getResultList();
    }
    
    @Override
    public List<WSBudgetAccount> findBudgetAccountByAccountNumber(String accountNumber) {
    	
    	 if (accountNumber == null || accountNumber.length() == 0) throw new IllegalArgumentException("The accountNumber argument is required");
        return entityManager.createQuery("SELECT o FROM WSBudgetAccount o WHERE o.accountNumber= :accountNumber", WSBudgetAccount.class)
        		.setParameter("accountNumber", accountNumber)
        		.getResultList();
    }
    
    @Override
    public List<WSBudgetAccount> findBudgetAccountByNature(int nature) {
    	
    	 if (nature == 0 ) throw new IllegalArgumentException("The accountNumber argument is required");
        return entityManager.createQuery("SELECT o FROM WSBudgetAccount o WHERE o.nature= :nature", WSBudgetAccount.class)
        		.setParameter("nature", nature)
        		.getResultList();
    }
    
    @Transactional
    @Override
    public void persist(WSBudgetAccount budgetAccount) {
        this.entityManager.persist(budgetAccount);
    }
    
    @Transactional
    @Override
    public void remove(Long id) {

        WSBudgetAccount attached = this.findBudgetAccount(id);
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
    public WSBudgetAccount merge(WSBudgetAccount budgetAccount) {

        WSBudgetAccount merged = this.entityManager.merge(budgetAccount);
        this.entityManager.flush();
        return merged;
    }
    
    public void setEntityManager(EntityManager entityManager){
    	this.entityManager = entityManager;
    }

}
