package com.depich1987.wsih.services.dao;

import java.util.List;

import com.depich1987.wsih.domain.WSCashAccount;

public interface CashAccountService {

	public long countCashAccounts();

	public List<WSCashAccount> findAllCashAccounts();

	public WSCashAccount findCashAccount(Long id);

	public List<WSCashAccount> findCashAccountEntries(int firstResult, int maxResults);

	public void persist(WSCashAccount cashAccount);

	public void remove(Long id);

	public void flush();

	public void clear();

	public WSCashAccount merge(WSCashAccount cashAccount);

}
