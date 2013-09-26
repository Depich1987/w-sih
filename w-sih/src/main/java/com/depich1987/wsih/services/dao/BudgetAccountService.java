package com.depich1987.wsih.services.dao;

import java.util.List;

import com.depich1987.wsih.domain.WSBudgetAccount;

public interface BudgetAccountService {

	public long countBudgetAccounts();

	public List<WSBudgetAccount> findAllBudgetAccounts();

	public WSBudgetAccount findBudgetAccount(Long id);
	
	public List<WSBudgetAccount> findBudgetAccountByAccountNumber(String accountNumber);
	
	public List<WSBudgetAccount> findBudgetAccountByNature(int nature);

	public List<WSBudgetAccount> findBudgetAccountEntries(int firstResult,	int maxResults);

	public void persist(WSBudgetAccount budgetAccount);

	public void remove(Long id);

	public void flush();

	public void clear();

	public WSBudgetAccount merge(WSBudgetAccount budgetAccount);

}
